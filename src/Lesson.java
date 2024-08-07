public class Lesson {
    //1
    public void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    //2
    public void checkSumSign() {
        int a = 10;
        int b = -15;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3
    public void printColor() {
        int value = 255;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    public void compareNumbers() {
        int a = 10, b = 30;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5
    public boolean sumChecker(int a, int b) {
        System.out.println(a + b >= 10 && a + b <= 20);
        return a + b >= 10 && a + b <= 20;
    }

    //6
    public void rationalNumbers(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");

        } else {
            System.out.println("Число отрицательное");
        }
    }

    //7
    public boolean rationalNumbersBoolean(int a) {
        boolean result = a >= 0 ? true : false;
        System.out.println(result);
        return result;
    }

    //8
    public void stringNum(int num, String string) {
        for (int i = 0; i < num; ++i) {
            System.out.println(string);
        }

    }

    //9
    public boolean leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
        } else {
            return false;
        }
    }

    //10
    public void swap() {
        int[] array = new int[]{1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0};
        System.out.print("Массив до изменения: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.print("Массив после изменения: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    //11
    public void arrayFill() {
        int[] newArray = new int[100];
        for (int i = 0; i < newArray.length; ++i) {
            System.out.print((newArray[i] = i + 1) + " ");
        }
    }

    //12
    public void numberMultiplication() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Массив до изменения: ");
        int i;
        for (i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.print("Массив после изменения: ");
        for (i = 0; i < array.length; ++i) {
            if (array[i] < 6) {
                array[i] *= 2;
            }

            System.out.print(array[i] + " ");
        }
    }

    //13
    public void matrix() {
        int m = 5;
        int[][] matrix = new int[m][m];
        int i;
        for (i = 0; i < m; ++i) {
            matrix[i][i] = 1;
            matrix[i][m - i - 1] = 1;
        }
        for (i = 0; i < m; ++i) {
            matrix[i][m - i - 1] = 1;
        }
        for (i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //14
    public static int[] initialValue(int len, int initialValue) {
        int[] array = new int[len];
        System.out.print("Массив:");
        for (int i = 0; i < len; ++i) {
            array[i] = initialValue;
            System.out.print(" " + array[i]);
        }
        return array;
    }
}
