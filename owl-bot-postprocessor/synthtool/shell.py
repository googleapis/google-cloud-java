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

import subprocess

from synthtool.log import logger


def run(args, *, cwd=None, check=True, hide_output=True):
    if hide_output:
        stdout = subprocess.PIPE
    else:
        stdout = None

    try:
        return subprocess.run(
            args,
            stdout=stdout,
            stderr=subprocess.STDOUT,
            cwd=cwd,
            check=check,
            encoding="utf-8",
        )
    except subprocess.CalledProcessError as exc:
        logger.error(
            f"Failed executing {' '.join((str(arg) for arg in args))}:\n\n{exc.stdout}"
        )
        raise exc
