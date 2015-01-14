package com.homeserver.barnesbrothers.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int quantity;
	
	private int vendor_id;
	private int email_threshold;
	private String item_url;
	private int on_order_quantity;
	private boolean active;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	
	public int getEmail_threshold() {
		return email_threshold;
	}

	public void setEmail_threshold(int email_threshold) {
		this.email_threshold = email_threshold;
	}

	public String getItem_url() {
		return item_url;
	}

	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}

	public int getOn_order_quantity() {
		return on_order_quantity;
	}

	public void setOn_order_quantity(int on_order_quantity) {
		this.on_order_quantity = on_order_quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	
	public Item() {
		
	}
	
	public Item(int id, String name, int quantity, int vendor_id,
			int email_threshold, int on_order_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.vendor_id = vendor_id;
		this.email_threshold = email_threshold;
		this.on_order_quantity = on_order_quantity;
	}

	public Item(int id, String name, String description, int quantity, int vendor_id,//Vendor vendor,
			int email_threshold, String item_url, int on_order_quantity,
			boolean active, Date updated_at, Date created_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.vendor_id = vendor_id;
		this.email_threshold = email_threshold;
		this.item_url = item_url;
		this.on_order_quantity = on_order_quantity;
		this.active = active;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
}
