import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                if (j == i1) {
                    System.out.print(matrix[i][j1] + " ");
                }
                else if (j == j1) {
                    System.out.print(matrix[i][i1] + " ");
                }
                else {
                    System.out.print(matrix[i][j] + " ");
                }
            }

            System.out.println();
        }

    }
}