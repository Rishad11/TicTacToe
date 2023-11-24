package com.example.tictactoe;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void playerXWinsDiagonaly(){
        Model model = new Model(new MyRandomFake(List.of(0,5)));

        model.handleButtonClick(2);
        model.handleButtonClick(4);
        model.handleButtonClick(6);

        assertEquals("1",model.humanScore());
        assertEquals("0",model.computerScore());
    }

}