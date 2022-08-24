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

package com.google.cloud.batch.v1alpha.stub;

import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListJobsPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListTasksPagedResponse;

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
import com.google.cloud.batch.v1alpha.CreateJobRequest;
import com.google.cloud.batch.v1alpha.DeleteJobRequest;
import com.google.cloud.batch.v1alpha.GetJobRequest;
import com.google.cloud.batch.v1alpha.GetTaskRequest;
import com.google.cloud.batch.v1alpha.Job;
import com.google.cloud.batch.v1alpha.ListJobsRequest;
import com.google.cloud.batch.v1alpha.ListJobsResponse;
import com.google.cloud.batch.v1alpha.ListTasksRequest;
import com.google.cloud.batch.v1alpha.ListTasksResponse;
import com.google.cloud.batch.v1alpha.OperationMetadata;
import com.google.cloud.batch.v1alpha.Task;
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
 * Settings class to configure an instance of {@link BatchServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li> The default service address (batch.googleapis.com) and default port (443) are used.
 *   <li> Credentials are acquired automatically through Application Default Credentials.
 *   <li> Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * BatchServiceStubSettings.Builder batchServiceSettingsBuilder =
 *     BatchServiceStubSettings.newBuilder();
 * batchServiceSettingsBuilder
 *     .createJobSettings()
 *     .setRetrySettings(
 *         batchServiceSettingsBuilder
 *             .createJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BatchServiceStubSettings batchServiceSettings = batchServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BatchServiceStubSettings extends StubSettings<BatchServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateJobRequest, Job> createJobSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final UnaryCallSettings<DeleteJobRequest, Operation> deleteJobSettings;
  private final OperationCallSettings<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationSettings;
  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<GetTaskRequest, Task> getTaskSettings;
  private final PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings;

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

  private static final PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>
      LIST_TASKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTasksRequest injectToken(ListTasksRequest payload, String token) {
              return ListTasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTasksRequest injectPageSize(ListTasksRequest payload, int pageSize) {
              return ListTasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Task> extractResources(ListTasksResponse payload) {
              return payload.getTasksList() == null
                  ? ImmutableList.<Task>of()
                  : payload.getTasksList();
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

  private static final PagedListResponseFactory<
          ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      LIST_TASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>() {
            @Override
            public ApiFuture<ListTasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTasksRequest, ListTasksResponse> callable,
                ListTasksRequest request,
                ApiCallContext context,
                ApiFuture<ListTasksResponse> futureResponse) {
              PageContext<ListTasksRequest, ListTasksResponse, Task> pageContext =
                  PageContext.create(callable, LIST_TASKS_PAGE_STR_DESC, request, context);
              return ListTasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return createJobSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Operation> deleteJobSettings() {
    return deleteJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public OperationCallSettings<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationSettings() {
    return deleteJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return getTaskSettings;
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return listTasksSettings;
  }

  public BatchServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBatchServiceStub.create(this);
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
    return "batch.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "batch.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BatchServiceStubSettings.class))
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

  protected BatchServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createJobSettings = settingsBuilder.createJobSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    deleteJobSettings = settingsBuilder.deleteJobSettings().build();
    deleteJobOperationSettings = settingsBuilder.deleteJobOperationSettings().build();
    listJobsSettings = settingsBuilder.listJobsSettings().build();
    getTaskSettings = settingsBuilder.getTaskSettings().build();
    listTasksSettings = settingsBuilder.listTasksSettings().build();
  }

  /** Builder for BatchServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<BatchServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final UnaryCallSettings.Builder<DeleteJobRequest, Operation> deleteJobSettings;
    private final OperationCallSettings.Builder<DeleteJobRequest, Empty, OperationMetadata>
        deleteJobOperationSettings;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings;
    private final PagedCallSettings.Builder<
            ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings;
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

      createJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteJobOperationSettings = OperationCallSettings.newBuilder();
      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);
      getTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTasksSettings = PagedCallSettings.newBuilder(LIST_TASKS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              getJobSettings,
              deleteJobSettings,
              listJobsSettings,
              getTaskSettings,
              listTasksSettings);
      initDefaults(this);
    }

    protected Builder(BatchServiceStubSettings settings) {
      super(settings);

      createJobSettings = settings.createJobSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      deleteJobSettings = settings.deleteJobSettings.toBuilder();
      deleteJobOperationSettings = settings.deleteJobOperationSettings.toBuilder();
      listJobsSettings = settings.listJobsSettings.toBuilder();
      getTaskSettings = settings.getTaskSettings.toBuilder();
      listTasksSettings = settings.listTasksSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              getJobSettings,
              deleteJobSettings,
              listJobsSettings,
              getTaskSettings,
              listTasksSettings);
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
          .createJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createJob. */
    public UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings() {
      return createJobSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Operation> deleteJobSettings() {
      return deleteJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteJobRequest, Empty, OperationMetadata>
        deleteJobOperationSettings() {
      return deleteJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getTaskSettings;
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return listTasksSettings;
    }

    @Override
    public BatchServiceStubSettings build() throws IOException {
      return new BatchServiceStubSettings(this);
    }
  }
}
