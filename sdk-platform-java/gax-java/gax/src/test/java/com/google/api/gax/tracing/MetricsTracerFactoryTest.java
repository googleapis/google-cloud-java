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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MetricsTracerFactoryTest {
  private static final int DEFAULT_ATTRIBUTES_COUNT = 2;

  @Mock private MetricsRecorder metricsRecorder;
  @Mock private ApiTracer parent;
  private SpanName spanName;
  private MetricsTracerFactory metricsTracerFactory;

  @BeforeEach
  void setUp() {
    // Create an instance of MetricsTracerFactory with the mocked MetricsRecorder
    metricsTracerFactory = new MetricsTracerFactory(metricsRecorder);

    spanName = mock(SpanName.class);
    when(spanName.getClientName()).thenReturn("testService");
    when(spanName.getMethodName()).thenReturn("testMethod");
  }

  @Test
  void testNewTracer_notNull() {
    // Call the newTracer method
    ApiTracer apiTracer = metricsTracerFactory.newTracer(parent, spanName, OperationType.Unary);

    // Assert that the apiTracer created has expected type and not null
    Truth.assertThat(apiTracer).isNotNull();
    Truth.assertThat(apiTracer).isInstanceOf(MetricsTracer.class);
  }

  @Test
  void testNewTracer_hasCorrectNumberAttributes_hasDefaultAttributes() {
    MetricsTracer metricsTracer =
        (MetricsTracer) metricsTracerFactory.newTracer(parent, spanName, OperationType.Unary);
    Map<String, String> attributes = metricsTracer.getAttributes();
    Truth.assertThat(attributes.size()).isEqualTo(DEFAULT_ATTRIBUTES_COUNT);
    Truth.assertThat(attributes.get(MetricsTracer.METHOD_ATTRIBUTE))
        .isEqualTo("testService.testMethod");
    Truth.assertThat(attributes.get(MetricsTracer.LANGUAGE_ATTRIBUTE))
        .isEqualTo(MetricsTracer.DEFAULT_LANGUAGE);
  }

  @Test
  void testClientAttributes_additionalClientAttributes() {
    Map<String, String> clientAttributes =
        ImmutableMap.of("attribute1", "value1", "attribute2", "value2");
    MetricsTracerFactory metricsTracerFactory =
        new MetricsTracerFactory(metricsRecorder, clientAttributes);

    MetricsTracer metricsTracer =
        (MetricsTracer) metricsTracerFactory.newTracer(parent, spanName, OperationType.Unary);
    Map<String, String> attributes = metricsTracer.getAttributes();
    Truth.assertThat(attributes.size())
        .isEqualTo(DEFAULT_ATTRIBUTES_COUNT + clientAttributes.size());
    // Default attributes already tested above
    Truth.assertThat(attributes.containsKey("attribute1")).isTrue();
    Truth.assertThat(attributes.containsKey("attribute2")).isTrue();
  }
}
