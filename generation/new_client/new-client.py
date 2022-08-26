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

import click
from jinja2 import Environment, FileSystemLoader
from repo_splitter.java import module, pom, templates


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


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
    required=True,
    type=click.Choice(["stable", "preview"]),
    prompt=True,
    default="preview",
)
@click.option(
    "--transport",
    required=True,
    type=click.Choice(["grpc", "http", "both"]),
    prompt=True,
    default="grpc",
)
@click.option("--language", required=True, type=str, prompt=True, default="java")
@click.option("--distribution-name", type=str)
@click.option("--api-id", type=str)
@click.option("--requires-billing", type=bool, default=True)
@click.option("--destination-name", type=str, default=None)
@click.option("--proto-path", type=str, default=None)
@click.option("--cloud-api", type=bool, default=True)
@click.option("--group-id", type=str, default="com.google.cloud")
@click.option(
    "--owlbot-image", type=str, default="gcr.io/cloud-devrel-public-resources/owlbot-java"
)
@click.option("--library-type", type=str)
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

    client_documentation = (
        f"https://cloud.google.com/{language}/docs/reference/{distribution_name_short}/latest/overview"
    )

    if destination_name is None:
        destination_name = api_shortname

    if proto_path is None:
        proto_path = f"/google/cloud/{api_shortname}"

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

    # write .repo-metadata.json file
    workdir = Path(f"workspace/java-{output_name}")
    os.makedirs(workdir, exist_ok=True)
    with open(workdir / ".repo-metadata.json", "w") as fp:
        json.dump(repo_metadata, fp, indent=2)

    subprocess.check_call(["git", "init", "-b", "main"], cwd=workdir)

    # create owlbot.py
    templates.render(
        template_name="new-client/owlbot.py.j2",
        output_name=str(workdir / "owlbot.py"),
        should_include_templates=True,
        template_excludes=[],
    )

    # create owlbot config
    templates.render(
        template_name="new-client/owlbot.yaml.j2",
        output_name=str(workdir / ".github" / ".OwlBot.yaml"),
        artifact_name=distribution_name_short,
        proto_path=proto_path,
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

    # create owlbot lock
    templates.render(
        template_name="new-client/owlbot.lock.yaml.j2",
        output_name=str(workdir / ".github" / ".OwlBot.lock.yaml"),
        owlbot_image_digest=owlbot_image_digest,
        owlbot_image=owlbot_image,
    )

    user = subprocess.check_output(["id", "-u"], encoding="utf8").strip()
    group = subprocess.check_output(["id", "-g"], encoding="utf8").strip()

    # run owlbot copy
    print("Cloning googleapis-gen...")
    subprocess.check_call(["git", "clone", "git@github.com:googleapis/googleapis-gen.git", "./gen/googleapis-gen"], cwd=workdir)
    subprocess.check_call(["docker", "pull", "gcr.io/cloud-devrel-public-resources/owlbot-cli:latest"])
    print("Running copy-code...")
    subprocess.check_call(
        [
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
            "--source-repo=/googleapis-gen"

        ],
        cwd=workdir,
    )
    print("Removing googleapis-gen...")
    subprocess.check_call(["rm", "-fr", "gen"], cwd=workdir)
    # run post processor owl-bot image
    subprocess.check_call(["git", "add", "."], cwd=workdir)
    subprocess.check_call(
        ["git", "commit", "-m", "feat: initial generation"], cwd=workdir
    )
    print("Running the post-processor...")
    subprocess.check_call(
        [
            "docker",
            "run",
            "--rm",
            "-v",
            f"{workdir.resolve()}:/workspace",
            "--user",
            f"{user}:{group}",
            owlbot_image,
        ],
        cwd=workdir,
    )
    subprocess.check_call(["git", "add", "."], cwd=workdir)
    subprocess.check_call(["git", "commit", "--amend", "--no-edit"], cwd=workdir)

if __name__ == "__main__":
    main()
