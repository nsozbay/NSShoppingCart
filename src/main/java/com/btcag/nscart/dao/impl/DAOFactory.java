package com.btcag.nscart.dao.impl;

import com.btcag.nscart.dao.GenericDAOFactory;
import com.btcag.nscart.model.Cart;
import com.btcag.nscart.model.CartItem;
import com.btcag.nscart.model.Product;

public class DAOFactory implements GenericDAOFactory {

	private static DAOFactory instance;

	private DAOFactory() {
	}

	public static synchronized DAOFactory getInstance() { 
		if( instance == null ) 
		{ 
			instance = new DAOFactory(); 
		}
		return instance;
	}


	//public static DAOFactory 

	@SuppressWarnings("unchecked")
	@Override
	public <T> AbstractDAO<T> createDAO(Class<T> type) {
		if(type == Cart.class)
			return (AbstractDAO<T>) new CartDAO();
		else if(type == CartItem.class)
			return (AbstractDAO<T>) new CartItemDAO();
		else if(type == Product.class)
			return (AbstractDAO<T>) new ProductDAO();
		else 
			return (AbstractDAO<T>) new CategoryDAO();
	}

}
