/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner.spi.v1;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Adds logging to rpc calls */
class LoggingInterceptor implements ClientInterceptor {

  private final Logger logger;
  private final Level level;

  LoggingInterceptor(Logger logger, Level level) {
    this.logger = logger;
    this.level = level;
  }

  private class CallLogger {

    private final MethodDescriptor<?, ?> method;

    CallLogger(MethodDescriptor<?, ?> method) {
      this.method = method;
    }

    void log(String message) {
      logger.log(
          level,
          "{0}[{1}]: {2}",
          new Object[] {
            method.getFullMethodName(), Integer.toHexString(System.identityHashCode(this)), message
          });
    }

    void logfmt(String message, Object... params) {
      log(String.format(message, params));
    }
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    if (!logger.isLoggable(level)) {
      return next.newCall(method, callOptions);
    }

    final CallLogger callLogger = new CallLogger(method);
    callLogger.log("Start");
    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        super.start(
            new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                responseListener) {
              @Override
              public void onMessage(RespT message) {
                callLogger.logfmt("Received:\n%s", message);
                super.onMessage(message);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                callLogger.logfmt("Closed with status %s and trailers %s", status, trailers);
                super.onClose(status, trailers);
              }
            },
            headers);
      }

      @Override
      public void sendMessage(ReqT message) {
        callLogger.logfmt("Send:\n%s", message);
        super.sendMessage(message);
      }

      @Override
      public void cancel(@Nullable String message, @Nullable Throwable cause) {
        callLogger.logfmt("Cancelled with message %s", message);
        super.cancel(message, cause);
      }
    };
  }
}
