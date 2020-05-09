package com.Sahaj.UX;

import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteEmployee {

	public DeleteEmployee() {
		init();
		start();
	}

	private void init() {
	}

	private void start() {

		int id;
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("Employee Id : ");
			try{
				id = Integer.parseInt(sc.next());
				if (id<=0){
					throw new NumberFormatException();
				}
				break;
			}catch (NumberFormatException ex) {
				System.out.println("Please enter correct number.");
			}
		}

		DatabaseInteractor.getInstance().deleteEmployee(id);

	}
}