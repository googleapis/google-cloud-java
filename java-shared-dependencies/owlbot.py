# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""This script is used to synthesize generated parts of this library."""

from synthtool.languages import java

java.common_templates(excludes=[
  'README.md',
  'samples/*',
  'renovate.json',
  # excluding samples ci jobs since there are no samples in this repo
  '.github/workflows/samples.yaml',
  '.github/release-please.yml',
  '.github/workflows/auto-release.yaml',
])
