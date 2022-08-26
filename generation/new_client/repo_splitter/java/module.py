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

import attr
from lxml import etree
import os
from typing import List, Optional


@attr.s(auto_attribs=True)
class Module:
    group_id: str
    artifact_id: str
    version: str
    release_version: Optional[str]


def read_module(pom: str) -> Module:
    tree = etree.parse(pom)
    artifact_id = tree.find("{http://maven.apache.org/POM/4.0.0}artifactId").text
    version = tree.find("{http://maven.apache.org/POM/4.0.0}version").text
    group_id = (
        "com.google.cloud"
        if artifact_id.startswith("google-cloud")
        else "com.google.api.grpc"
    )
    return Module(group_id=group_id, artifact_id=artifact_id, version=version,)


def read_modules(service: str) -> List[Module]:
    thedir = f"workspace/java-{service}/"
    modules = []
    for name in os.listdir(thedir):
        dir = os.path.join(thedir, name)
        pom = os.path.join(dir, "pom.xml")
        if os.path.exists(pom):
            modules.append(read_module(pom))

    return modules
