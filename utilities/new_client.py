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

import sys, os
from jinja2 import Environment, FileSystemLoader
from lxml import etree as ElementTree

namespaces = {
    'pom': 'http://maven.apache.org/POM/4.0.0'
}

class PomBuilder(ElementTree.TreeBuilder):
    def comment(self, data):
        self.start(ElementTree.Comment, {})
        self.data(data)
        self.end(ElementTree.Comment)

def add_module_to_pom(pom: str, module_name: str) -> None:
    parser = ElementTree.XMLParser()
    tree = ElementTree.parse(pom, parser)#, ElementTree.XMLParser(target=PomBuilder()))
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

    tree.write(pom, pretty_print=True)#, default_namespace='http://maven.apache.org/POM/4.0.0')

def write_synthfile(path: str, versions: str, service: str, config_path: str) -> None:
    env = Environment(
        loader=FileSystemLoader('templates')
    )
    template = env.get_template('synth.py')
    synth = template.stream(
        versions=str(versions),
        service=service,
        config_path=config_path,
    )

    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    synth.dump(path)

def write_cloud_pom(path: str, api_version: str, version: str, service: str, name: str, description: str) -> None:
    env = Environment(
        loader=FileSystemLoader('templates')
    )
    template = env.get_template('pom.xml')
    pom = template.stream(
        api_version=api_version,
        description=description,
        name=name,
        service=service,
        version=version
    )
    directory = os.path.dirname(path)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    pom.dump(path)

def run_synthtool() -> None:
    print("TODO: run synthtool")

root_directory = os.path.dirname(os.path.realpath(os.path.join('..', __file__)))
versions = ['v1']
service = 'iamcredentials'
config_path = '/google/iam/credentials/artman_iamcredentials_{version}.yaml'

add_module_to_pom(
    pom=os.path.join(root_directory, 'google-cloud-clients/pom.xml'),
    module_name='google-cloud-iamcredentials'
)
write_synthfile(
    path=os.path.join(root_directory, 'google-cloud-clients/google-cloud-iamcredentials/synth.py'),
    versions=versions,
    service=service,
    config_path=config_path
)
write_cloud_pom(
    path=os.path.join(root_directory, 'google-cloud-clients/google-cloud-iamcredentials/pom.xml'),
    api_version='v1',
    version='0.71.1-alpha-SNAPSHOT',
    service='iamcredentials',
    description='FIXME',
    name='FIXME',
)
run_synthtool()