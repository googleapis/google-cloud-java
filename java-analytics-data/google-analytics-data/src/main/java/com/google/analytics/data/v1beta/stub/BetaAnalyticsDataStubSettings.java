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

package com.google.analytics.data.v1beta.stub;

import static com.google.analytics.data.v1beta.BetaAnalyticsDataClient.ListAudienceExportsPagedResponse;

import com.google.analytics.data.v1beta.AudienceExport;
import com.google.analytics.data.v1beta.AudienceExportMetadata;
import com.google.analytics.data.v1beta.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1beta.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.CheckCompatibilityRequest;
import com.google.analytics.data.v1beta.CheckCompatibilityResponse;
import com.google.analytics.data.v1beta.CreateAudienceExportRequest;
import com.google.analytics.data.v1beta.GetAudienceExportRequest;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsResponse;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.QueryAudienceExportRequest;
import com.google.analytics.data.v1beta.QueryAudienceExportResponse;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
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
 * Settings class to configure an instance of {@link BetaAnalyticsDataStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticsdata.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of runReport to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BetaAnalyticsDataStubSettings.Builder betaAnalyticsDataSettingsBuilder =
 *     BetaAnalyticsDataStubSettings.newBuilder();
 * betaAnalyticsDataSettingsBuilder
 *     .runReportSettings()
 *     .setRetrySettings(
 *         betaAnalyticsDataSettingsBuilder
 *             .runReportSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BetaAnalyticsDataStubSettings betaAnalyticsDataSettings =
 *     betaAnalyticsDataSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BetaAnalyticsDataStubSettings extends StubSettings<BetaAnalyticsDataStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/analytics")
          .add("https://www.googleapis.com/auth/analytics.readonly")
          .build();

  private final UnaryCallSettings<RunReportRequest, RunReportResponse> runReportSettings;
  private final UnaryCallSettings<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportSettings;
  private final UnaryCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsSettings;
  private final UnaryCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsSettings;
  private final UnaryCallSettings<GetMetadataRequest, Metadata> getMetadataSettings;
  private final UnaryCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportSettings;
  private final UnaryCallSettings<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilitySettings;
  private final UnaryCallSettings<CreateAudienceExportRequest, Operation>
      createAudienceExportSettings;
  private final OperationCallSettings<
          CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationSettings;
  private final UnaryCallSettings<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportSettings;
  private final UnaryCallSettings<GetAudienceExportRequest, AudienceExport>
      getAudienceExportSettings;
  private final PagedCallSettings<
          ListAudienceExportsRequest, ListAudienceExportsResponse, ListAudienceExportsPagedResponse>
      listAudienceExportsSettings;

  private static final PagedListDescriptor<
          ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
      LIST_AUDIENCE_EXPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAudienceExportsRequest injectToken(
                ListAudienceExportsRequest payload, String token) {
              return ListAudienceExportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAudienceExportsRequest injectPageSize(
                ListAudienceExportsRequest payload, int pageSize) {
              return ListAudienceExportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAudienceExportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAudienceExportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AudienceExport> extractResources(ListAudienceExportsResponse payload) {
              return payload.getAudienceExportsList() == null
                  ? ImmutableList.<AudienceExport>of()
                  : payload.getAudienceExportsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAudienceExportsRequest, ListAudienceExportsResponse, ListAudienceExportsPagedResponse>
      LIST_AUDIENCE_EXPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAudienceExportsRequest,
              ListAudienceExportsResponse,
              ListAudienceExportsPagedResponse>() {
            @Override
            public ApiFuture<ListAudienceExportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsResponse> callable,
                ListAudienceExportsRequest request,
                ApiCallContext context,
                ApiFuture<ListAudienceExportsResponse> futureResponse) {
              PageContext<ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUDIENCE_EXPORTS_PAGE_STR_DESC, request, context);
              return ListAudienceExportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to runReport. */
  public UnaryCallSettings<RunReportRequest, RunReportResponse> runReportSettings() {
    return runReportSettings;
  }

  /** Returns the object with the settings used for calls to runPivotReport. */
  public UnaryCallSettings<RunPivotReportRequest, RunPivotReportResponse> runPivotReportSettings() {
    return runPivotReportSettings;
  }

  /** Returns the object with the settings used for calls to batchRunReports. */
  public UnaryCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsSettings() {
    return batchRunReportsSettings;
  }

  /** Returns the object with the settings used for calls to batchRunPivotReports. */
  public UnaryCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsSettings() {
    return batchRunPivotReportsSettings;
  }

  /** Returns the object with the settings used for calls to getMetadata. */
  public UnaryCallSettings<GetMetadataRequest, Metadata> getMetadataSettings() {
    return getMetadataSettings;
  }

  /** Returns the object with the settings used for calls to runRealtimeReport. */
  public UnaryCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportSettings() {
    return runRealtimeReportSettings;
  }

  /** Returns the object with the settings used for calls to checkCompatibility. */
  public UnaryCallSettings<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilitySettings() {
    return checkCompatibilitySettings;
  }

  /** Returns the object with the settings used for calls to createAudienceExport. */
  public UnaryCallSettings<CreateAudienceExportRequest, Operation> createAudienceExportSettings() {
    return createAudienceExportSettings;
  }

  /** Returns the object with the settings used for calls to createAudienceExport. */
  public OperationCallSettings<CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationSettings() {
    return createAudienceExportOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryAudienceExport. */
  public UnaryCallSettings<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportSettings() {
    return queryAudienceExportSettings;
  }

  /** Returns the object with the settings used for calls to getAudienceExport. */
  public UnaryCallSettings<GetAudienceExportRequest, AudienceExport> getAudienceExportSettings() {
    return getAudienceExportSettings;
  }

  /** Returns the object with the settings used for calls to listAudienceExports. */
  public PagedCallSettings<
          ListAudienceExportsRequest, ListAudienceExportsResponse, ListAudienceExportsPagedResponse>
      listAudienceExportsSettings() {
    return listAudienceExportsSettings;
  }

  public BetaAnalyticsDataStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBetaAnalyticsDataStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBetaAnalyticsDataStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "analyticsdata";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "analyticsdata.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "analyticsdata.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BetaAnalyticsDataStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BetaAnalyticsDataStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BetaAnalyticsDataStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    runReportSettings = settingsBuilder.runReportSettings().build();
    runPivotReportSettings = settingsBuilder.runPivotReportSettings().build();
    batchRunReportsSettings = settingsBuilder.batchRunReportsSettings().build();
    batchRunPivotReportsSettings = settingsBuilder.batchRunPivotReportsSettings().build();
    getMetadataSettings = settingsBuilder.getMetadataSettings().build();
    runRealtimeReportSettings = settingsBuilder.runRealtimeReportSettings().build();
    checkCompatibilitySettings = settingsBuilder.checkCompatibilitySettings().build();
    createAudienceExportSettings = settingsBuilder.createAudienceExportSettings().build();
    createAudienceExportOperationSettings =
        settingsBuilder.createAudienceExportOperationSettings().build();
    queryAudienceExportSettings = settingsBuilder.queryAudienceExportSettings().build();
    getAudienceExportSettings = settingsBuilder.getAudienceExportSettings().build();
    listAudienceExportsSettings = settingsBuilder.listAudienceExportsSettings().build();
  }

  /** Builder for BetaAnalyticsDataStubSettings. */
  public static class Builder extends StubSettings.Builder<BetaAnalyticsDataStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<RunReportRequest, RunReportResponse> runReportSettings;
    private final UnaryCallSettings.Builder<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportSettings;
    private final UnaryCallSettings.Builder<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsSettings;
    private final UnaryCallSettings.Builder<
            BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsSettings;
    private final UnaryCallSettings.Builder<GetMetadataRequest, Metadata> getMetadataSettings;
    private final UnaryCallSettings.Builder<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportSettings;
    private final UnaryCallSettings.Builder<CheckCompatibilityRequest, CheckCompatibilityResponse>
        checkCompatibilitySettings;
    private final UnaryCallSettings.Builder<CreateAudienceExportRequest, Operation>
        createAudienceExportSettings;
    private final OperationCallSettings.Builder<
            CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
        createAudienceExportOperationSettings;
    private final UnaryCallSettings.Builder<QueryAudienceExportRequest, QueryAudienceExportResponse>
        queryAudienceExportSettings;
    private final UnaryCallSettings.Builder<GetAudienceExportRequest, AudienceExport>
        getAudienceExportSettings;
    private final PagedCallSettings.Builder<
            ListAudienceExportsRequest,
            ListAudienceExportsResponse,
            ListAudienceExportsPagedResponse>
        listAudienceExportsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNKNOWN)));
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
              .setMaxRetryDelay(Duration.ofMillis(60000L))
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

      runReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runPivotReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRunReportsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRunPivotReportsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runRealtimeReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkCompatibilitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAudienceExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAudienceExportOperationSettings = OperationCallSettings.newBuilder();
      queryAudienceExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAudienceExportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAudienceExportsSettings =
          PagedCallSettings.newBuilder(LIST_AUDIENCE_EXPORTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runReportSettings,
              runPivotReportSettings,
              batchRunReportsSettings,
              batchRunPivotReportsSettings,
              getMetadataSettings,
              runRealtimeReportSettings,
              checkCompatibilitySettings,
              createAudienceExportSettings,
              queryAudienceExportSettings,
              getAudienceExportSettings,
              listAudienceExportsSettings);
      initDefaults(this);
    }

    protected Builder(BetaAnalyticsDataStubSettings settings) {
      super(settings);

      runReportSettings = settings.runReportSettings.toBuilder();
      runPivotReportSettings = settings.runPivotReportSettings.toBuilder();
      batchRunReportsSettings = settings.batchRunReportsSettings.toBuilder();
      batchRunPivotReportsSettings = settings.batchRunPivotReportsSettings.toBuilder();
      getMetadataSettings = settings.getMetadataSettings.toBuilder();
      runRealtimeReportSettings = settings.runRealtimeReportSettings.toBuilder();
      checkCompatibilitySettings = settings.checkCompatibilitySettings.toBuilder();
      createAudienceExportSettings = settings.createAudienceExportSettings.toBuilder();
      createAudienceExportOperationSettings =
          settings.createAudienceExportOperationSettings.toBuilder();
      queryAudienceExportSettings = settings.queryAudienceExportSettings.toBuilder();
      getAudienceExportSettings = settings.getAudienceExportSettings.toBuilder();
      listAudienceExportsSettings = settings.listAudienceExportsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runReportSettings,
              runPivotReportSettings,
              batchRunReportsSettings,
              batchRunPivotReportsSettings,
              getMetadataSettings,
              runRealtimeReportSettings,
              checkCompatibilitySettings,
              createAudienceExportSettings,
              queryAudienceExportSettings,
              getAudienceExportSettings,
              listAudienceExportsSettings);
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
          .runReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .runPivotReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchRunReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchRunPivotReportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .runRealtimeReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .checkCompatibilitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createAudienceExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryAudienceExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAudienceExportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAudienceExportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAudienceExportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAudienceExportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AudienceExport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(AudienceExportMetadata.class))
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

    /** Returns the builder for the settings used for calls to runReport. */
    public UnaryCallSettings.Builder<RunReportRequest, RunReportResponse> runReportSettings() {
      return runReportSettings;
    }

    /** Returns the builder for the settings used for calls to runPivotReport. */
    public UnaryCallSettings.Builder<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportSettings() {
      return runPivotReportSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunReports. */
    public UnaryCallSettings.Builder<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsSettings() {
      return batchRunReportsSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunPivotReports. */
    public UnaryCallSettings.Builder<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsSettings() {
      return batchRunPivotReportsSettings;
    }

    /** Returns the builder for the settings used for calls to getMetadata. */
    public UnaryCallSettings.Builder<GetMetadataRequest, Metadata> getMetadataSettings() {
      return getMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to runRealtimeReport. */
    public UnaryCallSettings.Builder<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportSettings() {
      return runRealtimeReportSettings;
    }

    /** Returns the builder for the settings used for calls to checkCompatibility. */
    public UnaryCallSettings.Builder<CheckCompatibilityRequest, CheckCompatibilityResponse>
        checkCompatibilitySettings() {
      return checkCompatibilitySettings;
    }

    /** Returns the builder for the settings used for calls to createAudienceExport. */
    public UnaryCallSettings.Builder<CreateAudienceExportRequest, Operation>
        createAudienceExportSettings() {
      return createAudienceExportSettings;
    }

    /** Returns the builder for the settings used for calls to createAudienceExport. */
    public OperationCallSettings.Builder<
            CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
        createAudienceExportOperationSettings() {
      return createAudienceExportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryAudienceExport. */
    public UnaryCallSettings.Builder<QueryAudienceExportRequest, QueryAudienceExportResponse>
        queryAudienceExportSettings() {
      return queryAudienceExportSettings;
    }

    /** Returns the builder for the settings used for calls to getAudienceExport. */
    public UnaryCallSettings.Builder<GetAudienceExportRequest, AudienceExport>
        getAudienceExportSettings() {
      return getAudienceExportSettings;
    }

    /** Returns the builder for the settings used for calls to listAudienceExports. */
    public PagedCallSettings.Builder<
            ListAudienceExportsRequest,
            ListAudienceExportsResponse,
            ListAudienceExportsPagedResponse>
        listAudienceExportsSettings() {
      return listAudienceExportsSettings;
    }

    @Override
    public BetaAnalyticsDataStubSettings build() throws IOException {
      return new BetaAnalyticsDataStubSettings(this);
    }
  }
}
