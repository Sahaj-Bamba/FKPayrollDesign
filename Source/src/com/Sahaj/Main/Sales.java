package com.Sahaj.Main;

public class Sales {

	private float amount;

	public Sales(float amount) {
		this.amount = amount;
	}

	public float getCommission(float rate) {
		return amount*(rate/100f);
	}

}
