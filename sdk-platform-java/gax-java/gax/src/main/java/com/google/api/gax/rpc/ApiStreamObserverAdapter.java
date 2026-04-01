/*
 * Copyright 2018 Google LLC
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

/**
 * Backwards compatibility bridge from the new {@link ResponseObserver} api to the old {@link
 * ApiStreamObserver} api.
 *
 * <p>Package-private for internal use.
 *
 * @param <T> The type of the response.
 * @deprecated Use ResponseObserver directly
 */
@Deprecated
class ApiStreamObserverAdapter<T> extends StateCheckingResponseObserver<T> {
  private final ApiStreamObserver<T> delegate;

  ApiStreamObserverAdapter(ApiStreamObserver<T> delegate) {
    this.delegate = delegate;
  }

  @Override
  protected void onStartImpl(StreamController controller) {
    // Noop: the old style assumes automatic flow control and doesn't support cancellation.
  }

  @Override
  protected void onResponseImpl(T response) {
    delegate.onNext(response);
  }

  @Override
  protected void onErrorImpl(Throwable t) {
    delegate.onError(t);
  }

  @Override
  protected void onCompleteImpl() {
    delegate.onCompleted();
  }
}
