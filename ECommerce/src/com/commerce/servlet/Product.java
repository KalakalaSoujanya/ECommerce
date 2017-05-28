package com.commerce.servlet;

public class Product {
	int productId;
	 String productName;
	 int productStock;
	 float productPrice;
	 String productDescription;
	 String productType;
	 public Product(int productId, String productName, int productStock, float productPrice, String productDescription, String productType){
		 super();
		this.productId=productId;
		this.productName=productName;
		this.productStock= productStock;
		this.productPrice=productPrice;
		this.productDescription=productDescription;
		this.productType=productType;
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
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	 public String toString(){
		 return "Product[productId="+productId+",productName="+productName+",productStock="+productStock+","
		 		+ "productPrice="+productPrice+",productDescription="+productDescription+",productType="+productType+"]";
	 }
	 
	

}


