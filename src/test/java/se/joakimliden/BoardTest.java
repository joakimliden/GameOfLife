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

    @Test
    void settingACellToAliveSetsItAlive() {

        assertEquals(1, board.setAlive(2, 2));
    }

    @Test
    void givenACellHasOneLiveNeighboursItCountsOneAliveNeighbours() {

        board.setAlive(2, 2);

        assertEquals(1, board.aliveNeighbours(2, 3));
    }

    @Test
    void givenACellHasTwoLiveNeighboursItCountsTwoAliveNeighbours() {

        board.setAlive(2, 2);
        board.setAlive(2, 4);

        assertEquals(2, board.aliveNeighbours(2, 3));
    }

    @Test
    void checkingStateForCellOutsideGridShouldReturn0() {

        assertEquals(0, board.getState(6, -1));
    }

    @Test
    void checkingStateForAliveCellShouldReturn1() {

        board.setAlive(2, 2);

        assertEquals(1, board.getState(2, 2));
    }

    @Test
    void checkingStateForDeadCellShouldReturn0() {
        Board board = new Board(5, 8);

        assertEquals(0, board.getState(2, 2));
    }

    @Test
    void checkingForAliveNeighboursOutsideOfGridShouldReturn0() {

        assertEquals(0, board.aliveNeighbours(0, 8));
    }

    @Test
    void livingCellWithTwoAliveNeighboursLivesNextGrid() {

        board.setAlive(1, 0);
        board.setAlive(1, 1);
        board.setAlive(1, 2);

        int[][] nextGrid = board.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void livingCellWithThreeAliveNeighboursLivesNextGrid() {
        Board board = new Board(5, 8);

        board.setAlive(1, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 1);
        board.setAlive(1, 2);

        int[][] nextGrid = board.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void livingCellWithLessThanTwoAliveNeighboursDieNextGrid() {
        Board board = new Board(5, 8);

        board.setAlive(1, 1);
        int[][] nextGrid = board.nextGrid();

        assertEquals(0, nextGrid[1][1]);
    }
}
