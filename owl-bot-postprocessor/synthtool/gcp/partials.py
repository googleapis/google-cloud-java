# Copyright 2020 Google LLC
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
import yaml
from pathlib import Path
from typing import Dict, List

# these are the default locations to look up
_DEFAULT_PARTIAL_FILES = [".readme-partials.yml", ".readme-partials.yaml"]


def load_partials(files: List[str] = _DEFAULT_PARTIAL_FILES) -> Dict:
    """
    hand-crafted artisinal markdown can be provided in a .readme-partials.yml.
    The following fields are currently supported:

    body: custom body to include in the usage section of the document.
    samples_body: an optional body to place below the table of contents
        in samples/README.md.
    introduction: a more thorough introduction than metadata["description"].
    title: provide markdown to use as a custom title.
    deprecation_warning: a warning to indicate that the library has been
        deprecated and a pointer to an alternate option
    """
    cwd_path = Path(os.getcwd())
    partials_file = None
    for file in files:
        if os.path.exists(cwd_path / file):
            partials_file = cwd_path / file
            break
    if not partials_file:
        return {}
    with open(partials_file) as f:
        return yaml.load(f, Loader=yaml.SafeLoader)
