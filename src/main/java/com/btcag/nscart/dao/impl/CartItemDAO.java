package com.btcag.nscart.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btcag.nscart.model.CartItem;


@Repository
@Transactional
public class CartItemDAO extends AbstractDAO<CartItem> {

	@Override
	public Class<CartItem> getEntityClass() {
		return CartItem.class;
	}

}
