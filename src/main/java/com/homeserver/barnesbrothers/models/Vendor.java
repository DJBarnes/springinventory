package com.homeserver.barnesbrothers.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id
	private int id;
	private String name;
	private String url;
	private Date updated_at;
	private Date created_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	
	public Vendor(int id, String name, String url, Date updated_at,
			Date created_at) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public Vendor(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public Vendor() {
		
	}
	
}
