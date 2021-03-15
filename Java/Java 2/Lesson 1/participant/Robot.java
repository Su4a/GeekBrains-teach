package participant;

public class Robot implements Jumpable, Runnable, Participant {
    private final int maxJumpDistance;
    private final int maxRunDistance;

    public Robot(int maxJumpDistance, int maxRunDistance) {
        this.maxJumpDistance = maxJumpDistance;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean jump(int distance) {
        System.out.println("Robot attempts jump");
        return maxJumpDistance <= distance;
    }

    @Override
    public boolean run(int distance) {
        System.out.println("Robot attempts run");
        return maxRunDistance <= distance;
    }
}
