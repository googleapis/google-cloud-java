/*
 * Copyright 2017 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.spi.SpannerRpcFactory;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.grpc.ManagedChannelBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/** Options for the Cloud Spanner service. */
public class SpannerOptions extends ServiceOptions<Spanner, SpannerOptions> {
  private static final long serialVersionUID = 2789571558532701170L;

  private static final String API_SHORT_NAME = "Spanner";
  private static final String DEFAULT_HOST = "https://spanner.googleapis.com";
  private static final ImmutableSet<String> SCOPES =
      ImmutableSet.of(
          "https://www.googleapis.com/auth/spanner.admin",
          "https://www.googleapis.com/auth/spanner.data");
  private static final int MAX_CHANNELS = 256;
  private final TransportChannelProvider channelProvider;

  @SuppressWarnings("rawtypes")
  private final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator;

  private final GrpcInterceptorProvider interceptorProvider;
  private final SessionPoolOptions sessionPoolOptions;
  private final int prefetchChunks;
  private final int numChannels;
  private final ImmutableMap<String, String> sessionLabels;

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
      return new GapicSpannerRpc(options);
    }
  }

  private SpannerOptions(Builder builder) {
    super(SpannerFactory.class, SpannerRpcFactory.class, builder, new SpannerDefaults());
    numChannels = builder.numChannels;
    Preconditions.checkArgument(
        numChannels >= 1 && numChannels <= MAX_CHANNELS,
        "Number of channels must fall in the range [1, %s], found: %s",
        MAX_CHANNELS,
        numChannels);

    channelProvider = builder.channelProvider;
    channelConfigurator = builder.channelConfigurator;
    interceptorProvider = builder.interceptorProvider;
    sessionPoolOptions =
        builder.sessionPoolOptions != null
            ? builder.sessionPoolOptions
            : SessionPoolOptions.newBuilder().build();
    prefetchChunks = builder.prefetchChunks;
    sessionLabels = builder.sessionLabels;
  }

  /** Builder for {@link SpannerOptions} instances. */
  public static class Builder
      extends ServiceOptions.Builder<Spanner, SpannerOptions, SpannerOptions.Builder> {
    private static final int DEFAULT_PREFETCH_CHUNKS = 4;
    private TransportChannelProvider channelProvider;

    @SuppressWarnings("rawtypes")
    private ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator;

    private GrpcInterceptorProvider interceptorProvider;

    /** By default, we create 4 channels per {@link SpannerOptions} */
    private int numChannels = 4;

    private int prefetchChunks = DEFAULT_PREFETCH_CHUNKS;
    private SessionPoolOptions sessionPoolOptions;
    private ImmutableMap<String, String> sessionLabels;

    private Builder() {}

    Builder(SpannerOptions options) {
      super(options);
      this.numChannels = options.numChannels;
      this.sessionPoolOptions = options.sessionPoolOptions;
      this.prefetchChunks = options.prefetchChunks;
      this.sessionLabels = options.sessionLabels;
      this.channelProvider = options.channelProvider;
      this.channelConfigurator = options.channelConfigurator;
      this.interceptorProvider = options.interceptorProvider;
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only grpc transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    /**
     * Sets the {@code ChannelProvider}. {@link GapicSpannerRpc} would create a default one if none
     * is provided.
     */
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
      this.channelProvider = channelProvider;
      return this;
    }

    /**
     * Sets an {@link ApiFunction} that will be used to configure the transport channel. This will
     * only be used if no custom {@link TransportChannelProvider} has been set.
     */
    public Builder setChannelConfigurator(
        @SuppressWarnings("rawtypes")
            ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator) {
      this.channelConfigurator = channelConfigurator;
      return this;
    }

    /**
     * Sets the {@code GrpcInterceptorProvider}. {@link GapicSpannerRpc} would create a default one
     * if none is provided.
     */
    public Builder setInterceptorProvider(GrpcInterceptorProvider interceptorProvider) {
      this.interceptorProvider = interceptorProvider;
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
     * Sets the labels to add to all Sessions created in this client.
     *
     * @param sessionLabels Map from label key to label value. Label key and value cannot be null.
     *     For more information on valid syntax see <a
     *     href="https://cloud.google.com/spanner/docs/reference/rpc/google.spanner.v1#google.spanner.v1.Session">
     *     api docs </a>.
     */
    public Builder setSessionLabels(Map<String, String> sessionLabels) {
      Preconditions.checkNotNull(sessionLabels, "Session labels map cannot be null");
      for (String value : sessionLabels.values()) {
        Preconditions.checkNotNull(value, "Null values are not allowed in the labels map.");
      }
      this.sessionLabels = ImmutableMap.copyOf(sessionLabels);
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

    @Override
    public SpannerOptions build() {
      return new SpannerOptions(this);
    }
  }

  /** Returns default instance of {@code SpannerOptions}. */
  public static SpannerOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public TransportChannelProvider getChannelProvider() {
    return channelProvider;
  }

  @SuppressWarnings("rawtypes")
  public ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> getChannelConfigurator() {
    return channelConfigurator;
  }

  public GrpcInterceptorProvider getInterceptorProvider() {
    return interceptorProvider;
  }

  public int getNumChannels() {
    return numChannels;
  }

  public SessionPoolOptions getSessionPoolOptions() {
    return sessionPoolOptions;
  }

  public Map<String, String> getSessionLabels() {
    return sessionLabels;
  }

  public int getPrefetchChunks() {
    return prefetchChunks;
  }

  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  private static class SpannerDefaults implements ServiceDefaults<Spanner, SpannerOptions> {

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

  public String getEndpoint() {
    URL url;
    try {
      url = new URL(getHost());
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Invalid host: " + getHost(), e);
    }
    return String.format(
        "%s:%s", url.getHost(), url.getPort() < 0 ? url.getDefaultPort() : url.getPort());
  }
}
