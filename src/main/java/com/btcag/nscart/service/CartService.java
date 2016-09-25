package com.btcag.nscart.service;

import com.btcag.nscart.model.Cart;

public interface CartService {
	
	Cart getCart();
	
	void update(Cart cart);
}
