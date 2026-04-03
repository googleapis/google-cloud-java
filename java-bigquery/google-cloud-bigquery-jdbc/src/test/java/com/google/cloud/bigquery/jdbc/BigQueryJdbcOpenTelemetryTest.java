/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcOpenTelemetryTest {

  @Test
  public void testGetOpenTelemetry_withCustomSdk_returnsCustom() {
    OpenTelemetry mockCustomOtel = mock(OpenTelemetry.class);

    OpenTelemetry result = BigQueryJdbcOpenTelemetry.getOpenTelemetry(false, false, mockCustomOtel);

    assertThat(result).isSameInstanceAs(mockCustomOtel);
  }

  @Test
  public void testGetOpenTelemetry_withCustomSdkAndFlags_returnsCustom() {
    OpenTelemetry mockCustomOtel = mock(OpenTelemetry.class);

    // Custom SDK always takes precedence over individual flags
    OpenTelemetry result = BigQueryJdbcOpenTelemetry.getOpenTelemetry(true, true, mockCustomOtel);

    assertThat(result).isSameInstanceAs(mockCustomOtel);
  }

  @Test
  public void testGetOpenTelemetry_noFlags_returnsNoop() {
    OpenTelemetry result = BigQueryJdbcOpenTelemetry.getOpenTelemetry(false, false, null);

    assertThat(result).isSameInstanceAs(OpenTelemetry.noop());
  }

  @Test
  public void testGetTracer_respectsScopeName() {
    Tracer result = BigQueryJdbcOpenTelemetry.getTracer(OpenTelemetry.noop());

    assertThat(result).isNotNull();
  }
}
