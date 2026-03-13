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
from hashlib import sha256
from typing import Optional
from common.model.gapic_config import GapicConfig
from common.model.gapic_inputs import GapicInputs


MAVEN_COORDINATE_SEPARATOR = ":"


class LibraryConfig:
    """
    Class that represents a library in a generation_config.yaml file
    """

    def __init__(
        self,
        api_shortname: str,
        api_description: str,
        name_pretty: str,
        product_documentation: str,
        gapic_configs: list[GapicConfig],
        library_type: Optional[str] = None,
        release_level: Optional[str] = None,
        api_id: Optional[str] = None,
        api_reference: Optional[str] = None,
        codeowner_team: Optional[str] = None,
        client_documentation: Optional[str] = None,
        distribution_name: Optional[str] = None,
        excluded_dependencies: Optional[str] = None,
        excluded_poms: Optional[str] = None,
        googleapis_commitish: Optional[str] = None,
        group_id: Optional[str] = "com.google.cloud",
        issue_tracker: Optional[str] = None,
        library_name: Optional[str] = None,
        rest_documentation: Optional[str] = None,
        rpc_documentation: Optional[str] = None,
        cloud_api: Optional[bool] = True,
        requires_billing: Optional[bool] = True,
        extra_versioned_modules: Optional[str] = None,
        recommended_package: Optional[str] = None,
        min_java_version: Optional[int] = None,
        transport: Optional[str] = None,
    ):
        self.api_shortname = api_shortname
        self.api_description = api_description
        self.name_pretty = name_pretty
        self.product_documentation = product_documentation
        self.gapic_configs = gapic_configs
        self.library_type = library_type if library_type else "GAPIC_AUTO"
        self.release_level = release_level if release_level else "preview"
        self.api_id = api_id
        self.api_reference = api_reference
        self.codeowner_team = codeowner_team
        self.excluded_dependencies = excluded_dependencies
        self.excluded_poms = excluded_poms
        self.client_documentation = client_documentation
        self.googleapis_commitish = googleapis_commitish
        self.group_id = group_id
        self.issue_tracker = issue_tracker
        self.library_name = library_name
        self.rest_documentation = rest_documentation
        self.rpc_documentation = rpc_documentation
        self.cloud_api = cloud_api
        self.requires_billing = requires_billing
        self.extra_versioned_modules = extra_versioned_modules
        self.recommended_package = recommended_package
        self.min_java_version = min_java_version
        self.distribution_name = self.__get_distribution_name(distribution_name)
        self.transport = self.__validate_transport(transport)

    def set_gapic_configs(self, gapic_configs: list[GapicConfig]) -> None:
        """
        Sets the gapic_configs for the library.

        Args:
            gapic_configs: The new list of GapicConfig objects.
        """
        self.gapic_configs = gapic_configs

    def get_library_name(self) -> str:
        """
        Return the library name of a given LibraryConfig object
        :return: the library name
        """
        return self.library_name if self.library_name else self.api_shortname

    def get_sorted_gapic_configs(self) -> list[GapicConfig]:
        return sorted(self.gapic_configs)

    def get_maven_coordinate(self) -> str:
        """
        Returns the Maven coordinate (group_id:artifact_id) of the library
        """
        return self.distribution_name

    def get_artifact_id(self) -> str:
        """
        Returns the artifact ID of the library
        """
        return self.get_maven_coordinate().split(MAVEN_COORDINATE_SEPARATOR)[-1]

    def get_transport(self, gapic_inputs: GapicInputs) -> str:
        """
        Returns the transport of the library. If directly set in library config, return it.
        Otherwise, return the transport inferred from gapic_inputs. This value is only
        used for postprocessing - the generation still infers the transport from BUILD
        files.
        """
        return self.transport if self.transport is not None else gapic_inputs.transport

    def __get_distribution_name(self, distribution_name: Optional[str]) -> str:
        LibraryConfig.__check_distribution_name(distribution_name)
        if distribution_name:
            return distribution_name
        cloud_prefix = "cloud-" if self.cloud_api else ""
        library_name = self.get_library_name()
        return f"{self.group_id}:google-{cloud_prefix}{library_name}"

    def __validate_transport(self, transport: str):
        if transport not in [None, "grpc", "rest", "both"]:
            raise ValueError(
                "allowed values for library.transport: grpc, rest, both and None"
            )
        return transport

    @staticmethod
    def __check_distribution_name(distribution_name: str) -> None:
        if not distribution_name:
            return
        sections = distribution_name.split(MAVEN_COORDINATE_SEPARATOR)
        if len(sections) != 2:
            raise ValueError(f"{distribution_name} is not a valid distribution name.")

    def __eq__(self, other):
        return (
            self.api_shortname == other.api_shortname
            and self.api_description == other.api_description
            and self.name_pretty == other.name_pretty
            and self.product_documentation == other.product_documentation
            and self.gapic_configs == other.gapic_configs
            and self.library_type == other.library_type
            and self.release_level == other.release_level
            and self.api_id == other.api_id
            and self.api_reference == other.api_reference
            and self.codeowner_team == other.codeowner_team
            and self.excluded_dependencies == other.excluded_dependencies
            and self.excluded_poms == other.excluded_poms
            and self.client_documentation == other.client_documentation
            and self.distribution_name == other.distribution_name
            and self.googleapis_commitish == other.googleapis_commitish
            and self.group_id == other.group_id
            and self.issue_tracker == other.issue_tracker
            and self.library_name == other.library_name
            and self.rest_documentation == other.rest_documentation
            and self.rpc_documentation == other.rpc_documentation
            and self.cloud_api == other.cloud_api
            and self.requires_billing == other.requires_billing
            and self.extra_versioned_modules == other.extra_versioned_modules
            and self.recommended_package == other.recommended_package
            and self.min_java_version == other.min_java_version
            and self.transport == other.transport
        )

    def __hash__(self):
        m = sha256()
        m.update(
            str(
                [
                    self.api_shortname,
                    self.api_description,
                    self.name_pretty,
                    self.product_documentation,
                    self.library_type,
                    self.release_level,
                    self.api_id,
                    self.api_reference,
                    self.codeowner_team,
                    self.excluded_dependencies,
                    self.excluded_poms,
                    self.client_documentation,
                    self.distribution_name,
                    self.googleapis_commitish,
                    self.group_id,
                    self.issue_tracker,
                    self.library_name,
                    self.rest_documentation,
                    self.rpc_documentation,
                    self.cloud_api,
                    self.requires_billing,
                    self.extra_versioned_modules,
                    self.recommended_package,
                    self.min_java_version,
                    self.transport,
                ]
                + [config.proto_path for config in self.gapic_configs]
            ).encode("utf-8")
        )
        return int(m.hexdigest(), 16)
