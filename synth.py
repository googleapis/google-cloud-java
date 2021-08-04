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
  #s.replace('**/CmekSettingsName.java', 'formatBillingAccountName', 'formatBillingAccountCmekSettingsName')
  DEPRECATION_JAVADOC = """Please use {{@link #{new_method}()}} instead"""

  java.copy_and_rename_method(
    'proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
    'public static String formatBillingAccountName(String billingAccount)', 
    'formatBillingAccountName', 
    'formatBillingAccountCmekSettingsName'
  )

  java.deprecate_method(
    'proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
    'public static String formatBillingAccountCmekSettingsName(String billingAccount)', 
    DEPRECATION_JAVADOC.format(new_method='formatBillingAccountName')
  )

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatFolderName(String folder)', 'formatFolderName', 'formatFolderCmekSettingsName')
  java.deprecate_method(
    'proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
    'public static String formatFolderCmekSettingsName(String folder)', 
    DEPRECATION_JAVADOC.format(new_method='formatFolderName')
    )

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatOrganizationName(String organization)', 'formatOrganizationName', 'formatOrganizationCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatOrganizationCmekSettingsName(String organization)', DEPRECATION_JAVADOC.format(new_method='formatOrganizationName'))
 
  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatProjectName(String project)', 'formatProjectName', 'formatProjectCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatProjectCmekSettingsName(String project)', DEPRECATION_JAVADOC.format(new_method='formatProjectName'))

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static BillingAccountCmekSettingsBuilder newBillingAccountBuilder()', 'newBillingAccountBuilder', 'newBillingAccountCmekSettingsBuilder')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static BillingAccountCmekSettingsBuilder newBillingAccountCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newBillingAccountBuilder'))
  s.replace('**/CmekSettingsName', 'return newBillingAccountBuilder', 'return newBillingAccountCmekSettingsBuilder' )
  
  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static FolderCmekSettingsBuilder newFolderBuilder()', 'newFolderBuilder', 'newFolderCmekSettingsBuilder')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static FolderCmekSettingsBuilder newFolderCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newFolderBuilder'))
  s.replace('**/CmekSettingsName.java', 'return newFolderBuilder', 'return newFolderCmekSettingsBuilder') 
  
  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static OrganizationCmekSettingsBuilder newOrganizationBuilder()', 'newOrganizationBuilder', 'newOrganizationCmekSettingsBuilder')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static OrganizationCmekSettingsBuilder newOrganizationCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newOrganizationBuilder'))
  s.replace('**/CmekSettingsName.java', 'return newOrganizationBuilder', 'return newOrganizationCmekSettingsBuilder')

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static Builder newProjectBuilder()', 'newProjectBuilder', 'newProjectCmekSettingsBuilder')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static Builder newProjectCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newProjectBuilder'))

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofBillingAccountName(String billingAccount)', 'ofBillingAccountName', 'ofBillingAccountCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofBillingAccountCmekSettingsName(String billingAccount)', DEPRECATION_JAVADOC.format(new_method='ofBillingAccountName'))
  s.replace('**/CmekSettingsName.java', 'return ofBillingAccountName', 'return ofBillingAccountCmekSettingsName')
  
  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofFolderName(String folder)', 'ofFolderName', 'ofFolderCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofFolderCmekSettingsName(String folder)', DEPRECATION_JAVADOC.format(new_method='ofFolderName'))
  s.replace('**/CmekSettingsName.java', 'return ofFolderName', 'return ofFolderCmekSettingsName')

  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofOrganizationName(String organization)', 'ofOrganizationName', 'ofOrganizationCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofOrganizationCmekSettingsName(String organization)', DEPRECATION_JAVADOC.format(new_method='ofOrganizationName'))
  s.replace('**/CmekSettingsName.java', 'return ofOrganizationName', 'return ofOrganizationCmekSettingsName')
  
  java.copy_and_rename_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofProjectName(String project)', 'ofProjectName', 'ofProjectCmekSettingsName')
  java.deprecate_method('proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofProjectCmekSettingsName(String project)', DEPRECATION_JAVADOC.format(new_method='ofProjectName'))
  s.replace('**/CmekSettingsName.java', 'return ofProjectName', 'return ofProjectCmekSettingsName')

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

