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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import java.util.HashMap;
import java.util.Map;

/** An implementation of {@link ApiTracer} that uses OpenTelemetry to record traces. */
@BetaApi
@InternalApi
public class SpanTracer implements ApiTracer {
  public static final String LANGUAGE_ATTRIBUTE = "gcp.client.language";

  public static final String DEFAULT_LANGUAGE = "Java";

  static final String CONTENT_LENGTH_KEY = "Content-Length";

  private final Tracer tracer;
  private final Map<String, Object> attemptAttributes;
  private final String attemptSpanName;
  private final ApiTracerContext apiTracerContext;
  private Span attemptSpan;

  /**
   * Creates a new instance of {@code SpanTracer}.
   *
   * @param tracer the {@link Tracer} to use for recording spans
   * @param apiTracerContext the {@link ApiTracerContext} to use for recording spans
   */
  public SpanTracer(Tracer tracer, ApiTracerContext apiTracerContext) {
    this.tracer = tracer;
    this.apiTracerContext = apiTracerContext;
    this.attemptSpanName = resolveAttemptSpanName(apiTracerContext);
    this.attemptAttributes = new HashMap<>();
    buildAttributes();
  }

  /**
   * Creates a new instance of {@code SpanTracer} with an explicitly provided span name.
   *
   * @param tracer the {@link Tracer} to use for recording spans
   * @param apiTracerContext the {@link ApiTracerContext} to use for recording spans
   * @param attemptSpanName the name of the individual attempt spans
   */
  @InternalApi
  SpanTracer(Tracer tracer, ApiTracerContext apiTracerContext, String attemptSpanName) {
    this.tracer = tracer;
    this.attemptSpanName = attemptSpanName;
    this.apiTracerContext = apiTracerContext;
    this.attemptAttributes = new HashMap<>();
    buildAttributes();
  }

  private static String resolveAttemptSpanName(ApiTracerContext apiTracerContext) {
    if (apiTracerContext.transport() == ApiTracerContext.Transport.GRPC) {
      // gRPC Uses the full method name as span name.
      return apiTracerContext.fullMethodName();
    } else if (apiTracerContext.httpMethod() == null
        || apiTracerContext.httpPathTemplate() == null) {
      // HTTP method name without necessary components defaults to the full method name
      return apiTracerContext.fullMethodName();
    } else {
      // We construct the span name with HTTP method and path template.
      return String.format(
          "%s %s", apiTracerContext.httpMethod(), apiTracerContext.httpPathTemplate());
    }
  }

  private void buildAttributes() {
    this.attemptAttributes.put(LANGUAGE_ATTRIBUTE, DEFAULT_LANGUAGE);
    this.attemptAttributes.putAll(this.apiTracerContext.getAttemptAttributes());
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    Map<String, Object> currentAttemptAttributes = new HashMap<>(this.attemptAttributes);

    if (attemptNumber > 0) {
      ApiTracerContext.Transport transport = apiTracerContext.transport();
      if (transport == ApiTracerContext.Transport.GRPC) {
        currentAttemptAttributes.put(
            ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE, (long) attemptNumber);
      } else if (transport == ApiTracerContext.Transport.HTTP) {
        currentAttemptAttributes.put(
            ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE, (long) attemptNumber);
      }
    }

    SpanBuilder spanBuilder = tracer.spanBuilder(attemptSpanName);

    // Attempt spans are of the CLIENT kind
    spanBuilder.setSpanKind(SpanKind.CLIENT);

    // Pass the combined attributes to the new SpanBuilder method
    spanBuilder.setAllAttributes(ObservabilityUtils.toOtelAttributes(currentAttemptAttributes));

    this.attemptSpan = spanBuilder.startSpan();
  }

  @Override
  public void attemptSucceeded() {
    endAttempt();
  }

  @Override
  public void responseHeadersReceived(java.util.Map<String, Object> headers) {
    if (attemptSpan == null) {
      return;
    }
    long contentLength = extractContentLength(headers);
    if (contentLength >= 0) {
      attemptSpan.setAttribute(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE, contentLength);
    }
  }

  /**
   * Extracts the Content-Length header value from the response headers, if available.
   *
   * <p>Note: google-http-java-client's HttpHeaders.java returns some headers (like Content-Length)
   * as a List<Long> instead of a single value.
   * https://github.com/googleapis/google-http-java-client/blob/main/google-http-client/src/main/java/com/google/api/client/http/HttpHeaders.java#L162
   *
   * @param headers the map of response headers.
   * @return the content length in bytes, or -1 if the header is missing or malformed.
   */
  private long extractContentLength(java.util.Map<String, Object> headers) {
    try {
      if (headers == null || headers.isEmpty()) return -1;
      // google-http-client HttpHeaders uses a case-insensitive map but we copy it for safety
      // and to handle potential different implementations.
      Object value =
          headers.entrySet().stream()
              .filter(e -> CONTENT_LENGTH_KEY.equalsIgnoreCase(e.getKey()))
              .map(Map.Entry::getValue)
              .findFirst()
              .orElse(null);

      if (value instanceof java.util.Collection) {
        value = ((java.util.Collection<?>) value).stream().findFirst().orElse(null);
      }
      return Long.parseLong(value.toString());
    } catch (Exception e) {
      return -1;
    }
  }

  @Override
  public void attemptCancelled() {
    endAttempt();
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    endAttempt();
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    endAttempt();
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    endAttempt();
  }

  private void endAttempt() {
    if (attemptSpan != null) {
      attemptSpan.end();
      attemptSpan = null;
    }
  }

  @Override
  public void requestUrlResolved(String url) {
    if (attemptSpan == null) {
      return;
    }
    String sanitizedUrlString = ObservabilityUtils.sanitizeUrlFull(url);
    if (sanitizedUrlString.isEmpty()) {
      return;
    }
    attemptSpan.setAttribute(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE, sanitizedUrlString);
  }
}
