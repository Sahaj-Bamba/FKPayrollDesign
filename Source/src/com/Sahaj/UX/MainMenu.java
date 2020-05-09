package com.Sahaj.UX;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main menu msg
 */

public class MainMenu {

	ArrayList<String> choices = new ArrayList<String>();

	public MainMenu(){
		init();
		start();
	}

	private void init() {
		choices.add("1) Add new Employee ");
		choices.add("2) Delete Employee ");
		choices.add("3) Post Time Card ");
		choices.add("4) Post Sales receipt ");
		choices.add("5) Post Membership fees ");
		choices.add("6) Post Service Charge ");
		choices.add("7) Change Employee details ");
		choices.add("8) Run PayRoll ");
		choices.add("9) Quit ");
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
		for (String ch : choices) {
			System.out.println(ch);
		}
	}

}
