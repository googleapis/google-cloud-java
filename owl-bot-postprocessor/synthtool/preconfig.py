# Copyright 2020 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import functools
import os

import google.protobuf.json_format

from synthtool.protos.preconfig_pb2 import Preconfig

PRECONFIG_ENVIRONMENT_VARIABLE = "SYNTHTOOL_PRECONFIG_FILE"

PRECONFIG_HELP = """
A json file containing a description of prefetch sources that this synth.py may
us.  See preconfig.proto for detail about the format.
"""


@functools.lru_cache(maxsize=None)
def load():
    """Loads the preconfig file specified in an environment variable.

    Returns:
      An instance of Preconfig
    """
    preconfig_file_path = os.environ.get(PRECONFIG_ENVIRONMENT_VARIABLE)
    if not preconfig_file_path:
        return Preconfig()
    with open(preconfig_file_path, "rt") as json_file:
        return google.protobuf.json_format.Parse(json_file.read(), Preconfig())
