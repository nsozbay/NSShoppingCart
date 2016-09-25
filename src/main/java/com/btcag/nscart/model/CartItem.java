package com.btcag.nscart.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartItem")
public class CartItem{

	@Id
    private ObjectId id;

	@DBRef(db="product")
    private Product product;

    private int quantity;
    private double totalPrice;
    
    @PersistenceConstructor
    public CartItem(Product product, int quantity, double totalPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ "]";
	}
    
    
    
} // The End of Class;
