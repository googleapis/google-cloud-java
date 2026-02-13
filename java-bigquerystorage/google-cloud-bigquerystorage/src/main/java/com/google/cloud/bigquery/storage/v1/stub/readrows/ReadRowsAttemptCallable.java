/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1.stub.readrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

final class ReadRowsAttemptCallable implements Callable<Void> {
  private final Object lock = new Object();

  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> innerCallable;
  private final StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse> resumptionStrategy;
  private final ReadRowsRequest initialRequest;
  private ApiCallContext context;
  private final ResponseObserver<ReadRowsResponse> outerObserver;

  // Start state
  private boolean autoFlowControl = true;
  private boolean isStarted;

  // Outer state
  @GuardedBy("lock")
  private Throwable cancellationCause;

  @GuardedBy("lock")
  private int pendingRequests;

  private RetryingFuture<Void> outerRetryingFuture;

  // Internal retry state
  private int numAttempts;

  @GuardedBy("lock")
  private StreamController innerController;

  private boolean seenSuccessSinceLastError;
  private SettableApiFuture<Void> innerAttemptFuture;

  ReadRowsAttemptCallable(
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> innerCallable,
      StreamResumptionStrategy<ReadRowsRequest, ReadRowsResponse> resumptionStrategy,
      ReadRowsRequest initialRequest,
      ApiCallContext context,
      ResponseObserver<ReadRowsResponse> outerObserver) {
    this.innerCallable = innerCallable;
    this.resumptionStrategy = resumptionStrategy;
    this.initialRequest = initialRequest;
    this.context = context;
    this.outerObserver = outerObserver;
  }

  /** Sets controlling {@link RetryingFuture}. Must be called be before {@link #start()}. */
  void setExternalFuture(RetryingFuture<Void> retryingFuture) {
    Preconditions.checkState(!isStarted, "Can't change the RetryingFuture once the call has start");
    Preconditions.checkNotNull(retryingFuture, "RetryingFuture can't be null");

    this.outerRetryingFuture = retryingFuture;
  }

  /**
   * Starts the initial call. The call is attempted on the caller's thread. Further call attempts
   * will be scheduled by the {@link RetryingFuture}.
   */
  public void start() {
    Preconditions.checkState(!isStarted, "Already started");

    // Initialize the outer observer
    outerObserver.onStart(
        new StreamController() {
          @Override
          public void disableAutoInboundFlowControl() {
            Preconditions.checkState(
                !isStarted, "Can't disable auto flow control once the stream is started");
            autoFlowControl = false;
          }

          @Override
          public void request(int count) {
            onRequest(count);
          }

          @Override
          public void cancel() {
            onCancel();
          }
        });

    if (autoFlowControl) {
      synchronized (lock) {
        pendingRequests = Integer.MAX_VALUE;
      }
    }
    isStarted = true;

    // Propagate the totalTimeout as the overall stream deadline.
    Duration totalTimeout =
        outerRetryingFuture.getAttemptSettings().getGlobalSettings().getTotalTimeoutDuration();

    if (totalTimeout != null && context != null) {
      context = context.withTimeoutDuration(totalTimeout);
    }

    // Call the inner callable
    call();
  }

  /**
   * Sends the actual RPC. The request being sent will first be transformed by the {@link
   * StreamResumptionStrategy}.
   *
   * <p>This method expects to be called by one thread at a time. Furthermore, it expects that the
   * current RPC finished before the next time it's called.
   */
  @Override
  public Void call() {
    Preconditions.checkState(isStarted, "Must be started first");

    ReadRowsRequest request =
        (++numAttempts == 1) ? initialRequest : resumptionStrategy.getResumeRequest(initialRequest);

    // Should never happen. onAttemptError will check if ResumptionStrategy can create a resume
    // request,
    // which the RetryingFuture/StreamResumptionStrategy should respect.
    Preconditions.checkState(request != null, "ResumptionStrategy returned a null request.");

    innerAttemptFuture = SettableApiFuture.create();
    seenSuccessSinceLastError = false;

    ApiCallContext attemptContext = context;

    if (!outerRetryingFuture.getAttemptSettings().getRpcTimeout().isZero()) {
      attemptContext =
          attemptContext.withStreamWaitTimeout(
              outerRetryingFuture.getAttemptSettings().getRpcTimeout());
    }

    attemptContext
        .getTracer()
        .attemptStarted(outerRetryingFuture.getAttemptSettings().getOverallAttemptCount());

    innerCallable.call(
        request,
        new StateCheckingResponseObserver<ReadRowsResponse>() {
          @Override
          public void onStartImpl(StreamController controller) {
            onAttemptStart(controller);
          }

          @Override
          public void onResponseImpl(ReadRowsResponse response) {
            onAttemptResponse(response);
          }

          @Override
          public void onErrorImpl(Throwable t) {
            onAttemptError(t);
          }

          @Override
          public void onCompleteImpl() {
            onAttemptComplete();
          }
        },
        attemptContext);

    outerRetryingFuture.setAttemptFuture(innerAttemptFuture);

    return null;
  }

  /**
   * Called by the inner {@link ServerStreamingCallable} when the call is about to start. This will
   * transfer unfinished state from the previous attempt.
   *
   * @see ResponseObserver#onStart(StreamController)
   */
  private void onAttemptStart(StreamController controller) {
    if (!autoFlowControl) {
      controller.disableAutoInboundFlowControl();
    }

    Throwable localCancellationCause;
    int numToRequest = 0;

    synchronized (lock) {
      innerController = controller;

      localCancellationCause = this.cancellationCause;

      if (!autoFlowControl) {
        numToRequest = pendingRequests;
      }
    }

    if (localCancellationCause != null) {
      controller.cancel();
    } else if (numToRequest > 0) {
      controller.request(numToRequest);
    }
  }

  /**
   * Called when the outer {@link ResponseObserver} wants to prematurely cancel the stream.
   *
   * @see StreamController#cancel()
   */
  private void onCancel() {
    StreamController localInnerController;

    synchronized (lock) {
      if (cancellationCause != null) {
        return;
      }
      // NOTE: BasicRetryingFuture will replace j.u.c.CancellationExceptions with it's own,
      // which will not have the current stacktrace, so a special wrapper has be used here.
      cancellationCause =
          new ServerStreamingAttemptException(
              new CancellationException("User cancelled stream"),
              resumptionStrategy.canResume(),
              seenSuccessSinceLastError);
      localInnerController = innerController;
    }

    if (localInnerController != null) {
      localInnerController.cancel();
    }
  }

  /**
   * Called when the outer {@link ResponseObserver} is ready for more data.
   *
   * @see StreamController#request(int)
   */
  private void onRequest(int count) {
    Preconditions.checkState(!autoFlowControl, "Automatic flow control is enabled");
    Preconditions.checkArgument(count > 0, "Count must be > 0");

    final StreamController localInnerController;

    synchronized (lock) {
      int maxInc = Integer.MAX_VALUE - pendingRequests;
      count = Math.min(maxInc, count);

      pendingRequests += count;
      localInnerController = this.innerController;
    }

    // Note: there is a race condition here where the count might go to the previous attempt's
    // StreamController after it failed. But it doesn't matter, because the controller will just
    // ignore it and the current controller will pick it up onStart.
    if (localInnerController != null) {
      localInnerController.request(count);
    }
  }

  /** Called when the inner callable has responses to deliver. */
  private void onAttemptResponse(ReadRowsResponse message) {
    if (!autoFlowControl) {
      synchronized (lock) {
        pendingRequests--;
      }
    }
    // Update local state to allow for future resume.
    seenSuccessSinceLastError = true;
    message = resumptionStrategy.processResponse(message);
    // Notify the outer observer.
    outerObserver.onResponse(message);
  }

  /**
   * Called when the current RPC fails. The error will be bubbled up to the outer {@link
   * RetryingFuture} via the {@link #innerAttemptFuture}.
   */
  private void onAttemptError(Throwable throwable) {
    Throwable localCancellationCause;
    synchronized (lock) {
      localCancellationCause = cancellationCause;
    }

    if (localCancellationCause != null) {
      // Take special care to preserve the cancellation's stack trace.
      innerAttemptFuture.setException(localCancellationCause);
    } else {
      // Wrap the original exception and provide more context for StreamingRetryAlgorithm.
      innerAttemptFuture.setException(
          new ServerStreamingAttemptException(
              throwable, resumptionStrategy.canResume(), seenSuccessSinceLastError));
    }
  }

  /**
   * Called when the current RPC successfully completes. Notifies the outer {@link RetryingFuture}
   * via {@link #innerAttemptFuture}.
   */
  private void onAttemptComplete() {
    innerAttemptFuture.set(null);
  }
}
