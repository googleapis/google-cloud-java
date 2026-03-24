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
import os
import unittest
from pathlib import Path
from common.utils.proto_path_utils import find_versioned_proto_path
from common.utils.proto_path_utils import ends_with_version

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources")
test_config_dir = Path(os.path.join(resources_dir, "test-config")).resolve()


class ProtoPathsUtilsTest(unittest.TestCase):
    def test_find_versioned_proto_path_nested_version_success(self):
        proto_path = "google/cloud/aiplatform/v1/schema/predict/params/image_classification.proto"
        expected = "google/cloud/aiplatform/v1"
        self.assertEqual(expected, find_versioned_proto_path(proto_path))

    def test_find_versioned_proto_path_success(self):
        proto_path = "google/cloud/asset/v1p2beta1/assets.proto"
        expected = "google/cloud/asset/v1p2beta1"
        self.assertEqual(expected, find_versioned_proto_path(proto_path))

    def test_find_versioned_proto_without_version_return_itself(self):
        proto_path = "google/type/color.proto"
        expected = "google/type/color.proto"
        self.assertEqual(expected, find_versioned_proto_path(proto_path))

    def test_ends_with_version_valid(self):
        self.assertTrue(ends_with_version("google/cloud/gsuiteaddons/v1"))
        self.assertTrue(ends_with_version("google/iam/v1beta"))
        self.assertTrue(ends_with_version("google/iam/v2betav1"))
        self.assertTrue(ends_with_version("google/cloud/alloydb/connectors/v1alpha"))
        self.assertTrue(ends_with_version("v1"))
        self.assertTrue(ends_with_version("anything/v123"))

    def test_ends_with_version_invalid(self):
        self.assertFalse(ends_with_version("google/apps/script/type"))
        self.assertFalse(ends_with_version("google/apps/script/type/docs"))
        self.assertFalse(
            ends_with_version("google/cloud/alloydb/connectors/v123/something")
        )
        self.assertFalse(ends_with_version(""))
        self.assertFalse(ends_with_version("noVersion"))
