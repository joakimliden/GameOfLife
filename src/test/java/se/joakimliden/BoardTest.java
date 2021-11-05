package se.joakimliden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5, 8);
    }

    @Test
    void givenANewBoardShouldReturnNewGrid() {

        String expected = Arrays.deepToString(board.grid);
        String actual = Arrays.deepToString(board.nextGrid());
        assertEquals(expected, actual);
    }

    @Test
    void givenANewBoardShouldNotReturnExactlyTheSameGrid() {
        assertNotEquals(board.grid, board.nextGrid());
    }
}
