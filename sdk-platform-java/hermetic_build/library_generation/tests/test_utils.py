# Copyright 2024 Google LLC
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
import unittest
from difflib import unified_diff
from pathlib import Path

from typing import List


class FileComparator(unittest.TestCase):
    def compare_files(self, expect: str, actual: str):
        with open(expect, "r") as f:
            expected_lines = f.readlines()
        with open(actual, "r") as f:
            actual_lines = f.readlines()

        diff = list(unified_diff(expected_lines, actual_lines))
        self.assertEqual(
            first=[], second=diff, msg="Unexpected file contents:\n" + "".join(diff)
        )


def cleanup(files: List[str]):
    for file in files:
        path = Path(file).resolve()
        if path.is_file():
            path.unlink()
        elif path.is_dir():
            path.rmdir()
