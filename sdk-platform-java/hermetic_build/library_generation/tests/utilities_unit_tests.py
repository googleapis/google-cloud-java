#!/usr/bin/env python3
#  Copyright 2024 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
"""
Unit tests for python scripts
"""
import shutil
import unittest
import os
import io
import contextlib
from pathlib import Path
from library_generation.utils import utilities as util
from common.model.gapic_config import GapicConfig
from common.model.gapic_inputs import GapicInputs
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig
from library_generation.tests.test_utils import FileComparator
from library_generation.tests.test_utils import cleanup

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "resources")
file_comparator = FileComparator()
library_1 = LibraryConfig(
    api_shortname="baremetalsolution",
    name_pretty="Bare Metal Solution",
    product_documentation="https://cloud.google.com/bare-metal/docs",
    api_description="Bring your Oracle workloads to Google Cloud with Bare Metal Solution and jumpstart your cloud journey with minimal risk.",
    gapic_configs=list(),
    library_name="bare-metal-solution",
    rest_documentation="https://cloud.google.com/bare-metal/docs/reference/rest",
    rpc_documentation="https://cloud.google.com/bare-metal/docs/reference/rpc",
    recommended_package="com.google.example",
    min_java_version=8,
)
library_2 = LibraryConfig(
    api_shortname="secretmanager",
    name_pretty="Secret Management",
    product_documentation="https://cloud.google.com/solutions/secrets-management/",
    api_description="allows you to encrypt, store, manage, and audit infrastructure and application-level secrets.",
    gapic_configs=list(),
)
common_protos = LibraryConfig(
    api_shortname="common-protos",
    name_pretty="Common Protos",
    product_documentation="",
    api_description="example description",
    gapic_configs=list(),
)
test_library_with_custom_transport = LibraryConfig(
    api_shortname="secretmanager",
    name_pretty="Secret Management",
    product_documentation="https://cloud.google.com/solutions/secrets-management/",
    api_description="allows you to encrypt, store, manage, and audit infrastructure and application-level secrets.",
    gapic_configs=list(),
    transport="rest",
)


class UtilitiesTest(unittest.TestCase):
    """
    Unit tests for utilities.py
    """

    CONFIGURATION_YAML_PATH = os.path.join(
        script_dir,
        "resources",
        "integration",
        "google-cloud-java",
        "generation_config.yaml",
    )

    def test_create_argument_valid_container_succeeds(self):
        container_value = "google/test/v1"
        container = GapicConfig(container_value)
        argument_key = "proto_path"
        result = util.create_argument(argument_key, container)
        self.assertEqual([f"--{argument_key}", container_value], result)

    def test_create_argument_empty_container_returns_empty_list(self):
        container = dict()
        argument_key = "proto_path"
        result = util.create_argument(argument_key, container)
        self.assertEqual([], result)

    def test_create_argument_none_container_fails(self):
        container = None
        argument_key = "proto_path"
        result = util.create_argument(argument_key, container)
        self.assertEqual([], result)

    def test_sh_util_existent_function_succeeds(self):
        result = util.sh_util("extract_folder_name path/to/folder_name")
        self.assertEqual("folder_name", result)

    def test_sh_util_nonexistent_function_fails(self):
        with self.assertRaises(RuntimeError):
            result = util.sh_util("nonexistent_function")

    def test_mv_src_files_gapic_main_succeeds(self):
        previous_dir = os.getcwd()
        os.chdir(f"{resources_dir}/test_mv_src/gapic")
        os.environ["folder_name"] = "example"
        util.sh_util("mv_src_files gapic main destination")
        self.assertTrue(
            os.path.isfile("destination/gapic-example/src/main/java/example_main.txt")
        )
        shutil.rmtree("destination/gapic-example")
        os.chdir(previous_dir)

    def test_mv_src_files_gapic_test_succeeds(self):
        previous_dir = os.getcwd()
        os.chdir(f"{resources_dir}/test_mv_src/gapic")
        os.environ["folder_name"] = "example"
        util.sh_util("mv_src_files gapic test destination")
        self.assertTrue(
            os.path.isfile("destination/gapic-example/src/test/java/example_test.txt")
        )
        shutil.rmtree("destination/gapic-example")
        os.chdir(previous_dir)

    def test_mv_src_files_proto_main_succeeds(self):
        previous_dir = os.getcwd()
        os.chdir(f"{resources_dir}/test_mv_src/proto")
        os.environ["folder_name"] = "example"
        util.sh_util("mv_src_files proto main destination")
        self.assertTrue(
            os.path.isfile(
                "destination/proto-example/src/main/java/example_proto_main.txt"
            )
        )
        shutil.rmtree("destination/proto-example")
        os.chdir(previous_dir)

    def test_mv_src_files_sample_suffix_io_succeeds(self):
        previous_dir = os.getcwd()
        os.chdir(f"{resources_dir}/test_mv_src/samples")
        util.sh_util("mv_src_files samples main destination_io")
        self.assertTrue(
            os.path.isfile(
                "destination_io/samples/snippets/generated/io/example_io_sample.txt"
            )
        )
        shutil.rmtree("destination_io/samples")
        os.chdir(previous_dir)

    def test_mv_src_files_sample_suffix_com_succeeds(self):
        previous_dir = os.getcwd()
        os.chdir(f"{resources_dir}/test_mv_src/samples")
        util.sh_util("mv_src_files samples main destination_com")
        self.assertTrue(
            os.path.isfile(
                "destination_com/samples/snippets/generated/com/example_com_sample.txt"
            )
        )
        shutil.rmtree("destination_com/samples")
        os.chdir(previous_dir)

    def test_eprint_valid_input_succeeds(self):
        test_input = "This is some test input"
        # create a stdio capture object
        stderr_capture = io.StringIO()
        # run eprint() with the capture object
        with contextlib.redirect_stderr(stderr_capture):
            util.eprint(test_input)
        result = stderr_capture.getvalue()
        # print() appends a `\n` each time it's called
        self.assertEqual(test_input + "\n", result)

    def test_get_library_repository_with_common_protos_returns_sdk_platform_java(self):
        config = self.__get_a_gen_config(3)
        library = common_protos
        result = util.get_library_repository(config, library)
        self.assertEqual("googleapis/sdk-platform-java", result)

    def test_get_library_repository_with_monorepo_returns_google_cloud_java(self):
        config = self.__get_a_gen_config(2)
        library = library_1
        result = util.get_library_repository(config, library)
        self.assertEqual("googleapis/google-cloud-java", result)

    def test_get_library_repository_with_split_repo_returns_library_repo(self):
        config = self.__get_a_gen_config(1)
        library = library_1
        result = util.get_library_repository(config, library)
        self.assertEqual("googleapis/java-bare-metal-solution", result)

    def test_generate_postprocessing_prerequisite_files_non_monorepo_success(self):
        library_path = self.__setup_postprocessing_prerequisite_files(
            combination=1, library_type="GAPIC_COMBO"
        )

        file_comparator.compare_files(
            f"{library_path}/.repo-metadata.json",
            f"{library_path}/.repo-metadata-non-monorepo-golden.json",
        )
        # since this is a single library, we treat this as HW repository,
        # meaning that the owlbot yaml will be inside a .github folder
        file_comparator.compare_files(
            f"{library_path}/.github/.OwlBot-hermetic.yaml",
            f"{library_path}/.OwlBot-hermetic-golden.yaml",
        )
        file_comparator.compare_files(
            f"{library_path}/owlbot.py", f"{library_path}/owlbot-golden.py"
        )
        self.__remove_postprocessing_prerequisite_files(
            path=library_path, is_monorepo=False
        )

    def test_generate_postprocessing_prerequisite_files_monorepo_success(self):
        library_path = self.__setup_postprocessing_prerequisite_files(combination=2)

        file_comparator.compare_files(
            f"{library_path}/.repo-metadata.json",
            f"{library_path}/.repo-metadata-monorepo-golden.json",
        )
        file_comparator.compare_files(
            f"{library_path}/.OwlBot-hermetic.yaml",
            f"{library_path}/.OwlBot-hermetic-golden.yaml",
        )
        file_comparator.compare_files(
            f"{library_path}/owlbot.py", f"{library_path}/owlbot-golden.py"
        )
        self.__remove_postprocessing_prerequisite_files(path=library_path)

    def test_generate_postprocessing_prerequisite_files_proto_only_repo_success(self):
        library_path = self.__setup_postprocessing_prerequisite_files(
            combination=3, library_type="OTHER"
        )

        file_comparator.compare_files(
            f"{library_path}/.repo-metadata.json",
            f"{library_path}/.repo-metadata-proto-only-golden.json",
        )
        file_comparator.compare_files(
            f"{library_path}/.OwlBot-hermetic.yaml",
            f"{library_path}/.OwlBot-hermetic-golden.yaml",
        )
        file_comparator.compare_files(
            f"{library_path}/owlbot.py", f"{library_path}/owlbot-golden.py"
        )
        self.__remove_postprocessing_prerequisite_files(path=library_path)

    def test_generate_postprocessing_prerequisite_files__custom_transport_set_in_config__success(
        self,
    ):
        """
        This test generates files for `test_library_with_custom_transport`, which
        has an explicit value for transport declared (http). This is expected to
        override the value obtained in BUILD.bazel via gapic_inputs.parse(). For
        testing purposes, we test with a default GapicInputs object, whose transport
        is set to "grpc".
        """
        library_path = self.__setup_postprocessing_prerequisite_files(
            combination=2, library=test_library_with_custom_transport
        )

        file_comparator.compare_files(
            f"{library_path}/.repo-metadata.json",
            f"{library_path}/.repo-metadata-custom-transport-golden.json",
        )
        self.__remove_postprocessing_prerequisite_files(path=library_path)

    def test_create__library_invalid_transport__fails(
        self,
    ):
        with self.assertRaises(ValueError):
            test_library_with_invalid_transport = LibraryConfig(
                api_shortname="secretmanager",
                name_pretty="Secret Management",
                product_documentation="https://cloud.google.com/solutions/secrets-management/",
                api_description="allows you to encrypt, store, manage, and audit infrastructure and application-level secrets.",
                gapic_configs=list(),
                transport="http",
            )

    def test_prepare_repo_monorepo_success(self):
        gen_config = self.__get_a_gen_config(2)
        repo_config = util.prepare_repo(
            gen_config=gen_config,
            library_config=gen_config.libraries,
            repo_path=f"{resources_dir}/misc",
        )
        self.assertEqual("output", Path(repo_config.output_folder).name)
        library_path = sorted([Path(key).name for key in repo_config.libraries])
        self.assertEqual(
            ["java-bare-metal-solution", "java-secretmanager"], library_path
        )

    def test_prepare_repo_monorepo_failed(self):
        gen_config = self.__get_a_gen_config(2)
        self.assertRaises(
            FileNotFoundError,
            util.prepare_repo,
            gen_config,
            gen_config.libraries,
            f"{resources_dir}/non-exist",
        )

    def test_prepare_repo_split_repo_success(self):
        gen_config = self.__get_a_gen_config(1)
        repo_config = util.prepare_repo(
            gen_config=gen_config,
            library_config=gen_config.libraries,
            repo_path=f"{resources_dir}/misc",
        )
        self.assertEqual("output", Path(repo_config.output_folder).name)
        library_path = sorted([Path(key).name for key in repo_config.libraries])
        self.assertEqual(["misc"], library_path)
        shutil.rmtree(repo_config.output_folder)

    def __setup_postprocessing_prerequisite_files(
        self,
        combination: int,
        library_type: str = "GAPIC_AUTO",
        library: LibraryConfig = library_1,
    ) -> str:
        library_path = f"{resources_dir}/goldens"
        files = [
            f"{library_path}/.repo-metadata.json",
            f"{library_path}/.OwlBot-hermetic.yaml",
            f"{library_path}/owlbot.py",
        ]
        cleanup(files)
        library.library_type = library_type
        config = self.__get_a_gen_config(combination, library_type=library_type)
        proto_path = "google/cloud/baremetalsolution/v2"
        gapic_inputs = GapicInputs()  # defaults to transport=grpc
        transport = library.get_transport(gapic_inputs)
        util.generate_postprocessing_prerequisite_files(
            config=config,
            library=library,
            proto_path=proto_path,
            transport=transport,
            library_path=library_path,
        )
        return library_path

    @staticmethod
    def __get_a_gen_config(
        combination: int, library_type: str = "GAPIC_AUTO"
    ) -> GenerationConfig:
        """
        Returns an object of GenerationConfig with one to three of
        LibraryConfig objects. Other attributes are set to empty str.

        :param combination: combination of LibraryConfig objects associated with
        the GenerationConfig. Only support 1, 2 or 3.
        :return: an object of GenerationConfig
        """
        if combination == 1:
            libraries = [library_1]
        elif combination == 2:
            libraries = [library_1, library_2]
        else:
            libraries = [library_1, common_protos]

        # update libraries with custom configuration (for now, only
        # library_type)
        for library in libraries:
            library.library_type = library_type
            if combination == 1:
                # treat this as a HW library case to generate a real-life
                # repo-metadata
                library.extra_versioned_modules = "test-module"
            else:
                library.extra_versioned_modules = None

        return GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=libraries,
        )

    @staticmethod
    def __remove_postprocessing_prerequisite_files(
        path: str, is_monorepo: bool = True
    ) -> None:
        os.remove(f"{path}/.repo-metadata.json")
        os.remove(f"{path}/owlbot.py")
        if is_monorepo:
            os.remove(f"{path}/.OwlBot-hermetic.yaml")
            return
        if os.path.isdir(f"{path}/.github"):
            shutil.rmtree(f"{path}/.github", ignore_errors=True)


if __name__ == "__main__":
    unittest.main()
