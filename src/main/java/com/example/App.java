package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlurType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    // prepare datas to do some calculating
    ArrayList<Double> numbers = new ArrayList<Double>();
    ArrayList<String> num2 = new ArrayList<String>();
    String btnValue = "";
    Label label = new Label("0");

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grd = new GridPane();
        VBox vbox = new VBox(10, grd);
        vbox.setAlignment(Pos.CENTER);

        scene = new Scene(vbox, 400, 450);

        // TextArea txtArea = new TextArea("Enter value");
        
        Font fbFont = new Font(50.00);
        label.setFont(fbFont);
        GridPane grdBtn = new GridPane();
        GridPane grdDel = new GridPane();

        // center buttons
        grdBtn.setAlignment(Pos.CENTER);
        grdDel.setAlignment(Pos.CENTER);

        // preparing margins
        Insets btnMargins = new Insets(2);

        // preparing buttuns
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button btnVir = new Button(".");
        Button btnPlus = new Button("+");
        Button btnMin = new Button("-");
        Button btnMul = new Button("*");
        Button btnDiv = new Button("/");
        Button btnEqu = new Button("=");
        Button btnDel = new Button("DEL");

        // add buttons the the GridPane
        grdBtn.add(btn7, 0, 0, 1, 1);
        grdBtn.add(btn8, 1, 0, 1, 1);
        grdBtn.add(btn9, 2, 0, 1, 1);
        grdBtn.add(btn4, 0, 1, 1, 1);
        grdBtn.add(btn5, 1, 1, 1, 1);
        grdBtn.add(btn6, 2, 1, 1, 1);
        grdBtn.add(btn1, 0, 2, 1, 1);
        grdBtn.add(btn2, 1, 2, 1, 1);
        grdBtn.add(btn3, 2, 2, 1, 1);
        grdBtn.add(btn0, 1, 3, 1, 1);
        grdBtn.add(btnVir, 2, 3, 1, 1);
        grdBtn.add(btnDiv, 3, 0, 1, 1);
        grdBtn.add(btnMul, 3, 1, 1, 1);
        grdBtn.add(btnMin, 3, 2, 1, 1);
        grdBtn.add(btnPlus, 3, 3, 1, 1);
        grdBtn.add(btnEqu, 0, 3, 1, 1);

        // prepare Del button
        grdDel.add(btnDel, 0, 0);
        btnDel.setPrefSize(100, 50);

        // set margins and size
        Button[] btnList = { btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0 };
        Button[] btnCalcList = { btnVir, btnPlus, btnMin, btnMul, btnDiv, btnEqu };

        // getting buttons values and add it to the arraylist
        for (Button button : btnList) {

            button.setId("btnId");
            GridPane.setMargin(button, btnMargins);
            button.setPrefSize(50, 50);

            // button 0-9 On Action
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    
                    if(label.getText().equals("0")){
                        label.setText(button.getText());
                    } else {
                        // changing the label text
                        label.setText(label.getText() + button.getText());
                    }
                }
            });
        }

        // setting up btnClicList + - / * = On Action
        for (Button button : btnCalcList) {

            button.setId("brnCalcId");
            GridPane.setMargin(button, btnMargins);
            button.setPrefSize(50, 50);

            // button btnCalc OnAction
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    numbers.add(Double.valueOf(label.getText()));
                    label.setText(label.getText() + " " + button.getText());

                }

            });

        }

        // setting up Del button OnAction 
        btnDel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (Double num : numbers) {
                        System.out.println(num + " \n");
                    }
                label.setText("0");
            }

        });

        // adding buttons to the GridPane children
        vbox.getChildren().addAll(label, grdBtn, grdDel);

        stage.setScene(scene);
        stage.setTitle("Calculatrice JavaFX");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}