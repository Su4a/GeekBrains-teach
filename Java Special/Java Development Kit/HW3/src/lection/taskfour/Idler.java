package lection.taskfour;

public class Idler implements Person {

    @Override
    public void doWork() {
        System.out.println("No");
    }

    @Override
    public void haveRest() {
        System.out.println("Chill!");
    }
}
