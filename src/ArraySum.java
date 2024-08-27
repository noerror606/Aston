public class ArraySum {
    int sum = 0;

    private void checkArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("MyArraySizeException Размер массива не равен 4х4");
        }
        //извращение, но я старалась)
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("MyArraySizeException Размер массива не равен 4х4");
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("MyArrayDataException [" + i + "][" + j + "]");
                }
            }
        }
    }

    public void printInfo(String[][] array) {
        try {
            checkArray(array);
            System.out.println("Сумма всех элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}