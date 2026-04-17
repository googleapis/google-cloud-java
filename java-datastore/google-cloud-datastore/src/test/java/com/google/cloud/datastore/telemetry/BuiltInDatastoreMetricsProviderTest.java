/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.telemetry;

import static com.google.common.truth.Truth.assertThat;

import io.opentelemetry.api.OpenTelemetry;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInDatastoreMetricsProviderTest {

  private static final String PROJECT_ID = "project-id";

  @Test
  public void testBuildClientAttributes() {
    Map<String, String> attributes = BuiltInDatastoreMetricsProvider.buildClientAttributes();
    assertThat(attributes).containsKey(TelemetryConstants.CLIENT_UID_KEY.getKey());
    assertThat(attributes.get(TelemetryConstants.CLIENT_UID_KEY.getKey())).contains("@");
    assertThat(attributes).containsKey(TelemetryConstants.SERVICE_KEY.getKey());
    assertThat(attributes.get(TelemetryConstants.SERVICE_KEY.getKey()))
        .isEqualTo(TelemetryConstants.SERVICE_VALUE);
  }

  @Test
  public void testCreateOpenTelemetry_returnsNonNull() {
    OpenTelemetry otel =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(PROJECT_ID, "test-db", null);
    assertThat(otel).isNotNull();
  }

  @Test
  public void testCreateOpenTelemetry_eachCallReturnsDistinctInstance() {
    OpenTelemetry otel1 =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(PROJECT_ID, "test-db", null);
    OpenTelemetry otel2 =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(PROJECT_ID, "test-db", null);
    assertThat(otel1).isNotNull();
    assertThat(otel2).isNotNull();
    assertThat(otel1).isNotSameInstanceAs(otel2);
  }

  @Test
  public void testDetectClientLocation() {
    String location = BuiltInDatastoreMetricsProvider.detectClientLocation();
    assertThat(location).isEqualTo("global");
  }
}
