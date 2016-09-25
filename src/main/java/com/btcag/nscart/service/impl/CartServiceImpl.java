package com.btcag.nscart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btcag.nscart.dao.impl.CartDAO;
import com.btcag.nscart.model.Cart;
import com.btcag.nscart.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDAO cartDAO;
	
	@Override
	public Cart getCart() {
		return cartDAO.getAll().get(0);
	}

	@Override
	public void update(Cart cart) {
		cartDAO.save(cart);
	}

}
