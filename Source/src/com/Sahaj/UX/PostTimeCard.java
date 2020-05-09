package com.Sahaj.UX;

import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PostTimeCard {

	public PostTimeCard() {
		init();
		start();
	}

	private void init() {
	}

	private void start() {

		int id = Controller.getInstance().getInt("Employee Id : ");
		Date date = Controller.getInstance().getDate("Date");
		Float amount = Controller.getInstance().getFloat("Number Of Hours : ");

		DatabaseInteractor.getInstance().addTimeCard(id,date,amount);

	}

}
