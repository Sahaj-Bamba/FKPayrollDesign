package com.Sahaj.UX;

import com.Sahaj.Utilities.Controller;
import com.Sahaj.Utilities.DatabaseInteractor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DeleteEmployee {

	public DeleteEmployee() {
		init();
		start();
	}

	private void init() {
	}

	private void start() {

		int id = Controller.getInstance().getInt("Employee Id : ");

		DatabaseInteractor.getInstance().deleteEmployee(id);

	}
}