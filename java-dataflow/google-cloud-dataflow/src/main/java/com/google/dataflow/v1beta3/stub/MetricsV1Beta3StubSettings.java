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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetJobExecutionDetailsPagedResponse;
import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetStageExecutionDetailsPagedResponse;

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
import com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest;
import com.google.dataflow.v1beta3.GetJobMetricsRequest;
import com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest;
import com.google.dataflow.v1beta3.JobExecutionDetails;
import com.google.dataflow.v1beta3.JobMetrics;
import com.google.dataflow.v1beta3.StageExecutionDetails;
import com.google.dataflow.v1beta3.StageSummary;
import com.google.dataflow.v1beta3.WorkerDetails;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricsV1Beta3Stub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getJobMetrics to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsV1Beta3StubSettings.Builder metricsV1Beta3SettingsBuilder =
 *     MetricsV1Beta3StubSettings.newBuilder();
 * metricsV1Beta3SettingsBuilder
 *     .getJobMetricsSettings()
 *     .setRetrySettings(
 *         metricsV1Beta3SettingsBuilder
 *             .getJobMetricsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricsV1Beta3StubSettings metricsV1Beta3Settings = metricsV1Beta3SettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetricsV1Beta3StubSettings extends StubSettings<MetricsV1Beta3StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/userinfo.email")
          .build();

  private final UnaryCallSettings<GetJobMetricsRequest, JobMetrics> getJobMetricsSettings;
  private final PagedCallSettings<
          GetJobExecutionDetailsRequest, JobExecutionDetails, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsSettings;
  private final PagedCallSettings<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsSettings;

  private static final PagedListDescriptor<
          GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary>
      GET_JOB_EXECUTION_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GetJobExecutionDetailsRequest injectToken(
                GetJobExecutionDetailsRequest payload, String token) {
              return GetJobExecutionDetailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public GetJobExecutionDetailsRequest injectPageSize(
                GetJobExecutionDetailsRequest payload, int pageSize) {
              return GetJobExecutionDetailsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GetJobExecutionDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(JobExecutionDetails payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StageSummary> extractResources(JobExecutionDetails payload) {
              return payload.getStagesList() == null
                  ? ImmutableList.<StageSummary>of()
                  : payload.getStagesList();
            }
          };

  private static final PagedListDescriptor<
          GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails>
      GET_STAGE_EXECUTION_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GetStageExecutionDetailsRequest injectToken(
                GetStageExecutionDetailsRequest payload, String token) {
              return GetStageExecutionDetailsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public GetStageExecutionDetailsRequest injectPageSize(
                GetStageExecutionDetailsRequest payload, int pageSize) {
              return GetStageExecutionDetailsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GetStageExecutionDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(StageExecutionDetails payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkerDetails> extractResources(StageExecutionDetails payload) {
              return payload.getWorkersList() == null
                  ? ImmutableList.<WorkerDetails>of()
                  : payload.getWorkersList();
            }
          };

  private static final PagedListResponseFactory<
          GetJobExecutionDetailsRequest, JobExecutionDetails, GetJobExecutionDetailsPagedResponse>
      GET_JOB_EXECUTION_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GetJobExecutionDetailsRequest,
              JobExecutionDetails,
              GetJobExecutionDetailsPagedResponse>() {
            @Override
            public ApiFuture<GetJobExecutionDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails> callable,
                GetJobExecutionDetailsRequest request,
                ApiCallContext context,
                ApiFuture<JobExecutionDetails> futureResponse) {
              PageContext<GetJobExecutionDetailsRequest, JobExecutionDetails, StageSummary>
                  pageContext =
                      PageContext.create(
                          callable, GET_JOB_EXECUTION_DETAILS_PAGE_STR_DESC, request, context);
              return GetJobExecutionDetailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          GetStageExecutionDetailsPagedResponse>
      GET_STAGE_EXECUTION_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GetStageExecutionDetailsRequest,
              StageExecutionDetails,
              GetStageExecutionDetailsPagedResponse>() {
            @Override
            public ApiFuture<GetStageExecutionDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails> callable,
                GetStageExecutionDetailsRequest request,
                ApiCallContext context,
                ApiFuture<StageExecutionDetails> futureResponse) {
              PageContext<GetStageExecutionDetailsRequest, StageExecutionDetails, WorkerDetails>
                  pageContext =
                      PageContext.create(
                          callable, GET_STAGE_EXECUTION_DETAILS_PAGE_STR_DESC, request, context);
              return GetStageExecutionDetailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getJobMetrics. */
  public UnaryCallSettings<GetJobMetricsRequest, JobMetrics> getJobMetricsSettings() {
    return getJobMetricsSettings;
  }

  /** Returns the object with the settings used for calls to getJobExecutionDetails. */
  public PagedCallSettings<
          GetJobExecutionDetailsRequest, JobExecutionDetails, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsSettings() {
    return getJobExecutionDetailsSettings;
  }

  /** Returns the object with the settings used for calls to getStageExecutionDetails. */
  public PagedCallSettings<
          GetStageExecutionDetailsRequest,
          StageExecutionDetails,
          GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsSettings() {
    return getStageExecutionDetailsSettings;
  }

  public MetricsV1Beta3Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetricsV1Beta3Stub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMetricsV1Beta3Stub.create(this);
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
    return "dataflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataflow.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MetricsV1Beta3StubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetricsV1Beta3StubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetricsV1Beta3StubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MetricsV1Beta3StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getJobMetricsSettings = settingsBuilder.getJobMetricsSettings().build();
    getJobExecutionDetailsSettings = settingsBuilder.getJobExecutionDetailsSettings().build();
    getStageExecutionDetailsSettings = settingsBuilder.getStageExecutionDetailsSettings().build();
  }

  /** Builder for MetricsV1Beta3StubSettings. */
  public static class Builder extends StubSettings.Builder<MetricsV1Beta3StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetJobMetricsRequest, JobMetrics> getJobMetricsSettings;
    private final PagedCallSettings.Builder<
            GetJobExecutionDetailsRequest, JobExecutionDetails, GetJobExecutionDetailsPagedResponse>
        getJobExecutionDetailsSettings;
    private final PagedCallSettings.Builder<
            GetStageExecutionDetailsRequest,
            StageExecutionDetails,
            GetStageExecutionDetailsPagedResponse>
        getStageExecutionDetailsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getJobMetricsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getJobExecutionDetailsSettings =
          PagedCallSettings.newBuilder(GET_JOB_EXECUTION_DETAILS_PAGE_STR_FACT);
      getStageExecutionDetailsSettings =
          PagedCallSettings.newBuilder(GET_STAGE_EXECUTION_DETAILS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getJobMetricsSettings,
              getJobExecutionDetailsSettings,
              getStageExecutionDetailsSettings);
      initDefaults(this);
    }

    protected Builder(MetricsV1Beta3StubSettings settings) {
      super(settings);

      getJobMetricsSettings = settings.getJobMetricsSettings.toBuilder();
      getJobExecutionDetailsSettings = settings.getJobExecutionDetailsSettings.toBuilder();
      getStageExecutionDetailsSettings = settings.getStageExecutionDetailsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getJobMetricsSettings,
              getJobExecutionDetailsSettings,
              getStageExecutionDetailsSettings);
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
          .getJobMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getJobExecutionDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getStageExecutionDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to getJobMetrics. */
    public UnaryCallSettings.Builder<GetJobMetricsRequest, JobMetrics> getJobMetricsSettings() {
      return getJobMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to getJobExecutionDetails. */
    public PagedCallSettings.Builder<
            GetJobExecutionDetailsRequest, JobExecutionDetails, GetJobExecutionDetailsPagedResponse>
        getJobExecutionDetailsSettings() {
      return getJobExecutionDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to getStageExecutionDetails. */
    public PagedCallSettings.Builder<
            GetStageExecutionDetailsRequest,
            StageExecutionDetails,
            GetStageExecutionDetailsPagedResponse>
        getStageExecutionDetailsSettings() {
      return getStageExecutionDetailsSettings;
    }

    @Override
    public MetricsV1Beta3StubSettings build() throws IOException {
      return new MetricsV1Beta3StubSettings(this);
    }
  }
}
