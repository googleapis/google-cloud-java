# Copyright 2020 Google LLC
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

"""This script is used to synthesize generated parts of this library."""

from typing import List, Optional
from glob import glob
import json

class CloudClient:
  repo: str = None
  title: str = None
  release_level: str = None
  group_id: str = "com.google.cloud"
  artifact_id: str = None

  def __init__(self, repo: dict):
    self.repo = repo['repo']
    # For now, strip out "Google Cloud" to standardize the titles
    self.title = repo['name_pretty'].replace("Google ", "").replace("Cloud ", "")
    self.release_level = repo['release_level']
    artifact_parts = repo['distribution_name'].split(':')
    if len(artifact_parts) > 1:
      self.group_id = artifact_parts[0]
      self.artifact_id = artifact_parts[1]
    else:
      self.artifact_id = repo['distribution_name']

  # For sorting, we want to sort by release level, then API pretty_name
  def __lt__(self, other):
    if self.release_level == other.release_level:
      if self.title == other.title:
        return (self.artifact_id or "") < (other.artifact_id or "")
      return self.title < other.title

    return other.release_level < self.release_level

  def __repr__(self):
    return repr((self.release_level, self.title))

def replace_content_in_readme(content_rows: List[str]) -> None:
  START_MARKER = "[//]: # (API_TABLE_START)"
  END_MARKER = "[//]: # (API_TABLE_END)"
  newlines = []
  repl_open = False
  with open("README.md", "r") as f:
    for line in f:
      if not repl_open:
        newlines.append(line)

      if line.startswith(START_MARKER):
        repl_open = True
        newlines = newlines + content_rows
      elif line.startswith(END_MARKER):
        newlines.append("\n")
        newlines.append(line)
        repl_open = False

  with open("README.md", "w") as f:
    for line in newlines:
      f.write(line)

RELEASE_LEVEL_CONTENT = {
  "preview": "[![preview][preview-stability]][preview-description]",
  "stable": "[![stable][stable-stability]][stable-description]"
}

def client_row(client: CloudClient) -> str:
  maven_badge = f"[![Maven](https://img.shields.io/maven-central/v/{client.group_id}/{client.artifact_id}.svg)](https://search.maven.org/search?q=g:{client.group_id}%20AND%20a:{client.artifact_id}&core=gav)"
  return f"| [{client.title}](https://github.com/{client.repo}) | {RELEASE_LEVEL_CONTENT[client.release_level]} | {maven_badge} |\n"

def generate_table_contents(clients: List[CloudClient]) -> List[str]:
  content_rows = [
    "\n",
    "| Client | Release Level | Version |\n",
    "| ------ | ------------- | ------- |\n",
  ]
  return content_rows + [client_row(client) for client in clients]


def client_for_module(module) -> Optional[CloudClient]:
  with open ('%s/.repo-metadata.json' % module, "r") as metadata_file:
    data = json.load(metadata_file)
    data['repo'] = 'googleapis/google-cloud-java/tree/main/%s' % module
    return CloudClient(data)

# These repositories are not meant as shown as Cloud SDK for Java
REPO_EXCLUSION = [
  'java-bigtable-emulator',
  'java-cloud-bom',
  'java-conformance-tests',
  'java-common-protos',
  'java-core',
  'java-gcloud-maven-plugin',
  'java-grafeas',
  'java-notification',
  'java-shared-config',
  'java-shared-dependencies',
  'java-samples',
  'java-showcase',
  'java-vertexai'
]

LIBRARIES_IN_MONOREPO = glob("java-*")

def all_clients() -> List[CloudClient]:
  clients = []
  for module in sorted(LIBRARIES_IN_MONOREPO):
    if module not in REPO_EXCLUSION:
      client = client_for_module(module)
      if client:
        clients.append(client)

  return clients


clients = sorted(all_clients())
table_contents = generate_table_contents(clients)
replace_content_in_readme(table_contents)
