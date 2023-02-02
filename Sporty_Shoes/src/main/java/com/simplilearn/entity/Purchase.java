package com.simplilearn.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_2023")
public class Purchase {
	
	@Id
	@Column(name = "purchase_id")
	@GeneratedValue
	private long purchase_id ;
	
	@Column(name="purchase_name")
	private String name ;
	
	@Column(name="mobile_no")
	private String mobile ;
	
	@Column(name="date_purchased")
	private String date ;

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(long purchase_id) {
		this.purchase_id = purchase_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 
	
	
	
}
