package com.btcag.nscart.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.btcag.nscart.dao.GenericDAO;

public abstract class AbstractDAO<T> implements GenericDAO<T> {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void save(T entity) {
		mongoTemplate.save(entity);
	}

	@Override
	public void remove(T entity) {
		mongoTemplate.remove(entity);
	}
	
	@Override
	public List<T> getAll() {
		return mongoTemplate.findAll(getEntityClass());
	}

	@Override
	public T getById(ObjectId id) {
		return mongoTemplate.findById(id, getEntityClass());
	}
}
