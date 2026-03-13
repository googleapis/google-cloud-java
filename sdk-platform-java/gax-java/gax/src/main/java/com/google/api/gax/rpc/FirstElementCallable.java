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

import com.google.api.core.ApiFuture;

/**
 * Wraps a {@link ServerStreamingCallable} in a {@link UnaryCallable} that returns the first
 * element. After returning the first element, the underlying stream will be gracefully cancelled.
 *
 * <p>Package-private for internal use.
 *
 * @param <RequestT> The type of the request.
 * @param <ResponseT> The type of the item in the stream.
 */
final class FirstElementCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final ServerStreamingCallable<RequestT, ResponseT> streamingCallable;

  FirstElementCallable(ServerStreamingCallable<RequestT, ResponseT> streamingCallable) {
    this.streamingCallable = streamingCallable;
  }

  /**
   * Starts the RPC and returns a future wrapping the result. If the stream is empty, the result
   * will be null. If a request is cancelled, the future will be rejected with a {@link
   * java.util.concurrent.CancellationException}.
   *
   * @param request The request.
   * @param context {@link ApiCallContext} to make the call with
   * @return A {@link ApiFuture} wrapping a possible first element of the stream.
   */
  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
    FirstElementResponseObserver<ResponseT> observer = new FirstElementResponseObserver<>();

    streamingCallable.call(request, observer, context);
    // NOTE: Since onStart must be called synchronously on this thread, the observer is now fully
    // initialized and the future can be safely returned to the caller.
    return observer.getFuture();
  }
}
