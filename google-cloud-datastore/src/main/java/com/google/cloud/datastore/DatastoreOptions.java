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
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DatastoreOptions extends ServiceOptions<Datastore, DatastoreOptions> {

  private static final long serialVersionUID = -1018382430058137336L;
  private static final String API_SHORT_NAME = "Datastore";
  private static final String DATASTORE_SCOPE = "https://www.googleapis.com/auth/datastore";
  private static final Set<String> SCOPES = ImmutableSet.of(DATASTORE_SCOPE);
  private static final String DEFAULT_DATABASE_ID = "";
  public static final String PROJECT_ID_ENV_VAR = "DATASTORE_PROJECT_ID";
  public static final String LOCAL_HOST_ENV_VAR = "DATASTORE_EMULATOR_HOST";
  public static final int INIT_CHANNEL_COUNT = 1;
  public static final int MIN_CHANNEL_COUNT = 1;
  public static final int MAX_CHANNEL_COUNT = 4;

  private transient TransportChannelProvider channelProvider = null;

  private final String namespace;
  private final String databaseId;

  private final transient @Nonnull DatastoreOpenTelemetryOptions openTelemetryOptions;
  private final transient @Nonnull com.google.cloud.datastore.telemetry.TraceUtil traceUtil;

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
  com.google.cloud.datastore.telemetry.TraceUtil getTraceUtil() {
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
    private TransportChannelProvider channelProvider = null;
    private String host;
    private TransportOptions transportOptions;

    @Nullable private DatastoreOpenTelemetryOptions openTelemetryOptions = null;

    private Builder() {}

    private Builder(DatastoreOptions options) {
      super(options);
      this.namespace = options.namespace;
      this.databaseId = options.databaseId;
      this.openTelemetryOptions = options.openTelemetryOptions;
      this.channelProvider = validateChannelProvider(options.channelProvider);
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      this.transportOptions = transportOptions;
      return super.setTransportOptions(transportOptions);
    }

    /**
     * Sets the transport to gRPC. Note this functionality is experimental and subject to change.
     */
    @BetaApi
    public Builder setTransportOptions(GrpcTransportOptions transportOptions) {
      this.transportOptions = transportOptions;
      return super.setTransportOptions(transportOptions);
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

    @Override
    public DatastoreOptions build() {
      if (this.host == null && this.transportOptions instanceof GrpcTransportOptions) {
        this.setHost(DatastoreSettings.getDefaultEndpoint());
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
     * Sets the {@link DatastoreOpenTelemetryOptions} to be used for this Firestore instance.
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

  private static TransportChannelProvider validateChannelProvider(
      TransportChannelProvider channelProvider) {
    if (channelProvider != null && !(channelProvider instanceof InstantiatingGrpcChannelProvider)) {
      throw new IllegalArgumentException(
          "Only GRPC channels are allowed for " + API_SHORT_NAME + ".");
    }
    return channelProvider;
  }

  private DatastoreOptions(Builder builder) {
    super(DatastoreFactory.class, DatastoreRpcFactory.class, builder, new DatastoreDefaults());

    this.openTelemetryOptions =
        builder.openTelemetryOptions != null
            ? builder.openTelemetryOptions
            : DatastoreOpenTelemetryOptions.newBuilder().build();
    this.traceUtil = com.google.cloud.datastore.telemetry.TraceUtil.getInstance(this);

    namespace = MoreObjects.firstNonNull(builder.namespace, defaultNamespace());
    databaseId = MoreObjects.firstNonNull(builder.databaseId, DEFAULT_DATABASE_ID);

    if (getTransportOptions() instanceof HttpTransportOptions && builder.channelProvider != null) {
      throw new IllegalArgumentException(
          "Only gRPC transport allows setting of channel provider or credentials provider");
    } else if (getTransportOptions() instanceof GrpcTransportOptions) {
      // For grpc transport options, configure default gRPC Connection pool with minChannelCount = 1
      // and maxChannelCount = 4
      this.channelProvider =
          builder.channelProvider != null
              ? builder.channelProvider
              : GrpcTransportOptions.setUpChannelProvider(
                  DatastoreSettings.defaultGrpcTransportProviderBuilder()
                      .setChannelPoolSettings(
                          ChannelPoolSettings.builder()
                              .setInitialChannelCount(INIT_CHANNEL_COUNT)
                              .setMinChannelCount(MIN_CHANNEL_COUNT)
                              .setMaxChannelCount(MAX_CHANNEL_COUNT)
                              .build()),
                  this);
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

    public static HttpTransportOptions.Builder getDefaultTransportOptionsBuilder() {
      return HttpTransportOptions.newBuilder();
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
    return Objects.hash(baseHashCode(), namespace, databaseId);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DatastoreOptions)) {
      return false;
    }
    DatastoreOptions other = (DatastoreOptions) obj;
    return baseEquals(other)
        && Objects.equals(namespace, other.namespace)
        && Objects.equals(databaseId, other.databaseId);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
