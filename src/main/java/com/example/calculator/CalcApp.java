package com.example.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class used to create the User Intergace
 *
 * @author Michael Laing, Ngaio Hawkins
 */
public class CalcApp extends Application {
    private TextField display;
    private Engine engine;
    @Override
    public void start(Stage stage) {
        this.engine = new Engine();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        display = new TextField();
        display.setEditable(false);
        display.setMaxWidth(150.0);
        display.setText(engine.getEquation());
        display.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(display);
        HBox buttonsPane = new HBox();
        buttonsPane.setAlignment(Pos.CENTER);
        root.getChildren().add(buttonsPane);
        VBox column1 = new VBox();
        column1.setAlignment(Pos.CENTER);
        column1.setMinWidth(50.0);
        VBox column2 = new VBox();
        column2.setAlignment(Pos.CENTER);
        column2.setMinWidth(50.0);
        VBox column3 = new VBox();
        column3.setAlignment(Pos.CENTER);
        column3.setMinWidth(50.0);
        buttonsPane.getChildren().add(column1);
        buttonsPane.getChildren().add(column2);
        buttonsPane.getChildren().add(column3);
        addButton(column1, '1');
        addButton(column2, '2');
        addButton(column1, '3');
        addButton(column2, '4');
        addButton(column1, '5');
        addButton(column2, '6');
        addButton(column1, '7');
        addButton(column2, '8');
        addButton(column1, '9');
        addButton(column2, '0');
        addButton(column3, '+');
        addButton(column3, '-');
        addButton(column3, '/');
        addButton(column3, 'x');
        addButton(column3, '=');
        Scene scene = new Scene(root, 175, 200);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    //Method to quickly add buttons to the different columns.
    public void addButton(VBox vb, char c){
        Button b = new Button(""+c);
        vb.getChildren().add(b);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                engine.input(c);
                display.setText(engine.getEquation());
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}