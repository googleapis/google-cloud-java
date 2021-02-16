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

service = 'dialogflow'
versions = ['v2', 'v2beta1']

for version in versions:
  java.bazel_library(
      service=service,
      version=version,
      bazel_target=f'//google/cloud/{service}/{version}:google-cloud-{service}-{version}-java',
  )

# TODO: remove this for the next major version bump
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'public static String formatProjectName',
  'public static String formatProjectAgentName'
)
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'public static String formatProjectLocationName',
  'public static String formatProjectLocationAgentName'
)
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'ProjectBuilder',
  'ProjectAgentBuilder'
)
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'ProjectLocationBuilder',
  'ProjectLocationAgentBuilder'
)
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'ofProjectName',
  'ofProjectAgentName'
)
s.replace(
  'proto-google-cloud-dialogflow-v2beta1/src/main/java/com/google/cloud/dialogflow/v2beta1/AgentName.java',
  'ofProjectLocationName',
  'ofProjectLocationAgentName'
)
s.replace(
  [
    'google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/AgentsClientTest.java',
    'google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/EnvironmentsClientTest.java',
    'google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/EntityTypesClientTest.java',
    'google-cloud-dialogflow/src/test/java/com/google/cloud/dialogflow/v2beta1/IntentsClientTest.java',
  ],
  'ofProjectName',
  'ofProjectAgentName'
)
java.format_code('proto-google-cloud-dialogflow-v2beta1/src')

java.common_templates()
