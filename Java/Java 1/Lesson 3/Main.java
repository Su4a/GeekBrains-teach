import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //startGameOne();
        //startGameTwo();
    }

    public static void startGameOne() {
        boolean fromExitIsGame = true;
        do {
            System.out.println("Добро пожаловать в игру угадай число. Угадай с 3 раз число от 0 до 9");
            int saveIntIsProgramm = returnRandomInt(10);
            int saveLife = 3;
            while (saveLife > 0) {
                int parrowInt = returnScannerInt();
                if (saveIntIsProgramm == parrowInt) {
                    System.out.println("Молодец, вы угадали число");
                    fromExitIsGame = isReturnGame();
                    break;
                }else{
                    saveLife --;
                    if (parrowInt > saveIntIsProgramm) System.out.println("Загаданное вами число больше, осталось попыток " + saveLife);
                    else System.out.println("Загаданное вами число меньше осталось попыток " + saveLife);
                }
                if (saveLife == 0) {
                    System.out.println("Вы проиграли");
                    isReturnGame();
                }
            }
        }while (fromExitIsGame);
        System.out.println("Спасибо, что поиграли в угадай число");
    }
    public static void startGameTwo() {
        boolean fromExitIsGame = true;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Добро пожаловать в игру поле чудес. Игра загадывает слово, попытайтесь угадать его");
        String makeAWord = words[returnRandomInt(words.length)];
        String checkWord;
        String reservResult;
        char[] saveReservResoult = new char[makeAWord.length()];
        String saveStringReservResoult;
        for (int i = 0; i < saveReservResoult.length; i++) saveReservResoult[i] = '#';
        int shortIntWord;
        do {
            String enteredWord = returnScannerLine();
            if (makeAWord.length() < enteredWord.length()) shortIntWord = makeAWord.length();
            else shortIntWord = enteredWord.length();
            reservResult = "";
            saveStringReservResoult = "";
            for (int i = 0; i < shortIntWord; i++) {
                if (makeAWord.charAt(i) == enteredWord.charAt(i)) {
                    reservResult += makeAWord.charAt(i);
                    saveReservResoult[i] = (makeAWord.charAt(i));
                }else reservResult += "#";
            }
            for (int i = 0; i < shortIntWord; i++) {
                if (reservResult.charAt(i) == makeAWord.charAt(i)) {
                    saveReservResoult[i] = reservResult.charAt(i);
                }
            }
            for (int i = 0; i < saveReservResoult.length; i++) saveStringReservResoult += saveReservResoult[i];
            checkWord = saveStringReservResoult;
            for (int i = 0; i < 15 - shortIntWord; i++) {
                reservResult += "#";
                saveStringReservResoult += "#";
            }
            System.out.println(saveStringReservResoult);
            if (checkWord.equals(makeAWord)) {
                System.out.println("Поздравляю, вы угадали слово, загаданное слово: " + checkWord);
                fromExitIsGame = false;
            }
        }while (fromExitIsGame);
    }

    public static int returnRandomInt(int n) {
        Random randomInt = new Random();
        return  randomInt.nextInt(n);
    }
    public static int returnScannerInt() {
        System.out.println("Введите число");
        Scanner scanInt = new Scanner(System.in);
        while (true) {
            if (scanInt.hasNextInt()) return scanInt.nextInt();
            System.out.println("Введено неверное число");
            scanInt.nextLine();
        }
    }
    public static String returnScannerLine() {
        System.out.println("Введите слово");
        Scanner scanStr = new Scanner(System.in);
        return  scanStr.nextLine();
    }
    public static boolean isReturnGame() {
        System.out.println("Хотите ли повторить игру? 1 - да, 0 - нет");
        if (returnScannerInt() == 0) return false;
        return true;
    }
}
