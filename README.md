# AP Computer Science A: Your Work

**Period B · 2026–27 · Mr. DeVaughn-Brown · Room U 108**

Your code lives here. Your log lives in the other repository, `student-log`. Both
are yours, both are private to you and me, and both are read on pull requests.

There is an autograder in here. It runs when you push and you can run it yourself
any time. **It is not your grade.** It checks the things a machine can check, which
is roughly two thirds of the points, and it can only ever tell you that something
is wrong, never that your program is good.

---

## What is in here

```
src/          your programs. One file per assignment. This is where you work.
specs/        what each program has to do, exactly. Read the spec first.
tests/        the autograder's tests. Read them if you want; do not edit them.
tools/        the machinery that runs the tests. Leave it alone.
scripts/      check.sh, which runs everything.
rainfall.txt  data for the March lab.
```

---

## Setup, once

You already did the hard part on 2 September: a JDK, VS Code, the Extension Pack
for Java, and git configured. Nothing new to install here.

```
git clone <your repo url>
cd <your repo>
bash scripts/check.sh
```

That last command should print `Compiles.` and then five assignments listed as
`not started`. If it does, you are ready.

**Nothing here needs Maven, Gradle, or a download.** It runs on the JDK you already
have, on a plane, on the school wifi, in a power cut with a laptop battery.

---

## Every assignment, the same five steps

1. **Read the spec** in `specs/`. All of it, including the table of test cases.
   The cases are not a hint, they are the assignment.
2. **Cut a branch.** One per unit, your GitHub username plus the unit, hyphens
   never slashes:

   ```
   git checkout main
   git pull
   git checkout -b jd12-unit1
   git push -u origin jd12-unit1
   ```

3. **Delete the `NOT STARTED YET` line** from the file in `src/`. Until it is gone
   the autograder skips that assignment instead of failing it, which is why you do
   not open this repository in September to a wall of red for a lab due in March.
4. **Write it, running `bash scripts/check.sh` as you go.** Commit each time
   something new works. Four commits across three days tells me how you got there.
   One commit at 11:47 PM tells me nothing.
5. **Open a pull request** into `main` and fill in the template honestly.

---

## Reading the autograder

```
Lab 1: Unit Converter
---------------------
  PASS  reads the number from input            4 pts
  PASS  truncates with a cast                  4 pts
  FAIL  rounds, rather than truncating twice   4 pts
              3 of 7 correct. Rounding is (int)(km + 0.5).
              1 miles: expected "1 km" / "2 km", got "1 km" / "1 km"
              3 miles: expected "4 km" / "5 km", got "4 km" / "4 km"
```

Every failure names the input, what the spec wanted, and what your program did.
That is the whole debugging loop handed to you: pick the first failing case, work
out by hand what should happen, then find the line where your program disagrees.

`....` means not started. Those points are not counted against you.

### It does not compile

Then nothing runs, and the autograder says so instead of pretending. Read the
**first** error; the rest are usually consequences of it. Java points at where it
*noticed* the problem, not where you made it, so when the caret is sitting on
innocent code, look at the line above.

---

## The AP subset scan

After the tests, a second tool reads your code and points out Java that works
perfectly and **will not be available to you in May**: `charAt`, `char`,
`Math.round`, `StringBuilder`, `switch`, `HashMap`, a ternary `?:`, and a dozen
others. The exam gives you one page of methods, and that page is small.

**This never fails anything.** It is a note, not a mark. It exists because a model
will hand you the whole language when you ask it a question, and it has no idea
which corner of it you are allowed to use. The cheapest moment to find out is
before the habit sets, not in May.

If the scan flags something in a file I gave you, that is deliberate and the file
says so.

---

## What the autograder cannot see

Roughly a third of the points on every assignment, and they are not the easy third:

- whether your variable names say what the variables hold
- whether the precondition comment is there and true
- whether you predicted the output before you ran it
- whether you committed as you worked or the night before
- whether you can answer a question about your own code in December

Those are read by a person. A program that passes every test and is named `a`,
`b`, `c` is not a program that got full marks.

---

## Honesty

If it does not compile, or the tests fail, **open the pull request anyway and say
so.** That is worth more than silence and it is worth considerably more than a
quiet submission hoping I will not run it. I run it, and the run is in the
repository either way.
