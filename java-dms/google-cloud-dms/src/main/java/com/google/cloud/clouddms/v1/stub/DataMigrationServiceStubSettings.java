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

package com.google.cloud.clouddms.v1.stub;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.DescribeDatabaseEntitiesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConversionWorkspacesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMappingRulesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListPrivateConnectionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.ConnectionProfile;
import com.google.cloud.clouddms.v1.ConversionWorkspace;
import com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CreateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.CreateMappingRuleRequest;
import com.google.cloud.clouddms.v1.CreateMigrationJobRequest;
import com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest;
import com.google.cloud.clouddms.v1.DatabaseEntity;
import com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest;
import com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.DeleteMappingRuleRequest;
import com.google.cloud.clouddms.v1.DeleteMigrationJobRequest;
import com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse;
import com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest;
import com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse;
import com.google.cloud.clouddms.v1.FetchStaticIpsRequest;
import com.google.cloud.clouddms.v1.FetchStaticIpsResponse;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest;
import com.google.cloud.clouddms.v1.GetConnectionProfileRequest;
import com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.GetMappingRuleRequest;
import com.google.cloud.clouddms.v1.GetMigrationJobRequest;
import com.google.cloud.clouddms.v1.GetPrivateConnectionRequest;
import com.google.cloud.clouddms.v1.ImportMappingRulesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesResponse;
import com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest;
import com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse;
import com.google.cloud.clouddms.v1.ListMappingRulesRequest;
import com.google.cloud.clouddms.v1.ListMappingRulesResponse;
import com.google.cloud.clouddms.v1.ListMigrationJobsRequest;
import com.google.cloud.clouddms.v1.ListMigrationJobsResponse;
import com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest;
import com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse;
import com.google.cloud.clouddms.v1.MappingRule;
import com.google.cloud.clouddms.v1.MigrationJob;
import com.google.cloud.clouddms.v1.OperationMetadata;
import com.google.cloud.clouddms.v1.PrivateConnection;
import com.google.cloud.clouddms.v1.PromoteMigrationJobRequest;
import com.google.cloud.clouddms.v1.RestartMigrationJobRequest;
import com.google.cloud.clouddms.v1.ResumeMigrationJobRequest;
import com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest;
import com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse;
import com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.SshScript;
import com.google.cloud.clouddms.v1.StartMigrationJobRequest;
import com.google.cloud.clouddms.v1.StopMigrationJobRequest;
import com.google.cloud.clouddms.v1.TcpProxyScript;
import com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest;
import com.google.cloud.clouddms.v1.UpdateMigrationJobRequest;
import com.google.cloud.clouddms.v1.VerifyMigrationJobRequest;
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
 * Settings class to configure an instance of {@link DataMigrationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datamigration.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMigrationJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataMigrationServiceStubSettings.Builder dataMigrationServiceSettingsBuilder =
 *     DataMigrationServiceStubSettings.newBuilder();
 * dataMigrationServiceSettingsBuilder
 *     .getMigrationJobSettings()
 *     .setRetrySettings(
 *         dataMigrationServiceSettingsBuilder
 *             .getMigrationJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataMigrationServiceStubSettings dataMigrationServiceSettings =
 *     dataMigrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataMigrationServiceStubSettings
    extends StubSettings<DataMigrationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
      listMigrationJobsSettings;
  private final UnaryCallSettings<GetMigrationJobRequest, MigrationJob> getMigrationJobSettings;
  private final UnaryCallSettings<CreateMigrationJobRequest, Operation> createMigrationJobSettings;
  private final OperationCallSettings<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationSettings;
  private final UnaryCallSettings<UpdateMigrationJobRequest, Operation> updateMigrationJobSettings;
  private final OperationCallSettings<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationSettings;
  private final UnaryCallSettings<DeleteMigrationJobRequest, Operation> deleteMigrationJobSettings;
  private final OperationCallSettings<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationSettings;
  private final UnaryCallSettings<StartMigrationJobRequest, Operation> startMigrationJobSettings;
  private final OperationCallSettings<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationSettings;
  private final UnaryCallSettings<StopMigrationJobRequest, Operation> stopMigrationJobSettings;
  private final OperationCallSettings<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationSettings;
  private final UnaryCallSettings<ResumeMigrationJobRequest, Operation> resumeMigrationJobSettings;
  private final OperationCallSettings<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationSettings;
  private final UnaryCallSettings<PromoteMigrationJobRequest, Operation>
      promoteMigrationJobSettings;
  private final OperationCallSettings<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationSettings;
  private final UnaryCallSettings<VerifyMigrationJobRequest, Operation> verifyMigrationJobSettings;
  private final OperationCallSettings<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationSettings;
  private final UnaryCallSettings<RestartMigrationJobRequest, Operation>
      restartMigrationJobSettings;
  private final OperationCallSettings<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationSettings;
  private final UnaryCallSettings<GenerateSshScriptRequest, SshScript> generateSshScriptSettings;
  private final UnaryCallSettings<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptSettings;
  private final PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings;
  private final UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings;
  private final UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings;
  private final OperationCallSettings<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings;
  private final UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings;
  private final OperationCallSettings<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings;
  private final UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings;
  private final OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings;
  private final UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings;
  private final OperationCallSettings<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings;
  private final UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings;
  private final PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings;
  private final UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings;
  private final OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings;
  private final UnaryCallSettings<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceSettings;
  private final PagedCallSettings<
          ListConversionWorkspacesRequest,
          ListConversionWorkspacesResponse,
          ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesSettings;
  private final UnaryCallSettings<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceSettings;
  private final OperationCallSettings<
          CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceSettings;
  private final OperationCallSettings<
          UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceSettings;
  private final OperationCallSettings<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<CreateMappingRuleRequest, MappingRule> createMappingRuleSettings;
  private final UnaryCallSettings<DeleteMappingRuleRequest, Empty> deleteMappingRuleSettings;
  private final PagedCallSettings<
          ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
      listMappingRulesSettings;
  private final UnaryCallSettings<GetMappingRuleRequest, MappingRule> getMappingRuleSettings;
  private final UnaryCallSettings<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceSettings;
  private final OperationCallSettings<
          SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<ImportMappingRulesRequest, Operation> importMappingRulesSettings;
  private final OperationCallSettings<
          ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationSettings;
  private final UnaryCallSettings<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceSettings;
  private final OperationCallSettings<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceSettings;
  private final OperationCallSettings<
          CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceSettings;
  private final OperationCallSettings<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationSettings;
  private final UnaryCallSettings<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceSettings;
  private final OperationCallSettings<
          ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationSettings;
  private final PagedCallSettings<
          DescribeDatabaseEntitiesRequest,
          DescribeDatabaseEntitiesResponse,
          DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesSettings;
  private final UnaryCallSettings<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsSettings;
  private final UnaryCallSettings<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsSettings;
  private final PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings;

  private static final PagedListDescriptor<
          ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob>
      LIST_MIGRATION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMigrationJobsRequest injectToken(
                ListMigrationJobsRequest payload, String token) {
              return ListMigrationJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMigrationJobsRequest injectPageSize(
                ListMigrationJobsRequest payload, int pageSize) {
              return ListMigrationJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMigrationJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMigrationJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MigrationJob> extractResources(ListMigrationJobsResponse payload) {
              return payload.getMigrationJobsList() == null
                  ? ImmutableList.<MigrationJob>of()
                  : payload.getMigrationJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
      LIST_CONNECTION_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectionProfilesRequest injectToken(
                ListConnectionProfilesRequest payload, String token) {
              return ListConnectionProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectionProfilesRequest injectPageSize(
                ListConnectionProfilesRequest payload, int pageSize) {
              return ListConnectionProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConnectionProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectionProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConnectionProfile> extractResources(
                ListConnectionProfilesResponse payload) {
              return payload.getConnectionProfilesList() == null
                  ? ImmutableList.<ConnectionProfile>of()
                  : payload.getConnectionProfilesList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateConnectionsRequest injectToken(
                ListPrivateConnectionsRequest payload, String token) {
              return ListPrivateConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateConnectionsRequest injectPageSize(
                ListPrivateConnectionsRequest payload, int pageSize) {
              return ListPrivateConnectionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrivateConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateConnection> extractResources(
                ListPrivateConnectionsResponse payload) {
              return payload.getPrivateConnectionsList() == null
                  ? ImmutableList.<PrivateConnection>of()
                  : payload.getPrivateConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ListConversionWorkspacesRequest, ListConversionWorkspacesResponse, ConversionWorkspace>
      LIST_CONVERSION_WORKSPACES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversionWorkspacesRequest,
              ListConversionWorkspacesResponse,
              ConversionWorkspace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversionWorkspacesRequest injectToken(
                ListConversionWorkspacesRequest payload, String token) {
              return ListConversionWorkspacesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListConversionWorkspacesRequest injectPageSize(
                ListConversionWorkspacesRequest payload, int pageSize) {
              return ListConversionWorkspacesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConversionWorkspacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversionWorkspacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConversionWorkspace> extractResources(
                ListConversionWorkspacesResponse payload) {
              return payload.getConversionWorkspacesList() == null
                  ? ImmutableList.<ConversionWorkspace>of()
                  : payload.getConversionWorkspacesList();
            }
          };

  private static final PagedListDescriptor<
          ListMappingRulesRequest, ListMappingRulesResponse, MappingRule>
      LIST_MAPPING_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMappingRulesRequest, ListMappingRulesResponse, MappingRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMappingRulesRequest injectToken(
                ListMappingRulesRequest payload, String token) {
              return ListMappingRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMappingRulesRequest injectPageSize(
                ListMappingRulesRequest payload, int pageSize) {
              return ListMappingRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMappingRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMappingRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MappingRule> extractResources(ListMappingRulesResponse payload) {
              return payload.getMappingRulesList() == null
                  ? ImmutableList.<MappingRule>of()
                  : payload.getMappingRulesList();
            }
          };

  private static final PagedListDescriptor<
          DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse, DatabaseEntity>
      DESCRIBE_DATABASE_ENTITIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse, DatabaseEntity>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public DescribeDatabaseEntitiesRequest injectToken(
                DescribeDatabaseEntitiesRequest payload, String token) {
              return DescribeDatabaseEntitiesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public DescribeDatabaseEntitiesRequest injectPageSize(
                DescribeDatabaseEntitiesRequest payload, int pageSize) {
              return DescribeDatabaseEntitiesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(DescribeDatabaseEntitiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(DescribeDatabaseEntitiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatabaseEntity> extractResources(
                DescribeDatabaseEntitiesResponse payload) {
              return payload.getDatabaseEntitiesList() == null
                  ? ImmutableList.<DatabaseEntity>of()
                  : payload.getDatabaseEntitiesList();
            }
          };

  private static final PagedListDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse, String>
      FETCH_STATIC_IPS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchStaticIpsRequest injectToken(FetchStaticIpsRequest payload, String token) {
              return FetchStaticIpsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchStaticIpsRequest injectPageSize(
                FetchStaticIpsRequest payload, int pageSize) {
              return FetchStaticIpsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchStaticIpsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchStaticIpsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchStaticIpsResponse payload) {
              return payload.getStaticIpsList() == null
                  ? ImmutableList.<String>of()
                  : payload.getStaticIpsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
      LIST_MIGRATION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMigrationJobsRequest,
              ListMigrationJobsResponse,
              ListMigrationJobsPagedResponse>() {
            @Override
            public ApiFuture<ListMigrationJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse> callable,
                ListMigrationJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListMigrationJobsResponse> futureResponse) {
              PageContext<ListMigrationJobsRequest, ListMigrationJobsResponse, MigrationJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MIGRATION_JOBS_PAGE_STR_DESC, request, context);
              return ListMigrationJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      LIST_CONNECTION_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectionProfilesRequest,
              ListConnectionProfilesResponse,
              ListConnectionProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListConnectionProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
                    callable,
                ListConnectionProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectionProfilesResponse> futureResponse) {
              PageContext<
                      ListConnectionProfilesRequest,
                      ListConnectionProfilesResponse,
                      ConnectionProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONNECTION_PROFILES_PAGE_STR_DESC, request, context);
              return ListConnectionProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateConnectionsRequest,
              ListPrivateConnectionsResponse,
              ListPrivateConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
                    callable,
                ListPrivateConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
              PageContext<
                      ListPrivateConnectionsRequest,
                      ListPrivateConnectionsResponse,
                      PrivateConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListPrivateConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConversionWorkspacesRequest,
          ListConversionWorkspacesResponse,
          ListConversionWorkspacesPagedResponse>
      LIST_CONVERSION_WORKSPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversionWorkspacesRequest,
              ListConversionWorkspacesResponse,
              ListConversionWorkspacesPagedResponse>() {
            @Override
            public ApiFuture<ListConversionWorkspacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversionWorkspacesRequest, ListConversionWorkspacesResponse>
                    callable,
                ListConversionWorkspacesRequest request,
                ApiCallContext context,
                ApiFuture<ListConversionWorkspacesResponse> futureResponse) {
              PageContext<
                      ListConversionWorkspacesRequest,
                      ListConversionWorkspacesResponse,
                      ConversionWorkspace>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSION_WORKSPACES_PAGE_STR_DESC, request, context);
              return ListConversionWorkspacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
      LIST_MAPPING_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>() {
            @Override
            public ApiFuture<ListMappingRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMappingRulesRequest, ListMappingRulesResponse> callable,
                ListMappingRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListMappingRulesResponse> futureResponse) {
              PageContext<ListMappingRulesRequest, ListMappingRulesResponse, MappingRule>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MAPPING_RULES_PAGE_STR_DESC, request, context);
              return ListMappingRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          DescribeDatabaseEntitiesRequest,
          DescribeDatabaseEntitiesResponse,
          DescribeDatabaseEntitiesPagedResponse>
      DESCRIBE_DATABASE_ENTITIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              DescribeDatabaseEntitiesRequest,
              DescribeDatabaseEntitiesResponse,
              DescribeDatabaseEntitiesPagedResponse>() {
            @Override
            public ApiFuture<DescribeDatabaseEntitiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<DescribeDatabaseEntitiesRequest, DescribeDatabaseEntitiesResponse>
                    callable,
                DescribeDatabaseEntitiesRequest request,
                ApiCallContext context,
                ApiFuture<DescribeDatabaseEntitiesResponse> futureResponse) {
              PageContext<
                      DescribeDatabaseEntitiesRequest,
                      DescribeDatabaseEntitiesResponse,
                      DatabaseEntity>
                  pageContext =
                      PageContext.create(
                          callable, DESCRIBE_DATABASE_ENTITIES_PAGE_STR_DESC, request, context);
              return DescribeDatabaseEntitiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      FETCH_STATIC_IPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>() {
            @Override
            public ApiFuture<FetchStaticIpsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> callable,
                FetchStaticIpsRequest request,
                ApiCallContext context,
                ApiFuture<FetchStaticIpsResponse> futureResponse) {
              PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> pageContext =
                  PageContext.create(callable, FETCH_STATIC_IPS_PAGE_STR_DESC, request, context);
              return FetchStaticIpsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listMigrationJobs. */
  public PagedCallSettings<
          ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
      listMigrationJobsSettings() {
    return listMigrationJobsSettings;
  }

  /** Returns the object with the settings used for calls to getMigrationJob. */
  public UnaryCallSettings<GetMigrationJobRequest, MigrationJob> getMigrationJobSettings() {
    return getMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to createMigrationJob. */
  public UnaryCallSettings<CreateMigrationJobRequest, Operation> createMigrationJobSettings() {
    return createMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to createMigrationJob. */
  public OperationCallSettings<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationSettings() {
    return createMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMigrationJob. */
  public UnaryCallSettings<UpdateMigrationJobRequest, Operation> updateMigrationJobSettings() {
    return updateMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to updateMigrationJob. */
  public OperationCallSettings<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationSettings() {
    return updateMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMigrationJob. */
  public UnaryCallSettings<DeleteMigrationJobRequest, Operation> deleteMigrationJobSettings() {
    return deleteMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteMigrationJob. */
  public OperationCallSettings<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationSettings() {
    return deleteMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to startMigrationJob. */
  public UnaryCallSettings<StartMigrationJobRequest, Operation> startMigrationJobSettings() {
    return startMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to startMigrationJob. */
  public OperationCallSettings<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationSettings() {
    return startMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopMigrationJob. */
  public UnaryCallSettings<StopMigrationJobRequest, Operation> stopMigrationJobSettings() {
    return stopMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to stopMigrationJob. */
  public OperationCallSettings<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationSettings() {
    return stopMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeMigrationJob. */
  public UnaryCallSettings<ResumeMigrationJobRequest, Operation> resumeMigrationJobSettings() {
    return resumeMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to resumeMigrationJob. */
  public OperationCallSettings<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationSettings() {
    return resumeMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to promoteMigrationJob. */
  public UnaryCallSettings<PromoteMigrationJobRequest, Operation> promoteMigrationJobSettings() {
    return promoteMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to promoteMigrationJob. */
  public OperationCallSettings<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationSettings() {
    return promoteMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to verifyMigrationJob. */
  public UnaryCallSettings<VerifyMigrationJobRequest, Operation> verifyMigrationJobSettings() {
    return verifyMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to verifyMigrationJob. */
  public OperationCallSettings<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationSettings() {
    return verifyMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to restartMigrationJob. */
  public UnaryCallSettings<RestartMigrationJobRequest, Operation> restartMigrationJobSettings() {
    return restartMigrationJobSettings;
  }

  /** Returns the object with the settings used for calls to restartMigrationJob. */
  public OperationCallSettings<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationSettings() {
    return restartMigrationJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateSshScript. */
  public UnaryCallSettings<GenerateSshScriptRequest, SshScript> generateSshScriptSettings() {
    return generateSshScriptSettings;
  }

  /** Returns the object with the settings used for calls to generateTcpProxyScript. */
  public UnaryCallSettings<GenerateTcpProxyScriptRequest, TcpProxyScript>
      generateTcpProxyScriptSettings() {
    return generateTcpProxyScriptSettings;
  }

  /** Returns the object with the settings used for calls to listConnectionProfiles. */
  public PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings() {
    return listConnectionProfilesSettings;
  }

  /** Returns the object with the settings used for calls to getConnectionProfile. */
  public UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings() {
    return getConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings() {
    return createConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public OperationCallSettings<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings() {
    return createConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings() {
    return updateConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public OperationCallSettings<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings() {
    return updateConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings() {
    return deleteConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings() {
    return deleteConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return createPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return createPrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return getPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return listPrivateConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return deletePrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return deletePrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConversionWorkspace. */
  public UnaryCallSettings<GetConversionWorkspaceRequest, ConversionWorkspace>
      getConversionWorkspaceSettings() {
    return getConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to listConversionWorkspaces. */
  public PagedCallSettings<
          ListConversionWorkspacesRequest,
          ListConversionWorkspacesResponse,
          ListConversionWorkspacesPagedResponse>
      listConversionWorkspacesSettings() {
    return listConversionWorkspacesSettings;
  }

  /** Returns the object with the settings used for calls to createConversionWorkspace. */
  public UnaryCallSettings<CreateConversionWorkspaceRequest, Operation>
      createConversionWorkspaceSettings() {
    return createConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to createConversionWorkspace. */
  public OperationCallSettings<
          CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      createConversionWorkspaceOperationSettings() {
    return createConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConversionWorkspace. */
  public UnaryCallSettings<UpdateConversionWorkspaceRequest, Operation>
      updateConversionWorkspaceSettings() {
    return updateConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to updateConversionWorkspace. */
  public OperationCallSettings<
          UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      updateConversionWorkspaceOperationSettings() {
    return updateConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversionWorkspace. */
  public UnaryCallSettings<DeleteConversionWorkspaceRequest, Operation>
      deleteConversionWorkspaceSettings() {
    return deleteConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversionWorkspace. */
  public OperationCallSettings<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
      deleteConversionWorkspaceOperationSettings() {
    return deleteConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to createMappingRule. */
  public UnaryCallSettings<CreateMappingRuleRequest, MappingRule> createMappingRuleSettings() {
    return createMappingRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteMappingRule. */
  public UnaryCallSettings<DeleteMappingRuleRequest, Empty> deleteMappingRuleSettings() {
    return deleteMappingRuleSettings;
  }

  /** Returns the object with the settings used for calls to listMappingRules. */
  public PagedCallSettings<
          ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
      listMappingRulesSettings() {
    return listMappingRulesSettings;
  }

  /** Returns the object with the settings used for calls to getMappingRule. */
  public UnaryCallSettings<GetMappingRuleRequest, MappingRule> getMappingRuleSettings() {
    return getMappingRuleSettings;
  }

  /** Returns the object with the settings used for calls to seedConversionWorkspace. */
  public UnaryCallSettings<SeedConversionWorkspaceRequest, Operation>
      seedConversionWorkspaceSettings() {
    return seedConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to seedConversionWorkspace. */
  public OperationCallSettings<
          SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      seedConversionWorkspaceOperationSettings() {
    return seedConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to importMappingRules. */
  public UnaryCallSettings<ImportMappingRulesRequest, Operation> importMappingRulesSettings() {
    return importMappingRulesSettings;
  }

  /** Returns the object with the settings used for calls to importMappingRules. */
  public OperationCallSettings<ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
      importMappingRulesOperationSettings() {
    return importMappingRulesOperationSettings;
  }

  /** Returns the object with the settings used for calls to convertConversionWorkspace. */
  public UnaryCallSettings<ConvertConversionWorkspaceRequest, Operation>
      convertConversionWorkspaceSettings() {
    return convertConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to convertConversionWorkspace. */
  public OperationCallSettings<
          ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      convertConversionWorkspaceOperationSettings() {
    return convertConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to commitConversionWorkspace. */
  public UnaryCallSettings<CommitConversionWorkspaceRequest, Operation>
      commitConversionWorkspaceSettings() {
    return commitConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to commitConversionWorkspace. */
  public OperationCallSettings<
          CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      commitConversionWorkspaceOperationSettings() {
    return commitConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to rollbackConversionWorkspace. */
  public UnaryCallSettings<RollbackConversionWorkspaceRequest, Operation>
      rollbackConversionWorkspaceSettings() {
    return rollbackConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to rollbackConversionWorkspace. */
  public OperationCallSettings<
          RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      rollbackConversionWorkspaceOperationSettings() {
    return rollbackConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to applyConversionWorkspace. */
  public UnaryCallSettings<ApplyConversionWorkspaceRequest, Operation>
      applyConversionWorkspaceSettings() {
    return applyConversionWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to applyConversionWorkspace. */
  public OperationCallSettings<
          ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
      applyConversionWorkspaceOperationSettings() {
    return applyConversionWorkspaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to describeDatabaseEntities. */
  public PagedCallSettings<
          DescribeDatabaseEntitiesRequest,
          DescribeDatabaseEntitiesResponse,
          DescribeDatabaseEntitiesPagedResponse>
      describeDatabaseEntitiesSettings() {
    return describeDatabaseEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to searchBackgroundJobs. */
  public UnaryCallSettings<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
      searchBackgroundJobsSettings() {
    return searchBackgroundJobsSettings;
  }

  /**
   * Returns the object with the settings used for calls to describeConversionWorkspaceRevisions.
   */
  public UnaryCallSettings<
          DescribeConversionWorkspaceRevisionsRequest, DescribeConversionWorkspaceRevisionsResponse>
      describeConversionWorkspaceRevisionsSettings() {
    return describeConversionWorkspaceRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to fetchStaticIps. */
  public PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings() {
    return fetchStaticIpsSettings;
  }

  public DataMigrationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataMigrationServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "datamigration";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "datamigration.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datamigration.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataMigrationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected DataMigrationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMigrationJobsSettings = settingsBuilder.listMigrationJobsSettings().build();
    getMigrationJobSettings = settingsBuilder.getMigrationJobSettings().build();
    createMigrationJobSettings = settingsBuilder.createMigrationJobSettings().build();
    createMigrationJobOperationSettings =
        settingsBuilder.createMigrationJobOperationSettings().build();
    updateMigrationJobSettings = settingsBuilder.updateMigrationJobSettings().build();
    updateMigrationJobOperationSettings =
        settingsBuilder.updateMigrationJobOperationSettings().build();
    deleteMigrationJobSettings = settingsBuilder.deleteMigrationJobSettings().build();
    deleteMigrationJobOperationSettings =
        settingsBuilder.deleteMigrationJobOperationSettings().build();
    startMigrationJobSettings = settingsBuilder.startMigrationJobSettings().build();
    startMigrationJobOperationSettings =
        settingsBuilder.startMigrationJobOperationSettings().build();
    stopMigrationJobSettings = settingsBuilder.stopMigrationJobSettings().build();
    stopMigrationJobOperationSettings = settingsBuilder.stopMigrationJobOperationSettings().build();
    resumeMigrationJobSettings = settingsBuilder.resumeMigrationJobSettings().build();
    resumeMigrationJobOperationSettings =
        settingsBuilder.resumeMigrationJobOperationSettings().build();
    promoteMigrationJobSettings = settingsBuilder.promoteMigrationJobSettings().build();
    promoteMigrationJobOperationSettings =
        settingsBuilder.promoteMigrationJobOperationSettings().build();
    verifyMigrationJobSettings = settingsBuilder.verifyMigrationJobSettings().build();
    verifyMigrationJobOperationSettings =
        settingsBuilder.verifyMigrationJobOperationSettings().build();
    restartMigrationJobSettings = settingsBuilder.restartMigrationJobSettings().build();
    restartMigrationJobOperationSettings =
        settingsBuilder.restartMigrationJobOperationSettings().build();
    generateSshScriptSettings = settingsBuilder.generateSshScriptSettings().build();
    generateTcpProxyScriptSettings = settingsBuilder.generateTcpProxyScriptSettings().build();
    listConnectionProfilesSettings = settingsBuilder.listConnectionProfilesSettings().build();
    getConnectionProfileSettings = settingsBuilder.getConnectionProfileSettings().build();
    createConnectionProfileSettings = settingsBuilder.createConnectionProfileSettings().build();
    createConnectionProfileOperationSettings =
        settingsBuilder.createConnectionProfileOperationSettings().build();
    updateConnectionProfileSettings = settingsBuilder.updateConnectionProfileSettings().build();
    updateConnectionProfileOperationSettings =
        settingsBuilder.updateConnectionProfileOperationSettings().build();
    deleteConnectionProfileSettings = settingsBuilder.deleteConnectionProfileSettings().build();
    deleteConnectionProfileOperationSettings =
        settingsBuilder.deleteConnectionProfileOperationSettings().build();
    createPrivateConnectionSettings = settingsBuilder.createPrivateConnectionSettings().build();
    createPrivateConnectionOperationSettings =
        settingsBuilder.createPrivateConnectionOperationSettings().build();
    getPrivateConnectionSettings = settingsBuilder.getPrivateConnectionSettings().build();
    listPrivateConnectionsSettings = settingsBuilder.listPrivateConnectionsSettings().build();
    deletePrivateConnectionSettings = settingsBuilder.deletePrivateConnectionSettings().build();
    deletePrivateConnectionOperationSettings =
        settingsBuilder.deletePrivateConnectionOperationSettings().build();
    getConversionWorkspaceSettings = settingsBuilder.getConversionWorkspaceSettings().build();
    listConversionWorkspacesSettings = settingsBuilder.listConversionWorkspacesSettings().build();
    createConversionWorkspaceSettings = settingsBuilder.createConversionWorkspaceSettings().build();
    createConversionWorkspaceOperationSettings =
        settingsBuilder.createConversionWorkspaceOperationSettings().build();
    updateConversionWorkspaceSettings = settingsBuilder.updateConversionWorkspaceSettings().build();
    updateConversionWorkspaceOperationSettings =
        settingsBuilder.updateConversionWorkspaceOperationSettings().build();
    deleteConversionWorkspaceSettings = settingsBuilder.deleteConversionWorkspaceSettings().build();
    deleteConversionWorkspaceOperationSettings =
        settingsBuilder.deleteConversionWorkspaceOperationSettings().build();
    createMappingRuleSettings = settingsBuilder.createMappingRuleSettings().build();
    deleteMappingRuleSettings = settingsBuilder.deleteMappingRuleSettings().build();
    listMappingRulesSettings = settingsBuilder.listMappingRulesSettings().build();
    getMappingRuleSettings = settingsBuilder.getMappingRuleSettings().build();
    seedConversionWorkspaceSettings = settingsBuilder.seedConversionWorkspaceSettings().build();
    seedConversionWorkspaceOperationSettings =
        settingsBuilder.seedConversionWorkspaceOperationSettings().build();
    importMappingRulesSettings = settingsBuilder.importMappingRulesSettings().build();
    importMappingRulesOperationSettings =
        settingsBuilder.importMappingRulesOperationSettings().build();
    convertConversionWorkspaceSettings =
        settingsBuilder.convertConversionWorkspaceSettings().build();
    convertConversionWorkspaceOperationSettings =
        settingsBuilder.convertConversionWorkspaceOperationSettings().build();
    commitConversionWorkspaceSettings = settingsBuilder.commitConversionWorkspaceSettings().build();
    commitConversionWorkspaceOperationSettings =
        settingsBuilder.commitConversionWorkspaceOperationSettings().build();
    rollbackConversionWorkspaceSettings =
        settingsBuilder.rollbackConversionWorkspaceSettings().build();
    rollbackConversionWorkspaceOperationSettings =
        settingsBuilder.rollbackConversionWorkspaceOperationSettings().build();
    applyConversionWorkspaceSettings = settingsBuilder.applyConversionWorkspaceSettings().build();
    applyConversionWorkspaceOperationSettings =
        settingsBuilder.applyConversionWorkspaceOperationSettings().build();
    describeDatabaseEntitiesSettings = settingsBuilder.describeDatabaseEntitiesSettings().build();
    searchBackgroundJobsSettings = settingsBuilder.searchBackgroundJobsSettings().build();
    describeConversionWorkspaceRevisionsSettings =
        settingsBuilder.describeConversionWorkspaceRevisionsSettings().build();
    fetchStaticIpsSettings = settingsBuilder.fetchStaticIpsSettings().build();
  }

  /** Builder for DataMigrationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataMigrationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
        listMigrationJobsSettings;
    private final UnaryCallSettings.Builder<GetMigrationJobRequest, MigrationJob>
        getMigrationJobSettings;
    private final UnaryCallSettings.Builder<CreateMigrationJobRequest, Operation>
        createMigrationJobSettings;
    private final OperationCallSettings.Builder<
            CreateMigrationJobRequest, MigrationJob, OperationMetadata>
        createMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMigrationJobRequest, Operation>
        updateMigrationJobSettings;
    private final OperationCallSettings.Builder<
            UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
        updateMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMigrationJobRequest, Operation>
        deleteMigrationJobSettings;
    private final OperationCallSettings.Builder<DeleteMigrationJobRequest, Empty, OperationMetadata>
        deleteMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<StartMigrationJobRequest, Operation>
        startMigrationJobSettings;
    private final OperationCallSettings.Builder<
            StartMigrationJobRequest, MigrationJob, OperationMetadata>
        startMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<StopMigrationJobRequest, Operation>
        stopMigrationJobSettings;
    private final OperationCallSettings.Builder<
            StopMigrationJobRequest, MigrationJob, OperationMetadata>
        stopMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<ResumeMigrationJobRequest, Operation>
        resumeMigrationJobSettings;
    private final OperationCallSettings.Builder<
            ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
        resumeMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<PromoteMigrationJobRequest, Operation>
        promoteMigrationJobSettings;
    private final OperationCallSettings.Builder<
            PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
        promoteMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<VerifyMigrationJobRequest, Operation>
        verifyMigrationJobSettings;
    private final OperationCallSettings.Builder<
            VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
        verifyMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<RestartMigrationJobRequest, Operation>
        restartMigrationJobSettings;
    private final OperationCallSettings.Builder<
            RestartMigrationJobRequest, MigrationJob, OperationMetadata>
        restartMigrationJobOperationSettings;
    private final UnaryCallSettings.Builder<GenerateSshScriptRequest, SshScript>
        generateSshScriptSettings;
    private final UnaryCallSettings.Builder<GenerateTcpProxyScriptRequest, TcpProxyScript>
        generateTcpProxyScriptSettings;
    private final PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings;
    private final UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings;
    private final UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings;
    private final PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings;
    private final UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetConversionWorkspaceRequest, ConversionWorkspace>
        getConversionWorkspaceSettings;
    private final PagedCallSettings.Builder<
            ListConversionWorkspacesRequest,
            ListConversionWorkspacesResponse,
            ListConversionWorkspacesPagedResponse>
        listConversionWorkspacesSettings;
    private final UnaryCallSettings.Builder<CreateConversionWorkspaceRequest, Operation>
        createConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        createConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConversionWorkspaceRequest, Operation>
        updateConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        updateConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConversionWorkspaceRequest, Operation>
        deleteConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
        deleteConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<CreateMappingRuleRequest, MappingRule>
        createMappingRuleSettings;
    private final UnaryCallSettings.Builder<DeleteMappingRuleRequest, Empty>
        deleteMappingRuleSettings;
    private final PagedCallSettings.Builder<
            ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
        listMappingRulesSettings;
    private final UnaryCallSettings.Builder<GetMappingRuleRequest, MappingRule>
        getMappingRuleSettings;
    private final UnaryCallSettings.Builder<SeedConversionWorkspaceRequest, Operation>
        seedConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        seedConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<ImportMappingRulesRequest, Operation>
        importMappingRulesSettings;
    private final OperationCallSettings.Builder<
            ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
        importMappingRulesOperationSettings;
    private final UnaryCallSettings.Builder<ConvertConversionWorkspaceRequest, Operation>
        convertConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        convertConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<CommitConversionWorkspaceRequest, Operation>
        commitConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        commitConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<RollbackConversionWorkspaceRequest, Operation>
        rollbackConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        rollbackConversionWorkspaceOperationSettings;
    private final UnaryCallSettings.Builder<ApplyConversionWorkspaceRequest, Operation>
        applyConversionWorkspaceSettings;
    private final OperationCallSettings.Builder<
            ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        applyConversionWorkspaceOperationSettings;
    private final PagedCallSettings.Builder<
            DescribeDatabaseEntitiesRequest,
            DescribeDatabaseEntitiesResponse,
            DescribeDatabaseEntitiesPagedResponse>
        describeDatabaseEntitiesSettings;
    private final UnaryCallSettings.Builder<
            SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
        searchBackgroundJobsSettings;
    private final UnaryCallSettings.Builder<
            DescribeConversionWorkspaceRevisionsRequest,
            DescribeConversionWorkspaceRevisionsResponse>
        describeConversionWorkspaceRevisionsSettings;
    private final PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listMigrationJobsSettings = PagedCallSettings.newBuilder(LIST_MIGRATION_JOBS_PAGE_STR_FACT);
      getMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      updateMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      deleteMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      startMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      stopMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      resumeMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      promoteMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      promoteMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      verifyMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      verifyMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      restartMigrationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartMigrationJobOperationSettings = OperationCallSettings.newBuilder();
      generateSshScriptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateTcpProxyScriptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConnectionProfilesSettings =
          PagedCallSettings.newBuilder(LIST_CONNECTION_PROFILES_PAGE_STR_FACT);
      getConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      updateConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      createPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      getPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateConnectionsSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT);
      deletePrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      getConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversionWorkspacesSettings =
          PagedCallSettings.newBuilder(LIST_CONVERSION_WORKSPACES_PAGE_STR_FACT);
      createConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      updateConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      deleteConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      createMappingRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMappingRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMappingRulesSettings = PagedCallSettings.newBuilder(LIST_MAPPING_RULES_PAGE_STR_FACT);
      getMappingRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      seedConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      seedConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      importMappingRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importMappingRulesOperationSettings = OperationCallSettings.newBuilder();
      convertConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      convertConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      commitConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      rollbackConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rollbackConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      applyConversionWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      applyConversionWorkspaceOperationSettings = OperationCallSettings.newBuilder();
      describeDatabaseEntitiesSettings =
          PagedCallSettings.newBuilder(DESCRIBE_DATABASE_ENTITIES_PAGE_STR_FACT);
      searchBackgroundJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      describeConversionWorkspaceRevisionsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchStaticIpsSettings = PagedCallSettings.newBuilder(FETCH_STATIC_IPS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMigrationJobsSettings,
              getMigrationJobSettings,
              createMigrationJobSettings,
              updateMigrationJobSettings,
              deleteMigrationJobSettings,
              startMigrationJobSettings,
              stopMigrationJobSettings,
              resumeMigrationJobSettings,
              promoteMigrationJobSettings,
              verifyMigrationJobSettings,
              restartMigrationJobSettings,
              generateSshScriptSettings,
              generateTcpProxyScriptSettings,
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              deletePrivateConnectionSettings,
              getConversionWorkspaceSettings,
              listConversionWorkspacesSettings,
              createConversionWorkspaceSettings,
              updateConversionWorkspaceSettings,
              deleteConversionWorkspaceSettings,
              createMappingRuleSettings,
              deleteMappingRuleSettings,
              listMappingRulesSettings,
              getMappingRuleSettings,
              seedConversionWorkspaceSettings,
              importMappingRulesSettings,
              convertConversionWorkspaceSettings,
              commitConversionWorkspaceSettings,
              rollbackConversionWorkspaceSettings,
              applyConversionWorkspaceSettings,
              describeDatabaseEntitiesSettings,
              searchBackgroundJobsSettings,
              describeConversionWorkspaceRevisionsSettings,
              fetchStaticIpsSettings);
      initDefaults(this);
    }

    protected Builder(DataMigrationServiceStubSettings settings) {
      super(settings);

      listMigrationJobsSettings = settings.listMigrationJobsSettings.toBuilder();
      getMigrationJobSettings = settings.getMigrationJobSettings.toBuilder();
      createMigrationJobSettings = settings.createMigrationJobSettings.toBuilder();
      createMigrationJobOperationSettings =
          settings.createMigrationJobOperationSettings.toBuilder();
      updateMigrationJobSettings = settings.updateMigrationJobSettings.toBuilder();
      updateMigrationJobOperationSettings =
          settings.updateMigrationJobOperationSettings.toBuilder();
      deleteMigrationJobSettings = settings.deleteMigrationJobSettings.toBuilder();
      deleteMigrationJobOperationSettings =
          settings.deleteMigrationJobOperationSettings.toBuilder();
      startMigrationJobSettings = settings.startMigrationJobSettings.toBuilder();
      startMigrationJobOperationSettings = settings.startMigrationJobOperationSettings.toBuilder();
      stopMigrationJobSettings = settings.stopMigrationJobSettings.toBuilder();
      stopMigrationJobOperationSettings = settings.stopMigrationJobOperationSettings.toBuilder();
      resumeMigrationJobSettings = settings.resumeMigrationJobSettings.toBuilder();
      resumeMigrationJobOperationSettings =
          settings.resumeMigrationJobOperationSettings.toBuilder();
      promoteMigrationJobSettings = settings.promoteMigrationJobSettings.toBuilder();
      promoteMigrationJobOperationSettings =
          settings.promoteMigrationJobOperationSettings.toBuilder();
      verifyMigrationJobSettings = settings.verifyMigrationJobSettings.toBuilder();
      verifyMigrationJobOperationSettings =
          settings.verifyMigrationJobOperationSettings.toBuilder();
      restartMigrationJobSettings = settings.restartMigrationJobSettings.toBuilder();
      restartMigrationJobOperationSettings =
          settings.restartMigrationJobOperationSettings.toBuilder();
      generateSshScriptSettings = settings.generateSshScriptSettings.toBuilder();
      generateTcpProxyScriptSettings = settings.generateTcpProxyScriptSettings.toBuilder();
      listConnectionProfilesSettings = settings.listConnectionProfilesSettings.toBuilder();
      getConnectionProfileSettings = settings.getConnectionProfileSettings.toBuilder();
      createConnectionProfileSettings = settings.createConnectionProfileSettings.toBuilder();
      createConnectionProfileOperationSettings =
          settings.createConnectionProfileOperationSettings.toBuilder();
      updateConnectionProfileSettings = settings.updateConnectionProfileSettings.toBuilder();
      updateConnectionProfileOperationSettings =
          settings.updateConnectionProfileOperationSettings.toBuilder();
      deleteConnectionProfileSettings = settings.deleteConnectionProfileSettings.toBuilder();
      deleteConnectionProfileOperationSettings =
          settings.deleteConnectionProfileOperationSettings.toBuilder();
      createPrivateConnectionSettings = settings.createPrivateConnectionSettings.toBuilder();
      createPrivateConnectionOperationSettings =
          settings.createPrivateConnectionOperationSettings.toBuilder();
      getPrivateConnectionSettings = settings.getPrivateConnectionSettings.toBuilder();
      listPrivateConnectionsSettings = settings.listPrivateConnectionsSettings.toBuilder();
      deletePrivateConnectionSettings = settings.deletePrivateConnectionSettings.toBuilder();
      deletePrivateConnectionOperationSettings =
          settings.deletePrivateConnectionOperationSettings.toBuilder();
      getConversionWorkspaceSettings = settings.getConversionWorkspaceSettings.toBuilder();
      listConversionWorkspacesSettings = settings.listConversionWorkspacesSettings.toBuilder();
      createConversionWorkspaceSettings = settings.createConversionWorkspaceSettings.toBuilder();
      createConversionWorkspaceOperationSettings =
          settings.createConversionWorkspaceOperationSettings.toBuilder();
      updateConversionWorkspaceSettings = settings.updateConversionWorkspaceSettings.toBuilder();
      updateConversionWorkspaceOperationSettings =
          settings.updateConversionWorkspaceOperationSettings.toBuilder();
      deleteConversionWorkspaceSettings = settings.deleteConversionWorkspaceSettings.toBuilder();
      deleteConversionWorkspaceOperationSettings =
          settings.deleteConversionWorkspaceOperationSettings.toBuilder();
      createMappingRuleSettings = settings.createMappingRuleSettings.toBuilder();
      deleteMappingRuleSettings = settings.deleteMappingRuleSettings.toBuilder();
      listMappingRulesSettings = settings.listMappingRulesSettings.toBuilder();
      getMappingRuleSettings = settings.getMappingRuleSettings.toBuilder();
      seedConversionWorkspaceSettings = settings.seedConversionWorkspaceSettings.toBuilder();
      seedConversionWorkspaceOperationSettings =
          settings.seedConversionWorkspaceOperationSettings.toBuilder();
      importMappingRulesSettings = settings.importMappingRulesSettings.toBuilder();
      importMappingRulesOperationSettings =
          settings.importMappingRulesOperationSettings.toBuilder();
      convertConversionWorkspaceSettings = settings.convertConversionWorkspaceSettings.toBuilder();
      convertConversionWorkspaceOperationSettings =
          settings.convertConversionWorkspaceOperationSettings.toBuilder();
      commitConversionWorkspaceSettings = settings.commitConversionWorkspaceSettings.toBuilder();
      commitConversionWorkspaceOperationSettings =
          settings.commitConversionWorkspaceOperationSettings.toBuilder();
      rollbackConversionWorkspaceSettings =
          settings.rollbackConversionWorkspaceSettings.toBuilder();
      rollbackConversionWorkspaceOperationSettings =
          settings.rollbackConversionWorkspaceOperationSettings.toBuilder();
      applyConversionWorkspaceSettings = settings.applyConversionWorkspaceSettings.toBuilder();
      applyConversionWorkspaceOperationSettings =
          settings.applyConversionWorkspaceOperationSettings.toBuilder();
      describeDatabaseEntitiesSettings = settings.describeDatabaseEntitiesSettings.toBuilder();
      searchBackgroundJobsSettings = settings.searchBackgroundJobsSettings.toBuilder();
      describeConversionWorkspaceRevisionsSettings =
          settings.describeConversionWorkspaceRevisionsSettings.toBuilder();
      fetchStaticIpsSettings = settings.fetchStaticIpsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMigrationJobsSettings,
              getMigrationJobSettings,
              createMigrationJobSettings,
              updateMigrationJobSettings,
              deleteMigrationJobSettings,
              startMigrationJobSettings,
              stopMigrationJobSettings,
              resumeMigrationJobSettings,
              promoteMigrationJobSettings,
              verifyMigrationJobSettings,
              restartMigrationJobSettings,
              generateSshScriptSettings,
              generateTcpProxyScriptSettings,
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              deletePrivateConnectionSettings,
              getConversionWorkspaceSettings,
              listConversionWorkspacesSettings,
              createConversionWorkspaceSettings,
              updateConversionWorkspaceSettings,
              deleteConversionWorkspaceSettings,
              createMappingRuleSettings,
              deleteMappingRuleSettings,
              listMappingRulesSettings,
              getMappingRuleSettings,
              seedConversionWorkspaceSettings,
              importMappingRulesSettings,
              convertConversionWorkspaceSettings,
              commitConversionWorkspaceSettings,
              rollbackConversionWorkspaceSettings,
              applyConversionWorkspaceSettings,
              describeDatabaseEntitiesSettings,
              searchBackgroundJobsSettings,
              describeConversionWorkspaceRevisionsSettings,
              fetchStaticIpsSettings);
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
          .listMigrationJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .promoteMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .verifyMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .restartMigrationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateSshScriptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .generateTcpProxyScriptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConnectionProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listPrivateConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listConversionWorkspacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMappingRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMappingRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMappingRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMappingRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .seedConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .importMappingRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .convertConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .commitConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .rollbackConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .applyConversionWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .describeDatabaseEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .searchBackgroundJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .describeConversionWorkspaceRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .fetchStaticIpsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .updateMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .deleteMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .startMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .stopMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .resumeMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .promoteMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PromoteMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .verifyMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<VerifyMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .restartMigrationJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestartMigrationJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MigrationJob.class))
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
          .createConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectionProfile.class))
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
          .updateConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectionProfile.class))
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
          .deleteConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createPrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateConnection.class))
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
          .deletePrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConversionWorkspaceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .updateConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConversionWorkspaceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .deleteConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConversionWorkspaceRequest, OperationSnapshot>
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .seedConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SeedConversionWorkspaceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .importMappingRulesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportMappingRulesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .convertConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ConvertConversionWorkspaceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .commitConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CommitConversionWorkspaceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .rollbackConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RollbackConversionWorkspaceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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
          .applyConversionWorkspaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ApplyConversionWorkspaceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversionWorkspace.class))
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

    /** Returns the builder for the settings used for calls to listMigrationJobs. */
    public PagedCallSettings.Builder<
            ListMigrationJobsRequest, ListMigrationJobsResponse, ListMigrationJobsPagedResponse>
        listMigrationJobsSettings() {
      return listMigrationJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getMigrationJob. */
    public UnaryCallSettings.Builder<GetMigrationJobRequest, MigrationJob>
        getMigrationJobSettings() {
      return getMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to createMigrationJob. */
    public UnaryCallSettings.Builder<CreateMigrationJobRequest, Operation>
        createMigrationJobSettings() {
      return createMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to createMigrationJob. */
    public OperationCallSettings.Builder<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
        createMigrationJobOperationSettings() {
      return createMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMigrationJob. */
    public UnaryCallSettings.Builder<UpdateMigrationJobRequest, Operation>
        updateMigrationJobSettings() {
      return updateMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateMigrationJob. */
    public OperationCallSettings.Builder<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
        updateMigrationJobOperationSettings() {
      return updateMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMigrationJob. */
    public UnaryCallSettings.Builder<DeleteMigrationJobRequest, Operation>
        deleteMigrationJobSettings() {
      return deleteMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMigrationJob. */
    public OperationCallSettings.Builder<DeleteMigrationJobRequest, Empty, OperationMetadata>
        deleteMigrationJobOperationSettings() {
      return deleteMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startMigrationJob. */
    public UnaryCallSettings.Builder<StartMigrationJobRequest, Operation>
        startMigrationJobSettings() {
      return startMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to startMigrationJob. */
    public OperationCallSettings.Builder<StartMigrationJobRequest, MigrationJob, OperationMetadata>
        startMigrationJobOperationSettings() {
      return startMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopMigrationJob. */
    public UnaryCallSettings.Builder<StopMigrationJobRequest, Operation>
        stopMigrationJobSettings() {
      return stopMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to stopMigrationJob. */
    public OperationCallSettings.Builder<StopMigrationJobRequest, MigrationJob, OperationMetadata>
        stopMigrationJobOperationSettings() {
      return stopMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeMigrationJob. */
    public UnaryCallSettings.Builder<ResumeMigrationJobRequest, Operation>
        resumeMigrationJobSettings() {
      return resumeMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to resumeMigrationJob. */
    public OperationCallSettings.Builder<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
        resumeMigrationJobOperationSettings() {
      return resumeMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to promoteMigrationJob. */
    public UnaryCallSettings.Builder<PromoteMigrationJobRequest, Operation>
        promoteMigrationJobSettings() {
      return promoteMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to promoteMigrationJob. */
    public OperationCallSettings.Builder<
            PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
        promoteMigrationJobOperationSettings() {
      return promoteMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to verifyMigrationJob. */
    public UnaryCallSettings.Builder<VerifyMigrationJobRequest, Operation>
        verifyMigrationJobSettings() {
      return verifyMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to verifyMigrationJob. */
    public OperationCallSettings.Builder<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
        verifyMigrationJobOperationSettings() {
      return verifyMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restartMigrationJob. */
    public UnaryCallSettings.Builder<RestartMigrationJobRequest, Operation>
        restartMigrationJobSettings() {
      return restartMigrationJobSettings;
    }

    /** Returns the builder for the settings used for calls to restartMigrationJob. */
    public OperationCallSettings.Builder<
            RestartMigrationJobRequest, MigrationJob, OperationMetadata>
        restartMigrationJobOperationSettings() {
      return restartMigrationJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateSshScript. */
    public UnaryCallSettings.Builder<GenerateSshScriptRequest, SshScript>
        generateSshScriptSettings() {
      return generateSshScriptSettings;
    }

    /** Returns the builder for the settings used for calls to generateTcpProxyScript. */
    public UnaryCallSettings.Builder<GenerateTcpProxyScriptRequest, TcpProxyScript>
        generateTcpProxyScriptSettings() {
      return generateTcpProxyScriptSettings;
    }

    /** Returns the builder for the settings used for calls to listConnectionProfiles. */
    public PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings() {
      return listConnectionProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to getConnectionProfile. */
    public UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings() {
      return getConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings() {
      return createConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings() {
      return createConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings() {
      return updateConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings() {
      return updateConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings() {
      return deleteConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public OperationCallSettings.Builder<DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings() {
      return deleteConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return createPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return createPrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return listPrivateConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return deletePrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return deletePrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getConversionWorkspace. */
    public UnaryCallSettings.Builder<GetConversionWorkspaceRequest, ConversionWorkspace>
        getConversionWorkspaceSettings() {
      return getConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to listConversionWorkspaces. */
    public PagedCallSettings.Builder<
            ListConversionWorkspacesRequest,
            ListConversionWorkspacesResponse,
            ListConversionWorkspacesPagedResponse>
        listConversionWorkspacesSettings() {
      return listConversionWorkspacesSettings;
    }

    /** Returns the builder for the settings used for calls to createConversionWorkspace. */
    public UnaryCallSettings.Builder<CreateConversionWorkspaceRequest, Operation>
        createConversionWorkspaceSettings() {
      return createConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to createConversionWorkspace. */
    public OperationCallSettings.Builder<
            CreateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        createConversionWorkspaceOperationSettings() {
      return createConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConversionWorkspace. */
    public UnaryCallSettings.Builder<UpdateConversionWorkspaceRequest, Operation>
        updateConversionWorkspaceSettings() {
      return updateConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateConversionWorkspace. */
    public OperationCallSettings.Builder<
            UpdateConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        updateConversionWorkspaceOperationSettings() {
      return updateConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversionWorkspace. */
    public UnaryCallSettings.Builder<DeleteConversionWorkspaceRequest, Operation>
        deleteConversionWorkspaceSettings() {
      return deleteConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversionWorkspace. */
    public OperationCallSettings.Builder<DeleteConversionWorkspaceRequest, Empty, OperationMetadata>
        deleteConversionWorkspaceOperationSettings() {
      return deleteConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createMappingRule. */
    public UnaryCallSettings.Builder<CreateMappingRuleRequest, MappingRule>
        createMappingRuleSettings() {
      return createMappingRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMappingRule. */
    public UnaryCallSettings.Builder<DeleteMappingRuleRequest, Empty> deleteMappingRuleSettings() {
      return deleteMappingRuleSettings;
    }

    /** Returns the builder for the settings used for calls to listMappingRules. */
    public PagedCallSettings.Builder<
            ListMappingRulesRequest, ListMappingRulesResponse, ListMappingRulesPagedResponse>
        listMappingRulesSettings() {
      return listMappingRulesSettings;
    }

    /** Returns the builder for the settings used for calls to getMappingRule. */
    public UnaryCallSettings.Builder<GetMappingRuleRequest, MappingRule> getMappingRuleSettings() {
      return getMappingRuleSettings;
    }

    /** Returns the builder for the settings used for calls to seedConversionWorkspace. */
    public UnaryCallSettings.Builder<SeedConversionWorkspaceRequest, Operation>
        seedConversionWorkspaceSettings() {
      return seedConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to seedConversionWorkspace. */
    public OperationCallSettings.Builder<
            SeedConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        seedConversionWorkspaceOperationSettings() {
      return seedConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importMappingRules. */
    public UnaryCallSettings.Builder<ImportMappingRulesRequest, Operation>
        importMappingRulesSettings() {
      return importMappingRulesSettings;
    }

    /** Returns the builder for the settings used for calls to importMappingRules. */
    public OperationCallSettings.Builder<
            ImportMappingRulesRequest, ConversionWorkspace, OperationMetadata>
        importMappingRulesOperationSettings() {
      return importMappingRulesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to convertConversionWorkspace. */
    public UnaryCallSettings.Builder<ConvertConversionWorkspaceRequest, Operation>
        convertConversionWorkspaceSettings() {
      return convertConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to convertConversionWorkspace. */
    public OperationCallSettings.Builder<
            ConvertConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        convertConversionWorkspaceOperationSettings() {
      return convertConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to commitConversionWorkspace. */
    public UnaryCallSettings.Builder<CommitConversionWorkspaceRequest, Operation>
        commitConversionWorkspaceSettings() {
      return commitConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to commitConversionWorkspace. */
    public OperationCallSettings.Builder<
            CommitConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        commitConversionWorkspaceOperationSettings() {
      return commitConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackConversionWorkspace. */
    public UnaryCallSettings.Builder<RollbackConversionWorkspaceRequest, Operation>
        rollbackConversionWorkspaceSettings() {
      return rollbackConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackConversionWorkspace. */
    public OperationCallSettings.Builder<
            RollbackConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        rollbackConversionWorkspaceOperationSettings() {
      return rollbackConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to applyConversionWorkspace. */
    public UnaryCallSettings.Builder<ApplyConversionWorkspaceRequest, Operation>
        applyConversionWorkspaceSettings() {
      return applyConversionWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to applyConversionWorkspace. */
    public OperationCallSettings.Builder<
            ApplyConversionWorkspaceRequest, ConversionWorkspace, OperationMetadata>
        applyConversionWorkspaceOperationSettings() {
      return applyConversionWorkspaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to describeDatabaseEntities. */
    public PagedCallSettings.Builder<
            DescribeDatabaseEntitiesRequest,
            DescribeDatabaseEntitiesResponse,
            DescribeDatabaseEntitiesPagedResponse>
        describeDatabaseEntitiesSettings() {
      return describeDatabaseEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to searchBackgroundJobs. */
    public UnaryCallSettings.Builder<SearchBackgroundJobsRequest, SearchBackgroundJobsResponse>
        searchBackgroundJobsSettings() {
      return searchBackgroundJobsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to describeConversionWorkspaceRevisions.
     */
    public UnaryCallSettings.Builder<
            DescribeConversionWorkspaceRevisionsRequest,
            DescribeConversionWorkspaceRevisionsResponse>
        describeConversionWorkspaceRevisionsSettings() {
      return describeConversionWorkspaceRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchStaticIps. */
    public PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings() {
      return fetchStaticIpsSettings;
    }

    @Override
    public DataMigrationServiceStubSettings build() throws IOException {
      return new DataMigrationServiceStubSettings(this);
    }
  }
}
