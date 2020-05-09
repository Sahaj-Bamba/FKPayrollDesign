package com.Sahaj.UX;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quit {

	ArrayList<String> choices = new ArrayList<String>();
	private String mainHeading;

	public Quit(){
		init();
		start();
	}

	private void init() {
		mainHeading = "Are you sure that you want to quit ?";
		choices.add("Yes ");
		choices.add("No ");
	}

	private void start() {

		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		while (true){
			showMenu();
			try {
				choice = scanner.nextInt();
			}catch (InputMismatchException ex){
				choice = 0;
			}
			if(testChoice(choice)){
				makeMove(choice);
			}
		}

	}

	private boolean testChoice(int choice){
		if (choice<=choices.size()+1 && choice>=1){
			return true;
		}
		System.out.println("Please enter a valid number between (1-"+choices.size()+1+")");
		return false;
	}

	private void makeMove(int choice) {
		switch (choice){
			case 1: new AddEmployee();
				break;
			case 2: new DeleteEmployee();
				break;
			case 3: new PostTimeCard();
				break;
			case 4: new PostSalesReceipt();
				break;
			case 5: new UnionFees();
				break;
			case 6: new ServiceCharge();
				break;
			case 7: new ChangeEmployeeDetails();
				break;
			case 8: new Payroll();
				break;
			case 9: new Quit();
				break;
		}
	}

	private void showMenu() {
		System.out.println(mainHeading);
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i+1)+") "+choices.get(i));
		}
	}

}
