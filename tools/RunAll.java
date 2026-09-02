import java.util.List;

/**
 * The autograder.  Runs every assignment's checks and prints one report.
 * Exit code 0 when nothing failed, 1 when something did. Work you have not
 * started yet is skipped, not failed.
 *
 *     java -cp out RunAll              everything
 *     java -cp out RunAll TextAnalyzer just that one
 */
public class RunAll {

    private static final String[][] ASSIGNMENTS = {
        {"UnitConverter",     "UnitConverterTest"},
        {"PetDriver",         "PetDriverTest"},
        {"PersonalDataCard",  "PersonalDataCardTest"},
        {"TextAnalyzer",      "TextAnalyzerTest"},
        {"DataAnalysis",      "DataAnalysisTest"},
    };

    public static void main(String[] args) throws Exception {
        Check c = new Check();
        String only = args.length > 0 ? args[0] : null;

        for (String[] a : ASSIGNMENTS) {
            if (only != null && !only.equalsIgnoreCase(a[0])) continue;
            Class.forName(a[1]).getMethod("run", Check.class).invoke(null, c);
        }

        List<Check.Result> rs = c.results();
        if (rs.isEmpty()) {
            System.out.println("Nothing to check. Did you mean one of: "
                               + String.join(", ", names()) + "?");
            return;
        }

        String current = null;
        int earned = 0, available = 0, failures = 0, skipped = 0;
        for (Check.Result r : rs) {
            if (!r.assignment.equals(current)) {
                current = r.assignment;
                System.out.println();
                System.out.println(current);
                System.out.println("-".repeat(current.length()));
            }
            if (r.skipped) {
                System.out.printf("  ....  %-38s %s%n", r.item, r.detail);
                skipped++;
                continue;
            }
            available += r.points;
            if (r.passed) {
                earned += r.points;
                System.out.printf("  PASS  %-38s %d pts%n", r.item, r.points);
            } else {
                failures++;
                System.out.printf("  FAIL  %-38s %d pts%n", r.item, r.points);
                System.out.println("              " + r.detail);
            }
        }

        System.out.println();
        System.out.println("=".repeat(62));
        if (available > 0) {
            System.out.println("Machine-checked points: " + earned + " of " + available
                               + " on the work you have started.");
        }
        if (skipped > 0) {
            System.out.println(skipped + " assignment" + (skipped == 1 ? "" : "s")
                               + " not started yet, so not counted.");
        }
        System.out.println("This is not your grade. Points for naming, comments and the log are"
                           + " read by a person.");
        System.out.println("=".repeat(62));

        if (failures > 0) System.exit(1);
    }

    private static String[] names() {
        String[] n = new String[ASSIGNMENTS.length];
        for (int i = 0; i < n.length; i++) n[i] = ASSIGNMENTS[i][0];
        return n;
    }
}
