# Copyright 2024 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# GitHub action job to test core java library features on
# downstream client libraries before they are released.
import re
from enum import Enum
import click as click

VERSION_PREFIX = r"^(grpc|proto)-"
VERSION_SUFFIX = r"-v[1-9].*$"


class VersionType(Enum):
    MAJOR = (1,)
    MINOR = (2,)
    PATCH = 3


@click.group(invoke_without_command=False)
@click.pass_context
@click.version_option(message="%(version)s")
def main(ctx):
    pass


@main.command()
@click.option(
    "--artifact-ids",
    required=True,
    type=str,
    help="""
    Artifact IDs whose version needs to update, separated by comma.
    """,
)
@click.option(
    "--version-type",
    required=False,
    default="patch",
    type=str,
    help="""
    The type of version bump, one of major, minor or patch.
    """,
)
@click.option(
    "--versions",
    required=False,
    default="./versions.txt",
    type=str,
    help="""
    The path to the versions.txt.
    """,
)
def bump_released_version(artifact_ids: str, version_type: str, versions: str) -> None:
    target_artifact_ids = set(artifact_ids.split(","))
    version_enum = _parse_type_or_raise(version_type)
    newlines = []
    with open(versions) as versions_file:
        for num, line in enumerate(versions_file):
            striped_line = line.strip()
            # case 1: skip an empty line.
            if striped_line == "":
                newlines.append("")
                continue
            # case 2: keep a comment.
            if striped_line.startswith("#"):
                newlines.append(f"{striped_line}")
                continue
            values = striped_line.split(":")
            artifact_id = values[0]
            released_version = values[1]
            sanitized_artifact_id = _sanitize(artifact_id)
            # case 3: keep the line if the artifact id is not matched.
            if sanitized_artifact_id not in target_artifact_ids:
                newlines.append(f"{striped_line}")
                continue
            # case 4: bump version according to version type.
            major, minor, patch = [
                int(ver_num) for ver_num in released_version.split(".")
            ]
            match version_enum:
                case VersionType.MAJOR:
                    major += 1
                case VersionType.MINOR:
                    minor += 1
                case VersionType.PATCH:
                    patch += 1
            newlines.append(
                f"{artifact_id}:{major}.{minor}.{patch}:{major}.{minor}.{patch}"
            )
    with open(versions, "w") as versions_file:
        versions_file.writelines("\n".join(newlines))


def _parse_type_or_raise(version_type: str) -> VersionType:
    try:
        version_enum = VersionType[version_type.upper()]
    except KeyError:
        raise KeyError(
            f"Version type {version_type} is not supported.\n"
            f"Supported types are MAJOR, MINOR AND PATCH."
        )
    return version_enum


def _sanitize(artifact_id: str) -> str:
    # Remove the matching regex.
    temp = re.sub(VERSION_PREFIX, "", artifact_id)
    return re.sub(VERSION_SUFFIX, "", temp)


if __name__ == "__main__":
    main()
