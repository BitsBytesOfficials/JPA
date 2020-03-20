package com.niit.demo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cart_total")
	private double total;

	@ManyToMany(targetEntity = Item.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "CART_ITEMS", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private Set<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
