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

from common.model.config_change import ChangeType
from common.model.config_change import ConfigChange
from common.model.config_change import LibraryChange
from common.model.gapic_config import GapicConfig
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig


class ConfigChangeTest(unittest.TestCase):
    def test_get_changed_libraries_with_repo_level_change_returns_all_libraries_changed(
        self,
    ):
        config_change = ConfigChange(
            change_to_libraries={
                ChangeType.REPO_LEVEL_CHANGE: [],
                # add a library level change to verify this type of change has
                # no impact on the result.
                ChangeType.LIBRARY_LEVEL_CHANGE: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="test-library",
                    )
                ],
            },
            baseline_config=ConfigChangeTest.__get_a_gen_config(),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish="",
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="gke-backup",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/gkebackup/v1")
                        ],
                    ),
                    ConfigChangeTest.__get_a_library_config(
                        library_name="test-library",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/gkebackup/v1")
                        ],
                    ),
                ],
            ),
        )
        self.assertEqual(
            ["gke-backup", "test-library"],
            config_change.get_changed_libraries(),
        )

    def test_get_changed_libraries_with_library_level_change_returns_list(self):
        config_change = ConfigChange(
            change_to_libraries={
                ChangeType.LIBRARY_LEVEL_CHANGE: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="a-library",
                    ),
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="another-library",
                    ),
                ],
                ChangeType.LIBRARIES_ADDITION: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="new-library",
                    ),
                ],
                ChangeType.GAPIC_ADDITION: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="library-with-new-version",
                    ),
                ],
            },
            baseline_config=ConfigChangeTest.__get_a_gen_config(),
            current_config=ConfigChangeTest.__get_a_gen_config(),
        )
        self.assertEqual(
            ["a-library", "another-library", "library-with-new-version", "new-library"],
            config_change.get_changed_libraries(),
        )

    def test_get_changed_libraries_with_duplicated_library_name_returns_unique_name(
        self,
    ):
        config_change = ConfigChange(
            change_to_libraries={
                ChangeType.LIBRARY_LEVEL_CHANGE: [
                    LibraryChange(
                        changed_param="a-param",
                        current_value="new_test",
                        library_name="a-library",
                    ),
                    LibraryChange(
                        changed_param="another-param",
                        current_value="new_value",
                        library_name="a-library",
                    ),
                ],
            },
            baseline_config=ConfigChangeTest.__get_a_gen_config(),
            current_config=ConfigChangeTest.__get_a_gen_config(),
        )
        self.assertEqual(
            ["a-library"],
            config_change.get_changed_libraries(),
        )

    def test_get_changed_libraries_with_mix_changes_returns_list(self):
        baseline_commit = "277145d108819fa30fbed3a7cbbb50f91eb6155e"
        latest_commit = "8984ddb508dea0e673b724c58338e810b1d8aee3"
        config_change = ConfigChange(
            change_to_libraries={
                ChangeType.GOOGLEAPIS_COMMIT: [],
                ChangeType.LIBRARY_LEVEL_CHANGE: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="a-library",
                    )
                ],
                ChangeType.LIBRARIES_ADDITION: [
                    LibraryChange(
                        changed_param="test",
                        current_value="test",
                        library_name="new-library",
                    ),
                ],
            },
            baseline_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=baseline_commit
            ),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=latest_commit,
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="gke-backup",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/gkebackup/v1")
                        ],
                    ),
                ],
            ),
        )

        self.assertEqual(
            ["a-library", "gke-backup", "new-library"],
            sorted(config_change.get_changed_libraries()),
        )

    def test_get_qualified_commits_success(self):
        baseline_commit = "277145d108819fa30fbed3a7cbbb50f91eb6155e"
        latest_commit = "8984ddb508dea0e673b724c58338e810b1d8aee3"
        gke_backup_commit = "b8691edb3f1d3c1583aa9cd89240eb359eebe9c7"
        aiplatform_commit = "b82095baef02e525bee7bb1c48911c33b66acdf0"
        network_management_commit = "efad09c9f0d46ae0786d810a88024363e06c6ca3"
        config_change = ConfigChange(
            change_to_libraries={},
            baseline_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=baseline_commit
            ),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=latest_commit,
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="gke-backup",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/gkebackup/v1")
                        ],
                    ),
                    ConfigChangeTest.__get_a_library_config(
                        library_name="aiplatform",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/aiplatform/v1beta1")
                        ],
                    ),
                    ConfigChangeTest.__get_a_library_config(
                        library_name="network-management",
                        gapic_configs=[
                            GapicConfig(proto_path="google/cloud/networkmanagement/v1"),
                            GapicConfig(
                                proto_path="google/cloud/networkmanagement/v1beta1"
                            ),
                        ],
                    ),
                ],
            ),
        )
        qualified_commits = config_change.get_qualified_commits()
        self.assertEqual(3, len(qualified_commits))
        self.assertEqual({"gke-backup"}, qualified_commits[0].libraries)
        self.assertEqual(
            gke_backup_commit,
            qualified_commits[0].commit.hexsha,
        )
        self.assertEqual({"aiplatform"}, qualified_commits[1].libraries)
        self.assertEqual(
            aiplatform_commit,
            qualified_commits[1].commit.hexsha,
        )
        self.assertEqual({"network-management"}, qualified_commits[2].libraries)
        self.assertEqual(
            network_management_commit,
            qualified_commits[2].commit.hexsha,
        )

    def test_get_qualified_commits_rest_numeric_enum_change_returns_a_qualified_commit(
        self,
    ):
        baseline_commit = "45694d2bad602c52170096072d325aa644d550e5"
        latest_commit = "758f0d1217d9c7fe398aa5efb1057ce4b6409e55"
        config_change = ConfigChange(
            change_to_libraries={},
            baseline_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=baseline_commit
            ),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=latest_commit,
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="container",
                        gapic_configs=[GapicConfig(proto_path="google/container/v1")],
                    )
                ],
            ),
        )
        # one commit between latest_commit and baseline_commit which only
        # changed BUILD.bazel.
        # this commit changed `rest_numeric_enums`.
        self.assertTrue(len(config_change.get_qualified_commits()) == 1)

    def test_get_qualified_commits_irrelevant_build_field_change_returns_empty_list(
        self,
    ):
        baseline_commit = "bdda0174f68a738518ec311e05e6fd9bbe19cd78"
        latest_commit = "c9a5050ef225b0011603e1109cf53ab1de0a8e53"
        config_change = ConfigChange(
            change_to_libraries={},
            baseline_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=baseline_commit
            ),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=latest_commit,
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="chat",
                        gapic_configs=[GapicConfig(proto_path="google/chat/v1")],
                    )
                ],
            ),
        )
        # one commit between latest_commit and baseline_commit which only
        # changed BUILD.bazel.
        # this commit didn't change fields used in library generation.
        self.assertTrue(len(config_change.get_qualified_commits()) == 0)

    def test_get_qualified_commits_add_build_file_returns_a_qualified_commit(self):
        baseline_commit = "d007ca1b3cc820651530d44d5388533047ae1414"
        latest_commit = "05d889e7dfe087fc2ddc9de9579f01d4e1c2f35e"
        config_change = ConfigChange(
            change_to_libraries={},
            baseline_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=baseline_commit
            ),
            current_config=ConfigChangeTest.__get_a_gen_config(
                googleapis_commitish=latest_commit,
                libraries=[
                    ConfigChangeTest.__get_a_library_config(
                        library_name="cloudcontrolspartner",
                        gapic_configs=[
                            GapicConfig(
                                proto_path="google/cloud/cloudcontrolspartner/v1"
                            )
                        ],
                    )
                ],
            ),
        )
        # one commit between latest_commit and baseline_commit which added
        # google/cloud/cloudcontrolspartner/v1.
        self.assertTrue(len(config_change.get_qualified_commits()) == 1)

    @staticmethod
    def __get_a_gen_config(
        googleapis_commitish="", libraries: list[LibraryConfig] = None
    ) -> GenerationConfig:
        if libraries is None:
            libraries = []
        return GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish=googleapis_commitish,
            libraries=libraries,
        )

    @staticmethod
    def __get_a_library_config(
        library_name: str, gapic_configs: list[GapicConfig] = None
    ) -> LibraryConfig:
        if gapic_configs is None:
            gapic_configs = []
        return LibraryConfig(
            api_shortname="existing_library",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=gapic_configs,
            library_name=library_name,
        )
