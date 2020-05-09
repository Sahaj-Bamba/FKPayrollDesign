package com.Sahaj.Utilities;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;

public class DatabaseInteractor {

	private static DatabaseInteractor databaseInteractor;

	private DatabaseInteractor(){

	}

	public static DatabaseInteractor getInstance(){
		if (databaseInteractor == null){
			databaseInteractor = new DatabaseInteractor();
		}
		return databaseInteractor;
	}

	public void addEmployee(String name, PaymentScheme paymentScheme, float salary, float commission, ModeOfPayment modeOfPayment, String address) {
	
		//@// TODO: 09/05/20 Add Employee code
		
	}

	public void deleteEmployee(int id) {

		// @TODO: 09/05/20 Delete Employee

	}
}
