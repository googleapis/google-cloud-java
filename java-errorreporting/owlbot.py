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


for library in s.get_staging_dirs():
    # put any special-case replacements here
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

    version = library.parts[len(library.parts) - 1]
    service = 'errorreporting'

    #java.fix_proto_headers('owl-bot-staging/v2beta1/proto-google-cloud-error-reporting-v1beta1')
    #java.fix_grpc_headers('owl-bot-staging/v2beta1/grpc-google-cloud-error-reporting-v1beta1', "")

    s.replace(
        'owl-bot-staging/v1beta1/google-cloud-errorreporting/src/**/ErrorGroupServiceClient.java',
        ERROR_GROUP_OVERLOAD_PREVIOUS_METHOD,
        "\g<1>\n\n" + ERROR_GROUP_OVERLOAD
    )
    s.replace(
        'owl-bot-staging/v1beta1/google-cloud-errorreporting/src/**/ErrorGroupServiceClient.java',
        "import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupName;",
        "import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupName;\nimport com.google.devtools.clouderrorreporting.v1beta1.GroupName;"
    )

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
