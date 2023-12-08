package lection.taskthree;/*
Ќаписать итератор по массиву. »тератор Ц это объект, осуществл€ющий движение по коллекци€м любого типа, содержащим любые типы данных. »тераторы обычно имеют только
два метода Ц проверка на наличие следующего элемента и переход к следующему элементу. Ќо также, особенно в других €зыках программировани€, возможно встретить итераторы, реализующие дополнительную логику
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
