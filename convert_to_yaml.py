import os.path
import re
from pathlib import Path
import json
from typing import List, Dict

import click as click
import yaml

module_excludes = [
    "java-core",
    "java-grafeas",
    "java-dns",
    "java-notification",
    "java-vertexai",
]
assembly_pattern = r"""
java_gapic_assembly_gradle_pkg\(
(.*?)
\)
"""

# keys are not in the list will produce a WARNING.
metadata_keys = [
    "api_shortname",
    "api_description",
    "name_pretty",
    "product_documentation",
    "library_type",
    "release_level",
    "api_id",
    "api_reference",
    "codeowner_team",
    "client_documentation",
    "excluded_dependencies",
    "excluded_poms",
    "distribution_name",
    "group_id",
    "issue_tracker",
    "language",
    "library_name",
    "rest_documentation",
    "rpc_documentation",
    "cloud_api",
    "requires_billing",
    "transport",
    "repo",
    "repo_short",
]


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--path", required=False, type=str, prompt="path", help="path to google-cloud-java"
)
def generate(path: str = ".") -> None:
    config = {
        "gapic_generator_version": "2.34.0",
        "protobuf_version": "25.2",
        "googleapis_commitish": "7d73737e0e826ac683a4b5b19352feabf51bbc57",
        "owlbot_cli_image": "sha256:623647ee79ac605858d09e60c1382a716c125fb776f69301b72de1cd35d49409",
        "synthtool_commitish": "6612ab8f3afcd5e292aecd647f0fa68812c9f5b5",
        "template_excludes": [
            ".github/*",
            ".kokoro/*",
            "samples/*",
            "CODE_OF_CONDUCT.md",
            "CONTRIBUTING.md",
            "LICENSE",
            "SECURITY.md",
            "java.header",
            "license-checks.xml",
            "renovate.json",
            ".gitignore",
        ],
    }
    libraries = []
    for module in sorted(Path(path).resolve().iterdir()):
        if (not module.name.startswith("java-")) or module.name in module_excludes:
            continue
        with open(f"{module}/.repo-metadata.json") as f:
            metadata = json.load(f)
        new_keys = []
        for key in metadata:
            if key not in metadata_keys:
                new_keys.append(key)
        if len(new_keys) > 0:
            print(f"WARN: new keys in {module}: {new_keys}")

        # add required value
        library = {
            "api_shortname": metadata["api_shortname"],
            "name_pretty": metadata["name_pretty"],
            "product_documentation": metadata["product_documentation"],
            "api_description": metadata["api_description"],
        }
        # only need to add non-default value
        api_shortname = library["api_shortname"]
        if module.name != f"java-{api_shortname}":
            # define library-name if the module name
            # is NOT the same as java-{api-shortname}
            index = module.name.find("-")
            library["library_name"] = module.name[index + 1 :]
        if "release_level" in metadata and metadata["release_level"] == "stable":
            library["release_level"] = "stable"
        if (
            "api_id" in metadata
            and metadata["api_id"] != f"{api_shortname}.googleapis.com"
        ):
            library["api_id"] = metadata["api_id"]
        distribution_name = str(metadata["distribution_name"])
        if "cloud-" not in distribution_name:
            library["cloud_api"] = False
        distribution_name_short = re.split(r"[:/]", distribution_name)[-1]
        if (
            metadata["client_documentation"]
            != f"https://cloud.google.com/java/docs/reference/{distribution_name_short}/latest/overview"
        ):
            library["client_documentation"] = metadata["client_documentation"]
        # do not add None to the dict
        if "api_reference" in metadata:
            library["api_reference"] = metadata["api_reference"]
        if "codeowner_team" in metadata:
            library["codeowner_team"] = metadata["codeowner_team"]
        if "excluded_poms" in metadata:
            library["excluded_poms"] = metadata["excluded_poms"]
        if "excluded_dependencies" in metadata:
            library["excluded_dependencies"] = metadata["excluded_dependencies"]
        if "issue_tracker" in metadata:
            library["issue_tracker"] = metadata["issue_tracker"]
        if "rest_documentation" in metadata:
            library["rest_documentation"] = metadata["rest_documentation"]
        if "rpc_documentation" in metadata:
            library["rpc_documentation"] = metadata["rpc_documentation"]
        # read proto_path from .OwlBot.yaml
        with open(f"{module}/.OwlBot.yaml") as f:
            owlbot = yaml.safe_load(f)
        source = owlbot["deep-copy-regex"][0]["source"]
        regex_index = source.find("/(")
        if regex_index == -1:
            # the source path has no regex, find the version index instead.
            regex_index = source.find("/v")
        # non-versioned proto_path is the substring starting from index 1
        # (excluding the leading "/") to the version (a regex staring with "v").
        proto_path = source[1:regex_index]
        library["GAPICs"] = __get_versioned_proto_path(proto_path)
        libraries.append(library)
    config["libraries"] = libraries
    with open(f"{path}/config.yaml", "w") as out:
        yaml.dump(config, out, indent=2, Dumper=MyDumper, sort_keys=False)


def __get_versioned_proto_path(path: str) -> List[Dict[str, str]]:
    res = []
    for sub_dir in sorted(Path(path).resolve().iterdir()):
        if sub_dir.is_file() or not sub_dir.name.startswith("v"):
            continue
        if not os.path.exists(f"{sub_dir}/BUILD.bazel"):
            continue
        with open(f"{sub_dir}/BUILD.bazel") as f:
            build_content = f.read()
        assembly_target = re.compile(assembly_pattern, re.DOTALL | re.VERBOSE).findall(
            build_content
        )
        # only add the versioned proto_path if the BUILD contains
        # `java_gapic_assembly_gradle_pkg` target; otherwise this version
        # should not be published.
        if len(assembly_target) == 0:
            continue

        res.append({"proto_path": f"{path}/{sub_dir.name}"})
    return res


class MyDumper(yaml.SafeDumper):
    # HACK: insert blank lines between top-level objects
    # inspired by https://stackoverflow.com/a/44284819/3786245
    def write_line_break(self, data=None):
        super().write_line_break(data)

        if len(self.indents) == 2:
            super().write_line_break()


if __name__ == "__main__":
    main()
