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

"""Tracked paths.

This is a bit of a hack.
"""

import pathlib


_tracked_paths = []


def add(path):
    _tracked_paths.append(pathlib.Path(path))
    # Reverse sort the list, so that the deepest paths get matched first.
    _tracked_paths.sort(key=lambda s: -len(str(s)))


def relativize(path):
    path = pathlib.Path(path)
    for tracked_path in _tracked_paths:
        try:
            return path.relative_to(tracked_path)
        except ValueError:
            pass
    raise ValueError(f"The root for {path} is not tracked.")
