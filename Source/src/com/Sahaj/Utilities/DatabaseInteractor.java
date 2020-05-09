package com.Sahaj.Utilities;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;

import java.util.Date;

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

		System.out.println(name);
		System.out.println(address);

		//@// TODO: 09/05/20 Add Employee code
		
	}

	public void deleteEmployee(int id) {

		// @TODO: 09/05/20 Delete Employee

	}

	public void updatePaymentScheme(int id, PaymentScheme paymentScheme) {
	}

	public void updateCommission(int id, float commission) {
	}

	public void updateModeOfPayment(int id, ModeOfPayment modeOfPayment) {
	}

	public void updateAddress(int id, String address) {
	}

	public void updateSalary(int id, Float salary) {
	}

	public void addSalesReceipt(int id, Date date, Float amount) {
	}

	public void addTimeCard(int id, Date date, Float amount) {
	}

	public void addCharge(int id, Date date, Float amount, String reason) {
	}
}
