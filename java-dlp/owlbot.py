# Copyright 2021 Google LLC
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

import synthtool as s
from synthtool.languages import java


for library in s.get_staging_dirs():
    # put any special-case replacements here

    # TODO: remove this for the next semver major release
    # remove ResourceName base parseList and toStringList for backward-compatibility with legacy
    # resource name implementation
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/InspectTemplateName.java",
        "public static List<InspectTemplateName> parseList(List<String> formattedStrings)"
    )
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/InspectTemplateName.java",
        "public static List<String> toStringList(List<InspectTemplateName> values)"
    )
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/DeidentifyTemplateName.java",
        "public static List<DeidentifyTemplateName> parseList(List<String> formattedStrings)"
    )
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/DeidentifyTemplateName.java",
        "public static List<String> toStringList(List<DeidentifyTemplateName> values)"
    )
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/StoredInfoTypeName.java",
        "public static List<StoredInfoTypeName> parseList(List<String> formattedStrings)"
    )
    java.remove_method(
        "owl-bot-staging/v2/proto-google-cloud-dlp-v2/src/main/java/com/google/privacy/dlp/v2/StoredInfoTypeName.java",
        "public static List<String> toStringList(List<StoredInfoTypeName> values)"
    )
    s.move(library)

s.remove_staging_dirs()
java.common_templates(
    excludes=[
        ".kokoro/presubmit/samples.cfg",
        ".kokoro/nightly/samples.cfg",
        ".kokoro/build.sh",
    ]
)
