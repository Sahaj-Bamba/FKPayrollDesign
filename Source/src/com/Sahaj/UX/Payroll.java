package com.Sahaj.UX;

import com.Sahaj.Main.Employee;
import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
import java.util.Date;

public class Payroll {

	public Payroll() {
		init();
		start();
	}

	private void init(){

	}

	private void start(){
		Date endDate = Controller.getInstance().getDate("Enter the date on which you want to run payroll");
		ArrayList<Employee> employees= null;
		employees = DatabaseInteractor.getInstance().loadEmployees();
		float total = 0;
		for (Employee employee: employees) {
			total += employee.payRoll(endDate);
		}
		System.out.println("Total = "+total);
	}

}
