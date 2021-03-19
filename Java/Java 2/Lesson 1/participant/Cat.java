package participant;

public class Cat implements Jumpable, Participant {
    private final int maxJumpDistance;

    public Cat(int maxJumpDistance) {
        this.maxJumpDistance = maxJumpDistance;
    }
    @Override
    public boolean jump(int distance) {
        System.out.println("Cat attempts jump");
        return maxJumpDistance <= distance;
    }
}
