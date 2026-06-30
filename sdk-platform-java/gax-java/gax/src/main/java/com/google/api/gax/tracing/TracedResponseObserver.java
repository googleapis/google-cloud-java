/*
 * Copyright 2019 Google LLC
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
package com.google.api.gax.tracing;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;

/**
 * A {@link ResponseObserver} to mark a started operation trace as finished.
 *
 * <p>The operation will be marked as complete before notifying the wrapped observer. Which means
 * that the span of the instrumentation will not include processing of the innerObserver's
 * onComplete.
 */
@InternalApi
class TracedResponseObserver<ResponseT> implements ResponseObserver<ResponseT> {
  private final ApiTracer tracer;
  private final ResponseObserver<ResponseT> innerObserver;
  private AtomicBoolean wasCancelled;

  TracedResponseObserver(
      @Nonnull ApiTracer tracer, @Nonnull ResponseObserver<ResponseT> innerObserver) {
    this(tracer, innerObserver, new AtomicBoolean());
  }

  TracedResponseObserver(
      @Nonnull ApiTracer tracer,
      @Nonnull ResponseObserver<ResponseT> innerObserver,
      @Nonnull AtomicBoolean wasCancelled) {
    this.tracer = Preconditions.checkNotNull(tracer, "tracer");
    this.innerObserver = Preconditions.checkNotNull(innerObserver, "innerObserver");
    this.wasCancelled = Preconditions.checkNotNull(wasCancelled, "wasCancelled");
  }

  @Override
  public void onStart(final StreamController controller) {
    innerObserver.onStart(
        new StreamController() {
          @Override
          public void cancel() {
            wasCancelled.set(true);
            controller.cancel();
          }

          @Override
          public void disableAutoInboundFlowControl() {
            controller.disableAutoInboundFlowControl();
          }

          @Override
          public void request(int count) {
            controller.request(count);
          }
        });
  }

  @Override
  public void onResponse(ResponseT response) {
    tracer.responseReceived();
    innerObserver.onResponse(response);
  }

  @Override
  public void onError(Throwable t) {
    // Only mark explicit user cancellations. Since the retry logic can also throw
    // CancellationException, we can't simply check that t is an instance of a
    // CancellationException.
    if (wasCancelled.get()) {
      tracer.operationCancelled();
    } else {
      tracer.operationFailed(t);
    }
    innerObserver.onError(t);
  }

  @Override
  public void onComplete() {
    tracer.operationSucceeded();
    innerObserver.onComplete();
  }
}
