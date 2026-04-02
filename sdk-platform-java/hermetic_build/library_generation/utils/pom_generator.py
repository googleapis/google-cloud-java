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
from pathlib import Path

from lxml import etree
from typing import List

from library_generation.model.bom_config import BomConfig
from library_generation.utils.file_render import render

project_tag = "{http://maven.apache.org/POM/4.0.0}"
group_id_tag = "groupId"
artifact_tag = "artifactId"
version_tag = "version"


def generate_root_pom(repository_path: str) -> None:
    print("Regenerating root pom.xml")
    modules = __search_for_java_modules(repository_path)
    render(
        template_name="root-pom.xml.j2",
        output_name=f"{repository_path}/pom.xml",
        modules=modules,
    )


def generate_gapic_bom(repository_path: str, versions_file: str) -> None:
    print("Regenerating gapic-libraries-bom")
    bom_configs = __search_for_bom_artifact(repository_path)
    monorepo_version = get_version_from(
        versions_file=versions_file,
        artifact_id="google-cloud-java",
    )
    render(
        template_name="gapic-libraries-bom.xml.j2",
        output_name=f"{repository_path}/gapic-libraries-bom/pom.xml",
        monorepo_version=monorepo_version,
        bom_configs=bom_configs,
    )


def get_version_from(
    versions_file: str, artifact_id: str, is_released: bool = False
) -> str:
    """
    Get version of a given artifact from versions.txt
    :param versions_file: the path of version.txt
    :param artifact_id: the artifact id
    :param is_released: whether returns the released or current version
    :return: the version of the artifact
    """
    index = 1 if is_released else 2
    with open(versions_file, "r") as f:
        for line in f.readlines():
            if artifact_id in line:
                return line.split(":")[index].strip()


MODULE_ALLOWLIST = set(
    [
        "google-auth-library-java",
        "sdk-platform-java",
    ]
)


def __search_for_java_modules(
    repository_path: str,
) -> List[str]:
    repo = Path(repository_path).resolve()
    modules = []
    for sub_dir in repo.iterdir():
        if sub_dir.is_dir() and (
            sub_dir.name.startswith("java-") or sub_dir.name in MODULE_ALLOWLIST
        ):
            modules.append(sub_dir.name)
    return sorted(modules)


def __search_for_bom_artifact(
    repository_path: str,
) -> List[BomConfig]:
    repo = Path(repository_path).resolve()
    module_exclusions = ["gapic-libraries-bom"]
    group_id_inclusions = [
        "com.google.cloud",
        "com.google.analytics",
        "com.google.area120",
    ]
    bom_configs = []
    for module in repo.iterdir():
        if module.is_file() or module.name in module_exclusions:
            continue
        for sub_module in module.iterdir():
            if sub_module.is_dir() and sub_module.name.endswith("-bom"):
                root = etree.parse(f"{sub_module}/pom.xml").getroot()
                group_id = root.find(f"{project_tag}{group_id_tag}").text
                if group_id not in group_id_inclusions:
                    continue
                artifact_id = root.find(f"{project_tag}{artifact_tag}").text
                version = root.find(f"{project_tag}{version_tag}").text
                index = artifact_id.rfind("-")
                version_annotation = artifact_id[:index]
                bom_configs.append(
                    BomConfig(
                        group_id=group_id,
                        artifact_id=artifact_id,
                        version=version,
                        version_annotation=version_annotation,
                    )
                )
    # handle edge case: java-grafeas
    bom_configs += __handle_special_bom(
        repository_path=repository_path,
        module="java-grafeas",
        group_id="io.grafeas",
        artifact_id="grafeas",
    )
    # handle edge case: java-dns
    bom_configs += __handle_special_bom(
        repository_path=repository_path,
        module="java-dns",
        group_id="com.google.cloud",
        artifact_id="google-cloud-dns",
    )
    # handle edge case: java-notification
    bom_configs += __handle_special_bom(
        repository_path=repository_path,
        module="java-notification",
        group_id="com.google.cloud",
        artifact_id="google-cloud-notification",
    )

    return sorted(bom_configs)


def __handle_special_bom(
    repository_path: str,
    module: str,
    group_id: str,
    artifact_id: str,
) -> List[BomConfig]:
    pom = f"{repository_path}/{module}/pom.xml"
    if not Path(pom).exists():
        return []
    root = etree.parse(pom).getroot()
    version = root.find(f"{project_tag}{version_tag}").text
    return [
        BomConfig(
            group_id=group_id,
            artifact_id=artifact_id,
            version=version,
            version_annotation=artifact_id,
            is_import=False,
        )
    ]
