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
#
# $ python utilities/generate_api.py PATH_TO_ARTMAN_CONFIG_FILE java_gapic

import argparse
import io
import os
import shutil
import subprocess

from distutils import dir_util
from ruamel import yaml


dir_overrides = {
    'bigtable-admin': 'google-cloud-bigtable',
    'error-reporting': 'google-cloud-errorreporting',
    'spanner-admin-instance': 'google-cloud-spanner',
    'spanner-admin-database': 'google-cloud-spanner'
}


def run_generate_api(config_path, artifact_type, root_dir=None, has_proto_libs=True, noisy=False):
    """ Generate an API client library.

    :param config_path: (str) Path to directory containing artman config file.
    :param artifact_type: (str) artman target, e.g "java_gapic".
    :param root_dir: (str) Path to the directory containing the API definitions.
    :param has_proto_libs: (bool) if the generated proto and grpc libraries
              should replace the existing ones
    :param noisy: (bool) if console output should be verbose.

    """
    googleapis_index = config_path.rfind('/google/')
    if googleapis_index == -1:
        raise ValueError('Didn\'t find /googleapis/ in config file path; need absolute path to the artman config file.')
    if has_proto_libs:
        root_dir = config_path[0:googleapis_index]
        api_dir = config_path[googleapis_index+1:]
    else:
        api_dir = config_path

    extra_options = []
    if noisy:
        extra_options = ['-v']

    print("api_dir: "+ api_dir)
    print("root_dir: "+ root_dir)
    subprocess.check_call(['artman', '--config', api_dir, '--local', '--root-dir', root_dir] + extra_options + ['generate', artifact_type])

    with io.open(config_path, encoding='UTF-8') as config_file:
        artman_config_data = yaml.load(config_file, Loader=yaml.Loader)

    api_name = artman_config_data['common']['api_name']
    api_version = artman_config_data['common']['api_version']
    org_name = artman_config_data['common']['organization_name']

    api_full_name = '{}-{}-{}'.format(org_name, api_name, api_version)
    proto_dirname = 'proto-{}'.format(api_full_name)
    grpc_dirname = 'grpc-{}'.format(api_full_name)
    gapic_dirname = 'gapic-{}'.format(api_full_name)

    gapic_dir = os.path.join('artman-genfiles', 'java', gapic_dirname)
    if not os.path.exists(gapic_dir):
        raise ValueError('generated gapic dir doesn\'t exist: {}'.format(gapic_dir))

    if has_proto_libs:
        proto_dir = os.path.join('artman-genfiles', 'java', proto_dirname)
        grpc_dir = os.path.join('artman-genfiles', 'java', grpc_dirname)

        if not os.path.exists(proto_dir):
            raise ValueError('generated proto dir doesn\'t exist: {}'.format(proto_dir))
        if not os.path.exists(grpc_dir):
            raise ValueError('generated grpc dir doesn\'t exist: {}'.format(grpc_dir))

        target_proto_dir = os.path.join('google-api-grpc', proto_dirname)
        target_grpc_dir = os.path.join('google-api-grpc', grpc_dirname)
        if os.path.exists(target_proto_dir):
            print('{} already exists, removing & replacing it.'.format(target_proto_dir))
        if os.path.exists(target_grpc_dir):
            print('{} already exists, removing & replacing it.'.format(target_grpc_dir))

        print('-- ignore any pathspec errors that follow')

        if os.path.exists(target_proto_dir):
            shutil.rmtree(target_proto_dir)
        shutil.copytree(proto_dir, target_proto_dir)
        os.remove(os.path.join(target_proto_dir, 'LICENSE'))
        os.remove(os.path.join(target_proto_dir, 'build.gradle'))
        subprocess.call(['git', 'checkout', os.path.join(target_proto_dir, 'pom.xml')])

        if os.path.exists(target_grpc_dir):
            shutil.rmtree(target_grpc_dir)
        shutil.copytree(grpc_dir, target_grpc_dir)
        os.remove(os.path.join(target_grpc_dir, 'LICENSE'))
        os.remove(os.path.join(target_grpc_dir, 'build.gradle'))
        subprocess.call(['git', 'checkout', os.path.join(target_grpc_dir, 'pom.xml')])

    api_unversioned_name = '{}-{}'.format(org_name, api_name)
    if api_name in dir_overrides:
        api_unversioned_name = dir_overrides[api_name]

    target_gapic_dir = os.path.join('google-cloud-clients', api_unversioned_name)
    dir_util.copy_tree(os.path.join(gapic_dir, 'src'), os.path.join(target_gapic_dir, 'src'))

    if noisy:
        print('**** REMAINING MANUAL WORK: *****')
        print('This script doesn\'t set up new clients. If this is a new client, you need to:')
        print('1. Add the new proto and grpc modules into google-api-grpc/pom.xml')
        print('3. Copy an existing client pom.xml to the new client directory, update its text')
        print('4. Copy an existing client README.md to the new client directory, update its text')
        print('5. Add the new proto, grpc, and client modules into versions.txt')
        print('6. Add the new proto, grpc, and client modules into google-cloud-bom/pom.xml')
        print('7. Run `utilities/replace_versions.py` to update the module versions')

def main():
    parser = argparse.ArgumentParser(description='Regenerate a single API.')
    parser.add_argument('config_file', help='The artman config file for the API')
    parser.add_argument('artifact_type', help='The artman artifact type',
                        default="java_gapic")
    parser.add_argument('--quiet', action="store_true", default=False,
                        help='Don\'t print informational instructions')
    args = parser.parse_args()

    run_generate_api(args.config_file, args.artifact_type, not args.quiet)

if __name__ == '__main__':
    main()
