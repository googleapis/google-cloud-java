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

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import io.grpc.ManagedChannelBuilder;
import java.util.List;
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
  private final EnhancedBigtableStubSettings stubSettings;

  private BigtableDataSettings(Builder builder) {
    stubSettings = builder.stubSettings().build();
  }

  /** Create a new builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Create a new builder preconfigured to connect to the Bigtable emulator. */
  public static Builder newBuilderForEmulator(int port) {
    Builder builder = newBuilder();

    builder
        .stubSettings()
        .setProjectId("fake-project")
        .setInstanceId("fake-instance")
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setEndpoint("localhost:" + port)
        .setTransportChannelProvider(
            EnhancedBigtableStubSettings.defaultGrpcTransportProviderBuilder()
                .setPoolSize(1)
                .setChannelConfigurator(
                    new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
                      @Override
                      public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
                        return input.usePlaintext();
                      }
                    })
                .build());

    return builder;
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
  public EnhancedBigtableStubSettings getSubSettings() {
    return stubSettings;
  }

  // <editor-fold desc="Deprecated">
  /** @deprecated Please use {@link #getProjectId()} and {@link #getInstanceId()}. */
  @Deprecated()
  public com.google.cloud.bigtable.data.v2.models.InstanceName getInstanceName() {
    return stubSettings.getInstanceName();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public ServerStreamingCallSettings<Query, Row> readRowsSettings() {
    return stubSettings.readRowsSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public UnaryCallSettings<String, List<KeyOffset>> sampleRowKeysSettings() {
    return stubSettings.sampleRowKeysSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public UnaryCallSettings<Query, Row> readRowSettings() {
    return stubSettings.readRowSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public UnaryCallSettings<RowMutation, Void> mutateRowSettings() {
    return stubSettings.mutateRowSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public BatchingCallSettings<RowMutation, Void> bulkMutateRowsSettings() {
    return stubSettings.bulkMutateRowsSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public UnaryCallSettings<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
    return stubSettings.checkAndMutateRowSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public UnaryCallSettings<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
    return stubSettings.readModifyWriteRowSettings();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public ExecutorProvider getExecutorProvider() {
    return stubSettings.getExecutorProvider();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public TransportChannelProvider getTransportChannelProvider() {
    return stubSettings.getTransportChannelProvider();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public CredentialsProvider getCredentialsProvider() {
    return stubSettings.getCredentialsProvider();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public HeaderProvider getHeaderProvider() {
    return stubSettings.getHeaderProvider();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public ApiClock getClock() {
    return stubSettings.getClock();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  public String getEndpoint() {
    return stubSettings.getEndpoint();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  @Nullable
  public WatchdogProvider getStreamWatchdogProvider() {
    return stubSettings.getStreamWatchdogProvider();
  }

  /** @deprecated Please use {@link #getSubSettings()} */
  @Deprecated
  @Nonnull
  public Duration getStreamWatchdogCheckInterval() {
    return stubSettings.getStreamWatchdogCheckInterval();
  }
  // </editor-fold>

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
     * <p>Most defaults are extracted from BaseBigtableDataSettings, however some of the more
     * complex defaults are configured explicitly here. Once the overlayed defaults are configured,
     * the base settings are augmented to work with overlayed functionality (like disabling retries
     * in the underlying GAPIC client for batching).
     */
    private Builder() {
      stubSettings = EnhancedBigtableStubSettings.newBuilder();
    }

    private Builder(BigtableDataSettings settings) {
      stubSettings = settings.getSubSettings().toBuilder();
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
    // </editor-fold>

    // <editor-fold desc="Deprecated">
    /** @deprecated Please use {@link #setProjectId(String)} and {@link #setInstanceId(String)}. */
    @Deprecated
    public Builder setInstanceName(
        @Nonnull com.google.cloud.bigtable.data.v2.models.InstanceName instanceName) {
      stubSettings().setInstanceName(instanceName);
      return this;
    }

    /** @deprecated Please use {@link #getProjectId()} and {@link #getInstanceId()}. */
    @Deprecated
    public com.google.cloud.bigtable.data.v2.models.InstanceName getInstanceName() {
      return stubSettings.getInstanceName();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setExecutorProvider(
        ExecutorProvider executorProvider) {
      return stubSettings.setExecutorProvider(executorProvider);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setHeaderProvider(HeaderProvider headerProvider) {
      return stubSettings.setHeaderProvider(headerProvider);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setTransportChannelProvider(
        TransportChannelProvider transportChannelProvider) {
      return stubSettings.setTransportChannelProvider(transportChannelProvider);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setStreamWatchdogProvider(
        @Nullable WatchdogProvider streamWatchdogProvider) {
      return stubSettings.setStreamWatchdogProvider(streamWatchdogProvider);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setClock(ApiClock clock) {
      return stubSettings.setClock(clock);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setEndpoint(String endpoint) {
      return stubSettings.setEndpoint(endpoint);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setStreamWatchdogCheckInterval(
        @Nonnull Duration checkInterval) {
      return stubSettings.setStreamWatchdogCheckInterval(checkInterval);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public EnhancedBigtableStubSettings.Builder setTracerFactory(
        @Nonnull ApiTracerFactory tracerFactory) {
      return stubSettings.setTracerFactory(tracerFactory);
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public ExecutorProvider getExecutorProvider() {
      return stubSettings.getExecutorProvider();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public TransportChannelProvider getTransportChannelProvider() {
      return stubSettings.getTransportChannelProvider();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public HeaderProvider getHeaderProvider() {
      return stubSettings.getHeaderProvider();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    @Nullable
    public WatchdogProvider getStreamWatchdogProvider() {
      return stubSettings.getStreamWatchdogProvider();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public ApiClock getClock() {
      return stubSettings.getClock();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public String getEndpoint() {
      return stubSettings.getEndpoint();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    @Nonnull
    public Duration getStreamWatchdogCheckInterval() {
      return stubSettings.getStreamWatchdogCheckInterval();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    @Nonnull
    public ApiTracerFactory getTracerFactory() {
      return stubSettings.getTracerFactory();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings() {
      return stubSettings.readRowsSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public UnaryCallSettings.Builder<Query, Row> readRowSettings() {
      return stubSettings.readRowSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public UnaryCallSettings.Builder<String, List<KeyOffset>> sampleRowKeysSettings() {
      return stubSettings.sampleRowKeysSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public UnaryCallSettings.Builder<RowMutation, Void> mutateRowSettings() {
      return stubSettings.mutateRowSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public BatchingCallSettings.Builder<RowMutation, Void> bulkMutateRowsSettings() {
      return stubSettings.bulkMutateRowsSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public UnaryCallSettings.Builder<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
      return stubSettings.checkAndMutateRowSettings();
    }

    /** @deprecated Please use {@link #stubSettings()} */
    @Deprecated
    public UnaryCallSettings.Builder<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
      return stubSettings.readModifyWriteRowSettings();
    }
    // </editor-fold>
  }
}
