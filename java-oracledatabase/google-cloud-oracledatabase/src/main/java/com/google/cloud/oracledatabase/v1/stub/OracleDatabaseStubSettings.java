/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.oracledatabase.v1.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.AutonomousDatabase;
import com.google.cloud.oracledatabase.v1.AutonomousDatabaseBackup;
import com.google.cloud.oracledatabase.v1.AutonomousDatabaseCharacterSet;
import com.google.cloud.oracledatabase.v1.AutonomousDbVersion;
import com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure;
import com.google.cloud.oracledatabase.v1.CloudVmCluster;
import com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.CreateDbSystemRequest;
import com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.Database;
import com.google.cloud.oracledatabase.v1.DatabaseCharacterSet;
import com.google.cloud.oracledatabase.v1.DbNode;
import com.google.cloud.oracledatabase.v1.DbServer;
import com.google.cloud.oracledatabase.v1.DbSystem;
import com.google.cloud.oracledatabase.v1.DbSystemInitialStorageSize;
import com.google.cloud.oracledatabase.v1.DbSystemShape;
import com.google.cloud.oracledatabase.v1.DbVersion;
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest;
import com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.Entitlement;
import com.google.cloud.oracledatabase.v1.ExadbVmCluster;
import com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault;
import com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetDbSystemRequest;
import com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest;
import com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest;
import com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GiVersion;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest;
import com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest;
import com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse;
import com.google.cloud.oracledatabase.v1.ListDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListDatabasesResponse;
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemsRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemsResponse;
import com.google.cloud.oracledatabase.v1.ListDbVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListDbVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest;
import com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest;
import com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest;
import com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest;
import com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest;
import com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse;
import com.google.cloud.oracledatabase.v1.MinorVersion;
import com.google.cloud.oracledatabase.v1.OdbNetwork;
import com.google.cloud.oracledatabase.v1.OdbSubnet;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.PluggableDatabase;
import com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest;
import com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OracleDatabaseStub}.
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
 * OracleDatabaseStubSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseStubSettings.newBuilder();
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
 * OracleDatabaseStubSettings oracleDatabaseSettings = oracleDatabaseSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
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
 * OracleDatabaseStubSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseStubSettings.newBuilder();
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
public class OracleDatabaseStubSettings extends StubSettings<OracleDatabaseStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresSettings;
  private final UnaryCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureSettings;
  private final UnaryCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureSettings;
  private final OperationCallSettings<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationSettings;
  private final UnaryCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureSettings;
  private final OperationCallSettings<
          DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationSettings;
  private final PagedCallSettings<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, ListCloudVmClustersPagedResponse>
      listCloudVmClustersSettings;
  private final UnaryCallSettings<GetCloudVmClusterRequest, CloudVmCluster>
      getCloudVmClusterSettings;
  private final UnaryCallSettings<CreateCloudVmClusterRequest, Operation>
      createCloudVmClusterSettings;
  private final OperationCallSettings<
          CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationSettings;
  private final UnaryCallSettings<DeleteCloudVmClusterRequest, Operation>
      deleteCloudVmClusterSettings;
  private final OperationCallSettings<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationSettings;
  private final PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings;
  private final PagedCallSettings<
          ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
      listDbServersSettings;
  private final PagedCallSettings<ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
      listDbNodesSettings;
  private final PagedCallSettings<
          ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
      listGiVersionsSettings;
  private final PagedCallSettings<
          ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
      listMinorVersionsSettings;
  private final PagedCallSettings<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
      listDbSystemShapesSettings;
  private final PagedCallSettings<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesSettings;
  private final UnaryCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseSettings;
  private final UnaryCallSettings<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseSettings;
  private final OperationCallSettings<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseSettings;
  private final OperationCallSettings<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseSettings;
  private final OperationCallSettings<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseSettings;
  private final OperationCallSettings<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletSettings;
  private final PagedCallSettings<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsSettings;
  private final PagedCallSettings<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsSettings;
  private final PagedCallSettings<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsSettings;
  private final UnaryCallSettings<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseSettings;
  private final OperationCallSettings<
          StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseSettings;
  private final OperationCallSettings<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseSettings;
  private final OperationCallSettings<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseSettings;
  private final OperationCallSettings<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationSettings;
  private final UnaryCallSettings<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseSettings;
  private final OperationCallSettings<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationSettings;
  private final PagedCallSettings<
          ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
      listOdbNetworksSettings;
  private final UnaryCallSettings<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings;
  private final UnaryCallSettings<CreateOdbNetworkRequest, Operation> createOdbNetworkSettings;
  private final OperationCallSettings<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationSettings;
  private final UnaryCallSettings<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkSettings;
  private final OperationCallSettings<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationSettings;
  private final PagedCallSettings<
          ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
      listOdbSubnetsSettings;
  private final UnaryCallSettings<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings;
  private final UnaryCallSettings<CreateOdbSubnetRequest, Operation> createOdbSubnetSettings;
  private final OperationCallSettings<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationSettings;
  private final UnaryCallSettings<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetSettings;
  private final OperationCallSettings<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationSettings;
  private final PagedCallSettings<
          ListExadbVmClustersRequest, ListExadbVmClustersResponse, ListExadbVmClustersPagedResponse>
      listExadbVmClustersSettings;
  private final UnaryCallSettings<GetExadbVmClusterRequest, ExadbVmCluster>
      getExadbVmClusterSettings;
  private final UnaryCallSettings<CreateExadbVmClusterRequest, Operation>
      createExadbVmClusterSettings;
  private final OperationCallSettings<
          CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationSettings;
  private final UnaryCallSettings<DeleteExadbVmClusterRequest, Operation>
      deleteExadbVmClusterSettings;
  private final OperationCallSettings<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationSettings;
  private final UnaryCallSettings<UpdateExadbVmClusterRequest, Operation>
      updateExadbVmClusterSettings;
  private final OperationCallSettings<
          UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationSettings;
  private final UnaryCallSettings<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterSettings;
  private final OperationCallSettings<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationSettings;
  private final PagedCallSettings<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsSettings;
  private final UnaryCallSettings<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultSettings;
  private final UnaryCallSettings<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultSettings;
  private final OperationCallSettings<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationSettings;
  private final UnaryCallSettings<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultSettings;
  private final OperationCallSettings<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationSettings;
  private final PagedCallSettings<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesSettings;
  private final PagedCallSettings<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings;
  private final UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings;
  private final PagedCallSettings<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesSettings;
  private final UnaryCallSettings<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseSettings;
  private final PagedCallSettings<
          ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
      listDbSystemsSettings;
  private final UnaryCallSettings<GetDbSystemRequest, DbSystem> getDbSystemSettings;
  private final UnaryCallSettings<CreateDbSystemRequest, Operation> createDbSystemSettings;
  private final OperationCallSettings<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationSettings;
  private final UnaryCallSettings<DeleteDbSystemRequest, Operation> deleteDbSystemSettings;
  private final OperationCallSettings<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationSettings;
  private final PagedCallSettings<
          ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
      listDbVersionsSettings;
  private final PagedCallSettings<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          CloudExadataInfrastructure>
      LIST_CLOUD_EXADATA_INFRASTRUCTURES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCloudExadataInfrastructuresRequest,
              ListCloudExadataInfrastructuresResponse,
              CloudExadataInfrastructure>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCloudExadataInfrastructuresRequest injectToken(
                ListCloudExadataInfrastructuresRequest payload, String token) {
              return ListCloudExadataInfrastructuresRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCloudExadataInfrastructuresRequest injectPageSize(
                ListCloudExadataInfrastructuresRequest payload, int pageSize) {
              return ListCloudExadataInfrastructuresRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCloudExadataInfrastructuresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCloudExadataInfrastructuresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloudExadataInfrastructure> extractResources(
                ListCloudExadataInfrastructuresResponse payload) {
              return payload.getCloudExadataInfrastructuresList();
            }
          };

  private static final PagedListDescriptor<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
      LIST_CLOUD_VM_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCloudVmClustersRequest injectToken(
                ListCloudVmClustersRequest payload, String token) {
              return ListCloudVmClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCloudVmClustersRequest injectPageSize(
                ListCloudVmClustersRequest payload, int pageSize) {
              return ListCloudVmClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCloudVmClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCloudVmClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloudVmCluster> extractResources(ListCloudVmClustersResponse payload) {
              return payload.getCloudVmClustersList();
            }
          };

  private static final PagedListDescriptor<
          ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>
      LIST_ENTITLEMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntitlementsRequest injectToken(
                ListEntitlementsRequest payload, String token) {
              return ListEntitlementsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntitlementsRequest injectPageSize(
                ListEntitlementsRequest payload, int pageSize) {
              return ListEntitlementsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntitlementsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntitlementsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entitlement> extractResources(ListEntitlementsResponse payload) {
              return payload.getEntitlementsList();
            }
          };

  private static final PagedListDescriptor<ListDbServersRequest, ListDbServersResponse, DbServer>
      LIST_DB_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDbServersRequest, ListDbServersResponse, DbServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbServersRequest injectToken(ListDbServersRequest payload, String token) {
              return ListDbServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDbServersRequest injectPageSize(ListDbServersRequest payload, int pageSize) {
              return ListDbServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDbServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbServer> extractResources(ListDbServersResponse payload) {
              return payload.getDbServersList();
            }
          };

  private static final PagedListDescriptor<ListDbNodesRequest, ListDbNodesResponse, DbNode>
      LIST_DB_NODES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDbNodesRequest, ListDbNodesResponse, DbNode>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbNodesRequest injectToken(ListDbNodesRequest payload, String token) {
              return ListDbNodesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDbNodesRequest injectPageSize(ListDbNodesRequest payload, int pageSize) {
              return ListDbNodesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDbNodesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbNodesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbNode> extractResources(ListDbNodesResponse payload) {
              return payload.getDbNodesList();
            }
          };

  private static final PagedListDescriptor<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion>
      LIST_GI_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGiVersionsRequest injectToken(ListGiVersionsRequest payload, String token) {
              return ListGiVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGiVersionsRequest injectPageSize(
                ListGiVersionsRequest payload, int pageSize) {
              return ListGiVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGiVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGiVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GiVersion> extractResources(ListGiVersionsResponse payload) {
              return payload.getGiVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion>
      LIST_MINOR_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMinorVersionsRequest injectToken(
                ListMinorVersionsRequest payload, String token) {
              return ListMinorVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMinorVersionsRequest injectPageSize(
                ListMinorVersionsRequest payload, int pageSize) {
              return ListMinorVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMinorVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMinorVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MinorVersion> extractResources(ListMinorVersionsResponse payload) {
              return payload.getMinorVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape>
      LIST_DB_SYSTEM_SHAPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbSystemShapesRequest injectToken(
                ListDbSystemShapesRequest payload, String token) {
              return ListDbSystemShapesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDbSystemShapesRequest injectPageSize(
                ListDbSystemShapesRequest payload, int pageSize) {
              return ListDbSystemShapesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDbSystemShapesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbSystemShapesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbSystemShape> extractResources(ListDbSystemShapesResponse payload) {
              return payload.getDbSystemShapesList();
            }
          };

  private static final PagedListDescriptor<
          ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse, AutonomousDatabase>
      LIST_AUTONOMOUS_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutonomousDatabasesRequest,
              ListAutonomousDatabasesResponse,
              AutonomousDatabase>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutonomousDatabasesRequest injectToken(
                ListAutonomousDatabasesRequest payload, String token) {
              return ListAutonomousDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAutonomousDatabasesRequest injectPageSize(
                ListAutonomousDatabasesRequest payload, int pageSize) {
              return ListAutonomousDatabasesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAutonomousDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutonomousDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutonomousDatabase> extractResources(
                ListAutonomousDatabasesResponse payload) {
              return payload.getAutonomousDatabasesList();
            }
          };

  private static final PagedListDescriptor<
          ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse, AutonomousDbVersion>
      LIST_AUTONOMOUS_DB_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutonomousDbVersionsRequest,
              ListAutonomousDbVersionsResponse,
              AutonomousDbVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutonomousDbVersionsRequest injectToken(
                ListAutonomousDbVersionsRequest payload, String token) {
              return ListAutonomousDbVersionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAutonomousDbVersionsRequest injectPageSize(
                ListAutonomousDbVersionsRequest payload, int pageSize) {
              return ListAutonomousDbVersionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAutonomousDbVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutonomousDbVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutonomousDbVersion> extractResources(
                ListAutonomousDbVersionsResponse payload) {
              return payload.getAutonomousDbVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          AutonomousDatabaseCharacterSet>
      LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutonomousDatabaseCharacterSetsRequest,
              ListAutonomousDatabaseCharacterSetsResponse,
              AutonomousDatabaseCharacterSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutonomousDatabaseCharacterSetsRequest injectToken(
                ListAutonomousDatabaseCharacterSetsRequest payload, String token) {
              return ListAutonomousDatabaseCharacterSetsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAutonomousDatabaseCharacterSetsRequest injectPageSize(
                ListAutonomousDatabaseCharacterSetsRequest payload, int pageSize) {
              return ListAutonomousDatabaseCharacterSetsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAutonomousDatabaseCharacterSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutonomousDatabaseCharacterSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutonomousDatabaseCharacterSet> extractResources(
                ListAutonomousDatabaseCharacterSetsResponse payload) {
              return payload.getAutonomousDatabaseCharacterSetsList();
            }
          };

  private static final PagedListDescriptor<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          AutonomousDatabaseBackup>
      LIST_AUTONOMOUS_DATABASE_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutonomousDatabaseBackupsRequest,
              ListAutonomousDatabaseBackupsResponse,
              AutonomousDatabaseBackup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutonomousDatabaseBackupsRequest injectToken(
                ListAutonomousDatabaseBackupsRequest payload, String token) {
              return ListAutonomousDatabaseBackupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAutonomousDatabaseBackupsRequest injectPageSize(
                ListAutonomousDatabaseBackupsRequest payload, int pageSize) {
              return ListAutonomousDatabaseBackupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAutonomousDatabaseBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutonomousDatabaseBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutonomousDatabaseBackup> extractResources(
                ListAutonomousDatabaseBackupsResponse payload) {
              return payload.getAutonomousDatabaseBackupsList();
            }
          };

  private static final PagedListDescriptor<
          ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork>
      LIST_ODB_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOdbNetworksRequest injectToken(
                ListOdbNetworksRequest payload, String token) {
              return ListOdbNetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOdbNetworksRequest injectPageSize(
                ListOdbNetworksRequest payload, int pageSize) {
              return ListOdbNetworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOdbNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOdbNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OdbNetwork> extractResources(ListOdbNetworksResponse payload) {
              return payload.getOdbNetworksList();
            }
          };

  private static final PagedListDescriptor<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet>
      LIST_ODB_SUBNETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOdbSubnetsRequest injectToken(ListOdbSubnetsRequest payload, String token) {
              return ListOdbSubnetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOdbSubnetsRequest injectPageSize(
                ListOdbSubnetsRequest payload, int pageSize) {
              return ListOdbSubnetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOdbSubnetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOdbSubnetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OdbSubnet> extractResources(ListOdbSubnetsResponse payload) {
              return payload.getOdbSubnetsList();
            }
          };

  private static final PagedListDescriptor<
          ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
      LIST_EXADB_VM_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExadbVmClustersRequest injectToken(
                ListExadbVmClustersRequest payload, String token) {
              return ListExadbVmClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExadbVmClustersRequest injectPageSize(
                ListExadbVmClustersRequest payload, int pageSize) {
              return ListExadbVmClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExadbVmClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExadbVmClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExadbVmCluster> extractResources(ListExadbVmClustersResponse payload) {
              return payload.getExadbVmClustersList();
            }
          };

  private static final PagedListDescriptor<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ExascaleDbStorageVault>
      LIST_EXASCALE_DB_STORAGE_VAULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExascaleDbStorageVaultsRequest,
              ListExascaleDbStorageVaultsResponse,
              ExascaleDbStorageVault>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExascaleDbStorageVaultsRequest injectToken(
                ListExascaleDbStorageVaultsRequest payload, String token) {
              return ListExascaleDbStorageVaultsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListExascaleDbStorageVaultsRequest injectPageSize(
                ListExascaleDbStorageVaultsRequest payload, int pageSize) {
              return ListExascaleDbStorageVaultsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListExascaleDbStorageVaultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExascaleDbStorageVaultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExascaleDbStorageVault> extractResources(
                ListExascaleDbStorageVaultsResponse payload) {
              return payload.getExascaleDbStorageVaultsList();
            }
          };

  private static final PagedListDescriptor<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          DbSystemInitialStorageSize>
      LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDbSystemInitialStorageSizesRequest,
              ListDbSystemInitialStorageSizesResponse,
              DbSystemInitialStorageSize>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbSystemInitialStorageSizesRequest injectToken(
                ListDbSystemInitialStorageSizesRequest payload, String token) {
              return ListDbSystemInitialStorageSizesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDbSystemInitialStorageSizesRequest injectPageSize(
                ListDbSystemInitialStorageSizesRequest payload, int pageSize) {
              return ListDbSystemInitialStorageSizesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDbSystemInitialStorageSizesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbSystemInitialStorageSizesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbSystemInitialStorageSize> extractResources(
                ListDbSystemInitialStorageSizesResponse payload) {
              return payload.getDbSystemInitialStorageSizesList();
            }
          };

  private static final PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>
      LIST_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabasesRequest injectToken(ListDatabasesRequest payload, String token) {
              return ListDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatabasesRequest injectPageSize(ListDatabasesRequest payload, int pageSize) {
              return ListDatabasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Database> extractResources(ListDatabasesResponse payload) {
              return payload.getDatabasesList();
            }
          };

  private static final PagedListDescriptor<
          ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>
      LIST_PLUGGABLE_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPluggableDatabasesRequest injectToken(
                ListPluggableDatabasesRequest payload, String token) {
              return ListPluggableDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPluggableDatabasesRequest injectPageSize(
                ListPluggableDatabasesRequest payload, int pageSize) {
              return ListPluggableDatabasesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPluggableDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPluggableDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PluggableDatabase> extractResources(
                ListPluggableDatabasesResponse payload) {
              return payload.getPluggableDatabasesList();
            }
          };

  private static final PagedListDescriptor<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem>
      LIST_DB_SYSTEMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbSystemsRequest injectToken(ListDbSystemsRequest payload, String token) {
              return ListDbSystemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDbSystemsRequest injectPageSize(ListDbSystemsRequest payload, int pageSize) {
              return ListDbSystemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDbSystemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbSystemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbSystem> extractResources(ListDbSystemsResponse payload) {
              return payload.getDbSystemsList();
            }
          };

  private static final PagedListDescriptor<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion>
      LIST_DB_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDbVersionsRequest injectToken(ListDbVersionsRequest payload, String token) {
              return ListDbVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDbVersionsRequest injectPageSize(
                ListDbVersionsRequest payload, int pageSize) {
              return ListDbVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDbVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDbVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DbVersion> extractResources(ListDbVersionsResponse payload) {
              return payload.getDbVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse, DatabaseCharacterSet>
      LIST_DATABASE_CHARACTER_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDatabaseCharacterSetsRequest,
              ListDatabaseCharacterSetsResponse,
              DatabaseCharacterSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabaseCharacterSetsRequest injectToken(
                ListDatabaseCharacterSetsRequest payload, String token) {
              return ListDatabaseCharacterSetsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDatabaseCharacterSetsRequest injectPageSize(
                ListDatabaseCharacterSetsRequest payload, int pageSize) {
              return ListDatabaseCharacterSetsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDatabaseCharacterSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabaseCharacterSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatabaseCharacterSet> extractResources(
                ListDatabaseCharacterSetsResponse payload) {
              return payload.getDatabaseCharacterSetsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          ListCloudExadataInfrastructuresPagedResponse>
      LIST_CLOUD_EXADATA_INFRASTRUCTURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCloudExadataInfrastructuresRequest,
              ListCloudExadataInfrastructuresResponse,
              ListCloudExadataInfrastructuresPagedResponse>() {
            @Override
            public ApiFuture<ListCloudExadataInfrastructuresPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListCloudExadataInfrastructuresRequest,
                        ListCloudExadataInfrastructuresResponse>
                    callable,
                ListCloudExadataInfrastructuresRequest request,
                ApiCallContext context,
                ApiFuture<ListCloudExadataInfrastructuresResponse> futureResponse) {
              PageContext<
                      ListCloudExadataInfrastructuresRequest,
                      ListCloudExadataInfrastructuresResponse,
                      CloudExadataInfrastructure>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CLOUD_EXADATA_INFRASTRUCTURES_PAGE_STR_DESC,
                          request,
                          context);
              return ListCloudExadataInfrastructuresPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, ListCloudVmClustersPagedResponse>
      LIST_CLOUD_VM_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCloudVmClustersRequest,
              ListCloudVmClustersResponse,
              ListCloudVmClustersPagedResponse>() {
            @Override
            public ApiFuture<ListCloudVmClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse> callable,
                ListCloudVmClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListCloudVmClustersResponse> futureResponse) {
              PageContext<ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CLOUD_VM_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListCloudVmClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      LIST_ENTITLEMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>() {
            @Override
            public ApiFuture<ListEntitlementsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse> callable,
                ListEntitlementsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntitlementsResponse> futureResponse) {
              PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENTITLEMENTS_PAGE_STR_DESC, request, context);
              return ListEntitlementsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
      LIST_DB_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>() {
            @Override
            public ApiFuture<ListDbServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDbServersRequest, ListDbServersResponse> callable,
                ListDbServersRequest request,
                ApiCallContext context,
                ApiFuture<ListDbServersResponse> futureResponse) {
              PageContext<ListDbServersRequest, ListDbServersResponse, DbServer> pageContext =
                  PageContext.create(callable, LIST_DB_SERVERS_PAGE_STR_DESC, request, context);
              return ListDbServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
      LIST_DB_NODES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>() {
            @Override
            public ApiFuture<ListDbNodesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> callable,
                ListDbNodesRequest request,
                ApiCallContext context,
                ApiFuture<ListDbNodesResponse> futureResponse) {
              PageContext<ListDbNodesRequest, ListDbNodesResponse, DbNode> pageContext =
                  PageContext.create(callable, LIST_DB_NODES_PAGE_STR_DESC, request, context);
              return ListDbNodesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
      LIST_GI_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListGiVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse> callable,
                ListGiVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListGiVersionsResponse> futureResponse) {
              PageContext<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion> pageContext =
                  PageContext.create(callable, LIST_GI_VERSIONS_PAGE_STR_DESC, request, context);
              return ListGiVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
      LIST_MINOR_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMinorVersionsRequest,
              ListMinorVersionsResponse,
              ListMinorVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListMinorVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse> callable,
                ListMinorVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListMinorVersionsResponse> futureResponse) {
              PageContext<ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MINOR_VERSIONS_PAGE_STR_DESC, request, context);
              return ListMinorVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
      LIST_DB_SYSTEM_SHAPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbSystemShapesRequest,
              ListDbSystemShapesResponse,
              ListDbSystemShapesPagedResponse>() {
            @Override
            public ApiFuture<ListDbSystemShapesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse> callable,
                ListDbSystemShapesRequest request,
                ApiCallContext context,
                ApiFuture<ListDbSystemShapesResponse> futureResponse) {
              PageContext<ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DB_SYSTEM_SHAPES_PAGE_STR_DESC, request, context);
              return ListDbSystemShapesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          ListAutonomousDatabasesPagedResponse>
      LIST_AUTONOMOUS_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutonomousDatabasesRequest,
              ListAutonomousDatabasesResponse,
              ListAutonomousDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListAutonomousDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
                    callable,
                ListAutonomousDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListAutonomousDatabasesResponse> futureResponse) {
              PageContext<
                      ListAutonomousDatabasesRequest,
                      ListAutonomousDatabasesResponse,
                      AutonomousDatabase>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTONOMOUS_DATABASES_PAGE_STR_DESC, request, context);
              return ListAutonomousDatabasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          ListAutonomousDbVersionsPagedResponse>
      LIST_AUTONOMOUS_DB_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutonomousDbVersionsRequest,
              ListAutonomousDbVersionsResponse,
              ListAutonomousDbVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListAutonomousDbVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
                    callable,
                ListAutonomousDbVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListAutonomousDbVersionsResponse> futureResponse) {
              PageContext<
                      ListAutonomousDbVersionsRequest,
                      ListAutonomousDbVersionsResponse,
                      AutonomousDbVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTONOMOUS_DB_VERSIONS_PAGE_STR_DESC, request, context);
              return ListAutonomousDbVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutonomousDatabaseCharacterSetsRequest,
              ListAutonomousDatabaseCharacterSetsResponse,
              ListAutonomousDatabaseCharacterSetsPagedResponse>() {
            @Override
            public ApiFuture<ListAutonomousDatabaseCharacterSetsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListAutonomousDatabaseCharacterSetsRequest,
                            ListAutonomousDatabaseCharacterSetsResponse>
                        callable,
                    ListAutonomousDatabaseCharacterSetsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListAutonomousDatabaseCharacterSetsResponse> futureResponse) {
              PageContext<
                      ListAutonomousDatabaseCharacterSetsRequest,
                      ListAutonomousDatabaseCharacterSetsResponse,
                      AutonomousDatabaseCharacterSet>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS_PAGE_STR_DESC,
                          request,
                          context);
              return ListAutonomousDatabaseCharacterSetsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          ListAutonomousDatabaseBackupsPagedResponse>
      LIST_AUTONOMOUS_DATABASE_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutonomousDatabaseBackupsRequest,
              ListAutonomousDatabaseBackupsResponse,
              ListAutonomousDatabaseBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListAutonomousDatabaseBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
                    callable,
                ListAutonomousDatabaseBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListAutonomousDatabaseBackupsResponse> futureResponse) {
              PageContext<
                      ListAutonomousDatabaseBackupsRequest,
                      ListAutonomousDatabaseBackupsResponse,
                      AutonomousDatabaseBackup>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_AUTONOMOUS_DATABASE_BACKUPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListAutonomousDatabaseBackupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
      LIST_ODB_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListOdbNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse> callable,
                ListOdbNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListOdbNetworksResponse> futureResponse) {
              PageContext<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork> pageContext =
                  PageContext.create(callable, LIST_ODB_NETWORKS_PAGE_STR_DESC, request, context);
              return ListOdbNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
      LIST_ODB_SUBNETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>() {
            @Override
            public ApiFuture<ListOdbSubnetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse> callable,
                ListOdbSubnetsRequest request,
                ApiCallContext context,
                ApiFuture<ListOdbSubnetsResponse> futureResponse) {
              PageContext<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet> pageContext =
                  PageContext.create(callable, LIST_ODB_SUBNETS_PAGE_STR_DESC, request, context);
              return ListOdbSubnetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExadbVmClustersRequest, ListExadbVmClustersResponse, ListExadbVmClustersPagedResponse>
      LIST_EXADB_VM_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExadbVmClustersRequest,
              ListExadbVmClustersResponse,
              ListExadbVmClustersPagedResponse>() {
            @Override
            public ApiFuture<ListExadbVmClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse> callable,
                ListExadbVmClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListExadbVmClustersResponse> futureResponse) {
              PageContext<ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXADB_VM_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListExadbVmClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ListExascaleDbStorageVaultsPagedResponse>
      LIST_EXASCALE_DB_STORAGE_VAULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExascaleDbStorageVaultsRequest,
              ListExascaleDbStorageVaultsResponse,
              ListExascaleDbStorageVaultsPagedResponse>() {
            @Override
            public ApiFuture<ListExascaleDbStorageVaultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
                    callable,
                ListExascaleDbStorageVaultsRequest request,
                ApiCallContext context,
                ApiFuture<ListExascaleDbStorageVaultsResponse> futureResponse) {
              PageContext<
                      ListExascaleDbStorageVaultsRequest,
                      ListExascaleDbStorageVaultsResponse,
                      ExascaleDbStorageVault>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_EXASCALE_DB_STORAGE_VAULTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListExascaleDbStorageVaultsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          ListDbSystemInitialStorageSizesPagedResponse>
      LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbSystemInitialStorageSizesRequest,
              ListDbSystemInitialStorageSizesResponse,
              ListDbSystemInitialStorageSizesPagedResponse>() {
            @Override
            public ApiFuture<ListDbSystemInitialStorageSizesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListDbSystemInitialStorageSizesRequest,
                        ListDbSystemInitialStorageSizesResponse>
                    callable,
                ListDbSystemInitialStorageSizesRequest request,
                ApiCallContext context,
                ApiFuture<ListDbSystemInitialStorageSizesResponse> futureResponse) {
              PageContext<
                      ListDbSystemInitialStorageSizesRequest,
                      ListDbSystemInitialStorageSizesResponse,
                      DbSystemInitialStorageSize>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES_PAGE_STR_DESC,
                          request,
                          context);
              return ListDbSystemInitialStorageSizesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      LIST_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> callable,
                ListDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabasesResponse> futureResponse) {
              PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> pageContext =
                  PageContext.create(callable, LIST_DATABASES_PAGE_STR_DESC, request, context);
              return ListDatabasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          ListPluggableDatabasesPagedResponse>
      LIST_PLUGGABLE_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPluggableDatabasesRequest,
              ListPluggableDatabasesResponse,
              ListPluggableDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListPluggableDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
                    callable,
                ListPluggableDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListPluggableDatabasesResponse> futureResponse) {
              PageContext<
                      ListPluggableDatabasesRequest,
                      ListPluggableDatabasesResponse,
                      PluggableDatabase>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PLUGGABLE_DATABASES_PAGE_STR_DESC, request, context);
              return ListPluggableDatabasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
      LIST_DB_SYSTEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>() {
            @Override
            public ApiFuture<ListDbSystemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> callable,
                ListDbSystemsRequest request,
                ApiCallContext context,
                ApiFuture<ListDbSystemsResponse> futureResponse) {
              PageContext<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem> pageContext =
                  PageContext.create(callable, LIST_DB_SYSTEMS_PAGE_STR_DESC, request, context);
              return ListDbSystemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
      LIST_DB_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListDbVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse> callable,
                ListDbVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListDbVersionsResponse> futureResponse) {
              PageContext<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion> pageContext =
                  PageContext.create(callable, LIST_DB_VERSIONS_PAGE_STR_DESC, request, context);
              return ListDbVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          ListDatabaseCharacterSetsPagedResponse>
      LIST_DATABASE_CHARACTER_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabaseCharacterSetsRequest,
              ListDatabaseCharacterSetsResponse,
              ListDatabaseCharacterSetsPagedResponse>() {
            @Override
            public ApiFuture<ListDatabaseCharacterSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
                    callable,
                ListDatabaseCharacterSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabaseCharacterSetsResponse> futureResponse) {
              PageContext<
                      ListDatabaseCharacterSetsRequest,
                      ListDatabaseCharacterSetsResponse,
                      DatabaseCharacterSet>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATABASE_CHARACTER_SETS_PAGE_STR_DESC, request, context);
              return ListDatabaseCharacterSetsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listCloudExadataInfrastructures. */
  public PagedCallSettings<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresSettings() {
    return listCloudExadataInfrastructuresSettings;
  }

  /** Returns the object with the settings used for calls to getCloudExadataInfrastructure. */
  public UnaryCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureSettings() {
    return getCloudExadataInfrastructureSettings;
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public UnaryCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureSettings() {
    return createCloudExadataInfrastructureSettings;
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public OperationCallSettings<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationSettings() {
    return createCloudExadataInfrastructureOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public UnaryCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureSettings() {
    return deleteCloudExadataInfrastructureSettings;
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public OperationCallSettings<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationSettings() {
    return deleteCloudExadataInfrastructureOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCloudVmClusters. */
  public PagedCallSettings<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, ListCloudVmClustersPagedResponse>
      listCloudVmClustersSettings() {
    return listCloudVmClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCloudVmCluster. */
  public UnaryCallSettings<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterSettings() {
    return getCloudVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public UnaryCallSettings<CreateCloudVmClusterRequest, Operation> createCloudVmClusterSettings() {
    return createCloudVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public OperationCallSettings<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationSettings() {
    return createCloudVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public UnaryCallSettings<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterSettings() {
    return deleteCloudVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public OperationCallSettings<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationSettings() {
    return deleteCloudVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return listEntitlementsSettings;
  }

  /** Returns the object with the settings used for calls to listDbServers. */
  public PagedCallSettings<ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
      listDbServersSettings() {
    return listDbServersSettings;
  }

  /** Returns the object with the settings used for calls to listDbNodes. */
  public PagedCallSettings<ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
      listDbNodesSettings() {
    return listDbNodesSettings;
  }

  /** Returns the object with the settings used for calls to listGiVersions. */
  public PagedCallSettings<
          ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
      listGiVersionsSettings() {
    return listGiVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listMinorVersions. */
  public PagedCallSettings<
          ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
      listMinorVersionsSettings() {
    return listMinorVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listDbSystemShapes. */
  public PagedCallSettings<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
      listDbSystemShapesSettings() {
    return listDbSystemShapesSettings;
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabases. */
  public PagedCallSettings<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesSettings() {
    return listAutonomousDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to getAutonomousDatabase. */
  public UnaryCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseSettings() {
    return getAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public UnaryCallSettings<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseSettings() {
    return createAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public OperationCallSettings<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationSettings() {
    return createAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAutonomousDatabase. */
  public UnaryCallSettings<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseSettings() {
    return updateAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to updateAutonomousDatabase. */
  public OperationCallSettings<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationSettings() {
    return updateAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public UnaryCallSettings<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseSettings() {
    return deleteAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public OperationCallSettings<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationSettings() {
    return deleteAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public UnaryCallSettings<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseSettings() {
    return restoreAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public OperationCallSettings<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationSettings() {
    return restoreAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateAutonomousDatabaseWallet. */
  public UnaryCallSettings<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletSettings() {
    return generateAutonomousDatabaseWalletSettings;
  }

  /** Returns the object with the settings used for calls to listAutonomousDbVersions. */
  public PagedCallSettings<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsSettings() {
    return listAutonomousDbVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseCharacterSets. */
  public PagedCallSettings<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsSettings() {
    return listAutonomousDatabaseCharacterSetsSettings;
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseBackups. */
  public PagedCallSettings<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsSettings() {
    return listAutonomousDatabaseBackupsSettings;
  }

  /** Returns the object with the settings used for calls to stopAutonomousDatabase. */
  public UnaryCallSettings<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseSettings() {
    return stopAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to stopAutonomousDatabase. */
  public OperationCallSettings<StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationSettings() {
    return stopAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to startAutonomousDatabase. */
  public UnaryCallSettings<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseSettings() {
    return startAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to startAutonomousDatabase. */
  public OperationCallSettings<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationSettings() {
    return startAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to restartAutonomousDatabase. */
  public UnaryCallSettings<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseSettings() {
    return restartAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to restartAutonomousDatabase. */
  public OperationCallSettings<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationSettings() {
    return restartAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to switchoverAutonomousDatabase. */
  public UnaryCallSettings<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseSettings() {
    return switchoverAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to switchoverAutonomousDatabase. */
  public OperationCallSettings<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationSettings() {
    return switchoverAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to failoverAutonomousDatabase. */
  public UnaryCallSettings<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseSettings() {
    return failoverAutonomousDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to failoverAutonomousDatabase. */
  public OperationCallSettings<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationSettings() {
    return failoverAutonomousDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to listOdbNetworks. */
  public PagedCallSettings<
          ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
      listOdbNetworksSettings() {
    return listOdbNetworksSettings;
  }

  /** Returns the object with the settings used for calls to getOdbNetwork. */
  public UnaryCallSettings<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings() {
    return getOdbNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createOdbNetwork. */
  public UnaryCallSettings<CreateOdbNetworkRequest, Operation> createOdbNetworkSettings() {
    return createOdbNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createOdbNetwork. */
  public OperationCallSettings<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationSettings() {
    return createOdbNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOdbNetwork. */
  public UnaryCallSettings<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkSettings() {
    return deleteOdbNetworkSettings;
  }

  /** Returns the object with the settings used for calls to deleteOdbNetwork. */
  public OperationCallSettings<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationSettings() {
    return deleteOdbNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to listOdbSubnets. */
  public PagedCallSettings<
          ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
      listOdbSubnetsSettings() {
    return listOdbSubnetsSettings;
  }

  /** Returns the object with the settings used for calls to getOdbSubnet. */
  public UnaryCallSettings<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings() {
    return getOdbSubnetSettings;
  }

  /** Returns the object with the settings used for calls to createOdbSubnet. */
  public UnaryCallSettings<CreateOdbSubnetRequest, Operation> createOdbSubnetSettings() {
    return createOdbSubnetSettings;
  }

  /** Returns the object with the settings used for calls to createOdbSubnet. */
  public OperationCallSettings<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationSettings() {
    return createOdbSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOdbSubnet. */
  public UnaryCallSettings<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetSettings() {
    return deleteOdbSubnetSettings;
  }

  /** Returns the object with the settings used for calls to deleteOdbSubnet. */
  public OperationCallSettings<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationSettings() {
    return deleteOdbSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExadbVmClusters. */
  public PagedCallSettings<
          ListExadbVmClustersRequest, ListExadbVmClustersResponse, ListExadbVmClustersPagedResponse>
      listExadbVmClustersSettings() {
    return listExadbVmClustersSettings;
  }

  /** Returns the object with the settings used for calls to getExadbVmCluster. */
  public UnaryCallSettings<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterSettings() {
    return getExadbVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to createExadbVmCluster. */
  public UnaryCallSettings<CreateExadbVmClusterRequest, Operation> createExadbVmClusterSettings() {
    return createExadbVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to createExadbVmCluster. */
  public OperationCallSettings<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationSettings() {
    return createExadbVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExadbVmCluster. */
  public UnaryCallSettings<DeleteExadbVmClusterRequest, Operation> deleteExadbVmClusterSettings() {
    return deleteExadbVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteExadbVmCluster. */
  public OperationCallSettings<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationSettings() {
    return deleteExadbVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateExadbVmCluster. */
  public UnaryCallSettings<UpdateExadbVmClusterRequest, Operation> updateExadbVmClusterSettings() {
    return updateExadbVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateExadbVmCluster. */
  public OperationCallSettings<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationSettings() {
    return updateExadbVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeVirtualMachineExadbVmCluster. */
  public UnaryCallSettings<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterSettings() {
    return removeVirtualMachineExadbVmClusterSettings;
  }

  /** Returns the object with the settings used for calls to removeVirtualMachineExadbVmCluster. */
  public OperationCallSettings<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationSettings() {
    return removeVirtualMachineExadbVmClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExascaleDbStorageVaults. */
  public PagedCallSettings<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsSettings() {
    return listExascaleDbStorageVaultsSettings;
  }

  /** Returns the object with the settings used for calls to getExascaleDbStorageVault. */
  public UnaryCallSettings<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultSettings() {
    return getExascaleDbStorageVaultSettings;
  }

  /** Returns the object with the settings used for calls to createExascaleDbStorageVault. */
  public UnaryCallSettings<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultSettings() {
    return createExascaleDbStorageVaultSettings;
  }

  /** Returns the object with the settings used for calls to createExascaleDbStorageVault. */
  public OperationCallSettings<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationSettings() {
    return createExascaleDbStorageVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExascaleDbStorageVault. */
  public UnaryCallSettings<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultSettings() {
    return deleteExascaleDbStorageVaultSettings;
  }

  /** Returns the object with the settings used for calls to deleteExascaleDbStorageVault. */
  public OperationCallSettings<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationSettings() {
    return deleteExascaleDbStorageVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDbSystemInitialStorageSizes. */
  public PagedCallSettings<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesSettings() {
    return listDbSystemInitialStorageSizesSettings;
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return listDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return getDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to listPluggableDatabases. */
  public PagedCallSettings<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesSettings() {
    return listPluggableDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to getPluggableDatabase. */
  public UnaryCallSettings<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseSettings() {
    return getPluggableDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to listDbSystems. */
  public PagedCallSettings<ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
      listDbSystemsSettings() {
    return listDbSystemsSettings;
  }

  /** Returns the object with the settings used for calls to getDbSystem. */
  public UnaryCallSettings<GetDbSystemRequest, DbSystem> getDbSystemSettings() {
    return getDbSystemSettings;
  }

  /** Returns the object with the settings used for calls to createDbSystem. */
  public UnaryCallSettings<CreateDbSystemRequest, Operation> createDbSystemSettings() {
    return createDbSystemSettings;
  }

  /** Returns the object with the settings used for calls to createDbSystem. */
  public OperationCallSettings<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationSettings() {
    return createDbSystemOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDbSystem. */
  public UnaryCallSettings<DeleteDbSystemRequest, Operation> deleteDbSystemSettings() {
    return deleteDbSystemSettings;
  }

  /** Returns the object with the settings used for calls to deleteDbSystem. */
  public OperationCallSettings<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationSettings() {
    return deleteDbSystemOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDbVersions. */
  public PagedCallSettings<
          ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
      listDbVersionsSettings() {
    return listDbVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listDatabaseCharacterSets. */
  public PagedCallSettings<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsSettings() {
    return listDatabaseCharacterSetsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public OracleDatabaseStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOracleDatabaseStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOracleDatabaseStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "oracledatabase";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "oracledatabase.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "oracledatabase.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OracleDatabaseStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OracleDatabaseStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OracleDatabaseStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected OracleDatabaseStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listCloudExadataInfrastructuresSettings =
        settingsBuilder.listCloudExadataInfrastructuresSettings().build();
    getCloudExadataInfrastructureSettings =
        settingsBuilder.getCloudExadataInfrastructureSettings().build();
    createCloudExadataInfrastructureSettings =
        settingsBuilder.createCloudExadataInfrastructureSettings().build();
    createCloudExadataInfrastructureOperationSettings =
        settingsBuilder.createCloudExadataInfrastructureOperationSettings().build();
    deleteCloudExadataInfrastructureSettings =
        settingsBuilder.deleteCloudExadataInfrastructureSettings().build();
    deleteCloudExadataInfrastructureOperationSettings =
        settingsBuilder.deleteCloudExadataInfrastructureOperationSettings().build();
    listCloudVmClustersSettings = settingsBuilder.listCloudVmClustersSettings().build();
    getCloudVmClusterSettings = settingsBuilder.getCloudVmClusterSettings().build();
    createCloudVmClusterSettings = settingsBuilder.createCloudVmClusterSettings().build();
    createCloudVmClusterOperationSettings =
        settingsBuilder.createCloudVmClusterOperationSettings().build();
    deleteCloudVmClusterSettings = settingsBuilder.deleteCloudVmClusterSettings().build();
    deleteCloudVmClusterOperationSettings =
        settingsBuilder.deleteCloudVmClusterOperationSettings().build();
    listEntitlementsSettings = settingsBuilder.listEntitlementsSettings().build();
    listDbServersSettings = settingsBuilder.listDbServersSettings().build();
    listDbNodesSettings = settingsBuilder.listDbNodesSettings().build();
    listGiVersionsSettings = settingsBuilder.listGiVersionsSettings().build();
    listMinorVersionsSettings = settingsBuilder.listMinorVersionsSettings().build();
    listDbSystemShapesSettings = settingsBuilder.listDbSystemShapesSettings().build();
    listAutonomousDatabasesSettings = settingsBuilder.listAutonomousDatabasesSettings().build();
    getAutonomousDatabaseSettings = settingsBuilder.getAutonomousDatabaseSettings().build();
    createAutonomousDatabaseSettings = settingsBuilder.createAutonomousDatabaseSettings().build();
    createAutonomousDatabaseOperationSettings =
        settingsBuilder.createAutonomousDatabaseOperationSettings().build();
    updateAutonomousDatabaseSettings = settingsBuilder.updateAutonomousDatabaseSettings().build();
    updateAutonomousDatabaseOperationSettings =
        settingsBuilder.updateAutonomousDatabaseOperationSettings().build();
    deleteAutonomousDatabaseSettings = settingsBuilder.deleteAutonomousDatabaseSettings().build();
    deleteAutonomousDatabaseOperationSettings =
        settingsBuilder.deleteAutonomousDatabaseOperationSettings().build();
    restoreAutonomousDatabaseSettings = settingsBuilder.restoreAutonomousDatabaseSettings().build();
    restoreAutonomousDatabaseOperationSettings =
        settingsBuilder.restoreAutonomousDatabaseOperationSettings().build();
    generateAutonomousDatabaseWalletSettings =
        settingsBuilder.generateAutonomousDatabaseWalletSettings().build();
    listAutonomousDbVersionsSettings = settingsBuilder.listAutonomousDbVersionsSettings().build();
    listAutonomousDatabaseCharacterSetsSettings =
        settingsBuilder.listAutonomousDatabaseCharacterSetsSettings().build();
    listAutonomousDatabaseBackupsSettings =
        settingsBuilder.listAutonomousDatabaseBackupsSettings().build();
    stopAutonomousDatabaseSettings = settingsBuilder.stopAutonomousDatabaseSettings().build();
    stopAutonomousDatabaseOperationSettings =
        settingsBuilder.stopAutonomousDatabaseOperationSettings().build();
    startAutonomousDatabaseSettings = settingsBuilder.startAutonomousDatabaseSettings().build();
    startAutonomousDatabaseOperationSettings =
        settingsBuilder.startAutonomousDatabaseOperationSettings().build();
    restartAutonomousDatabaseSettings = settingsBuilder.restartAutonomousDatabaseSettings().build();
    restartAutonomousDatabaseOperationSettings =
        settingsBuilder.restartAutonomousDatabaseOperationSettings().build();
    switchoverAutonomousDatabaseSettings =
        settingsBuilder.switchoverAutonomousDatabaseSettings().build();
    switchoverAutonomousDatabaseOperationSettings =
        settingsBuilder.switchoverAutonomousDatabaseOperationSettings().build();
    failoverAutonomousDatabaseSettings =
        settingsBuilder.failoverAutonomousDatabaseSettings().build();
    failoverAutonomousDatabaseOperationSettings =
        settingsBuilder.failoverAutonomousDatabaseOperationSettings().build();
    listOdbNetworksSettings = settingsBuilder.listOdbNetworksSettings().build();
    getOdbNetworkSettings = settingsBuilder.getOdbNetworkSettings().build();
    createOdbNetworkSettings = settingsBuilder.createOdbNetworkSettings().build();
    createOdbNetworkOperationSettings = settingsBuilder.createOdbNetworkOperationSettings().build();
    deleteOdbNetworkSettings = settingsBuilder.deleteOdbNetworkSettings().build();
    deleteOdbNetworkOperationSettings = settingsBuilder.deleteOdbNetworkOperationSettings().build();
    listOdbSubnetsSettings = settingsBuilder.listOdbSubnetsSettings().build();
    getOdbSubnetSettings = settingsBuilder.getOdbSubnetSettings().build();
    createOdbSubnetSettings = settingsBuilder.createOdbSubnetSettings().build();
    createOdbSubnetOperationSettings = settingsBuilder.createOdbSubnetOperationSettings().build();
    deleteOdbSubnetSettings = settingsBuilder.deleteOdbSubnetSettings().build();
    deleteOdbSubnetOperationSettings = settingsBuilder.deleteOdbSubnetOperationSettings().build();
    listExadbVmClustersSettings = settingsBuilder.listExadbVmClustersSettings().build();
    getExadbVmClusterSettings = settingsBuilder.getExadbVmClusterSettings().build();
    createExadbVmClusterSettings = settingsBuilder.createExadbVmClusterSettings().build();
    createExadbVmClusterOperationSettings =
        settingsBuilder.createExadbVmClusterOperationSettings().build();
    deleteExadbVmClusterSettings = settingsBuilder.deleteExadbVmClusterSettings().build();
    deleteExadbVmClusterOperationSettings =
        settingsBuilder.deleteExadbVmClusterOperationSettings().build();
    updateExadbVmClusterSettings = settingsBuilder.updateExadbVmClusterSettings().build();
    updateExadbVmClusterOperationSettings =
        settingsBuilder.updateExadbVmClusterOperationSettings().build();
    removeVirtualMachineExadbVmClusterSettings =
        settingsBuilder.removeVirtualMachineExadbVmClusterSettings().build();
    removeVirtualMachineExadbVmClusterOperationSettings =
        settingsBuilder.removeVirtualMachineExadbVmClusterOperationSettings().build();
    listExascaleDbStorageVaultsSettings =
        settingsBuilder.listExascaleDbStorageVaultsSettings().build();
    getExascaleDbStorageVaultSettings = settingsBuilder.getExascaleDbStorageVaultSettings().build();
    createExascaleDbStorageVaultSettings =
        settingsBuilder.createExascaleDbStorageVaultSettings().build();
    createExascaleDbStorageVaultOperationSettings =
        settingsBuilder.createExascaleDbStorageVaultOperationSettings().build();
    deleteExascaleDbStorageVaultSettings =
        settingsBuilder.deleteExascaleDbStorageVaultSettings().build();
    deleteExascaleDbStorageVaultOperationSettings =
        settingsBuilder.deleteExascaleDbStorageVaultOperationSettings().build();
    listDbSystemInitialStorageSizesSettings =
        settingsBuilder.listDbSystemInitialStorageSizesSettings().build();
    listDatabasesSettings = settingsBuilder.listDatabasesSettings().build();
    getDatabaseSettings = settingsBuilder.getDatabaseSettings().build();
    listPluggableDatabasesSettings = settingsBuilder.listPluggableDatabasesSettings().build();
    getPluggableDatabaseSettings = settingsBuilder.getPluggableDatabaseSettings().build();
    listDbSystemsSettings = settingsBuilder.listDbSystemsSettings().build();
    getDbSystemSettings = settingsBuilder.getDbSystemSettings().build();
    createDbSystemSettings = settingsBuilder.createDbSystemSettings().build();
    createDbSystemOperationSettings = settingsBuilder.createDbSystemOperationSettings().build();
    deleteDbSystemSettings = settingsBuilder.deleteDbSystemSettings().build();
    deleteDbSystemOperationSettings = settingsBuilder.deleteDbSystemOperationSettings().build();
    listDbVersionsSettings = settingsBuilder.listDbVersionsSettings().build();
    listDatabaseCharacterSetsSettings = settingsBuilder.listDatabaseCharacterSetsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for OracleDatabaseStubSettings. */
  public static class Builder extends StubSettings.Builder<OracleDatabaseStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListCloudExadataInfrastructuresRequest,
            ListCloudExadataInfrastructuresResponse,
            ListCloudExadataInfrastructuresPagedResponse>
        listCloudExadataInfrastructuresSettings;
    private final UnaryCallSettings.Builder<
            GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureSettings;
    private final UnaryCallSettings.Builder<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureSettings;
    private final OperationCallSettings.Builder<
            CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
        createCloudExadataInfrastructureOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureSettings;
    private final OperationCallSettings.Builder<
            DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
        deleteCloudExadataInfrastructureOperationSettings;
    private final PagedCallSettings.Builder<
            ListCloudVmClustersRequest,
            ListCloudVmClustersResponse,
            ListCloudVmClustersPagedResponse>
        listCloudVmClustersSettings;
    private final UnaryCallSettings.Builder<GetCloudVmClusterRequest, CloudVmCluster>
        getCloudVmClusterSettings;
    private final UnaryCallSettings.Builder<CreateCloudVmClusterRequest, Operation>
        createCloudVmClusterSettings;
    private final OperationCallSettings.Builder<
            CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
        createCloudVmClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCloudVmClusterRequest, Operation>
        deleteCloudVmClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteCloudVmClusterRequest, Empty, OperationMetadata>
        deleteCloudVmClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings;
    private final PagedCallSettings.Builder<
            ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
        listDbServersSettings;
    private final PagedCallSettings.Builder<
            ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
        listDbNodesSettings;
    private final PagedCallSettings.Builder<
            ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
        listGiVersionsSettings;
    private final PagedCallSettings.Builder<
            ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
        listMinorVersionsSettings;
    private final PagedCallSettings.Builder<
            ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
        listDbSystemShapesSettings;
    private final PagedCallSettings.Builder<
            ListAutonomousDatabasesRequest,
            ListAutonomousDatabasesResponse,
            ListAutonomousDatabasesPagedResponse>
        listAutonomousDatabasesSettings;
    private final UnaryCallSettings.Builder<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseSettings;
    private final UnaryCallSettings.Builder<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        createAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAutonomousDatabaseRequest, Operation>
        updateAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        updateAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
        deleteAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restoreAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletSettings;
    private final PagedCallSettings.Builder<
            ListAutonomousDbVersionsRequest,
            ListAutonomousDbVersionsResponse,
            ListAutonomousDbVersionsPagedResponse>
        listAutonomousDbVersionsSettings;
    private final PagedCallSettings.Builder<
            ListAutonomousDatabaseCharacterSetsRequest,
            ListAutonomousDatabaseCharacterSetsResponse,
            ListAutonomousDatabaseCharacterSetsPagedResponse>
        listAutonomousDatabaseCharacterSetsSettings;
    private final PagedCallSettings.Builder<
            ListAutonomousDatabaseBackupsRequest,
            ListAutonomousDatabaseBackupsResponse,
            ListAutonomousDatabaseBackupsPagedResponse>
        listAutonomousDatabaseBackupsSettings;
    private final UnaryCallSettings.Builder<StopAutonomousDatabaseRequest, Operation>
        stopAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        stopAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<StartAutonomousDatabaseRequest, Operation>
        startAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        startAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<RestartAutonomousDatabaseRequest, Operation>
        restartAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restartAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<SwitchoverAutonomousDatabaseRequest, Operation>
        switchoverAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        switchoverAutonomousDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<FailoverAutonomousDatabaseRequest, Operation>
        failoverAutonomousDatabaseSettings;
    private final OperationCallSettings.Builder<
            FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        failoverAutonomousDatabaseOperationSettings;
    private final PagedCallSettings.Builder<
            ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
        listOdbNetworksSettings;
    private final UnaryCallSettings.Builder<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings;
    private final UnaryCallSettings.Builder<CreateOdbNetworkRequest, Operation>
        createOdbNetworkSettings;
    private final OperationCallSettings.Builder<
            CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
        createOdbNetworkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOdbNetworkRequest, Operation>
        deleteOdbNetworkSettings;
    private final OperationCallSettings.Builder<DeleteOdbNetworkRequest, Empty, OperationMetadata>
        deleteOdbNetworkOperationSettings;
    private final PagedCallSettings.Builder<
            ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
        listOdbSubnetsSettings;
    private final UnaryCallSettings.Builder<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings;
    private final UnaryCallSettings.Builder<CreateOdbSubnetRequest, Operation>
        createOdbSubnetSettings;
    private final OperationCallSettings.Builder<
            CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
        createOdbSubnetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOdbSubnetRequest, Operation>
        deleteOdbSubnetSettings;
    private final OperationCallSettings.Builder<DeleteOdbSubnetRequest, Empty, OperationMetadata>
        deleteOdbSubnetOperationSettings;
    private final PagedCallSettings.Builder<
            ListExadbVmClustersRequest,
            ListExadbVmClustersResponse,
            ListExadbVmClustersPagedResponse>
        listExadbVmClustersSettings;
    private final UnaryCallSettings.Builder<GetExadbVmClusterRequest, ExadbVmCluster>
        getExadbVmClusterSettings;
    private final UnaryCallSettings.Builder<CreateExadbVmClusterRequest, Operation>
        createExadbVmClusterSettings;
    private final OperationCallSettings.Builder<
            CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        createExadbVmClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExadbVmClusterRequest, Operation>
        deleteExadbVmClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteExadbVmClusterRequest, Empty, OperationMetadata>
        deleteExadbVmClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateExadbVmClusterRequest, Operation>
        updateExadbVmClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        updateExadbVmClusterOperationSettings;
    private final UnaryCallSettings.Builder<RemoveVirtualMachineExadbVmClusterRequest, Operation>
        removeVirtualMachineExadbVmClusterSettings;
    private final OperationCallSettings.Builder<
            RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        removeVirtualMachineExadbVmClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListExascaleDbStorageVaultsRequest,
            ListExascaleDbStorageVaultsResponse,
            ListExascaleDbStorageVaultsPagedResponse>
        listExascaleDbStorageVaultsSettings;
    private final UnaryCallSettings.Builder<
            GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
        getExascaleDbStorageVaultSettings;
    private final UnaryCallSettings.Builder<CreateExascaleDbStorageVaultRequest, Operation>
        createExascaleDbStorageVaultSettings;
    private final OperationCallSettings.Builder<
            CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
        createExascaleDbStorageVaultOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExascaleDbStorageVaultRequest, Operation>
        deleteExascaleDbStorageVaultSettings;
    private final OperationCallSettings.Builder<
            DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
        deleteExascaleDbStorageVaultOperationSettings;
    private final PagedCallSettings.Builder<
            ListDbSystemInitialStorageSizesRequest,
            ListDbSystemInitialStorageSizesResponse,
            ListDbSystemInitialStorageSizesPagedResponse>
        listDbSystemInitialStorageSizesSettings;
    private final PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings;
    private final UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings;
    private final PagedCallSettings.Builder<
            ListPluggableDatabasesRequest,
            ListPluggableDatabasesResponse,
            ListPluggableDatabasesPagedResponse>
        listPluggableDatabasesSettings;
    private final UnaryCallSettings.Builder<GetPluggableDatabaseRequest, PluggableDatabase>
        getPluggableDatabaseSettings;
    private final PagedCallSettings.Builder<
            ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
        listDbSystemsSettings;
    private final UnaryCallSettings.Builder<GetDbSystemRequest, DbSystem> getDbSystemSettings;
    private final UnaryCallSettings.Builder<CreateDbSystemRequest, Operation>
        createDbSystemSettings;
    private final OperationCallSettings.Builder<CreateDbSystemRequest, DbSystem, OperationMetadata>
        createDbSystemOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDbSystemRequest, Operation>
        deleteDbSystemSettings;
    private final OperationCallSettings.Builder<DeleteDbSystemRequest, Empty, OperationMetadata>
        deleteDbSystemOperationSettings;
    private final PagedCallSettings.Builder<
            ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
        listDbVersionsSettings;
    private final PagedCallSettings.Builder<
            ListDatabaseCharacterSetsRequest,
            ListDatabaseCharacterSetsResponse,
            ListDatabaseCharacterSetsPagedResponse>
        listDatabaseCharacterSetsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listCloudExadataInfrastructuresSettings =
          PagedCallSettings.newBuilder(LIST_CLOUD_EXADATA_INFRASTRUCTURES_PAGE_STR_FACT);
      getCloudExadataInfrastructureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloudExadataInfrastructureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloudExadataInfrastructureOperationSettings = OperationCallSettings.newBuilder();
      deleteCloudExadataInfrastructureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCloudExadataInfrastructureOperationSettings = OperationCallSettings.newBuilder();
      listCloudVmClustersSettings =
          PagedCallSettings.newBuilder(LIST_CLOUD_VM_CLUSTERS_PAGE_STR_FACT);
      getCloudVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloudVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCloudVmClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteCloudVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCloudVmClusterOperationSettings = OperationCallSettings.newBuilder();
      listEntitlementsSettings = PagedCallSettings.newBuilder(LIST_ENTITLEMENTS_PAGE_STR_FACT);
      listDbServersSettings = PagedCallSettings.newBuilder(LIST_DB_SERVERS_PAGE_STR_FACT);
      listDbNodesSettings = PagedCallSettings.newBuilder(LIST_DB_NODES_PAGE_STR_FACT);
      listGiVersionsSettings = PagedCallSettings.newBuilder(LIST_GI_VERSIONS_PAGE_STR_FACT);
      listMinorVersionsSettings = PagedCallSettings.newBuilder(LIST_MINOR_VERSIONS_PAGE_STR_FACT);
      listDbSystemShapesSettings =
          PagedCallSettings.newBuilder(LIST_DB_SYSTEM_SHAPES_PAGE_STR_FACT);
      listAutonomousDatabasesSettings =
          PagedCallSettings.newBuilder(LIST_AUTONOMOUS_DATABASES_PAGE_STR_FACT);
      getAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      updateAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      deleteAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      restoreAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      generateAutonomousDatabaseWalletSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAutonomousDbVersionsSettings =
          PagedCallSettings.newBuilder(LIST_AUTONOMOUS_DB_VERSIONS_PAGE_STR_FACT);
      listAutonomousDatabaseCharacterSetsSettings =
          PagedCallSettings.newBuilder(LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS_PAGE_STR_FACT);
      listAutonomousDatabaseBackupsSettings =
          PagedCallSettings.newBuilder(LIST_AUTONOMOUS_DATABASE_BACKUPS_PAGE_STR_FACT);
      stopAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      startAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      restartAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      switchoverAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      switchoverAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      failoverAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      failoverAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
      listOdbNetworksSettings = PagedCallSettings.newBuilder(LIST_ODB_NETWORKS_PAGE_STR_FACT);
      getOdbNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOdbNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOdbNetworkOperationSettings = OperationCallSettings.newBuilder();
      deleteOdbNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOdbNetworkOperationSettings = OperationCallSettings.newBuilder();
      listOdbSubnetsSettings = PagedCallSettings.newBuilder(LIST_ODB_SUBNETS_PAGE_STR_FACT);
      getOdbSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOdbSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOdbSubnetOperationSettings = OperationCallSettings.newBuilder();
      deleteOdbSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOdbSubnetOperationSettings = OperationCallSettings.newBuilder();
      listExadbVmClustersSettings =
          PagedCallSettings.newBuilder(LIST_EXADB_VM_CLUSTERS_PAGE_STR_FACT);
      getExadbVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExadbVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExadbVmClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteExadbVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExadbVmClusterOperationSettings = OperationCallSettings.newBuilder();
      updateExadbVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExadbVmClusterOperationSettings = OperationCallSettings.newBuilder();
      removeVirtualMachineExadbVmClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeVirtualMachineExadbVmClusterOperationSettings = OperationCallSettings.newBuilder();
      listExascaleDbStorageVaultsSettings =
          PagedCallSettings.newBuilder(LIST_EXASCALE_DB_STORAGE_VAULTS_PAGE_STR_FACT);
      getExascaleDbStorageVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExascaleDbStorageVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExascaleDbStorageVaultOperationSettings = OperationCallSettings.newBuilder();
      deleteExascaleDbStorageVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExascaleDbStorageVaultOperationSettings = OperationCallSettings.newBuilder();
      listDbSystemInitialStorageSizesSettings =
          PagedCallSettings.newBuilder(LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES_PAGE_STR_FACT);
      listDatabasesSettings = PagedCallSettings.newBuilder(LIST_DATABASES_PAGE_STR_FACT);
      getDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPluggableDatabasesSettings =
          PagedCallSettings.newBuilder(LIST_PLUGGABLE_DATABASES_PAGE_STR_FACT);
      getPluggableDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDbSystemsSettings = PagedCallSettings.newBuilder(LIST_DB_SYSTEMS_PAGE_STR_FACT);
      getDbSystemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDbSystemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDbSystemOperationSettings = OperationCallSettings.newBuilder();
      deleteDbSystemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDbSystemOperationSettings = OperationCallSettings.newBuilder();
      listDbVersionsSettings = PagedCallSettings.newBuilder(LIST_DB_VERSIONS_PAGE_STR_FACT);
      listDatabaseCharacterSetsSettings =
          PagedCallSettings.newBuilder(LIST_DATABASE_CHARACTER_SETS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCloudExadataInfrastructuresSettings,
              getCloudExadataInfrastructureSettings,
              createCloudExadataInfrastructureSettings,
              deleteCloudExadataInfrastructureSettings,
              listCloudVmClustersSettings,
              getCloudVmClusterSettings,
              createCloudVmClusterSettings,
              deleteCloudVmClusterSettings,
              listEntitlementsSettings,
              listDbServersSettings,
              listDbNodesSettings,
              listGiVersionsSettings,
              listMinorVersionsSettings,
              listDbSystemShapesSettings,
              listAutonomousDatabasesSettings,
              getAutonomousDatabaseSettings,
              createAutonomousDatabaseSettings,
              updateAutonomousDatabaseSettings,
              deleteAutonomousDatabaseSettings,
              restoreAutonomousDatabaseSettings,
              generateAutonomousDatabaseWalletSettings,
              listAutonomousDbVersionsSettings,
              listAutonomousDatabaseCharacterSetsSettings,
              listAutonomousDatabaseBackupsSettings,
              stopAutonomousDatabaseSettings,
              startAutonomousDatabaseSettings,
              restartAutonomousDatabaseSettings,
              switchoverAutonomousDatabaseSettings,
              failoverAutonomousDatabaseSettings,
              listOdbNetworksSettings,
              getOdbNetworkSettings,
              createOdbNetworkSettings,
              deleteOdbNetworkSettings,
              listOdbSubnetsSettings,
              getOdbSubnetSettings,
              createOdbSubnetSettings,
              deleteOdbSubnetSettings,
              listExadbVmClustersSettings,
              getExadbVmClusterSettings,
              createExadbVmClusterSettings,
              deleteExadbVmClusterSettings,
              updateExadbVmClusterSettings,
              removeVirtualMachineExadbVmClusterSettings,
              listExascaleDbStorageVaultsSettings,
              getExascaleDbStorageVaultSettings,
              createExascaleDbStorageVaultSettings,
              deleteExascaleDbStorageVaultSettings,
              listDbSystemInitialStorageSizesSettings,
              listDatabasesSettings,
              getDatabaseSettings,
              listPluggableDatabasesSettings,
              getPluggableDatabaseSettings,
              listDbSystemsSettings,
              getDbSystemSettings,
              createDbSystemSettings,
              deleteDbSystemSettings,
              listDbVersionsSettings,
              listDatabaseCharacterSetsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(OracleDatabaseStubSettings settings) {
      super(settings);

      listCloudExadataInfrastructuresSettings =
          settings.listCloudExadataInfrastructuresSettings.toBuilder();
      getCloudExadataInfrastructureSettings =
          settings.getCloudExadataInfrastructureSettings.toBuilder();
      createCloudExadataInfrastructureSettings =
          settings.createCloudExadataInfrastructureSettings.toBuilder();
      createCloudExadataInfrastructureOperationSettings =
          settings.createCloudExadataInfrastructureOperationSettings.toBuilder();
      deleteCloudExadataInfrastructureSettings =
          settings.deleteCloudExadataInfrastructureSettings.toBuilder();
      deleteCloudExadataInfrastructureOperationSettings =
          settings.deleteCloudExadataInfrastructureOperationSettings.toBuilder();
      listCloudVmClustersSettings = settings.listCloudVmClustersSettings.toBuilder();
      getCloudVmClusterSettings = settings.getCloudVmClusterSettings.toBuilder();
      createCloudVmClusterSettings = settings.createCloudVmClusterSettings.toBuilder();
      createCloudVmClusterOperationSettings =
          settings.createCloudVmClusterOperationSettings.toBuilder();
      deleteCloudVmClusterSettings = settings.deleteCloudVmClusterSettings.toBuilder();
      deleteCloudVmClusterOperationSettings =
          settings.deleteCloudVmClusterOperationSettings.toBuilder();
      listEntitlementsSettings = settings.listEntitlementsSettings.toBuilder();
      listDbServersSettings = settings.listDbServersSettings.toBuilder();
      listDbNodesSettings = settings.listDbNodesSettings.toBuilder();
      listGiVersionsSettings = settings.listGiVersionsSettings.toBuilder();
      listMinorVersionsSettings = settings.listMinorVersionsSettings.toBuilder();
      listDbSystemShapesSettings = settings.listDbSystemShapesSettings.toBuilder();
      listAutonomousDatabasesSettings = settings.listAutonomousDatabasesSettings.toBuilder();
      getAutonomousDatabaseSettings = settings.getAutonomousDatabaseSettings.toBuilder();
      createAutonomousDatabaseSettings = settings.createAutonomousDatabaseSettings.toBuilder();
      createAutonomousDatabaseOperationSettings =
          settings.createAutonomousDatabaseOperationSettings.toBuilder();
      updateAutonomousDatabaseSettings = settings.updateAutonomousDatabaseSettings.toBuilder();
      updateAutonomousDatabaseOperationSettings =
          settings.updateAutonomousDatabaseOperationSettings.toBuilder();
      deleteAutonomousDatabaseSettings = settings.deleteAutonomousDatabaseSettings.toBuilder();
      deleteAutonomousDatabaseOperationSettings =
          settings.deleteAutonomousDatabaseOperationSettings.toBuilder();
      restoreAutonomousDatabaseSettings = settings.restoreAutonomousDatabaseSettings.toBuilder();
      restoreAutonomousDatabaseOperationSettings =
          settings.restoreAutonomousDatabaseOperationSettings.toBuilder();
      generateAutonomousDatabaseWalletSettings =
          settings.generateAutonomousDatabaseWalletSettings.toBuilder();
      listAutonomousDbVersionsSettings = settings.listAutonomousDbVersionsSettings.toBuilder();
      listAutonomousDatabaseCharacterSetsSettings =
          settings.listAutonomousDatabaseCharacterSetsSettings.toBuilder();
      listAutonomousDatabaseBackupsSettings =
          settings.listAutonomousDatabaseBackupsSettings.toBuilder();
      stopAutonomousDatabaseSettings = settings.stopAutonomousDatabaseSettings.toBuilder();
      stopAutonomousDatabaseOperationSettings =
          settings.stopAutonomousDatabaseOperationSettings.toBuilder();
      startAutonomousDatabaseSettings = settings.startAutonomousDatabaseSettings.toBuilder();
      startAutonomousDatabaseOperationSettings =
          settings.startAutonomousDatabaseOperationSettings.toBuilder();
      restartAutonomousDatabaseSettings = settings.restartAutonomousDatabaseSettings.toBuilder();
      restartAutonomousDatabaseOperationSettings =
          settings.restartAutonomousDatabaseOperationSettings.toBuilder();
      switchoverAutonomousDatabaseSettings =
          settings.switchoverAutonomousDatabaseSettings.toBuilder();
      switchoverAutonomousDatabaseOperationSettings =
          settings.switchoverAutonomousDatabaseOperationSettings.toBuilder();
      failoverAutonomousDatabaseSettings = settings.failoverAutonomousDatabaseSettings.toBuilder();
      failoverAutonomousDatabaseOperationSettings =
          settings.failoverAutonomousDatabaseOperationSettings.toBuilder();
      listOdbNetworksSettings = settings.listOdbNetworksSettings.toBuilder();
      getOdbNetworkSettings = settings.getOdbNetworkSettings.toBuilder();
      createOdbNetworkSettings = settings.createOdbNetworkSettings.toBuilder();
      createOdbNetworkOperationSettings = settings.createOdbNetworkOperationSettings.toBuilder();
      deleteOdbNetworkSettings = settings.deleteOdbNetworkSettings.toBuilder();
      deleteOdbNetworkOperationSettings = settings.deleteOdbNetworkOperationSettings.toBuilder();
      listOdbSubnetsSettings = settings.listOdbSubnetsSettings.toBuilder();
      getOdbSubnetSettings = settings.getOdbSubnetSettings.toBuilder();
      createOdbSubnetSettings = settings.createOdbSubnetSettings.toBuilder();
      createOdbSubnetOperationSettings = settings.createOdbSubnetOperationSettings.toBuilder();
      deleteOdbSubnetSettings = settings.deleteOdbSubnetSettings.toBuilder();
      deleteOdbSubnetOperationSettings = settings.deleteOdbSubnetOperationSettings.toBuilder();
      listExadbVmClustersSettings = settings.listExadbVmClustersSettings.toBuilder();
      getExadbVmClusterSettings = settings.getExadbVmClusterSettings.toBuilder();
      createExadbVmClusterSettings = settings.createExadbVmClusterSettings.toBuilder();
      createExadbVmClusterOperationSettings =
          settings.createExadbVmClusterOperationSettings.toBuilder();
      deleteExadbVmClusterSettings = settings.deleteExadbVmClusterSettings.toBuilder();
      deleteExadbVmClusterOperationSettings =
          settings.deleteExadbVmClusterOperationSettings.toBuilder();
      updateExadbVmClusterSettings = settings.updateExadbVmClusterSettings.toBuilder();
      updateExadbVmClusterOperationSettings =
          settings.updateExadbVmClusterOperationSettings.toBuilder();
      removeVirtualMachineExadbVmClusterSettings =
          settings.removeVirtualMachineExadbVmClusterSettings.toBuilder();
      removeVirtualMachineExadbVmClusterOperationSettings =
          settings.removeVirtualMachineExadbVmClusterOperationSettings.toBuilder();
      listExascaleDbStorageVaultsSettings =
          settings.listExascaleDbStorageVaultsSettings.toBuilder();
      getExascaleDbStorageVaultSettings = settings.getExascaleDbStorageVaultSettings.toBuilder();
      createExascaleDbStorageVaultSettings =
          settings.createExascaleDbStorageVaultSettings.toBuilder();
      createExascaleDbStorageVaultOperationSettings =
          settings.createExascaleDbStorageVaultOperationSettings.toBuilder();
      deleteExascaleDbStorageVaultSettings =
          settings.deleteExascaleDbStorageVaultSettings.toBuilder();
      deleteExascaleDbStorageVaultOperationSettings =
          settings.deleteExascaleDbStorageVaultOperationSettings.toBuilder();
      listDbSystemInitialStorageSizesSettings =
          settings.listDbSystemInitialStorageSizesSettings.toBuilder();
      listDatabasesSettings = settings.listDatabasesSettings.toBuilder();
      getDatabaseSettings = settings.getDatabaseSettings.toBuilder();
      listPluggableDatabasesSettings = settings.listPluggableDatabasesSettings.toBuilder();
      getPluggableDatabaseSettings = settings.getPluggableDatabaseSettings.toBuilder();
      listDbSystemsSettings = settings.listDbSystemsSettings.toBuilder();
      getDbSystemSettings = settings.getDbSystemSettings.toBuilder();
      createDbSystemSettings = settings.createDbSystemSettings.toBuilder();
      createDbSystemOperationSettings = settings.createDbSystemOperationSettings.toBuilder();
      deleteDbSystemSettings = settings.deleteDbSystemSettings.toBuilder();
      deleteDbSystemOperationSettings = settings.deleteDbSystemOperationSettings.toBuilder();
      listDbVersionsSettings = settings.listDbVersionsSettings.toBuilder();
      listDatabaseCharacterSetsSettings = settings.listDatabaseCharacterSetsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCloudExadataInfrastructuresSettings,
              getCloudExadataInfrastructureSettings,
              createCloudExadataInfrastructureSettings,
              deleteCloudExadataInfrastructureSettings,
              listCloudVmClustersSettings,
              getCloudVmClusterSettings,
              createCloudVmClusterSettings,
              deleteCloudVmClusterSettings,
              listEntitlementsSettings,
              listDbServersSettings,
              listDbNodesSettings,
              listGiVersionsSettings,
              listMinorVersionsSettings,
              listDbSystemShapesSettings,
              listAutonomousDatabasesSettings,
              getAutonomousDatabaseSettings,
              createAutonomousDatabaseSettings,
              updateAutonomousDatabaseSettings,
              deleteAutonomousDatabaseSettings,
              restoreAutonomousDatabaseSettings,
              generateAutonomousDatabaseWalletSettings,
              listAutonomousDbVersionsSettings,
              listAutonomousDatabaseCharacterSetsSettings,
              listAutonomousDatabaseBackupsSettings,
              stopAutonomousDatabaseSettings,
              startAutonomousDatabaseSettings,
              restartAutonomousDatabaseSettings,
              switchoverAutonomousDatabaseSettings,
              failoverAutonomousDatabaseSettings,
              listOdbNetworksSettings,
              getOdbNetworkSettings,
              createOdbNetworkSettings,
              deleteOdbNetworkSettings,
              listOdbSubnetsSettings,
              getOdbSubnetSettings,
              createOdbSubnetSettings,
              deleteOdbSubnetSettings,
              listExadbVmClustersSettings,
              getExadbVmClusterSettings,
              createExadbVmClusterSettings,
              deleteExadbVmClusterSettings,
              updateExadbVmClusterSettings,
              removeVirtualMachineExadbVmClusterSettings,
              listExascaleDbStorageVaultsSettings,
              getExascaleDbStorageVaultSettings,
              createExascaleDbStorageVaultSettings,
              deleteExascaleDbStorageVaultSettings,
              listDbSystemInitialStorageSizesSettings,
              listDatabasesSettings,
              getDatabaseSettings,
              listPluggableDatabasesSettings,
              getPluggableDatabaseSettings,
              listDbSystemsSettings,
              getDbSystemSettings,
              createDbSystemSettings,
              deleteDbSystemSettings,
              listDbVersionsSettings,
              listDatabaseCharacterSetsSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listCloudExadataInfrastructuresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCloudExadataInfrastructureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCloudExadataInfrastructureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCloudExadataInfrastructureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listCloudVmClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCloudVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCloudVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCloudVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listEntitlementsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDbServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDbNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGiVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMinorVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDbSystemShapesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAutonomousDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .restoreAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateAutonomousDatabaseWalletSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listAutonomousDbVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAutonomousDatabaseCharacterSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAutonomousDatabaseBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .stopAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .restartAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .switchoverAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .failoverAutonomousDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listOdbNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOdbNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOdbNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOdbNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listOdbSubnetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOdbSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOdbSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOdbSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExadbVmClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExadbVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExadbVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteExadbVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateExadbVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeVirtualMachineExadbVmClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExascaleDbStorageVaultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExascaleDbStorageVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExascaleDbStorageVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteExascaleDbStorageVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDbSystemInitialStorageSizesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPluggableDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPluggableDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDbSystemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDbSystemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDbSystemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteDbSystemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDbVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDatabaseCharacterSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createCloudExadataInfrastructureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCloudExadataInfrastructureRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CloudExadataInfrastructure.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .deleteCloudExadataInfrastructureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCloudExadataInfrastructureRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .createCloudVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCloudVmClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CloudVmCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .deleteCloudVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCloudVmClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .createAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAutonomousDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .updateAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAutonomousDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAutonomousDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .restoreAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreAutonomousDatabaseRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(432000000L))
                      .build()));

      builder
          .stopAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopAutonomousDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .startAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartAutonomousDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .restartAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestartAutonomousDatabaseRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .switchoverAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SwitchoverAutonomousDatabaseRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .failoverAutonomousDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<FailoverAutonomousDatabaseRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AutonomousDatabase.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createOdbNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOdbNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OdbNetwork.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteOdbNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteOdbNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createOdbSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOdbSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OdbSubnet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteOdbSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteOdbSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createExadbVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExadbVmClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExadbVmCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteExadbVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExadbVmClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateExadbVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateExadbVmClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExadbVmCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .removeVirtualMachineExadbVmClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveVirtualMachineExadbVmClusterRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExadbVmCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createExascaleDbStorageVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExascaleDbStorageVaultRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExascaleDbStorageVault.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteExascaleDbStorageVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExascaleDbStorageVaultRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDbSystemOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDbSystemRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DbSystem.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDbSystemOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDbSystemRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listCloudExadataInfrastructures. */
    public PagedCallSettings.Builder<
            ListCloudExadataInfrastructuresRequest,
            ListCloudExadataInfrastructuresResponse,
            ListCloudExadataInfrastructuresPagedResponse>
        listCloudExadataInfrastructuresSettings() {
      return listCloudExadataInfrastructuresSettings;
    }

    /** Returns the builder for the settings used for calls to getCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<
            GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureSettings() {
      return getCloudExadataInfrastructureSettings;
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureSettings() {
      return createCloudExadataInfrastructureSettings;
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
        createCloudExadataInfrastructureOperationSettings() {
      return createCloudExadataInfrastructureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureSettings() {
      return deleteCloudExadataInfrastructureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
        deleteCloudExadataInfrastructureOperationSettings() {
      return deleteCloudExadataInfrastructureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCloudVmClusters. */
    public PagedCallSettings.Builder<
            ListCloudVmClustersRequest,
            ListCloudVmClustersResponse,
            ListCloudVmClustersPagedResponse>
        listCloudVmClustersSettings() {
      return listCloudVmClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCloudVmCluster. */
    public UnaryCallSettings.Builder<GetCloudVmClusterRequest, CloudVmCluster>
        getCloudVmClusterSettings() {
      return getCloudVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public UnaryCallSettings.Builder<CreateCloudVmClusterRequest, Operation>
        createCloudVmClusterSettings() {
      return createCloudVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public OperationCallSettings.Builder<
            CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
        createCloudVmClusterOperationSettings() {
      return createCloudVmClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public UnaryCallSettings.Builder<DeleteCloudVmClusterRequest, Operation>
        deleteCloudVmClusterSettings() {
      return deleteCloudVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public OperationCallSettings.Builder<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
        deleteCloudVmClusterOperationSettings() {
      return deleteCloudVmClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return listEntitlementsSettings;
    }

    /** Returns the builder for the settings used for calls to listDbServers. */
    public PagedCallSettings.Builder<
            ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
        listDbServersSettings() {
      return listDbServersSettings;
    }

    /** Returns the builder for the settings used for calls to listDbNodes. */
    public PagedCallSettings.Builder<
            ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
        listDbNodesSettings() {
      return listDbNodesSettings;
    }

    /** Returns the builder for the settings used for calls to listGiVersions. */
    public PagedCallSettings.Builder<
            ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
        listGiVersionsSettings() {
      return listGiVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listMinorVersions. */
    public PagedCallSettings.Builder<
            ListMinorVersionsRequest, ListMinorVersionsResponse, ListMinorVersionsPagedResponse>
        listMinorVersionsSettings() {
      return listMinorVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listDbSystemShapes. */
    public PagedCallSettings.Builder<
            ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
        listDbSystemShapesSettings() {
      return listDbSystemShapesSettings;
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabases. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabasesRequest,
            ListAutonomousDatabasesResponse,
            ListAutonomousDatabasesPagedResponse>
        listAutonomousDatabasesSettings() {
      return listAutonomousDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to getAutonomousDatabase. */
    public UnaryCallSettings.Builder<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseSettings() {
      return getAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public UnaryCallSettings.Builder<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseSettings() {
      return createAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public OperationCallSettings.Builder<
            CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        createAutonomousDatabaseOperationSettings() {
      return createAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAutonomousDatabase. */
    public UnaryCallSettings.Builder<UpdateAutonomousDatabaseRequest, Operation>
        updateAutonomousDatabaseSettings() {
      return updateAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateAutonomousDatabase. */
    public OperationCallSettings.Builder<
            UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        updateAutonomousDatabaseOperationSettings() {
      return updateAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public UnaryCallSettings.Builder<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseSettings() {
      return deleteAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public OperationCallSettings.Builder<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
        deleteAutonomousDatabaseOperationSettings() {
      return deleteAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public UnaryCallSettings.Builder<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseSettings() {
      return restoreAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public OperationCallSettings.Builder<
            RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restoreAutonomousDatabaseOperationSettings() {
      return restoreAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateAutonomousDatabaseWallet. */
    public UnaryCallSettings.Builder<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletSettings() {
      return generateAutonomousDatabaseWalletSettings;
    }

    /** Returns the builder for the settings used for calls to listAutonomousDbVersions. */
    public PagedCallSettings.Builder<
            ListAutonomousDbVersionsRequest,
            ListAutonomousDbVersionsResponse,
            ListAutonomousDbVersionsPagedResponse>
        listAutonomousDbVersionsSettings() {
      return listAutonomousDbVersionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listAutonomousDatabaseCharacterSets.
     */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseCharacterSetsRequest,
            ListAutonomousDatabaseCharacterSetsResponse,
            ListAutonomousDatabaseCharacterSetsPagedResponse>
        listAutonomousDatabaseCharacterSetsSettings() {
      return listAutonomousDatabaseCharacterSetsSettings;
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabaseBackups. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseBackupsRequest,
            ListAutonomousDatabaseBackupsResponse,
            ListAutonomousDatabaseBackupsPagedResponse>
        listAutonomousDatabaseBackupsSettings() {
      return listAutonomousDatabaseBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to stopAutonomousDatabase. */
    public UnaryCallSettings.Builder<StopAutonomousDatabaseRequest, Operation>
        stopAutonomousDatabaseSettings() {
      return stopAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to stopAutonomousDatabase. */
    public OperationCallSettings.Builder<
            StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        stopAutonomousDatabaseOperationSettings() {
      return stopAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startAutonomousDatabase. */
    public UnaryCallSettings.Builder<StartAutonomousDatabaseRequest, Operation>
        startAutonomousDatabaseSettings() {
      return startAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to startAutonomousDatabase. */
    public OperationCallSettings.Builder<
            StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        startAutonomousDatabaseOperationSettings() {
      return startAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restartAutonomousDatabase. */
    public UnaryCallSettings.Builder<RestartAutonomousDatabaseRequest, Operation>
        restartAutonomousDatabaseSettings() {
      return restartAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to restartAutonomousDatabase. */
    public OperationCallSettings.Builder<
            RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restartAutonomousDatabaseOperationSettings() {
      return restartAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to switchoverAutonomousDatabase. */
    public UnaryCallSettings.Builder<SwitchoverAutonomousDatabaseRequest, Operation>
        switchoverAutonomousDatabaseSettings() {
      return switchoverAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to switchoverAutonomousDatabase. */
    public OperationCallSettings.Builder<
            SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        switchoverAutonomousDatabaseOperationSettings() {
      return switchoverAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to failoverAutonomousDatabase. */
    public UnaryCallSettings.Builder<FailoverAutonomousDatabaseRequest, Operation>
        failoverAutonomousDatabaseSettings() {
      return failoverAutonomousDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to failoverAutonomousDatabase. */
    public OperationCallSettings.Builder<
            FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        failoverAutonomousDatabaseOperationSettings() {
      return failoverAutonomousDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listOdbNetworks. */
    public PagedCallSettings.Builder<
            ListOdbNetworksRequest, ListOdbNetworksResponse, ListOdbNetworksPagedResponse>
        listOdbNetworksSettings() {
      return listOdbNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to getOdbNetwork. */
    public UnaryCallSettings.Builder<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkSettings() {
      return getOdbNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createOdbNetwork. */
    public UnaryCallSettings.Builder<CreateOdbNetworkRequest, Operation>
        createOdbNetworkSettings() {
      return createOdbNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createOdbNetwork. */
    public OperationCallSettings.Builder<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
        createOdbNetworkOperationSettings() {
      return createOdbNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOdbNetwork. */
    public UnaryCallSettings.Builder<DeleteOdbNetworkRequest, Operation>
        deleteOdbNetworkSettings() {
      return deleteOdbNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOdbNetwork. */
    public OperationCallSettings.Builder<DeleteOdbNetworkRequest, Empty, OperationMetadata>
        deleteOdbNetworkOperationSettings() {
      return deleteOdbNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listOdbSubnets. */
    public PagedCallSettings.Builder<
            ListOdbSubnetsRequest, ListOdbSubnetsResponse, ListOdbSubnetsPagedResponse>
        listOdbSubnetsSettings() {
      return listOdbSubnetsSettings;
    }

    /** Returns the builder for the settings used for calls to getOdbSubnet. */
    public UnaryCallSettings.Builder<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetSettings() {
      return getOdbSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to createOdbSubnet. */
    public UnaryCallSettings.Builder<CreateOdbSubnetRequest, Operation> createOdbSubnetSettings() {
      return createOdbSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to createOdbSubnet. */
    public OperationCallSettings.Builder<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
        createOdbSubnetOperationSettings() {
      return createOdbSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOdbSubnet. */
    public UnaryCallSettings.Builder<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetSettings() {
      return deleteOdbSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOdbSubnet. */
    public OperationCallSettings.Builder<DeleteOdbSubnetRequest, Empty, OperationMetadata>
        deleteOdbSubnetOperationSettings() {
      return deleteOdbSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExadbVmClusters. */
    public PagedCallSettings.Builder<
            ListExadbVmClustersRequest,
            ListExadbVmClustersResponse,
            ListExadbVmClustersPagedResponse>
        listExadbVmClustersSettings() {
      return listExadbVmClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getExadbVmCluster. */
    public UnaryCallSettings.Builder<GetExadbVmClusterRequest, ExadbVmCluster>
        getExadbVmClusterSettings() {
      return getExadbVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createExadbVmCluster. */
    public UnaryCallSettings.Builder<CreateExadbVmClusterRequest, Operation>
        createExadbVmClusterSettings() {
      return createExadbVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createExadbVmCluster. */
    public OperationCallSettings.Builder<
            CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        createExadbVmClusterOperationSettings() {
      return createExadbVmClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExadbVmCluster. */
    public UnaryCallSettings.Builder<DeleteExadbVmClusterRequest, Operation>
        deleteExadbVmClusterSettings() {
      return deleteExadbVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExadbVmCluster. */
    public OperationCallSettings.Builder<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
        deleteExadbVmClusterOperationSettings() {
      return deleteExadbVmClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateExadbVmCluster. */
    public UnaryCallSettings.Builder<UpdateExadbVmClusterRequest, Operation>
        updateExadbVmClusterSettings() {
      return updateExadbVmClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateExadbVmCluster. */
    public OperationCallSettings.Builder<
            UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        updateExadbVmClusterOperationSettings() {
      return updateExadbVmClusterOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to removeVirtualMachineExadbVmCluster.
     */
    public UnaryCallSettings.Builder<RemoveVirtualMachineExadbVmClusterRequest, Operation>
        removeVirtualMachineExadbVmClusterSettings() {
      return removeVirtualMachineExadbVmClusterSettings;
    }

    /**
     * Returns the builder for the settings used for calls to removeVirtualMachineExadbVmCluster.
     */
    public OperationCallSettings.Builder<
            RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
        removeVirtualMachineExadbVmClusterOperationSettings() {
      return removeVirtualMachineExadbVmClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExascaleDbStorageVaults. */
    public PagedCallSettings.Builder<
            ListExascaleDbStorageVaultsRequest,
            ListExascaleDbStorageVaultsResponse,
            ListExascaleDbStorageVaultsPagedResponse>
        listExascaleDbStorageVaultsSettings() {
      return listExascaleDbStorageVaultsSettings;
    }

    /** Returns the builder for the settings used for calls to getExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
        getExascaleDbStorageVaultSettings() {
      return getExascaleDbStorageVaultSettings;
    }

    /** Returns the builder for the settings used for calls to createExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<CreateExascaleDbStorageVaultRequest, Operation>
        createExascaleDbStorageVaultSettings() {
      return createExascaleDbStorageVaultSettings;
    }

    /** Returns the builder for the settings used for calls to createExascaleDbStorageVault. */
    public OperationCallSettings.Builder<
            CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
        createExascaleDbStorageVaultOperationSettings() {
      return createExascaleDbStorageVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExascaleDbStorageVault. */
    public UnaryCallSettings.Builder<DeleteExascaleDbStorageVaultRequest, Operation>
        deleteExascaleDbStorageVaultSettings() {
      return deleteExascaleDbStorageVaultSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExascaleDbStorageVault. */
    public OperationCallSettings.Builder<
            DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
        deleteExascaleDbStorageVaultOperationSettings() {
      return deleteExascaleDbStorageVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDbSystemInitialStorageSizes. */
    public PagedCallSettings.Builder<
            ListDbSystemInitialStorageSizesRequest,
            ListDbSystemInitialStorageSizesResponse,
            ListDbSystemInitialStorageSizesPagedResponse>
        listDbSystemInitialStorageSizesSettings() {
      return listDbSystemInitialStorageSizesSettings;
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return listDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to listPluggableDatabases. */
    public PagedCallSettings.Builder<
            ListPluggableDatabasesRequest,
            ListPluggableDatabasesResponse,
            ListPluggableDatabasesPagedResponse>
        listPluggableDatabasesSettings() {
      return listPluggableDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to getPluggableDatabase. */
    public UnaryCallSettings.Builder<GetPluggableDatabaseRequest, PluggableDatabase>
        getPluggableDatabaseSettings() {
      return getPluggableDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to listDbSystems. */
    public PagedCallSettings.Builder<
            ListDbSystemsRequest, ListDbSystemsResponse, ListDbSystemsPagedResponse>
        listDbSystemsSettings() {
      return listDbSystemsSettings;
    }

    /** Returns the builder for the settings used for calls to getDbSystem. */
    public UnaryCallSettings.Builder<GetDbSystemRequest, DbSystem> getDbSystemSettings() {
      return getDbSystemSettings;
    }

    /** Returns the builder for the settings used for calls to createDbSystem. */
    public UnaryCallSettings.Builder<CreateDbSystemRequest, Operation> createDbSystemSettings() {
      return createDbSystemSettings;
    }

    /** Returns the builder for the settings used for calls to createDbSystem. */
    public OperationCallSettings.Builder<CreateDbSystemRequest, DbSystem, OperationMetadata>
        createDbSystemOperationSettings() {
      return createDbSystemOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDbSystem. */
    public UnaryCallSettings.Builder<DeleteDbSystemRequest, Operation> deleteDbSystemSettings() {
      return deleteDbSystemSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDbSystem. */
    public OperationCallSettings.Builder<DeleteDbSystemRequest, Empty, OperationMetadata>
        deleteDbSystemOperationSettings() {
      return deleteDbSystemOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDbVersions. */
    public PagedCallSettings.Builder<
            ListDbVersionsRequest, ListDbVersionsResponse, ListDbVersionsPagedResponse>
        listDbVersionsSettings() {
      return listDbVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listDatabaseCharacterSets. */
    public PagedCallSettings.Builder<
            ListDatabaseCharacterSetsRequest,
            ListDatabaseCharacterSetsResponse,
            ListDatabaseCharacterSetsPagedResponse>
        listDatabaseCharacterSetsSettings() {
      return listDatabaseCharacterSetsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public OracleDatabaseStubSettings build() throws IOException {
      return new OracleDatabaseStubSettings(this);
    }
  }
}
