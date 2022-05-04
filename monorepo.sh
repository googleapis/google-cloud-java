#!/bin/bash

# https://stackoverflow.com/questions/1425892/how-do-you-merge-two-git-repositories

set -xe

cd ~/projects

rm -rf monorepo
mkdir monorepo

cp google-cloud-java/monorepo.sh monorepo

cd monorepo

git clone git@github.com:newren/git-filter-repo.git
export PATH=$PATH:~/projects/monorepo/git-filter-repo

echo $PATH

mkdir google-cloud-java
cp ../google-cloud-java/pom.xml google-cloud-java
cp ../google-cloud-java/repos.txt google-cloud-java
cd google-cloud-java
git init

cat repos.txt | while read service
do
  cd ..
  echo "    <module>${service}</module>" >> modules.txt
  git clone git@github.com:googleapis/${service}.git
  cd  ${service}
  git filter-repo --to-subdirectory-filter ${service}
  cd ../google-cloud-java
  git remote add ${service} ../${service}
  git fetch ${service} #--tags
  EDITOR=true git merge --allow-unrelated-histories ${service}/main
  git remote remove ${service}
  # rm -rf ../java-${service}
done

cd ..

# remove existing modules
grep -v '<module>' ../google-cloud-java/pom.xml > pom.xml

# insert processed modules
awk -v MODULES="`awk -v ORS='\\\\n' '1' modules.txt`" '1;/<modules>/{print MODULES}' pom.xml > google-cloud-java/pom.xml

cd google-cloud-java

# generate coverage report
mkdir CoverageAggregator

cat <<EOT > CoverageAggregator/pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <artifactId>google-cloud-java</artifactId>
    <groupId>com.google.api</groupId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <artifactId>CoverageAggregator</artifactId>

  <properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <dependencies>
EOT

mvn compile -Dexec.executable='echo' \
-Dexec.args='<dependency><groupId>${project.groupId}</groupId><artifactId>${project.artifactId}</artifactId><version>${project.version}</version></dependency>' \
exec:exec -q | grep -v 'CoverageAggregator\|bom\|parent\|proto\-\|grpc-\|google\-cloud\-java' >> CoverageAggregator/pom.xml

cat <<EOT>> CoverageAggregator/pom.xml
  </dependencies>

</project>
EOT

mvn install
mvn jacoco:report-aggregate

