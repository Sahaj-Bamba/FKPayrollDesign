package com.Sahaj.UX;

import java.util.ArrayList;

public class ChoiceMenu extends Menu{

	public ChoiceMenu(ArrayList<String> choices,String mainHeading){
		super();
		this.choices = choices;
		this.mainHeading = mainHeading;
	}

	@Override
	protected void init() {

	}

	@Override
	protected void makeMove(int choice) {
		goBack();
		return;
	}
}
