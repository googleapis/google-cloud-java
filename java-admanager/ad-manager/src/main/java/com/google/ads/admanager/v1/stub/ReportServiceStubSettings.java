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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ReportServiceClient.FetchReportResultRowsPagedResponse;
import static com.google.ads.admanager.v1.ReportServiceClient.ListReportsPagedResponse;

import com.google.ads.admanager.v1.CreateReportRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsResponse;
import com.google.ads.admanager.v1.GetReportRequest;
import com.google.ads.admanager.v1.ListReportsRequest;
import com.google.ads.admanager.v1.ListReportsResponse;
import com.google.ads.admanager.v1.Report;
import com.google.ads.admanager.v1.RunReportMetadata;
import com.google.ads.admanager.v1.RunReportRequest;
import com.google.ads.admanager.v1.RunReportResponse;
import com.google.ads.admanager.v1.UpdateReportRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
 * Settings class to configure an instance of {@link ReportServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReportServiceStubSettings.Builder reportServiceSettingsBuilder =
 *     ReportServiceStubSettings.newBuilder();
 * reportServiceSettingsBuilder
 *     .getReportSettings()
 *     .setRetrySettings(
 *         reportServiceSettingsBuilder
 *             .getReportSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ReportServiceStubSettings reportServiceSettings = reportServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for runReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReportServiceStubSettings.Builder reportServiceSettingsBuilder =
 *     ReportServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * reportServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ReportServiceStubSettings extends StubSettings<ReportServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetReportRequest, Report> getReportSettings;
  private final PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings;
  private final UnaryCallSettings<CreateReportRequest, Report> createReportSettings;
  private final UnaryCallSettings<UpdateReportRequest, Report> updateReportSettings;
  private final UnaryCallSettings<RunReportRequest, Operation> runReportSettings;
  private final OperationCallSettings<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationSettings;
  private final PagedCallSettings<
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          FetchReportResultRowsPagedResponse>
      fetchReportResultRowsSettings;

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
              return payload.getReportsList();
            }
          };

  private static final PagedListDescriptor<
          FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>
      FETCH_REPORT_RESULT_ROWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchReportResultRowsRequest injectToken(
                FetchReportResultRowsRequest payload, String token) {
              return FetchReportResultRowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchReportResultRowsRequest injectPageSize(
                FetchReportResultRowsRequest payload, int pageSize) {
              return FetchReportResultRowsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchReportResultRowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchReportResultRowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Report.DataTable.Row> extractResources(
                FetchReportResultRowsResponse payload) {
              return payload.getRowsList();
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
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          FetchReportResultRowsPagedResponse>
      FETCH_REPORT_RESULT_ROWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchReportResultRowsRequest,
              FetchReportResultRowsResponse,
              FetchReportResultRowsPagedResponse>() {
            @Override
            public ApiFuture<FetchReportResultRowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsResponse> callable,
                FetchReportResultRowsRequest request,
                ApiCallContext context,
                ApiFuture<FetchReportResultRowsResponse> futureResponse) {
              PageContext<
                      FetchReportResultRowsRequest,
                      FetchReportResultRowsResponse,
                      Report.DataTable.Row>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_REPORT_RESULT_ROWS_PAGE_STR_DESC, request, context);
              return FetchReportResultRowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getReport. */
  public UnaryCallSettings<GetReportRequest, Report> getReportSettings() {
    return getReportSettings;
  }

  /** Returns the object with the settings used for calls to listReports. */
  public PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings() {
    return listReportsSettings;
  }

  /** Returns the object with the settings used for calls to createReport. */
  public UnaryCallSettings<CreateReportRequest, Report> createReportSettings() {
    return createReportSettings;
  }

  /** Returns the object with the settings used for calls to updateReport. */
  public UnaryCallSettings<UpdateReportRequest, Report> updateReportSettings() {
    return updateReportSettings;
  }

  /** Returns the object with the settings used for calls to runReport. */
  public UnaryCallSettings<RunReportRequest, Operation> runReportSettings() {
    return runReportSettings;
  }

  /** Returns the object with the settings used for calls to runReport. */
  public OperationCallSettings<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationSettings() {
    return runReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchReportResultRows. */
  public PagedCallSettings<
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          FetchReportResultRowsPagedResponse>
      fetchReportResultRowsSettings() {
    return fetchReportResultRowsSettings;
  }

  public ReportServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonReportServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ReportServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected ReportServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getReportSettings = settingsBuilder.getReportSettings().build();
    listReportsSettings = settingsBuilder.listReportsSettings().build();
    createReportSettings = settingsBuilder.createReportSettings().build();
    updateReportSettings = settingsBuilder.updateReportSettings().build();
    runReportSettings = settingsBuilder.runReportSettings().build();
    runReportOperationSettings = settingsBuilder.runReportOperationSettings().build();
    fetchReportResultRowsSettings = settingsBuilder.fetchReportResultRowsSettings().build();
  }

  /** Builder for ReportServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ReportServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetReportRequest, Report> getReportSettings;
    private final PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings;
    private final UnaryCallSettings.Builder<CreateReportRequest, Report> createReportSettings;
    private final UnaryCallSettings.Builder<UpdateReportRequest, Report> updateReportSettings;
    private final UnaryCallSettings.Builder<RunReportRequest, Operation> runReportSettings;
    private final OperationCallSettings.Builder<
            RunReportRequest, RunReportResponse, RunReportMetadata>
        runReportOperationSettings;
    private final PagedCallSettings.Builder<
            FetchReportResultRowsRequest,
            FetchReportResultRowsResponse,
            FetchReportResultRowsPagedResponse>
        fetchReportResultRowsSettings;
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

      getReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReportsSettings = PagedCallSettings.newBuilder(LIST_REPORTS_PAGE_STR_FACT);
      createReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runReportOperationSettings = OperationCallSettings.newBuilder();
      fetchReportResultRowsSettings =
          PagedCallSettings.newBuilder(FETCH_REPORT_RESULT_ROWS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReportSettings,
              listReportsSettings,
              createReportSettings,
              updateReportSettings,
              runReportSettings,
              fetchReportResultRowsSettings);
      initDefaults(this);
    }

    protected Builder(ReportServiceStubSettings settings) {
      super(settings);

      getReportSettings = settings.getReportSettings.toBuilder();
      listReportsSettings = settings.listReportsSettings.toBuilder();
      createReportSettings = settings.createReportSettings.toBuilder();
      updateReportSettings = settings.updateReportSettings.toBuilder();
      runReportSettings = settings.runReportSettings.toBuilder();
      runReportOperationSettings = settings.runReportOperationSettings.toBuilder();
      fetchReportResultRowsSettings = settings.fetchReportResultRowsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReportSettings,
              listReportsSettings,
              createReportSettings,
              updateReportSettings,
              runReportSettings,
              fetchReportResultRowsSettings);
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
          .getReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .runReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchReportResultRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .runReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<RunReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RunReportResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RunReportMetadata.class))
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

    /** Returns the builder for the settings used for calls to createReport. */
    public UnaryCallSettings.Builder<CreateReportRequest, Report> createReportSettings() {
      return createReportSettings;
    }

    /** Returns the builder for the settings used for calls to updateReport. */
    public UnaryCallSettings.Builder<UpdateReportRequest, Report> updateReportSettings() {
      return updateReportSettings;
    }

    /** Returns the builder for the settings used for calls to runReport. */
    public UnaryCallSettings.Builder<RunReportRequest, Operation> runReportSettings() {
      return runReportSettings;
    }

    /** Returns the builder for the settings used for calls to runReport. */
    public OperationCallSettings.Builder<RunReportRequest, RunReportResponse, RunReportMetadata>
        runReportOperationSettings() {
      return runReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchReportResultRows. */
    public PagedCallSettings.Builder<
            FetchReportResultRowsRequest,
            FetchReportResultRowsResponse,
            FetchReportResultRowsPagedResponse>
        fetchReportResultRowsSettings() {
      return fetchReportResultRowsSettings;
    }

    @Override
    public ReportServiceStubSettings build() throws IOException {
      return new ReportServiceStubSettings(this);
    }
  }
}
