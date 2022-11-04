# Copyright 2019 Google LLC
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

import os
import synthtool.languages.java as java
import synthtool as s

java.common_templates(excludes=[
    '.gitignore',
    '.github/CODEOWNERS',
    '.github/blunderbuss.yml',
    'CONTRIBUTING.md',
    '.github/auto-label.yaml',
    ".github/release-please.yml",
])

# --------------------------------------------------------------------------
# Modify test configs
# --------------------------------------------------------------------------

# add shared environment variables to test configs
s.move(
    ".kokoro/common_env_vars.cfg",
    ".kokoro/common.cfg",
    merge=lambda src, dst, _, : f"{dst}\n{src}",
)
tracked_subdirs = ["continuous", "presubmit", "release", "nightly"]
for subdir in tracked_subdirs:
    for path, subdirs, files in os.walk(f".kokoro/{subdir}"):
        for name in files:
            if name == "common.cfg":
                file_path = os.path.join(path, name)
                s.move(
                    ".kokoro/common_env_vars.cfg",
                    file_path,
                    merge=lambda src, dst, _, : f"{dst}\n{src}",
                )
