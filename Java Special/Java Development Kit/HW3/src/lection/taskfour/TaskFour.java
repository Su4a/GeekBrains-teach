package lection.taskfour;/*
Описать интерфейс Person с методами doWork() и haveRest(). Написать два класса работник и бездельник, реализующих интерфейс.
Работник работает, и не умеет бездельничать, в то время как бездельник не умеет работать, но умеет отдыхать.
Написать обобщённые классы Workplace и Club, содержащие массив из Person. В классах необходимо вызывать у всего массива людей вызывать соответствующие методы
 */

public class TaskFour {
    public static void main(String[] args) {
        Workplace<Person> w = new Workplace<>(new Worker(), new Idler());
        Club<Person> c = new Club<>(new Worker(), new Idler());
        w.work();
        c.chill();
    }
}
