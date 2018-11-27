# Copyright 2018 Google LLC
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

# Usage: python new_client.py -v <api version> -s <service name> -c <path to config>

import argparse
import attr
import copy
import os
import re
import sys
import subprocess
from jinja2 import Environment, FileSystemLoader
from lxml import etree
from typing import List
from releasetool.commands.start import java as releasetool

class Context:
    service: str = None
    api_version: str = None
    artman_config: str = None
    google_cloud_artifact: str = None
    google_cloud_version: str = None
    grpc_artifact: str = None
    grpc_version: str = None
    proto_artifact: str = None
    proto_version: str = None
    root_directory: str = None
    description: str = "FIXME"
    name: str = "FIXME"
    versions: List[str] = None

    def __init__(self, service: str, api_version: str, artman_config: str):
        self.service = service
        self.api_version = api_version
        self.artman_config = artman_config
        self.google_cloud_artifact = f'google-cloud-{service}'
        self.grpc_artifact = f'grpc-google-cloud-{service}-{api_version}'
        self.proto_artifact = f'proto-google-cloud-{service}-{api_version}'
        self.root_directory = os.path.realpath(os.path.join(os.path.dirname(os.path.realpath(__file__)), '..'))
        self.jinja_env = Environment(
            loader=FileSystemLoader(self.path('utilities/templates'))
        )
        print(self.root_directory)

    def path(self, suffix) -> str:
        return os.path.join(self.root_directory, suffix)

def add_to_versions(ctx: Context) -> None:
    versions = []

    # read from versions.txt
    versions_path = ctx.path('versions.txt')
    with open(versions_path) as f:
        for line in f:
            version_line = line.strip()
            if not version_line or version_line.startswith("#"):
                continue

            versions.append(releasetool.ArtifactVersions(version_line))

    if not next((v for v in versions if v.module == ctx.google_cloud_artifact), None):
        print("adding new versions to versions.txt")
        # insert new versions
        # use assets API for new api versions
        version = copy.deepcopy(next(v for v in versions if v.module == 'google-cloud-asset'))
        version.module = ctx.google_cloud_artifact
        versions.append(version)
        ctx.google_cloud_version = str(version)

        version = copy.deepcopy(next(v for v in versions if v.module == 'proto-google-cloud-asset-v1beta1'))
        version.module = ctx.proto_artifact
        versions.append(version)
        ctx.proto_version = str(version)

        version = copy.deepcopy(next(v for v in versions if v.module == 'grpc-google-cloud-asset-v1beta1'))
        version.module = ctx.grpc_artifact
        versions.append(version)
        ctx.grpc_version = str(version)

        # sort by name
        versions.sort(key=lambda v: v.module)

        # update versions.txt
        with open(versions_path, "w") as f:
            f.write("# Format:\n")
            f.write("# module:released-version:current-version\n\n")
            for versions in versions:
                f.write("{}\n".format(versions))

    ctx.versions = versions

def add_module_to_pom(pom: str, module_name: str) -> None:
    tree = etree.parse(pom)
    root = tree.getroot()
    modules = root.find('{http://maven.apache.org/POM/4.0.0}modules')

    new_module = etree.Element('{http://maven.apache.org/POM/4.0.0}module')
    new_module.text = module_name

    for i, module in enumerate(modules):
        if module.text == module_name:
            # print("already added to pom.xml, skipping")
            return

        if module.text > module_name:
            modules.insert(i, new_module)
            break

    tree.write(pom, pretty_print=True, xml_declaration=True, encoding='utf-8')

def write_synthfile(ctx: Context) -> None:
    template = ctx.jinja_env.get_template('synth.py')
    synth = template.stream(
        version=ctx.api_version,
        service=ctx.service,
        config_path=ctx.artman_config,
    )
    path = ctx.path(f'google-cloud-clients/{ctx.google_cloud_artifact}/synth.py')
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    synth.dump(path)

def write_pom(template: str, path: str, ctx: Context, version: str) -> None:
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
    pom.dump(path)

def run_synthtool(ctx: Context) -> None:
    subprocess.run(
        [sys.executable, 'synth.py'],
        check=True,
        cwd=ctx.path(f'google-cloud-clients/{ctx.google_cloud_artifact}')
    )

def update_stub_packages(ctx: Context) -> None:
    # open google-cloud-clients/pom.xml and fix the Stub packages list
    pom = ctx.path('google-cloud-clients/pom.xml')
    tree = etree.parse(pom)

    grpc_artifacts = [v.module for v in ctx.versions if v.module.startswith('grpc-')]
    stub_classes = []
    for artifact in grpc_artifacts:
        m = re.match('grpc-google-cloud-(.*)-(v.*)', artifact)
        stub_classes.append(f'com.google.cloud.{m[1]}.{m[2]}.stub')

    for group in tree.findall('.//{http://maven.apache.org/POM/4.0.0}group'):
        if group.find('{http://maven.apache.org/POM/4.0.0}title').text == 'Stub packages':
            group.find('{http://maven.apache.org/POM/4.0.0}packages').text = ':'.join(stub_classes)

    tree.write(pom, pretty_print=True, xml_declaration=True, encoding='utf-8')

def write_readme(ctx: Context) -> None:
    template = ctx.jinja_env.get_template('README.md')
    pom = template.stream(
        api_version=ctx.api_version,
        description=ctx.description,
        name=ctx.name,
        service=ctx.service,
        version=ctx.google_cloud_version
    )
    path = ctx.path(f'google-cloud-clients/{ctx.google_cloud_artifact}/README.md')
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    pom.dump(path)


parser = argparse.ArgumentParser(description='Create a new client')
parser.add_argument('-v', required=True, help='API version (i.e. v1)')
parser.add_argument('-c', required=True, help='Path to config in googleapis/googleapis')
parser.add_argument('-s', required=True, help='Service name')
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
    path=ctx.path(f'google-cloud-clients/{ctx.google_cloud_artifact}/pom.xml'),
    version=ctx.google_cloud_version
)
add_module_to_pom(
    pom=ctx.path('google-cloud-clients/pom.xml'),
    module_name='google-cloud-iamcredentials'
)
write_pom(
    ctx=ctx,
    template="proto_pom.xml",
    path=ctx.path(f'google-api-grpc/{ctx.proto_artifact}/pom.xml'),
    version=ctx.proto_version
)
write_pom(
    ctx=ctx,
    template="grpc_pom.xml",
    path=ctx.path(f'google-api-grpc/{ctx.grpc_artifact}/pom.xml'),
    version=ctx.grpc_version
)
add_module_to_pom(
    pom=ctx.path('google-api-grpc/pom.xml'),
    module_name=ctx.grpc_artifact
)
add_module_to_pom(
    pom=ctx.path('google-api-grpc/pom.xml'),
    module_name=ctx.proto_artifact
)
update_stub_packages(ctx)
write_readme(ctx)
