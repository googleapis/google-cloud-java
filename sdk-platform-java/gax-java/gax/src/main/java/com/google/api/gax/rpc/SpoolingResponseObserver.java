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

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * A {@link ResponseObserver} that buffers the results from a {@link ServerStreamingCallable} in an
 * {@link ApiFuture}.
 *
 * <p>Package-private for internal use.
 *
 * @param <ResponseT> The type of the element in the stream.
 */
class SpoolingResponseObserver<ResponseT> extends StateCheckingResponseObserver<ResponseT> {
  private final MyFuture future = new MyFuture();
  private StreamController controller;
  private final List<ResponseT> buffer = Lists.newArrayList();

  ApiFuture<List<ResponseT>> getFuture() {
    return future;
  }

  @Override
  protected void onStartImpl(StreamController controller) {
    // NOTE: the call is started before the future is exposed to the caller
    this.controller = controller;
  }

  @Override
  protected void onResponseImpl(ResponseT response) {
    buffer.add(response);
  }

  @Override
  protected void onErrorImpl(Throwable t) {
    future.setException(t);
  }

  @Override
  protected void onCompleteImpl() {
    future.set(buffer);
  }

  /** Simple implementation of a future that allows the receiver to cancel the underlying stream. */
  class MyFuture extends AbstractApiFuture<List<ResponseT>> {
    @Override
    protected void interruptTask() {
      SpoolingResponseObserver.this.controller.cancel();
    }

    @Override
    protected boolean set(List<ResponseT> value) {
      return super.set(value);
    }

    @Override
    protected boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }
  }
}
