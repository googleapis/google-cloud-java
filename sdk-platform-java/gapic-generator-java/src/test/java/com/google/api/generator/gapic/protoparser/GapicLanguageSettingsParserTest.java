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

import com.google.api.generator.gapic.model.GapicLanguageSettings;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class GapicLanguageSettingsParserTest {

  private static final String YAML_DIRECTORY = "src/test/resources/";

  @Test
  void parseLanguageSettings_onlyInterfacePresent() {
    String filename = "datastore_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<GapicLanguageSettings> settingsOpt =
        GapicLanguageSettingsParser.parse(path.toString());
    assertTrue(settingsOpt.isPresent());
    GapicLanguageSettings settings = settingsOpt.get();
    assertEquals("com.google.cloud.datastore.v1", settings.pakkage());
    assertEquals("FooBar", settings.getJavaServiceName("google.datastore.v1", "FooBar"));
  }

  @Test
  void parseLanguageSettings_methodNameOverridesPresent() {
    String filename = "logging_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<GapicLanguageSettings> settingsOpt =
        GapicLanguageSettingsParser.parse(path.toString());
    assertTrue(settingsOpt.isPresent());
    GapicLanguageSettings settings = settingsOpt.get();
    assertEquals("com.google.cloud.logging.v2", settings.pakkage());
    assertEquals("Logging", settings.getJavaServiceName("google.logging.v2", "LoggingServiceV2"));
  }
}
