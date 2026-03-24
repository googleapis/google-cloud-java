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
import click as click

from library_generation.utils.pom_generator import generate_gapic_bom


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--repository-path",
    required=True,
    type=str,
    help="""
    Path to which the generated pom.xml goes.
    """,
)
@click.option(
    "--versions-file",
    required=True,
    type=str,
    help="""
    The file containing version of libraries.
    Throw FileNotFoundError if the file doesn't exist.
    """,
)
def generate(repository_path: str, versions_file: str) -> None:
    generate_gapic_bom(repository_path=repository_path, versions_file=versions_file)


if __name__ == "__main__":
    main()
