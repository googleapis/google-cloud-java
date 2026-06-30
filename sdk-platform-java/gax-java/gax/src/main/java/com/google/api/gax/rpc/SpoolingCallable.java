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
import java.util.List;

/**
 * Wraps a {@link ServerStreamingCallable} in a buffering {@link UnaryCallable}. The {@link
 * UnaryCallable} will buffer the entire stream in memory. This is meant to be used for short
 * streams and provides interoperability with {@link UnaryCallable} middleware like {@link
 * BatchingCallable}.
 *
 * <p>Package-private for internal use.
 *
 * @param <RequestT> The type of the request.
 * @param <ResponseT> The type of an item in the stream.
 */
class SpoolingCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, List<ResponseT>> {
  private final ServerStreamingCallable<RequestT, ResponseT> streamingCallable;

  SpoolingCallable(ServerStreamingCallable<RequestT, ResponseT> streamingCallable) {
    this.streamingCallable = streamingCallable;
  }

  /**
   * Starts the RPC and returns a future wrapping a list of results. If the stream is empty, the
   * result will be an empty list. If a request is cancelled, the future will be rejected with a
   * {@link java.util.concurrent.CancellationException}.
   *
   * @param request The request.
   * @param context {@link ApiCallContext} to make the call with.
   * @return A {@link ApiFuture} wrapping a possible first element of the stream.
   */
  @Override
  public ApiFuture<List<ResponseT>> futureCall(RequestT request, ApiCallContext context) {
    SpoolingResponseObserver<ResponseT> observer = new SpoolingResponseObserver<>();
    streamingCallable.call(request, observer, context);
    // NOTE: Since onStart must be called synchronously on this thread, the observer is now fully
    // initialized and the future can be safely returned to the caller.
    return observer.getFuture();
  }
}
