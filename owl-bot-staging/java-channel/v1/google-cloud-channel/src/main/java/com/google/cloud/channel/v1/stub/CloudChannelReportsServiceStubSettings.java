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

package com.google.cloud.channel.v1.stub;

import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.FetchReportResultsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.ListReportsPagedResponse;

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
import com.google.cloud.channel.v1.FetchReportResultsRequest;
import com.google.cloud.channel.v1.FetchReportResultsResponse;
import com.google.cloud.channel.v1.ListReportsRequest;
import com.google.cloud.channel.v1.ListReportsResponse;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.Report;
import com.google.cloud.channel.v1.Row;
import com.google.cloud.channel.v1.RunReportJobRequest;
import com.google.cloud.channel.v1.RunReportJobResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudChannelReportsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudchannel.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of runReportJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudChannelReportsServiceStubSettings.Builder cloudChannelReportsServiceSettingsBuilder =
 *     CloudChannelReportsServiceStubSettings.newBuilder();
 * cloudChannelReportsServiceSettingsBuilder
 *     .runReportJobSettings()
 *     .setRetrySettings(
 *         cloudChannelReportsServiceSettingsBuilder
 *             .runReportJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudChannelReportsServiceStubSettings cloudChannelReportsServiceSettings =
 *     cloudChannelReportsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudChannelReportsServiceStubSettings
    extends StubSettings<CloudChannelReportsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/apps.reports.usage.readonly")
          .build();

  private final UnaryCallSettings<RunReportJobRequest, Operation> runReportJobSettings;
  private final OperationCallSettings<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationSettings;
  private final PagedCallSettings<
          FetchReportResultsRequest, FetchReportResultsResponse, FetchReportResultsPagedResponse>
      fetchReportResultsSettings;
  private final PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings;

  private static final PagedListDescriptor<
          FetchReportResultsRequest, FetchReportResultsResponse, Row>
      FETCH_REPORT_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchReportResultsRequest, FetchReportResultsResponse, Row>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchReportResultsRequest injectToken(
                FetchReportResultsRequest payload, String token) {
              return FetchReportResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchReportResultsRequest injectPageSize(
                FetchReportResultsRequest payload, int pageSize) {
              return FetchReportResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchReportResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchReportResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Row> extractResources(FetchReportResultsResponse payload) {
              return payload.getRowsList() == null
                  ? ImmutableList.<Row>of()
                  : payload.getRowsList();
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

  private static final PagedListResponseFactory<
          FetchReportResultsRequest, FetchReportResultsResponse, FetchReportResultsPagedResponse>
      FETCH_REPORT_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchReportResultsRequest,
              FetchReportResultsResponse,
              FetchReportResultsPagedResponse>() {
            @Override
            public ApiFuture<FetchReportResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchReportResultsRequest, FetchReportResultsResponse> callable,
                FetchReportResultsRequest request,
                ApiCallContext context,
                ApiFuture<FetchReportResultsResponse> futureResponse) {
              PageContext<FetchReportResultsRequest, FetchReportResultsResponse, Row> pageContext =
                  PageContext.create(
                      callable, FETCH_REPORT_RESULTS_PAGE_STR_DESC, request, context);
              return FetchReportResultsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to runReportJob. */
  public UnaryCallSettings<RunReportJobRequest, Operation> runReportJobSettings() {
    return runReportJobSettings;
  }

  /** Returns the object with the settings used for calls to runReportJob. */
  public OperationCallSettings<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationSettings() {
    return runReportJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchReportResults. */
  public PagedCallSettings<
          FetchReportResultsRequest, FetchReportResultsResponse, FetchReportResultsPagedResponse>
      fetchReportResultsSettings() {
    return fetchReportResultsSettings;
  }

  /** Returns the object with the settings used for calls to listReports. */
  public PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings() {
    return listReportsSettings;
  }

  public CloudChannelReportsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudChannelReportsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudChannelReportsServiceStub.create(this);
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
    return "cloudchannel.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudchannel.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudChannelReportsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudChannelReportsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudChannelReportsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudChannelReportsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    runReportJobSettings = settingsBuilder.runReportJobSettings().build();
    runReportJobOperationSettings = settingsBuilder.runReportJobOperationSettings().build();
    fetchReportResultsSettings = settingsBuilder.fetchReportResultsSettings().build();
    listReportsSettings = settingsBuilder.listReportsSettings().build();
  }

  /** Builder for CloudChannelReportsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CloudChannelReportsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<RunReportJobRequest, Operation> runReportJobSettings;
    private final OperationCallSettings.Builder<
            RunReportJobRequest, RunReportJobResponse, OperationMetadata>
        runReportJobOperationSettings;
    private final PagedCallSettings.Builder<
            FetchReportResultsRequest, FetchReportResultsResponse, FetchReportResultsPagedResponse>
        fetchReportResultsSettings;
    private final PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings;
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

      runReportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runReportJobOperationSettings = OperationCallSettings.newBuilder();
      fetchReportResultsSettings = PagedCallSettings.newBuilder(FETCH_REPORT_RESULTS_PAGE_STR_FACT);
      listReportsSettings = PagedCallSettings.newBuilder(LIST_REPORTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runReportJobSettings, fetchReportResultsSettings, listReportsSettings);
      initDefaults(this);
    }

    protected Builder(CloudChannelReportsServiceStubSettings settings) {
      super(settings);

      runReportJobSettings = settings.runReportJobSettings.toBuilder();
      runReportJobOperationSettings = settings.runReportJobOperationSettings.toBuilder();
      fetchReportResultsSettings = settings.fetchReportResultsSettings.toBuilder();
      listReportsSettings = settings.listReportsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runReportJobSettings, fetchReportResultsSettings, listReportsSettings);
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
          .runReportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchReportResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .runReportJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunReportJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RunReportJobResponse.class))
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

    /** Returns the builder for the settings used for calls to runReportJob. */
    public UnaryCallSettings.Builder<RunReportJobRequest, Operation> runReportJobSettings() {
      return runReportJobSettings;
    }

    /** Returns the builder for the settings used for calls to runReportJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            RunReportJobRequest, RunReportJobResponse, OperationMetadata>
        runReportJobOperationSettings() {
      return runReportJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchReportResults. */
    public PagedCallSettings.Builder<
            FetchReportResultsRequest, FetchReportResultsResponse, FetchReportResultsPagedResponse>
        fetchReportResultsSettings() {
      return fetchReportResultsSettings;
    }

    /** Returns the builder for the settings used for calls to listReports. */
    public PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings() {
      return listReportsSettings;
    }

    @Override
    public CloudChannelReportsServiceStubSettings build() throws IOException {
      return new CloudChannelReportsServiceStubSettings(this);
    }
  }
}
