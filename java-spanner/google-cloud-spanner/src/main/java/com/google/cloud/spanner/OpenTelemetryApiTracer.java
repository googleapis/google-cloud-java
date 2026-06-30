/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.base.Preconditions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * {@link com.google.api.gax.tracing.ApiTracer} for use with OpenTelemetry. Based on {@link
 * com.google.api.gax.tracing.OpencensusTracer}.
 */
class OpenTelemetryApiTracer implements ApiTracer {
  /** The attribute keys that are used by this tracer might change in a future release. */
  private final AttributeKey<Long> ATTEMPT_COUNT_KEY = AttributeKey.longKey("attempt.count");

  private final AttributeKey<Long> TOTAL_REQUEST_COUNT_KEY =
      AttributeKey.longKey("total_request_count");
  private final AttributeKey<Long> TOTAL_RESPONSE_COUNT_KEY =
      AttributeKey.longKey("total_response_count");
  private final AttributeKey<String> EXCEPTION_MESSAGE_KEY =
      AttributeKey.stringKey("exception.message");
  private final AttributeKey<Long> ATTEMPT_NUMBER_KEY = AttributeKey.longKey("attempt.number");
  private final AttributeKey<Long> ATTEMPT_REQUEST_COUNT_KEY =
      AttributeKey.longKey("attempt.request_count");
  private final AttributeKey<Long> ATTEMPT_RESPONSE_COUNT_KEY =
      AttributeKey.longKey("attempt.response_count");
  private final AttributeKey<String> CONNECTION_ID_KEY = AttributeKey.stringKey("connection");
  private final AttributeKey<Long> RETRY_DELAY_KEY = AttributeKey.longKey("delay_ms");
  private static final AttributeKey<Long> BATCH_SIZE_KEY = AttributeKey.longKey("batch.size");
  private static final AttributeKey<Long> BATCH_COUNT_KEY = AttributeKey.longKey("batch.count");

  private final Span span;
  private final OperationType operationType;

  private volatile String lastConnectionId;
  private volatile long currentAttemptId;
  private final AtomicLong attemptSentMessages = new AtomicLong(0);
  private long attemptReceivedMessages = 0;
  private final AtomicLong totalSentMessages = new AtomicLong(0);
  private long totalReceivedMessages = 0;

  OpenTelemetryApiTracer(@Nonnull Span span, @Nonnull OperationType operationType) {
    this.span = Preconditions.checkNotNull(span);
    this.operationType = Preconditions.checkNotNull(operationType);
  }

  Span getSpan() {
    return this.span;
  }

  @Override
  public Scope inScope() {
    final io.opentelemetry.context.Scope openTelemetryScope = span.makeCurrent();
    return openTelemetryScope::close;
  }

  @Override
  public void operationSucceeded() {
    span.setAllAttributes(baseOperationAttributes());
    span.setStatus(StatusCode.OK);
    span.end();
  }

  @Override
  public void operationCancelled() {
    span.setAllAttributes(baseOperationAttributes());
    span.setStatus(StatusCode.ERROR, "Cancelled by caller");
    span.end();
  }

  @Override
  public void operationFailed(Throwable error) {
    span.setAllAttributes(baseOperationAttributes());
    span.setStatus(StatusCode.ERROR, error.getMessage());
    span.end();
  }

  @Override
  public void lroStartFailed(Throwable error) {
    span.addEvent(
        "Operation failed to start", Attributes.of(EXCEPTION_MESSAGE_KEY, error.getMessage()));
    span.setStatus(StatusCode.ERROR, error.getMessage());
    span.end();
  }

  @Override
  public void lroStartSucceeded() {
    span.addEvent("Operation started");
  }

  @Override
  public void connectionSelected(String id) {
    lastConnectionId = id;
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    attemptStarted(null, attemptNumber);
  }

  @Override
  public void attemptStarted(@Nullable Object request, int attemptNumber) {
    currentAttemptId = attemptNumber;
    attemptSentMessages.set(0);
    attemptReceivedMessages = 0;

    // Attempts start counting a zero, so more than zero indicates a retry.
    if (attemptNumber > 0 && operationType != OperationType.LongRunning) {
      // Add an event if the RPC retries, as this is otherwise transparent to the user. Retries
      // would then show up as higher latency without any logical explanation.
      span.addEvent("Starting RPC retry " + attemptNumber);
    } else if (operationType == OperationType.LongRunning) {
      span.addEvent("Starting poll attempt " + attemptNumber);
    }
  }

  @Override
  public void attemptSucceeded() {
    Attributes attributes = baseAttemptAttributes();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addEvent("Polling completed", attributes);
    } else {
      span.addEvent("Attempt succeeded", attributes);
    }
  }

  @Override
  public void attemptCancelled() {
    Attributes attributes = baseAttemptAttributes();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addEvent("Polling was cancelled", attributes);
    } else {
      span.addEvent("Attempt cancelled", attributes);
    }
    lastConnectionId = null;
  }

  /** This method is obsolete. Use {@link #attemptFailedDuration(Throwable, Duration)} instead. */
  @Override
  @ObsoleteApi("Use attemptFailedDuration(Throwable, Duration) instead")
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    attemptFailedDuration(error, toJavaTimeDuration(delay));
  }

  @Override
  public void attemptFailedDuration(Throwable error, Duration delay) {
    AttributesBuilder builder = baseAttemptAttributesBuilder();
    if (delay != null) {
      builder.put(RETRY_DELAY_KEY, delay.toMillis());
    }
    if (error != null) {
      builder.put(EXCEPTION_MESSAGE_KEY, error.getMessage());
    }
    Attributes attributes = builder.build();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      // The poll RPC was successful, but it indicated that the operation is still running.
      span.addEvent("Scheduling next poll", attributes);
    } else {
      span.addEvent("Attempt failed, scheduling next attempt", attributes);
    }
    lastConnectionId = null;
  }

  @Override
  public void attemptFailedRetriesExhausted(@Nonnull Throwable error) {
    AttributesBuilder builder = baseAttemptAttributesBuilder();
    builder.put(EXCEPTION_MESSAGE_KEY, error.getMessage());
    Attributes attributes = builder.build();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addEvent("Polling attempts exhausted", attributes);
    } else {
      span.addEvent("Attempts exhausted", attributes);
    }
    lastConnectionId = null;
  }

  @Override
  public void attemptPermanentFailure(@Nonnull Throwable error) {
    AttributesBuilder builder = baseAttemptAttributesBuilder();
    builder.put(EXCEPTION_MESSAGE_KEY, error.getMessage());
    Attributes attributes = builder.build();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addEvent("Polling failed", attributes);
    } else {
      span.addEvent("Attempt failed, error not retryable", attributes);
    }
    lastConnectionId = null;
  }

  @Override
  public void responseReceived() {
    attemptReceivedMessages++;
    totalReceivedMessages++;
  }

  @Override
  public void requestSent() {
    attemptSentMessages.incrementAndGet();
    totalSentMessages.incrementAndGet();
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    span.setAllAttributes(
        Attributes.of(BATCH_COUNT_KEY, elementCount, BATCH_SIZE_KEY, requestSize));
  }

  private Attributes baseOperationAttributes() {
    AttributesBuilder builder = Attributes.builder();
    builder.put(ATTEMPT_COUNT_KEY, currentAttemptId + 1);
    long localTotalSentMessages = totalSentMessages.get();
    if (localTotalSentMessages > 0) {
      builder.put(TOTAL_REQUEST_COUNT_KEY, localTotalSentMessages);
    }
    if (totalReceivedMessages > 0) {
      builder.put(TOTAL_RESPONSE_COUNT_KEY, totalReceivedMessages);
    }
    return builder.build();
  }

  private Attributes baseAttemptAttributes() {
    return baseAttemptAttributesBuilder().build();
  }

  private AttributesBuilder baseAttemptAttributesBuilder() {
    AttributesBuilder builder = Attributes.builder();
    populateAttemptNumber(builder);

    long localAttemptSentMessages = attemptSentMessages.get();
    if (localAttemptSentMessages > 0) {
      builder.put(ATTEMPT_REQUEST_COUNT_KEY, localAttemptSentMessages);
    }
    if (attemptReceivedMessages > 0) {
      builder.put(ATTEMPT_RESPONSE_COUNT_KEY, attemptReceivedMessages);
    }
    String localLastConnectionId = lastConnectionId;
    if (localLastConnectionId != null) {
      builder.put(CONNECTION_ID_KEY, localLastConnectionId);
    }

    return builder;
  }

  private void populateAttemptNumber(AttributesBuilder builder) {
    builder.put(ATTEMPT_NUMBER_KEY, currentAttemptId);
  }
}
