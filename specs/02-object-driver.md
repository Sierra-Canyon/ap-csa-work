# Lab 2 · Object Driver

**You get this spec Friday 25 September and write the lab in class Tuesday 29
September, right after the walkthrough on instance methods. Due at the end of that
period. 20 points.**
File: `src/PetDriver.java`

You are given a `Pet` class in `src/Pet.java`. **You do not write it and you do not
edit it.** Writing classes is January. You write a driver: a `main` that uses it.

## The API you are given

```java
public Pet(String name, int ageYears)   // two constructors
public Pet(String name)                 //   age defaults to 0
public String getName()
public int getAgeMonths()
public void haveBirthday()              // adds twelve months, returns nothing
```

## What to do, in this order

1. Make a Pet called `Rex`, three years old, using the two-argument constructor.
   Print `Name: ` and its name, then `Rex months: ` and its age in months.
2. Make a Pet called `Buddy` using the one-argument constructor. Print
   `Buddy months: ` and its age in months.
3. Give Rex a birthday. Then **store the returned age in a variable** and print
   `After birthday: ` and that variable.
4. Write a second name for the same pet: `Pet c = a;`. Give it a birthday through
   `c`, then print `Alias months: ` followed by **`a`'s** age in months.
5. Make `Pet d = null;`. Print `Null name: ` followed by the pet's name if there is
   one and the word `none` if there is not. It must not crash.

## Required output

```
Name: Rex
Rex months: 36
Buddy months: 0
After birthday: 48
Alias months: 60
Null name: none
```

**Before you run it, write in a comment what you think each line will print.**
Leave the comment in even when you were wrong. Being wrong and knowing why earns
more here than being right by accident, and I can tell which one happened.

## Graded on

| | Points | Checked by |
|---|---|---|
| Uses both constructors | 4 | tests |
| Captures a returned value in a variable and uses it | 4 | tests |
| Two names, one object: `a` changes when `c` has a birthday | 4 | tests |
| Handles a `null` reference without crashing | 4 | tests |
| The prediction comment, and one sentence on why `haveBirthday()` cannot be printed | 4 | me |

## The one everybody gets wrong

`Pet c = a;` does not make a second pet. It makes a second name for the same pet.
Step 4 is the whole lab.
