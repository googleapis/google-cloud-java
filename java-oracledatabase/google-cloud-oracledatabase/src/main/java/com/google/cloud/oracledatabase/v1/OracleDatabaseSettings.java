/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.oracledatabase.v1;

import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseBackupsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudExadataInfrastructuresPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemInitialStorageSizesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExadbVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExascaleDbStorageVaultsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListMinorVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbNetworksPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbSubnetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListPluggableDatabasesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.stub.OracleDatabaseStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OracleDatabaseClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (oracledatabase.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCloudExadataInfrastructure:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OracleDatabaseSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseSettings.newBuilder();
 * oracleDatabaseSettingsBuilder
 *     .getCloudExadataInfrastructureSettings()
 *     .setRetrySettings(
 *         oracleDatabaseSettingsBuilder
 *             .getCloudExadataInfrastructureSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * OracleDatabaseSettings oracleDatabaseSettings = oracleDatabaseSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createCloudExadataInfrastructure:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OracleDatabaseSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * oracleDatabaseSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OracleDatabaseSettings extends ClientSettings<OracleDatabaseSettings> {

  /** Returns the object with the settings used for calls to listCloudExadataInfrastructures. */
  public PagedCallSettings<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .listCloudExadataInfrastructuresSettings();
  }

  /** Returns the object with the settings used for calls to getCloudExadataInfrastructure. */
  public UnaryCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public UnaryCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public OperationCallSettings<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createCloudExadataInfrastructureOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public UnaryCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public OperationCallSettings<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteCloudExadataInfrastructureOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCloudVmClusters. */
  public PagedCallSettings<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, ListCloudVmClustersPagedResponse>
      listCloudVmClustersSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listCloudVmClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCloudVmCluster. */
  public UnaryCallSettings<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public UnaryCallSettings<CreateCloudVmClusterRequest, Operation> createCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public OperationCallSettings<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createCloudVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public UnaryCallSettings<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public OperationCallSettings<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteCloudVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to listDbServers. */
  public PagedCallSettings<ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
      listDbServersSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbServersSettings();
  }

  /** Returns the object with the settings used for calls to listDbNodes. */
  public PagedCallSettings<ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
      listDbNodesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbNodesSettings();
  }

  /** Returns the object with the settings used for calls to listGiVersions. */
  public PagedCallSettings<
          ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
      listGiVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listGiVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listMinorVersions. */
  public PagedCallSettings<
          ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
      listMinorVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listMinorVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listDbSystemShapes. */
  public PagedCallSettings<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
      listDbSystemShapesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbSystemShapesSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabases. */
  public PagedCallSettings<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to getAutonomousDatabase. */
  public UnaryCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public UnaryCallSettings<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public OperationCallSettings<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAutonomousDatabase. */
  public UnaryCallSettings<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).updateAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateAutonomousDatabase. */
  public OperationCallSettings<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .updateAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public UnaryCallSettings<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public OperationCallSettings<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public UnaryCallSettings<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).restoreAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public OperationCallSettings<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .restoreAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAutonomousDatabaseWallet. */
  public UnaryCallSettings<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .generateAutonomousDatabaseWalletSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDbVersions. */
  public PagedCallSettings<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDbVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseCharacterSets. */
  public PagedCallSettings<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .listAutonomousDatabaseCharacterSetsSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseBackups. */
  public PagedCallSettings<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDatabaseBackupsSettings();
  }

  /** Returns the object with the settings used for calls to stopAutonomousDatabase. */
  public UnaryCallSettings<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).stopAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to stopAutonomousDatabase. */
  public OperationCallSettings<StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .stopAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to startAutonomousDatabase. */
  public UnaryCallSettings<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).startAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to startAutonomousDatabase. */
  public OperationCallSettings<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .startAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to restartAutonomousDatabase. */
  public UnaryCallSettings<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).restartAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to restartAutonomousDatabase. */
  public OperationCallSettings<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .restartAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to switchoverAutonomousDatabase. */
  public UnaryCallSettings<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).switchoverAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to switchoverAutonomousDatabase. */
  public OperationCallSettings<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .switchoverAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to failoverAutonomousDatabase. */
  public UnaryCallSettings<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).failoverAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to failoverAutonomousDatabase. */
  public OperationCallSettings<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .failoverAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to listOdbNetworks. */
  public PagedCallSettings<
          ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
      listOdbNetworksSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listOdbNetworksSettings();
  }

  /** Returns the object with the settings used for calls to getOdbNetwork. */
  public UnaryCallSettings<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getOdbNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createOdbNetwork. */
  public UnaryCallSettings<CreateOdbNetworkRequest, Operation> createOdbNetworkSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createOdbNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createOdbNetwork. */
  public OperationCallSettings<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createOdbNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOdbNetwork. */
  public UnaryCallSettings<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteOdbNetworkSettings();
  }

  /** Returns the object with the settings used for calls to deleteOdbNetwork. */
  public OperationCallSettings<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteOdbNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to listOdbSubnets. */
  public PagedCallSettings<
          ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
      listOdbSubnetsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listOdbSubnetsSettings();
  }

  /** Returns the object with the settings used for calls to getOdbSubnet. */
  public UnaryCallSettings<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getOdbSubnetSettings();
  }

  /** Returns the object with the settings used for calls to createOdbSubnet. */
  public UnaryCallSettings<CreateOdbSubnetRequest, Operation> createOdbSubnetSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createOdbSubnetSettings();
  }

  /** Returns the object with the settings used for calls to createOdbSubnet. */
  public OperationCallSettings<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createOdbSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOdbSubnet. */
  public UnaryCallSettings<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteOdbSubnetSettings();
  }

  /** Returns the object with the settings used for calls to deleteOdbSubnet. */
  public OperationCallSettings<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteOdbSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExadbVmClusters. */
  public PagedCallSettings<
          ListExadbVmClustersRequest, ListExadbVmClustersResponse, ListExadbVmClustersPagedResponse>
      listExadbVmClustersSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listExadbVmClustersSettings();
  }

  /** Returns the object with the settings used for calls to getExadbVmCluster. */
  public UnaryCallSettings<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getExadbVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createExadbVmCluster. */
  public UnaryCallSettings<CreateExadbVmClusterRequest, Operation> createExadbVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createExadbVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createExadbVmCluster. */
  public OperationCallSettings<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createExadbVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExadbVmCluster. */
  public UnaryCallSettings<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteExadbVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteExadbVmCluster. */
  public OperationCallSettings<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteExadbVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateExadbVmCluster. */
  public UnaryCallSettings<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).updateExadbVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateExadbVmCluster. */
  public OperationCallSettings<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).updateExadbVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeVirtualMachineExadbVmCluster. */
  public UnaryCallSettings<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .removeVirtualMachineExadbVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to removeVirtualMachineExadbVmCluster. */
  public OperationCallSettings<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .removeVirtualMachineExadbVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExascaleDbStorageVaults. */
  public PagedCallSettings<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listExascaleDbStorageVaultsSettings();
  }

  /** Returns the object with the settings used for calls to getExascaleDbStorageVault. */
  public UnaryCallSettings<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getExascaleDbStorageVaultSettings();
  }

  /** Returns the object with the settings used for calls to createExascaleDbStorageVault. */
  public UnaryCallSettings<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createExascaleDbStorageVaultSettings();
  }

  /** Returns the object with the settings used for calls to createExascaleDbStorageVault. */
  public OperationCallSettings<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createExascaleDbStorageVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExascaleDbStorageVault. */
  public UnaryCallSettings<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteExascaleDbStorageVaultSettings();
  }

  /** Returns the object with the settings used for calls to deleteExascaleDbStorageVault. */
  public OperationCallSettings<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteExascaleDbStorageVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDbSystemInitialStorageSizes. */
  public PagedCallSettings<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .listDbSystemInitialStorageSizesSettings();
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to listPluggableDatabases. */
  public PagedCallSettings<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listPluggableDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to getPluggableDatabase. */
  public UnaryCallSettings<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getPluggableDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to listDbSystems. */
  public PagedCallSettings<ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
      listDbSystemsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbSystemsSettings();
  }

  /** Returns the object with the settings used for calls to getDbSystem. */
  public UnaryCallSettings<GetDbSystemRequest, DbSystem> getDbSystemSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getDbSystemSettings();
  }

  /** Returns the object with the settings used for calls to createDbSystem. */
  public UnaryCallSettings<CreateDbSystemRequest, Operation> createDbSystemSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createDbSystemSettings();
  }

  /** Returns the object with the settings used for calls to createDbSystem. */
  public OperationCallSettings<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createDbSystemOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDbSystem. */
  public UnaryCallSettings<DeleteDbSystemRequest, Operation> deleteDbSystemSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteDbSystemSettings();
  }

  /** Returns the object with the settings used for calls to deleteDbSystem. */
  public OperationCallSettings<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteDbSystemOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDbVersions. */
  public PagedCallSettings<
          ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
      listDbVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listDatabaseCharacterSets. */
  public PagedCallSettings<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDatabaseCharacterSetsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final OracleDatabaseSettings create(OracleDatabaseStubSettings stub)
      throws IOException {
    return new OracleDatabaseSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OracleDatabaseStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OracleDatabaseStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OracleDatabaseStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OracleDatabaseStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OracleDatabaseStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OracleDatabaseStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OracleDatabaseStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OracleDatabaseStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected OracleDatabaseSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OracleDatabaseSettings. */
  public static class Builder extends ClientSettings.Builder<OracleDatabaseSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OracleDatabaseStubSettings.newBuilder(clientContext));
    }

    protected Builder(OracleDatabaseSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OracleDatabaseStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OracleDatabaseStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(OracleDatabaseStubSettings.newHttpJsonBuilder());
    }

    public OracleDatabaseStubSettings.Builder getStubSettingsBuilder() {
      return ((OracleDatabaseStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCloudExadataInfrastructures. */
    public PagedCallSettings.Builder<
            ListCloudExadataInfrastructuresRequest,
            ListCloudExadataInfrastructuresResponse,
            ListCloudExadataInfrastructuresPagedResponse>
        listCloudExadataInfrastructuresSettings() {
      return getStubSettingsBuilder().listCloudExadataInfrastructuresSettings();
    }

    /** Returns the builder for the settings used for calls to getCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<
            GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().getCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().createCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
        createCloudExadataInfrastructureOperationSettings() {
      return getStubSettingsBuilder().createCloudExadataInfrastructureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().deleteCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
        deleteCloudExadataInfrastructureOperationSettings() {
      return getStubSettingsBuilder().deleteCloudExadataInfrastructureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCloudVmClusters. */
    public PagedCallSettings.Builder<
            ListCloudVmClustersRequest,
            ListCloudVmClustersResponse,
            ListCloudVmClustersPagedResponse>
        listCloudVmClustersSettings() {
      return getStubSettingsBuilder().listCloudVmClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCloudVmCluster. */
    public UnaryCallSettings.Builder<GetCloudVmClusterRequest, CloudVmCluster>
        getCloudVmClusterSettings() {
      return getStubSettingsBuilder().getCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public UnaryCallSettings.Builder<CreateCloudVmClusterRequest, Operation>
        createCloudVmClusterSettings() {
      return getStubSettingsBuilder().createCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public OperationCallSettings.Builder<
            CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
        createCloudVmClusterOperationSettings() {
      return getStubSettingsBuilder().createCloudVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public UnaryCallSettings.Builder<DeleteCloudVmClusterRequest, Operation>
        deleteCloudVmClusterSettings() {
      return getStubSettingsBuilder().deleteCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public OperationCallSettings.Builder<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
        deleteCloudVmClusterOperationSettings() {
      return getStubSettingsBuilder().deleteCloudVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return getStubSettingsBuilder().listEntitlementsSettings();
    }

    /** Returns the builder for the settings used for calls to listDbServers. */
    public PagedCallSettings.Builder<
            ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
        listDbServersSettings() {
      return getStubSettingsBuilder().listDbServersSettings();
    }

    /** Returns the builder for the settings used for calls to listDbNodes. */
    public PagedCallSettings.Builder<
            ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
        listDbNodesSettings() {
      return getStubSettingsBuilder().listDbNodesSettings();
    }

    /** Returns the builder for the settings used for calls to listGiVersions. */
    public PagedCallSettings.Builder<
            ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
        listGiVersionsSettings() {
      return getStubSettingsBuilder().listGiVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listMinorVersions. */
    public PagedCallSettings.Builder<
            ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
        listMinorVersionsSettings() {
      return getStubSettingsBuilder().listMinorVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDbSystemShapes. */
    public PagedCallSettings.Builder<
            ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
        listDbSystemShapesSettings() {
      return getStubSettingsBuilder().listDbSystemShapesSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabases. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabasesRequest,
            ListAutonomousDatabasesResponse,
            ListAutonomousDatabasesPagedResponse>
        listAutonomousDatabasesSettings() {
      return getStubSettingsBuilder().listAutonomousDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to getAutonomousDatabase. */
    public UnaryCallSettings.Builder<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().getAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public UnaryCallSettings.Builder<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().createAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public OperationCallSettings.Builder<
            CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        createAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().createAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAutonomousDatabase. */
    public UnaryCallSettings.Builder<UpdateAutonomousDatabaseRequest, Operation>
        updateAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().updateAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateAutonomousDatabase. */
    public OperationCallSettings.Builder<
            UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        updateAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().updateAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public UnaryCallSettings.Builder<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().deleteAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public OperationCallSettings.Builder<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
        deleteAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().deleteAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public UnaryCallSettings.Builder<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().restoreAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public OperationCallSettings.Builder<
            RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restoreAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().restoreAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateAutonomousDatabaseWallet. */
    public UnaryCallSettings.Builder<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletSettings() {
      return getStubSettingsBuilder().generateAutonomousDatabaseWalletSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDbVersions. */
    public PagedCallSettings.Builder<
            ListAutonomousDbVersionsRequest,
            ListAutonomousDbVersionsResponse,
            ListAutonomousDbVersionsPagedResponse>
        listAutonomousDbVersionsSettings() {
      return getStubSettingsBuilder().listAutonomousDbVersionsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listAutonomousDatabaseCharacterSets.
     */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseCharacterSetsRequest,
            ListAutonomousDatabaseCharacterSetsResponse,
            ListAutonomousDatabaseCharacterSetsPagedResponse>
        listAutonomousDatabaseCharacterSetsSettings() {
      return getStubSettingsBuilder().listAutonomousDatabaseCharacterSetsSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabaseBackups. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseBackupsRequest,
            ListAutonomousDatabaseBackupsResponse,
            ListAutonomousDatabaseBackupsPagedResponse>
        listAutonomousDatabaseBackupsSettings() {
      return getStubSettingsBuilder().listAutonomousDatabaseBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to stopAutonomousDatabase. */
    public UnaryCallSettings.Builder<StopAutonomousDatabaseRequest, Operation>
        stopAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().stopAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to stopAutonomousDatabase. */
    public OperationCallSettings.Builder<
            StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        stopAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().stopAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startAutonomousDatabase. */
    public UnaryCallSettings.Builder<StartAutonomousDatabaseRequest, Operation>
        startAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().startAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to startAutonomousDatabase. */
    public OperationCallSettings.Builder<
            StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        startAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().startAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restartAutonomousDatabase. */
    public UnaryCallSettings.Builder<RestartAutonomousDatabaseRequest, Operation>
        restartAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().restartAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to restartAutonomousDatabase. */
    public OperationCallSettings.Builder<
            RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restartAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().restartAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to switchoverAutonomousDatabase. */
    public UnaryCallSettings.Builder<SwitchoverAutonomousDatabaseRequest, Operation>
        switchoverAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().switchoverAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to switchoverAutonomousDatabase. */
    public OperationCallSettings.Builder<
            SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        switchoverAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().switchoverAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to failoverAutonomousDatabase. */
    public UnaryCallSettings.Builder<FailoverAutonomousDatabaseRequest, Operation>
        failoverAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().failoverAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to failoverAutonomousDatabase. */
    public OperationCallSettings.Builder<
            FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        failoverAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().failoverAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listOdbNetworks. */
    public PagedCallSettings.Builder<
            ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
        listOdbNetworksSettings() {
      return getStubSettingsBuilder().listOdbNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to getOdbNetwork. */
    public UnaryCallSettings.Builder<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings() {
      return getStubSettingsBuilder().getOdbNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createOdbNetwork. */
    public UnaryCallSettings.Builder<CreateOdbNetworkRequest, Operation>
        createOdbNetworkSettings() {
      return getStubSettingsBuilder().createOdbNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createOdbNetwork. */
    public OperationCallSettings.Builder<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
        createOdbNetworkOperationSettings() {
      return getStubSettingsBuilder().createOdbNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOdbNetwork. */
    public UnaryCallSettings.Builder<DeleteOdbNetworkRequest, Operation>
        deleteOdbNetworkSettings() {
      return getStubSettingsBuilder().deleteOdbNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOdbNetwork. */
    public OperationCallSettings.Builder<DeleteOdbNetworkRequest, Empty, OperationMetadata>
        deleteOdbNetworkOperationSettings() {
      return getStubSettingsBuilder().deleteOdbNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listOdbSubnets. */
    public PagedCallSettings.Builder<
            ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
        listOdbSubnetsSettings() {
      return getStubSettingsBuilder().listOdbSubnetsSettings();
    }

    /** Returns the builder for the settings used for calls to getOdbSubnet. */
    public UnaryCallSettings.Builder<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings() {
      return getStubSettingsBuilder().getOdbSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to createOdbSubnet. */
    public UnaryCallSettings.Builder<CreateOdbSubnetRequest, Operation> createOdbSubnetSettings() {
      return getStubSettingsBuilder().createOdbSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to createOdbSubnet. */
    public OperationCallSettings.Builder<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
        createOdbSubnetOperationSettings() {
      return getStubSettingsBuilder().createOdbSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOdbSubnet. */
    public UnaryCallSettings.Builder<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetSettings() {
      return getStubSettingsBuilder().deleteOdbSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOdbSubnet. */
    public OperationCallSettings.Builder<DeleteOdbSubnetRequest, Empty, OperationMetadata>
        deleteOdbSubnetOperationSettings() {
      return getStubSettingsBuilder().deleteOdbSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExadbVmClusters. */
    public PagedCallSettings.Builder<
            ListExadbVmClustersRequest,
            ListExadbVmClustersResponse,
            ListExadbVmClustersPagedResponse>
        listExadbVmClustersSettings() {
      return getStubSettingsBuilder().listExadbVmClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getExadbVmCluster. */
    public UnaryCallSettings.Builder<GetExadbVmClusterRequest, ExadbVmCluster>
        getExadbVmClusterSettings() {
      return getStubSettingsBuilder().getExadbVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createExadbVmCluster. */
    public UnaryCallSettings.Builder<CreateExadbVmClusterRequest, Operation>
        createExadbVmClusterSettings() {
      return getStubSettingsBuilder().createExadbVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createExadbVmCluster. */
    public OperationCallSettings.Builder<
            CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        createExadbVmClusterOperationSettings() {
      return getStubSettingsBuilder().createExadbVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExadbVmCluster. */
    public UnaryCallSettings.Builder<DeleteExadbVmClusterRequest, Operation>
        deleteExadbVmClusterSettings() {
      return getStubSettingsBuilder().deleteExadbVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExadbVmCluster. */
    public OperationCallSettings.Builder<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
        deleteExadbVmClusterOperationSettings() {
      return getStubSettingsBuilder().deleteExadbVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateExadbVmCluster. */
    public UnaryCallSettings.Builder<UpdateExadbVmClusterRequest, Operation>
        updateExadbVmClusterSettings() {
      return getStubSettingsBuilder().updateExadbVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateExadbVmCluster. */
    public OperationCallSettings.Builder<
            UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        updateExadbVmClusterOperationSettings() {
      return getStubSettingsBuilder().updateExadbVmClusterOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to removeVirtualMachineExadbVmCluster.
     */
    public UnaryCallSettings.Builder<RemoveVirtualMachineExadbVmClusterRequest, Operation>
        removeVirtualMachineExadbVmClusterSettings() {
      return getStubSettingsBuilder().removeVirtualMachineExadbVmClusterSettings();
    }

    /**
     * Returns the builder for the settings used for calls to removeVirtualMachineExadbVmCluster.
     */
    public OperationCallSettings.Builder<
            RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        removeVirtualMachineExadbVmClusterOperationSettings() {
      return getStubSettingsBuilder().removeVirtualMachineExadbVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExascaleDbStorageVaults. */
    public PagedCallSettings.Builder<
            ListExascaleDbStorageVaultsRequest,
            ListExascaleDbStorageVaultsResponse,
            ListExascaleDbStorageVaultsPagedResponse>
        listExascaleDbStorageVaultsSettings() {
      return getStubSettingsBuilder().listExascaleDbStorageVaultsSettings();
    }

    /** Returns the builder for the settings used for calls to getExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
        getExascaleDbStorageVaultSettings() {
      return getStubSettingsBuilder().getExascaleDbStorageVaultSettings();
    }

    /** Returns the builder for the settings used for calls to createExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<CreateExascaleDbStorageVaultRequest, Operation>
        createExascaleDbStorageVaultSettings() {
      return getStubSettingsBuilder().createExascaleDbStorageVaultSettings();
    }

    /** Returns the builder for the settings used for calls to createExascaleDbStorageVault. */
    public OperationCallSettings.Builder<
            CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
        createExascaleDbStorageVaultOperationSettings() {
      return getStubSettingsBuilder().createExascaleDbStorageVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<DeleteExascaleDbStorageVaultRequest, Operation>
        deleteExascaleDbStorageVaultSettings() {
      return getStubSettingsBuilder().deleteExascaleDbStorageVaultSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExascaleDbStorageVault. */
    public OperationCallSettings.Builder<
            DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
        deleteExascaleDbStorageVaultOperationSettings() {
      return getStubSettingsBuilder().deleteExascaleDbStorageVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDbSystemInitialStorageSizes. */
    public PagedCallSettings.Builder<
            ListDbSystemInitialStorageSizesRequest,
            ListDbSystemInitialStorageSizesResponse,
            ListDbSystemInitialStorageSizesPagedResponse>
        listDbSystemInitialStorageSizesSettings() {
      return getStubSettingsBuilder().listDbSystemInitialStorageSizesSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return getStubSettingsBuilder().listDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getStubSettingsBuilder().getDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to listPluggableDatabases. */
    public PagedCallSettings.Builder<
            ListPluggableDatabasesRequest,
            ListPluggableDatabasesResponse,
            ListPluggableDatabasesPagedResponse>
        listPluggableDatabasesSettings() {
      return getStubSettingsBuilder().listPluggableDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to getPluggableDatabase. */
    public UnaryCallSettings.Builder<GetPluggableDatabaseRequest, PluggableDatabase>
        getPluggableDatabaseSettings() {
      return getStubSettingsBuilder().getPluggableDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to listDbSystems. */
    public PagedCallSettings.Builder<
            ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
        listDbSystemsSettings() {
      return getStubSettingsBuilder().listDbSystemsSettings();
    }

    /** Returns the builder for the settings used for calls to getDbSystem. */
    public UnaryCallSettings.Builder<GetDbSystemRequest, DbSystem> getDbSystemSettings() {
      return getStubSettingsBuilder().getDbSystemSettings();
    }

    /** Returns the builder for the settings used for calls to createDbSystem. */
    public UnaryCallSettings.Builder<CreateDbSystemRequest, Operation> createDbSystemSettings() {
      return getStubSettingsBuilder().createDbSystemSettings();
    }

    /** Returns the builder for the settings used for calls to createDbSystem. */
    public OperationCallSettings.Builder<CreateDbSystemRequest, DbSystem, OperationMetadata>
        createDbSystemOperationSettings() {
      return getStubSettingsBuilder().createDbSystemOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDbSystem. */
    public UnaryCallSettings.Builder<DeleteDbSystemRequest, Operation> deleteDbSystemSettings() {
      return getStubSettingsBuilder().deleteDbSystemSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDbSystem. */
    public OperationCallSettings.Builder<DeleteDbSystemRequest, Empty, OperationMetadata>
        deleteDbSystemOperationSettings() {
      return getStubSettingsBuilder().deleteDbSystemOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDbVersions. */
    public PagedCallSettings.Builder<
            ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
        listDbVersionsSettings() {
      return getStubSettingsBuilder().listDbVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabaseCharacterSets. */
    public PagedCallSettings.Builder<
            ListDatabaseCharacterSetsRequest,
            ListDatabaseCharacterSetsResponse,
            ListDatabaseCharacterSetsPagedResponse>
        listDatabaseCharacterSetsSettings() {
      return getStubSettingsBuilder().listDatabaseCharacterSetsSettings();
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
    public OracleDatabaseSettings build() throws IOException {
      return new OracleDatabaseSettings(this);
    }
  }
}
