public abstract class Fruit {
    private final float weight;
    private final String name;

    public Fruit(float weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
