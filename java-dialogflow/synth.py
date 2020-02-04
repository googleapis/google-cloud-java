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

service = 'dialogflow'
versions = ['v2', 'v2beta1']
config_pattern = '/google/cloud/dialogflow/{version}/artman_dialogflow_{version}.yaml'

library = gapic.java_library(
    service=service,
    version='v2',
    config_path='/google/cloud/dialogflow/v2/artman_dialogflow_v2.yaml',
    artman_output_name='')

package_name = f'com.google.cloud.{service}.v2'
java.fix_proto_headers(library / f'proto-google-cloud-{service}-v2')
java.fix_grpc_headers(library / f'grpc-google-cloud-{service}-v2', package_name)

s.copy(library / f'gapic-google-cloud-{service}-v2/src', f'google-cloud-{service}/src')
s.copy(library / f'grpc-google-cloud-{service}-v2/src', f'grpc-google-cloud-{service}-v2/src')
s.copy(library / f'proto-google-cloud-{service}-v2/src', f'proto-google-cloud-{service}-v2/src')

library = gapic.java_library(
    service=service,
    version='v2beta1',
    config_path='/google/cloud/dialogflow/v2beta1/artman_dialogflow_v2beta1_java.yaml',
    artman_output_name='')

package_name = f'com.google.cloud.{service}.v2beta1'
java.fix_proto_headers(library / f'proto-google-cloud-{service}-v2beta1')
java.fix_grpc_headers(library / f'grpc-google-cloud-{service}-v2beta1', package_name)

s.copy(library / f'gapic-google-cloud-{service}-v2beta1/src', f'google-cloud-{service}/src')
s.copy(library / f'grpc-google-cloud-{service}-v2beta1/src', f'grpc-google-cloud-{service}-v2beta1/src')
s.copy(library / f'proto-google-cloud-{service}-v2beta1/src', f'proto-google-cloud-{service}-v2beta1/src')


for version in versions:
  java.format_code(f'google-cloud-{service}/src')
  java.format_code(f'grpc-google-cloud-{service}-{version}/src')
  java.format_code(f'proto-google-cloud-{service}-{version}/src')

java.common_templates()