package com.Sahaj.UX;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
	protected ArrayList<String> choices = new ArrayList<String>();
	protected String mainHeading;

	public Menu(){
		init();
		start();
	}

	protected abstract void init();

	private final void start() {

		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		while (true){
			showMenu();
			try {
				choice = scanner.nextInt();
			}catch (InputMismatchException ex){
				choice = 0;
			}
			if(testChoice(choice)){
				makeMove(choice);
			}
		}

	}

	private final boolean testChoice(int choice){
		if (choice<=choices.size()+1 && choice>=1){
			return true;
		}
		System.out.println("Please enter a valid number between (1-"+choices.size()+1+")");
		return false;
	}

	protected abstract void makeMove(int choice);

	private final void showMenu() {
		System.out.println(mainHeading);
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i+1)+") "+choices.get(i));
		}
	}

}
