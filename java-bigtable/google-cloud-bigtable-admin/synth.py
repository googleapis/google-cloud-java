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

import synthtool as s
import synthtool.gcp as gcp
import synthtool.languages.java as java

gapic = gcp.GAPICGenerator()

service = 'bigtable-admin'
versions = ['v2']
config_pattern = '/google/bigtable/admin/artman_bigtableadmin.yaml'

for version in versions:
  library = gapic.java_library(
      service=service,
      version=version,
      config_path=config_pattern.format(version=version),
      artman_output_name='')

  s.copy(library / f'gapic-google-cloud-{service}-{version}/src', 'src')
  s.copy(library / f'grpc-google-cloud-{service}-{version}/src', f'../../google-api-grpc/grpc-google-cloud-{service}-{version}/src')
  s.copy(library / f'proto-google-cloud-{service}-{version}/src', f'../../google-api-grpc/proto-google-cloud-{service}-{version}/src')

  java.format_code('./src')
  java.format_code(f'../../google-api-grpc/grpc-google-cloud-{service}-{version}/src')
  java.format_code(f'../../google-api-grpc/proto-google-cloud-{service}-{version}/src')
