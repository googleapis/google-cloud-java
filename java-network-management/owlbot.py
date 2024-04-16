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

v1_file_name = "owl-bot-staging/v1/google-cloud-network-management/src/test/java/com/google/cloud/networkmanagement/v1/ReachabilityServiceClientHttpJsonTest.java"
v1beta1_file_name = "owl-bot-staging/v1beta1/google-cloud-network-management/src/test/java/com/google/cloud/networkmanagement/v1beta1/ReachabilityServiceClientHttpJsonTest.java"


for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.replace(
        v1_file_name,
        r'^import org.junit.Test;',
        'import org.junit.Ignore;\nimport org.junit.Test;'
    )
    s.replace(
        v1_file_name,
        r"\s+@Test\n\s+public void setIamPolicyTest\(\) throws Exception.*",
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")\n@Test\npublic void setIamPolicyTest() throws Exception {'
    )
    s.replace(
        v1_file_name,
        r'\s+@Test\n\s+public void getIamPolicyTest\(\) throws Exception.*',
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")\n@Test\npublic void getIamPolicyTest() throws Exception {'
    )
    s.replace(
        v1_file_name,
        r'\s+@Test\n\s+public void testIamPermissionsTest\(\) throws Exception.*',
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")@Test\npublic void testIamPermissionsTest() throws Exception {'
    )
    s.replace(
        v1beta1_file_name,
        r'^import org.junit.Test;',
        'import org.junit.Ignore;\nimport org.junit.Test;'
    )
    s.replace(
        v1beta1_file_name,
        r"\s+@Test\n\s+public void setIamPolicyTest\(\) throws Exception.*",
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")\n@Test\npublic void setIamPolicyTest() throws Exception {'
    )
    s.replace(
        v1beta1_file_name,
        r'\s+@Test\n\s+public void getIamPolicyTest\(\) throws Exception.*',
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")\n@Test\npublic void getIamPolicyTest() throws Exception {'
    )
    s.replace(
        v1beta1_file_name,
        r'\s+@Test\n\s+public void testIamPermissionsTest\(\) throws Exception.*',
        '@Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")@Test\npublic void testIamPermissionsTest() throws Exception {'
    )
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