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
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.data.v2.stub.SafeResponseObserver;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
 *    public void call(Request request, ResponseObserver<FullResponse> outerResponseObserver,
 * ApiCallContext context) {
 *      Reframer<Chunk, FullResponse> myReframer = new Reframer<>();
 *      innerCallable.call(request, new ReframingResponseObserver(myReframer, outerResponseObserver),
 * context);
 *    }
 *  }
 * }</pre>
 */
@InternalApi
public class ReframingResponseObserver<InnerT, OuterT> extends SafeResponseObserver<InnerT> {
  // Used as a nonblocking mutex for deliver().
  // 0 means unlocked
  // 1 means locked without contention
  // > 1 means locked with contention (another thread tried to deliver concurrently)
  private final AtomicInteger lock = new AtomicInteger();

  private final ResponseObserver<OuterT> outerResponseObserver;
  private final Reframer<OuterT, InnerT> reframer;

  // Written in the initial calling thread.
  private StreamController innerController;
  private boolean hasStarted;
  private boolean autoFlowControl = true;

  // Read and written by different threads w/o lock.
  private final AtomicInteger numRequested = new AtomicInteger();
  // Written by an application thread and read under lock in delivery.
  private final AtomicReference<Throwable> cancellation = new AtomicReference<>();

  // Only written under lock
  private volatile boolean awaitingInner;
  // Written by multiple interleaved threads. It is the staging area for messages before they are
  // fed to the Reframer. It protects the Reframer from having to worry about concurrency, by acting
  // like a single item queue: a GRPC thread puts a value in, and then, after acquiring the lock,
  // any thread can take the value out and feed it to the Reframer.
  private final AtomicReference<InnerT> newItem = new AtomicReference<>();

  // Written by a GRPC thread, and read by any thread after acquiring a lock
  // Care must be to taken to read the volatile done before accessing error.
  private Throwable error;
  private volatile boolean done;

  // Always written and read by the same thread under lock.
  // Safety flag set in the delivery loop before notifying the outer observer of termination.
  // It's checked by error handling in delivery() to avoid double notifying the outer observer.
  private boolean finished;

  public ReframingResponseObserver(
      ResponseObserver<OuterT> observer, Reframer<OuterT, InnerT> reframer) {
    super(observer);
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
            numRequested.set(0);
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
      numRequested.set(Integer.MAX_VALUE);
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

    while (true) {
      int current = numRequested.get();
      if (current == Integer.MAX_VALUE) {
        return;
      }

      int newValue = IntMath.saturatedAdd(current, count);
      if (numRequested.compareAndSet(current, newValue)) {
        break;
      }
    }

    deliver();
  }

  /**
   * Cancels the stream and notifies the downstream {@link ResponseObserver#onError(Throwable)}.
   * This method can be called multiple times, but only the first time has any effect. Please note
   * that there is a race condition between cancellation and the stream completing normally.
   */
  private void onCancel() {
    if (cancellation.compareAndSet(null, new CancellationException("User cancelled stream"))) {
      innerController.cancel();
    }

    deliver();
  }

  /**
   * Accept a new response from inner/upstream callable. This message will be processed by the
   * {@link Reframer} in the delivery loop and the output will be delivered to the downstream {@link
   * ResponseObserver}.
   *
   * <p>If the delivery loop is stopped, this will restart it.
   */
  @Override
  protected void onResponseImpl(InnerT response) {
    IllegalStateException error = null;

    // Guard against unsolicited notifications
    if (!awaitingInner || !newItem.compareAndSet(null, response)) {
      // Notify downstream if it's still open
      error = new IllegalStateException("Received unsolicited response from upstream.");
      cancellation.compareAndSet(null, error);
    }
    deliver();

    // Notify upstream by throwing an exception
    if (error != null) {
      throw error;
    }
  }

  /**
   * Process inner/upstream callable's onError notification. This will be queued to be delivered
   * after the delegate exhausts its buffers.
   *
   * <p>If the delivery loop is stopped, this will restart it.
   */
  @Override
  protected void onErrorImpl(Throwable t) {
    // order of assignment matters
    error = t;
    done = true;
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
    done = true;
    deliver();
  }

  /** Tries to kick off the delivery loop, wrapping it in error handling. */
  private void deliver() {
    try {
      deliverUnsafe();
    } catch (Throwable t) {
      // This should never happen. If does, it means we are in an inconsistent state and should
      // close the stream and further processing should be prevented. This is accomplished by
      // purposefully leaving the lock non-zero and notifying the outerResponseObserver of the
      // error. Care must be taken to avoid calling close twice in case the first invocation threw
      // an error.
      try {
        innerController.cancel();
      } catch (Throwable cancelError) {
        t.addSuppressed(
            new IllegalStateException(
                "Failed to cancel upstream while recovering from an unexpected error",
                cancelError));
      }
      if (!finished) {
        outerResponseObserver.onError(t);
      }
    }
  }

  /**
   * Coordinates state transfer between inner/downstream callable and the outer/upstream. It
   * orchestrates the flow of demand from downstream to upstream. The data flows from upstream
   * through the Reframer to downstream. It is back pressure aware and will only send as many
   * messages as were requested. However, it will send unsolicited onComplete & onError messages.
   *
   * <p>This method is thread safe and performs all state changes (including interactions with the
   * Reframer) using CAS mutex.
   */
  private void deliverUnsafe() {
    // Try to acquire the lock
    if (lock.getAndIncrement() != 0) {
      return;
    }

    do {
      // Optimization: the inner loop will eager process any accumulated state, so reset the lock
      // for just this iteration. (If another event occurs during processing, it can increment the
      // lock to enqueue another iteration).
      lock.lazySet(1);

      // Process the upstream message if one exists.
      pollUpstream();

      // Eagerly notify of onComplete/onError disregarding demand.
      // NOTE: this will purposely leave wip set to avoid further deliveries.
      if (maybeFinish()) {
        return;
      }

      // Deliver as many messages as possible
      int demandSnapshot = numRequested.get();
      int delivered = 0;

      while (delivered < demandSnapshot) {
        // Deliver a message if we can
        if (reframer.hasFullFrame()) {
          delivered++;
          outerResponseObserver.onResponse(reframer.pop());
        } else {
          // Otherwise request more from upstream (if we haven't done so already)
          if (!awaitingInner) {
            awaitingInner = true;
            innerController.request(1);
          }
          break;
        }

        if (maybeFinish()) {
          return;
        }
      }

      // update the counter in bulk
      if (delivered != 0) {
        numRequested.addAndGet(-delivered);
      }
    } while (lock.decrementAndGet() != 0);
  }

  /**
   * Checks if the awaited upstream response is available. If it is, then feed it to the {@link
   * Reframer} and update the {@link #awaitingInner} flag. Upon exit, if awaitingInner is not set,
   * then done is guaranteed to reflect the current status of the upstream.
   */
  private void pollUpstream() {
    if (!awaitingInner) {
      return;
    }

    boolean localDone = this.done;

    // Try to move the new item into the reframer
    InnerT newUpstreamItem = newItem.getAndSet(null);
    if (newUpstreamItem != null) {
      reframer.push(newUpstreamItem);
      // and reset the awaiting flag, if the item arrived or upstream closed
      awaitingInner = false;
    } else if (localDone) {
      awaitingInner = false;
    }
  }

  /**
   * Completes the outer observer if appropriate.
   *
   * <p>Grounds for completion:
   *
   * <ul>
   *   <li>Caller cancelled the stream
   *   <li>Upstream has been exhausted and there is no hope of completing another frame.
   * </ul>
   *
   * <p>Upon upstream exhaustion, the outer observer will be notified via onComplete only if all
   * buffers have been consumed. Otherwise it will be notified with an IncompleteStreamException.
   *
   * @return true if the outer observer has been notified of completion.
   */
  private boolean maybeFinish() {
    // Check for cancellations
    Throwable localError = this.cancellation.get();
    if (localError != null) {
      finished = true;

      outerResponseObserver.onError(localError);
      return true;
    }

    // Check for upstream termination and exhaustion of local buffers
    if (done && !reframer.hasFullFrame() && !awaitingInner) {
      finished = true;

      if (error != null) {
        outerResponseObserver.onError(error);
      } else if (reframer.hasPartialFrame()) {
        outerResponseObserver.onError(new IncompleteStreamException());
      } else {
        outerResponseObserver.onComplete();
      }
      return true;
    }

    // No termination conditions found, go back to business as usual
    return false;
  }
}
