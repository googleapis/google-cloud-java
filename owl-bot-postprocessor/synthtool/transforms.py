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

from pathlib import Path
import shutil
from typing import Callable, Iterable, Union, List, Optional
import os
import re
import sys

from synthtool import _tracked_paths
from synthtool.log import logger
from synthtool import metadata

PathOrStr = Union[str, Path]
ListOfPathsOrStrs = Iterable[Union[str, Path]]


class MissingSourceError(Exception):
    pass


def _expand_paths(paths: ListOfPathsOrStrs, root: PathOrStr = None) -> Iterable[Path]:
    """Given a list of globs/paths, expands them into a flat sequence,
    expanding globs as necessary."""
    if paths is None:
        return []

    if isinstance(paths, (str, Path)):
        paths = [paths]

    if root is None:
        root = Path(".")

    # ensure root is a path
    root = Path(root)

    # record name of synth script so we don't try to do transforms on it
    synth_script_name = sys.argv[0]

    for path in paths:
        if isinstance(path, Path):
            if path.is_absolute():
                anchor = Path(path.anchor)
                remainder = str(path.relative_to(path.anchor))
                yield from anchor.glob(remainder)
            else:
                yield from root.glob(str(path))
        else:
            yield from (
                p
                for p in root.glob(path)
                if p.absolute() != Path(synth_script_name).absolute()
            )


def _filter_files(paths: Iterable[Path]) -> Iterable[Path]:
    """Returns only the paths that are files (no directories)."""

    return (path for path in paths if path.is_file() and os.access(path, os.W_OK))


def _merge_file(
    source_path: Path, dest_path: Path, merge: Callable[[str, str, Path], str]
):
    """
    Writes to the destination the result of merging the source with the
    existing destination contents, using the given merge function.

    The merge function must take three arguments: the source contents, the
    old destination contents, and a Path to the file to be written.
    """

    with source_path.open("r") as source_file:
        source_text = source_file.read()

    with dest_path.open("r+") as dest_file:
        dest_text = dest_file.read()

        final_text = merge(source_text, dest_text, dest_path)

        # use the source file's file permission mode
        os.chmod(dest_path, os.stat(source_path).st_mode)
        if final_text != dest_text:
            dest_file.seek(0)
            dest_file.write(final_text)
            dest_file.truncate()
        else:
            dest_path.touch()


def _copy_dir_to_existing_dir(
    source: Path,
    destination: Path,
    excludes: ListOfPathsOrStrs = None,
    merge: Callable[[str, str, Path], str] = None,
) -> bool:
    """
    copies files over existing files to an existing directory
    this function does not copy empty directories.

    Returns: True if any files were copied, False otherwise.
    """
    copied = False

    if not excludes:
        excludes = []
    for root, _, files in os.walk(source):
        for name in files:
            rel_path = str(Path(root).relative_to(source))
            dest_dir = destination / rel_path
            dest_path = dest_dir / name
            exclude = [
                e
                for e in excludes
                if (
                    Path(e) == _tracked_paths.relativize(root)
                    or Path(e) == _tracked_paths.relativize(Path(root) / name)
                )
            ]
            if not exclude:
                os.makedirs(str(dest_dir), exist_ok=True)
                source_path = Path(os.path.join(root, name))
                if merge is not None and dest_path.is_file():
                    try:
                        _merge_file(source_path, dest_path, merge)
                    except Exception:
                        logger.exception(
                            "_merge_file failed for %s, fall back to copy",
                            source_path,
                        )
                        shutil.copy2(str(source_path), str(dest_path))
                else:
                    shutil.copy2(str(source_path), str(dest_path))
                copied = True

    return copied


def dont_overwrite(
    patterns: ListOfPathsOrStrs,
) -> Callable[[str, str, Path], str]:
    """Returns a merge function that doesn't overwrite the specified files.

    Pass the return value to move() or copy() to avoid overwriting existing
    files.
    """

    def merge(source_text: str, destinaton_text: str, file_path: Path) -> str:
        for pattern in patterns:
            if file_path.match(str(pattern)):
                logger.debug(f"Preserving existing contents of {file_path}.")
                return destinaton_text
        return source_text

    return merge


def move(
    sources: ListOfPathsOrStrs,
    destination: PathOrStr = None,
    excludes: ListOfPathsOrStrs = None,
    merge: Callable[[str, str, Path], str] = None,
    required: bool = False,
) -> bool:
    """
    copy file(s) at source to current directory, preserving file mode.

    Args:
        sources (ListOfPathsOrStrs): Glob pattern(s) to copy
        destination (PathOrStr): Destination folder for copied files
        excludes (ListOfPathsOrStrs): Glob pattern(s) of files to skip
        merge (Callable[[str, str, Path], str]): Callback function for merging files
            if there is an existing file.
        required (bool): If required and no source files are copied, throws a MissingSourceError

    Returns:
        True if any files were copied, False otherwise.
    """
    copied = False

    for excluded_pattern in excludes or []:
        metadata.add_pattern_excluded_during_copy(str(excluded_pattern))

    for source in _expand_paths(sources):
        if destination is None:
            canonical_destination = _tracked_paths.relativize(source)
        else:
            canonical_destination = Path(destination)

        if excludes:
            excludes = [
                _tracked_paths.relativize(e) for e in _expand_paths(excludes, source)
            ]
        else:
            excludes = []
        if source.is_dir():
            copied = copied or _copy_dir_to_existing_dir(
                source, canonical_destination, excludes=excludes, merge=merge
            )
        elif source not in excludes:
            # copy individual file
            if merge is not None and canonical_destination.is_file():
                try:
                    _merge_file(source, canonical_destination, merge)
                except Exception:
                    logger.exception(
                        "_merge_file failed for %s, fall back to copy", source
                    )
                    shutil.copy2(source, canonical_destination)
            else:
                shutil.copy2(source, canonical_destination)
            copied = True

    if not copied:
        if required:
            raise MissingSourceError(
                f"No files in sources {sources} were copied. Does the source "
                f"contain files?"
            )
        else:
            logger.warning(
                f"No files in sources {sources} were copied. Does the source "
                f"contain files?"
            )

    return copied


def _replace_in_file(path, expr, replacement):
    try:
        with path.open("r+") as fh:
            return _replace_in_file_handle(fh, expr, replacement)
    except UnicodeDecodeError:
        pass  # It's a binary file.  Try again with a binary regular expression.
    flags = expr.flags & ~re.UNICODE
    expr = re.compile(expr.pattern.encode(), flags)
    with path.open("rb+") as fh:
        return _replace_in_file_handle(fh, expr, replacement.encode())


def _replace_in_file_handle(fh, expr, replacement):
    content = fh.read()
    content, count = expr.subn(replacement, content)

    # Don't bother writing the file if we didn't change
    # anything.
    if count:
        fh.seek(0)
        fh.write(content)
        fh.truncate()
    return count


def replace(
    sources: ListOfPathsOrStrs, before: str, after: str, flags: int = re.MULTILINE
) -> int:
    """Replaces occurrences of before with after in all the given sources.

    Returns:
      The number of times the text was found and replaced across all files.
    """
    expr = re.compile(before, flags=flags or 0)
    paths = _filter_files(_expand_paths(sources, "."))

    if not paths:
        logger.warning(f"No files were found in sources {sources} for replace()")

    count_replaced = 0
    for path in paths:
        replaced = _replace_in_file(path, expr, after)
        count_replaced += replaced
        if replaced:
            logger.info(f"Replaced {before!r} in {path}.")

    if not count_replaced:
        logger.warning(
            f"No replacements made in {sources} for pattern {before}, maybe "
            "replacement is no longer needed?"
        )
    return count_replaced


def get_staging_dirs(
    default_version: Optional[str] = None, staging_path: Optional[str] = None
) -> List[Path]:
    """Returns the list of directories, one per version, copied from
    https://github.com/googleapis/googleapis-gen. Will return in lexical sorting
    order with the exception of the default_version which will be last (if specified).

    Args:
      default_version: the default version of the API. The directory for this version
        will be the last item in the returned list if specified.
      staging_path: the path to the staging directory.

    Returns: the empty list if no file were copied.
    """

    if staging_path:
        staging = Path(staging_path)
    else:
        staging = Path("owl-bot-staging")
    if staging.is_dir():
        # Collect the subdirectories of the staging directory.
        versions = [v.name for v in staging.iterdir() if v.is_dir()]
        # Reorder the versions so the default version always comes last.
        versions = [v for v in versions if v != default_version]
        versions.sort()
        if default_version is not None:
            versions += [default_version]
        dirs = [staging / v for v in versions]
        for dir in dirs:
            _tracked_paths.add(dir)
        return dirs
    else:
        return []


def remove_staging_dirs():
    """Removes all the staging directories."""
    staging = Path("owl-bot-staging")
    if staging.is_dir():
        shutil.rmtree(staging)
