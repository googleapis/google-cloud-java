/*
 * Copyright 2019 Google LLC
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

import static com.google.api.gax.tracing.MetricsTestUtils.reportFailedAttempt;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.collect.ImmutableMap;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Status.CanonicalCode;
import io.opencensus.trace.Tracer;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpencensusTracerTest {

  @Mock private Tracer internalTracer;
  @Mock private Span span;
  @Captor private ArgumentCaptor<Map<String, AttributeValue>> attributeCaptor;

  private OpencensusTracer tracer;

  @BeforeEach
  void setUp() {
    tracer = new OpencensusTracer(internalTracer, span, OperationType.Unary);
  }

  @Test
  void testUnarySuccessExample_javaTime() {
    testUnarySuccessExample(java.time.Duration.ofMillis(5));
  }

  @Test
  public void testUnarySuccessExample_threeten() {
    testUnarySuccessExample(org.threeten.bp.Duration.ofMillis(5));
  }

  public void testUnarySuccessExample(Object attemptFailedValue) {
    tracer.attemptStarted(0);
    tracer.connectionSelected("1");
    ApiException error0 =
        new DeadlineExceededException(
            "deadline exceeded", null, new FakeStatusCode(Code.DEADLINE_EXCEEDED), true);
    reportFailedAttempt(tracer, error0, attemptFailedValue);

    tracer.attemptStarted(1);
    tracer.connectionSelected("2");
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    // Attempt 0
    verify(span)
        .addAnnotation(
            "Attempt failed, scheduling next attempt",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(0),
                "delay ms", AttributeValue.longAttributeValue(5),
                "status", AttributeValue.stringAttributeValue("DEADLINE_EXCEEDED"),
                "status message", AttributeValue.stringAttributeValue("deadline exceeded"),
                "connection", AttributeValue.stringAttributeValue("1")));

    // Attempt 1
    verify(span)
        .addAnnotation(
            "Attempt succeeded",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(1),
                "connection", AttributeValue.stringAttributeValue("2")));

    verify(span)
        .putAttributes(ImmutableMap.of("attempt count", AttributeValue.longAttributeValue(2)));
    verify(span).end();

    verifyNoMoreInteractions(span);
  }

  @Test
  void testBatchExample() {
    tracer.batchRequestSent(100, 1000);
    tracer.attemptStarted(0);
    tracer.connectionSelected("1");
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    verify(span).putAttribute("batch count", AttributeValue.longAttributeValue(100));
    verify(span).putAttribute("batch size", AttributeValue.longAttributeValue(1000));
  }

  @Test
  void testLongRunningExample_javaTime() {
    testLongRunningExample(java.time.Duration.ofMillis(5));
  }

  @Test
  public void testLongRunningExample_threeten() {
    testLongRunningExample(org.threeten.bp.Duration.ofMillis(5));
  }

  public void testLongRunningExample(Object attemptFailedValue) {
    tracer = new OpencensusTracer(internalTracer, span, OperationType.LongRunning);

    // Initial poll of the initial rpc
    tracer.attemptStarted(0);
    reportFailedAttempt(tracer, null, attemptFailedValue);

    // Initial rpc finished
    tracer.lroStartSucceeded();

    // First real poll
    tracer.attemptStarted(1);
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    // Attempt 0 - initial poll of the initial rpc
    verify(span)
        .addAnnotation(
            "Scheduling next poll",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(0),
                "delay ms", AttributeValue.longAttributeValue(5),
                "status", AttributeValue.stringAttributeValue("OK")));

    verify(span).addAnnotation("Operation started", ImmutableMap.<String, AttributeValue>of());

    // Attempt 1 - first real poll
    verify(span)
        .addAnnotation(
            "Polling completed", ImmutableMap.of("attempt", AttributeValue.longAttributeValue(1)));

    verify(span)
        .putAttributes(ImmutableMap.of("attempt count", AttributeValue.longAttributeValue(2)));
    verify(span).end();

    verifyNoMoreInteractions(span);
  }

  @Test
  void testRetriesExhaustedExample() {
    tracer.attemptStarted(0);
    tracer.connectionSelected("1");
    ApiException error0 =
        new DeadlineExceededException(
            "deadline exceeded", null, new FakeStatusCode(Code.DEADLINE_EXCEEDED), false);
    tracer.attemptFailedRetriesExhausted(error0);
    tracer.operationFailed(error0);

    verify(span)
        .addAnnotation(
            "Attempts exhausted",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(0),
                "status", AttributeValue.stringAttributeValue("DEADLINE_EXCEEDED"),
                "status message", AttributeValue.stringAttributeValue("deadline exceeded"),
                "connection", AttributeValue.stringAttributeValue("1")));

    verify(span)
        .putAttributes(ImmutableMap.of("attempt count", AttributeValue.longAttributeValue(1)));

    verify(span)
        .end(
            EndSpanOptions.builder()
                .setStatus(Status.DEADLINE_EXCEEDED.withDescription("deadline exceeded"))
                .build());

    verifyNoMoreInteractions(span);
  }

  @Test
  void testCancellationExample() {
    tracer.attemptStarted(0);
    tracer.connectionSelected("1");
    tracer.attemptCancelled();
    tracer.operationCancelled();

    verify(span)
        .addAnnotation(
            "Attempt cancelled",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(0),
                "connection", AttributeValue.stringAttributeValue("1")));

    verify(span)
        .putAttributes(ImmutableMap.of("attempt count", AttributeValue.longAttributeValue(1)));

    verify(span)
        .end(
            EndSpanOptions.builder()
                .setStatus(Status.CANCELLED.withDescription("Cancelled by caller"))
                .build());
    verifyNoMoreInteractions(span);
  }

  @Test
  void testFailureExample() {
    tracer.attemptStarted(0);
    tracer.connectionSelected("1");
    ApiException error0 =
        new NotFoundException("not found", null, new FakeStatusCode(Code.NOT_FOUND), false);
    tracer.attemptPermanentFailure(error0);
    tracer.operationFailed(error0);

    verify(span)
        .addAnnotation(
            "Attempt failed, error not retryable",
            ImmutableMap.of(
                "attempt", AttributeValue.longAttributeValue(0),
                "status", AttributeValue.stringAttributeValue("NOT_FOUND"),
                "status message", AttributeValue.stringAttributeValue("not found"),
                "connection", AttributeValue.stringAttributeValue("1")));

    verify(span)
        .putAttributes(ImmutableMap.of("attempt count", AttributeValue.longAttributeValue(1)));

    verify(span)
        .end(
            EndSpanOptions.builder()
                .setStatus(Status.NOT_FOUND.withDescription("not found"))
                .build());
    verifyNoMoreInteractions(span);
  }

  @Test
  void testResponseCount_javaTime() {
    testResponseCount(java.time.Duration.ofMillis(5));
  }

  @Test
  public void testResponseCount_threeten() {
    testResponseCount(java.time.Duration.ofMillis(5));
  }

  public void testResponseCount(Object attemptFailedValue) {
    // Initial attempt got 2 messages, then failed
    tracer.attemptStarted(0);
    tracer.responseReceived();
    tracer.responseReceived();
    reportFailedAttempt(tracer, new RuntimeException(), attemptFailedValue);

    // Next attempt got 1 message, then successfully finished the attempt and the logical operation.
    tracer.attemptStarted(1);
    tracer.responseReceived();
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    verify(span)
        .addAnnotation(eq("Attempt failed, scheduling next attempt"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt response count", AttributeValue.longAttributeValue(2));

    verify(span).addAnnotation(eq("Attempt succeeded"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt response count", AttributeValue.longAttributeValue(1));

    verify(span).putAttributes(attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("total response count", AttributeValue.longAttributeValue(3));
  }

  @Test
  void testRequestCount_javaTime() {
    testRequestCount(java.time.Duration.ofMillis(2));
  }

  @Test
  public void testRequestCount_threeten() {
    testRequestCount(org.threeten.bp.Duration.ofMillis(2));
  }

  public void testRequestCount(Object attemptFailedValue) {
    // Initial attempt sent 2 messages, then failed
    tracer.attemptStarted(0);
    tracer.requestSent();
    tracer.requestSent();
    reportFailedAttempt(tracer, new RuntimeException(), attemptFailedValue);

    // Next attempt sent 1 message, then successfully finished the attempt and the logical
    // operation.
    tracer.attemptStarted(1);
    tracer.requestSent();
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    verify(span)
        .addAnnotation(eq("Attempt failed, scheduling next attempt"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt request count", AttributeValue.longAttributeValue(2));

    verify(span).addAnnotation(eq("Attempt succeeded"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt request count", AttributeValue.longAttributeValue(1));

    verify(span).putAttributes(attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("total request count", AttributeValue.longAttributeValue(3));
  }

  @Test
  void testAttemptNumber_javaTime() {
    testAttemptNumber(java.time.Duration.ofMillis(5));
  }

  @Test
  public void testAttemptNumber_threeten() {
    testAttemptNumber(org.threeten.bp.Duration.ofMillis(5));
  }

  public void testAttemptNumber(Object attemptFailedValue) {
    tracer.attemptStarted(0);
    reportFailedAttempt(tracer, new RuntimeException(), attemptFailedValue);
    tracer.attemptStarted(1);
    tracer.attemptSucceeded();
    tracer.operationSucceeded();

    verify(span)
        .addAnnotation(eq("Attempt failed, scheduling next attempt"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt", AttributeValue.longAttributeValue(0));

    verify(span).addAnnotation(eq("Attempt succeeded"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt", AttributeValue.longAttributeValue(1));

    verify(span).putAttributes(attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("attempt count", AttributeValue.longAttributeValue(2));
  }

  @Test
  void testStatusCode() {
    tracer.attemptStarted(0);
    reportFailedAttempt(
        tracer,
        new DeadlineExceededException(
            "deadline exceeded", null, new FakeStatusCode(Code.DEADLINE_EXCEEDED), true),
        java.time.Duration.ofMillis(1));

    tracer.attemptStarted(1);
    ApiException permanentError =
        new NotFoundException("not found", null, new FakeStatusCode(Code.NOT_FOUND), false);
    tracer.attemptPermanentFailure(permanentError);
    tracer.operationFailed(permanentError);

    verify(span)
        .addAnnotation(eq("Attempt failed, scheduling next attempt"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("status", AttributeValue.stringAttributeValue("DEADLINE_EXCEEDED"));

    verify(span)
        .addAnnotation(eq("Attempt failed, error not retryable"), attributeCaptor.capture());
    assertThat(attributeCaptor.getValue())
        .containsEntry("status", AttributeValue.stringAttributeValue("NOT_FOUND"));
  }

  @Test
  void testErrorConversion() {
    for (Code code : Code.values()) {
      ApiException error = new ApiException("fake message", null, new FakeStatusCode(code), false);
      Status opencensusStatus = OpencensusTracer.convertErrorToStatus(error);
      assertThat(opencensusStatus.getDescription()).isEqualTo("fake message");
      assertThat(opencensusStatus.getCanonicalCode().toString()).isEqualTo(code.toString());
    }
  }

  @Test
  void testStreamingErrorConversion() {
    ServerStreamingAttemptException error =
        new ServerStreamingAttemptException(
            new DeadlineExceededException(
                "timeout", null, new FakeStatusCode(Code.DEADLINE_EXCEEDED), true),
            true,
            true);
    Status opencensusStatus = OpencensusTracer.convertErrorToStatus(error);
    assertThat(opencensusStatus.getDescription()).isEqualTo("timeout");
    assertThat(opencensusStatus.getCanonicalCode()).isEqualTo(CanonicalCode.DEADLINE_EXCEEDED);
  }
}
