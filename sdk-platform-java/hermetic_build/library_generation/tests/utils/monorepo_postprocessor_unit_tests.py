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

from library_generation.tests.test_utils import FileComparator
from library_generation.tests.test_utils import cleanup
from library_generation.utils.monorepo_postprocessor import monorepo_postprocessing

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources")
file_comparator = FileComparator()


class MonorepoPostprocessorTest(unittest.TestCase):
    def test_monorepo_postprocessing_valid_repository_success(self):
        repository_path = f"{resources_dir}/test_monorepo_postprocessing"
        versions_file = f"{repository_path}/versions.txt"
        files = [
            f"{repository_path}/pom.xml",
            f"{repository_path}/gapic-libraries-bom/pom.xml",
        ]
        cleanup(files)
        monorepo_postprocessing(
            repository_path=repository_path, versions_file=versions_file
        )
        file_comparator.compare_files(
            expect=f"{repository_path}/pom-golden.xml",
            actual=f"{repository_path}/pom.xml",
        )
        file_comparator.compare_files(
            expect=f"{repository_path}/gapic-libraries-bom/pom-golden.xml",
            actual=f"{repository_path}/gapic-libraries-bom/pom.xml",
        )
        cleanup(files)
