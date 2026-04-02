#!/usr/bin/env bash

mvn install -B -ntp -f shared-dependency-pom.xml
mvn install -B -ntp -f gax-example-pom.xml
mvn install -B -ntp -f nested-dependency-pom.xml
mvn install -B -ntp -f transitive-dependency-pom.xml
mvn install -B -ntp -f google-internal-artifact-test-case-pom.xml
