public class Main {
    static int sumArr = 0;

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        CalculatorArr calcArr = new CalculatorArr();

        try {
            if (calcArr.checkArrFoSize(arr, 4)) {
                sumArr = calcArr.sumArr(arr);
            }
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("Проверка рабоыт программы после ошибок");
    }
}