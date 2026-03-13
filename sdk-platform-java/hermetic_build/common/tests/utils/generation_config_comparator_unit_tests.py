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
import unittest

from common.model.gapic_config import GapicConfig
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig
from common.utils.generation_config_comparator import ChangeType
from common.utils.generation_config_comparator import compare_config


class GenerationConfigComparatorTest(unittest.TestCase):
    def setUp(self) -> None:
        self.baseline_library = LibraryConfig(
            api_shortname="existing_library",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=[],
        )
        self.current_library = LibraryConfig(
            api_shortname="existing_library",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=[],
        )
        self.baseline_config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[self.baseline_library],
        )
        self.current_config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[self.current_library],
        )

    def test_compare_config_not_change(self):
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(len(result.change_to_libraries) == 0)

    def test_compare_config_googleapis_update(self):
        self.baseline_config.googleapis_commitish = (
            "1a45bf7393b52407188c82e63101db7dc9c72026"
        )
        self.current_config.googleapis_commitish = (
            "1e6517ef4f949191c9e471857cf5811c8abcab84"
        )
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertEqual({ChangeType.GOOGLEAPIS_COMMIT: []}, result.change_to_libraries)

    def test_compare_config_generator_update(self):
        self.baseline_config.gapic_generator_version = "1.2.3"
        self.current_config.gapic_generator_version = "1.2.4"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE][0]
        self.assertEqual("gapic_generator_version", config_change.changed_param)
        self.assertEqual("1.2.4", config_change.current_value)

    def test_compare_config_libraries_bom_update(self):
        self.baseline_config.libraries_bom_version = "26.36.0"
        self.current_config.libraries_bom_version = "26.37.0"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE][0]
        self.assertEqual("libraries_bom_version", config_change.changed_param)
        self.assertEqual("26.37.0", config_change.current_value)

    def test_compare_protobuf_update(self):
        self.baseline_config.protoc_version = "3.25.2"
        self.current_config.protoc_version = "3.27.0"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE][0]
        self.assertEqual("protoc_version", config_change.changed_param)
        self.assertEqual("3.27.0", config_change.current_value)

    def test_compare_config_grpc_update(self):
        self.baseline_config.grpc_version = "1.60.0"
        self.current_config.grpc_version = "1.61.0"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE][0]
        self.assertEqual("grpc_version", config_change.changed_param)
        self.assertEqual("1.61.0", config_change.current_value)

    def test_compare_config_template_excludes_update(self):
        self.baseline_config.template_excludes = [".github/*", ".kokoro/*"]
        self.current_config.template_excludes = [
            ".github/*",
            ".kokoro/*",
            "samples/*",
            "CODE_OF_CONDUCT.md",
        ]
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE][0]
        self.assertEqual("template_excludes", config_change.changed_param)
        self.assertEqual(
            [
                ".github/*",
                ".kokoro/*",
                "samples/*",
                "CODE_OF_CONDUCT.md",
            ],
            config_change.current_value,
        )

    def test_compare_config_library_addition(self):
        self.current_config.libraries.append(
            LibraryConfig(
                api_shortname="new_library",
                api_description="",
                name_pretty="",
                product_documentation="",
                gapic_configs=[],
            )
        )
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARIES_ADDITION]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARIES_ADDITION][0]
        self.assertEqual("new_library", config_change.library_name)

    def test_compare_config_library_removal_does_not_have_repo_or_library_level_change(
        self,
    ):
        self.current_config.libraries = []
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.REPO_LEVEL_CHANGE]) == 0
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 0
        )

    def test_compare_config_api_shortname_update_without_library_name(self):
        self.current_config.libraries[0].api_shortname = "new_api_shortname"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARIES_ADDITION]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARIES_ADDITION][0]
        self.assertEqual("new_api_shortname", config_change.library_name)

    def test_compare_config_api_shortname_update_with_library_name_raise_error(self):
        self.baseline_config.libraries[0].library_name = "old_library_name"
        self.current_config.libraries[0].library_name = "old_library_name"
        self.current_config.libraries[0].api_shortname = "new_api_shortname"
        self.assertRaisesRegex(
            ValueError,
            r"api_shortname.*library_name",
            compare_config,
            self.baseline_config,
            self.current_config,
        )

    def test_compare_config_library_name_update(self):
        self.current_config.libraries[0].library_name = "new_library_name"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARIES_ADDITION]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARIES_ADDITION][0]
        self.assertEqual("new_library_name", config_change.library_name)

    def test_compare_config_api_description_update(self):
        self.current_config.libraries[0].api_description = "updated description"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("api_description", config_change.changed_param)
        self.assertEqual("updated description", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_name_pretty_update(self):
        self.current_config.libraries[0].name_pretty = "new name"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("name_pretty", config_change.changed_param)
        self.assertEqual("new name", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_product_docs_update(self):
        self.current_config.libraries[0].product_documentation = "new docs"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("product_documentation", config_change.changed_param)
        self.assertEqual("new docs", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_library_type_update(self):
        self.current_config.libraries[0].library_type = "GAPIC_COMBO"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("library_type", config_change.changed_param)
        self.assertEqual("GAPIC_COMBO", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_release_level_update(self):
        self.current_config.libraries[0].release_level = "STABLE"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("release_level", config_change.changed_param)
        self.assertEqual("STABLE", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_api_id_update(self):
        self.current_config.libraries[0].api_id = "new_id"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("api_id", config_change.changed_param)
        self.assertEqual("new_id", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_api_reference_update(self):
        self.current_config.libraries[0].api_reference = "new api_reference"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("api_reference", config_change.changed_param)
        self.assertEqual("new api_reference", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_code_owner_team_update(self):
        self.current_config.libraries[0].codeowner_team = "new team"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("codeowner_team", config_change.changed_param)
        self.assertEqual("new team", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_excluded_deps_update(self):
        self.current_config.libraries[0].excluded_dependencies = "group:artifact"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("excluded_dependencies", config_change.changed_param)
        self.assertEqual("group:artifact", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_excluded_poms_update(self):
        self.current_config.libraries[0].excluded_poms = "pom.xml"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("excluded_poms", config_change.changed_param)
        self.assertEqual("pom.xml", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_client_docs_update(self):
        self.current_config.libraries[0].client_documentation = "new client docs"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("client_documentation", config_change.changed_param)
        self.assertEqual("new client docs", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_distribution_name_update(self):
        self.current_config.libraries[0].distribution_name = "new_group:new_artifact"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("distribution_name", config_change.changed_param)
        self.assertEqual("new_group:new_artifact", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_group_id_update(self):
        self.current_config.libraries[0].group_id = "new_group"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("group_id", config_change.changed_param)
        self.assertEqual("new_group", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_issue_tracker_update(self):
        self.current_config.libraries[0].issue_tracker = "new issue tracker"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("issue_tracker", config_change.changed_param)
        self.assertEqual("new issue tracker", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_rest_docs_update(self):
        self.current_config.libraries[0].rest_documentation = "new rest docs"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("rest_documentation", config_change.changed_param)
        self.assertEqual("new rest docs", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_rpc_docs_update(self):
        self.current_config.libraries[0].rpc_documentation = "new rpc docs"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("rpc_documentation", config_change.changed_param)
        self.assertEqual("new rpc docs", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_cloud_api_update(self):
        self.current_config.libraries[0].cloud_api = False
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("cloud_api", config_change.changed_param)
        self.assertEqual(False, config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_requires_billing_update(self):
        self.current_config.libraries[0].requires_billing = False
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("requires_billing", config_change.changed_param)
        self.assertEqual(False, config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_extra_versioned_mod_update(self):
        self.current_config.libraries[0].extra_versioned_modules = "extra module"
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(
            len(result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE]) == 1
        )
        config_change = result.change_to_libraries[ChangeType.LIBRARY_LEVEL_CHANGE][0]
        self.assertEqual("extra_versioned_modules", config_change.changed_param)
        self.assertEqual("extra module", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)

    def test_compare_config_version_addition(self):
        self.current_config.libraries[0].gapic_configs = [
            GapicConfig(proto_path="google/new/library/v1")
        ]
        result = compare_config(
            baseline_config=self.baseline_config,
            current_config=self.current_config,
        )
        self.assertTrue(len(result.change_to_libraries[ChangeType.GAPIC_ADDITION]) == 1)
        config_change = result.change_to_libraries[ChangeType.GAPIC_ADDITION][0]
        self.assertEqual("", config_change.changed_param)
        self.assertEqual("google/new/library/v1", config_change.current_value)
        self.assertEqual("existing_library", config_change.library_name)
