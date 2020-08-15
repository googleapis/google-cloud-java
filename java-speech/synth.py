# Copyright 2018 Google LLC
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

import synthtool as s
import synthtool.languages.java as java

AUTOSYNTH_MULTIPLE_COMMITS = True

service = 'speech'
versions = ['v1', 'v1p1beta1']

for version in versions:
  library = java.bazel_library(
      service=service,
      version=version,
      bazel_target=f'//google/cloud/{service}/{version}:google-cloud-{service}-{version}-java',
  )

# skip smoke test on VPCSC
s.replace(
  'google-cloud-speech/src/test/**/SpeechSmokeTest.java',
  'import org.junit.Test;',
  "import org.junit.Assume;\nimport org.junit.Test;"
)
vpcsc_skip_code = """
    // Skip smoke tests if running in VPCSC because our V1 integration tests
    // cover VPC-SC.
    Assume.assumeTrue(System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") == null);"""
s.replace(
  'google-cloud-speech/src/test/**/SpeechSmokeTest.java',
  r'(\s+public void run.*)',
  f'\g<1>{vpcsc_skip_code}'
)

java.common_templates()
