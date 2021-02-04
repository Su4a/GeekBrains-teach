public class Cat extends Animal {
    Cat(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        Statistic.countCat++;
    }
}
