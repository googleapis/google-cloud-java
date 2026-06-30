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
import re
from typing import Optional

ALPHA_VERSION = "alpha"
BETA_VERSION = "beta"


class GapicConfig:
    """
    Class that represents a GAPICs single entry, inside a `LibraryConfig` in
    a generation_config.yaml
    """

    def __init__(self, proto_path: str):
        self.proto_path = proto_path
        self.version = self.__parse_version()

    def is_stable(self):
        return (
            self.version
            and (ALPHA_VERSION not in self.version)
            and (BETA_VERSION not in self.version)
        )

    def get_version(self):
        return self.version

    def __parse_version(self) -> Optional[str]:
        version_regex = re.compile(r"^v[1-9]+(p[1-9]+)*(alpha|beta)?.*")
        for directory in self.proto_path.split("/"):
            if version_regex.search(directory):
                return directory
        return None

    def __eq__(self, other) -> bool:
        if not isinstance(other, GapicConfig):
            return False
        return self.proto_path == other.proto_path

    def __lt__(self, other) -> bool:
        if not isinstance(other, GapicConfig):
            raise ValueError(
                f"Type {type(other)} can't be comparable " f"with GapicConfig."
            )

        self_version = self.get_version()
        other_version = other.get_version()
        self_dirs = self.proto_path.split("/")
        other_dirs = other.proto_path.split("/")
        # Case 1: if both of the configs don't have a version in proto_path,
        # the one with lower depth is smaller.
        if (not self_version) and (not other_version):
            return len(self_dirs) < len(other_dirs)
        # Case 2: if only one config has a version in proto_path, it is smaller
        # than the other one.
        if self_version and (not other_version):
            return True
        if (not self_version) and other_version:
            return False
        # Two configs both have a version in proto_path.
        self_stable = self.is_stable()
        other_stable = other.is_stable()
        # Case 3, if only config has a stable version in proto_path, it is
        # smaller than the other one.
        if self_stable and (not other_stable):
            return True
        if (not self_stable) and other_stable:
            return False
        # Case 4, if two configs have a non-stable version in proto_path,
        # the one with higher version is smaller.
        # Note that using string comparison may lead unexpected result,
        # e.g., v1beta10 is smaller than v1beta2.
        # In reality, however, there's unlikely that a library has >10 beta
        # versions.
        if (not self_stable) and (not other_stable):
            return self_version > other_version
        # Two configs both have a stable version in proto_path.
        # Case 5, if two configs have different depth in proto_path, the one
        # with lower depth is smaller.
        if len(self_dirs) != len(other_dirs):
            return len(self_dirs) < len(other_dirs)
        # Case 6, the config with higher stable version is smaller.
        self_num = int(self_version[1:])
        other_num = int(other_version[1:])
        return self_num > other_num
