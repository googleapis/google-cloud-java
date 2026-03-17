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

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.*;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * HttpRequestInitializer that wraps a delegate initializer, intercepts all HTTP requests, adds
 * OpenTelemetry tracing and then invokes delegate interceptor.
 */
@BetaApi
@InternalApi
public class HttpTracingRequestInitializer implements HttpRequestInitializer {

  // TODO: migrate to use gax attributes keys
  // https://github.com/googleapis/google-cloud-java/issues/12099
  // HTTP Specific Telemetry Attributes
  public static final AttributeKey<String> HTTP_REQUEST_METHOD =
      AttributeKey.stringKey("http.request.method");
  public static final AttributeKey<String> URL_FULL = AttributeKey.stringKey("url.full");
  public static final AttributeKey<String> URL_TEMPLATE = AttributeKey.stringKey("url.template");
  public static final AttributeKey<String> URL_DOMAIN = AttributeKey.stringKey("url.domain");
  public static final AttributeKey<Long> HTTP_RESPONSE_STATUS_CODE =
      AttributeKey.longKey("http.response.status_code");
  public static final AttributeKey<Long> HTTP_REQUEST_RESEND_COUNT =
      AttributeKey.longKey("http.request.resend_count");
  public static final AttributeKey<Long> HTTP_REQUEST_BODY_SIZE =
      AttributeKey.longKey("http.request.body.size");
  public static final AttributeKey<Long> HTTP_RESPONSE_BODY_SIZE =
      AttributeKey.longKey("http.response.body.size");

  @VisibleForTesting static final String HTTP_RPC_SYSTEM_NAME = "http";

  private final HttpRequestInitializer delegate;
  private final Tracer tracer;

  public HttpTracingRequestInitializer(HttpRequestInitializer delegate, Tracer tracer) {
    this.delegate = delegate;
    this.tracer = tracer;
  }

  @Override
  public void initialize(HttpRequest request) throws IOException {

    if (delegate != null) {

      delegate.initialize(request);
    }

    if (tracer == null) {
      return;
    }
    // Get the current active span (created by HttpBigQueryRpc) and add HTTP
    // attributes to it
    Span span = Span.current();
    if (!span.getSpanContext().isValid()) {
      // No active span to exists, skip instrumentation
      return;
    }
    String host = request.getUrl().getHost();
    int port = request.getUrl().getPort();
    addInitialHttpAttributesToSpan(span, host, port);

    HttpResponseInterceptor originalInterceptor = request.getResponseInterceptor();
    request.setResponseInterceptor(
        response -> {
          addCommonResponseAttributesToSpan(
              span, request.getRequestMethod(), response.getStatusCode());
          try {
            if (originalInterceptor != null) {
              originalInterceptor.interceptResponse(response);
            }
            span.setStatus(StatusCode.OK);
          } catch (IOException e) {
            addExceptionToSpan(e, span);
            throw e;
          }
        });

    HttpUnsuccessfulResponseHandler originalHandler = request.getUnsuccessfulResponseHandler();
    request.setUnsuccessfulResponseHandler(
        (request1, response, supportsRetry) -> {
          int statusCode = response.getStatusCode();
          addCommonResponseAttributesToSpan(span, request1.getRequestMethod(), statusCode);
          addErrorResponseToSpan(response, span, statusCode);
          try {
            if (originalHandler != null) {
              return originalHandler.handleResponse(request1, response, supportsRetry);
            }
            return false;
          } catch (IOException e) {
            addExceptionToSpan(e, span);
            throw e;
          }
        });
  }

  /** Add initial HTTP attributes to the existing active span */
  private void addInitialHttpAttributesToSpan(Span span, String host, Integer port) {
    BigQueryTelemetryTracer.addCommonAttributeToSpan(span);
    span.setAttribute(BigQueryTelemetryTracer.RPC_SYSTEM_NAME, HTTP_RPC_SYSTEM_NAME);
    span.setAttribute(BigQueryTelemetryTracer.SERVER_ADDRESS, host);
    if (port != null && port > 0) {
      span.setAttribute(BigQueryTelemetryTracer.SERVER_PORT, port.longValue());
    }
  }

  private static void addCommonResponseAttributesToSpan(
      Span span, String httpMethod, int statusCode) {
    span.setAttribute(HTTP_REQUEST_METHOD, httpMethod);
    span.setAttribute(HTTP_RESPONSE_STATUS_CODE, (long) statusCode);
  }

  public static void addExceptionToSpan(Exception e, Span span) {
    span.recordException(e);
    String message = e.getMessage();
    String simpleName = e.getClass().getSimpleName();
    if (simpleName.isEmpty()) {
      simpleName = e.getClass().getName();
    }
    String statusMessage = simpleName + (message != null ? ": " + message : "");
    span.setAttribute(BigQueryTelemetryTracer.EXCEPTION_TYPE, e.getClass().getName());
    span.setAttribute(BigQueryTelemetryTracer.ERROR_TYPE, getErrorType(e));
    span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, statusMessage);
    span.setStatus(StatusCode.ERROR, statusMessage);
  }

  // TODO: this logic should get migrated to gax when ready
  private static String getErrorType(Exception e) {
    if (ExceptionTypeUtil.isClientTimeout(e)) {
      return "CLIENT_TIMEOUT";
    } else if (ExceptionTypeUtil.isClientConnectionError(e)) {
      return "CLIENT_CONNECTION_ERROR";
    } else if (ExceptionTypeUtil.isHttpResponseException(e)) {
      int statusCode = ((com.google.api.client.http.HttpResponseException) e).getStatusCode();
      return Integer.toString(statusCode);
    } else if (ExceptionTypeUtil.isClientResponseDecodeError(e)) {
      return "CLIENT_RESPONSE_DECODE_ERROR";
    } else if (ExceptionTypeUtil.isClientRedirectError(e)) {
      return "CLIENT_REDIRECT_ERROR";
    } else if (ExceptionTypeUtil.isClientAuthenticationError(e)) {
      return "CLIENT_AUTHENTICATION_ERROR";
    } else if (ExceptionTypeUtil.isClientRequestError(e)) {
      return "CLIENT_REQUEST_ERROR";
    }
    return "CLIENT_UNKNOWN_ERROR";
  }

  // first set defaults from HttpResponse then try to parse additional error
  // details from response
  private static void addErrorResponseToSpan(HttpResponse response, Span span, int statusCode) {
    try {
      String statusMessage = response.getStatusMessage();
      if (statusMessage != null && !statusMessage.isEmpty()) {
        span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, statusMessage);
      }
    } catch (Exception ex) {
      // Ignore
    }
    span.setAttribute(BigQueryTelemetryTracer.ERROR_TYPE, Integer.toString(statusCode));
    try {
      retrieveErrorDetailsFromResponseObject(response, span, statusCode);
    } catch (IOException e) {
      // Ignore, will use defaults above
    }
  }

  private static void retrieveErrorDetailsFromResponseObject(
      HttpResponse response, Span span, int statusCode) throws IOException {
    InputStream content = response.getContent();
    if (content != null) {
      if (!content.markSupported()) {
        content = new BufferedInputStream(content);
      }
      content.mark(1024 * 1024); // Mark up to 1MB
      try {
        com.google.api.client.json.JsonParser parser =
            com.google.api.client.json.gson.GsonFactory.getDefaultInstance()
                .createJsonParser(content);
        ErrorResponse errorResponse = parser.parse(ErrorResponse.class);
        if (errorResponse != null
            && errorResponse.getError() != null
            && errorResponse.getError().getErrors() != null) {
          GoogleJsonError.ErrorInfo errorInfo = errorResponse.getError().getErrors().get(0);
          String message = errorInfo.getMessage();
          if (message != null) {
            span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, message);
          }
          String reason = errorInfo.getReason();
          if (reason != null) {
            span.setAttribute(BigQueryTelemetryTracer.ERROR_TYPE, reason);
          }
        }
      } finally {
        content.reset();
      }
    }
  }
}
