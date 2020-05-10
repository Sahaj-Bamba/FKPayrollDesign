package com.Sahaj.Main;

import com.Sahaj.UX.MainMenu;
import com.Sahaj.Utilities.SQLQueryExecuter;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SQLQueryExecuter.startConnection("root", "", "jdbc:mysql://localhost:3306/PayrollDesign");
        new MainMenu();
    }
}
