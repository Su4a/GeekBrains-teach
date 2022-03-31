package obstacle;

import participant.Jumpable;
import participant.Participant;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Participant participant) {
        if (participant instanceof Jumpable) {                                                                          //Сравнение типов participant и Jumpable
            return ((Jumpable) participant).jump(height);                                                                      //Cast партикипанта к интерфейсу бегу. Выволнение возможно т.к. было сравнение типов Participant и Runnable, при котором сравнение будет true
        }
        System.out.println(participant.getClass().getSimpleName() + " cannot jump");
        return false;
    }
}
