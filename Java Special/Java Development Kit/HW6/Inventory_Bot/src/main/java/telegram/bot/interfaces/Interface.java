package telegram.bot.interfaces;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Interface {
    protected <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    protected String[] splitString(String message, char splitChar) {
        StringBuilder stringBuilder = new StringBuilder();
        int countSplit = 0;
        int count = 0;
        for (int  i = 0; i < message.length(); i++) if (message.charAt(i) == splitChar) countSplit++;
        String[] splitString = new String[countSplit + 1];

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == splitChar) {
                splitString[count] = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                count++;
            } else {
                stringBuilder.append(message.charAt(i));
            }
        }
        splitString[count] = stringBuilder.toString();
        return splitString;
    }
}
