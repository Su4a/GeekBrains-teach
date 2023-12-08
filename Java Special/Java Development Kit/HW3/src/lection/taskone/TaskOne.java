package lection.taskone;

import java.io.DataInput;

/*
������� ���������� ����� � ����� ����������� (T, V, K). ����� �������� ��� ���������� ���� (T, V, K), �����������, ����������� �� ���� ��������� ���� (T, V, K), ������
������������ �������� ���� ����������. ������� �����, ��������� �� ������� �����
������� ��� ���� ���������� ������. �������� ����������� �� ��������� ����: T ������ ����������� ��������� Comparable (������ ��������, String), V ������ ����������� ��������� DataInput � ��������� ����� InputStream, K ������ ��������� �����
Number
 */
public class TaskOne<T extends Comparable, V extends DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    TaskOne(T  t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {return t;}
    public V getV() {return v;}
    public K getK() {return k;}

    public void info() {
        System.out.println(t.getClass().getSimpleName() + " " + v.getClass().getSimpleName() + " " + k.getClass().getSimpleName());
    }
}
