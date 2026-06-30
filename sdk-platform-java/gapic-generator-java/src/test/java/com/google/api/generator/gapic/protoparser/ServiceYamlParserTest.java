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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.MethodSettings;
import com.google.api.Publishing;
import com.google.common.truth.Truth;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ServiceYamlParserTest {

  private static final String YAML_DIRECTORY = "src/test/resources/";

  @Test
  void parseServiceYaml_basic() {
    String yamlFilename = "logging.yaml";
    Path yamlPath = Paths.get(YAML_DIRECTORY, yamlFilename);
    Optional<com.google.api.Service> serviceYamlProtoOpt =
        ServiceYamlParser.parse(yamlPath.toString());
    assertTrue(serviceYamlProtoOpt.isPresent());

    com.google.api.Service serviceYamlProto = serviceYamlProtoOpt.get();
    assertEquals("logging.googleapis.com", serviceYamlProto.getName());
  }

  // TODO: Add more scenarios (e.g. null MethodSettings, null PublishingSettings, incorrect
  // FieldNames, etc.)
  @Test
  void parseServiceYaml_autoPopulatedFields() {
    String yamlFilename = "auto_populate_field_testing.yaml";
    Path yamlPath = Paths.get(YAML_DIRECTORY, yamlFilename);
    Optional<com.google.api.Service> serviceYamlProtoOpt =
        ServiceYamlParser.parse(yamlPath.toString());
    assertTrue(serviceYamlProtoOpt.isPresent());

    com.google.api.Service serviceYamlProto = serviceYamlProtoOpt.get();
    assertEquals("autopopulatefieldtesting.googleapis.com", serviceYamlProto.getName());

    Publishing publishingSettings = serviceYamlProto.getPublishing();
    List<MethodSettings> methodSettings = publishingSettings.getMethodSettingsList();
    Truth.assertThat(methodSettings.size() == 2);
    Truth.assertThat(methodSettings.get(0).getSelector())
        .isEqualTo(
            "google.auto.populate.field.AutoPopulateFieldTesting.AutoPopulateFieldTestingEcho");
    Truth.assertThat(methodSettings.get(0).getAutoPopulatedFieldsList())
        .containsExactly(
            "request_id",
            "second_request_id",
            "third_request_id",
            "fourth_request_id",
            "non_existent_field");
    Truth.assertThat(methodSettings.get(1).getSelector())
        .isEqualTo(
            "google.auto.populate.field.AutoPopulateFieldTesting.AutoPopulateFieldTestingExpand");
    Truth.assertThat(methodSettings.get(1).getAutoPopulatedFieldsList())
        .containsExactly("request_id");
  }
}
