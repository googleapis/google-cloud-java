import os
import unittest
from pathlib import Path

from parameterized import parameterized
from common.model.gapic_inputs import parse

script_dir = os.path.dirname(os.path.realpath(__file__))
resources_dir = os.path.join(script_dir, "..", "resources")
build_file = Path(os.path.join(resources_dir, "misc")).resolve()


class UtilitiesTest(unittest.TestCase):
    @parameterized.expand(
        [
            ("BUILD_no_additional_protos.bazel", " "),
            ("BUILD_common_resources.bazel", "  google/cloud/common_resources.proto"),
            ("BUILD_comment_common_resources.bazel", " "),
            ("BUILD_locations.bazel", "  google/cloud/location/locations.proto"),
            ("BUILD_comment_locations.bazel", " "),
            ("BUILD_iam_policy.bazel", "  google/iam/v1/iam_policy.proto"),
            ("BUILD_comment_iam_policy.bazel", " "),
            (
                "BUILD_iam_locations.bazel",
                "  google/cloud/location/locations.proto google/iam/v1/iam_policy.proto",
            ),
        ]
    )
    def test_gapic_inputs_parse_additional_protos(self, build_name, expected):
        parsed = parse(build_file, "", build_name)
        self.assertEqual(
            expected,
            parsed.additional_protos,
        )

    def test_gapic_inputs_parse_grpc_only_succeeds(self):
        parsed = parse(build_file, "", "BUILD_grpc.bazel")
        self.assertEqual("grpc", parsed.transport)

    def test_gapic_inputs_parse_grpc_rest_succeeds(self):
        parsed = parse(build_file, "", "BUILD_grpc_rest.bazel")
        self.assertEqual("grpc+rest", parsed.transport)

    def test_gapic_inputs_parse_rest_succeeds(self):
        parsed = parse(build_file, "", "BUILD_rest.bazel")
        self.assertEqual("rest", parsed.transport)

    def test_gapic_inputs_parse_empty_include_samples_succeeds(self):
        parsed = parse(build_file, "", "BUILD_include_samples_empty.bazel")
        self.assertEqual("false", parsed.include_samples)

    def test_gapic_inputs_parse_include_samples_false_succeeds(self):
        parsed = parse(build_file, "", "BUILD_include_samples_false.bazel")
        self.assertEqual("false", parsed.include_samples)

    def test_gapic_inputs_parse_include_samples_true_succeeds(self):
        parsed = parse(build_file, "", "BUILD_include_samples_true.bazel")
        self.assertEqual("true", parsed.include_samples)

    def test_gapic_inputs_parse_empty_rest_numeric_enums_succeeds(self):
        parsed = parse(build_file, "", "BUILD_rest_numeric_enums_empty.bazel")
        self.assertEqual("false", parsed.rest_numeric_enum)

    def test_gapic_inputs_parse_rest_numeric_enums_false_succeeds(self):
        parsed = parse(build_file, "", "BUILD_rest_numeric_enums_false.bazel")
        self.assertEqual("false", parsed.rest_numeric_enum)

    def test_gapic_inputs_parse_rest_numeric_enums_true_succeeds(self):
        parsed = parse(build_file, "", "BUILD_rest_numeric_enums_true.bazel")
        self.assertEqual("true", parsed.rest_numeric_enum)

    def test_gapic_inputs_parse_no_gapic_library_returns_proto_only_true(self):
        # include_samples_empty only has a gradle assembly rule
        parsed = parse(build_file, "", "BUILD_include_samples_empty.bazel")
        self.assertEqual("true", parsed.proto_only)

    def test_gapic_inputs_parse_with_gapic_library_returns_proto_only_false(self):
        # rest.bazel has a java_gapic_library rule
        parsed = parse(build_file, "", "BUILD_rest.bazel")
        self.assertEqual("false", parsed.proto_only)

    def test_gapic_inputs_parse_gapic_yaml_succeeds(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_gapic_yaml.bazel")
        self.assertEqual("test/versioned/path/test_gapic_yaml.yaml", parsed.gapic_yaml)

    def test_gapic_inputs_parse_no_gapic_yaml_returns_empty_string(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_no_gapic_yaml.bazel")
        self.assertEqual("", parsed.gapic_yaml)

    def test_gapic_inputs_parse_service_config_succeeds(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_service_config.bazel")
        self.assertEqual(
            "test/versioned/path/test_service_config.json", parsed.service_config
        )

    def test_gapic_inputs_parse_service_yaml_relative_target(self):
        parsed = parse(
            build_file,
            "google/cloud/compute/v1",
            "BUILD_service_config_relative_target.bazel",
        )
        self.assertEqual(
            "google/cloud/compute/v1/compute_grpc_service_config.json",
            parsed.service_config,
        )

    def test_gapic_inputs_parse_no_service_config_returns_empty_string(self):
        parsed = parse(
            build_file, "test/versioned/path", "BUILD_no_service_config.bazel"
        )
        self.assertEqual("", parsed.service_config)

    def test_gapic_inputs_parse_service_yaml_succeeds(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_service_yaml.bazel")
        self.assertEqual(
            "test/versioned/path/test_service_yaml.yaml", parsed.service_yaml
        )

    def test_gapic_inputs_parse_service_yaml_absolute_target(self):
        parsed = parse(build_file, "", "BUILD_service_yaml_absolute_target.bazel")
        self.assertEqual(
            "google/cloud/videointelligence/videointelligence_v1p3beta1.yaml",
            parsed.service_yaml,
        )

    def test_gapic_inputs_parse_no_service_yaml_returns_empty_string(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_no_service_yaml.bazel")
        self.assertEqual("", parsed.service_yaml)

    def test_gapic_inputs_parse_proto_only_returns_grpc(self):
        parsed = parse(build_file, "test/versioned/path", "BUILD_proto_only.bazel")
        self.assertEqual("grpc", parsed.transport)
