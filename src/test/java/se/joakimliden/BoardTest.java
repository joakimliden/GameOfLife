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

    @Test
    void givenACellHasTwoLiveNeighboursItCountsTwoAliveNeighbours() {
        Board board = new Board(5, 8);

        board.setAlive(2, 2);
        board.setAlive(2, 4);

        assertEquals(2, board.countAliveNeighbours(2, 3));
    }

    @Test
    void checkingStateForCellOutsideGridShouldReturnZero() {
        Board board = new Board(5, 8);

        assertEquals(0, board.getState(6, -1));
    }

}
