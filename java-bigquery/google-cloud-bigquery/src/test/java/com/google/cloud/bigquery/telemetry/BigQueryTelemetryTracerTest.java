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

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryTelemetryTracerTest {

  private InMemorySpanExporter spanExporter;
  private Tracer tracer;
  private Span span;

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
    span = tracer.spanBuilder("test-span").startSpan();
  }

  @Test
  public void testAddServerErrorResponseToSpan_DetailsNull() throws Exception {
    GoogleJsonResponseException errorResponse = createException(400, "{}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("400", null);
  }

  @Test
  public void testAddServerErrorResponseToSpan_ErrorsNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException(400, "{\"error\": {\"code\": 400, \"message\": \"Bad Request\"}}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("400", "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_ErrorsEmpty() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException(
            400, "{\"error\": {\"code\": 400, \"message\": \"Bad Request\", \"errors\": []}}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("400", "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_MessageAndReasonNotNull()
      throws Exception {
    GoogleJsonResponseException errorResponse =
        createException(
            400,
            "{\"error\": {\"code\": 400, \"message\": \"Bad Request\", \"errors\": [{\"message\": \"Detailed error\", \"reason\": \"invalidParameter\"}]}}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("invalidParameter", "Detailed error");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_MessageNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException(
            400,
            "{\"error\": {\"code\": 400, \"message\": \"Bad Request\", \"errors\": [{\"reason\": \"invalidParameter\"}]}}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("invalidParameter", "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_ReasonNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException(
            400,
            "{\"error\": {\"code\": 400, \"message\": \"Bad Request\", \"errors\": [{\"message\": \"Detailed error\"}]}}");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("400", "Detailed error");
  }

  private GoogleJsonResponseException createException(int statusCode, String content)
      throws Exception {
    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws java.io.IOException {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(statusCode);
                response.setContentType(com.google.api.client.json.Json.MEDIA_TYPE);
                response.setContent(content);
                return response;
              }
            };
          }
        };

    com.google.api.client.http.HttpRequestFactory requestFactory = transport.createRequestFactory();
    com.google.api.client.http.HttpRequest request =
        requestFactory.buildGetRequest(
            new com.google.api.client.http.GenericUrl("https://example.com"));
    request.setThrowExceptionOnExecuteError(false);
    com.google.api.client.http.HttpResponse response = request.execute();

    return GoogleJsonResponseException.from(jsonFactory, response);
  }

  private void assertErrorSpanAttributes(String expectedErrorType, String expectedStatusMessage) {
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData spanData = spans.get(0);

    assertEquals(StatusCode.ERROR, spanData.getStatus().getStatusCode());
    assertEquals(
        expectedErrorType, spanData.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    if (expectedStatusMessage == null) {
      assertNull(spanData.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    } else {
      assertEquals(
          expectedStatusMessage,
          spanData.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    }
  }

  @Test
  public void testAddExceptionToSpan_WithMessage() {
    Exception exception = new Exception("Test error message");

    BigQueryTelemetryTracer.addExceptionToSpan(exception, span);
    span.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData spanData = spans.get(0);

    assertEquals(
        "java.lang.Exception",
        spanData.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals(
        "Exception: Test error message",
        spanData.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals(
        "CLIENT_UNKNOWN_ERROR", spanData.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }

  @Test
  public void testAddExceptionToSpan_NoMessage() {
    Exception exception = new Exception();

    BigQueryTelemetryTracer.addExceptionToSpan(exception, span);
    span.end();

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData spanData = spans.get(0);

    assertEquals(
        "java.lang.Exception",
        spanData.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    assertEquals("Exception", spanData.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    assertEquals(
        "CLIENT_UNKNOWN_ERROR", spanData.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
  }
}
