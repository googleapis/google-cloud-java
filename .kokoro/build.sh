#!/bin/bash
# Copyright 2018 Google Inc.
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

cd github/google-cloud-java/

# Print out Java version
java -version
echo $JOB_TYPE

mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V

# prepend Kokoro root directory onto GOOGLE_APPLICATION_CREDENTIALS path
if [ ! -z "$GOOGLE_APPLICATION_CREDENTIALS" ]; then
    export GOOGLE_APPLICATION_CREDENTIALS=$(realpath ${KOKORO_ROOT}/src/${GOOGLE_APPLICATION_CREDENTIALS})
fi

case $JOB_TYPE in
test)
    mvn test -B
    bash $KOKORO_GFILE_DIR/codecov.sh
    ;;
lint)
    mvn com.coveo:fmt-maven-plugin:check
    ;;
javadoc)
    mvn javadoc:javadoc javadoc:test-javadoc
    ;;
integration)
    mvn -B -pl ${INTEGRATION_TEST_ARGS} -DtrimStackTrace=false -fae verify
    ;;
*)
    ;;
esac
