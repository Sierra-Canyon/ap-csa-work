// Today's trace bank. Meeting 9, Thursday 17 September. W0 to W4 only.
//
// Everything in here uses something the class has already been taught:
// types and output, concatenation, integer division and modulo, Scanner-free
// assignment, compound assignment, casting, ranges and overflow.
//
// It deliberately contains NO Math class and NO String methods. Those are
// W6 on 9/23 and W9/W10 on 9/30 and 10/1, and the old Warm.java uses both.
//
//     javac Warm1.java && java Warm1
//
// Predict all sixteen on paper first. Do not run this until you are told to.

public class Warm1 {
    public static void main(String[] args) {
        System.out.println(" 1  " + (7 / 2));
        System.out.println(" 2  " + (7 % 2));
        System.out.println(" 3  " + (7 / 2.0));
        System.out.println(" 4  " + ((double) 7 / 2));
        System.out.println(" 5  " + ((double) (7 / 2)));
        System.out.println(" 6  " + (1 + 2 + "3" + 4 + 5));
        System.out.println(" 7  " + ((int) 8.99));
        System.out.println(" 8  " + ((int) -8.99));
        System.out.println(" 9  " + ((int) (8.99 + 0.5)));
        System.out.println("10  " + ((int) (-8.99 + 0.5)));
        System.out.println("11  " + (10 / 4 * 4));
        System.out.println("12  " + (10.0 / 4 * 4));

        int p = 7;
        p /= 2;
        System.out.println("13  " + p);

        int q = 7;
        q *= 1.5;
        System.out.println("14  " + q);

        System.out.println("15  " + (2147483647 + 1));

        double avg = 9 / 2;
        System.out.println("16  " + avg);
    }
}
