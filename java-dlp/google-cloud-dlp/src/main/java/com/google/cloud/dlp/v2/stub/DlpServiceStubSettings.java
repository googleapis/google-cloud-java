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

package com.google.cloud.dlp.v2.stub;

import static com.google.cloud.dlp.v2.DlpServiceClient.ListColumnDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListConnectionsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDiscoveryConfigsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListProjectDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListTableDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.SearchConnectionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.ColumnDataProfile;
import com.google.privacy.dlp.v2.Connection;
import com.google.privacy.dlp.v2.CreateConnectionRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteConnectionRequest;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeleteTableDataProfileRequest;
import com.google.privacy.dlp.v2.DiscoveryConfig;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetColumnDataProfileRequest;
import com.google.privacy.dlp.v2.GetConnectionRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetProjectDataProfileRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.GetTableDataProfileRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListColumnDataProfilesRequest;
import com.google.privacy.dlp.v2.ListColumnDataProfilesResponse;
import com.google.privacy.dlp.v2.ListConnectionsRequest;
import com.google.privacy.dlp.v2.ListConnectionsResponse;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListProjectDataProfilesRequest;
import com.google.privacy.dlp.v2.ListProjectDataProfilesResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.ListTableDataProfilesRequest;
import com.google.privacy.dlp.v2.ListTableDataProfilesResponse;
import com.google.privacy.dlp.v2.ProjectDataProfile;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.SearchConnectionsRequest;
import com.google.privacy.dlp.v2.SearchConnectionsResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.TableDataProfile;
import com.google.privacy.dlp.v2.UpdateConnectionRequest;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DlpServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dlp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of inspectContent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DlpServiceStubSettings.Builder dlpServiceSettingsBuilder = DlpServiceStubSettings.newBuilder();
 * dlpServiceSettingsBuilder
 *     .inspectContentSettings()
 *     .setRetrySettings(
 *         dlpServiceSettingsBuilder
 *             .inspectContentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DlpServiceStubSettings dlpServiceSettings = dlpServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DlpServiceStubSettings extends StubSettings<DlpServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings;
  private final UnaryCallSettings<RedactImageRequest, RedactImageResponse> redactImageSettings;
  private final UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings;
  private final UnaryCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentSettings;
  private final UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesSettings;
  private final UnaryCallSettings<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateSettings;
  private final UnaryCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateSettings;
  private final UnaryCallSettings<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateSettings;
  private final PagedCallSettings<
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      listInspectTemplatesSettings;
  private final UnaryCallSettings<DeleteInspectTemplateRequest, Empty>
      deleteInspectTemplateSettings;
  private final UnaryCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateSettings;
  private final UnaryCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateSettings;
  private final UnaryCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateSettings;
  private final PagedCallSettings<
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesSettings;
  private final UnaryCallSettings<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateSettings;
  private final UnaryCallSettings<CreateJobTriggerRequest, JobTrigger> createJobTriggerSettings;
  private final UnaryCallSettings<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerSettings;
  private final UnaryCallSettings<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerSettings;
  private final UnaryCallSettings<GetJobTriggerRequest, JobTrigger> getJobTriggerSettings;
  private final PagedCallSettings<
          ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>
      listJobTriggersSettings;
  private final UnaryCallSettings<DeleteJobTriggerRequest, Empty> deleteJobTriggerSettings;
  private final UnaryCallSettings<ActivateJobTriggerRequest, DlpJob> activateJobTriggerSettings;
  private final UnaryCallSettings<CreateDiscoveryConfigRequest, DiscoveryConfig>
      createDiscoveryConfigSettings;
  private final UnaryCallSettings<UpdateDiscoveryConfigRequest, DiscoveryConfig>
      updateDiscoveryConfigSettings;
  private final UnaryCallSettings<GetDiscoveryConfigRequest, DiscoveryConfig>
      getDiscoveryConfigSettings;
  private final PagedCallSettings<
          ListDiscoveryConfigsRequest,
          ListDiscoveryConfigsResponse,
          ListDiscoveryConfigsPagedResponse>
      listDiscoveryConfigsSettings;
  private final UnaryCallSettings<DeleteDiscoveryConfigRequest, Empty>
      deleteDiscoveryConfigSettings;
  private final UnaryCallSettings<CreateDlpJobRequest, DlpJob> createDlpJobSettings;
  private final PagedCallSettings<ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      listDlpJobsSettings;
  private final UnaryCallSettings<GetDlpJobRequest, DlpJob> getDlpJobSettings;
  private final UnaryCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobSettings;
  private final UnaryCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobSettings;
  private final UnaryCallSettings<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeSettings;
  private final UnaryCallSettings<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeSettings;
  private final UnaryCallSettings<GetStoredInfoTypeRequest, StoredInfoType>
      getStoredInfoTypeSettings;
  private final PagedCallSettings<
          ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesSettings;
  private final UnaryCallSettings<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeSettings;
  private final PagedCallSettings<
          ListProjectDataProfilesRequest,
          ListProjectDataProfilesResponse,
          ListProjectDataProfilesPagedResponse>
      listProjectDataProfilesSettings;
  private final PagedCallSettings<
          ListTableDataProfilesRequest,
          ListTableDataProfilesResponse,
          ListTableDataProfilesPagedResponse>
      listTableDataProfilesSettings;
  private final PagedCallSettings<
          ListColumnDataProfilesRequest,
          ListColumnDataProfilesResponse,
          ListColumnDataProfilesPagedResponse>
      listColumnDataProfilesSettings;
  private final UnaryCallSettings<GetProjectDataProfileRequest, ProjectDataProfile>
      getProjectDataProfileSettings;
  private final UnaryCallSettings<GetTableDataProfileRequest, TableDataProfile>
      getTableDataProfileSettings;
  private final UnaryCallSettings<GetColumnDataProfileRequest, ColumnDataProfile>
      getColumnDataProfileSettings;
  private final UnaryCallSettings<DeleteTableDataProfileRequest, Empty>
      deleteTableDataProfileSettings;
  private final UnaryCallSettings<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobSettings;
  private final UnaryCallSettings<FinishDlpJobRequest, Empty> finishDlpJobSettings;
  private final UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings;
  private final UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings;
  private final PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings;
  private final PagedCallSettings<
          SearchConnectionsRequest, SearchConnectionsResponse, SearchConnectionsPagedResponse>
      searchConnectionsSettings;
  private final UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings;
  private final UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings;

  private static final PagedListDescriptor<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
      LIST_INSPECT_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInspectTemplatesRequest injectToken(
                ListInspectTemplatesRequest payload, String token) {
              return ListInspectTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInspectTemplatesRequest injectPageSize(
                ListInspectTemplatesRequest payload, int pageSize) {
              return ListInspectTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInspectTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInspectTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InspectTemplate> extractResources(
                ListInspectTemplatesResponse payload) {
              return payload.getInspectTemplatesList() == null
                  ? ImmutableList.<InspectTemplate>of()
                  : payload.getInspectTemplatesList();
            }
          };

  private static final PagedListDescriptor<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
      LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeidentifyTemplatesRequest,
              ListDeidentifyTemplatesResponse,
              DeidentifyTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeidentifyTemplatesRequest injectToken(
                ListDeidentifyTemplatesRequest payload, String token) {
              return ListDeidentifyTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeidentifyTemplatesRequest injectPageSize(
                ListDeidentifyTemplatesRequest payload, int pageSize) {
              return ListDeidentifyTemplatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDeidentifyTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeidentifyTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeidentifyTemplate> extractResources(
                ListDeidentifyTemplatesResponse payload) {
              return payload.getDeidentifyTemplatesList() == null
                  ? ImmutableList.<DeidentifyTemplate>of()
                  : payload.getDeidentifyTemplatesList();
            }
          };

  private static final PagedListDescriptor<
          ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger>
      LIST_JOB_TRIGGERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobTriggersRequest injectToken(
                ListJobTriggersRequest payload, String token) {
              return ListJobTriggersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobTriggersRequest injectPageSize(
                ListJobTriggersRequest payload, int pageSize) {
              return ListJobTriggersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobTriggersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobTriggersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<JobTrigger> extractResources(ListJobTriggersResponse payload) {
              return payload.getJobTriggersList() == null
                  ? ImmutableList.<JobTrigger>of()
                  : payload.getJobTriggersList();
            }
          };

  private static final PagedListDescriptor<
          ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse, DiscoveryConfig>
      LIST_DISCOVERY_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse, DiscoveryConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveryConfigsRequest injectToken(
                ListDiscoveryConfigsRequest payload, String token) {
              return ListDiscoveryConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiscoveryConfigsRequest injectPageSize(
                ListDiscoveryConfigsRequest payload, int pageSize) {
              return ListDiscoveryConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveryConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveryConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveryConfig> extractResources(
                ListDiscoveryConfigsResponse payload) {
              return payload.getDiscoveryConfigsList() == null
                  ? ImmutableList.<DiscoveryConfig>of()
                  : payload.getDiscoveryConfigsList();
            }
          };

  private static final PagedListDescriptor<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob>
      LIST_DLP_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDlpJobsRequest injectToken(ListDlpJobsRequest payload, String token) {
              return ListDlpJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDlpJobsRequest injectPageSize(ListDlpJobsRequest payload, int pageSize) {
              return ListDlpJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDlpJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDlpJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DlpJob> extractResources(ListDlpJobsResponse payload) {
              return payload.getJobsList() == null
                  ? ImmutableList.<DlpJob>of()
                  : payload.getJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
      LIST_STORED_INFO_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStoredInfoTypesRequest injectToken(
                ListStoredInfoTypesRequest payload, String token) {
              return ListStoredInfoTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStoredInfoTypesRequest injectPageSize(
                ListStoredInfoTypesRequest payload, int pageSize) {
              return ListStoredInfoTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStoredInfoTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStoredInfoTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StoredInfoType> extractResources(ListStoredInfoTypesResponse payload) {
              return payload.getStoredInfoTypesList() == null
                  ? ImmutableList.<StoredInfoType>of()
                  : payload.getStoredInfoTypesList();
            }
          };

  private static final PagedListDescriptor<
          ListProjectDataProfilesRequest, ListProjectDataProfilesResponse, ProjectDataProfile>
      LIST_PROJECT_DATA_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProjectDataProfilesRequest,
              ListProjectDataProfilesResponse,
              ProjectDataProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProjectDataProfilesRequest injectToken(
                ListProjectDataProfilesRequest payload, String token) {
              return ListProjectDataProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProjectDataProfilesRequest injectPageSize(
                ListProjectDataProfilesRequest payload, int pageSize) {
              return ListProjectDataProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListProjectDataProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProjectDataProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProjectDataProfile> extractResources(
                ListProjectDataProfilesResponse payload) {
              return payload.getProjectDataProfilesList() == null
                  ? ImmutableList.<ProjectDataProfile>of()
                  : payload.getProjectDataProfilesList();
            }
          };

  private static final PagedListDescriptor<
          ListTableDataProfilesRequest, ListTableDataProfilesResponse, TableDataProfile>
      LIST_TABLE_DATA_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTableDataProfilesRequest, ListTableDataProfilesResponse, TableDataProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTableDataProfilesRequest injectToken(
                ListTableDataProfilesRequest payload, String token) {
              return ListTableDataProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTableDataProfilesRequest injectPageSize(
                ListTableDataProfilesRequest payload, int pageSize) {
              return ListTableDataProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTableDataProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTableDataProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TableDataProfile> extractResources(
                ListTableDataProfilesResponse payload) {
              return payload.getTableDataProfilesList() == null
                  ? ImmutableList.<TableDataProfile>of()
                  : payload.getTableDataProfilesList();
            }
          };

  private static final PagedListDescriptor<
          ListColumnDataProfilesRequest, ListColumnDataProfilesResponse, ColumnDataProfile>
      LIST_COLUMN_DATA_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListColumnDataProfilesRequest, ListColumnDataProfilesResponse, ColumnDataProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListColumnDataProfilesRequest injectToken(
                ListColumnDataProfilesRequest payload, String token) {
              return ListColumnDataProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListColumnDataProfilesRequest injectPageSize(
                ListColumnDataProfilesRequest payload, int pageSize) {
              return ListColumnDataProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListColumnDataProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListColumnDataProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ColumnDataProfile> extractResources(
                ListColumnDataProfilesResponse payload) {
              return payload.getColumnDataProfilesList() == null
                  ? ImmutableList.<ColumnDataProfile>of()
                  : payload.getColumnDataProfilesList();
            }
          };

  private static final PagedListDescriptor<
          ListConnectionsRequest, ListConnectionsResponse, Connection>
      LIST_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConnectionsRequest, ListConnectionsResponse, Connection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectionsRequest injectToken(
                ListConnectionsRequest payload, String token) {
              return ListConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectionsRequest injectPageSize(
                ListConnectionsRequest payload, int pageSize) {
              return ListConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connection> extractResources(ListConnectionsResponse payload) {
              return payload.getConnectionsList() == null
                  ? ImmutableList.<Connection>of()
                  : payload.getConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          SearchConnectionsRequest, SearchConnectionsResponse, Connection>
      SEARCH_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchConnectionsRequest, SearchConnectionsResponse, Connection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchConnectionsRequest injectToken(
                SearchConnectionsRequest payload, String token) {
              return SearchConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchConnectionsRequest injectPageSize(
                SearchConnectionsRequest payload, int pageSize) {
              return SearchConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connection> extractResources(SearchConnectionsResponse payload) {
              return payload.getConnectionsList() == null
                  ? ImmutableList.<Connection>of()
                  : payload.getConnectionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      LIST_INSPECT_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInspectTemplatesRequest,
              ListInspectTemplatesResponse,
              ListInspectTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListInspectTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse> callable,
                ListInspectTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListInspectTemplatesResponse> futureResponse) {
              PageContext<
                      ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSPECT_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListInspectTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeidentifyTemplatesRequest,
              ListDeidentifyTemplatesResponse,
              ListDeidentifyTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListDeidentifyTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
                    callable,
                ListDeidentifyTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
              PageContext<
                      ListDeidentifyTemplatesRequest,
                      ListDeidentifyTemplatesResponse,
                      DeidentifyTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListDeidentifyTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>
      LIST_JOB_TRIGGERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>() {
            @Override
            public ApiFuture<ListJobTriggersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse> callable,
                ListJobTriggersRequest request,
                ApiCallContext context,
                ApiFuture<ListJobTriggersResponse> futureResponse) {
              PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> pageContext =
                  PageContext.create(callable, LIST_JOB_TRIGGERS_PAGE_STR_DESC, request, context);
              return ListJobTriggersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiscoveryConfigsRequest,
          ListDiscoveryConfigsResponse,
          ListDiscoveryConfigsPagedResponse>
      LIST_DISCOVERY_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveryConfigsRequest,
              ListDiscoveryConfigsResponse,
              ListDiscoveryConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveryConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse> callable,
                ListDiscoveryConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveryConfigsResponse> futureResponse) {
              PageContext<
                      ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse, DiscoveryConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISCOVERY_CONFIGS_PAGE_STR_DESC, request, context);
              return ListDiscoveryConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      LIST_DLP_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>() {
            @Override
            public ApiFuture<ListDlpJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> callable,
                ListDlpJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListDlpJobsResponse> futureResponse) {
              PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> pageContext =
                  PageContext.create(callable, LIST_DLP_JOBS_PAGE_STR_DESC, request, context);
              return ListDlpJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, ListStoredInfoTypesPagedResponse>
      LIST_STORED_INFO_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStoredInfoTypesRequest,
              ListStoredInfoTypesResponse,
              ListStoredInfoTypesPagedResponse>() {
            @Override
            public ApiFuture<ListStoredInfoTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse> callable,
                ListStoredInfoTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListStoredInfoTypesResponse> futureResponse) {
              PageContext<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
                  pageContext =
                      PageContext.create(
                          callable, LIST_STORED_INFO_TYPES_PAGE_STR_DESC, request, context);
              return ListStoredInfoTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProjectDataProfilesRequest,
          ListProjectDataProfilesResponse,
          ListProjectDataProfilesPagedResponse>
      LIST_PROJECT_DATA_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProjectDataProfilesRequest,
              ListProjectDataProfilesResponse,
              ListProjectDataProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListProjectDataProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>
                    callable,
                ListProjectDataProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListProjectDataProfilesResponse> futureResponse) {
              PageContext<
                      ListProjectDataProfilesRequest,
                      ListProjectDataProfilesResponse,
                      ProjectDataProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PROJECT_DATA_PROFILES_PAGE_STR_DESC, request, context);
              return ListProjectDataProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTableDataProfilesRequest,
          ListTableDataProfilesResponse,
          ListTableDataProfilesPagedResponse>
      LIST_TABLE_DATA_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTableDataProfilesRequest,
              ListTableDataProfilesResponse,
              ListTableDataProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListTableDataProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTableDataProfilesRequest, ListTableDataProfilesResponse> callable,
                ListTableDataProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListTableDataProfilesResponse> futureResponse) {
              PageContext<
                      ListTableDataProfilesRequest, ListTableDataProfilesResponse, TableDataProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TABLE_DATA_PROFILES_PAGE_STR_DESC, request, context);
              return ListTableDataProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListColumnDataProfilesRequest,
          ListColumnDataProfilesResponse,
          ListColumnDataProfilesPagedResponse>
      LIST_COLUMN_DATA_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListColumnDataProfilesRequest,
              ListColumnDataProfilesResponse,
              ListColumnDataProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListColumnDataProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>
                    callable,
                ListColumnDataProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListColumnDataProfilesResponse> futureResponse) {
              PageContext<
                      ListColumnDataProfilesRequest,
                      ListColumnDataProfilesResponse,
                      ColumnDataProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_COLUMN_DATA_PROFILES_PAGE_STR_DESC, request, context);
              return ListColumnDataProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      LIST_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> callable,
                ListConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectionsResponse> futureResponse) {
              PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> pageContext =
                  PageContext.create(callable, LIST_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchConnectionsRequest, SearchConnectionsResponse, SearchConnectionsPagedResponse>
      SEARCH_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchConnectionsRequest,
              SearchConnectionsResponse,
              SearchConnectionsPagedResponse>() {
            @Override
            public ApiFuture<SearchConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchConnectionsRequest, SearchConnectionsResponse> callable,
                SearchConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<SearchConnectionsResponse> futureResponse) {
              PageContext<SearchConnectionsRequest, SearchConnectionsResponse, Connection>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_CONNECTIONS_PAGE_STR_DESC, request, context);
              return SearchConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to inspectContent. */
  public UnaryCallSettings<InspectContentRequest, InspectContentResponse> inspectContentSettings() {
    return inspectContentSettings;
  }

  /** Returns the object with the settings used for calls to redactImage. */
  public UnaryCallSettings<RedactImageRequest, RedactImageResponse> redactImageSettings() {
    return redactImageSettings;
  }

  /** Returns the object with the settings used for calls to deidentifyContent. */
  public UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings() {
    return deidentifyContentSettings;
  }

  /** Returns the object with the settings used for calls to reidentifyContent. */
  public UnaryCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentSettings() {
    return reidentifyContentSettings;
  }

  /** Returns the object with the settings used for calls to listInfoTypes. */
  public UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesSettings() {
    return listInfoTypesSettings;
  }

  /** Returns the object with the settings used for calls to createInspectTemplate. */
  public UnaryCallSettings<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateSettings() {
    return createInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateInspectTemplate. */
  public UnaryCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateSettings() {
    return updateInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getInspectTemplate. */
  public UnaryCallSettings<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateSettings() {
    return getInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listInspectTemplates. */
  public PagedCallSettings<
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      listInspectTemplatesSettings() {
    return listInspectTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteInspectTemplate. */
  public UnaryCallSettings<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateSettings() {
    return deleteInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createDeidentifyTemplate. */
  public UnaryCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateSettings() {
    return createDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateDeidentifyTemplate. */
  public UnaryCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateSettings() {
    return updateDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getDeidentifyTemplate. */
  public UnaryCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateSettings() {
    return getDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listDeidentifyTemplates. */
  public PagedCallSettings<
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesSettings() {
    return listDeidentifyTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeidentifyTemplate. */
  public UnaryCallSettings<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateSettings() {
    return deleteDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createJobTrigger. */
  public UnaryCallSettings<CreateJobTriggerRequest, JobTrigger> createJobTriggerSettings() {
    return createJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to updateJobTrigger. */
  public UnaryCallSettings<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerSettings() {
    return updateJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to hybridInspectJobTrigger. */
  public UnaryCallSettings<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerSettings() {
    return hybridInspectJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to getJobTrigger. */
  public UnaryCallSettings<GetJobTriggerRequest, JobTrigger> getJobTriggerSettings() {
    return getJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to listJobTriggers. */
  public PagedCallSettings<
          ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>
      listJobTriggersSettings() {
    return listJobTriggersSettings;
  }

  /** Returns the object with the settings used for calls to deleteJobTrigger. */
  public UnaryCallSettings<DeleteJobTriggerRequest, Empty> deleteJobTriggerSettings() {
    return deleteJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to activateJobTrigger. */
  public UnaryCallSettings<ActivateJobTriggerRequest, DlpJob> activateJobTriggerSettings() {
    return activateJobTriggerSettings;
  }

  /** Returns the object with the settings used for calls to createDiscoveryConfig. */
  public UnaryCallSettings<CreateDiscoveryConfigRequest, DiscoveryConfig>
      createDiscoveryConfigSettings() {
    return createDiscoveryConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateDiscoveryConfig. */
  public UnaryCallSettings<UpdateDiscoveryConfigRequest, DiscoveryConfig>
      updateDiscoveryConfigSettings() {
    return updateDiscoveryConfigSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveryConfig. */
  public UnaryCallSettings<GetDiscoveryConfigRequest, DiscoveryConfig>
      getDiscoveryConfigSettings() {
    return getDiscoveryConfigSettings;
  }

  /** Returns the object with the settings used for calls to listDiscoveryConfigs. */
  public PagedCallSettings<
          ListDiscoveryConfigsRequest,
          ListDiscoveryConfigsResponse,
          ListDiscoveryConfigsPagedResponse>
      listDiscoveryConfigsSettings() {
    return listDiscoveryConfigsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDiscoveryConfig. */
  public UnaryCallSettings<DeleteDiscoveryConfigRequest, Empty> deleteDiscoveryConfigSettings() {
    return deleteDiscoveryConfigSettings;
  }

  /** Returns the object with the settings used for calls to createDlpJob. */
  public UnaryCallSettings<CreateDlpJobRequest, DlpJob> createDlpJobSettings() {
    return createDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to listDlpJobs. */
  public PagedCallSettings<ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      listDlpJobsSettings() {
    return listDlpJobsSettings;
  }

  /** Returns the object with the settings used for calls to getDlpJob. */
  public UnaryCallSettings<GetDlpJobRequest, DlpJob> getDlpJobSettings() {
    return getDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteDlpJob. */
  public UnaryCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobSettings() {
    return deleteDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelDlpJob. */
  public UnaryCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobSettings() {
    return cancelDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to createStoredInfoType. */
  public UnaryCallSettings<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeSettings() {
    return createStoredInfoTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateStoredInfoType. */
  public UnaryCallSettings<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeSettings() {
    return updateStoredInfoTypeSettings;
  }

  /** Returns the object with the settings used for calls to getStoredInfoType. */
  public UnaryCallSettings<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeSettings() {
    return getStoredInfoTypeSettings;
  }

  /** Returns the object with the settings used for calls to listStoredInfoTypes. */
  public PagedCallSettings<
          ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesSettings() {
    return listStoredInfoTypesSettings;
  }

  /** Returns the object with the settings used for calls to deleteStoredInfoType. */
  public UnaryCallSettings<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeSettings() {
    return deleteStoredInfoTypeSettings;
  }

  /** Returns the object with the settings used for calls to listProjectDataProfiles. */
  public PagedCallSettings<
          ListProjectDataProfilesRequest,
          ListProjectDataProfilesResponse,
          ListProjectDataProfilesPagedResponse>
      listProjectDataProfilesSettings() {
    return listProjectDataProfilesSettings;
  }

  /** Returns the object with the settings used for calls to listTableDataProfiles. */
  public PagedCallSettings<
          ListTableDataProfilesRequest,
          ListTableDataProfilesResponse,
          ListTableDataProfilesPagedResponse>
      listTableDataProfilesSettings() {
    return listTableDataProfilesSettings;
  }

  /** Returns the object with the settings used for calls to listColumnDataProfiles. */
  public PagedCallSettings<
          ListColumnDataProfilesRequest,
          ListColumnDataProfilesResponse,
          ListColumnDataProfilesPagedResponse>
      listColumnDataProfilesSettings() {
    return listColumnDataProfilesSettings;
  }

  /** Returns the object with the settings used for calls to getProjectDataProfile. */
  public UnaryCallSettings<GetProjectDataProfileRequest, ProjectDataProfile>
      getProjectDataProfileSettings() {
    return getProjectDataProfileSettings;
  }

  /** Returns the object with the settings used for calls to getTableDataProfile. */
  public UnaryCallSettings<GetTableDataProfileRequest, TableDataProfile>
      getTableDataProfileSettings() {
    return getTableDataProfileSettings;
  }

  /** Returns the object with the settings used for calls to getColumnDataProfile. */
  public UnaryCallSettings<GetColumnDataProfileRequest, ColumnDataProfile>
      getColumnDataProfileSettings() {
    return getColumnDataProfileSettings;
  }

  /** Returns the object with the settings used for calls to deleteTableDataProfile. */
  public UnaryCallSettings<DeleteTableDataProfileRequest, Empty> deleteTableDataProfileSettings() {
    return deleteTableDataProfileSettings;
  }

  /** Returns the object with the settings used for calls to hybridInspectDlpJob. */
  public UnaryCallSettings<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobSettings() {
    return hybridInspectDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to finishDlpJob. */
  public UnaryCallSettings<FinishDlpJobRequest, Empty> finishDlpJobSettings() {
    return finishDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings() {
    return createConnectionSettings;
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return getConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return listConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to searchConnections. */
  public PagedCallSettings<
          SearchConnectionsRequest, SearchConnectionsResponse, SearchConnectionsPagedResponse>
      searchConnectionsSettings() {
    return searchConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
    return deleteConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings() {
    return updateConnectionSettings;
  }

  public DlpServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDlpServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDlpServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dlp";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dlp.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dlp.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DlpServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DlpServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DlpServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DlpServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    inspectContentSettings = settingsBuilder.inspectContentSettings().build();
    redactImageSettings = settingsBuilder.redactImageSettings().build();
    deidentifyContentSettings = settingsBuilder.deidentifyContentSettings().build();
    reidentifyContentSettings = settingsBuilder.reidentifyContentSettings().build();
    listInfoTypesSettings = settingsBuilder.listInfoTypesSettings().build();
    createInspectTemplateSettings = settingsBuilder.createInspectTemplateSettings().build();
    updateInspectTemplateSettings = settingsBuilder.updateInspectTemplateSettings().build();
    getInspectTemplateSettings = settingsBuilder.getInspectTemplateSettings().build();
    listInspectTemplatesSettings = settingsBuilder.listInspectTemplatesSettings().build();
    deleteInspectTemplateSettings = settingsBuilder.deleteInspectTemplateSettings().build();
    createDeidentifyTemplateSettings = settingsBuilder.createDeidentifyTemplateSettings().build();
    updateDeidentifyTemplateSettings = settingsBuilder.updateDeidentifyTemplateSettings().build();
    getDeidentifyTemplateSettings = settingsBuilder.getDeidentifyTemplateSettings().build();
    listDeidentifyTemplatesSettings = settingsBuilder.listDeidentifyTemplatesSettings().build();
    deleteDeidentifyTemplateSettings = settingsBuilder.deleteDeidentifyTemplateSettings().build();
    createJobTriggerSettings = settingsBuilder.createJobTriggerSettings().build();
    updateJobTriggerSettings = settingsBuilder.updateJobTriggerSettings().build();
    hybridInspectJobTriggerSettings = settingsBuilder.hybridInspectJobTriggerSettings().build();
    getJobTriggerSettings = settingsBuilder.getJobTriggerSettings().build();
    listJobTriggersSettings = settingsBuilder.listJobTriggersSettings().build();
    deleteJobTriggerSettings = settingsBuilder.deleteJobTriggerSettings().build();
    activateJobTriggerSettings = settingsBuilder.activateJobTriggerSettings().build();
    createDiscoveryConfigSettings = settingsBuilder.createDiscoveryConfigSettings().build();
    updateDiscoveryConfigSettings = settingsBuilder.updateDiscoveryConfigSettings().build();
    getDiscoveryConfigSettings = settingsBuilder.getDiscoveryConfigSettings().build();
    listDiscoveryConfigsSettings = settingsBuilder.listDiscoveryConfigsSettings().build();
    deleteDiscoveryConfigSettings = settingsBuilder.deleteDiscoveryConfigSettings().build();
    createDlpJobSettings = settingsBuilder.createDlpJobSettings().build();
    listDlpJobsSettings = settingsBuilder.listDlpJobsSettings().build();
    getDlpJobSettings = settingsBuilder.getDlpJobSettings().build();
    deleteDlpJobSettings = settingsBuilder.deleteDlpJobSettings().build();
    cancelDlpJobSettings = settingsBuilder.cancelDlpJobSettings().build();
    createStoredInfoTypeSettings = settingsBuilder.createStoredInfoTypeSettings().build();
    updateStoredInfoTypeSettings = settingsBuilder.updateStoredInfoTypeSettings().build();
    getStoredInfoTypeSettings = settingsBuilder.getStoredInfoTypeSettings().build();
    listStoredInfoTypesSettings = settingsBuilder.listStoredInfoTypesSettings().build();
    deleteStoredInfoTypeSettings = settingsBuilder.deleteStoredInfoTypeSettings().build();
    listProjectDataProfilesSettings = settingsBuilder.listProjectDataProfilesSettings().build();
    listTableDataProfilesSettings = settingsBuilder.listTableDataProfilesSettings().build();
    listColumnDataProfilesSettings = settingsBuilder.listColumnDataProfilesSettings().build();
    getProjectDataProfileSettings = settingsBuilder.getProjectDataProfileSettings().build();
    getTableDataProfileSettings = settingsBuilder.getTableDataProfileSettings().build();
    getColumnDataProfileSettings = settingsBuilder.getColumnDataProfileSettings().build();
    deleteTableDataProfileSettings = settingsBuilder.deleteTableDataProfileSettings().build();
    hybridInspectDlpJobSettings = settingsBuilder.hybridInspectDlpJobSettings().build();
    finishDlpJobSettings = settingsBuilder.finishDlpJobSettings().build();
    createConnectionSettings = settingsBuilder.createConnectionSettings().build();
    getConnectionSettings = settingsBuilder.getConnectionSettings().build();
    listConnectionsSettings = settingsBuilder.listConnectionsSettings().build();
    searchConnectionsSettings = settingsBuilder.searchConnectionsSettings().build();
    deleteConnectionSettings = settingsBuilder.deleteConnectionSettings().build();
    updateConnectionSettings = settingsBuilder.updateConnectionSettings().build();
  }

  /** Builder for DlpServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DlpServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings;
    private final UnaryCallSettings.Builder<RedactImageRequest, RedactImageResponse>
        redactImageSettings;
    private final UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings;
    private final UnaryCallSettings.Builder<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentSettings;
    private final UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings;
    private final UnaryCallSettings.Builder<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateSettings;
    private final UnaryCallSettings.Builder<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateSettings;
    private final PagedCallSettings.Builder<
            ListInspectTemplatesRequest,
            ListInspectTemplatesResponse,
            ListInspectTemplatesPagedResponse>
        listInspectTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteInspectTemplateRequest, Empty>
        deleteInspectTemplateSettings;
    private final UnaryCallSettings.Builder<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateSettings;
    private final UnaryCallSettings.Builder<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateSettings;
    private final PagedCallSettings.Builder<
            ListDeidentifyTemplatesRequest,
            ListDeidentifyTemplatesResponse,
            ListDeidentifyTemplatesPagedResponse>
        listDeidentifyTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateSettings;
    private final UnaryCallSettings.Builder<CreateJobTriggerRequest, JobTrigger>
        createJobTriggerSettings;
    private final UnaryCallSettings.Builder<UpdateJobTriggerRequest, JobTrigger>
        updateJobTriggerSettings;
    private final UnaryCallSettings.Builder<HybridInspectJobTriggerRequest, HybridInspectResponse>
        hybridInspectJobTriggerSettings;
    private final UnaryCallSettings.Builder<GetJobTriggerRequest, JobTrigger> getJobTriggerSettings;
    private final PagedCallSettings.Builder<
            ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>
        listJobTriggersSettings;
    private final UnaryCallSettings.Builder<DeleteJobTriggerRequest, Empty>
        deleteJobTriggerSettings;
    private final UnaryCallSettings.Builder<ActivateJobTriggerRequest, DlpJob>
        activateJobTriggerSettings;
    private final UnaryCallSettings.Builder<CreateDiscoveryConfigRequest, DiscoveryConfig>
        createDiscoveryConfigSettings;
    private final UnaryCallSettings.Builder<UpdateDiscoveryConfigRequest, DiscoveryConfig>
        updateDiscoveryConfigSettings;
    private final UnaryCallSettings.Builder<GetDiscoveryConfigRequest, DiscoveryConfig>
        getDiscoveryConfigSettings;
    private final PagedCallSettings.Builder<
            ListDiscoveryConfigsRequest,
            ListDiscoveryConfigsResponse,
            ListDiscoveryConfigsPagedResponse>
        listDiscoveryConfigsSettings;
    private final UnaryCallSettings.Builder<DeleteDiscoveryConfigRequest, Empty>
        deleteDiscoveryConfigSettings;
    private final UnaryCallSettings.Builder<CreateDlpJobRequest, DlpJob> createDlpJobSettings;
    private final PagedCallSettings.Builder<
            ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
        listDlpJobsSettings;
    private final UnaryCallSettings.Builder<GetDlpJobRequest, DlpJob> getDlpJobSettings;
    private final UnaryCallSettings.Builder<DeleteDlpJobRequest, Empty> deleteDlpJobSettings;
    private final UnaryCallSettings.Builder<CancelDlpJobRequest, Empty> cancelDlpJobSettings;
    private final UnaryCallSettings.Builder<CreateStoredInfoTypeRequest, StoredInfoType>
        createStoredInfoTypeSettings;
    private final UnaryCallSettings.Builder<UpdateStoredInfoTypeRequest, StoredInfoType>
        updateStoredInfoTypeSettings;
    private final UnaryCallSettings.Builder<GetStoredInfoTypeRequest, StoredInfoType>
        getStoredInfoTypeSettings;
    private final PagedCallSettings.Builder<
            ListStoredInfoTypesRequest,
            ListStoredInfoTypesResponse,
            ListStoredInfoTypesPagedResponse>
        listStoredInfoTypesSettings;
    private final UnaryCallSettings.Builder<DeleteStoredInfoTypeRequest, Empty>
        deleteStoredInfoTypeSettings;
    private final PagedCallSettings.Builder<
            ListProjectDataProfilesRequest,
            ListProjectDataProfilesResponse,
            ListProjectDataProfilesPagedResponse>
        listProjectDataProfilesSettings;
    private final PagedCallSettings.Builder<
            ListTableDataProfilesRequest,
            ListTableDataProfilesResponse,
            ListTableDataProfilesPagedResponse>
        listTableDataProfilesSettings;
    private final PagedCallSettings.Builder<
            ListColumnDataProfilesRequest,
            ListColumnDataProfilesResponse,
            ListColumnDataProfilesPagedResponse>
        listColumnDataProfilesSettings;
    private final UnaryCallSettings.Builder<GetProjectDataProfileRequest, ProjectDataProfile>
        getProjectDataProfileSettings;
    private final UnaryCallSettings.Builder<GetTableDataProfileRequest, TableDataProfile>
        getTableDataProfileSettings;
    private final UnaryCallSettings.Builder<GetColumnDataProfileRequest, ColumnDataProfile>
        getColumnDataProfileSettings;
    private final UnaryCallSettings.Builder<DeleteTableDataProfileRequest, Empty>
        deleteTableDataProfileSettings;
    private final UnaryCallSettings.Builder<HybridInspectDlpJobRequest, HybridInspectResponse>
        hybridInspectDlpJobSettings;
    private final UnaryCallSettings.Builder<FinishDlpJobRequest, Empty> finishDlpJobSettings;
    private final UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings;
    private final UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings;
    private final PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings;
    private final PagedCallSettings.Builder<
            SearchConnectionsRequest, SearchConnectionsResponse, SearchConnectionsPagedResponse>
        searchConnectionsSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionRequest, Empty>
        deleteConnectionSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings;
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
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
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

      inspectContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      redactImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deidentifyContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reidentifyContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInfoTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInspectTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_INSPECT_TEMPLATES_PAGE_STR_FACT);
      deleteInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeidentifyTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_FACT);
      deleteDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      hybridInspectJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listJobTriggersSettings = PagedCallSettings.newBuilder(LIST_JOB_TRIGGERS_PAGE_STR_FACT);
      deleteJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      activateJobTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDiscoveryConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDiscoveryConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDiscoveryConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDiscoveryConfigsSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERY_CONFIGS_PAGE_STR_FACT);
      deleteDiscoveryConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDlpJobsSettings = PagedCallSettings.newBuilder(LIST_DLP_JOBS_PAGE_STR_FACT);
      getDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStoredInfoTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateStoredInfoTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getStoredInfoTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStoredInfoTypesSettings =
          PagedCallSettings.newBuilder(LIST_STORED_INFO_TYPES_PAGE_STR_FACT);
      deleteStoredInfoTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProjectDataProfilesSettings =
          PagedCallSettings.newBuilder(LIST_PROJECT_DATA_PROFILES_PAGE_STR_FACT);
      listTableDataProfilesSettings =
          PagedCallSettings.newBuilder(LIST_TABLE_DATA_PROFILES_PAGE_STR_FACT);
      listColumnDataProfilesSettings =
          PagedCallSettings.newBuilder(LIST_COLUMN_DATA_PROFILES_PAGE_STR_FACT);
      getProjectDataProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTableDataProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getColumnDataProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTableDataProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      hybridInspectDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      finishDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConnectionsSettings = PagedCallSettings.newBuilder(LIST_CONNECTIONS_PAGE_STR_FACT);
      searchConnectionsSettings = PagedCallSettings.newBuilder(SEARCH_CONNECTIONS_PAGE_STR_FACT);
      deleteConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              inspectContentSettings,
              redactImageSettings,
              deidentifyContentSettings,
              reidentifyContentSettings,
              listInfoTypesSettings,
              createInspectTemplateSettings,
              updateInspectTemplateSettings,
              getInspectTemplateSettings,
              listInspectTemplatesSettings,
              deleteInspectTemplateSettings,
              createDeidentifyTemplateSettings,
              updateDeidentifyTemplateSettings,
              getDeidentifyTemplateSettings,
              listDeidentifyTemplatesSettings,
              deleteDeidentifyTemplateSettings,
              createJobTriggerSettings,
              updateJobTriggerSettings,
              hybridInspectJobTriggerSettings,
              getJobTriggerSettings,
              listJobTriggersSettings,
              deleteJobTriggerSettings,
              activateJobTriggerSettings,
              createDiscoveryConfigSettings,
              updateDiscoveryConfigSettings,
              getDiscoveryConfigSettings,
              listDiscoveryConfigsSettings,
              deleteDiscoveryConfigSettings,
              createDlpJobSettings,
              listDlpJobsSettings,
              getDlpJobSettings,
              deleteDlpJobSettings,
              cancelDlpJobSettings,
              createStoredInfoTypeSettings,
              updateStoredInfoTypeSettings,
              getStoredInfoTypeSettings,
              listStoredInfoTypesSettings,
              deleteStoredInfoTypeSettings,
              listProjectDataProfilesSettings,
              listTableDataProfilesSettings,
              listColumnDataProfilesSettings,
              getProjectDataProfileSettings,
              getTableDataProfileSettings,
              getColumnDataProfileSettings,
              deleteTableDataProfileSettings,
              hybridInspectDlpJobSettings,
              finishDlpJobSettings,
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              searchConnectionsSettings,
              deleteConnectionSettings,
              updateConnectionSettings);
      initDefaults(this);
    }

    protected Builder(DlpServiceStubSettings settings) {
      super(settings);

      inspectContentSettings = settings.inspectContentSettings.toBuilder();
      redactImageSettings = settings.redactImageSettings.toBuilder();
      deidentifyContentSettings = settings.deidentifyContentSettings.toBuilder();
      reidentifyContentSettings = settings.reidentifyContentSettings.toBuilder();
      listInfoTypesSettings = settings.listInfoTypesSettings.toBuilder();
      createInspectTemplateSettings = settings.createInspectTemplateSettings.toBuilder();
      updateInspectTemplateSettings = settings.updateInspectTemplateSettings.toBuilder();
      getInspectTemplateSettings = settings.getInspectTemplateSettings.toBuilder();
      listInspectTemplatesSettings = settings.listInspectTemplatesSettings.toBuilder();
      deleteInspectTemplateSettings = settings.deleteInspectTemplateSettings.toBuilder();
      createDeidentifyTemplateSettings = settings.createDeidentifyTemplateSettings.toBuilder();
      updateDeidentifyTemplateSettings = settings.updateDeidentifyTemplateSettings.toBuilder();
      getDeidentifyTemplateSettings = settings.getDeidentifyTemplateSettings.toBuilder();
      listDeidentifyTemplatesSettings = settings.listDeidentifyTemplatesSettings.toBuilder();
      deleteDeidentifyTemplateSettings = settings.deleteDeidentifyTemplateSettings.toBuilder();
      createJobTriggerSettings = settings.createJobTriggerSettings.toBuilder();
      updateJobTriggerSettings = settings.updateJobTriggerSettings.toBuilder();
      hybridInspectJobTriggerSettings = settings.hybridInspectJobTriggerSettings.toBuilder();
      getJobTriggerSettings = settings.getJobTriggerSettings.toBuilder();
      listJobTriggersSettings = settings.listJobTriggersSettings.toBuilder();
      deleteJobTriggerSettings = settings.deleteJobTriggerSettings.toBuilder();
      activateJobTriggerSettings = settings.activateJobTriggerSettings.toBuilder();
      createDiscoveryConfigSettings = settings.createDiscoveryConfigSettings.toBuilder();
      updateDiscoveryConfigSettings = settings.updateDiscoveryConfigSettings.toBuilder();
      getDiscoveryConfigSettings = settings.getDiscoveryConfigSettings.toBuilder();
      listDiscoveryConfigsSettings = settings.listDiscoveryConfigsSettings.toBuilder();
      deleteDiscoveryConfigSettings = settings.deleteDiscoveryConfigSettings.toBuilder();
      createDlpJobSettings = settings.createDlpJobSettings.toBuilder();
      listDlpJobsSettings = settings.listDlpJobsSettings.toBuilder();
      getDlpJobSettings = settings.getDlpJobSettings.toBuilder();
      deleteDlpJobSettings = settings.deleteDlpJobSettings.toBuilder();
      cancelDlpJobSettings = settings.cancelDlpJobSettings.toBuilder();
      createStoredInfoTypeSettings = settings.createStoredInfoTypeSettings.toBuilder();
      updateStoredInfoTypeSettings = settings.updateStoredInfoTypeSettings.toBuilder();
      getStoredInfoTypeSettings = settings.getStoredInfoTypeSettings.toBuilder();
      listStoredInfoTypesSettings = settings.listStoredInfoTypesSettings.toBuilder();
      deleteStoredInfoTypeSettings = settings.deleteStoredInfoTypeSettings.toBuilder();
      listProjectDataProfilesSettings = settings.listProjectDataProfilesSettings.toBuilder();
      listTableDataProfilesSettings = settings.listTableDataProfilesSettings.toBuilder();
      listColumnDataProfilesSettings = settings.listColumnDataProfilesSettings.toBuilder();
      getProjectDataProfileSettings = settings.getProjectDataProfileSettings.toBuilder();
      getTableDataProfileSettings = settings.getTableDataProfileSettings.toBuilder();
      getColumnDataProfileSettings = settings.getColumnDataProfileSettings.toBuilder();
      deleteTableDataProfileSettings = settings.deleteTableDataProfileSettings.toBuilder();
      hybridInspectDlpJobSettings = settings.hybridInspectDlpJobSettings.toBuilder();
      finishDlpJobSettings = settings.finishDlpJobSettings.toBuilder();
      createConnectionSettings = settings.createConnectionSettings.toBuilder();
      getConnectionSettings = settings.getConnectionSettings.toBuilder();
      listConnectionsSettings = settings.listConnectionsSettings.toBuilder();
      searchConnectionsSettings = settings.searchConnectionsSettings.toBuilder();
      deleteConnectionSettings = settings.deleteConnectionSettings.toBuilder();
      updateConnectionSettings = settings.updateConnectionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              inspectContentSettings,
              redactImageSettings,
              deidentifyContentSettings,
              reidentifyContentSettings,
              listInfoTypesSettings,
              createInspectTemplateSettings,
              updateInspectTemplateSettings,
              getInspectTemplateSettings,
              listInspectTemplatesSettings,
              deleteInspectTemplateSettings,
              createDeidentifyTemplateSettings,
              updateDeidentifyTemplateSettings,
              getDeidentifyTemplateSettings,
              listDeidentifyTemplatesSettings,
              deleteDeidentifyTemplateSettings,
              createJobTriggerSettings,
              updateJobTriggerSettings,
              hybridInspectJobTriggerSettings,
              getJobTriggerSettings,
              listJobTriggersSettings,
              deleteJobTriggerSettings,
              activateJobTriggerSettings,
              createDiscoveryConfigSettings,
              updateDiscoveryConfigSettings,
              getDiscoveryConfigSettings,
              listDiscoveryConfigsSettings,
              deleteDiscoveryConfigSettings,
              createDlpJobSettings,
              listDlpJobsSettings,
              getDlpJobSettings,
              deleteDlpJobSettings,
              cancelDlpJobSettings,
              createStoredInfoTypeSettings,
              updateStoredInfoTypeSettings,
              getStoredInfoTypeSettings,
              listStoredInfoTypesSettings,
              deleteStoredInfoTypeSettings,
              listProjectDataProfilesSettings,
              listTableDataProfilesSettings,
              listColumnDataProfilesSettings,
              getProjectDataProfileSettings,
              getTableDataProfileSettings,
              getColumnDataProfileSettings,
              deleteTableDataProfileSettings,
              hybridInspectDlpJobSettings,
              finishDlpJobSettings,
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              searchConnectionsSettings,
              deleteConnectionSettings,
              updateConnectionSettings);
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
          .inspectContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .redactImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deidentifyContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reidentifyContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInspectTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDeidentifyTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .hybridInspectJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listJobTriggersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .activateJobTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createDiscoveryConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDiscoveryConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDiscoveryConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDiscoveryConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDiscoveryConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDlpJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createStoredInfoTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateStoredInfoTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getStoredInfoTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listStoredInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteStoredInfoTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listProjectDataProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTableDataProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listColumnDataProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getProjectDataProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTableDataProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getColumnDataProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTableDataProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .hybridInspectDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .finishDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to inspectContent. */
    public UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings() {
      return inspectContentSettings;
    }

    /** Returns the builder for the settings used for calls to redactImage. */
    public UnaryCallSettings.Builder<RedactImageRequest, RedactImageResponse>
        redactImageSettings() {
      return redactImageSettings;
    }

    /** Returns the builder for the settings used for calls to deidentifyContent. */
    public UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings() {
      return deidentifyContentSettings;
    }

    /** Returns the builder for the settings used for calls to reidentifyContent. */
    public UnaryCallSettings.Builder<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentSettings() {
      return reidentifyContentSettings;
    }

    /** Returns the builder for the settings used for calls to listInfoTypes. */
    public UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings() {
      return listInfoTypesSettings;
    }

    /** Returns the builder for the settings used for calls to createInspectTemplate. */
    public UnaryCallSettings.Builder<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateSettings() {
      return createInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateInspectTemplate. */
    public UnaryCallSettings.Builder<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateSettings() {
      return updateInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getInspectTemplate. */
    public UnaryCallSettings.Builder<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateSettings() {
      return getInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listInspectTemplates. */
    public PagedCallSettings.Builder<
            ListInspectTemplatesRequest,
            ListInspectTemplatesResponse,
            ListInspectTemplatesPagedResponse>
        listInspectTemplatesSettings() {
      return listInspectTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInspectTemplate. */
    public UnaryCallSettings.Builder<DeleteInspectTemplateRequest, Empty>
        deleteInspectTemplateSettings() {
      return deleteInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createDeidentifyTemplate. */
    public UnaryCallSettings.Builder<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateSettings() {
      return createDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeidentifyTemplate. */
    public UnaryCallSettings.Builder<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateSettings() {
      return updateDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getDeidentifyTemplate. */
    public UnaryCallSettings.Builder<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateSettings() {
      return getDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listDeidentifyTemplates. */
    public PagedCallSettings.Builder<
            ListDeidentifyTemplatesRequest,
            ListDeidentifyTemplatesResponse,
            ListDeidentifyTemplatesPagedResponse>
        listDeidentifyTemplatesSettings() {
      return listDeidentifyTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeidentifyTemplate. */
    public UnaryCallSettings.Builder<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateSettings() {
      return deleteDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createJobTrigger. */
    public UnaryCallSettings.Builder<CreateJobTriggerRequest, JobTrigger>
        createJobTriggerSettings() {
      return createJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to updateJobTrigger. */
    public UnaryCallSettings.Builder<UpdateJobTriggerRequest, JobTrigger>
        updateJobTriggerSettings() {
      return updateJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to hybridInspectJobTrigger. */
    public UnaryCallSettings.Builder<HybridInspectJobTriggerRequest, HybridInspectResponse>
        hybridInspectJobTriggerSettings() {
      return hybridInspectJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to getJobTrigger. */
    public UnaryCallSettings.Builder<GetJobTriggerRequest, JobTrigger> getJobTriggerSettings() {
      return getJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to listJobTriggers. */
    public PagedCallSettings.Builder<
            ListJobTriggersRequest, ListJobTriggersResponse, ListJobTriggersPagedResponse>
        listJobTriggersSettings() {
      return listJobTriggersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJobTrigger. */
    public UnaryCallSettings.Builder<DeleteJobTriggerRequest, Empty> deleteJobTriggerSettings() {
      return deleteJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to activateJobTrigger. */
    public UnaryCallSettings.Builder<ActivateJobTriggerRequest, DlpJob>
        activateJobTriggerSettings() {
      return activateJobTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to createDiscoveryConfig. */
    public UnaryCallSettings.Builder<CreateDiscoveryConfigRequest, DiscoveryConfig>
        createDiscoveryConfigSettings() {
      return createDiscoveryConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateDiscoveryConfig. */
    public UnaryCallSettings.Builder<UpdateDiscoveryConfigRequest, DiscoveryConfig>
        updateDiscoveryConfigSettings() {
      return updateDiscoveryConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveryConfig. */
    public UnaryCallSettings.Builder<GetDiscoveryConfigRequest, DiscoveryConfig>
        getDiscoveryConfigSettings() {
      return getDiscoveryConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listDiscoveryConfigs. */
    public PagedCallSettings.Builder<
            ListDiscoveryConfigsRequest,
            ListDiscoveryConfigsResponse,
            ListDiscoveryConfigsPagedResponse>
        listDiscoveryConfigsSettings() {
      return listDiscoveryConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDiscoveryConfig. */
    public UnaryCallSettings.Builder<DeleteDiscoveryConfigRequest, Empty>
        deleteDiscoveryConfigSettings() {
      return deleteDiscoveryConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createDlpJob. */
    public UnaryCallSettings.Builder<CreateDlpJobRequest, DlpJob> createDlpJobSettings() {
      return createDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to listDlpJobs. */
    public PagedCallSettings.Builder<
            ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
        listDlpJobsSettings() {
      return listDlpJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getDlpJob. */
    public UnaryCallSettings.Builder<GetDlpJobRequest, DlpJob> getDlpJobSettings() {
      return getDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDlpJob. */
    public UnaryCallSettings.Builder<DeleteDlpJobRequest, Empty> deleteDlpJobSettings() {
      return deleteDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelDlpJob. */
    public UnaryCallSettings.Builder<CancelDlpJobRequest, Empty> cancelDlpJobSettings() {
      return cancelDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to createStoredInfoType. */
    public UnaryCallSettings.Builder<CreateStoredInfoTypeRequest, StoredInfoType>
        createStoredInfoTypeSettings() {
      return createStoredInfoTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateStoredInfoType. */
    public UnaryCallSettings.Builder<UpdateStoredInfoTypeRequest, StoredInfoType>
        updateStoredInfoTypeSettings() {
      return updateStoredInfoTypeSettings;
    }

    /** Returns the builder for the settings used for calls to getStoredInfoType. */
    public UnaryCallSettings.Builder<GetStoredInfoTypeRequest, StoredInfoType>
        getStoredInfoTypeSettings() {
      return getStoredInfoTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listStoredInfoTypes. */
    public PagedCallSettings.Builder<
            ListStoredInfoTypesRequest,
            ListStoredInfoTypesResponse,
            ListStoredInfoTypesPagedResponse>
        listStoredInfoTypesSettings() {
      return listStoredInfoTypesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStoredInfoType. */
    public UnaryCallSettings.Builder<DeleteStoredInfoTypeRequest, Empty>
        deleteStoredInfoTypeSettings() {
      return deleteStoredInfoTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listProjectDataProfiles. */
    public PagedCallSettings.Builder<
            ListProjectDataProfilesRequest,
            ListProjectDataProfilesResponse,
            ListProjectDataProfilesPagedResponse>
        listProjectDataProfilesSettings() {
      return listProjectDataProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to listTableDataProfiles. */
    public PagedCallSettings.Builder<
            ListTableDataProfilesRequest,
            ListTableDataProfilesResponse,
            ListTableDataProfilesPagedResponse>
        listTableDataProfilesSettings() {
      return listTableDataProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to listColumnDataProfiles. */
    public PagedCallSettings.Builder<
            ListColumnDataProfilesRequest,
            ListColumnDataProfilesResponse,
            ListColumnDataProfilesPagedResponse>
        listColumnDataProfilesSettings() {
      return listColumnDataProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to getProjectDataProfile. */
    public UnaryCallSettings.Builder<GetProjectDataProfileRequest, ProjectDataProfile>
        getProjectDataProfileSettings() {
      return getProjectDataProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getTableDataProfile. */
    public UnaryCallSettings.Builder<GetTableDataProfileRequest, TableDataProfile>
        getTableDataProfileSettings() {
      return getTableDataProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getColumnDataProfile. */
    public UnaryCallSettings.Builder<GetColumnDataProfileRequest, ColumnDataProfile>
        getColumnDataProfileSettings() {
      return getColumnDataProfileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTableDataProfile. */
    public UnaryCallSettings.Builder<DeleteTableDataProfileRequest, Empty>
        deleteTableDataProfileSettings() {
      return deleteTableDataProfileSettings;
    }

    /** Returns the builder for the settings used for calls to hybridInspectDlpJob. */
    public UnaryCallSettings.Builder<HybridInspectDlpJobRequest, HybridInspectResponse>
        hybridInspectDlpJobSettings() {
      return hybridInspectDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to finishDlpJob. */
    public UnaryCallSettings.Builder<FinishDlpJobRequest, Empty> finishDlpJobSettings() {
      return finishDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings() {
      return createConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return listConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to searchConnections. */
    public PagedCallSettings.Builder<
            SearchConnectionsRequest, SearchConnectionsResponse, SearchConnectionsPagedResponse>
        searchConnectionsSettings() {
      return searchConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
      return deleteConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings() {
      return updateConnectionSettings;
    }

    @Override
    public DlpServiceStubSettings build() throws IOException {
      return new DlpServiceStubSettings(this);
    }
  }
}
