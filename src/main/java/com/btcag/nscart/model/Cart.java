package com.btcag.nscart.model;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cart")
public class Cart{
    
	@Id
    private ObjectId id;

	@DBRef(db="cartItem")
    private List<CartItem> cartItems;

    private double grandTotal;

    @PersistenceConstructor
    public Cart(List<CartItem> cartItems, double grandTotal) {
		super();
		this.cartItems = cartItems;
		this.grandTotal = grandTotal;
	}

	public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
	}
    
    

} // The End of Class;
