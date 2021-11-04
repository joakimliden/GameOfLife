package se.joakimliden;

public record ConsolePrint() {

    public String printBoard(Board board) {
        StringBuilder line = new StringBuilder();
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