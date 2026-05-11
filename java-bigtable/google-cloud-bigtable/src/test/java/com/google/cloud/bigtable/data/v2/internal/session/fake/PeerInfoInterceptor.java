/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session.fake;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import java.util.Base64;

public class PeerInfoInterceptor implements ServerInterceptor {
  private static final Metadata.Key<String> PEER_INFO_KEY =
      Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(
      ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

    return next.startCall(
        new SimpleForwardingServerCall<ReqT, RespT>(call) {
          @Override
          public void sendHeaders(Metadata headers) {
            PeerInfo peerInfo =
                PeerInfo.newBuilder()
                    .setTransportType(TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS)
                    .setApplicationFrontendRegion("local")
                    .setApplicationFrontendSubzone("ll")
                    .build();
            String encoded = Base64.getUrlEncoder().encodeToString(peerInfo.toByteArray());
            headers.put(PEER_INFO_KEY, encoded);
            super.sendHeaders(headers);
          }
        },
        headers);
  }
}
