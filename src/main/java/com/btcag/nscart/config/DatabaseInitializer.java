package com.btcag.nscart.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.btcag.nscart.model.Cart;
import com.btcag.nscart.model.CartItem;
import com.btcag.nscart.model.Category;
import com.btcag.nscart.model.Product;

public class DatabaseInitializer {

	public static void main(String[] args) {
		ApplicationContext ctx =
	             new AnnotationConfigApplicationContext(MongoConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("MongoTemplate");

		List<Product> fruits = new ArrayList<Product>();
				
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c0"),"Muz", 10.0, "Anamur", "Orta", "Sar�"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c1"),"Kiraz", 11.0, "Sivas", "�ri", "K�rm�z�"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c2"),"Hindistan Cevizi", 12.0, "Sulu", "Orta", "Kahverengi"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c3"),"Hurma", 13.0, "Ball�", "B�y�k", "Kahverengi"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c4"),"�z�m", 14.0, "�eker", "Misket", "Ye�il"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c5"),"Kivi", 15.0, "Yumu�ak", "Orta", "Ye�il"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c6"),"Limon", 16.0, "Yatak Sulu", "�ri", "Sar�"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c7"),"Mango", 17.0, "Tropik", "K���k", "Kar���k"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c8"),"Portakal", 18.0, "�nce Kabuk", "Orta", "Turuncu"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c9"),"�eftali", 19.0, "�ok Sulu Bursa", "�ri", "Turuncu"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97d0"),"Armut", 20.0, "Yumu�ak", "Orta", "Sar�"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97d1"),"Ananas", 21.0, "Dilimli", "B�y�k", "Sar�"));
		
		List<Product> vegetables = new ArrayList<Product>();
	
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e0"),"Brokoli", 10.0, "A�a�", "Orta", "Ye�il"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e1"),"Lahana", 11.0, "Sarmal�k", "B�y�k", "Beyaz"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e2"),"Havu�", 12.0, "K�t�r", "�nce", "Turuncu"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e3"),"M�s�r", 13.0, "Taneli", "Orta", "Sar�"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e4"),"Patl�can", 14.0, "�ekirdeksiz", "Orta", "Mor"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e5"),"Zeytin", 15.0, "Gemlik", "�ri", "Ye�il"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e6"),"So�an", 16.0, "Polatl�", "Orta", "Beyaz"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e7"),"Biber", 17.0, "Bursa Etli", "Orta", "K�rm�z�"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e8"),"Patates", 18.0, "K�zartmal�k", "�ri", "Sar�"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e9"),"Kabak", 19.0, "�ekerli", "B�y�k", "Turuncu"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97f0"),"Paz�", 20.0, "Taze", "Yaprakl�", "Ye�il"));
		
		Category fruitCategory = new Category("Meyve");
		fruitCategory.getProducts().addAll(fruits);
		
		Category vegetableCategory = new Category("Sebze");
		vegetableCategory.getProducts().addAll(vegetables);
		
		Category foodCategory = new Category("G�da");
		foodCategory.getProducts().addAll(fruits);
		foodCategory.getProducts().addAll(vegetables);

		Product product = null;
		for (Iterator<Product> iterator = fruits.iterator(); iterator.hasNext();) {
			product = iterator.next();
			mongoOperation.save(product);
		}
		
		for (Iterator<Product> iterator = vegetables.iterator(); iterator.hasNext();) {
			product = iterator.next();
			mongoOperation.save(product);
		}
		
		mongoOperation.save(fruitCategory);
		
		mongoOperation.save(vegetableCategory);
		
		mongoOperation.save(foodCategory);
		
		CartItem cartItem = new CartItem(fruits.get(0), 2, 20.0);
		Cart cart = new Cart(Arrays.asList(cartItem), 20.0);
		
		mongoOperation.save(cartItem);
		mongoOperation.save(cart);
	}

}
