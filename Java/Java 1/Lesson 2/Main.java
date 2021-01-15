import java.util.Arrays;

public class Main {
    static int[] createArrForTestOne = {1,1,0,0,1,0,1,1,0,0};
    static int[] createArrForTestTwo = new int[8];
    static int[] createArrForTestThree = {1,5,3,2,11,4,5,2,4,8,9,1};
    static int[][] createArrForTestFour = new int[5][5];
    static int[] createArrForTestFive = {5,2,9,15,-7,-2,-7};
    static int[] createHelpArrForTestFive = new int[2];
    static int[] createArrForTestSix = {3,5,8};
    static int[] createArrForTestSeven = {2,8,1,4,0,6,4};

    public static void main(String[] args) {
        //info();
        startTest();
        info();
    }
    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
    public static void doInvertIntArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
    }
    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
    public static void doFillArrCase(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++, j = i * 3)
            arr[i] = j;
    }
    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
    public static void ifNumbersArrLessFoSixDoMultiplyByTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] *= 2;
    }
    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    public static void doFillArrDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (i == j) {
                    arr[i][j] = 1;
                    arr[i][arr.length - i - 1] = 1;
                }
    }
    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    public static void doFindMaxOrMin(int[] arr) {
        int[] arrMaxMinCase = new int[2];
        arrMaxMinCase[0] = arr[0];
        arrMaxMinCase[1] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            arrMaxMinCase[0] = Math.max(arr[i], arrMaxMinCase[0]);
            arrMaxMinCase[1] = Math.min(arr[i], arrMaxMinCase[1]);
        }
        createHelpArrForTestFive = arrMaxMinCase;
    }
    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    //если в массиве есть место, в котором сумма левой и правой части массива равны
    public static boolean checkArrSumBalance(int[] arr) {
        int sumArr = 0, sumLeft = 0;
        for (int i = 0; i < arr.length; i++) sumArr += arr[i];
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            if (sumLeft*2 == sumArr)
                return true;
        }
        return false;
    }
    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным)
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично
    public static void doShiftArrLeftOrRight(int[] arr, int n) {
        int shift = n % arr.length;
        if (n > 0) {
            int shiftCase;
            for (int i = 0; i < shift; i++) {
                shiftCase = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = shiftCase;
            }
        }
        if (n < 0) {
            shift *= (-1);
            int shiftCase;
            for (int i = 0; i < shift; i++) {
                shiftCase = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = shiftCase;
            }
        }
    }

    //Test method's
    public static void startTest() {
        doInvertIntArr(createArrForTestOne);
        doFillArrCase(createArrForTestTwo);
        ifNumbersArrLessFoSixDoMultiplyByTwo(createArrForTestThree);
        doFillArrDiagonal(createArrForTestFour);
        doFindMaxOrMin(createArrForTestFive);
        checkArrSumBalance(createArrForTestSix);
        doShiftArrLeftOrRight(createArrForTestSeven, -7);
    }
    public static void info() {
        System.out.println("Первое задание");
        System.out.println(Arrays.toString(createArrForTestOne));
        System.out.println("Второе задание");
        System.out.println(Arrays.toString(createArrForTestTwo));
        System.out.println("Третье задание");
        System.out.println(Arrays.toString(createArrForTestThree));
        System.out.println("Четвертое задание");
        doToStringTwoArr(createArrForTestFour);
        System.out.println("Пятое задание");
        System.out.println(Arrays.toString(createHelpArrForTestFive));
        System.out.println("Шестое задание");
        System.out.println(checkArrSumBalance(createArrForTestSix));
        System.out.println("Седьмое задание");
        System.out.println(Arrays.toString(createArrForTestSeven));
        System.out.println("--------------------------------------------------------------");

    }
    public static void doToStringTwoArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}