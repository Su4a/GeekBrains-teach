public class Main {
    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        cat[0] = new Cat(35);
        cat[1] = new Cat(15);
        cat[2] = new Cat(32);
        cat[3] = new Cat(52);
        cat[4] = new Cat(23);

        Plate plate = new Plate(115);

        for (Cat i : cat) {
            i.eat(plate);
        }

        plate.increaseFood(55);

        for (Cat i : cat) i.info();
        plate.info();
    }
}
