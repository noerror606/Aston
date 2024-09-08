import java.util.*;

public class Array {
    public void info() {
        String[] strArrays = {"Кот", "Собака", "Кот", "Ёж", "Собака", "Хорек", "Гусь", "Кот", "Крыса", "Хорек", "Тушканчик", "Медведь"};
        Map<String, Integer> strCount = new HashMap<>();
        List<String> unStr = new ArrayList<>();

        for (String word : strArrays) {
            strCount.put(word, strCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> key : strCount.entrySet()) {
            if (key.getValue() == 1) {
                unStr.add(key.getKey());
            }
        }

        System.out.println("Уникальные слова (встречаются только один раз): ");
        for (String word : unStr) {
            System.out.print(word + " ");
        }

        System.out.println("\n\nВсе слова и сколько раз они встречаются:");
        for (Map.Entry<String, Integer> entry : strCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }
}