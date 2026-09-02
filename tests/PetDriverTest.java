/**
 * Lab 2: Object Driver.  16 points of behaviour are checked here. Two of those
 * items also require a written comment, which only a human can read.
 */
public class PetDriverTest {

    public static void run(Check c) {
        c.begin("Lab 2: Object Driver");
        if (Harness.isStub("PetDriver")) {
            c.skip("all checks", 16, "not started");
            return;
        }
        String out;
        try {
            out = Harness.run("PetDriver", "");
        } catch (Harness.NotRunnable e) {
            c.fail("runs at all", 16, e.getMessage());
            return;
        }

        boolean ctor = eq(out, "Name:", "Rex")
                    && eq(out, "Rex months:", "36")
                    && eq(out, "Buddy months:", "0");
        c.isTrue("uses both constructors", 4, ctor,
                 "expected Name: Rex / Rex months: 36 / Buddy months: 0, got:\n              "
                 + show(out));

        c.isTrue("captures a returned value and uses it", 4, eq(out, "After birthday:", "48"),
                 "expected After birthday: 48, got \"" + Harness.line(out, "After birthday:") + "\"");

        c.isTrue("two names, one object", 4, eq(out, "Alias months:", "60"),
                 "expected Alias months: 60. Pet c = a; does not make a second pet, so a birthday"
                 + " through c is a birthday for a. Got \"" + Harness.line(out, "Alias months:") + "\"");

        c.isTrue("handles null without crashing", 4, eq(out, "Null name:", "none"),
                 "expected Null name: none, got \"" + Harness.line(out, "Null name:") + "\"");
    }

    private static boolean eq(String out, String label, String want) {
        String v = Harness.line(out, label);
        return v != null && v.equals(want);
    }

    private static String show(String out) {
        return out.trim().replace("\n", "\n              ");
    }
}
