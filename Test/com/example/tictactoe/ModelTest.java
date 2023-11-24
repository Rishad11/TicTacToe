package com.example.tictactoe;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @Test
    void playerXWinsDiagonally(){
        Model model = new Model(new MyRandomFake(List.of(0,5)));

        model.handleButtonClick(2);
        model.handleButtonClick(4);
        model.handleButtonClick(6);

        assertEquals("1",model.humanScore());
        assertEquals("0",model.computerScore());
    }

    @Test
    void playerXWinsHorizontally(){
        Model model = new Model(new MyRandomFake(List.of(0,1)));

        model.handleButtonClick(3);
        model.handleButtonClick(4);
        model.handleButtonClick(5);

        assertEquals("1",model.humanScore());
        assertEquals("0",model.computerScore());
    }
    @Test
    void gameIsFinished() {
        Model model = new Model(new MyRandomFake(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8)));

        for (int i = 0; i < 9; i++) {
            model.handleButtonClick(i);
        }

        assertTrue(model.isGameOver());
    }
    @Test
    void validMoves() {
        Model model = new Model(new MyRandomFake(List.of(0, 3, 1, 4, 2)));

        model.handleButtonClick(0);
        model.handleButtonClick(3);
        model.handleButtonClick(1);

        // Ogiltig move
        model.handleButtonClick(0);

        // Giltig move
        model.handleButtonClick(4);


        assertEquals("X", model.getMark(0));
        assertEquals("O", model.getMark(3));
        assertEquals("X", model.getMark(1));
        assertEquals("O", model.getMark(4));
    }

}