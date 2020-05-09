package com.Sahaj.UX;

import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.Scanner;

public class Union extends Menu{

	public Union(){
		super();
		start();
	}

	@Override
	protected void init() {
		choices.add("Add Union");
		choices.add("Add Employee");
		choices.add("Update Fees");
		choices.add("Go Back");
	}

	@Override
	protected void makeMove(int choice) {
		switch (choice){
			case 1: addUnion();
				break;
			case 2: addEmployee();
				break;
			case 3: updateFee();
				break;
			case 4: goBack();
				break;
		}
	}

	private void updateFee() {
		DatabaseInteractor.getInstance().updateUnionFees(getInt("Union Id : "),getFloat("Weekly amount : "));
	}

	private void addEmployee() {
		DatabaseInteractor.getInstance().addUnionEmployee(getInt("Union Id : "),getInt("Employee Id : "));
	}

	private void addUnion() {
		DatabaseInteractor.getInstance().addUnion(getString("Union name : "));
	}

	private float getFloat(String heading){
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

	private int getInt(String heading){
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

	private String getString(String heading){

		Scanner sc = new Scanner(System.in);
		String value;
		System.out.print(heading);
		value = sc.nextLine();
		return value;

	}

}
