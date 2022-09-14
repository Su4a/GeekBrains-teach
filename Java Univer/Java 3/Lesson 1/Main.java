public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        boxApple1.add(apple1);
        boxApple1.add(apple2);
        boxApple1.add(apple3);
        boxOrange1.add(orange1);
        boxOrange1.add(orange2);

        boxApple1.shiftFruitBox(boxApple2);

        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple1);
        System.out.println(boxApple2.getWeight());
        System.out.println(boxApple2);
    }
}

//compare - сравнить 2 ящика
//getWeight - узнать вес ящика
//shiftFruitBox - переложить фрукт с одного ящика в другой
//add - добавить фрукт в ящик
//delite - выбросить фрукт с ящика
