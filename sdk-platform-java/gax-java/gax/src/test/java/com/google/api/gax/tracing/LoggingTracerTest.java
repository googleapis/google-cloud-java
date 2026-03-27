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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.logging.TestLogger;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

class LoggingTracerTest {

  private TestLogger testLogger;

  @BeforeEach
  void setUp() {
    testLogger = (TestLogger) LoggerFactory.getLogger(LoggingTracer.class);
    testLogger.getMessageList().clear();
    testLogger.getMDCMap().clear();
    testLogger.getKeyValuePairsMap().clear();
  }

  @Test
  void testAttemptFailedDuration_LogsError() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error = new RuntimeException("generic failure duration");
    tracer.attemptFailedDuration(error, java.time.Duration.ZERO);

    assertEquals(1, testLogger.getMessageList().size());
    assertEquals("generic failure duration", testLogger.getMessageList().get(0));
  }

  @Test
  void testAttemptFailedRetriesExhausted_LogsError() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error = new RuntimeException("generic failure retries exhausted");
    tracer.attemptFailedRetriesExhausted(error);

    assertEquals(1, testLogger.getMessageList().size());
    assertEquals("generic failure retries exhausted", testLogger.getMessageList().get(0));
  }

  @Test
  void testAttemptPermanentFailure_LogsError() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error = new RuntimeException("generic permanent failure");
    tracer.attemptPermanentFailure(error);

    assertEquals(1, testLogger.getMessageList().size());
    assertEquals("generic permanent failure", testLogger.getMessageList().get(0));
  }

  @Test
  void testRecordActionableError_logsErrorMessage() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error = new RuntimeException("test error message");
    tracer.recordActionableError(error);

    assertEquals(1, testLogger.getMessageList().size());
    assertEquals("test error message", testLogger.getMessageList().get(0));
  }

  @Test
  void testRecordActionableError_logsStatus() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error =
        ApiExceptionFactory.createException(
            "test error message",
            new RuntimeException("cause"),
            FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT),
            false);

    tracer.recordActionableError(error);

    Map<String, ?> attributesMap = getAttributesMap();

    assertTrue(attributesMap != null && !attributesMap.isEmpty());
    assertEquals(
        "INVALID_ARGUMENT",
        attributesMap.get(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE));
  }

  @Test
  void testRecordActionableError_logsAttributes() {
    ApiTracerContext context =
        ApiTracerContext.empty().toBuilder().setServiceName("test-service").build();
    LoggingTracer tracer = new LoggingTracer(context);

    Exception error = new RuntimeException("generic failure");
    tracer.recordActionableError(error);

    Map<String, ?> attributesMap = getAttributesMap();

    assertTrue(attributesMap != null && !attributesMap.isEmpty());
    assertEquals(
        "test-service", attributesMap.get(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE));
  }

  @Test
  void testRecordActionableError_logsErrorInfo() {
    ApiTracerContext context = ApiTracerContext.empty();
    LoggingTracer tracer = new LoggingTracer(context);

    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setReason("TEST_REASON")
            .setDomain("test.domain.com")
            .putMetadata("test_key", "test_value")
            .build();

    ErrorDetails errorDetails =
        ErrorDetails.builder()
            .setRawErrorMessages(Collections.singletonList(Any.pack(errorInfo)))
            .build();

    Exception error =
        ApiExceptionFactory.createException(
            "test error message",
            new RuntimeException("cause"),
            FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT),
            false,
            errorDetails);

    tracer.recordActionableError(error);

    Map<String, ?> attributesMap = getAttributesMap();

    assertTrue(attributesMap != null && !attributesMap.isEmpty());
    assertEquals("TEST_REASON", attributesMap.get(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE));
    assertEquals(
        "test.domain.com", attributesMap.get(ObservabilityAttributes.ERROR_DOMAIN_ATTRIBUTE));
    assertEquals(
        "test_value",
        attributesMap.get(ObservabilityAttributes.ERROR_METADATA_ATTRIBUTE_PREFIX + "test_key"));
  }

  private Map<String, ?> getAttributesMap() {
    if (!testLogger.getMDCMap().isEmpty()) {
      return testLogger.getMDCMap();
    } else {
      return testLogger.getKeyValuePairsMap();
    }
  }
}
