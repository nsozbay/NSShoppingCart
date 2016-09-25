package com.btcag.nscart.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Document(collection="product")
public class Product {
	
	@Id
	private ObjectId id;
	
    private String name;
    
    private double price;
    
    private String detail;
    
    private String size;
    
    private String colour;
    
    //private CommonsMultipartFile imageData;
    
    
    @PersistenceConstructor
	public Product(ObjectId id, String name, double price, String detail, String size, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.size = size;
		this.colour = colour;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

//	public CommonsMultipartFile getImageData() {
//		return imageData;
//	}
//
//	public void setImageData(CommonsMultipartFile imageData) {
//		this.imageData = imageData;
//	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", size=" + size
				+ ", colour=" + colour + "]";
	}
	
    
}
