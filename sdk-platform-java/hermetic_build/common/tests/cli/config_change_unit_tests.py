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
from click.testing import CliRunner
import unittest

from common.cli.get_changed_libraries import create

script_dir = os.path.dirname(os.path.realpath(__file__))
test_resource_dir = os.path.join(script_dir, "..", "resources", "cli")


class GetChangedLibrariesTest(unittest.TestCase):
    def test_entry_point_without_baseline_config_raise_system_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(create)
        self.assertEqual(2, result.exit_code)
        self.assertEqual(SystemExit, result.exc_info[0])

    def test_entry_point_without_current_config_raise_system_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            create, ["--baseline-generation-config-path=/invalid/path/file"]
        )
        self.assertEqual(2, result.exit_code)
        self.assertEqual(SystemExit, result.exc_info[0])

    def test_entry_point_with_invalid_baseline_config_raise_file_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            create,
            [
                "--baseline-generation-config-path=/invalid/path/file",
                "--current-generation-config-path=/invalid/path/file",
            ],
        )
        self.assertEqual(1, result.exit_code)
        self.assertEqual(FileNotFoundError, result.exc_info[0])
        self.assertRegex(result.exception.args[0], "baseline-generation-config-path")

    def test_entry_point_with_invalid_current_config_raise_file_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            create,
            [
                f"--baseline-generation-config-path={test_resource_dir}/empty_config.yaml",
                "--current-generation-config-path=/invalid/path/file",
            ],
        )
        self.assertEqual(1, result.exit_code)
        self.assertEqual(FileNotFoundError, result.exc_info[0])
        self.assertRegex(result.exception.args[0], "current-generation-config-path")
