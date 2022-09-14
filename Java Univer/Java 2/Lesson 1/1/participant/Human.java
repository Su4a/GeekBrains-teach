package participant;

public class Human implements Jumpable, Runnable, Participant {
    private final int maxJumpDistance;
    private final int maxRunDistance;

    public Human(int maxJumpDistance, int maxRunDistance) {
        this.maxJumpDistance = maxJumpDistance;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean jump(int distance) {
        System.out.println("Human attempts jump");
        return maxJumpDistance <= distance;
    }

    @Override
    public boolean run(int distance) {
        System.out.println("Human attempts run");
        return maxRunDistance <= distance;
    }
}
