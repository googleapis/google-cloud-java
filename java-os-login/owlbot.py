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
import shutil


for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.replace('**/OsLoginServiceClient.java', 'PosixAccountName', 'ProjectName')
    s.replace('**/OsLoginServiceClient.java', 'SshPublicKeyName',
              'FingerprintName')
    s.replace('**/OsLoginServiceClientTest.java', 'PosixAccountName',
              'ProjectName')
    s.replace('**/OsLoginServiceClientTest.java', 'SshPublicKeyName',
              'FingerprintName')

    # Copy of Resource name helper classes from v1 and import replacements
    # Todo: remove before next major release(lines 36 - 60)
    shutil.copy(
        'owl-bot-staging/v1/proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/common/UserName.java',
        'owl-bot-staging/v1/proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/v1/UserName.java')
    s.replace(
        'owl-bot-staging/v1/proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/v1/UserName.java',
        'package com.google.cloud.oslogin.common;',
        'package com.google.cloud.oslogin.v1;')
    s.replace('**/OsLoginServiceClient.java',
              'import com.google.cloud.oslogin.common.FingerprintName;',
              'import com.google.cloud.oslogin.v1.FingerprintName;')
    s.replace('**/OsLoginServiceClient.java',
              'import com.google.cloud.oslogin.common.UserName;',
              'import com.google.cloud.oslogin.v1.UserName;')
    s.replace('**/OsLoginServiceClient.java',
              'import com.google.cloud.oslogin.common.ProjectName;',
              'import com.google.cloud.oslogin.v1.ProjectName;')
    s.replace('**/OsLoginServiceClientTest.java',
              'import com.google.cloud.oslogin.common.FingerprintName;',
              'import com.google.cloud.oslogin.v1.FingerprintName;')
    s.replace('**/OsLoginServiceClientTest.java',
              'import com.google.cloud.oslogin.common.UserName;',
              'import com.google.cloud.oslogin.v1.UserName;')
    s.replace('**/OsLoginServiceClientTest.java',
              'import com.google.cloud.oslogin.common.ProjectName;',
              'import com.google.cloud.oslogin.v1.ProjectName;')

    # put any special-case replacements here
    s.replace('**/OsLoginServiceClientHttpJsonTest.java', 'PosixAccountName', 'ProjectName')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java', 'SshPublicKeyName',
              'FingerprintName')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java', 'PosixAccountName',
              'ProjectName')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java', 'SshPublicKeyName',
              'FingerprintName')

    # Copy of Resource name helper classes from v1 and import replacements

    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.FingerprintName;',
              'import com.google.cloud.oslogin.v1.FingerprintName;')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.UserName;',
              'import com.google.cloud.oslogin.v1.UserName;')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.ProjectName;',
              'import com.google.cloud.oslogin.v1.ProjectName;')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.FingerprintName;',
              'import com.google.cloud.oslogin.v1.FingerprintName;')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.UserName;',
              'import com.google.cloud.oslogin.v1.UserName;')
    s.replace('**/OsLoginServiceClientHttpJsonTest.java',
              'import com.google.cloud.oslogin.common.ProjectName;',
              'import com.google.cloud.oslogin.v1.ProjectName;')

    s.move(library)

s.remove_staging_dirs()
java.common_templates(excludes=[
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
