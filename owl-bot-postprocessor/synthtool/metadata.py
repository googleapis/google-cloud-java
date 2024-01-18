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

import fnmatch
import locale
import os
import pathlib
import shutil
import subprocess
import sys
import tempfile
import threading
import time
from typing import Dict, Iterable, List

import google.protobuf.json_format
import watchdog.events
import watchdog.observers

from synthtool.log import logger
from synthtool.protos import metadata_pb2

_metadata = metadata_pb2.Metadata()


def get_environment_bool(var_name: str) -> bool:
    val = os.environ.get(var_name)
    return False if not val or val.lower() == "false" else True


_track_obsolete_files = get_environment_bool("SYNTHTOOL_TRACK_OBSOLETE_FILES")

# The list of file patterns excluded during a copy() or move() operation.
_excluded_patterns: List[str] = []


def reset() -> None:
    """Clear all metadata so far."""
    global _metadata
    _metadata = metadata_pb2.Metadata()
    global _excluded_patterns
    _excluded_patterns = []


def get():
    return _metadata


def add_git_source(**kwargs) -> None:
    """Adds a git source to the current metadata."""
    _metadata.sources.add(git=metadata_pb2.GitSource(**kwargs))


def add_pattern_excluded_during_copy(glob_pattern: str) -> None:
    """Adds a file excluded during copy.

    Used to avoid deleting an obsolete file that is excluded."""
    _excluded_patterns.append(glob_pattern)


def add_generator_source(**kwargs) -> None:
    """Adds a generator source to the current metadata."""
    _metadata.sources.add(generator=metadata_pb2.GeneratorSource(**kwargs))


def add_template_source(**kwargs) -> None:
    """Adds a template source to the current metadata."""
    _metadata.sources.add(template=metadata_pb2.TemplateSource(**kwargs))


def add_client_destination(**kwargs) -> None:
    """Adds a client library destination to the current metadata."""
    _metadata.destinations.add(client=metadata_pb2.ClientDestination(**kwargs))


def _git_slashes(path: str):
    # git speaks only forward slashes
    return path.replace("\\", "/") if sys.platform == "win32" else path


def _read_or_empty(path: str = "synth.metadata"):
    """Reads a metadata json file.  Returns empty if that file is not found."""
    try:
        with open(path, "rt") as file:
            text = file.read()
        return google.protobuf.json_format.Parse(text, metadata_pb2.Metadata())
    except FileNotFoundError:
        return metadata_pb2.Metadata()


def write(outfile: str = "synth.metadata") -> None:
    """Writes out the metadata to a file."""
    jsonified = google.protobuf.json_format.MessageToJson(_metadata)

    with open(outfile, "w") as fh:
        fh.write(jsonified)

    logger.debug(f"Wrote metadata to {outfile}.")


def _remove_obsolete_files(old_metadata):
    """Remove obsolete files from the file system.

    Call add_new_files() before this function or it will remove all generated
    files.

    Parameters:
        old_metadata:  old metadata loaded from a call to read_or_empty().
    """
    old_files = set(old_metadata.generated_files)
    new_files = set(_metadata.generated_files)
    excluded_patterns = set([pattern for pattern in _excluded_patterns])
    obsolete_files = old_files - new_files
    for file_path in git_ignore(obsolete_files):
        try:
            matched_pattern = False
            for pattern in excluded_patterns:
                if fnmatch.fnmatch(file_path, pattern):
                    matched_pattern = True
                    break
            if matched_pattern:
                logger.info(
                    f"Leaving obsolete file {file_path} because it matched excluded pattern {pattern} during copy."
                )
            else:
                logger.info(f"Removing obsolete file {file_path}...")
                os.unlink(file_path)
        except FileNotFoundError:
            pass  # Already deleted.  That's OK.


def git_ignore(file_paths: Iterable[str]):
    """Returns a new list of the same files, with ignored files removed."""
    # Surprisingly, git check-ignore doesn't ignore .git directories, take those
    # files out manually.
    nongit_file_paths = [
        file_path
        for file_path in file_paths
        if ".git" not in pathlib.Path(file_path).parts
    ]

    encoding = locale.getpreferredencoding(False)
    # Write the files to a temporary text file.
    with tempfile.TemporaryFile("w+b") as f:
        for file_path in nongit_file_paths:
            f.write(_git_slashes(file_path).encode(encoding))
            f.write("\n".encode(encoding))
        # Invoke git.
        f.seek(0)
        git = shutil.which("git")
        if not git:
            raise FileNotFoundError("Could not find git in PATH.")
        completed_process = subprocess.run(
            [git, "check-ignore", "--stdin"], stdin=f, stdout=subprocess.PIPE
        )
    # Digest git output.
    output_text = completed_process.stdout.decode(encoding)
    ignored_file_paths = set(
        [os.path.normpath(path.strip()) for path in output_text.split("\n")]
    )
    # Filter the ignored paths from the file_paths.
    return [
        path
        for path in nongit_file_paths
        if os.path.normpath(path) not in ignored_file_paths
    ]


def set_track_obsolete_files(track_obsolete_files=True):
    """Instructs synthtool to track and remove obsolete files."""
    global _track_obsolete_files
    _track_obsolete_files = track_obsolete_files


def should_track_obsolete_files():
    return _track_obsolete_files


class FileSystemEventHandler(watchdog.events.FileSystemEventHandler):
    """Records all the files that were touched."""

    def __init__(self, watch_dir: pathlib.Path):
        super().__init__()
        self._touched_file_paths: List[str] = list()
        self._touched_lock = threading.Lock()
        self._watch_dir = watch_dir

    def on_any_event(self, event):
        if event.is_directory:
            return
        if event.event_type in (
            watchdog.events.EVENT_TYPE_MODIFIED,
            watchdog.events.EVENT_TYPE_CREATED,
        ):
            touched_path = event.src_path
        elif event.event_type == watchdog.events.EVENT_TYPE_MOVED:
            touched_path = event.dest_path
        else:
            return
        touched_path = pathlib.Path(touched_path).relative_to(self._watch_dir)
        with self._touched_lock:
            self._touched_file_paths.append(str(touched_path))

    def get_touched_file_paths(self) -> List[str]:
        # deduplicate and sort
        with self._touched_lock:
            paths = set(self._touched_file_paths)
        result = list(paths)
        result.sort()
        return result


class MetadataTrackerAndWriter:
    """Writes metadata file upon exiting scope."""

    def __init__(self, metadata_file_path: str):
        self.metadata_file_path = metadata_file_path

    def __enter__(self):
        self.old_metadata = _read_or_empty(self.metadata_file_path)
        _add_self_git_source()
        watch_dir = pathlib.Path(self.metadata_file_path).parent
        os.makedirs(watch_dir, exist_ok=True)
        # Create an observer only if obsolete file tracking is enabled.
        # This prevents inotify errors in synth jobs that may delete the watch
        # dir. Such synth jobs should leave obsolete file tracking disabled.
        if should_track_obsolete_files():
            self.handler = FileSystemEventHandler(watch_dir)
            self.observer = watchdog.observers.Observer()
            self.observer.schedule(self.handler, str(watch_dir), recursive=True)
            self.observer.start()

    def __exit__(self, type, value, traceback):
        if value:
            pass  # An exception was raised.  Don't write metadata or clean up.
        else:
            if should_track_obsolete_files():
                time.sleep(2)  # Finish collecting observations about modified files.
                self.observer.stop()
                self.observer.join()
                for path in git_ignore(self.handler.get_touched_file_paths()):
                    _metadata.generated_files.append(path)
                _remove_obsolete_files(self.old_metadata)
            _clear_local_paths(get())
            _metadata.sources.sort(key=_source_key)
            if _enable_write_metadata:
                write(self.metadata_file_path)


def _get_git_source_map(metadata) -> Dict[str, object]:
    """Gets the git sources from the metadata.

    Parameters:
        metadata: an instance of metadata_pb2.Metadata.

    Returns:
        A dict mapping git source name to metadata_pb2.GitSource instance.
    """
    source_map = {}
    for source in metadata.sources:
        if source.HasField("git"):
            git_source = source.git
            source_map[git_source.name] = git_source
    return source_map


def _clear_local_paths(metadata):
    """Clear the local_path from the git sources.

    There's no reason to preserve it, and it may leak some info we don't
    want to leak in the path.
    """
    for source in metadata.sources:
        if source.HasField("git"):
            git_source = source.git
            git_source.ClearField("local_path")


def _add_self_git_source():
    """Adds current working directory as a git source.

    Returns:
        The number of git sources added to metadata.
    """
    # Use the repository's root directory name as the name.
    return _add_git_source_from_directory(".", os.getcwd())


def _add_git_source_from_directory(name: str, dir_path: str) -> int:
    """Adds the git repo containing the directory as a git source.

    Returns:
        The number of git sources added to metadata.
    """
    completed_process = subprocess.run(
        ["git", "-C", dir_path, "status"], universal_newlines=True
    )
    if completed_process.returncode:
        logger.warning("%s is not directory in a git repo.", dir_path)
        return 0
    completed_process = subprocess.run(
        ["git", "-C", dir_path, "remote", "get-url", "origin"],
        stdout=subprocess.PIPE,
        universal_newlines=True,
    )
    url = completed_process.stdout.strip()
    completed_process = subprocess.run(
        ["git", "-C", dir_path, "log", "--no-decorate", "-1", "--pretty=format:%H"],
        stdout=subprocess.PIPE,
        universal_newlines=True,
    )
    latest_sha = completed_process.stdout.strip()
    add_git_source(name=name, remote=url, sha=latest_sha)
    return 1


def _source_key(source):
    """Creates a key to use to sort a list of sources.

    Arguments:
        source {metadata_pb2.Source} -- the Source for which to formulate a sort key

    Returns:
        tuple -- A key to use to sort a list of sources.
    """
    if source.HasField("git"):
        return ("git", source.git.name, source.git.remote, source.git.sha)
    if source.HasField("generator"):
        return (
            "generator",
            source.generator.name,
            source.generator.version,
            source.generator.docker_image,
        )
    if source.HasField("template"):
        return (
            "template",
            source.template.name,
            source.template.origin,
            source.template.version,
        )


_enable_write_metadata = True


def enable_write_metadata(enable: bool = True) -> None:
    """Control whether synthtool writes synth.metadata file."""
    global _enable_write_metadata
    _enable_write_metadata = enable
