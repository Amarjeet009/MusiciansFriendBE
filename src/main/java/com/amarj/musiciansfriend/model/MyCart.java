package com.amarj.musiciansfriend.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author amarj
 *
 */

@Entity
@Component
@Table(name="my_cart")
public class MyCart implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="User_id")
	private String userID; 
	
	@Column(name="product_name")
	private String productName;
	
    private int price;
    
    private char status;
    
    private DecimalFormat quantity;
    
    @Column(name="Date_Added")
    private Date dateAdded;

    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public DecimalFormat getQuantity() {
		return quantity;
	}

	public void setQuantity(DecimalFormat quantity) {
		this.quantity = quantity;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
	
    
    
    
    
}
