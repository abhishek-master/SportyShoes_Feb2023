package com.simplilearn.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoe_table_2023")
public class Shoes {
	
	@Id
	@GeneratedValue
	@Column(name="shoe_id")
	private long shoe_id ;
	
	@Column(name="shoe_name")
	private String name ;
	
	@Column(name="shoe_category")
	private int Category ;

	public long getShoe_id() {
		return shoe_id;
	}

	public void setShoe_id(long shoe_id) {
		this.shoe_id = shoe_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return Category;
	}

	public void setCategory(int category) {
		Category = category;
	}
	
	
	

}
