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
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpEncoding;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
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
  public void testAllAttributesAreSetOnSuccessfulCall() throws IOException {
    HttpResponseInterceptor originalInterceptor = mock(HttpResponseInterceptor.class);
    HttpRequestInitializer delegateInitializer =
        request -> request.setResponseInterceptor(originalInterceptor);
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(delegateInitializer, tracer);
    String responseContent = "{\"status\": \"ok\"}";
    HttpTransport transport = createTransport(200, responseContent);
    HttpContent requestContent =
        ByteArrayContent.fromString("application/json", "{\"test\": \"data\"}");
    HttpRequest request = buildPostRequest(transport, tracingInitializer, BASE_URL, requestContent);

    HttpResponse response = request.execute();
    response.disconnect();

    verify(originalInterceptor, times(1)).interceptResponse(any(HttpResponse.class));
    closeAndVerifySpanData(200, "POST", 16, requestContent.getLength());
  }

  @Test
  public void testExistingParentAttributesAreNotAffectedByRequestAttributes() throws IOException {
    parentSpan.setAttribute("parent_attribute", "value");
    HttpTransport transport = createTransport();
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();
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

  @Test
  public void testUnsuccessfulResponseHandlerSetsAttributesAndCallsOriginal() throws IOException {
    HttpUnsuccessfulResponseHandler originalHandler = mock(HttpUnsuccessfulResponseHandler.class);
    when(originalHandler.handleResponse(
            any(HttpRequest.class), any(HttpResponse.class), anyBoolean()))
        .thenReturn(false);
    HttpRequestInitializer delegateInitializer =
        request -> request.setUnsuccessfulResponseHandler(originalHandler);
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(delegateInitializer, tracer);
    String responseContent = "{\"error\": \"not found\"}";
    HttpTransport transport = createTransport(404, responseContent);
    HttpContent requestContent =
        ByteArrayContent.fromString("application/json", "{\"test\": \"data\"}");
    HttpRequest request = buildPostRequest(transport, tracingInitializer, BASE_URL, requestContent);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    verify(originalHandler, times(1))
        .handleResponse(any(HttpRequest.class), any(HttpResponse.class), anyBoolean());
    closeAndVerifySpanData(404, "POST", 16, responseContent.length());
  }

  @Test
  public void testUnsuccessfulResponseHandlerSetsErrorIfNoOriginal() throws IOException {
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(null, tracer);
    HttpTransport transport = createTransport(401);
    HttpRequest request = buildGetRequest(transport, tracingInitializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    closeAndVerifySpanData(401, "GET", -1, -1);
  }

  @Test
  public void testAddRequestBodySizeToSpan_ExceptionHandled() throws IOException {
    HttpContent content = mock(HttpContent.class);
    when(content.getLength()).thenThrow(new IOException("test"));
    HttpTransport transport = createTransport();
    HttpRequest request = buildPostRequest(transport, null, BASE_URL, content);

    HttpTracingRequestInitializer.addRequestBodySizeToSpan(request, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
  }

  @Test
  public void testAddRequestBodySizeToSpan_NullBody() throws IOException {
    HttpTransport transport = createTransport();
    HttpRequest request = buildPostRequest(transport, null, BASE_URL, null);

    HttpTracingRequestInitializer.addRequestBodySizeToSpan(request, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
  }

  @Test
  public void testAddRequestBodySizeToSpan_WithEncoding() throws IOException {
    HttpTransport transport = createTransport();
    HttpContent content = ByteArrayContent.fromString("application/json", "{\"test\": \"data\"}");
    HttpRequest request = buildPostRequest(transport, null, BASE_URL, content);
    request.setEncoding(mock(HttpEncoding.class));

    HttpTracingRequestInitializer.addRequestBodySizeToSpan(request, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
  }

  @Test
  public void testAddRequestBodySizeToSpan() throws IOException {
    HttpTransport transport = createTransport();
    HttpContent content = ByteArrayContent.fromString("application/json", "{\"test\": \"data\"}");
    HttpRequest request = buildPostRequest(transport, null, BASE_URL, content);

    HttpTracingRequestInitializer.addRequestBodySizeToSpan(request, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertEquals(
        content.getLength(),
        span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
  }

  @Test
  public void testAddResponseBodySizeToSpan_NullLength() throws IOException {
    HttpTransport transport =
        createTransport(200, null); // Null response content means null Content-Length header
    HttpRequest request = buildGetRequest(transport, null, BASE_URL);
    HttpResponse response = request.execute();

    HttpTracingRequestInitializer.addResponseBodySizeToSpan(response, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_BODY_SIZE));
  }

  private static HttpTransport createTransport() {
    return createTransport(200, null);
  }

  private static HttpTransport createTransport(int statusCode) {
    return createTransport(statusCode, null);
  }

  private static HttpTransport createTransport(int statusCode, String responseContent) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() {
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(statusCode);
            if (responseContent != null) {
              response.setContent(responseContent);
              response.addHeader("Content-Length", String.valueOf(responseContent.length()));
            }
            return response;
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

  private static HttpRequest buildPostRequest(
      HttpTransport transport,
      HttpRequestInitializer requestInitializer,
      String url,
      HttpContent content)
      throws IOException {
    HttpRequestFactory requestFactory = transport.createRequestFactory(requestInitializer);
    return requestFactory.buildPostRequest(new GenericUrl(url), content);
  }

  private void closeAndVerifySpanData(
      long responseCode, String method, long requestBodySize, long responseBodySize) {
    // close span so it is available for verification
    spanScope.close();
    parentSpan.end();
    List<SpanData> spans = spanExporter.getFinishedSpanItems();

    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
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
    assertEquals(
        responseCode,
        span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals(
        Version.VERSION, span.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_VERSION));
    assertEquals(
        method, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    if (requestBodySize >= 0) {
      assertEquals(
          requestBodySize,
          span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
    } else {
      assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_BODY_SIZE));
    }
    if (responseBodySize >= 0) {
      assertEquals(
          responseBodySize,
          span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_BODY_SIZE));
    } else {
      assertNull(span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_BODY_SIZE));
    }
  }
}
