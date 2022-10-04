#!/usr/bin/env python3
#  Copyright 2020 Google LLC
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

from repo_splitter.java.module import Module
from repo_splitter.java import templates
import os
import pathlib
import re
from typing import List


def write_parent_pom(
    path: str,
    service: str,
    name: str,
    modules: List[Module],
    module: Module,
    main_module: Module,
) -> None:
    """Creates a pom.xml file from a template."""
    templates.render(
        template_name="parent_pom.xml",
        output_name=path,
        modules=modules,
        module=module,
        main_module=main_module,
        name=name,
        service=service,
    )


def write_proto_pom(
    path: str, service: str, module: Module, parent_module: Module, main_module: Module,
) -> None:
    """Creates a pom.xml file from a template."""
    templates.render(
        template_name="proto_pom.xml",
        output_name=path,
        module=module,
        parent_module=parent_module,
        service=service,
        main_module=main_module,
    )


def write_grpc_pom(
    path: str,
    service: str,
    module: Module,
    parent_module: Module,
    proto_module: Module,
    main_module,
) -> None:
    """Creates a pom.xml file from a template."""
    service_version = re.match(r".*-(v[^\-]*)$", module.artifact_id)[1]
    templates.render(
        template_name="grpc_pom.xml",
        output_name=path,
        module=module,
        parent_module=parent_module,
        proto_module=proto_module,
        main_module=main_module,
        service=service,
        serviceVersion=service_version,
    )


def write_cloud_pom(
    path: str,
    service: str,
    module: Module,
    parent_module: Module,
    name: str,
    description: str,
    proto_modules: List[Module],
    grpc_modules: List[Module],
) -> None:
    """Creates a pom.xml file from a template."""
    templates.render(
        template_name="cloud_pom.xml",
        output_name=path,
        module=module,
        parent_module=parent_module,
        service=service,
        name=name,
        description=description,
        proto_modules=proto_modules,
        grpc_modules=grpc_modules,
    )


def write_bom_pom(
    path: str, service: str, name: str, modules: List[Module], main_module: Module
) -> None:
    """Creates a pom.xml file from a template."""
    templates.render(
        template_name="bom_pom.xml",
        output_name=path,
        service=service,
        name=name,
        modules=modules,
        main_module=main_module,
    )


def write_versions(path: str, modules: List[Module]):
    templates.render(
        template_name="versions.txt", output_name=path, modules=modules,
    )
