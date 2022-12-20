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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateDataScanRequest;
import com.google.cloud.dataplex.v1.DataScan;
import com.google.cloud.dataplex.v1.DataScanJob;
import com.google.cloud.dataplex.v1.DeleteDataScanRequest;
import com.google.cloud.dataplex.v1.GetDataScanJobRequest;
import com.google.cloud.dataplex.v1.GetDataScanRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsResponse;
import com.google.cloud.dataplex.v1.ListDataScansRequest;
import com.google.cloud.dataplex.v1.ListDataScansResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.RunDataScanRequest;
import com.google.cloud.dataplex.v1.RunDataScanResponse;
import com.google.cloud.dataplex.v1.UpdateDataScanRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link DataScanServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataScan to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataScanServiceStubSettings.Builder dataScanServiceSettingsBuilder =
 *     DataScanServiceStubSettings.newBuilder();
 * dataScanServiceSettingsBuilder
 *     .getDataScanSettings()
 *     .setRetrySettings(
 *         dataScanServiceSettingsBuilder.getDataScanSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataScanServiceStubSettings dataScanServiceSettings = dataScanServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataScanServiceStubSettings extends StubSettings<DataScanServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataScanRequest, Operation> createDataScanSettings;
  private final OperationCallSettings<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationSettings;
  private final UnaryCallSettings<UpdateDataScanRequest, Operation> updateDataScanSettings;
  private final OperationCallSettings<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationSettings;
  private final UnaryCallSettings<DeleteDataScanRequest, Operation> deleteDataScanSettings;
  private final OperationCallSettings<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationSettings;
  private final UnaryCallSettings<GetDataScanRequest, DataScan> getDataScanSettings;
  private final PagedCallSettings<
          ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
      listDataScansSettings;
  private final UnaryCallSettings<RunDataScanRequest, RunDataScanResponse> runDataScanSettings;
  private final UnaryCallSettings<GetDataScanJobRequest, DataScanJob> getDataScanJobSettings;
  private final PagedCallSettings<
          ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
      listDataScanJobsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListDataScansRequest, ListDataScansResponse, DataScan>
      LIST_DATA_SCANS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataScansRequest, ListDataScansResponse, DataScan>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataScansRequest injectToken(ListDataScansRequest payload, String token) {
              return ListDataScansRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataScansRequest injectPageSize(ListDataScansRequest payload, int pageSize) {
              return ListDataScansRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataScansRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataScansResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataScan> extractResources(ListDataScansResponse payload) {
              return payload.getDataScansList() == null
                  ? ImmutableList.<DataScan>of()
                  : payload.getDataScansList();
            }
          };

  private static final PagedListDescriptor<
          ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob>
      LIST_DATA_SCAN_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataScanJobsRequest injectToken(
                ListDataScanJobsRequest payload, String token) {
              return ListDataScanJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataScanJobsRequest injectPageSize(
                ListDataScanJobsRequest payload, int pageSize) {
              return ListDataScanJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataScanJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataScanJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataScanJob> extractResources(ListDataScanJobsResponse payload) {
              return payload.getDataScanJobsList() == null
                  ? ImmutableList.<DataScanJob>of()
                  : payload.getDataScanJobsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
      LIST_DATA_SCANS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>() {
            @Override
            public ApiFuture<ListDataScansPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataScansRequest, ListDataScansResponse> callable,
                ListDataScansRequest request,
                ApiCallContext context,
                ApiFuture<ListDataScansResponse> futureResponse) {
              PageContext<ListDataScansRequest, ListDataScansResponse, DataScan> pageContext =
                  PageContext.create(callable, LIST_DATA_SCANS_PAGE_STR_DESC, request, context);
              return ListDataScansPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
      LIST_DATA_SCAN_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>() {
            @Override
            public ApiFuture<ListDataScanJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse> callable,
                ListDataScanJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataScanJobsResponse> futureResponse) {
              PageContext<ListDataScanJobsRequest, ListDataScanJobsResponse, DataScanJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_SCAN_JOBS_PAGE_STR_DESC, request, context);
              return ListDataScanJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataScan. */
  public UnaryCallSettings<CreateDataScanRequest, Operation> createDataScanSettings() {
    return createDataScanSettings;
  }

  /** Returns the object with the settings used for calls to createDataScan. */
  public OperationCallSettings<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationSettings() {
    return createDataScanOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataScan. */
  public UnaryCallSettings<UpdateDataScanRequest, Operation> updateDataScanSettings() {
    return updateDataScanSettings;
  }

  /** Returns the object with the settings used for calls to updateDataScan. */
  public OperationCallSettings<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationSettings() {
    return updateDataScanOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataScan. */
  public UnaryCallSettings<DeleteDataScanRequest, Operation> deleteDataScanSettings() {
    return deleteDataScanSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataScan. */
  public OperationCallSettings<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationSettings() {
    return deleteDataScanOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataScan. */
  public UnaryCallSettings<GetDataScanRequest, DataScan> getDataScanSettings() {
    return getDataScanSettings;
  }

  /** Returns the object with the settings used for calls to listDataScans. */
  public PagedCallSettings<ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
      listDataScansSettings() {
    return listDataScansSettings;
  }

  /** Returns the object with the settings used for calls to runDataScan. */
  public UnaryCallSettings<RunDataScanRequest, RunDataScanResponse> runDataScanSettings() {
    return runDataScanSettings;
  }

  /** Returns the object with the settings used for calls to getDataScanJob. */
  public UnaryCallSettings<GetDataScanJobRequest, DataScanJob> getDataScanJobSettings() {
    return getDataScanJobSettings;
  }

  /** Returns the object with the settings used for calls to listDataScanJobs. */
  public PagedCallSettings<
          ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
      listDataScanJobsSettings() {
    return listDataScanJobsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public DataScanServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataScanServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataScanServiceStub.create(this);
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
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataScanServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataScanServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataScanServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataScanServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataScanSettings = settingsBuilder.createDataScanSettings().build();
    createDataScanOperationSettings = settingsBuilder.createDataScanOperationSettings().build();
    updateDataScanSettings = settingsBuilder.updateDataScanSettings().build();
    updateDataScanOperationSettings = settingsBuilder.updateDataScanOperationSettings().build();
    deleteDataScanSettings = settingsBuilder.deleteDataScanSettings().build();
    deleteDataScanOperationSettings = settingsBuilder.deleteDataScanOperationSettings().build();
    getDataScanSettings = settingsBuilder.getDataScanSettings().build();
    listDataScansSettings = settingsBuilder.listDataScansSettings().build();
    runDataScanSettings = settingsBuilder.runDataScanSettings().build();
    getDataScanJobSettings = settingsBuilder.getDataScanJobSettings().build();
    listDataScanJobsSettings = settingsBuilder.listDataScanJobsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DataScanServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataScanServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataScanRequest, Operation>
        createDataScanSettings;
    private final OperationCallSettings.Builder<CreateDataScanRequest, DataScan, OperationMetadata>
        createDataScanOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataScanRequest, Operation>
        updateDataScanSettings;
    private final OperationCallSettings.Builder<UpdateDataScanRequest, DataScan, OperationMetadata>
        updateDataScanOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataScanRequest, Operation>
        deleteDataScanSettings;
    private final OperationCallSettings.Builder<DeleteDataScanRequest, Empty, OperationMetadata>
        deleteDataScanOperationSettings;
    private final UnaryCallSettings.Builder<GetDataScanRequest, DataScan> getDataScanSettings;
    private final PagedCallSettings.Builder<
            ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
        listDataScansSettings;
    private final UnaryCallSettings.Builder<RunDataScanRequest, RunDataScanResponse>
        runDataScanSettings;
    private final UnaryCallSettings.Builder<GetDataScanJobRequest, DataScanJob>
        getDataScanJobSettings;
    private final PagedCallSettings.Builder<
            ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
        listDataScanJobsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      createDataScanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataScanOperationSettings = OperationCallSettings.newBuilder();
      updateDataScanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataScanOperationSettings = OperationCallSettings.newBuilder();
      deleteDataScanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataScanOperationSettings = OperationCallSettings.newBuilder();
      getDataScanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataScansSettings = PagedCallSettings.newBuilder(LIST_DATA_SCANS_PAGE_STR_FACT);
      runDataScanSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataScanJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataScanJobsSettings = PagedCallSettings.newBuilder(LIST_DATA_SCAN_JOBS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataScanSettings,
              updateDataScanSettings,
              deleteDataScanSettings,
              getDataScanSettings,
              listDataScansSettings,
              runDataScanSettings,
              getDataScanJobSettings,
              listDataScanJobsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataScanServiceStubSettings settings) {
      super(settings);

      createDataScanSettings = settings.createDataScanSettings.toBuilder();
      createDataScanOperationSettings = settings.createDataScanOperationSettings.toBuilder();
      updateDataScanSettings = settings.updateDataScanSettings.toBuilder();
      updateDataScanOperationSettings = settings.updateDataScanOperationSettings.toBuilder();
      deleteDataScanSettings = settings.deleteDataScanSettings.toBuilder();
      deleteDataScanOperationSettings = settings.deleteDataScanOperationSettings.toBuilder();
      getDataScanSettings = settings.getDataScanSettings.toBuilder();
      listDataScansSettings = settings.listDataScansSettings.toBuilder();
      runDataScanSettings = settings.runDataScanSettings.toBuilder();
      getDataScanJobSettings = settings.getDataScanJobSettings.toBuilder();
      listDataScanJobsSettings = settings.listDataScanJobsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataScanSettings,
              updateDataScanSettings,
              deleteDataScanSettings,
              getDataScanSettings,
              listDataScansSettings,
              runDataScanSettings,
              getDataScanJobSettings,
              listDataScanJobsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createDataScanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataScanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataScanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataScanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataScansSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .runDataScanSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataScanJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataScanJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataScanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataScanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataScan.class))
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

      builder
          .updateDataScanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataScanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataScan.class))
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

      builder
          .deleteDataScanOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataScanRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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

    /** Returns the builder for the settings used for calls to createDataScan. */
    public UnaryCallSettings.Builder<CreateDataScanRequest, Operation> createDataScanSettings() {
      return createDataScanSettings;
    }

    /** Returns the builder for the settings used for calls to createDataScan. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateDataScanRequest, DataScan, OperationMetadata>
        createDataScanOperationSettings() {
      return createDataScanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataScan. */
    public UnaryCallSettings.Builder<UpdateDataScanRequest, Operation> updateDataScanSettings() {
      return updateDataScanSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataScan. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateDataScanRequest, DataScan, OperationMetadata>
        updateDataScanOperationSettings() {
      return updateDataScanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataScan. */
    public UnaryCallSettings.Builder<DeleteDataScanRequest, Operation> deleteDataScanSettings() {
      return deleteDataScanSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataScan. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteDataScanRequest, Empty, OperationMetadata>
        deleteDataScanOperationSettings() {
      return deleteDataScanOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataScan. */
    public UnaryCallSettings.Builder<GetDataScanRequest, DataScan> getDataScanSettings() {
      return getDataScanSettings;
    }

    /** Returns the builder for the settings used for calls to listDataScans. */
    public PagedCallSettings.Builder<
            ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
        listDataScansSettings() {
      return listDataScansSettings;
    }

    /** Returns the builder for the settings used for calls to runDataScan. */
    public UnaryCallSettings.Builder<RunDataScanRequest, RunDataScanResponse>
        runDataScanSettings() {
      return runDataScanSettings;
    }

    /** Returns the builder for the settings used for calls to getDataScanJob. */
    public UnaryCallSettings.Builder<GetDataScanJobRequest, DataScanJob> getDataScanJobSettings() {
      return getDataScanJobSettings;
    }

    /** Returns the builder for the settings used for calls to listDataScanJobs. */
    public PagedCallSettings.Builder<
            ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
        listDataScanJobsSettings() {
      return listDataScanJobsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public DataScanServiceStubSettings build() throws IOException {
      return new DataScanServiceStubSettings(this);
    }
  }
}
