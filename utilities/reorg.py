#!/usr/bin/env python3
#  Copyright 2019 Google LLC
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

import glob
import os
import pathlib
import shutil
import warnings

import attr
import inflection
from jinja2 import Environment, FileSystemLoader
from lxml import etree
from typing import List

ROOT = pathlib.Path(os.path.realpath(os.path.join(os.path.dirname(os.path.realpath(__file__)), "..")))
JINJA_ENV = Environment(
    loader=FileSystemLoader(str(ROOT / "utilities/templates"))
)

@attr.s(auto_attribs=True)
class Artifact:
    name: str = None
    group_id: str = None
    version: str = None

@attr.s(auto_attribs=True)
class Service:
    service: str = None
    name: str = None
    version: str = None
    submodules: List[Artifact] = []
    api_versions: List[str] = []

def write_parent_pom(path: str, service: Service, parent_version: str):
    template = JINJA_ENV.get_template("parent_pom.xml")
    stub_packages = "FIXME"
    pom = template.stream(
        service=service.service,
        version=service.version,
        name=service.name,
        parent_version=parent_version,
        submodules=service.submodules,
        stub_packages=stub_packages
    )
    pom.dump(str(path))

def version_from_pom(pom_file: str) -> str:
    try:
        tree = etree.parse(str(pom_file))
        return tree.xpath("/a:project/a:version", namespaces={'a': 'http://maven.apache.org/POM/4.0.0'})[0].text
    except OSError:
        return None

IGNORED_SERVICES = [
    'core',
    'core-grpc',
    'core-http',
    'contrib',
    'notification'
]

def all_services():
    services = []
    for dir in os.listdir(ROOT / "google-cloud-clients"):
        cloud_client = os.path.basename(dir)
        if cloud_client.startswith('google-cloud-'):
            service = cloud_client.replace('google-cloud-', '')

            # read the version from the google-cloud-[service] pom.xml
            version = version_from_pom(ROOT / "google-cloud-clients" / cloud_client / "pom.xml")
            if version is None:
                continue

            # skip ignored services
            if service in IGNORED_SERVICES:
                continue

            # collect list of relevant submodules
            submodules = []
            api_versions = []
            for proto_module in glob.glob(str(ROOT / "google-api-grpc" / f"proto-google-cloud-{service}-*")):
                submodule = os.path.basename(proto_module)
                artifact = Artifact(
                    name=os.path.basename(proto_module),
                    group_id="com.google.api.grpc",
                    version=version_from_pom(ROOT / submodule / "pom.xml")
                )
                submodules.append(artifact)
                api_versions.append(submodule.replace(f"proto-google-cloud-{service}-", ''))
            for grpc_module in glob.glob(str(ROOT / "google-api-grpc" / f"grpc-google-cloud-{service}-*")):
                artifact = Artifact(
                    name=os.path.basename(grpc_module),
                    group_id="com.google.api.grpc",
                    version=version_from_pom(ROOT / submodule / "pom.xml")
                )
                submodules.append(artifact)
            submodules.append(
                Artifact(
                    name=cloud_client,
                    group_id="com.google.cloud",
                    version=version
                )
            )

            service = Service(
                service=service,
                name=inflection.titleize(service),
                version=version,
                submodules=submodules,
                api_versions=api_versions,
            )
            services.append(service)
    return services


def copy_client(service: str, artifact: str, current_location: str):
    src = str(ROOT / current_location / artifact)
    dest = str(ROOT / "google-cloud-clients" / service / artifact)
    try:
        shutil.copytree(src, dest)
    except FileNotFoundError:
        warnings.warn("source not found: " + src)
    except FileExistsError:
        pass
        # warnings.warn("destination already exists: " + dest)

def fix_parent_version(pom: str, artifact: str, version: str):
    tree = None
    try:
        tree = etree.parse(str(pom))
    except OSError:
        return

    parent = tree.find(".//{http://maven.apache.org/POM/4.0.0}parent")
    parent.clear()

    group_element = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
    group_element.text = "com.google.cloud"
    parent.append(group_element)
    artifact_element = etree.Element("{http://maven.apache.org/POM/4.0.0}artifactId")
    artifact_element.text = artifact
    parent.append(artifact_element)
    version_element = etree.Element("{http://maven.apache.org/POM/4.0.0}version")
    version_element.text = version
    parent.append(version_element)

    tree.write(str(pom), pretty_print=True, xml_declaration=True, encoding="utf-8")


def main():
    parent_version = version_from_pom(ROOT / "google-cloud-clients" / "pom.xml")
    for service in all_services():
        target_directory = ROOT / "google-cloud-clients" / service.service
        if not os.path.isdir(target_directory):
            os.makedirs(target_directory);

        # create the parent pom
        write_parent_pom(path=target_directory / "pom.xml", service=service, parent_version=parent_version)

        # TODO(chingor): make this move instead of copy
        # copy the artifacts to the new locations
        copy_client(service.service, f"google-cloud-{service.service}", "google-cloud-clients")
        fix_parent_version(
            ROOT / "google-cloud-clients" / service.service / f"google-cloud-{service.service}" / "pom.xml",
            f"google-cloud-{service.service}-parent",
            service.version
        )
        for version in service.api_versions:
            copy_client(service.service, f"proto-google-cloud-{service.service}-{version}", "google-api-grpc")
            fix_parent_version(
                ROOT / "google-cloud-clients" / service.service / f"proto-google-cloud-{service.service}-{version}" / "pom.xml",
                f"google-cloud-{service.service}-parent",
                service.version
            )
            copy_client(service.service, f"grpc-google-cloud-{service.service}-{version}", "google-api-grpc")
            fix_parent_version(
                ROOT / "google-cloud-clients" / service.service / f"grpc-google-cloud-{service.service}-{version}" / "pom.xml",
                f"google-cloud-{service.service}-parent",
                service.version
            )

if __name__ == "__main__":
    main()
