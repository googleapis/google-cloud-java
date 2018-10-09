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

# This scripts creates sites for `google-cloud-clients` and `google-api-grpc`
# modules and commits (but does not push) them to gh-pages branch of
# googleapis/google-cloud-java github repository.

# Usage:
#   python utilities/stage_sites.py

import subprocess
import sys


def stage_sites(sites, gh_pages, git_url, top_site_url):
  _run(['git', 'clone', '--branch', 'gh-pages', '--single-branch', git_url,
        gh_pages])
  _run(['mkdir', '-p', gh_pages])
  for site in sites:
    _create_site(site, gh_pages, top_site_url)
  _run(['git', 'add', '.'], gh_pages)
  _run(['git', 'commit', '-m',
        "Regenerate documentation for %s. [ci skip]" % ', '.join(sites)],
       gh_pages)


def _create_site(site_name, gh_pages, top_site_url):
  _run(['mvn', 'site'], site_name)
  _run(['mvn', 'site:stage', '-q',
        "-DtopSiteURL=%s/%s" % (top_site_url, site_name)],
       site_name)
  _run(['rm', '-rf', site_name], gh_pages)
  _run(['cp', '-r', "%s/target/staging/site/%s" % (site_name, site_name),
        gh_pages])


def _run(command, cwd=None):
  print("\033[1;36mExecute command:\033[0m %s" % ' '.join(command))
  subprocess.check_call(command, cwd=cwd, stdout=sys.stdout, stderr=sys.stderr)


if __name__ == '__main__':
  stage_sites(['google-api-grpc', 'google-cloud-clients'], 'tmp_gh-pages',
              'git@github.com:googleapis/google-cloud-java.git',
              'https://googleapis.github.io/google-cloud-java')
