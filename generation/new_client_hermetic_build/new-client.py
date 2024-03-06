"""
Script for enabling generation of a new library
Creates initial files and appends a new library to generation_config.yaml

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
    "--transport",
    type=click.Choice(["grpc", "http", "both"]),
    default="grpc",
    show_default=True,
    help="A label that appears in repo-metadata.json",
)
@click.option(
    "--destination-name",
    type=str,
    default=None,
    help="The directory name of the new library. By default it's "
    "java-<api_shortname>",
)
@click.option(
    "--distribution-name",
    type=str,
    help="Maven coordinates of the generated library. By default it's "
    "com.google.cloud:google-cloud-<api_shortname>",
)
def add_new_library(
    api_shortname,
    name_pretty,
    proto_path,
    product_docs,
    rest_docs,
    rpc_docs,
    api_description,
    transport,
    destination_name,
    distribution_name,
):
    output_name = destination_name if destination_name else api_shortname
    if distribution_name is None:
        distribution_name = f"com.google-cloud:google-cloud-{output_name}"

    distribution_name_short = re.split(r"[:\/]", distribution_name)[-1]

    api_id = f"{api_shortname}.googleapis.com"

    if not product_docs.startswith("https"):
        sys.exit(
            f"product_docs must starts with 'https://' - actual value is {product_docs}"
        )

    client_documentation = f"https://cloud.google.com/java/docs/reference/{distribution_name_short}/latest/overview"

    if destination_name is None:
        destination_name = f"java-{api_shortname}"

    if api_shortname == "":
        sys.exit("api_shortname is empty")

    path_to_yaml = os.path.join(script_dir, "..", "..", "generation_config.yaml")
    with open(path_to_yaml, "r") as file_stream:
        config = yaml.load(file_stream)

    # confirm library doesn't exist both in the monorepo and config yaml
    path_to_library = os.path.join(script_dir, "..", "..", destination_name)

    for library in config["libraries"]:
        if __compute_destination_name(library) == destination_name:
            print(f"library {destination_name} already exists")
            sys.exit(1)

    new_library = {
        "api_shortname": api_shortname,
        "name_pretty": name_pretty,
        "product_documentation": product_docs,
        "api_description": api_description,
        "transport": transport,
        "destination_name": destination_name,
        "GAPICs": [{
            "proto_path": proto_path
        }]
    }

    __add_item_if_set(new_library, "rest_docs", rest_docs)
    __add_item_if_set(new_library, "rpc_docs", rpc_docs)
    __add_item_if_set(new_library, "distribution_name", distribution_name)

    config["libraries"].append(new_library)
    config["libraries"] = sorted(config["libraries"], key=__compute_destination_name)

    yaml.dump(config, sys.stdout)

    with open(path_to_yaml, "w") as file_stream:
        yaml.dump(config, file_stream)


def __add_item_if_set(target, key, value):
    if value is not None:
        target[key] = value


def __compute_destination_name(library: dict) -> str:
    if "library_name" in library:
        return f'java-{library["library_name"]}'
    return f'java-{library["api_shortname"]}'


if __name__ == "__main__":
    main()
