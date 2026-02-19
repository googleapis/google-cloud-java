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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.ResponseParams;
import com.google.common.base.Strings;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.alts.AltsContextUtil;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@InternalApi
public class MetadataExtractorInterceptor implements ClientInterceptor {
  private final SidebandData sidebandData = new SidebandData();

  public GrpcCallContext injectInto(GrpcCallContext ctx) {
    // TODO: migrate to using .withTransportChannel
    //  This will require a change on gax's side to expose the underlying ManagedChannel in
    //  GrpcTransportChannel (its currently package private).
    return ctx.withChannel(ClientInterceptors.intercept(ctx.getChannel(), this))
        .withCallOptions(ctx.getCallOptions().withOption(SidebandData.KEY, sidebandData));
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        channel.newCall(methodDescriptor, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        sidebandData.reset();

        super.start(
            new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                responseListener) {
              @Override
              public void onHeaders(Metadata headers) {
                sidebandData.onResponseHeaders(headers, getAttributes());
                super.onHeaders(headers);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                sidebandData.onClose(status, trailers);
                super.onClose(status, trailers);
              }
            },
            headers);
      }
    };
  }

  public SidebandData getSidebandData() {
    return sidebandData;
  }

  public static class SidebandData {
    private static final CallOptions.Key<SidebandData> KEY =
        CallOptions.Key.create("bigtable-sideband");

    private static final Metadata.Key<String> SERVER_TIMING_HEADER_KEY =
        Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER);
    private static final Pattern SERVER_TIMING_HEADER_PATTERN =
        Pattern.compile(".*dur=(?<dur>\\d+)");
    private static final Metadata.Key<byte[]> LOCATION_METADATA_KEY =
        Metadata.Key.of("x-goog-ext-425905942-bin", Metadata.BINARY_BYTE_MARSHALLER);
    private static final Metadata.Key<String> PEER_INFO_KEY =
        Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);

    @Nullable private volatile ResponseParams responseParams;
    @Nullable private volatile PeerInfo peerInfo;
    @Nullable private volatile Long gfeTiming;

    @Nullable
    public ResponseParams getResponseParams() {
      return responseParams;
    }

    @Nullable
    public PeerInfo getPeerInfo() {
      return peerInfo;
    }

    @Nullable
    public Long getGfeTiming() {
      return gfeTiming;
    }

    private void reset() {
      responseParams = null;
      peerInfo = null;
      gfeTiming = null;
    }

    void onResponseHeaders(Metadata md, Attributes attributes) {
      responseParams = extractResponseParams(md);
      gfeTiming = extractGfeLatency(md);
      peerInfo = extractPeerInfo(md, gfeTiming, attributes);
    }

    void onClose(Status status, Metadata trailers) {
      if (responseParams == null) {
        responseParams = extractResponseParams(trailers);
      }
    }

    @Nullable
    private static Long extractGfeLatency(Metadata metadata) {
      String serverTiming = metadata.get(SERVER_TIMING_HEADER_KEY);
      if (serverTiming == null) {
        return null;
      }
      Matcher matcher = SERVER_TIMING_HEADER_PATTERN.matcher(serverTiming);
      // this should always be true
      if (matcher.find()) {
        return Long.parseLong(matcher.group("dur"));
      }
      return null;
    }

    @Nullable
    private static PeerInfo extractPeerInfo(
        Metadata metadata, Long gfeTiming, Attributes attributes) {
      String encodedStr = metadata.get(PEER_INFO_KEY);
      if (Strings.isNullOrEmpty(encodedStr)) {
        return null;
      }

      try {
        byte[] decoded = Base64.getUrlDecoder().decode(encodedStr);
        PeerInfo peerInfo = PeerInfo.parseFrom(decoded);
        PeerInfo.TransportType effectiveTransport = peerInfo.getTransportType();

        // TODO: remove this once transport_type is being sent by the server
        //  This is a temporary workaround to detect directpath until its available from the server
        if (effectiveTransport == PeerInfo.TransportType.TRANSPORT_TYPE_UNKNOWN) {
          boolean isAlts = AltsContextUtil.check(attributes);
          if (isAlts) {
            effectiveTransport = PeerInfo.TransportType.TRANSPORT_TYPE_DIRECT_ACCESS;
          } else if (gfeTiming != null) {
            effectiveTransport = PeerInfo.TransportType.TRANSPORT_TYPE_CLOUD_PATH;
          }
        }
        if (effectiveTransport != PeerInfo.TransportType.TRANSPORT_TYPE_UNKNOWN) {
          peerInfo = peerInfo.toBuilder().setTransportType(effectiveTransport).build();
        }
        return peerInfo;
      } catch (Exception e) {
        throw new IllegalArgumentException(
            "Failed to parse "
                + PEER_INFO_KEY.name()
                + " from the response header value: "
                + encodedStr);
      }
    }

    @Nullable
    private static ResponseParams extractResponseParams(Metadata metadata) {
      byte[] responseParams = metadata.get(LOCATION_METADATA_KEY);
      if (responseParams != null) {
        try {
          return ResponseParams.parseFrom(responseParams);
        } catch (InvalidProtocolBufferException e) {
        }
      }
      return null;
    }
  }
}
