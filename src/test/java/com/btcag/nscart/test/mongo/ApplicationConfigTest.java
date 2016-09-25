package com.btcag.nscart.test.mongo;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.btcag.nscart.config.ApplicationConfig;
import com.btcag.nscart.config.MongoConfiguration;
import com.btcag.nscart.dao.impl.CartDAO;
import com.btcag.nscart.dao.impl.CartItemDAO;
import com.btcag.nscart.dao.impl.CategoryDAO;
import com.btcag.nscart.dao.impl.ProductDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={MongoConfiguration.class, ApplicationConfig.class})
public class ApplicationConfigTest {

	@Autowired CartDAO cartDAO;

	@Autowired CartItemDAO cartItemDAO;

	@Autowired CategoryDAO categoryDAO;

	@Autowired ProductDAO productDAO;

	@Test
	public void testCartDAO() {
		assertNotNull(cartDAO);
	}

	@Test
	public void testCartItemDAO() {
		assertNotNull(cartItemDAO);
	}

	@Test
	public void testCategoryDAO() {
		assertNotNull(categoryDAO);
	}

	@Test
	public void testProductDAO() {
		assertNotNull(productDAO);
	}
}
