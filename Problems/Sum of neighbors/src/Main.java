import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")){
            arrayList.add(line);
            line = scanner.nextLine();
        }

        int[][] matrix = new int[arrayList.size()][];
        int[] informationColumns = new int[arrayList.size()];
        int numberOfRows = arrayList.size();

        int counter = 0;
        for (String s : arrayList) {
            String[] numbers = s.split(" ");
            int[] numbersInt = new int[numbers.length];
            informationColumns[counter] = numbers.length;
            for (int i = 0; i < numbers.length; i++) {
                numbersInt[i] = Integer.parseInt(numbers[i]);
            }
            matrix[counter] = numbersInt;
            counter++;
        }

        if (numberOfRows == 1 && informationColumns[0] == 1) {
            System.out.println(matrix[0][0] * 4);
        }
        else {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < informationColumns[i]; j++) {
                    int[] n = new int[4];

                    if (informationColumns[i] == 1) {
                        n[0] = matrix[i][j];
                        n[1] = matrix[i][j];
                    }
                    else {
                        n[0] = (j - 1 >= 0) ? matrix[i][j - 1] : matrix[i][informationColumns[i] - 1];
                        n[1] = (j + 1 <= informationColumns[i] - 1) ? matrix[i][j + 1] : matrix[i][0];
                    }

                    if (i == numberOfRows - 1) {
                        n[2] = (j <= informationColumns[0] - 1) ? matrix[0][j] : matrix[i][j];
                    }
                    else {
                        n[2] = (j <= informationColumns[i + 1] - 1) ? matrix[i + 1][j] : matrix[i][j];
                    }

                    if (i == 0) {
                        n[3] = (j <= informationColumns[numberOfRows - 1] - 1) ? matrix[numberOfRows - 1][j] : matrix[i][j];
                    }
                    else {
                        n[3] = (j <= informationColumns[i - 1] - 1) ? matrix[i - 1][j] : matrix[i][j];
                    }

                    System.out.print(n[0] + n[1] + n[2] + n[3] + " ");
                }
                System.out.println();
            }
        }

    }
}