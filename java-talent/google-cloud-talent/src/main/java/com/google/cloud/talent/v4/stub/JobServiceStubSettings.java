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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

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
import com.google.cloud.talent.v4.BatchCreateJobsRequest;
import com.google.cloud.talent.v4.BatchCreateJobsResponse;
import com.google.cloud.talent.v4.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4.BatchDeleteJobsResponse;
import com.google.cloud.talent.v4.BatchOperationMetadata;
import com.google.cloud.talent.v4.BatchUpdateJobsRequest;
import com.google.cloud.talent.v4.BatchUpdateJobsResponse;
import com.google.cloud.talent.v4.CreateJobRequest;
import com.google.cloud.talent.v4.DeleteJobRequest;
import com.google.cloud.talent.v4.GetJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.ListJobsRequest;
import com.google.cloud.talent.v4.ListJobsResponse;
import com.google.cloud.talent.v4.SearchJobsRequest;
import com.google.cloud.talent.v4.SearchJobsResponse;
import com.google.cloud.talent.v4.UpdateJobRequest;
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
 * Settings class to configure an instance of {@link JobServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (jobs.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobServiceStubSettings.Builder jobServiceSettingsBuilder = JobServiceStubSettings.newBuilder();
 * jobServiceSettingsBuilder
 *     .createJobSettings()
 *     .setRetrySettings(
 *         jobServiceSettingsBuilder.createJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobServiceStubSettings jobServiceSettings = jobServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class JobServiceStubSettings extends StubSettings<JobServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/jobs")
          .build();

  private final UnaryCallSettings<CreateJobRequest, Job> createJobSettings;
  private final UnaryCallSettings<BatchCreateJobsRequest, Operation> batchCreateJobsSettings;
  private final OperationCallSettings<
          BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings;
  private final UnaryCallSettings<BatchUpdateJobsRequest, Operation> batchUpdateJobsSettings;
  private final OperationCallSettings<
          BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationSettings;
  private final UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings;
  private final UnaryCallSettings<BatchDeleteJobsRequest, Operation> batchDeleteJobsSettings;
  private final OperationCallSettings<
          BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationSettings;
  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsSettings;
  private final UnaryCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertSettings;

  private static final PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>
      LIST_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobsRequest injectToken(ListJobsRequest payload, String token) {
              return ListJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobsRequest injectPageSize(ListJobsRequest payload, int pageSize) {
              return ListJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Job> extractResources(ListJobsResponse payload) {
              return payload.getJobsList() == null
                  ? ImmutableList.<Job>of()
                  : payload.getJobsList();
            }
          };

  private static final PagedListResponseFactory<
          ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      LIST_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>() {
            @Override
            public ApiFuture<ListJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobsRequest, ListJobsResponse> callable,
                ListJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListJobsResponse> futureResponse) {
              PageContext<ListJobsRequest, ListJobsResponse, Job> pageContext =
                  PageContext.create(callable, LIST_JOBS_PAGE_STR_DESC, request, context);
              return ListJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return createJobSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateJobs. */
  public UnaryCallSettings<BatchCreateJobsRequest, Operation> batchCreateJobsSettings() {
    return batchCreateJobsSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateJobs. */
  public OperationCallSettings<
          BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationSettings() {
    return batchCreateJobsOperationSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings() {
    return updateJobSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateJobs. */
  public UnaryCallSettings<BatchUpdateJobsRequest, Operation> batchUpdateJobsSettings() {
    return batchUpdateJobsSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateJobs. */
  public OperationCallSettings<
          BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationSettings() {
    return batchUpdateJobsOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return deleteJobSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteJobs. */
  public UnaryCallSettings<BatchDeleteJobsRequest, Operation> batchDeleteJobsSettings() {
    return batchDeleteJobsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteJobs. */
  public OperationCallSettings<
          BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationSettings() {
    return batchDeleteJobsOperationSettings;
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to searchJobs. */
  public UnaryCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsSettings() {
    return searchJobsSettings;
  }

  /** Returns the object with the settings used for calls to searchJobsForAlert. */
  public UnaryCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertSettings() {
    return searchJobsForAlertSettings;
  }

  public JobServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcJobServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonJobServiceStub.create(this);
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
    return "jobs.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "jobs.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(JobServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(JobServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return JobServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected JobServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createJobSettings = settingsBuilder.createJobSettings().build();
    batchCreateJobsSettings = settingsBuilder.batchCreateJobsSettings().build();
    batchCreateJobsOperationSettings = settingsBuilder.batchCreateJobsOperationSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    updateJobSettings = settingsBuilder.updateJobSettings().build();
    batchUpdateJobsSettings = settingsBuilder.batchUpdateJobsSettings().build();
    batchUpdateJobsOperationSettings = settingsBuilder.batchUpdateJobsOperationSettings().build();
    deleteJobSettings = settingsBuilder.deleteJobSettings().build();
    batchDeleteJobsSettings = settingsBuilder.batchDeleteJobsSettings().build();
    batchDeleteJobsOperationSettings = settingsBuilder.batchDeleteJobsOperationSettings().build();
    listJobsSettings = settingsBuilder.listJobsSettings().build();
    searchJobsSettings = settingsBuilder.searchJobsSettings().build();
    searchJobsForAlertSettings = settingsBuilder.searchJobsForAlertSettings().build();
  }

  /** Builder for JobServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<JobServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings;
    private final UnaryCallSettings.Builder<BatchCreateJobsRequest, Operation>
        batchCreateJobsSettings;
    private final OperationCallSettings.Builder<
            BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
        batchCreateJobsOperationSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings;
    private final UnaryCallSettings.Builder<BatchUpdateJobsRequest, Operation>
        batchUpdateJobsSettings;
    private final OperationCallSettings.Builder<
            BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
        batchUpdateJobsOperationSettings;
    private final UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings;
    private final UnaryCallSettings.Builder<BatchDeleteJobsRequest, Operation>
        batchDeleteJobsSettings;
    private final OperationCallSettings.Builder<
            BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
        batchDeleteJobsOperationSettings;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<SearchJobsRequest, SearchJobsResponse>
        searchJobsSettings;
    private final UnaryCallSettings.Builder<SearchJobsRequest, SearchJobsResponse>
        searchJobsForAlertSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateJobsOperationSettings = OperationCallSettings.newBuilder();
      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateJobsOperationSettings = OperationCallSettings.newBuilder();
      deleteJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteJobsOperationSettings = OperationCallSettings.newBuilder();
      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);
      searchJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchJobsForAlertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              batchCreateJobsSettings,
              getJobSettings,
              updateJobSettings,
              batchUpdateJobsSettings,
              deleteJobSettings,
              batchDeleteJobsSettings,
              listJobsSettings,
              searchJobsSettings,
              searchJobsForAlertSettings);
      initDefaults(this);
    }

    protected Builder(JobServiceStubSettings settings) {
      super(settings);

      createJobSettings = settings.createJobSettings.toBuilder();
      batchCreateJobsSettings = settings.batchCreateJobsSettings.toBuilder();
      batchCreateJobsOperationSettings = settings.batchCreateJobsOperationSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      updateJobSettings = settings.updateJobSettings.toBuilder();
      batchUpdateJobsSettings = settings.batchUpdateJobsSettings.toBuilder();
      batchUpdateJobsOperationSettings = settings.batchUpdateJobsOperationSettings.toBuilder();
      deleteJobSettings = settings.deleteJobSettings.toBuilder();
      batchDeleteJobsSettings = settings.batchDeleteJobsSettings.toBuilder();
      batchDeleteJobsOperationSettings = settings.batchDeleteJobsOperationSettings.toBuilder();
      listJobsSettings = settings.listJobsSettings.toBuilder();
      searchJobsSettings = settings.searchJobsSettings.toBuilder();
      searchJobsForAlertSettings = settings.searchJobsForAlertSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              batchCreateJobsSettings,
              getJobSettings,
              updateJobSettings,
              batchUpdateJobsSettings,
              deleteJobSettings,
              batchDeleteJobsSettings,
              listJobsSettings,
              searchJobsSettings,
              searchJobsForAlertSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .batchCreateJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .batchUpdateJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deleteJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .batchDeleteJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .searchJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .searchJobsForAlertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .batchCreateJobsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateJobsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchCreateJobsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchOperationMetadata.class))
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
          .batchUpdateJobsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchUpdateJobsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchUpdateJobsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchOperationMetadata.class))
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
          .batchDeleteJobsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteJobsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchDeleteJobsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createJob. */
    public UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings() {
      return createJobSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateJobs. */
    public UnaryCallSettings.Builder<BatchCreateJobsRequest, Operation> batchCreateJobsSettings() {
      return batchCreateJobsSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateJobs. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
        batchCreateJobsOperationSettings() {
      return batchCreateJobsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings() {
      return updateJobSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateJobs. */
    public UnaryCallSettings.Builder<BatchUpdateJobsRequest, Operation> batchUpdateJobsSettings() {
      return batchUpdateJobsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateJobs. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
        batchUpdateJobsOperationSettings() {
      return batchUpdateJobsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return deleteJobSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteJobs. */
    public UnaryCallSettings.Builder<BatchDeleteJobsRequest, Operation> batchDeleteJobsSettings() {
      return batchDeleteJobsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteJobs. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
        batchDeleteJobsOperationSettings() {
      return batchDeleteJobsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to searchJobs. */
    public UnaryCallSettings.Builder<SearchJobsRequest, SearchJobsResponse> searchJobsSettings() {
      return searchJobsSettings;
    }

    /** Returns the builder for the settings used for calls to searchJobsForAlert. */
    public UnaryCallSettings.Builder<SearchJobsRequest, SearchJobsResponse>
        searchJobsForAlertSettings() {
      return searchJobsForAlertSettings;
    }

    @Override
    public JobServiceStubSettings build() throws IOException {
      return new JobServiceStubSettings(this);
    }
  }
}
