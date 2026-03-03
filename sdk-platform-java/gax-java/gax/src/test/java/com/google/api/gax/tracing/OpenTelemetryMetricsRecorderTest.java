/*
 * Copyright 2024 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import com.google.rpc.Code;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongCounterBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpenTelemetryMetricsRecorderTest {
  private static final String SERVICE_NAME = "OtelRecorderTest";
  private static final String ATTEMPT_COUNT = SERVICE_NAME + "/attempt_count";
  private static final String OPERATION_COUNT = SERVICE_NAME + "/operation_count";
  private static final String ATTEMPT_LATENCY = SERVICE_NAME + "/attempt_latency";
  private static final String OPERATION_LATENCY = SERVICE_NAME + "/operation_latency";
  private static final String DEFAULT_METHOD_NAME = "fake_service.fake_method";

  private OpenTelemetryMetricsRecorder otelMetricsRecorder;
  @Mock private OpenTelemetry openTelemetry;
  @Mock private Meter meter;
  @Mock private MeterBuilder meterBuilder;
  @Mock private LongCounter attemptCountRecorder;
  @Mock private LongCounterBuilder attemptCountRecorderBuilder;
  @Mock private DoubleHistogramBuilder attemptLatencyRecorderBuilder;
  @Mock private DoubleHistogram attemptLatencyRecorder;
  @Mock private DoubleHistogram operationLatencyRecorder;
  @Mock private DoubleHistogramBuilder operationLatencyRecorderBuilder;
  @Mock private LongCounter operationCountRecorder;
  @Mock private LongCounterBuilder operationCountRecorderBuilder;

  @BeforeEach
  void setUp() {
    Mockito.when(openTelemetry.meterBuilder(Mockito.anyString())).thenReturn(meterBuilder);
    Mockito.when(meterBuilder.setInstrumentationVersion(Mockito.anyString()))
        .thenReturn(meterBuilder);
    Mockito.when(meterBuilder.build()).thenReturn(meter);
    // setup mocks for all the recorders using chained mocking
    setupAttemptCountRecorder();
    setupAttemptLatencyRecorder();
    setupOperationLatencyRecorder();
    setupOperationCountRecorder();

    otelMetricsRecorder = new OpenTelemetryMetricsRecorder(openTelemetry, SERVICE_NAME);
  }

  private Map<String, String> getAttributes(Code statusCode) {
    return ImmutableMap.of(
        "status",
        statusCode.toString(),
        "method_name",
        DEFAULT_METHOD_NAME,
        "language",
        MetricsTracer.DEFAULT_LANGUAGE);
  }

  @Test
  void testAttemptCountRecorder_recordsAttributes() {
    Map<String, String> attributes = getAttributes(Code.OK);

    Attributes otelAttributes = otelMetricsRecorder.toOtelAttributes(attributes);
    otelMetricsRecorder.recordAttemptCount(1, attributes);

    verify(attemptCountRecorder).add(1, otelAttributes);
    verifyNoMoreInteractions(attemptCountRecorder);
  }

  @Test
  void testAttemptLatencyRecorder_recordsAttributes() {
    Map<String, String> attributes = getAttributes(Code.NOT_FOUND);

    Attributes otelAttributes = otelMetricsRecorder.toOtelAttributes(attributes);
    otelMetricsRecorder.recordAttemptLatency(1.1, attributes);

    verify(attemptLatencyRecorder).record(1.1, otelAttributes);
    verifyNoMoreInteractions(attemptLatencyRecorder);
  }

  @Test
  void testOperationCountRecorder_recordsAttributes() {
    Map<String, String> attributes = getAttributes(Code.OK);

    Attributes otelAttributes = otelMetricsRecorder.toOtelAttributes(attributes);
    otelMetricsRecorder.recordOperationCount(1, attributes);

    verify(operationCountRecorder).add(1, otelAttributes);
    verifyNoMoreInteractions(operationCountRecorder);
  }

  @Test
  void testOperationLatencyRecorder_recordsAttributes() {
    Map<String, String> attributes = getAttributes(Code.INVALID_ARGUMENT);

    Attributes otelAttributes = otelMetricsRecorder.toOtelAttributes(attributes);
    otelMetricsRecorder.recordOperationLatency(1.7, attributes);

    verify(operationLatencyRecorder).record(1.7, otelAttributes);
    verifyNoMoreInteractions(operationLatencyRecorder);
  }

  @Test
  void testToOtelAttributes_correctConversion() {
    Map<String, String> attributes = getAttributes(Code.OK);

    Attributes otelAttributes = otelMetricsRecorder.toOtelAttributes(attributes);

    Truth.assertThat(otelAttributes.get(AttributeKey.stringKey("status")))
        .isEqualTo(Code.OK.toString());
    Truth.assertThat(otelAttributes.get(AttributeKey.stringKey("method_name")))
        .isEqualTo(DEFAULT_METHOD_NAME);
    Truth.assertThat(otelAttributes.get(AttributeKey.stringKey("language")))
        .isEqualTo(MetricsTracer.DEFAULT_LANGUAGE);
  }

  @Test
  void testToOtelAttributes_nullInput() {
    Throwable thrown =
        assertThrows(NullPointerException.class, () -> otelMetricsRecorder.toOtelAttributes(null));
    Truth.assertThat(thrown).hasMessageThat().contains("Attributes map cannot be null");
  }

  private void setupAttemptCountRecorder() {
    // Configure chained mocking for AttemptCountRecorder
    Mockito.when(meter.counterBuilder(ATTEMPT_COUNT)).thenReturn(attemptCountRecorderBuilder);
    Mockito.when(attemptCountRecorderBuilder.setDescription(Mockito.anyString()))
        .thenReturn(attemptCountRecorderBuilder);
    Mockito.when(attemptCountRecorderBuilder.setUnit(Mockito.anyString()))
        .thenReturn(attemptCountRecorderBuilder);
    Mockito.when(attemptCountRecorderBuilder.build()).thenReturn(attemptCountRecorder);
  }

  private void setupOperationCountRecorder() {
    // Configure chained mocking for operationCountRecorder
    Mockito.when(meter.counterBuilder(OPERATION_COUNT)).thenReturn(operationCountRecorderBuilder);
    Mockito.when(operationCountRecorderBuilder.setDescription(Mockito.anyString()))
        .thenReturn(operationCountRecorderBuilder);
    Mockito.when(operationCountRecorderBuilder.setUnit("1"))
        .thenReturn(operationCountRecorderBuilder);
    Mockito.when(operationCountRecorderBuilder.build()).thenReturn(operationCountRecorder);
  }

  private void setupAttemptLatencyRecorder() {
    // Configure chained mocking for attemptLatencyRecorder
    Mockito.when(meter.histogramBuilder(ATTEMPT_LATENCY)).thenReturn(attemptLatencyRecorderBuilder);
    Mockito.when(attemptLatencyRecorderBuilder.setDescription(Mockito.anyString()))
        .thenReturn(attemptLatencyRecorderBuilder);
    Mockito.when(attemptLatencyRecorderBuilder.setUnit(Mockito.anyString()))
        .thenReturn(attemptLatencyRecorderBuilder);
    Mockito.when(attemptLatencyRecorderBuilder.build()).thenReturn(attemptLatencyRecorder);
  }

  private void setupOperationLatencyRecorder() {
    // Configure chained mocking for operationLatencyRecorder
    Mockito.when(meter.histogramBuilder(OPERATION_LATENCY))
        .thenReturn(operationLatencyRecorderBuilder);
    Mockito.when(operationLatencyRecorderBuilder.setDescription(Mockito.anyString()))
        .thenReturn(operationLatencyRecorderBuilder);
    Mockito.when(operationLatencyRecorderBuilder.setUnit("ms"))
        .thenReturn(operationLatencyRecorderBuilder);
    Mockito.when(operationLatencyRecorderBuilder.build()).thenReturn(operationLatencyRecorder);
  }
}
