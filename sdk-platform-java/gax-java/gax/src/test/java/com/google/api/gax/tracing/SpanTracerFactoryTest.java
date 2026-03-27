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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.tracing.ApiTracerContext.Transport;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

class SpanTracerFactoryTest {
  private OpenTelemetry openTelemetry;
  private Tracer tracer;
  private SpanBuilder spanBuilder;
  private Span span;

  private LibraryMetadata validMetadata;

  @BeforeEach
  void setUp() {
    openTelemetry = mock(OpenTelemetry.class);
    tracer = mock(Tracer.class);
    spanBuilder = mock(SpanBuilder.class);
    span = mock(Span.class);
    when(openTelemetry.getTracer(nullable(String.class), nullable(String.class)))
        .thenReturn(tracer);
    when(tracer.spanBuilder(anyString())).thenReturn(spanBuilder);
    when(spanBuilder.setSpanKind(any())).thenReturn(spanBuilder);
    when(spanBuilder.setAllAttributes(any(Attributes.class))).thenReturn(spanBuilder);
    when(spanBuilder.startSpan()).thenReturn(span);

    validMetadata = mock(LibraryMetadata.class);
    when(validMetadata.artifactName()).thenReturn("gax-java");
    when(validMetadata.version()).thenReturn("2.1.0");
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testNewTracer_createsSpanTracer(boolean useContext) {
    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracer tracerInstance;
    if (useContext) {
      ApiTracerContext context =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(LibraryMetadata.empty())
              .build();
      tracerInstance = factory.newTracer(null, context);
    } else {
      tracerInstance =
          factory.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }
    assertThat(tracerInstance).isInstanceOf(SpanTracer.class);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testNewTracer_addsAttributes(boolean useContext) {
    ApiTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    factory =
        factory.withContext(
            ApiTracerContext.newBuilder()
                .setLibraryMetadata(validMetadata)
                .setServerAddress("test-address")
                .build());
    ApiTracer tracerInstance;
    if (useContext) {
      ApiTracerContext context =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(validMetadata)
              .build();
      tracerInstance = factory.newTracer(null, context);
    } else {
      tracerInstance =
          factory.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracerInstance.attemptStarted(null, 1);

    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder, atLeastOnce()).setAllAttributes(attributesCaptor.capture());

    Attributes attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes.asMap())
        .containsEntry(AttributeKey.stringKey("server.address"), "test-address");
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testWithContext_addsInferredAttributes(boolean useContext) {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(validMetadata)
            .setServerAddress("example.com")
            .build();

    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracerInstance;
    if (useContext) {
      ApiTracerContext callContext =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(validMetadata)
              .build();
      tracerInstance = factoryWithContext.newTracer(null, callContext);
    } else {
      tracerInstance =
          factoryWithContext.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracerInstance.attemptStarted(null, 1);

    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder, atLeastOnce()).setAllAttributes(attributesCaptor.capture());

    Attributes attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes.asMap())
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE),
            "example.com");
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testWithContext_noEndpointContext_doesNotAddServerAddressAttribute(boolean useContext) {
    ApiTracerContext context =
        ApiTracerContext.newBuilder().setLibraryMetadata(validMetadata).build();

    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracerInstance;
    if (useContext) {
      ApiTracerContext callContext =
          ApiTracerContext.newBuilder()
              .setFullMethodName("service/method")
              .setTransport(Transport.GRPC)
              .setLibraryMetadata(validMetadata)
              .build();
      tracerInstance = factoryWithContext.newTracer(null, callContext);
    } else {
      tracerInstance =
          factoryWithContext.newTracer(null, SpanName.of("service", "method"), OperationType.Unary);
    }

    tracerInstance.attemptStarted(null, 1);

    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder, atLeastOnce()).setAllAttributes(attributesCaptor.capture());

    Attributes attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes.asMap())
        .doesNotContainKey(
            AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE));
  }

  @Test
  void testNewTracer_withContext_grpc_usesFullMethodName() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setFullMethodName("google.cloud.v1.Service/Method")
            .setTransport(Transport.GRPC)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracer tracerInstance = factory.newTracer(null, context);

    tracerInstance.attemptStarted(null, 1);

    verify(tracer).spanBuilder("google.cloud.v1.Service/Method");
  }

  @ParameterizedTest
  @CsvSource({
    "POST, v1/projects/{project}/methods, POST v1/projects/{project}/methods",
    "GET, v1/projects/{project}/methods/{method}, GET v1/projects/{project}/methods/{method}",
    "DELETE, v1/projects/{project}/methods/{method}, DELETE v1/projects/{project}/methods/{method}",
    "PATCH, v1/projects/{project}/methods/{method}, PATCH v1/projects/{project}/methods/{method}"
  })
  void testNewTracer_withContext_http_usesHttpMethodAndPathTemplate(
      String httpMethod, String httpPathTemplate, String expectedSpanName) {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setFullMethodName("google.cloud.v1.Service.Method")
            .setTransport(Transport.HTTP)
            .setHttpMethod(httpMethod)
            .setHttpPathTemplate(httpPathTemplate)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracer tracerInstance = factory.newTracer(null, context);

    tracerInstance.attemptStarted(null, 1);

    verify(tracer).spanBuilder(expectedSpanName);
  }

  @Test
  void testNewTracer_withContext_http_noHttpMethodOrPathTemplate_usesFullMethodName() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setFullMethodName("google.cloud.v1.Service.Method")
            .setTransport(Transport.HTTP)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracer tracerInstance = factory.newTracer(null, context);

    tracerInstance.attemptStarted(null, 1);

    verify(tracer).spanBuilder("google.cloud.v1.Service.Method");
  }

  @Test
  void testNewTracer_withSpanName_usesPlaceholder() {
    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracer tracerInstance =
        factory.newTracer(null, SpanName.of("Service", "Method"), OperationType.Unary);

    tracerInstance.attemptStarted(null, 1);

    verify(tracer).spanBuilder("Service/Method/attempt");
  }

  @Test
  void testNewTracer_mergesFactoryContext() {
    ApiTracerContext apiTracerContext =
        ApiTracerContext.newBuilder()
            .setServerAddress("factory-address")
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();
    SpanTracerFactory factory = new SpanTracerFactory(openTelemetry, tracer, apiTracerContext);

    ApiTracerContext callContext =
        ApiTracerContext.newBuilder()
            .setFullMethodName("Service/Method")
            .setTransport(Transport.GRPC)
            .setLibraryMetadata(LibraryMetadata.empty())
            .build();

    ApiTracer tracerInstance = factory.newTracer(null, callContext);
    tracerInstance.attemptStarted(null, 1);

    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder).setAllAttributes(attributesCaptor.capture());

    Attributes attributes = attributesCaptor.getValue();
    assertThat(attributes.asMap())
        .containsEntry(AttributeKey.stringKey("server.address"), "factory-address");
    assertThat(attributes.asMap())
        .containsEntry(AttributeKey.stringKey("rpc.method"), "Service/Method");
  }

  @Test
  void testNoOpWhenTracerNull() {
    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, null, ApiTracerContext.empty());

    ApiTracer tracerInstance =
        factory.newTracer(null, SpanName.of("Service", "Method"), OperationType.Unary);

    assertThat(tracerInstance).isInstanceOf(BaseApiTracer.class);

    ApiTracer tracerInstance2 = factory.newTracer(null, ApiTracerContext.empty());

    assertThat(tracerInstance2).isInstanceOf(BaseApiTracer.class);
  }

  @Test
  void testWithContext_nullContext_returnsBaseApiTracerFactory() {
    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    ApiTracerFactory factoryWithContext = factory.withContext(null);
    assertThat(factoryWithContext).isInstanceOf(BaseApiTracerFactory.class);
  }

  @Test
  void testWithContext_nullMetadata_returnsBaseApiTracerFactory() {
    SpanTracerFactory factory =
        new SpanTracerFactory(openTelemetry, tracer, ApiTracerContext.empty());
    // Assuming ApiTracerContext.empty() has null libraryMetadata
    ApiTracerFactory factoryWithContext = factory.withContext(ApiTracerContext.empty());
    assertThat(factoryWithContext).isInstanceOf(BaseApiTracerFactory.class);
  }

  @Test
  void testWithContext_nullTracer_returnsBaseApiTracerFactory() {
    OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
    when(mockOpenTelemetry.getTracer(nullable(String.class), nullable(String.class)))
        .thenReturn(null);

    SpanTracerFactory factory =
        new SpanTracerFactory(mockOpenTelemetry, tracer, ApiTracerContext.empty());
    ApiTracerContext context =
        ApiTracerContext.newBuilder().setLibraryMetadata(LibraryMetadata.empty()).build();

    ApiTracerFactory factoryWithContext = factory.withContext(context);
    assertThat(factoryWithContext).isInstanceOf(BaseApiTracerFactory.class);
  }
}
