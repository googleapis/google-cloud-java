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

# Use case: Bump to the next patch release version in preparation for a release
#
#    python utilities/bump_versions.py next_release patch
#
# Use case: Bump to the next minor release version in preparation for a release
#
#    python utilities/bump_versions.py next_release minor
#
# Use case: Bump to the next snapshot version in preparation for new development
#
#    python utilities/bump_versions.py next_snapshot patch
#
# This script will update versions.txt in place.
# The script must be run at the root of google-cloud-java.

import argparse
import copy
import re

version_regex = re.compile(r'(\d+)\.(\d+)\.(\d+)(-\w+)?(-\w+)?')

class Version:
    def __init__(self, version_str):
        match = version_regex.match(version_str)
        major = int(match.group(1))
        minor = int(match.group(2))
        patch = int(match.group(3))
        qualifier1 = match.group(4)
        qualifier2 = match.group(5)
        variant = ''
        snapshot = False
        if qualifier1 and qualifier2:
            if qualifier2 == '-SNAPSHOT':
                variant = qualifier1
                snapshot = True
            else:
                variant = qualifier1 + qualifier2
        elif qualifier1:
            if qualifier1 == '-SNAPSHOT':
                snapshot = True
            else:
                variant = qualifier1
        self.major = major
        self.minor = minor
        self.patch = patch
        self.variant = variant
        self.snapshot = snapshot

    def bump(self, bump_type):
        if bump_type == 'minor':
            self.bump_minor()
        elif bump_type == 'patch':
            self.bump_patch()
        else:
            raise ValueError('invalid bump_type: {}'.format(bump_type))

    def bump_minor(self):
        self.minor += 1
        self.patch = 0

    def bump_patch(self):
        self.patch += 1

    def set_snapshot(self, snapshot):
        self.snapshot = snapshot

    def __str__(self):
        mmp = '{}.{}.{}'.format(self.major, self.minor, self.patch)
        postfix = self.variant
        if self.snapshot:
            postfix += '-SNAPSHOT'
        return mmp + postfix

def bump_versions(next_version_type, bump_type):
    newlines = []
    with open('versions.txt') as f:
        for line in f:
            version_line = line.strip()
            if not version_line or version_line.startswith('#'):
                newlines.append(line)
                continue

            (module, released_version_str, current_version_str) = version_line.split(':')
            released_version = Version(released_version_str)

            if next_version_type == 'next_release':
                released_version.bump(bump_type)
                released_version.set_snapshot(False)
                current_version = copy.deepcopy(released_version)
            elif next_version_type == 'next_snapshot':
                current_version = copy.deepcopy(released_version)
                current_version.bump(bump_type)
                current_version.set_snapshot(True)
            else:
                raise ValueError('invalid next_version_type: {}'.format(next_version_type))

            newlines.append('{}:{}:{}\n'.format(module, released_version, current_version))

    with open('versions.txt', 'w') as f:
        for line in newlines:
            f.write(line)

def main():
    parser = argparse.ArgumentParser(description='Add snippets to Javadoc.')
    parser.add_argument('next_version_type', help='Either next_snapshot or next_release')
    parser.add_argument('bump_type', help='Either minor or patch')
    args = parser.parse_args()

    bump_versions(args.next_version_type, args.bump_type)

if __name__ == '__main__':
    main()
