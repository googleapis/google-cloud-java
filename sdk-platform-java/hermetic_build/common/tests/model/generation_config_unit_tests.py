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
import os
import unittest
from pathlib import Path
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources")
test_config_dir = Path(os.path.join(resources_dir, "test-config")).resolve()

library_1 = LibraryConfig(
    api_shortname="a_library",
    api_description="",
    name_pretty="",
    product_documentation="",
    gapic_configs=[],
)
library_2 = LibraryConfig(
    api_shortname="another_library",
    api_description="",
    name_pretty="",
    product_documentation="",
    gapic_configs=[],
)
common_protos_library = LibraryConfig(
    api_shortname="common-protos",
    api_description="",
    name_pretty="",
    product_documentation="",
    gapic_configs=[],
)


class GenerationConfigTest(unittest.TestCase):
    def test_generation_config_default_value(self):
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[],
        )
        self.assertEqual("", config.libraries_bom_version)

    def test_generation_config_with_generator_version_env_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Environment variable GENERATOR_VERSION is not set",
            GenerationConfig,
            googleapis_commitish="",
            libraries=[],
        )

    def test_generation_config_set_generator_version_from_env(self):
        os.environ["GENERATOR_VERSION"] = "1.2.3"
        config = GenerationConfig(
            googleapis_commitish="",
            libraries=[],
        )
        self.assertEqual("1.2.3", config.gapic_generator_version)
        os.environ.pop("GENERATOR_VERSION")

    def test_from_yaml_succeeds(self):
        config = GenerationConfig.from_yaml(f"{test_config_dir}/generation_config.yaml")
        self.assertEqual("2.34.0", config.gapic_generator_version)
        self.assertEqual(
            "1a45bf7393b52407188c82e63101db7dc9c72026", config.googleapis_commitish
        )
        self.assertEqual("26.37.0", config.libraries_bom_version)
        library = config.libraries[0]
        self.assertEqual("cloudasset", library.api_shortname)
        self.assertEqual("Cloud Asset Inventory", library.name_pretty)
        self.assertEqual(
            "https://cloud.google.com/resource-manager/docs/cloud-asset-inventory/overview",
            library.product_documentation,
        )
        self.assertEqual(
            "provides inventory services based on a time series database.",
            library.api_description,
        )
        self.assertEqual("asset", library.library_name)
        self.assertEqual("@googleapis/analytics-dpe", library.codeowner_team)
        self.assertEqual(
            "proto-google-iam-v1-bom,google-iam-policy,proto-google-iam-v1",
            library.excluded_poms,
        )
        self.assertEqual("google-iam-policy", library.excluded_dependencies)
        gapics = library.gapic_configs
        self.assertEqual(5, len(gapics))
        self.assertEqual("google/cloud/asset/v1", gapics[0].proto_path)
        self.assertEqual("google/cloud/asset/v1p1beta1", gapics[1].proto_path)
        self.assertEqual("google/cloud/asset/v1p2beta1", gapics[2].proto_path)
        self.assertEqual("google/cloud/asset/v1p5beta1", gapics[3].proto_path)
        self.assertEqual("google/cloud/asset/v1p7beta1", gapics[4].proto_path)

    def test_get_proto_path_to_library_name_success(self):
        paths = GenerationConfig.from_yaml(
            f"{test_config_dir}/generation_config.yaml"
        ).get_proto_path_to_library_name()
        self.assertEqual(
            {
                "google/cloud/asset/v1": "asset",
                "google/cloud/asset/v1p1beta1": "asset",
                "google/cloud/asset/v1p2beta1": "asset",
                "google/cloud/asset/v1p5beta1": "asset",
                "google/cloud/asset/v1p7beta1": "asset",
            },
            paths,
        )

    def test_is_monorepo_with_one_library_returns_false(self):
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[library_1],
        )
        self.assertFalse(config.is_monorepo())

    def test_is_monorepo_with_two_libraries_returns_true(self):
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[library_1, library_2],
        )
        self.assertTrue(config.is_monorepo())

    def test_contains_common_protos_with_common_protos_returns_true(self):
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[library_1, library_2, common_protos_library],
        )
        self.assertTrue(config.contains_common_protos())

    def test_contains_common_protos_without_common_protos_returns_false(self):
        config = GenerationConfig(
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[library_1, library_2],
        )
        self.assertFalse(config.contains_common_protos())

    def test_validate_with_duplicate_library_name_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "the same library name",
            GenerationConfig,
            gapic_generator_version="",
            googleapis_commitish="",
            libraries=[
                LibraryConfig(
                    api_shortname="secretmanager",
                    name_pretty="Secret API",
                    product_documentation="",
                    api_description="",
                    gapic_configs=list(),
                ),
                LibraryConfig(
                    api_shortname="another-secret",
                    name_pretty="Another Secret API",
                    product_documentation="",
                    api_description="",
                    gapic_configs=list(),
                    library_name="secretmanager",
                ),
            ],
        )

    def test_from_yaml_without_googleapis_commitish_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Repo level parameter, googleapis_commitish",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_googleapis.yaml",
        )

    def test_from_yaml_without_libraries_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Repo level parameter, libraries",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_libraries.yaml",
        )

    def test_from_yaml_without_api_shortname_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Library level parameter, api_shortname",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_api_shortname.yaml",
        )

    def test_from_yaml_without_api_description_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            r"Library level parameter, api_description.*'api_shortname': 'apigeeconnect'.*",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_api_description.yaml",
        )

    def test_from_yaml_without_name_pretty_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            r"Library level parameter, name_pretty.*'api_shortname': 'apigeeconnect'.*",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_name_pretty.yaml",
        )

    def test_from_yaml_without_product_documentation_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            r"Library level parameter, product_documentation.*'api_shortname': 'apigeeconnect'.*",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_product_docs.yaml",
        )

    def test_from_yaml_without_gapics_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Library level parameter, GAPICs.*'api_shortname': 'apigeeconnect'.*",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_gapics_key.yaml",
        )

    def test_from_yaml_without_proto_path_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "GAPIC level parameter, proto_path",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_proto_path.yaml",
        )

    def test_from_yaml_with_zero_library_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            "Library is None",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_library_value.yaml",
        )

    def test_from_yaml_with_zero_proto_path_raise_exception(self):
        self.assertRaisesRegex(
            ValueError,
            r"GAPICs is None in.*'api_shortname': 'apigeeconnect'.*",
            GenerationConfig.from_yaml,
            f"{test_config_dir}/config_without_gapics_value.yaml",
        )
