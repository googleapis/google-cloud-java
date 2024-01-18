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

import json
import os
import re
import shutil
import fnmatch
from copy import deepcopy
from pathlib import Path
from typing import Dict, List, Optional
import jinja2
from datetime import date

from synthtool import shell, _tracked_paths
from synthtool.gcp import partials
from synthtool.languages import node, node_mono_repo
from synthtool.log import logger
from synthtool.sources import git, templates

PathOrStr = templates.PathOrStr
TEMPLATES_URL: str = git.make_repo_clone_url("googleapis/synthtool")
DEFAULT_TEMPLATES_PATH = "synthtool/gcp/templates"
LOCAL_TEMPLATES: Optional[str] = os.environ.get("SYNTHTOOL_TEMPLATES")


class CommonTemplates:
    def __init__(self, template_path: Optional[Path] = None):
        if template_path:
            self._template_root = template_path
        elif LOCAL_TEMPLATES:
            logger.debug(f"Using local templates at {LOCAL_TEMPLATES}")
            self._template_root = Path(LOCAL_TEMPLATES)
        else:
            templates_git = git.clone(TEMPLATES_URL)
            self._template_root = templates_git / DEFAULT_TEMPLATES_PATH

        self._templates = templates.Templates(self._template_root)
        self.excludes = []  # type: List[str]

    def _generic_library(self, directory: str, relative_dir=None, **kwargs) -> Path:
        # load common repo meta information (metadata that's not language specific).
        if "metadata" in kwargs:
            self._load_generic_metadata(kwargs["metadata"], relative_dir=relative_dir)
            # if no samples were found, don't attempt to render a
            # samples/README.md.
            if "samples" not in kwargs["metadata"] or not kwargs["metadata"]["samples"]:
                self.excludes.append("samples/README.md")

        t = templates.TemplateGroup(self._template_root / directory, self.excludes)

        if "repository" in kwargs["metadata"] and "repo" in kwargs["metadata"]:
            kwargs["metadata"]["repo"]["default_branch"] = _get_default_branch_name(
                kwargs["metadata"]["repository"]
            )

        # TODO: migrate to python.py once old sample gen is deprecated
        if directory == "python_samples":
            t.env.globals["get_help"] = lambda filename: shell.run(
                ["python", filename, "--help"]
            ).stdout

        result = t.render(**kwargs)
        _tracked_paths.add(result)

        return result

    def py_samples(self, **kwargs) -> List[Path]:
        """
        Handles generation of README.md templates for Python samples
        - Determines whether generation is being done in a client library or in a samples
        folder automatically
        - Otherwise accepts manually set sample_project_dir through kwargs metadata
        - Delegates generation of additional sample documents alternate/overridden folders
        through py_samples_override()
        """
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}

        # load common repo meta information (metadata that's not language specific).
        self._load_generic_metadata(kwargs["metadata"])

        # temporary exclusion prior to old templates being migrated out
        self.excludes.extend(
            [
                "README.rst",
                "auth_api_key.tmpl.rst",
                "auth.tmpl.rst",
                "install_deps.tmpl.rst",
                "install_portaudio.tmpl.rst",
                "noxfile.py.j2",
            ]
        )

        # ensure samples will generate
        kwargs["metadata"]["samples"] = True

        # determine if in client lib and set custom root sample dir if specified, else None
        in_client_library = Path("samples").exists()
        sample_project_dir = kwargs["metadata"]["repo"].get("sample_project_dir")

        if sample_project_dir is None:  # Not found in metadata
            if in_client_library:
                sample_project_dir = "samples"
            else:
                sample_project_dir = "."
        elif not Path(sample_project_dir).exists():
            raise Exception(f"'{sample_project_dir}' does not exist")

        override_paths_to_samples: Dict[
            str, List[str]
        ] = {}  # Dict of format { override_path : sample(s) }
        samples_dict = deepcopy(kwargs["metadata"]["repo"].get("samples"))
        default_samples_dict = []  # Dict which will generate in sample_project_dir

        # Iterate through samples to store override_paths_to_samples for all existing
        # override paths
        for sample_idx, sample in enumerate(samples_dict):
            override_path = samples_dict[sample_idx].get("override_path")

            if override_path is not None:
                # add absolute path to metadata so `python foo.py --help` succeeds
                if sample.get("file") is not None:
                    path = os.path.join(
                        sample_project_dir, override_path, sample.get("file")
                    )
                    sample["abs_path"] = Path(path).resolve()

                cur_override_sample = override_paths_to_samples.get(override_path)
                # Base case: No samples are yet planned to gen in this override dir
                if cur_override_sample is None:
                    override_paths_to_samples[override_path] = [sample]
                # Else: Sample docs will be generated in README merged with other
                # sample doc(s) already planned to generate in this dir
                else:
                    cur_override_sample.append(sample)
                    override_paths_to_samples[override_path] = cur_override_sample
            # If override path none, will be generated in the default
            # folder: sample_project_dir
            else:
                if sample.get("file") is not None:
                    path = os.path.join(sample_project_dir, sample.get("file"))
                    sample["abs_path"] = Path(path).resolve()
                default_samples_dict.append(sample)

        # List of paths to tempdirs which will be copied into sample folders
        result = []

        # deep copy is req. here to avoid kwargs being affected
        overridden_samples_kwargs = deepcopy(kwargs)
        for override_path in override_paths_to_samples:
            # Generate override sample docs
            result.append(
                self.py_samples_override(
                    root=sample_project_dir,
                    override_path=override_path,
                    override_samples=override_paths_to_samples[override_path],
                    **overridden_samples_kwargs,
                )
            )
        kwargs["metadata"]["repo"]["samples"] = default_samples_dict

        logger.debug(
            f"Generating templates for samples directory '{sample_project_dir}'"
        )
        kwargs["subdir"] = sample_project_dir
        # Generate default sample docs
        result.append(self._generic_library("python_samples", **kwargs))

        for path in result:
            # .add() records the root of the paths and needs to be applied to each
            _tracked_paths.add(path)

        return result

    def py_samples_override(
        self, root, override_path, override_samples, **overridden_samples_kwargs
    ) -> Path:
        """
        Handles additional generation of READMEs where "override_path"s
        are set in one or more samples' metadata
        """
        overridden_samples_kwargs["metadata"]["repo"][
            "sample_project_dir"
        ] = override_path
        # Set samples metadata to ONLY samples intended to generate
        # under this directory (override_path)
        overridden_samples_kwargs["metadata"]["repo"]["samples"] = override_samples
        if root != ".":
            override_path = Path(root) / override_path

        logger.debug(f"Generating templates for override path '{override_path}'")

        overridden_samples_kwargs["subdir"] = override_path
        return self._generic_library("python_samples", **overridden_samples_kwargs)

    def python_notebooks(self, **kwargs) -> Path:
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}
        return self._generic_library("python_notebooks", **kwargs)

    def py_mono_repo_library(self, relative_dir, **kwargs) -> Path:
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}

        # load common repo meta information (metadata that's not language specific).
        self._load_generic_metadata(kwargs["metadata"], relative_dir)

        # initialize default_version if it doesn't exist in kwargs["metadata"]['repo']
        if "default_version" not in kwargs["metadata"]["repo"]:
            kwargs["metadata"]["repo"]["default_version"] = ""

        # Don't add `docs/index.rst` if `versions` is not provided or `default_version` is empty
        if (
            "versions" not in kwargs
            or not kwargs["metadata"]["repo"]["default_version"]
            or kwargs["metadata"]["repo"]["default_version"] == "apiVersion"
        ):
            self.excludes += ["docs/index.rst"]

        # If the directory `google/cloud` exists, add kwargs to signal that the client library is for a Cloud API
        if Path("google/cloud").exists():
            kwargs["is_google_cloud_api"] = True

        return self._generic_library("python_mono_repo_library", relative_dir, **kwargs)

    def py_library(self, **kwargs) -> Path:
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}

        # load common repo meta information (metadata that's not language specific).
        self._load_generic_metadata(kwargs["metadata"])

        # initialize default_version if it doesn't exist in kwargs["metadata"]['repo']
        if "default_version" not in kwargs["metadata"]["repo"]:
            kwargs["metadata"]["repo"]["default_version"] = ""

        # rename variable to accommodate existing owlbot.py files
        if "system_test_dependencies" in kwargs:
            kwargs["system_test_local_dependencies"] = kwargs[
                "system_test_dependencies"
            ]
            logger.warning(
                "Template argument 'system_test_dependencies' is deprecated."
                "Use 'system_test_local_dependencies' or 'system_test_external_dependencies'"
                "instead."
            )

        # Set default Python versions for noxfile.py
        if "default_python_version" not in kwargs:
            kwargs["default_python_version"] = "3.8"
        if "unit_test_python_versions" not in kwargs:
            kwargs["unit_test_python_versions"] = ["3.7", "3.8", "3.9", "3.10"]

        if "system_test_python_versions" not in kwargs:
            kwargs["system_test_python_versions"] = ["3.8"]

        # If cov_level is not given, set it to None.
        if "cov_level" not in kwargs:
            kwargs["cov_level"] = None

        # Don't add samples templates if there are no samples
        if "samples" not in kwargs:
            self.excludes += ["samples/AUTHORING_GUIDE.md", "samples/CONTRIBUTING.md"]

        # Don't add `docs/index.rst` if `versions` is not provided or `default_version` is empty
        if (
            "versions" not in kwargs
            or not kwargs["metadata"]["repo"]["default_version"]
        ):
            self.excludes += ["docs/index.rst"]

        # Add kwargs to signal that UPGRADING.md should be included in docs/index.rst if it exists
        if Path("docs/UPGRADING.md").exists() or Path("docs/UPGRADING.rst").exists():
            kwargs["include_uprading_doc"] = True

        # If the directory `google/cloud` exists, add kwargs to signal that the client library is for a Cloud API
        if Path("google/cloud").exists():
            kwargs["is_google_cloud_api"] = True

        # If Dockerfile exists in .kokoro/docker/samples, add kwargs to
        # signal that a custom docker image should be used when testing samples.
        kwargs["custom_samples_dockerfile"] = Path(
            ".kokoro/docker/samples/Dockerfile"
        ).exists()

        ret = self._generic_library("python_library", **kwargs)

        # If split_system_tests is set to True, we disable the system
        # test in the main presubmit build and create individual build
        # configs for each python versions.
        if kwargs.get("split_system_tests", False):
            template_root = self._template_root / "py_library_split_systests"
            # copy the main presubmit config
            shutil.copy2(
                template_root / ".kokoro/presubmit/presubmit.cfg",
                ret / ".kokoro/presubmit/presubmit.cfg",
            )
            env = jinja2.Environment(loader=jinja2.FileSystemLoader(str(template_root)))
            tmpl = env.get_template(".kokoro/presubmit/system.cfg")
            for v in kwargs["system_test_python_versions"]:
                nox_session = f"system-{v}"
                dest = ret / f".kokoro/presubmit/system-{v}.cfg"
                content = tmpl.render(nox_session=nox_session)
                with open(dest, "w") as f:
                    f.write(content)
        return ret

    def java_library(self, **kwargs) -> Path:
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}
        return self._generic_library("java_library", **kwargs)

    def node_library(self, **kwargs) -> Path:
        # TODO: once we've migrated all Node.js repos to either having
        #  .repo-metadata.json, or excluding README.md, we can remove this.
        if not os.path.exists("./.repo-metadata.json"):
            self.excludes.append("README.md")
            if "samples/README.md" not in self.excludes:
                self.excludes.append("samples/README.md")

        kwargs["metadata"] = node.template_metadata()
        kwargs["publish_token"] = node.get_publish_token(kwargs["metadata"]["name"])

        ignore_src_index = [
            "yes" for f in self.excludes if fnmatch.fnmatch("src/index.ts", f)
        ]
        # generate root-level `src/index.ts` to export multiple versions and its default clients
        if (
            "versions" in kwargs
            and "default_version" in kwargs
            and not ignore_src_index
        ):
            node.generate_index_ts(
                versions=kwargs["versions"], default_version=kwargs["default_version"]
            )

        return self._generic_library("node_library", **kwargs)

    def node_mono_repo_library(self, relative_dir, **kwargs) -> Path:
        # TODO: once we've migrated all Node.js repos to either having
        #  .repo-metadata.json, or excluding README.md, we can remove this.
        if not os.path.exists(Path(relative_dir, ".repo-metadata.json").resolve()):
            self.excludes.append("README.md")
            if "samples/README.md" not in self.excludes:
                self.excludes.append("samples/README.md")

        kwargs["metadata"] = node_mono_repo.template_metadata(relative_dir)

        ignore_src_index = [
            "yes" for f in self.excludes if fnmatch.fnmatch("src/index.ts", f)
        ]
        # generate root-level `src/index.ts` to export multiple versions and its default clients
        if (
            "versions" in kwargs
            and "default_version" in kwargs
            and not ignore_src_index
        ):
            node_mono_repo.generate_index_ts(
                versions=kwargs["versions"],
                default_version=kwargs["default_version"],
                relative_dir=relative_dir,
                year=str(date.today().year),
            )

        return self._generic_library(
            "node_mono_repo_library", relative_dir=relative_dir, **kwargs
        )

    def php_library(self, **kwargs) -> Path:
        return self._generic_library("php_library", **kwargs)

    def ruby_library(self, **kwargs) -> Path:
        # kwargs["metadata"] is required to load values from .repo-metadata.json
        if "metadata" not in kwargs:
            kwargs["metadata"] = {}
        return self._generic_library("ruby_library", **kwargs)

    def render(self, template_name: str, **kwargs) -> Path:
        template = self._templates.render(template_name, **kwargs)
        _tracked_paths.add(template)
        return template

    def _load_generic_metadata(self, metadata: Dict, relative_dir=None):
        """
        loads additional meta information from .repo-metadata.json.
        """
        metadata["partials"] = partials.load_partials()

        # Loads repo metadata information from the default location if it
        # hasn't already been set. Some callers may have already loaded repo
        # metadata, so we don't need to do it again or overwrite it. Also, only
        # set the "repo" key.
        if "repo" not in metadata:
            metadata["repo"] = _load_repo_metadata(relative_dir=relative_dir)


def detect_versions(
    path: str = "./src",
    default_version: Optional[str] = None,
    default_first: Optional[bool] = None,
) -> List[str]:
    """
    Detects the versions a library has, based on distinct folders
    within path. This is based on the fact that our GAPIC libraries are
    structured as follows:

    src/v1
    src/v1beta
    src/v1alpha

    With folder names mapping directly to versions.

    Returns: a list of the sorted subdirectories; for the example above:
      ['v1', 'v1alpha', 'v1beta']
      If the `default_version` argument is not provided, the `default_version`
      will be read from `.repo-metadata.json`, if it exists.
      If `default_version` is available, the `default_version` is moved to
      at the front or the end of the sorted list depending on the value of `default_first`.
      The `default_version` will be first in the list when `default_first` is `True`.
    """

    versions = []

    if not default_version:
        try:
            # Get the `default_version` from ``.repo-metadata.json`.
            default_version = json.load(open(".repo-metadata.json", "rt")).get(
                "default_version"
            )
        except FileNotFoundError:
            pass

    # Detect versions up to a depth of 4 in directory hierarchy
    for level in ("*v[1-9]*", "*/*v[1-9]*", "*/*/*v[1-9]*", "*/*/*/*v[1-9]*"):
        # Sort the sub directories alphabetically.
        sub_dirs = sorted([p.name for p in Path(path).glob(level) if p.is_dir()])
        # Don't proceed to the next level if we've detected versions in this depth level
        if sub_dirs:
            break

    if sub_dirs:
        # if `default_version` is not specified, return the sorted directories.
        if not default_version:
            versions = sub_dirs
        else:
            # The subdirectory with the same suffix as the default_version
            # will be the default client.
            default_client = next(
                iter([d for d in sub_dirs if d.endswith(default_version)]), None
            )

            # start with all the versions except for the default client
            versions = [d for d in sub_dirs if not d.endswith(default_version)]

            if default_client:
                # If `default_first` is true, the default_client will be first
                # in the list.
                if default_first:
                    versions = [default_client] + versions
                else:
                    versions += [default_client]
    return versions


def decamelize(value: str):
    """Parser to convert fooBar.js to Foo Bar."""
    if not value:
        return ""
    str_decamelize = re.sub("^.", value[0].upper(), value)  # apple -> Apple.
    str_decamelize = re.sub(
        "([A-Z]+)([A-Z])([a-z0-9])", r"\1 \2\3", str_decamelize
    )  # ACLBatman -> ACL Batman.
    return re.sub("([a-z0-9])([A-Z])", r"\1 \2", str_decamelize)  # FooBar -> Foo Bar.


def _load_repo_metadata(
    relative_dir=None, metadata_file: str = "./.repo-metadata.json"
) -> Dict:
    """Parse a metadata JSON file into a Dict.

    Currently, the defined fields are:
    * `name` - The service's API name
    * `name_pretty` - The service's API title. This will be used for generating titles on READMEs
    * `product_documentation` - The product documentation on cloud.google.com
    * `client_documentation` - The client library reference documentation
    * `issue_tracker` - The public issue tracker for the product
    * `release_level` - The release level of the client library. One of: alpha, beta,
      ga, deprecated, preview, stable
    * `language` - The repo language. One of dotnet, go, java, nodejs, php, python, ruby
    * `repo` - The GitHub repo in the format {owner}/{repo}
    * `distribution_name` - The language-idiomatic package/distribution name
    * `api_id` - The API ID associated with the service. Fully qualified identifier use to
      enable a service in the cloud platform (e.g. monitoring.googleapis.com)
    * `requires_billing` - Whether or not the API requires billing to be configured on the
      customer's acocunt

    Args:
        metadata_file (str, optional): Path to the metadata json file

    Returns:
        A dictionary of metadata. This may not necessarily include all the defined fields above.
    """
    if relative_dir is not None:
        if os.path.exists(Path(relative_dir, metadata_file).resolve()):
            with open(Path(relative_dir, metadata_file).resolve()) as f:
                return json.load(f)
    elif os.path.exists(metadata_file):
        with open(metadata_file) as f:
            return json.load(f)
    return {}


def _get_default_branch_name(repository_name: str) -> str:
    """Read the default branch name from the environment.

    First checks environment variable DEFAULT_BRANCH_PATH.  If found, it
    reads the contents of the file at DEFAULT_BRANCH_PATH and returns it.

    Then checks environment varabile DEFAULT_BRANCH, and returns it if found.
    """
    default_branch_path = os.getenv("DEFAULT_BRANCH_PATH")
    if default_branch_path:
        return Path(default_branch_path).read_text().strip()

    # This default should be switched to "main" once we've migrated
    # the majority of our repositories:
    return os.getenv("DEFAULT_BRANCH", "master")
