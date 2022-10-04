#!/usr/bin/env python3
#  Copyright 2020 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

from jinja2 import Environment, FileSystemLoader
import os
import pathlib

root_directory = pathlib.Path(
    os.path.realpath(os.path.dirname(os.path.realpath(__file__)))
)
jinja_env = Environment(loader=FileSystemLoader(str(root_directory / "templates")))


def render(template_name: str, output_name: str, **kwargs):
    template = jinja_env.get_template(template_name)
    t = template.stream(kwargs)
    directory = os.path.dirname(output_name)
    if not os.path.isdir(directory):
        os.makedirs(directory)
    t.dump(str(output_name))
