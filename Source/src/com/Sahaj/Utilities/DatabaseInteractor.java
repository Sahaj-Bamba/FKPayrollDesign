package com.Sahaj.Utilities;

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

}
