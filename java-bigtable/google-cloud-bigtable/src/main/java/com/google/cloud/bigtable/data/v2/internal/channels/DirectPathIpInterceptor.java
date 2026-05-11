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

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class DirectPathIpInterceptor implements ClientInterceptor {
  private static final Logger LOGGER = Logger.getLogger(DirectPathIpInterceptor.class.getName());

  private static final String DP_IPV6_PREFIX = "2001:4860:8040";
  private static final String DP_IPV4_PREFIX = "34.126";

  private static final AtomicInteger nextObjectId = new AtomicInteger();
  private final int myId = nextObjectId.getAndIncrement();

  private AtomicReference<SocketAddress> lastIp = new AtomicReference<>();
  private final boolean expectDirectPath;

  public DirectPathIpInterceptor(boolean expectDirectPath) {
    this.expectDirectPath = expectDirectPath;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
    ClientCall<ReqT, RespT> clientCall = channel.newCall(methodDescriptor, callOptions);
    return new SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onHeaders(Metadata headers) {
                SocketAddress socketAddress =
                    clientCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);

                if (socketAddress != null
                    && !socketAddress.equals(lastIp.getAndSet(socketAddress))) {
                  boolean directPathActive = isDirectPath(socketAddress);
                  if (directPathActive != expectDirectPath) {
                    LOGGER.warning(
                        String.format(
                            "Channel %d, Unexpected DirectPath status: %s, expected: %s. ip: %s",
                            myId, directPathActive, expectDirectPath, socketAddress));
                  }
                }
                super.onHeaders(headers);
              }
            },
            headers);
      }
    };
  }

  private static boolean isDirectPath(SocketAddress remoteAddress) {
    InetAddress inetAddress = ((InetSocketAddress) remoteAddress).getAddress();
    String addr = inetAddress.getHostAddress();

    return addr.startsWith(DP_IPV6_PREFIX) || addr.startsWith(DP_IPV4_PREFIX);
  }
}
