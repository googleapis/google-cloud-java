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

    def test_update_bom_pom_excludes_vertexai_comment(self):
        import tempfile
        from library_generation.owlbot.src.poms.module import Module
        from library_generation.owlbot.src.fix_poms import update_bom_pom

        # Minimal XML structure
        initial_xml = """<?xml version="1.0" encoding="utf-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <dependencyManagement>
    <dependencies>
    </dependencies>
  </dependencyManagement>
</project>"""

        with tempfile.NamedTemporaryFile(mode="w+", delete=False) as tmp:
            tmp.write(initial_xml)
            tmp_path = tmp.name

        try:
            modules = [
                Module(
                    group_id="com.google.cloud",
                    artifact_id="google-cloud-vertexai",
                    version="1.0.0",
                    release_version="1.0.0",
                ),
                Module(
                    group_id="com.google.cloud",
                    artifact_id="google-cloud-datastore",
                    version="1.0.0",
                    release_version="1.0.0",
                ),
            ]

            update_bom_pom(tmp_path, modules)

            with open(tmp_path, "r") as f:
                content = f.read()

            self.assertNotIn("x-version-update:google-cloud-vertexai:current", content)
            self.assertIn("x-version-update:google-cloud-datastore:current", content)

        finally:
            import os

            os.unlink(tmp_path)

    @classmethod
    def __copy__golden(cls, base_dir: str, subdir: str):
        golden = os.path.join(base_dir, subdir, "pom-golden.xml")
        pom = os.path.join(base_dir, subdir, "pom.xml")
        shutil.copyfile(golden, pom)

    @classmethod
    def __remove_file_in_subdir(cls, base_dir: str, subdir: str):
        pom = os.path.join(base_dir, subdir, "pom.xml")
        os.unlink(pom)
