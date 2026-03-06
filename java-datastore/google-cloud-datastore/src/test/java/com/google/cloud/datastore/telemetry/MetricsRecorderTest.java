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

import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link MetricsRecorder#getInstance(DatastoreOpenTelemetryOptions)}.
 *
 * <p>Note: Since {@code setMetricsEnabled()} is package-private on {@link
 * DatastoreOpenTelemetryOptions.Builder}, these tests can only verify the default (metrics
 * disabled) behavior and the behavior when an explicit OpenTelemetry instance is provided. The
 * metrics-enabled paths are exercised through the {@link DatastoreImplMetricsTest} which operates
 * in the {@code com.google.cloud.datastore} package.
 */
@RunWith(JUnit4.class)
public class MetricsRecorderTest {

  @Test
  public void defaultOptionsReturnNoOp() {
    DatastoreOpenTelemetryOptions options = DatastoreOpenTelemetryOptions.newBuilder().build();

    MetricsRecorder recorder = MetricsRecorder.getInstance(options);

    assertThat(recorder).isInstanceOf(NoOpMetricsRecorder.class);
  }

  @Test
  public void tracingEnabledButMetricsDisabledReturnsNoOp() {
    // Enabling tracing alone should not enable metrics
    DatastoreOpenTelemetryOptions options =
        DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build();

    MetricsRecorder recorder = MetricsRecorder.getInstance(options);

    assertThat(recorder).isInstanceOf(NoOpMetricsRecorder.class);
  }

  @Test
  public void noOpRecorderDoesNotThrow() {
    // Verify NoOpMetricsRecorder methods do not throw
    NoOpMetricsRecorder recorder = new NoOpMetricsRecorder();
    recorder.recordTransactionLatency(100.0, null);
    recorder.recordTransactionAttemptCount(1, null);
  }

  @Test
  public void openTelemetryRecorderCreatedWithExplicitOpenTelemetry() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    OpenTelemetryMetricsRecorder recorder = new OpenTelemetryMetricsRecorder(openTelemetry);

    assertThat(recorder.getOpenTelemetry()).isSameInstanceAs(openTelemetry);
  }
}
