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


GET_IAM_POLICY = """
  public final Policy getIamPolicy(QueueName queueName) {
    return getIamPolicy((ResourceName) queueName);
  }
"""
GET_IAM_POLICY_PREVIOUS = r'(\s+public final Policy getIamPolicy\(GetIamPolicyRequest request\) {\n\s+return .*\n\s+})'

SET_IAM_POLICY = """
  public final Policy setIamPolicy(QueueName queue, Policy policy) {
    return setIamPolicy((ResourceName) queue, policy);
  }
"""
SET_IAM_POLICY_PREVIOUS = r'(\s+public final Policy setIamPolicy\(SetIamPolicyRequest request\) {\n\s+return .*\n\s+})'

TEST_IAM_POLICY = """
  public final TestIamPermissionsResponse testIamPermissions(
      QueueName queue, List<String> permissions) {
    return testIamPermissions((ResourceName) queue, permissions);
  }
"""
TEST_IAM_POLICY_PREVIOUS = r'(\spublic final TestIamPermissionsResponse testIamPermissions\(TestIamPermissionsRequest request\) {\n\s+return .*\n\s+})'

for library in s.get_staging_dirs():
    # put any special-case replacements here
    version = library.parts[len(library.parts) - 1]
    service = 'tasks'
    s.replace(
        f'owl-bot-staging/{version}/google-cloud-{service}/src/main/java/com/google/cloud/tasks/{version}/CloudTasksClient.java',
        GET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + GET_IAM_POLICY
    )
    s.replace(
        f'owl-bot-staging/{version}/google-cloud-{service}/src/main/java/com/google/cloud/tasks/{version}/CloudTasksClient.java',
        SET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + SET_IAM_POLICY
    )
    s.replace(
        f'owl-bot-staging/{version}/google-cloud-{service}/src/main/java/com/google/cloud/tasks/{version}/CloudTasksClient.java',
        TEST_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + TEST_IAM_POLICY
    )
    s.move(library)

s.remove_staging_dirs()
java.common_templates(monorepo=True,
    excludes=[
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
