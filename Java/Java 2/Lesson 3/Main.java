import java.util.*;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    static void firstTask() {
        String[] words = {"Happy", "One", "Nice", "Two", "Happy", "One"};
        System.out.println("Все слова - " + Arrays.toString(words));

        /*Уникальные слова*/
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова - " + uniqueWords);

        /*Количество повторяющихся слов*/
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        System.out.println("Сколько раз встречается каждое слово - " + counter);
    }

    static void secondTask() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Магелонов", "89536657823");
        phoneBook.add("Мигалочев", "89216637853");
        phoneBook.add("Апрельников", "89116653843");
        phoneBook.add("Магелонов", "89126654853");

        System.out.println(phoneBook.get("Магелонов"));
    }
}
