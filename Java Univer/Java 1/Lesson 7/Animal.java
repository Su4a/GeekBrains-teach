public abstract class Animal {
    private boolean hunger;
    private int appetite;

    Animal(int appetite) {
        this.appetite = appetite;
        hunger = true;
    }

    public void eat(ContainersFood containersFood) {
        if (containersFood.hasEnoughFood(appetite) && hunger) {
            containersFood.decreaseFood(appetite);
            hunger = false;
            System.out.println("Кот покушал");
        }else if (!hunger) {
            System.out.println("Кот не хочет кушать");
        }else{
            System.out.println("Мало еды в тарелке");
        }
    }

    public void info() {
        System.out.println("Голод кота: " + hunger);
    }
}
