package duka.ui;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class ConfirmBox {
    static  boolean response;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        Label msg = new Label();
        msg.setText(message);

        Button no = new Button("No");
        Button yes = new Button("Yes");
        yes.setOnAction(e ->
        {
            response = true;
            window.close();
        });
        no.setOnAction(e ->
        {
            response = false;
            window.close();
        });

        HBox buttons = new HBox(27);
        buttons.getChildren().addAll(yes, no);
        buttons.setAlignment(Pos.CENTER);

        VBox labels = new VBox(10);
        labels.getChildren().addAll(msg);
        labels.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(labels, buttons);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        window.showAndWait();

        return response;
    }
}