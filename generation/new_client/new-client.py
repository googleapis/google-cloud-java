# Copyright 2019 Google LLC
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

import json
import os
from pathlib import Path
import re
import subprocess
import sys

import click
import templates


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass

def add_module_to_root_pom(pom_path: Path, new_module: str):
    with open(pom_path, "r") as fp:
        content = fp.read()

    matches = re.findall(r'<module>([\w\-]+?)</module>', content)
    matches.append(new_module)

    # Make normal modules first and BOM at the end
    matches.sort(key=lambda m: f"0{m}" if m.startswith('java-') else m)
    modules_lines = []
    for match in matches:
        modules_lines.append(f"<module>{match}</module>")

    modules_line = "\n    ".join(modules_lines)
    ordered_content = re.sub(r"<modules>.+</modules>",
                             f"<modules>\n    {modules_line}\n  </modules>",
                             content,
                             flags=re.MULTILINE | re.DOTALL)

    with open(pom_path, "w") as fp:
        fp.truncate(0)
        fp.write(ordered_content)

@main.command()
@click.option("--api_shortname", required=True, type=str, prompt="Service name? (e.g. automl)")
@click.option(
    "--name-pretty",
    required=True,
    type=str,
    prompt="Pretty name? (e.g. 'Cloud AutoML')",
)
@click.option(
    "--product-docs", required=True, type=str, prompt="Product Documentation URL"
)
@click.option(
    "--api-description",
    required=True,
    type=str,
    prompt="Description for README. The first sentence is prefixed by the pretty name",
)
@click.option(
    "--release-level",
    type=click.Choice(["stable", "preview"]),
    default="preview",
)
@click.option(
    "--transport",
    type=click.Choice(["grpc", "http", "both"]),
    default="grpc",
)
@click.option("--language", type=str, default="java")
@click.option("--distribution-name", type=str)
@click.option("--api-id", type=str)
@click.option("--requires-billing", type=bool, default=True)
@click.option("--destination-name", type=str, default=None)
@click.option("--proto-path", required=True, type=str, default=None)
@click.option("--cloud-api", type=bool, default=True)
@click.option("--group-id", type=str, default="com.google.cloud")
@click.option(
    "--owlbot-image", type=str, default="gcr.io/cloud-devrel-public-resources/owlbot-java"
)
@click.option("--library-type", type=str)
@click.option("--monorepo-url", type=str, default="https://github.com/googleapis/google-cloud-java")
def generate(
    api_shortname,
    name_pretty,
    product_docs,
    api_description,
    release_level,
    distribution_name,
    api_id,
    requires_billing,
    transport,
    language,
    destination_name,
    proto_path,
    cloud_api,
    group_id,
    owlbot_image,
    library_type,
    monorepo_url,
):
    cloud_prefix = "cloud-" if cloud_api else ""

    output_name = destination_name if destination_name else api_shortname
    if distribution_name is None:
        distribution_name = f"{group_id}:google-{cloud_prefix}{output_name}"

    distribution_name_short = re.split(r"[:\/]", distribution_name)[-1]

    if api_id is None:
        api_id = f"{api_shortname}.googleapis.com"

    if library_type is None:
        library_type = "GAPIC_AUTO"

    if not product_docs.startswith("https"):
        sys.exit("product_docs must starts with 'https://'")

    client_documentation = (
        f"https://cloud.google.com/{language}/docs/reference/{distribution_name_short}/latest/overview"
    )

    if proto_path is None:
        proto_path = f"/google/cloud/{api_shortname}"

    if api_shortname == "":
        sys.exit("api_shortname is empty")

    repo_metadata = {
        "api_shortname": api_shortname,
        "name_pretty": name_pretty,
        "product_documentation": product_docs,
        "api_description": api_description,
        "client_documentation": client_documentation,
        "release_level": release_level,
        "transport": transport,
        "language": language,
        "repo": f"googleapis/{language}-{output_name}",
        "repo_short": f"{language}-{output_name}",
        "distribution_name": distribution_name,
        "api_id": api_id,
        "library_type": library_type,
    }
    if requires_billing:
        repo_metadata["requires_billing"] = True

    # Initialize workdir
    print("Creating a new module in monorepo " + monorepo_url)
    subprocess.check_call(["mkdir", "-p", "workspace"])
    subprocess.check_call(["rm", "-fr", "monorepo"], cwd="workspace")
    subprocess.check_call(["git", "clone", monorepo_url, "monorepo"],
                          cwd="workspace")
    workdir = Path(f"workspace/monorepo/java-{output_name}")
    os.makedirs(workdir, exist_ok=True)
    subprocess.check_call(["git", "checkout", "-b",
                           f"new_module_java-{output_name}"],
                          cwd=workdir)
    add_module_to_root_pom(workdir / ".." / "pom.xml",
                           f"java-{output_name}")
    subprocess.check_call(["git", "add", "."], cwd=workdir / "..")
    # write .repo-metadata.json file
    with open(workdir / ".repo-metadata.json", "w") as fp:
        json.dump(repo_metadata, fp, indent=2)

    # create owlbot.py
    templates.render(
        template_name="owlbot.py.j2",
        output_name=str(workdir / "owlbot.py"),
        should_include_templates=True,
        template_excludes=[],
    )

    # In monorepo, .OwlBot.yaml needs to be in the directory of the module.
    owlbot_yaml_location_from_module = ".OwlBot.yaml"
    # create owlbot config
    templates.render(
        template_name="owlbot.yaml.monorepo.j2",
        output_name=str(workdir / owlbot_yaml_location_from_module),
        artifact_name=distribution_name_short,
        proto_path=proto_path,
        module_name=f"java-{output_name}"
    )

    # get the sha256 digets for the owlbot image
    subprocess.check_call(["docker", "pull", owlbot_image])
    owlbot_image_digest = (
        subprocess.check_output(
            ["docker", "inspect", "--format='{{index .RepoDigests 0}}", owlbot_image,],
            encoding="utf-8",
        )
            .strip()
            .split("@")[-1]
    )

    user = subprocess.check_output(["id", "-u"], encoding="utf8").strip()
    group = subprocess.check_output(["id", "-g"], encoding="utf8").strip()

    # run owlbot copy
    print("Cloning googleapis-gen...")
    subprocess.check_call(["git", "clone", "https://github.com/googleapis/googleapis-gen.git", "./gen/googleapis-gen"], cwd=workdir)
    subprocess.check_call(["docker", "pull", "gcr.io/cloud-devrel-public-resources/owlbot-cli:latest"])
    copy_code_parameters = [
        "docker",
        "run",
        "--rm",
        "--user",
        f"{user}:{group}",
        "-v",
        f"{workdir.resolve()}:/repo",
        "-v",
        ""f"{workdir.resolve()}""/gen/googleapis-gen:/googleapis-gen",
        "-w",
        "/repo",
        "--env", "HOME=/tmp",
        "gcr.io/cloud-devrel-public-resources/owlbot-cli:latest",
        "copy-code",
        "--source-repo=/googleapis-gen",
        f"--config-file={owlbot_yaml_location_from_module}"
    ]
    print("Running copy-code: " + str(copy_code_parameters))
    print("  in directory: " + str(workdir))
    subprocess.check_call(
        copy_code_parameters,
        cwd=workdir,
    )

    print("Removing googleapis-gen...")
    subprocess.check_call(["rm", "-fr", "gen"], cwd=workdir)

    # Bringing owl-bot-staging from the new module's directory to the root
    # directory so that owlbot-java can process them.
    subprocess.check_call(
        [
            "mv",
            "owl-bot-staging",
            "../"
        ],
        cwd=workdir,
    )
    monorepo_root=(workdir / '..').resolve()
    print("Running the post-processor...")
    subprocess.check_call(
        [
            "docker",
            "run",
            "--rm",
            "-v",
            f"{monorepo_root}:/workspace",
            "--user",
            f"{user}:{group}",
            owlbot_image,
        ],
        cwd=monorepo_root,
    )
    # In monorpeo, .github and .kokoro under the module is unused
    print("Removing unnecessary files")
    subprocess.check_call(["rm", "-fr", ".github"],
                          cwd=workdir)
    subprocess.check_call(["rm", "-fr", ".kokoro"],
                          cwd=workdir)
    subprocess.check_call(["rm", "-f", ".gitignore"],
                          cwd=workdir)

    # Remove irrelevant files from templates
    subprocess.check_call(
        ["bash", "generation/update_owlbot_postprocessor_config.sh"],
        cwd=monorepo_root
    )
    subprocess.check_call(
        ["bash", "generation/delete_non_generated_samples.sh"],
        cwd=monorepo_root
    )

    subprocess.check_call(["git", "add", "."], cwd=workdir)
    subprocess.check_call(
        ["git", "commit", "-m", f"feat: initial generation of {api_shortname}"], cwd=workdir
    )

    print("Regenerating the BOM")
    subprocess.check_call(
        [
            "bash", "generation/generate_gapic_bom.sh",
        ],
        cwd=monorepo_root,
    )

    print("Regenerating root pom.xml")

    # This script takes care of updating the root pom.xml
    os.system(f"cd {monorepo_root} && generation/print_root_pom.sh > pom.xml")

    # This script updates every module's pom sets the root as parent
    subprocess.check_call(
        [
            "bash", "generation/set_parent_pom.sh"
        ],
        cwd=monorepo_root,
    )

    print("Regenerating Release Please config files")
    subprocess.check_call(
        [
            "bash", "generation/generate_release_please_config.sh"
        ],
        cwd=monorepo_root,
    )
    print("Consolidating configurations")
    subprocess.check_call(
        [
            "bash", "generation/consolidate_config.sh"
        ],
        cwd=monorepo_root,
    )
    print("Setting parent poms")
    subprocess.check_call(
        [
            "bash", "generation/set_parent_pom.sh"
        ],
        cwd=monorepo_root,
    )

    print("Applying the versions")
    subprocess.check_call(
        [
            "bash", "generation/apply_current_versions.sh"
        ],
        cwd=monorepo_root,
    )

    # Add the files to commit
    subprocess.check_call([
        "git", "add", "pom.xml", "gapic-libraries-bom/pom.xml",
        "release-please-config.json", ".release-please-manifest.json"],
        cwd=monorepo_root)

    subprocess.check_call(
        ["git", "commit", "-m",
         f"build: add the {api_shortname} module to monorepo"],
        cwd=monorepo_root
    )

    # Remove irrelevant changes in other modules
    subprocess.check_call(
        ["git", "checkout", "--", "."],
        cwd=monorepo_root
    )

    # It seems generate_release_please_config.sh is not ready to run as
    # part of client library generation process.

    print(f"Prepared new library in {workdir}")
    print(f"Please create a pull request from that directory:\n"
          f"  $ cd {monorepo_root}\n"
          f"  $ gh pr create --title 'feat: [{api_shortname}] new module for {api_shortname}'")

if __name__ == "__main__":
    main()

