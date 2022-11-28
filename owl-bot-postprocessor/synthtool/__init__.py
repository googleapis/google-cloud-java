# Copyright 2018 Google LLC
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

"""Synthtool synthesizes libraries from disparate sources."""

import sys

from synthtool.transforms import (
    move,
    replace,
    dont_overwrite,
    get_staging_dirs,
    remove_staging_dirs,
)
from synthtool.log import logger

copy = move

__all__ = [
    "copy",
    "move",
    "replace",
    "dont_overwrite",
    "get_staging_dirs",
    "remove_staging_dirs",
]

# Make sure that synthtool is being used instead of running the synth file
# directly
_main_module = sys.modules["__main__"]
if hasattr(_main_module, "__file__") and "synthtool" not in _main_module.__file__:
    logger.critical(
        "You are running the synthesis script directly, this will be disabled in a future release of Synthtool. Please use python3 -m synthtool instead."
    )
