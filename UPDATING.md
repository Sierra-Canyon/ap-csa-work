# Getting updates from the assignment template

Sometimes I fix or add something in the starter repository after you have already
started working. **Your repository is a copy of that starter, not a fork**, so those
changes do not arrive on their own. This page is how you pull them in.

You do the setup once. After that it is a single `git pull`.

---

## Setup, once per repository

### 1 · Add my repository as a second remote

Your repo already has a remote called `origin`, which is your copy on GitHub. You are
adding a second one, `template`, pointing at mine.

```bash
git remote add template https://github.com/Sierra-Canyon/ap-csa-work.git
git fetch template --tags
git remote -v
```

You should see four lines: `origin` twice, `template` twice. You will only ever fetch
from `template`. You do not have permission to push to it.

Already done it? You will get `error: remote template already exists`. Fine, skip on.

### 2 · Link the two histories

Try pulling right now and git refuses:

```
fatal: refusing to merge unrelated histories
```

**That is not a bug.** When your repository was created it got a copy of my files with a
brand-new history, so git cannot see how the two are related. It will not guess. You
tell it, once:

```bash
git checkout main
git merge -s ours --allow-unrelated-histories -m "Link template history" baseline
```

`baseline` is a tag I put on the commit your repo was created from. `-s ours` means
"record that these are related, change no files." Check that it did nothing to your
work:

```bash
git diff HEAD~1 HEAD --stat     # should print nothing
git push
```

Setup done, permanently.

---

## Every time I announce an update

```bash
git status                            # commit your own work first, this must be clean
git checkout main
git pull --no-rebase template main    # <- that is it
git push

git checkout jd12-unit1               # your branch, with your username
git merge main
```

> **`--no-rebase` is not optional, and leaving it off is the one way to make a mess
> here.** In setup you told git `pull.rebase true`, which is right for your own work
> and wrong for this. Without the flag git rebases your `main` on top of mine,
> rewrites the history your repository was created with, and then refuses your
> `git push` because the two no longer match. The next thing anybody tries at that
> point is a force-push, which is rule 3. Type the flag.

Because the histories are linked, git now knows what changed on my side, what changed on
yours, and combines them. **Files you have edited are not overwritten.** Files you never
touched update silently.

---

## If the pull reports a conflict

```
CONFLICT (content): Merge conflict in practice/ScoreCard.java
Automatic merge failed; fix conflicts and then commit the result.
```

Not a failure. It means you and I edited the same lines, and git will not choose for you.

```bash
git status                 # lists the conflicted files
```

Open each one. You will find:

```
<<<<<<< HEAD
        double average = (double) total / games;
=======
        double average = total / games;
>>>>>>> 1eb1bb4 (template update)
```

Between `<<<<<<< HEAD` and `=======` is **yours**. Between `=======` and `>>>>>>>` is
**mine**. Edit the file into what you actually want, often your version plus whatever I
added, then delete all three marker lines. **The file must read as normal Java when you
are done.**

```bash
git add practice/ScoreCard.java
git commit                 # finishes the merge
git push
```

### To back out and try again

```bash
git merge --abort
```

Puts you exactly back where you were. Completely safe, no penalty, use it freely. If you
are stuck: abort, then come ask me. **Never delete and re-clone your repository.** Your
work lives there.

---

## Rules

1. **Commit your own work before pulling.** `git status` must be clean.
2. **Read the diff before you merge.** If something surprises you, ask.
3. **Never force-push** to fix a merge you do not understand.
4. **Log the update in your student log** like any other work session.
