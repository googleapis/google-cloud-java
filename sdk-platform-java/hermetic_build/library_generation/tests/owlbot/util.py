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

import contextlib
import subprocess
import os
import pathlib
import shutil
import sys
import tempfile
import typing


def make_working_repo(working_dir: str, default_branch: str = "main"):
    """Create a local repo that resembles a real repo.

    Specifically, it has a history of synth.py changes that actually change the
    generated output.
    """
    subprocess.check_call(["git", "init"], cwd=working_dir)
    subprocess.check_call(["git", "checkout", "-b", default_branch], cwd=working_dir)
    subprocess.check_call(
        [
            "git",
            "remote",
            "add",
            "origin",
            "https://github.com/googleapis/nodejs-vision.git",
        ]
    )
    working_path = pathlib.Path(working_dir)
    # The simplest possible synth.py.  It generates one file with one line of text.
    template = """import time
import json
import uuid
import subprocess

# comment

with open("generated.txt", "wt") as f:
    f.write("a\\n")
metadata = { "updateTime": str(uuid.uuid4()),
    "sources": [
        {
        "git": {
            "name": ".",
            "remote": "https://github.com/googleapis/synthtool.git",
            "sha": subprocess.run(["git", "log", "-1", "--pretty=%H"], universal_newlines=True, stdout=subprocess.PIPE).stdout.strip(),
        }
    }]
}
with open("synth.metadata", "wt") as f:
    json.dump(metadata, f)
"""
    # Write version a.
    synth_py_path = working_path / "synth.py"
    synth_py_path.write_text(template)
    subprocess.check_call([sys.executable, str(synth_py_path)], cwd=working_dir)
    subprocess.check_call(["git", "add", "-A"], cwd=working_dir)
    subprocess.check_call(["git", "commit", "-m", "a"], cwd=working_dir)

    # Write version b.
    text = template.replace('"a\\n"', '"b\\n"')
    synth_py_path.write_text(text)
    subprocess.check_call(["git", "commit", "-am", "b"], cwd=working_dir)

    # Write a version that has no effect on output.
    text = text.replace("# comment", "# a different comment")
    synth_py_path.write_text(text)
    subprocess.check_call(["git", "commit", "-am", "comment"], cwd=working_dir)

    # Write version c.
    text = text.replace('"b\\n"', '"c\\n"')
    synth_py_path.write_text(text)
    subprocess.check_call(
        ["git", "commit", "-am", "c subject\n\nbody line 1\nbody line 2"],
        cwd=working_dir,
    )

    return text


@contextlib.contextmanager
def chdir(path: typing.Union[pathlib.Path, str]):
    """Context Manager to change the current working directory and restore the
    previous working directory after completing the context.

    Args:
        path (pathlib.Path, str) - The new current working directory.
    Yields:
        pathlib.Path - The new current working directory.
    """
    old_cwd = os.getcwd()
    os.chdir(str(path))
    try:
        yield pathlib.Path(path)
    finally:
        os.chdir(old_cwd)


@contextlib.contextmanager
def copied_fixtures_dir(source: pathlib.Path):
    """Context Manager to copy from a fixtures directory into a new temporary directory
    and change the current working directory to that copy. Restores the original
    current working directory after completing the context.

    Args:
        source (pathlib.Path) - The directory to copy.
    Yields:
        pathlib.Path - The temporary directory with the copied contents.
    """
    with tempfile.TemporaryDirectory() as tempdir:
        workdir = shutil.copytree(source, pathlib.Path(tempdir) / "workspace")
        with chdir(workdir):
            yield workdir
