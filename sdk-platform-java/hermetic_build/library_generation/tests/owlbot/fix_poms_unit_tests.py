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
import shutil
import unittest
from library_generation.owlbot.src.fix_poms import main
from library_generation.tests.compare_poms import compare_pom_in_subdir

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources", "test-owlbot")


class FixPomsTest(unittest.TestCase):
    def test_update_poms_group_id_does_not_start_with_google_correctly(self):
        ad_manager_resource = os.path.join(resources_dir, "java-admanager")
        versions_file = os.path.join(ad_manager_resource, "versions.txt")
        os.chdir(ad_manager_resource)
        sub_dirs = ["ad-manager", "ad-manager-bom", "proto-ad-manager-v1", "."]
        for sub_dir in sub_dirs:
            self.__copy__golden(ad_manager_resource, sub_dir)
        main(versions_file, "true")
        for sub_dir in sub_dirs:
            self.assertFalse(compare_pom_in_subdir(ad_manager_resource, sub_dir))
        for sub_dir in sub_dirs:
            self.__remove_file_in_subdir(ad_manager_resource, sub_dir)

    @classmethod
    def __copy__golden(cls, base_dir: str, subdir: str):
        golden = os.path.join(base_dir, subdir, "pom-golden.xml")
        pom = os.path.join(base_dir, subdir, "pom.xml")
        shutil.copyfile(golden, pom)

    @classmethod
    def __remove_file_in_subdir(cls, base_dir: str, subdir: str):
        pom = os.path.join(base_dir, subdir, "pom.xml")
        os.unlink(pom)
