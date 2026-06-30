# Copyright 2024 Google LLC
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
import re
from git import Commit

from common.model.config_change import ConfigChange, ChangeType
from common.model.generation_config import (
    GAPIC_GENERATOR_VERSION,
    LIBRARIES_BOM_VERSION,
)

PARAM_TO_COMMIT_MESSAGE = {
    GAPIC_GENERATOR_VERSION: "fix(deps): update the Java code generator (gapic-generator-java) to",
    LIBRARIES_BOM_VERSION: "chore: update the libraries_bom version to",
}


def format_commit_message(commits: dict[Commit, str], is_monorepo: bool) -> list[str]:
    """
    Format commit messages. Add library_name to conventional commit messages if
    is_monorepo is True; otherwise no op.

    :param commits: a mapping from commit to library_name.
    :param is_monorepo: whether it's monorepo or not.
    :return: formatted commit messages.
    """
    all_commits = []
    # please see go/java-client-releasing#conventional-commit-messages
    # for conventional commit.
    type_regex = re.compile(r"(feat|fix|docs|deps|test|samples|chore)!?:.*")
    for commit, library_name in commits.items():
        # a commit message may contain multiple lines, we need to
        # add library_name for each line.
        messages = []
        for message_line in commit.message.split("\n"):
            # add library name to a conventional commit message;
            # otherwise no op.
            if type_regex.search(message_line):
                commit_type, _, summary = message_line.partition(":")
                formatted_message = (
                    f"{commit_type}: [{library_name}]{str(summary).rstrip()}"
                    if is_monorepo
                    else f"{commit_type}:{str(summary).rstrip()}"
                )
                messages.append(formatted_message)
            else:
                messages.append(message_line)
        all_commits.extend(wrap_googleapis_commit(commit, messages))
    return all_commits


def format_repo_level_change(config_change: ConfigChange) -> list[str]:
    """
    Format commit messages regarding repo-level changes.

    :param config_change:
    :return: commit messages regarding repo-level changes.
    """
    messages = []
    for repo_level_change in config_change.change_to_libraries.get(
        ChangeType.REPO_LEVEL_CHANGE, []
    ):
        message = f"chore: update repo-level parameter {repo_level_change.changed_param} to {repo_level_change.current_value}"
        if repo_level_change.changed_param in PARAM_TO_COMMIT_MESSAGE:
            message = f"{PARAM_TO_COMMIT_MESSAGE.get(repo_level_change.changed_param)} {repo_level_change.current_value}"
        messages.extend(__wrap_nested_commit([message]))
    return messages


def wrap_googleapis_commit(commit: Commit, messages: list[str]) -> list[str]:
    """
    Wrap message between `BEGIN_NESTED_COMMIT` and `BEGIN_NESTED_COMMIT`.

    :param commit: a GitHub commit.
    :param messages: a (multi-line) commit message, one line per item.
    :return: wrapped messages.
    """
    messages.append(f"Source Link: {commit_link(commit)}")
    return __wrap_nested_commit(messages)


def wrap_override_commit(messages: list[str]) -> list[str]:
    """
    Wrap message between `BEGIN_COMMIT_OVERRIDE` and `END_COMMIT_OVERRIDE`.

    :param messages: a (multi-line) commit message, one line per item.
    :return: wrapped messages.
    """
    result = ["BEGIN_COMMIT_OVERRIDE"]
    result.extend(messages)
    result.append("END_COMMIT_OVERRIDE")
    return result


def commit_link(commit: Commit) -> str:
    """
    Create a link to the commit in Markdown format.

    :param commit: a GitHub commit.
    :return: a link in Markdown format.
    """
    short_sha = commit.hexsha[:7]
    return f"[googleapis/googleapis@{short_sha}](https://github.com/googleapis/googleapis/commit/{commit.hexsha})"


def __wrap_nested_commit(messages: list[str]) -> list[str]:
    """
    Wrap message between `BEGIN_NESTED_COMMIT` and `BEGIN_NESTED_COMMIT`.

    :param messages: a (multi-line) commit message, one line per item.
    :return: wrapped messages.
    """
    result = ["BEGIN_NESTED_COMMIT"]
    result.extend(messages)
    result.append("END_NESTED_COMMIT")
    return result
