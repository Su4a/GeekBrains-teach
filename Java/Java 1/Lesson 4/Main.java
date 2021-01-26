import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static int size;
    static int dots_to_win;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    public static void main(String[] args) {
        System.out.println("Введите размер поля");
        size = returnInt();
        System.out.println("Введите число для победной линии");
        dots_to_win = returnInt();
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin()) {
                System.out.println("Победил человек");
                printMap();
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                printMap();
                break;
            }
            aiTurn();
            if (checkWin()) {
                System.out.println("Победил AI");
                printMap();
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                printMap();
                break;
            }
            printMap();
        }
    }

    public static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < map.length; i++) Arrays.fill(map[i], DOT_EMPTY);
    }
    public static void printMap() {
        for (int i = 0; i < map.length + 1; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y от 1 до " + size);
            x = returnInt() - 1;
            y = returnInt() - 1;
        }while(!isCellValid(x,y));
        map[y][x] = DOT_X;
    }
    public static void aiTurn() {
        int x;
        int y;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (isCellValid(i, j)) {
                    map[j][i] = DOT_O;
                    if (checkWin()) {
                        map[j][i] = DOT_O;
                        System.out.println("Компьютер сходил в точку " + (i + 1) + " " + (j + 1));
                        return;
                    }
                    map[j][i] = DOT_EMPTY;
                }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (isCellValid(i, j)) {
                    map[j][i] = DOT_X;
                    if (checkWin()) {
                        map[j][i] = DOT_O;
                        System.out.println("Компьютер сходил в точку " + (i + 1) + " " + (j + 1));
                        return;
                    }
                    map[j][i] = DOT_EMPTY;
                }
        do {
            x = returnRandomInt(size);
            y = returnRandomInt(size);
        } while (!isCellValid(x,y));
        map[y][x] = DOT_O;
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static boolean checkWin() {
        int winCase = 0;
        char startWinChar = DOT_EMPTY;
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != DOT_EMPTY && winCase == 0) startWinChar = map[i][j];
                if (map[i][j] != DOT_EMPTY && map[i][j] == startWinChar) winCase++;
                else winCase = 0;
                if (winCase == dots_to_win) return true;
            }
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] != DOT_EMPTY && winCase == 0) startWinChar = map[j][i];
                if (map[j][i] != DOT_EMPTY && map[j][i] == startWinChar) winCase++;
                else winCase = 0;
                if (winCase == dots_to_win) return true;
            }
        return false;
    }
    static boolean isMapFull() {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                if (map[i][j] == DOT_EMPTY) return false;
        return true;
    }
    public static int returnInt() {
        Scanner scanInt = new Scanner(System.in);
        while (true) {
            if (scanInt.hasNextInt()) return scanInt.nextInt();
            System.out.println("Введено не число");
            scanInt.nextLine();
        }
    }
    public static int returnRandomInt(int a) {
        Random rndInt = new Random();
        return rndInt.nextInt(a);
    }
}