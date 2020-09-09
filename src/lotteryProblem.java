import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.Math.random;
/**
 * @author Ryan Ignasiak, Matthew Chen, Tina Vu
 * Due Date: 9/9/20
 * Purpose: The Lottery Problem program simulates the generation of QuickPick lottery tickets
 * Input Variables: The number of lottery tickets that the user selects
 * Output: The program  will print six comma-separated unique numbers on each line, as many lines as the user selects
 */
class lotteryProblem {
    /**
     * Queries the user for the number of lottery tickets to be created
     * @return the number of lottery tickets
     */

    private static int userResponse() {
        Scanner reader = new Scanner(System.in);
        System.out.println("How many lottery tickets would you like?");
        int userInput = 0;
        int count = 0;
        int max = 3;
        while(count<=max) {
            try {
                userInput = reader.nextInt();
                if (userInput < 1 && count < (max-1)) {
                    System.out.println("Please enter a valid number!");
                    count++;
                }
                else {
                    break;
                }
            } catch (Exception e) {
                if (++count == max) throw e;
                System.out.println("Please enter a valid number!");
                reader.nextLine();
            }
        }
        reader.close();
        return userInput;
    }
    /**
     * Generates a single ticket of six unique numbers between 1 and 49
     * @return the ArrayList of six numbers
     */
    private static ArrayList<Integer> generateTicket() {
        int rand;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            rand = (int)(49 * random()) + 1;
            if (numbers.contains(rand)) {
                i--;
            }
            else {
                numbers.add(rand);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }
    /**
     * Adds each ticket to an ArrayList
     * @param n the number of tickets to be generated
     * @return the ArrayList of tickets
     */
    private static ArrayList<ArrayList<Integer>> addTickets(int n) {
        ArrayList<ArrayList<Integer>> tickets = new ArrayList<>();
        while (n > 0) {
            tickets.add(generateTicket());
            n--;
        }
        return tickets;
    }
    /**
     * Prints the ArrayList of tickets, one per line, to console
     * @param t the ArrayList of tickets
     */
    private static void printTickets(ArrayList<ArrayList<Integer>> t) {
        for (ArrayList<Integer> integers : t) {
            System.out.println(integers);
        }
    }
    /**
     * Calls the methods to print a number of tickets based on the user's input
     * @param args an array filled with command-line arguments
     */
    public static void main(String[] args) {
        printTickets(addTickets(userResponse()));
    }
}