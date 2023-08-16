package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    Model model = new Model();
    @FXML
    private Label label;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //TODO
    }

    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            label.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        label.setText(label.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")){
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(label.getText());
            label.setText("");
        } else {
            if (operator.isEmpty())
                return;
            long number2 = Long.parseLong(label.getText());

            float output = model.calculator(number1, number2, operator);
            label.setText(String.valueOf(output));
            operator = ""; // Reset operator after calculation
            start = true; // Allow new calculation to start
        }
    }

    @FXML
    public void processClear(ActionEvent event) {
        label.setText("0");
        operator = "";
        start = true;
    }

    @FXML
    public void processEquals(ActionEvent event) {
        if (!operator.isEmpty()) {
            long number2 = Long.parseLong(label.getText());
            float output = model.calculator(number1, number2, operator);
            label.setText(String.valueOf(output));
            operator = ""; // Reset operator after calculation
            start = true; // Allow new calculation to start
        }
    }
}
