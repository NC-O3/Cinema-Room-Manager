package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int numberOfSeats = scanner.nextInt();

        int[] tickets1 = new int[numberOfRows * numberOfSeats];
        int[] tickets2 = new int[numberOfRows * numberOfSeats];
        int ticketCounter = 0;

        int currentIncome = 0;

        int totalPossibleIncome = 0;
        if (numberOfRows * numberOfSeats <= 60) {
            totalPossibleIncome = numberOfRows * numberOfSeats * 10;
        }
        else {
            int firstHalf1 = numberOfRows / 2;
            totalPossibleIncome = firstHalf1 * numberOfSeats * 10 + (numberOfRows - firstHalf1) * numberOfSeats * 8;
        }

        System.out.println();

        int select;

        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            select = scanner.nextInt();
            System.out.println();

            switch (select) {
                case 1:

                    System.out.println("Cinema: ");
                    System.out.print("  ");
                    for (int i = 0; i < numberOfSeats; i++) {
                        System.out.print(i + 1 + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < numberOfRows; i++) {
                        System.out.print(i + 1 + " ");
                        for (int j = 0; j < numberOfSeats; j++) {
                            boolean any = false;
                            for (int k = 0; k < ticketCounter; k++) {
                                if (i + 1 == tickets1[k] && j + 1 == tickets2[k]) {
                                    System.out.print("B ");
                                    any = true;
                                    break;
                                }
                            }
                            if (!any) {
                                System.out.print("S ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();

                    break;

                case 2:

                    boolean okData = false;
                    while (!okData) {
                        System.out.println("Enter a row number: ");
                        int rowNumber = scanner.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        int seatNumber = scanner.nextInt();

                        System.out.println();

                        boolean isGoodRow = rowNumber >=1 && rowNumber <= numberOfRows;
                        boolean isGoodSeat = seatNumber >= 1 && seatNumber <= numberOfSeats;

                        if (isGoodRow && isGoodSeat) {
                            boolean alreadyBought = false;
                            for (int i = 0; i < ticketCounter; i++) {
                                if (rowNumber == tickets1[i] && seatNumber == tickets2[i]) {
                                    alreadyBought = true;
                                    break;
                                }
                            }
                            if (alreadyBought) {
                                System.out.println("That ticket has already been purchased!");
                            }
                            else {
                                tickets1[ticketCounter] = rowNumber;
                                tickets2[ticketCounter] = seatNumber;
                                ticketCounter++;
                                if (numberOfRows * numberOfSeats <= 60) {
                                    System.out.println("Ticket price: $10");
                                    currentIncome += 10;
                                }
                                else {
                                    int firstHalf = numberOfRows / 2;
                                    if (rowNumber <= firstHalf) {
                                        System.out.println("Ticket price: $10");
                                        currentIncome += 10;
                                    }
                                    else {
                                        System.out.println("Ticket price: $8");
                                        currentIncome += 8;
                                    }
                                }
                                okData = true;
                            }
                        }
                        else {
                            System.out.println("Wrong input!");
                        }
                        System.out.println();
                    }

                    break;

                case 3:

                    System.out.println("Number of purchased tickets: " + ticketCounter);
                    double percentage = (double) ticketCounter/(numberOfRows * numberOfSeats) * 100;
                    System.out.printf("Percentage: %.2f%%%n", percentage);
                    System.out.printf("Current income: $%d%n", currentIncome);
                    System.out.printf("Total income: $%d%n", totalPossibleIncome);
                    System.out.println();

                    break;
            }

        }while (select != 0);

    }

}