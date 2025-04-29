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

package com.google.cloud.gkebackup.v1.stub;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupChannelsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlanBindingsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListLocationsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoreChannelsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlanBindingsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

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
import com.google.cloud.gkebackup.v1.Backup;
import com.google.cloud.gkebackup.v1.BackupChannel;
import com.google.cloud.gkebackup.v1.BackupPlan;
import com.google.cloud.gkebackup.v1.BackupPlanBinding;
import com.google.cloud.gkebackup.v1.CreateBackupChannelRequest;
import com.google.cloud.gkebackup.v1.CreateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.CreateBackupRequest;
import com.google.cloud.gkebackup.v1.CreateRestoreChannelRequest;
import com.google.cloud.gkebackup.v1.CreateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.CreateRestoreRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupChannelRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupRequest;
import com.google.cloud.gkebackup.v1.DeleteRestoreChannelRequest;
import com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest;
import com.google.cloud.gkebackup.v1.DeleteRestoreRequest;
import com.google.cloud.gkebackup.v1.GetBackupChannelRequest;
import com.google.cloud.gkebackup.v1.GetBackupIndexDownloadUrlRequest;
import com.google.cloud.gkebackup.v1.GetBackupIndexDownloadUrlResponse;
import com.google.cloud.gkebackup.v1.GetBackupPlanBindingRequest;
import com.google.cloud.gkebackup.v1.GetBackupPlanRequest;
import com.google.cloud.gkebackup.v1.GetBackupRequest;
import com.google.cloud.gkebackup.v1.GetRestoreChannelRequest;
import com.google.cloud.gkebackup.v1.GetRestorePlanBindingRequest;
import com.google.cloud.gkebackup.v1.GetRestorePlanRequest;
import com.google.cloud.gkebackup.v1.GetRestoreRequest;
import com.google.cloud.gkebackup.v1.GetVolumeBackupRequest;
import com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest;
import com.google.cloud.gkebackup.v1.ListBackupChannelsRequest;
import com.google.cloud.gkebackup.v1.ListBackupChannelsResponse;
import com.google.cloud.gkebackup.v1.ListBackupPlanBindingsRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlanBindingsResponse;
import com.google.cloud.gkebackup.v1.ListBackupPlansRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansResponse;
import com.google.cloud.gkebackup.v1.ListBackupsRequest;
import com.google.cloud.gkebackup.v1.ListBackupsResponse;
import com.google.cloud.gkebackup.v1.ListRestoreChannelsRequest;
import com.google.cloud.gkebackup.v1.ListRestoreChannelsResponse;
import com.google.cloud.gkebackup.v1.ListRestorePlanBindingsRequest;
import com.google.cloud.gkebackup.v1.ListRestorePlanBindingsResponse;
import com.google.cloud.gkebackup.v1.ListRestorePlansRequest;
import com.google.cloud.gkebackup.v1.ListRestorePlansResponse;
import com.google.cloud.gkebackup.v1.ListRestoresRequest;
import com.google.cloud.gkebackup.v1.ListRestoresResponse;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse;
import com.google.cloud.gkebackup.v1.OperationMetadata;
import com.google.cloud.gkebackup.v1.Restore;
import com.google.cloud.gkebackup.v1.RestoreChannel;
import com.google.cloud.gkebackup.v1.RestorePlan;
import com.google.cloud.gkebackup.v1.RestorePlanBinding;
import com.google.cloud.gkebackup.v1.UpdateBackupChannelRequest;
import com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.UpdateBackupRequest;
import com.google.cloud.gkebackup.v1.UpdateRestoreChannelRequest;
import com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.UpdateRestoreRequest;
import com.google.cloud.gkebackup.v1.VolumeBackup;
import com.google.cloud.gkebackup.v1.VolumeRestore;
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
 * Settings class to configure an instance of {@link BackupForGKEStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkebackup.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getBackupPlan:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupForGKEStubSettings.Builder backupForGKESettingsBuilder =
 *     BackupForGKEStubSettings.newBuilder();
 * backupForGKESettingsBuilder
 *     .getBackupPlanSettings()
 *     .setRetrySettings(
 *         backupForGKESettingsBuilder
 *             .getBackupPlanSettings()
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
 * BackupForGKEStubSettings backupForGKESettings = backupForGKESettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createBackupPlan:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupForGKEStubSettings.Builder backupForGKESettingsBuilder =
 *     BackupForGKEStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * backupForGKESettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackupForGKEStubSettings extends StubSettings<BackupForGKEStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings;
  private final OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings;
  private final PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings;
  private final UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings;
  private final UnaryCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanSettings;
  private final OperationCallSettings<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationSettings;
  private final UnaryCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanSettings;
  private final OperationCallSettings<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationSettings;
  private final UnaryCallSettings<CreateBackupChannelRequest, Operation>
      createBackupChannelSettings;
  private final OperationCallSettings<CreateBackupChannelRequest, BackupChannel, OperationMetadata>
      createBackupChannelOperationSettings;
  private final PagedCallSettings<
          ListBackupChannelsRequest, ListBackupChannelsResponse, ListBackupChannelsPagedResponse>
      listBackupChannelsSettings;
  private final UnaryCallSettings<GetBackupChannelRequest, BackupChannel> getBackupChannelSettings;
  private final UnaryCallSettings<UpdateBackupChannelRequest, Operation>
      updateBackupChannelSettings;
  private final OperationCallSettings<UpdateBackupChannelRequest, BackupChannel, OperationMetadata>
      updateBackupChannelOperationSettings;
  private final UnaryCallSettings<DeleteBackupChannelRequest, Operation>
      deleteBackupChannelSettings;
  private final OperationCallSettings<DeleteBackupChannelRequest, Empty, OperationMetadata>
      deleteBackupChannelOperationSettings;
  private final PagedCallSettings<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          ListBackupPlanBindingsPagedResponse>
      listBackupPlanBindingsSettings;
  private final UnaryCallSettings<GetBackupPlanBindingRequest, BackupPlanBinding>
      getBackupPlanBindingSettings;
  private final UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings;
  private final OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings;
  private final OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings;
  private final OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings;
  private final PagedCallSettings<
          ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
      listVolumeBackupsSettings;
  private final UnaryCallSettings<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupSettings;
  private final UnaryCallSettings<CreateRestorePlanRequest, Operation> createRestorePlanSettings;
  private final OperationCallSettings<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationSettings;
  private final PagedCallSettings<
          ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
      listRestorePlansSettings;
  private final UnaryCallSettings<GetRestorePlanRequest, RestorePlan> getRestorePlanSettings;
  private final UnaryCallSettings<UpdateRestorePlanRequest, Operation> updateRestorePlanSettings;
  private final OperationCallSettings<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationSettings;
  private final UnaryCallSettings<DeleteRestorePlanRequest, Operation> deleteRestorePlanSettings;
  private final OperationCallSettings<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationSettings;
  private final UnaryCallSettings<CreateRestoreChannelRequest, Operation>
      createRestoreChannelSettings;
  private final OperationCallSettings<
          CreateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      createRestoreChannelOperationSettings;
  private final PagedCallSettings<
          ListRestoreChannelsRequest, ListRestoreChannelsResponse, ListRestoreChannelsPagedResponse>
      listRestoreChannelsSettings;
  private final UnaryCallSettings<GetRestoreChannelRequest, RestoreChannel>
      getRestoreChannelSettings;
  private final UnaryCallSettings<UpdateRestoreChannelRequest, Operation>
      updateRestoreChannelSettings;
  private final OperationCallSettings<
          UpdateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      updateRestoreChannelOperationSettings;
  private final UnaryCallSettings<DeleteRestoreChannelRequest, Operation>
      deleteRestoreChannelSettings;
  private final OperationCallSettings<DeleteRestoreChannelRequest, Empty, OperationMetadata>
      deleteRestoreChannelOperationSettings;
  private final PagedCallSettings<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          ListRestorePlanBindingsPagedResponse>
      listRestorePlanBindingsSettings;
  private final UnaryCallSettings<GetRestorePlanBindingRequest, RestorePlanBinding>
      getRestorePlanBindingSettings;
  private final UnaryCallSettings<CreateRestoreRequest, Operation> createRestoreSettings;
  private final OperationCallSettings<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationSettings;
  private final PagedCallSettings<
          ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
      listRestoresSettings;
  private final UnaryCallSettings<GetRestoreRequest, Restore> getRestoreSettings;
  private final UnaryCallSettings<UpdateRestoreRequest, Operation> updateRestoreSettings;
  private final OperationCallSettings<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationSettings;
  private final UnaryCallSettings<DeleteRestoreRequest, Operation> deleteRestoreSettings;
  private final OperationCallSettings<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationSettings;
  private final PagedCallSettings<
          ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
      listVolumeRestoresSettings;
  private final UnaryCallSettings<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreSettings;
  private final UnaryCallSettings<
          GetBackupIndexDownloadUrlRequest, GetBackupIndexDownloadUrlResponse>
      getBackupIndexDownloadUrlSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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
          ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel>
      LIST_BACKUP_CHANNELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupChannelsRequest injectToken(
                ListBackupChannelsRequest payload, String token) {
              return ListBackupChannelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupChannelsRequest injectPageSize(
                ListBackupChannelsRequest payload, int pageSize) {
              return ListBackupChannelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupChannelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupChannelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupChannel> extractResources(ListBackupChannelsResponse payload) {
              return payload.getBackupChannelsList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>
      LIST_BACKUP_PLAN_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupPlanBindingsRequest injectToken(
                ListBackupPlanBindingsRequest payload, String token) {
              return ListBackupPlanBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupPlanBindingsRequest injectPageSize(
                ListBackupPlanBindingsRequest payload, int pageSize) {
              return ListBackupPlanBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBackupPlanBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupPlanBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupPlanBinding> extractResources(
                ListBackupPlanBindingsResponse payload) {
              return payload.getBackupPlanBindingsList();
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
          ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup>
      LIST_VOLUME_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumeBackupsRequest injectToken(
                ListVolumeBackupsRequest payload, String token) {
              return ListVolumeBackupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumeBackupsRequest injectPageSize(
                ListVolumeBackupsRequest payload, int pageSize) {
              return ListVolumeBackupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumeBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumeBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VolumeBackup> extractResources(ListVolumeBackupsResponse payload) {
              return payload.getVolumeBackupsList();
            }
          };

  private static final PagedListDescriptor<
          ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan>
      LIST_RESTORE_PLANS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRestorePlansRequest injectToken(
                ListRestorePlansRequest payload, String token) {
              return ListRestorePlansRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRestorePlansRequest injectPageSize(
                ListRestorePlansRequest payload, int pageSize) {
              return ListRestorePlansRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRestorePlansRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRestorePlansResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RestorePlan> extractResources(ListRestorePlansResponse payload) {
              return payload.getRestorePlansList();
            }
          };

  private static final PagedListDescriptor<
          ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
      LIST_RESTORE_CHANNELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRestoreChannelsRequest injectToken(
                ListRestoreChannelsRequest payload, String token) {
              return ListRestoreChannelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRestoreChannelsRequest injectPageSize(
                ListRestoreChannelsRequest payload, int pageSize) {
              return ListRestoreChannelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRestoreChannelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRestoreChannelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RestoreChannel> extractResources(ListRestoreChannelsResponse payload) {
              return payload.getRestoreChannelsList();
            }
          };

  private static final PagedListDescriptor<
          ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse, RestorePlanBinding>
      LIST_RESTORE_PLAN_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRestorePlanBindingsRequest,
              ListRestorePlanBindingsResponse,
              RestorePlanBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRestorePlanBindingsRequest injectToken(
                ListRestorePlanBindingsRequest payload, String token) {
              return ListRestorePlanBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRestorePlanBindingsRequest injectPageSize(
                ListRestorePlanBindingsRequest payload, int pageSize) {
              return ListRestorePlanBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRestorePlanBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRestorePlanBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RestorePlanBinding> extractResources(
                ListRestorePlanBindingsResponse payload) {
              return payload.getRestorePlanBindingsList();
            }
          };

  private static final PagedListDescriptor<ListRestoresRequest, ListRestoresResponse, Restore>
      LIST_RESTORES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRestoresRequest, ListRestoresResponse, Restore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRestoresRequest injectToken(ListRestoresRequest payload, String token) {
              return ListRestoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRestoresRequest injectPageSize(ListRestoresRequest payload, int pageSize) {
              return ListRestoresRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRestoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRestoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Restore> extractResources(ListRestoresResponse payload) {
              return payload.getRestoresList();
            }
          };

  private static final PagedListDescriptor<
          ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore>
      LIST_VOLUME_RESTORES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumeRestoresRequest injectToken(
                ListVolumeRestoresRequest payload, String token) {
              return ListVolumeRestoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumeRestoresRequest injectPageSize(
                ListVolumeRestoresRequest payload, int pageSize) {
              return ListVolumeRestoresRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumeRestoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumeRestoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VolumeRestore> extractResources(ListVolumeRestoresResponse payload) {
              return payload.getVolumeRestoresList();
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
          ListBackupChannelsRequest, ListBackupChannelsResponse, ListBackupChannelsPagedResponse>
      LIST_BACKUP_CHANNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupChannelsRequest,
              ListBackupChannelsResponse,
              ListBackupChannelsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupChannelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupChannelsRequest, ListBackupChannelsResponse> callable,
                ListBackupChannelsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupChannelsResponse> futureResponse) {
              PageContext<ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_CHANNELS_PAGE_STR_DESC, request, context);
              return ListBackupChannelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          ListBackupPlanBindingsPagedResponse>
      LIST_BACKUP_PLAN_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupPlanBindingsRequest,
              ListBackupPlanBindingsResponse,
              ListBackupPlanBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupPlanBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse>
                    callable,
                ListBackupPlanBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupPlanBindingsResponse> futureResponse) {
              PageContext<
                      ListBackupPlanBindingsRequest,
                      ListBackupPlanBindingsResponse,
                      BackupPlanBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_PLAN_BINDINGS_PAGE_STR_DESC, request, context);
              return ListBackupPlanBindingsPagedResponse.createAsync(pageContext, futureResponse);
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
          ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
      LIST_VOLUME_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumeBackupsRequest,
              ListVolumeBackupsResponse,
              ListVolumeBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListVolumeBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse> callable,
                ListVolumeBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumeBackupsResponse> futureResponse) {
              PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOLUME_BACKUPS_PAGE_STR_DESC, request, context);
              return ListVolumeBackupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
      LIST_RESTORE_PLANS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>() {
            @Override
            public ApiFuture<ListRestorePlansPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse> callable,
                ListRestorePlansRequest request,
                ApiCallContext context,
                ApiFuture<ListRestorePlansResponse> futureResponse) {
              PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESTORE_PLANS_PAGE_STR_DESC, request, context);
              return ListRestorePlansPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRestoreChannelsRequest, ListRestoreChannelsResponse, ListRestoreChannelsPagedResponse>
      LIST_RESTORE_CHANNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRestoreChannelsRequest,
              ListRestoreChannelsResponse,
              ListRestoreChannelsPagedResponse>() {
            @Override
            public ApiFuture<ListRestoreChannelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRestoreChannelsRequest, ListRestoreChannelsResponse> callable,
                ListRestoreChannelsRequest request,
                ApiCallContext context,
                ApiFuture<ListRestoreChannelsResponse> futureResponse) {
              PageContext<ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESTORE_CHANNELS_PAGE_STR_DESC, request, context);
              return ListRestoreChannelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          ListRestorePlanBindingsPagedResponse>
      LIST_RESTORE_PLAN_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRestorePlanBindingsRequest,
              ListRestorePlanBindingsResponse,
              ListRestorePlanBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListRestorePlanBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse>
                    callable,
                ListRestorePlanBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListRestorePlanBindingsResponse> futureResponse) {
              PageContext<
                      ListRestorePlanBindingsRequest,
                      ListRestorePlanBindingsResponse,
                      RestorePlanBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESTORE_PLAN_BINDINGS_PAGE_STR_DESC, request, context);
              return ListRestorePlanBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
      LIST_RESTORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>() {
            @Override
            public ApiFuture<ListRestoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRestoresRequest, ListRestoresResponse> callable,
                ListRestoresRequest request,
                ApiCallContext context,
                ApiFuture<ListRestoresResponse> futureResponse) {
              PageContext<ListRestoresRequest, ListRestoresResponse, Restore> pageContext =
                  PageContext.create(callable, LIST_RESTORES_PAGE_STR_DESC, request, context);
              return ListRestoresPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
      LIST_VOLUME_RESTORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumeRestoresRequest,
              ListVolumeRestoresResponse,
              ListVolumeRestoresPagedResponse>() {
            @Override
            public ApiFuture<ListVolumeRestoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse> callable,
                ListVolumeRestoresRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumeRestoresResponse> futureResponse) {
              PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOLUME_RESTORES_PAGE_STR_DESC, request, context);
              return ListVolumeRestoresPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public UnaryCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanSettings() {
    return createBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPlan. */
  public OperationCallSettings<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationSettings() {
    return createBackupPlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackupPlans. */
  public PagedCallSettings<
          ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
      listBackupPlansSettings() {
    return listBackupPlansSettings;
  }

  /** Returns the object with the settings used for calls to getBackupPlan. */
  public UnaryCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
    return getBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupPlan. */
  public UnaryCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanSettings() {
    return updateBackupPlanSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupPlan. */
  public OperationCallSettings<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationSettings() {
    return updateBackupPlanOperationSettings;
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

  /** Returns the object with the settings used for calls to createBackupChannel. */
  public UnaryCallSettings<CreateBackupChannelRequest, Operation> createBackupChannelSettings() {
    return createBackupChannelSettings;
  }

  /** Returns the object with the settings used for calls to createBackupChannel. */
  public OperationCallSettings<CreateBackupChannelRequest, BackupChannel, OperationMetadata>
      createBackupChannelOperationSettings() {
    return createBackupChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackupChannels. */
  public PagedCallSettings<
          ListBackupChannelsRequest, ListBackupChannelsResponse, ListBackupChannelsPagedResponse>
      listBackupChannelsSettings() {
    return listBackupChannelsSettings;
  }

  /** Returns the object with the settings used for calls to getBackupChannel. */
  public UnaryCallSettings<GetBackupChannelRequest, BackupChannel> getBackupChannelSettings() {
    return getBackupChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupChannel. */
  public UnaryCallSettings<UpdateBackupChannelRequest, Operation> updateBackupChannelSettings() {
    return updateBackupChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupChannel. */
  public OperationCallSettings<UpdateBackupChannelRequest, BackupChannel, OperationMetadata>
      updateBackupChannelOperationSettings() {
    return updateBackupChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupChannel. */
  public UnaryCallSettings<DeleteBackupChannelRequest, Operation> deleteBackupChannelSettings() {
    return deleteBackupChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupChannel. */
  public OperationCallSettings<DeleteBackupChannelRequest, Empty, OperationMetadata>
      deleteBackupChannelOperationSettings() {
    return deleteBackupChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackupPlanBindings. */
  public PagedCallSettings<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          ListBackupPlanBindingsPagedResponse>
      listBackupPlanBindingsSettings() {
    return listBackupPlanBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getBackupPlanBinding. */
  public UnaryCallSettings<GetBackupPlanBindingRequest, BackupPlanBinding>
      getBackupPlanBindingSettings() {
    return getBackupPlanBindingSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return createBackupSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return createBackupOperationSettings;
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
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return deleteBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVolumeBackups. */
  public PagedCallSettings<
          ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
      listVolumeBackupsSettings() {
    return listVolumeBackupsSettings;
  }

  /** Returns the object with the settings used for calls to getVolumeBackup. */
  public UnaryCallSettings<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupSettings() {
    return getVolumeBackupSettings;
  }

  /** Returns the object with the settings used for calls to createRestorePlan. */
  public UnaryCallSettings<CreateRestorePlanRequest, Operation> createRestorePlanSettings() {
    return createRestorePlanSettings;
  }

  /** Returns the object with the settings used for calls to createRestorePlan. */
  public OperationCallSettings<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationSettings() {
    return createRestorePlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRestorePlans. */
  public PagedCallSettings<
          ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
      listRestorePlansSettings() {
    return listRestorePlansSettings;
  }

  /** Returns the object with the settings used for calls to getRestorePlan. */
  public UnaryCallSettings<GetRestorePlanRequest, RestorePlan> getRestorePlanSettings() {
    return getRestorePlanSettings;
  }

  /** Returns the object with the settings used for calls to updateRestorePlan. */
  public UnaryCallSettings<UpdateRestorePlanRequest, Operation> updateRestorePlanSettings() {
    return updateRestorePlanSettings;
  }

  /** Returns the object with the settings used for calls to updateRestorePlan. */
  public OperationCallSettings<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationSettings() {
    return updateRestorePlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestorePlan. */
  public UnaryCallSettings<DeleteRestorePlanRequest, Operation> deleteRestorePlanSettings() {
    return deleteRestorePlanSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestorePlan. */
  public OperationCallSettings<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationSettings() {
    return deleteRestorePlanOperationSettings;
  }

  /** Returns the object with the settings used for calls to createRestoreChannel. */
  public UnaryCallSettings<CreateRestoreChannelRequest, Operation> createRestoreChannelSettings() {
    return createRestoreChannelSettings;
  }

  /** Returns the object with the settings used for calls to createRestoreChannel. */
  public OperationCallSettings<CreateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      createRestoreChannelOperationSettings() {
    return createRestoreChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRestoreChannels. */
  public PagedCallSettings<
          ListRestoreChannelsRequest, ListRestoreChannelsResponse, ListRestoreChannelsPagedResponse>
      listRestoreChannelsSettings() {
    return listRestoreChannelsSettings;
  }

  /** Returns the object with the settings used for calls to getRestoreChannel. */
  public UnaryCallSettings<GetRestoreChannelRequest, RestoreChannel> getRestoreChannelSettings() {
    return getRestoreChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateRestoreChannel. */
  public UnaryCallSettings<UpdateRestoreChannelRequest, Operation> updateRestoreChannelSettings() {
    return updateRestoreChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateRestoreChannel. */
  public OperationCallSettings<UpdateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      updateRestoreChannelOperationSettings() {
    return updateRestoreChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestoreChannel. */
  public UnaryCallSettings<DeleteRestoreChannelRequest, Operation> deleteRestoreChannelSettings() {
    return deleteRestoreChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestoreChannel. */
  public OperationCallSettings<DeleteRestoreChannelRequest, Empty, OperationMetadata>
      deleteRestoreChannelOperationSettings() {
    return deleteRestoreChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRestorePlanBindings. */
  public PagedCallSettings<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          ListRestorePlanBindingsPagedResponse>
      listRestorePlanBindingsSettings() {
    return listRestorePlanBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getRestorePlanBinding. */
  public UnaryCallSettings<GetRestorePlanBindingRequest, RestorePlanBinding>
      getRestorePlanBindingSettings() {
    return getRestorePlanBindingSettings;
  }

  /** Returns the object with the settings used for calls to createRestore. */
  public UnaryCallSettings<CreateRestoreRequest, Operation> createRestoreSettings() {
    return createRestoreSettings;
  }

  /** Returns the object with the settings used for calls to createRestore. */
  public OperationCallSettings<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationSettings() {
    return createRestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRestores. */
  public PagedCallSettings<ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
      listRestoresSettings() {
    return listRestoresSettings;
  }

  /** Returns the object with the settings used for calls to getRestore. */
  public UnaryCallSettings<GetRestoreRequest, Restore> getRestoreSettings() {
    return getRestoreSettings;
  }

  /** Returns the object with the settings used for calls to updateRestore. */
  public UnaryCallSettings<UpdateRestoreRequest, Operation> updateRestoreSettings() {
    return updateRestoreSettings;
  }

  /** Returns the object with the settings used for calls to updateRestore. */
  public OperationCallSettings<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationSettings() {
    return updateRestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestore. */
  public UnaryCallSettings<DeleteRestoreRequest, Operation> deleteRestoreSettings() {
    return deleteRestoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteRestore. */
  public OperationCallSettings<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationSettings() {
    return deleteRestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVolumeRestores. */
  public PagedCallSettings<
          ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
      listVolumeRestoresSettings() {
    return listVolumeRestoresSettings;
  }

  /** Returns the object with the settings used for calls to getVolumeRestore. */
  public UnaryCallSettings<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreSettings() {
    return getVolumeRestoreSettings;
  }

  /** Returns the object with the settings used for calls to getBackupIndexDownloadUrl. */
  public UnaryCallSettings<GetBackupIndexDownloadUrlRequest, GetBackupIndexDownloadUrlResponse>
      getBackupIndexDownloadUrlSettings() {
    return getBackupIndexDownloadUrlSettings;
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

  public BackupForGKEStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBackupForGKEStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackupForGKEStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "gkebackup";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "gkebackup.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkebackup.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BackupForGKEStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BackupForGKEStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackupForGKEStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BackupForGKEStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createBackupPlanSettings = settingsBuilder.createBackupPlanSettings().build();
    createBackupPlanOperationSettings = settingsBuilder.createBackupPlanOperationSettings().build();
    listBackupPlansSettings = settingsBuilder.listBackupPlansSettings().build();
    getBackupPlanSettings = settingsBuilder.getBackupPlanSettings().build();
    updateBackupPlanSettings = settingsBuilder.updateBackupPlanSettings().build();
    updateBackupPlanOperationSettings = settingsBuilder.updateBackupPlanOperationSettings().build();
    deleteBackupPlanSettings = settingsBuilder.deleteBackupPlanSettings().build();
    deleteBackupPlanOperationSettings = settingsBuilder.deleteBackupPlanOperationSettings().build();
    createBackupChannelSettings = settingsBuilder.createBackupChannelSettings().build();
    createBackupChannelOperationSettings =
        settingsBuilder.createBackupChannelOperationSettings().build();
    listBackupChannelsSettings = settingsBuilder.listBackupChannelsSettings().build();
    getBackupChannelSettings = settingsBuilder.getBackupChannelSettings().build();
    updateBackupChannelSettings = settingsBuilder.updateBackupChannelSettings().build();
    updateBackupChannelOperationSettings =
        settingsBuilder.updateBackupChannelOperationSettings().build();
    deleteBackupChannelSettings = settingsBuilder.deleteBackupChannelSettings().build();
    deleteBackupChannelOperationSettings =
        settingsBuilder.deleteBackupChannelOperationSettings().build();
    listBackupPlanBindingsSettings = settingsBuilder.listBackupPlanBindingsSettings().build();
    getBackupPlanBindingSettings = settingsBuilder.getBackupPlanBindingSettings().build();
    createBackupSettings = settingsBuilder.createBackupSettings().build();
    createBackupOperationSettings = settingsBuilder.createBackupOperationSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    updateBackupSettings = settingsBuilder.updateBackupSettings().build();
    updateBackupOperationSettings = settingsBuilder.updateBackupOperationSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    deleteBackupOperationSettings = settingsBuilder.deleteBackupOperationSettings().build();
    listVolumeBackupsSettings = settingsBuilder.listVolumeBackupsSettings().build();
    getVolumeBackupSettings = settingsBuilder.getVolumeBackupSettings().build();
    createRestorePlanSettings = settingsBuilder.createRestorePlanSettings().build();
    createRestorePlanOperationSettings =
        settingsBuilder.createRestorePlanOperationSettings().build();
    listRestorePlansSettings = settingsBuilder.listRestorePlansSettings().build();
    getRestorePlanSettings = settingsBuilder.getRestorePlanSettings().build();
    updateRestorePlanSettings = settingsBuilder.updateRestorePlanSettings().build();
    updateRestorePlanOperationSettings =
        settingsBuilder.updateRestorePlanOperationSettings().build();
    deleteRestorePlanSettings = settingsBuilder.deleteRestorePlanSettings().build();
    deleteRestorePlanOperationSettings =
        settingsBuilder.deleteRestorePlanOperationSettings().build();
    createRestoreChannelSettings = settingsBuilder.createRestoreChannelSettings().build();
    createRestoreChannelOperationSettings =
        settingsBuilder.createRestoreChannelOperationSettings().build();
    listRestoreChannelsSettings = settingsBuilder.listRestoreChannelsSettings().build();
    getRestoreChannelSettings = settingsBuilder.getRestoreChannelSettings().build();
    updateRestoreChannelSettings = settingsBuilder.updateRestoreChannelSettings().build();
    updateRestoreChannelOperationSettings =
        settingsBuilder.updateRestoreChannelOperationSettings().build();
    deleteRestoreChannelSettings = settingsBuilder.deleteRestoreChannelSettings().build();
    deleteRestoreChannelOperationSettings =
        settingsBuilder.deleteRestoreChannelOperationSettings().build();
    listRestorePlanBindingsSettings = settingsBuilder.listRestorePlanBindingsSettings().build();
    getRestorePlanBindingSettings = settingsBuilder.getRestorePlanBindingSettings().build();
    createRestoreSettings = settingsBuilder.createRestoreSettings().build();
    createRestoreOperationSettings = settingsBuilder.createRestoreOperationSettings().build();
    listRestoresSettings = settingsBuilder.listRestoresSettings().build();
    getRestoreSettings = settingsBuilder.getRestoreSettings().build();
    updateRestoreSettings = settingsBuilder.updateRestoreSettings().build();
    updateRestoreOperationSettings = settingsBuilder.updateRestoreOperationSettings().build();
    deleteRestoreSettings = settingsBuilder.deleteRestoreSettings().build();
    deleteRestoreOperationSettings = settingsBuilder.deleteRestoreOperationSettings().build();
    listVolumeRestoresSettings = settingsBuilder.listVolumeRestoresSettings().build();
    getVolumeRestoreSettings = settingsBuilder.getVolumeRestoreSettings().build();
    getBackupIndexDownloadUrlSettings = settingsBuilder.getBackupIndexDownloadUrlSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for BackupForGKEStubSettings. */
  public static class Builder extends StubSettings.Builder<BackupForGKEStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateBackupPlanRequest, Operation>
        createBackupPlanSettings;
    private final OperationCallSettings.Builder<
            CreateBackupPlanRequest, BackupPlan, OperationMetadata>
        createBackupPlanOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings;
    private final UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings;
    private final UnaryCallSettings.Builder<UpdateBackupPlanRequest, Operation>
        updateBackupPlanSettings;
    private final OperationCallSettings.Builder<
            UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
        updateBackupPlanOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupPlanRequest, Operation>
        deleteBackupPlanSettings;
    private final OperationCallSettings.Builder<DeleteBackupPlanRequest, Empty, OperationMetadata>
        deleteBackupPlanOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupChannelRequest, Operation>
        createBackupChannelSettings;
    private final OperationCallSettings.Builder<
            CreateBackupChannelRequest, BackupChannel, OperationMetadata>
        createBackupChannelOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupChannelsRequest, ListBackupChannelsResponse, ListBackupChannelsPagedResponse>
        listBackupChannelsSettings;
    private final UnaryCallSettings.Builder<GetBackupChannelRequest, BackupChannel>
        getBackupChannelSettings;
    private final UnaryCallSettings.Builder<UpdateBackupChannelRequest, Operation>
        updateBackupChannelSettings;
    private final OperationCallSettings.Builder<
            UpdateBackupChannelRequest, BackupChannel, OperationMetadata>
        updateBackupChannelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupChannelRequest, Operation>
        deleteBackupChannelSettings;
    private final OperationCallSettings.Builder<
            DeleteBackupChannelRequest, Empty, OperationMetadata>
        deleteBackupChannelOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupPlanBindingsRequest,
            ListBackupPlanBindingsResponse,
            ListBackupPlanBindingsPagedResponse>
        listBackupPlanBindingsSettings;
    private final UnaryCallSettings.Builder<GetBackupPlanBindingRequest, BackupPlanBinding>
        getBackupPlanBindingSettings;
    private final UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings;
    private final OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings;
    private final OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings;
    private final OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings;
    private final PagedCallSettings.Builder<
            ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
        listVolumeBackupsSettings;
    private final UnaryCallSettings.Builder<GetVolumeBackupRequest, VolumeBackup>
        getVolumeBackupSettings;
    private final UnaryCallSettings.Builder<CreateRestorePlanRequest, Operation>
        createRestorePlanSettings;
    private final OperationCallSettings.Builder<
            CreateRestorePlanRequest, RestorePlan, OperationMetadata>
        createRestorePlanOperationSettings;
    private final PagedCallSettings.Builder<
            ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
        listRestorePlansSettings;
    private final UnaryCallSettings.Builder<GetRestorePlanRequest, RestorePlan>
        getRestorePlanSettings;
    private final UnaryCallSettings.Builder<UpdateRestorePlanRequest, Operation>
        updateRestorePlanSettings;
    private final OperationCallSettings.Builder<
            UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
        updateRestorePlanOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRestorePlanRequest, Operation>
        deleteRestorePlanSettings;
    private final OperationCallSettings.Builder<DeleteRestorePlanRequest, Empty, OperationMetadata>
        deleteRestorePlanOperationSettings;
    private final UnaryCallSettings.Builder<CreateRestoreChannelRequest, Operation>
        createRestoreChannelSettings;
    private final OperationCallSettings.Builder<
            CreateRestoreChannelRequest, RestoreChannel, OperationMetadata>
        createRestoreChannelOperationSettings;
    private final PagedCallSettings.Builder<
            ListRestoreChannelsRequest,
            ListRestoreChannelsResponse,
            ListRestoreChannelsPagedResponse>
        listRestoreChannelsSettings;
    private final UnaryCallSettings.Builder<GetRestoreChannelRequest, RestoreChannel>
        getRestoreChannelSettings;
    private final UnaryCallSettings.Builder<UpdateRestoreChannelRequest, Operation>
        updateRestoreChannelSettings;
    private final OperationCallSettings.Builder<
            UpdateRestoreChannelRequest, RestoreChannel, OperationMetadata>
        updateRestoreChannelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRestoreChannelRequest, Operation>
        deleteRestoreChannelSettings;
    private final OperationCallSettings.Builder<
            DeleteRestoreChannelRequest, Empty, OperationMetadata>
        deleteRestoreChannelOperationSettings;
    private final PagedCallSettings.Builder<
            ListRestorePlanBindingsRequest,
            ListRestorePlanBindingsResponse,
            ListRestorePlanBindingsPagedResponse>
        listRestorePlanBindingsSettings;
    private final UnaryCallSettings.Builder<GetRestorePlanBindingRequest, RestorePlanBinding>
        getRestorePlanBindingSettings;
    private final UnaryCallSettings.Builder<CreateRestoreRequest, Operation> createRestoreSettings;
    private final OperationCallSettings.Builder<CreateRestoreRequest, Restore, OperationMetadata>
        createRestoreOperationSettings;
    private final PagedCallSettings.Builder<
            ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
        listRestoresSettings;
    private final UnaryCallSettings.Builder<GetRestoreRequest, Restore> getRestoreSettings;
    private final UnaryCallSettings.Builder<UpdateRestoreRequest, Operation> updateRestoreSettings;
    private final OperationCallSettings.Builder<UpdateRestoreRequest, Restore, OperationMetadata>
        updateRestoreOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRestoreRequest, Operation> deleteRestoreSettings;
    private final OperationCallSettings.Builder<DeleteRestoreRequest, Empty, OperationMetadata>
        deleteRestoreOperationSettings;
    private final PagedCallSettings.Builder<
            ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
        listVolumeRestoresSettings;
    private final UnaryCallSettings.Builder<GetVolumeRestoreRequest, VolumeRestore>
        getVolumeRestoreSettings;
    private final UnaryCallSettings.Builder<
            GetBackupIndexDownloadUrlRequest, GetBackupIndexDownloadUrlResponse>
        getBackupIndexDownloadUrlSettings;
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
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupPlanOperationSettings = OperationCallSettings.newBuilder();
      listBackupPlansSettings = PagedCallSettings.newBuilder(LIST_BACKUP_PLANS_PAGE_STR_FACT);
      getBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupPlanOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupPlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupPlanOperationSettings = OperationCallSettings.newBuilder();
      createBackupChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupChannelOperationSettings = OperationCallSettings.newBuilder();
      listBackupChannelsSettings = PagedCallSettings.newBuilder(LIST_BACKUP_CHANNELS_PAGE_STR_FACT);
      getBackupChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupChannelOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupChannelOperationSettings = OperationCallSettings.newBuilder();
      listBackupPlanBindingsSettings =
          PagedCallSettings.newBuilder(LIST_BACKUP_PLAN_BINDINGS_PAGE_STR_FACT);
      getBackupPlanBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupOperationSettings = OperationCallSettings.newBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupOperationSettings = OperationCallSettings.newBuilder();
      listVolumeBackupsSettings = PagedCallSettings.newBuilder(LIST_VOLUME_BACKUPS_PAGE_STR_FACT);
      getVolumeBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRestorePlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRestorePlanOperationSettings = OperationCallSettings.newBuilder();
      listRestorePlansSettings = PagedCallSettings.newBuilder(LIST_RESTORE_PLANS_PAGE_STR_FACT);
      getRestorePlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestorePlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestorePlanOperationSettings = OperationCallSettings.newBuilder();
      deleteRestorePlanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRestorePlanOperationSettings = OperationCallSettings.newBuilder();
      createRestoreChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRestoreChannelOperationSettings = OperationCallSettings.newBuilder();
      listRestoreChannelsSettings =
          PagedCallSettings.newBuilder(LIST_RESTORE_CHANNELS_PAGE_STR_FACT);
      getRestoreChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestoreChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestoreChannelOperationSettings = OperationCallSettings.newBuilder();
      deleteRestoreChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRestoreChannelOperationSettings = OperationCallSettings.newBuilder();
      listRestorePlanBindingsSettings =
          PagedCallSettings.newBuilder(LIST_RESTORE_PLAN_BINDINGS_PAGE_STR_FACT);
      getRestorePlanBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRestoreOperationSettings = OperationCallSettings.newBuilder();
      listRestoresSettings = PagedCallSettings.newBuilder(LIST_RESTORES_PAGE_STR_FACT);
      getRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRestoreOperationSettings = OperationCallSettings.newBuilder();
      deleteRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRestoreOperationSettings = OperationCallSettings.newBuilder();
      listVolumeRestoresSettings = PagedCallSettings.newBuilder(LIST_VOLUME_RESTORES_PAGE_STR_FACT);
      getVolumeRestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBackupIndexDownloadUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBackupPlanSettings,
              listBackupPlansSettings,
              getBackupPlanSettings,
              updateBackupPlanSettings,
              deleteBackupPlanSettings,
              createBackupChannelSettings,
              listBackupChannelsSettings,
              getBackupChannelSettings,
              updateBackupChannelSettings,
              deleteBackupChannelSettings,
              listBackupPlanBindingsSettings,
              getBackupPlanBindingSettings,
              createBackupSettings,
              listBackupsSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listVolumeBackupsSettings,
              getVolumeBackupSettings,
              createRestorePlanSettings,
              listRestorePlansSettings,
              getRestorePlanSettings,
              updateRestorePlanSettings,
              deleteRestorePlanSettings,
              createRestoreChannelSettings,
              listRestoreChannelsSettings,
              getRestoreChannelSettings,
              updateRestoreChannelSettings,
              deleteRestoreChannelSettings,
              listRestorePlanBindingsSettings,
              getRestorePlanBindingSettings,
              createRestoreSettings,
              listRestoresSettings,
              getRestoreSettings,
              updateRestoreSettings,
              deleteRestoreSettings,
              listVolumeRestoresSettings,
              getVolumeRestoreSettings,
              getBackupIndexDownloadUrlSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(BackupForGKEStubSettings settings) {
      super(settings);

      createBackupPlanSettings = settings.createBackupPlanSettings.toBuilder();
      createBackupPlanOperationSettings = settings.createBackupPlanOperationSettings.toBuilder();
      listBackupPlansSettings = settings.listBackupPlansSettings.toBuilder();
      getBackupPlanSettings = settings.getBackupPlanSettings.toBuilder();
      updateBackupPlanSettings = settings.updateBackupPlanSettings.toBuilder();
      updateBackupPlanOperationSettings = settings.updateBackupPlanOperationSettings.toBuilder();
      deleteBackupPlanSettings = settings.deleteBackupPlanSettings.toBuilder();
      deleteBackupPlanOperationSettings = settings.deleteBackupPlanOperationSettings.toBuilder();
      createBackupChannelSettings = settings.createBackupChannelSettings.toBuilder();
      createBackupChannelOperationSettings =
          settings.createBackupChannelOperationSettings.toBuilder();
      listBackupChannelsSettings = settings.listBackupChannelsSettings.toBuilder();
      getBackupChannelSettings = settings.getBackupChannelSettings.toBuilder();
      updateBackupChannelSettings = settings.updateBackupChannelSettings.toBuilder();
      updateBackupChannelOperationSettings =
          settings.updateBackupChannelOperationSettings.toBuilder();
      deleteBackupChannelSettings = settings.deleteBackupChannelSettings.toBuilder();
      deleteBackupChannelOperationSettings =
          settings.deleteBackupChannelOperationSettings.toBuilder();
      listBackupPlanBindingsSettings = settings.listBackupPlanBindingsSettings.toBuilder();
      getBackupPlanBindingSettings = settings.getBackupPlanBindingSettings.toBuilder();
      createBackupSettings = settings.createBackupSettings.toBuilder();
      createBackupOperationSettings = settings.createBackupOperationSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      updateBackupSettings = settings.updateBackupSettings.toBuilder();
      updateBackupOperationSettings = settings.updateBackupOperationSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      deleteBackupOperationSettings = settings.deleteBackupOperationSettings.toBuilder();
      listVolumeBackupsSettings = settings.listVolumeBackupsSettings.toBuilder();
      getVolumeBackupSettings = settings.getVolumeBackupSettings.toBuilder();
      createRestorePlanSettings = settings.createRestorePlanSettings.toBuilder();
      createRestorePlanOperationSettings = settings.createRestorePlanOperationSettings.toBuilder();
      listRestorePlansSettings = settings.listRestorePlansSettings.toBuilder();
      getRestorePlanSettings = settings.getRestorePlanSettings.toBuilder();
      updateRestorePlanSettings = settings.updateRestorePlanSettings.toBuilder();
      updateRestorePlanOperationSettings = settings.updateRestorePlanOperationSettings.toBuilder();
      deleteRestorePlanSettings = settings.deleteRestorePlanSettings.toBuilder();
      deleteRestorePlanOperationSettings = settings.deleteRestorePlanOperationSettings.toBuilder();
      createRestoreChannelSettings = settings.createRestoreChannelSettings.toBuilder();
      createRestoreChannelOperationSettings =
          settings.createRestoreChannelOperationSettings.toBuilder();
      listRestoreChannelsSettings = settings.listRestoreChannelsSettings.toBuilder();
      getRestoreChannelSettings = settings.getRestoreChannelSettings.toBuilder();
      updateRestoreChannelSettings = settings.updateRestoreChannelSettings.toBuilder();
      updateRestoreChannelOperationSettings =
          settings.updateRestoreChannelOperationSettings.toBuilder();
      deleteRestoreChannelSettings = settings.deleteRestoreChannelSettings.toBuilder();
      deleteRestoreChannelOperationSettings =
          settings.deleteRestoreChannelOperationSettings.toBuilder();
      listRestorePlanBindingsSettings = settings.listRestorePlanBindingsSettings.toBuilder();
      getRestorePlanBindingSettings = settings.getRestorePlanBindingSettings.toBuilder();
      createRestoreSettings = settings.createRestoreSettings.toBuilder();
      createRestoreOperationSettings = settings.createRestoreOperationSettings.toBuilder();
      listRestoresSettings = settings.listRestoresSettings.toBuilder();
      getRestoreSettings = settings.getRestoreSettings.toBuilder();
      updateRestoreSettings = settings.updateRestoreSettings.toBuilder();
      updateRestoreOperationSettings = settings.updateRestoreOperationSettings.toBuilder();
      deleteRestoreSettings = settings.deleteRestoreSettings.toBuilder();
      deleteRestoreOperationSettings = settings.deleteRestoreOperationSettings.toBuilder();
      listVolumeRestoresSettings = settings.listVolumeRestoresSettings.toBuilder();
      getVolumeRestoreSettings = settings.getVolumeRestoreSettings.toBuilder();
      getBackupIndexDownloadUrlSettings = settings.getBackupIndexDownloadUrlSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBackupPlanSettings,
              listBackupPlansSettings,
              getBackupPlanSettings,
              updateBackupPlanSettings,
              deleteBackupPlanSettings,
              createBackupChannelSettings,
              listBackupChannelsSettings,
              getBackupChannelSettings,
              updateBackupChannelSettings,
              deleteBackupChannelSettings,
              listBackupPlanBindingsSettings,
              getBackupPlanBindingSettings,
              createBackupSettings,
              listBackupsSettings,
              getBackupSettings,
              updateBackupSettings,
              deleteBackupSettings,
              listVolumeBackupsSettings,
              getVolumeBackupSettings,
              createRestorePlanSettings,
              listRestorePlansSettings,
              getRestorePlanSettings,
              updateRestorePlanSettings,
              deleteRestorePlanSettings,
              createRestoreChannelSettings,
              listRestoreChannelsSettings,
              getRestoreChannelSettings,
              updateRestoreChannelSettings,
              deleteRestoreChannelSettings,
              listRestorePlanBindingsSettings,
              getRestorePlanBindingSettings,
              createRestoreSettings,
              listRestoresSettings,
              getRestoreSettings,
              updateRestoreSettings,
              deleteRestoreSettings,
              listVolumeRestoresSettings,
              getVolumeRestoreSettings,
              getBackupIndexDownloadUrlSettings,
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
          .createBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listBackupPlansSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupPlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBackupChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBackupPlanBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupPlanBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

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
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listVolumeBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVolumeBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRestorePlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listRestorePlansSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRestorePlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRestorePlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRestorePlanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createRestoreChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRestoreChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRestoreChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRestoreChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRestoreChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRestorePlanBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRestorePlanBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listRestoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listVolumeRestoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVolumeRestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupIndexDownloadUrlSettings()
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
          .createBackupPlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupPlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
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
          .updateBackupPlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupPlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createBackupChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupChannel.class))
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
          .updateBackupChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupChannel.class))
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
          .deleteBackupChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
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
          .createRestorePlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRestorePlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RestorePlan.class))
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
          .updateRestorePlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRestorePlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RestorePlan.class))
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
          .deleteRestorePlanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRestorePlanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createRestoreChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRestoreChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RestoreChannel.class))
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
          .updateRestoreChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRestoreChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RestoreChannel.class))
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
          .deleteRestoreChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRestoreChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createRestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Restore.class))
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
          .updateRestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Restore.class))
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
          .deleteRestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listBackupPlans. */
    public PagedCallSettings.Builder<
            ListBackupPlansRequest, ListBackupPlansResponse, ListBackupPlansPagedResponse>
        listBackupPlansSettings() {
      return listBackupPlansSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupPlan. */
    public UnaryCallSettings.Builder<GetBackupPlanRequest, BackupPlan> getBackupPlanSettings() {
      return getBackupPlanSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupPlan. */
    public UnaryCallSettings.Builder<UpdateBackupPlanRequest, Operation>
        updateBackupPlanSettings() {
      return updateBackupPlanSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupPlan. */
    public OperationCallSettings.Builder<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
        updateBackupPlanOperationSettings() {
      return updateBackupPlanOperationSettings;
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

    /** Returns the builder for the settings used for calls to createBackupChannel. */
    public UnaryCallSettings.Builder<CreateBackupChannelRequest, Operation>
        createBackupChannelSettings() {
      return createBackupChannelSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupChannel. */
    public OperationCallSettings.Builder<
            CreateBackupChannelRequest, BackupChannel, OperationMetadata>
        createBackupChannelOperationSettings() {
      return createBackupChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupChannels. */
    public PagedCallSettings.Builder<
            ListBackupChannelsRequest, ListBackupChannelsResponse, ListBackupChannelsPagedResponse>
        listBackupChannelsSettings() {
      return listBackupChannelsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupChannel. */
    public UnaryCallSettings.Builder<GetBackupChannelRequest, BackupChannel>
        getBackupChannelSettings() {
      return getBackupChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupChannel. */
    public UnaryCallSettings.Builder<UpdateBackupChannelRequest, Operation>
        updateBackupChannelSettings() {
      return updateBackupChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupChannel. */
    public OperationCallSettings.Builder<
            UpdateBackupChannelRequest, BackupChannel, OperationMetadata>
        updateBackupChannelOperationSettings() {
      return updateBackupChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupChannel. */
    public UnaryCallSettings.Builder<DeleteBackupChannelRequest, Operation>
        deleteBackupChannelSettings() {
      return deleteBackupChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupChannel. */
    public OperationCallSettings.Builder<DeleteBackupChannelRequest, Empty, OperationMetadata>
        deleteBackupChannelOperationSettings() {
      return deleteBackupChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupPlanBindings. */
    public PagedCallSettings.Builder<
            ListBackupPlanBindingsRequest,
            ListBackupPlanBindingsResponse,
            ListBackupPlanBindingsPagedResponse>
        listBackupPlanBindingsSettings() {
      return listBackupPlanBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupPlanBinding. */
    public UnaryCallSettings.Builder<GetBackupPlanBindingRequest, BackupPlanBinding>
        getBackupPlanBindingSettings() {
      return getBackupPlanBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return createBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return createBackupOperationSettings;
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
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return deleteBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumeBackups. */
    public PagedCallSettings.Builder<
            ListVolumeBackupsRequest, ListVolumeBackupsResponse, ListVolumeBackupsPagedResponse>
        listVolumeBackupsSettings() {
      return listVolumeBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to getVolumeBackup. */
    public UnaryCallSettings.Builder<GetVolumeBackupRequest, VolumeBackup>
        getVolumeBackupSettings() {
      return getVolumeBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createRestorePlan. */
    public UnaryCallSettings.Builder<CreateRestorePlanRequest, Operation>
        createRestorePlanSettings() {
      return createRestorePlanSettings;
    }

    /** Returns the builder for the settings used for calls to createRestorePlan. */
    public OperationCallSettings.Builder<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
        createRestorePlanOperationSettings() {
      return createRestorePlanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRestorePlans. */
    public PagedCallSettings.Builder<
            ListRestorePlansRequest, ListRestorePlansResponse, ListRestorePlansPagedResponse>
        listRestorePlansSettings() {
      return listRestorePlansSettings;
    }

    /** Returns the builder for the settings used for calls to getRestorePlan. */
    public UnaryCallSettings.Builder<GetRestorePlanRequest, RestorePlan> getRestorePlanSettings() {
      return getRestorePlanSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestorePlan. */
    public UnaryCallSettings.Builder<UpdateRestorePlanRequest, Operation>
        updateRestorePlanSettings() {
      return updateRestorePlanSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestorePlan. */
    public OperationCallSettings.Builder<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
        updateRestorePlanOperationSettings() {
      return updateRestorePlanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestorePlan. */
    public UnaryCallSettings.Builder<DeleteRestorePlanRequest, Operation>
        deleteRestorePlanSettings() {
      return deleteRestorePlanSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestorePlan. */
    public OperationCallSettings.Builder<DeleteRestorePlanRequest, Empty, OperationMetadata>
        deleteRestorePlanOperationSettings() {
      return deleteRestorePlanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createRestoreChannel. */
    public UnaryCallSettings.Builder<CreateRestoreChannelRequest, Operation>
        createRestoreChannelSettings() {
      return createRestoreChannelSettings;
    }

    /** Returns the builder for the settings used for calls to createRestoreChannel. */
    public OperationCallSettings.Builder<
            CreateRestoreChannelRequest, RestoreChannel, OperationMetadata>
        createRestoreChannelOperationSettings() {
      return createRestoreChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRestoreChannels. */
    public PagedCallSettings.Builder<
            ListRestoreChannelsRequest,
            ListRestoreChannelsResponse,
            ListRestoreChannelsPagedResponse>
        listRestoreChannelsSettings() {
      return listRestoreChannelsSettings;
    }

    /** Returns the builder for the settings used for calls to getRestoreChannel. */
    public UnaryCallSettings.Builder<GetRestoreChannelRequest, RestoreChannel>
        getRestoreChannelSettings() {
      return getRestoreChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestoreChannel. */
    public UnaryCallSettings.Builder<UpdateRestoreChannelRequest, Operation>
        updateRestoreChannelSettings() {
      return updateRestoreChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestoreChannel. */
    public OperationCallSettings.Builder<
            UpdateRestoreChannelRequest, RestoreChannel, OperationMetadata>
        updateRestoreChannelOperationSettings() {
      return updateRestoreChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestoreChannel. */
    public UnaryCallSettings.Builder<DeleteRestoreChannelRequest, Operation>
        deleteRestoreChannelSettings() {
      return deleteRestoreChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestoreChannel. */
    public OperationCallSettings.Builder<DeleteRestoreChannelRequest, Empty, OperationMetadata>
        deleteRestoreChannelOperationSettings() {
      return deleteRestoreChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRestorePlanBindings. */
    public PagedCallSettings.Builder<
            ListRestorePlanBindingsRequest,
            ListRestorePlanBindingsResponse,
            ListRestorePlanBindingsPagedResponse>
        listRestorePlanBindingsSettings() {
      return listRestorePlanBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getRestorePlanBinding. */
    public UnaryCallSettings.Builder<GetRestorePlanBindingRequest, RestorePlanBinding>
        getRestorePlanBindingSettings() {
      return getRestorePlanBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createRestore. */
    public UnaryCallSettings.Builder<CreateRestoreRequest, Operation> createRestoreSettings() {
      return createRestoreSettings;
    }

    /** Returns the builder for the settings used for calls to createRestore. */
    public OperationCallSettings.Builder<CreateRestoreRequest, Restore, OperationMetadata>
        createRestoreOperationSettings() {
      return createRestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRestores. */
    public PagedCallSettings.Builder<
            ListRestoresRequest, ListRestoresResponse, ListRestoresPagedResponse>
        listRestoresSettings() {
      return listRestoresSettings;
    }

    /** Returns the builder for the settings used for calls to getRestore. */
    public UnaryCallSettings.Builder<GetRestoreRequest, Restore> getRestoreSettings() {
      return getRestoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestore. */
    public UnaryCallSettings.Builder<UpdateRestoreRequest, Operation> updateRestoreSettings() {
      return updateRestoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateRestore. */
    public OperationCallSettings.Builder<UpdateRestoreRequest, Restore, OperationMetadata>
        updateRestoreOperationSettings() {
      return updateRestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestore. */
    public UnaryCallSettings.Builder<DeleteRestoreRequest, Operation> deleteRestoreSettings() {
      return deleteRestoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRestore. */
    public OperationCallSettings.Builder<DeleteRestoreRequest, Empty, OperationMetadata>
        deleteRestoreOperationSettings() {
      return deleteRestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumeRestores. */
    public PagedCallSettings.Builder<
            ListVolumeRestoresRequest, ListVolumeRestoresResponse, ListVolumeRestoresPagedResponse>
        listVolumeRestoresSettings() {
      return listVolumeRestoresSettings;
    }

    /** Returns the builder for the settings used for calls to getVolumeRestore. */
    public UnaryCallSettings.Builder<GetVolumeRestoreRequest, VolumeRestore>
        getVolumeRestoreSettings() {
      return getVolumeRestoreSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupIndexDownloadUrl. */
    public UnaryCallSettings.Builder<
            GetBackupIndexDownloadUrlRequest, GetBackupIndexDownloadUrlResponse>
        getBackupIndexDownloadUrlSettings() {
      return getBackupIndexDownloadUrlSettings;
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
    public BackupForGKEStubSettings build() throws IOException {
      return new BackupForGKEStubSettings(this);
    }
  }
}
