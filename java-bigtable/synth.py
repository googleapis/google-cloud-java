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

"""This script is used to synthesize generated parts of this library."""

import re
import synthtool as s
import synthtool.gcp as gcp
import synthtool.languages.java as java

# TODO: try to move the GAPIC surface hiding to the gapic-generator:
# https://github.com/googleapis/gapic-generator/issues/2742

def main():
  gapic = gcp.GAPICGenerator()

  # License header
  license = """
  /*
   * Copyright 2019 Google LLC
   *
   * Licensed under the Apache License, Version 2.0 (the "License");
   * you may not use this file except in compliance with the License.
   * You may obtain a copy of the License at
   *
   *     https://www.apache.org/licenses/LICENSE-2.0
   *
   * Unless required by applicable law or agreed to in writing, software
   * distributed under the License is distributed on an "AS IS" BASIS,
   * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   * See the License for the specific language governing permissions and
   * limitations under the License.
   */
  """

  generate_data_api(gapic, license)
  generate_admin_api(gapic, license)

  java.format_code(f'./google-cloud-bigtable/src')

  java.common_templates(excludes=[
    '.gitignore',
    'README.md',
    '.kokoro/presubmit/integration.cfg',
    # todo remove once template is updated
    '.github/ISSUE_TEMPLATE/bug_report.md',
    'CONTRIBUTING.md',
  ])

def generate_data_api(gapic, license):
  library = gapic.java_library(
    service='bigtable',
    version='v2',
    config_path='/google/bigtable/artman_bigtable.yaml',
    artman_output_name='')

  # Excludes are relative to source `gapic-google-cloud-bigtable-v2/src`
  excludes = [
    "build.gradle",
    "pom.xml",
    "README.md",
    "src/main/java/com/google/cloud/bigtable/data/v2/package-info.java",
    "src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClient.java",
    "src/main/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataSettings.java",
    "src/test/java/com/google/cloud/bigtable/data/v2/BaseBigtableDataClientTest.java",
    "src/test/java/com/google/cloud/bigtable/data/v2/MockBigtable.java",
    "src/test/java/com/google/cloud/bigtable/data/v2/MockBigtableImpl.java",
  ]

  # Paths are relative to the destination, which is the current working directory
  internal_only = [
    "google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/BigtableStub.java",
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/BigtableStubSettings.java',
    "google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/GrpcBigtableStub.java",
    "google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/stub/GrpcBigtableCallableFactory.java",
  ]

  package_name = f'com.google.cloud.bigtable.v2'
  java.fix_proto_headers(library / f'proto-google-cloud-bigtable-v2')
  # java.fix_grpc_headers(library / f'grpc-google-cloud-bigtable-v2', package_name)

  ##todo replace with fix_grpc_headers
  s.replace(
      library / f'grpc-google-cloud-bigtable-v2/src/**/*.java',
      f"package com.google.bigtable.v2;",
      f"{license}package com.google.bigtable.v2;"
  )
  s.copy(library / f'gapic-google-cloud-bigtable-v2', 'google-cloud-bigtable/', excludes=excludes)
  s.copy(library / f'grpc-google-cloud-bigtable-v2/src', f'grpc-google-cloud-bigtable-v2/src')
  s.copy(library / f'proto-google-cloud-bigtable-v2/src', f'proto-google-cloud-bigtable-v2/src')

  make_internal_only(internal_only)

  java.format_code(f'./grpc-google-cloud-bigtable-v2/src')
  java.format_code(f'./proto-google-cloud-bigtable-v2/src')


def generate_admin_api(gapic, license):
  library = gapic.java_library(
      service='bigtable-admin',
      version='v2',
      config_path='/google/bigtable/admin/artman_bigtableadmin.yaml',
      artman_output_name='')

  # Excludes are relative to source `gapic-google-cloud-bigtable-v2/src`
  excludes = [
    "main/java/com/google/cloud/bigtable/admin/v2/package-info.java",
  ]

  # Paths are relative to the destination, which is the current working directory
  internal_only = [
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/GrpcBigtableInstanceAdminCallableFactory.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/GrpcBigtableInstanceAdminStub.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/BaseBigtableInstanceAdminSettings.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/GrpcBigtableTableAdminCallableFactory.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/GrpcBigtableTableAdminStub.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/BaseBigtableTableAdminSettings.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/BigtableInstanceAdminStub.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/stub/BigtableTableAdminStub.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/BaseBigtableInstanceAdminClient.java',
    'google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/admin/v2/BaseBigtableTableAdminClient.java',
  ]

  package_name = f'com.google.cloud.bigtable.admin.v2'
  java.fix_proto_headers(library / f'proto-google-cloud-bigtable-admin-v2')
  # java.fix_grpc_headers(library / f'grpc-google-cloud-bigtable-admin-v2', package_name)

  ##todo replace with fix_grpc_headers
  s.replace(
      library / f'grpc-google-cloud-bigtable-admin-v2/src/**/*.java',
      f"package com.google.bigtable.admin.v2;",
      f"{license}package com.google.bigtable.admin.v2;"
  )

  s.copy(library / f'gapic-google-cloud-bigtable-admin-v2/src', 'google-cloud-bigtable/src', excludes=excludes)
  s.copy(library / f'grpc-google-cloud-bigtable-admin-v2/src', f'grpc-google-cloud-bigtable-admin-v2/src')
  s.copy(library / f'proto-google-cloud-bigtable-admin-v2/src', f'proto-google-cloud-bigtable-admin-v2/src')

  make_internal_only(internal_only)

  java.format_code(f'./grpc-google-cloud-bigtable-admin-v2/src')
  java.format_code(f'./proto-google-cloud-bigtable-admin-v2/src')


def make_internal_only(sources):
  """Annotates all toplevel classes with `@InternalOnly`"""
  # Insert InternalOnly import in the non-static.
  s.replace(sources,
            before=r'^(import (?!static).*?\n)\n',
            after=r'\1import com.google.api.core.InternalApi;\n\n',
            flags=re.MULTILINE | re.DOTALL)

  # Replace javadoc and annotations before every public class with InternalApi
  # javadoc and annotation
  s.replace(sources,

            before=r'/\*\*.+?\*/\n(?:^@[^\n]*\n)*(?=public [a-zA-B ]*class)',
            after='/** For internal use only. */\n@Generated("by gapic-generator")\n@InternalApi\n',
            flags=re.MULTILINE | re.DOTALL)

main()
