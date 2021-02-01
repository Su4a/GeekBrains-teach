public class Statistic {
    static int countAnimals = 0;
    static int countCat = 0;
    static int countDog = 0;

    public static void pringInfo() {
        System.out.println("Количество животных: " + countAnimals + " (" + "Котов-" + countCat + "|" + "Собак-" + countDog + ")");
    }
}
