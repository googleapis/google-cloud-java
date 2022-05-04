#!/bin/bash

# https://stackoverflow.com/questions/1425892/how-do-you-merge-two-git-repositories

set -xe

rm -rf monorepo
mkdir monorepo

cp monorepo.sh monorepo
cp repos.txt monorepo

cd monorepo

git clone https://github.com/newren/git-filter-repo.git
export PATH=$PATH:~/projects/monorepo/git-filter-repo

mkdir google-cloud-java
cd google-cloud-java
git init

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

# generate coverage report
mkdir CoverageAggregator
cp ../../coverage.pom.xml CoverageAggregator/pom.xml

# create aggregator project for jacoco
mvn compile -Dexec.executable='echo' \
-Dexec.args='<dependency><groupId>${project.groupId}</groupId><artifactId>${project.artifactId}</artifactId><version>${project.version}</version></dependency>' \
exec:exec -q | grep -v 'CoverageAggregator\|bom\|parent\|proto\-\|grpc-\|google\-cloud\-java' >> ../coverage-modules.txt

# insert processed modules into aggregator pom.xml
awk -v MODULES="`awk -v ORS='\\\\n' '1' ../coverage-modules.txt`" '1;/<dependencies>/{print MODULES}' ../../coverage.pom.xml > CoverageAggregator/pom.xml

mvn install
mvn jacoco:report-aggregate

