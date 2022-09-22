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
  git clone https://github.com/googleapis/${service}.git
  cd  ${service}
  git filter-repo --to-subdirectory-filter ${service}

  # Search for <parent> tag in module pom and replace the next three lines -- groupId, artifcatId, and version
  sed -i.bak -e '/<parent>/{N;s/com.google.cloud/com.google.api/;N;s/google-cloud-shared-config/google-cloud-java/;N;s/<version>.*<\/version>/<version>0.0.1-SNAPSHOT<\/version>/}' ${service}/pom.xml && rm ${service}/pom.xml.bak

  NAME=$(jq -r '.distribution_name' ${service}/.repo-metadata.json | cut -d ':' -f 2)
  # Search for <parent> tag in module bom and replace the next three lines -- groupId, artifcatId, and version
  sed -i.bak -e '/<parent>/{N;s/com.google.cloud/com.google.api/;N;s/google-cloud-shared-config/google-cloud-java/;N;s/<version>.*<\/version>/<version>0.0.1-SNAPSHOT<\/version>\n    <relativePath>..\/..\/pom.xml<\/relativePath>/}' ${service}/${NAME}-bom/pom.xml && rm ${service}/${NAME}-bom/pom.xml.bak

  # setup owlbot files correctly to match monorepo configuration
  cp ${service}/.github/.OwlBot.yaml ${service}/.OwlBot.yaml
  rm ${service}/.github/.OwlBot.lock.yaml
  rm ${service}/.github/.OwlBot.yaml
  sed -i.bak '/docker/d' ${service}/.OwlBot.yaml && rm ${service}/.OwlBot.yaml.bak
  sed -i.bak '/image/d' ${service}/.OwlBot.yaml && rm ${service}/.OwlBot.yaml.bak

  # In monorepo, the staging directory structure tells the destination module to
  # which the OwlBot Java postprocessor copies the files.
  sed -i.bak "s|owl-bot-staging|owl-bot-staging/${service}|" ${service}/.OwlBot.yaml && rm ${service}/.OwlBot.yaml.bak

  text=$(grep '^.*api_shortname.*' ${service}/.repo-metadata.json)
  text=$(echo "$text" | sed 's/\"//g; s/\,//g; s/^[[:space:]]*//' )
  text=${text/api_shortname/api-name}
  echo -e "\n"$text>> ${service}/.OwlBot.yaml
  git add .
  git config --add secrets.allowed "dest.*src"
  git commit -am "chore: setup owlbot configuration"

  cd ../google-cloud-java
  git remote add ${service} ../${service}
  git config --add secrets.allowed "dest.*src"
  git fetch ${service} #--tags
  EDITOR=true git merge --quiet --allow-unrelated-histories ${service}/main
  git remote remove ${service}
  rm -rf ../${service}
done

# cwd: monorepo/google-cloud-java
echo "Working directory: $(pwd)"
../../templates/generation/print_root_pom.sh > pom.xml

git add pom.xml
git commit -am 'feat: create aggregator pom'

# Template files
cp -rp ../../templates/. ./

# Add all template files
git add --all
git add -f .gitignore
git commit -m 'chore: add template files'

./generation/generate_gapic_bom.sh

# add the gapic bom module to root pom.xml by regenerating aggregator pom
generation/print_root_pom.sh > pom.xml

git add google-cloud-gapic-bom/pom.xml
git commit -am 'feat: create google-cloud-gapic-bom'

cp generation/gapic_bom_versions.txt google-cloud-gapic-bom/versions.txt

# Generate Release Please configuration files
bash generation/generate_release_please_config.sh

git add --all
git commit -am 'feat: create release please configuration'

./generation/generate_coverage_aggregator.sh

git add --all
git commit -am 'feat: create CoverageAggregator module'

./generation/delete_non_generated_samples.sh

git add --all
git commit -am 'chore: delete non-auto-generated samples'
