package com.fitnessarea.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cid;
	private String cname;
	private String cproduct;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCproduct() {
		return cproduct;
	}
	public void setCproduct(String cproduct) {
		this.cproduct = cproduct;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", cproduct=" + cproduct + "]";
	}
	
	
	
}
