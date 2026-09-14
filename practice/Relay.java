/*
 * Debug clinic, Monday 14 September.
 *
 *     cd practice
 *     javac Relay.java
 *     java Relay
 *
 * THIS PROGRAM HAS FOUR BUGS. Two of them javac will refuse to compile and
 * tell you about. Two of them compile perfectly and produce the wrong answer,
 * and those are the ones worth your afternoon.
 *
 * Run it with:  Blazers   then   4   then   230   then   Ada
 *
 * When all four are fixed it prints exactly this:
 *
 *     Blazers ran 4 legs
 *     Average leg: 57.5
 *     Anchor: Ada (3 letters)
 *     Qualified: true
 *
 * Do not stop when it compiles. Compare every line of your output to the four
 * lines above.
 *
 * You do not need to save a copy of the broken version. It arrived as its own
 * commit, so once you commit your fix, git log on this file shows the before
 * and the after side by side without you doing anything.
 */
import java.util.Scanner;

public class Relay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Team: ");
        String team = input.nextLine();

        System.out.print("Legs: ");
        int legs = input.nextInt();

        System.out.print("Total seconds: ");
        int total = input.nextInt();

        System.out.print("Anchor runner: ");
        String anchor = input.nextLine();

        boolean qualified = 1;

        double average = total / legs;

        System.out.println(team + " ran " + legs + " legs");
        System.out.println("Average leg: " + average);
        System.out.println("Anchor: " + anchor + " (" + anchor.length + " letters)");
        System.out.println("Qualified: " + qualified);
    }
}
