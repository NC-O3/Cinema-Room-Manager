import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int numberToCheck = scanner.nextInt();

        boolean contains = false;

        for (int i = 0; i < size; i++) {
            if (numbers[i] == numberToCheck) {
                contains = true;
                break;
            }
        }

        System.out.println(contains);

    }
}