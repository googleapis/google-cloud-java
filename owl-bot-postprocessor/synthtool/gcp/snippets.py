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

import glob
import os
import re
from typing import Dict, List

OPEN_SNIPPET_REGEX = r".*\[START ([a-z0-9_]+)\].*$"
CLOSE_SNIPPET_REGEX = r".*\[END ([a-z0-9_]+)\].*$"
OPEN_EXCLUDE_REGEX = r".*\[START_EXCLUDE\].*$"
CLOSE_EXCLUDE_REGEX = r".*\[END_EXCLUDE\].*$"


def _trim_leading_whitespace(lines: List[str]) -> List[str]:
    """Trims leading, plain spaces from the snippet content. Finds the minimum
    number of leading spaces, ignoring empty lines, and removes that number of
    spaces from each line.

    Args:
        lines (List[str]): Lines of content. These lines are newline terminated.

    Returns:
        List of trimmed lines.
    """

    def number_of_leading_spaces(input: str) -> int:
        return len(input) - len(input.lstrip(" "))

    def is_empty_line(input: str) -> bool:
        if re.match(r"^\s*$", input):
            return True
        return False

    leading_spaces = [
        number_of_leading_spaces(line) for line in lines if not is_empty_line(line)
    ]
    max_leading_spaces = min(leading_spaces)
    return [
        "\n" if is_empty_line(line) else line[max_leading_spaces:] for line in lines
    ]


def all_snippets_from_file(sample_file: str) -> Dict[str, str]:
    """Reads in a sample file and parse out all contained snippets.

    Args:
        sample_file (str): Sample file to parse.

    Returns:
        Dictionary of snippet name to snippet code.
    """
    if not os.path.exists(sample_file):
        return {}

    snippet_lines = {}  # type: Dict[str, List[str]]
    open_snippets = set()
    with open(sample_file) as f:
        excluding = False
        # Iterate over each line:
        # - If the line matches an opening snippet tag, add that snippet tag to
        #   the set of open tags.
        # - If the line matches a closing snippet tag, remove that snippet tag
        #   from the set of open tags.
        # - If the line matches an opening exclude tag, record that we excluding
        #   content.
        # - If the line matches a closing exclude tag, record that we are capturing
        #   content again.
        # - Otherwise, if we are not excluding content, add the line to each of the
        #   open snippets
        #
        # This allows us to handle parsing nested or interleaved snippets and ignore
        # blocks of code in the snippets
        for line in f:
            open_match = re.match(pattern=OPEN_SNIPPET_REGEX, string=line)
            close_match = re.match(pattern=CLOSE_SNIPPET_REGEX, string=line)
            open_exclude_match = re.match(pattern=OPEN_EXCLUDE_REGEX, string=line)
            close_exclude_match = re.match(pattern=CLOSE_EXCLUDE_REGEX, string=line)
            if open_match and not excluding:
                open_snippets.add(open_match[1])
                if not open_match[1] in snippet_lines:
                    snippet_lines[open_match[1]] = []
            elif close_match and not excluding:
                open_snippets.discard(close_match[1])
            elif open_exclude_match:
                excluding = True
            elif close_exclude_match:
                excluding = False
            elif not excluding:
                for snippet in open_snippets:
                    snippet_lines[snippet].append(line)

    return {
        snippet: "".join(_trim_leading_whitespace(lines))
        for snippet, lines in snippet_lines.items()
    }


def all_snippets(snippet_globs: List[str]) -> Dict[str, str]:
    """Walks the samples directory and parses snippets from each file.

    Args:
        snippet_globs (List[str]): List of path globs to expand.

    Returns:
        Dictionary of snippet name to snippet code.
    """
    snippets = {}
    for snippet_glob in snippet_globs:
        for file in glob.glob(snippet_glob, recursive=True):
            for snippet, code in all_snippets_from_file(file).items():
                snippets[snippet] = code
    return snippets
