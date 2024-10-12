import re
import tempfile
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
    "--artifact_ids",
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

    with tempfile.TemporaryFile(mode="w", delete=False) as temp_file:
        with open(versions) as versions_file:
            for line in versions_file:
                values = line.strip().split(":")
                if len(values) != 3:
                    continue
                artifact_id = values[0]
                released_version = values[1]
                sanitized_artifact_id = _sanitize(artifact_id)
                if sanitized_artifact_id not in target_artifact_ids:
                    temp_file.write(f"{line}\n")
                    continue
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
                temp_file.write(f"{artifact_id}:{major}:{minor}:{patch}\n")


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
