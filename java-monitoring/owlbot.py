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

def fix_resource(client, version, name):
    s.replace(
        [f'owl-bot-staging/{version}/google-cloud-monitoring/**/{version}/{client}.java'],
        f'import com.google.monitoring.{version}.{name}',
        'import com.google.api.resourcenames.ResourceName',
    )

    s.replace(
        [f'owl-bot-staging/{version}/google-cloud-monitoring/**/{version}/{client}.java'],
        name,
        'ResourceName',
    )
version='v3'
for library in s.get_staging_dirs():
    # put any special-case replacements here
    fix_resource('AlertPolicyServiceClient', version, 'FolderName')
    fix_resource('GroupServiceClient', version, 'FolderName')
    fix_resource('MetricServiceClient', version, 'FolderName')
    fix_resource('NotificationChannelServiceClient', version, 'FolderName')
    fix_resource('ServiceMonitoringServiceClient', version, 'FolderName')
    fix_resource('UptimeCheckServiceClient', version, 'FolderName')

    s.move(library)

s.remove_staging_dirs()
java.common_templates(excludes=[
    ".github/*",
    ".kokoro/*",
    ".samples/*",
    "CODE_OF_CONDUCT.md",
    "CONTRIBUTING.md",
    "LICENSE",
    "SECURITY.md",
    "java.header",
    "license-checks.xml",
    "renovate.json"
])
