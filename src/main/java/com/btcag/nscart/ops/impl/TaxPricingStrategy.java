package com.btcag.nscart.ops.impl;

import com.btcag.nscart.ops.PricingStrategy;

public class TaxPricingStrategy implements PricingStrategy{

	public TaxPricingStrategy() {

	}

	@Override
	public double calculate(double totalAmount) {
		return totalAmount * 0.18;
	}

}
