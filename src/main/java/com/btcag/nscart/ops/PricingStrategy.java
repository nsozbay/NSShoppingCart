package com.btcag.nscart.ops;

public interface PricingStrategy {
	
	public double calculate(double totalAmount);

	default double sumAll(double...itemPrices){
		int total = 0;
		for (int i = 0; i < itemPrices.length; i++) {
			total += itemPrices[i];
		}
		return total;
	}
}
