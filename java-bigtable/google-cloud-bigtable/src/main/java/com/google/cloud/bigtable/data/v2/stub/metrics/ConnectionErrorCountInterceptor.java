/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.LongAdder;
import java.util.logging.Level;
import java.util.logging.Logger;

/** An interceptor which counts the number of failed responses for a channel. */
class ConnectionErrorCountInterceptor implements ClientInterceptor {
  private static final Logger LOG =
      Logger.getLogger(ConnectionErrorCountInterceptor.class.toString());
  private final LongAdder numOfErrors;
  private final LongAdder numOfSuccesses;

  ConnectionErrorCountInterceptor() {
    numOfErrors = new LongAdder();
    numOfSuccesses = new LongAdder();
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        channel.newCall(methodDescriptor, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        super.start(
            new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                // Connection accounting is non-critical, so we log the exception, but let normal
                // processing proceed.
                try {
                  handleOnCloseUnsafe(status);
                } catch (Throwable t) {
                  if (t instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                  }
                  LOG.log(
                      Level.WARNING, "Unexpected error while updating connection error stats", t);
                }
                super.onClose(status, trailers);
              }

              private void handleOnCloseUnsafe(Status status) {
                if (status.isOk()) {
                  numOfSuccesses.increment();
                } else {
                  numOfErrors.increment();
                }
              }
            },
            headers);
      }
    };
  }

  long getAndResetNumOfErrors() {
    return numOfErrors.sumThenReset();
  }

  long getAndResetNumOfSuccesses() {
    return numOfSuccesses.sumThenReset();
  }
}
