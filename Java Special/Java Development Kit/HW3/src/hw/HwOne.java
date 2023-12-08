/*
Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции
 */

package hw;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

public class HwOne<T> implements Iterable<T> {
    Object[] arr;
    private int size;
    int count;
    ArrayIterator iter;

    public HwOne() {
        size = 9;
        count = 0;
        arr = new Object[size + 1];
        this.iter = new ArrayIterator();
    }

    class ArrayIterator implements Iterator<T> {
        private  int index = 0;


        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (T) arr[index++];
        }
    }

    public void add(T t) {
        if (count == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[count++] = t;
    }

    public T remove() {
        if (count == 0) throw new NoSuchElementException();
        --count;
        T temp = (T) arr[count];
        arr[count] = null;
        return temp;
    }

    public Object get() {
        return arr[count];
    }

    @Override
    public Iterator<T> iterator() {
        return iter;
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
