#!/bin/bash
# ./generation/diff_jar.sh $mavenFileURL $sonatypeFileURL $artifactName $jar-type
# this command generates difference in files for the $artifactName. If diff found, writes to diffSummary.txt
#no diff found (success) results are written to matchSummary.txt

wget -O mavenFile $1

wget -O sonatypeFile $2

unzip -l mavenFile >>output-1.txt
#this command checks for filesize differences along with filename diff
cat output-1.txt | awk 'BEGIN{OFS=":"} {print $4,$1}' | sort >>firstFile.txt

#this command checks only for filename diff
#cat output-1.txt | awk '{print $4}' | sort >> firstFile.txt

unzip -l sonatypeFile >>output-2.txt
cat output-2.txt | awk 'BEGIN{OFS=":"} {print $4,$1}' | sort >>secondFile.txt
#cat output-2.txt | awk '{print $4}' | sort >> secondFile.txt

if diff firstFile.txt secondFile.txt >/dev/null; then
  echo "$3 $4 diff success" >>matchSummary.txt
else
  echo "---------------------------------^NEW-DIFF-FOUND^-----------------------------------------" >>allDifferencesFound.txt
  echo "$3 $4 diff differences:" >>allDifferencesFound.txt
  diff firstFile.txt secondFile.txt >>allDifferencesFound.txt

  echo "$3 $4 diff failed" >>modulesDiff.txt
fi

rm -f mavenFile
rm -f sonatypeFile
rm -f output-1.txt
rm -f output-2.txt
rm -f firstFile.txt
rm -f secondFile.txt
