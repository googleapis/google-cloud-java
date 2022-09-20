#!/bin/bash
# ./generation/diff_jar.sh $mavenFileURL $sonatypeFileURL $artifactName
#for example: to-do
# this command generate difference in files for the $artifactName -> ${artifactName}-finalDiff.txt
# in case of no-diff, output file is empty
#in case of diff, output file contains filenames that one directory has and the other doesnt, and vice versa

mkdir -p diffFiles/$3/$4
cd diffFiles/$3/$4

rm -f mavenFile
rm -f sonatypeFile
rm -f output-1.txt
rm -f output-2.txt
rm -f firstFile.txt
rm -f secondFile.txt

wget -O mavenFile $1

wget -O sonatypeFile $2

unzip -l mavenFile >> output-1.txt
cat output-1.txt | awk '{print $4}' | sort -k3 >> firstFile.txt

unzip -l sonatypeFile >> output-2.txt
cat output-2.txt | awk '{print $4}' | sort -k3 >> secondFile.txt

diff firstFile.txt secondFile.txt >> "$3-$4-diff.txt"



