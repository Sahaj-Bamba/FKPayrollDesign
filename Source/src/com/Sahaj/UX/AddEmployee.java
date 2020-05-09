package com.Sahaj.UX;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;
import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddEmployee {

	private String name;
	private PaymentScheme paymentScheme;
	private float salary;
	private float commission;
	private ModeOfPayment modeOfPayment;
	private String address;

	public AddEmployee(){
		init();
		start();
	}

	private void start() {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> choices = new ArrayList<String>();

		name = Controller.getInstance().getString("Name : ");

		System.out.print("SalaryType : ");
		choices.clear();
		choices.add("Monthly Salary");
		choices.add("Hourly Salary");
		paymentScheme = PaymentScheme.values()[new ChoiceMenu(choices,"Enter your payment scheme.").start()];

		salary = Controller.getInstance().getFloat("Salary : ");
		commission = Controller.getInstance().getFloat("Commission rate in percent : ");

		choices.clear();
		choices.add("Postal");
		choices.add("Online");
		choices.add("Pickup");
		modeOfPayment = ModeOfPayment.values()[new ChoiceMenu(choices,"Enter your payment mode.").start()];
		
		address = Controller.getInstance().getString("Address : ");

		DatabaseInteractor.getInstance().addEmployee(name,paymentScheme,salary,commission,modeOfPayment,address);

	}

	private void init() {
	}

}
