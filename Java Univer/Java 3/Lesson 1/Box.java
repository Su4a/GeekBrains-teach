import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Box<T>{
    private float weight;
    private final Set<T> fruit = new HashSet<>();

    public void add(T t) {
        if (t instanceof Fruit) {
            if (fruit.add(t)) weight += ((Fruit) t).getWeight();
        }
    }

    public T delite() {
        Iterator<T> iterator = fruit.iterator();
        T type = null;
        if (iterator.hasNext()) {
            type = iterator.next();
            if (type instanceof Fruit) weight -= ((Fruit) type).getWeight();
            iterator.remove();
        }
        return type;
    }

    public void shiftFruitBox(Box<T> t) {
        T type = delite();
        if (type != null) {
            t.add(type);
        }
    }

    public boolean compare(Box box) {
        return this.weight == box.getWeight();
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(fruit);
    }
}
