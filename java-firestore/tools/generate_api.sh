#!/bin/bash
set -e

# Generate classpath
cd ../google-cloud-firestore
mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
CLASSPATH=$(cat cp.txt)
rm cp.txt
cd ../tools

# Run Metalava
mvn exec:java -Dexec.mainClass="com.android.tools.metalava.Driver" \
  -Dexec.args="--source-path ../google-cloud-firestore/src/main/java --hide HiddenSuperclass --hide HiddenAbstractMethod --api api.txt --format=v2 --classpath $CLASSPATH"
