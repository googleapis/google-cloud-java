/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gcloud.logging.spi.v2.testing;

import com.google.logging.v2.LoggingServiceV2Grpc;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;

import java.io.IOException;
import java.net.SocketAddress;

/**
 * LocalLoggingHelper runs an in-memory Logging server for use in tests.
 */
public class LocalLoggingHelper {
  private static final int FLOW_CONTROL_WINDOW = 65 * 1024;

  private final SocketAddress address;
  private final Server server;
  private final LocalLoggingImpl loggingImpl;

  /**
   * Constructs a new LocalPubsubHelper. The method start() must
   * be called before it is used.
   */
  public LocalLoggingHelper(String addressString) {
    address = new LocalAddress(addressString);
    loggingImpl = new LocalLoggingImpl();
    NettyServerBuilder builder =
        NettyServerBuilder.forAddress(address)
            .flowControlWindow(FLOW_CONTROL_WINDOW)
            .channelType(LocalServerChannel.class);
    builder.addService(LoggingServiceV2Grpc.bindService(loggingImpl));
    server = builder.build();
  }
  /**
   * Starts the in-memory service.
   */
  public void start() {
    try {
      server.start();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  /**
   * Resets the state of the in-memory service.
   */
  public void reset() {
    loggingImpl.reset();
  }
  /**
   * Returns the internal in-memory service.
   */
  public LocalLoggingImpl getLoggingImpl() {
    return loggingImpl;
  }
  /**
   * Creates a channel for making requests to the in-memory service.
   */
  public ManagedChannel createChannel() {
    return NettyChannelBuilder.forAddress(address)
        .negotiationType(NegotiationType.PLAINTEXT)
        .channelType(LocalChannel.class)
        .build();
  }
  /**
   * Shuts down the in-memory service.
   */
  public void shutdownNow() {
    server.shutdownNow();
  }
}
