package com.homeserver.barnesbrothers.controllers;

import java.util.Date;
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
import com.homeserver.barnesbrothers.models.Item;

@Controller
public class InventoryApiController {
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/items", method = RequestMethod.GET)
	public @ResponseBody List<Map> fetchItems() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select new map(item.id as id, item.name as name, item.description as description, item.quantity as quantity, item.email_threshold as email_threshold, item.on_order_quantity as on_order_quantity, item.item_url as item_url, vendor.name as vendor_name, item.vendor_id as vendor_id) from Item as item, Vendor as vendor where item.active = 1 and vendor.id = item.vendor_id");
		
		@SuppressWarnings("unchecked")
		List<Map> theList = query.list();
		
		session.close();
		
		return theList;
	}
	
	@RequestMapping(value="/api/items", method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody final ModelMap model) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Item newItem = new Item();
		
		newItem.setName((String)model.get("name"));
		newItem.setDescription((String)model.get("description"));
		newItem.setEmail_threshold((Integer)model.get("email_threshold"));
		newItem.setItem_url((String)model.get("item_url"));
		newItem.setOn_order_quantity((Integer)model.get("on_order_quantity"));
		newItem.setQuantity((Integer)model.get("quantity"));
		newItem.setVendor_id((Integer)model.get("vendor_id"));
		newItem.setActive(true);
		newItem.setUpdated_at(new Date());
		newItem.setCreated_at(new Date());
		
		session.beginTransaction();
		try {		
			session.save(newItem);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return newItem;
	}
	
	@RequestMapping(value="/api/items/{id}", method = RequestMethod.PUT)
	public @ResponseBody Item updateItem(@PathVariable String id, @RequestBody final ModelMap model) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		int itemId = Integer.parseInt(id);

		Item existingItem = (Item)session.get(Item.class, itemId);
		
		existingItem.setName((String)model.get("name"));
		existingItem.setDescription((String)model.get("description"));
		existingItem.setEmail_threshold((Integer)model.get("email_threshold"));
		existingItem.setItem_url((String)model.get("item_url"));
		existingItem.setOn_order_quantity((Integer)model.get("on_order_quantity"));
		existingItem.setVendor_id((Integer)model.get("vendor_id"));
		existingItem.setUpdated_at(new Date());
		
		existingItem.setQuantity(existingItem.getQuantity() + (Integer)model.get("adjustmentQty"));
		if (existingItem.getQuantity() < 0) {
			existingItem.setQuantity(0);
		}
		
		session.beginTransaction();
		try {		
			session.update(existingItem);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return existingItem;
		
	}
	
	@RequestMapping(value="/api/items/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Item deleteItem(@PathVariable String id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		int itemId = Integer.parseInt(id);

		Item existingItem = (Item)session.get(Item.class, itemId);
		
		session.beginTransaction();
		try {		
			session.delete(existingItem);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return existingItem;
	}
	
}