package com.revision.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_Details")
public class Product 
{
	@Id
    private int pid;
    private String name;
    private int quantity;
    private int price;
    
    private Product() {}

	public Product(int pid, String name, int quantity, int price) 
	{
		this.pid = pid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

    
}
