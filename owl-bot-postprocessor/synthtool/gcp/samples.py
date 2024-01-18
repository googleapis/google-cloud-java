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
import re
import os
import yaml
from typing import List, Dict
from synthtool.log import logger


def _read_sample_metadata_comment(sample_file: str) -> Dict:
    """Additional meta-information can be provided through embedded comments:

    // sample-metadata:
    //   title: ACL (Access Control)
    //   description: Demonstrates setting access control rules.
    //   usage: node iam.js --help
    """
    sample_metadata = {}  # type: Dict[str, str]
    with open(sample_file) as f:
        contents = f.read()
        match = re.search(
            r"(?P<metadata>// *sample-metadata:([^\n]+|\n//)+)", contents, re.DOTALL
        )
        if match:
            # the metadata yaml is stored in a comments, remove the
            # prefix so that we can parse the yaml contained.
            sample_metadata_string = re.sub(r"((#|//) ?)", "", match.group("metadata"))
            try:
                sample_metadata = yaml.load(
                    sample_metadata_string, Loader=yaml.SafeLoader
                )["sample-metadata"]
            except yaml.scanner.ScannerError:
                # warn and continue on bad metadata
                logger.warning(f"bad metadata detected in {sample_file}")
    return sample_metadata


def _sample_metadata(file: str) -> Dict[str, str]:
    metadata = {
        "title": _decamelize(os.path.splitext(os.path.basename(file))[0]),
        "file": file,
    }
    return {**metadata, **_read_sample_metadata_comment(file)}


def all_samples(sample_globs: List[str]) -> List[Dict[str, str]]:
    """Walks samples directory and builds up samples data-structure

    Args:
        sample_globs: (List[str]): List of path globs to search for samples

    Returns:
        A list of sample metadata in the format:
        {
            "title": "Requester Pays",
            "file": "samples/requesterPays.js"
        }
        The file path is the relative path from the repository root.
    """
    files = []
    for sample_glob in sample_globs:
        for file in glob.glob(sample_glob, recursive=True):
            files.append(file)
    return [_sample_metadata(file) for file in sorted(files)]


def _decamelize(value: str):
    """Parser to convert fooBar.js to Foo Bar."""
    if not value:
        return ""
    str_decamelize = re.sub("^.", value[0].upper(), value)  # apple -> Apple.
    str_decamelize = re.sub(
        "([A-Z]+)([A-Z])([a-z0-9])", r"\1 \2\3", str_decamelize
    )  # ACLBatman -> ACL Batman.
    return re.sub("([a-z0-9])([A-Z])", r"\1 \2", str_decamelize)  # FooBar -> Foo Bar.
