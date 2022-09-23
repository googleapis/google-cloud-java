#!/bin/bash
## This is a helper script invoked by ./generation/diff_files.sh
## All the inputs to this script are provided by diff_files.sh
## You do not need to do anything for this script to run.

wget -O sonatypeFile --recursive -nd --no-parent $2

wget -O mavenFile --referer --recursive -nd --no-parent \
  --header="User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36" \
  $1

sed -n 's/.*href="\([^"]*\).*/\1/p' mavenFile >mavenContents.txt
sed -n 's/.*href="\([^"]*\).*/\1/p' sonatypeFile >sonatypeContents.txt

awk "/$4/" sonatypeContents.txt >temp.txt

if [[ "${4}" = *api* ]]; then
  cat temp.txt | while read line; do
    echo ${line} | awk -F '[/]' '{print $13}' | sed 's/[0-9]*//g' >>finalSonatype.txt
  done
else
  cat temp.txt | while read line; do
    echo ${line} | awk -F '[/]' '{print $12}' | sed 's/[0-9]*//g' >>finalSonatype.txt
  done
fi

cat mavenContents.txt | while read line; do
  echo ${line} | sed 's/[0-9]*//g' >>finalMaven.txt
  done
sed -i '' '1d' finalMaven.txt

echo "###################################################################################################################################" >>total-diff.txt
echo "----$3 Sonatype files : $2" >>total-diff.txt
cat finalSonatype.txt >>total-diff.txt
echo "----$3 Maven files : $1" >>total-diff.txt
cat finalMaven.txt >>total-diff.txt

echo "--------------------------------------------------------------------------------------------" >>diff-files-summary.txt
if diff finalMaven.txt finalSonatype.txt >/dev/null; then
  echo -e "$3 File match success" >>diff-files-summary.txt
else
  echo "---------------------------------^NEW-DIFF-FOUND^-----------------------------------------" >>diff-files-summary.txt
  echo "$3 diff:" >>diff-files-summary.txt
  diff finalMaven.txt finalSonatype.txt >>diff-files-summary.txt
fi

rm -f mavenFile
rm -f sonatypeFile
rm -f mavenContents.txt
rm -f sonatypeContents.txt
rm -f finalSonatype.txt
rm -f finalMaven.txt
rm -f temp.txt
