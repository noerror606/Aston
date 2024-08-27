public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[][] {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1", "8"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        String[][] array2 = new String[][] {
                {"1", "A", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        String[][] array3 = new String[][] {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };


        ArraySum arraySum = new ArraySum();

        arraySum.printInfo(array1);
        arraySum.printInfo(array2);
        arraySum.printInfo(array3);
    }

}