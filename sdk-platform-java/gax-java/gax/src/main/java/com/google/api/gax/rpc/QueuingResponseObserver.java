/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import com.google.common.collect.Queues;
import java.util.concurrent.BlockingQueue;

/**
 * A back pressure aware bridge from a {@link ResponseObserver} to a {@link BlockingQueue}. The
 * queue size is fixed to 1 item and a close signal. The observer will manage its own flow control,
 * keeping the queue in one of 3 states:
 *
 * <ul>
 *   <li>empty: a item has been requested and we are awaiting the next item
 *   <li>1 item: an in progress stream with 1 item buffered
 *   <li>1 control signal: either a Throwable, or an EOF_MARKER which means that the stream is
 *       closed
 *   <li>1 item & 1 control signal: this is the last item of the stream
 * </ul>
 *
 * <p>The observer can also be abruptly cancelled, which cancels the underlying call and always
 * returns an EOF_MARKER.
 *
 * <p>Package-private for internal use.
 *
 * @param <V> The item type.
 */
final class QueuingResponseObserver<V> extends StateCheckingResponseObserver<V> {
  static final Object EOF_MARKER = new Object();

  private final BlockingQueue<Object> buffer = Queues.newArrayBlockingQueue(2);
  private StreamController controller;
  private boolean isCancelled;

  void request() {
    controller.request(1);
  }

  Object getNext() throws InterruptedException {
    if (isCancelled) {
      return EOF_MARKER;
    }
    return buffer.take();
  }

  boolean isReady() {
    return isCancelled || !buffer.isEmpty();
  }

  /**
   * Cancels the underlying RPC and causes getNext to always return EOF_MARKER. This can only be
   * called after starting the underlying call.
   */
  void cancel() {
    isCancelled = true;
    controller.cancel();
  }

  /**
   * Before starting the RPC, disable automatic flow control and retain a reference to the
   * controller.
   *
   * @param controller The controller for the stream.
   */
  @Override
  protected void onStartImpl(StreamController controller) {
    this.controller = controller;
    controller.disableAutoInboundFlowControl();
    controller.request(1);
  }

  /**
   * Buffer the response. There should be at most 1 response in the buffer.
   *
   * @param response The received response.
   */
  @Override
  protected void onResponseImpl(V response) {
    buffer.add(response);
  }

  /**
   * Enqueue the error to be thrown later on. The error might occur without a request so the queue
   * might grow to 2 elements, and in that case the previous response will be consumed first.
   *
   * @param t The error occurred on the stream
   */
  @Override
  protected void onErrorImpl(Throwable t) {
    buffer.add(t);
  }

  /**
   * Enqueue a marker to notify the consumer that the stream is finished. In most situations this
   * will cause the queue to grow to 2 elements: the requested response and an unsolicited
   * completion marker.
   */
  @Override
  protected void onCompleteImpl() {
    buffer.add(EOF_MARKER);
  }
}
