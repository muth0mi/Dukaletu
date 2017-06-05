package duka.ui;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConfirmTest extends  Application{
    Stage window = new Stage();
    Button button1 , button2;

    public static void main(String args[]){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("This Window");

        button1 = new Button("Delete");
        button1.setOnAction(e ->
        {
            boolean result = ConfirmBox.display("Delete?", "Are you sure you want to delete?");
            System.out.println(result);
        });
        button2 = new Button("Cancel");
        button2.setOnAction(e -> window.close());

        HBox layout = new HBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button1, button2);

        Scene scene = new Scene(layout, 300, 300);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        window.show();
    }
}
