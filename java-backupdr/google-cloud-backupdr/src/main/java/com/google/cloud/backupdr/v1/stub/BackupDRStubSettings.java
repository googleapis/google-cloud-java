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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.FetchUsableBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlanAssociationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupPlansPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListBackupsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListDataSourcesPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

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
import com.google.cloud.backupdr.v1.Backup;
import com.google.cloud.backupdr.v1.BackupPlan;
import com.google.cloud.backupdr.v1.BackupPlanAssociation;
import com.google.cloud.backupdr.v1.BackupVault;
import com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.CreateBackupPlanRequest;
import com.google.cloud.backupdr.v1.CreateBackupVaultRequest;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DataSource;
import com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.DeleteBackupPlanRequest;
import com.google.cloud.backupdr.v1.DeleteBackupRequest;
import com.google.cloud.backupdr.v1.DeleteBackupVaultRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest;
import com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse;
import com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest;
import com.google.cloud.backupdr.v1.GetBackupPlanRequest;
import com.google.cloud.backupdr.v1.GetBackupRequest;
import com.google.cloud.backupdr.v1.GetBackupVaultRequest;
import com.google.cloud.backupdr.v1.GetDataSourceRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.InitializeServiceRequest;
import com.google.cloud.backupdr.v1.InitializeServiceResponse;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest;
import com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse;
import com.google.cloud.backupdr.v1.ListBackupPlansRequest;
import com.google.cloud.backupdr.v1.ListBackupPlansResponse;
import com.google.cloud.backupdr.v1.ListBackupVaultsRequest;
import com.google.cloud.backupdr.v1.ListBackupVaultsResponse;
import com.google.cloud.backupdr.v1.ListBackupsRequest;
import com.google.cloud.backupdr.v1.ListBackupsResponse;
import com.google.cloud.backupdr.v1.ListDataSourcesRequest;
import com.google.cloud.backupdr.v1.ListDataSourcesResponse;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.backupdr.v1.RestoreBackupRequest;
import com.google.cloud.backupdr.v1.RestoreBackupResponse;
import com.google.cloud.backupdr.v1.TriggerBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupRequest;
import com.google.cloud.backupdr.v1.UpdateBackupVaultRequest;
import com.google.cloud.backupdr.v1.UpdateDataSourceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackupDRStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (backupdr.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getManagementServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupDRStubSettings.Builder backupDRSettingsBuilder = BackupDRStubSettings.newBuilder();
 * backupDRSettingsBuilder
 *     .getManagementServerSettings()
 *     .setRetrySettings(
 *         backupDRSettingsBuilder
 *             .getManagementServerSettings()
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
 * BackupDRStubSettings backupDRSettings = backupDRSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createManagementServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupDRStubSettings.Builder backupDRSettingsBuilder = BackupDRStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * backupDRSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackupDRStubSettings extends StubSettings<BackupDRStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ListManagementServersPagedResponse>
      listManagementServersSettings;
  private final UnaryCallSettings<GetManagementServerRequest, ManagementServer>
      getManagementServerSettings;
  private final UnaryCallSettings<CreateManagementServerRequest, Operation>
      createManagementServerSettings;
  private final OperationCallSettings<
          CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationSettings;
  private final UnaryCallSettings<DeleteManagementServerRequest, Operation>
      deleteManagementServerSettings;
  private final OperationCallSettings<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationSettings;
  private final UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings;
  private final OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings;
  private final PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings;
  private final PagedCallSettings<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsSettings;
  private final UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings;
  private final UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings;
  private final OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings;
  private final UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings;
  private final OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings;
  private final PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings;
  private final UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings;
  private final UnaryCallSettings<UpdateDataSourceRequest, Operation> updateDataSourceSettings;
  private final OperationCallSettings<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings;
  private final OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings;
  private final OperationCallSettings<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationSettings;
  private final UnaryCallSettings<RestoreBackupRequest, Operation> restoreBackupSettings;
  private final OperationCallSettings<
          RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationSettings;
  private final UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings;
  private final OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings;
  private final UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings;
  private final PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings;
  private final UnaryCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanSettings;
  private final OperationCallSettings<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationSettings;
  private final UnaryCallSettings<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationSettings;
  private final OperationCallSettings<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationSettings;
  private final UnaryCallSettings<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationSettings;
  private final PagedCallSettings<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsSettings;
  private final UnaryCallSettings<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationSettings;
  private final OperationCallSettings<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationSettings;
  private final UnaryCallSettings<TriggerBackupRequest, Operation> triggerBackupSettings;
  private final OperationCallSettings<
          TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationSettings;
  private final UnaryCallSettings<InitializeServiceRequest, Operation> initializeServiceSettings;
  private final OperationCallSettings<
          InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
      LIST_MANAGEMENT_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListManagementServersRequest, ListManagementServersResponse, ManagementServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListManagementServersRequest injectToken(
                ListManagementServersRequest payload, String token) {
              return ListManagementServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListManagementServersRequest injectPageSize(
                ListManagementServersRequest payload, int pageSize) {
              return ListManagementServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListManagementServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListManagementServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ManagementServer> extractResources(
                ListManagementServersResponse payload) {
              return payload.getManagementServersList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>
      LIST_BACKUP_VAULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupVaultsRequest injectToken(
                ListBackupVaultsRequest payload, String token) {
              return ListBackupVaultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupVaultsRequest injectPageSize(
                ListBackupVaultsRequest payload, int pageSize) {
              return ListBackupVaultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupVaultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupVaultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupVault> extractResources(ListBackupVaultsResponse payload) {
              return payload.getBackupVaultsList();
            }
          };

  private static final PagedListDescriptor<
          FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
      FETCH_USABLE_BACKUP_VAULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchUsableBackupVaultsRequest injectToken(
                FetchUsableBackupVaultsRequest payload, String token) {
              return FetchUsableBackupVaultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchUsableBackupVaultsRequest injectPageSize(
                FetchUsableBackupVaultsRequest payload, int pageSize) {
              return FetchUsableBackupVaultsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchUsableBackupVaultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchUsableBackupVaultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupVault> extractResources(FetchUsableBackupVaultsResponse payload) {
              return payload.getBackupVaultsList();
            }
          };

  private static final PagedListDescriptor<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource>
      LIST_DATA_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataSourcesRequest, ListDataSourcesResponse, DataSource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataSourcesRequest injectToken(
                ListDataSourcesRequest payload, String token) {
              return ListDataSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataSourcesRequest injectPageSize(
                ListDataSourcesRequest payload, int pageSize) {
              return ListDataSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataSource> extractResources(ListDataSourcesResponse payload) {
              return payload.getDataSourcesList();
            }
          };

  private static final PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>
      LIST_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupsRequest injectToken(ListBackupsRequest payload, String token) {
              return ListBackupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupsRequest injectPageSize(ListBackupsRequest payload, int pageSize) {
              return ListBackupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Backup> extractResources(ListBackupsResponse payload) {
              return payload.getBackupsList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan>
      LIST_BACKUP_PLANS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupPlansRequest injectToken(
                ListBackupPlansRequest payload, String token) {
              return ListBackupPlansRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupPlansRequest injectPageSize(
                ListBackupPlansRequest payload, int pageSize) {
              return ListBackupPlansRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupPlansRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupPlansResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupPlan> extractResources(ListBackupPlansResponse payload) {
              return payload.getBackupPlansList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          BackupPlanAssociation>
      LIST_BACKUP_PLAN_ASSOCIATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupPlanAssociationsRequest,
              ListBackupPlanAssociationsResponse,
              BackupPlanAssociation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupPlanAssociationsRequest injectToken(
                ListBackupPlanAssociationsRequest payload, String token) {
              return ListBackupPlanAssociationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListBackupPlanAssociationsRequest injectPageSize(
                ListBackupPlanAssociationsRequest payload, int pageSize) {
              return ListBackupPlanAssociationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBackupPlanAssociationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupPlanAssociationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupPlanAssociation> extractResources(
                ListBackupPlanAssociationsResponse payload) {
              return payload.getBackupPlanAssociationsList();
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
          ListManagementServersRequest,
          ListManagementServersResponse,
          ListManagementServersPagedResponse>
      LIST_MANAGEMENT_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListManagementServersRequest,
              ListManagementServersResponse,
              ListManagementServersPagedResponse>() {
            @Override
            public ApiFuture<ListManagementServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListManagementServersRequest, ListManagementServersResponse> callable,
                ListManagementServersRequest request,
                ApiCallContext context,
                ApiFuture<ListManagementServersResponse> futureResponse) {
              PageContext<
                      ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MANAGEMENT_SERVERS_PAGE_STR_DESC, request, context);
              return ListManagementServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      LIST_BACKUP_VAULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupVaultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse> callable,
                ListBackupVaultsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupVaultsResponse> futureResponse) {
              PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_VAULTS_PAGE_STR_DESC, request, context);
              return ListBackupVaultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          FetchUsableBackupVaultsPagedResponse>
      FETCH_USABLE_BACKUP_VAULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchUsableBackupVaultsRequest,
              FetchUsableBackupVaultsResponse,
              FetchUsableBackupVaultsPagedResponse>() {
            @Override
            public ApiFuture<FetchUsableBackupVaultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
                    callable,
                FetchUsableBackupVaultsRequest request,
                ApiCallContext context,
                ApiFuture<FetchUsableBackupVaultsResponse> futureResponse) {
              PageContext<
                      FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_USABLE_BACKUP_VAULTS_PAGE_STR_DESC, request, context);
              return FetchUsableBackupVaultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      LIST_DATA_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListDataSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> callable,
                ListDataSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataSourcesResponse> futureResponse) {
              PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> pageContext =
                  PageContext.create(callable, LIST_DATA_SOURCES_PAGE_STR_DESC, request, context);
              return ListDataSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      LIST_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupsRequest, ListBackupsResponse> callable,
                ListBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupsResponse> futureResponse) {
              PageContext<ListBackupsRequest, ListBackupsResponse, Backup> pageContext =
                  PageContext.create(callable, LIST_BACKUPS_PAGE_STR_DESC, request, context);
              return ListBackupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      LIST_BACKUP_PLANS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>() {
            @Override
            public ApiFuture<ListBackupPlansPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> callable,
                ListBackupPlansRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupPlansResponse> futureResponse) {
              PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> pageContext =
                  PageContext.create(callable, LIST_BACKUP_PLANS_PAGE_STR_DESC, request, context);
              return ListBackupPlansPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          ListBackupPlanAssociationsPagedResponse>
      LIST_BACKUP_PLAN_ASSOCIATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupPlanAssociationsRequest,
              ListBackupPlanAssociationsResponse,
              ListBackupPlanAssociationsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupPlanAssociationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
                    callable,
                ListBackupPlanAssociationsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupPlanAssociationsResponse> futureResponse) {
              PageContext<
                      ListBackupPlanAssociationsRequest,
                      ListBackupPlanAssociationsResponse,
                      BackupPlanAssociation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_PLAN_ASSOCIATIONS_PAGE_STR_DESC, request, context);
              return ListBackupPlanAssociationsPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to listManagementServers. */
  public PagedCallSettings<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ListManagementServersPagedResponse>
      listManagementServersSettings() {
    return listManagementServersSettings;
  }

  /** Returns the object with the settings used for calls to getManagementServer. */
  public UnaryCallSettings<GetManagementServerRequest, ManagementServer>
      getManagementServerSettings() {
    return getManagementServerSettings;
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public UnaryCallSettings<CreateManagementServerRequest, Operation>
      createManagementServerSettings() {
    return createManagementServerSettings;
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public OperationCallSettings<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationSettings() {
    return createManagementServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public UnaryCallSettings<DeleteManagementServerRequest, Operation>
      deleteManagementServerSettings() {
    return deleteManagementServerSettings;
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public OperationCallSettings<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationSettings() {
    return deleteManagementServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings() {
    return createBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings() {
    return createBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackupVaults. */
  public PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings() {
    return listBackupVaultsSettings;
  }

  /** Returns the object with the settings used for calls to fetchUsableBackupVaults. */
  public PagedCallSettings<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsSettings() {
    return fetchUsableBackupVaultsSettings;
  }

  /** Returns the object with the settings used for calls to getBackupVault. */
  public UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
    return getBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings() {
    return updateBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings() {
    return updateBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings() {
    return deleteBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings() {
    return deleteBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDataSources. */
  public PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings() {
    return listDataSourcesSettings;
  }

  /** Returns the object with the settings used for calls to getDataSource. */
  public UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings() {
    return getDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public UnaryCallSettings<UpdateDataSourceRequest, Operation> updateDataSourceSettings() {
    return updateDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public OperationCallSettings<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationSettings() {
    return updateDataSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return listBackupsSettings;
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return getBackupSettings;
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return updateBackupSettings;
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return updateBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return deleteBackupSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationSettings() {
    return deleteBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public UnaryCallSettings<RestoreBackupRequest, Operation> restoreBackupSettings() {
    return restoreBackupSettings;
  }

  /** Returns the object with the settings used for calls to restoreBackup. */
  public OperationCallSettings<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationSettings() {
    return restoreBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings() {
    return createBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings() {
    return createBackupPlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackupPlan. */
  public UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
    return getBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to listBackupPlans. */
  public PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings() {
    return listBackupPlansSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public UnaryCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanSettings() {
    return deleteBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPlan. */
  public OperationCallSettings<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationSettings() {
    return deleteBackupPlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPlanAssociation. */
  public UnaryCallSettings<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationSettings() {
    return createBackupPlanAssociationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPlanAssociation. */
  public OperationCallSettings<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationSettings() {
    return createBackupPlanAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackupPlanAssociation. */
  public UnaryCallSettings<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationSettings() {
    return getBackupPlanAssociationSettings;
  }

  /** Returns the object with the settings used for calls to listBackupPlanAssociations. */
  public PagedCallSettings<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsSettings() {
    return listBackupPlanAssociationsSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPlanAssociation. */
  public UnaryCallSettings<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationSettings() {
    return deleteBackupPlanAssociationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPlanAssociation. */
  public OperationCallSettings<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationSettings() {
    return deleteBackupPlanAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to triggerBackup. */
  public UnaryCallSettings<TriggerBackupRequest, Operation> triggerBackupSettings() {
    return triggerBackupSettings;
  }

  /** Returns the object with the settings used for calls to triggerBackup. */
  public OperationCallSettings<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationSettings() {
    return triggerBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to initializeService. */
  public UnaryCallSettings<InitializeServiceRequest, Operation> initializeServiceSettings() {
    return initializeServiceSettings;
  }

  /** Returns the object with the settings used for calls to initializeService. */
  public OperationCallSettings<
          InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationSettings() {
    return initializeServiceOperationSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public BackupDRStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBackupDRStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackupDRStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "backupdr";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "backupdr.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "backupdr.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(BackupDRStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(BackupDRStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackupDRStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BackupDRStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listManagementServersSettings = settingsBuilder.listManagementServersSettings().build();
    getManagementServerSettings = settingsBuilder.getManagementServerSettings().build();
    createManagementServerSettings = settingsBuilder.createManagementServerSettings().build();
    createManagementServerOperationSettings =
        settingsBuilder.createManagementServerOperationSettings().build();
    deleteManagementServerSettings = settingsBuilder.deleteManagementServerSettings().build();
    deleteManagementServerOperationSettings =
        settingsBuilder.deleteManagementServerOperationSettings().build();
    createBackupVaultSettings = settingsBuilder.createBackupVaultSettings().build();
    createBackupVaultOperationSettings =
        settingsBuilder.createBackupVaultOperationSettings().build();
    listBackupVaultsSettings = settingsBuilder.listBackupVaultsSettings().build();
    fetchUsableBackupVaultsSettings = settingsBuilder.fetchUsableBackupVaultsSettings().build();
    getBackupVaultSettings = settingsBuilder.getBackupVaultSettings().build();
    updateBackupVaultSettings = settingsBuilder.updateBackupVaultSettings().build();
    updateBackupVaultOperationSettings =
        settingsBuilder.updateBackupVaultOperationSettings().build();
    deleteBackupVaultSettings = settingsBuilder.deleteBackupVaultSettings().build();
    deleteBackupVaultOperationSettings =
        settingsBuilder.deleteBackupVaultOperationSettings().build();
    listDataSourcesSettings = settingsBuilder.listDataSourcesSettings().build();
    getDataSourceSettings = settingsBuilder.getDataSourceSettings().build();
    updateDataSourceSettings = settingsBuilder.updateDataSourceSettings().build();
    updateDataSourceOperationSettings = settingsBuilder.updateDataSourceOperationSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    updateBackupSettings = settingsBuilder.updateBackupSettings().build();
    updateBackupOperationSettings = settingsBuilder.updateBackupOperationSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    deleteBackupOperationSettings = settingsBuilder.deleteBackupOperationSettings().build();
    restoreBackupSettings = settingsBuilder.restoreBackupSettings().build();
    restoreBackupOperationSettings = settingsBuilder.restoreBackupOperationSettings().build();
    createBackupPlanSettings = settingsBuilder.createBackupPlanSettings().build();
    createBackupPlanOperationSettings = settingsBuilder.createBackupPlanOperationSettings().build();
    getBackupPlanSettings = settingsBuilder.getBackupPlanSettings().build();
    listBackupPlansSettings = settingsBuilder.listBackupPlansSettings().build();
    deleteBackupPlanSettings = settingsBuilder.deleteBackupPlanSettings().build();
    deleteBackupPlanOperationSettings = settingsBuilder.deleteBackupPlanOperationSettings().build();
    createBackupPlanAssociationSettings =
        settingsBuilder.createBackupPlanAssociationSettings().build();
    createBackupPlanAssociationOperationSettings =
        settingsBuilder.createBackupPlanAssociationOperationSettings().build();
    getBackupPlanAssociationSettings = settingsBuilder.getBackupPlanAssociationSettings().build();
    listBackupPlanAssociationsSettings =
        settingsBuilder.listBackupPlanAssociationsSettings().build();
    deleteBackupPlanAssociationSettings =
        settingsBuilder.deleteBackupPlanAssociationSettings().build();
    deleteBackupPlanAssociationOperationSettings =
        settingsBuilder.deleteBackupPlanAssociationOperationSettings().build();
    triggerBackupSettings = settingsBuilder.triggerBackupSettings().build();
    triggerBackupOperationSettings = settingsBuilder.triggerBackupOperationSettings().build();
    initializeServiceSettings = settingsBuilder.initializeServiceSettings().build();
    initializeServiceOperationSettings =
        settingsBuilder.initializeServiceOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for BackupDRStubSettings. */
  public static class Builder extends StubSettings.Builder<BackupDRStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListManagementServersRequest,
            ListManagementServersResponse,
            ListManagementServersPagedResponse>
        listManagementServersSettings;
    private final UnaryCallSettings.Builder<GetManagementServerRequest, ManagementServer>
        getManagementServerSettings;
    private final UnaryCallSettings.Builder<CreateManagementServerRequest, Operation>
        createManagementServerSettings;
    private final OperationCallSettings.Builder<
            CreateManagementServerRequest, ManagementServer, OperationMetadata>
        createManagementServerOperationSettings;
    private final UnaryCallSettings.Builder<DeleteManagementServerRequest, Operation>
        deleteManagementServerSettings;
    private final OperationCallSettings.Builder<
            DeleteManagementServerRequest, Empty, OperationMetadata>
        deleteManagementServerOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings;
    private final OperationCallSettings.Builder<
            CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings;
    private final PagedCallSettings.Builder<
            FetchUsableBackupVaultsRequest,
            FetchUsableBackupVaultsResponse,
            FetchUsableBackupVaultsPagedResponse>
        fetchUsableBackupVaultsSettings;
    private final UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault>
        getBackupVaultSettings;
    private final UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings;
    private final OperationCallSettings.Builder<
            UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings;
    private final OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings;
    private final PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings;
    private final UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings;
    private final UnaryCallSettings.Builder<UpdateDataSourceRequest, Operation>
        updateDataSourceSettings;
    private final OperationCallSettings.Builder<
            UpdateDataSourceRequest, DataSource, OperationMetadata>
        updateDataSourceOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings;
    private final OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings;
    private final OperationCallSettings.Builder<DeleteBackupRequest, Backup, OperationMetadata>
        deleteBackupOperationSettings;
    private final UnaryCallSettings.Builder<RestoreBackupRequest, Operation> restoreBackupSettings;
    private final OperationCallSettings.Builder<
            RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
        restoreBackupOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupPlanRequest, Operation>
        createBackupPlanSettings;
    private final OperationCallSettings.Builder<
            CreateBackupPlanRequest, BackupPlan, OperationMetadata>
        createBackupPlanOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings;
    private final PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings;
    private final UnaryCallSettings.Builder<DeleteBackupPlanRequest, Operation>
        deleteBackupPlanSettings;
    private final OperationCallSettings.Builder<DeleteBackupPlanRequest, Empty, OperationMetadata>
        deleteBackupPlanOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupPlanAssociationRequest, Operation>
        createBackupPlanAssociationSettings;
    private final OperationCallSettings.Builder<
            CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
        createBackupPlanAssociationOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupPlanAssociationRequest, BackupPlanAssociation>
        getBackupPlanAssociationSettings;
    private final PagedCallSettings.Builder<
            ListBackupPlanAssociationsRequest,
            ListBackupPlanAssociationsResponse,
            ListBackupPlanAssociationsPagedResponse>
        listBackupPlanAssociationsSettings;
    private final UnaryCallSettings.Builder<DeleteBackupPlanAssociationRequest, Operation>
        deleteBackupPlanAssociationSettings;
    private final OperationCallSettings.Builder<
            DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
        deleteBackupPlanAssociationOperationSettings;
    private final UnaryCallSettings.Builder<TriggerBackupRequest, Operation> triggerBackupSettings;
    private final OperationCallSettings.Builder<
            TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
        triggerBackupOperationSettings;
    private final UnaryCallSettings.Builder<InitializeServiceRequest, Operation>
        initializeServiceSettings;
    private final OperationCallSettings.Builder<
            InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
        initializeServiceOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listManagementServersSettings =
          PagedCallSettings.newBuilder(LIST_MANAGEMENT_SERVERS_PAGE_STR_FACT);
      getManagementServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createManagementServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createManagementServerOperationSettings = OperationCallSettings.newBuilder();
      deleteManagementServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteManagementServerOperationSettings = OperationCallSettings.newBuilder();
      createBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      listBackupVaultsSettings = PagedCallSettings.newBuilder(LIST_BACKUP_VAULTS_PAGE_STR_FACT);
      fetchUsableBackupVaultsSettings =
          PagedCallSettings.newBuilder(FETCH_USABLE_BACKUP_VAULTS_PAGE_STR_FACT);
      getBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      listDataSourcesSettings = PagedCallSettings.newBuilder(LIST_DATA_SOURCES_PAGE_STR_FACT);
      getDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataSourceOperationSettings = OperationCallSettings.newBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupOperationSettings = OperationCallSettings.newBuilder();
      restoreBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreBackupOperationSettings = OperationCallSettings.newBuilder();
      createBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupPlanOperationSettings = OperationCallSettings.newBuilder();
      getBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupPlansSettings = PagedCallSettings.newBuilder(LIST_BACKUP_PLANS_PAGE_STR_FACT);
      deleteBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupPlanOperationSettings = OperationCallSettings.newBuilder();
      createBackupPlanAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupPlanAssociationOperationSettings = OperationCallSettings.newBuilder();
      getBackupPlanAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupPlanAssociationsSettings =
          PagedCallSettings.newBuilder(LIST_BACKUP_PLAN_ASSOCIATIONS_PAGE_STR_FACT);
      deleteBackupPlanAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupPlanAssociationOperationSettings = OperationCallSettings.newBuilder();
      triggerBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      triggerBackupOperationSettings = OperationCallSettings.newBuilder();
      initializeServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      initializeServiceOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listManagementServersSettings,
              getManagementServerSettings,
              createManagementServerSettings,
              deleteManagementServerSettings,
              createBackupVaultSettings,
              listBackupVaultsSettings,
              fetchUsableBackupVaultsSettings,
              getBackupVaultSettings,
              updateBackupVaultSettings,
              deleteBackupVaultSettings,
              listDataSourcesSettings,
              getDataSourceSettings,
              updateDataSourceSettings,
              listBackupsSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              restoreBackupSettings,
              createBackupPlanSettings,
              getBackupPlanSettings,
              listBackupPlansSettings,
              deleteBackupPlanSettings,
              createBackupPlanAssociationSettings,
              getBackupPlanAssociationSettings,
              listBackupPlanAssociationsSettings,
              deleteBackupPlanAssociationSettings,
              triggerBackupSettings,
              initializeServiceSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(BackupDRStubSettings settings) {
      super(settings);

      listManagementServersSettings = settings.listManagementServersSettings.toBuilder();
      getManagementServerSettings = settings.getManagementServerSettings.toBuilder();
      createManagementServerSettings = settings.createManagementServerSettings.toBuilder();
      createManagementServerOperationSettings =
          settings.createManagementServerOperationSettings.toBuilder();
      deleteManagementServerSettings = settings.deleteManagementServerSettings.toBuilder();
      deleteManagementServerOperationSettings =
          settings.deleteManagementServerOperationSettings.toBuilder();
      createBackupVaultSettings = settings.createBackupVaultSettings.toBuilder();
      createBackupVaultOperationSettings = settings.createBackupVaultOperationSettings.toBuilder();
      listBackupVaultsSettings = settings.listBackupVaultsSettings.toBuilder();
      fetchUsableBackupVaultsSettings = settings.fetchUsableBackupVaultsSettings.toBuilder();
      getBackupVaultSettings = settings.getBackupVaultSettings.toBuilder();
      updateBackupVaultSettings = settings.updateBackupVaultSettings.toBuilder();
      updateBackupVaultOperationSettings = settings.updateBackupVaultOperationSettings.toBuilder();
      deleteBackupVaultSettings = settings.deleteBackupVaultSettings.toBuilder();
      deleteBackupVaultOperationSettings = settings.deleteBackupVaultOperationSettings.toBuilder();
      listDataSourcesSettings = settings.listDataSourcesSettings.toBuilder();
      getDataSourceSettings = settings.getDataSourceSettings.toBuilder();
      updateDataSourceSettings = settings.updateDataSourceSettings.toBuilder();
      updateDataSourceOperationSettings = settings.updateDataSourceOperationSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      updateBackupSettings = settings.updateBackupSettings.toBuilder();
      updateBackupOperationSettings = settings.updateBackupOperationSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      deleteBackupOperationSettings = settings.deleteBackupOperationSettings.toBuilder();
      restoreBackupSettings = settings.restoreBackupSettings.toBuilder();
      restoreBackupOperationSettings = settings.restoreBackupOperationSettings.toBuilder();
      createBackupPlanSettings = settings.createBackupPlanSettings.toBuilder();
      createBackupPlanOperationSettings = settings.createBackupPlanOperationSettings.toBuilder();
      getBackupPlanSettings = settings.getBackupPlanSettings.toBuilder();
      listBackupPlansSettings = settings.listBackupPlansSettings.toBuilder();
      deleteBackupPlanSettings = settings.deleteBackupPlanSettings.toBuilder();
      deleteBackupPlanOperationSettings = settings.deleteBackupPlanOperationSettings.toBuilder();
      createBackupPlanAssociationSettings =
          settings.createBackupPlanAssociationSettings.toBuilder();
      createBackupPlanAssociationOperationSettings =
          settings.createBackupPlanAssociationOperationSettings.toBuilder();
      getBackupPlanAssociationSettings = settings.getBackupPlanAssociationSettings.toBuilder();
      listBackupPlanAssociationsSettings = settings.listBackupPlanAssociationsSettings.toBuilder();
      deleteBackupPlanAssociationSettings =
          settings.deleteBackupPlanAssociationSettings.toBuilder();
      deleteBackupPlanAssociationOperationSettings =
          settings.deleteBackupPlanAssociationOperationSettings.toBuilder();
      triggerBackupSettings = settings.triggerBackupSettings.toBuilder();
      triggerBackupOperationSettings = settings.triggerBackupOperationSettings.toBuilder();
      initializeServiceSettings = settings.initializeServiceSettings.toBuilder();
      initializeServiceOperationSettings = settings.initializeServiceOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listManagementServersSettings,
              getManagementServerSettings,
              createManagementServerSettings,
              deleteManagementServerSettings,
              createBackupVaultSettings,
              listBackupVaultsSettings,
              fetchUsableBackupVaultsSettings,
              getBackupVaultSettings,
              updateBackupVaultSettings,
              deleteBackupVaultSettings,
              listDataSourcesSettings,
              getDataSourceSettings,
              updateDataSourceSettings,
              listBackupsSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              restoreBackupSettings,
              createBackupPlanSettings,
              getBackupPlanSettings,
              listBackupPlansSettings,
              deleteBackupPlanSettings,
              createBackupPlanAssociationSettings,
              getBackupPlanAssociationSettings,
              listBackupPlanAssociationsSettings,
              deleteBackupPlanAssociationSettings,
              triggerBackupSettings,
              initializeServiceSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .listManagementServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getManagementServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createManagementServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteManagementServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupVaultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchUsableBackupVaultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .restoreBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBackupPlansSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBackupPlanAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBackupPlanAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBackupPlanAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBackupPlanAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .triggerBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .initializeServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createManagementServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateManagementServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ManagementServer.class))
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
          .deleteManagementServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteManagementServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupVault.class))
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
          .updateBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupVault.class))
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
          .deleteBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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
          .updateDataSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataSource.class))
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
          .updateBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
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
          .deleteBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
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
          .restoreBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RestoreBackupResponse.class))
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
          .createBackupPlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupPlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupPlan.class))
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
          .deleteBackupPlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupPlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .createBackupPlanAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupPlanAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupPlanAssociation.class))
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
          .deleteBackupPlanAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupPlanAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .triggerBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<TriggerBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupPlanAssociation.class))
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
          .initializeServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InitializeServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  InitializeServiceResponse.class))
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

    /** Returns the builder for the settings used for calls to listManagementServers. */
    public PagedCallSettings.Builder<
            ListManagementServersRequest,
            ListManagementServersResponse,
            ListManagementServersPagedResponse>
        listManagementServersSettings() {
      return listManagementServersSettings;
    }

    /** Returns the builder for the settings used for calls to getManagementServer. */
    public UnaryCallSettings.Builder<GetManagementServerRequest, ManagementServer>
        getManagementServerSettings() {
      return getManagementServerSettings;
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public UnaryCallSettings.Builder<CreateManagementServerRequest, Operation>
        createManagementServerSettings() {
      return createManagementServerSettings;
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public OperationCallSettings.Builder<
            CreateManagementServerRequest, ManagementServer, OperationMetadata>
        createManagementServerOperationSettings() {
      return createManagementServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public UnaryCallSettings.Builder<DeleteManagementServerRequest, Operation>
        deleteManagementServerSettings() {
      return deleteManagementServerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public OperationCallSettings.Builder<DeleteManagementServerRequest, Empty, OperationMetadata>
        deleteManagementServerOperationSettings() {
      return deleteManagementServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings() {
      return createBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public OperationCallSettings.Builder<CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings() {
      return createBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupVaults. */
    public PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings() {
      return listBackupVaultsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchUsableBackupVaults. */
    public PagedCallSettings.Builder<
            FetchUsableBackupVaultsRequest,
            FetchUsableBackupVaultsResponse,
            FetchUsableBackupVaultsPagedResponse>
        fetchUsableBackupVaultsSettings() {
      return fetchUsableBackupVaultsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupVault. */
    public UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
      return getBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings() {
      return updateBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public OperationCallSettings.Builder<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings() {
      return updateBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings() {
      return deleteBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings() {
      return deleteBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDataSources. */
    public PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings() {
      return listDataSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to getDataSource. */
    public UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings() {
      return getDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public UnaryCallSettings.Builder<UpdateDataSourceRequest, Operation>
        updateDataSourceSettings() {
      return updateDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public OperationCallSettings.Builder<UpdateDataSourceRequest, DataSource, OperationMetadata>
        updateDataSourceOperationSettings() {
      return updateDataSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return listBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getBackupSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings() {
      return updateBackupSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings() {
      return updateBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return deleteBackupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Backup, OperationMetadata>
        deleteBackupOperationSettings() {
      return deleteBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public UnaryCallSettings.Builder<RestoreBackupRequest, Operation> restoreBackupSettings() {
      return restoreBackupSettings;
    }

    /** Returns the builder for the settings used for calls to restoreBackup. */
    public OperationCallSettings.Builder<
            RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
        restoreBackupOperationSettings() {
      return restoreBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPlan. */
    public UnaryCallSettings.Builder<CreateBackupPlanRequest, Operation>
        createBackupPlanSettings() {
      return createBackupPlanSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPlan. */
    public OperationCallSettings.Builder<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
        createBackupPlanOperationSettings() {
      return createBackupPlanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupPlan. */
    public UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
      return getBackupPlanSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupPlans. */
    public PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings() {
      return listBackupPlansSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlan. */
    public UnaryCallSettings.Builder<DeleteBackupPlanRequest, Operation>
        deleteBackupPlanSettings() {
      return deleteBackupPlanSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlan. */
    public OperationCallSettings.Builder<DeleteBackupPlanRequest, Empty, OperationMetadata>
        deleteBackupPlanOperationSettings() {
      return deleteBackupPlanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPlanAssociation. */
    public UnaryCallSettings.Builder<CreateBackupPlanAssociationRequest, Operation>
        createBackupPlanAssociationSettings() {
      return createBackupPlanAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPlanAssociation. */
    public OperationCallSettings.Builder<
            CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
        createBackupPlanAssociationOperationSettings() {
      return createBackupPlanAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupPlanAssociation. */
    public UnaryCallSettings.Builder<GetBackupPlanAssociationRequest, BackupPlanAssociation>
        getBackupPlanAssociationSettings() {
      return getBackupPlanAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupPlanAssociations. */
    public PagedCallSettings.Builder<
            ListBackupPlanAssociationsRequest,
            ListBackupPlanAssociationsResponse,
            ListBackupPlanAssociationsPagedResponse>
        listBackupPlanAssociationsSettings() {
      return listBackupPlanAssociationsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlanAssociation. */
    public UnaryCallSettings.Builder<DeleteBackupPlanAssociationRequest, Operation>
        deleteBackupPlanAssociationSettings() {
      return deleteBackupPlanAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPlanAssociation. */
    public OperationCallSettings.Builder<
            DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
        deleteBackupPlanAssociationOperationSettings() {
      return deleteBackupPlanAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to triggerBackup. */
    public UnaryCallSettings.Builder<TriggerBackupRequest, Operation> triggerBackupSettings() {
      return triggerBackupSettings;
    }

    /** Returns the builder for the settings used for calls to triggerBackup. */
    public OperationCallSettings.Builder<
            TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
        triggerBackupOperationSettings() {
      return triggerBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to initializeService. */
    public UnaryCallSettings.Builder<InitializeServiceRequest, Operation>
        initializeServiceSettings() {
      return initializeServiceSettings;
    }

    /** Returns the builder for the settings used for calls to initializeService. */
    public OperationCallSettings.Builder<
            InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
        initializeServiceOperationSettings() {
      return initializeServiceOperationSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public BackupDRStubSettings build() throws IOException {
      return new BackupDRStubSettings(this);
    }
  }
}
