//1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
public class Main {
    public static void main(String[] args) {
        System.out.println("Test fo Lesson 1");
        createVariables();
        System.out.println(doSumFloat(3,7,4,3));
        System.out.println(doSumCheck(5,11));
        doCheckPositiveVariables(15);
        System.out.println(ifNegativeVariables(5));
        doHello("Agula");
        doCheckFoLeapYear(2021);
    }
//2. Создать переменные всех пройденных типов данных и инициализировать их значения.
    public static void createVariables() {
        byte createByte = 127;
        short createShort = 32767;
        int createInt = 2147483647;
        long createLong = 9223372036854775807L;
        float createFloat = 3.4E+38f;
        double createDouble = 1.7E+308;
        boolean createBoolean = true;
        char createChar = 'C';
        String createString = "String";
    }
//3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float doSumFloat(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
//4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean doSumCheck(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }
//5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void doCheckPositiveVariables(int a) {
        System.out.println((a >= 0) ? "Положительное число" : "Отрицательное число");
    }
//6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    public  static boolean ifNegativeVariables(int a) {
        return (a < 0) ? true : false;
    }
//7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void doHello(String name) {
        System.out.println("Hello " + name);
    }
//8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void doCheckFoLeapYear(int year) {
        System.out.println((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "Високосный год" : "Невисокосный год");
    }
}
