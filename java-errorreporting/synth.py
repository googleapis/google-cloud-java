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
import synthtool.gcp as gcp
import synthtool.languages.java as java

gapic = gcp.GAPICGenerator()

service = 'error-reporting'
versions = ['v1beta1']
config_pattern = '/google/devtools/clouderrorreporting/artman_errorreporting.yaml'

ERROR_GROUP_OVERLOAD = """
  // Inserted by synthtool to preserve backwards-compatibility
  /**
   * Get the specified group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
   *   GroupName groupName = GroupName.of("[PROJECT]", "[GROUP]");
   *   ErrorGroup response = errorGroupServiceClient.getGroup(groupName);
   * }
   * </code></pre>
   *
   * @param groupName Required. The group resource name. Written as
   *     &lt;code&gt;projects/&lt;var&gt;projectID&lt;/var&gt;/groups/&lt;var&gt;group_name&lt;/var&gt;&lt;/code&gt;.
   *     Call &lt;a href="/error-reporting/reference/rest/v1beta1/projects.groupStats/list"&gt;
   *     &lt;code&gt;groupStats.list&lt;/code&gt;&lt;/a&gt; to return a list of groups belonging to
   *     this project.
   *     <p>Example: &lt;code&gt;projects/my-project-123/groups/my-group&lt;/code&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use ErrorGroupServiceClient#getGroup(ErrorGroupName)
   */
  @Deprecated
  public final ErrorGroup getGroup(GroupName groupName) {

    GetGroupRequest request =
        GetGroupRequest.newBuilder()
            .setGroupName(groupName == null ? null : groupName.toString())
            .build();
    return getGroup(request);
  }
"""

ERROR_GROUP_OVERLOAD_PREVIOUS_METHOD = r'(\s+public ErrorGroupServiceStub getStub\(\) {\n\s+return stub;\n\s+})'

for version in versions:
  library = gapic.java_library(
      service=service,
      version=version,
      config_path=config_pattern.format(version=version),
      artman_output_name='')

  package_name = f'com.google.devtools.clouderrorreporting.{version}'
  java.fix_proto_headers(library / f'proto-google-cloud-{service}-{version}')
  java.fix_grpc_headers(library / f'grpc-google-cloud-{service}-{version}', package_name)

  s.replace(
      library / f'gapic-google-cloud-{service}-{version}/src/**/ErrorGroupServiceClient.java',
      ERROR_GROUP_OVERLOAD_PREVIOUS_METHOD,
      "\g<1>\n\n" + ERROR_GROUP_OVERLOAD
  )
  s.replace(
      library / f'gapic-google-cloud-{service}-{version}/src/**/ErrorGroupServiceClient.java',
      "import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupName;",
      "import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupName;\nimport com.google.devtools.clouderrorreporting.v1beta1.GroupName;"
  )

  s.copy(library / f'gapic-google-cloud-{service}-{version}/src', f'google-cloud-errorreporting/src')
  s.copy(library / f'grpc-google-cloud-{service}-{version}/src', f'grpc-google-cloud-{service}-{version}/src')
  s.copy(library / f'proto-google-cloud-{service}-{version}/src', f'proto-google-cloud-{service}-{version}/src')

  java.format_code(f'google-cloud-errorreporting/src')
  java.format_code(f'grpc-google-cloud-{service}-{version}/src')
  java.format_code(f'proto-google-cloud-{service}-{version}/src')

common_templates = gcp.CommonTemplates()
templates = common_templates.java_library()
s.copy(templates, excludes=[
    'README.md',
])