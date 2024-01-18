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

import time
import pathlib

import pkg_resources
import packaging.version
import requests


def _get_pypi_version(package_name: str) -> str:
    r = requests.get(f"https://pypi.org/pypi/{package_name}/json")
    r.raise_for_status()

    return r.json()["info"]["version"]


def _only_once_pls(package_name: str) -> bool:
    flag = pathlib.Path.home() / ".cache" / f"update-check-{package_name}"

    if not flag.exists():
        flag.parent.mkdir(parents=True, exist_ok=True)
        flag.touch()
        return True

    last_check = flag.stat().st_mtime
    one_day_in_seconds = 60 * 60 * 24

    if last_check < time.time() - one_day_in_seconds:
        flag.touch()
        return True
    else:
        return False


def check_for_updates(package_name: str, print=print) -> None:
    if not _only_once_pls(package_name):
        return

    current_version = packaging.version.Version(
        pkg_resources.get_distribution(package_name).version
    )

    pypi_version = packaging.version.Version(_get_pypi_version(package_name))

    if current_version >= pypi_version:
        return

    print(
        f"{package_name} has a newer version available. Current version is "
        f"{current_version}, newest is {pypi_version}. Run `python3 -m pip "
        f"install --upgrade {package_name}` to update."
    )
