package lection.taskthree;/*
�������� �������� �� �������. �������� � ��� ������, �������������� �������� �� ���������� ������ ����, ���������� ����� ���� ������. ��������� ������ ����� ������
��� ������ � �������� �� ������� ���������� �������� � ������� � ���������� ��������. �� �����, �������� � ������ ������ ����������������, �������� ��������� ���������, ����������� �������������� ������
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TaskThree<T> implements Iterator<T> {
    private T[] arr;
    private int index = 0;

    public TaskThree(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return arr[index++];
    }
}
