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
  public void defaultOptionsWithBuiltInMetricsDisabled_returnsNoOp() {
    // When both custom metrics and built-in metrics export are disabled, should return NoOp
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .build())
            .build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);
    assertThat(recorder).isInstanceOf(NoOpDatastoreMetricsRecorder.class);
  }

  @Test
  public void tracingEnabledButMetricsDisabledAndBuiltInDisabled_returnsNoOp() {
    // Enabling tracing alone should not enable metrics
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .build())
            .build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);
    assertThat(recorder).isInstanceOf(NoOpDatastoreMetricsRecorder.class);
  }

  @Test
  public void defaultOptionsWithBuiltInMetricsEnabled_returnsOpenTelemetryRecorder() {
    // Explicitly enable built-in metrics export
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(true)
                    .build())
            .build();
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options);

    // If we're not in an emulator, it should return a OpenTelemetryDatastoreMetricsRecorder
    // (Note: System.getenv() is hard to mock, but we assume it's not set in test environment)
    String emulatorHost = System.getenv(DatastoreOptions.LOCAL_HOST_ENV_VAR);
    if (emulatorHost == null || emulatorHost.isEmpty()) {
      assertThat(recorder).isInstanceOf(OpenTelemetryDatastoreMetricsRecorder.class);
    } else {
      assertThat(recorder).isInstanceOf(NoOpDatastoreMetricsRecorder.class);
    }
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
