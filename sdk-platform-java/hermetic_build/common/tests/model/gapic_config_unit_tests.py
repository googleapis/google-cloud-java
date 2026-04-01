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
import unittest

from common.model.gapic_config import GapicConfig


class GapicConfigTest(unittest.TestCase):
    def test_get_version_returns_none(self):
        self.assertIsNone(GapicConfig(proto_path="example/dir1/dir2").get_version())

    def test_get_version_returns_non_stable_version(self):
        self.assertEqual(
            "v2p2beta1",
            GapicConfig(proto_path="example/dir1/dir2/v2p2beta1").get_version(),
        )
        self.assertEqual(
            "v2beta1",
            GapicConfig(proto_path="example/dir1/dir2/v2beta1").get_version(),
        )

    def test_get_version_returns_stable_version(self):
        self.assertEqual(
            "v20",
            GapicConfig(proto_path="example/dir1/dir2/v20").get_version(),
        )

    def test_is_stable_with_no_version_returns_false(self):
        self.assertFalse(
            GapicConfig(proto_path="example/dir1/dir2/non_version").is_stable(),
        )

    def test_is_stable_with_non_stable_version_returns_false(self):
        self.assertFalse(
            GapicConfig(proto_path="example/dir1/dir2/v20alpha").is_stable(),
        )
        self.assertFalse(
            GapicConfig(proto_path="example/dir1/dir2/v20beta2").is_stable(),
        )

    def test_is_stable_with_stable_version_returns_true(self):
        self.assertTrue(
            GapicConfig(proto_path="example/dir1/dir2/v30").is_stable(),
        )

    def test_compare_configs_without_a_version(self):
        config_len_3 = GapicConfig(proto_path="example/dir1/dir2")
        config_len_4 = GapicConfig(proto_path="example/dir1/dir2/dir3")
        self.assertLess(
            config_len_3,
            config_len_4,
            "config_len_3 should be smaller since it has a lower depth.",
        )

    def test_compare_configs_only_one_has_a_stable_version(self):
        versioned_config = GapicConfig(proto_path="example/dir1/dir2/dir3/dir4/v1")
        non_versioned_config = GapicConfig(proto_path="example/dir1/dir2/dir3")
        self.assertLess(
            versioned_config,
            non_versioned_config,
            "versioned_config should be smaller since it has a version.",
        )

    def test_compare_configs_only_one_has_a_non_stable_version(self):
        non_stable_versioned_config = GapicConfig(
            proto_path="example/dir1/dir2/dir3/dir4/v1beta"
        )
        non_versioned_config = GapicConfig(proto_path="example/dir1/dir2/dir3")
        self.assertLess(
            non_stable_versioned_config,
            non_versioned_config,
            "non_stable_versioned_config should be smaller since it has a version.",
        )

    def test_compare_configs_one_has_non_stable_and_one_has_stable_version(self):
        stable_versioned_config = GapicConfig(
            proto_path="example/dir1/dir2/dir3/dir4/v1"
        )
        non_stable_versioned_config = GapicConfig(proto_path="example/dir1/dir2/v2beta")
        self.assertLess(
            stable_versioned_config,
            non_stable_versioned_config,
            "stable_versioned_config should be smaller since it has a stable version.",
        )

    def test_compare_configs_two_have_non_stable_version(self):
        v3p2beta = GapicConfig(proto_path="example/dir1/dir2/dir3/dir4/v3p2beta")
        v2p4beta = GapicConfig(proto_path="example/dir1/dir2/v2p4beta")
        self.assertLess(
            v3p2beta,
            v2p4beta,
            "v3p2beta should be smaller since it has a higher version.",
        )

    def test_compare_configs_two_have_stable_version_different_depth(self):
        v3 = GapicConfig(proto_path="example/dir1/dir2/v3")
        v4 = GapicConfig(proto_path="example/dir1/dir2/dir3/dir4/v4")
        self.assertLess(
            v3,
            v4,
            "v3 should be smaller since it has lower depth",
        )

    def test_compare_configs_two_have_stable_version_same_depth(self):
        v4 = GapicConfig(proto_path="example/dir1/dir2/v4")
        v3 = GapicConfig(proto_path="example/dir1/dir2/v3")
        self.assertLess(
            v4,
            v3,
            "v4 should be smaller since it has a higher version",
        )
