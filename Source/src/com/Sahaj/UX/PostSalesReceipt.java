package com.Sahaj.UX;

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

		int id;
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("Employee Id : ");
			try{
				id = Integer.parseInt(sc.next());
				if (id<=0){
					throw new NumberFormatException();
				}
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct number.");
			}
		}

		System.out.print("Date : ");
		String sDate = sc.next();
		Date date = null;
		try {
			date =  new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//@todo: Handle Date problems.

		Float amount;

		while (true){
			System.out.print("Amount : ");
			try{
				amount = Float.parseFloat(sc.next());
				if (amount<=0){
					throw new NumberFormatException();
				}
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct amount.");
			}
		}
		
		DatabaseInteractor.getInstance().addSalesReceipt(id,date,amount);

	}


}
