package com.freshapples.model;

public class OrderModel {
	// Film data, with the name, genre, and price being the important ones.
	Long id = 0L;
	String orderNo = "";
	String productName = "";
	String genre = "";
	float price = 0;
	
	public OrderModel(Long id, String orderNo, String productName, String genre, float price) {
		super();
		this.id = id; // Long chosen as ID in case it becomes IMDB sized.
		this.orderNo = orderNo;
		this.productName = productName;
		this.genre = genre;
		this.price = price;
	}
	@Override
	public String toString() { // Prints all the variables.
		return "OrderModel [id=" + id + ", orderNo=" + orderNo + ", productName=" + productName + ", genre=" + genre
				+ ", price=" + price + "]";
	}
	
	// Getters + setters.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
}