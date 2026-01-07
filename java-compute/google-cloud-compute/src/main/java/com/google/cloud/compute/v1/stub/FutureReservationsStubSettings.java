/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.compute.v1.FutureReservationsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.FutureReservationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListFutureReservationsRequest;
import com.google.cloud.compute.v1.CancelFutureReservationRequest;
import com.google.cloud.compute.v1.DeleteFutureReservationRequest;
import com.google.cloud.compute.v1.FutureReservation;
import com.google.cloud.compute.v1.FutureReservationsAggregatedListResponse;
import com.google.cloud.compute.v1.FutureReservationsListResponse;
import com.google.cloud.compute.v1.FutureReservationsScopedList;
import com.google.cloud.compute.v1.GetFutureReservationRequest;
import com.google.cloud.compute.v1.InsertFutureReservationRequest;
import com.google.cloud.compute.v1.ListFutureReservationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.UpdateFutureReservationRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FutureReservationsStub}.
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
 * FutureReservationsStubSettings.Builder futureReservationsSettingsBuilder =
 *     FutureReservationsStubSettings.newBuilder();
 * futureReservationsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         futureReservationsSettingsBuilder
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
 * FutureReservationsStubSettings futureReservationsSettings =
 *     futureReservationsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for cancel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FutureReservationsStubSettings.Builder futureReservationsSettingsBuilder =
 *     FutureReservationsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * futureReservationsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FutureReservationsStubSettings extends StubSettings<FutureReservationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListFutureReservationsRequest,
          FutureReservationsAggregatedListResponse,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<CancelFutureReservationRequest, Operation> cancelSettings;
  private final OperationCallSettings<CancelFutureReservationRequest, Operation, Operation>
      cancelOperationSettings;
  private final UnaryCallSettings<DeleteFutureReservationRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteFutureReservationRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetFutureReservationRequest, FutureReservation> getSettings;
  private final UnaryCallSettings<InsertFutureReservationRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertFutureReservationRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<UpdateFutureReservationRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateFutureReservationRequest, Operation, Operation>
      updateOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListFutureReservationsRequest,
          FutureReservationsAggregatedListResponse,
          Map.Entry<String, FutureReservationsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListFutureReservationsRequest,
              FutureReservationsAggregatedListResponse,
              Map.Entry<String, FutureReservationsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListFutureReservationsRequest injectToken(
                AggregatedListFutureReservationsRequest payload, String token) {
              return AggregatedListFutureReservationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListFutureReservationsRequest injectPageSize(
                AggregatedListFutureReservationsRequest payload, int pageSize) {
              return AggregatedListFutureReservationsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListFutureReservationsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(FutureReservationsAggregatedListResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, FutureReservationsScopedList>> extractResources(
                FutureReservationsAggregatedListResponse payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListFutureReservationsRequest, FutureReservationsListResponse, FutureReservation>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFutureReservationsRequest, FutureReservationsListResponse, FutureReservation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFutureReservationsRequest injectToken(
                ListFutureReservationsRequest payload, String token) {
              return ListFutureReservationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFutureReservationsRequest injectPageSize(
                ListFutureReservationsRequest payload, int pageSize) {
              return ListFutureReservationsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFutureReservationsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(FutureReservationsListResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FutureReservation> extractResources(
                FutureReservationsListResponse payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListFutureReservationsRequest,
          FutureReservationsAggregatedListResponse,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListFutureReservationsRequest,
              FutureReservationsAggregatedListResponse,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListFutureReservationsRequest,
                        FutureReservationsAggregatedListResponse>
                    callable,
                AggregatedListFutureReservationsRequest request,
                ApiCallContext context,
                ApiFuture<FutureReservationsAggregatedListResponse> futureResponse) {
              PageContext<
                      AggregatedListFutureReservationsRequest,
                      FutureReservationsAggregatedListResponse,
                      Map.Entry<String, FutureReservationsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFutureReservationsRequest, FutureReservationsListResponse>
                    callable,
                ListFutureReservationsRequest request,
                ApiCallContext context,
                ApiFuture<FutureReservationsListResponse> futureResponse) {
              PageContext<
                      ListFutureReservationsRequest,
                      FutureReservationsListResponse,
                      FutureReservation>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListFutureReservationsRequest,
          FutureReservationsAggregatedListResponse,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to cancel. */
  public UnaryCallSettings<CancelFutureReservationRequest, Operation> cancelSettings() {
    return cancelSettings;
  }

  /** Returns the object with the settings used for calls to cancel. */
  public OperationCallSettings<CancelFutureReservationRequest, Operation, Operation>
      cancelOperationSettings() {
    return cancelOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteFutureReservationRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteFutureReservationRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetFutureReservationRequest, FutureReservation> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertFutureReservationRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertFutureReservationRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateFutureReservationRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateFutureReservationRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  public FutureReservationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFutureReservationsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(FutureReservationsStubSettings.class))
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

  protected FutureReservationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    cancelSettings = settingsBuilder.cancelSettings().build();
    cancelOperationSettings = settingsBuilder.cancelOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
  }

  /** Builder for FutureReservationsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FutureReservationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListFutureReservationsRequest,
            FutureReservationsAggregatedListResponse,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<CancelFutureReservationRequest, Operation>
        cancelSettings;
    private final OperationCallSettings.Builder<
            CancelFutureReservationRequest, Operation, Operation>
        cancelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFutureReservationRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteFutureReservationRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetFutureReservationRequest, FutureReservation>
        getSettings;
    private final UnaryCallSettings.Builder<InsertFutureReservationRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertFutureReservationRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<UpdateFutureReservationRequest, Operation>
        updateSettings;
    private final OperationCallSettings.Builder<
            UpdateFutureReservationRequest, Operation, Operation>
        updateOperationSettings;
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

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      cancelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              cancelSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(FutureReservationsStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      cancelSettings = settings.cancelSettings.toBuilder();
      cancelOperationSettings = settings.cancelOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              cancelSettings,
              deleteSettings,
              getSettings,
              insertSettings,
              listSettings,
              updateSettings);
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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .cancelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CancelFutureReservationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFutureReservationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertFutureReservationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFutureReservationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListFutureReservationsRequest,
            FutureReservationsAggregatedListResponse,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public UnaryCallSettings.Builder<CancelFutureReservationRequest, Operation> cancelSettings() {
      return cancelSettings;
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public OperationCallSettings.Builder<CancelFutureReservationRequest, Operation, Operation>
        cancelOperationSettings() {
      return cancelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteFutureReservationRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteFutureReservationRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetFutureReservationRequest, FutureReservation> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertFutureReservationRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertFutureReservationRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListFutureReservationsRequest, FutureReservationsListResponse, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateFutureReservationRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateFutureReservationRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    @Override
    public FutureReservationsStubSettings build() throws IOException {
      return new FutureReservationsStubSettings(this);
    }
  }
}
