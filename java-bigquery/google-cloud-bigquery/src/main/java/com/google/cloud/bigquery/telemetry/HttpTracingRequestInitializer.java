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

import com.google.api.client.http.*;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import java.io.IOException;

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
    // Get the current active span (created by HttpBigQueryRpc) and add HTTP attributes to it
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
          addCommonResponseAttributesToSpan(request, response, span);
          if (originalInterceptor != null) {
            originalInterceptor.interceptResponse(response);
          }
        });

    HttpUnsuccessfulResponseHandler originalHandler = request.getUnsuccessfulResponseHandler();
    request.setUnsuccessfulResponseHandler(
        (request1, response, supportsRetry) -> {
          addCommonResponseAttributesToSpan(request1, response, span);
          if (originalHandler != null) {
            return originalHandler.handleResponse(request1, response, supportsRetry);
          }
          return false;
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
    // TODO add full sanitized url, url domain, request method
  }

  private static void addCommonResponseAttributesToSpan(
      HttpRequest request, HttpResponse response, Span span) {
    // We add request body size and update request method after we receive response as
    // the data is not always available until after the http request execution
    addRequestBodySizeToSpan(request, span);
    span.setAttribute(HTTP_REQUEST_METHOD, request.getRequestMethod());
    addResponseBodySizeToSpan(response, span);
    span.setAttribute(HTTP_RESPONSE_STATUS_CODE, response.getStatusCode());
  }

  static void addRequestBodySizeToSpan(HttpRequest request, Span span) {
    try {
      if (request.getContent() != null && request.getEncoding() == null) {
        span.setAttribute(HTTP_REQUEST_BODY_SIZE, request.getContent().getLength());
      }
    } catch (IOException e) {
      // Ignore - body size not available
    }
  }

  static void addResponseBodySizeToSpan(HttpResponse response, Span span) {
    Long contentLength = response.getHeaders().getContentLength();
    if (contentLength != null && contentLength > 0) {
      span.setAttribute(HTTP_RESPONSE_BODY_SIZE, contentLength);
    }
    // TODO handle chunked responses
  }
}
