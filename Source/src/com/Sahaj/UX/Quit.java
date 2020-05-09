package com.Sahaj.UX;

public class Quit extends Menu{

	public Quit(){
		super();
	}

	@Override
	protected void init() {
		mainHeading = "Are you sure that you want to quit ?";
		choices.add("Yes ");
		choices.add("No ");
	}

	@Override
	protected void makeMove(int choice) {
		switch (choice){
			case 1: quit();
				break;
			case 2: goBack();
				break;
		}
	}

	private void quit() {
		System.out.println("Thank you for using the Pay Roll Portal.");
		System.out.println("Have a nice Day");
		System.exit(0);
	}

}
