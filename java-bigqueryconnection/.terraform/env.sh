#!/bin/bash
#
# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Current working directory will be <repo-root>/.terraform/
source ./helpers/get-module-output.sh

MY_SQL_DATABASE=$(getModuleOutput java-bigqueryconnection db_name)
echo "Setting environment variable MY_SQL_DATABASE=$MY_SQL_DATABASE"
export MY_SQL_DATABASE

MY_SQL_INSTANCE=$(getModuleOutput java-bigqueryconnection db_instance)
echo "Setting environment variable MY_SQL_INSTANCE=$MY_SQL_INSTANCE"
export MY_SQL_INSTANCE

echo "Setting environment variable DB_PWD=<sensitive>"
DB_PWD=$(getModuleOutput java-bigqueryconnection db_password)
export DB_PWD

echo "Setting environment variable DB_USER=default"
export DB_USER="default"
