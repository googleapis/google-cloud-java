// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.protoparser;

import static com.google.api.generator.gapic.protoparser.PluginArgumentParser.KEY_METADATA;
import static com.google.api.generator.gapic.protoparser.PluginArgumentParser.KEY_NUMERIC_ENUM;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PluginArgumentParserTest {
  @Test
  void parseJsonPath_onlyOnePresent() {
    String jsonPath = "/tmp/grpc_service_config.json";
    assertEquals(
        jsonPath,
        PluginArgumentParser.parseJsonConfigPath(createGrpcServiceConfig(jsonPath)).get());
  }

  @Test
  void parseJsonPath_returnsFirstOneFound() {
    String jsonPathOne = "/tmp/foobar_grpc_service_config.json";
    String jsonPathTwo = "/tmp/some_other_grpc_service_config.json";
    assertEquals(
        jsonPathOne,
        PluginArgumentParser.parseJsonConfigPath(
                String.join(
                    ",",
                    Arrays.asList(
                        createGrpcServiceConfig(jsonPathOne),
                        createGrpcServiceConfig(jsonPathTwo))))
            .get());
  }

  @Test
  void parseJsonPath_similarFileAppearsFirst() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "/tmp/something_gapic.yaml";
    String rawArgument =
        String.join(
            ",",
            Arrays.asList(
                createGapicConfig(gapicPath),
                createGrpcServiceConfig("/tmp/something.json"),
                createGrpcServiceConfig("/tmp/some_grpc_service_configjson"),
                createGrpcServiceConfig(jsonPath),
                createGapicConfig(gapicPath)));
    assertEquals(jsonPath, PluginArgumentParser.parseJsonConfigPath(rawArgument).get());
  }

  @Test
  void parseJsonPath_argumentHasSpaces() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "/tmp/something_gapic.yaml";
    String rawArgument =
        String.join(
            " , ",
            Arrays.asList(
                createGapicConfig(gapicPath),
                createGrpcServiceConfig("/tmp/something.json"),
                createGrpcServiceConfig("/tmp/some_grpc_service_configjson"),
                createGrpcServiceConfig(jsonPath),
                createGapicConfig(gapicPath)));
    assertEquals(jsonPath, PluginArgumentParser.parseJsonConfigPath(rawArgument).get());
  }

  @Test
  void parseJsonPath_restAreEmpty() {
    String jsonPath = "/tmp/foobar_grpc_service_config.json";
    String gapicPath = "";
    String rawArgument =
        String.join(",", Arrays.asList(gapicPath, createGrpcServiceConfig(jsonPath), gapicPath));
    assertEquals(jsonPath, PluginArgumentParser.parseJsonConfigPath(rawArgument).get());
  }

  @Test
  void parseJsonPath_noneFound() {
    String gapicPath = "/tmp/something_gapic.yaml";
    String rawArgument = String.join(",", Arrays.asList(gapicPath));
    assertFalse(PluginArgumentParser.parseJsonConfigPath(rawArgument).isPresent());
  }

  @Test
  void parseGapicYamlPath_onlyOnePresent() {
    String gapicPath = "/tmp/something_gapic.yaml";
    assertEquals(
        gapicPath,
        PluginArgumentParser.parseGapicYamlConfigPath(createGapicConfig(gapicPath)).get());
  }

  @Test
  void parseGapicYamlPath_returnsFirstOneFound() {
    String gapicPathOne = "/tmp/something_gapic.yaml";
    String gapicPathTwo = "/tmp/other_gapic.yaml";
    assertEquals(
        gapicPathOne,
        PluginArgumentParser.parseGapicYamlConfigPath(
                String.join(
                    ",",
                    Arrays.asList(
                        createGapicConfig(gapicPathOne), createGapicConfig(gapicPathTwo))))
            .get());
  }

  @Test
  void parseGapicYamlPath_similarFileAppearsFirst() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "/tmp/something_gapic.yaml";
    String rawArgument =
        String.join(
            ",",
            Arrays.asList(
                createGrpcServiceConfig(jsonPath),
                createGapicConfig("/tmp/something.yaml"),
                createGapicConfig("/tmp/some_gapicyaml"),
                createGapicConfig(gapicPath)));
    assertEquals(gapicPath, PluginArgumentParser.parseGapicYamlConfigPath(rawArgument).get());
  }

  @Test
  void parseGapicYamlPath_restAreEmpty() {
    String jsonPath = "";
    String gapicPath = "/tmp/something_gapic.yaml";
    String rawArgument =
        String.join(",", Arrays.asList(jsonPath, createGapicConfig(gapicPath), jsonPath));
    assertEquals(gapicPath, PluginArgumentParser.parseGapicYamlConfigPath(rawArgument).get());
  }

  @Test
  void parseGapicYamlPath_noneFound() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "";
    String rawArgument =
        String.join(",", Arrays.asList(createGrpcServiceConfig(jsonPath), gapicPath));
    assertFalse(PluginArgumentParser.parseGapicYamlConfigPath(rawArgument).isPresent());
  }

  @Test
  void parseServiceYamlPath_onlyOnePresent() {
    String servicePath = "/tmp/something.yaml";
    assertEquals(
        servicePath,
        PluginArgumentParser.parseServiceYamlConfigPath(createServiceConfig(servicePath)).get());
  }

  @Test
  void parseServiceYamlPath_returnsFirstOneFound() {
    String servicePathOne = "/tmp/something.yaml";
    String servicePathTwo = "/tmp/other.yaml";
    assertEquals(
        servicePathOne,
        PluginArgumentParser.parseServiceYamlConfigPath(
                String.join(
                    ",",
                    Arrays.asList(
                        createServiceConfig(servicePathOne), createServiceConfig(servicePathTwo))))
            .get());
  }

  @Test
  void parseServiceYamlPath_gapicFilePresent() {
    String gapicPath = "/tmp/something_gapic.yaml";
    String servicePath = "/tmp/something.yaml";
    // Both passed under the service yaml flag.
    String rawArgument =
        String.join(
            ",", Arrays.asList(createServiceConfig(gapicPath), createServiceConfig(servicePath)));
    assertEquals(servicePath, PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).get());

    // Passed under the right flags.
    rawArgument =
        String.join(
            ",", Arrays.asList(createGapicConfig(gapicPath), createServiceConfig(servicePath)));
    assertEquals(servicePath, PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).get());

    // Swapped flags.
    rawArgument =
        String.join(
            ",", Arrays.asList(createGapicConfig(servicePath), createServiceConfig(gapicPath)));
    assertFalse(PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).isPresent());

    // Both passed under the Gapic yaml flag.
    rawArgument =
        String.join(
            ",", Arrays.asList(createGapicConfig(gapicPath), createGapicConfig(servicePath)));
    assertFalse(PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).isPresent());
  }

  @Test
  void parseServiceYamlPath_similarFileAppearsFirst() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "/tmp/something_gapic.yaml";
    String servicePath = "/tmp/something.yaml";
    String rawArgument =
        String.join(
            ",",
            Arrays.asList(
                createGrpcServiceConfig(jsonPath),
                createGapicConfig("/tmp/something.yaml"),
                createGapicConfig("/tmp/some_gapicyaml"),
                createServiceConfig(gapicPath),
                createServiceConfig(servicePath)));
    assertEquals(servicePath, PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).get());
  }

  @Test
  void parseServiceYamlPath_noneFound() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "";
    String rawArgument =
        String.join(",", Arrays.asList(createGrpcServiceConfig(jsonPath), gapicPath));
    assertFalse(PluginArgumentParser.parseServiceYamlConfigPath(rawArgument).isPresent());
  }

  @Test
  void hasMetadataFlag() {
    CodeGeneratorRequest request =
        CodeGeneratorRequest.newBuilder()
            .setParameter(String.join(",", KEY_METADATA, "does-not-matter"))
            .build();
    assertTrue(PluginArgumentParser.hasMetadataFlag(request));
  }

  @Test
  void hasNumericEnumFlag() {
    CodeGeneratorRequest request =
        CodeGeneratorRequest.newBuilder()
            .setParameter(String.join(",", KEY_NUMERIC_ENUM, "does-not-matter"))
            .build();
    assertTrue(PluginArgumentParser.hasNumericEnumFlag(request));
  }

  @Test
  void hasFlag_noneFound() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "";
    String rawArgument =
        String.join(",", Arrays.asList(createGrpcServiceConfig(jsonPath), gapicPath));
    assertFalse(PluginArgumentParser.hasFlag(rawArgument, KEY_METADATA));

    // Wrong casing.
    rawArgument =
        String.join(",", Arrays.asList("Metadata", createGrpcServiceConfig(jsonPath), gapicPath));
    assertFalse(PluginArgumentParser.hasFlag(rawArgument, KEY_METADATA));
  }

  @Test
  void hasFlag_flagFound() {
    String jsonPath = "/tmp/foo_grpc_service_config.json";
    String gapicPath = "";
    String rawArgument =
        String.join(",", Arrays.asList("metadata", createGrpcServiceConfig(jsonPath), gapicPath));
    assertTrue(PluginArgumentParser.hasFlag(rawArgument, KEY_METADATA));
  }

  @Test
  void parseRepo() {
    String repo = "googleapis/sdk-platform-java";
    String rawArgument = String.format("repo=%s", repo);
    assertEquals(
        repo,
        PluginArgumentParser.parseRepo(
                CodeGeneratorRequest.newBuilder().setParameter(rawArgument).build())
            .get());
  }

  @Test
  void parseArtifact() {
    String artifact = "com.google.cloud:google-cloud-library";
    String rawArgument = String.format("artifact=%s", artifact);
    assertEquals(
        artifact,
        PluginArgumentParser.parseArtifact(
                CodeGeneratorRequest.newBuilder().setParameter(rawArgument).build())
            .get());
  }

  private static String createGrpcServiceConfig(String path) {
    return String.format("%s=%s", PluginArgumentParser.KEY_GRPC_SERVICE_CONFIG, path);
  }

  private static String createGapicConfig(String path) {
    return String.format("%s=%s", PluginArgumentParser.KEY_GAPIC_CONFIG, path);
  }

  private static String createServiceConfig(String path) {
    return String.format("%s=%s", PluginArgumentParser.KEY_SERVICE_YAML_CONFIG, path);
  }
}
