package duka;

import duka.ui.Login;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static jdk.nashorn.internal.objects.Global.Infinity;


public class AdminDashboard implements EventHandler {

    Stage dashboardStage;
    Button buttonLogout;


    public AdminDashboard(Stage primaryStage) {

        dashboardStage = primaryStage;

        dashboardStage.setTitle("Dashboard");
        dashboardStage.centerOnScreen();
        dashboardStage.setMinWidth(800);
        dashboardStage.setMinHeight(600);


        Button t1 = new Button("Welcome Admin");
        buttonLogout = new Button("Logout");
        buttonLogout.setAlignment(Pos.TOP_RIGHT);
        buttonLogout.setOnAction(this);


        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(buttonLogout.getHeight());
        gridPane.setPrefWidth(-Infinity);
        gridPane.setStyle("-fx-background-color: #ff0000");
        gridPane.setMinWidth(600);

        gridPane.getChildren().add(t1);
        gridPane.getChildren().add(buttonLogout);


        Scene dashboardScene = new Scene(gridPane);
        dashboardStage.setScene(dashboardScene);
        dashboardStage.show();

    }

    @Override
    public void handle(Event event) {

        if (event.getSource() == buttonLogout) {
            dashboardStage.close();
            new Login().onStart(dashboardStage);
        }

    }
}
