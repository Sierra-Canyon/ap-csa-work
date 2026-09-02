/**
 * Lab 1: Unit Converter.  12 of the 20 points are checked here.
 * The other 8 (variable names, the precondition comment) are read by a human.
 */
public class UnitConverterTest {

    // miles, truncated km, rounded km.  1 mile = 1.609344 km.
    // The rows where the two answers differ are the whole point of the lab.
    private static final int[][] CASES = {
        {   0,   0,   0 },
        {   1,   1,   2 },   // 1.609344
        {   3,   4,   5 },   // 4.828032
        {   5,   8,   8 },   // 8.04672
        {  10,  16,  16 },   // 16.09344
        {  26,  41,  42 },   // 41.842944
        { 100, 160, 161 },   // 160.9344
    };

    public static void run(Check c) {
        c.begin("Lab 1: Unit Converter");
        if (Harness.isStub("UnitConverter")) {
            c.skip("all checks", 12, "not started");
            return;
        }

        int readOk = 0, truncOk = 0, roundOk = 0;
        StringBuilder trouble = new StringBuilder();

        for (int[] row : CASES) {
            String out;
            try {
                out = Harness.run("UnitConverter", row[0] + "\n");
            } catch (Harness.NotRunnable e) {
                c.fail("runs at all", 12, e.getMessage());
                return;
            }
            String t = Harness.line(out, "Truncated:");
            String r = Harness.line(out, "Rounded:");
            if (t == null || r == null) {
                c.fail("prints both required lines", 12,
                       "with input " + row[0] + " the output was:\n              "
                       + out.trim().replace("\n", "\n              ")
                       + "\n              The spec needs a line starting \"Truncated:\" and one starting \"Rounded:\".");
                return;
            }
            boolean tok = t.equals(row[1] + " km");
            boolean rok = r.equals(row[2] + " km");
            if (tok) truncOk++;
            if (rok) roundOk++;
            if (tok || rok) readOk++;
            if (!tok || !rok) {
                trouble.append("\n              ").append(row[0]).append(" miles: expected \"")
                       .append(row[1]).append(" km\" / \"").append(row[2])
                       .append(" km\", got \"").append(t).append("\" / \"").append(r).append("\"");
            }
        }

        c.isTrue("reads the number from input", 4, readOk > 0,
                 "no case produced a correct answer, so the program may not be reading input");
        c.isTrue("truncates with a cast", 4, truncOk == CASES.length,
                 truncOk + " of " + CASES.length + " correct." + trouble);
        c.isTrue("rounds, rather than truncating twice", 4, roundOk == CASES.length,
                 roundOk + " of " + CASES.length + " correct. Rounding is (int)(km + 0.5)."
                 + " Math.round is not on the Quick Reference." + trouble);
    }
}
