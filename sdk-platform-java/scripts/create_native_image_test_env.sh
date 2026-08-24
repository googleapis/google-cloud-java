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
  python3 -c "
import xml.etree.ElementTree as ET, sys
file = 'pom.xml'
ET.register_namespace('', 'http://maven.apache.org/POM/4.0.0')
tree = ET.parse(file)
root = tree.getroot()
for elem in root.iter():
    art = elem.find('{*}artifactId')
    ver = elem.find('{*}version')
    if art is not None and art.text == 'google-cloud-shared-config' and ver is not None:
        ver.text = sys.argv[1]
tree.write(file, encoding='utf-8', xml_declaration=True)
" "${SHARED_CONFIG_VERSION}"
}

function modify_shared_dependencies() {
  python3 -c "
import xml.etree.ElementTree as ET, sys
file = 'pom.xml'
ET.register_namespace('', 'http://maven.apache.org/POM/4.0.0')
tree = ET.parse(file)
root = tree.getroot()
for elem in root.iter():
    art = elem.find('{*}artifactId')
    ver = elem.find('{*}version')
    if art is not None and art.text == 'google-cloud-shared-dependencies' and ver is not None:
        ver.text = sys.argv[1]
tree.write(file, encoding='utf-8', xml_declaration=True)
" "${SHARED_DEPS_VERSION}"
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
python3 -c "
import xml.etree.ElementTree as ET, sys
file = 'pom.xml'
ET.register_namespace('', 'http://maven.apache.org/POM/4.0.0')
tree = ET.parse(file)
root = tree.getroot()
for elem in root.iter():
    art = elem.find('{*}artifactId')
    ver = elem.find('{*}version')
    if art is not None and art.text == 'graal-sdk' and ver is not None:
        ver.text = sys.argv[1]
tree.write(file, encoding='utf-8', xml_declaration=True)
" "${GRAALVM_VERSION}"

# Get java-shared-dependencies version
popd
pushd gapic-generator-java
SHARED_DEPS_VERSION=$(python3 -c "
import xml.etree.ElementTree as ET
root = ET.parse('java-shared-dependencies/pom.xml').getroot()
v = root.find('{*}version') or root.find('{*}parent/{*}version')
print(v.text if v is not None and v.text else '')
")
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
SHARED_CONFIG_VERSION=$(python3 -c "
import xml.etree.ElementTree as ET
root = ET.parse('pom.xml').getroot()
v = root.find('{*}version') or root.find('{*}parent/{*}version')
print(v.text if v is not None and v.text else '')
")

python3 -c "
import xml.etree.ElementTree as ET, sys
file = 'pom.xml'
ET.register_namespace('', 'http://maven.apache.org/POM/4.0.0')
tree = ET.parse(file)
root = tree.getroot()
for elem in root.iter():
    art = elem.find('{*}artifactId')
    ver = elem.find('{*}version')
    if art is not None and art.text == 'native-maven-plugin' and ver is not None:
        ver.text = sys.argv[1]
tree.write(file, encoding='utf-8', xml_declaration=True)
" "${NATIVE_MAVEN_PLUGIN}"

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

