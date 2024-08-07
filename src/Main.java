import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lesson lesson = new Lesson();
        Scanner sc = new Scanner(System.in);

        //1
        lesson.printThreeWords();
        //2
        lesson.checkSumSign();
        //3
        lesson.printColor();
        //4
        lesson.compareNumbers();
        //5
        System.out.print("Введите число а: ");
        int sumA = sc.nextInt();
        System.out.print("Введите число b: ");
        int sumB = sc.nextInt();
        lesson.sumChecker(sumA, sumB);
        //6
        System.out.print("Введите число: ");
        int Rational = sc.nextInt();
        lesson.rationalNumbers(Rational);
        //7
        System.out.print("Введите число: ");
        int RationalBool = sc.nextInt();
        lesson.rationalNumbersBoolean(RationalBool);
        //8
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите строку: ");
        String string = sc.nextLine();
        lesson.stringNum(num, string);
        //9
        System.out.print("Введите год: ");
        int year = sc.nextInt();
        lesson.leapYear(year);
        //10
        boolean result = lesson.leapYear(year);
        System.out.println("Год " + year + " високосный: " + result);
        lesson.swap();
        System.out.println(" ");
        //11
        lesson.arrayFill();
        System.out.println(" ");
        //12
        lesson.numberMultiplication();
        System.out.println(" ");
        //13
        lesson.matrix();
        //14
        System.out.print("Введите количество: ");
        int len = sc.nextInt();
        System.out.print("Введите число: ");
        int initialValue = sc.nextInt();
        lesson.initialValue(len, initialValue);
    }
}























