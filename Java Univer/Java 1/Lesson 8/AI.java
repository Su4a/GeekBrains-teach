import java.util.*;

class AI {
    Random random = new Random();
    private final char DOT;

    AI(char ch) {
        DOT = ch;
    }

    void turn(Field field) {
        int x, y;
        for (x = 0; x < TicTacToe.FIELD_SIZE; x++)
            for (y = 0; y < TicTacToe.FIELD_SIZE; y++) {
                if (field.isCellValid(x, y)) {
                    field.map[x][y] = field.AI_DOT;
                    if (field.checkWin(field.AI_DOT)) {
                        field.setDot(x, y, DOT);
                        return;
                    }
                    field.map[x][y] = field.EMPTY_DOT;
                }
                if (field.isCellValid(x, y)) {
                    field.map[x][y] = field.HUMAN_DOT;
                    if (field.checkWin(field.HUMAN_DOT)) {
                        field.setDot(x, y, DOT);
                        return;
                    }
                    field.map[x][y] = field.EMPTY_DOT;
                }
            }

        do {
            x = random.nextInt(field.getSize());
            y = random.nextInt(field.getSize());
        } while (!field.isCellValid(x, y));
        field.setDot(x, y, DOT);
    }
}