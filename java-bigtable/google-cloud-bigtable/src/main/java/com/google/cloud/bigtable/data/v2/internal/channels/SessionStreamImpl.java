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
package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.alts.AltsContextUtil;
import java.util.Base64;
import javax.annotation.Nullable;

public class SessionStreamImpl implements SessionStream {
  private final ClientCall<SessionRequest, SessionResponse> call;
  private volatile PeerInfo peerInfo = DISCONNECTED_PEER_INFO;

  @VisibleForTesting
  static final Metadata.Key<String> PEER_INFO_KEY =
      Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);

  public SessionStreamImpl(ClientCall<SessionRequest, SessionResponse> call) {
    this.call = call;
  }

  @Override
  public PeerInfo getPeerInfo() {
    return peerInfo;
  }

  @Override
  public void start(Listener responseListener, Metadata headers) {
    call.start(
        new ClientCall.Listener<SessionResponse>() {
          @Override
          public void onHeaders(Metadata headers) {
            String encodedStr = headers.get(PEER_INFO_KEY);
            Preconditions.checkArgument(
                !Strings.isNullOrEmpty(encodedStr),
                "Session open response headers missing %s",
                PEER_INFO_KEY.name());

            PeerInfo newPeerInfo;

            try {
              byte[] decoded = Base64.getUrlDecoder().decode(encodedStr);
              newPeerInfo = PeerInfo.parseFrom(decoded);
            } catch (Exception e) {
              throw new IllegalArgumentException(
                  "Failed to parse "
                      + PEER_INFO_KEY.name()
                      + " from the response header value: "
                      + encodedStr);
            }
            // TODO: remove these fallbacks once PeerInfo is properly populated on the server
            if (newPeerInfo.getTransportType() == TransportType.TRANSPORT_TYPE_UNKNOWN) {
              if (AltsContextUtil.check(call.getAttributes())) {
                newPeerInfo =
                    newPeerInfo.toBuilder()
                        .setTransportType(TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS)
                        .build();
              } else {
                newPeerInfo =
                    newPeerInfo.toBuilder()
                        .setTransportType(TransportType.TRANSPORT_TYPE_SESSION_UNKNOWN)
                        .build();
              }
            }
            SessionStreamImpl.this.peerInfo = newPeerInfo;
            responseListener.onBeforeSessionStart(peerInfo);
            super.onHeaders(headers);
          }

          @Override
          public void onMessage(SessionResponse message) {
            responseListener.onMessage(message);
          }

          @Override
          public void onClose(Status status, Metadata trailers) {
            responseListener.onClose(status, trailers);
          }
        },
        headers);
    call.request(Integer.MAX_VALUE);
  }

  @Override
  public void sendMessage(SessionRequest request) {
    call.sendMessage(request);
  }

  @Override
  public void halfClose() {
    call.halfClose();
  }

  @Override
  public void forceClose(@Nullable String message, @Nullable Throwable cause) {
    call.cancel("Force closed: " + message, cause);
  }
}
