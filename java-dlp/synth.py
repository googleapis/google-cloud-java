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

import synthtool.languages.java as java

AUTOSYNTH_MULTIPLE_COMMITS = True

service = 'privacy-dlp'
versions = ['v2']

for version in versions:
  java.bazel_library(
      service=service,
      version=version,
      proto_path=f'/google/privacy/dlp/{version}',
      bazel_target=f'//google/privacy/dlp/{version}:google-cloud-{service}-{version}-java',
      destination_name='dlp',
  )

# TODO: remove this for the next semver major release
# remove ResourceName base parseList and toStringList for backward-compatibility with legacy
# resource name implementation
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/InspectTemplateName.java",
    "public static List<InspectTemplateName> parseList(List<String> formattedStrings)"
)
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/InspectTemplateName.java",
    "public static List<String> toStringList(List<InspectTemplateName> values)"
)
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/DeidentifyTemplateName.java",
    "public static List<DeidentifyTemplateName> parseList(List<String> formattedStrings)"
)
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/DeidentifyTemplateName.java",
    "public static List<String> toStringList(List<DeidentifyTemplateName> values)"
)
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/StoredInfoTypeName.java",
    "public static List<StoredInfoTypeName> parseList(List<String> formattedStrings)"
)
java.remove_method(
    "proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/StoredInfoTypeName.java",
    "public static List<String> toStringList(List<StoredInfoTypeName> values)"
)
java.format_code("proto-google-cloud-dlp-v2")

java.common_templates(excludes=[
    '.kokoro/presubmit/samples.cfg',
    '.kokoro/nightly/samples.cfg',
    '.kokoro/build.sh',
])
