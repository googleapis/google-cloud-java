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

    # Ensure backwards-compat for Java-microgenerator migration
    # Details: https://github.com/googleapis/synthtool/pull/883
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/DataSourceName.java', 'public static List<DataSourceName> parseList(List<String> formattedStrings)')
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/DataSourceName.java', 'public static List<String> toStringList(List<DataSourceName> values)')
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/TransferConfigName.java', 'public static List<TransferConfigName> parseList(List<String> formattedStrings)')
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/TransferConfigName.java', 'public static List<String> toStringList(List<TransferConfigName> values)')
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/RunName.java', 'public static List<RunName> parseList(List<String> formattedStrings)')
    java.remove_method('owl-bot-staging/v1/proto-google-cloud-bigquerydatatransfer-v1/src/main/java/com/google/cloud/bigquery/datatransfer/v1/RunName.java', 'public static List<String> toStringList(List<RunName> values)')

    s.move(library)

s.remove_staging_dirs()
java.common_templates(monorepo=True, excludes=[
    ".github/*",
    ".kokoro/*",
    "samples/*",
    "CODE_OF_CONDUCT.md",
    "CONTRIBUTING.md",
    "LICENSE",
    "SECURITY.md",
    "java.header",
    "license-checks.xml",
    "renovate.json",
    ".gitignore"
])
