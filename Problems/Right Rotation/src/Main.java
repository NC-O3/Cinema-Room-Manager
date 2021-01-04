import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stringNumbers = scanner.nextLine();
        String[] numberList = stringNumbers.split(" ");
        int[] numbers = new int[numberList.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }

        int numberOfRotations = scanner.nextInt();

        numbers = rotateToRight(numbers, numberOfRotations);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    public static int[] rotateToRight(int[] array, int numberOfRotations) {

        if (numberOfRotations > array.length) {
            numberOfRotations = numberOfRotations % array.length;
        }

        for (int j = 0; j < numberOfRotations; j++) {
            int store1 = array[0];
            int store2;

            for (int i = 1; i < array.length; i++) {
                store2 = array[i];
                array[i] = store1;
                store1 = store2;
            }

            array[0] = store1;
        }

        return array;

    }
}