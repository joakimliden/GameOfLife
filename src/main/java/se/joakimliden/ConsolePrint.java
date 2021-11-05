package se.joakimliden;

public class ConsolePrint {
    public String printGrid(Board board) {
        StringBuilder line = new StringBuilder();
        line.append("Generation " + board.getGridGeneration() + "\n");
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                if (board.getGrid()[x][y] == 0) {
                    line.append("[ ]");
                } else {
                    line.append("[*]");
                }
            }
            line.append("\n");
        }
        System.out.println(line);
        return line.toString();
    }
}
