# Copyright 2019 Google LLC
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
from typing import Optional, Union
import os
import shutil
import tempfile

from synthtool import _tracked_paths, metadata, shell
from synthtool.log import logger
from synthtool.sources import git

GOOGLEAPIS_URL: str = git.make_repo_clone_url("googleapis/googleapis")
GOOGLEAPIS_PRIVATE_URL: str = git.make_repo_clone_url("googleapis/googleapis-private")
DISCOVERY_ARTIFACT_MANAGER_URL: str = git.make_repo_clone_url(
    "googleapis/discovery-artifact-manager"
)
LOCAL_GOOGLEAPIS: Optional[str] = os.environ.get("SYNTHTOOL_GOOGLEAPIS")
LOCAL_GOOGLEAPIS_DISCOVERY: Optional[str] = os.environ.get(
    "SYNTHTOOL_GOOGLEAPIS_DISCOVERY"
)
LOCAL_DISCOVERY_ARTIFACT_MANAGER: Optional[str] = os.environ.get(
    "SYNTHTOOL_DISCOVERY_ARTIFACT_MANAGER"
)


class GAPICBazel:
    """A synthtool component that can produce libraries using bazel build."""

    def __init__(self):
        self._ensure_dependencies_installed()
        self._googleapis = None
        self._googleapis_private = None
        self._googleapis_discovery = None
        self._discovery_artifact_manager = None

    def py_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "python", False, **kwargs)

    def go_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "go", False, **kwargs)

    def node_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "nodejs", False, **kwargs)

    def csharp_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "csharp", False, **kwargs)

    def php_library(
        self, service: str, version: str, clean_build: bool = False, **kwargs
    ) -> Path:
        return self._generate_code(service, version, "php", clean_build, **kwargs)

    def java_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(
            service, version, "java", False, tar_strip_components=0, **kwargs
        )

    def ruby_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "ruby", False, **kwargs)

    def _generate_code(
        self,
        service: str,
        version: str,
        language: str,
        clean_build: bool = False,
        *,
        private: bool = False,
        discogapic: bool = False,
        diregapic: bool = False,
        proto_path: Union[str, Path] = None,
        output_dir: Union[str, Path] = None,
        bazel_target: str = None,
        include_protos: bool = False,
        proto_output_path: Union[str, Path] = None,
        tar_strip_components: int = 1,
    ):
        # Determine which googleapis repo to use
        if discogapic:
            api_definitions_repo = self._clone_discovery_artifact_manager()
            api_definitions_repo_name = "discovery-artifact-manager"
        elif private:
            api_definitions_repo = self._clone_googleapis_private()
            api_definitions_repo_name = "googleapis_private"
        else:
            api_definitions_repo = self._clone_googleapis()
            api_definitions_repo_name = "googleapis"

        # Confidence check: We should have a googleapis repo; if we do not,
        # something went wrong, and we should abort.
        if not api_definitions_repo:
            raise RuntimeError(
                f"Unable to generate {service}, the sources repository repository"
                "is unavailable."
            )

        # Calculate proto_path if necessary.
        if not bazel_target or include_protos:
            # If bazel_target is not specified explicitly, we will need
            # proto_path to calculate it. If include_protos is True,
            # we will need the proto_path to copy the protos.
            if not proto_path:
                if bazel_target:
                    # Calculate proto_path from the full bazel target, which is
                    # in the format "//proto_path:target_name
                    proto_path = bazel_target.split(":")[0][2:]
                else:
                    # If bazel_target is not specified, assume the protos are
                    # simply under google/cloud, where the most of the protos
                    # usually are.
                    proto_path = f"google/cloud/{service}/{version}"
            protos = Path(proto_path)
            if protos.is_absolute():
                protos = protos.relative_to("/")

        # Determine bazel target based on per-language patterns
        # Java:    google-cloud-{{assembly_name}}-{{version}}-java
        # Go:      gapi-cloud-{{assembly_name}}-{{version}}-go
        # Python:  {{assembly_name}}-{{version}}-py
        # PHP:     google-cloud-{{assembly_name}}-{{version}}-php
        # Node.js: {{assembly_name}}-{{version}}-nodejs
        # Ruby:    google-cloud-{{assembly_name}}-{{version}}-ruby
        # C#:      google-cloud-{{assembly_name}}-{{version}}-csharp
        if not bazel_target:
            # Determine where the protos we are generating actually live.
            # We can sometimes (but not always) determine this from the service
            # and version; in other cases, the user must provide it outright.
            parts = list(protos.parts)
            while len(parts) > 0 and parts[0] != "google":
                parts.pop(0)
            if len(parts) == 0:
                raise RuntimeError(
                    f"Cannot determine bazel_target from proto_path {protos}."
                    "Please set bazel_target explicitly."
                )
            if language == "python":
                suffix = f"{service}-{version}-py"
            elif language == "nodejs":
                suffix = f"{service}-{version}-nodejs"
            elif language == "go":
                suffix = f"gapi-{'-'.join(parts[1:])}-go"
            else:
                suffix = f"{'-'.join(parts)}-{language}"
            bazel_target = f"//{os.path.sep.join(parts)}:{suffix}"

            # Confidence check: Do we have protos where we think we should?
            if not (api_definitions_repo / protos).exists():
                raise FileNotFoundError(
                    f"Unable to find directory for protos: {(api_definitions_repo / protos)}."
                )
            if not tuple((api_definitions_repo / protos).glob("*.proto")):
                raise FileNotFoundError(
                    f"Directory {(api_definitions_repo / protos)} exists, but no protos found."
                )
            if not (api_definitions_repo / protos / "BUILD.bazel"):
                raise FileNotFoundError(
                    f"File {(api_definitions_repo / protos / 'BUILD.bazel')} does not exist."
                )

        # Ensure the desired output directory exists.
        # If none was provided, create a temporary directory.
        if not output_dir:
            output_dir = tempfile.mkdtemp()
        output_dir = Path(output_dir).resolve()

        # Let's build some stuff now.
        cwd = os.getcwd()
        os.chdir(str(api_definitions_repo))

        if clean_build:
            logger.debug("Cleaning Bazel cache")
            shell.run(["bazel", "clean", "--expunge", "--async"])

        # Log which version of bazel that we're using for easier debugging.
        logger.debug("Which version of bazel will I run?")
        shell.run(["bazel", "--version"], hide_output=False)

        bazel_run_args = [
            "bazel",
            "--max_idle_secs=240",
            "build",
            bazel_target,
        ]

        logger.debug(f"Generating code for: {bazel_target}.")
        shell.run(bazel_run_args, hide_output=False)

        # We've got tar file!
        # its location: bazel-bin/google/cloud/language/v1/language-v1-nodejs.tar.gz
        # bazel_target:         //google/cloud/language/v1:language-v1-nodejs
        tar_file = (
            f"bazel-bin{os.path.sep}{bazel_target[2:].replace(':', os.path.sep)}.tar.gz"
        )

        tar_run_args = [
            "tar",
            "-C",
            str(output_dir),
            f"--strip-components={tar_strip_components}",
            "-xzf",
            tar_file,
        ]
        shell.run(tar_run_args)

        # Get the *.protos files and put them in a protos dir in the output
        if include_protos:
            proto_files = protos.glob("**/*.proto")
            # By default, put the protos at the root in a folder named 'protos'.
            # Specific languages can be cased here to put them in a more language
            # appropriate place.
            if not proto_output_path:
                proto_output_path = output_dir / "protos"
                if language == "python":
                    # place protos alongsize the *_pb2.py files
                    proto_output_path = (
                        output_dir / f"google/cloud/{service}_{version}/proto"
                    )
            else:
                proto_output_path = Path(output_dir / proto_output_path)
            os.makedirs(proto_output_path, exist_ok=True)

            for i in proto_files:
                logger.debug(f"Copy: {i} to {proto_output_path / i.name}")
                shutil.copyfile(i, proto_output_path / i.name)
            logger.success(f"Placed proto files into {proto_output_path}.")

        os.chdir(cwd)

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
            source=api_definitions_repo_name,
            api_name=service,
            api_version=version,
            language=language,
            generator="bazel",
        )

        _tracked_paths.add(output_dir)
        return output_dir

    def _clone_googleapis(self):
        if self._googleapis:
            return self._googleapis

        if LOCAL_GOOGLEAPIS:
            self._googleapis = Path(LOCAL_GOOGLEAPIS).expanduser()
            logger.debug(f"Using local googleapis at {self._googleapis}")

        else:
            logger.debug("Cloning googleapis.")
            self._googleapis = git.clone(GOOGLEAPIS_URL)

        return self._googleapis

    def _clone_googleapis_private(self):
        if self._googleapis_private:
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

    def _clone_discovery_artifact_manager(self):
        if self._discovery_artifact_manager:
            return self._discovery_artifact_manager

        if LOCAL_DISCOVERY_ARTIFACT_MANAGER:
            self._discovery_artifact_manager = Path(
                LOCAL_DISCOVERY_ARTIFACT_MANAGER
            ).expanduser()
            logger.debug(
                f"Using local discovery_artifact_manager at {self._discovery_artifact_manager} for googleapis-private"
            )
        else:
            logger.debug("Cloning discovery-artifact-manager.")
            self._discovery_artifact_manager = git.clone(DISCOVERY_ARTIFACT_MANAGER_URL)

        return self._discovery_artifact_manager

    def _ensure_dependencies_installed(self):
        logger.debug("Ensuring dependencies.")

        dependencies = ["bazel", "zip", "unzip", "tar"]
        failed_dependencies = []
        for dependency in dependencies:
            return_code = shell.run(["which", dependency], check=False).returncode
            if return_code:
                failed_dependencies.append(dependency)

        if failed_dependencies:
            raise EnvironmentError(
                f"Dependencies missing: {', '.join(failed_dependencies)}"
            )
