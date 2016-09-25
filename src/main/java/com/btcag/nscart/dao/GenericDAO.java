package com.btcag.nscart.dao;

import java.util.List;
import org.bson.types.ObjectId;

public interface GenericDAO<T> {

	public void save(T entity);

	public void remove(T entity);

	public List<T> getAll();

	public T getById(ObjectId id);
	
	public Class<T> getEntityClass();

}
