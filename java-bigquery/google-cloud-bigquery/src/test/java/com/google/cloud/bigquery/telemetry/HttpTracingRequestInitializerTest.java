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

package com.google.cloud.bigquery.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HttpTracingRequestInitializerTest {

  private static final String BASE_URL =
      "https://bigquery.googleapis.com:443/bigquery/v2/projects/test/datasets";
  private static final String BIGQUERY_DOMAIN = "bigquery.googleapis.com";
  private static final String CLIENT_ROOT_URL = "https://bigquery.googleapis.com:443";
  private static final String SPAN_NAME = "test-parent-span";
  private InMemorySpanExporter spanExporter;
  private Tracer tracer;
  private HttpTracingRequestInitializer initializer;
  private Span parentSpan;
  private Scope spanScope;

  @BeforeEach
  public void setUp() {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    tracer = openTelemetry.getTracer("test-tracer");
    initializer = new HttpTracingRequestInitializer(null, tracer);
    parentSpan = tracer.spanBuilder(SPAN_NAME).startSpan();
    spanScope = parentSpan.makeCurrent();
  }

  @Test
  public void testRequestAttributesAreSetIfSpanExists() throws IOException {
    HttpTransport transport = createTransport();
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    // End the span before verifying exported spans, so it appears in the exporter
    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());

    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);
  }

  @Test
  public void testExistingParentAttributesAreNotAffectedByRequestAttributes() throws IOException {
    parentSpan.setAttribute("parent_attribute", "value");
    HttpTransport transport = createTransport();
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    // End the span before verifying exported spans, so it appears in the exporter
    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());

    SpanData span = spans.get(0);
    assertEquals("value", span.getAttributes().get(AttributeKey.stringKey("parent_attribute")));
  }

  @Test
  public void testNoSpanIsCreatedIfNoActiveSpan() throws IOException {
    HttpRequestInitializer delegateInitializer = mock(HttpRequestInitializer.class);
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(delegateInitializer, tracer);

    HttpTransport transport = createTransport();
    // close span before building the request so there is no current span during initialization
    spanScope.close();
    parentSpan.end();

    HttpRequest request = buildGetRequest(transport, tracingInitializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    assertNull(spans.get(0).getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_ARTIFACT));
    verify(delegateInitializer, times(1)).initialize(any(HttpRequest.class));
  }

  @Test
  public void testDelegateInitializerIsCalled() throws IOException {
    HttpRequestInitializer delegateInitializer = mock(HttpRequestInitializer.class);
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(delegateInitializer, tracer);

    HttpTransport transport = createTransport();
    HttpRequest request = buildGetRequest(transport, tracingInitializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    verify(delegateInitializer, times(1)).initialize(any(HttpRequest.class));
  }

  private static HttpTransport createTransport() {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() {
            return new MockLowLevelHttpResponse();
          }
        };
      }
    };
  }

  private static HttpRequest buildGetRequest(
      HttpTransport transport, HttpRequestInitializer requestInitializer, String url)
      throws IOException {
    HttpRequestFactory requestFactory = transport.createRequestFactory(requestInitializer);
    return requestFactory.buildGetRequest(new GenericUrl(url));
  }

  private void verifyGeneralSpanData(SpanData span) {
    assertEquals(SPAN_NAME, span.getName());
    assertEquals(BIGQUERY_DOMAIN, span.getAttributes().get(BigQueryTelemetryTracer.SERVER_ADDRESS));
    assertEquals(443, span.getAttributes().get(BigQueryTelemetryTracer.SERVER_PORT));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_SERVICE,
        span.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_SERVICE));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_REPO,
        span.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_REPO));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_ARTIFACT,
        span.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_ARTIFACT));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_LANGUAGE,
        span.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_LANGUAGE));
    assertEquals(
        HttpTracingRequestInitializer.HTTP_RPC_SYSTEM_NAME,
        span.getAttributes().get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
  }
}
