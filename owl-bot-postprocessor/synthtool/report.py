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
import os
import pathlib
import typing

import jinja2


def make_report(
    name: str, results: typing.List[typing.Dict], log_file_dir: pathlib.Path
) -> None:
    """Write an xunit report sponge_log.xml to the specified directory.

    Arguments:
        name {str} - Name of the report
        results {typing.List[typing.Dict]} - List of synth results
          Each result has the following fields:
            name: str
            output: str
            error: bool
            skipped: bool
    """
    with open(pathlib.Path(__file__).parent / "report.xml.j2") as fh:
        template = jinja2.Template(fh.read())

    output = template.render(
        name=name,
        failures=len([result for result in results if result["error"]]),
        skips=len([result for result in results if result["skipped"]]),
        results=results,
    )
    os.makedirs(log_file_dir, exist_ok=True)
    with open(log_file_dir / "sponge_log.xml", "w") as fh:
        fh.write(output)
