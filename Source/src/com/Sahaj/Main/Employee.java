package com.Sahaj.Main;

import com.Sahaj.Constant.ModeOfPayment;
import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private float salary;
	private float commission;
	private String address;
	private String accNo;
	private Date lastPayed;
	private TypeOfPayment typeOfPayment;
	private ModeOfPayment modeOfPayment;
	private ArrayList<Sales> sales;

	public Employee(int id, String name, float salary, float commission, String address, Date lastPayed) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.commission = commission;
		this.address = address;
		this.lastPayed = lastPayed;
	}

	public void addSales(Sales sales){
		this.sales.add(sales);
	}

	private float debit(Date endDate){
		return DatabaseInteractor.getInstance().getCharges(lastPayed,endDate,id);
	}

	public float currentIncome(Date endDate){
		float income = typeOfPayment.credit(this.lastPayed,endDate,salary,id) + salesCommission(endDate);
		income -= debit(endDate);
		if (income<0){
			DatabaseInteractor.getInstance().addCharge(id,new Date(),Math.abs(income),"Previous Month Dues");
			income = 0;
		}
		return income;
	}

	private float salesCommission(Date endDate){
		this.sales = DatabaseInteractor.getInstance().getSaled(lastPayed,endDate,id);
		float value = 0;
		for (Sales sale: this.sales) {
			value += sale.getCommission(commission);
		}
		return value;
	}

	public float payRoll(Date endDate){
		addMembershipFees(endDate);
		float income = currentIncome(endDate);
		pay(income,endDate);
		return income;
	}

	private void addMembershipFees(Date endDate) {
		if(endDate.getDay() == Controller.getInstance().getMembershipFeeDate()){
			DatabaseInteractor.getInstance().addMembershipFees(id,endDate);
		}
	}

	private void pay(float currentIncome, Date endDate) {
		System.out.println("Pay " + currentIncome +"\t to "+name);
		if (modeOfPayment.equals(ModeOfPayment.OnlineBank)){
			System.out.println("Account number : "+accNo);
		}else if (modeOfPayment.equals(ModeOfPayment.Pickup)){
			System.out.println("He will come to pick up.");
		}else if (modeOfPayment.equals(ModeOfPayment.Postal)){
			System.out.println("Address : "+address);
		}
		DatabaseInteractor.getInstance().updatePayed(id,endDate);
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public void setTypeOfPayment(TypeOfPayment typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

}
