#!/usr/bin/env python3
#  Copyright 2024 Google LLC
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
import calendar
import os
import shutil
from typing import Dict
from git import Commit, Repo

from common.model.config_change import ConfigChange
from common.utils.proto_path_utils import find_versioned_proto_path
from release_note_generation.commit_message_formatter import (
    format_commit_message,
    format_repo_level_change,
    commit_link,
    wrap_override_commit,
)

EMPTY_MESSAGE = ""


def generate_pr_descriptions(
    config_change: ConfigChange,
    description_path: str,
    repo_url: str = "https://github.com/googleapis/googleapis.git",
) -> None:
    """
    Generate pull request description from configuration comparison result.

    The pull request description contains repo-level changes, if applicable,
    and googleapis commit from baseline config (exclusive) to current config
    (inclusive).

    The pull request description will be generated into
    description_path/pr_description.txt.

    No pr_description.txt will be generated if no changes in the configurations.

    :param config_change: a ConfigChange object, containing changes in baseline
    and current generation configurations.
    :param description_path: the path to which the pull request description
    file goes.
    :param repo_url: the GitHub repository from which retrieves the commit
    history.
    """
    repo_level_message = format_repo_level_change(config_change)
    paths = config_change.current_config.get_proto_path_to_library_name()
    description = get_repo_level_commit_messages(
        repo_url=repo_url,
        current_commit_sha=config_change.current_config.googleapis_commitish,
        baseline_commit_sha=config_change.baseline_config.googleapis_commitish,
        paths=paths,
        is_monorepo=config_change.current_config.is_monorepo(),
        repo_level_message=repo_level_message,
    )

    if description == EMPTY_MESSAGE:
        print("Empty commit messages, skip creating pull request description.")
        return

    description_file = f"{description_path}/pr_description.txt"
    print(f"Writing pull request description to {description_file}")
    with open(description_file, "w+") as f:
        f.write(description)


def get_repo_level_commit_messages(
    repo_url: str,
    current_commit_sha: str,
    baseline_commit_sha: str,
    paths: Dict[str, str],
    is_monorepo: bool,
    repo_level_message: list[str],
) -> str:
    """
    Combine commit messages of a repository from latest_commit to
    baseline_commit. Only commits which change files in a pre-defined
    file paths will be considered.
    Note that baseline_commit should be an ancestor of or the same as
    latest_commit.

    :param repo_url: the url of the repository.
    :param current_commit_sha: the newest commit to be considered in
    selecting commit message.
    :param baseline_commit_sha: the oldest commit to be considered in
    selecting commit message. This commit should be an ancestor of
    :param paths: a mapping from file paths to library_name.
    :param is_monorepo: whether to generate commit messages in a monorepo.
    :param repo_level_message: commit messages regarding repo-level changes.
    :return: commit messages.
    :raise ValueError: if current_commit is older than or equal to
    baseline_commit.
    """
    tmp_dir = "/tmp/repo"
    shutil.rmtree(tmp_dir, ignore_errors=True)
    os.mkdir(tmp_dir)
    repo = Repo.clone_from(repo_url, tmp_dir)
    current_commit = repo.commit(current_commit_sha)
    baseline_commit = repo.commit(baseline_commit_sha)
    current_commit_time = __get_commit_timestamp(current_commit)
    baseline_commit_time = __get_commit_timestamp(baseline_commit)
    if current_commit_time < baseline_commit_time:
        raise ValueError(
            f"current_commit ({current_commit_sha[:7]}, committed on "
            f"{current_commit_time}) should be newer than or equal to "
            f"baseline_commit ({baseline_commit_sha[:7]}, committed on "
            f"{baseline_commit_time}) (is this branch up to date with "
            f"the base branch?)."
        )
    qualified_commits = {}
    commit = current_commit
    while str(commit.hexsha) != baseline_commit_sha:
        commit_and_name = __filter_qualified_commit(paths=paths, commit=commit)
        if commit_and_name != ():
            qualified_commits[commit_and_name[0]] = commit_and_name[1]
        commit_parents = commit.parents
        if len(commit_parents) == 0:
            break
        commit = commit_parents[0]
    shutil.rmtree(tmp_dir, ignore_errors=True)

    return __combine_commit_messages(
        current_commit=current_commit,
        baseline_commit=baseline_commit,
        commits=qualified_commits,
        is_monorepo=is_monorepo,
        repo_level_message=repo_level_message,
    )


def __filter_qualified_commit(paths: Dict[str, str], commit: Commit) -> (Commit, str):
    """
    Returns a tuple of a commit and libray_name.
    A qualified commit means at least one file, excluding BUILD.bazel, changes
    in that commit is within the versioned proto_path in paths.

    :param paths: a mapping from versioned proto_path to library_name.
    :param commit: a commit under consideration.
    :return: a tuple of a commit and library_name if the commit is
    qualified; otherwise an empty tuple.
    """
    for file in commit.stats.files.keys():
        versioned_proto_path = find_versioned_proto_path(file)
        if versioned_proto_path in paths and (not file.endswith("BUILD.bazel")):
            return commit, paths[versioned_proto_path]
    return ()


def __combine_commit_messages(
    current_commit: Commit,
    baseline_commit: Commit,
    commits: Dict[Commit, str],
    is_monorepo: bool,
    repo_level_message: list[str],
) -> str:
    description = []
    if current_commit != baseline_commit:
        description.append(
            f"This pull request is generated with proto changes between "
            f"{commit_link(baseline_commit)} (exclusive) "
            f"and {commit_link(current_commit)} (inclusive).\n",
        )
    commit_message = repo_level_message
    commit_message.extend(
        format_commit_message(commits=commits, is_monorepo=is_monorepo)
    )
    if len(commit_message) == 0:
        return EMPTY_MESSAGE
    description.extend(wrap_override_commit(commit_message))
    return "\n".join(description)


def __get_commit_timestamp(commit: Commit) -> int:
    """
    # Convert datetime to UTC timestamp. For more info:
    # https://stackoverflow.com/questions/5067218/get-utc-timestamp-in-python-with-datetime

    :param commit: a Commit object
    :return: the timestamp of the commit
    """
    return calendar.timegm(commit.committed_datetime.utctimetuple())
