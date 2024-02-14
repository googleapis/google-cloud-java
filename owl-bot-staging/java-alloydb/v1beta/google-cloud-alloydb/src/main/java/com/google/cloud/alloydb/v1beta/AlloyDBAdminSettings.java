/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.alloydb.v1beta;

import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListClustersPagedResponse;
import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListInstancesPagedResponse;
import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListLocationsPagedResponse;
import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListSupportedDatabaseFlagsPagedResponse;
import static com.google.cloud.alloydb.v1beta.AlloyDBAdminClient.ListUsersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.alloydb.v1beta.stub.AlloyDBAdminStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AlloyDBAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (alloydb.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlloyDBAdminSettings.Builder alloyDBAdminSettingsBuilder = AlloyDBAdminSettings.newBuilder();
 * alloyDBAdminSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         alloyDBAdminSettingsBuilder
 *             .getClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AlloyDBAdminSettings alloyDBAdminSettings = alloyDBAdminSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AlloyDBAdminSettings extends ClientSettings<AlloyDBAdminSettings> {

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to promoteCluster. */
  public UnaryCallSettings<PromoteClusterRequest, Operation> promoteClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).promoteClusterSettings();
  }

  /** Returns the object with the settings used for calls to promoteCluster. */
  public OperationCallSettings<PromoteClusterRequest, Cluster, OperationMetadata>
      promoteClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).promoteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreCluster. */
  public UnaryCallSettings<RestoreClusterRequest, Operation> restoreClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).restoreClusterSettings();
  }

  /** Returns the object with the settings used for calls to restoreCluster. */
  public OperationCallSettings<RestoreClusterRequest, Cluster, OperationMetadata>
      restoreClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).restoreClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to createSecondaryCluster. */
  public UnaryCallSettings<CreateSecondaryClusterRequest, Operation>
      createSecondaryClusterSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createSecondaryClusterSettings();
  }

  /** Returns the object with the settings used for calls to createSecondaryCluster. */
  public OperationCallSettings<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
      createSecondaryClusterOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createSecondaryClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to createSecondaryInstance. */
  public UnaryCallSettings<CreateSecondaryInstanceRequest, Operation>
      createSecondaryInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createSecondaryInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createSecondaryInstance. */
  public OperationCallSettings<CreateSecondaryInstanceRequest, Instance, OperationMetadata>
      createSecondaryInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings())
        .createSecondaryInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateInstances. */
  public UnaryCallSettings<BatchCreateInstancesRequest, Operation> batchCreateInstancesSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).batchCreateInstancesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateInstances. */
  public OperationCallSettings<
          BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
      batchCreateInstancesOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).batchCreateInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to failoverInstance. */
  public UnaryCallSettings<FailoverInstanceRequest, Operation> failoverInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).failoverInstanceSettings();
  }

  /** Returns the object with the settings used for calls to failoverInstance. */
  public OperationCallSettings<FailoverInstanceRequest, Instance, OperationMetadata>
      failoverInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).failoverInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to injectFault. */
  public UnaryCallSettings<InjectFaultRequest, Operation> injectFaultSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).injectFaultSettings();
  }

  /** Returns the object with the settings used for calls to injectFault. */
  public OperationCallSettings<InjectFaultRequest, Instance, OperationMetadata>
      injectFaultOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).injectFaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to restartInstance. */
  public UnaryCallSettings<RestartInstanceRequest, Operation> restartInstanceSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).restartInstanceSettings();
  }

  /** Returns the object with the settings used for calls to restartInstance. */
  public OperationCallSettings<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).restartInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSupportedDatabaseFlags. */
  public PagedCallSettings<
          ListSupportedDatabaseFlagsRequest,
          ListSupportedDatabaseFlagsResponse,
          ListSupportedDatabaseFlagsPagedResponse>
      listSupportedDatabaseFlagsSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listSupportedDatabaseFlagsSettings();
  }

  /** Returns the object with the settings used for calls to generateClientCertificate. */
  public UnaryCallSettings<GenerateClientCertificateRequest, GenerateClientCertificateResponse>
      generateClientCertificateSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).generateClientCertificateSettings();
  }

  /** Returns the object with the settings used for calls to getConnectionInfo. */
  public UnaryCallSettings<GetConnectionInfoRequest, ConnectionInfo> getConnectionInfoSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getConnectionInfoSettings();
  }

  /** Returns the object with the settings used for calls to listUsers. */
  public PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listUsersSettings();
  }

  /** Returns the object with the settings used for calls to getUser. */
  public UnaryCallSettings<GetUserRequest, User> getUserSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getUserSettings();
  }

  /** Returns the object with the settings used for calls to createUser. */
  public UnaryCallSettings<CreateUserRequest, User> createUserSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).createUserSettings();
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public UnaryCallSettings<UpdateUserRequest, User> updateUserSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).updateUserSettings();
  }

  /** Returns the object with the settings used for calls to deleteUser. */
  public UnaryCallSettings<DeleteUserRequest, Empty> deleteUserSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).deleteUserSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AlloyDBAdminStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AlloyDBAdminSettings create(AlloyDBAdminStubSettings stub)
      throws IOException {
    return new AlloyDBAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AlloyDBAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AlloyDBAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AlloyDBAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AlloyDBAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AlloyDBAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AlloyDBAdminStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AlloyDBAdminStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AlloyDBAdminStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AlloyDBAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AlloyDBAdminSettings. */
  public static class Builder extends ClientSettings.Builder<AlloyDBAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AlloyDBAdminStubSettings.newBuilder(clientContext));
    }

    protected Builder(AlloyDBAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AlloyDBAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AlloyDBAdminStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AlloyDBAdminStubSettings.newHttpJsonBuilder());
    }

    public AlloyDBAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((AlloyDBAdminStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return getStubSettingsBuilder().deleteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to promoteCluster. */
    public UnaryCallSettings.Builder<PromoteClusterRequest, Operation> promoteClusterSettings() {
      return getStubSettingsBuilder().promoteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to promoteCluster. */
    public OperationCallSettings.Builder<PromoteClusterRequest, Cluster, OperationMetadata>
        promoteClusterOperationSettings() {
      return getStubSettingsBuilder().promoteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreCluster. */
    public UnaryCallSettings.Builder<RestoreClusterRequest, Operation> restoreClusterSettings() {
      return getStubSettingsBuilder().restoreClusterSettings();
    }

    /** Returns the builder for the settings used for calls to restoreCluster. */
    public OperationCallSettings.Builder<RestoreClusterRequest, Cluster, OperationMetadata>
        restoreClusterOperationSettings() {
      return getStubSettingsBuilder().restoreClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createSecondaryCluster. */
    public UnaryCallSettings.Builder<CreateSecondaryClusterRequest, Operation>
        createSecondaryClusterSettings() {
      return getStubSettingsBuilder().createSecondaryClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createSecondaryCluster. */
    public OperationCallSettings.Builder<CreateSecondaryClusterRequest, Cluster, OperationMetadata>
        createSecondaryClusterOperationSettings() {
      return getStubSettingsBuilder().createSecondaryClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createSecondaryInstance. */
    public UnaryCallSettings.Builder<CreateSecondaryInstanceRequest, Operation>
        createSecondaryInstanceSettings() {
      return getStubSettingsBuilder().createSecondaryInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createSecondaryInstance. */
    public OperationCallSettings.Builder<
            CreateSecondaryInstanceRequest, Instance, OperationMetadata>
        createSecondaryInstanceOperationSettings() {
      return getStubSettingsBuilder().createSecondaryInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateInstances. */
    public UnaryCallSettings.Builder<BatchCreateInstancesRequest, Operation>
        batchCreateInstancesSettings() {
      return getStubSettingsBuilder().batchCreateInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateInstances. */
    public OperationCallSettings.Builder<
            BatchCreateInstancesRequest, BatchCreateInstancesResponse, OperationMetadata>
        batchCreateInstancesOperationSettings() {
      return getStubSettingsBuilder().batchCreateInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to failoverInstance. */
    public UnaryCallSettings.Builder<FailoverInstanceRequest, Operation>
        failoverInstanceSettings() {
      return getStubSettingsBuilder().failoverInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to failoverInstance. */
    public OperationCallSettings.Builder<FailoverInstanceRequest, Instance, OperationMetadata>
        failoverInstanceOperationSettings() {
      return getStubSettingsBuilder().failoverInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to injectFault. */
    public UnaryCallSettings.Builder<InjectFaultRequest, Operation> injectFaultSettings() {
      return getStubSettingsBuilder().injectFaultSettings();
    }

    /** Returns the builder for the settings used for calls to injectFault. */
    public OperationCallSettings.Builder<InjectFaultRequest, Instance, OperationMetadata>
        injectFaultOperationSettings() {
      return getStubSettingsBuilder().injectFaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restartInstance. */
    public UnaryCallSettings.Builder<RestartInstanceRequest, Operation> restartInstanceSettings() {
      return getStubSettingsBuilder().restartInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to restartInstance. */
    public OperationCallSettings.Builder<RestartInstanceRequest, Instance, OperationMetadata>
        restartInstanceOperationSettings() {
      return getStubSettingsBuilder().restartInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return getStubSettingsBuilder().createBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return getStubSettingsBuilder().createBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings() {
      return getStubSettingsBuilder().updateBackupSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings() {
      return getStubSettingsBuilder().updateBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return getStubSettingsBuilder().deleteBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSupportedDatabaseFlags. */
    public PagedCallSettings.Builder<
            ListSupportedDatabaseFlagsRequest,
            ListSupportedDatabaseFlagsResponse,
            ListSupportedDatabaseFlagsPagedResponse>
        listSupportedDatabaseFlagsSettings() {
      return getStubSettingsBuilder().listSupportedDatabaseFlagsSettings();
    }

    /** Returns the builder for the settings used for calls to generateClientCertificate. */
    public UnaryCallSettings.Builder<
            GenerateClientCertificateRequest, GenerateClientCertificateResponse>
        generateClientCertificateSettings() {
      return getStubSettingsBuilder().generateClientCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to getConnectionInfo. */
    public UnaryCallSettings.Builder<GetConnectionInfoRequest, ConnectionInfo>
        getConnectionInfoSettings() {
      return getStubSettingsBuilder().getConnectionInfoSettings();
    }

    /** Returns the builder for the settings used for calls to listUsers. */
    public PagedCallSettings.Builder<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings() {
      return getStubSettingsBuilder().listUsersSettings();
    }

    /** Returns the builder for the settings used for calls to getUser. */
    public UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings() {
      return getStubSettingsBuilder().getUserSettings();
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public UnaryCallSettings.Builder<CreateUserRequest, User> createUserSettings() {
      return getStubSettingsBuilder().createUserSettings();
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public UnaryCallSettings.Builder<UpdateUserRequest, User> updateUserSettings() {
      return getStubSettingsBuilder().updateUserSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUser. */
    public UnaryCallSettings.Builder<DeleteUserRequest, Empty> deleteUserSettings() {
      return getStubSettingsBuilder().deleteUserSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public AlloyDBAdminSettings build() throws IOException {
      return new AlloyDBAdminSettings(this);
    }
  }
}
