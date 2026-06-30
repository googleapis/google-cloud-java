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

import java.util.concurrent.CancellationException;

/**
 * Allows the implementer of {@link ResponseObserver} to control the flow of responses.
 *
 * <p>An instance of this class will be passed to {@link
 * ResponseObserver#onStart(StreamController)}, at which point the receiver can disable automatic
 * flow control. The receiver can also save a reference to the instance and terminate the stream
 * early using {@code cancel()}.
 */
public interface StreamController {
  /**
   * Cancel the stream early.
   *
   * <p>This will manifest as an onError on the {@link ResponseObserver} with the cause being a
   * {@link CancellationException}.
   */
  void cancel();

  /**
   * Disables automatic flow control.
   *
   * <p>The next response is requested immediately after the current response is processed by {@link
   * ResponseObserver#onResponse(Object)}. If disabled, an application must make explicit calls to
   * {@link #request} to receive messages.
   */
  void disableAutoInboundFlowControl();

  /**
   * Requests up to the given number of responses from the call to be delivered to {@link
   * ResponseObserver#onResponse(Object)}. No additional messages will be delivered.
   *
   * <p>This method can only be called after disabling automatic flow control.
   *
   * <p>Message delivery is guaranteed to be sequential in the order received. In addition, the
   * listener methods will not be accessed concurrently. While it is not guaranteed that the same
   * thread will always be used, it is guaranteed that only a single thread will access the listener
   * at a time.
   *
   * <p>If called multiple times, the number of messages able to delivered will be the sum of the
   * calls.
   *
   * <p>This method is safe to call from multiple threads without external synchronizaton.
   *
   * @param count the requested number of messages to be delivered to the listener. Must be
   *     non-negative.
   */
  void request(int count);
}
