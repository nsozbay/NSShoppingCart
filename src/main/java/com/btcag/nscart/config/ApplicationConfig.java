package com.btcag.nscart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btcag.nscart.dao.impl.CartDAO;
import com.btcag.nscart.dao.impl.CartItemDAO;
import com.btcag.nscart.dao.impl.CategoryDAO;
import com.btcag.nscart.dao.impl.DAOFactory;
import com.btcag.nscart.dao.impl.ProductDAO;
import com.btcag.nscart.model.Cart;
import com.btcag.nscart.model.CartItem;
import com.btcag.nscart.model.Category;
import com.btcag.nscart.model.Product;

@Configuration
public class ApplicationConfig {

	@Bean(name = "cartDAO")
    public CartDAO getCartDAO() {
        return (CartDAO) DAOFactory.getInstance().createDAO(Cart.class);
    }
 
    @Bean(name = "cartItemDAO")
    public CartItemDAO getCartItemDAO() {
        return (CartItemDAO) DAOFactory.getInstance().createDAO(CartItem.class);
    }
 
    @Bean(name = "categoryDAO")
    public CategoryDAO getCategoryDAO() {
    	return (CategoryDAO) DAOFactory.getInstance().createDAO(Category.class);
    }
     
    @Bean(name = "productDAO")
    public ProductDAO getProductDAO()  {
    	return (ProductDAO) DAOFactory.getInstance().createDAO(Product.class);
    }
}
