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
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link DatastoreMetricsRecorder#getInstance(DatastoreOptions, OpenTelemetry)}. */
@RunWith(JUnit4.class)
public class DatastoreMetricsRecorderTest {

  private static final String PROJECT_ID = "test-project";

  private DatastoreOptions.Builder baseOptions() {
    return DatastoreOptions.newBuilder()
        .setProjectId(PROJECT_ID)
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void defaultOptionsWithBuiltInMetricsDisabled_returnsNoRecorders() {
    // When both custom metrics and built-in metrics export are disabled,
    // there should be no recorders
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .build())
            .build();
    OpenTelemetry builtInOtel = EasyMock.createMock(OpenTelemetry.class);
    EasyMock.replay(builtInOtel);
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options, builtInOtel);
    assertThat(recorder).isInstanceOf(CompositeDatastoreMetricsRecorder.class);
    CompositeDatastoreMetricsRecorder compositeRecorder =
        (CompositeDatastoreMetricsRecorder) recorder;
    assertThat(compositeRecorder.getMetricRecorders().size()).isEqualTo(0);
  }

  @Test
  public void tracingEnabledButMetricsDisabledAndBuiltInDisabled_returnsNoRecorders() {
    // Enabling tracing alone should not enable metrics
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .build())
            .build();
    OpenTelemetry builtInOtel = EasyMock.createMock(OpenTelemetry.class);
    EasyMock.replay(builtInOtel);
    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options, builtInOtel);
    assertThat(recorder).isInstanceOf(CompositeDatastoreMetricsRecorder.class);
    CompositeDatastoreMetricsRecorder compositeRecorder =
        (CompositeDatastoreMetricsRecorder) recorder;
    assertThat(compositeRecorder.getMetricRecorders().size()).isEqualTo(0);
  }

  @Test
  public void defaultOptionsWithBuiltInMetricsEnabled_butNoCredentials_returnsOneRecorder() {
    // Explicitly enable built-in metrics export
    DatastoreOptions options =
        baseOptions() // Uses NoCredentials by default
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(true)
                    .build())
            .build();
    DatastoreMetricsRecorder recorder =
        DatastoreMetricsRecorder.getInstance(options, OpenTelemetry.noop());

    // Since baseOptions() uses NoCredentials, the provider returns OpenTelemetry.noop().
    // This NoOp instance is passed to getInstance, which adds it to the recorders list.
    // So we have 1 recorder (the NoOp one).
    assertThat(recorder).isInstanceOf(CompositeDatastoreMetricsRecorder.class);
    CompositeDatastoreMetricsRecorder compositeRecorder =
        (CompositeDatastoreMetricsRecorder) recorder;
    assertThat(compositeRecorder.getMetricRecorders().size()).isEqualTo(1);
  }

  @Test
  public void openTelemetryRecorderCreatedWithExplicitOpenTelemetry() {
    OpenTelemetry openTelemetry = OpenTelemetry.noop();

    OpenTelemetryDatastoreMetricsRecorder recorder =
        new OpenTelemetryDatastoreMetricsRecorder(openTelemetry, TelemetryConstants.METRIC_PREFIX);

    assertThat(recorder.getOpenTelemetry()).isSameInstanceAs(openTelemetry);
  }

  @Test
  public void builtInDisabledAndCustomEnabled_returnsOneRecorder() {
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(OpenTelemetry.noop())
                    .build())
            .build();
    OpenTelemetry builtInOtel = EasyMock.createMock(OpenTelemetry.class);
    EasyMock.replay(builtInOtel);

    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options, builtInOtel);
    assertThat(recorder).isInstanceOf(CompositeDatastoreMetricsRecorder.class);
    CompositeDatastoreMetricsRecorder compositeRecorder =
        (CompositeDatastoreMetricsRecorder) recorder;
    assertThat(compositeRecorder.getMetricRecorders().size()).isEqualTo(1);
  }

  @Test
  public void bothEnabled_returnsTwoRecorders() {
    DatastoreOptions options =
        baseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(true)
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(OpenTelemetry.noop())
                    .build())
            .build();
    OpenTelemetry builtInOtel = OpenTelemetry.noop();

    DatastoreMetricsRecorder recorder = DatastoreMetricsRecorder.getInstance(options, builtInOtel);
    assertThat(recorder).isInstanceOf(CompositeDatastoreMetricsRecorder.class);
    CompositeDatastoreMetricsRecorder compositeRecorder =
        (CompositeDatastoreMetricsRecorder) recorder;
    assertThat(compositeRecorder.getMetricRecorders().size()).isEqualTo(2);
  }
}
