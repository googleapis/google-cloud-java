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
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.oracledatabase.v1.DbNode;
import com.google.cloud.oracledatabase.v1.DbServer;
import com.google.cloud.oracledatabase.v1.DbSystemShape;
import com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest;
import com.google.cloud.oracledatabase.v1.Entitlement;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest;
import com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse;
import com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest;
import com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest;
import com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest;
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
import com.google.cloud.oracledatabase.v1.ListDbNodesRequest;
import com.google.cloud.oracledatabase.v1.ListDbNodesResponse;
import com.google.cloud.oracledatabase.v1.ListDbServersRequest;
import com.google.cloud.oracledatabase.v1.ListDbServersResponse;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest;
import com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse;
import com.google.cloud.oracledatabase.v1.ListEntitlementsRequest;
import com.google.cloud.oracledatabase.v1.ListEntitlementsResponse;
import com.google.cloud.oracledatabase.v1.ListGiVersionsRequest;
import com.google.cloud.oracledatabase.v1.ListGiVersionsResponse;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest;
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OracleDatabaseStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
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
    listDbSystemShapesSettings = settingsBuilder.listDbSystemShapesSettings().build();
    listAutonomousDatabasesSettings = settingsBuilder.listAutonomousDatabasesSettings().build();
    getAutonomousDatabaseSettings = settingsBuilder.getAutonomousDatabaseSettings().build();
    createAutonomousDatabaseSettings = settingsBuilder.createAutonomousDatabaseSettings().build();
    createAutonomousDatabaseOperationSettings =
        settingsBuilder.createAutonomousDatabaseOperationSettings().build();
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
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
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
      listDbSystemShapesSettings =
          PagedCallSettings.newBuilder(LIST_DB_SYSTEM_SHAPES_PAGE_STR_FACT);
      listAutonomousDatabasesSettings =
          PagedCallSettings.newBuilder(LIST_AUTONOMOUS_DATABASES_PAGE_STR_FACT);
      getAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutonomousDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAutonomousDatabaseOperationSettings = OperationCallSettings.newBuilder();
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
              listDbSystemShapesSettings,
              listAutonomousDatabasesSettings,
              getAutonomousDatabaseSettings,
              createAutonomousDatabaseSettings,
              deleteAutonomousDatabaseSettings,
              restoreAutonomousDatabaseSettings,
              generateAutonomousDatabaseWalletSettings,
              listAutonomousDbVersionsSettings,
              listAutonomousDatabaseCharacterSetsSettings,
              listAutonomousDatabaseBackupsSettings,
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
      listDbSystemShapesSettings = settings.listDbSystemShapesSettings.toBuilder();
      listAutonomousDatabasesSettings = settings.listAutonomousDatabasesSettings.toBuilder();
      getAutonomousDatabaseSettings = settings.getAutonomousDatabaseSettings.toBuilder();
      createAutonomousDatabaseSettings = settings.createAutonomousDatabaseSettings.toBuilder();
      createAutonomousDatabaseOperationSettings =
          settings.createAutonomousDatabaseOperationSettings.toBuilder();
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
              listDbSystemShapesSettings,
              listAutonomousDatabasesSettings,
              getAutonomousDatabaseSettings,
              createAutonomousDatabaseSettings,
              deleteAutonomousDatabaseSettings,
              restoreAutonomousDatabaseSettings,
              generateAutonomousDatabaseWalletSettings,
              listAutonomousDbVersionsSettings,
              listAutonomousDatabaseCharacterSetsSettings,
              listAutonomousDatabaseBackupsSettings,
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
