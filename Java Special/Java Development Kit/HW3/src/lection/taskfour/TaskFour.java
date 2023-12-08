package lection.taskfour;/*
������� ��������� Person � �������� doWork() � haveRest(). �������� ��� ������ �������� � ����������, ����������� ���������.
�������� ��������, � �� ����� �������������, � �� ����� ��� ���������� �� ����� ��������, �� ����� ��������.
�������� ���������� ������ Workplace � Club, ���������� ������ �� Person. � ������� ���������� �������� � ����� ������� ����� �������� ��������������� ������
 */

public class TaskFour {
    public static void main(String[] args) {
        Workplace<Person> w = new Workplace<>(new Worker(), new Idler());
        Club<Person> c = new Club<>(new Worker(), new Idler());
        w.work();
        c.chill();
    }
}
