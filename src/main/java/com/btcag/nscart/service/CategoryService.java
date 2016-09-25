package com.btcag.nscart.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.btcag.nscart.model.Category;

public interface CategoryService {
	
	List<Category> getCategoryList();
	
	Category getCategoryById(ObjectId id) ;
}
