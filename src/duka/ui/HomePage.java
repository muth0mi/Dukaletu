package duka.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomePage extends Application {
    Stage window = new Stage();

    Button inventory = new Button("Products");
    Button logout = new Button("Close");
    Button users = new Button("Users");
    Button sale = new Button("Sales");

    Label home = new Label("Main Dashboard");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        home.setStyle("-fx-font-size: 20;");

        GridPane gridPane = new GridPane();
        gridPane.setId("background");
        gridPane.setPadding(new Insets(10, 15, 10, 15));
        gridPane.setHgap(25);
        gridPane.setVgap(20);

        GridPane.setConstraints(home, 11, 0);
        GridPane.setConstraints(inventory, 0, 1);
        GridPane.setConstraints(users, 0, 2);
        GridPane.setConstraints(sale, 0, 3);
        GridPane.setConstraints(logout, 22, 0);
        gridPane.getChildren().addAll(home, inventory, users, sale, logout);

        Scene homePage = new Scene(gridPane, 900, 400);
        homePage.getStylesheets().add("/style.css");
        window.setTitle("Home Page");
        window.setScene(homePage);
        window.show();
    }
}
