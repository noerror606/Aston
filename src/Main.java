public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[][] {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1",},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        String[][] array2 = new String[][] {
                {"1", "A", "1", "1"},
                {"1", "1", "1", "1",},
                {"1", "1", "1", "1","8"},
                {"1", "1", "1", "1"}
        };
        String[][] array3 = new String[][] {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };


          ArraySum array = new ArraySum();

        try {
            array.checkArray(array3);
            System.out.println("Сумма всех элементов массива: " + array.getSum());
            //array.checkArray(array2);
           // System.out.println("Сумма всех элементов массива: " + array.getSum());
            //array.checkArray(array1);
            //System.out.println("Сумма всех элементов массива: " + array.getSum());
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

}