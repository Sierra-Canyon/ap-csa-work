# Project · Text Analyzer

**Built in class across three meetings, 19 November to 30 November. Demos on the
due date. 50 points.**
File: `src/TextAnalyzer.java`

One program, all in `main`. No methods yet; that is Unit 3. Thanksgiving falls in
the middle of the build stretch: working over the break is optional and never
required.

## Input

One line: a sentence, with single spaces between words and no punctuation.

## Output

```
Words: 4
Longest: never
Vowels: 6
Longer than four: 1
Palindrome: true
Most frequent: e
```

Each line, pinned down so there is nothing to guess:

- **Words** is `split(" ")` and its length.
- **Longest** is the first word with the greatest `length()`. Ties go to the
  earlier word.
- **Vowels** counts a, e, i, o, u in the whole sentence, ignoring case. The idiom
  is `"aeiou".indexOf(ch) >= 0` where `ch` is `substring(i, i + 1)`.
- **Longer than four** counts words whose `length()` is more than 4.
- **Palindrome** ignores spaces and case and reads the whole sentence. `true` or
  `false`, lower case, which is what printing a `boolean` gives you.
- **Most frequent** is the letter a to z that appears most, ignoring case. Ties go
  to the letter earlier in the alphabet.

**There is no `charAt` in this course.** A single character is a one-character
String from `substring(i, i + 1)`, compared with `.equals()`. The CED says so at
1.15.B.3, and the Quick Reference you get in May does not list `charAt`.

## The cases the tests use

| sentence | words | longest | vowels | > 4 | palindrome | most frequent |
|---|---|---|---|---|---|---|
| never odd or even | 4 | never | 6 | 1 | true | e |
| the quick brown fox | 4 | quick | 5 | 2 | false | o |
| a | 1 | a | 1 | 0 | true | a |
| Was it a car or a cat I saw | 9 | Was | 9 | 0 | true | a |
| Madam In Eden Im Adam | 5 | Madam | 8 | 1 | true | a |

Row three is one word, one letter. Programs that assume at least two words fail
there, which is the cheapest bug in the set to find and the easiest to leave in.

## Graded on

| | Points | Checked by |
|---|---|---|
| Word count | 6 | tests |
| Longest word | 7 | tests |
| Vowel count | 7 | tests |
| Words longer than four | 6 | tests |
| Palindrome | 7 | tests |
| Most frequent letter | 7 | tests |
| The demo, and answering a question about your own code | 10 | me |
