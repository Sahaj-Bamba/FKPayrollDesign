package com.Sahaj.Main;

import com.Sahaj.Utilities.Controller;

import java.util.Date;

public class Monthly implements TypeOfPayment {
	@Override
	public float credit(Date lastPayed, Date endDate, float salary, int id) {

		float value = salary;

		if (lastPayed.getMonth() != endDate.getMonth() && endDate.getDate()== Controller.getInstance().getMonthlyBillDate()){
			value += salary;
		}

		return value;
	}
}
