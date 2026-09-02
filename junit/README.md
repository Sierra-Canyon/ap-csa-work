# From January: JUnit 5

Everything in `tests/` runs with nothing but the JDK, on purpose. That was the
right call for the autumn, because through November every graded program is a
`main` that reads input and prints, and there is no method anywhere to call.

**Unit 3 changes that.** From January you write classes with methods, and a method
you can call is a method a real test framework can test one at a time. That is
what JUnit is for and that is when it earns its download.

## What to do when the first Unit 3 lab exists

1. Drop the console launcher into `lib/`, which is git-ignored:

   ```
   mkdir -p lib
   curl -sSL -o lib/junit-console.jar \
     https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar
   ```

2. Write tests as ordinary JUnit 5 classes in `tests/`, next to the existing ones:

   ```java
   import org.junit.jupiter.api.Test;
   import static org.junit.jupiter.api.Assertions.*;

   public class BankAccountTest {
       @Test
       void depositAddsToBalance() {
           BankAccount a = new BankAccount("Ada", 100);
           a.deposit(50);
           assertEquals(150, a.getBalance());
       }
   }
   ```

3. Compile and run them alongside the plain ones:

   ```
   javac -cp lib/junit-console.jar -d out $(find src tools tests -name '*.java')
   java -jar lib/junit-console.jar --class-path out --scan-class-path
   ```

4. Add the same two lines to `.github/workflows/autograde.yml`, after the
   Autograde step. Cache `lib/` with `actions/cache` so the jar is fetched once.

## Why the plain runner stays

School networks block things. Maven Central was unreachable from two different
machines while this repository was being built. `bash scripts/check.sh` has to
work on the first Wednesday of the year, on thirteen laptops, one of which is
behind a filter nobody told you about. It needs no network at all, and that is
worth keeping even after JUnit arrives beside it.
