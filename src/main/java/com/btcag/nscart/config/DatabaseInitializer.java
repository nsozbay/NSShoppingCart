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
				
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c0"),"Muz", 10.0, "Anamur", "Orta", "Sarý"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c1"),"Kiraz", 11.0, "Sivas", "Ýri", "Kýrmýzý"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c2"),"Hindistan Cevizi", 12.0, "Sulu", "Orta", "Kahverengi"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c3"),"Hurma", 13.0, "Ballý", "Büyük", "Kahverengi"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c4"),"Üzüm", 14.0, "Þeker", "Misket", "Yeþil"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c5"),"Kivi", 15.0, "Yumuþak", "Orta", "Yeþil"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c6"),"Limon", 16.0, "Yatak Sulu", "Ýri", "Sarý"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c7"),"Mango", 17.0, "Tropik", "Küçük", "Karýþýk"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c8"),"Portakal", 18.0, "Ýnce Kabuk", "Orta", "Turuncu"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97c9"),"Þeftali", 19.0, "Çok Sulu Bursa", "Ýri", "Turuncu"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97d0"),"Armut", 20.0, "Yumuþak", "Orta", "Sarý"));
		fruits.add(new Product(new ObjectId("57e546d4338db7a11fdf97d1"),"Ananas", 21.0, "Dilimli", "Büyük", "Sarý"));
		
		List<Product> vegetables = new ArrayList<Product>();
	
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e0"),"Brokoli", 10.0, "Aðaç", "Orta", "Yeþil"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e1"),"Lahana", 11.0, "Sarmalýk", "Büyük", "Beyaz"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e2"),"Havuç", 12.0, "Kýtýr", "Ýnce", "Turuncu"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e3"),"Mýsýr", 13.0, "Taneli", "Orta", "Sarý"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e4"),"Patlýcan", 14.0, "Çekirdeksiz", "Orta", "Mor"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e5"),"Zeytin", 15.0, "Gemlik", "Ýri", "Yeþil"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e6"),"Soðan", 16.0, "Polatlý", "Orta", "Beyaz"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e7"),"Biber", 17.0, "Bursa Etli", "Orta", "Kýrmýzý"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e8"),"Patates", 18.0, "Kýzartmalýk", "Ýri", "Sarý"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97e9"),"Kabak", 19.0, "Þekerli", "Büyük", "Turuncu"));
		vegetables.add(new Product(new ObjectId("57e546d4338db7a11fdf97f0"),"Pazý", 20.0, "Taze", "Yapraklý", "Yeþil"));
		
		Category fruitCategory = new Category("Meyve");
		fruitCategory.getProducts().addAll(fruits);
		
		Category vegetableCategory = new Category("Sebze");
		vegetableCategory.getProducts().addAll(vegetables);
		
		Category foodCategory = new Category("Gýda");
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
