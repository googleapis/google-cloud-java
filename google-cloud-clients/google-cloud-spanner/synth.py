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
    service='spanner',
    version='v1',
    config_path='/google/spanner/artman_spanner.yaml',
    artman_output_name='')

s.copy(library / 'gapic-google-cloud-spanner-v1/src', 'src')
s.copy(library / 'grpc-google-cloud-spanner-v1/src', '../../google-api-grpc/grpc-google-cloud-spanner-v1/src')
s.copy(library / 'proto-google-cloud-spanner-v1/src', '../../google-api-grpc/proto-google-cloud-spanner-v1/src')

library = gapic.java_library(
    service='spanner',
    version='v1',
    config_path='/google/spanner/admin/database/artman_spanner_admin_database.yaml',
    artman_output_name='')

s.copy(library / 'gapic-google-cloud-spanner-admin-database-v1/src', 'src')
s.copy(library / 'grpc-google-cloud-spanner-admin-database-v1/src', '../../google-api-grpc/grpc-google-cloud-spanner-admin-database-v1/src')
s.copy(library / 'proto-google-cloud-spanner-admin-database-v1/src', '../../google-api-grpc/proto-google-cloud-spanner-admin-database-v1/src')

library = gapic.java_library(
    service='spanner',
    version='v1',
    config_path='/google/spanner/admin/instance/artman_spanner_admin_instance.yaml',
    artman_output_name='')

s.copy(library / 'gapic-google-cloud-spanner-admin-instance-v1/src', 'src')
s.copy(library / 'grpc-google-cloud-spanner-admin-instance-v1/src', '../../google-api-grpc/grpc-google-cloud-spanner-admin-instance-v1/src')
s.copy(library / 'proto-google-cloud-spanner-admin-instance-v1/src', '../../google-api-grpc/proto-google-cloud-spanner-admin-instance-v1/src')

java.format_code('./src')
java.format_code(f'../../google-api-grpc/grpc-google-cloud-spanner-v1/src')
java.format_code(f'../../google-api-grpc/proto-google-cloud-spanner-v1/src')
java.format_code(f'../../google-api-grpc/grpc-google-cloud-spanner-admin-database-v1/src')
java.format_code(f'../../google-api-grpc/proto-google-cloud-spanner-admin-database-v1/src')
java.format_code(f'../../google-api-grpc/grpc-google-cloud-spanner-admin-instance-v1/src')
java.format_code(f'../../google-api-grpc/proto-google-cloud-spanner-admin-instance-v1/src')
