/**
 * Lab 4: Data Analysis.  16 of the 20 points are checked here. The four log
 * questions in the spec are answered in your log, not in the program.
 */
public class DataAnalysisTest {

    public static void run(Check c) {
        c.begin("Lab 4: Data Analysis");
        if (Harness.isStub("DataAnalysis")) {
            c.skip("all checks", 16, "not started");
            return;
        }
        String out;
        try {
            out = Harness.run("DataAnalysis", "");
        } catch (Harness.NotRunnable e) {
            c.fail("runs at all", 16, e.getMessage()
                   + "\n              If it cannot find rainfall.txt, run from the top of the repository.");
            return;
        }

        c.equal("count of readings", 4, "8", str(out, "Count:"));

        Double mean = num(out, "Mean:");
        if (mean == null) {
            c.fail("mean", 4, "no line starting \"Mean:\" with a number after it");
        } else {
            c.near("mean", 4, 1.7125, mean, 1e-9);
        }

        Double max = num(out, "Max:");
        if (max == null) {
            c.fail("maximum", 4, "no line starting \"Max:\" with a number after it");
        } else {
            c.near("maximum", 4, 5.4, max, 1e-9);
        }

        c.equal("readings above the mean", 4, "3", str(out, "Above mean:"));
    }

    private static String str(String out, String label) {
        String v = Harness.line(out, label);
        return v == null ? "(no such line)" : v;
    }

    private static Double num(String out, String label) {
        String v = Harness.line(out, label);
        if (v == null) return null;
        try { return Double.parseDouble(v.trim()); } catch (NumberFormatException e) { return null; }
    }
}
