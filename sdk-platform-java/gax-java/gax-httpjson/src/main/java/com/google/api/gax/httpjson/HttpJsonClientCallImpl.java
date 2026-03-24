/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.httpjson;

import com.google.api.client.http.HttpTransport;
import com.google.api.gax.httpjson.ApiMethodDescriptor.MethodType;
import com.google.api.gax.httpjson.HttpRequestRunnable.ResultListener;
import com.google.api.gax.httpjson.HttpRequestRunnable.RunnableResult;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * This class serves as main implementation of {@link HttpJsonClientCall} for REST transport and is
 * expected to be used for every REST call. It currently supports unary and server-streaming
 * workflows. The overall behavior and surface of the class mimics as close as possible behavior of
 * the corresponding ClientCall implementation in gRPC transport.
 *
 * <p>This class is thread-safe.
 *
 * @param <RequestT> call request type
 * @param <ResponseT> call response type
 */
final class HttpJsonClientCallImpl<RequestT, ResponseT>
    extends HttpJsonClientCall<RequestT, ResponseT> implements ResultListener {
  //
  // A lock to guard the state of this call (and the response stream).
  //
  private final Object lock = new Object();

  // An active delivery loop marker.
  @GuardedBy("lock")
  private boolean inDelivery = false;

  // A queue to keep "scheduled" calls to HttpJsonClientCall.Listener<ResponseT> in a form of tasks.
  // It may seem like an overkill, but it exists to implement the following listeners contract:
  //   - onHeaders() must be called before any onMessage();
  //   - onClose() must be the last call made, no onMessage() or onHeaders() are allowed after that;
  //   - while methods on the same listener may be called from different threads they must never be
  //     called simultaneously;
  //   - listeners should not be called under the internal lock of the client call to reduce risk of
  //     deadlocking and minimize time spent under lock;
  //   - a specialized notifications' dispatcher thread may be used in the future to send
  //     notifications (not the case right now).
  @GuardedBy("lock")
  private final Queue<NotificationTask<ResponseT>> pendingNotifications = new ArrayDeque<>();

  //
  // Immutable API method-specific data.
  //
  private final HttpJsonCallOptions callOptions;
  private final String endpoint;
  private final ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor;
  private final HttpTransport httpTransport;
  private final Executor executor;
  private final ScheduledExecutorService deadlineCancellationExecutor;

  //
  // Request-specific data (provided by client code) before we get a response.
  //
  @GuardedBy("lock")
  private HttpJsonMetadata requestHeaders;

  @GuardedBy("lock")
  private Listener<ResponseT> listener;

  @GuardedBy("lock")
  private int pendingNumMessages;

  //
  // Response-specific data (received from server).
  //
  @GuardedBy("lock")
  private HttpRequestRunnable<RequestT, ResponseT> requestRunnable;

  @GuardedBy("lock")
  private RunnableResult runnableResult;

  @GuardedBy("lock")
  private ProtoMessageJsonStreamIterator responseStreamIterator;

  @GuardedBy("lock")
  private volatile boolean closed;

  // Store the timeout future created by the deadline schedule executor. The future
  // can be cancelled if a response (either an error or valid payload) has been
  // received before the timeout. This value may be null if the RPC does not have a
  // timeout.
  @GuardedBy("lock")
  private volatile ScheduledFuture<?> timeoutFuture;

  HttpJsonClientCallImpl(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor,
      String endpoint,
      HttpJsonCallOptions callOptions,
      HttpTransport httpTransport,
      Executor executor,
      ScheduledExecutorService deadlineCancellationExecutor) {
    this.methodDescriptor = methodDescriptor;
    this.endpoint = endpoint;
    this.callOptions = callOptions;
    this.httpTransport = httpTransport;
    this.executor = executor;
    this.deadlineCancellationExecutor = deadlineCancellationExecutor;
    this.closed = false;
  }

  @Override
  public void setResult(RunnableResult runnableResult) {
    Preconditions.checkNotNull(runnableResult);
    synchronized (lock) {
      if (closed) {
        return;
      }
      Preconditions.checkState(this.runnableResult == null, "The call result is already set");
      this.runnableResult = runnableResult;
      if (runnableResult.getResponseHeaders() != null) {
        pendingNotifications.offer(
            new OnHeadersNotificationTask<>(listener, runnableResult.getResponseHeaders()));
      }
    }

    // trigger delivery loop if not already running
    deliver();
  }

  @Override
  public void start(Listener<ResponseT> responseListener, HttpJsonMetadata requestHeaders) {
    Preconditions.checkNotNull(responseListener);
    Preconditions.checkNotNull(requestHeaders);
    synchronized (lock) {
      if (closed) {
        return;
      }
      Preconditions.checkState(this.listener == null, "The call is already started");
      this.listener = responseListener;
      this.requestHeaders = requestHeaders;

      // Use the timeout duration value instead of calculating the future Instant
      // Only schedule the deadline if the RPC timeout has been set in the RetrySettings
      java.time.Duration timeout = callOptions.getTimeoutDuration();
      if (timeout != null) {
        // The future timeout value is guaranteed to not be a negative value as the
        // RetryAlgorithm will not retry
        long timeoutMs = timeout.toMillis();
        // Assign the scheduled future so that it can be cancelled if the timeout task
        // is not needed (response received prior to timeout)
        timeoutFuture =
            this.deadlineCancellationExecutor.schedule(
                this::timeout, timeoutMs, TimeUnit.MILLISECONDS);
      }
    }
  }

  // Notify the FutureListener that the there is a timeout exception from this RPC
  // call (DEADLINE_EXCEEDED). For retrying RPCs, this code is returned for every attempt
  // that exceeds the timeout. The RetryAlgorithm will check both the timing and code to
  // ensure another attempt is made.
  private void timeout() {
    // There is a race between the deadline scheduler and response being returned from
    // the server. The deadline scheduler has priority as it will clear out the pending
    // notifications queue and add the DEADLINE_EXCEEDED event once it is able to obtain
    // the lock.
    synchronized (lock) {
      close(
          StatusCode.Code.DEADLINE_EXCEEDED.getHttpStatusCode(),
          "Deadline exceeded",
          new HttpJsonStatusRuntimeException(
              StatusCode.Code.DEADLINE_EXCEEDED.getHttpStatusCode(), "Deadline exceeded", null),
          true);
    }

    // trigger delivery loop if not already running
    deliver();
  }

  @Override
  public void request(int numMessages) {
    if (numMessages < 0) {
      throw new IllegalArgumentException("numMessages must be non-negative");
    }
    synchronized (lock) {
      if (closed) {
        return;
      }
      pendingNumMessages += numMessages;
    }

    // trigger delivery loop if not already running
    deliver();
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    Throwable actualCause = cause;
    if (actualCause == null) {
      actualCause = new CancellationException(message);
    }

    synchronized (lock) {
      close(499, message, actualCause, true);
    }

    // trigger delivery loop if not already running
    deliver();
  }

  @Override
  public void sendMessage(RequestT message) {
    Preconditions.checkNotNull(message);
    HttpRequestRunnable<RequestT, ResponseT> localRunnable;
    synchronized (lock) {
      if (closed) {
        return;
      }
      Preconditions.checkState(listener != null, "The call hasn't been started");
      Preconditions.checkState(
          requestRunnable == null,
          "The message has already been sent. Bidirectional streaming calls are not supported");

      requestRunnable =
          new HttpRequestRunnable<>(
              message,
              methodDescriptor,
              endpoint,
              callOptions,
              httpTransport,
              requestHeaders,
              this);
      localRunnable = requestRunnable;
    }
    executor.execute(localRunnable);
  }

  @Override
  public void halfClose() {
    // no-op for now, as halfClose makes sense only for bidirectional streams.
  }

  private void deliver() {
    // A flag stored in method stack space to detect when we enter a delivery loop (regardless if
    // it is a concurrent thread or a recursive call execution of delivery() method within the same
    // thread).
    boolean newActiveDeliveryLoop = true;
    boolean allMessagesConsumed = false;
    while (true) {
      // The try block around listener notification logic. We need to keep this
      // block inside the loop to make sure that in case onMessage() call throws, we close the
      // request properly and call onClose() method on listener once eventually (because the
      // listener can be called only inside this loop).
      try {
        // Check if there is only one delivery loop active. Exit if a competing delivery loop
        // detected (either in a concurrent thread or in a previous recursive call to this method in
        // the same thread). The last-standing delivery loop will do all the job. Even if something
        // in this loop throws, the code will first go through this block before exiting the loop to
        // make sure that the activeDeliveryLoops counter stays correct.
        //
        // Note, we must enter the loop before doing the check.
        synchronized (lock) {
          if (inDelivery && newActiveDeliveryLoop) {
            // EXIT delivery loop because another active delivery loop has been detected.
            break;
          }
          newActiveDeliveryLoop = false;
          inDelivery = true;
        }

        if (Thread.interrupted()) {
          // The catch block below will properly cancel the call. Note Thread.interrupted() clears
          // the interruption flag on this thread, so we don't throw forever.
          throw new InterruptedException("Message delivery has been interrupted");
        }

        // All listeners must be called under delivery loop (but outside the lock) to ensure that
        // no two notifications come simultaneously from two different threads and that we do not
        // go indefinitely deep in the stack if delivery logic is called recursively via
        // listeners.
        notifyListeners();

        // The synchronized block around message reading and cancellation notification processing
        // logic
        synchronized (lock) {
          if (allMessagesConsumed) {
            // allMessagesProcessed was set to true on previous loop iteration. We do it this
            // way to make sure that notifyListeners() is called in between consuming the last
            // message in a stream and closing the call.
            // This is to make sure that onMessage() for the last message in a stream is called
            // before closing this call, because that last onMessage() listener execution may change
            // how the call has to be closed (normally or cancelled).

            // Close the call normally.
            // once close() is called we will never ever enter this again, because `close` flag
            // will be set to true by the close() method. If the call is already closed, close()
            // will have no effect.
            allMessagesConsumed = false;
            close(
                runnableResult.getStatusCode(),
                runnableResult.getTrailers().getStatusMessage(),
                runnableResult.getTrailers().getException(),
                false);
          }

          // Attempt to terminate the delivery loop if:
          //   `runnableResult == null` => there is no response from the server yet;
          //   `pendingNumMessages <= 0` => we have already delivered as much as has been asked;
          //   `closed` => this call has been closed already;
          if (runnableResult == null || pendingNumMessages <= 0 || closed) {
            // The loop terminates only when there are no pending notifications left. The check
            // happens under the lock, so no other thread may add a listener notification task in
            // the middle of this logic.
            if (pendingNotifications.isEmpty()) {
              // EXIT delivery loop because there is no more work left to do. This is expected to be
              // the only active delivery loop.
              inDelivery = false;
              break;
            } else {
              // We still have some stuff in notificationTasksQueue so continue the loop, most
              // likely we will finally terminate on the next cycle.
              continue;
            }
          }
          pendingNumMessages--;
          allMessagesConsumed = consumeMessageFromStream();
        }
      } catch (Throwable e) {
        // Exceptions in message delivery result into cancellation of the call to stay consistent
        // with other transport implementations.
        HttpJsonStatusRuntimeException ex =
            new HttpJsonStatusRuntimeException(499, "Exception in message delivery", e);
        // If we are already closed the exception will be swallowed, which is the best thing we
        // can do in such an unlikely situation (otherwise we would stay forever in the delivery
        // loop).
        synchronized (lock) {
          // Close the call immediately marking it cancelled. If already closed, close() will have
          // no effect.
          close(ex.getStatusCode(), ex.getMessage(), ex, true);
        }
      }
    }
  }

  private void notifyListeners() {
    while (true) {
      NotificationTask<ResponseT> notification;
      synchronized (lock) {
        if (pendingNotifications.isEmpty()) {
          return;
        }
        notification = pendingNotifications.poll();
      }
      notification.call();
    }
  }

  @GuardedBy("lock")
  private boolean consumeMessageFromStream() throws IOException {
    if (runnableResult.getTrailers().getException() != null
        || runnableResult.getResponseContent() == null) {
      // Server returned an error, no messages to process. This will result into closing a call with
      // an error.
      return true;
    }

    boolean allMessagesConsumed;
    Reader responseReader;
    if (methodDescriptor.getType() == MethodType.SERVER_STREAMING) {
      // Lazily initialize responseStreamIterator in case if it is a server streaming response
      if (responseStreamIterator == null) {
        responseStreamIterator =
            new ProtoMessageJsonStreamIterator(
                new InputStreamReader(runnableResult.getResponseContent(), StandardCharsets.UTF_8));
      }
      if (responseStreamIterator.hasNext()) {
        responseReader = responseStreamIterator.next();
      } else {
        return true;
      }
      // To make sure that the call will be closed immediately once we read the last
      // message from the response (otherwise we would need to wait for another request(1)
      // from the client to check if there is anything else left in the stream).
      allMessagesConsumed = !responseStreamIterator.hasNext();
    } else {
      responseReader =
          new InputStreamReader(runnableResult.getResponseContent(), StandardCharsets.UTF_8);
      // Unary calls have only one message in their response, so we should be ready to close
      // immediately after delivering a single response message.
      allMessagesConsumed = true;
    }

    ResponseT message =
        methodDescriptor.getResponseParser().parse(responseReader, callOptions.getTypeRegistry());
    pendingNotifications.offer(new OnMessageNotificationTask<>(listener, message));

    return allMessagesConsumed;
  }

  @GuardedBy("lock")
  private void close(
      int statusCode, String message, Throwable cause, boolean terminateImmediately) {
    try {
      if (closed) {
        return;
      }
      closed = true;

      // Cancel the timeout future if there is a timeout associated with the RPC
      if (timeoutFuture != null) {
        // The timeout method also invokes close() and the second invocation of close()
        // will be guarded by the closed check above. No need to interrupt the timeout
        // task as running the timeout task is quick.
        timeoutFuture.cancel(false);
        timeoutFuture = null;
      }

      // Best effort task cancellation (to not be confused with task's thread interruption).
      // If the task is in blocking I/O waiting for the server response, it will keep waiting for
      // the response from the server, but once response is received the task will exit silently.
      // If the task has already completed, this call has no effect.
      if (requestRunnable != null) {
        requestRunnable.cancel();
        requestRunnable = null;
      }

      HttpJsonMetadata.Builder metadataBuilder = HttpJsonMetadata.newBuilder();
      if (runnableResult != null && runnableResult.getTrailers() != null) {
        metadataBuilder = runnableResult.getTrailers().toBuilder();
      }
      metadataBuilder.setException(cause);
      metadataBuilder.setStatusMessage(message);
      if (responseStreamIterator != null) {
        responseStreamIterator.close();
      }
      if (runnableResult != null && runnableResult.getResponseContent() != null) {
        runnableResult.getResponseContent().close();
      }

      // onClose() suppresses all other pending notifications.
      // there should be no place in the code which inserts something in this queue before checking
      // the `closed` flag under the lock and refusing to insert anything if `closed == true`.
      if (terminateImmediately) {
        // This usually means we are cancelling the call before processing the response in full.
        // It may happen if a user explicitly cancels the call or in response to an unexpected
        // exception either from server or a call listener execution.
        pendingNotifications.clear();
      }

      pendingNotifications.offer(
          new OnCloseNotificationTask<>(listener, statusCode, metadataBuilder.build()));

    } catch (Throwable e) {
      // suppress stream closing exceptions in favor of the actual call closing cause. This method
      // should not throw, otherwise we may be stuck in an infinite loop of exception processing.
    }
  }

  //
  // Listener notification tasks. Each class simply calls only one specific method on the Listener
  // interface, and to do so it also stores tha parameters needed to make the all.
  //
  private abstract static class NotificationTask<ResponseT> {
    private final Listener<ResponseT> listener;

    NotificationTask(Listener<ResponseT> listener) {
      this.listener = listener;
    }

    protected Listener<ResponseT> getListener() {
      return listener;
    }

    abstract void call();
  }

  private static class OnHeadersNotificationTask<ResponseT> extends NotificationTask<ResponseT> {
    private final HttpJsonMetadata responseHeaders;

    OnHeadersNotificationTask(Listener<ResponseT> listener, HttpJsonMetadata responseHeaders) {
      super(listener);
      this.responseHeaders = responseHeaders;
    }

    public void call() {
      getListener().onHeaders(responseHeaders);
    }
  }

  private static class OnMessageNotificationTask<ResponseT> extends NotificationTask<ResponseT> {
    private final ResponseT message;

    OnMessageNotificationTask(Listener<ResponseT> listener, ResponseT message) {
      super(listener);
      this.message = message;
    }

    public void call() {
      getListener().onMessage(message);
    }
  }

  private static class OnCloseNotificationTask<ResponseT> extends NotificationTask<ResponseT> {
    private final int statusCode;
    private final HttpJsonMetadata trailers;

    OnCloseNotificationTask(
        Listener<ResponseT> listener, int statusCode, HttpJsonMetadata trailers) {
      super(listener);
      this.statusCode = statusCode;
      this.trailers = trailers;
    }

    public void call() {
      getListener().onClose(statusCode, trailers);
    }
  }
}
