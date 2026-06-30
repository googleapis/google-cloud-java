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
import unittest

from library_generation.generate_repo import get_target_libraries
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig

from common.model.gapic_config import GapicConfig


class GenerateRepoTest(unittest.TestCase):
    def test_get_target_library_returns_selected_libraries(self):
        one_library = GenerateRepoTest.__get_an_empty_library_config()
        one_library.api_shortname = "one_library"
        another_library = GenerateRepoTest.__get_an_empty_library_config()
        another_library.api_shortname = "another_library"
        config = GenerateRepoTest.__get_an_empty_generation_config()
        config.libraries.extend([one_library, another_library])
        target_libraries = get_target_libraries(config, ["another_library"])
        self.assertEqual([another_library], target_libraries)

    def test_get_target_library_given_null_returns_all_libraries(self):
        one_library = GenerateRepoTest.__get_an_empty_library_config()
        one_library.api_shortname = "one_library"
        another_library = GenerateRepoTest.__get_an_empty_library_config()
        another_library.api_shortname = "another_library"
        config = GenerateRepoTest.__get_an_empty_generation_config()
        config.libraries.extend([one_library, another_library])
        target_libraries = get_target_libraries(config)
        self.assertEqual([one_library, another_library], target_libraries)

    def test_get_target_library_given_an_non_existent_library_returns_only_existing_libraries(
        self,
    ):
        one_library = GenerateRepoTest.__get_an_empty_library_config()
        one_library.api_shortname = "one_library"
        another_library = GenerateRepoTest.__get_an_empty_library_config()
        another_library.api_shortname = "another_library"
        config = GenerateRepoTest.__get_an_empty_generation_config()
        config.libraries.extend([one_library, another_library])
        target_libraries = get_target_libraries(
            config, ["one_library", "another_library", "non_existent_library"]
        )
        self.assertEqual([one_library, another_library], target_libraries)

    def test_get_target_library_returns_selected_api_path(self):
        one_library = GenerateRepoTest.__get_an_empty_library_config()
        one_library.api_shortname = "one_library"
        one_library.gapic_configs = [GapicConfig("google/cloud/one/library/v1")]
        another_library = GenerateRepoTest.__get_an_empty_library_config()
        another_library.api_shortname = "another_library"
        another_library_gapic_config = list()
        another_library_gapic_config.append(
            GapicConfig("google/cloud/another/library/v1")
        )
        another_library_gapic_config.append(
            GapicConfig("google/cloud/another/library/v2")
        )
        another_library.gapic_configs = another_library_gapic_config
        config = GenerateRepoTest.__get_an_empty_generation_config()
        config.libraries.extend([one_library, another_library])
        target_libraries = get_target_libraries(
            config, target_api_path="google/cloud/another/library/v2"
        )
        another_library_v1 = GenerateRepoTest.__get_an_empty_library_config()
        another_library_v1.api_shortname = "another_library"
        another_library_v1.gapic_configs = [
            GapicConfig("google/cloud/another/library/v2")
        ]

        self.assertEqual([another_library_v1], target_libraries)

    def test_get_target_library_returns_selected_api_path_plus_dep(self):
        one_library = GenerateRepoTest.__get_an_empty_library_config()
        one_library.api_shortname = "one_library"
        one_library.gapic_configs = [GapicConfig("google/cloud/one/library/v1")]
        another_library = GenerateRepoTest.__get_an_empty_library_config()
        another_library.api_shortname = "another_library"
        another_library_gapic_config = list()
        another_library_gapic_config.append(
            GapicConfig("google/cloud/another/library/v1")
        )
        another_library_gapic_config.append(
            GapicConfig("google/cloud/another/library/v2")
        )
        another_library_gapic_config.append(
            GapicConfig("google/cloud/another/library/type")
        )
        another_library.gapic_configs = another_library_gapic_config
        config = GenerateRepoTest.__get_an_empty_generation_config()
        config.libraries.extend([one_library, another_library])
        target_libraries = get_target_libraries(
            config, target_api_path="google/cloud/another/library/v2"
        )
        another_library_v1 = GenerateRepoTest.__get_an_empty_library_config()
        another_library_v1.api_shortname = "another_library"
        another_library_v1.gapic_configs = [
            GapicConfig("google/cloud/another/library/v2"),
            GapicConfig("google/cloud/another/library/type"),
        ]

        self.assertEqual([another_library_v1], target_libraries)

    def test_get_target_library_invalid_target_api_path(self):
        """
        Tests when the api_path is invalid and sys.exit is called.
        """
        config = GenerateRepoTest.__get_an_empty_library_config()
        with self.assertRaises(ValueError) as context:
            _target_libraries = get_target_libraries(
                config, target_api_path="google/cloud/another/library/type"
            )

        self.assertEqual(
            str(context.exception),
            "api_path is not ending with a version is not supported",
        )

    @staticmethod
    def __get_an_empty_generation_config() -> GenerationConfig:
        return GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[],
        )

    @staticmethod
    def __get_an_empty_library_config() -> LibraryConfig:
        return LibraryConfig(
            api_shortname="",
            name_pretty="",
            api_description="",
            product_documentation="",
            gapic_configs=[],
        )
