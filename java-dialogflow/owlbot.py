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
    # TODO: remove this for the next major version bump
    if 'formatProjectAgentName' not in open('owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java').read():
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static String formatProjectName',
            'public static String formatProjectAgentName'
        )
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static String formatProjectLocationName',
            'public static String formatProjectLocationAgentName'
        )
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'ProjectBuilder',
            'ProjectAgentBuilder'
        )
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'ProjectLocationBuilder',
            'ProjectLocationAgentBuilder'
        )

        DEPRECATION_JAVADOC = """Please use {{@link #{new_method}()}} instead"""


        java.copy_and_rename_method(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static AgentName ofProjectName(String project)',
            'ofProjectName',
            'ofProjectAgentName'
        )
        java.deprecate_method(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static AgentName ofProjectAgentName(String project)',
            DEPRECATION_JAVADOC.format(new_method='ofProjectName')
        )
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'return ofProjectName',
            'return ofProjectAgentName'
        )
        s.replace(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'return ofProjectLocationName',
            'return ofProjectLocationAgentName'
        )
        java.copy_and_rename_method(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static AgentName ofProjectLocationName(String project, String location)',
            'ofProjectLocationName',
            'ofProjectLocationAgentName'
        )
        java.deprecate_method(
            'owl-bot-staging/v2beta1/proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
            'public static AgentName ofProjectLocationAgentName(String project, String location)',
            DEPRECATION_JAVADOC.format(new_method='ofProjectLocationName')
        )

        s.replace(
            [
                'owl-bot-staging/v2beta1/google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/AgentsClientTest.java',
                'owl-bot-staging/v2beta1/google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/EnvironmentsClientTest.java',
                'owl-bot-staging/v2beta1/google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/EntityTypesClientTest.java',
                'owl-bot-staging/v2beta1/google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/IntentsClientTest.java',
                'owl-bot-staging/v2beta1/google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/VersionsClientTest.java'

            ],
            'ofProjectName',
            'ofProjectAgentName'
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
