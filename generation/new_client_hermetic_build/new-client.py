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

"""
Script for enabling generation of a new library
Appends a new library to `generation_config.yaml`

Some of the logic is copied from new-client.py as
a transition step while we test the hermetic build scripts
"""

import click
import os
import re
import sys
from ruamel.yaml import YAML

yaml = YAML()

script_dir = os.path.dirname(os.path.realpath(__file__))


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--api_shortname",
    required=True,
    type=str,
    prompt="Service name? (e.g. automl)",
    help="Name for the new directory name and (default) artifact name",
)
@click.option(
    "--name-pretty",
    required=True,
    type=str,
    prompt="Pretty name? (e.g. 'Cloud AutoML')",
    help="The human-friendly name that appears in README.md",
)
@click.option(
    "--proto-path",
    required=True,
    type=str,
    default=None,
    help="Path to proto file from the root of the googleapis repository to the"
    "directory that contains the proto files (without the version)."
    "For example, to generate the library for 'google/maps/routing/v2', "
    "then you specify this value as 'google/maps/routing'",
)
@click.option(
    "--product-docs",
    required=True,
    type=str,
    prompt="Product Documentation URL",
    help="Documentation URL that appears in README.md",
)
@click.option(
    "--rest-docs",
    type=str,
    help="If it exists, link to the REST Documentation for a service",
)
@click.option(
    "--rpc-docs",
    type=str,
    help="If it exists, link to the RPC Documentation for a service",
)
@click.option(
    "--api-description",
    required=True,
    type=str,
    prompt="Description for README. The first sentence is prefixed by the "
    "pretty name",
    help="Description that appears in README.md",
)
@click.option(
    "--library-name",
    type=str,
    default=None,
    help="The directory name of the new library. By default it's "
    "java-<api_shortname>",
)
@click.option(
    "--distribution-name",
    type=str,
    help="Maven coordinates of the generated library. By default it's "
    "com.google.cloud:google-cloud-<api_shortname>. "
    "It cannot be set at the same time with group_id"
)
@click.option(
    "--release-level",
    type=click.Choice(["stable", "preview"]),
    default="preview",
    show_default=True,
    help="A label that appears in repo-metadata.json. The first library "
         "generation is always 'preview'."
)
@click.option(
    "--api-id",
    type=str,
    help="The value of the apiid parameter used in README.md It has link to "
         "https://console.cloud.google.com/flows/enableapi?apiid=<api_id>"
)
@click.option(
    "--requires-billing",
    type=bool,
    default=True,
    show_default=True,
    help="Based on this value, README.md explains whether billing setup is "
         "needed or not."
)
@click.option(
    "--group-id",
    type=str,
    default="com.google.cloud",
    show_default=True,
    help="The group ID of the artifact when distribution_name is not set. "
    "It cannot be set at the same time as distribution_name"
)
@click.option(
    "--library-type",
    type=str,
    default="GAPIC_AUTO",
    show_default=True,
    help="A label that appears in repo-metadata.json to tell how the library is "
         "maintained or generated"
)
@click.option(
    "--api-reference",
    type=str,
    help="API reference for this library"
)
@click.option(
    "--codeowner-team",
    type=str,
    help="Team owning this library"
)
@click.option(
    "--excluded-dependencies",
    type=str,
    help="Comma-separated list of dependencies excluded from this library. The modules specified "
    "here will not be added to the poms when postprocessing."
)
@click.option(
    "--excluded-poms",
    type=str,
    help="Comma-separated list of pom files excluded from postprocessing."
)
@click.option(
    "--googleapis-committish",
    type=str,
    help="Committish of googleapis/googleapis to get the protos from. It will "
    "override the repo-level committish and is not subject to automatic updates"
)
@click.option(
    "--issue-tracker",
    type=str,
    help="Issue tracker of the library"
)
def add_new_library(
    api_shortname,
    name_pretty,
    proto_path,
    product_docs,
    rest_docs,
    rpc_docs,
    api_description,
    library_name,
    distribution_name,
    release_level,
    api_id,
    requires_billing,
    group_id,
    library_type,
    api_reference,
    codeowner_team,
    excluded_dependencies,
    excluded_poms,
    googleapis_committish,
    issue_tracker,
):
    output_name = library_name if library_name else api_shortname
    if distribution_name is None:
        distribution_name = f"{group_id}:google-cloud-{output_name}"
    elif group_id:
        raise ValueError('--group-id and --distribution-name are mutually exclusive options')
    else:
      group_id = distribution_name.split(':')[0]

    distribution_name_short = re.split(r"[:\/]", distribution_name)[-1]

    if api_id is None:
        api_id = f"{api_shortname}.googleapis.com"

    if not product_docs.startswith("https"):
        sys.exit(
            f"product_docs must starts with 'https://' - actual value is {product_docs}"
        )

    client_documentation = f"https://cloud.google.com/java/docs/reference/{distribution_name_short}/latest/overview"

    if library_name is None:
        library_name = f"java-{api_shortname}"

    if api_shortname == "":
        sys.exit("api_shortname is empty")

    path_to_yaml = os.path.join(script_dir, "..", "..", "generation_config.yaml")
    with open(path_to_yaml, "r") as file_stream:
        config = yaml.load(file_stream)

    new_library = {
        "api_shortname": api_shortname,
        "name_pretty": name_pretty,
        "product_documentation": product_docs,
        "api_description": api_description,
        "client_documentation": client_documentation,
        "release_level": release_level,
        "distribution_name": distribution_name,
        "library_name": library_name,
        "api_id": api_id,
        "library_type": library_type,
        "group_id": group_id,
        "GAPICs": [{
            "proto_path": proto_path
        }]
    }

    __add_item_if_set(new_library, "requires_billing", requires_billing)
    __add_item_if_set(new_library, "rest_documentation", rest_docs)
    __add_item_if_set(new_library, "rpc_documentation", rpc_docs)
    __add_item_if_set(new_library, "distribution_name", distribution_name)
    __add_item_if_set(new_library, "api_reference", api_reference)
    __add_item_if_set(new_library, "codeowner_team", codeowner_team)
    __add_item_if_set(new_library, "excluded_dependencies", excluded_dependencies)
    __add_item_if_set(new_library, "excluded_poms", excluded_poms)
    __add_item_if_set(new_library, "googleapis_commitish", googleapis_committish)
    __add_item_if_set(new_library, "issue_tracker", issue_tracker)


    config["libraries"].append(new_library)
    config["libraries"] = sorted(config["libraries"], key=__compute_library_name)


    with open(path_to_yaml, "w") as file_stream:
        yaml.dump(config, file_stream)


def __add_item_if_set(target, key, value):
    if value is not None:
        target[key] = value


def __compute_library_name(library: dict) -> str:
    if "library_name" in library:
        return f'java-{library["library_name"]}'
    return f'java-{library["api_shortname"]}'


if __name__ == "__main__":
    main()
