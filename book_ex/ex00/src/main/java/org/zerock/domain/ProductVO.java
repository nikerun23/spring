package org.zerock.domain;

public class ProductVO {

	private String name;
	private Double price;
	
	public ProductVO(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "ProductVO [name=" + this.name + ", price=" + this.price + "]";
	}
	
}
