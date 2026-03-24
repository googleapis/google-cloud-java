#!/usr/bin/env python3
#  Copyright 2024 Google LLC
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


class BomConfig:
    """
    Class that represents an entry in dependencyManagement section.
    """

    def __init__(
        self,
        group_id: str,
        artifact_id: str,
        version: str,
        version_annotation: str,
        is_import: bool = True,
    ):
        self.group_id = group_id
        self.artifact_id = artifact_id
        self.version = version
        self.version_annotation = version_annotation
        self.is_import = is_import

    def __lt__(self, another):
        return self.group_id < another.group_id or (
            self.group_id == another.group_id and self.artifact_id < another.artifact_id
        )

    def __eq__(self, another):
        return (
            self.group_id == another.group_id
            and self.artifact_id == another.artifact_id
        )
