package tictactoe;

import java.util.Scanner;


public class TicTacToe {

    public void head () {
        Scanner scan = new Scanner(System.in);
        byte input;
        byte rand;
        byte i;
        boolean boxAvailable;
        byte winner = 0;
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int numberOfBoxes = 9;
        System.out.println(("Enter box number to select. Enjoy!\n"));
        boolean boxEmpty = false;
        while (true) {
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
            if (!boxEmpty) {
                for (i = 0; i < numberOfBoxes; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            if (winner == 1) {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (winner == 2) {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (winner == 3) {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (isCorrectInput(input, numberOfBoxes)) {
                    if (isBoxNotFree(box, input)) {
                        System.out.println("That one is already in use. Enter another.");
                    } else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            }

            if (isThreeCrossesInRow(box)) {
                winner = 1;
            }

            boxAvailable = false;
            for (i = 0; i < numberOfBoxes; i++) {
                if (isBoxFree(box, i)) {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = 3;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (isRandBoxFree(box, rand)) {
                    box[rand - 1] = 'O';
                    break;
                }
            }

            if (isThreeZeroesInRow(box)) {
                winner = 2;
            }
        }
    }

    public static boolean isThreeCrossesInRow (char[] box) {
        return (box[0]=='X' && box[1]=='X' && box[2]=='X') || (box[3]=='X' && box[4]=='X' && box[5]=='X') || (box[6]=='X' && box[7]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[3]=='X' && box[6]=='X') || (box[1]=='X' && box[4]=='X' && box[7]=='X') || (box[2]=='X' && box[5]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[4]=='X' && box[8]=='X') || (box[2]=='X' && box[4]=='X' && box[6]=='X');
    }

    public static boolean isThreeZeroesInRow (char[] box) {
        return (box[0]=='O' && box[1]=='O' && box[2]=='O') || (box[3]=='O' && box[4]=='O' && box[5]=='O') || (box[6]=='O' && box[7]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[3]=='O' && box[6]=='O') || (box[1]=='O' && box[4]=='O' && box[7]=='O') || (box[2]=='O' && box[5]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[4]=='O' && box[8]=='O') || (box[2]=='O' && box[4]=='O' && box[6]=='O');
    }

    public static boolean isRandBoxFree (char[] box, byte rand) {
        return box[rand - 1] != 'X' && box[rand - 1] != 'O';
    }

    public static boolean isBoxFree (char[] box, byte i) {
        return box[i] != 'X' && box[i] != 'O';
    }

    public static boolean isBoxNotFree (char[] box, byte input) {
        return box[input - 1] == 'X' || box[input - 1] == 'O';
    }

    public static boolean isCorrectInput (byte input, int numberOfBoxes) {
        return input > 0 && input <= numberOfBoxes;
    }

    public static String resultMessage(byte winner) {
        String message = "";
        if (winner == 1) {
            return message + "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
        }
        if (winner == 2) {
            return message + "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
        }
        if (winner == 3) {
            return message + "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
        }
        return message;
    }

}