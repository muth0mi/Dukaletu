package duka;

import duka.ui.Login;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserDashboard implements EventHandler{

    Stage dashboardStage;
    Button buttonLogout;

    public UserDashboard(Stage primaryStage) {

        dashboardStage = primaryStage;

        dashboardStage.setTitle("Dashboard");
        dashboardStage.centerOnScreen();
        dashboardStage.setMinWidth(800);
        dashboardStage.setMinHeight(600);


        Button t1 = new Button("Welcome User");
        buttonLogout = new Button("Logout");
        buttonLogout.setAlignment(Pos.TOP_RIGHT);
        buttonLogout.setOnAction(this);


        VBox layout = new VBox();
        layout.setMinHeight(800);
        layout.setMinWidth(600);



        layout.getChildren().add(t1);
        layout.getChildren().add(buttonLogout);


        Scene dashboardScene = new Scene(layout);
        dashboardStage.setScene(dashboardScene);
        dashboardStage.show();

    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == buttonLogout){
            dashboardStage.close();
            new Login().onStart(dashboardStage);

        }
    }
}
