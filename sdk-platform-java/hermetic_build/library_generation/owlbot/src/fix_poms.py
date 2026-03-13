# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#   https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import sys
import glob
import json
from xml.etree.ElementTree import ElementTree

from lxml import etree
import os
import re
from typing import List, Mapping
from library_generation.owlbot.src.poms import module, templates


def load_versions(filename: str, default_group_id: str) -> Mapping[str, module.Module]:
    if not os.path.isfile(filename):
        return {}
    modules = {}
    with open(filename, "r") as fp:
        for line in fp:
            line = line.strip()
            if line.startswith("#"):
                continue

            parts = line.split(":")
            if len(parts) == 3:
                artifact_id = parts[0]
                group_id = (
                    # For artifact id starts with `proto-` or `grpc-`, we
                    # need special treatments to append `.api.grpc` suffix
                    # to its corresponding group id.
                    # For other artifact id, keep the existing group id.
                    # Other than the two aforementioned artifact id, do not
                    # assume artifact id always starts with `google-`. Known
                    # exception is ad-manager.
                    __proto_group_id(default_group_id)
                    if artifact_id.startswith("proto-")
                    or artifact_id.startswith("grpc-")
                    else default_group_id
                )
                modules[artifact_id] = module.Module(
                    group_id=group_id,
                    artifact_id=artifact_id,
                    release_version=parts[1],
                    version=parts[2],
                )
    return modules


def _find_dependency_index(dependencies, group_id, artifact_id) -> int:
    try:
        return next(
            i
            for i, x in enumerate(dependencies.getchildren())
            if _dependency_matches(x, group_id, artifact_id)
        )
    except StopIteration:
        return -1


def _dependency_matches(node, group_id, artifact_id) -> bool:
    artifact_node = node.find("{http://maven.apache.org/POM/4.0.0}artifactId")
    group_node = node.find("{http://maven.apache.org/POM/4.0.0}groupId")

    if artifact_node is None or group_node is None:
        return False

    return artifact_node.text.startswith(artifact_id) and group_node.text.startswith(
        group_id
    )


def _is_cloud_client(existing_modules: List[module.Module]) -> bool:
    proto_modules_len = 0
    grpc_modules_len = 0
    for artifact in existing_modules:
        if artifact.startswith("proto-"):
            proto_modules_len += 1
        if artifact.startswith("grpc-"):
            grpc_modules_len += 1
    return proto_modules_len > 0 or grpc_modules_len > 0


def update_cloud_pom(
    filename: str,
    proto_modules: List[module.Module],
    grpc_modules: List[module.Module],
    is_monorepo: bool,
):
    tree = etree.parse(filename)
    root = tree.getroot()
    dependencies = root.find("{http://maven.apache.org/POM/4.0.0}dependencies")

    existing_dependencies = [
        m.find("{http://maven.apache.org/POM/4.0.0}artifactId").text
        for m in dependencies
        if m.find("{http://maven.apache.org/POM/4.0.0}artifactId") is not None
    ]

    if is_monorepo:
        _set_test_scoped_deps(dependencies)

    try:
        grpc_index = _find_dependency_index(
            dependencies, "com.google.api.grpc", "grpc-"
        )
    except StopIteration:
        grpc_index = _find_dependency_index(dependencies, "junit", "junit")
    # insert grpc dependencies after junit
    for m in grpc_modules:
        if m.artifact_id not in existing_dependencies:
            print(f"adding new test dependency {m.artifact_id}")
            new_dependency = etree.Element(
                "{http://maven.apache.org/POM/4.0.0}dependency"
            )
            new_dependency.tail = "\n    "
            new_dependency.text = "\n      "
            new_group = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
            new_group.text = m.group_id
            new_group.tail = "\n      "
            new_artifact = etree.Element(
                "{http://maven.apache.org/POM/4.0.0}artifactId"
            )
            new_artifact.text = m.artifact_id
            new_artifact.tail = "\n      "
            new_scope = etree.Element("{http://maven.apache.org/POM/4.0.0}scope")
            new_scope.text = "test"
            new_scope.tail = "\n    "
            new_dependency.append(new_group)
            new_dependency.append(new_artifact)
            new_dependency.append(new_scope)
            dependencies.insert(grpc_index + 1, new_dependency)

    try:
        proto_index = _find_dependency_index(
            dependencies, "com.google.api.grpc", "proto-"
        )
    except StopIteration:
        print("after protobuf")
        proto_index = _find_dependency_index(
            dependencies, "com.google.protobuf", "protobuf-java"
        )
    # insert proto dependencies after protobuf-java
    for m in proto_modules:
        if m.artifact_id not in existing_dependencies:
            if re.match(r"proto-.*-v\d+.*", m.artifact_id):
                print(f"adding new dependency {m.artifact_id}")
                new_dependency = etree.Element(
                    "{http://maven.apache.org/POM/4.0.0}dependency"
                )
                new_dependency.tail = "\n    "
                new_dependency.text = "\n      "
                new_group = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
                new_group.text = m.group_id
                new_group.tail = "\n      "
                new_artifact = etree.Element(
                    "{http://maven.apache.org/POM/4.0.0}artifactId"
                )
                new_artifact.text = m.artifact_id
                new_artifact.tail = "\n    "
                new_dependency.append(new_group)
                new_dependency.append(new_artifact)
                dependencies.insert(proto_index + 1, new_dependency)

    tree.write(filename, pretty_print=True, xml_declaration=True, encoding="utf-8")


def _set_test_scoped_deps(dependencies: list[ElementTree]) -> None:
    """
    As of July 2024, we have two dependencies that should be declared as
    test-scoped in a monorepo: grpc-google-common-protos and grpc-google-iam-v1.
    HW libraries are treated as usual
    :param dependencies: List of XML Objects representing a <dependency/>
    """
    TEST_SCOPED_DEPENDENCIES = ["grpc-google-common-protos", "grpc-google-iam-v1"]
    print(
        'converting dependencies "grpc-google-common-protos" and "grpc-google-iam-v1" to test-scoped'
    )
    for d in dependencies:
        artifact_query = "{http://maven.apache.org/POM/4.0.0}artifactId"
        scope_query = "{http://maven.apache.org/POM/4.0.0}scope"
        current_scope = d.find(scope_query)
        artifact_id_elem = d.find(artifact_query)
        if artifact_id_elem is None:
            continue
        artifact_id = artifact_id_elem.text
        is_test_scoped = (
            current_scope.text == "test" if current_scope is not None else False
        )
        if artifact_id in TEST_SCOPED_DEPENDENCIES and not is_test_scoped:
            new_scope = etree.Element(scope_query)
            new_scope.text = "test"
            if current_scope is not None:
                d.replace(current_scope, new_scope)
            else:
                d.append(new_scope)
            new_scope.tail = "\n    "
            new_scope.getprevious().tail = "\n      "


def update_parent_pom(filename: str, modules: List[module.Module]):
    tree = etree.parse(filename)
    root = tree.getroot()

    # BEGIN: update modules
    existing = root.find("{http://maven.apache.org/POM/4.0.0}modules")

    module_names = [m.artifact_id for m in modules]
    extra_modules = [
        m.text for i, m in enumerate(existing) if m.text not in module_names
    ]

    modules_to_write = module_names + extra_modules
    num_modules = len(modules_to_write)

    existing.clear()
    existing.text = "\n    "
    for index, m in enumerate(modules_to_write):
        new_module = etree.Element("{http://maven.apache.org/POM/4.0.0}module")
        new_module.text = m
        if index == num_modules - 1:
            new_module.tail = "\n  "
        else:
            new_module.tail = "\n    "
        existing.append(new_module)

    existing.tail = "\n\n  "
    # END: update modules

    # BEGIN: update versions in dependencyManagement
    dependencies = root.find(
        "{http://maven.apache.org/POM/4.0.0}dependencyManagement"
    ).find("{http://maven.apache.org/POM/4.0.0}dependencies")

    existing_dependencies = [
        m.find("{http://maven.apache.org/POM/4.0.0}artifactId").text
        for m in dependencies
        if m.find("{http://maven.apache.org/POM/4.0.0}artifactId") is not None
    ]
    insert_index = 1

    num_modules = len(modules)

    for index, m in enumerate(modules):
        if m.artifact_id in existing_dependencies:
            continue

        new_dependency = etree.Element("{http://maven.apache.org/POM/4.0.0}dependency")
        new_dependency.tail = "\n      "
        new_dependency.text = "\n        "
        new_group = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
        new_group.text = m.group_id
        new_group.tail = "\n        "
        new_artifact = etree.Element("{http://maven.apache.org/POM/4.0.0}artifactId")
        new_artifact.text = m.artifact_id
        new_artifact.tail = "\n        "
        new_version = etree.Element("{http://maven.apache.org/POM/4.0.0}version")
        new_version.text = m.version
        comment = etree.Comment(" {x-version-update:" + m.artifact_id + ":current} ")
        comment.tail = "\n      "
        new_dependency.append(new_group)
        new_dependency.append(new_artifact)
        new_dependency.append(new_version)
        new_dependency.append(comment)
        new_dependency.tail = "\n      "
        dependencies.insert(1, new_dependency)

    # END: update versions in dependencyManagement

    tree.write(filename, pretty_print=True, xml_declaration=True, encoding="utf-8")


def update_bom_pom(filename: str, modules: List[module.Module]):
    tree = etree.parse(filename)
    root = tree.getroot()
    existing = root.find(
        "{http://maven.apache.org/POM/4.0.0}dependencyManagement"
    ).find("{http://maven.apache.org/POM/4.0.0}dependencies")

    num_modules = len(modules)

    existing.clear()
    existing.text = "\n      "
    for index, m in enumerate(modules):
        new_dependency = etree.Element("{http://maven.apache.org/POM/4.0.0}dependency")
        new_dependency.tail = "\n      "
        new_dependency.text = "\n        "
        new_group = etree.Element("{http://maven.apache.org/POM/4.0.0}groupId")
        new_group.text = m.group_id
        new_group.tail = "\n        "
        new_artifact = etree.Element("{http://maven.apache.org/POM/4.0.0}artifactId")
        new_artifact.text = m.artifact_id
        new_artifact.tail = "\n        "
        new_version = etree.Element("{http://maven.apache.org/POM/4.0.0}version")
        new_version.text = m.version
        comment = etree.Comment(" {x-version-update:" + m.artifact_id + ":current} ")
        comment.tail = "\n      "
        new_dependency.append(new_group)
        new_dependency.append(new_artifact)
        new_dependency.append(new_version)
        new_dependency.append(comment)

        if index == num_modules - 1:
            new_dependency.tail = "\n    "
        else:
            new_dependency.tail = "\n      "
        existing.append(new_dependency)

    existing.tail = "\n  "

    tree.write(filename, pretty_print=True, xml_declaration=True, encoding="utf-8")


# When generating non-cloud client library, the group id of proto/grpc artifacts
# is prefixed with `{main_artifact_group_id}.api.grpc`, rather than
# `com.google.api.grpc`.
# https://github.com/googleapis/google-cloud-java/issues/9125
# However, some exceptions are com.google.area120 and com.google.analytics.
# https://github.com/googleapis/google-cloud-java/issues/9304
def __proto_group_id(main_artifact_group_id: str) -> str:
    prefix = "com.google"
    list_of_group_id = [
        "com.google.cloud",
        "com.google.area120",
        "com.google.analytics",
    ]
    if main_artifact_group_id not in list_of_group_id:
        prefix = main_artifact_group_id
    return f"{prefix}.api.grpc"


def __get_monorepo_version(versions: str) -> str:
    """
    Returns the current version of google-cloud-java in the given version file
    :param versions: the versions.txt
    :return: the current version of google-cloud-java
    """
    with open(versions, "r") as f:
        for line in f.readlines():
            if "google-cloud-java" in line:
                return line.split(":")[-1].strip()


def main(versions_file, monorepo):
    print(f"working directory: {os.getcwd()}")
    with open(".repo-metadata.json", "r") as fp:
        repo_metadata = json.load(fp)
    group_id, artifact_id = repo_metadata["distribution_name"].split(":")
    name = repo_metadata["name_pretty"]
    existing_modules = load_versions(versions_file, group_id)
    print(f"monorepo? {monorepo}")

    # extra modules that need to be manages in versions.txt
    if "extra_versioned_modules" in repo_metadata:
        extra_managed_modules = repo_metadata["extra_versioned_modules"].split(",")
    else:
        extra_managed_modules = ""

    # list of modules to be excluded from added to poms
    if "excluded_dependencies" in repo_metadata:
        excluded_dependencies_list = repo_metadata["excluded_dependencies"].split(",")
    else:
        excluded_dependencies_list = ""

    # list of poms that have to be excluded from post processing
    if "excluded_poms" in repo_metadata:
        excluded_poms_list = repo_metadata["excluded_poms"].split(",")
    else:
        excluded_poms_list = ""

    # Missing Case 1: When this library ('java-XXX' module) is new.
    if artifact_id not in existing_modules:
        existing_modules[artifact_id] = module.Module(
            group_id=group_id,
            artifact_id=artifact_id,
            version="0.0.1-SNAPSHOT",
            release_version="0.0.0",
        )
    main_module = existing_modules[artifact_id]

    # Artifact ID is part of distribution name field in .repo-metadata.json
    if artifact_id in [
        "grafeas",
        "google-cloud-dns",
        "google-cloud-notification",
        "google-iam-policy",
    ]:
        # There are special libraries that are not automatically generated
        print(
            f"Skipping a special case library {artifact_id} that do not have "
            " the standard module structure."
        )
        return

    parent_artifact_id = f"{artifact_id}-parent"

    if parent_artifact_id not in existing_modules:
        existing_modules[parent_artifact_id] = module.Module(
            group_id=group_id,
            artifact_id=parent_artifact_id,
            version=main_module.version,
            release_version=main_module.release_version,
        )
    parent_module = existing_modules[parent_artifact_id]

    required_dependencies = {}
    for dependency_module in existing_modules:
        if dependency_module in excluded_dependencies_list:
            continue
        dep_artifact_id = existing_modules[dependency_module].artifact_id
        if monorepo and not os.path.isdir(dep_artifact_id):
            # In monorepo, existing_modules are loaded from the root
            # versions.txt and thus includes irrelevant artifacts
            continue
        required_dependencies[dependency_module] = existing_modules[dependency_module]

    # Missing Case 2: There's a new proto-XXX and grpc-XXX directory. It's a new
    # version in the proto file to a library. Both a new library and existing
    # library.
    for path in glob.glob("proto-*"):
        if not path in existing_modules:
            existing_modules[path] = module.Module(
                group_id=__proto_group_id(group_id),
                artifact_id=path,
                version=main_module.version,
                release_version=main_module.release_version,
            )
            if (
                path not in excluded_dependencies_list
                and path not in main_module.artifact_id
            ):
                required_dependencies[path] = module.Module(
                    group_id=__proto_group_id(group_id),
                    artifact_id=path,
                    version=main_module.version,
                    release_version=main_module.release_version,
                )
        if not os.path.isfile(f"{path}/pom.xml"):
            print(f"creating missing proto pom: {path}")
            templates.render(
                template_name="proto_pom.xml.j2",
                output_name=f"{path}/pom.xml",
                module=required_dependencies[path],
                parent_module=parent_module,
                main_module=main_module,
                monorepo=monorepo,
            )
            if (
                path not in excluded_dependencies_list
                and path not in main_module.artifact_id
            ):
                required_dependencies[path] = module.Module(
                    group_id=__proto_group_id(group_id),
                    artifact_id=path,
                    version=main_module.version,
                    release_version=main_module.release_version,
                )

    for path in glob.glob("grpc-*"):
        if not path in existing_modules:
            existing_modules[path] = module.Module(
                group_id=__proto_group_id(group_id),
                artifact_id=path,
                version=main_module.version,
                release_version=main_module.release_version,
            )
            if (
                path not in excluded_dependencies_list
                and path not in main_module.artifact_id
            ):
                required_dependencies[path] = module.Module(
                    group_id=__proto_group_id(group_id),
                    artifact_id=path,
                    version=main_module.version,
                    release_version=main_module.release_version,
                )

        if not os.path.isfile(f"{path}/pom.xml"):
            proto_artifact_id = path.replace("grpc-", "proto-")
            print(f"creating missing grpc pom: {path}")
            templates.render(
                template_name="grpc_pom.xml.j2",
                output_name=f"{path}/pom.xml",
                module=required_dependencies[path],
                parent_module=parent_module,
                main_module=main_module,
                proto_module=existing_modules[proto_artifact_id],
                monorepo=monorepo,
            )
            if (
                path not in excluded_dependencies_list
                and path not in main_module.artifact_id
            ):
                required_dependencies[path] = module.Module(
                    group_id=__proto_group_id(group_id),
                    artifact_id=path,
                    version=main_module.version,
                    release_version=main_module.release_version,
                )
    proto_modules = [
        module
        for module in required_dependencies.values()
        if module.artifact_id.startswith("proto-")
        and module.artifact_id not in parent_artifact_id
    ]
    grpc_modules = [
        module
        for module in required_dependencies.values()
        if module.artifact_id.startswith("grpc-")
        and module.artifact_id not in parent_artifact_id
    ]
    if main_module in grpc_modules or main_module in proto_modules:
        modules = grpc_modules + proto_modules
    else:
        modules = [main_module] + grpc_modules + proto_modules

    if not _is_cloud_client(existing_modules):
        print("no proto or grpc modules - probably not a cloud client")
        return

    if os.path.isfile(f"{artifact_id}/pom.xml"):
        print("updating modules in cloud pom.xml")
        if artifact_id not in excluded_poms_list:
            update_cloud_pom(
                f"{artifact_id}/pom.xml", proto_modules, grpc_modules, monorepo
            )
    elif artifact_id not in excluded_poms_list:
        print("creating missing cloud pom.xml")
        templates.render(
            template_name="cloud_pom.xml.j2",
            output_name=f"{artifact_id}/pom.xml",
            module=main_module,
            parent_module=parent_module,
            repo=repo_metadata["repo"],
            name=name,
            description=repo_metadata["api_description"],
            proto_modules=proto_modules,
            grpc_modules=grpc_modules,
            monorepo=monorepo,
        )

    if os.path.isfile(f"{artifact_id}-bom/pom.xml"):
        print("updating modules in bom pom.xml")
        if artifact_id + "-bom" not in excluded_poms_list:
            update_bom_pom(f"{artifact_id}-bom/pom.xml", modules)
    elif artifact_id + "-bom" not in excluded_poms_list:
        print("creating missing bom pom.xml")
        monorepo_version = __get_monorepo_version(versions_file) if monorepo else ""
        templates.render(
            template_name="bom_pom.xml.j2",
            output_name=f"{artifact_id}-bom/pom.xml",
            repo=repo_metadata["repo"],
            name=name,
            modules=modules,
            main_module=main_module,
            monorepo=monorepo,
            monorepo_version=monorepo_version,
        )

    if os.path.isfile("pom.xml"):
        print("updating modules in parent pom.xml")
        update_parent_pom("pom.xml", modules)
    else:
        print("creating missing parent pom.xml")
        monorepo_version = __get_monorepo_version(versions_file) if monorepo else ""
        templates.render(
            template_name="parent_pom.xml.j2",
            output_name="./pom.xml",
            repo=repo_metadata["repo"],
            modules=modules,
            main_module=main_module,
            name=name,
            monorepo=monorepo,
            monorepo_version=monorepo_version,
        )

    print(f"updating modules in {versions_file}")
    existing_modules.pop(parent_artifact_id)

    # add extra modules to versions.txt
    for dependency_module in extra_managed_modules:
        if dependency_module not in existing_modules:
            existing_modules[dependency_module] = module.Module(
                group_id=__proto_group_id(group_id),
                artifact_id=dependency_module,
                version=main_module.version,
                release_version=main_module.release_version,
            )
    templates.render(
        template_name="versions.txt.j2",
        output_name=versions_file,
        modules=existing_modules.values(),
    )


if __name__ == "__main__":
    versions_file = sys.argv[1]
    monorepo = True if sys.argv[2].lower() == "true" else False
    main(versions_file, monorepo)
