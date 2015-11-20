package com.google.gcloud.pubsub.testing;

import com.google.gcloud.pubsub.spi.testing.LocalPublisherImpl;
import com.google.pubsub.v1.PublisherGrpc;

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
 * A class that runs an in-memory Publisher instance for use in tests.
 */
public class LocalPubsubHelper {
  private static int FLOW_CONTROL_WINDOW = 65 * 1024;

  private final SocketAddress address;
  private final Server server;
  private final LocalPublisherImpl publisherImpl;

  /**
   * Constructs a new LocalPubsubHelper. The method start() must
   * be called before it is used.
   */
  public LocalPubsubHelper(String addressString) {
    address = new LocalAddress(addressString);
    publisherImpl = new LocalPublisherImpl();
    NettyServerBuilder builder = NettyServerBuilder
        .forAddress(address)
        .flowControlWindow(FLOW_CONTROL_WINDOW)
        .channelType(LocalServerChannel.class);
    builder.addService(PublisherGrpc.bindService(publisherImpl));
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
    publisherImpl.reset();
  }

  /**
   * Returns the internal in-memory service.
   */
  public LocalPublisherImpl getPublisherImpl() {
    return publisherImpl;
  }

  /**
   * Creates a channel for making requests to the in-memory service.
   */
  public ManagedChannel createChannel() {
    return NettyChannelBuilder
        .forAddress(address)
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
