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

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.TimeUnit;

class ManagedHttpJsonInterceptorChannel extends ManagedHttpJsonChannel {

  private final ManagedHttpJsonChannel channel;
  private final HttpJsonClientInterceptor interceptor;

  ManagedHttpJsonInterceptorChannel(
      ManagedHttpJsonChannel channel, HttpJsonClientInterceptor interceptor) {
    super();
    this.channel = channel;
    this.interceptor = interceptor;
  }

  @VisibleForTesting
  ManagedHttpJsonChannel getChannel() {
    return channel;
  }

  @Override
  public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> newCall(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor, HttpJsonCallOptions callOptions) {
    return interceptor.interceptCall(methodDescriptor, callOptions, channel);
  }

  @Override
  public synchronized void shutdown() {
    channel.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return channel.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return channel.isTerminated();
  }

  @Override
  public void shutdownNow() {
    channel.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return channel.awaitTermination(duration, unit);
  }

  @Override
  public void close() {
    channel.close();
  }
}
