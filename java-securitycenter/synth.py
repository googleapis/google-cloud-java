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

service = 'securitycenter'
versions = ['v1p1beta1', 'v1beta1', 'v1']

for version in versions:
  library = java.bazel_library(
      service=service,
      version=version,
      bazel_target=f'//google/cloud/{service}/{version}:google-cloud-{service}-{version}-java',
  )

  # TODO: remove for next major release (2.0.0)
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "formatOrganizationAssetName\(",
      "formatOrganizationAssetSecurityMarksName("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "formatOrganizationSourceFindingName\(",
      "formatOrganizationSourceFindingSecurityMarksName("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "newOrganizationAssetBuilder\(",
      "newOrganizationAssetSecurityMarksBuilder("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "newOrganizationSourceFindingBuilder\(",
      "newOrganizationSourceFindingSecurityMarksBuilder("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "ofOrganizationAssetName\(",
      "ofOrganizationAssetSecurityMarksName("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "ofOrganizationSourceFindingName\(",
      "ofOrganizationSourceFindingSecurityMarksName("
  )
  s.replace(
      [f"proto-google-cloud-securitycenter-{version}/**/SecurityMarksName.java"],
      "OrganizationSourceFindingBuilder",
      "OrganizationSourceFindingSecurityMarksBuilder",
  )
  java.format_code(f"proto-google-cloud-securitycenter-{version}")

s.replace(
  [f"google-cloud-securitycenter/**/SecurityCenterClientTest.java"],
  "SecurityMarksName.ofOrganizationAssetName",
  "SecurityMarksName.ofOrganizationAssetSecurityMarksName"
)
java.format_code(f"google-cloud-securitycenter")

java.common_templates()
