package se.joakimliden;

import org.junit.jupiter.api.BeforeEach;

public class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5, 8);
    }
}
