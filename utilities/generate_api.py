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

# Instructions:
#
# Find the artman config file the describes the API you want to generate a client for.
# Specifiy the artman ARTIFACT_NAME to generate, e.g. "java_gapic"
#
# $ python utilities/generate_api.py PATH_TO_ARTMAN_CONFIG_FILE ARTIFACT_NAME

import argparse
import collections
import io
import os
import re
import shutil
import subprocess

from distutils import dir_util
from ruamel import yaml


dir_overrides = {
    'error-reporting': 'google-cloud-errorreporting',
    'spanner-admin-instance': 'google-cloud-spanner',
    'spanner-admin-database': 'google-cloud-spanner'
}

JAVA_PROTO="java_proto"
JAVA_GRPC="java_grpc"
JAVA_GAPIC="java_gapic"
JAVA_DISCOGAPIC="java_discogapic"


def dump_versions(config_path):
    print("Component versions:")

    print(subprocess.check_output(['artman', '--version'], stderr=subprocess.STDOUT).strip())

    print("googleapis %s" % get_git_repo_version(os.path.dirname(config_path)))
    print("google-cloud-java %s" % get_git_repo_version(os.path.dirname(__file__)))

    with io.open(os.path.expanduser("~/.artman/config.yaml"), encoding='UTF-8') as config_file:
        artman_config_data = yaml.load(config_file, Loader=yaml.Loader)
        toolkit_path = artman_config_data['local']['toolkit']
        print("gapic_generator  %s" % get_git_repo_version(toolkit_path))


def get_git_repo_version(path):
    commit = subprocess.check_output(['git', '-C', path, 'rev-parse', 'HEAD']).strip()
    suffix = ''

    changes = subprocess.check_output(['git', '-C', path, 'diff', '--stat'])

    if changes:
        suffix = " (%s)" % changes.splitlines()[-1]

    return ''.join([commit, suffix])


def run_generate_api(config_path, artifact_name, noisy=False):
    """ Generate an API client library.

    :param config_path: (str) Path to directory containing artman config file.
    :param artifact_name: (str) artman target, e.g "java_gapic".
    :param noisy: (bool) if console output should be verbose.

    """
    api_repo_index = config_path.rfind('/google/')
    if artifact_name == JAVA_DISCOGAPIC:
        api_repo_index = config_path.rfind('/gapic/')
    if api_repo_index == -1:
        raise ValueError('Didn\'t find the API repo in config file path; need absolute path to the artman config file.')
    root_dir = config_path[0:api_repo_index]
    api_dir = config_path[api_repo_index+1:]

    extra_options = []
    if noisy:
        extra_options = ['-v']

    subprocess.check_call(
        ['artman', '--config', api_dir, '--local', '--root-dir', root_dir]
        + extra_options + ['generate', artifact_name, '--aspect', 'CODE'])

    with io.open(config_path, encoding='UTF-8') as config_file:
        artman_config_data = yaml.load(config_file, Loader=yaml.Loader)

    api_name = artman_config_data['common']['api_name']
    api_version = artman_config_data['common']['api_version']
    org_name = artman_config_data['common']['organization_name']

    api_full_name = '{}-{}-{}'.format(org_name, api_name, api_version)
    proto_dirname = 'proto-{}'.format(api_full_name)
    grpc_dirname = 'grpc-{}'.format(api_full_name)
    gapic_dirname = 'gapic-{}'.format(api_full_name)

    generating_gapic = artifact_name == JAVA_GAPIC or artifact_name == JAVA_DISCOGAPIC
    generating_grpc = generating_gapic or artifact_name == JAVA_GRPC

    gapic_dir = os.path.join('artman-genfiles', 'java', gapic_dirname)
    if generating_gapic and not os.path.exists(gapic_dir):
        raise ValueError('generated gapic dir doesn\'t exist: {}'.format(gapic_dir))

    if artifact_name != JAVA_DISCOGAPIC:
        proto_dir = os.path.join('artman-genfiles', 'java', proto_dirname)
        grpc_dir = os.path.join('artman-genfiles', 'java', grpc_dirname)

        if not os.path.exists(proto_dir):
            raise ValueError('generated proto dir doesn\'t exist: {}'.format(proto_dir))
        if generating_grpc and not os.path.exists(grpc_dir):
            raise ValueError('generated grpc dir doesn\'t exist: {}'.format(grpc_dir))

        target_proto_dir = os.path.join('google-api-grpc', proto_dirname)
        target_proto_code_dir = os.path.join(target_proto_dir, 'src')
        if os.path.exists(target_proto_code_dir):
            print('{} already exists, removing & replacing it.'.format(target_proto_code_dir))
            shutil.rmtree(target_proto_code_dir)
        dir_util.copy_tree(proto_dir, target_proto_dir)

        if generating_grpc:
            target_grpc_dir = os.path.join('google-api-grpc', grpc_dirname)
            target_grpc_code_dir = os.path.join(target_grpc_dir, 'src')
            if os.path.exists(target_grpc_code_dir):
                print('{} already exists, removing & replacing it.'.format(target_grpc_code_dir))
                shutil.rmtree(target_grpc_code_dir)
            dir_util.copy_tree(grpc_dir, target_grpc_dir)

    if generating_gapic:
        api_unversioned_name = '{}-{}'.format(org_name, api_name)
        if api_name in dir_overrides:
            api_unversioned_name = dir_overrides[api_name]

        target_gapic_dir = os.path.join('google-cloud-clients', api_unversioned_name)
        dir_util.copy_tree(os.path.join(gapic_dir, 'src'), os.path.join(target_gapic_dir, 'src'))

    if noisy:
        print('**** REMAINING MANUAL WORK: *****')
        print('This script doesn\'t set up new clients. If this is a new client, you need to:')
        print('1. Add the new proto and grpc modules into google-api-grpc/pom.xml')
        print('2. Add version declarations for the proto and grpc modules in google-api-grpc/pom.xml')
        print('3. Copy an existing client pom.xml to the new client directory, update its text')
        print('4. Copy an existing client README.md to the new client directory, update its text')
        print('5. Add the new proto, grpc, and client modules into versions.txt')
        print('6. Add the new proto, grpc, and client modules into google-cloud-bom/pom.xml')
        print('7. Add the API to the list in the root README.md')
        print('8. Add the client module into the list in google-cloud-clients/pom.xml')
        print('9. Add the stub package for the client into the stubs list in google-cloud-clients/pom.xml')
        print('10. Run `utilities/replace_versions.py` to update the module versions')

def main():
    parser = argparse.ArgumentParser(description='Regenerate a single API.')
    parser.add_argument('config_file', help='The artman config file for the API')
    parser.add_argument('artifact_name', help='The artman artifact type',
                        default="java_gapic")
    parser.add_argument('--quiet', action="store_true", default=False,
                        help='Don\'t print informational instructions')
    args = parser.parse_args()

    dump_versions(args.config_file)

    run_generate_api(args.config_file, args.artifact_name, not args.quiet)

if __name__ == '__main__':
    main()
