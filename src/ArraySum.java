public class ArraySum {

    int sum = 0;

    public void checkArray(String[][] array) throws MyArrayDataException {
        //row
        if (array.length != 4) {
                throw new MyArraySizeException ("MyArraySizeException");
        }

        // col
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException ("MyArraySizeException");
            }
        }

        // sum
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("MyArrayDataException ["+ i + "][" + j + "]");
                }
            }
        }
    }
    public int getSum() {
        return sum;
    }

}




