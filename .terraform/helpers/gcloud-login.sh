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

# Perform gcloud auth login if no current credentials are available.
if gcloud auth print-access-token &>/dev/null; then
  true
else
  if ! gcloud auth login; then
    exit
  fi
fi
if gcloud auth application-default print-access-token &>/dev/null; then
  true
else
  if ! gcloud auth application-default login; then
    exit
  fi
fi
