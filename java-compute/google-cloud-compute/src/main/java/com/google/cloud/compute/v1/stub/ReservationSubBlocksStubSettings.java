/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ReservationSubBlocksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.GetReservationSubBlockRequest;
import com.google.cloud.compute.v1.ListReservationSubBlocksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PerformMaintenanceReservationSubBlockRequest;
import com.google.cloud.compute.v1.ReportFaultyReservationSubBlockRequest;
import com.google.cloud.compute.v1.ReservationSubBlock;
import com.google.cloud.compute.v1.ReservationSubBlocksGetResponse;
import com.google.cloud.compute.v1.ReservationSubBlocksListResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReservationSubBlocksStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationSubBlocksStubSettings.Builder reservationSubBlocksSettingsBuilder =
 *     ReservationSubBlocksStubSettings.newBuilder();
 * reservationSubBlocksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         reservationSubBlocksSettingsBuilder
 *             .getSettings()
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
 * ReservationSubBlocksStubSettings reservationSubBlocksSettings =
 *     reservationSubBlocksSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for performMaintenance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationSubBlocksStubSettings.Builder reservationSubBlocksSettingsBuilder =
 *     ReservationSubBlocksStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * reservationSubBlocksSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ReservationSubBlocksStubSettings
    extends StubSettings<ReservationSubBlocksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getSettings;
  private final PagedCallSettings<
          ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PerformMaintenanceReservationSubBlockRequest, Operation>
      performMaintenanceSettings;
  private final OperationCallSettings<
          PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
      performMaintenanceOperationSettings;
  private final UnaryCallSettings<ReportFaultyReservationSubBlockRequest, Operation>
      reportFaultySettings;
  private final OperationCallSettings<ReportFaultyReservationSubBlockRequest, Operation, Operation>
      reportFaultyOperationSettings;

  private static final PagedListDescriptor<
          ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ReservationSubBlock>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReservationSubBlocksRequest,
              ReservationSubBlocksListResponse,
              ReservationSubBlock>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReservationSubBlocksRequest injectToken(
                ListReservationSubBlocksRequest payload, String token) {
              return ListReservationSubBlocksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListReservationSubBlocksRequest injectPageSize(
                ListReservationSubBlocksRequest payload, int pageSize) {
              return ListReservationSubBlocksRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListReservationSubBlocksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ReservationSubBlocksListResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReservationSubBlock> extractResources(
                ReservationSubBlocksListResponse payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReservationSubBlocksRequest,
              ReservationSubBlocksListResponse,
              ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
                    callable,
                ListReservationSubBlocksRequest request,
                ApiCallContext context,
                ApiFuture<ReservationSubBlocksListResponse> futureResponse) {
              PageContext<
                      ListReservationSubBlocksRequest,
                      ReservationSubBlocksListResponse,
                      ReservationSubBlock>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to performMaintenance. */
  public UnaryCallSettings<PerformMaintenanceReservationSubBlockRequest, Operation>
      performMaintenanceSettings() {
    return performMaintenanceSettings;
  }

  /** Returns the object with the settings used for calls to performMaintenance. */
  public OperationCallSettings<PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
      performMaintenanceOperationSettings() {
    return performMaintenanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to reportFaulty. */
  public UnaryCallSettings<ReportFaultyReservationSubBlockRequest, Operation>
      reportFaultySettings() {
    return reportFaultySettings;
  }

  /** Returns the object with the settings used for calls to reportFaulty. */
  public OperationCallSettings<ReportFaultyReservationSubBlockRequest, Operation, Operation>
      reportFaultyOperationSettings() {
    return reportFaultyOperationSettings;
  }

  public ReservationSubBlocksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonReservationSubBlocksStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ReservationSubBlocksStubSettings.class))
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

  protected ReservationSubBlocksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSettings = settingsBuilder.getSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    performMaintenanceSettings = settingsBuilder.performMaintenanceSettings().build();
    performMaintenanceOperationSettings =
        settingsBuilder.performMaintenanceOperationSettings().build();
    reportFaultySettings = settingsBuilder.reportFaultySettings().build();
    reportFaultyOperationSettings = settingsBuilder.reportFaultyOperationSettings().build();
  }

  /** Builder for ReservationSubBlocksStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ReservationSubBlocksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
        getSettings;
    private final PagedCallSettings.Builder<
            ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PerformMaintenanceReservationSubBlockRequest, Operation>
        performMaintenanceSettings;
    private final OperationCallSettings.Builder<
            PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
        performMaintenanceOperationSettings;
    private final UnaryCallSettings.Builder<ReportFaultyReservationSubBlockRequest, Operation>
        reportFaultySettings;
    private final OperationCallSettings.Builder<
            ReportFaultyReservationSubBlockRequest, Operation, Operation>
        reportFaultyOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      performMaintenanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      performMaintenanceOperationSettings = OperationCallSettings.newBuilder();
      reportFaultySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportFaultyOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSettings, listSettings, performMaintenanceSettings, reportFaultySettings);
      initDefaults(this);
    }

    protected Builder(ReservationSubBlocksStubSettings settings) {
      super(settings);

      getSettings = settings.getSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      performMaintenanceSettings = settings.performMaintenanceSettings.toBuilder();
      performMaintenanceOperationSettings =
          settings.performMaintenanceOperationSettings.toBuilder();
      reportFaultySettings = settings.reportFaultySettings.toBuilder();
      reportFaultyOperationSettings = settings.reportFaultyOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSettings, listSettings, performMaintenanceSettings, reportFaultySettings);
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
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .performMaintenanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .reportFaultySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .performMaintenanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PerformMaintenanceReservationSubBlockRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .reportFaultyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReportFaultyReservationSubBlockRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
        getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListReservationSubBlocksRequest, ReservationSubBlocksListResponse, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to performMaintenance. */
    public UnaryCallSettings.Builder<PerformMaintenanceReservationSubBlockRequest, Operation>
        performMaintenanceSettings() {
      return performMaintenanceSettings;
    }

    /** Returns the builder for the settings used for calls to performMaintenance. */
    public OperationCallSettings.Builder<
            PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
        performMaintenanceOperationSettings() {
      return performMaintenanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reportFaulty. */
    public UnaryCallSettings.Builder<ReportFaultyReservationSubBlockRequest, Operation>
        reportFaultySettings() {
      return reportFaultySettings;
    }

    /** Returns the builder for the settings used for calls to reportFaulty. */
    public OperationCallSettings.Builder<
            ReportFaultyReservationSubBlockRequest, Operation, Operation>
        reportFaultyOperationSettings() {
      return reportFaultyOperationSettings;
    }

    @Override
    public ReservationSubBlocksStubSettings build() throws IOException {
      return new ReservationSubBlocksStubSettings(this);
    }
  }
}
