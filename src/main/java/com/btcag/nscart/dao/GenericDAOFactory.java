package com.btcag.nscart.dao;


public interface GenericDAOFactory {
	public <T> GenericDAO<T> createDAO(Class<T> type);
}
