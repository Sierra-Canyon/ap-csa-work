# Pair problems: W0 to W3

**One laptop between two people.** The driver types and nothing else. The navigator
reads the spec, watches the screen, and thinks out loud. The navigator's hands stay
off the keyboard. **Swap driver after every problem.**

Four files, all in this folder. Three are empty and waiting for you. The fourth is
already written and already broken.

| | File | What it is |
|---|---|---|
| 1 | `Split.java` | write it |
| 2 | `DigitWork.java` | write it, swap driver first |
| 3 | `Bell.java` | write it, swap driver first |
| 4 | `ScoreCard.java` | **already written, four bugs.** Swap driver first |

**Each file's spec and test table are in the comment at the top of it.** Open the
file, read the header, write the code underneath.

## Running one

```
cd practice
javac Split.java
java Split
```

`javac` takes a *file*, `java` takes a *class*, which is why the second command has
no `.java` on it.

## Nothing here is graded

`bash scripts/check.sh` compiles `src`, `tools` and `tests` only. This folder is
never built, so code in here that does not compile cannot turn a check red. That is
deliberate. This is where you are allowed to be wrong, at length, in public.

Getting these wrong today is free. Getting them wrong Monday is not.

## When you finish

```
git add practice
git commit -m "feat: Add pair problems for Sept 10th (CW)"
git push
```
