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
package com.google.cloud.bigtable.admin.v2;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Verify;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Settings class to configure an instance of {@link BigtableTableAdminClient}.
 *
 * <p>It must be configured with a project ID and instance ID.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * BigtableTableAdminSettings.Builder tableAdminSettingsBuilder = BigtableTableAdminSettings.newBuilder()
 *   .setProjectId("my-project")
 *   .setInstanceId("my-instance");
 *
 * tableAdminSettingsBuilder.stubSettings().createTableSettings()
 *   .setRetrySettings(
 *     RetrySettings.newBuilder()
 *       .setTotalTimeout(Duration.ofMinutes(15))
 *       .build());
 *
 * BigtableTableAdminSettings tableAdminSettings = tableAdminSettingsBuilder.build();
 * }</pre>
 */
public final class BigtableTableAdminSettings {

  private static final Logger LOGGER = Logger.getLogger(BigtableTableAdminSettings.class.getName());
  static final String BIGTABLE_EMULATOR_HOST_ENV_VAR = "BIGTABLE_EMULATOR_HOST";

  private final String projectId;
  private final String instanceId;
  private final BigtableTableAdminStubSettings stubSettings;

  private BigtableTableAdminSettings(Builder builder) throws IOException {
    this.projectId = Preconditions.checkNotNull(builder.projectId, "Project ID must be set");
    this.instanceId = Preconditions.checkNotNull(builder.instanceId, "Instance ID must be set");
    this.stubSettings =
        Verify.verifyNotNull(builder.stubSettings, "stubSettings should never be null").build();
  }

  /** Gets the project ID of instance whose tables the client will manage. */
  public String getProjectId() {
    return projectId;
  }

  /** Gets the instance ID whose tables the client will manage. */
  public String getInstanceId() {
    return instanceId;
  }

  /** Gets the credentials provider to use for getting the credentials to make calls with. */
  public CredentialsProvider getCredentialsProvider() {
    return stubSettings.getCredentialsProvider();
  }

  /** Gets the underlying RPC settings. */
  public BigtableTableAdminStubSettings getStubSettings() {
    return stubSettings;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("projectId", projectId)
        .add("instanceId", instanceId)
        .add("createTableSettings", stubSettings.createTableSettings())
        .add("createTableFromSnapshotSettings", stubSettings.createTableFromSnapshotSettings())
        .add(
            "createTableFromSnapshotOperationSettings",
            stubSettings.createTableFromSnapshotOperationSettings())
        .add("listTablesSettings", stubSettings.listTablesSettings())
        .add("getTableSettings", stubSettings.getTableSettings())
        .add("deleteTableSettings", stubSettings.deleteTableSettings())
        .add("modifyColumnFamiliesSettings", stubSettings.modifyColumnFamiliesSettings())
        .add("dropRowRangeSettings", stubSettings.dropRowRangeSettings())
        .add("generateConsistencyTokenSettings", stubSettings.generateConsistencyTokenSettings())
        .add("checkConsistencySettings", stubSettings.checkConsistencySettings())
        .add("getIamPolicySettings", stubSettings.getIamPolicySettings())
        .add("setIamPolicySettings", stubSettings.setIamPolicySettings())
        .add("testIamPermissionsSettings", stubSettings.testIamPermissionsSettings())
        .add("snapshotTableSettings", stubSettings.snapshotTableSettings())
        .add("snapshotTableOperationSettings", stubSettings.snapshotTableOperationSettings())
        .add("getSnapshotSettings", stubSettings.getSnapshotSettings())
        .add("listSnapshotsSettings", stubSettings.listSnapshotsSettings())
        .add("deleteSnapshotSettings", stubSettings.deleteSnapshotSettings())
        .add("createBackupSettings", stubSettings.createBackupSettings())
        .add("createBackupOperationSettings", stubSettings.createBackupOperationSettings())
        .add("getBackupSettings", stubSettings.getBackupSettings())
        .add("listBackupsSettings", stubSettings.listBackupsSettings())
        .add("updateBackupSettings", stubSettings.updateBackupSettings())
        .add("deleteBackupSettings", stubSettings.deleteBackupSettings())
        .add("restoreTableSettings", stubSettings.restoreTableSettings())
        .add("restoreTableOperationSettings", stubSettings.restoreTableOperationSettings())
        .add("stubSettings", stubSettings)
        .add("undeleteTableSettings", stubSettings.undeleteTableSettings())
        .add("undeleteTableOperationSettings", stubSettings.undeleteTableOperationSettings())
        .add("updateTableSettings", stubSettings.updateTableSettings())
        .add("updateTableOperationSettings", stubSettings.updateTableOperationSettings())
        .toString();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns a new builder for this class.
   *
   * <p>If emulator configuration provided in BIGTABLE_EMULATOR_HOST environment variable then it
   * creates a builder preconfigured to connect to Bigtable using emulator hostname and port number.
   */
  public static Builder newBuilder() {
    String hostAndPort = System.getenv(BIGTABLE_EMULATOR_HOST_ENV_VAR);
    if (!Strings.isNullOrEmpty(hostAndPort)) {
      int port;
      try {
        port = Integer.parseInt(hostAndPort.substring(hostAndPort.lastIndexOf(":") + 1));
        return newBuilderForEmulator(hostAndPort.substring(0, hostAndPort.lastIndexOf(":")), port);
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
   * Creates a new builder preconfigured to connect to the Bigtable emulator with host name and port
   * number.
   */
  public static Builder newBuilderForEmulator(String hostname, int port) {
    Builder builder = new Builder();

    builder
        .stubSettings()
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setEndpoint(hostname + ":" + port)
        .setTransportChannelProvider(
            InstantiatingGrpcChannelProvider.newBuilder()
                .setChannelPoolSettings(ChannelPoolSettings.staticallySized(1))
                .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                .build());

    LOGGER.info("Connecting to the Bigtable emulator at " + hostname + ":" + port);
    return builder;
  }

  /** Builder for BigtableTableAdminSettings. */
  public static final class Builder {
    @Nullable private String projectId;
    @Nullable private String instanceId;
    private final BigtableTableAdminStubSettings.Builder stubSettings;

    private Builder() {
      stubSettings = BigtableTableAdminStubSettings.newBuilder();
    }

    private Builder(BigtableTableAdminSettings settings) {
      this.projectId = settings.projectId;
      this.instanceId = settings.instanceId;
      this.stubSettings = settings.stubSettings.toBuilder();
    }

    /** Sets the project ID of the instance whose tables the client will manage. */
    public Builder setProjectId(@Nullable String projectId) {
      Preconditions.checkNotNull(projectId);
      this.projectId = projectId;
      return this;
    }

    /** Gets the project ID of the instance whose tables the client will manage. */
    @Nullable
    public String getProjectId() {
      return projectId;
    }

    /** Sets the instance ID of the instance whose tables the client will manage. */
    public Builder setInstanceId(@Nullable String instanceId) {
      Preconditions.checkNotNull(instanceId);
      this.instanceId = instanceId;
      return this;
    }

    /** Gets the instance ID of the instance whose tables the client will manage. */
    @Nullable
    public String getInstanceId() {
      return instanceId;
    }

    /** Sets the credentials provider to use for getting the credentials to make calls with. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      stubSettings.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /** Gets the credentials provider to use for getting the credentials to make calls with. */
    public CredentialsProvider getCredentialsProvider() {
      return stubSettings.getCredentialsProvider();
    }

    /**
     * Returns the builder for the settings used for all RPCs.
     *
     * <p>This is meant for advanced usage. The default RPC settings are set to their recommended
     * values.
     */
    public BigtableTableAdminStubSettings.Builder stubSettings() {
      return stubSettings;
    }

    /** Builds an instance of the settings. */
    public BigtableTableAdminSettings build() throws IOException {
      return new BigtableTableAdminSettings(this);
    }
  }
}
