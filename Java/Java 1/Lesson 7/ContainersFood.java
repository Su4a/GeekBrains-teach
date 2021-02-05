public abstract class ContainersFood {
    private int food;

    ContainersFood(int food) {
        this.food = food;
    }

    public  void increaseFood(int food) {
        this.food += food;
    }

    public void decreaseFood(int appetite) {
        if (hasEnoughFood(appetite)) food -= appetite;
        else System.out.println("Недостаточно еды в тарелке");
    }

    public boolean hasEnoughFood(int appetite) {
        return appetite <= food;
    }

    public void info() {
        System.out.println("Еды в резервуаре: " + food);
    }
}
