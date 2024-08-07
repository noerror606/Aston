import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lesson lesson = new Lesson();
        Scanner sc = new Scanner(System.in);
        lesson.printThreeWords();
        lesson.checkSumSign();
        lesson.printColor();
        lesson.compareNumbers();
        System.out.print("Введите число а: ");
        int sumA = sc.nextInt();
        System.out.print("Введите число b: ");
        int sumB = sc.nextInt();
        lesson.sumChecker(sumA, sumB);
        System.out.print("Введите число: ");
        int Rational = sc.nextInt();
        lesson.rationalNumbers(Rational);
        System.out.print("Введите число: ");
        int RationalBool = sc.nextInt();
        lesson.rationalNumbersBoolean(RationalBool);
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите строку: ");
        String string = sc.nextLine();
        lesson.stringNum(num, string);
        System.out.print("Введите год: ");
        int year = sc.nextInt();
        lesson.leapYear(year);
        boolean result = lesson.leapYear(year);
        System.out.println("Год " + year + " високосный: " + result);
        lesson.swap();
        lesson.arrayFill();
        lesson.numberMultiplication();
        lesson.matrix();
        System.out.print("Введите число: ");
        int len = sc.nextInt();
        System.out.print("Введите строку: ");
        sc.nextLine();
        String initialValue = sc.nextLine();
        lesson.initialValue(len, initialValue);
    }
}























