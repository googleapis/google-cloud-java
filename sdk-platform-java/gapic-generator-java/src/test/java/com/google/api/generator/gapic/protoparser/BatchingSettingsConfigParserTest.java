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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.gapic.model.GapicBatchingSettings;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class BatchingSettingsConfigParserTest {

  private static final String YAML_DIRECTORY = "src/test/resources/";

  @Test
  void parseGapicSettings_plain() {
    String filename = "datastore_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicBatchingSettings>> settingsOpt =
        BatchingSettingsConfigParser.parse(path.toString());
    assertFalse(settingsOpt.isPresent());
  }

  @Test
  void parseGapicSettings_noMethodSettings() {
    String filename = "showcase_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicBatchingSettings>> settingsOpt =
        BatchingSettingsConfigParser.parse(path.toString());
    assertFalse(settingsOpt.isPresent());
  }

  @Test
  void parseBatchingSettings_logging() {
    String filename = "logging_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicBatchingSettings>> settingsOpt =
        BatchingSettingsConfigParser.parse(path.toString());
    assertTrue(settingsOpt.isPresent());

    List<GapicBatchingSettings> batchingSettings = settingsOpt.get();
    assertEquals(1, batchingSettings.size());
    GapicBatchingSettings setting = batchingSettings.get(0);

    assertEquals("google.logging.v2", setting.protoPakkage());
    assertEquals("LoggingServiceV2", setting.serviceName());
    assertEquals("WriteLogEntries", setting.methodName());

    assertEquals(1000, setting.elementCountThreshold());
    assertEquals(1048576, setting.requestByteThreshold());
    assertEquals(50, setting.delayThresholdMillis());

    assertThat(setting.flowControlElementLimit()).isNotNull();
    assertEquals(100000, (long) setting.flowControlElementLimit());
    assertThat(setting.flowControlByteLimit()).isNotNull();
    assertEquals(10485760, (long) setting.flowControlByteLimit());
    assertEquals(
        GapicBatchingSettings.FlowControlLimitExceededBehavior.THROW_EXCEPTION,
        setting.flowControlLimitExceededBehavior());

    assertEquals("entries", setting.batchedFieldName());
    assertThat(setting.discriminatorFieldNames()).containsExactly("log_name", "resource", "labels");
    assertThat(setting.subresponseFieldName()).isNull();
  }

  @Test
  void parseBatchingSettings_pubsub() {
    String filename = "pubsub_gapic.yaml";
    Path path = Paths.get(YAML_DIRECTORY, filename);
    Optional<List<GapicBatchingSettings>> settingsOpt =
        BatchingSettingsConfigParser.parse(path.toString());
    assertTrue(settingsOpt.isPresent());

    List<GapicBatchingSettings> batchingSettings = settingsOpt.get();
    assertEquals(1, batchingSettings.size());
    GapicBatchingSettings setting = batchingSettings.get(0);

    assertEquals("google.pubsub.v1", setting.protoPakkage());
    assertEquals("Publisher", setting.serviceName());
    assertEquals("Publish", setting.methodName());

    assertEquals(100, setting.elementCountThreshold());
    assertEquals(1048576, setting.requestByteThreshold());
    assertEquals(10, setting.delayThresholdMillis());

    assertThat(setting.flowControlElementLimit()).isNull();
    assertThat(setting.flowControlByteLimit()).isNull();
    assertEquals(
        GapicBatchingSettings.FlowControlLimitExceededBehavior.IGNORE,
        setting.flowControlLimitExceededBehavior());

    assertEquals("messages", setting.batchedFieldName());
    assertThat(setting.discriminatorFieldNames()).containsExactly("topic");
    assertEquals("message_ids", setting.subresponseFieldName());
  }
}
