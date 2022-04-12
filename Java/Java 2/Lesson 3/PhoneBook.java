import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    /*Добавление контактов в телефонную книжку*/
    public void add(String name, String number) {
        if (book.containsKey(name)) {
            book.get(name).add(number);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            book.put(name, numbers);
        }
    }

    /*Вывод телефонов по Фамилии*/
    public Set<String> get(String name) {
        return book.getOrDefault(name, Collections.emptySet());
    }
}
