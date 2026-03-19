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

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryTelemetryTracerTest {

  private InMemorySpanExporter spanExporter;
  private Span span;
  String errorCode = "400";

  @BeforeEach
  public void setUp() {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    Tracer tracer = openTelemetry.getTracer("test-tracer");
    span = tracer.spanBuilder("test-span").startSpan();
  }

  @Test
  public void testAddServerErrorResponseToSpan_DetailsNull() throws Exception {
    GoogleJsonResponseException errorResponse = createException(null, null, null, null);

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes(errorCode, null);
  }

  @Test
  public void testAddServerErrorResponseToSpan_UsesStatusMessage() throws Exception {
    GoogleJsonResponseException errorResponse = createException("Status Message", null, null, null);

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes(errorCode, "Status Message");
  }

  @Test
  public void testAddServerErrorResponseToSpan_ErrorsNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException("Status Message", "Bad Request", null, null);

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes(errorCode, "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_ErrorsEmpty() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException("Status Message", "Bad Request", "", "");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes(errorCode, "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_MessageAndReasonNotNull()
      throws Exception {
    GoogleJsonResponseException errorResponse =
        createException("Status Message", "Bad Request", "Detailed error", "invalidParameter");
    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("invalidParameter", "Detailed error");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_MessageNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException("Status Message", "Bad Request", null, "invalidParameter");

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes("invalidParameter", "Bad Request");
  }

  @Test
  public void testAddServerErrorResponseToSpan_WithErrors_ReasonNull() throws Exception {
    GoogleJsonResponseException errorResponse =
        createException("Status Message", "Bad Request", "Detailed error", null);

    BigQueryTelemetryTracer.addServerErrorResponseToSpan(errorResponse, span);
    span.end();

    assertErrorSpanAttributes(errorCode, "Detailed error");
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
    assertErrorSpanAttributes("CLIENT_UNKNOWN_ERROR", "Exception: Test error message");
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

  private GoogleJsonResponseException createException(
      String highLevelStatusCode, String errorMessage, String detailedErrorMessage, String reason) {
    GoogleJsonError googleJsonError = null;
    if (errorMessage != null || detailedErrorMessage != null || reason != null) {
      googleJsonError = new GoogleJsonError();
      ArrayList<GoogleJsonError.ErrorInfo> errorList = new ArrayList<>();
      if (detailedErrorMessage != null || reason != null) {
        GoogleJsonError.ErrorInfo errorInfo = new GoogleJsonError.ErrorInfo();
        if (detailedErrorMessage != null && !detailedErrorMessage.isEmpty()) {
          errorInfo.setMessage(detailedErrorMessage);
        }
        if (reason != null && !reason.isEmpty()) {
          errorInfo.setReason(reason);
        }
        errorList.add(errorInfo);
      }
      googleJsonError.setErrors(errorList);
      googleJsonError.setMessage(errorMessage);
    }
    return new GoogleJsonResponseException(
        new HttpResponseException.Builder(400, highLevelStatusCode, new HttpHeaders()),
        googleJsonError);
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
}
