#!/bin/bash

# https://stackoverflow.com/questions/1425892/how-do-you-merge-two-git-repositories

set -xe

[ -z "`git config user.email`" ] && git config --global user.email "${USERNAME:-script}@google.com"
[ -z "`git config user.name`" ] && git config --global user.name "${USERNAME:-script}"

cd "$(dirname "$0")"

rm -rf monorepo
mkdir monorepo

cp merge_repository.sh monorepo
cp repos.txt monorepo

cd monorepo

git clone https://github.com/newren/git-filter-repo.git
export PATH=$PATH:`pwd`/git-filter-repo

merged_repository=google-cloud-java-merged
mkdir "${merged_repository}"

cd "${merged_repository}"
git init -b main

cat ../repos.txt | while read service
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

  cd "../${merged_repository}"
  git remote add ${service} ../${service}
  git config --add secrets.allowed "dest.*src"
  git fetch ${service} #--tags
  EDITOR=true git merge --quiet --allow-unrelated-histories ${service}/main
  git remote remove ${service}
  rm -rf ../${service}
done

# cwd: monorepo/google-cloud-java-merged
echo "Working directory: $(pwd)"

cp -R ../../../google-cloud-jar-parent google-cloud-jar-parent
cp -R ../../../google-cloud-pom-parent google-cloud-pom-parent

git add --all
git commit -m 'chore: add template files'

../../generate_root_pom.sh

git add pom.xml
git commit -am 'chore: create aggregator pom'

# Point modules poms and BOMs to the aggregator pom as parent
bash ../../set_parent_pom.sh

git add --all
git commit -am 'chore: point modules to the aggregator pom as parent'

../../consolidate_config.sh

git add --all
git commit -am 'chore: consolidate config to parent'

../../generate_gapic_bom.sh

# add the gapic bom module to root pom.xml by regenerating aggregator pom
../../generate_root_pom.sh

git add gapic-libraries-bom/pom.xml
git commit -am 'chore: create gapic-libraries-bom'

cp ../../gapic_bom_versions.txt gapic-libraries-bom/versions.txt

../../delete_non_generated_samples.sh

git add --all
git commit -am 'chore: delete non-auto-generated samples'

../../generate_root_versions_txt.sh
../../update_versions.sh -s
../../apply_current_versions.sh

git add --all
git commit -am 'chore: update versions to latest in maven'

../../update_owlbot_postprocessor_config.sh

git add --all
git commit -am 'chore: remove and disable owlbot postprocessor templates'

for F in `find . -maxdepth 2 -name '.OwlBot.yaml'`; do sh ../../set_owlbot_config.sh $F; done
git commit -am 'chore: set owlbot copy config' --allow-empty

# create a monorepo/diff repo
cd ..
cp -R "${merged_repository}" split
rm -rf split/.git
git clone -b main --single-branch https://github.com/googleapis/google-cloud-java.git shadow
cp -R shadow/.git split/.git
rm -rf shadow
mv split diff
cd diff

git add "*/src/main/*" || true
git commit -m 'split repo - diff src/main' --allow-empty

git add "*/src/test/*" || true
git commit -m 'split repo - diff src/test' --allow-empty

git add "*/samples/*" || true
git commit -m 'split repo - diff samples' --allow-empty

git add "**/pom.xml" || true
git commit -m 'split repo - diff pom.xml' --allow-empty

git add "**/CHANGELOG.md" || true
git commit -m 'split repo - diff CHANGELOG.md' --allow-empty

git add "**/README.md" || true
git commit -m 'split repo - diff README.md' --allow-empty

git add "**/.OwlBot.yaml" || true
git commit -m 'split repo - diff .OwlBot.yaml' --allow-empty

git add "**/versions.txt" || true
git commit -m 'split repo - diff versions.txt' --allow-empty

git add --all || true
git commit -am 'split repo - diff everything else' --allow-empty
cd ../..