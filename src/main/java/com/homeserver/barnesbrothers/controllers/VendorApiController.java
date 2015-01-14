package com.homeserver.barnesbrothers.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeserver.barnesbrothers.db.HibernateUtil;
import com.homeserver.barnesbrothers.models.Vendor;

@Controller
public class VendorApiController {

	/**
	 * Simply returns the item list or log list
	 */
	@RequestMapping(value = "/api/vendors", method = RequestMethod.GET)
	public @ResponseBody List<Vendor> fetchItems() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Vendor as vendor");
		
		@SuppressWarnings("unchecked")
		List<Vendor> theList = query.list();
		
		session.close();
		
		return theList;
	}
	
}
