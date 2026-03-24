/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerExceptionForCancellation;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.PartialResultSet;
import io.grpc.Context;
import io.opentelemetry.api.common.Attributes;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Wraps an iterator over partial result sets, supporting resuming RPCs on error. This class keeps
 * track of the most recent resume token seen, and will buffer partial result set chunks that do not
 * have a resume token until one is seen or buffer space is exceeded, which reduces the chance of
 * yielding data to the caller that cannot be resumed.
 */
@VisibleForTesting
abstract class ResumableStreamIterator extends AbstractIterator<PartialResultSet>
    implements CloseableIterator<PartialResultSet> {
  private static final RetrySettings DEFAULT_STREAMING_RETRY_SETTINGS =
      SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings();
  private final ErrorHandler errorHandler;
  private AsyncResultSet.StreamMessageListener streamMessageListener;
  private final RetrySettings streamingRetrySettings;
  private final Set<Code> retryableCodes;
  private static final Logger logger = Logger.getLogger(ResumableStreamIterator.class.getName());
  private BackOff backOff;
  private final LinkedList<PartialResultSet> buffer = new LinkedList<>();
  private final int maxBufferSize;
  private final ISpan span;
  private final TraceWrapper tracer;
  private CloseableIterator<PartialResultSet> stream;
  private int attempts;
  private ByteString resumeToken;
  private boolean finished;
  private final XGoogSpannerRequestId requestId;

  /**
   * Indicates whether it is currently safe to retry RPCs. This will be {@code false} if we have
   * reached the maximum buffer size without seeing a restart token; in this case, we will drain the
   * buffer and remain in this state until we see a new restart token.
   */
  private boolean safeToRetry = true;

  protected ResumableStreamIterator(
      int maxBufferSize,
      String streamName,
      ISpan parent,
      TraceWrapper tracer,
      ErrorHandler errorHandler,
      RetrySettings streamingRetrySettings,
      Set<Code> retryableCodes,
      XGoogSpannerRequestId.RequestIdCreator xGoogRequestIdCreator) {
    this(
        maxBufferSize,
        streamName,
        parent,
        tracer,
        Attributes.empty(),
        errorHandler,
        streamingRetrySettings,
        retryableCodes,
        xGoogRequestIdCreator);
  }

  protected ResumableStreamIterator(
      int maxBufferSize,
      String streamName,
      ISpan parent,
      TraceWrapper tracer,
      Attributes attributes,
      ErrorHandler errorHandler,
      RetrySettings streamingRetrySettings,
      Set<Code> retryableCodes,
      XGoogSpannerRequestId.RequestIdCreator xGoogRequestIdCreator) {
    checkArgument(maxBufferSize >= 0);
    this.maxBufferSize = maxBufferSize;
    this.tracer = tracer;
    this.span = tracer.spanBuilderWithExplicitParent(streamName, parent, attributes);
    this.errorHandler = errorHandler;
    this.streamingRetrySettings = Preconditions.checkNotNull(streamingRetrySettings);
    this.retryableCodes = Preconditions.checkNotNull(retryableCodes);
    // The channel is automatically updated by the gRPC client when the request is actually sent.
    this.requestId = xGoogRequestIdCreator.nextRequestId(0);
  }

  private ExponentialBackOff newBackOff() {
    if (Objects.equals(streamingRetrySettings, DEFAULT_STREAMING_RETRY_SETTINGS)) {
      return new ExponentialBackOff.Builder()
          .setMultiplier(streamingRetrySettings.getRetryDelayMultiplier())
          .setInitialIntervalMillis(
              Math.max(10, (int) streamingRetrySettings.getInitialRetryDelay().toMillis()))
          .setMaxIntervalMillis(
              Math.max(1000, (int) streamingRetrySettings.getMaxRetryDelay().toMillis()))
          .setMaxElapsedTimeMillis(Integer.MAX_VALUE) // Prevent Backoff.STOP from getting returned.
          .build();
    }
    return new ExponentialBackOff.Builder()
        .setMultiplier(streamingRetrySettings.getRetryDelayMultiplier())
        // All of these values must be > 0.
        .setInitialIntervalMillis(
            Math.max(
                1,
                (int)
                    Math.min(
                        streamingRetrySettings.getInitialRetryDelay().toMillis(),
                        Integer.MAX_VALUE)))
        .setMaxIntervalMillis(
            Math.max(
                1,
                (int)
                    Math.min(
                        streamingRetrySettings.getMaxRetryDelay().toMillis(), Integer.MAX_VALUE)))
        .setMaxElapsedTimeMillis(
            Math.max(
                1,
                (int)
                    Math.min(
                        streamingRetrySettings.getTotalTimeout().toMillis(), Integer.MAX_VALUE)))
        .build();
  }

  private void backoffSleep(Context context, BackOff backoff) throws SpannerException {
    backoffSleep(context, nextBackOffMillis(backoff));
  }

  private static long nextBackOffMillis(BackOff backoff) throws SpannerException {
    try {
      return backoff.nextBackOffMillis();
    } catch (IOException e) {
      throw newSpannerException(ErrorCode.INTERNAL, e.getMessage(), e);
    }
  }

  private void backoffSleep(Context context, long backoffMillis) throws SpannerException {
    tracer.getCurrentSpan().addAnnotation("Backing off", "Delay", backoffMillis);
    final CountDownLatch latch = new CountDownLatch(1);
    final Context.CancellationListener listener =
        ignored -> {
          // Wakeup on cancellation / DEADLINE_EXCEEDED.
          latch.countDown();
        };

    context.addListener(listener, DirectExecutor.INSTANCE);
    try {
      if (backoffMillis == BackOff.STOP) {
        // Highly unlikely but we handle it just in case.
        backoffMillis = streamingRetrySettings.getMaxRetryDelay().toMillis();
      }
      if (latch.await(backoffMillis, TimeUnit.MILLISECONDS)) {
        // Woken by context cancellation.
        throw newSpannerExceptionForCancellation(context, null);
      }
    } catch (InterruptedException interruptExcept) {
      throw newSpannerExceptionForCancellation(context, interruptExcept);
    } finally {
      context.removeListener(listener);
    }
  }

  private enum DirectExecutor implements Executor {
    INSTANCE;

    @Override
    public void execute(Runnable command) {
      command.run();
    }
  }

  abstract CloseableIterator<PartialResultSet> startStream(
      @Nullable ByteString resumeToken,
      AsyncResultSet.StreamMessageListener streamMessageListener,
      XGoogSpannerRequestId requestId);

  /**
   * Prepares the iterator for a retry on a different gRPC channel. Returns true if that is
   * possible, and false otherwise. A retry should only be attempted if the method returns true.
   */
  boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
    return false;
  }

  @Override
  public void close(@Nullable String message) {
    if (stream != null) {
      stream.close(message);
      span.end();
      stream = null;
    }
  }

  @Override
  public boolean isWithBeginTransaction() {
    return stream != null && stream.isWithBeginTransaction();
  }

  @Override
  public boolean isLastStatement() {
    return stream != null && stream.isLastStatement();
  }

  @Override
  @InternalApi
  public boolean initiateStreaming(AsyncResultSet.StreamMessageListener streamMessageListener) {
    this.streamMessageListener = streamMessageListener;
    startGrpcStreaming();
    return true;
  }

  @Override
  protected PartialResultSet computeNext() {
    int numAttemptsOnOtherChannel = 0;
    Context context = Context.current();
    while (true) {
      // Eagerly start stream before consuming any buffered items.
      startGrpcStreaming();
      // Buffer contains items up to a resume token or has reached capacity: flush.
      if (!buffer.isEmpty()
          && (finished || !safeToRetry || !buffer.getLast().getResumeToken().isEmpty())) {
        return buffer.pop();
      }
      try {
        if (stream.hasNext()) {
          PartialResultSet next = stream.next();
          boolean hasResumeToken = !next.getResumeToken().isEmpty();
          if (hasResumeToken) {
            resumeToken = next.getResumeToken();
            safeToRetry = true;
          }
          // If the buffer is empty and this chunk has a resume token or we cannot resume safely
          // anyway, we can yield it immediately rather than placing it in the buffer to be
          // returned on the next iteration.
          if ((hasResumeToken || !safeToRetry) && buffer.isEmpty()) {
            return next;
          }
          buffer.add(next);
          if (buffer.size() > maxBufferSize && buffer.getLast().getResumeToken().isEmpty()) {
            // We need to flush without a restart token.  Errors encountered until we see
            // such a token will fail the read.
            safeToRetry = false;
          }
        } else {
          finished = true;
          if (buffer.isEmpty()) {
            endOfData();
            return null;
          }
        }
      } catch (SpannerException spannerException) {
        if (safeToRetry && isRetryable(spannerException)) {
          span.addAnnotation("Stream broken. Safe to retry", spannerException);
          logger.log(Level.FINE, "Retryable exception, will sleep and retry", spannerException);
          // Truncate any items in the buffer before the last retry token.
          while (!buffer.isEmpty() && buffer.getLast().getResumeToken().isEmpty()) {
            buffer.removeLast();
          }
          assert buffer.isEmpty() || buffer.getLast().getResumeToken().equals(resumeToken);
          stream = null;
          try (IScope s = tracer.withSpan(span)) {
            long delay = spannerException.getRetryDelayInMillis();
            if (delay != -1) {
              backoffSleep(context, delay);
            } else {
              if (this.backOff == null) {
                this.backOff = newBackOff();
              }
              backoffSleep(context, this.backOff);
            }
          }

          continue;
        }
        // Check if we should retry the request on a different gRPC channel.
        if (resumeToken == null && buffer.isEmpty()) {
          Throwable translated = errorHandler.translateException(spannerException);
          if (translated instanceof RetryOnDifferentGrpcChannelException) {
            if (++numAttemptsOnOtherChannel < errorHandler.getMaxAttempts()
                && prepareIteratorForRetryOnDifferentGrpcChannel()) {
              stream = null;
              continue;
            }
          }
        }
        span.addAnnotation("Stream broken. Not safe to retry", spannerException);
        span.setStatus(spannerException);
        throw spannerException;
      } catch (RuntimeException e) {
        span.addAnnotation("Stream broken. Not safe to retry", e);
        span.setStatus(e);
        throw e;
      }
    }
  }

  private void startGrpcStreaming() {
    if (stream == null) {
      span.addAnnotation(
          "Starting/Resuming stream",
          "ResumeToken",
          resumeToken == null ? "null" : resumeToken.toStringUtf8());
      try (IScope scope = tracer.withSpan(span)) {
        // When start a new stream set the Span as current to make the gRPC Span a child of
        // this Span.
        stream = checkNotNull(startStream(resumeToken, streamMessageListener, requestId));
        stream.requestPrefetchChunks();
      }
    }
  }

  boolean isRetryable(SpannerException spannerException) {
    return spannerException.isRetryable()
        || retryableCodes.contains(
            GrpcStatusCode.of(spannerException.getErrorCode().getGrpcStatusCode()).getCode());
  }
}
