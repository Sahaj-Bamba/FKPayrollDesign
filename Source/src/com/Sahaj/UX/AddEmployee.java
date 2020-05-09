package com.Sahaj.UX;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
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
		System.out.print("Name : ");
		name = sc.next();
		System.out.print("SalaryType : ");
		choices.clear();
		choices.add("Monthly Salary");
		choices.add("Hourly Salary");
		paymentScheme = PaymentScheme.values()[new ChoiceMenu(choices,"Enter your payment scheme.").start()];
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
		choices.clear();
		choices.add("Postal");
		choices.add("Online");
		choices.add("Pickup");
		modeOfPayment = ModeOfPayment.values()[new ChoiceMenu(choices,"Enter your payment mode.").start()];
		
		System.out.print("Address : ");
		address = sc.nextLine();

		DatabaseInteractor.getInstance().addEmployee(name,paymentScheme,salary,commission,modeOfPayment,address);

	}

	private void init() {
	}

}
