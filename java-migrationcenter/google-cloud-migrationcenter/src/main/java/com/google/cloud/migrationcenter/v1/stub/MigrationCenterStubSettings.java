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

package com.google.cloud.migrationcenter.v1.stub;

import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListErrorFramesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListGroupsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportDataFilesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportJobsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListPreferenceSetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportConfigsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListSourcesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest;
import com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest;
import com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse;
import com.google.cloud.migrationcenter.v1.Asset;
import com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest;
import com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest;
import com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse;
import com.google.cloud.migrationcenter.v1.CreateGroupRequest;
import com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.CreateImportJobRequest;
import com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.CreateReportConfigRequest;
import com.google.cloud.migrationcenter.v1.CreateReportRequest;
import com.google.cloud.migrationcenter.v1.CreateSourceRequest;
import com.google.cloud.migrationcenter.v1.DeleteAssetRequest;
import com.google.cloud.migrationcenter.v1.DeleteGroupRequest;
import com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.DeleteImportJobRequest;
import com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest;
import com.google.cloud.migrationcenter.v1.DeleteReportRequest;
import com.google.cloud.migrationcenter.v1.DeleteSourceRequest;
import com.google.cloud.migrationcenter.v1.ErrorFrame;
import com.google.cloud.migrationcenter.v1.GetAssetRequest;
import com.google.cloud.migrationcenter.v1.GetErrorFrameRequest;
import com.google.cloud.migrationcenter.v1.GetGroupRequest;
import com.google.cloud.migrationcenter.v1.GetImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.GetImportJobRequest;
import com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.GetReportConfigRequest;
import com.google.cloud.migrationcenter.v1.GetReportRequest;
import com.google.cloud.migrationcenter.v1.GetSettingsRequest;
import com.google.cloud.migrationcenter.v1.GetSourceRequest;
import com.google.cloud.migrationcenter.v1.Group;
import com.google.cloud.migrationcenter.v1.ImportDataFile;
import com.google.cloud.migrationcenter.v1.ImportJob;
import com.google.cloud.migrationcenter.v1.ListAssetsRequest;
import com.google.cloud.migrationcenter.v1.ListAssetsResponse;
import com.google.cloud.migrationcenter.v1.ListErrorFramesRequest;
import com.google.cloud.migrationcenter.v1.ListErrorFramesResponse;
import com.google.cloud.migrationcenter.v1.ListGroupsRequest;
import com.google.cloud.migrationcenter.v1.ListGroupsResponse;
import com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest;
import com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse;
import com.google.cloud.migrationcenter.v1.ListImportJobsRequest;
import com.google.cloud.migrationcenter.v1.ListImportJobsResponse;
import com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest;
import com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse;
import com.google.cloud.migrationcenter.v1.ListReportConfigsRequest;
import com.google.cloud.migrationcenter.v1.ListReportConfigsResponse;
import com.google.cloud.migrationcenter.v1.ListReportsRequest;
import com.google.cloud.migrationcenter.v1.ListReportsResponse;
import com.google.cloud.migrationcenter.v1.ListSourcesRequest;
import com.google.cloud.migrationcenter.v1.ListSourcesResponse;
import com.google.cloud.migrationcenter.v1.OperationMetadata;
import com.google.cloud.migrationcenter.v1.PreferenceSet;
import com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest;
import com.google.cloud.migrationcenter.v1.Report;
import com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest;
import com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse;
import com.google.cloud.migrationcenter.v1.ReportConfig;
import com.google.cloud.migrationcenter.v1.RunImportJobRequest;
import com.google.cloud.migrationcenter.v1.Settings;
import com.google.cloud.migrationcenter.v1.Source;
import com.google.cloud.migrationcenter.v1.UpdateAssetRequest;
import com.google.cloud.migrationcenter.v1.UpdateGroupRequest;
import com.google.cloud.migrationcenter.v1.UpdateImportJobRequest;
import com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.UpdateSettingsRequest;
import com.google.cloud.migrationcenter.v1.UpdateSourceRequest;
import com.google.cloud.migrationcenter.v1.ValidateImportJobRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MigrationCenterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (migrationcenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAsset to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MigrationCenterStubSettings.Builder migrationCenterSettingsBuilder =
 *     MigrationCenterStubSettings.newBuilder();
 * migrationCenterSettingsBuilder
 *     .getAssetSettings()
 *     .setRetrySettings(
 *         migrationCenterSettingsBuilder
 *             .getAssetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationCenterStubSettings migrationCenterSettings = migrationCenterSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MigrationCenterStubSettings extends StubSettings<MigrationCenterStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings;
  private final UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings;
  private final UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings;
  private final UnaryCallSettings<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsSettings;
  private final UnaryCallSettings<DeleteAssetRequest, Empty> deleteAssetSettings;
  private final UnaryCallSettings<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsSettings;
  private final UnaryCallSettings<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesSettings;
  private final UnaryCallSettings<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesSettings;
  private final UnaryCallSettings<CreateImportJobRequest, Operation> createImportJobSettings;
  private final OperationCallSettings<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationSettings;
  private final PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings;
  private final UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings;
  private final UnaryCallSettings<DeleteImportJobRequest, Operation> deleteImportJobSettings;
  private final OperationCallSettings<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationSettings;
  private final UnaryCallSettings<UpdateImportJobRequest, Operation> updateImportJobSettings;
  private final OperationCallSettings<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationSettings;
  private final UnaryCallSettings<ValidateImportJobRequest, Operation> validateImportJobSettings;
  private final OperationCallSettings<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationSettings;
  private final UnaryCallSettings<RunImportJobRequest, Operation> runImportJobSettings;
  private final OperationCallSettings<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationSettings;
  private final UnaryCallSettings<GetImportDataFileRequest, ImportDataFile>
      getImportDataFileSettings;
  private final PagedCallSettings<
          ListImportDataFilesRequest, ListImportDataFilesResponse, ListImportDataFilesPagedResponse>
      listImportDataFilesSettings;
  private final UnaryCallSettings<CreateImportDataFileRequest, Operation>
      createImportDataFileSettings;
  private final OperationCallSettings<
          CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationSettings;
  private final UnaryCallSettings<DeleteImportDataFileRequest, Operation>
      deleteImportDataFileSettings;
  private final OperationCallSettings<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationSettings;
  private final PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings;
  private final UnaryCallSettings<GetGroupRequest, Group> getGroupSettings;
  private final UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings;
  private final OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings;
  private final UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings;
  private final OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings;
  private final UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings;
  private final OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings;
  private final UnaryCallSettings<AddAssetsToGroupRequest, Operation> addAssetsToGroupSettings;
  private final OperationCallSettings<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationSettings;
  private final UnaryCallSettings<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupSettings;
  private final OperationCallSettings<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationSettings;
  private final PagedCallSettings<
          ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
      listErrorFramesSettings;
  private final UnaryCallSettings<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings;
  private final PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings;
  private final UnaryCallSettings<GetSourceRequest, Source> getSourceSettings;
  private final UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings;
  private final OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings;
  private final UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings;
  private final OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings;
  private final UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings;
  private final OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings;
  private final PagedCallSettings<
          ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
      listPreferenceSetsSettings;
  private final UnaryCallSettings<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetSettings;
  private final UnaryCallSettings<CreatePreferenceSetRequest, Operation>
      createPreferenceSetSettings;
  private final OperationCallSettings<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationSettings;
  private final UnaryCallSettings<UpdatePreferenceSetRequest, Operation>
      updatePreferenceSetSettings;
  private final OperationCallSettings<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationSettings;
  private final UnaryCallSettings<DeletePreferenceSetRequest, Operation>
      deletePreferenceSetSettings;
  private final OperationCallSettings<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings;
  private final OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings;
  private final UnaryCallSettings<CreateReportConfigRequest, Operation> createReportConfigSettings;
  private final OperationCallSettings<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationSettings;
  private final UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings;
  private final PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings;
  private final UnaryCallSettings<DeleteReportConfigRequest, Operation> deleteReportConfigSettings;
  private final OperationCallSettings<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationSettings;
  private final UnaryCallSettings<CreateReportRequest, Operation> createReportSettings;
  private final OperationCallSettings<CreateReportRequest, Report, OperationMetadata>
      createReportOperationSettings;
  private final UnaryCallSettings<GetReportRequest, Report> getReportSettings;
  private final PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings;
  private final UnaryCallSettings<DeleteReportRequest, Operation> deleteReportSettings;
  private final OperationCallSettings<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>
      LIST_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssetsRequest injectToken(ListAssetsRequest payload, String token) {
              return ListAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssetsRequest injectPageSize(ListAssetsRequest payload, int pageSize) {
              return ListAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Asset> extractResources(ListAssetsResponse payload) {
              return payload.getAssetsList() == null
                  ? ImmutableList.<Asset>of()
                  : payload.getAssetsList();
            }
          };

  private static final PagedListDescriptor<ListImportJobsRequest, ListImportJobsResponse, ImportJob>
      LIST_IMPORT_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListImportJobsRequest, ListImportJobsResponse, ImportJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImportJobsRequest injectToken(ListImportJobsRequest payload, String token) {
              return ListImportJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImportJobsRequest injectPageSize(
                ListImportJobsRequest payload, int pageSize) {
              return ListImportJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImportJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListImportJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ImportJob> extractResources(ListImportJobsResponse payload) {
              return payload.getImportJobsList() == null
                  ? ImmutableList.<ImportJob>of()
                  : payload.getImportJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
      LIST_IMPORT_DATA_FILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImportDataFilesRequest injectToken(
                ListImportDataFilesRequest payload, String token) {
              return ListImportDataFilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImportDataFilesRequest injectPageSize(
                ListImportDataFilesRequest payload, int pageSize) {
              return ListImportDataFilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImportDataFilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListImportDataFilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ImportDataFile> extractResources(ListImportDataFilesResponse payload) {
              return payload.getImportDataFilesList() == null
                  ? ImmutableList.<ImportDataFile>of()
                  : payload.getImportDataFilesList();
            }
          };

  private static final PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>
      LIST_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupsRequest injectToken(ListGroupsRequest payload, String token) {
              return ListGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupsRequest injectPageSize(ListGroupsRequest payload, int pageSize) {
              return ListGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Group> extractResources(ListGroupsResponse payload) {
              return payload.getGroupsList() == null
                  ? ImmutableList.<Group>of()
                  : payload.getGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame>
      LIST_ERROR_FRAMES_PAGE_STR_DESC =
          new PagedListDescriptor<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListErrorFramesRequest injectToken(
                ListErrorFramesRequest payload, String token) {
              return ListErrorFramesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListErrorFramesRequest injectPageSize(
                ListErrorFramesRequest payload, int pageSize) {
              return ListErrorFramesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListErrorFramesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListErrorFramesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ErrorFrame> extractResources(ListErrorFramesResponse payload) {
              return payload.getErrorFramesList() == null
                  ? ImmutableList.<ErrorFrame>of()
                  : payload.getErrorFramesList();
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
          ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet>
      LIST_PREFERENCE_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPreferenceSetsRequest injectToken(
                ListPreferenceSetsRequest payload, String token) {
              return ListPreferenceSetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPreferenceSetsRequest injectPageSize(
                ListPreferenceSetsRequest payload, int pageSize) {
              return ListPreferenceSetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPreferenceSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPreferenceSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PreferenceSet> extractResources(ListPreferenceSetsResponse payload) {
              return payload.getPreferenceSetsList() == null
                  ? ImmutableList.<PreferenceSet>of()
                  : payload.getPreferenceSetsList();
            }
          };

  private static final PagedListDescriptor<
          ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>
      LIST_REPORT_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReportConfigsRequest injectToken(
                ListReportConfigsRequest payload, String token) {
              return ListReportConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReportConfigsRequest injectPageSize(
                ListReportConfigsRequest payload, int pageSize) {
              return ListReportConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReportConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReportConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReportConfig> extractResources(ListReportConfigsResponse payload) {
              return payload.getReportConfigsList() == null
                  ? ImmutableList.<ReportConfig>of()
                  : payload.getReportConfigsList();
            }
          };

  private static final PagedListDescriptor<ListReportsRequest, ListReportsResponse, Report>
      LIST_REPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListReportsRequest, ListReportsResponse, Report>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReportsRequest injectToken(ListReportsRequest payload, String token) {
              return ListReportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReportsRequest injectPageSize(ListReportsRequest payload, int pageSize) {
              return ListReportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Report> extractResources(ListReportsResponse payload) {
              return payload.getReportsList() == null
                  ? ImmutableList.<Report>of()
                  : payload.getReportsList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      LIST_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>() {
            @Override
            public ApiFuture<ListAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssetsRequest, ListAssetsResponse> callable,
                ListAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssetsResponse> futureResponse) {
              PageContext<ListAssetsRequest, ListAssetsResponse, Asset> pageContext =
                  PageContext.create(callable, LIST_ASSETS_PAGE_STR_DESC, request, context);
              return ListAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      LIST_IMPORT_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>() {
            @Override
            public ApiFuture<ListImportJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> callable,
                ListImportJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListImportJobsResponse> futureResponse) {
              PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> pageContext =
                  PageContext.create(callable, LIST_IMPORT_JOBS_PAGE_STR_DESC, request, context);
              return ListImportJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListImportDataFilesRequest, ListImportDataFilesResponse, ListImportDataFilesPagedResponse>
      LIST_IMPORT_DATA_FILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImportDataFilesRequest,
              ListImportDataFilesResponse,
              ListImportDataFilesPagedResponse>() {
            @Override
            public ApiFuture<ListImportDataFilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesResponse> callable,
                ListImportDataFilesRequest request,
                ApiCallContext context,
                ApiFuture<ListImportDataFilesResponse> futureResponse) {
              PageContext<ListImportDataFilesRequest, ListImportDataFilesResponse, ImportDataFile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IMPORT_DATA_FILES_PAGE_STR_DESC, request, context);
              return ListImportDataFilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      LIST_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupsRequest, ListGroupsResponse> callable,
                ListGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupsResponse> futureResponse) {
              PageContext<ListGroupsRequest, ListGroupsResponse, Group> pageContext =
                  PageContext.create(callable, LIST_GROUPS_PAGE_STR_DESC, request, context);
              return ListGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
      LIST_ERROR_FRAMES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>() {
            @Override
            public ApiFuture<ListErrorFramesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListErrorFramesRequest, ListErrorFramesResponse> callable,
                ListErrorFramesRequest request,
                ApiCallContext context,
                ApiFuture<ListErrorFramesResponse> futureResponse) {
              PageContext<ListErrorFramesRequest, ListErrorFramesResponse, ErrorFrame> pageContext =
                  PageContext.create(callable, LIST_ERROR_FRAMES_PAGE_STR_DESC, request, context);
              return ListErrorFramesPagedResponse.createAsync(pageContext, futureResponse);
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
          ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
      LIST_PREFERENCE_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPreferenceSetsRequest,
              ListPreferenceSetsResponse,
              ListPreferenceSetsPagedResponse>() {
            @Override
            public ApiFuture<ListPreferenceSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsResponse> callable,
                ListPreferenceSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListPreferenceSetsResponse> futureResponse) {
              PageContext<ListPreferenceSetsRequest, ListPreferenceSetsResponse, PreferenceSet>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PREFERENCE_SETS_PAGE_STR_DESC, request, context);
              return ListPreferenceSetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      LIST_REPORT_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReportConfigsRequest,
              ListReportConfigsResponse,
              ListReportConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListReportConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse> callable,
                ListReportConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListReportConfigsResponse> futureResponse) {
              PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPORT_CONFIGS_PAGE_STR_DESC, request, context);
              return ListReportConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      LIST_REPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>() {
            @Override
            public ApiFuture<ListReportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReportsRequest, ListReportsResponse> callable,
                ListReportsRequest request,
                ApiCallContext context,
                ApiFuture<ListReportsResponse> futureResponse) {
              PageContext<ListReportsRequest, ListReportsResponse, Report> pageContext =
                  PageContext.create(callable, LIST_REPORTS_PAGE_STR_DESC, request, context);
              return ListReportsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return listAssetsSettings;
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return getAssetSettings;
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings() {
    return updateAssetSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateAssets. */
  public UnaryCallSettings<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsSettings() {
    return batchUpdateAssetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Empty> deleteAssetSettings() {
    return deleteAssetSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteAssets. */
  public UnaryCallSettings<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsSettings() {
    return batchDeleteAssetsSettings;
  }

  /** Returns the object with the settings used for calls to reportAssetFrames. */
  public UnaryCallSettings<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesSettings() {
    return reportAssetFramesSettings;
  }

  /** Returns the object with the settings used for calls to aggregateAssetsValues. */
  public UnaryCallSettings<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesSettings() {
    return aggregateAssetsValuesSettings;
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public UnaryCallSettings<CreateImportJobRequest, Operation> createImportJobSettings() {
    return createImportJobSettings;
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public OperationCallSettings<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationSettings() {
    return createImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listImportJobs. */
  public PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings() {
    return listImportJobsSettings;
  }

  /** Returns the object with the settings used for calls to getImportJob. */
  public UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings() {
    return getImportJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteImportJob. */
  public UnaryCallSettings<DeleteImportJobRequest, Operation> deleteImportJobSettings() {
    return deleteImportJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteImportJob. */
  public OperationCallSettings<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationSettings() {
    return deleteImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateImportJob. */
  public UnaryCallSettings<UpdateImportJobRequest, Operation> updateImportJobSettings() {
    return updateImportJobSettings;
  }

  /** Returns the object with the settings used for calls to updateImportJob. */
  public OperationCallSettings<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationSettings() {
    return updateImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to validateImportJob. */
  public UnaryCallSettings<ValidateImportJobRequest, Operation> validateImportJobSettings() {
    return validateImportJobSettings;
  }

  /** Returns the object with the settings used for calls to validateImportJob. */
  public OperationCallSettings<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationSettings() {
    return validateImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to runImportJob. */
  public UnaryCallSettings<RunImportJobRequest, Operation> runImportJobSettings() {
    return runImportJobSettings;
  }

  /** Returns the object with the settings used for calls to runImportJob. */
  public OperationCallSettings<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationSettings() {
    return runImportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to getImportDataFile. */
  public UnaryCallSettings<GetImportDataFileRequest, ImportDataFile> getImportDataFileSettings() {
    return getImportDataFileSettings;
  }

  /** Returns the object with the settings used for calls to listImportDataFiles. */
  public PagedCallSettings<
          ListImportDataFilesRequest, ListImportDataFilesResponse, ListImportDataFilesPagedResponse>
      listImportDataFilesSettings() {
    return listImportDataFilesSettings;
  }

  /** Returns the object with the settings used for calls to createImportDataFile. */
  public UnaryCallSettings<CreateImportDataFileRequest, Operation> createImportDataFileSettings() {
    return createImportDataFileSettings;
  }

  /** Returns the object with the settings used for calls to createImportDataFile. */
  public OperationCallSettings<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationSettings() {
    return createImportDataFileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteImportDataFile. */
  public UnaryCallSettings<DeleteImportDataFileRequest, Operation> deleteImportDataFileSettings() {
    return deleteImportDataFileSettings;
  }

  /** Returns the object with the settings used for calls to deleteImportDataFile. */
  public OperationCallSettings<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationSettings() {
    return deleteImportDataFileOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return listGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return getGroupSettings;
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Operation> createGroupSettings() {
    return createGroupSettings;
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public OperationCallSettings<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationSettings() {
    return createGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Operation> updateGroupSettings() {
    return updateGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public OperationCallSettings<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationSettings() {
    return updateGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Operation> deleteGroupSettings() {
    return deleteGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public OperationCallSettings<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationSettings() {
    return deleteGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to addAssetsToGroup. */
  public UnaryCallSettings<AddAssetsToGroupRequest, Operation> addAssetsToGroupSettings() {
    return addAssetsToGroupSettings;
  }

  /** Returns the object with the settings used for calls to addAssetsToGroup. */
  public OperationCallSettings<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationSettings() {
    return addAssetsToGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeAssetsFromGroup. */
  public UnaryCallSettings<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupSettings() {
    return removeAssetsFromGroupSettings;
  }

  /** Returns the object with the settings used for calls to removeAssetsFromGroup. */
  public OperationCallSettings<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationSettings() {
    return removeAssetsFromGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listErrorFrames. */
  public PagedCallSettings<
          ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
      listErrorFramesSettings() {
    return listErrorFramesSettings;
  }

  /** Returns the object with the settings used for calls to getErrorFrame. */
  public UnaryCallSettings<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings() {
    return getErrorFrameSettings;
  }

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return listSourcesSettings;
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return getSourceSettings;
  }

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Operation> createSourceSettings() {
    return createSourceSettings;
  }

  /** Returns the object with the settings used for calls to createSource. */
  public OperationCallSettings<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationSettings() {
    return createSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Operation> updateSourceSettings() {
    return updateSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public OperationCallSettings<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationSettings() {
    return updateSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public UnaryCallSettings<DeleteSourceRequest, Operation> deleteSourceSettings() {
    return deleteSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteSource. */
  public OperationCallSettings<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationSettings() {
    return deleteSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPreferenceSets. */
  public PagedCallSettings<
          ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
      listPreferenceSetsSettings() {
    return listPreferenceSetsSettings;
  }

  /** Returns the object with the settings used for calls to getPreferenceSet. */
  public UnaryCallSettings<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetSettings() {
    return getPreferenceSetSettings;
  }

  /** Returns the object with the settings used for calls to createPreferenceSet. */
  public UnaryCallSettings<CreatePreferenceSetRequest, Operation> createPreferenceSetSettings() {
    return createPreferenceSetSettings;
  }

  /** Returns the object with the settings used for calls to createPreferenceSet. */
  public OperationCallSettings<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationSettings() {
    return createPreferenceSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePreferenceSet. */
  public UnaryCallSettings<UpdatePreferenceSetRequest, Operation> updatePreferenceSetSettings() {
    return updatePreferenceSetSettings;
  }

  /** Returns the object with the settings used for calls to updatePreferenceSet. */
  public OperationCallSettings<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationSettings() {
    return updatePreferenceSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePreferenceSet. */
  public UnaryCallSettings<DeletePreferenceSetRequest, Operation> deletePreferenceSetSettings() {
    return deletePreferenceSetSettings;
  }

  /** Returns the object with the settings used for calls to deletePreferenceSet. */
  public OperationCallSettings<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationSettings() {
    return deletePreferenceSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings() {
    return updateSettingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public UnaryCallSettings<CreateReportConfigRequest, Operation> createReportConfigSettings() {
    return createReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public OperationCallSettings<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationSettings() {
    return createReportConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getReportConfig. */
  public UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings() {
    return getReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to listReportConfigs. */
  public PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings() {
    return listReportConfigsSettings;
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public UnaryCallSettings<DeleteReportConfigRequest, Operation> deleteReportConfigSettings() {
    return deleteReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public OperationCallSettings<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationSettings() {
    return deleteReportConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to createReport. */
  public UnaryCallSettings<CreateReportRequest, Operation> createReportSettings() {
    return createReportSettings;
  }

  /** Returns the object with the settings used for calls to createReport. */
  public OperationCallSettings<CreateReportRequest, Report, OperationMetadata>
      createReportOperationSettings() {
    return createReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to getReport. */
  public UnaryCallSettings<GetReportRequest, Report> getReportSettings() {
    return getReportSettings;
  }

  /** Returns the object with the settings used for calls to listReports. */
  public PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings() {
    return listReportsSettings;
  }

  /** Returns the object with the settings used for calls to deleteReport. */
  public UnaryCallSettings<DeleteReportRequest, Operation> deleteReportSettings() {
    return deleteReportSettings;
  }

  /** Returns the object with the settings used for calls to deleteReport. */
  public OperationCallSettings<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationSettings() {
    return deleteReportOperationSettings;
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

  public MigrationCenterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMigrationCenterStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMigrationCenterStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "migrationcenter";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "migrationcenter.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "migrationcenter.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MigrationCenterStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MigrationCenterStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MigrationCenterStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MigrationCenterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAssetsSettings = settingsBuilder.listAssetsSettings().build();
    getAssetSettings = settingsBuilder.getAssetSettings().build();
    updateAssetSettings = settingsBuilder.updateAssetSettings().build();
    batchUpdateAssetsSettings = settingsBuilder.batchUpdateAssetsSettings().build();
    deleteAssetSettings = settingsBuilder.deleteAssetSettings().build();
    batchDeleteAssetsSettings = settingsBuilder.batchDeleteAssetsSettings().build();
    reportAssetFramesSettings = settingsBuilder.reportAssetFramesSettings().build();
    aggregateAssetsValuesSettings = settingsBuilder.aggregateAssetsValuesSettings().build();
    createImportJobSettings = settingsBuilder.createImportJobSettings().build();
    createImportJobOperationSettings = settingsBuilder.createImportJobOperationSettings().build();
    listImportJobsSettings = settingsBuilder.listImportJobsSettings().build();
    getImportJobSettings = settingsBuilder.getImportJobSettings().build();
    deleteImportJobSettings = settingsBuilder.deleteImportJobSettings().build();
    deleteImportJobOperationSettings = settingsBuilder.deleteImportJobOperationSettings().build();
    updateImportJobSettings = settingsBuilder.updateImportJobSettings().build();
    updateImportJobOperationSettings = settingsBuilder.updateImportJobOperationSettings().build();
    validateImportJobSettings = settingsBuilder.validateImportJobSettings().build();
    validateImportJobOperationSettings =
        settingsBuilder.validateImportJobOperationSettings().build();
    runImportJobSettings = settingsBuilder.runImportJobSettings().build();
    runImportJobOperationSettings = settingsBuilder.runImportJobOperationSettings().build();
    getImportDataFileSettings = settingsBuilder.getImportDataFileSettings().build();
    listImportDataFilesSettings = settingsBuilder.listImportDataFilesSettings().build();
    createImportDataFileSettings = settingsBuilder.createImportDataFileSettings().build();
    createImportDataFileOperationSettings =
        settingsBuilder.createImportDataFileOperationSettings().build();
    deleteImportDataFileSettings = settingsBuilder.deleteImportDataFileSettings().build();
    deleteImportDataFileOperationSettings =
        settingsBuilder.deleteImportDataFileOperationSettings().build();
    listGroupsSettings = settingsBuilder.listGroupsSettings().build();
    getGroupSettings = settingsBuilder.getGroupSettings().build();
    createGroupSettings = settingsBuilder.createGroupSettings().build();
    createGroupOperationSettings = settingsBuilder.createGroupOperationSettings().build();
    updateGroupSettings = settingsBuilder.updateGroupSettings().build();
    updateGroupOperationSettings = settingsBuilder.updateGroupOperationSettings().build();
    deleteGroupSettings = settingsBuilder.deleteGroupSettings().build();
    deleteGroupOperationSettings = settingsBuilder.deleteGroupOperationSettings().build();
    addAssetsToGroupSettings = settingsBuilder.addAssetsToGroupSettings().build();
    addAssetsToGroupOperationSettings = settingsBuilder.addAssetsToGroupOperationSettings().build();
    removeAssetsFromGroupSettings = settingsBuilder.removeAssetsFromGroupSettings().build();
    removeAssetsFromGroupOperationSettings =
        settingsBuilder.removeAssetsFromGroupOperationSettings().build();
    listErrorFramesSettings = settingsBuilder.listErrorFramesSettings().build();
    getErrorFrameSettings = settingsBuilder.getErrorFrameSettings().build();
    listSourcesSettings = settingsBuilder.listSourcesSettings().build();
    getSourceSettings = settingsBuilder.getSourceSettings().build();
    createSourceSettings = settingsBuilder.createSourceSettings().build();
    createSourceOperationSettings = settingsBuilder.createSourceOperationSettings().build();
    updateSourceSettings = settingsBuilder.updateSourceSettings().build();
    updateSourceOperationSettings = settingsBuilder.updateSourceOperationSettings().build();
    deleteSourceSettings = settingsBuilder.deleteSourceSettings().build();
    deleteSourceOperationSettings = settingsBuilder.deleteSourceOperationSettings().build();
    listPreferenceSetsSettings = settingsBuilder.listPreferenceSetsSettings().build();
    getPreferenceSetSettings = settingsBuilder.getPreferenceSetSettings().build();
    createPreferenceSetSettings = settingsBuilder.createPreferenceSetSettings().build();
    createPreferenceSetOperationSettings =
        settingsBuilder.createPreferenceSetOperationSettings().build();
    updatePreferenceSetSettings = settingsBuilder.updatePreferenceSetSettings().build();
    updatePreferenceSetOperationSettings =
        settingsBuilder.updatePreferenceSetOperationSettings().build();
    deletePreferenceSetSettings = settingsBuilder.deletePreferenceSetSettings().build();
    deletePreferenceSetOperationSettings =
        settingsBuilder.deletePreferenceSetOperationSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    updateSettingsOperationSettings = settingsBuilder.updateSettingsOperationSettings().build();
    createReportConfigSettings = settingsBuilder.createReportConfigSettings().build();
    createReportConfigOperationSettings =
        settingsBuilder.createReportConfigOperationSettings().build();
    getReportConfigSettings = settingsBuilder.getReportConfigSettings().build();
    listReportConfigsSettings = settingsBuilder.listReportConfigsSettings().build();
    deleteReportConfigSettings = settingsBuilder.deleteReportConfigSettings().build();
    deleteReportConfigOperationSettings =
        settingsBuilder.deleteReportConfigOperationSettings().build();
    createReportSettings = settingsBuilder.createReportSettings().build();
    createReportOperationSettings = settingsBuilder.createReportOperationSettings().build();
    getReportSettings = settingsBuilder.getReportSettings().build();
    listReportsSettings = settingsBuilder.listReportsSettings().build();
    deleteReportSettings = settingsBuilder.deleteReportSettings().build();
    deleteReportOperationSettings = settingsBuilder.deleteReportOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for MigrationCenterStubSettings. */
  public static class Builder extends StubSettings.Builder<MigrationCenterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings;
    private final UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings;
    private final UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings;
    private final UnaryCallSettings.Builder<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
        batchUpdateAssetsSettings;
    private final UnaryCallSettings.Builder<DeleteAssetRequest, Empty> deleteAssetSettings;
    private final UnaryCallSettings.Builder<BatchDeleteAssetsRequest, Empty>
        batchDeleteAssetsSettings;
    private final UnaryCallSettings.Builder<ReportAssetFramesRequest, ReportAssetFramesResponse>
        reportAssetFramesSettings;
    private final UnaryCallSettings.Builder<
            AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
        aggregateAssetsValuesSettings;
    private final UnaryCallSettings.Builder<CreateImportJobRequest, Operation>
        createImportJobSettings;
    private final OperationCallSettings.Builder<
            CreateImportJobRequest, ImportJob, OperationMetadata>
        createImportJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings;
    private final UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings;
    private final UnaryCallSettings.Builder<DeleteImportJobRequest, Operation>
        deleteImportJobSettings;
    private final OperationCallSettings.Builder<DeleteImportJobRequest, Empty, OperationMetadata>
        deleteImportJobOperationSettings;
    private final UnaryCallSettings.Builder<UpdateImportJobRequest, Operation>
        updateImportJobSettings;
    private final OperationCallSettings.Builder<
            UpdateImportJobRequest, ImportJob, OperationMetadata>
        updateImportJobOperationSettings;
    private final UnaryCallSettings.Builder<ValidateImportJobRequest, Operation>
        validateImportJobSettings;
    private final OperationCallSettings.Builder<ValidateImportJobRequest, Empty, OperationMetadata>
        validateImportJobOperationSettings;
    private final UnaryCallSettings.Builder<RunImportJobRequest, Operation> runImportJobSettings;
    private final OperationCallSettings.Builder<RunImportJobRequest, Empty, OperationMetadata>
        runImportJobOperationSettings;
    private final UnaryCallSettings.Builder<GetImportDataFileRequest, ImportDataFile>
        getImportDataFileSettings;
    private final PagedCallSettings.Builder<
            ListImportDataFilesRequest,
            ListImportDataFilesResponse,
            ListImportDataFilesPagedResponse>
        listImportDataFilesSettings;
    private final UnaryCallSettings.Builder<CreateImportDataFileRequest, Operation>
        createImportDataFileSettings;
    private final OperationCallSettings.Builder<
            CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
        createImportDataFileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteImportDataFileRequest, Operation>
        deleteImportDataFileSettings;
    private final OperationCallSettings.Builder<
            DeleteImportDataFileRequest, Empty, OperationMetadata>
        deleteImportDataFileOperationSettings;
    private final PagedCallSettings.Builder<
            ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings;
    private final UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings;
    private final UnaryCallSettings.Builder<CreateGroupRequest, Operation> createGroupSettings;
    private final OperationCallSettings.Builder<CreateGroupRequest, Group, OperationMetadata>
        createGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings;
    private final OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGroupRequest, Operation> deleteGroupSettings;
    private final OperationCallSettings.Builder<DeleteGroupRequest, Empty, OperationMetadata>
        deleteGroupOperationSettings;
    private final UnaryCallSettings.Builder<AddAssetsToGroupRequest, Operation>
        addAssetsToGroupSettings;
    private final OperationCallSettings.Builder<AddAssetsToGroupRequest, Group, OperationMetadata>
        addAssetsToGroupOperationSettings;
    private final UnaryCallSettings.Builder<RemoveAssetsFromGroupRequest, Operation>
        removeAssetsFromGroupSettings;
    private final OperationCallSettings.Builder<
            RemoveAssetsFromGroupRequest, Group, OperationMetadata>
        removeAssetsFromGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
        listErrorFramesSettings;
    private final UnaryCallSettings.Builder<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings;
    private final PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings;
    private final UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings;
    private final UnaryCallSettings.Builder<CreateSourceRequest, Operation> createSourceSettings;
    private final OperationCallSettings.Builder<CreateSourceRequest, Source, OperationMetadata>
        createSourceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSourceRequest, Operation> updateSourceSettings;
    private final OperationCallSettings.Builder<UpdateSourceRequest, Source, OperationMetadata>
        updateSourceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSourceRequest, Operation> deleteSourceSettings;
    private final OperationCallSettings.Builder<DeleteSourceRequest, Empty, OperationMetadata>
        deleteSourceOperationSettings;
    private final PagedCallSettings.Builder<
            ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
        listPreferenceSetsSettings;
    private final UnaryCallSettings.Builder<GetPreferenceSetRequest, PreferenceSet>
        getPreferenceSetSettings;
    private final UnaryCallSettings.Builder<CreatePreferenceSetRequest, Operation>
        createPreferenceSetSettings;
    private final OperationCallSettings.Builder<
            CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        createPreferenceSetOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePreferenceSetRequest, Operation>
        updatePreferenceSetSettings;
    private final OperationCallSettings.Builder<
            UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        updatePreferenceSetOperationSettings;
    private final UnaryCallSettings.Builder<DeletePreferenceSetRequest, Operation>
        deletePreferenceSetSettings;
    private final OperationCallSettings.Builder<
            DeletePreferenceSetRequest, Empty, OperationMetadata>
        deletePreferenceSetOperationSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Operation>
        updateSettingsSettings;
    private final OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings;
    private final UnaryCallSettings.Builder<CreateReportConfigRequest, Operation>
        createReportConfigSettings;
    private final OperationCallSettings.Builder<
            CreateReportConfigRequest, ReportConfig, OperationMetadata>
        createReportConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings;
    private final PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings;
    private final UnaryCallSettings.Builder<DeleteReportConfigRequest, Operation>
        deleteReportConfigSettings;
    private final OperationCallSettings.Builder<DeleteReportConfigRequest, Empty, OperationMetadata>
        deleteReportConfigOperationSettings;
    private final UnaryCallSettings.Builder<CreateReportRequest, Operation> createReportSettings;
    private final OperationCallSettings.Builder<CreateReportRequest, Report, OperationMetadata>
        createReportOperationSettings;
    private final UnaryCallSettings.Builder<GetReportRequest, Report> getReportSettings;
    private final PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings;
    private final UnaryCallSettings.Builder<DeleteReportRequest, Operation> deleteReportSettings;
    private final OperationCallSettings.Builder<DeleteReportRequest, Empty, OperationMetadata>
        deleteReportOperationSettings;
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
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAssetsSettings = PagedCallSettings.newBuilder(LIST_ASSETS_PAGE_STR_FACT);
      getAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateAssetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteAssetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportAssetFramesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregateAssetsValuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImportJobOperationSettings = OperationCallSettings.newBuilder();
      listImportJobsSettings = PagedCallSettings.newBuilder(LIST_IMPORT_JOBS_PAGE_STR_FACT);
      getImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteImportJobOperationSettings = OperationCallSettings.newBuilder();
      updateImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateImportJobOperationSettings = OperationCallSettings.newBuilder();
      validateImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateImportJobOperationSettings = OperationCallSettings.newBuilder();
      runImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runImportJobOperationSettings = OperationCallSettings.newBuilder();
      getImportDataFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listImportDataFilesSettings =
          PagedCallSettings.newBuilder(LIST_IMPORT_DATA_FILES_PAGE_STR_FACT);
      createImportDataFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImportDataFileOperationSettings = OperationCallSettings.newBuilder();
      deleteImportDataFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteImportDataFileOperationSettings = OperationCallSettings.newBuilder();
      listGroupsSettings = PagedCallSettings.newBuilder(LIST_GROUPS_PAGE_STR_FACT);
      getGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGroupOperationSettings = OperationCallSettings.newBuilder();
      updateGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGroupOperationSettings = OperationCallSettings.newBuilder();
      addAssetsToGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addAssetsToGroupOperationSettings = OperationCallSettings.newBuilder();
      removeAssetsFromGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeAssetsFromGroupOperationSettings = OperationCallSettings.newBuilder();
      listErrorFramesSettings = PagedCallSettings.newBuilder(LIST_ERROR_FRAMES_PAGE_STR_FACT);
      getErrorFrameSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSourcesSettings = PagedCallSettings.newBuilder(LIST_SOURCES_PAGE_STR_FACT);
      getSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSourceOperationSettings = OperationCallSettings.newBuilder();
      updateSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSourceOperationSettings = OperationCallSettings.newBuilder();
      deleteSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSourceOperationSettings = OperationCallSettings.newBuilder();
      listPreferenceSetsSettings = PagedCallSettings.newBuilder(LIST_PREFERENCE_SETS_PAGE_STR_FACT);
      getPreferenceSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPreferenceSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPreferenceSetOperationSettings = OperationCallSettings.newBuilder();
      updatePreferenceSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePreferenceSetOperationSettings = OperationCallSettings.newBuilder();
      deletePreferenceSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePreferenceSetOperationSettings = OperationCallSettings.newBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsOperationSettings = OperationCallSettings.newBuilder();
      createReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReportConfigOperationSettings = OperationCallSettings.newBuilder();
      getReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReportConfigsSettings = PagedCallSettings.newBuilder(LIST_REPORT_CONFIGS_PAGE_STR_FACT);
      deleteReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReportConfigOperationSettings = OperationCallSettings.newBuilder();
      createReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReportOperationSettings = OperationCallSettings.newBuilder();
      getReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReportsSettings = PagedCallSettings.newBuilder(LIST_REPORTS_PAGE_STR_FACT);
      deleteReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReportOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAssetsSettings,
              getAssetSettings,
              updateAssetSettings,
              batchUpdateAssetsSettings,
              deleteAssetSettings,
              batchDeleteAssetsSettings,
              reportAssetFramesSettings,
              aggregateAssetsValuesSettings,
              createImportJobSettings,
              listImportJobsSettings,
              getImportJobSettings,
              deleteImportJobSettings,
              updateImportJobSettings,
              validateImportJobSettings,
              runImportJobSettings,
              getImportDataFileSettings,
              listImportDataFilesSettings,
              createImportDataFileSettings,
              deleteImportDataFileSettings,
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              addAssetsToGroupSettings,
              removeAssetsFromGroupSettings,
              listErrorFramesSettings,
              getErrorFrameSettings,
              listSourcesSettings,
              getSourceSettings,
              createSourceSettings,
              updateSourceSettings,
              deleteSourceSettings,
              listPreferenceSetsSettings,
              getPreferenceSetSettings,
              createPreferenceSetSettings,
              updatePreferenceSetSettings,
              deletePreferenceSetSettings,
              getSettingsSettings,
              updateSettingsSettings,
              createReportConfigSettings,
              getReportConfigSettings,
              listReportConfigsSettings,
              deleteReportConfigSettings,
              createReportSettings,
              getReportSettings,
              listReportsSettings,
              deleteReportSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(MigrationCenterStubSettings settings) {
      super(settings);

      listAssetsSettings = settings.listAssetsSettings.toBuilder();
      getAssetSettings = settings.getAssetSettings.toBuilder();
      updateAssetSettings = settings.updateAssetSettings.toBuilder();
      batchUpdateAssetsSettings = settings.batchUpdateAssetsSettings.toBuilder();
      deleteAssetSettings = settings.deleteAssetSettings.toBuilder();
      batchDeleteAssetsSettings = settings.batchDeleteAssetsSettings.toBuilder();
      reportAssetFramesSettings = settings.reportAssetFramesSettings.toBuilder();
      aggregateAssetsValuesSettings = settings.aggregateAssetsValuesSettings.toBuilder();
      createImportJobSettings = settings.createImportJobSettings.toBuilder();
      createImportJobOperationSettings = settings.createImportJobOperationSettings.toBuilder();
      listImportJobsSettings = settings.listImportJobsSettings.toBuilder();
      getImportJobSettings = settings.getImportJobSettings.toBuilder();
      deleteImportJobSettings = settings.deleteImportJobSettings.toBuilder();
      deleteImportJobOperationSettings = settings.deleteImportJobOperationSettings.toBuilder();
      updateImportJobSettings = settings.updateImportJobSettings.toBuilder();
      updateImportJobOperationSettings = settings.updateImportJobOperationSettings.toBuilder();
      validateImportJobSettings = settings.validateImportJobSettings.toBuilder();
      validateImportJobOperationSettings = settings.validateImportJobOperationSettings.toBuilder();
      runImportJobSettings = settings.runImportJobSettings.toBuilder();
      runImportJobOperationSettings = settings.runImportJobOperationSettings.toBuilder();
      getImportDataFileSettings = settings.getImportDataFileSettings.toBuilder();
      listImportDataFilesSettings = settings.listImportDataFilesSettings.toBuilder();
      createImportDataFileSettings = settings.createImportDataFileSettings.toBuilder();
      createImportDataFileOperationSettings =
          settings.createImportDataFileOperationSettings.toBuilder();
      deleteImportDataFileSettings = settings.deleteImportDataFileSettings.toBuilder();
      deleteImportDataFileOperationSettings =
          settings.deleteImportDataFileOperationSettings.toBuilder();
      listGroupsSettings = settings.listGroupsSettings.toBuilder();
      getGroupSettings = settings.getGroupSettings.toBuilder();
      createGroupSettings = settings.createGroupSettings.toBuilder();
      createGroupOperationSettings = settings.createGroupOperationSettings.toBuilder();
      updateGroupSettings = settings.updateGroupSettings.toBuilder();
      updateGroupOperationSettings = settings.updateGroupOperationSettings.toBuilder();
      deleteGroupSettings = settings.deleteGroupSettings.toBuilder();
      deleteGroupOperationSettings = settings.deleteGroupOperationSettings.toBuilder();
      addAssetsToGroupSettings = settings.addAssetsToGroupSettings.toBuilder();
      addAssetsToGroupOperationSettings = settings.addAssetsToGroupOperationSettings.toBuilder();
      removeAssetsFromGroupSettings = settings.removeAssetsFromGroupSettings.toBuilder();
      removeAssetsFromGroupOperationSettings =
          settings.removeAssetsFromGroupOperationSettings.toBuilder();
      listErrorFramesSettings = settings.listErrorFramesSettings.toBuilder();
      getErrorFrameSettings = settings.getErrorFrameSettings.toBuilder();
      listSourcesSettings = settings.listSourcesSettings.toBuilder();
      getSourceSettings = settings.getSourceSettings.toBuilder();
      createSourceSettings = settings.createSourceSettings.toBuilder();
      createSourceOperationSettings = settings.createSourceOperationSettings.toBuilder();
      updateSourceSettings = settings.updateSourceSettings.toBuilder();
      updateSourceOperationSettings = settings.updateSourceOperationSettings.toBuilder();
      deleteSourceSettings = settings.deleteSourceSettings.toBuilder();
      deleteSourceOperationSettings = settings.deleteSourceOperationSettings.toBuilder();
      listPreferenceSetsSettings = settings.listPreferenceSetsSettings.toBuilder();
      getPreferenceSetSettings = settings.getPreferenceSetSettings.toBuilder();
      createPreferenceSetSettings = settings.createPreferenceSetSettings.toBuilder();
      createPreferenceSetOperationSettings =
          settings.createPreferenceSetOperationSettings.toBuilder();
      updatePreferenceSetSettings = settings.updatePreferenceSetSettings.toBuilder();
      updatePreferenceSetOperationSettings =
          settings.updatePreferenceSetOperationSettings.toBuilder();
      deletePreferenceSetSettings = settings.deletePreferenceSetSettings.toBuilder();
      deletePreferenceSetOperationSettings =
          settings.deletePreferenceSetOperationSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      updateSettingsOperationSettings = settings.updateSettingsOperationSettings.toBuilder();
      createReportConfigSettings = settings.createReportConfigSettings.toBuilder();
      createReportConfigOperationSettings =
          settings.createReportConfigOperationSettings.toBuilder();
      getReportConfigSettings = settings.getReportConfigSettings.toBuilder();
      listReportConfigsSettings = settings.listReportConfigsSettings.toBuilder();
      deleteReportConfigSettings = settings.deleteReportConfigSettings.toBuilder();
      deleteReportConfigOperationSettings =
          settings.deleteReportConfigOperationSettings.toBuilder();
      createReportSettings = settings.createReportSettings.toBuilder();
      createReportOperationSettings = settings.createReportOperationSettings.toBuilder();
      getReportSettings = settings.getReportSettings.toBuilder();
      listReportsSettings = settings.listReportsSettings.toBuilder();
      deleteReportSettings = settings.deleteReportSettings.toBuilder();
      deleteReportOperationSettings = settings.deleteReportOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAssetsSettings,
              getAssetSettings,
              updateAssetSettings,
              batchUpdateAssetsSettings,
              deleteAssetSettings,
              batchDeleteAssetsSettings,
              reportAssetFramesSettings,
              aggregateAssetsValuesSettings,
              createImportJobSettings,
              listImportJobsSettings,
              getImportJobSettings,
              deleteImportJobSettings,
              updateImportJobSettings,
              validateImportJobSettings,
              runImportJobSettings,
              getImportDataFileSettings,
              listImportDataFilesSettings,
              createImportDataFileSettings,
              deleteImportDataFileSettings,
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              addAssetsToGroupSettings,
              removeAssetsFromGroupSettings,
              listErrorFramesSettings,
              getErrorFrameSettings,
              listSourcesSettings,
              getSourceSettings,
              createSourceSettings,
              updateSourceSettings,
              deleteSourceSettings,
              listPreferenceSetsSettings,
              getPreferenceSetSettings,
              createPreferenceSetSettings,
              updatePreferenceSetSettings,
              deletePreferenceSetSettings,
              getSettingsSettings,
              updateSettingsSettings,
              createReportConfigSettings,
              getReportConfigSettings,
              listReportConfigsSettings,
              deleteReportConfigSettings,
              createReportSettings,
              getReportSettings,
              listReportsSettings,
              deleteReportSettings,
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
          .listAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchUpdateAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchDeleteAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .reportAssetFramesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .aggregateAssetsValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listImportJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .validateImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .runImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getImportDataFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listImportDataFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createImportDataFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteImportDataFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addAssetsToGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .removeAssetsFromGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listErrorFramesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getErrorFrameSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listPreferenceSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getPreferenceSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createPreferenceSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updatePreferenceSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deletePreferenceSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listReportConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .validateImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ValidateImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .runImportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunImportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createImportDataFileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateImportDataFileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportDataFile.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteImportDataFileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteImportDataFileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .addAssetsToGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddAssetsToGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .removeAssetsFromGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveAssetsFromGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Group.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Source.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Source.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPreferenceSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePreferenceSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PreferenceSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updatePreferenceSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePreferenceSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PreferenceSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deletePreferenceSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePreferenceSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateSettingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSettingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Settings.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createReportConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReportConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReportConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteReportConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteReportConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Report.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return listAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getAssetSettings;
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings() {
      return updateAssetSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateAssets. */
    public UnaryCallSettings.Builder<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
        batchUpdateAssetsSettings() {
      return batchUpdateAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Empty> deleteAssetSettings() {
      return deleteAssetSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteAssets. */
    public UnaryCallSettings.Builder<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsSettings() {
      return batchDeleteAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to reportAssetFrames. */
    public UnaryCallSettings.Builder<ReportAssetFramesRequest, ReportAssetFramesResponse>
        reportAssetFramesSettings() {
      return reportAssetFramesSettings;
    }

    /** Returns the builder for the settings used for calls to aggregateAssetsValues. */
    public UnaryCallSettings.Builder<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
        aggregateAssetsValuesSettings() {
      return aggregateAssetsValuesSettings;
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public UnaryCallSettings.Builder<CreateImportJobRequest, Operation> createImportJobSettings() {
      return createImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public OperationCallSettings.Builder<CreateImportJobRequest, ImportJob, OperationMetadata>
        createImportJobOperationSettings() {
      return createImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listImportJobs. */
    public PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings() {
      return listImportJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getImportJob. */
    public UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings() {
      return getImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImportJob. */
    public UnaryCallSettings.Builder<DeleteImportJobRequest, Operation> deleteImportJobSettings() {
      return deleteImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImportJob. */
    public OperationCallSettings.Builder<DeleteImportJobRequest, Empty, OperationMetadata>
        deleteImportJobOperationSettings() {
      return deleteImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateImportJob. */
    public UnaryCallSettings.Builder<UpdateImportJobRequest, Operation> updateImportJobSettings() {
      return updateImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateImportJob. */
    public OperationCallSettings.Builder<UpdateImportJobRequest, ImportJob, OperationMetadata>
        updateImportJobOperationSettings() {
      return updateImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to validateImportJob. */
    public UnaryCallSettings.Builder<ValidateImportJobRequest, Operation>
        validateImportJobSettings() {
      return validateImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to validateImportJob. */
    public OperationCallSettings.Builder<ValidateImportJobRequest, Empty, OperationMetadata>
        validateImportJobOperationSettings() {
      return validateImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to runImportJob. */
    public UnaryCallSettings.Builder<RunImportJobRequest, Operation> runImportJobSettings() {
      return runImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to runImportJob. */
    public OperationCallSettings.Builder<RunImportJobRequest, Empty, OperationMetadata>
        runImportJobOperationSettings() {
      return runImportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getImportDataFile. */
    public UnaryCallSettings.Builder<GetImportDataFileRequest, ImportDataFile>
        getImportDataFileSettings() {
      return getImportDataFileSettings;
    }

    /** Returns the builder for the settings used for calls to listImportDataFiles. */
    public PagedCallSettings.Builder<
            ListImportDataFilesRequest,
            ListImportDataFilesResponse,
            ListImportDataFilesPagedResponse>
        listImportDataFilesSettings() {
      return listImportDataFilesSettings;
    }

    /** Returns the builder for the settings used for calls to createImportDataFile. */
    public UnaryCallSettings.Builder<CreateImportDataFileRequest, Operation>
        createImportDataFileSettings() {
      return createImportDataFileSettings;
    }

    /** Returns the builder for the settings used for calls to createImportDataFile. */
    public OperationCallSettings.Builder<
            CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
        createImportDataFileOperationSettings() {
      return createImportDataFileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImportDataFile. */
    public UnaryCallSettings.Builder<DeleteImportDataFileRequest, Operation>
        deleteImportDataFileSettings() {
      return deleteImportDataFileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteImportDataFile. */
    public OperationCallSettings.Builder<DeleteImportDataFileRequest, Empty, OperationMetadata>
        deleteImportDataFileOperationSettings() {
      return deleteImportDataFileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return listGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public UnaryCallSettings.Builder<CreateGroupRequest, Operation> createGroupSettings() {
      return createGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public OperationCallSettings.Builder<CreateGroupRequest, Group, OperationMetadata>
        createGroupOperationSettings() {
      return createGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Operation> updateGroupSettings() {
      return updateGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public OperationCallSettings.Builder<UpdateGroupRequest, Group, OperationMetadata>
        updateGroupOperationSettings() {
      return updateGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public UnaryCallSettings.Builder<DeleteGroupRequest, Operation> deleteGroupSettings() {
      return deleteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public OperationCallSettings.Builder<DeleteGroupRequest, Empty, OperationMetadata>
        deleteGroupOperationSettings() {
      return deleteGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addAssetsToGroup. */
    public UnaryCallSettings.Builder<AddAssetsToGroupRequest, Operation>
        addAssetsToGroupSettings() {
      return addAssetsToGroupSettings;
    }

    /** Returns the builder for the settings used for calls to addAssetsToGroup. */
    public OperationCallSettings.Builder<AddAssetsToGroupRequest, Group, OperationMetadata>
        addAssetsToGroupOperationSettings() {
      return addAssetsToGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeAssetsFromGroup. */
    public UnaryCallSettings.Builder<RemoveAssetsFromGroupRequest, Operation>
        removeAssetsFromGroupSettings() {
      return removeAssetsFromGroupSettings;
    }

    /** Returns the builder for the settings used for calls to removeAssetsFromGroup. */
    public OperationCallSettings.Builder<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
        removeAssetsFromGroupOperationSettings() {
      return removeAssetsFromGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listErrorFrames. */
    public PagedCallSettings.Builder<
            ListErrorFramesRequest, ListErrorFramesResponse, ListErrorFramesPagedResponse>
        listErrorFramesSettings() {
      return listErrorFramesSettings;
    }

    /** Returns the builder for the settings used for calls to getErrorFrame. */
    public UnaryCallSettings.Builder<GetErrorFrameRequest, ErrorFrame> getErrorFrameSettings() {
      return getErrorFrameSettings;
    }

    /** Returns the builder for the settings used for calls to listSources. */
    public PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings() {
      return listSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to getSource. */
    public UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings() {
      return getSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public UnaryCallSettings.Builder<CreateSourceRequest, Operation> createSourceSettings() {
      return createSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createSource. */
    public OperationCallSettings.Builder<CreateSourceRequest, Source, OperationMetadata>
        createSourceOperationSettings() {
      return createSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public UnaryCallSettings.Builder<UpdateSourceRequest, Operation> updateSourceSettings() {
      return updateSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public OperationCallSettings.Builder<UpdateSourceRequest, Source, OperationMetadata>
        updateSourceOperationSettings() {
      return updateSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public UnaryCallSettings.Builder<DeleteSourceRequest, Operation> deleteSourceSettings() {
      return deleteSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSource. */
    public OperationCallSettings.Builder<DeleteSourceRequest, Empty, OperationMetadata>
        deleteSourceOperationSettings() {
      return deleteSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPreferenceSets. */
    public PagedCallSettings.Builder<
            ListPreferenceSetsRequest, ListPreferenceSetsResponse, ListPreferenceSetsPagedResponse>
        listPreferenceSetsSettings() {
      return listPreferenceSetsSettings;
    }

    /** Returns the builder for the settings used for calls to getPreferenceSet. */
    public UnaryCallSettings.Builder<GetPreferenceSetRequest, PreferenceSet>
        getPreferenceSetSettings() {
      return getPreferenceSetSettings;
    }

    /** Returns the builder for the settings used for calls to createPreferenceSet. */
    public UnaryCallSettings.Builder<CreatePreferenceSetRequest, Operation>
        createPreferenceSetSettings() {
      return createPreferenceSetSettings;
    }

    /** Returns the builder for the settings used for calls to createPreferenceSet. */
    public OperationCallSettings.Builder<
            CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        createPreferenceSetOperationSettings() {
      return createPreferenceSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePreferenceSet. */
    public UnaryCallSettings.Builder<UpdatePreferenceSetRequest, Operation>
        updatePreferenceSetSettings() {
      return updatePreferenceSetSettings;
    }

    /** Returns the builder for the settings used for calls to updatePreferenceSet. */
    public OperationCallSettings.Builder<
            UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
        updatePreferenceSetOperationSettings() {
      return updatePreferenceSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePreferenceSet. */
    public UnaryCallSettings.Builder<DeletePreferenceSetRequest, Operation>
        deletePreferenceSetSettings() {
      return deletePreferenceSetSettings;
    }

    /** Returns the builder for the settings used for calls to deletePreferenceSet. */
    public OperationCallSettings.Builder<DeletePreferenceSetRequest, Empty, OperationMetadata>
        deletePreferenceSetOperationSettings() {
      return deletePreferenceSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Operation> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings() {
      return updateSettingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public UnaryCallSettings.Builder<CreateReportConfigRequest, Operation>
        createReportConfigSettings() {
      return createReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public OperationCallSettings.Builder<CreateReportConfigRequest, ReportConfig, OperationMetadata>
        createReportConfigOperationSettings() {
      return createReportConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getReportConfig. */
    public UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings() {
      return getReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listReportConfigs. */
    public PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings() {
      return listReportConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public UnaryCallSettings.Builder<DeleteReportConfigRequest, Operation>
        deleteReportConfigSettings() {
      return deleteReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public OperationCallSettings.Builder<DeleteReportConfigRequest, Empty, OperationMetadata>
        deleteReportConfigOperationSettings() {
      return deleteReportConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createReport. */
    public UnaryCallSettings.Builder<CreateReportRequest, Operation> createReportSettings() {
      return createReportSettings;
    }

    /** Returns the builder for the settings used for calls to createReport. */
    public OperationCallSettings.Builder<CreateReportRequest, Report, OperationMetadata>
        createReportOperationSettings() {
      return createReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getReport. */
    public UnaryCallSettings.Builder<GetReportRequest, Report> getReportSettings() {
      return getReportSettings;
    }

    /** Returns the builder for the settings used for calls to listReports. */
    public PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings() {
      return listReportsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReport. */
    public UnaryCallSettings.Builder<DeleteReportRequest, Operation> deleteReportSettings() {
      return deleteReportSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReport. */
    public OperationCallSettings.Builder<DeleteReportRequest, Empty, OperationMetadata>
        deleteReportOperationSettings() {
      return deleteReportOperationSettings;
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
    public MigrationCenterStubSettings build() throws IOException {
      return new MigrationCenterStubSettings(this);
    }
  }
}
