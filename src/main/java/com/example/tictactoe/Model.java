package com.example.tictactoe;

import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Model {
    private String[] buttons;
    private boolean isPlayerX;
    private boolean gameOver;
    private int humanScore;
    private int computerScore;
    RandomGenerator random = new Random();

    public Model(RandomGenerator random){
        this();
        this.random = random;
    }

    public Model() {
        this.buttons = new String[]{"","","","","","","","",""};
        this.isPlayerX = true;
        this.gameOver = false;
        this.humanScore = 0;
        this.computerScore = 0;
    }

    public void handleButtonClick(int index) {
        if (!gameOver && buttons[index].isEmpty()) {
            if (isPlayerX) {
                buttons[index] ="X";
            } else {
                buttons[index] ="O";
            }
            isPlayerX = !isPlayerX;

            checkForWinner();

            if (!gameOver && !isPlayerX) {
                makeComputerMove();
                checkForWinner();
            }
        }
    }

    private void makeComputerMove() {
        int row;

        do {
            row = random.nextInt(9);
        } while (!buttons[row].isEmpty());

        buttons[row] = "O";
        isPlayerX = true;
    }

    private void checkForWinner() {
        boolean isTie = false;
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i * 3 + 0], buttons[i * 3 + 1], buttons[i * 3 + 2]) ||
                    checkLine(buttons[0 * 3 + i], buttons[1 * 3 + i], buttons[2 * 3 + i])) {
                gameOver = true;
                break;
            }
        }

        if (!gameOver) {
            if (checkLine(buttons[0 * 3 + 0], buttons[1 * 3 + 1], buttons[2 * 3 + 2]) ||
                    checkLine(buttons[0 * 3 + 2], buttons[1 * 3 + 1], buttons[2 * 3 + 0])) {
                gameOver = true;
            } else {
                    isTie = Arrays.stream(buttons).noneMatch(String::isEmpty);
                }
                if (isTie) {
                    System.out.println("Game Over! It's a tie!");
                    gameOver = true;
                }
        }

        if (gameOver) {
            updateScores(isTie);
            if (!isTie) {
                System.out.println("Game Over! Winner: " + (isPlayerX ? "Computer" : "Player X"));
            }
        }
    }


    private boolean checkLine(String b1, String b2, String b3) {
        return !b1.isEmpty() && b1.equals(b2) && b2.equals(b3);
    }

    private void updateScores(boolean isTie) {
        if (!isTie) {
            if (isPlayerX) {
                computerScore++;
            } else {
                humanScore++;
            }
        }
    }

    public void restartGame() {
        for (int i = 0; i < 9; i++)
                buttons[i]="";

        isPlayerX = true;
        gameOver = false;
    }

    public void resetScore() {
        humanScore = 0;
        computerScore = 0;
    }

    public String getMark(int i) {
        return buttons[i];
    }

    public String humanScore() {
        return String.valueOf(humanScore);
    }

    public String computerScore() {
        return String.valueOf(computerScore);
    }
    public boolean isGameOver() {
        return gameOver;
    }
}
