package com.commerce.servlet;

public class CartItem {
	
	int productId;
	String productName;
	String productDescription;
	float productPrice;
	int quantity;
	
	public CartItem(int productId,String productName,String productDescription,float productPrice,int quantity){
	 this.productId=productId;
	 this.productName=productName;
	 this.productDescription=productDescription;
	 this.productPrice=productPrice;
	 this.quantity=quantity;
		
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}