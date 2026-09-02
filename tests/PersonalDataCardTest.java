/**
 * Over-break practice: Personal Data Card.  Completion-graded, so this is a
 * self-check rather than a mark. It is the only thing you have over the break
 * that can tell you whether it works.
 */
public class PersonalDataCardTest {

    // name, birth year, favourite number | initials, age, hundreds, tens, ones, parity, length
    private static final String[][] CASES = {
        {"Ada Lovelace",          "1985", "472", "AL", "41",  "4", "7", "2", "even", "short"},
        {"Grace Brewster Hopper", "2010", "250", "GB", "16",  "2", "5", "0", "even", "long"},
        {"Alan Turing",           "1912", "999", "AT", "114", "9", "9", "9", "odd",  "short"},
    };

    public static void run(Check c) {
        c.begin("Personal Data Card");
        if (Harness.isStub("PersonalDataCard")) {
            c.skip("all checks", 20, "not started");
            return;
        }

        int initials = 0, age = 0, digits = 0, id = 0, parity = 0, length = 0;
        StringBuilder trouble = new StringBuilder();

        for (String[] k : CASES) {
            String out;
            try {
                out = Harness.run("PersonalDataCard", k[0] + "\n" + k[1] + "\n" + k[2] + "\n");
            } catch (Harness.NotRunnable e) {
                c.fail("runs at all", 20, e.getMessage());
                return;
            }
            if (want(out, "Initials:", k[3], k, trouble)) initials++;
            if (want(out, "Age:", k[4], k, trouble)) age++;
            if (want(out, "Hundreds:", k[5], k, trouble)
                & want(out, "Tens:", k[6], k, trouble)
                & want(out, "Ones:", k[7], k, trouble)) digits++;
            if (want(out, "Favorite number is", k[8], k, trouble)) parity++;
            if (want(out, "Name is", k[9], k, trouble)) length++;

            String v = Harness.line(out, "ID:");
            if (v != null && v.matches("\\d{4}") && Integer.parseInt(v) >= 1000) {
                id++;
            } else {
                trouble.append("\n              ID: expected four digits from 1000 to 9999, got \"")
                       .append(v).append("\"");
            }
        }

        int n = CASES.length;
        c.isTrue("initials, with indexOf and substring", 4, initials == n, trouble.toString());
        c.isTrue("age from the birth year", 3, age == n, trouble.toString());
        c.isTrue("digits split with / and %", 4, digits == n, trouble.toString());
        c.isTrue("a random id in range", 3, id == n,
                 "the formula is (int)(Math.random() * 9000) + 1000." + trouble);
        c.isTrue("even or odd", 3, parity == n, trouble.toString());
        c.isTrue("long or short name", 3, length == n, trouble.toString());
    }

    private static boolean want(String out, String label, String expect, String[] k, StringBuilder t) {
        String v = Harness.line(out, label);
        if (v != null && v.equals(expect)) return true;
        t.append("\n              ").append(k[0]).append(" -> ").append(label)
         .append(" expected \"").append(expect).append("\", got \"").append(v).append("\"");
        return false;
    }
}
