public class CalculatorArr {

    public boolean checkArrFoSize(String[][] arr, int arrLenght) {
        if (arr.length != arrLenght) {
            throw new MyArraySizeException("Размер массива не равен " + arrLenght);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arrLenght) {
                throw new MyArraySizeException("Размер массива не равен " + arrLenght);
            }
        }
        return true;
    }

    public int sumArr(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String message = String.format("В массиве [%s][%s] содержится не число", i , j);
                    throw new MyArrayDataException(message);
                }
            }
        }
        return sum;
    }
}