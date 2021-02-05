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

service = 'monitoring'
versions = ['v3']

def fix_resource(client, version, name):
    s.replace(
        [f'google-cloud-monitoring/**/{version}/{client}.java'],
        f'import com.google.monitoring.{version}.{name}',
        'import com.google.api.resourcenames.ResourceName',
    )

    s.replace(
        [f'google-cloud-monitoring/**/{version}/{client}.java'],
        name,
        'ResourceName',
    )

for version in versions:
  java.bazel_library(
      service=service,
      version=version,
      proto_path=f'google/{service}/{version}',
      bazel_target=f'//google/{service}/{version}:google-cloud-{service}-{version}-java',
  )
  fix_resource('AlertPolicyServiceClient', version, 'FolderName')
  fix_resource('GroupServiceClient', version, 'FolderName')
  fix_resource('MetricServiceClient', version, 'FolderName')
  fix_resource('NotificationChannelServiceClient', version, 'FolderName')
  fix_resource('ServiceMonitoringServiceClient', version, 'FolderName')
  fix_resource('UptimeCheckServiceClient', version, 'FolderName')

  java.format_code(f'google-cloud-{service}/src')
  java.format_code(f'grpc-google-cloud-{service}-{version}/src')
  java.format_code(f'proto-google-cloud-{service}-{version}/src')

java.common_templates()
