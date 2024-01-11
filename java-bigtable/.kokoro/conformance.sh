#!/bin/bash
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# include common functions
source ${scriptDir}/common.sh

# Print out Maven & Java version
mvn -version
echo ${JOB_TYPE}

# attempt to install 3 times with exponential backoff (starting with 10 seconds)
retry_with_backoff 3 10 \
  mvn install -B -V -ntp \
    -DskipTests=true \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dmaven.javadoc.skip=true \
    -Dgcloud.download.skip=true \
    -T 1C

RETURN_CODE=0
set +e

# Build the proxy
pushd .
cd test-proxy
mvn clean install -DskipTests
popd

declare -a configs=("default" "enable_all")
for config in "${configs[@]}"
do
  # Start the proxy in a separate process
  nohup java -Dport=9999 -jar test-proxy/target/google-cloud-bigtable-test-proxy-0.0.1-SNAPSHOT.jar &
  proxyPID=$!

  # Run the conformance test
  if [[ ${config} = "enable_all" ]]
  then
    echo "Testing the client with all optional features enabled..."
    configFlag="--enable_features_all"
  else
    echo "Testing the client with default settings for optional features..."
    # skipping routing cookie and retry info tests. When the feature is disabled, these
    # tests are expected to fail
    configFlag="-skip _Retry_WithRoutingCookie\|_Retry_WithRetryInfo"
  fi

  pushd .
  cd cloud-bigtable-clients-test/tests
  # If there is known failures, please add
  # "-skip `cat ../../test-proxy/known_failures.txt`" to the command below.
  eval "go test -v -proxy_addr=:9999 ${configFlag}"
  returnCode=$?
  popd

  # Stop the proxy
  kill ${proxyPID}

  if [[ ${returnCode} -gt 0 ]]
  then
    echo "Conformance test failed for config: ${config}"
    RETURN_CODE=${returnCode}
  else
    echo "Conformance test passed for config: ${config}"
  fi
done

# fix output location of logs
bash .kokoro/coerce_logs.sh

exit ${RETURN_CODE}
