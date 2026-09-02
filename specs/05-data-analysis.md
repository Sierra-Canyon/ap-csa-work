# Lab 4 · Data Analysis

**Written in class Wednesday 10 March. Due at the end of that period. 20 points.**
File: `src/DataAnalysis.java`

Read `rainfall.txt` with `File` and `Scanner` into an `ArrayList`, then report on
it. The file is at the top of the repository, so `new File("rainfall.txt")` finds
it as long as you run from there.

`Scanner(File)` can fail, so `main` needs `throws FileNotFoundException`. That is
not exception handling and it is not a workaround; it is the only way the language
will let you open a file.

## Output

```
Count: 8
Mean: 1.7125000000000001
Max: 5.4
Above mean: 3
```

- **Count** is how many readings the file held.
- **Mean** is the sum divided by the count, printed as it comes out. Do not round
  it. The tests accept anything within a billionth of 1.7125.
- **Max** is the largest reading.
- **Above mean** counts readings strictly greater than the mean.

## Also answer, in your log

1. The mean prints as `1.7125000000000001`. Why?
2. Two readings are `0.0`. How would your program tell a day with no rain apart
   from a day where nobody wrote the number down?
3. What would change if the file had one reading in it? What about none?

## Graded on

| | Points | Checked by |
|---|---|---|
| Count | 4 | tests |
| Mean | 4 | tests |
| Max | 4 | tests |
| Above mean | 4 | tests |
| The three log answers | 4 | me |
