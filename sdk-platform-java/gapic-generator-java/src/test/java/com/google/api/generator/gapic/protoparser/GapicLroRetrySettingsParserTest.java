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
import static org.junit.Assert.assertFalse;

import com.google.api.generator.gapic.model.GapicLroRetrySettings;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class GapicLroRetrySettingsParserTest {

  private static final double DELTA = 0.0001;
  private static final String YAML_DIRECTORY = "src/test/resources/";

  @Test
  void parseLroRetrySettings_methodsPresentNoLroRetrySettings() {
    String filename = "datastore_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicLroRetrySettings>> settingsOpt =
        GapicLroRetrySettingsParser.parse(path.toString());
    assertFalse(settingsOpt.isPresent());
  }

  @Test
  void parseGapicSettings_noMethodSettings() {
    String filename = "showcase_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicLroRetrySettings>> settingsOpt =
        GapicLroRetrySettingsParser.parse(path.toString());
    assertFalse(settingsOpt.isPresent());
  }

  @Test
  void parseLroRetrySettings_lroRetrySettingsPresent() {
    String filename = "dataproc_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicLroRetrySettings>> settingsOpt =
        GapicLroRetrySettingsParser.parse(path.toString());

    List<GapicLroRetrySettings> lroRetrySettings = settingsOpt.get();
    assertEquals(6, lroRetrySettings.size());

    // This LRO setting has a max_poll_delay_millis that will be parsed as an integer.
    GapicLroRetrySettings setting = lroRetrySettings.get(0);
    assertEquals("google.cloud.dataproc.v1", setting.protoPakkage());
    assertEquals("ClusterController", setting.serviceName());
    assertEquals("CreateCluster", setting.methodName());

    assertEquals(1000, setting.initialPollDelayMillis());
    assertEquals(2, setting.pollDelayMultiplier(), DELTA);
    assertEquals(10000, setting.maxPollDelayMillis());
    assertEquals(900000, setting.totalPollTimeoutMillis());

    // Sanity-check on a different service and method.
    // The list element order is coupled to the definition order in the gapic.yaml file.
    // This LRO setting has a max_poll_delay_millis that will be parsed as a double.
    setting = lroRetrySettings.get(4);
    assertEquals("google.cloud.dataproc.v1", setting.protoPakkage());
    assertEquals("WorkflowTemplateService", setting.serviceName());
    assertEquals("InstantiateWorkflowTemplate", setting.methodName());

    assertEquals(1000, setting.initialPollDelayMillis());
    assertEquals(2.5, setting.pollDelayMultiplier(), DELTA);
    assertEquals(10000, setting.maxPollDelayMillis());
    assertEquals(43200000, setting.totalPollTimeoutMillis());
  }
}
