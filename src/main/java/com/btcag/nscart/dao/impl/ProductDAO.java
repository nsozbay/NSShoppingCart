package com.btcag.nscart.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btcag.nscart.model.Product;


@Repository
@Transactional
public class ProductDAO extends AbstractDAO<Product> {

	@Override
	public Class<Product> getEntityClass() {
		return Product.class;
	}
	
}
