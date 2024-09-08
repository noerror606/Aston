import java.util.*;

public class PhoneCollection {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }
}
