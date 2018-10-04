# Copyright 2018 Google LLC
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

"""This script is used to synthesize generated parts of this library."""

import os
import synthtool as s
import logging

from synthtool import log
from synthtool import _tracked_paths
from synthtool import shell
from synthtool.sources import git

logging.basicConfig(level=logging.DEBUG)

discovery_url = "https://github.com/googleapis/discovery-artifact-manager.git"

log.debug(f"Cloning {discovery_url}.")
discovery = git.clone(discovery_url, depth=1)

def generate(config, root_dir):
    image = "googleapis/artman:latest"
    log.debug("Pulling artman image.")
    shell.run(["docker", "pull", image])

    output_dir = root_dir / "artman-genfiles"

    docker_cmd = [
        "docker",
        "run",
        "--rm",
        "-i",
        "-e",
        f"HOST_USER_ID={os.getuid()}",
        "-e",
        f"HOST_GROUP_ID={os.getgid()}",
        "-e",
        "RUNNING_IN_ARTMAN_DOCKER=True",
        "-v",
        f"{root_dir}:{root_dir}",
        "-v",
        f"{output_dir}:{output_dir}",
        "-w",
        root_dir,
        image,
        "/bin/bash",
        "-c",
    ]

    config_yaml = root_dir / config
    artman_command = " ".join(
        map(str, ["artman", "--local", "--config", config_yaml, "generate", "java_discogapic"])
    )

    cmd = docker_cmd + [artman_command]

    shell.run(cmd, cwd=root_dir)

    genfiles = output_dir / "java"

    if not genfiles.exists():
        raise FileNotFoundError(
            f"Unable to find generated output of artman: {genfiles}."
        )

    log.success(f"Generated code into {genfiles}.")

    _tracked_paths.add(genfiles)
    return genfiles

library = generate('gapic/google/compute/artman_compute.yaml', discovery)

s.copy(library / 'gapic-google-cloud-compute-v1/src', 'src')
#s.copy(library / 'grpc-google-cloud-compute-v1/src', '../../google-api-grpc/grpc-google-cloud-compute-v1/src')
#s.copy(library / 'proto-google-cloud-compute-v1/src', '../../google-api-grpc/proto-google-cloud-compute-v1/src')

