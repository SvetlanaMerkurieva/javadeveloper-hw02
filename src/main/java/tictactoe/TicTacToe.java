package tictactoe;

import java.util.Scanner;


public class TicTacToe {
    private static final Scanner scan = new Scanner(System.in);

    public void playTicTacToe () {
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
                putSpace(box, numberOfBoxes);
                boxEmpty = true;
            }

            if (isThreeCrossesInRow(box)) {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (isThreeZeroesInRow(box)) {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            if (!isBoxAvailable(box, numberOfBoxes)) {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            putCross(scan, box, numberOfBoxes);

            putZero(box);
        }
    }

    public static char[] putSpace(char[] box, int numberOfBoxes) {
        for (byte i = 0; i < numberOfBoxes; i++) {
            box[i] = ' ';
        }
        return box;
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

    public static boolean isBoxFree (char[] box, byte i) {
        return box[i] != 'X' && box[i] != 'O';
    }

    public static boolean isBoxNotFree (char[] box, byte input) {
        return box[input - 1] == 'X' || box[input - 1] == 'O';
    }

    public static boolean isBoxAvailable(char[] box, int numberOfBoxes) {
        boolean boxAvailable = false;
        for (byte i = 0; i < numberOfBoxes; i++) {
            if (isBoxFree(box, i)) {
                boxAvailable = true;
                break;
            }
        }
        return boxAvailable;
    }
    public static boolean isCorrectInput (byte input, int numberOfBoxes) {
        return input > 0 && input <= numberOfBoxes;
    }

    public static char[] putCross(Scanner scan, char[] box, int numberOfBoxes) {
        while (true) {
            byte input = scan.nextByte();
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
            return box;
    }

    public static char[] putZero(char[] box) {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (isRandBoxFree(box, rand)) {
                box[rand - 1] = 'O';
                break;
            }
        }
        return box;
    }
    public static boolean isRandBoxFree (char[] box, byte rand) {
        return box[rand - 1] != 'X' && box[rand - 1] != 'O';
    }

}