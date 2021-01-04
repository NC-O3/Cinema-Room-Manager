import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int store1 = numbers[0];
        int store2;

        System.out.print(numbers[size - 1] + " ");

        for (int i = 1; i < size; i++) {
            store2 = numbers[i];
            numbers[i] = store1;
            System.out.print(numbers[i] + " ");
            store1 = store2;
        }

        numbers[0] = store1;

    }

}