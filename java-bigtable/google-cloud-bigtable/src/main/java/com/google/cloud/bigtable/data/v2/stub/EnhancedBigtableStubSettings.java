/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchingCallSettings;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.internal.PrepareQueryRequest;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.stub.metrics.DefaultMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.metrics.MetricsProvider;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Settings class to configure an instance of {@link EnhancedBigtableStub}.
 *
 * <p>Sane defaults are provided for most settings:
 *
 * <ul>
 *   <li>The default service address (bigtable.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The only required setting is the instance name.
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <pre>{@code
 * BigtableDataSettings.Builder settingsBuilder = BigtableDataSettings.newBuilder()
 *   .setProjectId("my-project-id")
 *   .setInstanceId("my-instance-id")
 *   .setAppProfileId("default");
 *
 * settingsBuilder.stubSettings().readRowsSettings()
 *  .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE);
 *
 * BigtableDataSettings settings = builder.build();
 * }</pre>
 */
public class EnhancedBigtableStubSettings extends StubSettings<EnhancedBigtableStubSettings> {
  // The largest message that can be received is a 256 MB ReadRowsResponse.
  private static final int MAX_MESSAGE_SIZE = 256 * 1024 * 1024;
  private static final String SERVER_DEFAULT_APP_PROFILE_ID = "";

  // TODO(meeral-k): add documentation
  private static final boolean DIRECT_PATH_ENABLED =
      Boolean.parseBoolean(System.getenv("CBT_ENABLE_DIRECTPATH"));

  // If true, disable the bound-token-by-default feature for DirectPath.
  private static final boolean DIRECT_PATH_BOUND_TOKEN_DISABLED =
      Boolean.parseBoolean(System.getenv("CBT_DISABLE_DIRECTPATH_BOUND_TOKEN"));

  /**
   * Scopes that are equivalent to JWT's audience.
   *
   * <p>When the credentials provider contains any of these scopes (default behavior) and the
   * application default credentials point to a service account, then OAuth2 tokens will be replaced
   * with JWT tokens. This removes the need for access token refreshes.
   */
  private static final ImmutableList<String> JWT_ENABLED_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.data")
          .add("https://www.googleapis.com/auth/cloud-bigtable.data")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  /**
   * Default jwt audience is always the service name unless it's override to test / staging for
   * testing.
   */
  private static final String DEFAULT_DATA_JWT_AUDIENCE = "https://bigtable.googleapis.com/";

  private final String projectId;
  private final String instanceId;
  private final String appProfileId;
  private final boolean isRefreshingChannel;

  private final ClientOperationSettings perOpSettings;

  private final FeatureFlags featureFlags;

  private final MetricsProvider metricsProvider;
  @Nullable private final String metricsEndpoint;
  private final boolean areInternalMetricsEnabled;
  private final String jwtAudience;

  private EnhancedBigtableStubSettings(Builder builder) {
    super(builder);

    projectId = builder.projectId;
    instanceId = builder.instanceId;
    appProfileId = builder.appProfileId;
    isRefreshingChannel = builder.isRefreshingChannel;
    metricsProvider = builder.metricsProvider;
    metricsEndpoint = builder.metricsEndpoint;
    areInternalMetricsEnabled = builder.areInternalMetricsEnabled;
    jwtAudience = builder.jwtAudience;

    perOpSettings = new ClientOperationSettings(builder.perOpSettings);
    featureFlags = builder.featureFlags.build();
  }

  /** Create a new builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns the project id of the target instance. */
  public String getProjectId() {
    return projectId;
  }

  /** Returns the target instance id. */
  public String getInstanceId() {
    return instanceId;
  }

  /** Returns the configured AppProfile to use */
  public String getAppProfileId() {
    return appProfileId;
  }

  /**
   * Returns if channels will gracefully refresh connections to Cloud Bigtable service
   *
   * @deprecated Channel refreshing is enabled by default and this method will be deprecated.
   */
  @Deprecated
  public boolean isRefreshingChannel() {
    return isRefreshingChannel;
  }

  /**
   * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
   *     requests will be sent to all table ids of the instance.
   */
  @Deprecated
  public List<String> getPrimedTableIds() {
    return ImmutableList.of();
  }

  /**
   * @deprecated This is a no op and will always return an empty map. Audience is always set to
   *     bigtable service name.
   */
  @InternalApi("Used for internal testing")
  @Deprecated
  public Map<String, String> getJwtAudienceMapping() {
    return ImmutableMap.of();
  }

  public MetricsProvider getMetricsProvider() {
    return metricsProvider;
  }

  /**
   * @deprecated routing cookies are always on.
   */
  @Deprecated
  public boolean getEnableRoutingCookie() {
    return true;
  }

  /**
   * @deprecated RetryInfo is now always on.
   */
  @Deprecated
  public boolean getEnableRetryInfo() {
    return true;
  }

  /**
   * Gets the Google Cloud Monitoring endpoint for publishing client side metrics. If it's null,
   * client will publish metrics to the default monitoring endpoint.
   */
  @Nullable
  public String getMetricsEndpoint() {
    return metricsEndpoint;
  }

  public boolean areInternalMetricsEnabled() {
    return areInternalMetricsEnabled;
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    InstantiatingGrpcChannelProvider.Builder grpcTransportProviderBuilder =
        BigtableStubSettings.defaultGrpcTransportProviderBuilder();
    if (DIRECT_PATH_ENABLED) {
      // Attempts direct access to CBT service over gRPC to improve throughput,
      // whether the attempt is allowed is totally controlled by service owner.
      grpcTransportProviderBuilder
          .setAttemptDirectPathXds()
          .setAttemptDirectPath(true)
          // Allow using non-default service account in DirectPath.
          .setAllowNonDefaultServiceAccount(true);
      if (!DIRECT_PATH_BOUND_TOKEN_DISABLED) {
        // Try to fetch a hard-bound access token for direct access if the runtime
        // environment supports it.
        grpcTransportProviderBuilder.setAllowHardBoundTokenTypes(
            Collections.singletonList(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS));
      }
    }
    return grpcTransportProviderBuilder
        .setChannelPoolSettings(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(10)
                .setMinRpcsPerChannel(1)
                // Keep it conservative as we scale the channel size every 1min
                // and delta is 2 channels.
                .setMaxRpcsPerChannel(25)
                .setPreemptiveRefreshEnabled(true)
                .build())
        .setMaxInboundMessageSize(MAX_MESSAGE_SIZE)
        .setKeepAliveTime(Duration.ofSeconds(30)) // sends ping in this interval
        .setKeepAliveTimeout(
            Duration.ofSeconds(10)); // wait this long before considering the connection dead
  }

  @SuppressWarnings("WeakerAccess")
  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BigtableStubSettings.defaultCredentialsProviderBuilder()
        .setJwtEnabledScopes(JWT_ENABLED_SCOPES);
  }

  @Override
  public String getServiceName() {
    return "bigtable";
  }

  /**
   * Returns the object with the settings used for calls to ReadRows.
   *
   * <p>This is idempotent and streaming operation.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>{@link ServerStreamingCallSettings.Builder#setIdleTimeout Default idle timeout} is set to
   *       5 mins. Idle timeout is how long to wait before considering the stream orphaned by the
   *       user and closing it.
   *   <li>{@link ServerStreamingCallSettings.Builder#setWaitTimeout Default wait timeout} is set to
   *       5 mins. Wait timeout is the maximum amount of time to wait for the next message from the
   *       server.
   *   <li>Retry {@link ServerStreamingCallSettings.Builder#setRetryableCodes error codes} are:
   *       {@link Code#DEADLINE_EXCEEDED}, {@link Code#UNAVAILABLE} and {@link Code#ABORTED}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default read timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt}
   *       is 30 minutes with {@link RetrySettings.Builder#setMaxAttempts maximum attempt} count of
   *       10 times and the timeout to read the {@link RetrySettings.Builder#setTotalTimeout entire
   *       stream} is 12 hours.
   * </ul>
   */
  public ServerStreamingCallSettings<Query, Row> readRowsSettings() {
    return perOpSettings.readRowsSettings;
  }

  /**
   * Returns the object with the settings used for calls to SampleRowKeys.
   *
   * <p>This is idempotent and non-streaming operation.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link UnaryCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED} and {@link Code#UNAVAILABLE}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 5
   *       minutes and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   */
  public UnaryCallSettings<String, List<KeyOffset>> sampleRowKeysSettings() {
    return perOpSettings.sampleRowKeysSettings;
  }

  /**
   * Returns the object with the settings used for point reads via ReadRows.
   *
   * <p>This is an idempotent and non-streaming operation.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link UnaryCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED}, {@link Code#UNAVAILABLE} and {@link Code#ABORTED}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 20
   *       seconds and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   *
   * @see RetrySettings for more explanation.
   */
  public UnaryCallSettings<Query, Row> readRowSettings() {
    return perOpSettings.readRowSettings;
  }

  /**
   * Returns the object with the settings used for calls to MutateRow.
   *
   * <p>This is an idempotent and non-streaming operation.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link UnaryCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED} and {@link Code#UNAVAILABLE}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 60 seconds.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 20
   *       seconds and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   *
   * @see RetrySettings for more explanation.
   */
  public UnaryCallSettings<RowMutation, Void> mutateRowSettings() {
    return perOpSettings.mutateRowSettings;
  }

  /**
   * Returns the object with the settings used for calls to MutateRows.
   *
   * <p>Please note that these settings will affect both manually batched calls
   * (bulkMutateRowsCallable) and automatic batched calls (bulkMutateRowsBatchingCallable). The
   * {@link RowMutation} request signature is ignored for the manual batched calls.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link BatchingCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED} and {@link Code#UNAVAILABLE}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 1
   *       minute and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   *
   * <p>On breach of certain triggers, the operation initiates processing of accumulated request for
   * which the default settings are:
   *
   * <ul>
   *   <li>When the {@link BatchingSettings.Builder#setElementCountThreshold request count} reaches
   *       100.
   *   <li>When accumulated {@link BatchingSettings.Builder#setRequestByteThreshold request size}
   *       reaches to 20MB.
   *   <li>When an {@link BatchingSettings.Builder#setDelayThreshold interval of} 1 second passes
   *       after batching initialization or last processed batch.
   * </ul>
   *
   * <p>A {@link FlowController} will be set up with {@link BigtableBatchingCallSettings.Builder
   * #getDynamicFlowControlSettings()} for throttling in-flight requests. When the pending request
   * count or accumulated request size reaches {@link FlowController} thresholds, then this
   * operation will be throttled until some of the pending batches are resolved.
   *
   * @see RetrySettings for more explanation.
   * @see BatchingSettings for batch related configuration explanation.
   * @see BigtableBatchingCallSettings.Builder#getDynamicFlowControlSettings() for flow control
   *     related configuration explanation.
   */
  public BigtableBatchingCallSettings bulkMutateRowsSettings() {
    return perOpSettings.bulkMutateRowsSettings;
  }

  /**
   * Returns the call settings used for bulk read rows.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link BatchingCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED}, {@link Code#UNAVAILABLE} and {@link Code#ABORTED}.
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 5
   *       minute and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   *
   * <p>On breach of certain triggers, the operation initiates processing of accumulated request for
   * which the default settings are:
   *
   * <ul>
   *   <li>When the {@link BatchingSettings.Builder#setElementCountThreshold request count} reaches
   *       100.
   *   <li>When accumulated {@link BatchingSettings.Builder#setRequestByteThreshold request size}
   *       reaches to 400KB.
   *   <li>When an {@link BatchingSettings.Builder#setDelayThreshold interval of} 1 second passes
   *       after batching initialization or last processed batch.
   * </ul>
   *
   * <p>When the pending {@link FlowControlSettings.Builder#setMaxOutstandingElementCount request
   * count} reaches a default of 1000 outstanding row keys per channel then this operation will by
   * default be {@link FlowControlSettings.Builder#setLimitExceededBehavior blocked} until some of
   * the pending batch are resolved.
   *
   * @see RetrySettings for more explanation.
   * @see BatchingSettings for batch related configuration explanation.
   */
  public BigtableBulkReadRowsCallSettings bulkReadRowsSettings() {
    return perOpSettings.bulkReadRowsSettings;
  }

  /**
   * Returns the object with the settings used for calls to CheckAndMutateRow.
   *
   * <p>This is a non-idempotent and non-streaming operation.
   *
   * <p>By default this operation does not reattempt in case of RPC failure. The default timeout for
   * the {@link RetrySettings.Builder#setTotalTimeout entire operation} is 20 seconds.
   *
   * @see RetrySettings for more explanation.
   */
  public UnaryCallSettings<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
    return perOpSettings.checkAndMutateRowSettings;
  }

  /**
   * Returns the object with the settings used for calls to ReadModifyWriteRow.
   *
   * <p>This is a non-idempotent and non-streaming operation.
   *
   * <p>By default this operation does not reattempt in case of RPC failure. The default timeout for
   * the {@link RetrySettings.Builder#setTotalTimeout entire operation} is 20 seconds.
   *
   * @see RetrySettings for more explanation.
   */
  public UnaryCallSettings<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
    return perOpSettings.readModifyWriteRowSettings;
  }

  public ServerStreamingCallSettings<String, ByteStringRange>
      generateInitialChangeStreamPartitionsSettings() {
    return perOpSettings.generateInitialChangeStreamPartitionsSettings;
  }

  public ServerStreamingCallSettings<ReadChangeStreamQuery, ChangeStreamRecord>
      readChangeStreamSettings() {
    return perOpSettings.readChangeStreamSettings;
  }

  public ServerStreamingCallSettings<BoundStatement, SqlRow> executeQuerySettings() {
    return perOpSettings.executeQuerySettings;
  }

  /**
   * Returns the object with the settings used for a PrepareQuery request. This is used by
   * PreparedStatement to manage PreparedQueries.
   *
   * <p>This is an idempotent and non-streaming operation.
   *
   * <p>Default retry and timeout settings:
   *
   * <ul>
   *   <li>Retry {@link UnaryCallSettings.Builder#setRetryableCodes error codes} are: {@link
   *       Code#DEADLINE_EXCEEDED} and {@link Code#UNAVAILABLE}
   *   <li>RetryDelay between failed attempts {@link RetrySettings.Builder#setInitialRetryDelay
   *       starts} at 10ms and {@link RetrySettings.Builder#setRetryDelayMultiplier increases
   *       exponentially} by a factor of 2 until a {@link RetrySettings.Builder#setMaxRetryDelay
   *       maximum of} 1 minute.
   *   <li>The default timeout for {@link RetrySettings.Builder#setMaxRpcTimeout each attempt} is 5
   *       seconds and the timeout for the {@link RetrySettings.Builder#setTotalTimeout entire
   *       operation} across all of the attempts is 10 mins.
   * </ul>
   *
   * @see RetrySettings for more explanation.
   */
  public UnaryCallSettings<PrepareQueryRequest, PrepareResponse> prepareQuerySettings() {
    return perOpSettings.prepareQuerySettings;
  }

  /**
   * Returns the object with the settings used for calls to PingAndWarm.
   *
   * <p>By default the retries are disabled for PingAndWarm and deadline is set to 30 seconds.
   */
  UnaryCallSettings<PingAndWarmRequest, Void> pingAndWarmSettings() {
    return perOpSettings.pingAndWarmSettings;
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Builder for BigtableDataSettings. */
  public static class Builder extends StubSettings.Builder<EnhancedBigtableStubSettings, Builder> {

    private String projectId;
    private String instanceId;
    private String appProfileId;
    private boolean isRefreshingChannel;
    private String jwtAudience;

    private final ClientOperationSettings.Builder perOpSettings;

    private final FeatureFlags.Builder featureFlags;

    private MetricsProvider metricsProvider;
    @Nullable private String metricsEndpoint;
    private boolean areInternalMetricsEnabled;

    /**
     * Initializes a new Builder with sane defaults for all settings.
     *
     * <p>Most defaults are extracted from BaseBigtableDataSettings, however some of the more
     * complex defaults are configured explicitly here. Once the overlayed defaults are configured,
     * the base settings are augmented to work with overlayed functionality (like disabling retries
     * in the underlying GAPIC client for batching).
     */
    private Builder() {
      this.appProfileId = SERVER_DEFAULT_APP_PROFILE_ID;
      this.isRefreshingChannel = true;
      setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      metricsProvider = DefaultMetricsProvider.INSTANCE;
      this.areInternalMetricsEnabled = true;
      this.jwtAudience = DEFAULT_DATA_JWT_AUDIENCE;

      // Defaults provider
      BigtableStubSettings.Builder baseDefaults = BigtableStubSettings.newBuilder();

      setEndpoint(baseDefaults.getEndpoint());
      setTransportChannelProvider(defaultTransportChannelProvider());
      setStreamWatchdogCheckInterval(baseDefaults.getStreamWatchdogCheckInterval());
      setStreamWatchdogProvider(baseDefaults.getStreamWatchdogProvider());

      perOpSettings = new ClientOperationSettings.Builder();

      featureFlags =
          FeatureFlags.newBuilder()
              .setReverseScans(true)
              .setLastScannedRowResponses(true)
              .setDirectAccessRequested(DIRECT_PATH_ENABLED)
              .setTrafficDirectorEnabled(DIRECT_PATH_ENABLED)
              .setPeerInfo(true);
    }

    private Builder(EnhancedBigtableStubSettings settings) {
      super(settings);
      projectId = settings.projectId;
      instanceId = settings.instanceId;
      appProfileId = settings.appProfileId;
      isRefreshingChannel = settings.isRefreshingChannel;
      metricsProvider = settings.metricsProvider;
      metricsEndpoint = settings.getMetricsEndpoint();
      areInternalMetricsEnabled = settings.areInternalMetricsEnabled;
      jwtAudience = settings.jwtAudience;

      this.perOpSettings = new ClientOperationSettings.Builder(settings.perOpSettings);

      featureFlags = settings.featureFlags.toBuilder();
    }

    // <editor-fold desc="Public API">
    /**
     * Sets the project id of that target instance. This setting is required. All RPCs will be made
     * in the context of this setting.
     */
    public Builder setProjectId(@Nonnull String projectId) {
      Preconditions.checkNotNull(projectId);
      this.projectId = projectId;
      return this;
    }

    /** Gets the project id of the target instance that was previously set on this Builder. */
    public String getProjectId() {
      return projectId;
    }

    /**
     * Sets the target instance id. This setting is required. All RPCs will be made in the context
     * of this setting.
     */
    public Builder setInstanceId(@Nonnull String instanceId) {
      Preconditions.checkNotNull(instanceId);
      this.instanceId = instanceId;
      return this;
    }

    /** Gets the target instance id that was previously set on this Builder. */
    public String getInstanceId() {
      return instanceId;
    }

    /**
     * Sets the AppProfile to use. An application profile (sometimes also shortened to "app
     * profile") is a group of configuration parameters for an individual use case. A client will
     * identify itself with an application profile ID at connection time, and the requests will be
     * handled according to that application profile.
     */
    public Builder setAppProfileId(@Nonnull String appProfileId) {
      Preconditions.checkNotNull(appProfileId, "AppProfileId can't be null");
      this.appProfileId = appProfileId;
      return this;
    }

    /**
     * Resets the AppProfile id to the default for the instance.
     *
     * <p>An application profile (sometimes also shortened to "app profile") is a group of
     * configuration parameters for an individual use case. A client will identify itself with an
     * application profile ID at connection time, and the requests will be handled according to that
     * application profile.
     *
     * <p>Every Bigtable Instance has a default application profile associated with it, this method
     * configures the client to use it.
     */
    public Builder setDefaultAppProfileId() {
      setAppProfileId(SERVER_DEFAULT_APP_PROFILE_ID);
      return this;
    }

    /** Gets the app profile id that was previously set on this Builder. */
    public String getAppProfileId() {
      return appProfileId;
    }

    /**
     * Sets if channels will gracefully refresh connections to Cloud Bigtable service.
     *
     * <p>When enabled, this will wait for the connection to complete the SSL handshake and warm up
     * serverside caches for all the tables of the instance. This feature is enabled by default.
     *
     * @see com.google.cloud.bigtable.data.v2.BigtableDataSettings.Builder#setRefreshingChannel
     * @deprecated Channel refreshing is enabled by default and this method will be deprecated.
     */
    @Deprecated
    public Builder setRefreshingChannel(boolean isRefreshingChannel) {
      this.isRefreshingChannel = isRefreshingChannel;
      return this;
    }

    /**
     * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
     *     requests will be sent to all table ids of the instance.
     */
    @Deprecated
    public Builder setPrimedTableIds(String... tableIds) {
      return this;
    }

    /**
     * Gets if channels will gracefully refresh connections to Cloud Bigtable service.
     *
     * @deprecated Channel refreshing is enabled by default and this method will be deprecated.
     */
    @Deprecated
    public boolean isRefreshingChannel() {
      return isRefreshingChannel;
    }

    /**
     * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
     *     requests will be sent to all table ids of the instance.
     */
    @Deprecated
    public List<String> getPrimedTableIds() {
      return ImmutableList.of();
    }

    /**
     * @deprecated This is a no op. Audience is always set to bigtable service name.
     * @see #setJwtAudience(String) to override the audience.
     */
    @InternalApi("Used for internal testing")
    @Deprecated
    public Builder setJwtAudienceMapping(Map<String, String> jwtAudienceMapping) {
      return this;
    }

    /** Set the jwt audience override. */
    @InternalApi("Used for internal testing")
    public Builder setJwtAudience(String audience) {
      this.jwtAudience = audience;
      return this;
    }

    /**
     * Sets the {@link MetricsProvider}.
     *
     * <p>By default, this is set to {@link
     * com.google.cloud.bigtable.data.v2.stub.metrics.DefaultMetricsProvider#INSTANCE} which will
     * collect and export client side metrics.
     *
     * <p>To disable client side metrics, set it to {@link
     * com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider#INSTANCE}.
     *
     * <p>To use a custom OpenTelemetry instance, refer to {@link
     * com.google.cloud.bigtable.data.v2.stub.metrics.CustomOpenTelemetryMetricsProvider} on how to
     * set it up.
     */
    public Builder setMetricsProvider(MetricsProvider metricsProvider) {
      this.metricsProvider = Preconditions.checkNotNull(metricsProvider);
      return this;
    }

    /** Gets the {@link MetricsProvider}. */
    public MetricsProvider getMetricsProvider() {
      return this.metricsProvider;
    }

    /**
     * Built-in client side metrics are published through Google Cloud Monitoring endpoint. This
     * setting overrides the default endpoint for publishing the metrics.
     */
    public Builder setMetricsEndpoint(String endpoint) {
      this.metricsEndpoint = endpoint;
      return this;
    }

    /**
     * Get the Google Cloud Monitoring endpoint for publishing client side metrics. If it's null,
     * client will publish metrics to the default monitoring endpoint.
     */
    @Nullable
    public String getMetricsEndpoint() {
      return metricsEndpoint;
    }

    /** Disable collection of internal metrics that help google detect issues accessing Bigtable. */
    public Builder disableInternalMetrics() {
      this.areInternalMetricsEnabled = false;
      return this;
    }

    /** Checks if internal metrics are disabled */
    public boolean areInternalMetricsEnabled() {
      return areInternalMetricsEnabled;
    }

    /**
     * @deprecated This is a no op and will always return an empty map. Audience is always set to
     *     bigtable service name.
     * @see #getJwtAudience() to get the audience.
     */
    @InternalApi("Used for internal testing")
    @Deprecated
    public Map<String, String> getJwtAudienceMapping() {
      return ImmutableMap.of();
    }

    /** Return the jwt audience override. */
    String getJwtAudience() {
      return this.jwtAudience;
    }

    /**
     * @deprecated this now a no-op as routing cookies are always on.
     */
    @Deprecated
    public Builder setEnableRoutingCookie(boolean enableRoutingCookie) {
      return this;
    }

    /**
     * @deprecated routing cookies are always on.
     */
    @Deprecated
    public boolean getEnableRoutingCookie() {
      return true;
    }

    /**
     * @deprecated This is a no-op, RetryInfo is always used now.
     */
    @Deprecated
    public Builder setEnableRetryInfo(boolean enableRetryInfo) {
      return this;
    }

    /**
     * @deprecated RetryInfo is always on.
     */
    @Deprecated
    public boolean getEnableRetryInfo() {
      return true;
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings() {
      return perOpSettings.readRowsSettings;
    }

    /** Returns the builder for the settings used for point reads using readRow. */
    public UnaryCallSettings.Builder<Query, Row> readRowSettings() {
      return perOpSettings.readRowSettings;
    }

    /** Returns the builder for the settings used for calls to SampleRowKeysSettings. */
    public UnaryCallSettings.Builder<String, List<KeyOffset>> sampleRowKeysSettings() {
      return perOpSettings.sampleRowKeysSettings;
    }

    /** Returns the builder for the settings used for calls to MutateRow. */
    public UnaryCallSettings.Builder<RowMutation, Void> mutateRowSettings() {
      return perOpSettings.mutateRowSettings;
    }

    /** Returns the builder for the settings used for calls to MutateRows. */
    public BigtableBatchingCallSettings.Builder bulkMutateRowsSettings() {
      return perOpSettings.bulkMutateRowsSettings;
    }

    /** Returns the builder for the settings used for calls to MutateRows. */
    public BigtableBulkReadRowsCallSettings.Builder bulkReadRowsSettings() {
      return perOpSettings.bulkReadRowsSettings;
    }

    /** Returns the builder for the settings used for calls to CheckAndMutateRow. */
    public UnaryCallSettings.Builder<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
      return perOpSettings.checkAndMutateRowSettings;
    }

    /** Returns the builder with the settings used for calls to ReadModifyWriteRow. */
    public UnaryCallSettings.Builder<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
      return perOpSettings.readModifyWriteRowSettings;
    }

    /** Returns the builder for the settings used for calls to ReadChangeStream. */
    public ServerStreamingCallSettings.Builder<ReadChangeStreamQuery, ChangeStreamRecord>
        readChangeStreamSettings() {
      return perOpSettings.readChangeStreamSettings;
    }

    /**
     * Returns the builder for the settings used for calls to GenerateInitialChangeStreamPartitions.
     */
    public ServerStreamingCallSettings.Builder<String, ByteStringRange>
        generateInitialChangeStreamPartitionsSettings() {
      return perOpSettings.generateInitialChangeStreamPartitionsSettings;
    }

    /** Returns the builder with the settings used for calls to PingAndWarm. */
    public UnaryCallSettings.Builder<PingAndWarmRequest, Void> pingAndWarmSettings() {
      return perOpSettings.pingAndWarmSettings;
    }

    /**
     * Returns the builder for the settings used for calls to ExecuteQuery
     *
     * <p>Note that this will currently ignore any retry settings other than deadlines. ExecuteQuery
     * requests will not be retried currently.
     */
    @BetaApi
    public ServerStreamingCallSettings.Builder<BoundStatement, SqlRow> executeQuerySettings() {
      return perOpSettings.executeQuerySettings;
    }

    /** Returns the builder with the settings used for calls to PrepareQuery */
    @BetaApi
    public UnaryCallSettings.Builder<PrepareQueryRequest, PrepareResponse> prepareQuerySettings() {
      return perOpSettings.prepareQuerySettings;
    }

    @SuppressWarnings("unchecked")
    public EnhancedBigtableStubSettings build() {
      Preconditions.checkState(projectId != null, "Project id must be set");
      Preconditions.checkState(instanceId != null, "Instance id must be set");

      if (this.bulkMutateRowsSettings().isServerInitiatedFlowControlEnabled()) {
        // only set mutate rows feature flag when this feature is enabled
        featureFlags.setMutateRowsRateLimit(true);
        featureFlags.setMutateRowsRateLimit2(true);
      }

      featureFlags.setRoutingCookie(true);
      featureFlags.setRetryInfo(true);
      // client_Side_metrics_enabled feature flag is only set when a user is running with a
      // DefaultMetricsProvider. This may cause false negatives when a user registered the
      // metrics on their CustomOpenTelemetryMetricsProvider.
      featureFlags.setClientSideMetricsEnabled(
          this.getMetricsProvider() instanceof DefaultMetricsProvider);

      // Serialize the web64 encode the bigtable feature flags
      ByteArrayOutputStream boas = new ByteArrayOutputStream();
      try {
        featureFlags.build().writeTo(boas);
      } catch (IOException e) {
        throw new IllegalStateException(
            "Unexpected IOException while serializing feature flags", e);
      }
      byte[] serializedFlags = boas.toByteArray();
      byte[] encodedFlags = Base64.getUrlEncoder().encode(serializedFlags);

      // Inject the UserAgent in addition to api-client header
      Map<String, String> headers =
          ImmutableMap.<String, String>builder()
              .putAll(
                  BigtableStubSettings.defaultApiClientHeaderProviderBuilder().build().getHeaders())
              // GrpcHeaderInterceptor treats the `user-agent` as a magic string
              .put("user-agent", "bigtable-java/" + Version.VERSION)
              .put("bigtable-features", new String(encodedFlags, StandardCharsets.UTF_8))
              .build();
      setInternalHeaderProvider(FixedHeaderProvider.create(headers));

      return new EnhancedBigtableStubSettings(this);
    }
    // </editor-fold>
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("projectId", projectId)
        .add("instanceId", instanceId)
        .add("appProfileId", appProfileId)
        .add("isRefreshingChannel", isRefreshingChannel)
        .add("perOpSettings", perOpSettings)
        .add("metricsProvider", metricsProvider)
        .add("metricsEndpoint", metricsEndpoint)
        .add("areInternalMetricsEnabled", areInternalMetricsEnabled)
        .add("jwtAudience", jwtAudience)
        .add("parent", super.toString())
        .toString();
  }
}
