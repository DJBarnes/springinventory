package com.homeserver.barnesbrothers.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class Order_Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int order_id;
	private int item_id;
	private int order_qty;
	private Date updated_at;
	private Date created_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
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
	public Order_Item(int id, int order_id, int item_id, int order_qty,
			Date updated_at, Date created_at) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.order_qty = order_qty;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public Order_Item() {
		
	}
}
