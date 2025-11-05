/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.grpc.fallback;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import javax.annotation.Nullable;

class MonitoringInterceptor implements ClientInterceptor {
  private Consumer<Code> statusCodeConsumer;

  MonitoringInterceptor(Consumer<Status.Code> statusCodeConsumer) {
    this.statusCodeConsumer = statusCodeConsumer;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new MonitoredClientCall<>(statusCodeConsumer, next, method, callOptions);
  }

  static class MonitoredClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {

    private final ClientCall<ReqT, RespT> delegateCall;
    private final AtomicBoolean decremented = new AtomicBoolean(false);
    private final Consumer<Status.Code> statusCodeConsumer;

    protected MonitoredClientCall(
        Consumer<Status.Code> statusCodeConsumer,
        Channel channel,
        MethodDescriptor<ReqT, RespT> methodDescriptor,
        CallOptions callOptions) {
      this.statusCodeConsumer = statusCodeConsumer;
      this.delegateCall = channel.newCall(methodDescriptor, callOptions);
    }

    @Override
    protected ClientCall<ReqT, RespT> delegate() {
      return delegateCall;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {

      Listener<RespT> listener =
          new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
              responseListener) {
            @Override
            public void onClose(Status status, Metadata trailers) {
              // Use atomic to account for the race between onClose and cancel.
              if (!decremented.getAndSet(true)) {
                statusCodeConsumer.accept(status.getCode());
              }
              super.onClose(status, trailers);
            }
          };

      delegateCall.start(listener, headers);
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      // Use atomic to account for the race between onClose and cancel.
      if (!decremented.getAndSet(true)) {
        statusCodeConsumer.accept(Status.Code.CANCELLED);
      }
      delegateCall.cancel(message, cause);
    }
  }
}
