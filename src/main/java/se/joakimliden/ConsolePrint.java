package se.joakimliden;

public record ConsolePrint() {

    public String printBoard(GameOfLife gameOfLife) {
        StringBuilder line = new StringBuilder();
        line.append("Generation " + gameOfLife.getGridGeneration() + "\n");
        for (int y = 0; y < gameOfLife.getHeight(); y++) {
            for (int x = 0; x < gameOfLife.getWidth(); x++) {
                if (gameOfLife.getGrid()[x][y] == 0) {
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