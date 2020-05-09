package com.Sahaj.UX;

import com.Sahaj.Utilities.Controller;
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
		DatabaseInteractor.getInstance().updateUnionFees(Controller.getInstance().getInt("Union Id : "),Controller.getInstance().getFloat("Weekly amount : "));
	}

	private void addEmployee() {
		DatabaseInteractor.getInstance().addUnionEmployee(Controller.getInstance().getInt("Union Id : "),Controller.getInstance().getInt("Employee Id : "));
	}

	private void addUnion() {
		DatabaseInteractor.getInstance().addUnion(Controller.getInstance().getString("Union name : "));
	}

}
