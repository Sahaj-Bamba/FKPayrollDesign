package com.Sahaj.Utilities;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;

import java.sql.ResultSet;
import java.sql.SQLException;
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

		int id = -1;
		ResultSet resultSet = SQLQueryExecuter.getInstance().select("Select Id from Employee order by Id desc");

		try {
			if(resultSet.next()) {
				id = resultSet.getInt("Id");
			}
		} catch (SQLException throwables) {
			System.out.println("Something went wrong");
		}

		// Adding
		SQLQueryExecuter.getInstance().update("INSERT INTO `Employee`(`Name`, `SalaryType`, `Salary`, `Comission`, `ModeOfPayment`, `Address`) VALUES ('"+name+"',"+paymentScheme.ordinal()+","+salary+","+commission+","+modeOfPayment.ordinal()+",'"+address+"')");

		resultSet = SQLQueryExecuter.getInstance().select("Select Id from Employee order by Id desc");

		try {
			if(resultSet.next() && id != resultSet.getInt("Id")) {
				id = resultSet.getInt("Id");
				System.out.println("New Employee added with id " + id);
			}
		} catch (SQLException throwables) {
			System.out.println("Something went wrong");
		}

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
