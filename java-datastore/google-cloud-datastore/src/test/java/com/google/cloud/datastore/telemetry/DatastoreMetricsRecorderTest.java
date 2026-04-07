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

import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptionsTestHelper;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link DatastoreMetricsRecorder#getInstance(DatastoreOptions)}. */
@RunWith(JUnit4.class)
public class DatastoreMetricsRecorderTest {

  private static final String PROJECT_ID = "test-project";

  private DatastoreOptions.Builder baseOptions() {
    return DatastoreOptions.newBuilder()
        .setProjectId(PROJECT_ID)
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void defaultOptions_returnsNoOp() {
    // metricsEnabled defaults to false, so getInstance() should return NoOp
    DatastoreOptions options = baseOptions().build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);
    assertThat(recorder).isInstanceOf(NoOpDatastoreMetricsRecorder.class);
  }

  @Test
  public void tracingEnabledButMetricsDisabled_returnsNoOp() {
    // Enabling tracing alone should not enable metrics
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
            .build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);
    assertThat(recorder).isInstanceOf(NoOpDatastoreMetricsRecorder.class);
  }

  @Test
  public void metricsEnabled_withCustomOtel_returnsOpenTelemetryRecorder() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    // Use DatastoreOpenTelemetryOptionsTestHelper since setMetricsEnabled() is package-private
    // and this test lives in the telemetry sub-package.
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptionsTestHelper.withMetricsEnabled(openTelemetry))
            .build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);
    assertThat(recorder).isInstanceOf(OpenTelemetryDatastoreMetricsRecorder.class);
  }

  @Test
  public void openTelemetryRecorderCreatedWithExplicitOpenTelemetry() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    OpenTelemetryDatastoreMetricsRecorder recorder =
        new OpenTelemetryDatastoreMetricsRecorder(openTelemetry, TelemetryConstants.METRIC_PREFIX);

    assertThat(recorder.getOpenTelemetry()).isSameInstanceAs(openTelemetry);
  }
}
