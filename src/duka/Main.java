package duka;

import duka.ui.Login;
import javafx.application.Application;


public class Main {


    public static void main(String[] args) {

        new DatabaseHelper().createTables();
        new DatabaseHelper().addUser(new User(200, "a@b.c", "xxxxx", "admin"));

        Application.launch(Login.class, args);

    }
}
