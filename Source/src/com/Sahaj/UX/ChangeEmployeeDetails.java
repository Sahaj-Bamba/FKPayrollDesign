package com.Sahaj.UX;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;
import com.Sahaj.Utilities.DatabaseInteractor;

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
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Employee Id : ");
				try {
					id = Integer.parseInt(sc.next());
					break;
				} catch (NumberFormatException ex) {
					System.out.println("Please enter correct amount.");
				}
			}
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

		System.out.println("Account Number : ");
		String account;
		Scanner sc = new Scanner(System.in);
		account = sc.next();
		DatabaseInteractor.getInstance().updateAccount(id,account);

	}

	private void commission() {

		float commission;
		Scanner sc = new Scanner(System.in);

		while (true){
			System.out.print("Commission : ");
			try{
				commission = Float.parseFloat(sc.next());
				if (commission<=0){
					throw new NumberFormatException();
				}
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct amount.");
			}
		}

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

		Scanner sc = new Scanner(System.in);
		String address;
		System.out.print("Address : ");
		address = sc.nextLine();

		DatabaseInteractor.getInstance().updateAddress(id,address);

	}

	private void salary() {

		Scanner sc = new Scanner(System.in);
		Float salary;

		while (true){
			System.out.print("Salary : ");
			try{
				salary = Float.parseFloat(sc.next());
				if (salary<=0){
					throw new NumberFormatException();
				}
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct amount.");
			}
		}

		DatabaseInteractor.getInstance().updateSalary(id,salary);

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
