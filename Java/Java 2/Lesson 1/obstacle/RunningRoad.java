package obstacle;

import participant.Participant;
import participant.Runnable;

public class RunningRoad implements Obstacle {
    private final int width;

    public RunningRoad(int width) {
        this.width = width;
    }

    @Override
    public boolean doIt(Participant participant) {
        if (participant instanceof Runnable) {                                                                          //Сравнение типов participant и Runnable
            return ((Runnable) participant).run(width);                                                                 //Cast партикипанта к интерфейсу бегу. Выволнение возможно т.к. было сравнение типов Participant и Runnable, при котором сравнение будет true
        }
        System.out.println(participant.getClass().getSimpleName() + " cannot run");
        return false;
    }
}
