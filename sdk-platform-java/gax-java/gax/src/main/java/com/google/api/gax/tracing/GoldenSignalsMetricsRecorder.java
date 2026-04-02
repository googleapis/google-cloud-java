/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.tracing;

import com.google.api.gax.rpc.LibraryMetadata;
import com.google.common.base.Strings;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * This class takes an OpenTelemetry object, and creates instruments (meters, histograms etc.) from
 * it for recording golden signal metrics. There must be only one instance of
 * GoldenSignalsMetricsRecorder per client, all the methods in this class are expected to be called
 * from multiple threads, hence they need to be thread safe.
 */
class GoldenSignalsMetricsRecorder {
  static final String CLIENT_REQUEST_DURATION_METRIC_NAME = "gcp.client.request.duration";
  static final String CLIENT_REQUEST_DURATION_METRIC_DESCRIPTION =
      "Measures the total time taken for a logical client request, including any retries, backoff, and pre/post-processing";

  static final List<Double> BOUNDARIES =
      Arrays.asList(
          0.0, 0.0001, 0.0005, 0.0010, 0.005, 0.010, 0.050, 0.100, 0.5, 1.0, 5.0, 10.0, 60.0, 300.0,
          900.0, 3600.0);
  final DoubleHistogram clientRequestDurationRecorder;

  @Nullable
  static GoldenSignalsMetricsRecorder create(
      OpenTelemetry openTelemetry, LibraryMetadata libraryMetadata) {
    if (libraryMetadata == null || Strings.isNullOrEmpty(libraryMetadata.artifactName())) {
      return null;
    }
    return new GoldenSignalsMetricsRecorder(openTelemetry, libraryMetadata);
  }

  private GoldenSignalsMetricsRecorder(
      OpenTelemetry openTelemetry, LibraryMetadata libraryMetadata) {
    MeterBuilder meterBuilder = openTelemetry.meterBuilder(libraryMetadata.artifactName());
    String libraryVersion = libraryMetadata.version();
    if (!Strings.isNullOrEmpty(libraryVersion)) {
      meterBuilder.setInstrumentationVersion(libraryVersion);
    }
    Meter meter = meterBuilder.build();

    this.clientRequestDurationRecorder =
        meter
            .histogramBuilder(CLIENT_REQUEST_DURATION_METRIC_NAME)
            .setDescription(CLIENT_REQUEST_DURATION_METRIC_DESCRIPTION)
            .setUnit("s")
            .setExplicitBucketBoundariesAdvice(BOUNDARIES)
            .build();
  }

  void recordOperationLatency(double operationLatency, Map<String, Object> attributes) {
    clientRequestDurationRecorder.record(
        operationLatency, ObservabilityUtils.toOtelAttributes(attributes));
  }
}
