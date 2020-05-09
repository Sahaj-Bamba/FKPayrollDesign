package com.Sahaj.Utilities;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class DatabaseInteractor {

	private static DatabaseInteractor databaseInteractor;

	private DatabaseInteractor(){
		//@Todo: Update so that success message is not shown in case of some problem .
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
		SQLQueryExecuter.getInstance().update("INSERT INTO `Employee`(`Name`, `SalaryType`, `Salary`, `Commission`, `ModeOfPayment`, `Address`) VALUES ('"+name+"',"+paymentScheme.ordinal()+","+salary+","+commission+","+modeOfPayment.ordinal()+",'"+address+"')");

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

		SQLQueryExecuter.getInstance().update("DELETE FROM `Employee` WHERE Id = "+id);
		System.out.println("Deleted Employee");

	}

	public void updatePaymentScheme(int id, PaymentScheme paymentScheme) {

		SQLQueryExecuter.getInstance().update("UPDATE `Employee` SET SalaryType = "+paymentScheme.ordinal()+" WHERE Id = "+id);
		System.out.println("Updated Employee");

	}

	public void updateCommission(int id, float commission) {

		SQLQueryExecuter.getInstance().update("UPDATE `Employee` SET commission = "+commission+" WHERE Id = "+id);
		System.out.println("Updated Employee");

	}

	public void updateModeOfPayment(int id, ModeOfPayment modeOfPayment) {

		SQLQueryExecuter.getInstance().update("UPDATE `Employee` SET ModeOfPayment = "+modeOfPayment.ordinal()+" WHERE Id = "+id);
		System.out.println("Updated Employee");

	}

	public void updateAddress(int id, String address) {

		SQLQueryExecuter.getInstance().update("UPDATE `Employee` SET Address = '"+address+"' WHERE Id = "+id);
		System.out.println("Updated Employee");

	}

	public void updateSalary(int id, Float salary) {

		SQLQueryExecuter.getInstance().update("UPDATE `Employee` SET salary = "+salary+" WHERE Id = "+id);
		System.out.println("Updated Employee");

	}

	public void addSalesReceipt(int id, Date date, Float amount) {

		SQLQueryExecuter.getInstance().update("INSERT INTO `Sales`( `EmpId`, `Date`, `Amount`) VALUES ("+id+",'"+date+"',"+amount+")");

	}

	public void addTimeCard(int id, Date date, Float amount) {

		SQLQueryExecuter.getInstance().update("INSERT INTO `TimeCard`( `EmpId`, `Date`, `NumberOfHours`) VALUES ("+id+",'"+date+"',"+amount+")");

	}

	public void addCharge(int id, Date date, Float amount, String reason) {

		SQLQueryExecuter.getInstance().update("INSERT INTO `ExtraCharges`( `EmpId`, `Date`, `Amount`, `Reason`) VALUES ("+id+",'"+date+"',"+amount+",'"+reason+"')");

	}

	public void updateAccount(int id, String account) {

		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `AccountDetails` WHERE EmpId = '"+id+"'");

		try {
			if (resultSet.next()){
				SQLQueryExecuter.getInstance().update( " UPDATE `AccountDetails` SET `AccountNumber`= '"+account+"' WHERE `EmpId`= " + id);
			}else{
				SQLQueryExecuter.getInstance().update("INSERT INTO `AccountDetails`(`EmpId`, `AccountNumber`) VALUES ("+id+",'"+account+"'");
			}
		} catch (SQLException throwables) {
			System.out.println("Something went wrong");
		}

	}

	public void updateUnionFees(int unionId, float fees) {
		SQLQueryExecuter.getInstance().update("UPDATE `Union_` SET `Fees`="+fees+" WHERE `Id`= "+unionId+" ");
	}

	public void addUnionEmployee(int unionId, int empId) {
		SQLQueryExecuter.getInstance().update("INSERT INTO `EmployeeUnion`(`EmpId`, `UnionId`) VALUES ("+empId+","+unionId+")");
	}

	public void addUnion(String name) {
		int id = -1;
		ResultSet resultSet = SQLQueryExecuter.getInstance().select("Select Id from Union_ order by Id desc");

		try {
			if(resultSet.next()) {
				id = resultSet.getInt("Id");
			}
		} catch (SQLException throwables) {
			System.out.println("Something went wrong");
		}

		// Adding
		SQLQueryExecuter.getInstance().update("INSERT INTO `Union_`(`Name`) VALUES ('"+name+"')");

		resultSet = SQLQueryExecuter.getInstance().select("Select Id from Union_ order by Id desc");

		try {
			if(resultSet.next() && id != resultSet.getInt("Id")) {
				id = resultSet.getInt("Id");
				System.out.println("New Union added with id " + id);
			}
		} catch (SQLException throwables) {
			System.out.println("Something went wrong");
		}

	}

}
