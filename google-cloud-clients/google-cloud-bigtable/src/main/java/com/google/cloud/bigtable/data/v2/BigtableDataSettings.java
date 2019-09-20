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
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.base.Strings;
import io.grpc.ManagedChannelBuilder;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

/**
 * Settings class to configure an instance of {@link BigtableDataClient}.
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

  /** Returns the underlying RPC settings. */
  public EnhancedBigtableStubSettings getStubSettings() {
    return stubSettings;
  }

  /** Returns the object with the settings used for point reads via ReadRow. */
  public UnaryCallSettings<Query, Row> readRowSettings() {
    return stubSettings.readRowSettings();
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
     * Sets the AppProfile to use. An application profile (sometimes also shortened to "app
     * profile") is a group of configuration parameters for an individual use case. A client will
     * identify itself with an application profile ID at connection time, and the requests will be
     * handled according to that application profile.
     */
    public Builder setAppProfileId(@Nonnull String appProfileId) {
      stubSettings.setAppProfileId(appProfileId);
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
