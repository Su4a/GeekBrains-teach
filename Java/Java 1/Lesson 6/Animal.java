public abstract class Animal {
    private String name;
    private int maxRun;
    private int maxSwim;

    Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        Statistic.countAnimals++;
    }

    protected void doRun(int distance) {
        if (maxRun >= distance) System.out.println(name + " пробежал дистанцию на " + distance + " метров");
        else System.out.println(name + " не смог пробежать дистанцию на " + distance + " метров");
    }

    protected void doSwim(int distance) {
        if (maxSwim >= distance) System.out.println(name + " проплыл дистанцию на " + distance + " метров");
        else System.out.println(name + " не смог проплыть дистанцию на " + distance + " метров");
    }
}
