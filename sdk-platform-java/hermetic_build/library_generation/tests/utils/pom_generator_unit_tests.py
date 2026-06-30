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

from library_generation.utils.pom_generator import get_version_from

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources")


class PomGeneratorTest(unittest.TestCase):
    def test_get_version_from_returns_current(self):
        versions_file = f"{resources_dir}/misc/versions.txt"
        artifact = "gax-grpc"
        self.assertEqual("2.33.1-SNAPSHOT", get_version_from(versions_file, artifact))

    def test_get_version_from_returns_released(self):
        versions_file = f"{resources_dir}/misc/versions.txt"
        artifact = "gax-grpc"
        self.assertEqual("2.34.0", get_version_from(versions_file, artifact, True))
