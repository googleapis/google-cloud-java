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

gapic = gcp.GAPICGenerator()
common_templates = gcp.CommonTemplates()

library = gapic.java_library(
    service='websecurityscanner',
    version='v1alpha',
    config_path='/google/cloud/websecurityscanner/artman_websecurityscanner_v1alpha.yaml',
    artman_output_name='')

s.copy(library / 'gapic-google-cloud-websecurityscanner-v1alpha/src', 'src')
s.copy(library / 'grpc-google-cloud-websecurityscanner-v1alpha/src', '../../google-api-grpc/grpc-google-cloud-websecurityscanner-v1alpha/src')
s.copy(library / 'proto-google-cloud-websecurityscanner-v1alpha/src', '../../google-api-grpc/proto-google-cloud-websecurityscanner-v1alpha/src')
