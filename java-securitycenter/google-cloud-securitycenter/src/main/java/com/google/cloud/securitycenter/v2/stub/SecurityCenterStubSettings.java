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

package com.google.cloud.securitycenter.v2.stub;

import static com.google.cloud.securitycenter.v2.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListAttackPathsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListResourceValueConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListSourcesPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListValuedResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.securitycenter.v2.AttackPath;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.BigQueryExport;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsResponse;
import com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.CreateFindingRequest;
import com.google.cloud.securitycenter.v2.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.CreateSourceRequest;
import com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.ExternalSystem;
import com.google.cloud.securitycenter.v2.Finding;
import com.google.cloud.securitycenter.v2.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v2.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.GetSimulationRequest;
import com.google.cloud.securitycenter.v2.GetSourceRequest;
import com.google.cloud.securitycenter.v2.GetValuedResourceRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsResponse;
import com.google.cloud.securitycenter.v2.GroupResult;
import com.google.cloud.securitycenter.v2.ListAttackPathsRequest;
import com.google.cloud.securitycenter.v2.ListAttackPathsResponse;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse;
import com.google.cloud.securitycenter.v2.ListFindingsRequest;
import com.google.cloud.securitycenter.v2.ListFindingsResponse;
import com.google.cloud.securitycenter.v2.ListMuteConfigsRequest;
import com.google.cloud.securitycenter.v2.ListMuteConfigsResponse;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.ListSourcesRequest;
import com.google.cloud.securitycenter.v2.ListSourcesResponse;
import com.google.cloud.securitycenter.v2.ListValuedResourcesRequest;
import com.google.cloud.securitycenter.v2.ListValuedResourcesResponse;
import com.google.cloud.securitycenter.v2.MuteConfig;
import com.google.cloud.securitycenter.v2.NotificationConfig;
import com.google.cloud.securitycenter.v2.ResourceValueConfig;
import com.google.cloud.securitycenter.v2.SecurityMarks;
import com.google.cloud.securitycenter.v2.SetFindingStateRequest;
import com.google.cloud.securitycenter.v2.SetMuteRequest;
import com.google.cloud.securitycenter.v2.Simulation;
import com.google.cloud.securitycenter.v2.Source;
import com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest;
import com.google.cloud.securitycenter.v2.UpdateFindingRequest;
import com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v2.UpdateSourceRequest;
import com.google.cloud.securitycenter.v2.ValuedResource;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityCenterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of batchCreateResourceValueConfigs to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterStubSettings.Builder securityCenterSettingsBuilder =
 *     SecurityCenterStubSettings.newBuilder();
 * securityCenterSettingsBuilder
 *     .batchCreateResourceValueConfigsSettings()
 *     .setRetrySettings(
 *         securityCenterSettingsBuilder
 *             .batchCreateResourceValueConfigsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterStubSettings securityCenterSettings = securityCenterSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityCenterStubSettings extends StubSettings<SecurityCenterStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsSettings;
  private final UnaryCallSettings<BulkMuteFindingsRequest, Operation> bulkMuteFindingsSettings;
  private final OperationCallSettings<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationSettings;
  private final UnaryCallSettings<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportSettings;
  private final UnaryCallSettings<CreateFindingRequest, Finding> createFindingSettings;
  private final UnaryCallSettings<CreateMuteConfigRequest, MuteConfig> createMuteConfigSettings;
  private final UnaryCallSettings<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigSettings;
  private final UnaryCallSettings<CreateSourceRequest, Source> createSourceSettings;
  private final UnaryCallSettings<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportSettings;
  private final UnaryCallSettings<DeleteMuteConfigRequest, Empty> deleteMuteConfigSettings;
  private final UnaryCallSettings<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigSettings;
  private final UnaryCallSettings<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigSettings;
  private final UnaryCallSettings<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportSettings;
  private final UnaryCallSettings<GetSimulationRequest, Simulation> getSimulationSettings;
  private final UnaryCallSettings<GetValuedResourceRequest, ValuedResource>
      getValuedResourceSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<GetMuteConfigRequest, MuteConfig> getMuteConfigSettings;
  private final UnaryCallSettings<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigSettings;
  private final UnaryCallSettings<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigSettings;
  private final UnaryCallSettings<GetSourceRequest, Source> getSourceSettings;
  private final PagedCallSettings<
          GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      groupFindingsSettings;
  private final PagedCallSettings<
          ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>
      listAttackPathsSettings;
  private final PagedCallSettings<
          ListBigQueryExportsRequest, ListBigQueryExportsResponse, ListBigQueryExportsPagedResponse>
      listBigQueryExportsSettings;
  private final PagedCallSettings<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings;
  private final PagedCallSettings<
          ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>
      listMuteConfigsSettings;
  private final PagedCallSettings<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      listNotificationConfigsSettings;
  private final PagedCallSettings<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsSettings;
  private final PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings;
  private final PagedCallSettings<
          ListValuedResourcesRequest, ListValuedResourcesResponse, ListValuedResourcesPagedResponse>
      listValuedResourcesSettings;
  private final UnaryCallSettings<SetFindingStateRequest, Finding> setFindingStateSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetMuteRequest, Finding> setMuteSettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportSettings;
  private final UnaryCallSettings<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemSettings;
  private final UnaryCallSettings<UpdateFindingRequest, Finding> updateFindingSettings;
  private final UnaryCallSettings<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigSettings;
  private final UnaryCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigSettings;
  private final UnaryCallSettings<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigSettings;
  private final UnaryCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksSettings;
  private final UnaryCallSettings<UpdateSourceRequest, Source> updateSourceSettings;

  private static final PagedListDescriptor<GroupFindingsRequest, GroupFindingsResponse, GroupResult>
      GROUP_FINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<GroupFindingsRequest, GroupFindingsResponse, GroupResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GroupFindingsRequest injectToken(GroupFindingsRequest payload, String token) {
              return GroupFindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public GroupFindingsRequest injectPageSize(GroupFindingsRequest payload, int pageSize) {
              return GroupFindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(GroupFindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(GroupFindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GroupResult> extractResources(GroupFindingsResponse payload) {
              return payload.getGroupByResultsList() == null
                  ? ImmutableList.<GroupResult>of()
                  : payload.getGroupByResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListAttackPathsRequest, ListAttackPathsResponse, AttackPath>
      LIST_ATTACK_PATHS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAttackPathsRequest injectToken(
                ListAttackPathsRequest payload, String token) {
              return ListAttackPathsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAttackPathsRequest injectPageSize(
                ListAttackPathsRequest payload, int pageSize) {
              return ListAttackPathsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAttackPathsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAttackPathsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AttackPath> extractResources(ListAttackPathsResponse payload) {
              return payload.getAttackPathsList() == null
                  ? ImmutableList.<AttackPath>of()
                  : payload.getAttackPathsList();
            }
          };

  private static final PagedListDescriptor<
          ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
      LIST_BIG_QUERY_EXPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBigQueryExportsRequest injectToken(
                ListBigQueryExportsRequest payload, String token) {
              return ListBigQueryExportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBigQueryExportsRequest injectPageSize(
                ListBigQueryExportsRequest payload, int pageSize) {
              return ListBigQueryExportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBigQueryExportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBigQueryExportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BigQueryExport> extractResources(ListBigQueryExportsResponse payload) {
              return payload.getBigQueryExportsList() == null
                  ? ImmutableList.<BigQueryExport>of()
                  : payload.getBigQueryExportsList();
            }
          };

  private static final PagedListDescriptor<
          ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
      LIST_FINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFindingsRequest,
              ListFindingsResponse,
              ListFindingsResponse.ListFindingsResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFindingsRequest injectToken(ListFindingsRequest payload, String token) {
              return ListFindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFindingsRequest injectPageSize(ListFindingsRequest payload, int pageSize) {
              return ListFindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListFindingsResponse.ListFindingsResult> extractResources(
                ListFindingsResponse payload) {
              return payload.getListFindingsResultsList() == null
                  ? ImmutableList.<ListFindingsResponse.ListFindingsResult>of()
                  : payload.getListFindingsResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig>
      LIST_MUTE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMuteConfigsRequest injectToken(
                ListMuteConfigsRequest payload, String token) {
              return ListMuteConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMuteConfigsRequest injectPageSize(
                ListMuteConfigsRequest payload, int pageSize) {
              return ListMuteConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMuteConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMuteConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MuteConfig> extractResources(ListMuteConfigsResponse payload) {
              return payload.getMuteConfigsList() == null
                  ? ImmutableList.<MuteConfig>of()
                  : payload.getMuteConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
      LIST_NOTIFICATION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotificationConfigsRequest,
              ListNotificationConfigsResponse,
              NotificationConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotificationConfigsRequest injectToken(
                ListNotificationConfigsRequest payload, String token) {
              return ListNotificationConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNotificationConfigsRequest injectPageSize(
                ListNotificationConfigsRequest payload, int pageSize) {
              return ListNotificationConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotificationConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotificationConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotificationConfig> extractResources(
                ListNotificationConfigsResponse payload) {
              return payload.getNotificationConfigsList() == null
                  ? ImmutableList.<NotificationConfig>of()
                  : payload.getNotificationConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListResourceValueConfigsRequest, ListResourceValueConfigsResponse, ResourceValueConfig>
      LIST_RESOURCE_VALUE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListResourceValueConfigsRequest,
              ListResourceValueConfigsResponse,
              ResourceValueConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListResourceValueConfigsRequest injectToken(
                ListResourceValueConfigsRequest payload, String token) {
              return ListResourceValueConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListResourceValueConfigsRequest injectPageSize(
                ListResourceValueConfigsRequest payload, int pageSize) {
              return ListResourceValueConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListResourceValueConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListResourceValueConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResourceValueConfig> extractResources(
                ListResourceValueConfigsResponse payload) {
              return payload.getResourceValueConfigsList() == null
                  ? ImmutableList.<ResourceValueConfig>of()
                  : payload.getResourceValueConfigsList();
            }
          };

  private static final PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>
      LIST_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSourcesRequest injectToken(ListSourcesRequest payload, String token) {
              return ListSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSourcesRequest injectPageSize(ListSourcesRequest payload, int pageSize) {
              return ListSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Source> extractResources(ListSourcesResponse payload) {
              return payload.getSourcesList() == null
                  ? ImmutableList.<Source>of()
                  : payload.getSourcesList();
            }
          };

  private static final PagedListDescriptor<
          ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
      LIST_VALUED_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListValuedResourcesRequest injectToken(
                ListValuedResourcesRequest payload, String token) {
              return ListValuedResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListValuedResourcesRequest injectPageSize(
                ListValuedResourcesRequest payload, int pageSize) {
              return ListValuedResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListValuedResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListValuedResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ValuedResource> extractResources(ListValuedResourcesResponse payload) {
              return payload.getValuedResourcesList() == null
                  ? ImmutableList.<ValuedResource>of()
                  : payload.getValuedResourcesList();
            }
          };

  private static final PagedListResponseFactory<
          GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      GROUP_FINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>() {
            @Override
            public ApiFuture<GroupFindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> callable,
                GroupFindingsRequest request,
                ApiCallContext context,
                ApiFuture<GroupFindingsResponse> futureResponse) {
              PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> pageContext =
                  PageContext.create(callable, GROUP_FINDINGS_PAGE_STR_DESC, request, context);
              return GroupFindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>
      LIST_ATTACK_PATHS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>() {
            @Override
            public ApiFuture<ListAttackPathsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse> callable,
                ListAttackPathsRequest request,
                ApiCallContext context,
                ApiFuture<ListAttackPathsResponse> futureResponse) {
              PageContext<ListAttackPathsRequest, ListAttackPathsResponse, AttackPath> pageContext =
                  PageContext.create(callable, LIST_ATTACK_PATHS_PAGE_STR_DESC, request, context);
              return ListAttackPathsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBigQueryExportsRequest, ListBigQueryExportsResponse, ListBigQueryExportsPagedResponse>
      LIST_BIG_QUERY_EXPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBigQueryExportsRequest,
              ListBigQueryExportsResponse,
              ListBigQueryExportsPagedResponse>() {
            @Override
            public ApiFuture<ListBigQueryExportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse> callable,
                ListBigQueryExportsRequest request,
                ApiCallContext context,
                ApiFuture<ListBigQueryExportsResponse> futureResponse) {
              PageContext<ListBigQueryExportsRequest, ListBigQueryExportsResponse, BigQueryExport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BIG_QUERY_EXPORTS_PAGE_STR_DESC, request, context);
              return ListBigQueryExportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      LIST_FINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>() {
            @Override
            public ApiFuture<ListFindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFindingsRequest, ListFindingsResponse> callable,
                ListFindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListFindingsResponse> futureResponse) {
              PageContext<
                      ListFindingsRequest,
                      ListFindingsResponse,
                      ListFindingsResponse.ListFindingsResult>
                  pageContext =
                      PageContext.create(callable, LIST_FINDINGS_PAGE_STR_DESC, request, context);
              return ListFindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>
      LIST_MUTE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListMuteConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse> callable,
                ListMuteConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListMuteConfigsResponse> futureResponse) {
              PageContext<ListMuteConfigsRequest, ListMuteConfigsResponse, MuteConfig> pageContext =
                  PageContext.create(callable, LIST_MUTE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListMuteConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      LIST_NOTIFICATION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotificationConfigsRequest,
              ListNotificationConfigsResponse,
              ListNotificationConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListNotificationConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
                    callable,
                ListNotificationConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListNotificationConfigsResponse> futureResponse) {
              PageContext<
                      ListNotificationConfigsRequest,
                      ListNotificationConfigsResponse,
                      NotificationConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTIFICATION_CONFIGS_PAGE_STR_DESC, request, context);
              return ListNotificationConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ListResourceValueConfigsPagedResponse>
      LIST_RESOURCE_VALUE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListResourceValueConfigsRequest,
              ListResourceValueConfigsResponse,
              ListResourceValueConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListResourceValueConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
                    callable,
                ListResourceValueConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListResourceValueConfigsResponse> futureResponse) {
              PageContext<
                      ListResourceValueConfigsRequest,
                      ListResourceValueConfigsResponse,
                      ResourceValueConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESOURCE_VALUE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListResourceValueConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      LIST_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSourcesRequest, ListSourcesResponse> callable,
                ListSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListSourcesResponse> futureResponse) {
              PageContext<ListSourcesRequest, ListSourcesResponse, Source> pageContext =
                  PageContext.create(callable, LIST_SOURCES_PAGE_STR_DESC, request, context);
              return ListSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListValuedResourcesRequest, ListValuedResourcesResponse, ListValuedResourcesPagedResponse>
      LIST_VALUED_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListValuedResourcesRequest,
              ListValuedResourcesResponse,
              ListValuedResourcesPagedResponse>() {
            @Override
            public ApiFuture<ListValuedResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse> callable,
                ListValuedResourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListValuedResourcesResponse> futureResponse) {
              PageContext<ListValuedResourcesRequest, ListValuedResourcesResponse, ValuedResource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VALUED_RESOURCES_PAGE_STR_DESC, request, context);
              return ListValuedResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to batchCreateResourceValueConfigs. */
  public UnaryCallSettings<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsSettings() {
    return batchCreateResourceValueConfigsSettings;
  }

  /** Returns the object with the settings used for calls to bulkMuteFindings. */
  public UnaryCallSettings<BulkMuteFindingsRequest, Operation> bulkMuteFindingsSettings() {
    return bulkMuteFindingsSettings;
  }

  /** Returns the object with the settings used for calls to bulkMuteFindings. */
  public OperationCallSettings<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationSettings() {
    return bulkMuteFindingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBigQueryExport. */
  public UnaryCallSettings<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportSettings() {
    return createBigQueryExportSettings;
  }

  /** Returns the object with the settings used for calls to createFinding. */
  public UnaryCallSettings<CreateFindingRequest, Finding> createFindingSettings() {
    return createFindingSettings;
  }

  /** Returns the object with the settings used for calls to createMuteConfig. */
  public UnaryCallSettings<CreateMuteConfigRequest, MuteConfig> createMuteConfigSettings() {
    return createMuteConfigSettings;
  }

  /** Returns the object with the settings used for calls to createNotificationConfig. */
  public UnaryCallSettings<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigSettings() {
    return createNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Source> createSourceSettings() {
    return createSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteBigQueryExport. */
  public UnaryCallSettings<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportSettings() {
    return deleteBigQueryExportSettings;
  }

  /** Returns the object with the settings used for calls to deleteMuteConfig. */
  public UnaryCallSettings<DeleteMuteConfigRequest, Empty> deleteMuteConfigSettings() {
    return deleteMuteConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotificationConfig. */
  public UnaryCallSettings<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigSettings() {
    return deleteNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteResourceValueConfig. */
  public UnaryCallSettings<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigSettings() {
    return deleteResourceValueConfigSettings;
  }

  /** Returns the object with the settings used for calls to getBigQueryExport. */
  public UnaryCallSettings<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportSettings() {
    return getBigQueryExportSettings;
  }

  /** Returns the object with the settings used for calls to getSimulation. */
  public UnaryCallSettings<GetSimulationRequest, Simulation> getSimulationSettings() {
    return getSimulationSettings;
  }

  /** Returns the object with the settings used for calls to getValuedResource. */
  public UnaryCallSettings<GetValuedResourceRequest, ValuedResource> getValuedResourceSettings() {
    return getValuedResourceSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getMuteConfig. */
  public UnaryCallSettings<GetMuteConfigRequest, MuteConfig> getMuteConfigSettings() {
    return getMuteConfigSettings;
  }

  /** Returns the object with the settings used for calls to getNotificationConfig. */
  public UnaryCallSettings<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigSettings() {
    return getNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to getResourceValueConfig. */
  public UnaryCallSettings<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigSettings() {
    return getResourceValueConfigSettings;
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return getSourceSettings;
  }

  /** Returns the object with the settings used for calls to groupFindings. */
  public PagedCallSettings<GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      groupFindingsSettings() {
    return groupFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listAttackPaths. */
  public PagedCallSettings<
          ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>
      listAttackPathsSettings() {
    return listAttackPathsSettings;
  }

  /** Returns the object with the settings used for calls to listBigQueryExports. */
  public PagedCallSettings<
          ListBigQueryExportsRequest, ListBigQueryExportsResponse, ListBigQueryExportsPagedResponse>
      listBigQueryExportsSettings() {
    return listBigQueryExportsSettings;
  }

  /** Returns the object with the settings used for calls to listFindings. */
  public PagedCallSettings<ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings() {
    return listFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listMuteConfigs. */
  public PagedCallSettings<
          ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>
      listMuteConfigsSettings() {
    return listMuteConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listNotificationConfigs. */
  public PagedCallSettings<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      listNotificationConfigsSettings() {
    return listNotificationConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listResourceValueConfigs. */
  public PagedCallSettings<
          ListResourceValueConfigsRequest,
          ListResourceValueConfigsResponse,
          ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsSettings() {
    return listResourceValueConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return listSourcesSettings;
  }

  /** Returns the object with the settings used for calls to listValuedResources. */
  public PagedCallSettings<
          ListValuedResourcesRequest, ListValuedResourcesResponse, ListValuedResourcesPagedResponse>
      listValuedResourcesSettings() {
    return listValuedResourcesSettings;
  }

  /** Returns the object with the settings used for calls to setFindingState. */
  public UnaryCallSettings<SetFindingStateRequest, Finding> setFindingStateSettings() {
    return setFindingStateSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setMute. */
  public UnaryCallSettings<SetMuteRequest, Finding> setMuteSettings() {
    return setMuteSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to updateBigQueryExport. */
  public UnaryCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportSettings() {
    return updateBigQueryExportSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalSystem. */
  public UnaryCallSettings<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemSettings() {
    return updateExternalSystemSettings;
  }

  /** Returns the object with the settings used for calls to updateFinding. */
  public UnaryCallSettings<UpdateFindingRequest, Finding> updateFindingSettings() {
    return updateFindingSettings;
  }

  /** Returns the object with the settings used for calls to updateMuteConfig. */
  public UnaryCallSettings<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigSettings() {
    return updateMuteConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateNotificationConfig. */
  public UnaryCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigSettings() {
    return updateNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateResourceValueConfig. */
  public UnaryCallSettings<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigSettings() {
    return updateResourceValueConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityMarks. */
  public UnaryCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksSettings() {
    return updateSecurityMarksSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Source> updateSourceSettings() {
    return updateSourceSettings;
  }

  public SecurityCenterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecurityCenterStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecurityCenterStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "securitycenter";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "securitycenter.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "securitycenter.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecurityCenterStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecurityCenterStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityCenterStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SecurityCenterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    batchCreateResourceValueConfigsSettings =
        settingsBuilder.batchCreateResourceValueConfigsSettings().build();
    bulkMuteFindingsSettings = settingsBuilder.bulkMuteFindingsSettings().build();
    bulkMuteFindingsOperationSettings = settingsBuilder.bulkMuteFindingsOperationSettings().build();
    createBigQueryExportSettings = settingsBuilder.createBigQueryExportSettings().build();
    createFindingSettings = settingsBuilder.createFindingSettings().build();
    createMuteConfigSettings = settingsBuilder.createMuteConfigSettings().build();
    createNotificationConfigSettings = settingsBuilder.createNotificationConfigSettings().build();
    createSourceSettings = settingsBuilder.createSourceSettings().build();
    deleteBigQueryExportSettings = settingsBuilder.deleteBigQueryExportSettings().build();
    deleteMuteConfigSettings = settingsBuilder.deleteMuteConfigSettings().build();
    deleteNotificationConfigSettings = settingsBuilder.deleteNotificationConfigSettings().build();
    deleteResourceValueConfigSettings = settingsBuilder.deleteResourceValueConfigSettings().build();
    getBigQueryExportSettings = settingsBuilder.getBigQueryExportSettings().build();
    getSimulationSettings = settingsBuilder.getSimulationSettings().build();
    getValuedResourceSettings = settingsBuilder.getValuedResourceSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getMuteConfigSettings = settingsBuilder.getMuteConfigSettings().build();
    getNotificationConfigSettings = settingsBuilder.getNotificationConfigSettings().build();
    getResourceValueConfigSettings = settingsBuilder.getResourceValueConfigSettings().build();
    getSourceSettings = settingsBuilder.getSourceSettings().build();
    groupFindingsSettings = settingsBuilder.groupFindingsSettings().build();
    listAttackPathsSettings = settingsBuilder.listAttackPathsSettings().build();
    listBigQueryExportsSettings = settingsBuilder.listBigQueryExportsSettings().build();
    listFindingsSettings = settingsBuilder.listFindingsSettings().build();
    listMuteConfigsSettings = settingsBuilder.listMuteConfigsSettings().build();
    listNotificationConfigsSettings = settingsBuilder.listNotificationConfigsSettings().build();
    listResourceValueConfigsSettings = settingsBuilder.listResourceValueConfigsSettings().build();
    listSourcesSettings = settingsBuilder.listSourcesSettings().build();
    listValuedResourcesSettings = settingsBuilder.listValuedResourcesSettings().build();
    setFindingStateSettings = settingsBuilder.setFindingStateSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setMuteSettings = settingsBuilder.setMuteSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateBigQueryExportSettings = settingsBuilder.updateBigQueryExportSettings().build();
    updateExternalSystemSettings = settingsBuilder.updateExternalSystemSettings().build();
    updateFindingSettings = settingsBuilder.updateFindingSettings().build();
    updateMuteConfigSettings = settingsBuilder.updateMuteConfigSettings().build();
    updateNotificationConfigSettings = settingsBuilder.updateNotificationConfigSettings().build();
    updateResourceValueConfigSettings = settingsBuilder.updateResourceValueConfigSettings().build();
    updateSecurityMarksSettings = settingsBuilder.updateSecurityMarksSettings().build();
    updateSourceSettings = settingsBuilder.updateSourceSettings().build();
  }

  /** Builder for SecurityCenterStubSettings. */
  public static class Builder extends StubSettings.Builder<SecurityCenterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
        batchCreateResourceValueConfigsSettings;
    private final UnaryCallSettings.Builder<BulkMuteFindingsRequest, Operation>
        bulkMuteFindingsSettings;
    private final OperationCallSettings.Builder<
            BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
        bulkMuteFindingsOperationSettings;
    private final UnaryCallSettings.Builder<CreateBigQueryExportRequest, BigQueryExport>
        createBigQueryExportSettings;
    private final UnaryCallSettings.Builder<CreateFindingRequest, Finding> createFindingSettings;
    private final UnaryCallSettings.Builder<CreateMuteConfigRequest, MuteConfig>
        createMuteConfigSettings;
    private final UnaryCallSettings.Builder<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigSettings;
    private final UnaryCallSettings.Builder<CreateSourceRequest, Source> createSourceSettings;
    private final UnaryCallSettings.Builder<DeleteBigQueryExportRequest, Empty>
        deleteBigQueryExportSettings;
    private final UnaryCallSettings.Builder<DeleteMuteConfigRequest, Empty>
        deleteMuteConfigSettings;
    private final UnaryCallSettings.Builder<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigSettings;
    private final UnaryCallSettings.Builder<DeleteResourceValueConfigRequest, Empty>
        deleteResourceValueConfigSettings;
    private final UnaryCallSettings.Builder<GetBigQueryExportRequest, BigQueryExport>
        getBigQueryExportSettings;
    private final UnaryCallSettings.Builder<GetSimulationRequest, Simulation> getSimulationSettings;
    private final UnaryCallSettings.Builder<GetValuedResourceRequest, ValuedResource>
        getValuedResourceSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<GetMuteConfigRequest, MuteConfig> getMuteConfigSettings;
    private final UnaryCallSettings.Builder<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigSettings;
    private final UnaryCallSettings.Builder<GetResourceValueConfigRequest, ResourceValueConfig>
        getResourceValueConfigSettings;
    private final UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings;
    private final PagedCallSettings.Builder<
            GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
        groupFindingsSettings;
    private final PagedCallSettings.Builder<
            ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>
        listAttackPathsSettings;
    private final PagedCallSettings.Builder<
            ListBigQueryExportsRequest,
            ListBigQueryExportsResponse,
            ListBigQueryExportsPagedResponse>
        listBigQueryExportsSettings;
    private final PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings;
    private final PagedCallSettings.Builder<
            ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>
        listMuteConfigsSettings;
    private final PagedCallSettings.Builder<
            ListNotificationConfigsRequest,
            ListNotificationConfigsResponse,
            ListNotificationConfigsPagedResponse>
        listNotificationConfigsSettings;
    private final PagedCallSettings.Builder<
            ListResourceValueConfigsRequest,
            ListResourceValueConfigsResponse,
            ListResourceValueConfigsPagedResponse>
        listResourceValueConfigsSettings;
    private final PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings;
    private final PagedCallSettings.Builder<
            ListValuedResourcesRequest,
            ListValuedResourcesResponse,
            ListValuedResourcesPagedResponse>
        listValuedResourcesSettings;
    private final UnaryCallSettings.Builder<SetFindingStateRequest, Finding>
        setFindingStateSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetMuteRequest, Finding> setMuteSettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportSettings;
    private final UnaryCallSettings.Builder<UpdateExternalSystemRequest, ExternalSystem>
        updateExternalSystemSettings;
    private final UnaryCallSettings.Builder<UpdateFindingRequest, Finding> updateFindingSettings;
    private final UnaryCallSettings.Builder<UpdateMuteConfigRequest, MuteConfig>
        updateMuteConfigSettings;
    private final UnaryCallSettings.Builder<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigSettings;
    private final UnaryCallSettings.Builder<UpdateResourceValueConfigRequest, ResourceValueConfig>
        updateResourceValueConfigSettings;
    private final UnaryCallSettings.Builder<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksSettings;
    private final UnaryCallSettings.Builder<UpdateSourceRequest, Source> updateSourceSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      batchCreateResourceValueConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkMuteFindingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkMuteFindingsOperationSettings = OperationCallSettings.newBuilder();
      createBigQueryExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMuteConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBigQueryExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMuteConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteResourceValueConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBigQueryExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSimulationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getValuedResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMuteConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getResourceValueConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      groupFindingsSettings = PagedCallSettings.newBuilder(GROUP_FINDINGS_PAGE_STR_FACT);
      listAttackPathsSettings = PagedCallSettings.newBuilder(LIST_ATTACK_PATHS_PAGE_STR_FACT);
      listBigQueryExportsSettings =
          PagedCallSettings.newBuilder(LIST_BIG_QUERY_EXPORTS_PAGE_STR_FACT);
      listFindingsSettings = PagedCallSettings.newBuilder(LIST_FINDINGS_PAGE_STR_FACT);
      listMuteConfigsSettings = PagedCallSettings.newBuilder(LIST_MUTE_CONFIGS_PAGE_STR_FACT);
      listNotificationConfigsSettings =
          PagedCallSettings.newBuilder(LIST_NOTIFICATION_CONFIGS_PAGE_STR_FACT);
      listResourceValueConfigsSettings =
          PagedCallSettings.newBuilder(LIST_RESOURCE_VALUE_CONFIGS_PAGE_STR_FACT);
      listSourcesSettings = PagedCallSettings.newBuilder(LIST_SOURCES_PAGE_STR_FACT);
      listValuedResourcesSettings =
          PagedCallSettings.newBuilder(LIST_VALUED_RESOURCES_PAGE_STR_FACT);
      setFindingStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setMuteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBigQueryExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExternalSystemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMuteConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateResourceValueConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecurityMarksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchCreateResourceValueConfigsSettings,
              bulkMuteFindingsSettings,
              createBigQueryExportSettings,
              createFindingSettings,
              createMuteConfigSettings,
              createNotificationConfigSettings,
              createSourceSettings,
              deleteBigQueryExportSettings,
              deleteMuteConfigSettings,
              deleteNotificationConfigSettings,
              deleteResourceValueConfigSettings,
              getBigQueryExportSettings,
              getSimulationSettings,
              getValuedResourceSettings,
              getIamPolicySettings,
              getMuteConfigSettings,
              getNotificationConfigSettings,
              getResourceValueConfigSettings,
              getSourceSettings,
              groupFindingsSettings,
              listAttackPathsSettings,
              listBigQueryExportsSettings,
              listFindingsSettings,
              listMuteConfigsSettings,
              listNotificationConfigsSettings,
              listResourceValueConfigsSettings,
              listSourcesSettings,
              listValuedResourcesSettings,
              setFindingStateSettings,
              setIamPolicySettings,
              setMuteSettings,
              testIamPermissionsSettings,
              updateBigQueryExportSettings,
              updateExternalSystemSettings,
              updateFindingSettings,
              updateMuteConfigSettings,
              updateNotificationConfigSettings,
              updateResourceValueConfigSettings,
              updateSecurityMarksSettings,
              updateSourceSettings);
      initDefaults(this);
    }

    protected Builder(SecurityCenterStubSettings settings) {
      super(settings);

      batchCreateResourceValueConfigsSettings =
          settings.batchCreateResourceValueConfigsSettings.toBuilder();
      bulkMuteFindingsSettings = settings.bulkMuteFindingsSettings.toBuilder();
      bulkMuteFindingsOperationSettings = settings.bulkMuteFindingsOperationSettings.toBuilder();
      createBigQueryExportSettings = settings.createBigQueryExportSettings.toBuilder();
      createFindingSettings = settings.createFindingSettings.toBuilder();
      createMuteConfigSettings = settings.createMuteConfigSettings.toBuilder();
      createNotificationConfigSettings = settings.createNotificationConfigSettings.toBuilder();
      createSourceSettings = settings.createSourceSettings.toBuilder();
      deleteBigQueryExportSettings = settings.deleteBigQueryExportSettings.toBuilder();
      deleteMuteConfigSettings = settings.deleteMuteConfigSettings.toBuilder();
      deleteNotificationConfigSettings = settings.deleteNotificationConfigSettings.toBuilder();
      deleteResourceValueConfigSettings = settings.deleteResourceValueConfigSettings.toBuilder();
      getBigQueryExportSettings = settings.getBigQueryExportSettings.toBuilder();
      getSimulationSettings = settings.getSimulationSettings.toBuilder();
      getValuedResourceSettings = settings.getValuedResourceSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getMuteConfigSettings = settings.getMuteConfigSettings.toBuilder();
      getNotificationConfigSettings = settings.getNotificationConfigSettings.toBuilder();
      getResourceValueConfigSettings = settings.getResourceValueConfigSettings.toBuilder();
      getSourceSettings = settings.getSourceSettings.toBuilder();
      groupFindingsSettings = settings.groupFindingsSettings.toBuilder();
      listAttackPathsSettings = settings.listAttackPathsSettings.toBuilder();
      listBigQueryExportsSettings = settings.listBigQueryExportsSettings.toBuilder();
      listFindingsSettings = settings.listFindingsSettings.toBuilder();
      listMuteConfigsSettings = settings.listMuteConfigsSettings.toBuilder();
      listNotificationConfigsSettings = settings.listNotificationConfigsSettings.toBuilder();
      listResourceValueConfigsSettings = settings.listResourceValueConfigsSettings.toBuilder();
      listSourcesSettings = settings.listSourcesSettings.toBuilder();
      listValuedResourcesSettings = settings.listValuedResourcesSettings.toBuilder();
      setFindingStateSettings = settings.setFindingStateSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setMuteSettings = settings.setMuteSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateBigQueryExportSettings = settings.updateBigQueryExportSettings.toBuilder();
      updateExternalSystemSettings = settings.updateExternalSystemSettings.toBuilder();
      updateFindingSettings = settings.updateFindingSettings.toBuilder();
      updateMuteConfigSettings = settings.updateMuteConfigSettings.toBuilder();
      updateNotificationConfigSettings = settings.updateNotificationConfigSettings.toBuilder();
      updateResourceValueConfigSettings = settings.updateResourceValueConfigSettings.toBuilder();
      updateSecurityMarksSettings = settings.updateSecurityMarksSettings.toBuilder();
      updateSourceSettings = settings.updateSourceSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              batchCreateResourceValueConfigsSettings,
              bulkMuteFindingsSettings,
              createBigQueryExportSettings,
              createFindingSettings,
              createMuteConfigSettings,
              createNotificationConfigSettings,
              createSourceSettings,
              deleteBigQueryExportSettings,
              deleteMuteConfigSettings,
              deleteNotificationConfigSettings,
              deleteResourceValueConfigSettings,
              getBigQueryExportSettings,
              getSimulationSettings,
              getValuedResourceSettings,
              getIamPolicySettings,
              getMuteConfigSettings,
              getNotificationConfigSettings,
              getResourceValueConfigSettings,
              getSourceSettings,
              groupFindingsSettings,
              listAttackPathsSettings,
              listBigQueryExportsSettings,
              listFindingsSettings,
              listMuteConfigsSettings,
              listNotificationConfigsSettings,
              listResourceValueConfigsSettings,
              listSourcesSettings,
              listValuedResourcesSettings,
              setFindingStateSettings,
              setIamPolicySettings,
              setMuteSettings,
              testIamPermissionsSettings,
              updateBigQueryExportSettings,
              updateExternalSystemSettings,
              updateFindingSettings,
              updateMuteConfigSettings,
              updateNotificationConfigSettings,
              updateResourceValueConfigSettings,
              updateSecurityMarksSettings,
              updateSourceSettings);
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
          .batchCreateResourceValueConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .bulkMuteFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBigQueryExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMuteConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBigQueryExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMuteConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteResourceValueConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBigQueryExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSimulationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getValuedResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMuteConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getResourceValueConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .groupFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAttackPathsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBigQueryExportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMuteConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNotificationConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listResourceValueConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listValuedResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setFindingStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setMuteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateBigQueryExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateExternalSystemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMuteConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateResourceValueConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSecurityMarksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .bulkMuteFindingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkMuteFindingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BulkMuteFindingsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to batchCreateResourceValueConfigs. */
    public UnaryCallSettings.Builder<
            BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
        batchCreateResourceValueConfigsSettings() {
      return batchCreateResourceValueConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkMuteFindings. */
    public UnaryCallSettings.Builder<BulkMuteFindingsRequest, Operation>
        bulkMuteFindingsSettings() {
      return bulkMuteFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkMuteFindings. */
    public OperationCallSettings.Builder<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
        bulkMuteFindingsOperationSettings() {
      return bulkMuteFindingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBigQueryExport. */
    public UnaryCallSettings.Builder<CreateBigQueryExportRequest, BigQueryExport>
        createBigQueryExportSettings() {
      return createBigQueryExportSettings;
    }

    /** Returns the builder for the settings used for calls to createFinding. */
    public UnaryCallSettings.Builder<CreateFindingRequest, Finding> createFindingSettings() {
      return createFindingSettings;
    }

    /** Returns the builder for the settings used for calls to createMuteConfig. */
    public UnaryCallSettings.Builder<CreateMuteConfigRequest, MuteConfig>
        createMuteConfigSettings() {
      return createMuteConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createNotificationConfig. */
    public UnaryCallSettings.Builder<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigSettings() {
      return createNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public UnaryCallSettings.Builder<CreateSourceRequest, Source> createSourceSettings() {
      return createSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBigQueryExport. */
    public UnaryCallSettings.Builder<DeleteBigQueryExportRequest, Empty>
        deleteBigQueryExportSettings() {
      return deleteBigQueryExportSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMuteConfig. */
    public UnaryCallSettings.Builder<DeleteMuteConfigRequest, Empty> deleteMuteConfigSettings() {
      return deleteMuteConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotificationConfig. */
    public UnaryCallSettings.Builder<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigSettings() {
      return deleteNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteResourceValueConfig. */
    public UnaryCallSettings.Builder<DeleteResourceValueConfigRequest, Empty>
        deleteResourceValueConfigSettings() {
      return deleteResourceValueConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getBigQueryExport. */
    public UnaryCallSettings.Builder<GetBigQueryExportRequest, BigQueryExport>
        getBigQueryExportSettings() {
      return getBigQueryExportSettings;
    }

    /** Returns the builder for the settings used for calls to getSimulation. */
    public UnaryCallSettings.Builder<GetSimulationRequest, Simulation> getSimulationSettings() {
      return getSimulationSettings;
    }

    /** Returns the builder for the settings used for calls to getValuedResource. */
    public UnaryCallSettings.Builder<GetValuedResourceRequest, ValuedResource>
        getValuedResourceSettings() {
      return getValuedResourceSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getMuteConfig. */
    public UnaryCallSettings.Builder<GetMuteConfigRequest, MuteConfig> getMuteConfigSettings() {
      return getMuteConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getNotificationConfig. */
    public UnaryCallSettings.Builder<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigSettings() {
      return getNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getResourceValueConfig. */
    public UnaryCallSettings.Builder<GetResourceValueConfigRequest, ResourceValueConfig>
        getResourceValueConfigSettings() {
      return getResourceValueConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getSource. */
    public UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings() {
      return getSourceSettings;
    }

    /** Returns the builder for the settings used for calls to groupFindings. */
    public PagedCallSettings.Builder<
            GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
        groupFindingsSettings() {
      return groupFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listAttackPaths. */
    public PagedCallSettings.Builder<
            ListAttackPathsRequest, ListAttackPathsResponse, ListAttackPathsPagedResponse>
        listAttackPathsSettings() {
      return listAttackPathsSettings;
    }

    /** Returns the builder for the settings used for calls to listBigQueryExports. */
    public PagedCallSettings.Builder<
            ListBigQueryExportsRequest,
            ListBigQueryExportsResponse,
            ListBigQueryExportsPagedResponse>
        listBigQueryExportsSettings() {
      return listBigQueryExportsSettings;
    }

    /** Returns the builder for the settings used for calls to listFindings. */
    public PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings() {
      return listFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listMuteConfigs. */
    public PagedCallSettings.Builder<
            ListMuteConfigsRequest, ListMuteConfigsResponse, ListMuteConfigsPagedResponse>
        listMuteConfigsSettings() {
      return listMuteConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listNotificationConfigs. */
    public PagedCallSettings.Builder<
            ListNotificationConfigsRequest,
            ListNotificationConfigsResponse,
            ListNotificationConfigsPagedResponse>
        listNotificationConfigsSettings() {
      return listNotificationConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listResourceValueConfigs. */
    public PagedCallSettings.Builder<
            ListResourceValueConfigsRequest,
            ListResourceValueConfigsResponse,
            ListResourceValueConfigsPagedResponse>
        listResourceValueConfigsSettings() {
      return listResourceValueConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listSources. */
    public PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings() {
      return listSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to listValuedResources. */
    public PagedCallSettings.Builder<
            ListValuedResourcesRequest,
            ListValuedResourcesResponse,
            ListValuedResourcesPagedResponse>
        listValuedResourcesSettings() {
      return listValuedResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to setFindingState. */
    public UnaryCallSettings.Builder<SetFindingStateRequest, Finding> setFindingStateSettings() {
      return setFindingStateSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setMute. */
    public UnaryCallSettings.Builder<SetMuteRequest, Finding> setMuteSettings() {
      return setMuteSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateBigQueryExport. */
    public UnaryCallSettings.Builder<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportSettings() {
      return updateBigQueryExportSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalSystem. */
    public UnaryCallSettings.Builder<UpdateExternalSystemRequest, ExternalSystem>
        updateExternalSystemSettings() {
      return updateExternalSystemSettings;
    }

    /** Returns the builder for the settings used for calls to updateFinding. */
    public UnaryCallSettings.Builder<UpdateFindingRequest, Finding> updateFindingSettings() {
      return updateFindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateMuteConfig. */
    public UnaryCallSettings.Builder<UpdateMuteConfigRequest, MuteConfig>
        updateMuteConfigSettings() {
      return updateMuteConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateNotificationConfig. */
    public UnaryCallSettings.Builder<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigSettings() {
      return updateNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateResourceValueConfig. */
    public UnaryCallSettings.Builder<UpdateResourceValueConfigRequest, ResourceValueConfig>
        updateResourceValueConfigSettings() {
      return updateResourceValueConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityMarks. */
    public UnaryCallSettings.Builder<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksSettings() {
      return updateSecurityMarksSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public UnaryCallSettings.Builder<UpdateSourceRequest, Source> updateSourceSettings() {
      return updateSourceSettings;
    }

    @Override
    public SecurityCenterStubSettings build() throws IOException {
      return new SecurityCenterStubSettings(this);
    }
  }
}
