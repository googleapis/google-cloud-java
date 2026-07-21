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
import os

for library in s.get_staging_dirs():
    # put any special-case replacements here
    if os.path.exists('owl-bot-staging/v2/gapic-google-cloud-storage-v2/src/main/java/com/google/storage/v2/gapic_metadata.json'):
        os.remove('owl-bot-staging/v2/gapic-google-cloud-storage-v2/src/main/java/com/google/storage/v2/gapic_metadata.json')
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
