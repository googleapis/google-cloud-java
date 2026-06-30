/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;
import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY;

import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.MethodDescriptor;
import java.util.concurrent.atomic.AtomicLong;

class RequestIdInterceptor implements ClientInterceptor {
  static final CallOptions.Key<AtomicLong> ATTEMPT_KEY = CallOptions.Key.create("Attempt");
  private static final String RESPONSE_ENCODING_KEY_NAME = "x-response-encoding";
  private static final Key<String> RESPONSE_ENCODING_KEY =
      Key.of(RESPONSE_ENCODING_KEY_NAME, Metadata.ASCII_STRING_MARSHALLER);

  RequestIdInterceptor() {}

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        XGoogSpannerRequestId requestId = callOptions.getOption(REQUEST_ID_CALL_OPTIONS_KEY);
        if (requestId != null) {
          // If grpc-gcp has set the actual channel ID, use it to update the request ID.
          // This provides the real channel ID used after channel selection, especially
          // important when dynamic channel pooling is enabled.
          Integer gcpChannelId = callOptions.getOption(GcpManagedChannel.CHANNEL_ID_KEY);
          if (gcpChannelId != null) {
            // Channel IDs from grpc-gcp are 0-based, add 1 to match request ID convention
            // where 0 means unknown and >0 means a known channel.
            requestId.setChannelId(gcpChannelId + 1);
          }
          requestId.incrementAttempt();
          headers.put(REQUEST_ID_HEADER_KEY, requestId.getHeaderValue());
        }
        super.start(responseListener, headers);
      }
    };
  }
}
