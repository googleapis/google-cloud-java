# Copyright 2026 Google LLC
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

'This script is used to synthesize generated parts of this library.'
import re
import os.path
data_internal_only = ['owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/BigtableStub.java', 'owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/BigtableStubSettings.java', 'owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/GrpcBigtableStub.java', 'owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/GrpcBigtableCallableFactory.java']
def make_internal_only(sources):
    """Annotates all toplevel classes with `@InternalOnly`"""
    s.replace(sources, before='^(import (?!static).*?\\n)\\n', after='\\1import com.google.api.core.InternalApi;\\n\\n', flags=re.MULTILINE | re.DOTALL)
    s.replace(sources, before='/\\*\\*.+?\\*/\\n(?:^@[^\\n]*\\n)*(?=public [a-zA-B ]*class)', after='/** For internal use only. */\n@Generated("by gapic-generator")\n@InternalApi\n', flags=re.MULTILINE | re.DOTALL)

for library in s.get_staging_dirs():
    # put any special-case replacements here
    make_internal_only(data_internal_only)
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClient.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClient.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataSettings.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataSettings.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClientTest.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClientTest.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/MockBigtable.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/MockBigtable.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/MockBigtableImpl.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/test/java/com/google/cloud/bigtable/data/v2/MockBigtableImpl.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/package-info.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/package-info.java')
    if os.path.exists('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/package-info.java'):
        os.remove('owl-bot-staging/v2/google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/package-info.java')
    s.replace(f'{library}/**/BaseBigtable*AdminClient.java', 'public static final BaseBigtable(.*)AdminClient create\\(', 'protected static BaseBigtable\\1AdminClient create(')

    # Remove the 'final' modifier from the close() method in the Base Admin clients
    # This allows our handwritten wrappers to override close() and clean up custom executors.
    s.replace(
        f"{library}/**/BaseBigtable*AdminClient.java",
        r"public final void close\(\) \{",
        r"public void close() {"
    )
    s.move(library)
s.remove_staging_dirs()
java.common_templates(
    monorepo=True,
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
