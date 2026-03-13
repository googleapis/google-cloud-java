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
from pathlib import Path
from unittest.mock import patch, ANY
from click.testing import CliRunner
from library_generation.cli.entry_point import (
    generate,
    validate_generation_config,
    __generate_repo_impl as generate_impl,
)
from common.model.generation_config import GenerationConfig

script_dir = os.path.dirname(os.path.realpath(__file__))
test_resource_dir = os.path.join(script_dir, "..", "resources", "test-config")


class EntryPointTest(unittest.TestCase):
    def test_entry_point_without_default_config_raise_file_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(generate)
        self.assertEqual(1, result.exit_code)
        self.assertEqual(FileNotFoundError, result.exc_info[0])
        self.assertRegex(
            result.exception.args[0], "generation_config.yaml does not exist."
        )

    def test_entry_point_with_invalid_config_raise_file_exception(self):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            generate, ["--generation-config-path=/non-existent/file"]
        )
        self.assertEqual(1, result.exit_code)
        self.assertEqual(FileNotFoundError, result.exc_info[0])
        self.assertRegex(result.exception.args[0], "/non-existent/file does not exist.")

    def test_entry_point_with_invalid_generation_input_raise_file_exception(
        self,
    ):
        os.chdir(script_dir)
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(generate, ["--generation-input=/non-existent/folder"])
        self.assertEqual(1, result.exit_code)
        self.assertEqual(FileNotFoundError, result.exc_info[0])
        self.assertRegex(
            result.exception.args[0],
            "/non-existent/folder/generation_config.yaml does not exist.",
        )

    def test_validate_generation_config_succeeds(
        self,
    ):
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            validate_generation_config,
            [f"--generation-config-path={test_resource_dir}/generation_config.yaml"],
        )
        self.assertEqual(0, result.exit_code)

    def test_validate_generation_config_with_duplicate_library_name_raise_file_exception(
        self,
    ):
        runner = CliRunner()
        # noinspection PyTypeChecker
        result = runner.invoke(
            validate_generation_config,
            [
                f"--generation-config-path={test_resource_dir}/generation_config_with_duplicate_library_name.yaml"
            ],
        )
        self.assertEqual(1, result.exit_code)
        self.assertEqual(SystemExit, result.exc_info[0])
        self.assertRegex(
            result.output,
            "have the same library name",
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_non_monorepo_without_library_names_full_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of non monorepos
        (HW libraries). generate() should call generate_from_yaml()
        with target_library_names=None in order to trigger the full generation
        """
        config_path = f"{test_resource_dir}/generation_config.yaml"
        self.assertFalse(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names=None,
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=None,
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_non_monorepo_with_library_names_full_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of non monorepos
        (HW libraries).
        generate() should call generate_from_yaml() with
        target_library_names equals includes.
        """
        config_path = f"{test_resource_dir}/generation_config.yaml"
        self.assertFalse(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names="non-existent-library",
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=None,
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_monorepo_with_common_protos_without_library_names_triggers_full_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of a monorepo with
        common protos.
        generate() should call generate_from_yaml() with
        target_library_names=None in order to trigger the full generation
        """
        config_path = f"{test_resource_dir}/monorepo_with_common_protos.yaml"
        self.assertTrue(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names=None,
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=None,
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_monorepo_with_common_protos_with_library_names_triggers_full_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of a monorepo with
        common protos.
        target_library_names is the same as includes.
        """
        config_path = f"{test_resource_dir}/monorepo_with_common_protos.yaml"
        self.assertTrue(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names="iam,non-existent-library",
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=None,
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_monorepo_without_library_names_trigger_full_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of a monorepo without
        common protos.
        generate() should call generate_from_yaml() with
        target_library_names=changed libraries which does not trigger the full
        generation.
        """
        config_path = f"{test_resource_dir}/monorepo_without_common_protos.yaml"
        self.assertTrue(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names=None,
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=None,
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    def test_generate_monorepo_with_library_names_trigger_selective_generation(
        self,
        generate_from_yaml,
    ):
        """
        this tests confirms the behavior of generation of a monorepo without
        common protos.
        generate() should call generate_from_yaml() with
        target_library_names=changed libraries which does not trigger the full
        generation.
        """
        config_path = f"{test_resource_dir}/monorepo_without_common_protos.yaml"
        self.assertTrue(GenerationConfig.from_yaml(config_path).is_monorepo())
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=config_path,
            generation_input=None,
            library_names="asset",
            api_path=None,
            repository_path=".",
            api_definitions_path=".",
        )
        generate_from_yaml.assert_called_with(
            config=ANY,
            repository_path=ANY,
            api_definitions_path=ANY,
            target_library_names=["asset"],
            target_api_path=None,
        )

    @patch("library_generation.cli.entry_point.generate_from_yaml")
    @patch("common.model.generation_config.GenerationConfig.from_yaml")
    def test_generate_provide_generation_input(
        self,
        mock_from_yaml,
        mock_generate_from_yaml,
    ):
        """
        This test confirms that when no generation_config_path and
        only generation_input is provided, it looks inside this path
        for generation config and creates versions file when not exists
        """
        config_path = f"{test_resource_dir}/generation_config.yaml"
        self._create_folder_in_current_dir("test-output")
        # we call the implementation method directly since click
        # does special handling when a method is annotated with @main.command()
        generate_impl(
            generation_config_path=None,
            generation_input=test_resource_dir,
            library_names="asset",
            api_path=None,
            repository_path="./test-output",
            api_definitions_path=".",
        )
        mock_from_yaml.assert_called_with(os.path.abspath(config_path))
        self.assertTrue(os.path.exists(f"test-output/versions.txt"))

    def tearDown(self):
        # clean up after
        if os.path.exists("./output"):
            shutil.rmtree(Path("./output"))
        if os.path.exists("./test-output"):
            shutil.rmtree(Path("./test-output"))

    def _create_folder_in_current_dir(self, folder_name):
        """Creates a folder in the current directory."""
        try:
            os.makedirs(
                folder_name, exist_ok=True
            )  # exist_ok prevents errors if folder exists
            print(f"Folder '{folder_name}' created successfully.")
        except OSError as e:
            print(f"Error creating folder '{folder_name}': {e}")
