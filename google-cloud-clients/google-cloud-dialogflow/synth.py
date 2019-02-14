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

library = gapic.java_library(
    service='dialogflow',
    version='v2',
    config_path=f'/google/cloud/dialogflow/artman_dialogflow_v2.yaml',
    artman_output_name='')

s.copy(library / f'gapic-google-cloud-dialogflow-v2/src', 'src')
s.copy(library / f'grpc-google-cloud-dialogflow-v2/src', f'../../google-api-grpc/grpc-google-cloud-dialogflow-v2/src')
s.copy(library / f'proto-google-cloud-dialogflow-v2/src', f'../../google-api-grpc/proto-google-cloud-dialogflow-v2/src')

# v2beta1 has a weird config name
library = gapic.java_library(
    service='dialogflow',
    version='v2beta1',
    config_path=f'/google/cloud/dialogflow/artman_dialogflow_v2beta1_java.yaml',
    artman_output_name='')

s.copy(library / f'gapic-google-cloud-dialogflow-v2beta1/src', 'src')
s.copy(library / f'grpc-google-cloud-dialogflow-v2beta1/src', f'../../google-api-grpc/grpc-google-cloud-dialogflow-v2beta1/src')
s.copy(library / f'proto-google-cloud-dialogflow-v2beta1/src', f'../../google-api-grpc/proto-google-cloud-dialogflow-v2beta1/src')

java.format_code('./src')
java.format_code(f'../../google-api-grpc/grpc-google-cloud-dialogflow-v2/src')
java.format_code(f'../../google-api-grpc/proto-google-cloud-dialogflow-v2/src')
java.format_code(f'../../google-api-grpc/grpc-google-cloud-dialogflow-v2beta1/src')
java.format_code(f'../../google-api-grpc/proto-google-cloud-dialogflow-v2beta1/src')
