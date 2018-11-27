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

# Usage: python new_client.py
#
# client name: i.e. securitycenter
# path to artman file
#
#

import attr
import sys, os
import subprocess
from jinja2 import Environment, FileSystemLoader
from lxml import etree as ElementTree
from typing import List
from releasetool.commands.start import java as releasetool

namespaces = {
    'pom': 'http://maven.apache.org/POM/4.0.0'
}

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
        self.google_cloud_version = 'FIXME'
        self.grpc_artifact = f'grpc-google-cloud-{service}-{api_version}'
        self.grpc_version = 'FIXME'
        self.proto_artifact = f'proto-google-cloud-{service}-{api_version}'
        self.proto_version = 'FIXME'
        self.root_directory = os.path.dirname(os.path.realpath(os.path.join('..', __file__)))

    def path(self, suffix) -> str:
        return os.path.join(self.root_directory, suffix)

def add_to_versions(ctx: Context) -> None:
    versions = []
    with open(os.path.join(ctx.root_directory, 'versions.txt')) as f:
        for line in f:
            version_line = line.strip()
            if not version_line or version_line.startswith("#"):
                continue

            versions.append(releasetool.ArtifactVersions(version_line))


    ctx.versions = versions

def add_module_to_pom(pom: str, module_name: str) -> None:
    parser = ElementTree.XMLParser()
    tree = ElementTree.parse(pom, parser)
    root = tree.getroot()
    modules = root.find('pom:modules', namespaces)

    new_module = ElementTree.Element('{http://maven.apache.org/POM/4.0.0}module')
    new_module.text = module_name

    for i, module in enumerate(modules):
        if module.text == module_name:
            print("already added to pom.xml, skipping")
            return

        if module.text > module_name:
            modules.insert(i, new_module)
            break

    tree.write(pom, pretty_print=True, xml_declaration=True, encoding='utf-8')

def write_synthfile(ctx: Context) -> None:
    env = Environment(
        loader=FileSystemLoader('templates')
    )
    template = env.get_template('synth.py')
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
    env = Environment(
        loader=FileSystemLoader('templates')
    )
    template = env.get_template(template)
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

def update_stub_packages() -> None:
    print("TODO: update stub packages")

api_version = 'v1'
service = 'iamcredentials'
config_path = '/google/iam/credentials/artman_iamcredentials_{version}.yaml'
ctx = Context(
    api_version=api_version,
    service=service,
    artman_config=config_path
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
update_stub_packages(

)
