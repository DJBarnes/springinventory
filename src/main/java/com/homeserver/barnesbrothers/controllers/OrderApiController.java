package com.homeserver.barnesbrothers.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeserver.barnesbrothers.db.HibernateUtil;
import com.homeserver.barnesbrothers.models.Order_Item;
import com.homeserver.barnesbrothers.models.Orders;

@Controller
public class OrderApiController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "/api/orders", method = RequestMethod.GET)
	public List<Map> getOrders() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select distinct new map(orders.id as id, orders.created_at as created_at, orders.status as status, item.vendor_id as vendor_id, vendor.name as vendor_name, COUNT(orders.id) as item_count) from Orders as orders, Order_Item as order_item, Item as item, Vendor as vendor where orders.id = order_item.order_id AND order_item.item_id = item.id AND vendor.id = item.vendor_id GROUP BY orders.id, orders.created_at, status, vendor.name ORDER BY orders.id DESC");

		List<Map> theList = query.list();
		
		session.close();
		
		for (Map order:theList) {
			
			session = sessionFactory.openSession();
			
			query = session.createQuery("select new map(order_item.item_id as item_id, item.name as name, order_item.order_qty as order_qty) from Order_Item as order_item, Item as item WHERE item_id = item.id AND order_id = :orderId").setParameter("orderId", (Integer)order.get("id"));
			
			List<Map> itemList = query.list();
			
			session.close();
			
			order.put(new String("items"), itemList);
		}

		return theList;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "/api/orders", method = RequestMethod.POST)
	public Map<String, Object> createOrder(@RequestBody final ModelMap model) {
		
		Orders order = new Orders();
		Order_Item order_item;
		ArrayList<Map> items;
		int numberOfItems = 0;
		Map<String, Object> returnOrder = new HashMap<String, Object>();
		Query vendorQuery;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		order.setStatus(true);
		order.setCreated_at(new Date());
		order.setUpdated_at(new Date());
		
		session.beginTransaction();
		try {		
			session.save(order);
			
			int newOrderId = order.getId();
			items = (ArrayList<Map>)model.get("items");

			for(Map orderItem:items) {
				order_item = new Order_Item();
				order_item.setOrder_id(newOrderId);
				order_item.setItem_id(Integer.parseInt((String)orderItem.get("item_id")));
				order_item.setOrder_qty((Integer)orderItem.get("order_qty"));
				order_item.setCreated_at(new Date());
				order_item.setUpdated_at(new Date());
				
				session.save(order_item);
				
				numberOfItems += 1;
			}
			
			vendorQuery = session.createSQLQuery("SELECT name from vendor where id = :vendorId").setParameter("vendorId", String.valueOf(model.get("vendor_id")));
			
			String vendorName = vendorQuery.list().get(0).toString();
			
			returnOrder.put("id", order.getId());
			returnOrder.put("status", (Boolean)order.getStatus());
			returnOrder.put("created_at", order.getCreated_at());
			returnOrder.put("updated_at", order.getCreated_at());
			returnOrder.put("open", "yes");
			returnOrder.put("vendor_id", (Integer)model.get("vendor_id"));
			returnOrder.put("vendor_name", vendorName);
			returnOrder.put("item_count", (Integer)numberOfItems);
			returnOrder.put("items", model.get("items"));
			
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return returnOrder;
	}
	
	@RequestMapping(value="/api/orders/{id}", method = RequestMethod.PUT)
	public @ResponseBody Orders updateOrders(@PathVariable String id, @RequestBody final ModelMap model) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		int orderId = Integer.parseInt(id);

		Orders existingOrder = (Orders)session.get(Orders.class, orderId);
		
		existingOrder.setStatus((Boolean)model.get("status"));
		
		session.beginTransaction();
		try {		
			session.update(existingOrder);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return existingOrder;
		
	}
}
