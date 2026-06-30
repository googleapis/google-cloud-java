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
from unittest.mock import patch
from common.model.config_change import (
    ConfigChange,
    ChangeType,
    LibraryChange,
)
from common.model.generation_config import GenerationConfig
from release_note_generation.commit_message_formatter import (
    format_commit_message,
    commit_link,
    format_repo_level_change,
    wrap_googleapis_commit,
    wrap_override_commit,
)

gen_config = GenerationConfig(
    gapic_generator_version="1.2.3", googleapis_commitish="123abc", libraries=[]
)


class CommitMessageFormatterTest(unittest.TestCase):
    def test_format_commit_message_should_add_library_name_for_conventional_commit(
        self,
    ):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.message = "feat: a commit message\nPiperOrigin-RevId: 123456"
            commit.hexsha = "1234567abcdefg"
            commits = {commit: "example_library"}
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "feat: [example_library] a commit message",
                    "PiperOrigin-RevId: 123456",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                format_commit_message(commits, True),
            )

    def test_format_commit_message_should_add_library_name_for_mutliline_conventional_commit(
        self,
    ):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.message = "feat: a commit message\nfix: an another commit message\nPiperOrigin-RevId: 123456"
            commit.hexsha = "1234567abcdefg"
            commits = {commit: "example_library"}
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "feat: [example_library] a commit message",
                    "fix: [example_library] an another commit message",
                    "PiperOrigin-RevId: 123456",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                format_commit_message(commits, True),
            )

    def test_format_commit_message_should_not_add_library_name_for_nonconvnentional_commit(
        self,
    ):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.message = "PiperOrigin-RevId: 123456"
            commit.hexsha = "1234567abcdefg"
            commits = {commit: "example_library"}
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "PiperOrigin-RevId: 123456",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                format_commit_message(commits, True),
            )

    def test_format_commit_message_should_not_add_library_name_if_not_monorepo(self):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.message = "feat: a commit message\nPiperOrigin-RevId: 123456"
            commit.hexsha = "1234567abcdefg"
            commits = {commit: "example_library"}
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "feat: a commit message",
                    "PiperOrigin-RevId: 123456",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                format_commit_message(commits, False),
            )

    def test_format_commit_message_should_not_add_library_name_for_multiline_commit_if_not_monorepo(
        self,
    ):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.message = "feat: a commit message\nfix: an another commit message\nPiperOrigin-RevId: 123456"
            commit.hexsha = "1234567abcdefg"
            commits = {commit: "example_library"}
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "feat: a commit message",
                    "fix: an another commit message",
                    "PiperOrigin-RevId: 123456",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                format_commit_message(commits, False),
            )

    def test_wrap_nested_commit_success(self):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.hexsha = "1234567abcdefg"
            messages = ["a commit message", "another message"]
            self.assertEqual(
                [
                    "BEGIN_NESTED_COMMIT",
                    "a commit message",
                    "another message",
                    "Source Link: [googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                    "END_NESTED_COMMIT",
                ],
                wrap_googleapis_commit(commit, messages),
            )

    def test_wrap_override_commit_success(self):
        messages = ["a commit message", "another message"]
        self.assertEqual(
            [
                "BEGIN_COMMIT_OVERRIDE",
                "a commit message",
                "another message",
                "END_COMMIT_OVERRIDE",
            ],
            wrap_override_commit(messages),
        )

    def test_commit_link_success(self):
        with patch("git.Commit") as mock_commit:
            commit = mock_commit.return_value
            commit.hexsha = "1234567abcdefg"
            self.assertEqual(
                "[googleapis/googleapis@1234567](https://github.com/googleapis/googleapis/commit/1234567abcdefg)",
                commit_link(commit),
            )

    def test_format_repo_level_change_success(self):
        config_change = ConfigChange(
            change_to_libraries={
                ChangeType.REPO_LEVEL_CHANGE: [
                    LibraryChange(
                        changed_param="gapic_generator_version", current_value="1.2.3"
                    ),
                    LibraryChange(
                        changed_param="libraries_bom_version", current_value="2.3.4"
                    ),
                    LibraryChange(
                        changed_param="protoc_version", current_value="3.4.5"
                    ),
                ]
            },
            baseline_config=gen_config,
            current_config=gen_config,
        )
        self.assertEqual(
            [
                "BEGIN_NESTED_COMMIT",
                "fix(deps): update the Java code generator (gapic-generator-java) to 1.2.3",
                "END_NESTED_COMMIT",
                "BEGIN_NESTED_COMMIT",
                "chore: update the libraries_bom version to 2.3.4",
                "END_NESTED_COMMIT",
                "BEGIN_NESTED_COMMIT",
                "chore: update repo-level parameter protoc_version to 3.4.5",
                "END_NESTED_COMMIT",
            ],
            format_repo_level_change(config_change),
        )
