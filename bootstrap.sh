#!/bin/bash

# https://stackoverflow.com/questions/1425892/how-do-you-merge-two-git-repositories

set -xe

[ -z "`git config user.email`" ] && git config --global user.email "${USERNAME:-script}@google.com"
[ -z "`git config user.name`" ] && git config --global user.name "${USERNAME:-script}"

rm -rf monorepo
mkdir monorepo

cp bootstrap.sh monorepo
cp repos.txt monorepo

cd monorepo

git clone https://github.com/newren/git-filter-repo.git
export PATH=$PATH:`pwd`/git-filter-repo

mkdir google-cloud-java

cd google-cloud-java
git init -b main

cat ../../repos.txt | while read service
do
  cd ..
  echo "    <module>${service}</module>" >> repo-modules.txt
  git clone https://github.com/googleapis/${service}.git
  cd  ${service}
  git filter-repo --to-subdirectory-filter ${service}
  cd ../google-cloud-java
  git remote add ${service} ../${service}
  git fetch ${service} #--tags
  EDITOR=true git merge --allow-unrelated-histories ${service}/main
  git remote remove ${service}
  rm -rf ../${service}
done

cd ..

# insert processed modules into aggregator pom.xml
awk -v MODULES="`awk -v ORS='\\\\n' '1' repo-modules.txt`" '1;/<modules>/{print MODULES}' ../parent.pom.xml > google-cloud-java/pom.xml

cd google-cloud-java

git add pom.xml
git commit -am 'feat: create aggregator pom'

cp -r --preserve=all ../../templates/. ./
git add --all
git commit -m 'chore: add template files'

# generate coverage report
mkdir CoverageAggregator
cp ../../coverage.pom.xml CoverageAggregator/pom.xml

# create aggregator project for jacoco
mvn compile -Dexec.executable='echo' \
-Dexec.args='<dependency><groupId>${project.groupId}</groupId><artifactId>${project.artifactId}</artifactId><version>${project.version}</version></dependency>' \
exec:exec -q -B | grep -v 'CoverageAggregator\|bom\|parent\|proto\-\|grpc-\|google\-cloud\-java' >> ../coverage-modules.txt

# insert processed modules into coverage aggregator pom.xml
awk -v MODULES="`awk -v ORS='\\\\n' '1' ../coverage-modules.txt`" '1;/<dependencies>/{print MODULES}' ../../coverage.pom.xml > CoverageAggregator/pom.xml

# add CoverageAggregator to root pom
awk -v MODULE='    <module>CoverageAggregator</module>' '/<\/modules>/{print MODULE};1' pom.xml > pom.xml.tmp && mv pom.xml.tmp pom.xml

git add --all
git commit -am 'feat: create CoverageAggregator module'
