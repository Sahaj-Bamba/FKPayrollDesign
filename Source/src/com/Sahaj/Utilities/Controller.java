package com.Sahaj.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Different Global Control variables
 *
 */

public class Controller {

	/**
	 * The main instance of the class
	 */
	private static Controller controller = null;

	private int MonthlyBillDate;
	private int HourlyBillDate;
	private int MembershipFeeDate;

	private Controller() {
		init();
	}

	private void init() {
		MonthlyBillDate = 1;
		HourlyBillDate = 5;
		MembershipFeeDate = 5;
	}

	/**
	 * Creates the instance and return
	 *
	 * @return the instance of the object
	 */
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	public float getFloat(String heading){
		Scanner sc = new Scanner(System.in);
		float value=0f;
		while (true){
			System.out.print(heading);
			try{
				value = Float.parseFloat(sc.next());
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct amount.");
			}
		}
		return value;
	}

	public int getInt(String heading){
		Scanner sc = new Scanner(System.in);
		int value=0;
		while (true){
			System.out.print(heading);
			try{
				value = Integer.parseInt(sc.next());
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct amount.");
			}
		}
		return value;
	}

	public String getString(String heading){

		Scanner sc = new Scanner(System.in);
		String value;
		System.out.print(heading);
		value = sc.nextLine();
		return value;

	}

	public Date getDate(String heading){
		Scanner sc = new Scanner(System.in);
		System.out.print(heading + " Format (dd/MM/yyyy) : ");
		String sDate = sc.next();
		Date date = null;
		try {
			date =  new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public int getMonthlyBillDate() {
		return MonthlyBillDate;
	}

	public int getHourlyBillDate() {
		return HourlyBillDate;
	}

	public int getMembershipFeeDate() {
		return MembershipFeeDate;
	}
}
