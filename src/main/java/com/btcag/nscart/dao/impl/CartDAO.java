package com.btcag.nscart.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btcag.nscart.model.Cart;


@Repository
@Transactional
public class CartDAO extends AbstractDAO<Cart> {

	@Override
	public Class<Cart> getEntityClass() {
		return Cart.class;
	}
	
}
