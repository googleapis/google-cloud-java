#
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

GENERATED_CODE_DIR=$(pwd)/../googleapis-gen
DATASTORE_DIR=$(pwd)

echo $GENERATED_CODE_DIR
if [ -d "$GENERATED_CODE_DIR" ]; then
  echo "Pulling latest changes in ${GENERATED_CODE_DIR}"
  pushd $GENERATED_CODE_DIR || exit
  git pull
  popd || exit
else
  echo "Cloning googleapis-gen"
  git clone --depth 1 git@github.com:googleapis/googleapis-gen.git $GENERATED_CODE_DIR
fi

#Copying the required directories
mkdir -p "$DATASTORE_DIR/grpc-google-cloud-datastore-v1"
cp -r "$GENERATED_CODE_DIR/google/datastore/v1/google-cloud-datastore-v1-java/grpc-google-cloud-datastore-v1-java/." \
"$DATASTORE_DIR/grpc-google-cloud-datastore-v1/."
cp -r "$GENERATED_CODE_DIR/google/datastore/v1/google-cloud-datastore-v1-java/gapic-google-cloud-datastore-v1-java/." \
"$DATASTORE_DIR/google-cloud-datastore/."

#Cleaning up unwanted files
rm grpc-google-cloud-datastore-v1/build.gradle
rm google-cloud-datastore/build.gradle

echo "Success"
