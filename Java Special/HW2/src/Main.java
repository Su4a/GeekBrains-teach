/*
Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) ? 3 countEvens([2, 2, 0]) ? 3 countEvens([1, 3, 5]) ? 0
Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(countEvent(new int[]{2, 1, 2, 3, 4}));
        System.out.println(minOrMax(new int[]{2,1,2,3,4,10}));
        System.out.println(isTwoZeroNumber(new int[]{2,0,1,0,4,10,5,7,0,0}));
    }

    public static int countEvent(int... arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) count++;
        }
        return count;
    }

    public static int minOrMax(int... arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        return max - min;
    }

    public static boolean isTwoZeroNumber(int... arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
            else countZero = 0;
            if (arr[i] == 0 && countZero == 2) return true;
        }
        return false;
    }
}