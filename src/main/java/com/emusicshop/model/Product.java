package com.emusicshop.model;


import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	private int id;
	private String productName;
	private String productCategory;
	private String productDecription;
	private Double productPrice;
	private String productCondition;
	private String productStatus;
	private String unitInStock;
	private String productManufacturer;
	
	
	private MultipartFile productImage;
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDecription() {
		return productDecription;
	}
	public void setProductDecription(String productDecription) {
		this.productDecription = productDecription;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(String string) {
		this.unitInStock = string;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productDecription=" + productDecription + ", productPrice=" + productPrice + ", productCondition="
				+ productCondition + ", productStatus=" + productStatus + ", unitInStock=" + unitInStock
				+ ", productManufacturer=" + productManufacturer + ", productImage=" + productImage + "]";
	}
	
	
}
