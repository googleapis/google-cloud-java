# Copyright 2023 Google LLC
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
import json
from typing import List
import os
from pathlib import Path

import click
import jinja2


@click.command()
@click.option(
    "--folder",
    help="Path to folder of templates",
)
@click.option("--file", help="Path to template file")
@click.option(
    "--data",
    help="Path to JSON file with template values",
    multiple=True,
    required=True,
)
@click.option(
    "--output",
    help="Path to output",
    default=".",
)
def main(folder: str, file: str, data: List[str], output: str):
    """Generate templates"""
    variables = {}
    for data_file in data:
        with open(data_file, "r") as fp:
            variables = {**variables, **json.load(fp)}

    if folder is not None:
        location = Path(folder)
        filenames = glob.glob(f"{folder}/**/*.j2", recursive=True)
    elif file is not None:
        location = Path(file).parent
        filenames = [f"{file}.j2"]
    else:
        raise Exception("Need to specify either folder or file")

    output_path = Path(output)

    env = jinja2.Environment(
        loader=jinja2.FileSystemLoader(str(location)),
        autoescape=False,
        keep_trailing_newline=True,
    )

    for filename in filenames:
        template_name = Path(filename).relative_to(location)
        template = env.get_template(str(template_name))
        output = template.stream(**variables)

        destination = output_path / os.path.splitext(template_name)[0]
        destination.parent.mkdir(parents=True, exist_ok=True)

        with destination.open("w") as fp:
            output.dump(fp)

        # Copy file mode over
        source_path = Path(template.filename)
        mode = source_path.stat().st_mode
        destination.chmod(mode)


if __name__ == "__main__":
    main()
