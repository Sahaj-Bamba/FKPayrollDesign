package com.Sahaj.Utilities;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Constant.PaymentScheme;
import com.Sahaj.Main.Employee;
import com.Sahaj.Main.Hourly;
import com.Sahaj.Main.Monthly;
import com.Sahaj.Main.Sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public ArrayList<Employee> loadEmployees() {

		ArrayList<Employee> employees = new ArrayList<>();

		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `Employee` WHERE 1");
		try {
			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("Id"),resultSet.getString("Name"),resultSet.getFloat("Salary"),resultSet.getFloat("Commission"),resultSet.getString("Address"),resultSet.getDate("LastPayed"));
				if (resultSet.getInt("SalaryType") == PaymentScheme.HourlySalary.ordinal()){
					employee.setTypeOfPayment(new Hourly());
				}else if(resultSet.getInt("SalaryType") == PaymentScheme.MonthlySalary.ordinal()){
					employee.setTypeOfPayment(new Monthly());
				}
				employee.setModeOfPayment(ModeOfPayment.values()[resultSet.getInt("ModeOfPayment")]);
				if (resultSet.getInt("ModeOfPayment") == ModeOfPayment.OnlineBank.ordinal()){
					ResultSet resultSet2 = SQLQueryExecuter.getInstance().select("SELECT * FROM `AccountDetails` WHERE EmpId = "+resultSet.getInt("EmpId"));
					if (resultSet2.next()){
						employee.setAccNo(resultSet2.getString("AccountNumber"));
					}
				}
				employees.add(employee);
			}
		}catch (SQLException throwables) {
			System.out.println("Something went wrong please try again latter.");
		}
		return employees;
	}

	public float getHours(Date lastPayed, Date endDate, int id) {
		float hours = 0f;

		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `TimeCard` WHERE EmpId = " + id + " And Date >= '" + lastPayed + "' And Date < '" + endDate + "' ");
		try {
			while (resultSet.next()) {
				if (resultSet.getFloat("NumberOfHours")>8){
					hours += 8f;
				}else{
					hours += resultSet.getFloat("NumberOfHours");
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return hours;
	}

		public float getExtraHours(Date lastPayed, Date endDate, float salary, int id) {

			float hours = 0f;

			ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `TimeCard` WHERE EmpId = " + id + " And Date >= '" + lastPayed + "' And Date < '" + endDate + "' ");
			try {
				while (resultSet.next()) {
					if (resultSet.getFloat("NumberOfHours")>8){
						hours += resultSet.getFloat("NumberOfHours") - 8f;
					}else{
						hours += 0;
					}
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			return hours;

		}

	public ArrayList<Sales> getSaled(Date lastPayed, Date endDate, int id) {
	
		ArrayList<Sales> sales = null;
		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `Sales` WHERE EmpId = " + id + " And Date >= '" + lastPayed + "' And Date < '" + endDate + "' ");
		try {
			while (resultSet.next()) {
				sales.add(new Sales(resultSet.getFloat("Amount")));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return sales;
	}

	public void updatePayed(int id, Date endDate) {

		SQLQueryExecuter.getInstance().update("Update Employee SET LastPayed = '"+endDate+"' where Id = "+id);

	}

	public float getCharges(Date lastPayed, Date endDate, int id) {

		float value = 0f;

		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `ExtraCharges` WHERE EmpId = " + id + " And Date >= '" + lastPayed + "' And Date < '" + endDate + "' ");
		try {
			while (resultSet.next()) {
				value += resultSet.getFloat("Amount");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return value;


	}

	public void addMembershipFees(int id, Date endDate) {
		int unionId = -1;
		ResultSet resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `EmployeeUnion` WHERE EmpId = " + id );
		try {
			if (resultSet.next()) {
				unionId = resultSet.getInt("UnionId");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		if (unionId == -1){
			return;
		}
		float charges = 0f;
		resultSet = SQLQueryExecuter.getInstance().select("SELECT * FROM `Union_` WHERE Id = " + unionId );
		try {
			if (resultSet.next()) {
				charges = resultSet.getInt("Fees");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		addCharge(id,endDate,charges,"Union fees");
	}
}
