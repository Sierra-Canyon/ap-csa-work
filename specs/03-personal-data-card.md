# Personal Data Card

**Out Friday 16 October, due Monday 26 October, over the break. 20 points,
graded on completion rather than correctness.**
File: `src/PersonalDataCard.java`

The tests are here because this is the one thing you do with nobody to ask. Run
them and find out for yourself.

## Input

Three lines:

```
Ada Lovelace
1985
472
```

A full name, a birth year, and a favourite number between 100 and 999.

## Output

```
Initials: AL
Age: 41
Hundreds: 4
Tens: 7
Ones: 2
ID: 4817
Favorite number is even
Name is short
```

- **Initials** are the first letter of the name and the first letter of the word
  after the first space. `indexOf(" ")` and `substring`. There is no
  `lastIndexOf` on the Quick Reference and there is no `charAt` in this course.
- **Age** is `2026 - birthYear`. Fixed at 2026 so the answer does not change in
  January.
- **Hundreds, Tens, Ones** split the favourite number with `/` and `%`.
- **ID** is a random four-digit number from 1000 to 9999. The formula is
  `(int) (Math.random() * 9000) + 1000`, not `Math.random() * 9999`, which can
  hand you a 4.
- **Favorite number is** `even` or `odd`.
- **Name is** `long` when the whole name is more than 15 characters, `short`
  otherwise.

## The cases the tests use

| name | year | number | initials | age | digits | parity | length |
|---|---|---|---|---|---|---|---|
| Ada Lovelace | 1985 | 472 | AL | 41 | 4 7 2 | even | short |
| Grace Brewster Hopper | 2010 | 250 | GB | 16 | 2 5 0 | even | long |
| Alan Turing | 1912 | 999 | AT | 114 | 9 9 9 | odd | short |

The tests check the ID's shape, never its value.

## Graded on

Completion, and the commit history. Four commits across three days over the break,
each with a message saying what you did, is the point. One commit at 11 PM on the
25th is visible in the repository, so there is nothing to argue about.
