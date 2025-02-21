/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.gaxx.retrying;

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.data.v2.stub.BigtableStreamResumptionStrategy;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

// TODO: remove this once ApiResultRetryAlgorithm is added to gax.
/**
 * A callable that generates Server Streaming attempts. At any one time, it is responsible for at
 * most a single outstanding attempt. During an attempt, it proxies all incoming message to the
 * outer {@link ResponseObserver} and the {@link StreamResumptionStrategy}. Once the attempt
 * completes, the external {@link RetryingFuture} future is notified. If the {@link RetryingFuture}
 * decides to retry the attempt, it will invoke {@link #call()}.
 *
 * <p>The lifecycle of this class is:
 *
 * <ol>
 *   <li>The caller instantiates this class.
 *   <li>The caller sets the {@link RetryingFuture} via {@link #setExternalFuture(RetryingFuture)}.
 *       The {@link RetryingFuture} will be responsible for scheduling future attempts.
 *   <li>The caller calls {@link #start()}. This notifies the outer {@link ResponseObserver} that
 *       call is about to start.
 *   <li>The outer {@link ResponseObserver} configures inbound flow control via the {@link
 *       StreamController} that it received in {@link ResponseObserver#onStart(StreamController)}.
 *   <li>The attempt call is sent via the inner/upstream {@link ServerStreamingCallable}.
 *   <li>A future representing the end state of the inner attempt is passed to the outer {@link
 *       RetryingFuture}.
 *   <li>All messages received from the inner {@link ServerStreamingCallable} are recorded by the
 *       {@link StreamResumptionStrategy}.
 *   <li>All messages received from the inner {@link ServerStreamingCallable} are forwarded to the
 *       outer {@link ResponseObserver}.
 *   <li>Upon attempt completion (either success or failure) are communicated to the outer {@link
 *       RetryingFuture}.
 *   <li>If the {@link RetryingFuture} decides to resume the RPC, it will invoke {@link #call()},
 *       which will consult the {@link StreamResumptionStrategy} for the resuming request and
 *       restart the process at step 5.
 *   <li>Once the {@link RetryingFuture} decides to stop the retry loop, it will notify the outer
 *       {@link ResponseObserver}.
 * </ol>
 *
 * <p>This class is meant to be used as middleware between an outer {@link ResponseObserver} and an
 * inner {@link ServerStreamingCallable}. As such it follows the general threading model of {@link
 * ServerStreamingCallable}s:
 *
 * <ul>
 *   <li>{@code onStart} must be called in the same thread that invoked {@code call()}
 *   <li>The outer {@link ResponseObserver} can call {@code request()} and {@code cancel()} on this
 *       class' {@link StreamController} from any thread
 *   <li>The inner callable will serialize calls to {@code onResponse()}, {@code onError()} and
 *       {@code onComplete}
 * </ul>
 *
 * <p>With this model in mind, this class only needs to synchronize access data that is shared
 * between: the outer {@link ResponseObserver} (via this class' {@link StreamController}) and the
 * inner {@link ServerStreamingCallable}: pendingRequests, cancellationCause and the current
 * innerController.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@InternalApi
public final class ServerStreamingAttemptCallable<RequestT, ResponseT> implements Callable<Void> {
  private final Object lock = new Object();

  private final ServerStreamingCallable<RequestT, ResponseT> innerCallable;
  private final StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategy;
  private final RequestT initialRequest;
  private ApiCallContext context;
  private final ResponseObserver<ResponseT> outerObserver;

  // Start state
  private boolean autoFlowControl = true;
  private boolean isStarted;

  // Outer state
  private Throwable cancellationCause;

  private int pendingRequests;

  private RetryingFuture<Void> outerRetryingFuture;

  // Internal retry state
  private int numAttempts;

  private StreamController innerController;

  private boolean seenSuccessSinceLastError;
  private SettableApiFuture<Void> innerAttemptFuture;

  public ServerStreamingAttemptCallable(
      ServerStreamingCallable<RequestT, ResponseT> innerCallable,
      StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategy,
      RequestT initialRequest,
      ApiCallContext context,
      ResponseObserver<ResponseT> outerObserver) {
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

    RequestT request =
        (++numAttempts == 1) ? initialRequest : resumptionStrategy.getResumeRequest(initialRequest);

    // Should never happen. onAttemptError will check if ResumptionStrategy can create a resume
    // request,
    // which the RetryingFuture/StreamResumptionStrategy should respect.
    Preconditions.checkState(request != null, "ResumptionStrategy returned a null request.");

    innerAttemptFuture = SettableApiFuture.create();
    seenSuccessSinceLastError = false;

    ApiCallContext attemptContext = context;

    if (!outerRetryingFuture.getAttemptSettings().getRpcTimeout().isZero()
        && attemptContext.getTimeout() == null) {
      attemptContext =
          attemptContext.withTimeout(outerRetryingFuture.getAttemptSettings().getRpcTimeout());
    }

    attemptContext
        .getTracer()
        .attemptStarted(request, outerRetryingFuture.getAttemptSettings().getOverallAttemptCount());

    innerCallable.call(
        request,
        new StateCheckingResponseObserver<ResponseT>() {
          @Override
          public void onStartImpl(StreamController controller) {
            onAttemptStart(controller);
          }

          @Override
          public void onResponseImpl(ResponseT response) {
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
  private void onAttemptResponse(ResponseT message) {
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
    if (resumptionStrategy instanceof BigtableStreamResumptionStrategy) {
      throwable = ((BigtableStreamResumptionStrategy) resumptionStrategy).processError(throwable);
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
