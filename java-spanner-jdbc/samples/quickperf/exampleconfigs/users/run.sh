#!/bin/bash

# Generate Data
cd ../..

mvn -q compile

mvn -q exec:java -Dexec.args="-c exampleconfigs/users/users_config.json"

mvn -q exec:java -Dexec.args="-c exampleconfigs/users/groupmgt_config.json"

mvn -q exec:java -Dexec.args="-c exampleconfigs/users/membership_config.json"

# load test random users
mvn -q exec:java -Dexec.args="-c exampleconfigs/users/loadtestusers.json"
