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
import shutil

AUTOSYNTH_MULTIPLE_COMMITS = True

service = 'oslogin'
versions = ['v1']

for version in versions:
  library = java.bazel_library(
      service=service,
      version=version,
      bazel_target=f'//google/cloud/{service}/{version}:google-cloud-{service}-{version}-java',
      destination_name='os-login',
  )

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
      'proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/common/UserName.java',
      'proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/v1/UserName.java')
  s.replace(
      'proto-google-cloud-os-login-v1/src/main/java/com/google/cloud/oslogin/v1/UserName.java',
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

  java.format_code(f'google-cloud-os-login/src')
  java.format_code(f'grpc-google-cloud-{service}-{version}/src')
  java.format_code(f'proto-google-cloud-{service}-{version}/src')

java.common_templates()
