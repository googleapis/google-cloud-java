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

from pathlib import Path
import re

proto_library_pattern = r"""
proto_library_with_info\(
(.*?)
\)
"""
gapic_pattern = r"""
java_gapic_library\(
(.*?)
\)
"""
assembly_pattern = r"""
java_gapic_assembly_gradle_pkg\(
(.*?)
\)
"""
# match a line which the first character is "#".
comment_pattern = r"^\s*\#+"
pattern_to_proto = {
    r"//google/cloud:common_resources_proto": "google/cloud/common_resources.proto",
    r"//google/cloud/location:location_proto": "google/cloud/location/locations.proto",
    r"//google/iam/v1:iam_policy_proto": "google/iam/v1/iam_policy.proto",
}
transport_pattern = r"transport = \"(.*?)\""
rest_pattern = r"rest_numeric_enums = True"
gapic_yaml_pattern = r"gapic_yaml = \"(.*?)\""
service_config_pattern = r"grpc_service_config = \"(.*?)\""
service_yaml_pattern = r"service_yaml = \"(.*?)\""
include_samples_pattern = r"include_samples = True"


class GapicInputs:
    """
    A data class containing inputs to invoke generate_library.sh to generate
    a GAPIC library.
    """

    def __init__(
        self,
        proto_only="true",
        additional_protos="google/cloud/common_resources.proto",
        transport="grpc",
        rest_numeric_enum="",
        gapic_yaml="",
        service_config="",
        service_yaml="",
        include_samples="true",
    ):
        self.proto_only = proto_only
        self.additional_protos = additional_protos
        self.transport = transport
        self.rest_numeric_enum = rest_numeric_enum
        self.gapic_yaml = gapic_yaml
        self.service_config = service_config
        self.service_yaml = service_yaml
        self.include_samples = include_samples

    def __eq__(self, other):
        if not isinstance(other, GapicInputs):
            return False
        return (
            self.proto_only == other.proto_only
            and self.additional_protos == other.additional_protos
            and self.transport == other.transport
            and self.rest_numeric_enum == other.rest_numeric_enum
            and self.gapic_yaml == other.gapic_yaml
            and self.service_config == other.service_config
            and self.service_yaml == other.service_yaml
            and self.include_samples == other.include_samples
        )


def parse(
    build_path: Path, versioned_path: str, build_file_name: str = "BUILD.bazel"
) -> GapicInputs:
    """
    Utility function to parse inputs of generate_library.sh from BUILD.bazel.
    :param build_path: the file path of BUILD.bazel
    :param versioned_path: a versioned path in googleapis repository, e.g.,
    google/cloud/asset/v1.
    :param build_file_name: the name of the build file.
    :return: an GapicInputs object.
    """
    with open(f"{build_path}/{build_file_name}") as build:
        content = build.read()
    return parse_build_str(build_str=content, versioned_path=versioned_path)


def parse_build_str(build_str: str, versioned_path: str) -> GapicInputs:
    proto_library_target = re.compile(
        proto_library_pattern, re.DOTALL | re.VERBOSE
    ).findall(build_str)
    additional_protos = ""
    if len(proto_library_target) > 0:
        additional_protos = __parse_additional_protos(proto_library_target[0])
    gapic_target = re.compile(gapic_pattern, re.DOTALL | re.VERBOSE).findall(build_str)
    assembly_target = re.compile(assembly_pattern, re.DOTALL | re.VERBOSE).findall(
        build_str
    )
    include_samples = "false"
    if len(assembly_target) > 0:
        include_samples = __parse_include_samples(assembly_target[0])
    if len(gapic_target) == 0:
        return GapicInputs(
            additional_protos=additional_protos, include_samples=include_samples
        )

    transport = __parse_transport(gapic_target[0])
    rest_numeric_enum = __parse_rest_numeric_enums(gapic_target[0])
    gapic_yaml = __parse_gapic_yaml(gapic_target[0], versioned_path)
    service_config = __parse_service_config(gapic_target[0], versioned_path)
    service_yaml = __parse_service_yaml(gapic_target[0], versioned_path)

    return GapicInputs(
        proto_only="false",
        additional_protos=additional_protos,
        transport=transport,
        rest_numeric_enum=rest_numeric_enum,
        gapic_yaml=gapic_yaml,
        service_config=service_config,
        service_yaml=service_yaml,
        include_samples=include_samples,
    )


def __parse_additional_protos(proto_library_target: str) -> str:
    res = [" "]
    lines = proto_library_target.split("\n")
    for line in lines:
        if len(re.findall(comment_pattern, line)) != 0:
            # skip a line which the first charactor is "#" since it's
            # a comment.
            continue
        for pattern in pattern_to_proto:
            if len(re.findall(pattern, line)) == 0:
                continue
            res.append(pattern_to_proto[pattern])
    return " ".join(res)


def __parse_transport(gapic_target: str) -> str:
    transport = re.findall(transport_pattern, gapic_target)
    return transport[0] if len(transport) != 0 else "grpc"


def __parse_rest_numeric_enums(gapic_target: str) -> str:
    rest_numeric_enums = re.findall(rest_pattern, gapic_target)
    return "true" if len(rest_numeric_enums) != 0 else "false"


def __parse_gapic_yaml(gapic_target: str, versioned_path: str) -> str:
    gapic_yaml = re.findall(gapic_yaml_pattern, gapic_target)
    return f"{versioned_path}/{gapic_yaml[0]}" if len(gapic_yaml) != 0 else ""


def __parse_service_config(gapic_target: str, versioned_path: str) -> str:
    service_config = re.findall(service_config_pattern, gapic_target)
    return (
        f"{versioned_path}/{service_config[0]}".replace(":", "")
        if len(service_config) != 0
        else ""
    )


def __parse_service_yaml(gapic_target: str, versioned_path: str) -> str:
    service_yaml = re.findall(service_yaml_pattern, gapic_target)
    if len(service_yaml) == 0:
        return ""
    res = str(service_yaml[0])
    if res.startswith("//"):
        # special case if the service config starts with "//", is a Bazel
        # target with an absolute path.
        return res.replace("//", "").replace(":", "/")
    return f"{versioned_path}/{res}"


def __parse_include_samples(assembly_target: str) -> str:
    include_samples = re.findall(include_samples_pattern, assembly_target)
    return "true" if len(include_samples) != 0 else "false"
