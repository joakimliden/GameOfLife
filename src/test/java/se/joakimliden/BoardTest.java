package se.joakimliden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5, 8);
    }

    @Test
    void givenANewBoardShouldReturnNewGrid() {

        String expected = Arrays.deepToString(board.grid);
    }
}
