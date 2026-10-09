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

import com.google.api.client.util.Strings;
import com.google.api.core.InternalApi;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** An implementation of {@link ApiTracer} that uses OpenTelemetry to record traces. */
@NullMarked
class OpenTelemetryTracingTracer implements ApiTracer {

  static final String CONTENT_LENGTH_KEY = "Content-Length";

  private final Tracer tracer;
  private final Map<String, Object> attemptAttributes;
  private final String attemptSpanName;
  private final String operationSpanName;
  private final ApiTracerContext apiTracerContext;
  // Captures the active trace context from the calling thread at RPC initiation.
  // This allows the operation span and attempt spans to link back to the caller's trace.
  private final Context parentContext;
  // Trace context containing the operationSpan, serving as the parent for attempt spans.
  private final Context operationContext;
  private @Nullable Span operationSpan;
  private @Nullable Span attemptSpan;

  @Override
  public void injectTraceContext(Map<String, String> carrier) {
    // Prefer the active attempt span so outgoing RPC wire context reflects the specific attempt;
    // fall back to the overall operation span if no attempt is currently in-flight.
    Span currentSpan = attemptSpan != null ? attemptSpan : operationSpan;
    if (currentSpan != null) {
      Context context = Context.current().with(currentSpan);
      W3CTraceContextPropagator.getInstance()
          .inject(
              context,
              carrier,
              (c, k, v) -> {
                if (c != null) {
                  c.put(k, v);
                }
              });
    }
  }

  /**
   * Creates a new instance of {@code OpenTelemetryTracingTracer}.
   *
   * @param tracer the {@link Tracer} to use for recording spans
   * @param apiTracerContext the {@link ApiTracerContext} to use for recording spans
   */
  OpenTelemetryTracingTracer(Tracer tracer, ApiTracerContext apiTracerContext) {
    this(tracer, apiTracerContext, resolveAttemptSpanName(apiTracerContext));
  }

  /**
   * Creates a new instance of {@code OpenTelemetryTracingTracer} with an explicitly provided span
   * name.
   *
   * @param tracer the {@link Tracer} to use for recording spans
   * @param apiTracerContext the {@link ApiTracerContext} to use for recording spans
   * @param attemptSpanName the name of the individual attempt spans
   */
  @InternalApi
  OpenTelemetryTracingTracer(
      Tracer tracer, ApiTracerContext apiTracerContext, String attemptSpanName) {
    this.tracer = tracer;
    this.apiTracerContext = apiTracerContext;
    this.attemptSpanName = attemptSpanName;
    this.operationSpanName = resolveOperationSpanName(attemptSpanName);
    this.attemptAttributes = new HashMap<>();
    this.parentContext = Context.current();
    buildAttributes();
    this.operationSpan = startOperationSpan();
    this.operationContext = parentContext.with(this.operationSpan);
  }

  /**
   * Starts and initializes the operation-level client request span.
   *
   * @return the newly started {@link Span} for the overall operation
   */
  private Span startOperationSpan() {
    SpanBuilder operationSpanBuilder = tracer.spanBuilder(operationSpanName);
    operationSpanBuilder.setSpanKind(SpanKind.INTERNAL);
    operationSpanBuilder.setParent(parentContext);
    operationSpanBuilder.setAllAttributes(
        ObservabilityUtils.toOtelAttributes(this.apiTracerContext.getOperationAttributes()));
    return operationSpanBuilder.startSpan();
  }

  /**
   * Derives the operation-level span name from the attempt span name.
   *
   * @param attemptSpanName the attempt span name
   * @return the operation span name
   */
  private static String resolveOperationSpanName(String attemptSpanName) {
    if (!Strings.isNullOrEmpty(attemptSpanName)) {
      if (attemptSpanName.endsWith("/attempt")) {
        String name = attemptSpanName.substring(0, attemptSpanName.length() - "/attempt".length());
        return name.isEmpty() ? "operation" : name;
      }
      return "attempt".equals(attemptSpanName) ? "operation" : attemptSpanName;
    }
    return "operation";
  }

  /**
   * Resolves the canonical attempt-level span name based on transport and context.
   *
   * @param apiTracerContext the tracer context containing transport and method metadata
   * @return the attempt span name
   */
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

  /** Copies attempt-level attributes from the tracer context into the local attribute cache. */
  private void buildAttributes() {
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

    // Link attempt span to operation context (parent operation span)
    spanBuilder.setParent(operationContext);

    // Pass the combined attributes to the new SpanBuilder method
    spanBuilder.setAllAttributes(ObservabilityUtils.toOtelAttributes(currentAttemptAttributes));

    this.attemptSpan = spanBuilder.startSpan();
  }

  /**
   * Signals that the overall logical operation succeeded.
   *
   * <p>Closes any remaining in-flight attempt span and ends the operation span.
   */
  @Override
  public void operationSucceeded() {
    recordErrorAndEndOperation(null);
  }

  /**
   * Signals that the overall logical operation was cancelled.
   *
   * <p>Closes any remaining in-flight attempt span with a {@link CancellationException} and ends
   * the operation span with an ERROR status.
   */
  @Override
  public void operationCancelled() {
    recordErrorAndEndOperation(new CancellationException());
  }

  /**
   * Signals that the overall logical operation failed permanently.
   *
   * <p>Closes any remaining in-flight attempt span with the provided error details and ends the
   * operation span with an ERROR status.
   *
   * @param error the cause of the operation failure
   */
  @Override
  public void operationFailed(Throwable error) {
    recordErrorAndEndOperation(error);
  }

  /**
   * Records error details and ends both the active attempt span and the operation span.
   *
   * @param error the exception associated with the operation failure, or {@code null} if successful
   */
  private void recordErrorAndEndOperation(@Nullable Throwable error) {
    if (attemptSpan != null) {
      endSpan(attemptSpan, error);
      attemptSpan = null;
    }
    if (operationSpan != null) {
      endSpan(operationSpan, error);
      operationSpan = null;
    }
  }

  @Override
  public void attemptSucceeded() {
    recordErrorAndEndAttempt(null);
  }

  @Override
  public void responseHeadersReceived(Map<String, Object> headers) {
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
  private long extractContentLength(Map<String, Object> headers) {
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
    recordErrorAndEndAttempt(new CancellationException());
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    recordErrorAndEndAttempt(error);
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    recordErrorAndEndAttempt(error);
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    recordErrorAndEndAttempt(error);
  }

  /**
   * Records error details and ends the current attempt span.
   *
   * @param error the exception associated with the attempt failure, or {@code null} if successful
   */
  private void recordErrorAndEndAttempt(@Nullable Throwable error) {
    if (attemptSpan == null) {
      return;
    }
    endSpan(attemptSpan, error);
    attemptSpan = null;
  }

  /**
   * Attaches response status attributes and error messages to the span and ends it.
   *
   * @param span the span to finish
   * @param error the exception that caused the span to end, or {@code null} if successful
   */
  private void endSpan(Span span, @Nullable Throwable error) {
    Map<String, Object> responseAttributes =
        ObservabilityUtils.getResponseAttributes(error, this.apiTracerContext.transport());
    if (!responseAttributes.isEmpty()) {
      span.setAllAttributes(ObservabilityUtils.toOtelAttributes(responseAttributes));
    }

    if (error != null) {
      span.setStatus(StatusCode.ERROR);
      if (!Strings.isNullOrEmpty(error.getMessage())) {
        span.setAttribute(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE, error.getMessage());
      }
    }

    span.end();
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
