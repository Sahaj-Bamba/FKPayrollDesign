package com.Sahaj.UX;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;
import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.Date;
import java.util.Scanner;

public class ChangeEmployeeDetails extends Menu{

	int id;

	public ChangeEmployeeDetails(){
		super();
		start();
	}

	@Override
	protected void init() {

		mainHeading="Enter Your Choice";
		choices.add("Salary type");
		choices.add("Salary");
		choices.add("Commission");
		choices.add("Mode of Payment");
		choices.add("Address");
		choices.add("Account");
		choices.add("Go Back");

	}

	@Override
	protected void makeMove(int choice) {

		if (choice!=6) {
			id = Controller.getInstance().getInt("Employee Id : ");
		}

		switch (choice){
			case 1: salaryType();
				break;
			case 2: salary();
				break;
			case 3: commission();
				break;
			case 4: modeOfPayment();
				break;
			case 5: address();
				break;
			case 6: account();
				break;
			case 7: goBack();
				break;
		}
	}

	private void account() {

		String account = Controller.getInstance().getString("Account Number : ");
		DatabaseInteractor.getInstance().updateAccount(id,account);

	}

	private void commission() {

		Float commission = Controller.getInstance().getFloat("Commission amount in percent : ");

		DatabaseInteractor.getInstance().updateCommission(id,commission);

	}

	private void modeOfPayment() {

		ModeOfPayment modeOfPayment;

		choices.clear();
		choices.add("Postal");
		choices.add("Online");
		choices.add("Pickup");
		modeOfPayment = ModeOfPayment.values()[new ChoiceMenu(choices,"Enter your payment mode.").start()];

		DatabaseInteractor.getInstance().updateModeOfPayment(id,modeOfPayment);

	}

	private void address() {

		String address = Controller.getInstance().getString("Address : ");
		DatabaseInteractor.getInstance().updateAddress(id,address);

	}

	private void salary() {

		Float amount = Controller.getInstance().getFloat("Salary : ");

		DatabaseInteractor.getInstance().updateSalary(id,amount);

	}

	private void salaryType() {

		PaymentScheme paymentScheme;
		System.out.print("SalaryType : ");
		choices.clear();
		choices.add("Monthly Salary");
		choices.add("Hourly Salary");
		paymentScheme = PaymentScheme.values()[new ChoiceMenu(choices,"Enter your payment scheme.").start()];

		DatabaseInteractor.getInstance().updatePaymentScheme(id,paymentScheme);

	}

}
