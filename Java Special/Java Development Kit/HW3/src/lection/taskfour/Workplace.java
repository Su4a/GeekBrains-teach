package lection.taskfour;

public class Workplace <T extends Person> {
    Person[] arr;
    public Workplace(T... people) {
        arr = people;
    }
    void work() {
        for (Person person : arr) {person.doWork();}
    }
}
