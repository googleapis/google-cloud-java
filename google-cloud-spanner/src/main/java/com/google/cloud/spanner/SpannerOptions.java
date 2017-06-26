/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.spanner.spi.v1.GrpcSpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.SpannerRpcFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLException;

/** Options for the Cloud Spanner service. */
public class SpannerOptions extends ServiceOptions<Spanner, SpannerOptions> {
  private static final String API_SHORT_NAME = "Spanner";
  private static final String DEFAULT_HOST = "https://spanner.googleapis.com";
  private static final ImmutableSet<String> SCOPES =
      ImmutableSet.of(
          "https://www.googleapis.com/auth/spanner.admin",
          "https://www.googleapis.com/auth/spanner.data");
  private static final int MAX_CHANNELS = 256;
  private static final RpcChannelFactory DEFAULT_RPC_CHANNEL_FACTORY = new NettyRpcChannelFactory();

  /** Default implementation of {@code SpannerFactory}. */
  private static class DefaultSpannerFactory implements SpannerFactory {
    private static final DefaultSpannerFactory INSTANCE = new DefaultSpannerFactory();

    @Override
    public Spanner create(SpannerOptions serviceOptions) {
      return new SpannerImpl(serviceOptions);
    }
  }

  /** Default implementation of {@code SpannerRpcFactory}. */
  private static class DefaultSpannerRpcFactory implements SpannerRpcFactory {
    private static final DefaultSpannerRpcFactory INSTANCE = new DefaultSpannerRpcFactory();

    @Override
    public ServiceRpc create(SpannerOptions options) {
      return new GrpcSpannerRpc(options);
    }
  }

  private final List<ManagedChannel> rpcChannels;
  private final SessionPoolOptions sessionPoolOptions;
  private final int prefetchChunks;
  private final int numChannels;
  private final String userAgent;

  private SpannerOptions(Builder builder) {
    super(SpannerFactory.class, SpannerRpcFactory.class, builder, new SpannerDefaults());
    numChannels = builder.numChannels;
    userAgent = builder.userAgentPrefix;
    RpcChannelFactory defaultRpcChannelFactory =
        userAgent == null
            ? DEFAULT_RPC_CHANNEL_FACTORY
            : new NettyRpcChannelFactory(userAgent);
    rpcChannels =
        createChannels(
            getHost(),
            MoreObjects.firstNonNull(builder.rpcChannelFactory, defaultRpcChannelFactory),
            numChannels);
    sessionPoolOptions =
        builder.sessionPoolOptions != null
            ? builder.sessionPoolOptions
            : SessionPoolOptions.newBuilder().build();
    prefetchChunks = builder.prefetchChunks;
  }

  /** Builder for {@link SpannerOptions} instances. */
  public static class Builder
      extends ServiceOptions.Builder<
      Spanner, SpannerOptions, SpannerOptions.Builder> {
    private static final int DEFAULT_PREFETCH_CHUNKS = 4;
    private RpcChannelFactory rpcChannelFactory;
    /** By default, we create 4 channels per {@link SpannerOptions} */
    private int numChannels = 4;

    private int prefetchChunks = DEFAULT_PREFETCH_CHUNKS;
    private SessionPoolOptions sessionPoolOptions;
    private String userAgentPrefix;

    private Builder() {}

    Builder(SpannerOptions options) {
      super(options);
      this.numChannels = options.numChannels;
      this.sessionPoolOptions = options.sessionPoolOptions;
      this.prefetchChunks = options.prefetchChunks;
      this.userAgentPrefix = options.userAgent;
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only grpc transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    /** Sets the factory for creating gRPC channels. If not set, a default will be used. */
    public Builder setRpcChannelFactory(RpcChannelFactory factory) {
      this.rpcChannelFactory = factory;
      return this;
    }

    /**
     * Sets the number of gRPC channels to use. By default 4 channels are created per {@link
     * SpannerOptions}.
     */
    public Builder setNumChannels(int numChannels) {
      this.numChannels = numChannels;
      return this;
    }

    /**
     * Sets the options for managing the session pool. If not specified then the default {@code
     * SessionPoolOptions} is used.
     */
    public Builder setSessionPoolOption(SessionPoolOptions sessionPoolOptions) {
      this.sessionPoolOptions = sessionPoolOptions;
      return this;
    }

    /**
     * Specifying this will allow the client to prefetch up to {@code prefetchChunks} {@code
     * PartialResultSet} chunks for each read and query. The data size of each chunk depends on the
     * server implementation but a good rule of thumb is that each chunk will be up to 1 MiB. Larger
     * values reduce the likelihood of blocking while consuming results at the cost of greater
     * memory consumption. {@code prefetchChunks} should be greater than 0. To get good performance
     * choose a value that is large enough to allow buffering of chunks for an entire row. Apart
     * from the buffered chunks, there can be at most one more row buffered in the client. This can
     * be overriden on a per read/query basis by {@link Options#prefetchChunks()}. If unspecified,
     * we will use a default value (currently 4).
     */
    public Builder setPrefetchChunks(int prefetchChunks) {
      this.prefetchChunks = prefetchChunks;
      return this;
    }

    /** If specified, this will be prefixed to the default user agent sent in the requests. */
    public Builder setUserAgentPrefix(String userAgentPrefix) {
      this.userAgentPrefix = userAgentPrefix;
      return this;
    }

    @Override
    public SpannerOptions build() {
      return new SpannerOptions(this);
    }
  }

  /**
   * Interface for gRPC channel creation. Most users won't need to use this, as the default covers
   * typical deployment scenarios.
   */
  public interface RpcChannelFactory {
    ManagedChannel newChannel(String host, int port);
  }

  /** Returns default instance of {@code SpannerOptions}. */
  public static SpannerOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public List<ManagedChannel> getRpcChannels() {
    return rpcChannels;
  }

  public SessionPoolOptions getSessionPoolOptions() {
    return sessionPoolOptions;
  }

  public int getPrefetchChunks() {
    return prefetchChunks;
  }

  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  /**
   * Returns the default RPC channel factory used when none is specified. This may be useful for
   * callers that wish to add interceptors to gRPC channels used by the Cloud Spanner client
   * library.
   */
  public static RpcChannelFactory getDefaultRpcChannelFactory() {
    return DEFAULT_RPC_CHANNEL_FACTORY;
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  private static List<ManagedChannel> createChannels(
      String rootUrl, RpcChannelFactory factory, int numChannels) {
    Preconditions.checkArgument(
        numChannels >= 1 && numChannels <= MAX_CHANNELS,
        "Number of channels must fall in the range [1, %s], found: %s",
        MAX_CHANNELS,
        numChannels);
    ImmutableList.Builder<ManagedChannel> builder = ImmutableList.builder();
    for (int i = 0; i < numChannels; i++) {
      builder.add(createChannel(rootUrl, factory));
    }
    return builder.build();
  }

  private static ManagedChannel createChannel(String rootUrl, RpcChannelFactory factory) {
    URL url;
    try {
      url = new URL(rootUrl);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Invalid host: " + rootUrl, e);
    }
    ManagedChannel channel =
        factory.newChannel(url.getHost(), url.getPort() > 0 ? url.getPort() : url.getDefaultPort());
    return channel;
  }

  static class NettyRpcChannelFactory implements RpcChannelFactory {
    private static final int MAX_MESSAGE_SIZE = 100 * 1024 * 1024;
    private final String userAgent;
    private final List<ClientInterceptor> interceptors;

    NettyRpcChannelFactory() {
      this(null);
    }

    NettyRpcChannelFactory(String userAgent) {
      this(userAgent, ImmutableList.<ClientInterceptor>of());
    }

    NettyRpcChannelFactory(String userAgent, List<ClientInterceptor> interceptors) {
      this.userAgent = userAgent;
      this.interceptors = interceptors;
    }

    @Override
    public ManagedChannel newChannel(String host, int port) {
      NettyChannelBuilder builder =
          NettyChannelBuilder.forAddress(host, port)
            .sslContext(newSslContext())
            .intercept(interceptors)
            .maxMessageSize(MAX_MESSAGE_SIZE);
      if (userAgent != null) {
        builder.userAgent(userAgent);
      }
      return builder.build();
    }

    private static SslContext newSslContext() {
      try {
        return GrpcSslContexts.forClient().ciphers(null).build();
      } catch (SSLException e) {
        throw new RuntimeException("SSL configuration failed: " + e.getMessage(), e);
      }
    }
  }

  private static class SpannerDefaults implements
      ServiceDefaults<Spanner, SpannerOptions> {

    @Override
    public SpannerFactory getDefaultServiceFactory() {
      return DefaultSpannerFactory.INSTANCE;
    }

    @Override
    public SpannerRpcFactory getDefaultRpcFactory() {
      return DefaultSpannerRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultGrpcTransportOptions();
    }
  }

  @Override
  public Set<String> getScopes() {
    return SCOPES;
  }

  protected SpannerRpc getSpannerRpcV1() {
    return (SpannerRpc) getRpc();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }
}
