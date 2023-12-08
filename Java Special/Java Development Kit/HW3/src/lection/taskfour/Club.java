package lection.taskfour;

public class Club<T extends Person> {
    Person[] arr;
    public Club(T... people) {
        arr = people;
    }
    void chill() {
        for (Person person : arr) {person.haveRest();}
    }
}
