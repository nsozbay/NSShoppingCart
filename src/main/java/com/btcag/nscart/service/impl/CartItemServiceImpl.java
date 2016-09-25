package com.btcag.nscart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btcag.nscart.dao.impl.CartItemDAO;
import com.btcag.nscart.model.CartItem;
import com.btcag.nscart.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDAO cartItemDAO;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDAO.save(cartItem);		
	}

}
