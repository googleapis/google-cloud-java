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

import os
import pathlib
import re
import shutil
import subprocess
from typing import Dict, Optional, Tuple, Union

import synthtool
import synthtool.preconfig
from synthtool.log import logger
from synthtool import _tracked_paths, cache, metadata, shell

REPO_REGEX = (
    r"(((https:\/\/)|(git@))github.com(:|\/))?(?P<owner>[^\/]+)\/(?P<name>[^\/]+)"
)

USE_SSH = os.environ.get("AUTOSYNTH_USE_SSH", False)


def make_repo_clone_url(repo: str) -> str:
    """Returns a fully-qualified repo URL on GitHub from a string containing
    "owner/repo".

    This returns an https URL by default, but will return an ssh URL if
    AUTOSYNTH_USE_SSH is set.
    """
    if USE_SSH:
        return f"git@github.com:{repo}.git"
    else:
        return f"https://github.com/{repo}.git"


def _local_default_branch(path: pathlib.Path) -> Union[str, None]:
    """Helper method to infer the default branch.

    Sorts the list of branches by committerdate (latest is last) and then
    returns the later of master or main. The order of branches that are tied
    by committerdate is undefined.

    Arguments:
        path {pathlib.Path} - Path to the local git clone

    Returns:
        string -- The inferred default branch.
    """
    branches = (
        subprocess.check_output(
            ["git", "branch", "--sort=-committerdate", "--format=%(refname:short)"],
            cwd=str(path),
        )
        .decode("utf-8")
        .splitlines()
    )
    for branch in branches:
        if branch == "master" or branch == "main":
            return branch
    return None


def clone(
    url: str,
    dest: pathlib.Path = None,
    committish: str = None,
    force: bool = False,
) -> pathlib.Path:
    """Clones a remote git repo.

    Will not actually clone the repo if it's already local via two ways:
      1. It's in the cache (the default destitination).
      2. It was supplied via the preconfig file.

    Arguments:
        url {str} -- Url pointing to remote git repo.

    Keyword Arguments:
        dest {pathlib.Path} -- Local folder where repo should be cloned. (default: {None})
        committish {str} -- The commit hash to check out. (default: {None})
        force {bool} -- Wipe out and reclone if it already exists it the cache. (default: {False})

    Returns:
        pathlib.Path -- Local directory where the repo was cloned.
    """
    preclone = get_preclone(url)

    if preclone:
        logger.debug(f"Using precloned repo {preclone}")
        dest = pathlib.Path(preclone)
    else:
        if dest is None:
            dest = cache.get_cache_dir()

        dest = dest / pathlib.Path(url).stem

        if force and dest.exists():
            shutil.rmtree(dest)

        default_branch = None
        if not dest.exists():
            cmd = ["git", "clone", "--recurse-submodules", "--single-branch", url, dest]
            shell.run(cmd, check=True)
        else:
            default_branch = _local_default_branch(dest)
            shell.run(["git", "checkout", default_branch], cwd=str(dest), check=True)
            shell.run(["git", "pull"], cwd=str(dest), check=True)
        committish = committish or default_branch

    if committish:
        shell.run(["git", "reset", "--hard", committish], cwd=str(dest))

    # track all git repositories
    _tracked_paths.add(dest)

    # add repo to metadata
    sha, message = get_latest_commit(dest)
    commit_metadata = extract_commit_message_metadata(message)

    metadata.add_git_source(
        name=dest.name,
        remote=url,
        sha=sha,
        internal_ref=commit_metadata.get("PiperOrigin-RevId"),
        local_path=str(dest),
    )

    return dest


def parse_repo_url(url: str) -> Dict[str, str]:
    """
    Parses a GitHub url and returns a dict with:
        owner - Owner of the repository
        name  - Name of the repository

    The following are matchable:
        googleapis/nodejs-vision(.git)?
        git@github.com:GoogleCloudPlatform/google-cloud-python.git
        https://github.com/GoogleCloudPlatform/google-cloud-python.git
    """
    match = re.search(REPO_REGEX, url)

    if not match:
        raise RuntimeError("repository url is not a properly formatted git string.")

    owner = match.group("owner")
    name = match.group("name")

    if name.endswith(".git"):
        name = name[:-4]

    return {"owner": owner, "name": name}


def get_latest_commit(repo: pathlib.Path = None) -> Tuple[str, str]:
    """Return the sha and commit message of the latest commit."""
    output = subprocess.check_output(
        ["git", "log", "-1", "--pretty=%H%n%B"], cwd=repo
    ).decode("utf-8")
    commit, message = output.split("\n", 1)
    return commit, message


def extract_commit_message_metadata(message: str) -> Dict[str, str]:
    """Extract extended metadata stored in the Git commit message.

    For example, a commit that looks like this::

        Do the thing!

        Piper-Changelog: 1234567

    Will return::

        {"Piper-Changelog": "1234567"}

    """
    metadata = {}
    for line in message.splitlines():
        if ":" not in line:
            continue

        key, value = line.split(":", 1)
        metadata[key] = value.strip()

    return metadata


def get_preclone(url: str) -> Optional[str]:
    """Finds a pre-cloned git repo in the preclone map."""
    preconfig = synthtool.preconfig.load()
    return preconfig.precloned_repos.get(url)
