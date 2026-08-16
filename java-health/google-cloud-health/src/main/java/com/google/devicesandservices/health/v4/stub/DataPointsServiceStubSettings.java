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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.RollUpDataPointsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsOperationMetadata;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsResponse;
import com.google.devicesandservices.health.v4.CreateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.CreateDataPointRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.DataPoint;
import com.google.devicesandservices.health.v4.ExportExerciseTcxRequest;
import com.google.devicesandservices.health.v4.ExportExerciseTcxResponse;
import com.google.devicesandservices.health.v4.GetDataPointRequest;
import com.google.devicesandservices.health.v4.ListDataPointsRequest;
import com.google.devicesandservices.health.v4.ListDataPointsResponse;
import com.google.devicesandservices.health.v4.ReconcileDataPointsRequest;
import com.google.devicesandservices.health.v4.ReconcileDataPointsResponse;
import com.google.devicesandservices.health.v4.ReconciledDataPoint;
import com.google.devicesandservices.health.v4.RollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.RollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.RollupDataPoint;
import com.google.devicesandservices.health.v4.UpdateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.UpdateDataPointRequest;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataPointsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (health.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataPoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataPointsServiceStubSettings.Builder dataPointsServiceSettingsBuilder =
 *     DataPointsServiceStubSettings.newBuilder();
 * dataPointsServiceSettingsBuilder
 *     .getDataPointSettings()
 *     .setRetrySettings(
 *         dataPointsServiceSettingsBuilder
 *             .getDataPointSettings()
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
 * DataPointsServiceStubSettings dataPointsServiceSettings =
 *     dataPointsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataPoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataPointsServiceStubSettings.Builder dataPointsServiceSettingsBuilder =
 *     DataPointsServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataPointsServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DataPointsServiceStubSettings extends StubSettings<DataPointsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/googlehealth.activity_and_fitness.readonly")
          .add(
              "https://www.googleapis.com/auth/googlehealth.health_metrics_and_measurements.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.location.readonly")
          .add("https://www.googleapis.com/auth/googlehealth.sleep.readonly")
          .build();

  private final UnaryCallSettings<GetDataPointRequest, DataPoint> getDataPointSettings;
  private final PagedCallSettings<
          ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
      listDataPointsSettings;
  private final UnaryCallSettings<CreateDataPointRequest, Operation> createDataPointSettings;
  private final OperationCallSettings<
          CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationSettings;
  private final UnaryCallSettings<UpdateDataPointRequest, Operation> updateDataPointSettings;
  private final OperationCallSettings<
          UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationSettings;
  private final UnaryCallSettings<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsSettings;
  private final OperationCallSettings<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationSettings;
  private final PagedCallSettings<
          ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconcileDataPointsPagedResponse>
      reconcileDataPointsSettings;
  private final PagedCallSettings<
          RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
      rollUpDataPointsSettings;
  private final UnaryCallSettings<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsSettings;
  private final UnaryCallSettings<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxSettings;

  private static final PagedListDescriptor<ListDataPointsRequest, ListDataPointsResponse, DataPoint>
      LIST_DATA_POINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataPointsRequest, ListDataPointsResponse, DataPoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataPointsRequest injectToken(ListDataPointsRequest payload, String token) {
              return ListDataPointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataPointsRequest injectPageSize(
                ListDataPointsRequest payload, int pageSize) {
              return ListDataPointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataPointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataPointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataPoint> extractResources(ListDataPointsResponse payload) {
              return payload.getDataPointsList();
            }
          };

  private static final PagedListDescriptor<
          ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
      RECONCILE_DATA_POINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ReconcileDataPointsRequest injectToken(
                ReconcileDataPointsRequest payload, String token) {
              return ReconcileDataPointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ReconcileDataPointsRequest injectPageSize(
                ReconcileDataPointsRequest payload, int pageSize) {
              return ReconcileDataPointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ReconcileDataPointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ReconcileDataPointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReconciledDataPoint> extractResources(
                ReconcileDataPointsResponse payload) {
              return payload.getDataPointsList();
            }
          };

  private static final PagedListDescriptor<
          RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint>
      ROLL_UP_DATA_POINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public RollUpDataPointsRequest injectToken(
                RollUpDataPointsRequest payload, String token) {
              return RollUpDataPointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public RollUpDataPointsRequest injectPageSize(
                RollUpDataPointsRequest payload, int pageSize) {
              return RollUpDataPointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(RollUpDataPointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(RollUpDataPointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RollupDataPoint> extractResources(RollUpDataPointsResponse payload) {
              return payload.getRollupDataPointsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
      LIST_DATA_POINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>() {
            @Override
            public ApiFuture<ListDataPointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> callable,
                ListDataPointsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataPointsResponse> futureResponse) {
              PageContext<ListDataPointsRequest, ListDataPointsResponse, DataPoint> pageContext =
                  PageContext.create(callable, LIST_DATA_POINTS_PAGE_STR_DESC, request, context);
              return ListDataPointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconcileDataPointsPagedResponse>
      RECONCILE_DATA_POINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ReconcileDataPointsRequest,
              ReconcileDataPointsResponse,
              ReconcileDataPointsPagedResponse>() {
            @Override
            public ApiFuture<ReconcileDataPointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse> callable,
                ReconcileDataPointsRequest request,
                ApiCallContext context,
                ApiFuture<ReconcileDataPointsResponse> futureResponse) {
              PageContext<
                      ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
                  pageContext =
                      PageContext.create(
                          callable, RECONCILE_DATA_POINTS_PAGE_STR_DESC, request, context);
              return ReconcileDataPointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
      ROLL_UP_DATA_POINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>() {
            @Override
            public ApiFuture<RollUpDataPointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse> callable,
                RollUpDataPointsRequest request,
                ApiCallContext context,
                ApiFuture<RollUpDataPointsResponse> futureResponse) {
              PageContext<RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint>
                  pageContext =
                      PageContext.create(
                          callable, ROLL_UP_DATA_POINTS_PAGE_STR_DESC, request, context);
              return RollUpDataPointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getDataPoint. */
  public UnaryCallSettings<GetDataPointRequest, DataPoint> getDataPointSettings() {
    return getDataPointSettings;
  }

  /** Returns the object with the settings used for calls to listDataPoints. */
  public PagedCallSettings<
          ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
      listDataPointsSettings() {
    return listDataPointsSettings;
  }

  /** Returns the object with the settings used for calls to createDataPoint. */
  public UnaryCallSettings<CreateDataPointRequest, Operation> createDataPointSettings() {
    return createDataPointSettings;
  }

  /** Returns the object with the settings used for calls to createDataPoint. */
  public OperationCallSettings<CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationSettings() {
    return createDataPointOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataPoint. */
  public UnaryCallSettings<UpdateDataPointRequest, Operation> updateDataPointSettings() {
    return updateDataPointSettings;
  }

  /** Returns the object with the settings used for calls to updateDataPoint. */
  public OperationCallSettings<UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationSettings() {
    return updateDataPointOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteDataPoints. */
  public UnaryCallSettings<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsSettings() {
    return batchDeleteDataPointsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteDataPoints. */
  public OperationCallSettings<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationSettings() {
    return batchDeleteDataPointsOperationSettings;
  }

  /** Returns the object with the settings used for calls to reconcileDataPoints. */
  public PagedCallSettings<
          ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconcileDataPointsPagedResponse>
      reconcileDataPointsSettings() {
    return reconcileDataPointsSettings;
  }

  /** Returns the object with the settings used for calls to rollUpDataPoints. */
  public PagedCallSettings<
          RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
      rollUpDataPointsSettings() {
    return rollUpDataPointsSettings;
  }

  /** Returns the object with the settings used for calls to dailyRollUpDataPoints. */
  public UnaryCallSettings<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsSettings() {
    return dailyRollUpDataPointsSettings;
  }

  /** Returns the object with the settings used for calls to exportExerciseTcx. */
  public UnaryCallSettings<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxSettings() {
    return exportExerciseTcxSettings;
  }

  public DataPointsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataPointsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataPointsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "health";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "health.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "health.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataPointsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataPointsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataPointsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DataPointsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDataPointSettings = settingsBuilder.getDataPointSettings().build();
    listDataPointsSettings = settingsBuilder.listDataPointsSettings().build();
    createDataPointSettings = settingsBuilder.createDataPointSettings().build();
    createDataPointOperationSettings = settingsBuilder.createDataPointOperationSettings().build();
    updateDataPointSettings = settingsBuilder.updateDataPointSettings().build();
    updateDataPointOperationSettings = settingsBuilder.updateDataPointOperationSettings().build();
    batchDeleteDataPointsSettings = settingsBuilder.batchDeleteDataPointsSettings().build();
    batchDeleteDataPointsOperationSettings =
        settingsBuilder.batchDeleteDataPointsOperationSettings().build();
    reconcileDataPointsSettings = settingsBuilder.reconcileDataPointsSettings().build();
    rollUpDataPointsSettings = settingsBuilder.rollUpDataPointsSettings().build();
    dailyRollUpDataPointsSettings = settingsBuilder.dailyRollUpDataPointsSettings().build();
    exportExerciseTcxSettings = settingsBuilder.exportExerciseTcxSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-health")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DataPointsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataPointsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetDataPointRequest, DataPoint> getDataPointSettings;
    private final PagedCallSettings.Builder<
            ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
        listDataPointsSettings;
    private final UnaryCallSettings.Builder<CreateDataPointRequest, Operation>
        createDataPointSettings;
    private final OperationCallSettings.Builder<
            CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
        createDataPointOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataPointRequest, Operation>
        updateDataPointSettings;
    private final OperationCallSettings.Builder<
            UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
        updateDataPointOperationSettings;
    private final UnaryCallSettings.Builder<BatchDeleteDataPointsRequest, Operation>
        batchDeleteDataPointsSettings;
    private final OperationCallSettings.Builder<
            BatchDeleteDataPointsRequest,
            BatchDeleteDataPointsResponse,
            BatchDeleteDataPointsOperationMetadata>
        batchDeleteDataPointsOperationSettings;
    private final PagedCallSettings.Builder<
            ReconcileDataPointsRequest,
            ReconcileDataPointsResponse,
            ReconcileDataPointsPagedResponse>
        reconcileDataPointsSettings;
    private final PagedCallSettings.Builder<
            RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
        rollUpDataPointsSettings;
    private final UnaryCallSettings.Builder<
            DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
        dailyRollUpDataPointsSettings;
    private final UnaryCallSettings.Builder<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
        exportExerciseTcxSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getDataPointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataPointsSettings = PagedCallSettings.newBuilder(LIST_DATA_POINTS_PAGE_STR_FACT);
      createDataPointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataPointOperationSettings = OperationCallSettings.newBuilder();
      updateDataPointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataPointOperationSettings = OperationCallSettings.newBuilder();
      batchDeleteDataPointsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteDataPointsOperationSettings = OperationCallSettings.newBuilder();
      reconcileDataPointsSettings =
          PagedCallSettings.newBuilder(RECONCILE_DATA_POINTS_PAGE_STR_FACT);
      rollUpDataPointsSettings = PagedCallSettings.newBuilder(ROLL_UP_DATA_POINTS_PAGE_STR_FACT);
      dailyRollUpDataPointsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportExerciseTcxSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataPointSettings,
              listDataPointsSettings,
              createDataPointSettings,
              updateDataPointSettings,
              batchDeleteDataPointsSettings,
              reconcileDataPointsSettings,
              rollUpDataPointsSettings,
              dailyRollUpDataPointsSettings,
              exportExerciseTcxSettings);
      initDefaults(this);
    }

    protected Builder(DataPointsServiceStubSettings settings) {
      super(settings);

      getDataPointSettings = settings.getDataPointSettings.toBuilder();
      listDataPointsSettings = settings.listDataPointsSettings.toBuilder();
      createDataPointSettings = settings.createDataPointSettings.toBuilder();
      createDataPointOperationSettings = settings.createDataPointOperationSettings.toBuilder();
      updateDataPointSettings = settings.updateDataPointSettings.toBuilder();
      updateDataPointOperationSettings = settings.updateDataPointOperationSettings.toBuilder();
      batchDeleteDataPointsSettings = settings.batchDeleteDataPointsSettings.toBuilder();
      batchDeleteDataPointsOperationSettings =
          settings.batchDeleteDataPointsOperationSettings.toBuilder();
      reconcileDataPointsSettings = settings.reconcileDataPointsSettings.toBuilder();
      rollUpDataPointsSettings = settings.rollUpDataPointsSettings.toBuilder();
      dailyRollUpDataPointsSettings = settings.dailyRollUpDataPointsSettings.toBuilder();
      exportExerciseTcxSettings = settings.exportExerciseTcxSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDataPointSettings,
              listDataPointsSettings,
              createDataPointSettings,
              updateDataPointSettings,
              batchDeleteDataPointsSettings,
              reconcileDataPointsSettings,
              rollUpDataPointsSettings,
              dailyRollUpDataPointsSettings,
              exportExerciseTcxSettings);
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
          .getDataPointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataPointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDataPointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchDeleteDataPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reconcileDataPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollUpDataPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .dailyRollUpDataPointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportExerciseTcxSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataPointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataPointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataPoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateDataPointOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateDataPointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataPointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataPoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateDataPointOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchDeleteDataPointsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteDataPointsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchDeleteDataPointsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchDeleteDataPointsOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to getDataPoint. */
    public UnaryCallSettings.Builder<GetDataPointRequest, DataPoint> getDataPointSettings() {
      return getDataPointSettings;
    }

    /** Returns the builder for the settings used for calls to listDataPoints. */
    public PagedCallSettings.Builder<
            ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
        listDataPointsSettings() {
      return listDataPointsSettings;
    }

    /** Returns the builder for the settings used for calls to createDataPoint. */
    public UnaryCallSettings.Builder<CreateDataPointRequest, Operation> createDataPointSettings() {
      return createDataPointSettings;
    }

    /** Returns the builder for the settings used for calls to createDataPoint. */
    public OperationCallSettings.Builder<
            CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
        createDataPointOperationSettings() {
      return createDataPointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataPoint. */
    public UnaryCallSettings.Builder<UpdateDataPointRequest, Operation> updateDataPointSettings() {
      return updateDataPointSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataPoint. */
    public OperationCallSettings.Builder<
            UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
        updateDataPointOperationSettings() {
      return updateDataPointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataPoints. */
    public UnaryCallSettings.Builder<BatchDeleteDataPointsRequest, Operation>
        batchDeleteDataPointsSettings() {
      return batchDeleteDataPointsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataPoints. */
    public OperationCallSettings.Builder<
            BatchDeleteDataPointsRequest,
            BatchDeleteDataPointsResponse,
            BatchDeleteDataPointsOperationMetadata>
        batchDeleteDataPointsOperationSettings() {
      return batchDeleteDataPointsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reconcileDataPoints. */
    public PagedCallSettings.Builder<
            ReconcileDataPointsRequest,
            ReconcileDataPointsResponse,
            ReconcileDataPointsPagedResponse>
        reconcileDataPointsSettings() {
      return reconcileDataPointsSettings;
    }

    /** Returns the builder for the settings used for calls to rollUpDataPoints. */
    public PagedCallSettings.Builder<
            RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
        rollUpDataPointsSettings() {
      return rollUpDataPointsSettings;
    }

    /** Returns the builder for the settings used for calls to dailyRollUpDataPoints. */
    public UnaryCallSettings.Builder<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
        dailyRollUpDataPointsSettings() {
      return dailyRollUpDataPointsSettings;
    }

    /** Returns the builder for the settings used for calls to exportExerciseTcx. */
    public UnaryCallSettings.Builder<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
        exportExerciseTcxSettings() {
      return exportExerciseTcxSettings;
    }

    @Override
    public DataPointsServiceStubSettings build() throws IOException {
      return new DataPointsServiceStubSettings(this);
    }
  }
}
