#!/bin/bash
# ./generation/diff_pom.sh $mavenFileURL $sonatypeFileURL $artifactName pom
# this command generate difference in pom files for the $artifactName
# in case of no-diff, writes the summary to matchSummary.txt
#in case of diff, writes the diff to diffSummary.txt

wget -O mavenFile $1

wget -O sonatypeFile $2

if diff mavenFile sonatypeFile >/dev/null; then
  echo "$3 $4 diff success" >>matchSummary.txt
else
  echo "---------------------------------^NEW-DIFF-FOUND^-----------------------------------------" >>allDifferencesFound.txt
  echo "$3 $4 diff differences:" >>allDifferencesFound.txt
  diff mavenFile sonatypeFile >>allDifferencesFound.txt
  echo "$3 $4 diff failed" >>modulesDiff.txt
fi

rm -f mavenFile
rm -f sonatypeFile
