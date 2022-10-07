#
# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Ensure current directory is repo root.
helperDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
pushd "$helperDir/../.." >/dev/null || exit

# Find all directories starting with 'java-', sort them, then join with ',' as the delimiter.
ls -1 -d java-* | sort | paste -s -d, -

popd >/dev/null || exit
