package duka.ui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Products extends Application implements EventHandler {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Products Inventory");

        GridPane products_pane = new GridPane();

        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Button add = new Button("Add");
        Button delete = new Button("Delete");

        TextField name = new TextField();
        name.setPromptText("Product Name");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField quantity = new TextField();
        quantity.setPromptText("Quantity");


        Label title = new Label("Products Inventory");
        Label name_label = new Label("Product Name: ");
        Label price_label = new Label("Price: ");
        Label quantity_label = new Label("Quantity: ");

        //Title
        products_pane.add(title, 5, 0, 2, 4);

        // Text boxes
        products_pane.add(name, 5, 3, 5, 2);
        products_pane.add(price, 5, 5, 5, 2);
        products_pane.add(quantity, 5, 8, 5, 2);

        // Text Box Labels
        products_pane.add(name_label, 0, 3, 5, 2);
        products_pane.add(price_label, 0, 5, 5, 2);
        products_pane.add(quantity_label, 0, 8, 5, 2);


        // Buttons
        products_pane.add(previous, 0, 12, 2, 2);
        products_pane.add(next, 3, 12, 2, 2);
        products_pane.add(add, 7, 12, 2, 2);
        products_pane.add(delete, 10, 12, 2, 2);


        Scene product_scene = new Scene(products_pane, 400, 300);

        primaryStage.setScene(product_scene);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {

    }
}

