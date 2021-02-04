public class Dog extends Animal {
    Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        Statistic.countDog++;
    }
}
