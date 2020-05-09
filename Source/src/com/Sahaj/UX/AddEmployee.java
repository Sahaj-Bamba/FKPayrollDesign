package com.Sahaj.UX;

import com.Sahaj.Constant.PaymentScheme;

import java.util.ArrayList;
import java.util.Scanner;

public class AddEmployee {

	private String name;
	private PaymentScheme paymentScheme;
	public AddEmployee(){
		init();
		start();
	}

	private void start() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Name : ");
		name = sc.next();
		System.out.print("SalaryType : ");
		paymentScheme = PaymentScheme.values()[new ChoiceMenu(new ArrayList<String>(),"Enter your payment scheme.").start()];
		System.out.print("Name : ");
		name = sc.next();
		System.out.print("Name : ");
		name = sc.next();


	}

	private void init() {
	}

}
