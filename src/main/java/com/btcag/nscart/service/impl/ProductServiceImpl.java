package com.btcag.nscart.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btcag.nscart.dao.impl.ProductDAO;
import com.btcag.nscart.model.Product;
import com.btcag.nscart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
	
	@Override
	public List<Product> getProductList() {
		return productDAO.getAll();
	}

	@Override
	public Product getProductById(ObjectId id) {
		return productDAO.getById(id);
	}

}
