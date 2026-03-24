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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.*;

import io.opentelemetry.api.OpenTelemetry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoldenSignalsMetricsTracerFactoryTest {

  private GoldenSignalsMetricsTracerFactory tracerFactory;

  @BeforeEach
  void setUp() {
    tracerFactory = new GoldenSignalsMetricsTracerFactory(OpenTelemetry.noop());
  }

  @Test
  void newTracerWithSpanName_shouldCreateTracer_ifMetricsRecorderIsNotNull() {
    tracerFactory.withContext(ApiTracerContext.empty());
    ApiTracer actual =
        tracerFactory.newTracer(
            mock(ApiTracer.class), mock(SpanName.class), ApiTracerFactory.OperationType.Unary);
    assertThat(actual).isInstanceOf(GoldenSignalsMetricsTracer.class);
  }

  @Test
  void newTracerWithSpanName_shouldCreateBaseTracer_ifMetricsRecorderIsNull() {
    ApiTracer actual =
        tracerFactory.newTracer(
            mock(ApiTracer.class), mock(SpanName.class), ApiTracerFactory.OperationType.Unary);
    assertThat(actual).isInstanceOf(BaseApiTracer.class);
  }

  @Test
  void newTracerWithApiTracerContext_shouldMergeApiTracerContext() {
    ApiTracerContext clientLevelTracerContext = mock(ApiTracerContext.class, RETURNS_DEEP_STUBS);
    ApiTracerContext methodLevelTracerContext = mock(ApiTracerContext.class);
    when(clientLevelTracerContext.libraryMetadata().artifactName()).thenReturn("does not matter");
    when(clientLevelTracerContext.merge(methodLevelTracerContext))
        .thenReturn(clientLevelTracerContext);

    tracerFactory.withContext(clientLevelTracerContext);
    ApiTracer actual = tracerFactory.newTracer(mock(ApiTracer.class), methodLevelTracerContext);

    verify(clientLevelTracerContext).merge(methodLevelTracerContext);
    assertThat(actual).isInstanceOf(GoldenSignalsMetricsTracer.class);
  }

  @Test
  void newTracerWithApiTracerContext_shouldCreateBaseTracer_ifMetricsRecorderIsNull() {
    ApiTracer actual = tracerFactory.newTracer(mock(ApiTracer.class), mock(ApiTracerContext.class));

    assertThat(actual).isInstanceOf(BaseApiTracer.class);
  }
}
