/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it.util;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

/** Implements a client interceptor to retrieve the metadata from a GRPC client request. */
public class GrpcCapturingClientInterceptor implements ClientInterceptor {
  public Metadata metadata;

  @Override
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> interceptCall(
      MethodDescriptor<RequestT, ResponseT> method, final CallOptions callOptions, Channel next) {
    ClientCall<RequestT, ResponseT> call = next.newCall(method, callOptions);
    return new ForwardingClientCall.SimpleForwardingClientCall<RequestT, ResponseT>(call) {
      @Override
      public void start(Listener<ResponseT> responseListener, Metadata headers) {
        Listener<ResponseT> wrappedListener =
            new SimpleForwardingClientCallListener<ResponseT>(responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                if (status.isOk()) {
                  metadata = trailers;
                }
                super.onClose(status, trailers);
              }
            };

        super.start(wrappedListener, headers);
      }
    };
  }

  private static class SimpleForwardingClientCallListener<RespT>
      extends ClientCall.Listener<RespT> {
    private final ClientCall.Listener<RespT> delegate;

    SimpleForwardingClientCallListener(ClientCall.Listener<RespT> delegate) {
      this.delegate = delegate;
    }

    @Override
    public void onHeaders(Metadata headers) {
      delegate.onHeaders(headers);
    }

    @Override
    public void onMessage(RespT message) {
      delegate.onMessage(message);
    }

    @Override
    public void onClose(Status status, Metadata trailers) {
      delegate.onClose(status, trailers);
    }

    @Override
    public void onReady() {
      delegate.onReady();
    }
  }
}
