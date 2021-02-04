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

service = 'logging'
versions = ['v2']

for version in versions:
  java.bazel_library(
      service=service,
      version=version,
      proto_path=f'google/{service}/{version}',
      bazel_target=f'//google/{service}/{version}:google-cloud-{service}-{version}-java',
  )

  # The method renamings will be removed in the next major release(lines 34 - 51)
  s.replace('**/CmekSettingsName.java', 'formatBillingAccountName', 'formatBillingAccountCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'formatFolderName', 'formatFolderCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'formatOrganizationName', 'formatOrganizationCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'formatProjectName', 'formatProjectCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'newBillingAccountBuilder', 'newBillingAccountCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'newFolderBuilder', 'newFolderCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'newOrganizationBuilder', 'newOrganizationCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'newProjectBuilder', 'newProjectCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'ofBillingAccountName', 'ofBillingAccountCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'ofFolderName', 'ofFolderCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'ofOrganizationName', 'ofOrganizationCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'ofProjectName', 'ofProjectCmekSettingsName')
  s.replace('**/CmekSettingsName.java', 'BillingAccountBuilder', 'BillingAccountCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'FolderBuilder', 'FolderCmekSettingsBuilder')
  s.replace('**/CmekSettingsName.java', 'OrganizationBuilder', 'OrganizationCmekSettingsBuilder')
  s.replace('**/ConfigClientTest.java', 'CmekSettingsName.ofProjectName', 'CmekSettingsName.ofProjectCmekSettingsName')

  java.format_code(f'proto-google-cloud-{service}-{version}/src')

java.common_templates(excludes=[
    '.gitignore',
    '.github/CODEOWNERS',
    '.github/blunderbuss.yml',
    'CONTRIBUTING.md',
])

