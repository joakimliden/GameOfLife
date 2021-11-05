package se.joakimliden;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    ConsolePrint consolePrint = new ConsolePrint();


    @Test
    void givenANewBoardShouldReturnNewGrid() {
        Board board = new Board(5,8);

        String expected = Arrays.deepToString(board.getGrid());
        String actual = Arrays.deepToString(board.nextGrid());
        assertEquals(expected, actual);
    }

    @Test
    void givenANewBoardShouldNotReturnExactlyTheSameGrid() {
        Board board = new Board(5,8);
        assertNotEquals(board.getGrid(), board.nextGrid());
    }

    @Test
    void settingACellToAliveSetsItAlive() {
        Board board = new Board(5, 8);

        assertEquals(1, board.setAlive(2, 2));
    }

    @Test
    void givenACellHasOneLiveNeighboursItCountsOneAliveNeighbours() {
        Board board = new Board(5, 8);

        board.setAlive(2, 2);

        assertEquals(1, board.aliveNeighbours(2, 3));
    }

    @Test
    void givenACellHasTwoLiveNeighboursItCountsTwoAliveNeighbours() {
        Board board = new Board(5, 8);

        board.setAlive(2, 2);
        board.setAlive(2, 4);

        assertEquals(2, board.aliveNeighbours(2, 3));
    }

    @Test
    void checkingStateForCellOutsideGridShouldReturn0() {
        Board board = new Board(5, 8);

        assertEquals(0, board.getState(6, -1));
    }

    @Test
    void checkingStateForAliveCellShouldReturn1() {
        Board board = new Board(5, 8);

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
        Board board = new Board(5, 8);

        assertEquals(0, board.aliveNeighbours(0, 8));
    }

    @Test
    void livingCellWithLessThanTwoAliveNeighboursDieNextGrid() {
        Board board = new Board(5, 8);

        board.setAlive(1, 1);
        int[][] nextGrid = board.nextGrid();

        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithMoreThanThreeAliveNeighboursDieNextGrid() {
        Board board = new Board(5, 8);

        board.setAlive(1, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 1);
        board.setAlive(2, 1);
        board.setAlive(1, 2);

        int[][] nextGrid = board.nextGrid();
        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithTwoAliveNeighboursLivesNextGrid() {
        Board board = new Board(5, 8);

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
    void deadCellWithExactlyThreeAliveNeighboursLivesNextGrid() {
        Board board = new Board(5, 8);

        board.setAlive(1, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 2);

        int[][] nextGrid = board.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void gridGenerationIncreasesByOneEachTimeNextGridRuns() {
        Board board = new Board(5, 8);

        int before = board.getGridGeneration();

        board.nextGrid();
        int after = board.getGridGeneration();
        assertEquals(before + 1, after);
    }

    @Test
    void checkingThatPrintGridMethodHasExpectedOutcomeForEmptyBoard() {
        Board board = new Board(5, 8);

        String expected =
                """
                        Generation 1
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        """;

        assertEquals(expected, consolePrint.printGrid(board));
    }

    @Test
    void checkingThatPrintGridMethodHasExpectedOutcomeForBoardWithAliveCells() {
        Board board = new Board(5,8);

        board.setAlive(0, 0);
        board.setAlive(1, 1);
        board.setAlive(0, 2);
        String expected =
                """
                        Generation 1
                        [*][ ][ ][ ][ ]
                        [ ][*][ ][ ][ ]
                        [*][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        [ ][ ][ ][ ][ ]
                        """;

        assertEquals(expected, consolePrint.printGrid(board));
    }
}
