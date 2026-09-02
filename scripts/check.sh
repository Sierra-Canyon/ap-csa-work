#!/bin/bash
# Compile everything, run the autograder, then scan for Java that is not on the
# AP subset. Needs nothing but the JDK you installed on 2 September.
#
#   bash scripts/check.sh                 everything
#   bash scripts/check.sh TextAnalyzer    just one assignment
#
# Run it from the top of the repository. rainfall.txt is found relative to there.

cd "$(dirname "$0")/.."

rm -rf out
mkdir -p out

echo "Compiling..."
if ! javac -d out $(find src tools tests -name '*.java') 2>&1; then
  echo
  echo "=============================================================="
  echo "It does not compile, so nothing below could run."
  echo "Read the FIRST error. The rest are usually consequences of it."
  echo "Java points at where it NOTICED the problem, not where you made"
  echo "it. When the caret is on innocent code, look at the line above."
  echo "=============================================================="
  exit 1
fi
echo "Compiles."
echo

java -cp out RunAll "$@"
GRADE=$?

echo
java -cp out ApSubset src

exit $GRADE
