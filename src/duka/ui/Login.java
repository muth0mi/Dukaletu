package duka.ui;

import duka.DatabaseHelper;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static jdk.nashorn.internal.objects.Global.Infinity;


public class Login extends Application implements EventHandler {

    private DatabaseHelper db = new DatabaseHelper();

    private TextField textFieldEmail;
    private PasswordField passwordFieldPassword;
    private Label labelError;

    private Button buttonLogin, buttonOkay;

    private Stage loginStage, stage;

    private String mUserType;


    @Override
    public void start(Stage stage) throws Exception {

        onStart(stage);
    }


    public void onStart(Stage stage) {
        this.loginStage = stage;

        loginStage.setTitle("Duka Letu");
        loginStage.centerOnScreen();
        loginStage.setMinWidth(390.0);
        loginStage.setWidth(500.0);
        loginStage.setMinHeight(500.0);
        loginStage.setHeight(500.0);

        AnchorPane anchorPane1;
        {
            anchorPane1 = new AnchorPane();
            anchorPane1.getStylesheets().add("style.css");
            anchorPane1.setId("background");
            anchorPane1.setMaxHeight(-Infinity);
            anchorPane1.setMinHeight(-Infinity);
            anchorPane1.prefHeight(500.0);
            anchorPane1.setMaxWidth(-Infinity);
            anchorPane1.setMinWidth(-Infinity);
            anchorPane1.prefWidth(500.0);

            AnchorPane anchorPane2;
            {
                anchorPane2 = new AnchorPane();
                anchorPane2.setId("top-segment");
                anchorPane2.setPrefWidth(500.0);
                anchorPane2.setPrefHeight(300.0);
                AnchorPane.setBottomAnchor(anchorPane2, 200.0);
                AnchorPane.setTopAnchor(anchorPane2, 0.0);
                AnchorPane.setRightAnchor(anchorPane2, 0.0);
                AnchorPane.setLeftAnchor(anchorPane2, 0.0);

                VBox vBox;
                {
                    vBox = new VBox();
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefHeight(300.0);
                    vBox.setPrefWidth(421.0);
                    vBox.setSpacing(5.0);
                    AnchorPane.setTopAnchor(vBox, 0.0);
                    AnchorPane.setBottomAnchor(vBox, 0.0);
                    AnchorPane.setRightAnchor(vBox, 40.0);
                    AnchorPane.setLeftAnchor(vBox, 40.0);

                    AnchorPane anchorPane3 = new AnchorPane();
                    {
                        anchorPane3.setPrefWidth(430.0);
                        anchorPane3.setPrefHeight(180.0);

                        Label labelPassword, labelEmail, labelLogin;

                        labelLogin = new Label();
                        labelLogin.setText("Log In");
                        labelLogin.setLayoutY(-20.0);
                        AnchorPane.setRightAnchor(labelLogin, 40.0);
                        AnchorPane.setLeftAnchor(labelLogin, 40.0);
                        labelLogin.setAlignment(Pos.BASELINE_CENTER);
                        labelLogin.setStyle("-fx-font-size: 600%; -fx-font-family: monospace;");

                        {
                            labelEmail = new Label("Email");
                            labelEmail.setLayoutX(24.0);
                            labelEmail.setLayoutY(65.0);
                            labelEmail.setId("email_n_password_labels");

                            textFieldEmail = new TextField();
                            textFieldEmail.setPromptText("example@email.com");
                            textFieldEmail.setLayoutY(86.0);
                            textFieldEmail.setPrefWidth(415.0);
                            AnchorPane.setLeftAnchor(textFieldEmail, 10.0);
                            AnchorPane.setRightAnchor(textFieldEmail, 10.0);
                        }

                        {
                            labelPassword = new Label("Password");
                            labelPassword.setLayoutX(24.0);
                            labelPassword.setLayoutY(137.0);
                            labelPassword.setId("email_n_password_labels");

                            passwordFieldPassword = new PasswordField();
                            passwordFieldPassword.setPromptText("password");
                            passwordFieldPassword.setLayoutY(157.0);
                            passwordFieldPassword.setPrefWidth(415.0);
                            AnchorPane.setLeftAnchor(passwordFieldPassword, 10.0);
                            AnchorPane.setRightAnchor(passwordFieldPassword, 10.0);
                        }
                        anchorPane3.getChildren().addAll(labelEmail, textFieldEmail, labelPassword, passwordFieldPassword, labelLogin);

                    }
                    vBox.getChildren().addAll(anchorPane3);

                }
                anchorPane2.getChildren().addAll(vBox);

            }

            buttonLogin = new Button();
            buttonLogin.setOnAction(this);
            buttonLogin.setText("Login");
            buttonLogin.setDefaultButton(true);
            buttonLogin.setPrefHeight(70.0);
            buttonLogin.setPrefWidth(400.0);
            AnchorPane.setBottomAnchor(buttonLogin, 66.0);
            AnchorPane.setRightAnchor(buttonLogin, 40.0);
            AnchorPane.setLeftAnchor(buttonLogin, 40.0);


            HBox hBox2;
            {
                hBox2 = new HBox();
                hBox2.setAlignment(Pos.CENTER);
                hBox2.setPrefHeight(25.0);
                hBox2.setPrefWidth(418.0);
                AnchorPane.setBottomAnchor(hBox2, 156.0);
                AnchorPane.setRightAnchor(hBox2, 41.0);
                AnchorPane.setLeftAnchor(hBox2, 41.0);

                labelError = new Label("");
                labelError.setId("errorMessage");

                hBox2.getChildren().addAll(labelError);
            }

            anchorPane1.getChildren().addAll(anchorPane2, buttonLogin, hBox2);
        }

        Scene loginScene = new Scene(anchorPane1);

        loginStage.setScene(loginScene);
        loginStage.show();
    }


    private void startLogin() {
        // Get the inputs
        String email = textFieldEmail.getText();
        String password = passwordFieldPassword.getText();

        // Input Validity Checks.
        {
            textFieldEmail.setStyle(new TextField().getStyle());
            passwordFieldPassword.setStyle(new TextField().getStyle());

            if (email.isEmpty()) {
                labelError.setText("The email field is empty");
                this.textFieldEmail.setStyle("-fx-border-color: #f00");
                textFieldEmail.requestFocus();
                return;
            } else if (!email.contains("@") || !email.contains(".")) {
                labelError.setText("Please enter a valid email");
                textFieldEmail.setStyle("-fx-border-color: #f00");
                textFieldEmail.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                labelError.setText("The password field is empty");
                this.passwordFieldPassword.setStyle("-fx-border-color: #f00");
                passwordFieldPassword.requestFocus();
                return;
            } else if (password.length() < 4) {
                labelError.setText("Password should be at least 4 characters");
                passwordFieldPassword.setStyle("-fx-border-color: #f00");
                passwordFieldPassword.requestFocus();
                return;
            }


        }

        // Login authentication
        {
            if (db.getUsersCount(email) == 1) {


                if (password.equals(db.getUsersPassword(email))) {

                    // Login Successful

                    {
                        stage = new Stage();
                        stage.setTitle("Welcome");
                        stage.centerOnScreen();

                        stage.setMinHeight(150);
                        stage.setMaxHeight(150);
                        stage.setHeight(150);
                        stage.setMinWidth(400);
                        stage.setMaxWidth(400);
                        stage.setWidth(400);

                        stage.setAlwaysOnTop(true);
                        stage.setOnCloseRequest(this);
                        stage.setResizable(false);


                        buttonOkay = new Button("OK");
                        buttonOkay.setOnAction(this);

                        mUserType = db.getUser(email).getmUserType();
                        Label label = new Label("You are logged in as a " + mUserType);

                        GridPane gridPane = new GridPane();
                        gridPane.setId("background");
                        gridPane.getChildren().addAll(buttonOkay, label);

                        Scene scene = new Scene(gridPane);
                        scene.getStylesheets().add("style.css");
                        stage.setScene(scene);
                        stage.show();
                    }

                } else {
                    labelError.setText("Incorrect Password. Try again");

                }

            } else {
                labelError.setText("Email not found");
            }
        }


    }


    private void goToDashboard() {
        if (mUserType.equals("admin")) {
            new Register(loginStage);
        }
        if (mUserType.equals("user")) {
            new Register(loginStage);
        }

    }


    @Override
    public void handle(Event event) {

        if (event.getSource() == stage) {
            goToDashboard();
        } else if (event.getSource() == buttonOkay) {
            stage.close();
            goToDashboard();
        } else if (event.getSource() == buttonLogin) {
            startLogin();

        }

    }


}