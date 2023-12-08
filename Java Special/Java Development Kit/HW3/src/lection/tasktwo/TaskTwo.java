package lection.tasktwo;/*
������� ����������� ��������� � ������ �� ������ �������. ��������� ������ �����
����������� ������� ����� ���� ������, ����� ������ ���������� � �������� ���������
 */

public class TaskTwo {
    Object[] arr;
    private int lenght;
    private int size;

    public TaskTwo() {
        size = 9;
        lenght = 0;
        arr = new Object[size + 1];
    }

    public <T> void add(T t) {
        if (lenght < size) {
            arr[lenght] = t;
            lenght++;
        }
    }

    public void remove() {
        if (arr[lenght] != null) {
            arr[lenght] = null;
            lenght--;
        }
    }

    public Object get() {
        return arr[lenght];
    }
}
