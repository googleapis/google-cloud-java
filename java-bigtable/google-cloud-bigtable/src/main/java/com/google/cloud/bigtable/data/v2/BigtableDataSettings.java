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
package com.google.cloud.bigtable.data.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.stub.BigtableBatchingCallSettings;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import io.grpc.ManagedChannelBuilder;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Settings class to configure an instance of {@link BigtableDataClient}.
 *
 * <p>Sane defaults are provided for most settings:
 *
 * <ul>
 *   <li>The default service address (bigtable.googleapis.com) and default port (443) are used.
 *   <li>The transport provider is configured with a channel pool that contains twice as many
 *       connections as CPUs.
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
 *   .setProjectId("my-project")
 *   .setInstanceId("my-instance-id")
 *   .setAppProfileId("default");
 *
 * BigtableDataSettings settings = builder.build();
 * }</pre>
 *
 * <p>For fine grained control of individual RPCs, please refer to {@link
 * EnhancedBigtableStubSettings}, which is exposed as {@link Builder#stubSettings()}.
 */
public final class BigtableDataSettings {

  private static final Logger LOGGER = Logger.getLogger(BigtableDataSettings.class.getName());
  private static final String BIGTABLE_EMULATOR_HOST_ENV_VAR = "BIGTABLE_EMULATOR_HOST";

  private final EnhancedBigtableStubSettings stubSettings;

  private BigtableDataSettings(Builder builder) {
    stubSettings = builder.stubSettings().build();
  }

  /**
   * Create a new builder.
   *
   * <p>If emulator configuration provided in BIGTABLE_EMULATOR_HOST environment variable then it
   * creates a builder preconfigured to connect to Bigtable using emulator hostname and port number.
   */
  public static Builder newBuilder() {
    String hostAndPort = System.getenv(BIGTABLE_EMULATOR_HOST_ENV_VAR);
    if (!Strings.isNullOrEmpty(hostAndPort)) {
      try {
        int lastIndexOfCol = hostAndPort.lastIndexOf(":");
        int port = Integer.parseInt(hostAndPort.substring(lastIndexOfCol + 1));
        return newBuilderForEmulator(hostAndPort.substring(0, lastIndexOfCol), port);
      } catch (NumberFormatException | IndexOutOfBoundsException ex) {
        throw new RuntimeException(
            "Invalid host/port in "
                + BIGTABLE_EMULATOR_HOST_ENV_VAR
                + " environment variable: "
                + hostAndPort);
      }
    }
    return new Builder();
  }

  /** Create a new builder preconfigured to connect to the Bigtable emulator with port number. */
  public static Builder newBuilderForEmulator(int port) {
    return newBuilderForEmulator("localhost", port);
  }

  /**
   * Creates a new builder preconfigured to connect to the Bigtable emulator with a host name and
   * port number.
   */
  public static Builder newBuilderForEmulator(String hostname, int port) {
    Builder builder = new Builder();

    builder
        .stubSettings()
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setEndpoint(hostname + ":" + port)
        .setTransportChannelProvider(
            InstantiatingGrpcChannelProvider.newBuilder()
                .setMaxInboundMessageSize(256 * 1024 * 1024)
                .setPoolSize(1)
                .setChannelConfigurator(
                    new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
                      @Override
                      public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
                        return input.usePlaintext();
                      }
                    })
                .setKeepAliveTime(Duration.ofSeconds(61)) // sends ping in this interval
                .setKeepAliveTimeout(
                    Duration.ofSeconds(10)) // wait this long before considering the connection dead
                .build());

    LOGGER.info("Connecting to the Bigtable emulator at " + hostname + ":" + port);
    return builder;
  }

  /**
   * Enables OpenCensus metric aggregations.
   *
   * <p>This will register Bigtable client relevant {@link io.opencensus.stats.View}s. When coupled
   * with an exporter, it allows users to monitor client behavior.
   *
   * <p>Please note that in addition to calling this method, the application must:
   * <ul>
   *   <li>Include openensus-impl dependency on the classpath
   *   <li>Configure an exporter like opencensus-exporter-stats-stackdriver
   * </ul>
   *
   * <p>Example usage for maven:
   * <pre>{@code
   *   <dependency>
   *     <groupId>io.opencensus</groupId>
   *     <artifactId>opencensus-impl</artifactId>
   *     <version>${opencensus.version}</version>
   *     <scope>runtime</scope>
   *   </dependency>
   *
   *   <dependency>
   *     <groupId>io.opencensus</groupId>
   *     <artifactId>opencensus-exporter-stats-stackdriver</artifactId>
   *     <version>${opencensus.version}</version>
   *   </dependency>
   * </pre>
   *
   * Java:
   * <pre>{@code
   *   StackdriverStatsExporter.createAndRegister();
   *   BigtableDataSettings.enableOpenCensusStats();
   * }</pre>
   */
  @BetaApi("OpenCensus stats integration is currently unstable and may change in the future")
  public static void enableOpenCensusStats() {
    com.google.cloud.bigtable.data.v2.stub.metrics.RpcViews.registerBigtableClientViews();
    // TODO(igorbernstein): Enable grpc views once we upgrade to grpc-java 1.24.0
    // Required change: https://github.com/grpc/grpc-java/pull/5996
    // io.opencensus.contrib.grpc.metrics.RpcViews.registerClientGrpcBasicViews();
  }

  /**
   * Enables OpenCensus GFE metric aggregations.
   *
   * <p>This will register views for gfe_latency and gfe_header_missing_count metrics.
   *
   * <p>gfe_latency measures the latency between Google's network receives an RPC and reads back the
   * first byte of the response. gfe_header_missing_count is a counter of the number of RPC
   * responses received without the server-timing header.
   */
  @BetaApi("OpenCensus stats integration is currently unstable and may change in the future")
  public static void enableGfeOpenCensusStats() {
    com.google.cloud.bigtable.data.v2.stub.metrics.RpcViews.registerBigtableClientGfeViews();
  }

  /** Returns the target project id. */
  public String getProjectId() {
    return stubSettings.getProjectId();
  }

  /** Returns the target instance id. */
  public String getInstanceId() {
    return stubSettings.getInstanceId();
  }

  /** Returns the configured AppProfile id to use. */
  public String getAppProfileId() {
    return stubSettings.getAppProfileId();
  }

  /** Gets if channels will gracefully refresh connections to Cloud Bigtable service */
  @BetaApi("Channel priming is not currently stable and may change in the future")
  public boolean isRefreshingChannel() {
    return stubSettings.isRefreshingChannel();
  }

  /**
   * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
   *     requests will be sent to all table ids of the instance.
   */
  @Deprecated
  public List<String> getPrimingTableIds() {
    return stubSettings.getPrimedTableIds();
  }

  /**
   * Gets if latency based throttling is enabled for {@link
   * BigtableDataClient#newBulkMutationBatcher(String)}
   */
  @BetaApi("Latency based throttling is not currently stable and may change in the future")
  public boolean isLatencyBasedThrottlingForBatchMutationsEnabled() {
    return stubSettings.bulkMutateRowsSettings().isLatencyBasedThrottlingEnabled();
  }

  /**
   * Gets target bulk mutation rpc latency if latency based throttling is enabled for {@link
   * BigtableDataClient#newBulkMutationBatcher(String)}. Otherwise returns null.
   */
  @BetaApi("Latency based throttling is not currently stable and may change in the future")
  @Nullable
  public Long getBatchMutationsTargetRpcLatencyMs() {
    return stubSettings.bulkMutateRowsSettings().getTargetRpcLatencyMs();
  }

  /** Returns the underlying RPC settings. */
  public EnhancedBigtableStubSettings getStubSettings() {
    return stubSettings;
  }

  /** Returns the object with the settings used for point reads via ReadRow. */
  public UnaryCallSettings<Query, Row> readRowSettings() {
    return stubSettings.readRowSettings();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("stubSettings", stubSettings).toString();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Builder for BigtableDataSettings. */
  public static class Builder {
    private final EnhancedBigtableStubSettings.Builder stubSettings;
    /**
     * Initializes a new Builder with sane defaults for all settings.
     *
     * <p>Most defaults are extracted from {@link
     * com.google.cloud.bigtable.data.v2.stub.BigtableStubSettings}, however some of the more
     * complex defaults are configured explicitly here. Once the overlayed defaults are configured,
     * the base settings are augmented to work with overlayed functionality (like disabling retries
     * in the underlying GAPIC client for batching).
     */
    private Builder() {
      stubSettings = EnhancedBigtableStubSettings.newBuilder();
    }

    private Builder(BigtableDataSettings settings) {
      stubSettings = settings.getStubSettings().toBuilder();
    }

    // <editor-fold desc="Public API">
    /**
     * Sets the target project. This setting is required. All RPCs will be made in the context of
     * this setting.
     */
    public Builder setProjectId(@Nonnull String projectId) {
      stubSettings.setProjectId(projectId);
      return this;
    }

    /** Gets the project id that was previously set on this Builder. */
    public String getProjectId() {
      return stubSettings.getProjectId();
    }

    /**
     * Sets the target instance. This setting is required. All RPCs will be made in the context of
     * this setting.
     */
    public Builder setInstanceId(@Nonnull String instanceId) {
      stubSettings.setInstanceId(instanceId);
      return this;
    }

    /** Gets the instance id that was previously set on this Builder. */
    public String getInstanceId() {
      return stubSettings.getInstanceId();
    }

    /**
     * Sets the AppProfile to use.
     *
     * <p>An application profile (sometimes also shortened to "app profile") is a group of
     * configuration parameters for an individual use case. A client will identify itself with an
     * application profile ID at connection time, and the requests will be handled according to that
     * application profile.
     */
    public Builder setAppProfileId(@Nonnull String appProfileId) {
      stubSettings.setAppProfileId(appProfileId);
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
      stubSettings.setDefaultAppProfileId();
      return this;
    }

    /** Gets the app profile id that was previously set on this Builder. */
    public String getAppProfileId() {
      return stubSettings.getAppProfileId();
    }

    /** Sets the CredentialsProvider to use for getting the credentials to make calls with. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      stubSettings.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /** Gets the CredentialsProvider to use for getting the credentials to make calls with. */
    public CredentialsProvider getCredentialsProvider() {
      return stubSettings.getCredentialsProvider();
    }

    /**
     * Configure periodic gRPC channel refreshes.
     *
     * <p>This feature will gracefully refresh connections to the Cloud Bigtable service. This is an
     * experimental feature to address tail latency caused by the service dropping long lived gRPC
     * connections, which causes the client to renegotiate the gRPC connection in the request path,
     * which causes periodic spikes in latency
     */
    @BetaApi("Channel priming is not currently stable and may change in the future")
    public Builder setRefreshingChannel(boolean isRefreshingChannel) {
      stubSettings.setRefreshingChannel(isRefreshingChannel);
      return this;
    }

    /** Gets if channels will gracefully refresh connections to Cloud Bigtable service */
    @BetaApi("Channel priming is not currently stable and may change in the future")
    public boolean isRefreshingChannel() {
      return stubSettings.isRefreshingChannel();
    }

    /**
     * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
     *     requests will be sent to all table ids of the instance.
     */
    @Deprecated
    public Builder setPrimingTableIds(String... tableIds) {
      stubSettings.setPrimedTableIds(tableIds);
      return this;
    }

    /**
     * @deprecated This field is ignored. If {@link #isRefreshingChannel()} is enabled, warm up
     *     requests will be sent to all table ids of the instance.
     */
    @Deprecated
    public List<String> getPrimingTableIds() {
      return stubSettings.getPrimedTableIds();
    }

    /**
     * Enable latency based throttling for {@link BigtableDataClient#newBulkMutationBatcher(String)}
     * with a target rpc latency. The number of allowed in-flight requests will be adjusted to reach
     * the target bulk mutations rpc latency.
     *
     * <p>The logic of adjusting in-flight request limits is as follows:
     *
     * <pre>
     * To start, {@link Batcher} allows {@link FlowController#getCurrentElementCountLimit()}
     * in-flight elements with a total size of {@link FlowController#getCurrentRequestBytesLimit()}.
     *
     * Every 20 seconds, {@link Batcher} checks the mean rpc latency of the requests and compare
     * it with the target rpc latency:
     *   if (mean latency &gt; 3 * target latency) {
     *     decrease element count limit by 30% of {@link FlowController#getMaxElementCountLimit()}
     *   } else if (mean latency &gt; 1.2 * target latency) {
     *     decrease element count limit by 10% of {@link FlowController#getMaxElementCountLimit()}
     *   } else if (there was throttling in the past 5 minutes
     *        && mean latency &lt; 0.8 * target latency) {
     *     increase element count limit by 5% of {@link FlowController#getMaxElementCountLimit()}
     *   } else if (there was throttling in the past 5 minutes
     *        && parallelism is 5% of {@link FlowController#getMaxElementCountLimit()}
     *        && mean latency &lt; 2 * target latency) {
     *     increase element count limit by 2% of {@link FlowController#getMaxElementCountLimit()}
     *
     * Increases are capped by {@link
     * FlowController#getMaxElementCountLimit()}, Decreases are floored at {@link
     * FlowController#getMinElementCountLimit()} so that there is some level of throughput.
     * </pre>
     *
     * @see BigtableBatchingCallSettings.Builder#getDynamicFlowControlSettings() for explanation on
     *     default configurations.
     */
    @BetaApi("Latency based throttling is not currently stable and may change in the future")
    public Builder enableBatchMutationLatencyBasedThrottling(long targetRpcLatencyMs) {
      stubSettings.bulkMutateRowsSettings().enableLatencyBasedThrottling(targetRpcLatencyMs);
      return this;
    }

    /**
     * Disable latency based throttling for {@link
     * BigtableDataClient#newBulkMutationBatcher(String)}.
     */
    @BetaApi("Latency based throttling is not currently stable and may change in the future")
    public Builder disableBatchMutationLatencyBasedThrottling() {
      stubSettings.bulkMutateRowsSettings().disableLatencyBasedThrottling();
      return this;
    }

    /**
     * Gets if latency based throttling is enabled for {@link
     * BigtableDataClient#newBulkMutationBatcher(String)}
     */
    @BetaApi("Latency based throttling is not currently stable and may change in the future")
    public boolean isLatencyBasedThrottlingForBatchMutationEnabled() {
      return stubSettings.bulkMutateRowsSettings().isLatencyBasedThrottlingEnabled();
    }

    /**
     * Gets target bulk mutation rpc latency if latency based throttling is enabled for {@link
     * BigtableDataClient#newBulkMutationBatcher(String)}. Otherwise returns null.
     */
    @BetaApi("Latency based throttling is not currently stable and may change in the future")
    @Nullable
    public Long getTargetRpcLatencyMsForBatchMutation() {
      return stubSettings.bulkMutateRowsSettings().getTargetRpcLatencyMs();
    }

    /**
     * Returns the underlying settings for making RPC calls. The settings should be changed with
     * care.
     */
    public EnhancedBigtableStubSettings.Builder stubSettings() {
      return stubSettings;
    }

    public BigtableDataSettings build() {
      return new BigtableDataSettings(this);
    }
  }
}
