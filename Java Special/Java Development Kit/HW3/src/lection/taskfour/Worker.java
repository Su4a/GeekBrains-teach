package lection.taskfour;

public class Worker implements Person {

    @Override
    public void doWork() {
        System.out.println("Work");
    }

    @Override
    public void haveRest() {
        System.out.println("What?");
    }
}
