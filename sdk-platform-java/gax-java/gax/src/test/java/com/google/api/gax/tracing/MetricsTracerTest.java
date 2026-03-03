/*
 * Copyright 2024 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MetricsTracerTest {
  private static final String DEFAULT_METHOD_NAME = "fake_service.fake_method";

  private MetricsTracer metricsTracer;
  @Mock private MetricsRecorder metricsRecorder;

  @BeforeEach
  void setUp() {
    metricsTracer =
        new MetricsTracer(MethodName.of("fake_service", "fake_method"), metricsRecorder);
  }

  private ImmutableMap<String, String> getAttributes(Code statusCode) {
    return ImmutableMap.of(
        MetricsTracer.STATUS_ATTRIBUTE,
        statusCode.toString(),
        MetricsTracer.METHOD_ATTRIBUTE,
        DEFAULT_METHOD_NAME,
        MetricsTracer.LANGUAGE_ATTRIBUTE,
        MetricsTracer.DEFAULT_LANGUAGE);
  }

  @Test
  void testOperationSucceeded_recordsAttributes() {
    metricsTracer.operationSucceeded();

    Map<String, String> attributes = getAttributes(Code.OK);

    verify(metricsRecorder).recordOperationCount(1, attributes);
    verify(metricsRecorder).recordOperationLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testOperationFailed_recordsAttributes() {
    ApiException error0 =
        new NotFoundException(
            "invalid argument", null, new FakeStatusCode(Code.INVALID_ARGUMENT), false);
    metricsTracer.operationFailed(error0);

    Map<String, String> attributes = getAttributes(Code.INVALID_ARGUMENT);

    verify(metricsRecorder).recordOperationCount(1, attributes);
    verify(metricsRecorder).recordOperationLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testOperationCancelled_recordsAttributes() {
    metricsTracer.operationCancelled();

    Map<String, String> attributes = getAttributes(Code.CANCELLED);

    verify(metricsRecorder).recordOperationCount(1, attributes);
    verify(metricsRecorder).recordOperationLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testAttemptSucceeded_recordsAttributes() {
    // initialize mock-request
    Object mockSuccessfulRequest = new Object();

    // Attempt #1
    metricsTracer.attemptStarted(mockSuccessfulRequest, 0);
    metricsTracer.attemptSucceeded();

    Map<String, String> attributes = getAttributes(Code.OK);

    verify(metricsRecorder).recordAttemptCount(1, attributes);
    verify(metricsRecorder).recordAttemptLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testAttemptFailed_usingJavaTime_recordsAttributes() {
    testAttemptFailed_recordsAttributes(java.time.Duration.ofMillis(2));
  }

  @Test
  public void testAttemptFailed_usingThreeten_recordsAttributes() {
    testAttemptFailed_recordsAttributes(org.threeten.bp.Duration.ofMillis(2));
  }

  public void testAttemptFailed_recordsAttributes(final Object attemptFailedValue) {
    // initialize mock-request
    Object mockFailedRequest = new Object();

    // Attempt #1
    metricsTracer.attemptStarted(mockFailedRequest, 0);
    ApiException error0 =
        new NotFoundException(
            "invalid argument", null, new FakeStatusCode(Code.INVALID_ARGUMENT), false);
    reportFailedAttempt(metricsTracer, error0, attemptFailedValue);

    Map<String, String> attributes = getAttributes(Code.INVALID_ARGUMENT);

    verify(metricsRecorder).recordAttemptCount(1, attributes);
    verify(metricsRecorder).recordAttemptLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testAttemptCancelled_recordsAttributes() {
    // initialize mock-request
    Object mockCancelledRequest = new Object();
    // Attempt #1
    metricsTracer.attemptStarted(mockCancelledRequest, 0);
    metricsTracer.attemptCancelled();

    Map<String, String> attributes = getAttributes(Code.CANCELLED);

    verify(metricsRecorder).recordAttemptCount(1, attributes);
    verify(metricsRecorder).recordAttemptLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testAttemptFailedRetriesExhausted_recordsAttributes() {
    // initialize mock-request
    Object mockRequest = new Object();
    // Attempt #1
    metricsTracer.attemptStarted(mockRequest, 0);
    ApiException error0 =
        new DeadlineExceededException(
            "deadline exceeded", null, new FakeStatusCode(Code.DEADLINE_EXCEEDED), false);
    metricsTracer.attemptFailedRetriesExhausted(error0);

    Map<String, String> attributes = getAttributes(Code.DEADLINE_EXCEEDED);

    verify(metricsRecorder).recordAttemptCount(1, attributes);
    verify(metricsRecorder).recordAttemptLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testAttemptPermanentFailure_recordsAttributes() {
    // initialize mock-request
    Object mockRequest = new Object();
    // Attempt #1
    metricsTracer.attemptStarted(mockRequest, 0);
    ApiException error0 =
        new NotFoundException("not found", null, new FakeStatusCode(Code.NOT_FOUND), false);
    metricsTracer.attemptFailedRetriesExhausted(error0);

    Map<String, String> attributes = getAttributes(Code.NOT_FOUND);

    verify(metricsRecorder).recordAttemptCount(1, attributes);
    verify(metricsRecorder).recordAttemptLatency(anyDouble(), eq(attributes));

    verifyNoMoreInteractions(metricsRecorder);
  }

  @Test
  void testMultipleOperationCalls_throwsError() {
    metricsTracer.operationSucceeded();
    IllegalStateException exception1 =
        assertThrows(IllegalStateException.class, () -> metricsTracer.operationCancelled());
    assertThat(exception1.getMessage()).isEqualTo("Operation has already been completed");
    IllegalStateException exception2 =
        assertThrows(IllegalStateException.class, () -> metricsTracer.operationSucceeded());
    assertThat(exception2.getMessage()).isEqualTo("Operation has already been completed");
  }

  @Test
  void testAddAttributes_recordsAttributes() {
    metricsTracer.addAttributes("FakeTableId", "12345");
    assertThat(metricsTracer.getAttributes().get("FakeTableId")).isEqualTo("12345");
  }

  @Test
  void testAddAttributes_recordsAttributesWithMap() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put("FakeTableId", "12345");
    attributes.put("FakeInstanceId", "67890");
    metricsTracer.addAttributes(attributes);
    assertThat(metricsTracer.getAttributes().get("FakeTableId")).isEqualTo("12345");
    assertThat(metricsTracer.getAttributes().get("FakeInstanceId")).isEqualTo("67890");
  }

  @Test
  void testExtractStatus_errorConversion_apiExceptions() {
    ApiException error =
        new ApiException("fake_error", null, new FakeStatusCode(Code.INVALID_ARGUMENT), false);
    String errorCode = metricsTracer.extractStatus(error);
    assertThat(errorCode).isEqualTo(Code.INVALID_ARGUMENT.toString());
  }

  @Test
  void testExtractStatus_errorConversion_noError() {
    // test "OK", which corresponds to a "null" error.
    String successCode = metricsTracer.extractStatus(null);
    assertThat(successCode).isEqualTo(Code.OK.toString());
  }

  @Test
  void testExtractStatus_errorConversion_unknownException() {
    // test "UNKNOWN"
    Throwable unknownException = new RuntimeException();
    String errorCode2 = metricsTracer.extractStatus(unknownException);
    assertThat(errorCode2).isEqualTo(Code.UNKNOWN.toString());
  }
}
