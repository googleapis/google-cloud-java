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

import getpass
from pathlib import Path
from typing import List, Mapping, Optional, Union
import os
import platform
import tempfile

from synthtool import _tracked_paths, metadata, shell
from synthtool.log import logger
from synthtool.sources import git

GOOGLEAPIS_URL: str = git.make_repo_clone_url("googleapis/googleapis")
GOOGLEAPIS_PRIVATE_URL: str = git.make_repo_clone_url("googleapis/googleapis-private")
LOCAL_GOOGLEAPIS: Optional[str] = os.environ.get("SYNTHTOOL_GOOGLEAPIS")
GENERATOR_VERSION: str = os.environ.get(
    "SYNTHTOOL_GAPIC_GENERATOR_PYTHON_VERSION", "latest"
)


class GAPICMicrogenerator:
    """A synthtool component that can produce libraries using microgenerators.

    A microgenerator is any code generator that follows the code
    generation specification defined at https://aip.dev/client-libraries
    """

    def __init__(self):
        # Docker on mac by default cannot use the default temp file location
        # instead use the more standard *nix /tmp location.
        if platform.system() == "Darwin":
            tempfile.tempdir = "/tmp"
        self._ensure_dependencies_installed()
        self._googleapis = None
        self._googleapis_private = None

    def py_library(self, service: str, version: str, **kwargs) -> Path:
        """
        Generates the Python Library files using artman/GAPIC
        returns a `Path` object
        library: path to library. 'google/cloud/speech'
        version: version of lib. 'v1'
        """
        return self._generate_code(service, version, "python", **kwargs)

    def go_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "go", **kwargs)

    def kotlin_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "kotlin", **kwargs)

    def typescript_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "typescript", **kwargs)

    def ruby_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "ruby", **kwargs)

    def _generate_code(
        self,
        service: str,
        version: str,
        language: str,
        *,
        private: bool = False,
        proto_path: Union[str, Path] = None,
        extra_proto_files: List[str] = [],
        output_dir: Union[str, Path] = None,
        generator_version: str = GENERATOR_VERSION,
        generator_args: Mapping[str, str] = None,
    ):
        # Determine which googleapis repo to use
        if not private:
            googleapis = self._clone_googleapis()
        else:
            googleapis = self._clone_googleapis_private()

        # Confidence check: We should have a googleapis repo; if we do not,
        # something went wrong, and we should abort.
        if googleapis is None:
            raise RuntimeError(
                f"Unable to generate {service}, the googleapis repository"
                "is unavailable."
            )

        # Pull the code generator for the requested language.
        # If a code generator version was specified, honor that.
        logger.debug(
            f"Pulling Docker image: gapic-generator-{language}:{generator_version}"
        )
        shell.run(
            [
                "docker",
                "pull",
                f"gcr.io/gapic-images/gapic-generator-{language}:{generator_version}",
            ],
            hide_output=False,
        )

        # Determine where the protos we are generating actually live.
        # We can sometimes (but not always) determine this from the service
        # and version; in other cases, the user must provide it outright.
        if proto_path:
            proto_path = Path(proto_path)
            if proto_path.is_absolute():
                proto_path = proto_path.relative_to("/")
        else:
            proto_path = Path("google/cloud") / service / version

        # Confidence check: Do we have protos where we think we should?
        if not (googleapis / proto_path).exists():
            raise FileNotFoundError(
                f"Unable to find directory for protos: {(googleapis / proto_path)}."
            )
        if not tuple((googleapis / proto_path).glob("*.proto")):
            raise FileNotFoundError(
                f"Directory {(googleapis / proto_path)} exists, but no protos found."
            )

        # Ensure the desired output directory exists.
        # If none was provided, create a temporary directory.
        if not output_dir:
            output_dir = tempfile.mkdtemp()
        output_dir = Path(output_dir).resolve()

        # The time has come, the walrus said, to talk of actually running
        # the code generator.
        sep = os.path.sep

        # try to figure out user ID and stay compatible.
        # If there is no `os.getuid()`, fallback to `getpass.getuser()`
        getuid = getattr(os, "getuid", None)
        if getuid:
            user = str(getuid())
        else:
            user = getpass.getuser()

        docker_run_args = [
            "docker",
            "run",
            "--mount",
            f"type=bind,source={googleapis / proto_path}{sep},destination={Path('/in') / proto_path}{sep},readonly",
            "--mount",
            f"type=bind,source={output_dir}{sep},destination={Path('/out')}{sep}",
            "--rm",
            "--user",
            user,
        ]

        # Process extra proto files, e.g. google/cloud/common_resources.proto,
        # if they are required by this API.
        # First, bind mount all the extra proto files into the container.
        for proto in extra_proto_files:
            source_proto = googleapis / Path(proto)
            if not source_proto.exists():
                raise FileNotFoundError(
                    f"Unable to find extra proto file: {source_proto}."
                )
            docker_run_args.extend(
                [
                    "--mount",
                    f"type=bind,source={source_proto},destination={Path('/in') / proto},readonly",
                ]
            )

        docker_run_args.append(
            f"gcr.io/gapic-images/gapic-generator-{language}:{generator_version}"
        )

        # Populate any additional CLI arguments provided for Docker.
        if generator_args:
            for key, value in generator_args.items():
                docker_run_args.append(f"--{key}")
                docker_run_args.append(value)

        logger.debug(f"Generating code for: {proto_path}.")
        shell.run(docker_run_args, hide_output=False)

        # Confidence check: Does the output location have code in it?
        # If not, complain.
        if not tuple(output_dir.iterdir()):
            raise RuntimeError(
                f"Code generation seemed to succeed, but {output_dir} is empty."
            )

        # Huzzah, it worked.
        logger.success(f"Generated code into {output_dir}.")

        # Record this in the synthtool metadata.
        metadata.add_client_destination(
            source="googleapis" if not private else "googleapis-private",
            api_name=service,
            api_version=version,
            language=language,
            generator=f"gapic-generator-{language}",
        )

        _tracked_paths.add(output_dir)
        return output_dir

    def _clone_googleapis(self):
        if self._googleapis is not None:
            return self._googleapis

        if LOCAL_GOOGLEAPIS:
            self._googleapis = Path(LOCAL_GOOGLEAPIS).expanduser()
            logger.debug(f"Using local googleapis at {self._googleapis}")

        else:
            logger.debug("Cloning googleapis.")
            self._googleapis = git.clone(GOOGLEAPIS_URL)

        return self._googleapis

    def _clone_googleapis_private(self):
        if self._googleapis_private is not None:
            return self._googleapis_private

        if LOCAL_GOOGLEAPIS:
            self._googleapis_private = Path(LOCAL_GOOGLEAPIS).expanduser()
            logger.debug(
                f"Using local googleapis at {self._googleapis_private} for googleapis-private"
            )

        else:
            logger.debug("Cloning googleapis-private.")
            self._googleapis_private = git.clone(GOOGLEAPIS_PRIVATE_URL)

        return self._googleapis_private

    def _ensure_dependencies_installed(self):
        logger.debug("Ensuring dependencies.")

        dependencies = ["docker", "git"]
        failed_dependencies = []
        for dependency in dependencies:
            return_code = shell.run(["which", dependency], check=False).returncode
            if return_code:
                failed_dependencies.append(dependency)

        if failed_dependencies:
            raise EnvironmentError(
                f"Dependencies missing: {', '.join(failed_dependencies)}"
            )
