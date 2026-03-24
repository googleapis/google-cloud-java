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
import sys
from typing import Optional
import click as click
import shutil
from pathlib import Path
from library_generation.generate_repo import generate_from_yaml
from common.model.generation_config import GenerationConfig


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--generation-config-path",
    required=False,
    default=None,
    type=str,
    help="""
    Absolute or relative path to a generation_config.yaml that contains the
    metadata about library generation.
    When not set, will use generation_config.yaml from --generation-input.
    When neither this or --generation-input is set default to 
    generation_config.yaml in the current working directory 
    """,
)
@click.option(
    "--generation-input",
    required=False,
    default=None,
    type=str,
    help="""
    Absolute or relative path to a input folder that contains 
    generation_config.yaml and versions.txt.
    This is only used when --generation-config-path is not set.
    When neither this or --generation-config-path is set default to 
    generation_config.yaml in the current working directory 
    """,
)
@click.option(
    "--library-names",
    required=False,
    type=str,
    default=None,
    show_default=True,
    help="""
    A list of library names that will be generated, separated by comma.
    The library name of a library is the value of library_name or api_shortname,
    if library_name is not specified, in the generation configuration.
    
    If neither --library-names  or --api-path specified, all libraries in the 
    generation configuration will be generated.
    """,
)
@click.option(
    "--api-path",
    required=False,
    type=str,
    default=None,
    show_default=True,
    help="""
    Path within the API root (e.g. googleapis) to the API to 
    generate/build/configure etc. This is expected to be a major-versioned 
    API directory, e.g. google/cloud/functions/v2.

    Takes precedence over --library-names when specidied. 
    If neither --library-names  or --api-path specified, all libraries in the 
    generation configuration will be generated.
    """,
)
@click.option(
    "--repository-path",
    "--output",
    type=str,
    default=".",
    show_default=True,
    help="""
    The repository path to which the generated files
    will be sent.
    If not specified, the repository will be generated to the current working
    directory.
    """,
)
@click.option(
    "--api-definitions-path",
    "--api-root",
    type=str,
    default=".",
    show_default=True,
    help="""
    The path to which the api definition (proto and service yaml) and its
    dependencies resides.
    If not specified, the path is the current working directory.
    """,
)
def generate(
    generation_config_path: Optional[str],
    generation_input: Optional[str],
    library_names: Optional[str],
    api_path: Optional[str],
    repository_path: str,
    api_definitions_path: str,
):
    """
    Generate libraries based on a generation config.

    If the `generation-config-path` is not specified the default generation
    config, `$(pwd)/generation_config.yaml`, will be used.

    If `library_names` is specified, only libraries whose name can be found in
    the generation config will be generated; otherwise all libraries in the
    generation config will be generated.

    :raise FileNotFoundError if the specified generation config does not exist
    or, in case `generation-config-path` is not specified, the default
    generation config does not exist.
    """
    __generate_repo_impl(
        generation_config_path=generation_config_path,
        generation_input=generation_input,
        library_names=library_names,
        api_path=api_path,
        repository_path=repository_path,
        api_definitions_path=api_definitions_path,
    )


def __generate_repo_impl(
    generation_config_path: Optional[str],
    generation_input: Optional[str],
    library_names: Optional[str],
    api_path: Optional[str],
    repository_path: str,
    api_definitions_path: str,
):
    """
    Implementation method for generate().
    The decoupling of generate and __generate_repo_impl is
    meant to allow testing of this implementation function.
    """

    # only use generation_input when generation_config_path is not provided and
    # generation_input provided. generation_config_path should be deprecated after
    # migration to 1pp.
    default_generation_config_path = f"{os.getcwd()}/generation_config.yaml"
    if generation_config_path is None and generation_input is not None:
        print(
            "generation_config_path is not provided, using generation-input folder provided"
        )
        generation_config_path = f"{generation_input}/generation_config.yaml"
        # copy versions.txt from generation_input to repository_path
        # override if present.
        _copy_versions_file(generation_input, repository_path)
    if generation_config_path is None and generation_input is None:
        print("Using default generation config path")
        generation_config_path = default_generation_config_path
    generation_config_path = os.path.abspath(generation_config_path)
    if not os.path.isfile(generation_config_path):
        raise FileNotFoundError(
            f"Generation config {generation_config_path} does not exist."
        )
    repository_path = os.path.abspath(repository_path)
    api_definitions_path = os.path.abspath(api_definitions_path)
    generation_config = GenerationConfig.from_yaml(generation_config_path)
    include_library_names = _parse_library_name_from(
        includes=library_names, generation_config=generation_config
    )
    generate_from_yaml(
        config=generation_config,
        repository_path=repository_path,
        api_definitions_path=api_definitions_path,
        target_library_names=include_library_names,
        target_api_path=api_path,
    )


def _copy_versions_file(generation_input_path, repository_path):
    """
    Copies the versions.txt file from the generation_input folder to the repository_path.
    Overrides the destination file if it already exists.

    Args:
        generation_input_path (str): The path to the generation_input folder.
        repository_path (str): The path to the repository folder.
    """
    source_file = Path(generation_input_path) / "versions.txt"
    destination_file = Path(repository_path) / "versions.txt"

    if not source_file.exists():
        destination_file.touch()
        print(
            f"generation-input does not contain versions.txt. "
            f"Created empty versions file: {source_file}"
        )
        return
    try:
        shutil.copy2(source_file, destination_file)
        print(f"Copied '{source_file}' to '{destination_file}'")
    except Exception as e:
        print(f"An error occurred while copying the versions.txt: {e}")
        raise  # Re-raises the caught exception


def _needs_full_repo_generation(generation_config: GenerationConfig) -> bool:
    """
    Whether you should need a full repo generation, i.e., generate all
    libraries in the generation configuration.
    """
    return (
        not generation_config.is_monorepo()
        or generation_config.contains_common_protos()
    )


def _parse_library_name_from(
    includes: Optional[str], generation_config: GenerationConfig
) -> Optional[list[str]]:
    if includes is None or _needs_full_repo_generation(generation_config):
        return None
    return [library_name.strip() for library_name in includes.split(",")]


@main.command()
@click.option(
    "--generation-config-path",
    required=False,
    type=str,
    help="""
    Absolute or relative path to a generation_config.yaml.
    Default to generation_config.yaml in the current working directory.
    """,
)
def validate_generation_config(generation_config_path: str) -> None:
    """
    Validate the given generation configuration.
    """
    if generation_config_path is None:
        generation_config_path = "generation_config.yaml"
    try:
        GenerationConfig.from_yaml(os.path.abspath(generation_config_path))
        print(f"{generation_config_path} is validated without any errors.")
    except ValueError as err:
        print(err)
        sys.exit(1)


if __name__ == "__main__":
    main()
