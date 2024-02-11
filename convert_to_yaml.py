import re
from collections import OrderedDict
from pathlib import Path
import json

import click as click
import yaml

module_excludes = ["java-core", "java-grafeas", "java-dns", "java-notification"]


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--path",
    required=False,
    type=str,
    prompt="path",
    help="path to google-cloud-java"
)
def generate(path: str = ".") -> None:
    libraries = []
    for module in sorted(Path(path).resolve().iterdir()):
        if (not module.name.startswith("java-")) or module.name in module_excludes:
            continue
        with open(f"{module}/.repo-metadata.json") as metadata:
            data = json.load(metadata)
        library = OrderedDict()
        # add required value
        library = {
            "api_shortname": data["api_shortname"],
            "name_pretty": data["name_pretty"],
            "product_documentation": data["product_documentation"],
            "api_description": data["api_description"],
        }
        # only need to add non-default value
        api_shortname = library["api_shortname"]
        if module.name != f"java-{api_shortname}":
            # define library-name if the module name
            # is NOT the same as java-{api-shortname}
            index = module.name.find("-")
            library["library-name"] = module.name[index + 1 :]
        if "release_level" in data and data["release_level"] == "stable":
            library["release_level"] = "stable"
        if "api_id" in data and data["api_id"] != f"{api_shortname}.googleapis.com":
            library["api_id"] = data["api_id"]
        distribution_name = str(data["distribution_name"])
        if "cloud-" not in distribution_name:
            library["cloud_api"] = False
        distribution_name_short = re.split(r"[:/]", distribution_name)[-1]
        if (
            data["client_documentation"]
            != f"https://cloud.google.com/java/docs/reference/{distribution_name_short}/latest/overview"
        ):
            library["client_documentation"] = data["client_documentation"]
        # do not add None to the dict
        if "api_reference" in data:
            library["api_reference"] = data["api_reference"]
        if "codeowner_team" in data:
            library["codeowner_team"] = data["codeowner_team"]
        if "issue_tracker" in data:
            library["issue_tracker"] = data["issue_tracker"]
        if "rest_documentation" in data:
            library["rest_documentation"] = data["rest_documentation"]
        if "rpc_documentation" in data:
            library["rpc_documentation"] = data["rpc_documentation"]
        libraries.append(library)
    with open(f"{path}/config.yaml", "w") as out:
        yaml.dump(libraries, out, indent=2, Dumper=MyDumper, sort_keys=False)


class MyDumper(yaml.SafeDumper):
    # HACK: insert blank lines between top-level objects
    # inspired by https://stackoverflow.com/a/44284819/3786245
    def write_line_break(self, data=None):
        super().write_line_break(data)

        if len(self.indents) == 1:
            super().write_line_break()


if __name__ == "__main__":
    main()
