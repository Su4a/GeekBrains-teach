import obstacle.Obstacle;
import obstacle.RunningRoad;
import obstacle.Wall;
import participant.Cat;
import participant.Human;
import participant.Participant;
import participant.Robot;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Cat(50),
                new Human(10, 200),
                new Robot(100, 400)};
        Obstacle[] obstacles = {
                new RunningRoad(220),
                new Wall(48)};

        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < participants.length; j++) {
                System.out.println(obstacles[i].doIt(participants[j]));
            }
        }
    }
}













