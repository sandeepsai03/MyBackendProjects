package com.excelr.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@Column(name="p_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identity increments the primary key values automatically 
	private Integer pid;
	
	@Column(name="p_name")
	private String pname;
	
	@Column(name="p_price")
	private Integer price;
	
	@CreationTimestamp
	@Column(name="create_date",updatable=false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name="update_date",insertable=false)
	private LocalDate updateDate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer pid, String pname, Integer price, LocalDate createDate, LocalDate updateDate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", getPid()=" + getPid() + ", getPname()=" + getPname()
				+ ", getPrice()=" + getPrice() + ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()="
				+ getUpdateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
