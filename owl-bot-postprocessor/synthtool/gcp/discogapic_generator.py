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

from pathlib import Path

from synthtool import _tracked_paths
from synthtool.gcp import artman
from synthtool.log import logger
from synthtool.sources import git

DISCOVERY_ARTIFACT_MANAGER_URL: str = git.make_repo_clone_url(
    "googleapis/discovery-artifact-manager"
)


class DiscoGAPICGenerator:
    def __init__(self):
        self._clone_discovery_artifact_manager()

    def py_library(self, service: str, version: str, **kwargs) -> Path:
        """
        Generates the Python Library files using artman/GAPIC
        returns a `Path` object
        library: path to library. 'google/cloud/speech'
        version: version of lib. 'v1'
        """
        return self._generate_code(service, version, "python", **kwargs)

    def node_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "nodejs", **kwargs)

    nodejs_library = node_library

    def ruby_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "ruby", **kwargs)

    def php_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "php", **kwargs)

    def java_library(self, service: str, version: str, **kwargs) -> Path:
        return self._generate_code(service, version, "java", **kwargs)

    def _generate_code(
        self, service, version, language, config_path=None, artman_output_name=None
    ):
        # map the language to the artman argument and subdir of genfiles
        GENERATE_FLAG_LANGUAGE = {
            "python": ("python_gapic", "python"),
            "nodejs": ("nodejs_gapic", "js"),
            "ruby": ("ruby_gapic", "ruby"),
            "php": ("php_gapic", "php"),
            "java": ("java_discogapic", "java"),
        }

        if language not in GENERATE_FLAG_LANGUAGE:
            raise ValueError("provided language unsupported")

        gapic_language_arg, gen_language = GENERATE_FLAG_LANGUAGE[language]

        if self.discovery_artifact_manager is None:
            raise RuntimeError(
                f"Unable to generate {config_path}, the googleapis repository"
                "is unavailable."
            )

        # Run the code generator.
        # $ artman --config path/to/artman_api.yaml generate python_gapic
        if config_path is None:
            config_path = (
                Path("gapic/google") / service / f"artman_{service}_{version}.yaml"
            )
        elif Path(config_path).is_absolute():
            config_path = Path(config_path).relative_to("/")
        else:
            config_path = Path("gapic/google") / service / Path(config_path)

        if not (self.discovery_artifact_manager / config_path).exists():
            raise FileNotFoundError(
                f"Unable to find configuration yaml file: {config_path}."
            )

        logger.debug(f"Running generator for {config_path}.")
        output_root = artman.Artman().run(
            f"googleapis/artman:{artman.ARTMAN_VERSION}",
            self.discovery_artifact_manager,
            config_path,
            gapic_language_arg,
        )

        # Expect the output to be in the artman-genfiles directory.
        # example: /artman-genfiles/python/speech-v1
        if artman_output_name is None:
            artman_output_name = f"{service}-{version}"
        genfiles = output_root / gen_language / artman_output_name

        if not genfiles.exists():
            raise FileNotFoundError(
                f"Unable to find generated output of artman: {genfiles}."
            )

        logger.success(f"Generated code into {genfiles}.")

        _tracked_paths.add(genfiles)
        return genfiles

    def _clone_discovery_artifact_manager(self):
        logger.debug("Cloning discovery-artifact-manager.")
        self.discovery_artifact_manager = git.clone(DISCOVERY_ARTIFACT_MANAGER_URL)
