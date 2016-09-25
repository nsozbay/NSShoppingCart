package com.btcag.nscart.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.btcag.nscart.model.Product;


public interface ProductService {
	
	List<Product> getProductList();

    Product getProductById (ObjectId id);

}
