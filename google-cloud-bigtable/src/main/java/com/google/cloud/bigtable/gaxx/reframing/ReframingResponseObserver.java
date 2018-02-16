/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.gaxx.reframing;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

/**
 * Mediates message flow between two {@link ResponseObserver}s. It is intended for situations when a
 * stream needs to be transformed in such a way where the incoming responses do not map 1:1 to the
 * output responses.
 *
 * <p>This class manages back pressure between M upstream responses and N downstream responses. It
 * buffers responses when M &gt; N and spools them when M &lt; N. The downstream responses will be
 * delivered via either the upstream thread or the downstream thread that called request(); in
 * either case, the downstream methods will be invoked sequentially. Neither the downstream {@link
 * ResponseObserver} nor the {@link Reframer} need to be threadsafe.
 *
 * <p>All invocations to the {@link Reframer} are made while holding a lock.
 *
 * <p>Expected usage:
 *
 * <pre>{@code
 *  class OuterStreamingCallable extends ServerStreamingCallable<Request, FullResponse> {
 *    private final ServerStreamingCallable<Request, Chunk> innerCallable;
 *
 *    OuterStreamingCallable(ServerStreamingCallable<Request, Chunk> innerCallable) {
 *      this.innerCallable = innerCallable;
 *    }
 *
 *    public void call(Request request, ResponseObserver<FullResponse> outerObserver,
 * ApiCallContext context) {
 *      Reframer<Chunk, FullResponse> myReframer = new Reframer<>();
 *      innerCallable.call(request, new ReframingResponseObserver(myReframer, outerObserver),
 * context);
 *    }
 *  }
 * }</pre>
 */
@InternalApi
public class ReframingResponseObserver<InnerT, OuterT>
    extends StateCheckingResponseObserver<InnerT> {
  private final Object lock = new Object();

  @GuardedBy("lock")
  private final ResponseObserver<OuterT> outerResponseObserver;

  @GuardedBy("lock")
  private final Reframer<OuterT, InnerT> reframer;

  private StreamController innerController;
  private boolean hasStarted;
  private boolean autoFlowControl = true;

  @GuardedBy("lock")
  private int numPending;

  // Delivery mutual exclusion: only one thread can be delivering at a time
  @GuardedBy("lock")
  private boolean inDelivery;
  // When another thread is delivering, signal it to take an extra run to pick up changes
  @GuardedBy("lock")
  private boolean missed;

  // Request mutex: only one upstream request can be active at a time
  @GuardedBy("lock")
  private boolean awaitingInner;
  // By default all errors should be deferred until buffers have been exhausted
  // However, when a stream is cancelled, the errors should be immediate
  @GuardedBy("lock")
  private boolean deferError = true;
  // Deferred delivery stop: the upstream is exhausted, request downstream notification when
  // internal buffers are exhausted
  @GuardedBy("lock")
  private boolean closeOnDone;
  // When closing, this signals an error.
  @GuardedBy("lock")
  private Throwable error;
  // This stream has been closed; don't do any more processing.
  @GuardedBy("lock")
  private boolean closed;

  public ReframingResponseObserver(
      ResponseObserver<OuterT> observer, Reframer<OuterT, InnerT> reframer) {
    this.outerResponseObserver = observer;
    this.reframer = reframer;
  }

  /**
   * Callback that will be notified when the inner/upstream callable starts. This will in turn
   * notify the outer/downstreamObserver of stream start. Regardless of the
   * outer/downstreamObserver, the upstream controller will be put into manual flow control.
   *
   * @param controller The controller for the upstream stream.
   */
  @Override
  protected void onStartImpl(StreamController controller) {
    innerController = controller;
    innerController.disableAutoInboundFlowControl();

    outerResponseObserver.onStart(
        new StreamController() {
          @Override
          public void disableAutoInboundFlowControl() {
            Preconditions.checkState(
                !hasStarted, "Can't disable automatic flow control once the stream has started");
            autoFlowControl = false;
            numPending = 0;
          }

          @Override
          public void request(int count) {
            // innerController.request(int) is indirectly invoked in deliver().
            ReframingResponseObserver.this.onRequest(count);
          }

          @Override
          public void cancel() {
            ReframingResponseObserver.this.onCancel();
          }
        });

    hasStarted = true;

    if (autoFlowControl) {
      numPending = Integer.MAX_VALUE;
      deliver();
    }
  }

  /**
   * Request n responses to be delivered to the outer/downstream {@link
   * ResponseObserver#onResponse(Object)}. This method might synchronously deliver the messages if
   * they have already been buffered. Or it will deliver them asynchronously if they need to be
   * requested from upstream.
   *
   * @param count The maximum number of responses to deliver
   */
  private void onRequest(int count) {
    Preconditions.checkState(!autoFlowControl, "Auto flow control enabled");
    Preconditions.checkArgument(count > 0, "Count must be > 0");

    synchronized (lock) {
      int maxCount = Integer.MAX_VALUE - numPending;
      count = Math.min(maxCount, count);

      numPending += count;
    }

    deliver();
  }

  /**
   * Cancels the stream and notifies the downstream {@link ResponseObserver#onError(Throwable)}.
   * This method can be called multiple times, but only the first time has any effect. Please note
   * that there is a race condition between cancellation and the stream completing normally. Please
   * note that you can only specify a message or a cause, not both.
   */
  private void onCancel() {
    innerController.cancel();

    synchronized (lock) {
      deferError = false;
      error = new CancellationException("User cancelled stream");
    }

    deliver();
  }

  /**
   * Process a new response from inner/upstream callable. The message will be fed to the reframer
   * and the output will be delivered to the downstream {@link ResponseObserver}.
   *
   * <p>If the delivery loop is stopped, this will restart it.
   */
  @Override
  protected void onResponseImpl(InnerT response) {
    synchronized (lock) {
      Preconditions.checkState(awaitingInner, "Received unsolicited response from upstream");
      awaitingInner = false;
      reframer.push(response);
    }
    deliver();
  }

  /**
   * Process inner/upstream callable's onError notification. This will be queued to be delivered
   * after the delegate exhausts its buffers.
   *
   * <p>If the delivery loop is stopped, this will restart it.
   */
  @Override
  protected void onErrorImpl(Throwable t) {
    synchronized (lock) {
      if (error == null) {
        error = t;
      }
      closeOnDone = true;
    }
    deliver();
  }

  /**
   * Process inner/upstream callable's onComplete notification. This will be queued to be delivered
   * after the delegate exhausts its buffers.
   *
   * <p>If the delivery loop is stopped, this will restart it.
   */
  @Override
  protected void onCompleteImpl() {
    synchronized (lock) {
      closeOnDone = true;
    }
    deliver();
  }

  /** Tries to kick off the delivery loop, wrapping it in error handling. */
  private void deliver() {
    // Ensure mutual exclusion via the inDelivery flag; if there is a currently active delivery
    // then use the missed flag to schedule an extra delivery run.
    synchronized (lock) {
      if (inDelivery) {
        missed = true;
        return;
      }
      inDelivery = true;
    }

    try {
      unsafeDeliver();
    } catch (Throwable t) {
      // This should never happen. If does, it means we are in an inconsistent state and should
      // close the stream
      // and prevent further processing. This is accomplished by purposefully leaving the inDelivery
      // flag set and
      // notifying the outerResponseObserver of the error. Care must be taken to avoid calling close
      // twice in
      // case the first invocation threw an error.
      final boolean forceClose;
      synchronized (lock) {
        forceClose = !closed;
        closed = true;
      }

      if (forceClose) {
        outerResponseObserver.onError(t);
      }
    }
  }

  /** The internal states of the delivery loop */
  private enum DeliveryAction {
    /** There is supply & demand, so deliver the current message */
    DELIVER,
    /** There is demand but no supply, so request more from upstream */
    REQUEST_MORE,
    /** There is demand but no supply and with an outstanding request, so do nothing */
    AWAIT_MORE_DATA,
    /** Demand has been fully supplied */
    FULFILLED,
    /** The stream should be closed for various reasons */
    CLOSE,
    /** The stream is already closed, do nothing */
    NOOP,
  }

  /**
   * Coordinates state transfer between inner/downstream callable and the outer/upstream. It
   * orchestrates the flow of demand from downstream to upstream. The data flows from upstream
   * through the delegate to downstream. It is back pressure aware and will only send as many
   * messages as were requested. However, it will send unsolicited onComplete & onError messages.
   *
   * <p>This method is thread safe and performs all state changes (including interactions with the
   * Reframer) in a synchronized block. The lock is released when interacting with outer/downstream
   * {@link ResponseObserver} and the inner/upstream callable.
   */
  private void unsafeDeliver() {
    // Outer loop: will iterate while there missed deliveries
    while (true) {
      DeliveryAction action;
      Throwable closeError = null;

      // Data pump: will loop while there is both supply & demand.
      do {
        OuterT result = null;

        synchronized (lock) {
          if (closed) {
            // Nothing to do.
            action = DeliveryAction.NOOP;
          }
          // Check for early cancellation.
          else if (!deferError && error != null) {
            closed = true;
            closeError = this.error;
            action = DeliveryAction.CLOSE;
          }
          // There is supply & demand: schedule delivery.
          else if (numPending > 0 && reframer.hasFullFrame()) {
            result = reframer.pop();
            if (!autoFlowControl) {
              numPending--;
            }
            action = DeliveryAction.DELIVER;
          }
          // There is demand, the buffer is empty, request more from upstream.
          else if (numPending > 0 && !reframer.hasFullFrame() && !closeOnDone) {
            if (!awaitingInner) {
              action = DeliveryAction.REQUEST_MORE;
              awaitingInner = true;
            } else {
              action = DeliveryAction.AWAIT_MORE_DATA;
            }
          }
          // There is no supply and more can't be requested, notify regardless of demand
          else if (!reframer.hasFullFrame() && closeOnDone) {
            if (error == null && reframer.hasPartialFrame()) {
              error = new IncompleteStreamException();
            }
            closed = true;
            closeError = error;
            action = DeliveryAction.CLOSE;
          }
          // demand has been fulfilled, do nothing
          else if (numPending == 0) {
            action = DeliveryAction.FULFILLED;
          } else {
            throw new IllegalStateException("ReframingResponseObserver is in an unexpected state");
          }
        }

        if (action == DeliveryAction.DELIVER) {
          outerResponseObserver.onResponse(result);
        }
      } while (action == DeliveryAction.DELIVER);

      switch (action) {
        case REQUEST_MORE:
          innerController.request(1);
          break;
        case CLOSE:
          if (closeError != null) {
            outerResponseObserver.onError(closeError);
          } else {
            outerResponseObserver.onComplete();
          }
          break;
      }

      // exit only if there were no missed delivery requests
      synchronized (lock) {
        if (missed) {
          missed = false;
          continue;
        }

        inDelivery = false;
        return;
      }
    }
  }
}
