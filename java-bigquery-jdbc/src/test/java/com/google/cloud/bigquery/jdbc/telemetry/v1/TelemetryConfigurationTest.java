/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TelemetryConfigurationTest {

  @Test
  public void testDefaultValues() {
    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().build();

    assertTrue(config.isEnabled());
    assertEquals(-1, config.getLogSource());
    assertEquals("https://play.googleapis.com/log", config.getEndpointUrl());
    assertEquals(300_000L, config.getUploadIntervalMs());
    assertEquals(100, config.getBatchSizeThreshold());
    assertNull(config.getDriverEnvironment());
  }

  @Test
  public void testCustomValues() {
    DriverEnvironment environment =
        DriverEnvironment.newBuilder()
            .setDriverName("BigQuery JDBC")
            .setDriverVersion("1.0.0")
            .build();

    TelemetryConfiguration config =
        TelemetryConfiguration.newBuilder()
            .setEnabled(false)
            .setLogSource(1234)
            .setEndpointUrl("https://custom.endpoint.com/log")
            .setUploadIntervalMs(60_000L)
            .setBatchSizeThreshold(50)
            .setDriverEnvironment(environment)
            .build();

    assertFalse(config.isEnabled());
    assertEquals(1234, config.getLogSource());
    assertEquals("https://custom.endpoint.com/log", config.getEndpointUrl());
    assertEquals(60_000L, config.getUploadIntervalMs());
    assertEquals(50, config.getBatchSizeThreshold());
    assertEquals(environment, config.getDriverEnvironment());
  }

  @Test
  public void testEqualsAndHashCode() {
    TelemetryConfiguration config1 =
        TelemetryConfiguration.newBuilder().setEnabled(true).setLogSource(1234).build();

    TelemetryConfiguration config2 =
        TelemetryConfiguration.newBuilder().setEnabled(true).setLogSource(1234).build();

    TelemetryConfiguration config3 =
        TelemetryConfiguration.newBuilder().setEnabled(false).setLogSource(1234).build();

    assertEquals(config1, config2);
    assertEquals(config1.hashCode(), config2.hashCode());
    assertNotEquals(config1, config3);
    assertNotEquals(config1, null);
    assertNotEquals(config1, "string");
  }
}
