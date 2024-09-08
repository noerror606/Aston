import java.util.List;
public class Main {
    public static void main(String[] args) {
        Array array = new Array();
        array.info();

        PhoneCollection phoneBook = new PhoneCollection();

        phoneBook.add("Иванов", "+375336186208");
        phoneBook.add("Петров", "+375291274131");
        phoneBook.add("Иванов", "+375336186209");
        phoneBook.add("Сидоров", "+375298486067");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
    }
}