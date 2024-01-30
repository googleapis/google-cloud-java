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

import os
import synthtool as s
from synthtool.languages import java

# The method renamings will be removed in the next major release(lines 34 - 51)
#s.replace('**/CmekSettingsName.java', 'formatBillingAccountName', 'formatBillingAccountCmekSettingsName')
DEPRECATION_JAVADOC = """Please use {{@link #{new_method}}} instead"""

for library in s.get_staging_dirs():
    # put any special-case replacements here
    java.copy_and_rename_method(
        'owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
        'public static String formatBillingAccountName(String billingAccount)',
        'formatBillingAccountName',
        'formatBillingAccountCmekSettingsName'
    )

    java.deprecate_method(
        'owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
        'public static String formatBillingAccountCmekSettingsName(String billingAccount)',
        DEPRECATION_JAVADOC.format(new_method='formatBillingAccountName(String)')
    )

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatFolderName(String folder)', 'formatFolderName', 'formatFolderCmekSettingsName')
    java.deprecate_method(
        'owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java',
        'public static String formatFolderCmekSettingsName(String folder)',
        DEPRECATION_JAVADOC.format(new_method='formatFolderName(String)')
    )

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatOrganizationName(String organization)', 'formatOrganizationName', 'formatOrganizationCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatOrganizationCmekSettingsName(String organization)', DEPRECATION_JAVADOC.format(new_method='formatOrganizationName(String)'))

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatProjectName(String project)', 'formatProjectName', 'formatProjectCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static String formatProjectCmekSettingsName(String project)', DEPRECATION_JAVADOC.format(new_method='formatProjectName(String)'))

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static BillingAccountCmekSettingsBuilder newBillingAccountBuilder()', 'newBillingAccountBuilder', 'newBillingAccountCmekSettingsBuilder')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static BillingAccountCmekSettingsBuilder newBillingAccountCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newBillingAccountBuilder()'))
    s.replace('**/CmekSettingsName', 'return newBillingAccountBuilder', 'return newBillingAccountCmekSettingsBuilder' )

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static FolderCmekSettingsBuilder newFolderBuilder()', 'newFolderBuilder', 'newFolderCmekSettingsBuilder')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static FolderCmekSettingsBuilder newFolderCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newFolderBuilder()'))
    s.replace('**/CmekSettingsName.java', 'return newFolderBuilder', 'return newFolderCmekSettingsBuilder')

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static OrganizationCmekSettingsBuilder newOrganizationBuilder()', 'newOrganizationBuilder', 'newOrganizationCmekSettingsBuilder')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static OrganizationCmekSettingsBuilder newOrganizationCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newOrganizationBuilder()'))
    s.replace('**/CmekSettingsName.java', 'return newOrganizationBuilder', 'return newOrganizationCmekSettingsBuilder')

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static Builder newProjectBuilder()', 'newProjectBuilder', 'newProjectCmekSettingsBuilder')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static Builder newProjectCmekSettingsBuilder()', DEPRECATION_JAVADOC.format(new_method='newProjectBuilder()'))

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofBillingAccountName(String billingAccount)', 'ofBillingAccountName', 'ofBillingAccountCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofBillingAccountCmekSettingsName(String billingAccount)', DEPRECATION_JAVADOC.format(new_method='ofBillingAccountName(String)'))
    s.replace('**/CmekSettingsName.java', 'return ofBillingAccountName', 'return ofBillingAccountCmekSettingsName')

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofFolderName(String folder)', 'ofFolderName', 'ofFolderCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofFolderCmekSettingsName(String folder)', DEPRECATION_JAVADOC.format(new_method='ofFolderName(String)'))
    s.replace('**/CmekSettingsName.java', 'return ofFolderName', 'return ofFolderCmekSettingsName')

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofOrganizationName(String organization)', 'ofOrganizationName', 'ofOrganizationCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofOrganizationCmekSettingsName(String organization)', DEPRECATION_JAVADOC.format(new_method='ofOrganizationName(String)'))
    s.replace('**/CmekSettingsName.java', 'return ofOrganizationName', 'return ofOrganizationCmekSettingsName')

    java.copy_and_rename_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java', 'public static CmekSettingsName ofProjectName(String project)', 'ofProjectName', 'ofProjectCmekSettingsName')
    java.deprecate_method('owl-bot-staging/v2/proto-google-cloud-logging-v2/src/main/java/com/google/logging/v2/CmekSettingsName.java','public static CmekSettingsName ofProjectCmekSettingsName(String project)', DEPRECATION_JAVADOC.format(new_method='ofProjectName(String)'))
    s.replace('**/CmekSettingsName.java', 'return ofProjectName', 'return ofProjectCmekSettingsName')

    s.replace('**/CmekSettingsName.java', 'BillingAccountBuilder', 'BillingAccountCmekSettingsBuilder')
    s.replace('**/CmekSettingsName.java', 'FolderBuilder', 'FolderCmekSettingsBuilder')
    s.replace('**/CmekSettingsName.java', 'OrganizationBuilder', 'OrganizationCmekSettingsBuilder')
    s.replace('**/ConfigClientTest.java', 'CmekSettingsName.ofProjectName', 'CmekSettingsName.ofProjectCmekSettingsName')

    s.move(library)

s.remove_staging_dirs()
java.common_templates(
    excludes=[
        ".gitignore",
        ".github/CODEOWNERS",
        ".github/blunderbuss.yml",
        "CONTRIBUTING.md",
        ".kokoro/requirements.in",
        ".kokoro/requirements.txt"
    ]
)

# --------------------------------------------------------------------------
# Modify test configs
# --------------------------------------------------------------------------

def _append_if_not_contained(src: str, dest: str, file: str):
    if src in dest:
        return dest
    return f"{dest}\n{src}"

def append_new_content(src: str, dest: str):
    # add shared environment variables to test configs
    s.move(
        src,
        dest,
        merge=_append_if_not_contained,
)

append_new_content(".kokoro/common_env_vars.cfg", ".kokoro/common.cfg")

tracked_subdirs = ["continuous", "presubmit", "release", "nightly"]
for subdir in tracked_subdirs:
    for path, subdirs, files in os.walk(f".kokoro/{subdir}"):
        for name in files:
            if name == "common.cfg":
                file_path = os.path.join(path, name)
                append_new_content(".kokoro/common_env_vars.cfg", file_path)