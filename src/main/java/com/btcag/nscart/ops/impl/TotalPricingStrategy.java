package com.btcag.nscart.ops.impl;

import com.btcag.nscart.ops.PricingStrategy;

public class TotalPricingStrategy implements PricingStrategy {

		
	public TotalPricingStrategy() {
		
	}

	@Override
	public double calculate(double totalAmount) {
		return totalAmount;
	}

}
