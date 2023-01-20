/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;

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
import com.google.cloud.clouddms.v1.ConnectionProfile;
import com.google.cloud.clouddms.v1.CreateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.CreateMigrationJobRequest;
import com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest;
import com.google.cloud.clouddms.v1.DeleteMigrationJobRequest;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.GetConnectionProfileRequest;
import com.google.cloud.clouddms.v1.GetMigrationJobRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesResponse;
import com.google.cloud.clouddms.v1.ListMigrationJobsRequest;
import com.google.cloud.clouddms.v1.ListMigrationJobsResponse;
import com.google.cloud.clouddms.v1.MigrationJob;
import com.google.cloud.clouddms.v1.OperationMetadata;
import com.google.cloud.clouddms.v1.PromoteMigrationJobRequest;
import com.google.cloud.clouddms.v1.RestartMigrationJobRequest;
import com.google.cloud.clouddms.v1.ResumeMigrationJobRequest;
import com.google.cloud.clouddms.v1.SshScript;
import com.google.cloud.clouddms.v1.StartMigrationJobRequest;
import com.google.cloud.clouddms.v1.StopMigrationJobRequest;
import com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest;
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
      definitions.put("no_retry_1_params", settings);
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
      listConnectionProfilesSettings =
          PagedCallSettings.newBuilder(LIST_CONNECTION_PROFILES_PAGE_STR_FACT);
      getConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      updateConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionProfileOperationSettings = OperationCallSettings.newBuilder();

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
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings);
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
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings() {
      return deleteConnectionProfileOperationSettings;
    }

    @Override
    public DataMigrationServiceStubSettings build() throws IOException {
      return new DataMigrationServiceStubSettings(this);
    }
  }
}
