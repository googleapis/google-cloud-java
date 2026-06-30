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

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Status.CanonicalCode;
import io.opencensus.trace.Tracer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nonnull;

/**
 * Implementation of {@link ApiTracer} that uses OpenCensus.
 *
 * <p>This implementation wraps an OpenCensus {@link Span} for every tracer and annotates that
 * {@link Span} with various events throughout the lifecycle of the logical operation.
 *
 * <p>Each span will be named {@code ClientName.MethodName} and will have the following attributes:
 *
 * <dl>
 *   <dt>{@code attempt count}
 *   <dd>The Number of attempts sent before the logical operation completed
 *   <dt>{@code status}
 *   <dd>The status code of the last attempt
 *   <dt>{@code total response count}
 *   <dd>The number of messages received across all of the attempts. This will only be set for
 *       server streaming and bidi RPCs.
 *   <dt>{@code total request count}
 *   <dd>The number of messages sent across all of the attempts. This will only be set for client
 *       streaming and bidi RPCs.
 *   <dt>{@code batch count}
 *   <dd>For batch requests, the number of elements in the request.
 *   <dt>{@code batch size}
 *   <dd>For batch requests, the byte size of the request.
 * </dl>
 *
 * <p>The spans will contain the following annotations:
 *
 * <ul>
 *   <li>{@code Attempt cancelled} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential attempt number
 *         <dt>{@code attempt request count}
 *         <dd>The number of requests sent in this attempt. This will only be set for client
 *             streaming and bidi RPCs.
 *         <dt>{@code attempt response count}
 *         <dd>The number of responses received in this attempt. This will only be set for server
 *             streaming and bidi RPCs.
 *         <dt>{@code connection}
 *         <dd>The UUID of the connection which the attempt was sent.
 *       </dl>
 *   <li>{@code Attempt failed, scheduling next attempt} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential attempt number
 *         <dt>{@code status}
 *         <dd>The status code of the failed attempt
 *         <dt>{@code delay}
 *         <dd>The number of milliseconds to wait before trying again
 *         <dt>{@code attempt request count}
 *         <dd>The number of requests sent in this attempt. This will only be set for client
 *             streaming and bidi RPCs.
 *         <dt>{@code attempt response count}
 *         <dd>The number of responses received in this attempt. This will only be set for server
 *             streaming and bidi RPCs.
 *         <dt>{@code connection}
 *         <dd>The UUID of the connection which the attempt was sent.
 *       </dl>
 *   <li>{@code Attempts exhausted} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential attempt number
 *         <dt>{@code status}
 *         <dd>The status code of the failed attempt
 *         <dt>{@code attempt request count}
 *         <dd>The number of requests sent in this attempt. This will only be set for client
 *             streaming and bidi RPCs.
 *         <dt>{@code attempt response count}
 *         <dd>The number of responses received in this attempt. This will only be set for server
 *             streaming and bidi RPCs.
 *         <dt>{@code connection}
 *         <dd>The UUID of the connection which the attempt was sent.
 *       </dl>
 *   <li>{@code Attempt failed, error not retryable} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential attempt number
 *         <dt>{@code status}
 *         <dd>The status code of the failed attempt
 *         <dt>{@code attempt request count}
 *         <dd>The number of requests sent in this attempt. This will only be set for client
 *             streaming and bidi RPCs.
 *         <dt>{@code attempt response count}
 *         <dd>The number of responses received in this attempt. This will only be set for server
 *             streaming and bidi RPCs.
 *         <dt>{@code connection}
 *         <dd>The UUID of the connection which the attempt was sent.
 *       </dl>
 *   <li>{@code Attempt succeeded} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential attempt number
 *         <dt>{@code attempt request count}
 *         <dd>The number of requests sent in this attempt. This will only be set for client
 *             streaming and bidi RPCs.
 *         <dt>{@code attempt response count}
 *         <dd>The number of responses received in this attempt. This will only be set for server
 *             streaming and bidi RPCs.
 *         <dt>{@code connection}
 *         <dd>The UUID of the connection which the attempt was sent.
 *       </dl>
 * </ul>
 *
 * <p>Long running operations, which are composed of an initial RPC to start the operation and a
 * number of polling RPCs will be represented as a tree of spans. The top level span will be named
 * after the initial RPC name suffixed with "Operation" and will have the following annotations:
 *
 * <ul>
 *   <li>{@code Operation started}
 *   <li>{@code Operation failed to start} with the following attributes:
 *       <dl>
 *         <dt>{@code status}
 *         <dd>The status code of why the operation failed to start
 *       </dl>
 *   <li>{@code Polling was cancelled} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential poll number.
 *         <dt>{@code attempt request count}
 *       </dl>
 *   <li>{@code Scheduling next poll} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential poll number
 *         <dt>{@code status}
 *         <dd>OK if the poll succeeded, but the operation is still running.
 *         <dt>{@code delay}
 *         <dd>The number of milliseconds to wait before polling again
 *       </dl>
 *   <li>{@code Polling attempts exhausted} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential poll number
 *         <dt>{@code status}
 *         <dd>OK if the poll succeeded, but the operation is still running.
 *       </dl>
 *   <li>{@code Polling failed} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential poll number
 *         <dt>{@code status}
 *         <dd>OK if the poll succeeded, but the operation is still running.
 *       </dl>
 *   <li>{@code Polling completed} with the following attributes:
 *       <dl>
 *         <dt>{@code attempt}
 *         <dd>Zero based sequential poll number
 *       </dl>
 * </ul>
 *
 * <p>The toplevel long running operation span will also contain child spans to describe the retry
 * attempts for the initial RPC and each poll as described in the general span section above.
 *
 * <p>This class is thread compatible. It expects callers to follow grpc's threading model: there is
 * only one thread that invokes the operation* and attempt* methods. Please see {@link
 * com.google.api.gax.rpc.ApiStreamObserver} for more information.
 */
@BetaApi("Surface for tracing is not yet stable")
public class OpencensusTracer extends BaseApiTracer {
  private final Tracer tracer;
  private final Span span;
  private final OperationType operationType;

  private volatile String lastConnectionId;
  private volatile long currentAttemptId;
  private AtomicLong attemptSentMessages = new AtomicLong(0);
  private long attemptReceivedMessages = 0;
  private AtomicLong totalSentMessages = new AtomicLong(0);
  private long totalReceivedMessages = 0;

  OpencensusTracer(
      @Nonnull Tracer tracer, @Nonnull Span span, @Nonnull OperationType operationType) {
    this.tracer = Preconditions.checkNotNull(tracer, "tracer can't be null");
    this.span = Preconditions.checkNotNull(span, "span can't be null");
    this.operationType = Preconditions.checkNotNull(operationType, "operationType can't be null");
  }

  Span getSpan() {
    return span;
  }

  /** {@inheritDoc} */
  @Override
  public Scope inScope() {
    // Suppressing to make MustBeClosedChecker happy. The scope will be closed but indirectly
    // (inside new Scope()), and the checker cannot recognize it.
    @SuppressWarnings("MustBeClosedChecker")
    final io.opencensus.common.Scope scope = tracer.withSpan(span);

    return new Scope() {
      @Override
      public void close() {
        scope.close();
      }
    };
  }

  /** {@inheritDoc} */
  @Override
  public void operationSucceeded() {
    Map<String, AttributeValue> attributes = baseOperationAttributes();

    span.putAttributes(attributes);
    span.end();
  }

  /** {@inheritDoc} */
  @Override
  public void operationCancelled() {
    Map<String, AttributeValue> attributes = baseOperationAttributes();
    span.putAttributes(attributes);
    span.end(
        EndSpanOptions.builder()
            .setStatus(Status.CANCELLED.withDescription("Cancelled by caller"))
            .build());
  }

  /** {@inheritDoc} */
  @Override
  public void operationFailed(Throwable error) {
    Map<String, AttributeValue> attributes = baseOperationAttributes();

    span.putAttributes(attributes);
    span.end(EndSpanOptions.builder().setStatus(convertErrorToStatus(error)).build());
  }

  /** {@inheritDoc} */
  @Override
  public void lroStartFailed(Throwable error) {
    Map<String, AttributeValue> attributes = new HashMap<>();
    populateError(attributes, error);

    span.addAnnotation("Operation failed to start", attributes);
  }

  /** {@inheritDoc} */
  @Override
  public void lroStartSucceeded() {
    span.addAnnotation("Operation started");
  }

  /** {@inheritDoc} */
  @Override
  public void connectionSelected(String id) {
    lastConnectionId = id;
  }

  /** {@inheritDoc} */
  @Override
  public void attemptStarted(int attemptNumber) {
    currentAttemptId = attemptNumber;
    attemptSentMessages.set(0);
    attemptReceivedMessages = 0;

    // NOTE: no annotations are added because they don't provide any semantic value.
    // This simply is used for state management.
  }

  /** {@inheritDoc} */
  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    attemptStarted(attemptNumber);
  }

  /** {@inheritDoc} */
  @Override
  public void attemptSucceeded() {
    Map<String, AttributeValue> attributes = baseAttemptAttributes();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addAnnotation("Polling completed", attributes);
    } else {
      span.addAnnotation("Attempt succeeded", attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void attemptCancelled() {
    Map<String, AttributeValue> attributes = baseAttemptAttributes();

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addAnnotation("Polling was cancelled", attributes);
    } else {
      span.addAnnotation("Attempt cancelled", attributes);
    }
    lastConnectionId = null;
  }

  /** {@inheritDoc} */
  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    Map<String, AttributeValue> attributes = baseAttemptAttributes();
    attributes.put("delay ms", AttributeValue.longAttributeValue(delay.toMillis()));
    populateError(attributes, error);

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      // The poll RPC was successful, but it indicated that the operation is still running.
      span.addAnnotation("Scheduling next poll", attributes);
    } else {
      span.addAnnotation("Attempt failed, scheduling next attempt", attributes);
    }
    lastConnectionId = null;
  }

  /**
   * This method is obsolete. Use {@link #attemptFailedDuration(Throwable, java.time.Duration)}
   * instead.
   */
  @Override
  @ObsoleteApi("Use attemptFailedDuration(Throwable, java.time.Duration) instead")
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    attemptFailedDuration(error, toJavaTimeDuration(delay));
  }

  /** {@inheritDoc} */
  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    Map<String, AttributeValue> attributes = baseAttemptAttributes();
    populateError(attributes, error);

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addAnnotation("Polling attempts exhausted", attributes);
    } else {
      span.addAnnotation("Attempts exhausted", attributes);
    }
    lastConnectionId = null;
  }

  /** {@inheritDoc} */
  @Override
  public void attemptPermanentFailure(Throwable error) {
    Map<String, AttributeValue> attributes = baseAttemptAttributes();
    populateError(attributes, error);

    // Same infrastructure is used for both polling and retries, so need to disambiguate it here.
    if (operationType == OperationType.LongRunning) {
      span.addAnnotation("Polling failed", attributes);
    } else {
      span.addAnnotation("Attempt failed, error not retryable", attributes);
    }
    lastConnectionId = null;
  }

  /** {@inheritDoc} */
  @Override
  public void responseReceived() {
    attemptReceivedMessages++;
    totalReceivedMessages++;
  }

  /** {@inheritDoc} */
  @Override
  public void requestSent() {
    attemptSentMessages.incrementAndGet();
    totalSentMessages.incrementAndGet();
  }

  /** {@inheritDoc} */
  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    span.putAttribute("batch count", AttributeValue.longAttributeValue(elementCount));
    span.putAttribute("batch size", AttributeValue.longAttributeValue(requestSize));
  }

  private Map<String, AttributeValue> baseOperationAttributes() {
    HashMap<String, AttributeValue> attributes = new HashMap<>();

    attributes.put("attempt count", AttributeValue.longAttributeValue(currentAttemptId + 1));

    long localTotalSentMessages = totalSentMessages.get();
    if (localTotalSentMessages > 0) {
      attributes.put(
          "total request count", AttributeValue.longAttributeValue(localTotalSentMessages));
    }
    if (totalReceivedMessages > 0) {
      attributes.put(
          "total response count", AttributeValue.longAttributeValue(totalReceivedMessages));
    }

    return attributes;
  }

  private Map<String, AttributeValue> baseAttemptAttributes() {
    HashMap<String, AttributeValue> attributes = new HashMap<>();

    populateAttemptNumber(attributes);

    long localAttemptSentMessages = attemptSentMessages.get();
    if (localAttemptSentMessages > 0) {
      attributes.put(
          "attempt request count", AttributeValue.longAttributeValue(localAttemptSentMessages));
    }
    if (attemptReceivedMessages > 0) {
      attributes.put(
          "attempt response count", AttributeValue.longAttributeValue(attemptReceivedMessages));
    }

    String localLastConnectionId = lastConnectionId;
    if (localLastConnectionId != null) {
      attributes.put("connection", AttributeValue.stringAttributeValue(localLastConnectionId));
    }

    return attributes;
  }

  private void populateAttemptNumber(Map<String, AttributeValue> attributes) {
    attributes.put("attempt", AttributeValue.longAttributeValue(currentAttemptId));
  }

  private void populateError(Map<String, AttributeValue> attributes, Throwable error) {
    if (error == null) {
      attributes.put("status", AttributeValue.stringAttributeValue("OK"));
      return;
    }

    Status status = convertErrorToStatus(error);

    attributes.put(
        "status", AttributeValue.stringAttributeValue(status.getCanonicalCode().toString()));

    if (!Strings.isNullOrEmpty(status.getDescription())) {
      attributes.put(
          "status message", AttributeValue.stringAttributeValue(status.getDescription()));
    }
  }

  @InternalApi("Visible for testing")
  static Status convertErrorToStatus(Throwable error) {
    StatusCode.Code gaxCode = Code.UNKNOWN;

    if (error instanceof ApiException) {
      gaxCode = ((ApiException) error).getStatusCode().getCode();
    } else if (error.getCause() instanceof ApiException) {
      gaxCode = ((ApiException) error.getCause()).getStatusCode().getCode();
    }

    Status.CanonicalCode code;
    try {
      code = Status.CanonicalCode.valueOf(gaxCode.name());
    } catch (IllegalArgumentException e) {
      code = CanonicalCode.UNKNOWN;
    }

    return code.toStatus().withDescription(error.getMessage());
  }
}
