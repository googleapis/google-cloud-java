#!/bin/bash

# This script creates a submodule project with all the necessary repositories (forked) and changes needed to test
# GraalVM updates with handwritten libraries (including, pubsub, bigquery, bigtable and spanner-jdbc).
# It serves two main purposes; first, it allows for the creation of a testing environment that can be shared with
# teammates and second, given that the submodule leverages creation of test branches in the (forked) repositories,
# any extra configurations necessary for making the library compatible with GraalVM can easily be sent for review as a PR
# from the branch itself.
# At a high-level, the script will do the following:
# - Modifies graal-sdk version in gapic-generator-java/gax
# - Modifies the gapic-generator-bom version in java-shared-dependencies.
# - Updates the version of native-maven-plugin in java-shared-config.
# - Updates the java-shared-config and java-shared-dependencies versions in the handwritten libraries listed.
# - Adds gapic-generator-java, java-shared-config and handwritten libraries listed previously
#   with the associated changes, to the submodule project.
set -eo pipefail

function modify_shared_config() {
  xmllint --shell pom.xml <<EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:artifactId[text()="google-cloud-shared-config"]
  cd ../x:version
  set ${SHARED_CONFIG_VERSION}
  save pom.xml
EOF
}

function modify_shared_dependencies() {
  xmllint --shell pom.xml <<EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:artifactId[text()="google-cloud-shared-dependencies"]
  cd ../x:version
  set ${SHARED_DEPS_VERSION}
  save pom.xml
EOF
}

if [ -z "$GRAALVM_VERSION" ]; then
  echo "Please specify the GRAALVM_VERSION."
  exit 1
fi

if [ -z "$NATIVE_MAVEN_PLUGIN" ]; then
  echo "Please specify the NATIVE_MAVEN_PLUGIN version you want to update to."
  exit 1
fi

if [ -z "$ORGANIZATION" ]; then
  echo "Please specify the ORGANIZATION where your updates need to be stored."
  exit 1
fi

# This script assumes that you've already created a new github repository.
if [ ! -d ".git" ]; then
  echo "Missing '.git' file. Please make sure that you are running this script from a new github repository."
  exit 1
fi

GRAALVM_BRANCH="${GRAALVM_VERSION}_update"

## Round 1: Add gapic-generator-java and update graal-sdk version in GAX.
if [ ! -d "gapic-generator-java" ]; then
  echo "Create gapic-generator-java submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/gapic-generator-java.git
fi

# Modify graal-sdk version in GAX
pushd gapic-generator-java/gax-java
xmllint --shell pom.xml <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="graal-sdk"]
cd ../x:version
set ${GRAALVM_VERSION}
save pom.xml
EOF

# Get java-shared-dependencies version
popd
pushd gapic-generator-java
SHARED_DEPS_VERSION=$(sed -e 's/xmlns=".*"//' java-shared-dependencies/pom.xml | xmllint --xpath '/project/version/text()' -)
echo $SHARED_DEPS_VERSION

if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git diff
   git checkout -b "${GRAALVM_BRANCH}"
   git add gax-java/pom.xml
   git commit -m "chore: update graalvm-sdk's version (${GRAALVM_VERSION}) in GAX for testing"
   git push origin "${GRAALVM_BRANCH}"
fi

popd

## Round 2: Add java-shared-config if not present and update native-maven-plugin's version
if [ ! -d "java-shared-config" ]; then
  echo "Create java-shared-config submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/java-shared-config.git
fi

# Modify junit-platform-native and native-maven-plugin
pushd java-shared-config
SHARED_CONFIG_VERSION=$(sed -e 's/xmlns=".*"//' pom.xml | xmllint --xpath '/project/version/text()' -)

xmllint --shell pom.xml <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="native-maven-plugin"]
cd ../x:version
set ${NATIVE_MAVEN_PLUGIN}
save pom.xml
EOF

echo "Modified native-maven-plugin in shared-config"
git diff

# Create branch on github
if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git checkout -b "${GRAALVM_BRANCH}"
   git add pom.xml
   git commit -m "chore: update native-maven-plugin's version (${NATIVE_MAVEN_PLUGIN}) in java-shared-config for testing"
   git push origin "${GRAALVM_BRANCH}"
fi
popd

## Round 3: Add java-pubsub if not present and update versions of shared-dependencies and java-shared-config.
if [ ! -d "java-pubsub" ]; then
  echo "Create java-pubsub submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/java-pubsub.git
fi

# Update shared-config and shared-dependencies version
pushd java-pubsub
modify_shared_config
modify_shared_dependencies
echo "Modified shared-config and shared-dependencies versions in java-pubsub"
git diff

if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git checkout -b "${GRAALVM_BRANCH}"
   git add pom.xml
   git commit -m "chore: update shared-config (${SHARED_CONFIG_VERSION}) shared-dependencies version (${SHARED_DEPS_VERSION}) for testing"
   git push origin "${GRAALVM_BRANCH}"
fi
popd

## Round 4: Add java-bigquery if not present and update versions of shared-dependencies and java-shared-config.
if [ ! -d "java-bigquery" ]; then
  echo "Create java-bigquery submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/java-bigquery.git
fi

# Update shared-config and shared-dependencies version
pushd java-bigquery
modify_shared_config
modify_shared_dependencies
echo "Modified shared-config and shared-dependencies versions in java-bigquery"
git diff

if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git checkout -b "${GRAALVM_BRANCH}"
   git add pom.xml
   git commit -m "chore: update shared-config (${SHARED_CONFIG_VERSION}) shared-dependencies version (${SHARED_DEPS_VERSION}) for testing"
   git push origin "${GRAALVM_BRANCH}"
fi
popd

## Round 5: Add java-bigtable if not present and update versions of shared-dependencies and java-shared-config.
if [ ! -d "java-bigtable" ]; then
  echo "Create java-bigtable submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/java-bigtable.git
fi

# Update shared-config and shared-dependencies version
pushd java-bigtable/google-cloud-bigtable-deps-bom
modify_shared_config
modify_shared_dependencies

popd
pushd java-bigtable/google-cloud-bigtable-bom
modify_shared_config

popd
pushd java-bigtable
modify_shared_config

echo "Modified shared-config and shared-dependencies versions in java-bigtable"
git diff

if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git checkout -b "${GRAALVM_BRANCH}"
   git add pom.xml
   git add google-cloud-bigtable-deps-bom/pom.xml
   git add google-cloud-bigtable-bom/pom.xml
   git commit -m "chore: update shared-config (${SHARED_CONFIG_VERSION}) shared-dependencies version (${SHARED_DEPS_VERSION}) for testing"
   git push origin "${GRAALVM_BRANCH}"
fi

popd

## Round 6: Add java-spanner-jdbc if not present and update versions of shared-dependencies and java-shared-config.
if [ ! -d "java-spanner-jdbc" ]; then
  echo "Create java-spanner-jdbc submodule if one does not exist"
  git submodule add --force https://github.com/"${ORGANIZATION}"/java-spanner-jdbc.git
fi

# Update shared-config and shared-dependencies version
pushd java-spanner-jdbc
modify_shared_config
modify_shared_dependencies
echo "Modified shared-config and shared-dependencies versions in java-spanner-jdbc"
git diff

if [ ! "$(git branch --list "$GRAALVM_BRANCH")" ]
then
   git checkout -b "${GRAALVM_BRANCH}"
   git add pom.xml
   git commit -m "chore: update shared config (${SHARED_CONFIG_VERSION}) shared-dependencies version (${SHARED_DEPS_VERSION}) for testing"
   git push origin "${GRAALVM_BRANCH}"
fi
popd

## Round 7: Push modified repos to submodule repository.
git add gapic-generator-java
git add java-shared-config
git add java-pubsub
git add java-bigquery
git add java-bigtable
git add java-spanner-jdbc
git commit -m "chore: populate the submodule project" --allow-empty
git push origin main

