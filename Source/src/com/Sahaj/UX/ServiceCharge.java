package com.Sahaj.UX;

import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServiceCharge {

	public ServiceCharge() {
		init();
		start();
	}

	private void init() {
	}

	private void start() {

		int id = Controller.getInstance().getInt("Employee Id : ");
		Date date = Controller.getInstance().getDate("Date");
		Float amount = Controller.getInstance().getFloat("Charge : ");
		String reason = Controller.getInstance().getString("Reason : ");

		DatabaseInteractor.getInstance().addCharge(id,date,amount,reason);

	}

}
