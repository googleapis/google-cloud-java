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
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.gson.JsonParseException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
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
    // close span before building the request so there is no current span during
    // initialization
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
  public void testHttpResponseInterceptor_Success() throws IOException {
    HttpTransport transport = createTransportWithResponse(200, "OK", "OK");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        200L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals(StatusCode.OK, span.getStatus().getStatusCode());
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorWithDetails() throws IOException {
    String errorJson =
        "{\n"
            + "  \"error\": {\n"
            + "    \"errors\": [\n"
            + "      {\n"
            + "        \"message\": \"Detailed error message\",\n"
            + "        \"reason\": \"DetailedReason\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "}";
    HttpTransport transport = createTransportWithResponse(400, errorJson, "Bad Request");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        400L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals(
        "Detailed error message", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals("DetailedReason", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorWithoutDetails() throws IOException {
    HttpTransport transport =
        createTransportWithResponse(500, "Internal Server Error", "Internal Server Error");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        500L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals(
        "Internal Server Error", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals("500", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_Exception() throws IOException {
    HttpTransport transport = createTransportWithResponse(500, "Error", "Error");

    // Create a delegate that sets an unsuccessful response handler that throws
    // IOException
    HttpRequestInitializer delegate =
        req ->
            req.setUnsuccessfulResponseHandler(
                (request1, response, supportsRetry) -> {
                  throw new IOException("Original handler exception");
                });

    initializer = new HttpTracingRequestInitializer(delegate, tracer);
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (IOException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "IOException: Original handler exception",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals(
        "CLIENT_UNKNOWN_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        "java.io.IOException", span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(StatusCode.ERROR, span.getStatus().getStatusCode());
  }

  @Test
  public void testTracerIsNull() throws IOException {
    HttpRequestInitializer delegateInitializer = mock(HttpRequestInitializer.class);
    HttpTracingRequestInitializer tracingInitializer =
        new HttpTracingRequestInitializer(delegateInitializer, null);

    HttpTransport transport = createTransport();
    HttpRequest request = buildGetRequest(transport, tracingInitializer, BASE_URL);

    HttpResponse response = request.execute();
    response.disconnect();

    verify(delegateInitializer, times(1)).initialize(any(HttpRequest.class));

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertEquals(1, spans.size());
    SpanData span = spans.get(0);
    assertNull(span.getAttributes().get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
  }

  @Test
  public void testHttpSuccessResponseInterceptor_Exception() throws IOException {
    HttpTransport transport = createTransportWithResponse(200, "OK", "OK");

    HttpRequestInitializer delegate =
        req ->
            req.setResponseInterceptor(
                response -> {
                  throw new IOException("Original interceptor exception");
                });

    initializer = new HttpTracingRequestInitializer(delegate, tracer);
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (IOException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "IOException: Original interceptor exception",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals(
        "CLIENT_UNKNOWN_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        "java.io.IOException", span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(StatusCode.ERROR, span.getStatus().getStatusCode());
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorMissingReason() throws IOException {
    String errorJson =
        "{\n"
            + "  \"error\": {\n"
            + "    \"errors\": [\n"
            + "      {\n"
            + "        \"message\": \"Detailed error message\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "}";
    HttpTransport transport = createTransportWithResponse(400, errorJson, "Bad Request");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        400L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals(
        "Detailed error message", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals("400", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorMissingMessage() throws IOException {
    String errorJson =
        "{\n"
            + "  \"error\": {\n"
            + "    \"errors\": [\n"
            + "      {\n"
            + "        \"reason\": \"ERROR\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "}";
    HttpTransport transport = createTransportWithResponse(400, errorJson, "Bad Request");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        400L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals("Bad Request", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals("ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorMessageNoDetails() throws IOException {
    HttpTransport transport = createTransportWithResponse(400, null, "Bad Request");
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        400L, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals("Bad Request", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals("400", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ErrorNoMessageNoDetails() throws IOException {
    HttpTransport transport = createTransportWithResponse(400, null, null);
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (HttpResponseException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "GET", span.getAttributes().get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
    assertEquals(
        400, span.getAttributes().get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
    assertEquals("400", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertNull(span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  // All tests below use the delegate to fake these exceptions
  @Test
  public void testHttpUnsuccessfulResponseHandler_SocketTimeoutException() throws IOException {
    HttpTransport transport = createTransportWithResponse(500, "Error", "Error");
    HttpRequestInitializer delegate =
        req ->
            req.setUnsuccessfulResponseHandler(
                (request1, response, supportsRetry) -> {
                  throw new java.net.SocketTimeoutException("Read timed out");
                });

    initializer = new HttpTracingRequestInitializer(delegate, tracer);
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (IOException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals("CLIENT_TIMEOUT", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        "java.net.SocketTimeoutException",
        span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "SocketTimeoutException: Read timed out",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testHttpUnsuccessfulResponseHandler_ConnectException() throws IOException {
    HttpTransport transport = createTransportWithResponse(500, "Error", "Error");

    HttpRequestInitializer delegate =
        req ->
            req.setUnsuccessfulResponseHandler(
                (request1, response, supportsRetry) -> {
                  throw new java.net.ConnectException("Connection refused");
                });

    initializer = new HttpTracingRequestInitializer(delegate, tracer);
    HttpRequest request = buildGetRequest(transport, initializer, BASE_URL);

    try {
      request.execute();
    } catch (IOException e) {
      // Expected
    }

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    verifyGeneralSpanData(span);

    assertEquals(
        "CLIENT_CONNECTION_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        "java.net.ConnectException",
        span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "ConnectException: Connection refused",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testAddExceptionToSpan_DecodeException() {
    Exception e = new JsonParseException("parse error");
    HttpTracingRequestInitializer.addExceptionToSpan(e, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    assertEquals(
        "CLIENT_RESPONSE_DECODE_ERROR",
        span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        e.getClass().getName(), span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "JsonParseException: parse error",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testAddExceptionToSpan_RedirectException() {
    Exception e = new Exception("Too many redirects");
    HttpTracingRequestInitializer.addExceptionToSpan(e, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    assertEquals(
        "CLIENT_REDIRECT_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        e.getClass().getName(), span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "Exception: Too many redirects",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testAddExceptionToSpan_AuthenticationException() {
    // note com.google.auth.oauth2.GoogleAuthException is package private so recreating here
    class GoogleAuthException extends Exception {}
    Exception e = new GoogleAuthException();
    HttpTracingRequestInitializer.addExceptionToSpan(e, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    assertEquals(
        "CLIENT_AUTHENTICATION_ERROR",
        span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        e.getClass().getName(), span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "GoogleAuthException", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testAddExceptionToSpan_IllegalArgumentException() {
    Exception e = new IllegalArgumentException("missing field");
    HttpTracingRequestInitializer.addExceptionToSpan(e, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    assertEquals(
        "CLIENT_REQUEST_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        e.getClass().getName(), span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "IllegalArgumentException: missing field",
        span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
  }

  @Test
  public void testAddExceptionToSpan_UnknownException() {
    Exception e = new Exception("unknown");
    HttpTracingRequestInitializer.addExceptionToSpan(e, parentSpan);

    spanScope.close();
    parentSpan.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = spans.get(0);
    assertEquals(
        "CLIENT_UNKNOWN_ERROR", span.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    assertEquals(
        e.getClass().getName(), span.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "Exception: unknown", span.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
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

  private static HttpTransport createTransportWithResponse(
      int statusCode, String content, String reasonPhrase) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() {
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(statusCode);
            if (content != null) {
              response.setContent(content);
            }
            if (reasonPhrase != null) {
              response.setReasonPhrase(reasonPhrase);
            }
            return response;
          }
        };
      }
    };
  }
}
