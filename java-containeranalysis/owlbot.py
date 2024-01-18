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

get_grafeas_code = """
  /**
   * Returns a new GrafeasClient with the same configured settings.
   *
   * @throws IOException
   */
  public GrafeasClient getGrafeasClient() throws IOException {
    return GrafeasClient.create(GrafeasUtils.transformSettings(settings));
  }
"""

for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.replace(
        f'owl-bot-staging/v1/google-cloud-containeranalysis/src/main/java/com/google/cloud/devtools/containeranalysis/v1/ContainerAnalysisClient.java',
        'import com.google.iam.v1.TestIamPermissionsResponse;',
        'import com.google.iam.v1.TestIamPermissionsResponse;\nimport io.grafeas.v1.GrafeasClient;'
    )

    # add getGrafeasClient()
    s.replace(
        f'owl-bot-staging/v1/google-cloud-containeranalysis/src/main/java/com/google/cloud/devtools/containeranalysis/v1/ContainerAnalysisClient.java',
        r'(\s+private final ContainerAnalysisStub stub;.*)',
        f'\g<1>{get_grafeas_code}'
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
