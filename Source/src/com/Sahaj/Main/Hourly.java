package com.Sahaj.Main;

import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.Date;

public class Hourly implements TypeOfPayment {
	@Override
	public float credit(Date lastPayed, Date endDate, float salary, int id) {
		float value = 0f;
		if (endDate.getDay() == Controller.getInstance().getHourlyBillDate() && lastPayed.getDate()!=endDate.getDate()){
			value += DatabaseInteractor.getInstance().getHours(lastPayed,endDate,id) + DatabaseInteractor.getInstance().getExtraHours(lastPayed,endDate,salary,id)*1.5;
			value *= salary;
		}
		return value;
	}
}
