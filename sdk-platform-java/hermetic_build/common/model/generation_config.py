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
import os

import yaml
from typing import Optional
from common.model.library_config import LibraryConfig
from common.model.gapic_config import GapicConfig

REPO_LEVEL_PARAMETER = "Repo level parameter"
LIBRARY_LEVEL_PARAMETER = "Library level parameter"
GAPIC_LEVEL_PARAMETER = "GAPIC level parameter"
COMMON_PROTOS_LIBRARY_NAME = "common-protos"
GAPIC_GENERATOR_VERSION = "gapic_generator_version"
LIBRARIES_BOM_VERSION = "libraries_bom_version"
GENERATOR_VERSION_ENV_KEY = "GENERATOR_VERSION"


class GenerationConfig:
    """
    Class that represents the root of a generation_config.yaml
    """

    def __init__(
        self,
        googleapis_commitish: str,
        libraries: list[LibraryConfig],
        gapic_generator_version: Optional[str] = None,
        libraries_bom_version: Optional[str] = None,
    ):
        self.googleapis_commitish = googleapis_commitish
        self.libraries_bom_version = (
            libraries_bom_version if libraries_bom_version else ""
        )
        self.gapic_generator_version = GenerationConfig.__set_generator_version(
            gapic_generator_version
        )
        self.libraries = libraries
        # explicit set to None so that we can compute the
        # value in getter.
        self.__contains_common_protos = None
        self.__validate()

    def get_proto_path_to_library_name(self) -> dict[str, str]:
        """
        Get versioned proto_path to library_name mapping from configuration.

        :return: versioned proto_path to library_name mapping
        """
        paths = {}
        for library in self.libraries:
            for gapic_config in library.gapic_configs:
                paths[gapic_config.proto_path] = library.get_library_name()
        return paths

    def is_monorepo(self) -> bool:
        return len(self.libraries) > 1

    def contains_common_protos(self) -> bool:
        if self.__contains_common_protos is None:
            self.__contains_common_protos = False
            for library in self.libraries:
                if library.get_library_name() == COMMON_PROTOS_LIBRARY_NAME:
                    self.__contains_common_protos = True
                    break
        return self.__contains_common_protos

    @staticmethod
    def __set_generator_version(gapic_generator_version: Optional[str]) -> str:
        if gapic_generator_version is not None:
            return gapic_generator_version
        # if the generator version is not set through generation config,
        # get it from environment variable.
        gapic_generator_version = os.getenv(GENERATOR_VERSION_ENV_KEY)
        if not gapic_generator_version:
            raise ValueError(
                f"Environment variable {GENERATOR_VERSION_ENV_KEY}"
                f" is not set when the generator version is not"
                f" specified in the generation config."
            )
        return gapic_generator_version

    def __validate(self) -> None:
        seen_library_names = dict()
        for library in self.libraries:
            library_name = library.get_library_name()
            if library_name in seen_library_names:
                raise ValueError(
                    f"Both {library.name_pretty} and "
                    f"{seen_library_names.get(library_name)} have the same "
                    f"library name: {library_name}, please update one of the "
                    f"library to have a different library name."
                )
            seen_library_names[library_name] = library.name_pretty

    @staticmethod
    def from_yaml(path_to_yaml: str) -> "GenerationConfig":
        """
        Parses a yaml located in path_to_yaml.
        :param path_to_yaml: the path to the configuration file
        :return the parsed configuration represented by the "model" classes
        """
        with open(path_to_yaml, "r") as file_stream:
            config = yaml.safe_load(file_stream)

        libraries = _required(config, "libraries", REPO_LEVEL_PARAMETER)
        if not libraries:
            raise ValueError(f"Library is None in {path_to_yaml}.")

        parsed_libraries = list()
        for library in libraries:
            gapics = _required(library, "GAPICs")

            parsed_gapics = list()
            if not gapics:
                raise ValueError(f"GAPICs is None in {library}.")
            for gapic in gapics:
                proto_path = _required(gapic, "proto_path", GAPIC_LEVEL_PARAMETER)
                new_gapic = GapicConfig(proto_path)
                parsed_gapics.append(new_gapic)

            new_library = LibraryConfig(
                api_shortname=_required(library, "api_shortname"),
                api_description=_required(library, "api_description"),
                name_pretty=_required(library, "name_pretty"),
                product_documentation=_required(library, "product_documentation"),
                gapic_configs=parsed_gapics,
                library_type=_optional(library, "library_type", "GAPIC_AUTO"),
                release_level=_optional(library, "release_level", "preview"),
                api_id=_optional(library, "api_id", None),
                api_reference=_optional(library, "api_reference", None),
                codeowner_team=_optional(library, "codeowner_team", None),
                excluded_poms=_optional(library, "excluded_poms", None),
                excluded_dependencies=_optional(library, "excluded_dependencies", None),
                client_documentation=_optional(library, "client_documentation", None),
                distribution_name=_optional(library, "distribution_name", None),
                googleapis_commitish=_optional(library, "googleapis_commitish", None),
                group_id=_optional(library, "group_id", "com.google.cloud"),
                issue_tracker=_optional(library, "issue_tracker", None),
                library_name=_optional(library, "library_name", None),
                rest_documentation=_optional(library, "rest_documentation", None),
                rpc_documentation=_optional(library, "rpc_documentation", None),
                cloud_api=_optional(library, "cloud_api", True),
                requires_billing=_optional(library, "requires_billing", True),
                extra_versioned_modules=_optional(
                    library, "extra_versioned_modules", None
                ),
                recommended_package=_optional(library, "recommended_package", None),
                min_java_version=_optional(library, "min_java_version", None),
                transport=_optional(library, "transport", None),
            )
            parsed_libraries.append(new_library)

        parsed_config = GenerationConfig(
            googleapis_commitish=_required(
                config, "googleapis_commitish", REPO_LEVEL_PARAMETER
            ),
            gapic_generator_version=_optional(config, GAPIC_GENERATOR_VERSION, None),
            libraries_bom_version=_optional(config, LIBRARIES_BOM_VERSION, None),
            libraries=parsed_libraries,
        )

        return parsed_config


def _required(config: dict, key: str, level: str = LIBRARY_LEVEL_PARAMETER):
    if key not in config:
        message = (
            f"{level}, {key}, is not found in {config} in yaml."
            if level != REPO_LEVEL_PARAMETER
            else f"{level}, {key}, is not found in yaml."
        )
        raise ValueError(message)
    return config[key]


def _optional(config: dict, key: str, default: any):
    if key not in config:
        return default
    return config[key]
