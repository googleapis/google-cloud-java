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

printf "Setting environment variables MY_SQL_DATABASE, MY_SQL_INSTANCE, DB_USER, and DB_PWD."

MY_SQL_DATABASE=$(terraform output -raw db_name)
export MY_SQL_DATABASE

MY_SQL_INSTANCE=$(terraform output -raw db_instance)
export MY_SQL_INSTANCE

DB_PWD=$(terraform output -raw db_password)
export DB_PWD

export DB_USER="default"
