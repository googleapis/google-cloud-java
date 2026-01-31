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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListCollectionsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.Collection;
import com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.CreateIndexRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsMetadata;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.GetCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.GetIndexRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsMetadata;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.Index;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse;
import com.google.cloud.vectorsearch.v1beta.ListIndexesRequest;
import com.google.cloud.vectorsearch.v1beta.ListIndexesResponse;
import com.google.cloud.vectorsearch.v1beta.OperationMetadata;
import com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VectorSearchServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vectorsearch.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCollection:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VectorSearchServiceStubSettings.Builder vectorSearchServiceSettingsBuilder =
 *     VectorSearchServiceStubSettings.newBuilder();
 * vectorSearchServiceSettingsBuilder
 *     .getCollectionSettings()
 *     .setRetrySettings(
 *         vectorSearchServiceSettingsBuilder
 *             .getCollectionSettings()
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
 * VectorSearchServiceStubSettings vectorSearchServiceSettings =
 *     vectorSearchServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createCollection:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VectorSearchServiceStubSettings.Builder vectorSearchServiceSettingsBuilder =
 *     VectorSearchServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vectorSearchServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VectorSearchServiceStubSettings extends StubSettings<VectorSearchServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings;
  private final UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings;
  private final UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings;
  private final OperationCallSettings<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationSettings;
  private final UnaryCallSettings<UpdateCollectionRequest, Operation> updateCollectionSettings;
  private final OperationCallSettings<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationSettings;
  private final UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings;
  private final OperationCallSettings<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationSettings;
  private final PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings;
  private final UnaryCallSettings<GetIndexRequest, Index> getIndexSettings;
  private final UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings;
  private final OperationCallSettings<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationSettings;
  private final UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings;
  private final OperationCallSettings<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationSettings;
  private final UnaryCallSettings<ImportDataObjectsRequest, Operation> importDataObjectsSettings;
  private final OperationCallSettings<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationSettings;
  private final UnaryCallSettings<ExportDataObjectsRequest, Operation> exportDataObjectsSettings;
  private final OperationCallSettings<
          ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
      exportDataObjectsOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListCollectionsRequest, ListCollectionsResponse, Collection>
      LIST_COLLECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCollectionsRequest, ListCollectionsResponse, Collection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCollectionsRequest injectToken(
                ListCollectionsRequest payload, String token) {
              return ListCollectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCollectionsRequest injectPageSize(
                ListCollectionsRequest payload, int pageSize) {
              return ListCollectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCollectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCollectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Collection> extractResources(ListCollectionsResponse payload) {
              return payload.getCollectionsList();
            }
          };

  private static final PagedListDescriptor<ListIndexesRequest, ListIndexesResponse, Index>
      LIST_INDEXES_PAGE_STR_DESC =
          new PagedListDescriptor<ListIndexesRequest, ListIndexesResponse, Index>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIndexesRequest injectToken(ListIndexesRequest payload, String token) {
              return ListIndexesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIndexesRequest injectPageSize(ListIndexesRequest payload, int pageSize) {
              return ListIndexesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIndexesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIndexesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Index> extractResources(ListIndexesResponse payload) {
              return payload.getIndexesList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      LIST_COLLECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>() {
            @Override
            public ApiFuture<ListCollectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCollectionsRequest, ListCollectionsResponse> callable,
                ListCollectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListCollectionsResponse> futureResponse) {
              PageContext<ListCollectionsRequest, ListCollectionsResponse, Collection> pageContext =
                  PageContext.create(callable, LIST_COLLECTIONS_PAGE_STR_DESC, request, context);
              return ListCollectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      LIST_INDEXES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>() {
            @Override
            public ApiFuture<ListIndexesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIndexesRequest, ListIndexesResponse> callable,
                ListIndexesRequest request,
                ApiCallContext context,
                ApiFuture<ListIndexesResponse> futureResponse) {
              PageContext<ListIndexesRequest, ListIndexesResponse, Index> pageContext =
                  PageContext.create(callable, LIST_INDEXES_PAGE_STR_DESC, request, context);
              return ListIndexesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listCollections. */
  public PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings() {
    return listCollectionsSettings;
  }

  /** Returns the object with the settings used for calls to getCollection. */
  public UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings() {
    return getCollectionSettings;
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings() {
    return createCollectionSettings;
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public OperationCallSettings<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationSettings() {
    return createCollectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public UnaryCallSettings<UpdateCollectionRequest, Operation> updateCollectionSettings() {
    return updateCollectionSettings;
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public OperationCallSettings<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationSettings() {
    return updateCollectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings() {
    return deleteCollectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public OperationCallSettings<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationSettings() {
    return deleteCollectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return listIndexesSettings;
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return getIndexSettings;
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return createIndexSettings;
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationSettings() {
    return createIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return deleteIndexSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationSettings() {
    return deleteIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to importDataObjects. */
  public UnaryCallSettings<ImportDataObjectsRequest, Operation> importDataObjectsSettings() {
    return importDataObjectsSettings;
  }

  /** Returns the object with the settings used for calls to importDataObjects. */
  public OperationCallSettings<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationSettings() {
    return importDataObjectsOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportDataObjects. */
  public UnaryCallSettings<ExportDataObjectsRequest, Operation> exportDataObjectsSettings() {
    return exportDataObjectsSettings;
  }

  /** Returns the object with the settings used for calls to exportDataObjects. */
  public OperationCallSettings<
          ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
      exportDataObjectsOperationSettings() {
    return exportDataObjectsOperationSettings;
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

  public VectorSearchServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVectorSearchServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVectorSearchServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "vectorsearch";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "vectorsearch.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vectorsearch.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(VectorSearchServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VectorSearchServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected VectorSearchServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listCollectionsSettings = settingsBuilder.listCollectionsSettings().build();
    getCollectionSettings = settingsBuilder.getCollectionSettings().build();
    createCollectionSettings = settingsBuilder.createCollectionSettings().build();
    createCollectionOperationSettings = settingsBuilder.createCollectionOperationSettings().build();
    updateCollectionSettings = settingsBuilder.updateCollectionSettings().build();
    updateCollectionOperationSettings = settingsBuilder.updateCollectionOperationSettings().build();
    deleteCollectionSettings = settingsBuilder.deleteCollectionSettings().build();
    deleteCollectionOperationSettings = settingsBuilder.deleteCollectionOperationSettings().build();
    listIndexesSettings = settingsBuilder.listIndexesSettings().build();
    getIndexSettings = settingsBuilder.getIndexSettings().build();
    createIndexSettings = settingsBuilder.createIndexSettings().build();
    createIndexOperationSettings = settingsBuilder.createIndexOperationSettings().build();
    deleteIndexSettings = settingsBuilder.deleteIndexSettings().build();
    deleteIndexOperationSettings = settingsBuilder.deleteIndexOperationSettings().build();
    importDataObjectsSettings = settingsBuilder.importDataObjectsSettings().build();
    importDataObjectsOperationSettings =
        settingsBuilder.importDataObjectsOperationSettings().build();
    exportDataObjectsSettings = settingsBuilder.exportDataObjectsSettings().build();
    exportDataObjectsOperationSettings =
        settingsBuilder.exportDataObjectsOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for VectorSearchServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<VectorSearchServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings;
    private final UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings;
    private final UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings;
    private final OperationCallSettings.Builder<
            CreateCollectionRequest, Collection, OperationMetadata>
        createCollectionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCollectionRequest, Operation>
        updateCollectionSettings;
    private final OperationCallSettings.Builder<
            UpdateCollectionRequest, Collection, OperationMetadata>
        updateCollectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings;
    private final OperationCallSettings.Builder<DeleteCollectionRequest, Empty, OperationMetadata>
        deleteCollectionOperationSettings;
    private final PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings;
    private final UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings;
    private final UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings;
    private final OperationCallSettings.Builder<CreateIndexRequest, Index, OperationMetadata>
        createIndexOperationSettings;
    private final UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings;
    private final OperationCallSettings.Builder<DeleteIndexRequest, Empty, OperationMetadata>
        deleteIndexOperationSettings;
    private final UnaryCallSettings.Builder<ImportDataObjectsRequest, Operation>
        importDataObjectsSettings;
    private final OperationCallSettings.Builder<
            ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
        importDataObjectsOperationSettings;
    private final UnaryCallSettings.Builder<ExportDataObjectsRequest, Operation>
        exportDataObjectsSettings;
    private final OperationCallSettings.Builder<
            ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
        exportDataObjectsOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listCollectionsSettings = PagedCallSettings.newBuilder(LIST_COLLECTIONS_PAGE_STR_FACT);
      getCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCollectionOperationSettings = OperationCallSettings.newBuilder();
      updateCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCollectionOperationSettings = OperationCallSettings.newBuilder();
      deleteCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCollectionOperationSettings = OperationCallSettings.newBuilder();
      listIndexesSettings = PagedCallSettings.newBuilder(LIST_INDEXES_PAGE_STR_FACT);
      getIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexOperationSettings = OperationCallSettings.newBuilder();
      deleteIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexOperationSettings = OperationCallSettings.newBuilder();
      importDataObjectsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDataObjectsOperationSettings = OperationCallSettings.newBuilder();
      exportDataObjectsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportDataObjectsOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCollectionsSettings,
              getCollectionSettings,
              createCollectionSettings,
              updateCollectionSettings,
              deleteCollectionSettings,
              listIndexesSettings,
              getIndexSettings,
              createIndexSettings,
              deleteIndexSettings,
              importDataObjectsSettings,
              exportDataObjectsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(VectorSearchServiceStubSettings settings) {
      super(settings);

      listCollectionsSettings = settings.listCollectionsSettings.toBuilder();
      getCollectionSettings = settings.getCollectionSettings.toBuilder();
      createCollectionSettings = settings.createCollectionSettings.toBuilder();
      createCollectionOperationSettings = settings.createCollectionOperationSettings.toBuilder();
      updateCollectionSettings = settings.updateCollectionSettings.toBuilder();
      updateCollectionOperationSettings = settings.updateCollectionOperationSettings.toBuilder();
      deleteCollectionSettings = settings.deleteCollectionSettings.toBuilder();
      deleteCollectionOperationSettings = settings.deleteCollectionOperationSettings.toBuilder();
      listIndexesSettings = settings.listIndexesSettings.toBuilder();
      getIndexSettings = settings.getIndexSettings.toBuilder();
      createIndexSettings = settings.createIndexSettings.toBuilder();
      createIndexOperationSettings = settings.createIndexOperationSettings.toBuilder();
      deleteIndexSettings = settings.deleteIndexSettings.toBuilder();
      deleteIndexOperationSettings = settings.deleteIndexOperationSettings.toBuilder();
      importDataObjectsSettings = settings.importDataObjectsSettings.toBuilder();
      importDataObjectsOperationSettings = settings.importDataObjectsOperationSettings.toBuilder();
      exportDataObjectsSettings = settings.exportDataObjectsSettings.toBuilder();
      exportDataObjectsOperationSettings = settings.exportDataObjectsOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCollectionsSettings,
              getCollectionSettings,
              createCollectionSettings,
              updateCollectionSettings,
              deleteCollectionSettings,
              listIndexesSettings,
              getIndexSettings,
              createIndexSettings,
              deleteIndexSettings,
              importDataObjectsSettings,
              exportDataObjectsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listCollectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .deleteCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listIndexesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .deleteIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .importDataObjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .exportDataObjectsSettings()
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
          .createCollectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCollectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateCollectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCollectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteCollectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCollectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Index.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .importDataObjectsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportDataObjectsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportDataObjectsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportDataObjectsMetadata.class))
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
          .exportDataObjectsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportDataObjectsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportDataObjectsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportDataObjectsMetadata.class))
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

    /** Returns the builder for the settings used for calls to listCollections. */
    public PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings() {
      return listCollectionsSettings;
    }

    /** Returns the builder for the settings used for calls to getCollection. */
    public UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings() {
      return getCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings() {
      return createCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public OperationCallSettings.Builder<CreateCollectionRequest, Collection, OperationMetadata>
        createCollectionOperationSettings() {
      return createCollectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public UnaryCallSettings.Builder<UpdateCollectionRequest, Operation>
        updateCollectionSettings() {
      return updateCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public OperationCallSettings.Builder<UpdateCollectionRequest, Collection, OperationMetadata>
        updateCollectionOperationSettings() {
      return updateCollectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings() {
      return deleteCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public OperationCallSettings.Builder<DeleteCollectionRequest, Empty, OperationMetadata>
        deleteCollectionOperationSettings() {
      return deleteCollectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return listIndexesSettings;
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getIndexSettings;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return createIndexSettings;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, OperationMetadata>
        createIndexOperationSettings() {
      return createIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return deleteIndexSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Empty, OperationMetadata>
        deleteIndexOperationSettings() {
      return deleteIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importDataObjects. */
    public UnaryCallSettings.Builder<ImportDataObjectsRequest, Operation>
        importDataObjectsSettings() {
      return importDataObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to importDataObjects. */
    public OperationCallSettings.Builder<
            ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
        importDataObjectsOperationSettings() {
      return importDataObjectsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportDataObjects. */
    public UnaryCallSettings.Builder<ExportDataObjectsRequest, Operation>
        exportDataObjectsSettings() {
      return exportDataObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to exportDataObjects. */
    public OperationCallSettings.Builder<
            ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
        exportDataObjectsOperationSettings() {
      return exportDataObjectsOperationSettings;
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
    public VectorSearchServiceStubSettings build() throws IOException {
      return new VectorSearchServiceStubSettings(this);
    }
  }
}
