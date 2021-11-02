package se.joakimliden;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void givenAnEmptyBoardShouldReturnNewEmptyBoard() {
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expected, Board.nextBoard(expected));
    }

    @Test
    void givenACellIsSetToAliveItIsAlive() {
        Board board = new Board(5, 8);

        assertEquals(1, board.setAlive(2, 2));
    }
}
