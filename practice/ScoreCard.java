/*
 * Pair problem 4 -- four bugs.
 *
 * TWO of them stop this compiling. TWO of them do not: it will build, run, and
 * print something that looks almost right.
 *
 * Run it with:  Ada Lovelace / 4 / 70 / Blazers
 *
 * When all four are fixed it prints exactly:
 *
 *     Ada Lovelace of Blazers
 *     Average: 17.5
 *     Starter: true
 *
 * Fix the compiler's complaints first, then RUN IT AND READ THE OUTPUT before
 * you decide you are done. Write the four bugs in your log, and beside each one
 * say whether the compiler caught it or you did.
 */
import java.util.Scanner;

public class ScoreCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Player: ");
        String name = input.nextLine()

        System.out.print("Games played: ");
        int games = input.nextInt();

        System.out.print("Total points: ");
        int total = input.nextInt();

        boolean starter = 1;

        System.out.print("Team: ");
        String team = input.nextLine();

        double average = total / games;

        System.out.println(name + " of " + team);
        System.out.println("Average: " + average);
        System.out.println("Starter: " + starter);
    }
}
