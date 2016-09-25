package com.btcag.nscart.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btcag.nscart.model.Category;


@Repository
@Transactional
public class CategoryDAO extends AbstractDAO<Category> {

	@Override
	public Class<Category> getEntityClass() {
		return Category.class;
	}

}
