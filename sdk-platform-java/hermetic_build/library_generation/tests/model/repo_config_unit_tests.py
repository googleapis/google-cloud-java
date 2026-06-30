# Copyright 2024 Google LLC
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
import unittest

from library_generation.model.repo_config import RepoConfig

script_dir = os.path.dirname(os.path.realpath(__file__))
versions_file = os.path.join(script_dir, "..", "resources", "misc", "versions.txt")


class RepoConfigTest(unittest.TestCase):
    def test_get_library_versions_with_existing_library(self):
        repo_config = RepoConfig(
            output_folder="test", libraries=dict(), versions_file=versions_file
        )
        self.assertEqual(
            "2.25.0",
            repo_config.get_library_version("gapic-generator-java"),
        )
        self.assertEqual(
            "2.16.0",
            repo_config.get_library_version("api-common"),
        )
        self.assertEqual(
            "2.33.0",
            repo_config.get_library_version("gax"),
        )
        self.assertEqual(
            "2.34.0",
            repo_config.get_library_version("gax-grpc"),
        )
        self.assertEqual(
            "0.118.0",
            repo_config.get_library_version("gax-httpjson"),
        )

    def test_get_library_versions_with_new_library(self):
        repo_config = RepoConfig(
            output_folder="test", libraries=dict(), versions_file=versions_file
        )
        self.assertEqual(
            "0.0.0",
            repo_config.get_library_version("example-artifact"),
        )
