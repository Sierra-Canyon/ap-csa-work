# Lab 1 · Unit Converter

**Written in class Thursday 17 September. Due at the end of that period. 20 points.**
File: `src/UnitConverter.java`

Convert miles to kilometres. **1 mile is 1.609344 kilometres**, and that number is
fixed so that the tests can check your answers.

## Input

One number, on one line: a distance in miles. Prompt for it however you like.

## Output

Somewhere in what you print, these two lines have to appear, in this order:

```
Truncated: 8 km
Rounded: 8 km
```

Prompts are yours. `System.out.print("Miles: ")` on the same line is fine; the
tests read the labels, not the layout.

**Truncated** means the decimal part thrown away, with a cast.
**Rounded** means the nearest whole number. `Math.round` is not on the AP Quick
Reference and is not available to you. Rounding is `(int) (km + 0.5)`.

## The cases the tests use

| miles | kilometres | Truncated | Rounded |
|---|---|---|---|
| 0 | 0.0 | 0 | 0 |
| 1 | 1.609344 | 1 | **2** |
| 3 | 4.828032 | 4 | **5** |
| 5 | 8.04672 | 8 | 8 |
| 10 | 16.09344 | 16 | 16 |
| 26 | 41.842944 | 41 | **42** |
| 100 | 160.9344 | 160 | **161** |

The four bold rows are the lab. A program that casts twice passes three cases and
fails four, and that is the mistake this lab exists to catch.

## Graded on

| | Points | Checked by |
|---|---|---|
| Reads the number with `Scanner` and prompts clearly | 4 | tests |
| Truncates with a cast | 4 | tests |
| Rounds, rather than truncating twice | 4 | tests |
| Meaningful variable names, camelCase | 4 | me |
| A comment at the top stating the precondition | 4 | me |

**The precondition** is the promise the person running your program has to keep.
*Assumes a non-negative number of miles* is a precondition, and it is a real one
here: `(int) (km + 0.5)` rounds the wrong way for negative distances.

## Where people lose points

Getting a whole number by accident rather than by casting. Rounding with `(int)`
alone, which truncates. And forgetting that `(double) (7 / 2)` and
`(double) 7 / 2` are different answers.
