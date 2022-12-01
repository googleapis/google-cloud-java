# Copyright 2018 Google LLC
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

import json
from pathlib import Path
import re


def update_library_version(version: str, root_dir: str):
    """
    Rewrites all metadata files in ./samples/generated to the version number argument

    """
    root_dir_path = Path(root_dir)

    snippet_metadata_files = get_sample_metadata_files(root_dir_path)
    for file in snippet_metadata_files:
        with open(file, "r+") as f:
            data = json.load(f)
            data["clientLibrary"]["version"] = version
            f.seek(0)
            json.dump(data, f, indent=4)
            f.truncate()


def get_sample_metadata_files(dir: Path, regex: str = r"snippet_metadata"):
    """
    Walks through samples/generated to find all snippet metadata files, appends them to a list

    Returns:
    A list of all metadata files.
    """
    metadata_files = []
    for path_object in dir.glob("**/*"):
        if path_object.is_file():
            if re.search(regex, str(path_object)):
                metadata_files.append(str(Path(path_object).resolve()))
        if path_object.is_dir():
            get_sample_metadata_files(path_object)

    return metadata_files
