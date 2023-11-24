package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, restartButton, resetButton;

    @FXML
    private TextField Human_score, Computer_score;

    private Model model;

    Button[] buttons;

    public void initialize() {
        buttons = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        model = new Model();
        initializeButtons();
    }

    private void initializeButtons() {
        for (Button button : buttons)
                button.setOnAction(event -> handleButtonClick(button));
        restartButton.setOnAction(event -> restartGame());
        resetButton.setOnAction(event -> resetScore());
    }

    private void resetScore() {
        model.resetScore();
        updateView();
    }

    private void restartGame() {
        model.restartGame();
        updateView();
    }

    private void handleButtonClick(Button button) {
        model.handleButtonClick(Integer.parseInt(button.getId().substring(6))-1);
        updateView();
    }

    private void updateView() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(model.getMark(i));
        }
        Human_score.setText("Player X score: " + model.humanScore());
        Computer_score.setText("Computer score: " + model.computerScore());
    }
}
