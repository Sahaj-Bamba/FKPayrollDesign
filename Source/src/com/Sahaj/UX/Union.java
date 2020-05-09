package com.Sahaj.UX;

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

	}

	private void addEmployee() {
		
	}

	private void addUnion() {
		
	}

}
