import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {

            for (int j = 0; j < number; j++) {
                if (i == j) {
                    System.out.print("*" + " ");
                }
                else if (i + j == number - 1) {
                    System.out.print("*" + " ");
                }
                else if (j == number/2 || i == number/2) {
                    System.out.print("*" + " ");
                }
                else {
                    System.out.print("." + " ");
                }
            }

            System.out.println();
        }


    }
}