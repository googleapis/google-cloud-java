/*
 * Copyright 2018 Google LLC
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

import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;

/**
 * Implementations of this class trace the logical flow of a google cloud client.
 *
 * <p>A single instance of a tracer represents a logical operation that can be annotated throughout
 * its lifecycle. Constructing an instance of a subclass will implicitly signal the start of a new
 * operation.
 *
 * <p>For internal use only. google-cloud-java libraries should extend {@link BaseApiTracer}.
 */
@InternalApi
public interface ApiTracer {

  /**
   * Asks the underlying implementation to install itself as a thread local. This allows for interop
   * between clients using gax and external resources to share the same implementation of the
   * tracing. For example OpenCensus will install a thread local that can read by the GRPC.
   */
  default Scope inScope() {
    return () -> {
      // noop
    };
  }
  ;

  /**
   * Signals that the overall operation has finished successfully. The tracer is now considered
   * closed and should no longer be used.
   */
  default void operationSucceeded() {}
  ;

  /**
   * Signals that the operation was cancelled by the user. The tracer is now considered closed and
   * should no longer be used.
   */
  default void operationCancelled() {}
  ;

  /**
   * Signals that the overall operation has failed and no further attempts will be made. The tracer
   * is now considered closed and should no longer be used.
   *
   * @param error the final error that caused the operation to fail.
   */
  default void operationFailed(Throwable error) {}
  ;

  /**
   * Annotates the operation with selected connection id from the {@code ChannelPool}.
   *
   * @param id the local connection identifier of the selected connection.
   */
  default void connectionSelected(String id) {}
  ;

  /**
   * Adds an annotation that an attempt is about to start. In general this should occur at the very
   * start of the operation. The attemptNumber is zero based. So the initial attempt will be 0.
   *
   * @param attemptNumber the zero based sequential attempt number.
   * @deprecated Please use {@link #attemptStarted(Object, int)} instead.
   */
  @Deprecated
  default void attemptStarted(int attemptNumber) {}
  ;

  /**
   * Adds an annotation that an attempt is about to start with additional information from the
   * request. In general this should occur at the very start of the operation. The attemptNumber is
   * zero based. So the initial attempt will be 0.
   *
   * @param attemptNumber the zero based sequential attempt number.
   * @param request request of this attempt.
   */
  default void attemptStarted(Object request, int attemptNumber) {}
  ;

  /** Adds an annotation that the attempt succeeded. */
  default void attemptSucceeded() {}
  ;

  /** Add an annotation that the attempt was cancelled by the user. */
  default void attemptCancelled() {}
  ;

  /**
   * This method is obsolete. Use {@link #attemptFailedDuration(Throwable, java.time.Duration)}
   * instead.
   */
  @ObsoleteApi("Use attemptFailedDuration(Throwable, java.time.Duration) instead")
  default void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {}
  ;

  /**
   * Adds an annotation that the attempt failed, but another attempt will be made after the delay.
   *
   * @param error the transient error that caused the attempt to fail.
   * @param delay the amount of time to wait before the next attempt will start.
   */
  default void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    // Defaults to do the same as attemptFailed(Throwable, org.threeten.bp.Duration). This
    // is because customers may have older/legacy code that directly implements
    // attemptFailed(Throwable, org.threeten.bp.Duration)} and their overridden logic should be
    // invoked in gax.
    attemptFailed(error, toThreetenDuration(delay));
  }
  ;

  /**
   * Adds an annotation that the attempt failed and that no further attempts will be made because
   * retry limits have been reached.
   *
   * @param error the last error received before retries were exhausted.
   */
  default void attemptFailedRetriesExhausted(Throwable error) {}
  ;

  /**
   * Adds an annotation that the attempt failed and that no further attempts will be made because
   * the last error was not retryable.
   *
   * @param error the error that caused the final attempt to fail.
   */
  default void attemptPermanentFailure(Throwable error) {}
  ;

  /**
   * Signals that the initial RPC for the long running operation failed.
   *
   * @param error the error that caused the long running operation fail.
   */
  default void lroStartFailed(Throwable error) {}
  ;

  /**
   * Signals that the initial RPC successfully started the long running operation. The long running
   * operation will now be polled for completion.
   */
  default void lroStartSucceeded() {}
  ;

  /** Adds an annotation that a streaming response has been received. */
  default void responseReceived() {}
  ;

  /** Adds an annotation that a streaming request has been sent. */
  default void requestSent() {}
  ;

  /**
   * Adds an annotation that a batch of writes has been flushed.
   *
   * @param elementCount the number of elements in the batch.
   * @param requestSize the size of the batch in bytes.
   */
  default void batchRequestSent(long elementCount, long requestSize) {}
  ;

  /**
   * A context class to be used with {@link #inScope()} and a try-with-resources block. Closing a
   * {@link Scope} removes any context that the underlying implementation might've set in {@link
   * #inScope()}.
   */
  interface Scope extends AutoCloseable {
    @Override
    void close();
  }
}
