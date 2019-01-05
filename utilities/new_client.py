#!/usr/bin/env python3
#  Copyright 2018 Google LLC
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

import argparse
import os
import pathlib
import re
import sys
import subprocess

import attr
from jinja2 import Environment, FileSystemLoader
from lxml import etree
from releasetool.commands.start import java as releasetool
from typing import List

@attr.s(auto_attribs=True)
class Context:
    service: str = None
    api_version: str = None
    artman_config: str = None
    google_cloud_artifact: str = None
    google_cloud_version: releasetool.Version = None
    grpc_artifact: str = None
    grpc_version: releasetool.Version = None
    proto_artifact: str = None
    proto_version: releasetool.Version = None
    root_directory: pathlib.Path = \
        pathlib.Path(os.path.realpath(os.path.join(os.path.dirname(os.path.realpath(__file__)), "..")))
    description: str = "FIXME"
    name: str = "FIXME"
    versions: List[str] = None
    jinja_env: Environment = None

    def __attrs_post_init__(self):
        self.google_cloud_artifact = f"google-cloud-{self.service}"
        self.grpc_artifact = f"grpc-google-cloud-{self.service}-{self.api_version}"
        self.proto_artifact = f"proto-google-cloud-{self.service}-{self.api_version}"
        self.jinja_env = Environment(
            loader=FileSystemLoader(str(self.root_directory / "utilities/templates"))
        )

def add_to_versions(ctx: Context) -> None:
    """Add the new artifact's versions to the versions.txt manifest."""
    versions = []

    # read from versions.txt
    versions_path = ctx.root_directory / "versions.txt"
    with open(versions_path) as f:
        for line in f:
            version_line = line.strip()
            if not version_line or version_line.startswith("#"):
                continue

            versions.append(releasetool.ArtifactVersions(version_line))

    # Add new versions unless the artifacts already exist in the versions.txt manifest
    ctx.google_cloud_version = next((v for v in versions if v.module == ctx.google_cloud_artifact), None)
    if not ctx.google_cloud_version:
        ctx.google_cloud_version = releasetool.ArtifactVersions(f"{ctx.google_cloud_artifact}:0.0.0-alpha:0.0.1-alpha-SNAPSHOT")
        versions.append(ctx.google_cloud_version)

    ctx.proto_version = next((v for v in versions if v.module == ctx.proto_artifact), None)
    if not ctx.proto_version:
        ctx.proto_version = releasetool.ArtifactVersions(f"{ctx.proto_artifact}:0.0.0-alpha:0.0.1-alpha-SNAPSHOT")
        versions.append(ctx.proto_version)

    ctx.grpc_version = next((v for v in versions if v.module == ctx.grpc_artifact), None)
    if not ctx.grpc_version:
        ctx.grpc_version = releasetool.ArtifactVersions(f"{ctx.grpc_artifact}:0.0.0-alpha:0.0.1-alpha-SNAPSHOT")
        versions.append(ctx.grpc_version)

    # sort by name
    versions.sort(key=lambda v: v.module)

    # update versions.txt
    with open(versions_path, "w") as f:
        f.write("# Format:\n")
        f.write("# module:released-version:current-version\n\n")
        for version in versions:
            f.write("{}\n".format(version))

    ctx.versions = versions

def add_module_to_pom(pom: pathlib.Path, module_name: str) -> None:
    """
    Insert a new <module>name</module> into a pom.xml file.

    This assumes that the modules are in alphabetical order and inserts it
    in the correct place
    """
    tree = etree.parse(str(pom))
    root = tree.getroot()
    modules = root.find("{http://maven.apache.org/POM/4.0.0}modules")

    new_module = etree.Element("{http://maven.apache.org/POM/4.0.0}module")
    new_module.text = module_name

    for i, module in enumerate(modules):
        if module.text == module_name:
            # print("already added to pom.xml, skipping")
            return

        if module.text > module_name:
            modules.insert(i, new_module)
            break

    tree.write(str(pom), pretty_print=True, xml_declaration=True, encoding="utf-8")

def add_dependency_management_to_pom(pom: pathlib.Path, group: str, artifact: str, version: str) -> None:
    """Adds a <dependency>...</depedency> section into a pom.xml file."""
    tree = etree.parse(str(pom))
    root = tree.getroot()
    dependencies = root.find("{http://maven.apache.org/POM/4.0.0}dependencyManagement/{http://maven.apache.org/POM/4.0.0}dependencies")

    for dependency in dependencies:
        existing = dependency.find("{http://maven.apache.org/POM/4.0.0}artifactId")
        if existing is not None:
            if existing.text == artifact:
                print("already added dependency to pom.xml, skipping")
                return

    new_dependency = etree.Element("{http://maven.apache.org/POM/4.0.0}dependency")
    group_element = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
    group_element.text = group
    new_dependency.append(group_element)
    artifact_element = etree.Element("{http://maven.apache.org/POM/4.0.0}artifactId")
    artifact_element.text = artifact
    new_dependency.append(artifact_element)
    version_element = etree.Element("{http://maven.apache.org/POM/4.0.0}version")
    version_element.text = version
    new_dependency.append(version_element)
    comment = etree.Comment("{x-version-update:" + artifact + ":current}")
    new_dependency.append(comment)
    dependencies.append(new_dependency)

    tree.write(str(pom), pretty_print=True, xml_declaration=True, encoding="utf-8")


def write_synthfile(ctx: Context) -> None:
    """Creates a synth.py file from a template."""
    template = ctx.jinja_env.get_template("synth.py")
    synth = template.stream(
        version=ctx.api_version,
        service=ctx.service,
        config_path=ctx.artman_config,
    )
    path = ctx.root_directory / "google-cloud-clients" / ctx.google_cloud_artifact / "synth.py"
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    synth.dump(str(path))

def write_pom(template: str, path: str, ctx: Context, version: str) -> None:
    """Creates a pom.xml file from a template."""
    template = ctx.jinja_env.get_template(template)
    pom = template.stream(
        api_version=ctx.api_version,
        description=ctx.description,
        name=ctx.name,
        service=ctx.service,
        version=version
    )
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    pom.dump(str(path))

def run_synthtool(ctx: Context) -> None:
    """Runs synthtool for the initial client generation."""
    subprocess.run(
        [sys.executable, "synth.py"],
        check=True,
        cwd=ctx.root_directory / "google-cloud-clients" / ctx.google_cloud_artifact
    )

def update_stub_packages(ctx: Context) -> None:
    """Updates the pom.xml documentation section to scrub certain packages."""
    # open google-cloud-clients/pom.xml and fix the Stub packages list
    pom = ctx.root_directory / "google-cloud-clients/pom.xml"
    tree = etree.parse(str(pom))

    grpc_artifacts = [v.module for v in ctx.versions if v.module.startswith("grpc-")]
    stub_classes = []
    for artifact in grpc_artifacts:
        m = re.match("grpc-google-cloud-(.*)-(v.*)", artifact)
        stub_classes.append(f"com.google.cloud.{m[1]}.{m[2]}.stub")

    for group in tree.findall(".//{http://maven.apache.org/POM/4.0.0}group"):
        if group.find("{http://maven.apache.org/POM/4.0.0}title").text == "Stub packages":
            group.find("{http://maven.apache.org/POM/4.0.0}packages").text = ":".join(stub_classes)

    tree.write(str(pom), pretty_print=True, xml_declaration=True, encoding="utf-8")

def write_readme(ctx: Context) -> None:
    """Creates a README.md from a template."""
    template = ctx.jinja_env.get_template("README.md.tmpl")
    pom = template.stream(
        api_version=ctx.api_version,
        description=ctx.description,
        name=ctx.name,
        service=ctx.service,
        version=ctx.google_cloud_version
    )
    path = ctx.root_directory / "google-cloud-clients" / ctx.google_cloud_artifact / "README.md"
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    pom.dump(str(path))

def main():
    parser = argparse.ArgumentParser(description="Create a new client")
    parser.add_argument("-v", required=True, help="API version (i.e. v1)")
    parser.add_argument("-c", required=True, help="Path to config in googleapis/googleapis")
    parser.add_argument("-s", required=True, help="Service name")
    args = parser.parse_args()

    ctx = Context(
        api_version=args.v,
        service=args.s,
        artman_config=args.c
    )

    add_to_versions(ctx)
    write_synthfile(ctx)
    run_synthtool(ctx)
    write_pom(
        ctx=ctx,
        template="cloud_pom.xml",
        path=ctx.root_directory / "google-cloud-clients" / ctx.google_cloud_artifact / "pom.xml",
        version=ctx.google_cloud_version.current
    )
    add_module_to_pom(
        pom=ctx.root_directory / "google-cloud-clients/pom.xml",
        module_name="google-cloud-iamcredentials"
    )
    add_dependency_management_to_pom(
        pom=ctx.root_directory /  "google-api-grpc/pom.xml",
        group="com.google.api.grpc",
        artifact=ctx.proto_artifact,
        version=str(ctx.proto_version.current)
    )
    add_dependency_management_to_pom(
        pom=ctx.root_directory / "google-api-grpc/pom.xml",
        group="com.google.api.grpc",
        artifact=ctx.grpc_artifact,
        version=str(ctx.grpc_version.current)
    )
    add_dependency_management_to_pom(
        pom=ctx.root_directory / "google-cloud-bom/pom.xml",
        group="com.google.api.grpc",
        artifact=ctx.proto_artifact,
        version=str(ctx.proto_version.current)
    )
    add_dependency_management_to_pom(
        pom=ctx.root_directory / "google-cloud-bom/pom.xml",
        group="com.google.api.grpc",
        artifact=ctx.grpc_artifact,
        version=str(ctx.grpc_version.current)
    )
    add_dependency_management_to_pom(
        pom=ctx.root_directory / "google-cloud-bom/pom.xml",
        group="com.google.cloud",
        artifact=ctx.google_cloud_artifact,
        version=str(ctx.google_cloud_version.current)
    )
    write_pom(
        ctx=ctx,
        template="proto_pom.xml",
        path=ctx.root_directory / "google-api-grpc" / ctx.proto_artifact / "pom.xml",
        version=ctx.proto_version.current
    )
    write_pom(
        ctx=ctx,
        template="grpc_pom.xml",
        path=ctx.root_directory / "google-api-grpc" / ctx.grpc_artifact / "pom.xml",
        version=ctx.grpc_version.current
    )
    add_module_to_pom(
        pom=ctx.root_directory /  "google-api-grpc/pom.xml",
        module_name=ctx.grpc_artifact
    )
    add_module_to_pom(
        pom=ctx.root_directory / "google-api-grpc/pom.xml",
        module_name=ctx.proto_artifact
    )
    update_stub_packages(ctx)
    write_readme(ctx)

if __name__ == "__main__":
    main()
