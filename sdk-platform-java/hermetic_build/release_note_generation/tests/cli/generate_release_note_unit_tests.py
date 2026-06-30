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
from click.testing import CliRunner
from release_note_generation.cli.generate_release_note import generate

script_dir = os.path.dirname(os.path.realpath(__file__))
resource_dir = os.path.join(script_dir, "..", "resources", "test_generate_release_note")


class GenerateReleaseNoteTest(unittest.TestCase):
    def test_gen_release_note_with_no_baseline_config_does_not_generate_note(self):
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(generate)
        self.assertEqual(0, result.exit_code)
        self.assertFalse(os.path.isfile("pr_description.txt"))

    def test_gen_release_note_with_no_current_config_does_not_generate_note(self):
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            generate, ["--baseline-generation-config-path=any_config"]
        )
        self.assertEqual(0, result.exit_code)
        self.assertFalse(os.path.isfile("pr_description.txt"))

    def test_gen_release_note_with_nonexistent_baseline_config_does_not_generate_note(
        self,
    ):
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            generate,
            [
                "--baseline-generation-config-path=non_existent_config",
                "--current-generation-config-path=not_relevant",
            ],
        )
        self.assertEqual(0, result.exit_code)
        self.assertFalse(os.path.isfile("pr_description.txt"))

    def test_gen_release_note_with_nonexistent_current_config_does_not_generate_note(
        self,
    ):
        cwd = os.getcwd()
        os.chdir(resource_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            generate,
            [
                "--baseline-generation-config-path=empty_gen_config.yaml",
                "--current-generation-config-path=non_existent_config",
            ],
        )
        self.assertEqual(0, result.exit_code)
        self.assertFalse(os.path.isfile("pr_description.txt"))
        os.chdir(cwd)
