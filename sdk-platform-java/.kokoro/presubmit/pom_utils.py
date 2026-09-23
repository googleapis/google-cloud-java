#!/usr/bin/env python3
# Copyright 2026 Google LLC
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

"""Utility script for reading and manipulating Maven pom.xml files."""

import argparse
import sys
import xml.etree.ElementTree as ET

MAVEN_NAMESPACE = "http://maven.apache.org/POM/4.0.0"


def parse_pom_version(pom_path: str) -> str | None:
    """Extracts project version or parent version from pom.xml."""
    try:
        tree = ET.parse(pom_path)
        root = tree.getroot()
        version_elem = root.find("{*}version")
        if version_elem is None:
            version_elem = root.find("{*}parent/{*}version")
        if version_elem is not None and version_elem.text:
            return version_elem.text.strip()
    except Exception as e:
        sys.stderr.write(f"Error parsing version from {pom_path}: {e}\n")
    return None


def has_versioned_dependency(pom_path: str, artifact_id: str) -> bool:
    """Checks if a pom.xml defines a <version> tag for the given artifactId."""
    try:
        tree = ET.parse(pom_path)
        root = tree.getroot()
        for elem in root.iter():
            art = elem.find("{*}artifactId")
            ver = elem.find("{*}version")
            if (
                art is not None
                and art.text == artifact_id
                and ver is not None
                and ver.text
            ):
                return True
    except Exception as e:
        sys.stderr.write(f"Error checking dependency in {pom_path}: {e}\n")
    return False


def get_dependency_version(pom_path: str, artifact_id: str) -> str | None:
    """Returns the version for the given artifactId in pom.xml."""
    try:
        tree = ET.parse(pom_path)
        root = tree.getroot()
        for elem in root.iter():
            art = elem.find("{*}artifactId")
            ver = elem.find("{*}version")
            if (
                art is not None
                and art.text == artifact_id
                and ver is not None
                and ver.text
            ):
                return ver.text.strip()
    except Exception as e:
        sys.stderr.write(f"Error reading dependency version from {pom_path}: {e}\n")
    return None


def update_dependency_version(
    pom_path: str, artifact_id: str, new_version: str
) -> bool:
    """Updates the version for the given artifactId in pom.xml."""
    try:
        ET.register_namespace("", MAVEN_NAMESPACE)
        tree = ET.parse(pom_path)
        root = tree.getroot()
        updated = False
        for elem in root.iter():
            art = elem.find("{*}artifactId")
            ver = elem.find("{*}version")
            if art is not None and art.text == artifact_id and ver is not None:
                ver.text = new_version
                updated = True
        if updated:
            tree.write(pom_path, encoding="utf-8", xml_declaration=True)
            return True
    except Exception as e:
        sys.stderr.write(f"Error updating dependency in {pom_path}: {e}\n")
    return False


def update_property_value(
    pom_path: str, property_name: str, new_value: str
) -> bool:
    """Updates the value of a named property in <properties> of pom.xml."""
    try:
        ET.register_namespace("", MAVEN_NAMESPACE)
        tree = ET.parse(pom_path)
        root = tree.getroot()
        updated = False
        for prop in root.findall(".//{*}properties"):
            target = prop.find(f"{{*}}{property_name}")
            if target is not None:
                target.text = new_value
                updated = True
        if updated:
            tree.write(pom_path, encoding="utf-8", xml_declaration=True)
            return True
    except Exception as e:
        sys.stderr.write(f"Error updating property in {pom_path}: {e}\n")
    return False


def get_coordinates(pom_path: str) -> tuple[str, str, str]:
    """Returns (groupId, artifactId, version) from pom.xml."""
    try:
        tree = ET.parse(pom_path)
        root = tree.getroot()
        gid = root.find("{*}groupId")
        aid = root.find("{*}artifactId")
        ver = root.find("{*}version")
        if gid is None:
            gid = root.find("{*}parent/{*}groupId")
        if ver is None:
            ver = root.find("{*}parent/{*}version")
        return (
            gid.text.strip() if gid is not None and gid.text else "",
            aid.text.strip() if aid is not None and aid.text else "",
            ver.text.strip() if ver is not None and ver.text else "",
        )
    except Exception as e:
        sys.stderr.write(f"Error reading coordinates from {pom_path}: {e}\n")
        return ("", "", "")


def main():
    parser = argparse.ArgumentParser(description="Maven POM XML utility CLI")
    subparsers = parser.add_subparsers(dest="command", required=True)

    # get-version
    get_version_parser = subparsers.add_parser(
        "get-version", help="Get project version from pom.xml"
    )
    get_version_parser.add_argument("pom_file", help="Path to pom.xml")

    # has-versioned-dep
    has_dep_parser = subparsers.add_parser(
        "has-versioned-dep",
        help="Check if pom.xml declares a versioned dependency for an artifact",
    )
    has_dep_parser.add_argument("pom_file", help="Path to pom.xml")
    has_dep_parser.add_argument("artifact_id", help="Artifact ID to search for")

    # get-dep-version
    get_dep_ver_parser = subparsers.add_parser(
        "get-dep-version",
        help="Get version for an artifactId in pom.xml",
    )
    get_dep_ver_parser.add_argument("pom_file", help="Path to pom.xml")
    get_dep_ver_parser.add_argument("artifact_id", help="Artifact ID to search for")

    # update-dep-version
    update_dep_parser = subparsers.add_parser(
        "update-dep-version",
        help="Update version for an artifactId in pom.xml",
    )
    update_dep_parser.add_argument("pom_file", help="Path to pom.xml")
    update_dep_parser.add_argument("artifact_id", help="Artifact ID to update")
    update_dep_parser.add_argument("new_version", help="New version to set")

    # update-property
    update_prop_parser = subparsers.add_parser(
        "update-property",
        help="Update property value in pom.xml",
    )
    update_prop_parser.add_argument("pom_file", help="Path to pom.xml")
    update_prop_parser.add_argument("property_name", help="Property tag name to update")
    update_prop_parser.add_argument("new_value", help="New value to set")

    # get-coordinates
    coord_parser = subparsers.add_parser(
        "get-coordinates", help="Get groupId, artifactId, and version"
    )
    coord_parser.add_argument("pom_file", help="Path to pom.xml")

    args = parser.parse_args()

    if args.command == "get-version":
        version = parse_pom_version(args.pom_file)
        if version:
            print(version)
            sys.exit(0)
        else:
            sys.exit(1)

    elif args.command == "has-versioned-dep":
        found = has_versioned_dependency(args.pom_file, args.artifact_id)
        sys.exit(0 if found else 1)

    elif args.command == "get-dep-version":
        ver = get_dependency_version(args.pom_file, args.artifact_id)
        if ver:
            print(ver)
            sys.exit(0)
        else:
            sys.exit(1)

    elif args.command == "update-dep-version":
        success = update_dependency_version(
            args.pom_file, args.artifact_id, args.new_version
        )
        sys.exit(0 if success else 1)

    elif args.command == "update-property":
        success = update_property_value(
            args.pom_file, args.property_name, args.new_value
        )
        sys.exit(0 if success else 1)

    elif args.command == "get-coordinates":
        gid, aid, ver = get_coordinates(args.pom_file)
        print(f"{gid} {aid} {ver}")
        sys.exit(0 if aid else 1)


if __name__ == "__main__":
    main()
