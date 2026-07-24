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

import com.google.auth.oauth2.GoogleCredentials;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BigQueryJdbcOpenTelemetryTest {

  private MockedStatic<GoogleCredentials> mockedCredentials;

  @BeforeEach
  public void setUp() {
    mockedCredentials = Mockito.mockStatic(GoogleCredentials.class);
    mockedCredentials
        .when(GoogleCredentials::getApplicationDefault)
        .thenReturn(mock(GoogleCredentials.class));
  }

  @AfterEach
  public void tearDown() {
    mockedCredentials.close();
  }

  @Test
  public void testGetOpenTelemetry_withCustomSdk_returnsCustom() {
    OpenTelemetry mockCustomOtel = mock(OpenTelemetry.class);

    OpenTelemetry result =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, false, false, mockCustomOtel, null, null, null);

    assertThat(result).isSameInstanceAs(mockCustomOtel);
  }

  @Test
  public void testGetOpenTelemetry_withCustomSdkAndFlags_returnsCustom() {
    OpenTelemetry mockCustomOtel = mock(OpenTelemetry.class);

    // Custom SDK always takes precedence over individual flags
    OpenTelemetry result =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, true, mockCustomOtel, null, null, null);

    assertThat(result).isSameInstanceAs(mockCustomOtel);
  }

  @Test
  public void testGetOpenTelemetry_noFlags_returnsNoop() {
    OpenTelemetry result =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(false, false, false, null, null, null, null);

    assertThat(result).isSameInstanceAs(OpenTelemetry.noop());
  }

  @Test
  public void testGetTracer_respectsScopeName() {
    Tracer result = BigQueryJdbcOpenTelemetry.getTracer(OpenTelemetry.noop());

    assertThat(result).isNotNull();
  }

  @Test
  public void testGetOpenTelemetry_cachesSdkInstances() {
    OpenTelemetry result1 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, false, null, null, "project1", null);
    OpenTelemetry result2 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, false, null, null, "project1", null);

    assertThat(result1).isSameInstanceAs(result2);
  }

  @Test
  public void testGetOpenTelemetry_createsNewInstanceForDifferentKey() {
    OpenTelemetry result1 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, false, null, null, "project1", null);
    OpenTelemetry result2 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, false, null, null, "project2", null);

    assertThat(result1).isNotSameInstanceAs(result2);
  }

  @Test
  public void testGetOpenTelemetry_createsNewInstanceForDifferentTraceFlag() {
    OpenTelemetry result1 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(false, true, true, null, null, "project1", null);
    OpenTelemetry result2 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, false, true, null, null, "project1", null);

    assertThat(result1).isNotSameInstanceAs(result2);
  }

  @Test
  public void testGetOpenTelemetry_ignoresEnableLogFlagInCacheKey() {
    OpenTelemetry result1 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(false, true, true, null, null, "project1", null);
    OpenTelemetry result2 =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            false, true, false, null, null, "project1", null);

    assertThat(result1).isSameInstanceAs(result2);
  }

  @Test
  public void testGetOpenTelemetry_withUseGlobalOTel_returnsGlobal() {
    OpenTelemetry result =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(true, false, false, null, null, null, null);

    assertThat(result).isSameInstanceAs(GlobalOpenTelemetry.get());
  }
}
