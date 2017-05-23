package duka.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.layout.Priority.ALWAYS;

public class Register {

    Stage registerStage;

    public Register(Stage primaryStage) {

        registerStage = primaryStage;

        registerStage.setTitle("Register");
        registerStage.centerOnScreen();
        registerStage.setMinWidth(800);
        registerStage.setMinHeight(600);


        AnchorPane anchorPane;

        {
            anchorPane = new AnchorPane();
            anchorPane.getStylesheets().add("/style.css");
            anchorPane.setId("background");
            anchorPane.setMinWidth(500);
            anchorPane.setPrefWidth(500);
            anchorPane.setPrefHeight(500);


            AnchorPane anchorPane1;

            {
                anchorPane1 = new AnchorPane();
                anchorPane1.setId("top-segment");
                anchorPane1.setPrefWidth(500.0);
                anchorPane1.setPrefHeight(371.0);
                AnchorPane.setTopAnchor(anchorPane1, 0.0);
                AnchorPane.setBottomAnchor(anchorPane1, 129.0);
                AnchorPane.setLeftAnchor(anchorPane1, 0.0);
                AnchorPane.setRightAnchor(anchorPane1, 0.0);


                VBox vBox;
                {
                    vBox = new VBox();
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setSpacing(5.0);
                    AnchorPane.setTopAnchor(vBox, 10.0);
                    AnchorPane.setBottomAnchor(vBox, 32.5);
                    AnchorPane.setLeftAnchor(vBox, 42.0);
                    AnchorPane.setRightAnchor(vBox, 40.0);

                    GridPane gridPane;
                    {
                        gridPane = new GridPane();
                        gridPane.setHgap(15.0);
                        gridPane.setVgap(15.0);

                    }
                    vBox.getChildren().addAll(gridPane);

                }
                anchorPane1.getChildren().addAll(vBox);

            }

            HBox hBox;
            {
                hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(5.0);
                AnchorPane.setBottomAnchor(hBox, 102.0);
                AnchorPane.setLeftAnchor(hBox, 40.0);

                Label label;
                {
                    label = new Label("Profile  successfully updated!");
                    // label.setFont("$x2");
                    label.setOpacity(0.0);

                    hBox.getChildren().addAll(label);
                }

            }
            HBox hBox1;
            {
                hBox1 = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(20.0);
                AnchorPane.setBottomAnchor(hBox1, 42.0);
                AnchorPane.setLeftAnchor(hBox1, 40.0);
                AnchorPane.setRightAnchor(hBox1, 40.0);

                Button buttonReset = new Button("Reset");
                buttonReset.setDefaultButton(true);
                buttonReset.setMaxHeight(3.0);
                buttonReset.setPrefHeight(50.0);
                buttonReset.setPrefWidth(205.0);
                HBox.setHgrow(buttonReset, ALWAYS);

                Button buttonSave = new Button("Save");
                buttonSave.setDefaultButton(true);
                buttonSave.setMaxHeight(3.0);
                buttonSave.setPrefHeight(50.0);
                buttonSave.setPrefWidth(205.0);
                HBox.setHgrow(buttonSave, ALWAYS);


                hBox1.getChildren().addAll(buttonReset, buttonSave);
            }
            anchorPane.getChildren().addAll(anchorPane1, hBox, hBox1);
        }

        registerStage.setScene(new Scene(anchorPane));
        registerStage.show();


    }

}
