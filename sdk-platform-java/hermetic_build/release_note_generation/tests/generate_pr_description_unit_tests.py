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
from filecmp import cmp
from release_note_generation.generate_pr_description import (
    get_repo_level_commit_messages,
    generate_pr_descriptions,
)
from common.model.config_change import (
    ConfigChange,
    ChangeType,
    LibraryChange,
)
from common.model.gapic_config import GapicConfig
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "resources", "goldens")


class GeneratePrDescriptionTest(unittest.TestCase):
    def test_get_commit_messages_current_is_older_raise_exception(self):
        # committed on April 1st, 2024
        current_commit = "36441693dddaf0ed73951ad3a15c215a332756aa"
        # committed on April 2nd, 2024
        baseline_commit = "d5020fff4cbe108bdf506074791c56cff7840bef"
        self.assertRaisesRegex(
            ValueError,
            "newer than",
            get_repo_level_commit_messages,
            "https://github.com/googleapis/googleapis.git",
            current_commit,
            baseline_commit,
            {},
            True,
            [],
        )

    def test_get_commit_messages_with_same_current_and_baseline_returns_empty_message(
        self,
    ):
        # committed on April 1st, 2024
        current_commit = "36441693dddaf0ed73951ad3a15c215a332756aa"
        baseline_commit = "36441693dddaf0ed73951ad3a15c215a332756aa"
        self.assertEqual(
            "",
            get_repo_level_commit_messages(
                "https://github.com/googleapis/googleapis.git",
                current_commit,
                baseline_commit,
                {},
                True,
                [],
            ),
        )

    def test_generate_pr_description_with_no_change_in_config(self):
        commit_sha = "36441693dddaf0ed73951ad3a15c215a332756aa"
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish=commit_sha,
            libraries_bom_version="",
            # use empty libraries to make sure no qualified commit between
            # two commit sha.
            libraries=[],
        )
        pr_description_path = os.path.join(os.getcwd(), "no_config_change")
        generate_pr_descriptions(
            config_change=ConfigChange(
                change_to_libraries={},
                baseline_config=config,
                current_config=config,
            ),
            description_path=pr_description_path,
        )
        self.assertFalse(os.path.isfile(f"{pr_description_path}/pr_description.txt"))

    def test_generate_pr_description_does_not_create_pr_description_without_qualified_commit(
        self,
    ):
        # committed on May 22nd, 2024
        old_commit_sha = "30717c0b0c9966906880703208a4c820411565c4"
        # committed on May 23rd, 2024
        new_commit_sha = "eeed69d446a90eb4a4a2d1762c49d637075390c1"
        pr_description_path = os.path.join(os.getcwd(), "no_qualified_commit")
        generate_pr_descriptions(
            config_change=ConfigChange(
                change_to_libraries={},
                baseline_config=GenerationConfig(
                    gapic_generator_version="",
                    googleapis_commitish=old_commit_sha,
                    # use empty libraries to make sure no qualified commit between
                    # two commit sha.
                    libraries=[],
                ),
                current_config=GenerationConfig(
                    gapic_generator_version="",
                    googleapis_commitish=new_commit_sha,
                    # use empty libraries to make sure no qualified commit between
                    # two commit sha.
                    libraries=[],
                ),
            ),
            description_path=pr_description_path,
        )
        self.assertFalse(os.path.isfile(f"{pr_description_path}/pr_description.txt"))

    def test_generate_pr_description_with_combined_message(
        self,
    ):
        # no other commits between these two commits.
        baseline_commit_sha = "3b6f144d47b0a1d2115ab2445ec06e80cc324a44"
        documentai_commit_sha = "0cea7170404bec3d994f43db4fa292f5034cbe9a"
        cwd = os.getcwd()
        library = LibraryConfig(
            api_shortname="documentai",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=[GapicConfig(proto_path="google/cloud/documentai/v1")],
        )
        generate_pr_descriptions(
            config_change=ConfigChange(
                change_to_libraries={
                    ChangeType.REPO_LEVEL_CHANGE: [
                        LibraryChange(
                            changed_param="gapic_generator_version",
                            current_value="1.2.3",
                        ),
                        LibraryChange(
                            changed_param="libraries_bom_version", current_value="2.3.4"
                        ),
                    ],
                    ChangeType.GOOGLEAPIS_COMMIT: [],
                },
                baseline_config=GenerationConfig(
                    gapic_generator_version="",
                    googleapis_commitish=baseline_commit_sha,
                    libraries=[library],
                ),
                current_config=GenerationConfig(
                    gapic_generator_version="1.2.3",
                    googleapis_commitish=documentai_commit_sha,
                    libraries_bom_version="2.3.4",
                    libraries=[library],
                ),
            ),
            description_path=cwd,
        )
        self.assertTrue(os.path.isfile(f"{cwd}/pr_description.txt"))
        self.assertTrue(
            cmp(
                f"{resources_dir}/pr_description-golden.txt",
                f"{cwd}/pr_description.txt",
            ),
            "The generated PR description does not match the expected golden file",
        )
        os.remove(f"{cwd}/pr_description.txt")

    def test_generate_pr_description_with_repo_level_change_without_qualified_commit(
        self,
    ):
        # no other commits between these two commits.
        baseline_commit_sha = "3b6f144d47b0a1d2115ab2445ec06e80cc324a44"
        current_commit_sha = "0cea7170404bec3d994f43db4fa292f5034cbe9a"
        cwd = os.getcwd()
        library = LibraryConfig(
            api_shortname="example_library",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=[GapicConfig(proto_path="google/example/v1")],
        )
        generate_pr_descriptions(
            config_change=ConfigChange(
                change_to_libraries={
                    ChangeType.REPO_LEVEL_CHANGE: [
                        LibraryChange(
                            changed_param="gapic_generator_version",
                            current_value="1.2.3",
                        ),
                        LibraryChange(
                            changed_param="libraries_bom_version", current_value="2.3.4"
                        ),
                    ],
                    ChangeType.GOOGLEAPIS_COMMIT: [],
                },
                baseline_config=GenerationConfig(
                    gapic_generator_version="",
                    googleapis_commitish=baseline_commit_sha,
                    libraries=[library],
                ),
                current_config=GenerationConfig(
                    gapic_generator_version="1.2.3",
                    googleapis_commitish=current_commit_sha,
                    libraries_bom_version="2.3.4",
                    libraries=[library],
                ),
            ),
            description_path=cwd,
        )
        self.assertTrue(os.path.isfile(f"{cwd}/pr_description.txt"))
        self.assertTrue(
            cmp(
                f"{resources_dir}/repo_level_and_no_qualified_commit_pr_description-golden.txt",
                f"{cwd}/pr_description.txt",
            ),
            "The generated PR description does not match the expected golden file",
        )
        os.remove(f"{cwd}/pr_description.txt")

    def test_generate_pr_description_create_description_with_only_repo_level_change(
        self,
    ):
        commit_sha = "3b6f144d47b0a1d2115ab2445ec06e80cc324a44"
        cwd = os.getcwd()
        library = LibraryConfig(
            api_shortname="documentai",
            api_description="",
            name_pretty="",
            product_documentation="",
            gapic_configs=[GapicConfig(proto_path="google/cloud/documentai/v1")],
        )
        generate_pr_descriptions(
            config_change=ConfigChange(
                change_to_libraries={
                    ChangeType.REPO_LEVEL_CHANGE: [
                        LibraryChange(
                            changed_param="gapic_generator_version",
                            current_value="1.2.3",
                        )
                    ],
                    ChangeType.GOOGLEAPIS_COMMIT: [],
                },
                baseline_config=GenerationConfig(
                    gapic_generator_version="1.2.2",
                    googleapis_commitish=commit_sha,
                    libraries=[library],
                ),
                current_config=GenerationConfig(
                    gapic_generator_version="1.2.3",
                    googleapis_commitish=commit_sha,
                    libraries=[library],
                ),
            ),
            description_path=cwd,
        )
        self.assertTrue(os.path.isfile(f"{cwd}/pr_description.txt"))
        self.assertTrue(
            cmp(
                f"{resources_dir}/repo_level_only_pr_description-golden.txt",
                f"{cwd}/pr_description.txt",
            ),
            "The generated PR description does not match the expected golden file",
        )
        os.remove(f"{cwd}/pr_description.txt")
