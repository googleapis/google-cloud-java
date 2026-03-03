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
from common.model.library_config import LibraryConfig


GRPC_PREFIX = "grpc-"
PROTO_PREFIX = "proto-"
NEW_CLIENT_VERSION = "0.0.0"


class RepoConfig:
    """
    Class that represents a generated repository
    """

    def __init__(
        self,
        output_folder: str,
        libraries: dict[str, LibraryConfig],
        versions_file: str,
    ):
        """
        Init a RepoConfig object

        :param output_folder: the path to which the generated repo goes
        :param libraries: a mapping from library_path to LibraryConfig object
        :param versions_file: the path of versions.txt used in post-processing
        """
        self.output_folder = output_folder
        self.libraries = libraries
        self.versions_file = versions_file
        self.library_versions = self.__parse_versions()

    def get_libraries(self) -> dict[str, LibraryConfig]:
        return self.libraries

    def get_library_version(self, artifact_id: str) -> str:
        """
        Returns the version of a given artifact ID.
        If the artifact ID is not managed, i.e., a new client, returns `0.0.0`.

        :param artifact_id: the Maven artifact ID.
        :return: the version of the artifact.
        """
        return self.library_versions.get(artifact_id, NEW_CLIENT_VERSION)

    def __parse_versions(self) -> dict[str, str]:
        """
        For a given versions.txt file (defined in self.versions_file)
        creates a map of artifact-id to its version

        :return: a map "artifact-id -> version"
        """
        library_versions = dict()
        with open(self.versions_file) as f:
            for line in f.readlines():
                sections = line.split(":")
                # skip comments and empty lines.
                if len(sections) != 3:
                    continue
                artifact_id = sections[0]
                released_version = sections[1]
                if artifact_id.startswith(GRPC_PREFIX) or artifact_id.startswith(
                    PROTO_PREFIX
                ):
                    continue
                library_versions[artifact_id] = released_version
        return library_versions
