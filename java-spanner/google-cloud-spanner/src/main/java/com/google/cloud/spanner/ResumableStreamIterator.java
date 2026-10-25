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
import com.google.cloud.spanner.AsyncResultSet.StreamMessageListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.PartialResultSet;
import io.grpc.Context;
import io.opentelemetry.api.common.Attributes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Wraps an iterator over partial result sets, supporting resuming RPCs on error. This class keeps
 * track of the most recent resume token seen, and will buffer partial result set chunks that do not
 * have a resume token until one is seen or buffer space is exceeded, which reduces the chance of
 * yielding data to the caller that cannot be resumed.
 *
 * <p>The resume loop is bounded by the streaming retry settings: consecutive failed attempts are
 * limited by {@link RetrySettings#getMaxAttempts()} if that has been set to a value greater than
 * zero, and the total time spent on a sequence of consecutive failed attempts is limited by {@link
 * RetrySettings#getTotalTimeout()} if that has been set to a positive value. Only consecutive
 * failures count against these budgets: any progress on the stream (that is, receiving a resume
 * token that differs from the last seen resume token) resets both, so a long-running stream that
 * regularly makes progress is not terminated by an occasional transient error. The default settings
 * have no maximum number of attempts or total timeout. Setting maxAttempts to 1 disables streaming
 * retries.
 *
 * <p>These limits bound the number of streams that this iterator starts. Each (re)started stream is
 * a call through the underlying GAX callable, and GAX applies the same {@link RetrySettings} to
 * attempts of that call that fail before any response has been received. A stream that repeatedly
 * fails before its first response can therefore consist of up to maxAttempts RPC attempts itself,
 * so a configured maxAttempts of N bounds the total number of RPC attempts without progress by N*N,
 * not by N. The total timeout is measured in wall-clock time from the first failure of the sequence
 * and therefore spans both layers.
 *
 * <p><strong>Threading Contract:</strong> This iterator follows a single-consumer model.
 * Invocations of {@link #hasNext()}, {@link #next()}, {@link #computeNext()}, {@link
 * #isDataAvailable()}, and {@link #canPollWithoutErrorOrBlocking()} must be serialized by the
 * caller on a single thread. Concurrency is supported for {@link #close(String)} and listener
 * registration, but simultaneous consumption or polling from multiple threads is not supported.
 * Invoking {@link #close(String)} while the consumer thread is blocked in {@link #next()} cancels
 * the underlying stream and causes {@link #computeNext()} to return end-of-data rather than
 * propagating the resulting {@code CANCELLED} stream error.
 */
@NullMarked
@VisibleForTesting
abstract class ResumableStreamIterator extends AbstractIterator<PartialResultSet>
    implements CloseableIterator<PartialResultSet> {
  private final ErrorHandler errorHandler;
  @Nullable private volatile StreamMessageListener streamMessageListener;
  private final RetrySettings streamingRetrySettings;
  private final Set<Code> retryableCodes;
  private static final Logger logger = Logger.getLogger(ResumableStreamIterator.class.getName());
  @Nullable private BackOff backOff;
  private final ArrayDeque<PartialResultSet> buffer = new ArrayDeque<>();
  private final int maxBufferSize;
  private final ISpan span;
  private final TraceWrapper tracer;

  /** Guards state transitions between {@link #stream} and {@link #closed}. */
  private final Object streamLock = new Object();

  /** Indicates whether this iterator has been closed. */
  private volatile boolean closed;

  @Nullable private String closeMessage;
  private volatile boolean withBeginTransaction;
  private volatile boolean lastStatement;

  /** Ensures the tracing span is finalized at most once. */
  private final AtomicBoolean spanEnded = new AtomicBoolean(false);

  @Nullable private volatile CloseableIterator<PartialResultSet> stream;
  @Nullable private CloseableIterator<PartialResultSet> inFlightStream;
  @Nullable private volatile Throwable startFailure;
  private boolean startingStream;

  /**
   * The number of consecutive failed attempts without any progress on the stream. Reset to zero
   * every time the stream returns a new resume token.
   */
  private int attempts;

  /**
   * The value of {@link System#nanoTime()} at the first failure of the current sequence of
   * consecutive failed attempts. Only meaningful when {@link #attempts} is nonzero. Used to enforce
   * {@link RetrySettings#getTotalTimeout()} when a positive timeout is configured.
   */
  private long retrySequenceStartNanos = -1L;

  @Nullable private volatile ByteString resumeToken;
  private volatile boolean finished;
  private final XGoogSpannerRequestId requestId;

  /**
   * Indicates whether it is currently safe to retry RPCs. This will be {@code false} if we have
   * reached the maximum buffer size without seeing a restart token; in this case, we will drain the
   * buffer and remain in this state until we see a new restart token.
   */
  private volatile boolean safeToRetry = true;

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

  /**
   * Returns true if the number of consecutive failed attempts has reached the maximum number of
   * attempts in the retry settings. {@link RetrySettings#getMaxAttempts()} equal to zero means that
   * no maximum has been set, and that the number of attempts is unlimited. This is also the value
   * in the default streaming retry settings, which means that only users who have explicitly opted
   * in to a maximum number of attempts are affected by this limit.
   */
  private boolean maxAttemptsExhausted() {
    int maxAttempts = streamingRetrySettings.getMaxAttempts();
    return maxAttempts > 0 && attempts >= maxAttempts;
  }

  /**
   * Returns true if retrying after the proposed delay would exceed the total timeout in the retry
   * settings. The total timeout limits the wall-clock time that is spent on a sequence of
   * consecutive failed attempts without progress, measured from the first failure of the sequence.
   * It is only enforced for retry settings that set a positive total timeout: a total timeout of
   * zero means that no total timeout has been set, and that only maxAttempts (if set) limits the
   * retries. This mirrors the interpretation of these values in GAX.
   */
  private boolean totalTimeoutExceeded(long proposedDelayMillis) {
    long totalTimeoutMillis = streamingRetrySettings.getTotalTimeout().toMillis();
    if (totalTimeoutMillis <= 0L) {
      return false;
    }
    long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(nanoTime() - retrySequenceStartNanos);
    if (elapsedMillis < 0L) {
      elapsedMillis = 0L;
    }
    if (elapsedMillis >= totalTimeoutMillis) {
      return true;
    }
    return Math.max(proposedDelayMillis, 0L) >= totalTimeoutMillis - elapsedMillis;
  }

  private ExponentialBackOff newBackOff() {
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
        // The total timeout is enforced explicitly in computeNext(), based on the elapsed time
        // since the first failure of the current retry sequence. Prevent the backoff from
        // returning BackOff.STOP, as that would misinterpret a total timeout of zero (that is, no
        // total timeout) as a total timeout of one millisecond.
        .setMaxElapsedTimeMillis(Integer.MAX_VALUE)
        .build();
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

  /**
   * Starts a new underlying gRPC stream. Implementations SHOULD invoke {@link
   * #setStream(CloseableIterator)} with the created stream iterator before initiating the network
   * RPC so that in-flight RPCs can be cancelled immediately if {@link #close(String)} is invoked
   * before {@code startStream()} returns. Streams that are not registered early are registered
   * (and, if this iterator was closed in the meantime, closed) as soon as this method returns.
   */
  abstract CloseableIterator<PartialResultSet> startStream(
      @Nullable ByteString resumeToken,
      @Nullable StreamMessageListener streamMessageListener,
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
    // Closing while another thread is blocked in next() makes computeNext() return end-of-data
    // (via its closed checks) instead of surfacing the CANCELLED error reported by the cancelled
    // underlying stream.
    CloseableIterator<PartialResultSet> streamToClose = null;
    synchronized (streamLock) {
      if (!closed) {
        closed = true;
        closeMessage = message;
        streamToClose = this.stream != null ? this.stream : this.inFlightStream;
        // Leave inFlightStream set until startGrpcStreaming() finishes so the post-startStream()
        // setStream(streamIterator) check sees inFlightStream == streamToRegister and does not
        // close streamIterator a second time.
        this.stream = null;
        streamLock.notifyAll();
      }
    }
    synchronized (buffer) {
      buffer.clear();
    }
    // Perform stream teardown outside the lock to prevent deadlocks with external callbacks.
    if (streamToClose != null) {
      streamToClose.close(message);
    }
    endSpanOnce();
  }

  @VisibleForTesting
  boolean isClosed() {
    return closed;
  }

  @Override
  public boolean isWithBeginTransaction() {
    CloseableIterator<PartialResultSet> currentInFlightStream;
    boolean fallbackWithBeginTransaction;
    synchronized (streamLock) {
      currentInFlightStream = this.inFlightStream;
      fallbackWithBeginTransaction = this.withBeginTransaction;
    }
    // A subclass that registers its stream early calls setStream(consumer) before
    // consumer.setCall(call, true) sets withBeginTransaction on the underlying stream. Querying
    // currentInFlightStream live ensures callers observe true as soon as setCall() runs during an
    // in-flight startStream().
    return currentInFlightStream != null
        ? currentInFlightStream.isWithBeginTransaction()
        : fallbackWithBeginTransaction;
  }

  @Override
  public boolean isLastStatement() {
    return this.lastStatement;
  }

  @Override
  @InternalApi
  public boolean initiateStreaming(StreamMessageListener streamMessageListener) {
    synchronized (streamLock) {
      if (closed) {
        return false;
      }
      this.streamMessageListener = streamMessageListener;
    }
    startGrpcStreaming();
    return true;
  }

  @Override
  public boolean canPollWithoutErrorOrBlocking() {
    synchronized (buffer) {
      if (closed) {
        return false;
      }
      if (isBufferFlushableLocked() || finished) {
        return true;
      }
    }
    drainAvailableFromStream(this.stream);
    synchronized (buffer) {
      return !closed && (isBufferFlushableLocked() || finished);
    }
  }

  @Override
  public boolean isDataAvailable() {
    // If closed, return true to unblock any waiting async consumer so it can observe EOF/closure
    // instead of hanging indefinitely.
    // This loop is bounded: an iteration only loops when currentStream has a non-error chunk or EOF
    // ready to poll, and the next iteration's canPollWithoutErrorOrBlocking() call drains that into
    // buffer until either buffer becomes flushable (at most maxBufferSize + 1 chunks) or
    // currentStream has nothing more that is immediately available.
    while (true) {
      if (closed || canPollWithoutErrorOrBlocking()) {
        return true;
      }
      CloseableIterator<PartialResultSet> currentStream = this.stream;
      if (currentStream == null || !currentStream.isDataAvailable()) {
        return closed || startFailure != null;
      }
      if (!currentStream.canPollWithoutErrorOrBlocking()) {
        return true;
      }
    }
  }

  @Override
  @Nullable
  protected PartialResultSet computeNext() {
    int numAttemptsOnOtherChannel = 0;
    Context context = Context.current();
    while (!closed) {
      // Eagerly start stream before consuming any buffered items.
      startGrpcStreaming();
      // Buffer contains items up to a resume token or has reached capacity: flush.
      PartialResultSet buffered = pollBufferedChunk();
      if (buffered != null) {
        return buffered;
      }
      if (finished) {
        break;
      }
      // Snapshot the volatile stream reference to guard against concurrent close() nulling the
      // field between check and dereference.
      CloseableIterator<PartialResultSet> currentStream = this.stream;
      if (currentStream == null) {
        break;
      }
      try {
        readNextFromStreamIntoBuffer(currentStream);
      } catch (SpannerException spannerException) {
        if (safeToRetry && isRetryable(spannerException)) {
          try {
            handleRetryableException(context, spannerException);
            continue;
          } catch (Throwable throwable) {
            span.setStatus(throwable);
            endSpanOnce();
            throw throwable;
          }
        }
        // Check if we should retry the request on a different gRPC channel.
        if (shouldRetryOnDifferentChannel(spannerException, ++numAttemptsOnOtherChannel)) {
          resetStream();
          continue;
        }
        recordFailure(spannerException);
        throw spannerException;
      } catch (RuntimeException | Error throwable) {
        recordFailure(throwable);
        throw throwable;
      }
    }
    endOfData();
    return null;
  }

  /** Monotonic time source, overridable for deterministic retry-budget tests. */
  @VisibleForTesting
  long nanoTime() {
    return System.nanoTime();
  }

  @VisibleForTesting
  long checkRetryBudgetAndGetDelay(SpannerException spannerException) {
    if (attempts == 0) {
      retrySequenceStartNanos = nanoTime();
    }
    attempts++;
    if (maxAttemptsExhausted()) {
      span.addAnnotation(
          "Stream broken. Not retrying because the maximum number of attempts has been"
              + " exhausted",
          spannerException);
      throw spannerException;
    }
    // Determine the retry delay: either the delay that the server included in the error, or
    // otherwise a delay determined by the exponential backoff.
    long delayMillis = spannerException.getRetryDelayInMillis();
    if (delayMillis == -1L) {
      if (this.backOff == null) {
        this.backOff = newBackOff();
      }
      delayMillis = nextBackOffMillis(this.backOff);
    }
    // The total timeout budget applies regardless of whether the delay came from the server
    // or from the backoff.
    if (totalTimeoutExceeded(delayMillis)) {
      span.addAnnotation(
          "Stream broken. Not retrying because the total timeout has been exhausted",
          spannerException);
      throw spannerException;
    }
    return delayMillis;
  }

  private void handleRetryableException(Context context, SpannerException spannerException) {
    long delayMillis = checkRetryBudgetAndGetDelay(spannerException);
    span.addAnnotation("Stream broken. Safe to retry", spannerException);
    logger.log(Level.FINE, "Retryable exception, will sleep and retry", spannerException);
    // Discard any uncommitted chunks in the buffer (they will be replayed from resumeToken).
    synchronized (buffer) {
      buffer.clear();
    }
    resetStream();
    try (IScope scope = tracer.withSpan(span)) {
      backoffSleep(context, delayMillis);
    }
  }

  /**
   * Lazily starts the underlying gRPC stream if streaming has not already been initiated and the
   * iterator has not been closed. Concurrent callers (for example, when {@link
   * #initiateStreaming(StreamMessageListener)} triggers an asynchronous {@code onStreamMessage}
   * callback before {@code startGrpcStreaming()} returns) wait for the in-flight startup to finish
   * rather than starting a second stream or consuming an uninitialized stream.
   */
  private void startGrpcStreaming() {
    // Fast path: lock-free check when stream is already running.
    if (stream != null) {
      return;
    }
    synchronized (streamLock) {
      while (startingStream && !closed) {
        try {
          streamLock.wait();
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
          throw newSpannerExceptionForCancellation(Context.current(), interruptedException);
        }
      }
      if (stream != null || closed) {
        return;
      }
      if (startFailure instanceof Error) {
        throw (Error) startFailure;
      }
      if (startFailure != null) {
        throw (RuntimeException) startFailure;
      }
      startingStream = true;
    }
    CloseableIterator<PartialResultSet> streamIterator;
    try {
      span.addAnnotation(
          "Starting/Resuming stream",
          "ResumeToken",
          resumeToken == null ? "null" : resumeToken.toStringUtf8());
      try (IScope scope = tracer.withSpan(span)) {
        // When start a new stream set the Span as current to make the gRPC Span a child of
        // this Span.
        streamIterator = checkNotNull(startStream(resumeToken, streamMessageListener, requestId));
        if (setStream(streamIterator)) {
          streamIterator.requestPrefetchChunks();
        }
      }
    } catch (RuntimeException | Error throwable) {
      resetStreamOnFailure(throwable);
      recordFailure(throwable);
      throw throwable;
    }
    publishStartedStream(streamIterator);
  }

  boolean isRetryable(SpannerException spannerException) {
    return spannerException.isRetryable()
        || retryableCodes.contains(
            GrpcStatusCode.of(spannerException.getErrorCode().getGrpcStatusCode()).getCode());
  }

  /**
   * Registers the in-flight stream early during {@code startStream()} setup so that in-flight RPCs
   * can be cancelled immediately if {@link #close(String)} is invoked before {@code startStream()}
   * returns, without publishing the stream to consumers before it is fully initialized.
   *
   * @return {@code true} if the stream was attached, or {@code false} if this iterator was already
   *     closed
   */
  boolean setStream(CloseableIterator<PartialResultSet> streamToRegister) {
    boolean streamWithBeginTransaction = streamToRegister.isWithBeginTransaction();
    boolean streamLastStatement = streamToRegister.isLastStatement();
    boolean isClosed;
    String messageToClose;
    synchronized (streamLock) {
      this.withBeginTransaction = streamWithBeginTransaction;
      this.lastStatement = streamLastStatement;
      // Only the single thread that set startingStream = true in startGrpcStreaming() calls
      // setStream(), at most once early inside startStream() and once immediately after
      // startStream() returns with the same instance. inFlightStream is always cleared before
      // startingStream is reset to false, so inFlightStream is either null or streamToRegister.
      if (this.inFlightStream == streamToRegister) {
        return !this.closed;
      }
      isClosed = this.closed;
      messageToClose = this.closeMessage;
      this.inFlightStream = streamToRegister;
    }
    // If closed concurrently during acquisition, tear down the stream out-of-lock to avoid leaks.
    if (isClosed) {
      streamToRegister.close(messageToClose);
    }
    return !isClosed;
  }

  private void publishStartedStream(CloseableIterator<PartialResultSet> streamIterator) {
    synchronized (streamLock) {
      if (!this.closed) {
        this.stream = streamIterator;
      }
      this.inFlightStream = null;
      this.startingStream = false;
      streamLock.notifyAll();
    }
  }

  /**
   * Resets the active stream reference during retries or channel failovers. Only called after
   * {@link #startGrpcStreaming()} has already succeeded ({@code startFailure == null}) and a stream
   * error is later encountered while reading from the published {@link #stream}.
   */
  private void resetStream() {
    synchronized (streamLock) {
      this.stream = null;
    }
  }

  private void resetStreamOnFailure(Throwable throwable) {
    CloseableIterator<PartialResultSet> failedStream = null;
    synchronized (streamLock) {
      if (this.inFlightStream != null) {
        // Refresh withBeginTransaction (a non-blocking field read on the stream iterator) before
        // clearing inFlightStream and calling notifyAll(). A subclass that registers its stream
        // early calls setStream(consumer) before consumer.setCall(call, true), and any follower
        // thread woken by notifyAll() must immediately observe the updated flag via
        // isWithBeginTransaction().
        this.withBeginTransaction = this.inFlightStream.isWithBeginTransaction();
        if (!this.closed) {
          failedStream = this.inFlightStream;
        }
      }
      this.inFlightStream = null;
      this.startingStream = false;
      this.startFailure = throwable;
      streamLock.notifyAll();
    }
    if (failedStream != null) {
      failedStream.close(throwable.getMessage());
    }
  }

  /** Ensures the tracing span opened in the constructor is ended exactly once. */
  private void endSpanOnce() {
    if (spanEnded.compareAndSet(false, true)) {
      span.end();
    }
  }

  private boolean isBufferFlushableLocked() {
    return !buffer.isEmpty()
        && (finished || !safeToRetry || !buffer.getLast().getResumeToken().isEmpty());
  }

  private void bufferChunkLocked(PartialResultSet next) {
    boolean hasResumeToken = !next.getResumeToken().isEmpty();
    if (hasResumeToken) {
      // Only a resume token that differs from the last seen token is progress: a stream
      // that repeatedly returns the token that was used to resume it has not moved past it.
      if (!next.getResumeToken().equals(resumeToken)) {
        // The stream made progress, so reset the budget for consecutive failed attempts.
        attempts = 0;
        backOff = null;
        retrySequenceStartNanos = -1L;
      }
      resumeToken = next.getResumeToken();
      safeToRetry = true;
    }
    buffer.add(next);
    if (buffer.size() > maxBufferSize && !hasResumeToken) {
      // We need to flush without a restart token. Errors encountered until we see
      // such a token will fail the read.
      safeToRetry = false;
    }
  }

  /**
   * Non-blockingly drains available non-error chunks from {@code currentStream} into {@link
   * #buffer} until {@link #buffer} becomes flushable (for example, a resume token is seen or {@link
   * #maxBufferSize} is exceeded) or the stream reaches EOF.
   */
  private void drainAvailableFromStream(
      @Nullable CloseableIterator<PartialResultSet> currentStream) {
    if (currentStream == null) {
      return;
    }
    // Under the single-consumer contract, canPollWithoutErrorOrBlocking() returning true guarantees
    // that the next item in currentStream is a non-error PartialResultSet or EOF, so
    // readNextFromStreamIntoBuffer(currentStream) will not block or throw a stream error unless
    // close() is invoked concurrently while reading (which readNextFromStreamIntoBuffer handles).
    while (currentStream.canPollWithoutErrorOrBlocking()) {
      if (readNextFromStreamIntoBuffer(currentStream)) {
        return;
      }
    }
  }

  private boolean readNextFromStreamIntoBuffer(CloseableIterator<PartialResultSet> currentStream) {
    try {
      if (currentStream.hasNext()) {
        PartialResultSet next = currentStream.next();
        synchronized (buffer) {
          if (closed) {
            return true;
          }
          bufferChunkLocked(next);
          return isBufferFlushableLocked();
        }
      } else {
        synchronized (buffer) {
          finished = true;
        }
        return true;
      }
    } catch (SpannerException spannerException) {
      if (closed) {
        return true;
      }
      throw spannerException;
    }
  }

  @Nullable
  private PartialResultSet pollBufferedChunk() {
    synchronized (buffer) {
      if (isBufferFlushableLocked()) {
        return buffer.pop();
      }
    }
    return null;
  }

  private boolean shouldRetryOnDifferentChannel(
      SpannerException spannerException, int numAttemptsOnOtherChannel) {
    boolean canRetry;
    synchronized (buffer) {
      canRetry = resumeToken == null && buffer.isEmpty();
    }
    if (canRetry) {
      Throwable translated = errorHandler.translateException(spannerException);
      return translated instanceof RetryOnDifferentGrpcChannelException
          && numAttemptsOnOtherChannel < errorHandler.getMaxAttempts()
          && prepareIteratorForRetryOnDifferentGrpcChannel();
    }
    return false;
  }

  private void recordFailure(Throwable throwable) {
    span.addAnnotation("Stream broken. Not safe to retry", throwable);
    span.setStatus(throwable);
    endSpanOnce();
  }
}
