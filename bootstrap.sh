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

# Template files
cp -rp ../../templates/. ./

# Generation files
cp -rp ../../generation ./

# Add all template files
git add --all
git add -f .gitignore
git commit -m 'chore: add template files'

./generation/print_root_pom.sh > pom.xml

git add pom.xml
git commit -am 'feat: create aggregator pom'

# Point modules poms and BOMs to the aggregator pom as parent
bash generation/set_parent_pom.sh

git add --all
git commit -am 'feat: point modules to the aggregator pom as parent'


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

./generation/update_versions.sh

git add --all
git commit -am 'chore: update versions to latest in maven'

# create a monorepo/diff repo
cd ..
cp -R google-cloud-java split
rm -rf split/.git
git clone -b main --single-branch https://github.com/googleapis/google-cloud-java.git shadow
cp -R shadow/.git split/.git
rm -rf shadow
mv split diff
cd diff
git add --all
git commit -am 'diff with split repos'
cd ../..