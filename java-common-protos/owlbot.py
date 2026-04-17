# Copyright 2020 Google LLC
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

import os
import os.path
import synthtool as s
from synthtool.languages import java


for library in s.get_staging_dirs():
  # put any special-case replacements here
  # TODO: remove this for the next major version bump
  if os.path.exists("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadata.java"):
    os.remove("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadata.java")
  if os.path.exists("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadataOrBuilder.java"):
    os.remove("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadataOrBuilder.java")
  if os.path.exists("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadataProto.java"):
    os.remove("owl-bot-staging/v1/proto-google-common-protos/src/main/java/com/google/cloud/audit/BigQueryAuditMetadataProto.java")
  if os.path.exists("owl-bot-staging/v1/proto-google-common-protos/src/main/proto/google/cloud/audit/bigquery_audit_metadata.proto"):
    os.remove("owl-bot-staging/v1/proto-google-common-protos/src/main/proto/google/cloud/audit/bigquery_audit_metadata.proto")
  if os.path.exists("owl-bot-staging/v1/proto-google-common-protos/src/main/proto/google/cloud/common_resources.proto"):
    os.remove("owl-bot-staging/v1/proto-google-common-protos/src/main/proto/google/cloud/common_resources.proto")
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
    "README.md",
    "renovate.json",
    ".gitignore"
])
