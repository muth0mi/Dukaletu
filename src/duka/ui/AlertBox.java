package duka.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class AlertBox {
    public static void display(String title, String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        BorderPane border = new BorderPane();
        Label msg = new Label();
        msg.setText(message);

        Button goBack = new Button("Back");
        goBack.setOnAction(e ->
        {
            window.close();
        });
        goBack.setVisible(false);
        Button no = new Button("No");
        Button yes = new Button("Yes");
        yes.setOnAction(e ->
        {
            msg.setText("Delete Confirmed");
            no.setVisible(false);
            yes.setVisible(false);
            goBack.setVisible(true);
        });
        no.setOnAction(e ->
        {
            msg.setText("Cancelled");
            msg.setVisible(true);
            no.setVisible(false);
            yes.setVisible(false);
            goBack.setVisible(true);
        } );

        HBox buttons = new HBox(24);
        buttons.getChildren().addAll(yes,goBack, no);
        buttons.setAlignment(Pos.CENTER);

        VBox labels =  new VBox(10);
        labels.getChildren().addAll(msg);
        labels.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(labels, buttons);
        layout.setAlignment(Pos.CENTER);

        //border.setBottom(buttons);
        //border.setCenter(labels);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
