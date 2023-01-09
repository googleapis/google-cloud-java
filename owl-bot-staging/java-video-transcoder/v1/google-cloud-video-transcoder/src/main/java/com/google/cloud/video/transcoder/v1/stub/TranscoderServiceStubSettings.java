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

package com.google.cloud.video.transcoder.v1.stub;

import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobsPagedResponse;

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
import com.google.cloud.video.transcoder.v1.CreateJobRequest;
import com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.GetJobRequest;
import com.google.cloud.video.transcoder.v1.GetJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.Job;
import com.google.cloud.video.transcoder.v1.JobTemplate;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse;
import com.google.cloud.video.transcoder.v1.ListJobsRequest;
import com.google.cloud.video.transcoder.v1.ListJobsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TranscoderServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (transcoder.googleapis.com) and default port (443) are used.
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
 * TranscoderServiceStubSettings.Builder transcoderServiceSettingsBuilder =
 *     TranscoderServiceStubSettings.newBuilder();
 * transcoderServiceSettingsBuilder
 *     .createJobSettings()
 *     .setRetrySettings(
 *         transcoderServiceSettingsBuilder
 *             .createJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TranscoderServiceStubSettings transcoderServiceSettings =
 *     transcoderServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TranscoderServiceStubSettings extends StubSettings<TranscoderServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateJobRequest, Job> createJobSettings;
  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings;
  private final UnaryCallSettings<CreateJobTemplateRequest, JobTemplate> createJobTemplateSettings;
  private final PagedCallSettings<
          ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
      listJobTemplatesSettings;
  private final UnaryCallSettings<GetJobTemplateRequest, JobTemplate> getJobTemplateSettings;
  private final UnaryCallSettings<DeleteJobTemplateRequest, Empty> deleteJobTemplateSettings;

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

  private static final PagedListDescriptor<
          ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate>
      LIST_JOB_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobTemplatesRequest injectToken(
                ListJobTemplatesRequest payload, String token) {
              return ListJobTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobTemplatesRequest injectPageSize(
                ListJobTemplatesRequest payload, int pageSize) {
              return ListJobTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<JobTemplate> extractResources(ListJobTemplatesResponse payload) {
              return payload.getJobTemplatesList() == null
                  ? ImmutableList.<JobTemplate>of()
                  : payload.getJobTemplatesList();
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
          ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
      LIST_JOB_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListJobTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesResponse> callable,
                ListJobTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListJobTemplatesResponse> futureResponse) {
              PageContext<ListJobTemplatesRequest, ListJobTemplatesResponse, JobTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_JOB_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListJobTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return createJobSettings;
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return deleteJobSettings;
  }

  /** Returns the object with the settings used for calls to createJobTemplate. */
  public UnaryCallSettings<CreateJobTemplateRequest, JobTemplate> createJobTemplateSettings() {
    return createJobTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listJobTemplates. */
  public PagedCallSettings<
          ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
      listJobTemplatesSettings() {
    return listJobTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to getJobTemplate. */
  public UnaryCallSettings<GetJobTemplateRequest, JobTemplate> getJobTemplateSettings() {
    return getJobTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteJobTemplate. */
  public UnaryCallSettings<DeleteJobTemplateRequest, Empty> deleteJobTemplateSettings() {
    return deleteJobTemplateSettings;
  }

  public TranscoderServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTranscoderServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTranscoderServiceStub.create(this);
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
    return "transcoder.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "transcoder.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(TranscoderServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TranscoderServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TranscoderServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TranscoderServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createJobSettings = settingsBuilder.createJobSettings().build();
    listJobsSettings = settingsBuilder.listJobsSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    deleteJobSettings = settingsBuilder.deleteJobSettings().build();
    createJobTemplateSettings = settingsBuilder.createJobTemplateSettings().build();
    listJobTemplatesSettings = settingsBuilder.listJobTemplatesSettings().build();
    getJobTemplateSettings = settingsBuilder.getJobTemplateSettings().build();
    deleteJobTemplateSettings = settingsBuilder.deleteJobTemplateSettings().build();
  }

  /** Builder for TranscoderServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TranscoderServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings;
    private final UnaryCallSettings.Builder<CreateJobTemplateRequest, JobTemplate>
        createJobTemplateSettings;
    private final PagedCallSettings.Builder<
            ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
        listJobTemplatesSettings;
    private final UnaryCallSettings.Builder<GetJobTemplateRequest, JobTemplate>
        getJobTemplateSettings;
    private final UnaryCallSettings.Builder<DeleteJobTemplateRequest, Empty>
        deleteJobTemplateSettings;
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

      createJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);
      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createJobTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listJobTemplatesSettings = PagedCallSettings.newBuilder(LIST_JOB_TEMPLATES_PAGE_STR_FACT);
      getJobTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteJobTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              listJobsSettings,
              getJobSettings,
              deleteJobSettings,
              createJobTemplateSettings,
              listJobTemplatesSettings,
              getJobTemplateSettings,
              deleteJobTemplateSettings);
      initDefaults(this);
    }

    protected Builder(TranscoderServiceStubSettings settings) {
      super(settings);

      createJobSettings = settings.createJobSettings.toBuilder();
      listJobsSettings = settings.listJobsSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      deleteJobSettings = settings.deleteJobSettings.toBuilder();
      createJobTemplateSettings = settings.createJobTemplateSettings.toBuilder();
      listJobTemplatesSettings = settings.listJobTemplatesSettings.toBuilder();
      getJobTemplateSettings = settings.getJobTemplateSettings.toBuilder();
      deleteJobTemplateSettings = settings.deleteJobTemplateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createJobSettings,
              listJobsSettings,
              getJobSettings,
              deleteJobSettings,
              createJobTemplateSettings,
              listJobTemplatesSettings,
              getJobTemplateSettings,
              deleteJobTemplateSettings);
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
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createJobTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listJobTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getJobTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteJobTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return deleteJobSettings;
    }

    /** Returns the builder for the settings used for calls to createJobTemplate. */
    public UnaryCallSettings.Builder<CreateJobTemplateRequest, JobTemplate>
        createJobTemplateSettings() {
      return createJobTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listJobTemplates. */
    public PagedCallSettings.Builder<
            ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
        listJobTemplatesSettings() {
      return listJobTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to getJobTemplate. */
    public UnaryCallSettings.Builder<GetJobTemplateRequest, JobTemplate> getJobTemplateSettings() {
      return getJobTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJobTemplate. */
    public UnaryCallSettings.Builder<DeleteJobTemplateRequest, Empty> deleteJobTemplateSettings() {
      return deleteJobTemplateSettings;
    }

    @Override
    public TranscoderServiceStubSettings build() throws IOException {
      return new TranscoderServiceStubSettings(this);
    }
  }
}
