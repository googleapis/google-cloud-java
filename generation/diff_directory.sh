#!/bin/bash
## This is a helper script invoked by ./generation/diff_files.sh
## All the inputs to this script are provided by diff_files.sh
## You do not need to do anything for this script to run.
## Inputs provided in sequential order are :
## 1. ${mavenURL} -> The URL for artifact's latest version directory on maven central
## 2. ${sonatypeURL} -> The URL for artifact's staging directory on google sonatype
## 3. ${artifactId} -> self-explanatory
## 4. ${groupId} -> artifact's groupId
## output for this script are 2 files:
#     1. diff-files-summary.txt : This will show success for artifacts which have same files on maven-central and sonatype,
#     and if they differ, it will show a diff failure message along with the names of the files that differ.
#     2. total-diff.txt : For every artifact, this will show 4 things:
         # a. Sonatype directory URL
         # b. Files that exist on sonatype (with version omitted, since we only care about the file generated)
         # c. Maven directory URL
         # d. Files that exist on Maven (with version omitted, since we only care about the file generated)

mavenCentralURL=$1
sonatypeURL=$2
artifactId=$3
groupId=$4

wget -O sonatypeFile --recursive -nd --no-parent ${sonatypeURL}

##why --header="User-Agent: ? -> Maven central denies CLI requests to browse a directory URL, so imitating a browser's behaviour by using this header.
wget -O mavenFile --referer --recursive -nd --no-parent \
  --header="User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36" \
  ${mavenCentralURL}

sed -n 's/.*href="\([^"]*\).*/\1/p' mavenFile >mavenContents.txt
sed -n 's/.*href="\([^"]*\).*/\1/p' sonatypeFile >sonatypeContents.txt

awk "/${groupId}/" sonatypeContents.txt >temp.txt

if [[ "${groupId}" = *api* ]]; then
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
echo "----${artifactId} Sonatype files : ${sonatypeURL}" >>total-diff.txt
cat finalSonatype.txt >>total-diff.txt
echo "----${artifactId} Maven files : ${mavenCentralURL}" >>total-diff.txt
cat finalMaven.txt >>total-diff.txt

echo "--------------------------------------------------------------------------------------------" >>diff-files-summary.txt
if diff finalMaven.txt finalSonatype.txt >/dev/null; then
  echo -e "${artifactId} File match success" >>diff-files-summary.txt
else
  echo "---------------------------------^NEW-DIFF-FOUND^-----------------------------------------" >>diff-files-summary.txt
  echo "${artifactId} diff:" >>diff-files-summary.txt
  diff finalMaven.txt finalSonatype.txt >>diff-files-summary.txt
fi

rm -f mavenFile
rm -f sonatypeFile
rm -f mavenContents.txt
rm -f sonatypeContents.txt
rm -f finalSonatype.txt
rm -f finalMaven.txt
rm -f temp.txt
