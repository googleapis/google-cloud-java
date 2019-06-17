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
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import io.grpc.ManagedChannelBuilder;
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
