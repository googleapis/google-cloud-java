/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static com.google.cloud.datastore.Validator.validateNamespace;

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.spi.v1.GrpcDatastoreRpc;
import com.google.cloud.datastore.spi.v1.HttpDatastoreRpc;
import com.google.cloud.datastore.telemetry.TraceUtil;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DatastoreOptions extends ServiceOptions<Datastore, DatastoreOptions> {

  private static final long serialVersionUID = -1018382430058137336L;
  private static final String API_SHORT_NAME = "Datastore";
  private static final Logger logger = Logger.getLogger(DatastoreOptions.class.getName());
  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE);
  private static final String DEFAULT_DATABASE_ID = "";
  public static final String PROJECT_ID_ENV_VAR = "DATASTORE_PROJECT_ID";
  public static final String LOCAL_HOST_ENV_VAR = "DATASTORE_EMULATOR_HOST";

  // Default to a slightly larger channel count to handle a larger initial QPS. The initial
  // configuration should be able to handle a max of ~500 concurrent streams as each gRPC
  // channel can handle a max of 100 streams (limited by Google Middleware). The initial
  // configuration aims to have a max of ~250 concurrent streams and will rely on the ChannelPool
  // to resize according to the client's average load.
  public static final int INIT_CHANNEL_COUNT = 5;
  // Default to be larger than Gax's default (2) to better scale with spikes in requests
  static final int CHANNEL_POOL_DEFAULT_RESIZE_DELTA = 5;

  // Configure the min and max RPC/Channel default in accordance to Datastore configuration guide:
  // https://docs.cloud.google.com/datastore/docs/java-client-grpc#connection_pool_configuration
  static final int CHANNEL_POOL_MIN_RPCS_PER_CHANNEL = 10;
  static final int CHANNEL_POOL_MAX_RPCS_PER_CHANNEL = 50;

  public static final int MIN_CHANNEL_COUNT = 1;

  /**
   * @deprecated This constant is obsolete and will be removed in a future version.
   */
  @Deprecated public static final int MAX_CHANNEL_COUNT = 10;

  private transient TransportChannelProvider channelProvider = null;

  private final String namespace;
  private final String databaseId;
  private final ImmutableList<String> requestTags;

  private final transient @Nonnull DatastoreOpenTelemetryOptions openTelemetryOptions;
  @Nonnull private final transient TraceUtil traceUtil;

  public static class DefaultDatastoreFactory implements DatastoreFactory {

    private static final DatastoreFactory INSTANCE = new DefaultDatastoreFactory();

    @Override
    public Datastore create(DatastoreOptions options) {
      return new DatastoreImpl(options);
    }
  }

  public static class DefaultDatastoreRpcFactory implements DatastoreRpcFactory {

    private static final DatastoreRpcFactory INSTANCE = new DefaultDatastoreRpcFactory();

    @Override
    public ServiceRpc create(DatastoreOptions options) {
      try {
        if (options.getTransportOptions() instanceof GrpcTransportOptions) {
          return new GrpcDatastoreRpc(options);
        } else {
          return new HttpDatastoreRpc(options);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Nonnull
  TraceUtil getTraceUtil() {
    return traceUtil;
  }

  @BetaApi
  @Nonnull
  public DatastoreOpenTelemetryOptions getOpenTelemetryOptions() {
    return openTelemetryOptions;
  }

  public static class Builder extends ServiceOptions.Builder<Datastore, DatastoreOptions, Builder> {

    private String namespace;
    private String databaseId;
    private ImmutableList<String> requestTags = ImmutableList.of();
    private TransportChannelProvider channelProvider = null;
    private String host;

    @Nonnull
    private TransportOptions transportOptions =
        new DatastoreDefaults().getDefaultTransportOptions();

    @Nullable private DatastoreOpenTelemetryOptions openTelemetryOptions = null;

    private Builder() {}

    private Builder(DatastoreOptions options) {
      super(options);
      this.namespace = options.namespace;
      this.databaseId = options.databaseId;
      this.requestTags = options.requestTags;
      this.openTelemetryOptions = options.openTelemetryOptions;
      this.channelProvider = validateChannelProvider(options.channelProvider);
      this.host = options.getHost();
      this.transportOptions = options.getTransportOptions();
    }

    private TransportChannelProvider validateChannelProvider(
        TransportChannelProvider channelProvider) {
      Preconditions.checkNotNull(channelProvider, "TransportChannelProvider cannot be null");
      if (!(channelProvider instanceof InstantiatingGrpcChannelProvider)) {
        throw new IllegalArgumentException(
            "Only GRPC channels are allowed for " + API_SHORT_NAME + ".");
      }
      return channelProvider;
    }

    /**
     * Sets the transport options.
     *
     * @param transportOptions the transport options to set, must be {@link HttpTransportOptions} or
     *     {@link GrpcTransportOptions}
     * @return the builder
     * @throws IllegalArgumentException if the transport options are not supported
     */
    @Override
    public Builder setTransportOptions(@Nonnull TransportOptions transportOptions) {
      Preconditions.checkNotNull(transportOptions, "TransportOptions cannot be null");
      if (!(transportOptions instanceof HttpTransportOptions)
          && !(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http and grpc transport are allowed for " + API_SHORT_NAME + ".");
      }
      this.transportOptions = transportOptions;
      return super.setTransportOptions(transportOptions);
    }

    /**
     * This method deprecated. Prefer to use {@link #setTransportOptions(TransportOptions)} instead.
     * When using the transport-neutral variant, you may need to cast to TransportOptions when using
     * a GrpcTransportOptions class, otherwise it will default to the deprecated method.
     *
     * <p>Sets the transport to gRPC. Note this functionality is experimental and subject to change.
     */
    @Deprecated
    @BetaApi
    public Builder setTransportOptions(GrpcTransportOptions transportOptions) {
      return setTransportOptions((TransportOptions) transportOptions);
    }

    @Override
    public Builder setHost(String host) {
      this.host = host;
      return super.setHost(host);
    }

    /**
     * Sets the {@link TransportChannelProvider} to use with this Datastore client.
     *
     * <p>This is only compatible with clients using a gRPC transport (see {@code
     * DatastoreOptions#setTransportOptions(GrpcTransportOptions)} for more details).
     *
     * <p>This functionality is experimental and subject to change.
     *
     * @param channelProvider A InstantiatingGrpcChannelProvider object that defines the transport
     *     provider for this client.
     */
    @BetaApi
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
      this.channelProvider = validateChannelProvider(channelProvider);
      return this;
    }

    /**
     * Builds the {@link DatastoreOptions} instance.
     *
     * <p>If the host is not explicitly set, it defaults to the transport-specific default host:
     *
     * <ul>
     *   <li>gRPC: {@code datastore.googleapis.com:443}
     *   <li>HTTP: {@code https://datastore.googleapis.com}
     * </ul>
     *
     * @return the {@link DatastoreOptions} instance
     */
    @Override
    public DatastoreOptions build() {
      if (this.host == null) {
        // Use whatever host value the user passes in, otherwise use the transport specific default
        // host values
        if (this.transportOptions instanceof GrpcTransportOptions) {
          this.setHost(DatastoreSettings.getDefaultEndpoint());
        } else if (this.transportOptions instanceof HttpTransportOptions) {
          this.setHost(com.google.datastore.v1.client.DatastoreFactory.DEFAULT_HOST);
        }
      }
      return new DatastoreOptions(this);
    }

    /** Sets the default namespace to be used by the datastore service. */
    public Builder setNamespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    public Builder setDatabaseId(String databaseId) {
      this.databaseId = databaseId;
      return this;
    }

    /**
     * Sets the request tags to be associated with all requests sent by this client.
     *
     * @param requestTags the list of request tags to set
     * @return the builder object
     */
    public Builder setRequestTags(ImmutableList<String> requestTags) {
      Preconditions.checkNotNull(requestTags, "Request tags cannot be null");
      this.requestTags = requestTags;
      return this;
    }

    /**
     * Sets the request tags to be associated with all requests sent by this client.
     *
     * @param requestTags the request tags to set
     * @return the builder object
     */
    public Builder setRequestTags(String... requestTags) {
      Preconditions.checkNotNull(requestTags, "Request tags cannot be null");
      this.requestTags = ImmutableList.copyOf(requestTags);
      return this;
    }

    /**
     * Sets the {@link DatastoreOpenTelemetryOptions} to be used for this Datastore instance.
     *
     * @param openTelemetryOptions The `DatastoreOpenTelemetryOptions` to use.
     */
    @BetaApi
    @Nonnull
    public Builder setOpenTelemetryOptions(
        @Nonnull DatastoreOpenTelemetryOptions openTelemetryOptions) {
      this.openTelemetryOptions = openTelemetryOptions;
      return this;
    }
  }

  private DatastoreOptions(Builder builder) {
    super(DatastoreFactory.class, DatastoreRpcFactory.class, builder, new DatastoreDefaults());

    this.openTelemetryOptions =
        builder.openTelemetryOptions != null
            ? builder.openTelemetryOptions
            : DatastoreOpenTelemetryOptions.newBuilder().build();
    this.traceUtil = TraceUtil.getInstance(this);

    namespace = MoreObjects.firstNonNull(builder.namespace, defaultNamespace());
    databaseId = MoreObjects.firstNonNull(builder.databaseId, DEFAULT_DATABASE_ID);
    requestTags = builder.requestTags;

    // ChannelProvider is used by GAX but HttpJson does not use it so we safely ignore it.
    if (getTransportOptions() instanceof HttpTransportOptions && builder.channelProvider != null) {
      logger.warning("Channel provider is ignored for HttpJson transport.");
    } else if (getTransportOptions() instanceof GrpcTransportOptions) {
      if (builder.channelProvider == null) {
        // Set the default gRPC connection pool to be configured with a minimum of 1 channel.
        // The maximum channel count automatically defaults to 200 (as defined in gax-grpc).
        // Datastore sets the initial channel pool count to be 5 channels to allow better handle
        // large loads of requests and the resize delta to be 5 to scale quicker. In cases of low
        // load, the channel count will scale down as needed and memory will be freed. The default
        // configuration is set to try and handle an average of ~250 QPS and will scale up and down
        // as needed.
        ChannelPoolSettings datastoreChannelPoolSettings =
            ChannelPoolSettings.builder()
                .setInitialChannelCount(INIT_CHANNEL_COUNT)
                .setMinChannelCount(MIN_CHANNEL_COUNT)
                .setMinRpcsPerChannel(CHANNEL_POOL_MIN_RPCS_PER_CHANNEL)
                .setMaxRpcsPerChannel(CHANNEL_POOL_MAX_RPCS_PER_CHANNEL)
                .setMaxResizeDelta(CHANNEL_POOL_DEFAULT_RESIZE_DELTA)
                .build();

        InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
            DatastoreSettings.defaultGrpcTransportProviderBuilder()
                .setChannelPoolSettings(datastoreChannelPoolSettings)
                .setEndpoint(getHost());
        if (traceUtil.getChannelConfigurator() != null) {
          // Intercept the grpc channel calls to add telemetry info.
          channelProviderBuilder.setChannelConfigurator(traceUtil.getChannelConfigurator());
        }
        this.channelProvider = channelProviderBuilder.build();
      } else {
        this.channelProvider = builder.channelProvider;
      }
    }
  }

  public TransportChannelProvider getTransportChannelProvider() {
    return channelProvider;
  }

  @Override
  protected String getDefaultHost() {
    String host = System.getProperty(LOCAL_HOST_ENV_VAR, System.getenv(LOCAL_HOST_ENV_VAR));
    return host != null ? host : com.google.datastore.v1.client.DatastoreFactory.DEFAULT_HOST;
  }

  @Override
  protected String getDefaultProject() {
    String projectId = System.getProperty(PROJECT_ID_ENV_VAR, System.getenv(PROJECT_ID_ENV_VAR));
    return projectId != null ? projectId : super.getDefaultProject();
  }

  private static class DatastoreDefaults implements ServiceDefaults<Datastore, DatastoreOptions> {

    private final TransportOptions TRANSPORT_OPTIONS = getDefaultTransportOptionsBuilder().build();

    @Override
    public DatastoreFactory getDefaultServiceFactory() {
      return DefaultDatastoreFactory.INSTANCE;
    }

    @Override
    public DatastoreRpcFactory getDefaultRpcFactory() {
      return DefaultDatastoreRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return TRANSPORT_OPTIONS;
    }

    public static GrpcTransportOptions.Builder getDefaultTransportOptionsBuilder() {
      return GrpcTransportOptions.newBuilder();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
  }

  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  /** Returns the default namespace to be used by the datastore service. */
  public String getNamespace() {
    return namespace;
  }

  public String getDatabaseId() {
    return this.databaseId;
  }

  /**
   * Returns the request tags to be associated with all requests sent by this client.
   *
   * @return the request tags
   */
  public ImmutableList<String> getRequestTags() {
    return requestTags;
  }

  /** Returns a default {@code DatastoreOptions} instance. */
  public static DatastoreOptions getDefaultInstance() {
    return newBuilder().build();
  }

  private static String defaultNamespace() {
    try {
      Class<?> clazz = Class.forName("com.google.appengine.api.NamespaceManager");
      Method method = clazz.getMethod("get");
      String namespace = (String) method.invoke(null);
      return MoreObjects.firstNonNull(namespace, "");
    } catch (Exception ignore) {
      // return empty string (Datastore default namespace) if could not automatically determine
      return "";
    }
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected DatastoreRpc getDatastoreRpcV1() {
    return (DatastoreRpc) getRpc();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), namespace, databaseId, requestTags);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DatastoreOptions)) {
      return false;
    }
    DatastoreOptions other = (DatastoreOptions) obj;
    return baseEquals(other)
        && Objects.equals(namespace, other.namespace)
        && Objects.equals(databaseId, other.databaseId)
        && Objects.equals(requestTags, other.requestTags);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
