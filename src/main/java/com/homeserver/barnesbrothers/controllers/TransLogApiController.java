package com.homeserver.barnesbrothers.controllers;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homeserver.barnesbrothers.db.HibernateUtil;
import com.homeserver.barnesbrothers.models.TransLog;

@Controller
public class TransLogApiController {

	@RequestMapping(value = "/api/log", method = RequestMethod.GET)
	public @ResponseBody List<TransLog> fetchLogs() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from TransLog as translog");
		
		@SuppressWarnings("unchecked")
		List<TransLog> theList = query.list();
		
		session.close();
		
		return theList;
	}
	
	@RequestMapping(value = "/api/log", method = RequestMethod.POST)
	public @ResponseBody TransLog logTransaction(@RequestBody final ModelMap model) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		TransLog newLog = new TransLog();
		
		newLog.setAction((String)model.get("action"));
		newLog.setItemname((String)model.get("itemname"));
		newLog.setUsername("caeUser");
		newLog.setUpdated_at(new Date());
		newLog.setCreated_at(new Date());
		
		session.beginTransaction();
		try {		
			session.save(newLog);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return newLog;
	}
	
}
