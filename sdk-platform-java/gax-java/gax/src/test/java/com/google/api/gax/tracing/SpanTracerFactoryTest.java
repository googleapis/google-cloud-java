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
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.tracing.ApiTracerContext.Transport;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

class SpanTracerFactoryTest {
  private TraceManager traceManager;
  private TraceManager.Span span;

  @BeforeEach
  void setUp() {
    traceManager = mock(TraceManager.class);
    span = mock(TraceManager.Span.class);
    when(traceManager.createSpan(anyString(), anyMap())).thenReturn(span);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testNewTracer_createsSpanTracer(boolean useContext) {
    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracer tracer;
    if (useContext) {
      ApiTracerContext context =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(LibraryMetadata.empty())
              .build();
      tracer = factory.newTracer(null, context);
    } else {
      tracer = factory.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }
    assertThat(tracer).isInstanceOf(SpanTracer.class);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testNewTracer_addsAttributes(boolean useContext) {
    ApiTracerFactory factory = new SpanTracerFactory(traceManager, ApiTracerContext.empty());
    factory =
        factory.withContext(
            ApiTracerContext.newBuilder()
                .setLibraryMetadata(LibraryMetadata.empty())
                .setServerAddress("test-address")
                .build());
    ApiTracer tracer;
    if (useContext) {
      ApiTracerContext context =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(LibraryMetadata.empty())
              .build();
      tracer = factory.newTracer(null, context);
    } else {
      tracer = factory.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, Object>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(traceManager, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, Object> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes).containsEntry("server.address", "test-address");
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testWithContext_addsInferredAttributes(boolean useContext) {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setServerAddress("example.com")
            .build();

    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracer;
    if (useContext) {
      ApiTracerContext callContext =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(LibraryMetadata.empty())
              .build();
      tracer = factoryWithContext.newTracer(null, callContext);
    } else {
      tracer =
          factoryWithContext.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, Object>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(traceManager, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, Object> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes)
        .containsEntry(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE, "example.com");
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testWithContext_noEndpointContext_doesNotAddServerAddressAttribute(boolean useContext) {
    ApiTracerContext context = ApiTracerContext.empty();

    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracer;
    if (useContext) {
      ApiTracerContext callContext =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(LibraryMetadata.empty())
              .build();
      tracer = factoryWithContext.newTracer(null, callContext);
    } else {
      tracer =
          factoryWithContext.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, Object>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(traceManager, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, Object> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes)
        .doesNotContainKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE);
  }

  @Test
  void testNewTracer_withContext_grpc_usesFullMethodName() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setFullMethodName("google.cloud.v1.Service/Method")
            .setTransport(Transport.GRPC)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracer tracer = factory.newTracer(null, context);

    tracer.attemptStarted(null, 1);

    verify(traceManager).createSpan(eq("google.cloud.v1.Service/Method"), anyMap());
  }

  @Test
  void testNewTracer_withContext_http_usesPlaceholder() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setFullMethodName("google.cloud.v1.Service.Method")
            .setTransport(Transport.HTTP)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracer tracer = factory.newTracer(null, context);

    tracer.attemptStarted(null, 1);

    verify(traceManager).createSpan(eq("google.cloud.v1.Service.Method/attempt"), anyMap());
  }

  @Test
  void testNewTracer_withSpanName_usesPlaceholder() {
    SpanTracerFactory factory = new SpanTracerFactory(traceManager);
    ApiTracer tracer =
        factory.newTracer(null, SpanName.of("Service", "Method"), OperationType.Unary);

    tracer.attemptStarted(null, 1);

    verify(traceManager).createSpan(eq("Service/Method/attempt"), anyMap());
  }

  @Test
  void testNewTracer_mergesFactoryContext() {
    ApiTracerContext apiTracerContext =
        ApiTracerContext.newBuilder()
            .setServerAddress("factory-address")
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();
    SpanTracerFactory factory = new SpanTracerFactory(traceManager, apiTracerContext);

    ApiTracerContext callContext =
        ApiTracerContext.newBuilder()
            .setFullMethodName("Service/Method")
            .setTransport(Transport.GRPC)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    ApiTracer tracer = factory.newTracer(null, callContext);
    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, Object>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(traceManager).createSpan(anyString(), attributesCaptor.capture());

    Map<String, Object> attributes = attributesCaptor.getValue();
    assertThat(attributes).containsEntry("server.address", "factory-address");
    assertThat(attributes).containsEntry("rpc.method", "Service/Method");
  }
}
