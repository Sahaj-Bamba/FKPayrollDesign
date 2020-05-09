package com.Sahaj.UX;

import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PostSalesReceipt {

	public PostSalesReceipt() {
		init();
		start();
	}

	private void init() {
	}

	private void start() {

		int id = Controller.getInstance().getInt("Employee Id : ");
		Date date = Controller.getInstance().getDate("Date");
		Float amount = Controller.getInstance().getFloat("Number Of Hours : ");

		DatabaseInteractor.getInstance().addSalesReceipt(id,date,amount);

	}


}
