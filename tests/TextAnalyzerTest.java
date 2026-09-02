/**
 * Project: Text Analyzer.  40 of the 50 points are checked here. The remaining
 * 10 are the demo and the commit history, both of which a human reads.
 */
public class TextAnalyzerTest {

    // sentence | words, longest, vowels, longerThanFour, palindrome, mostFrequent
    private static final String[][] CASES = {
        {"never odd or even",           "4", "never", "6", "1", "true",  "e"},
        {"the quick brown fox",         "4", "quick", "5", "2", "false", "o"},
        {"a",                           "1", "a",     "1", "0", "true",  "a"},
        {"Was it a car or a cat I saw", "9", "Was",   "9", "0", "true",  "a"},
        {"Madam In Eden Im Adam",       "5", "Madam", "8", "1", "true",  "a"},
    };

    private static final String[] LABELS =
        {"Words:", "Longest:", "Vowels:", "Longer than four:", "Palindrome:", "Most frequent:"};
    private static final String[] NAMES =
        {"word count", "longest word", "vowel count", "words longer than four",
         "palindrome test", "most frequent letter"};
    private static final int[] POINTS = {6, 7, 7, 6, 7, 7};

    public static void run(Check c) {
        c.begin("Project: Text Analyzer");
        if (Harness.isStub("TextAnalyzer")) {
            c.skip("all checks", 40, "not started");
            return;
        }

        int[] correct = new int[LABELS.length];
        StringBuilder[] trouble = new StringBuilder[LABELS.length];
        for (int i = 0; i < trouble.length; i++) trouble[i] = new StringBuilder();

        for (String[] k : CASES) {
            String out;
            try {
                out = Harness.run("TextAnalyzer", k[0] + "\n");
            } catch (Harness.NotRunnable e) {
                c.fail("runs at all", 40, e.getMessage());
                return;
            }
            for (int i = 0; i < LABELS.length; i++) {
                String got = Harness.line(out, LABELS[i]);
                if (got != null && got.equals(k[i + 1])) {
                    correct[i]++;
                } else {
                    trouble[i].append("\n              \"").append(k[0]).append("\" -> expected ")
                              .append(LABELS[i]).append(" ").append(k[i + 1])
                              .append(", got \"").append(got).append("\"");
                }
            }
        }

        for (int i = 0; i < LABELS.length; i++) {
            c.isTrue(NAMES[i], POINTS[i], correct[i] == CASES.length,
                     correct[i] + " of " + CASES.length + " sentences correct." + trouble[i]);
        }
    }
}
