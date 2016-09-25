package com.btcag.nscart.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btcag.nscart.dao.impl.CategoryDAO;
import com.btcag.nscart.model.Category;
import com.btcag.nscart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Override
	public List<Category> getCategoryList() {
		return categoryDAO.getAll();
	}
	
	@Override
	public Category getCategoryById(ObjectId id) {
		return categoryDAO.getById(id);
	}

}
