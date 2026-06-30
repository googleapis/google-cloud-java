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
import tempfile
from enum import Enum
from typing import Optional
from git import Commit, Repo
from common.model.gapic_inputs import parse_build_str
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig
from common.utils.proto_path_utils import find_versioned_proto_path

INSERTIONS = "insertions"
LINES = "lines"


class ChangeType(Enum):
    GOOGLEAPIS_COMMIT = 1
    REPO_LEVEL_CHANGE = 2
    LIBRARIES_ADDITION = 3
    # As of Mar. 2024, we decide not to produce this type of change because we
    # still need to manually remove the libray.
    # LIBRARIES_REMOVAL = 4
    LIBRARY_LEVEL_CHANGE = 5
    GAPIC_ADDITION = 6
    # As of Mar. 2024, we decide not to produce this type of change because we
    # still need to manually remove the libray.
    # GAPIC_REMOVAL = 7


class HashLibrary:
    """
    Data class to group a LibraryConfig object and its hash value together.
    """

    def __init__(self, hash_value: int, library: LibraryConfig):
        self.hash_value = hash_value
        self.library = library


class LibraryChange:
    def __init__(self, changed_param: str, current_value: str, library_name: str = ""):
        self.changed_param = changed_param
        self.current_value = current_value
        self.library_name = library_name


class QualifiedCommit:
    def __init__(self, commit: Commit, libraries: set[str]):
        self.commit = commit
        self.libraries = libraries


class ConfigChange:

    def __init__(
        self,
        change_to_libraries: dict[ChangeType, list[LibraryChange]],
        baseline_config: GenerationConfig,
        current_config: GenerationConfig,
    ):
        self.change_to_libraries = change_to_libraries
        self.baseline_config = baseline_config
        self.current_config = current_config

    def get_changed_libraries(self) -> list[str]:
        """
        Returns a unique, sorted list of library name of changed libraries.

        :return: library names of change libraries.
        """
        if ChangeType.REPO_LEVEL_CHANGE in self.change_to_libraries:
            return [
                library.get_library_name() for library in self.current_config.libraries
            ]
        library_names = set()
        for change_type, library_changes in self.change_to_libraries.items():
            if change_type == ChangeType.GOOGLEAPIS_COMMIT:
                library_names.update(self.__get_library_names_from_qualified_commits())
            else:
                library_names.update(
                    [library_change.library_name for library_change in library_changes]
                )
        return sorted(list(library_names))

    def get_qualified_commits(
        self,
        repo_url: str = "https://github.com/googleapis/googleapis.git",
    ) -> list[QualifiedCommit]:
        """
        Returns qualified commits from configuration change.

        A qualified commit is a commit that changes at least one file (excluding
        BUILD.bazel) within a versioned proto path in the given proto_paths.
        :param repo_url: the repository contains the commit history.
        :return: QualifiedCommit objects.
        """
        with tempfile.TemporaryDirectory(ignore_cleanup_errors=True) as tmp_dir:
            # We include blobs to avoid unexpected missing git objects when computing
            # a diff.
            # See https://github.com/googleapis/sdk-platform-java/issues/3745
            repo = Repo.clone_from(url=repo_url, to_path=tmp_dir)
            commit = repo.commit(self.current_config.googleapis_commitish)
            proto_paths = self.current_config.get_proto_path_to_library_name()
            qualified_commits = []
            while str(commit.hexsha) != self.baseline_config.googleapis_commitish:
                qualified_commit = ConfigChange.__create_qualified_commit(
                    proto_paths=proto_paths, commit=commit
                )
                if qualified_commit is not None:
                    qualified_commits.append(qualified_commit)
                commit_parents = commit.parents
                if len(commit_parents) == 0:
                    break
                commit = commit_parents[0]
            repo.close()
        return qualified_commits

    def __get_library_names_from_qualified_commits(self) -> list[str]:
        qualified_commits = self.get_qualified_commits()
        library_names = []
        for qualified_commit in qualified_commits:
            library_names.extend(qualified_commit.libraries)
        return library_names

    @staticmethod
    def __create_qualified_commit(
        proto_paths: dict[str, str], commit: Commit
    ) -> Optional[QualifiedCommit]:
        """
        Returns a qualified commit from the given Commit object; otherwise None.

        :param proto_paths: a mapping from versioned proto_path to library_name
        :param commit: a GitHub commit object.
        :return: qualified commits.
        """
        libraries = set()
        for file_path, changes in commit.stats.files.items():
            versioned_proto_path = find_versioned_proto_path(file_path)
            if versioned_proto_path in proto_paths:
                if (
                    file_path.endswith("BUILD.bazel")
                    # Qualify a commit if the commit only added BUILD.bazel
                    # because it's very unlikely that a commit added BUILD.bazel
                    # without adding proto files. Therefore, the commit is
                    # qualified duo to the proto change eventually.
                    and (not ConfigChange.__is_added(changes))
                    and (
                        not ConfigChange.__is_qualified_build_change(
                            commit=commit, build_file_path=file_path
                        )
                    )
                ):
                    continue
                # Even though a commit usually only changes one
                # library, we don't want to miss generating a
                # library because the commit may change multiple
                # libraries.
                libraries.add(proto_paths[versioned_proto_path])
        if len(libraries) == 0:
            return None
        return QualifiedCommit(commit=commit, libraries=libraries)

    @staticmethod
    def __is_added(changes: dict[str, int]) -> bool:
        return changes[INSERTIONS] == changes[LINES]

    @staticmethod
    def __is_qualified_build_change(commit: Commit, build_file_path: str) -> bool:
        """
        Checks if the given commit containing a BUILD.bazel change is a
        qualified commit.

        The commit is a qualified commit if the
        :class:`library_generation.model.gapic_inputs.GapicInputs` objects
        parsed from the commit and its parent are different, since there are
        changes in fields that used in library generation.

        :param commit: a GitHub commit object.
        :param build_file_path: the path of the BUILD.bazel
        :return: True if the commit is a qualified commit; False otherwise.
        """
        versioned_proto_path = find_versioned_proto_path(build_file_path)
        build = str((commit.tree / build_file_path).data_stream.read())
        parent_commit = commit.parents[0]
        parent_build = str((parent_commit.tree / build_file_path).data_stream.read())
        inputs = parse_build_str(build, versioned_proto_path)
        parent_inputs = parse_build_str(parent_build, versioned_proto_path)
        return inputs != parent_inputs
