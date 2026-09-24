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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.logging.TestLogger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.testing.junit5.OpenTelemetryExtension;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.LoggerFactory;

/**
 * Manual and automated verification test confirming that during SLF4J actionable error logging in
 * {@link LoggingTracer}, the active OpenTelemetry {@code trace_id} and {@code span_id} are
 * automatically populated from the ambient thread context managed by {@link
 * OpenTelemetryTracingTracer}.
 */
class VerifySlf4jTraceIdPopulationTest {

  @RegisterExtension
  static final OpenTelemetryExtension otelTesting = OpenTelemetryExtension.create();

  private Tracer tracer;
  private TestLogger testLogger;
  private Scope rootScope;

  @BeforeEach
  @SuppressWarnings("MustBeClosedChecker")
  void setUp() {
    // Reset ambient thread context to root before each test to prevent thread leakage
    rootScope = Context.root().makeCurrent();

    tracer = otelTesting.getOpenTelemetry().getTracer("com.google.api.gax.test");

    testLogger = (TestLogger) LoggerFactory.getLogger(LoggingTracer.class);
    testLogger.getMessageList().clear();
    testLogger.getMDCMap().clear();
    testLogger.getKeyValuePairsMap().clear();
  }

  @AfterEach
  void tearDown() {
    if (rootScope != null) {
      rootScope.close();
    }
  }

  @Test
  void testSlf4jTraceIdPopulatedAutomaticallyDuringAttemptFailure() {
    // 1. Set up ApiTracerContext with attempt attributes
    ApiTracerContext context =
        ApiTracerContext.empty().toBuilder().setTransport(ApiTracerContext.Transport.GRPC).build();

    // 2. Capture ambient OpenTelemetry trace context at the exact moment SLF4J logs
    AtomicReference<SpanContext> ambientSpanContextAtLogTime = new AtomicReference<>();
    AtomicBoolean logExecuted = new AtomicBoolean(false);

    LoggingTracer loggingTracer =
        new LoggingTracer(context) {
          @Override
          void recordActionableError(Throwable error) {
            // When LoggingTracer logs via SLF4J, standard logging frameworks (Logback,
            // OpenTelemetry
            // appender, Log4j2) query Span.current() on the calling thread.
            Span currentSpan = Span.current();
            ambientSpanContextAtLogTime.set(currentSpan.getSpanContext());
            logExecuted.set(true);

            super.recordActionableError(error);

            // Print formatted SLF4J log line demonstrating automatic trace_id population
            System.out.println(
                "================================================================================");
            System.out.println("VERIFICATION: Emitted SLF4J Actionable Error Log Record:");
            System.out.println("  Message:       " + error.getMessage());
            System.out.println("  Trace ID:      " + currentSpan.getSpanContext().getTraceId());
            System.out.println("  Span ID:       " + currentSpan.getSpanContext().getSpanId());
            System.out.println("  Span Valid:    " + currentSpan.getSpanContext().isValid());
            System.out.println("  Attempt Attrs: " + context.getAttemptAttributes());
            System.out.println("  SLF4J Formatted Log Output:");
            System.out.println(
                "    DEBUG com.google.api.gax.tracing.LoggingTracer - [trace_id="
                    + currentSpan.getSpanContext().getTraceId()
                    + ", span_id="
                    + currentSpan.getSpanContext().getSpanId()
                    + "] "
                    + error.getMessage());
            System.out.println(
                "================================================================================");
          }
        };

    // 3. Compose OpenTelemetryTracingTracer and LoggingTracer matching ClientContext ordering
    OpenTelemetryTracingTracer otelTracer =
        new OpenTelemetryTracingTracer(
            tracer, context, "google.showcase.v1beta1.Echo/Echo/attempt");
    CompositeTracer compositeTracer = new CompositeTracer(Arrays.asList(otelTracer, loggingTracer));

    // 4. Start attempt -> Starts attemptSpan and sets it to current context (scope.makeCurrent())
    compositeTracer.attemptStarted(new Object(), 1);

    // 5. Attempt fails with permanent error -> Triggers LoggingTracer.recordActionableError()
    Exception rpcFailure = new RuntimeException("UNAVAILABLE: connection reset by peer");
    compositeTracer.attemptPermanentFailure(rpcFailure);

    // 6. Verify assertions
    assertTrue(logExecuted.get(), "Expected LoggingTracer.recordActionableError to be executed");
    SpanContext loggedSpanContext = ambientSpanContextAtLogTime.get();
    assertThat(loggedSpanContext).isNotNull();
    assertTrue(
        loggedSpanContext.isValid(),
        "Expected active span context during SLF4J logging to be valid");
    assertNotEquals(
        "00000000000000000000000000000000",
        loggedSpanContext.getTraceId(),
        "Trace ID must be non-zero and populated from OpenTelemetry span");
    assertNotEquals(
        "0000000000000000",
        loggedSpanContext.getSpanId(),
        "Span ID must be non-zero and populated from OpenTelemetry span");

    // 7. Verify that after attempt finishes, the scope is closed and no span context leaks
    Span currentSpanAfterAttempt = Span.current();
    assertFalse(
        currentSpanAfterAttempt.getSpanContext().isValid(),
        "Scope must be closed when attempt ends; thread context must return to invalid span");
    assertEquals(
        "00000000000000000000000000000000",
        currentSpanAfterAttempt.getSpanContext().getTraceId(),
        "Ambient trace ID after attempt completion must be 0");
  }

  @Test
  void testSlf4jTraceIdPopulatedDuringAttemptFailedDuration() {
    ApiTracerContext context =
        ApiTracerContext.empty().toBuilder().setTransport(ApiTracerContext.Transport.HTTP).build();

    AtomicReference<SpanContext> ambientSpanContextAtLogTime = new AtomicReference<>();

    LoggingTracer loggingTracer =
        new LoggingTracer(context) {
          @Override
          void recordActionableError(Throwable error) {
            ambientSpanContextAtLogTime.set(Span.current().getSpanContext());
            super.recordActionableError(error);
          }
        };

    OpenTelemetryTracingTracer otelTracer =
        new OpenTelemetryTracingTracer(
            tracer, context, "google.showcase.v1beta1.Echo/Echo/attempt");
    CompositeTracer compositeTracer = new CompositeTracer(Arrays.asList(otelTracer, loggingTracer));

    compositeTracer.attemptStarted(new Object(), 1);

    Exception retryableError = new RuntimeException("RESOURCE_EXHAUSTED: quota exceeded");
    compositeTracer.attemptFailedDuration(retryableError, Duration.ofMillis(250));

    SpanContext loggedSpanContext = ambientSpanContextAtLogTime.get();
    assertThat(loggedSpanContext).isNotNull();
    assertTrue(loggedSpanContext.isValid());
    assertNotEquals("00000000000000000000000000000000", loggedSpanContext.getTraceId());

    // Verify scope cleanly closed after attempt end
    assertFalse(Span.current().getSpanContext().isValid());
  }

  @Test
  void testWithoutScopeManagement_TraceIdIsInvalid() {
    // Simulates the pre-PR #14457 behavior where attemptSpan was started but never made current
    ApiTracerContext context = ApiTracerContext.empty();

    AtomicReference<SpanContext> ambientSpanContextAtLogTime = new AtomicReference<>();

    LoggingTracer loggingTracer =
        new LoggingTracer(context) {
          @Override
          void recordActionableError(Throwable error) {
            ambientSpanContextAtLogTime.set(Span.current().getSpanContext());
            super.recordActionableError(error);
          }
        };

    // ApiTracer without span.makeCurrent()
    ApiTracer legacyTracerWithoutScope =
        new BaseApiTracer() {
          @Override
          public void attemptStarted(Object request, int attemptNumber) {
            // Started span without makeCurrent() (the bug before PR #14457)
            tracer.spanBuilder("Service/Method/attempt").startSpan();
          }
        };

    CompositeTracer compositeTracer =
        new CompositeTracer(Arrays.asList(legacyTracerWithoutScope, loggingTracer));

    compositeTracer.attemptStarted(new Object(), 1);
    compositeTracer.attemptPermanentFailure(new RuntimeException("Simulated error"));

    SpanContext loggedSpanContext = ambientSpanContextAtLogTime.get();
    assertThat(loggedSpanContext).isNotNull();
    // Prior to PR #14457, the span was NOT made current, so the ambient context was invalid:
    assertFalse(
        loggedSpanContext.isValid(),
        "Without scope management, ambient span context during SLF4J logging is invalid");
    assertEquals(
        "00000000000000000000000000000000",
        loggedSpanContext.getTraceId(),
        "Without scope management, trace ID is all zeros (unpopulated)");
  }
}
