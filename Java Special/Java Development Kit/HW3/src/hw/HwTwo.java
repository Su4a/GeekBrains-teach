/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов – два
числа разного типа, над которыми должна быть произведена операция.

 */

package hw;

public class HwTwo {
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
        return num1.doubleValue() * num2.doubleValue();
    }
    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        return num1.doubleValue() / num2.doubleValue();
    }
    public static <T extends Number, U extends Number> double substrace(T num1, U num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
