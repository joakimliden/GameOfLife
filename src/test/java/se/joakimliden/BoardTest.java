package se.joakimliden;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    ConsolePrint consolePrint = new ConsolePrint();

    @Test
    void givenAnEmptyGridShouldReturnNewEmptyGrid() {
        Board board = new Board(5,8);
        int[][] inputGrid = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(inputGrid, board.nextGrid(inputGrid));
        /*Board board = new Board(5,8);

        assertEquals(board, board.nextBoard(board));*/
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

        assertEquals(0, board.countAliveNeighbours(0, 8));
    }

    @Test
    void checkingThatPrintBoardMethodHasExpectedOutcomeForEmptyBoard() {
        Board board = new Board(5,8);
        ConsolePrint consolePrint = new ConsolePrint();

        String expected =
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n";

        assertEquals(expected, consolePrint.printBoard(board));
    }

    @Test
    void checkingThatPrintBoardMethodHasExpectedOutcomeForBoardWithAliveCells() {
        Board board = new Board(5,8);
        ConsolePrint consolePrint = new ConsolePrint();

        board.setAlive(0, 0);
        board.setAlive(1, 1);
        board.setAlive(0, 2);
        String expected =
                "[*][ ][ ][ ][ ]\n" +
                "[ ][*][ ][ ][ ]\n" +
                "[*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ]\n";

        assertEquals(expected, consolePrint.printBoard(board));
    }

    @Test
    void livingCellWithLessThanTwoAliveNeighboursDieNextBoard() {
        Board inputBoard = new Board(5, 8);
//        Board expected = new Board(5, 8);

        inputBoard.setAlive(1, 1);
        int[][] nextGrid = inputBoard.nextBoard();

        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithMoreThanThreeAliveNeighboursDieNextBoard() {
        Board inputBoard = new Board(5, 8);

        inputBoard.setAlive(1, 0);
        inputBoard.setAlive(0, 1);
        inputBoard.setAlive(1, 1);
        inputBoard.setAlive(2, 1);
        inputBoard.setAlive(1, 2);

        int[][] nextGrid = inputBoard.nextBoard();
        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithTwoAliveNeighboursLivesNextBoard() {
        Board inputBoard = new Board(5, 8);

        inputBoard.setAlive(1, 0);
//        inputBoard.setAlive(0, 1);
        inputBoard.setAlive(1, 1);
//        inputBoard.setAlive(2, 1);
        inputBoard.setAlive(1, 2);

        consolePrint.printBoard(inputBoard);
        int[][] nextGrid = inputBoard.nextBoard();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void livingCellWithThreeAliveNeighboursLivesNextBoard() {
        Board inputBoard = new Board(5, 8);

        inputBoard.setAlive(1, 0);
        inputBoard.setAlive(0, 1);
        inputBoard.setAlive(1, 1);
//        inputBoard.setAlive(2, 1);
        inputBoard.setAlive(1, 2);

        consolePrint.printBoard(inputBoard);
        int[][] nextGrid = inputBoard.nextBoard();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void deadCellWithExactlyThreeAliveNeighboursLivesNextBoard() {
        Board inputBoard = new Board(5, 8);

        inputBoard.setAlive(1, 0);
        inputBoard.setAlive(0, 1);
        inputBoard.setAlive(1, 2);

        consolePrint.printBoard(inputBoard);
        int[][] nextGrid = inputBoard.nextBoard();
        assertEquals(1, nextGrid[1][1]);
        consolePrint.printBoard(inputBoard);
    }

    @Test
    void spinnerSpins() {
        Board inputBoard = new Board(5, 8);

        inputBoard.setAlive(2, 2);
        inputBoard.setAlive(2, 3);
        inputBoard.setAlive(2, 4);

        consolePrint.printBoard(inputBoard);

        inputBoard.nextBoard();
        consolePrint.printBoard(inputBoard);

        inputBoard.nextBoard();
        consolePrint.printBoard(inputBoard);

        inputBoard.nextBoard();
        consolePrint.printBoard(inputBoard);

        inputBoard.nextBoard();
        consolePrint.printBoard(inputBoard);

        inputBoard.nextBoard();
        consolePrint.printBoard(inputBoard);
    }

    /**
     *
     * 1. Levande cell med mindre än 2 levande grannar DÖR
     * 2. Levande cell med mer än 3 levande grannar DÖR
     * 3. Levande cell med 2 eller 3 levande grannar LEVER
     * 4. Död cell med exakt 3 levande grannar LEVER
     *
     **/
}
