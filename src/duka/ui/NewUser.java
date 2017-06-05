package duka.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NewUser extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle(" Add new user");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(9.5);
        gridPane.setHgap(10.5);

        // Labels
        Label titleLabel = new Label("Registration");
        titleLabel.setStyle("-fx-font-size: 16; -fx-font-weight: 200");
        GridPane.setConstraints(titleLabel, 1, 0);

        Label idLabel = new Label("Id:");
        GridPane.setConstraints(idLabel, 0, 1);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 2);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 3);

        Label confirmLabel = new Label("Confirm Password:");
        GridPane.setConstraints(confirmLabel, 0, 4);

        Label typeLabel = new Label("Account Type:");
        GridPane.setConstraints(typeLabel, 0, 5);

        Label msg = new Label();
        GridPane.setConstraints(msg, 1, 6);

        // Text fields
        TextField id = new TextField();
        id.setPromptText("unique number");
        GridPane.setConstraints(id, 1, 1);

        TextField email = new TextField();
        email.setPromptText("example@email.com");
        GridPane.setConstraints(email, 1, 2);

        TextField password = new TextField();
        password.setPromptText("password");
        GridPane.setConstraints(password, 1, 3);

        TextField confirmPassword = new TextField();
        confirmPassword.setPromptText("confirm password");
        GridPane.setConstraints(confirmPassword, 1, 4);

        TextField type = new TextField();
        type.setPromptText("admin or user");
        GridPane.setConstraints(type, 1, 5);

        // Buttons
        Button addUser = new Button("Confirm");
        Button deleteUser = new Button("Delete");

        HBox buttons = new HBox(15.5);
        GridPane.setConstraints(buttons, 1, 7);
        buttons.getChildren().addAll(addUser, deleteUser);


        gridPane.getChildren().addAll(titleLabel, idLabel, id, emailLabel, email, passLabel, password, confirmLabel, confirmPassword, typeLabel, type, msg, buttons);

        Scene userScene = new Scene(gridPane, 400, 300);
        window.setScene(userScene);
        window.show();
    }
}
