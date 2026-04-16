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
import copy
import os
import shutil
import sys
import threading
from concurrent.futures import ThreadPoolExecutor, as_completed
from pathlib import Path
from typing import Optional
import library_generation.utils.utilities as util
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig
from common.utils.proto_path_utils import ends_with_version
from library_generation.generate_composed_library import (
    generate_composed_library,
    library_generation_worker,
)
from library_generation.utils.monorepo_postprocessor import monorepo_postprocessing

from common.model.gapic_config import GapicConfig


def generate_from_yaml(
    config: GenerationConfig,
    repository_path: str,
    api_definitions_path: str,
    target_library_names: Optional[list[str]],
    target_api_path: Optional[str] = None,
) -> None:
    """
    Based on the generation config, generates libraries via
    generate_composed_library.py

    :param config: a GenerationConfig object.
    :param repository_path: The repository path to which the generated files
    will be sent.
    :param api_definitions_path: The path to where the api definition resides.
    :param target_library_names: a list of libraries to be generated.
    If specified, only the library whose library_name is in target_library_names
    will be generated.
    If specified with an empty list, then no library will be generated.
    If not specified, all libraries in the configuration yaml will be generated.
    """
    target_libraries = get_target_libraries(
        config=config,
        target_library_names=target_library_names,
        target_api_path=target_api_path,
    )
    repo_config = util.prepare_repo(
        gen_config=config, library_config=target_libraries, repo_path=repository_path
    )
    # copy api definition to output folder.
    shutil.copytree(api_definitions_path, repo_config.output_folder, dirs_exist_ok=True)
    sys.stdout = ThreadLocalStream(original_stdout)
    sys.stderr = ThreadLocalStream(original_stderr)
    try:
        _generate_libraries_in_parallel(config, repo_config)
    finally:
        sys.stdout = original_stdout
        sys.stderr = original_stderr

    if not config.is_monorepo() or config.contains_common_protos():
        return

    monorepo_postprocessing(
        repository_path=repository_path, versions_file=repo_config.versions_file
    )

    # cleanup temp output folder
    try:
        shutil.rmtree(Path(repo_config.output_folder))
        print(f"Directory {repo_config.output_folder} and its contents removed.")
    except OSError as e:
        print(f"Error: {e} - Failed to remove directory {repo_config.output_folder}.")
        raise


def get_target_libraries(
    config: GenerationConfig,
    target_library_names: list[str] = None,
    target_api_path: Optional[str] = None,
) -> list[LibraryConfig]:
    """
    Returns LibraryConfig objects whose library_name is in target_library_names.

    :param config: a GenerationConfig object.
    :param target_library_names: library_name of target libraries.
    If not specified, all libraries in the given config will be returned.
    :return: LibraryConfig objects.
    """
    if target_api_path is None:
        return _get_target_libraries_from_name(config, target_library_names)
    return _get_target_libraries_from_api_path(config, target_api_path)


def _get_target_libraries_from_name(
    config: GenerationConfig, target_library_names: list[str] = None
) -> list[LibraryConfig]:
    """
    Returns LibraryConfig objects whose library_name is in target_library_names.

    :param config: a GenerationConfig object.
    :param target_library_names: library_name of target libraries.
    If not specified, all libraries in the given config will be returned.
    :return: LibraryConfig objects.
    """
    if target_library_names is None:
        return config.libraries
    target_libraries = set(target_library_names)
    return [
        library
        for library in config.libraries
        if library.get_library_name() in target_libraries
    ]


def _get_target_libraries_from_api_path(
    config: GenerationConfig, target_api_path: Optional[str] = None
) -> list[LibraryConfig]:
    """
    Retrieves a copy of the LibraryConfig objects that contain the specified
    target API path, without other proto_path versions that were not specified.
    dependency proto_paths are kept.

    :param config: The GenerationConfig object.
    :param target_api_path: The target proto path to search for.

    :return:
        A list of LibraryConfig objects matching the target API path, or an
        empty list if no matches are found.
    """
    if not ends_with_version(target_api_path):
        raise ValueError("api_path is not ending with a version is not supported")
    target_libraries = []
    for library in config.libraries:
        target_library = copy.deepcopy(library)
        gapic_config_list = []
        for item in library.gapic_configs:
            if item.proto_path == target_api_path or not ends_with_version(
                item.proto_path
            ):
                gapic_config_list.append(GapicConfig(item.proto_path))
        if gapic_config_list:
            target_library.set_gapic_configs(gapic_config_list)
            target_libraries.append(target_library)
            return target_libraries
    return []



class ThreadLocalStream:
    """
    Thread-safe interceptor to route print() statements into thread-local buffers.
    Necessary because sys.stdout is a global stream; direct threading writes interleave outputs.
    """

    def __init__(self, original_stream):
        self.original_stream = original_stream
        self.local = threading.local()

    @property
    def buffer(self):
        return getattr(self.local, "buffer", None)

    def write(self, data):
        writer = self.buffer if self.buffer is not None else self.original_stream
        writer.write(data)

    def flush(self):
        if self.buffer is not None:
            self.buffer.flush()
        self.original_stream.flush()


original_stdout, original_stderr = sys.stdout, sys.stderr

print_lock = threading.Lock()


def _print_worker_result(lib_name, logs, err):
    """
    Atomically prints the buffered output of a worker thread directly to original_stdout,
    preventing output interleaving in the console.
    """
    with print_lock:
        status = "[FAILURE]" if err else "[SUCCESS]"
        original_stdout.write(f"\n{'='*40}\n{status} Logs for {lib_name}:\n{'='*40}\n")
        original_stdout.write(logs)
        if err:
            original_stdout.write(f"\nError details:\n{err}\n")
        original_stdout.flush()


def _generate_libraries_in_parallel(config, repo_config):
    cores = os.cpu_count() or 4
    with ThreadPoolExecutor(max_workers=min(cores, 5)) as executor:
        futures = {
            executor.submit(
                library_generation_worker, config, path, lib, repo_config
            ): lib.get_library_name()
            for path, lib in repo_config.get_libraries().items()
        }

        for future in as_completed(futures):
            lib_name = futures[future]
            logs, err = future.result()
            _print_worker_result(lib_name, logs, err)
