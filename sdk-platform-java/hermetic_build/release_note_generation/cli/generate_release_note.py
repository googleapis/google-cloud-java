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
from typing import Optional
import click as click
from release_note_generation.generate_pr_description import generate_pr_descriptions
from common.model.generation_config import GenerationConfig
from common.utils.generation_config_comparator import compare_config


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--baseline-generation-config-path",
    required=False,
    default=None,
    type=str,
    help="""
    Absolute or relative path to a generation_config.yaml.
    This config file is used for commit history generation, not library
    generation.
    """,
)
@click.option(
    "--current-generation-config-path",
    required=False,
    default=None,
    type=str,
    help="""
    Absolute or relative path to a generation_config.yaml that contains the
    metadata about library generation.
    """,
)
@click.option(
    "--repository-path",
    type=str,
    default=".",
    show_default=True,
    help="""
    The path where the file `pr_description.txt`, which contains the release
    notes, will be sent.
    If not specified, the file will be generated to the current working
    directory.
    """,
)
def generate(
    baseline_generation_config_path: Optional[str],
    current_generation_config_path: Optional[str],
    repository_path: str,
) -> None:
    if (
        baseline_generation_config_path is None
        or current_generation_config_path is None
    ):
        print(
            "One of the generation configs is not specified, do not generate "
            "the description."
        )
        return
    baseline_generation_config_path = os.path.abspath(baseline_generation_config_path)
    current_generation_config_path = os.path.abspath(current_generation_config_path)
    if not (
        os.path.isfile(baseline_generation_config_path)
        and os.path.isfile(current_generation_config_path)
    ):
        print(
            "One of the generation configs does not exist, do not generate "
            "the description."
        )
        return
    config_change = compare_config(
        baseline_config=GenerationConfig.from_yaml(baseline_generation_config_path),
        current_config=GenerationConfig.from_yaml(current_generation_config_path),
    )
    generate_pr_descriptions(
        config_change=config_change,
        description_path=os.path.abspath(repository_path),
    )


if __name__ == "__main__":
    main()
