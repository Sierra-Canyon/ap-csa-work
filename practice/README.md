# practice

**Everything you type along with in class lives here.** The programs I write on the
board, the parallel problem you do in pairs afterwards, anything you are trying out
because you want to know what it does.

`src/` is different: that holds the five programs that are graded, each one against
a spec. This folder holds the other four days a week.

## Running one file

Nothing here is built by a build system. One file, two commands:

```
cd practice
javac Greeter.java
java Greeter
```

`javac` turns `Greeter.java` into `Greeter.class`. `java Greeter` runs it. Note the
missing `.java` on the second command: you compile a *file*, then you run a *class*.
Getting those the wrong way round is the second most common day-one error, behind
capital letters in file names.

## Three things worth knowing

**The autograder ignores this folder.** `bash scripts/check.sh` compiles `src/`,
`tools/` and `tests/` only. Code in here that does not compile will never fail your
build or turn a check red. That is deliberate: this is where you are allowed to be
wrong, at length, in public.

**It is still committed, and I still read it.** Not for correctness. For whether the
work happened across the week or in one sitting the night before, which is a
different question and one git answers by itself.

**Name files after the class, not after the day.** `Digits.java`, not
`sept9.java`. In February you will want to find the integer division one, and you
will not remember that it was a Wednesday.

## What ends up in here

One file per walkthrough, roughly, plus your own parallel problems:

| | |
|---|---|
| `Greeter.java` | how code runs and how it breaks |
| `Receipt.java` | static typing and primitive types |
| `Digits.java` | integer division and modulo |
| `Scores.java` | assignment, Scanner input, compound operators |
| ... | and so on, one a meeting |

You write these yourself, as I write them. Copying my screen character for
character and copying my screen while thinking about it look identical in the file
and are not the same activity. The one that survives to May is the second one.
