package se.joakimliden;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    ConsolePrint consolePrint = new ConsolePrint();

    @Test
    void givenAnEmptyGridShouldReturnNewEmptyGrid() {
        GameOfLife gameOfLife = new GameOfLife(5,8);

        var expected = Arrays.deepToString(gameOfLife.getGrid());
        var actual = Arrays.deepToString(gameOfLife.nextGrid());
        assertEquals(expected, actual);
    }

    @Test
    void givenEmptyGridShouldNotReturnExactlyTheSameGrid() {
        GameOfLife gameOfLife = new GameOfLife(5,8);
        assertNotEquals(gameOfLife.getGrid(), gameOfLife.nextGrid());
    }

    @Test
    void givenACellIsSetToAliveItIsAlive() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        assertEquals(1, gameOfLife.setAlive(2, 2));
    }

    @Test
    void givenACellHasTwoLiveNeighboursItCountsTwoAliveNeighbours() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        gameOfLife.setAlive(2, 2);
        gameOfLife.setAlive(2, 4);

        assertEquals(2, gameOfLife.aliveNeighbours(2, 3));
    }

    @Test
    void checkingStateForCellOutsideGridShouldReturn0() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        assertEquals(0, gameOfLife.getState(6, -1));
    }

    @Test
    void checkingStateForAliveCellShouldReturn1() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        gameOfLife.setAlive(2, 2);

        assertEquals(1, gameOfLife.getState(2, 2));
    }

    @Test
    void checkingStateForDeadCellShouldReturn0() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        assertEquals(0, gameOfLife.getState(2, 2));
    }

    @Test
    void checkingForAliveNeighboursOutsideOfGridShouldReturn0() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);

        assertEquals(0, gameOfLife.aliveNeighbours(0, 8));
    }

    @Test
    void livingCellWithLessThanTwoAliveNeighboursDieNextBoard() {
        GameOfLife inputGameOfLife = new GameOfLife(5, 8);

        inputGameOfLife.setAlive(1, 1);
        int[][] nextGrid = inputGameOfLife.nextGrid();

        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithMoreThanThreeAliveNeighboursDieNextBoard() {
        GameOfLife inputGameOfLife = new GameOfLife(5, 8);

        inputGameOfLife.setAlive(1, 0);
        inputGameOfLife.setAlive(0, 1);
        inputGameOfLife.setAlive(1, 1);
        inputGameOfLife.setAlive(2, 1);
        inputGameOfLife.setAlive(1, 2);

        int[][] nextGrid = inputGameOfLife.nextGrid();
        assertEquals(0, nextGrid[1][1]);
    }

    @Test
    void livingCellWithTwoAliveNeighboursLivesNextBoard() {
        GameOfLife inputGameOfLife = new GameOfLife(5, 8);

        inputGameOfLife.setAlive(1, 0);
        inputGameOfLife.setAlive(1, 1);
        inputGameOfLife.setAlive(1, 2);

        int[][] nextGrid = inputGameOfLife.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void livingCellWithThreeAliveNeighboursLivesNextBoard() {
        GameOfLife inputGameOfLife = new GameOfLife(5, 8);

        inputGameOfLife.setAlive(1, 0);
        inputGameOfLife.setAlive(0, 1);
        inputGameOfLife.setAlive(1, 1);
        inputGameOfLife.setAlive(1, 2);

        int[][] nextGrid = inputGameOfLife.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void deadCellWithExactlyThreeAliveNeighboursLivesNextBoard() {
        GameOfLife inputGameOfLife = new GameOfLife(5, 8);

        inputGameOfLife.setAlive(1, 0);
        inputGameOfLife.setAlive(0, 1);
        inputGameOfLife.setAlive(1, 2);

        int[][] nextGrid = inputGameOfLife.nextGrid();
        assertEquals(1, nextGrid[1][1]);
    }

    @Test
    void boardGenerationIncreasesByOneEachTimeNextBoardRuns() {
        GameOfLife gameOfLife = new GameOfLife(5, 8);
        int before = gameOfLife.getGridGeneration();
        gameOfLife.nextGrid();
        int after = gameOfLife.getGridGeneration();
        assertEquals(before + 1, after);
    }

    @Test
    void checkingThatPrintBoardMethodHasExpectedOutcomeForEmptyBoard() {
        GameOfLife gameOfLife = new GameOfLife(5,8);

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

        assertEquals(expected, consolePrint.printBoard(gameOfLife));
    }

    @Test
    void checkingThatPrintBoardMethodHasExpectedOutcomeForBoardWithAliveCells() {
        GameOfLife gameOfLife = new GameOfLife(5,8);

        gameOfLife.setAlive(0, 0);
        gameOfLife.setAlive(1, 1);
        gameOfLife.setAlive(0, 2);
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

        assertEquals(expected, consolePrint.printBoard(gameOfLife));
    }
}
