package com.homeserver.barnesbrothers.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trans_log")
public class TransLog {

	@Id
	private int id;
	private String username;
	private String itemname;
	private String action;
	private Date updated_at;
	private Date created_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public TransLog(int id, String username, String itemname, String action,
			Date updated_at, Date created_at) {
		super();
		this.id = id;
		this.username = username;
		this.itemname = itemname;
		this.action = action;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public TransLog(int id, String username, String itemname, String action) {
		super();
		this.id = id;
		this.username = username;
		this.itemname = itemname;
		this.action = action;
	}
	
	public TransLog() {
		
	}
	
}
