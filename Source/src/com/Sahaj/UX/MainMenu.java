package com.Sahaj.UX;

/**
 * The main menu
 */

public class MainMenu extends Menu {

	public MainMenu(){
		super();
		start();
	}

	@Override
	protected void init() {
		mainHeading = "Welcome to the Pay Roll system.\nPlease enter your choice.";
		choices.add("Add new Employee ");
		choices.add("Delete Employee ");
		choices.add("Post Time Card ");
		choices.add("Post Sales receipt ");
		choices.add("Union ");
		choices.add("Post Service Charge ");
		choices.add("Change Employee details ");
		choices.add("Run PayRoll ");
		choices.add("Quit ");
	}

	@Override
	protected void makeMove(int choice) {
		switch (choice){
			case 1: new AddEmployee();
				break;
			case 2: new DeleteEmployee();
				break;
			case 3: new PostTimeCard();
				break;
			case 4: new PostSalesReceipt();
				break;
			case 5: new Union();
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

}
