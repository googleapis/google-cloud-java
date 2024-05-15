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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.WarehouseClient.ListAnnotationsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListAssetsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListCollectionsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListCorporaPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListDataSchemasPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListIndexEndpointsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListIndexesPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListSearchConfigsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListSearchHypernymsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.SearchAssetsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.SearchIndexEndpointPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ViewCollectionItemsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ViewIndexedAssetsPagedResponse;

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
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AddCollectionItemRequest;
import com.google.cloud.visionai.v1.AddCollectionItemResponse;
import com.google.cloud.visionai.v1.AnalyzeAssetMetadata;
import com.google.cloud.visionai.v1.AnalyzeAssetRequest;
import com.google.cloud.visionai.v1.AnalyzeAssetResponse;
import com.google.cloud.visionai.v1.AnalyzeCorpusMetadata;
import com.google.cloud.visionai.v1.AnalyzeCorpusRequest;
import com.google.cloud.visionai.v1.AnalyzeCorpusResponse;
import com.google.cloud.visionai.v1.Annotation;
import com.google.cloud.visionai.v1.Asset;
import com.google.cloud.visionai.v1.ClipAssetRequest;
import com.google.cloud.visionai.v1.ClipAssetResponse;
import com.google.cloud.visionai.v1.Collection;
import com.google.cloud.visionai.v1.CollectionItem;
import com.google.cloud.visionai.v1.Corpus;
import com.google.cloud.visionai.v1.CreateAnnotationRequest;
import com.google.cloud.visionai.v1.CreateAssetRequest;
import com.google.cloud.visionai.v1.CreateCollectionMetadata;
import com.google.cloud.visionai.v1.CreateCollectionRequest;
import com.google.cloud.visionai.v1.CreateCorpusMetadata;
import com.google.cloud.visionai.v1.CreateCorpusRequest;
import com.google.cloud.visionai.v1.CreateDataSchemaRequest;
import com.google.cloud.visionai.v1.CreateIndexEndpointMetadata;
import com.google.cloud.visionai.v1.CreateIndexEndpointRequest;
import com.google.cloud.visionai.v1.CreateIndexMetadata;
import com.google.cloud.visionai.v1.CreateIndexRequest;
import com.google.cloud.visionai.v1.CreateSearchConfigRequest;
import com.google.cloud.visionai.v1.CreateSearchHypernymRequest;
import com.google.cloud.visionai.v1.DataSchema;
import com.google.cloud.visionai.v1.DeleteAnnotationRequest;
import com.google.cloud.visionai.v1.DeleteAssetMetadata;
import com.google.cloud.visionai.v1.DeleteAssetRequest;
import com.google.cloud.visionai.v1.DeleteCollectionMetadata;
import com.google.cloud.visionai.v1.DeleteCollectionRequest;
import com.google.cloud.visionai.v1.DeleteCorpusRequest;
import com.google.cloud.visionai.v1.DeleteDataSchemaRequest;
import com.google.cloud.visionai.v1.DeleteIndexEndpointMetadata;
import com.google.cloud.visionai.v1.DeleteIndexEndpointRequest;
import com.google.cloud.visionai.v1.DeleteIndexMetadata;
import com.google.cloud.visionai.v1.DeleteIndexRequest;
import com.google.cloud.visionai.v1.DeleteSearchConfigRequest;
import com.google.cloud.visionai.v1.DeleteSearchHypernymRequest;
import com.google.cloud.visionai.v1.DeployIndexMetadata;
import com.google.cloud.visionai.v1.DeployIndexRequest;
import com.google.cloud.visionai.v1.DeployIndexResponse;
import com.google.cloud.visionai.v1.GenerateHlsUriRequest;
import com.google.cloud.visionai.v1.GenerateHlsUriResponse;
import com.google.cloud.visionai.v1.GenerateRetrievalUrlRequest;
import com.google.cloud.visionai.v1.GenerateRetrievalUrlResponse;
import com.google.cloud.visionai.v1.GetAnnotationRequest;
import com.google.cloud.visionai.v1.GetAssetRequest;
import com.google.cloud.visionai.v1.GetCollectionRequest;
import com.google.cloud.visionai.v1.GetCorpusRequest;
import com.google.cloud.visionai.v1.GetDataSchemaRequest;
import com.google.cloud.visionai.v1.GetIndexEndpointRequest;
import com.google.cloud.visionai.v1.GetIndexRequest;
import com.google.cloud.visionai.v1.GetSearchConfigRequest;
import com.google.cloud.visionai.v1.GetSearchHypernymRequest;
import com.google.cloud.visionai.v1.ImportAssetsMetadata;
import com.google.cloud.visionai.v1.ImportAssetsRequest;
import com.google.cloud.visionai.v1.ImportAssetsResponse;
import com.google.cloud.visionai.v1.Index;
import com.google.cloud.visionai.v1.IndexAssetMetadata;
import com.google.cloud.visionai.v1.IndexAssetRequest;
import com.google.cloud.visionai.v1.IndexAssetResponse;
import com.google.cloud.visionai.v1.IndexEndpoint;
import com.google.cloud.visionai.v1.IndexedAsset;
import com.google.cloud.visionai.v1.IngestAssetRequest;
import com.google.cloud.visionai.v1.IngestAssetResponse;
import com.google.cloud.visionai.v1.ListAnnotationsRequest;
import com.google.cloud.visionai.v1.ListAnnotationsResponse;
import com.google.cloud.visionai.v1.ListAssetsRequest;
import com.google.cloud.visionai.v1.ListAssetsResponse;
import com.google.cloud.visionai.v1.ListCollectionsRequest;
import com.google.cloud.visionai.v1.ListCollectionsResponse;
import com.google.cloud.visionai.v1.ListCorporaRequest;
import com.google.cloud.visionai.v1.ListCorporaResponse;
import com.google.cloud.visionai.v1.ListDataSchemasRequest;
import com.google.cloud.visionai.v1.ListDataSchemasResponse;
import com.google.cloud.visionai.v1.ListIndexEndpointsRequest;
import com.google.cloud.visionai.v1.ListIndexEndpointsResponse;
import com.google.cloud.visionai.v1.ListIndexesRequest;
import com.google.cloud.visionai.v1.ListIndexesResponse;
import com.google.cloud.visionai.v1.ListSearchConfigsRequest;
import com.google.cloud.visionai.v1.ListSearchConfigsResponse;
import com.google.cloud.visionai.v1.ListSearchHypernymsRequest;
import com.google.cloud.visionai.v1.ListSearchHypernymsResponse;
import com.google.cloud.visionai.v1.RemoveCollectionItemRequest;
import com.google.cloud.visionai.v1.RemoveCollectionItemResponse;
import com.google.cloud.visionai.v1.RemoveIndexAssetMetadata;
import com.google.cloud.visionai.v1.RemoveIndexAssetRequest;
import com.google.cloud.visionai.v1.RemoveIndexAssetResponse;
import com.google.cloud.visionai.v1.SearchAssetsRequest;
import com.google.cloud.visionai.v1.SearchAssetsResponse;
import com.google.cloud.visionai.v1.SearchConfig;
import com.google.cloud.visionai.v1.SearchHypernym;
import com.google.cloud.visionai.v1.SearchIndexEndpointRequest;
import com.google.cloud.visionai.v1.SearchIndexEndpointResponse;
import com.google.cloud.visionai.v1.SearchResultItem;
import com.google.cloud.visionai.v1.UndeployIndexMetadata;
import com.google.cloud.visionai.v1.UndeployIndexRequest;
import com.google.cloud.visionai.v1.UndeployIndexResponse;
import com.google.cloud.visionai.v1.UpdateAnnotationRequest;
import com.google.cloud.visionai.v1.UpdateAssetRequest;
import com.google.cloud.visionai.v1.UpdateCollectionRequest;
import com.google.cloud.visionai.v1.UpdateCorpusRequest;
import com.google.cloud.visionai.v1.UpdateDataSchemaRequest;
import com.google.cloud.visionai.v1.UpdateIndexEndpointMetadata;
import com.google.cloud.visionai.v1.UpdateIndexEndpointRequest;
import com.google.cloud.visionai.v1.UpdateIndexMetadata;
import com.google.cloud.visionai.v1.UpdateIndexRequest;
import com.google.cloud.visionai.v1.UpdateSearchConfigRequest;
import com.google.cloud.visionai.v1.UpdateSearchHypernymRequest;
import com.google.cloud.visionai.v1.UploadAssetMetadata;
import com.google.cloud.visionai.v1.UploadAssetRequest;
import com.google.cloud.visionai.v1.UploadAssetResponse;
import com.google.cloud.visionai.v1.ViewCollectionItemsRequest;
import com.google.cloud.visionai.v1.ViewCollectionItemsResponse;
import com.google.cloud.visionai.v1.ViewIndexedAssetsRequest;
import com.google.cloud.visionai.v1.ViewIndexedAssetsResponse;
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
 * Settings class to configure an instance of {@link WarehouseStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAsset to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WarehouseStubSettings.Builder warehouseSettingsBuilder = WarehouseStubSettings.newBuilder();
 * warehouseSettingsBuilder
 *     .createAssetSettings()
 *     .setRetrySettings(
 *         warehouseSettingsBuilder
 *             .createAssetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WarehouseStubSettings warehouseSettings = warehouseSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WarehouseStubSettings extends StubSettings<WarehouseStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAssetRequest, Asset> createAssetSettings;
  private final UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings;
  private final UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings;
  private final PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings;
  private final UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings;
  private final OperationCallSettings<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationSettings;
  private final UnaryCallSettings<UploadAssetRequest, Operation> uploadAssetSettings;
  private final OperationCallSettings<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationSettings;
  private final UnaryCallSettings<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlSettings;
  private final UnaryCallSettings<AnalyzeAssetRequest, Operation> analyzeAssetSettings;
  private final OperationCallSettings<
          AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationSettings;
  private final UnaryCallSettings<IndexAssetRequest, Operation> indexAssetSettings;
  private final OperationCallSettings<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationSettings;
  private final UnaryCallSettings<RemoveIndexAssetRequest, Operation> removeIndexAssetSettings;
  private final OperationCallSettings<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationSettings;
  private final PagedCallSettings<
          ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsSettings;
  private final UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings;
  private final OperationCallSettings<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationSettings;
  private final UnaryCallSettings<UpdateIndexRequest, Operation> updateIndexSettings;
  private final OperationCallSettings<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationSettings;
  private final UnaryCallSettings<GetIndexRequest, Index> getIndexSettings;
  private final PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings;
  private final UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings;
  private final OperationCallSettings<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationSettings;
  private final UnaryCallSettings<CreateCorpusRequest, Operation> createCorpusSettings;
  private final OperationCallSettings<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationSettings;
  private final UnaryCallSettings<GetCorpusRequest, Corpus> getCorpusSettings;
  private final UnaryCallSettings<UpdateCorpusRequest, Corpus> updateCorpusSettings;
  private final PagedCallSettings<ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
      listCorporaSettings;
  private final UnaryCallSettings<DeleteCorpusRequest, Empty> deleteCorpusSettings;
  private final UnaryCallSettings<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings;
  private final OperationCallSettings<
          AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationSettings;
  private final UnaryCallSettings<CreateDataSchemaRequest, DataSchema> createDataSchemaSettings;
  private final UnaryCallSettings<UpdateDataSchemaRequest, DataSchema> updateDataSchemaSettings;
  private final UnaryCallSettings<GetDataSchemaRequest, DataSchema> getDataSchemaSettings;
  private final UnaryCallSettings<DeleteDataSchemaRequest, Empty> deleteDataSchemaSettings;
  private final PagedCallSettings<
          ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
      listDataSchemasSettings;
  private final UnaryCallSettings<CreateAnnotationRequest, Annotation> createAnnotationSettings;
  private final UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings;
  private final PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings;
  private final UnaryCallSettings<UpdateAnnotationRequest, Annotation> updateAnnotationSettings;
  private final UnaryCallSettings<DeleteAnnotationRequest, Empty> deleteAnnotationSettings;
  private final StreamingCallSettings<IngestAssetRequest, IngestAssetResponse> ingestAssetSettings;
  private final UnaryCallSettings<ClipAssetRequest, ClipAssetResponse> clipAssetSettings;
  private final UnaryCallSettings<GenerateHlsUriRequest, GenerateHlsUriResponse>
      generateHlsUriSettings;
  private final UnaryCallSettings<ImportAssetsRequest, Operation> importAssetsSettings;
  private final OperationCallSettings<
          ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationSettings;
  private final UnaryCallSettings<CreateSearchConfigRequest, SearchConfig>
      createSearchConfigSettings;
  private final UnaryCallSettings<UpdateSearchConfigRequest, SearchConfig>
      updateSearchConfigSettings;
  private final UnaryCallSettings<GetSearchConfigRequest, SearchConfig> getSearchConfigSettings;
  private final UnaryCallSettings<DeleteSearchConfigRequest, Empty> deleteSearchConfigSettings;
  private final PagedCallSettings<
          ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
      listSearchConfigsSettings;
  private final UnaryCallSettings<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymSettings;
  private final UnaryCallSettings<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymSettings;
  private final UnaryCallSettings<GetSearchHypernymRequest, SearchHypernym>
      getSearchHypernymSettings;
  private final UnaryCallSettings<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymSettings;
  private final PagedCallSettings<
          ListSearchHypernymsRequest, ListSearchHypernymsResponse, ListSearchHypernymsPagedResponse>
      listSearchHypernymsSettings;
  private final PagedCallSettings<
          SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
      searchAssetsSettings;
  private final PagedCallSettings<
          SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchIndexEndpointPagedResponse>
      searchIndexEndpointSettings;
  private final UnaryCallSettings<CreateIndexEndpointRequest, Operation>
      createIndexEndpointSettings;
  private final OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationSettings;
  private final UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings;
  private final PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings;
  private final UnaryCallSettings<UpdateIndexEndpointRequest, Operation>
      updateIndexEndpointSettings;
  private final OperationCallSettings<
          UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationSettings;
  private final UnaryCallSettings<DeleteIndexEndpointRequest, Operation>
      deleteIndexEndpointSettings;
  private final OperationCallSettings<
          DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationSettings;
  private final UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings;
  private final OperationCallSettings<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationSettings;
  private final UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings;
  private final OperationCallSettings<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationSettings;
  private final UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings;
  private final OperationCallSettings<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationSettings;
  private final UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings;
  private final OperationCallSettings<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationSettings;
  private final UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings;
  private final UnaryCallSettings<UpdateCollectionRequest, Collection> updateCollectionSettings;
  private final PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings;
  private final UnaryCallSettings<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemSettings;
  private final UnaryCallSettings<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemSettings;
  private final PagedCallSettings<
          ViewCollectionItemsRequest, ViewCollectionItemsResponse, ViewCollectionItemsPagedResponse>
      viewCollectionItemsSettings;

  private static final PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>
      LIST_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssetsRequest injectToken(ListAssetsRequest payload, String token) {
              return ListAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssetsRequest injectPageSize(ListAssetsRequest payload, int pageSize) {
              return ListAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Asset> extractResources(ListAssetsResponse payload) {
              return payload.getAssetsList() == null
                  ? ImmutableList.<Asset>of()
                  : payload.getAssetsList();
            }
          };

  private static final PagedListDescriptor<
          ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset>
      VIEW_INDEXED_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ViewIndexedAssetsRequest injectToken(
                ViewIndexedAssetsRequest payload, String token) {
              return ViewIndexedAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ViewIndexedAssetsRequest injectPageSize(
                ViewIndexedAssetsRequest payload, int pageSize) {
              return ViewIndexedAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ViewIndexedAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ViewIndexedAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IndexedAsset> extractResources(ViewIndexedAssetsResponse payload) {
              return payload.getIndexedAssetsList() == null
                  ? ImmutableList.<IndexedAsset>of()
                  : payload.getIndexedAssetsList();
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
              return payload.getIndexesList() == null
                  ? ImmutableList.<Index>of()
                  : payload.getIndexesList();
            }
          };

  private static final PagedListDescriptor<ListCorporaRequest, ListCorporaResponse, Corpus>
      LIST_CORPORA_PAGE_STR_DESC =
          new PagedListDescriptor<ListCorporaRequest, ListCorporaResponse, Corpus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCorporaRequest injectToken(ListCorporaRequest payload, String token) {
              return ListCorporaRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCorporaRequest injectPageSize(ListCorporaRequest payload, int pageSize) {
              return ListCorporaRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCorporaRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCorporaResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Corpus> extractResources(ListCorporaResponse payload) {
              return payload.getCorporaList() == null
                  ? ImmutableList.<Corpus>of()
                  : payload.getCorporaList();
            }
          };

  private static final PagedListDescriptor<
          ListDataSchemasRequest, ListDataSchemasResponse, DataSchema>
      LIST_DATA_SCHEMAS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataSchemasRequest injectToken(
                ListDataSchemasRequest payload, String token) {
              return ListDataSchemasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataSchemasRequest injectPageSize(
                ListDataSchemasRequest payload, int pageSize) {
              return ListDataSchemasRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataSchemasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataSchemasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataSchema> extractResources(ListDataSchemasResponse payload) {
              return payload.getDataSchemasList() == null
                  ? ImmutableList.<DataSchema>of()
                  : payload.getDataSchemasList();
            }
          };

  private static final PagedListDescriptor<
          ListAnnotationsRequest, ListAnnotationsResponse, Annotation>
      LIST_ANNOTATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAnnotationsRequest, ListAnnotationsResponse, Annotation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnnotationsRequest injectToken(
                ListAnnotationsRequest payload, String token) {
              return ListAnnotationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnnotationsRequest injectPageSize(
                ListAnnotationsRequest payload, int pageSize) {
              return ListAnnotationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnnotationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnnotationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Annotation> extractResources(ListAnnotationsResponse payload) {
              return payload.getAnnotationsList() == null
                  ? ImmutableList.<Annotation>of()
                  : payload.getAnnotationsList();
            }
          };

  private static final PagedListDescriptor<
          ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig>
      LIST_SEARCH_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSearchConfigsRequest injectToken(
                ListSearchConfigsRequest payload, String token) {
              return ListSearchConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSearchConfigsRequest injectPageSize(
                ListSearchConfigsRequest payload, int pageSize) {
              return ListSearchConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSearchConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSearchConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchConfig> extractResources(ListSearchConfigsResponse payload) {
              return payload.getSearchConfigsList() == null
                  ? ImmutableList.<SearchConfig>of()
                  : payload.getSearchConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
      LIST_SEARCH_HYPERNYMS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSearchHypernymsRequest injectToken(
                ListSearchHypernymsRequest payload, String token) {
              return ListSearchHypernymsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSearchHypernymsRequest injectPageSize(
                ListSearchHypernymsRequest payload, int pageSize) {
              return ListSearchHypernymsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSearchHypernymsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSearchHypernymsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchHypernym> extractResources(ListSearchHypernymsResponse payload) {
              return payload.getSearchHypernymsList() == null
                  ? ImmutableList.<SearchHypernym>of()
                  : payload.getSearchHypernymsList();
            }
          };

  private static final PagedListDescriptor<
          SearchAssetsRequest, SearchAssetsResponse, SearchResultItem>
      SEARCH_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAssetsRequest injectToken(SearchAssetsRequest payload, String token) {
              return SearchAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAssetsRequest injectPageSize(SearchAssetsRequest payload, int pageSize) {
              return SearchAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchResultItem> extractResources(SearchAssetsResponse payload) {
              return payload.getSearchResultItemsList() == null
                  ? ImmutableList.<SearchResultItem>of()
                  : payload.getSearchResultItemsList();
            }
          };

  private static final PagedListDescriptor<
          SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
      SEARCH_INDEX_ENDPOINT_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchIndexEndpointRequest injectToken(
                SearchIndexEndpointRequest payload, String token) {
              return SearchIndexEndpointRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchIndexEndpointRequest injectPageSize(
                SearchIndexEndpointRequest payload, int pageSize) {
              return SearchIndexEndpointRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchIndexEndpointRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchIndexEndpointResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchResultItem> extractResources(
                SearchIndexEndpointResponse payload) {
              return payload.getSearchResultItemsList() == null
                  ? ImmutableList.<SearchResultItem>of()
                  : payload.getSearchResultItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>
      LIST_INDEX_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIndexEndpointsRequest injectToken(
                ListIndexEndpointsRequest payload, String token) {
              return ListIndexEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIndexEndpointsRequest injectPageSize(
                ListIndexEndpointsRequest payload, int pageSize) {
              return ListIndexEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIndexEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIndexEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IndexEndpoint> extractResources(ListIndexEndpointsResponse payload) {
              return payload.getIndexEndpointsList() == null
                  ? ImmutableList.<IndexEndpoint>of()
                  : payload.getIndexEndpointsList();
            }
          };

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
              return payload.getCollectionsList() == null
                  ? ImmutableList.<Collection>of()
                  : payload.getCollectionsList();
            }
          };

  private static final PagedListDescriptor<
          ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
      VIEW_COLLECTION_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ViewCollectionItemsRequest injectToken(
                ViewCollectionItemsRequest payload, String token) {
              return ViewCollectionItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ViewCollectionItemsRequest injectPageSize(
                ViewCollectionItemsRequest payload, int pageSize) {
              return ViewCollectionItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ViewCollectionItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ViewCollectionItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CollectionItem> extractResources(ViewCollectionItemsResponse payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<CollectionItem>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      LIST_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>() {
            @Override
            public ApiFuture<ListAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssetsRequest, ListAssetsResponse> callable,
                ListAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssetsResponse> futureResponse) {
              PageContext<ListAssetsRequest, ListAssetsResponse, Asset> pageContext =
                  PageContext.create(callable, LIST_ASSETS_PAGE_STR_DESC, request, context);
              return ListAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
      VIEW_INDEXED_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ViewIndexedAssetsRequest,
              ViewIndexedAssetsResponse,
              ViewIndexedAssetsPagedResponse>() {
            @Override
            public ApiFuture<ViewIndexedAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse> callable,
                ViewIndexedAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ViewIndexedAssetsResponse> futureResponse) {
              PageContext<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset>
                  pageContext =
                      PageContext.create(
                          callable, VIEW_INDEXED_ASSETS_PAGE_STR_DESC, request, context);
              return ViewIndexedAssetsPagedResponse.createAsync(pageContext, futureResponse);
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
          ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
      LIST_CORPORA_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>() {
            @Override
            public ApiFuture<ListCorporaPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCorporaRequest, ListCorporaResponse> callable,
                ListCorporaRequest request,
                ApiCallContext context,
                ApiFuture<ListCorporaResponse> futureResponse) {
              PageContext<ListCorporaRequest, ListCorporaResponse, Corpus> pageContext =
                  PageContext.create(callable, LIST_CORPORA_PAGE_STR_DESC, request, context);
              return ListCorporaPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
      LIST_DATA_SCHEMAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>() {
            @Override
            public ApiFuture<ListDataSchemasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataSchemasRequest, ListDataSchemasResponse> callable,
                ListDataSchemasRequest request,
                ApiCallContext context,
                ApiFuture<ListDataSchemasResponse> futureResponse) {
              PageContext<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema> pageContext =
                  PageContext.create(callable, LIST_DATA_SCHEMAS_PAGE_STR_DESC, request, context);
              return ListDataSchemasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      LIST_ANNOTATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>() {
            @Override
            public ApiFuture<ListAnnotationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> callable,
                ListAnnotationsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnnotationsResponse> futureResponse) {
              PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> pageContext =
                  PageContext.create(callable, LIST_ANNOTATIONS_PAGE_STR_DESC, request, context);
              return ListAnnotationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
      LIST_SEARCH_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSearchConfigsRequest,
              ListSearchConfigsResponse,
              ListSearchConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListSearchConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsResponse> callable,
                ListSearchConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListSearchConfigsResponse> futureResponse) {
              PageContext<ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SEARCH_CONFIGS_PAGE_STR_DESC, request, context);
              return ListSearchConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSearchHypernymsRequest, ListSearchHypernymsResponse, ListSearchHypernymsPagedResponse>
      LIST_SEARCH_HYPERNYMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSearchHypernymsRequest,
              ListSearchHypernymsResponse,
              ListSearchHypernymsPagedResponse>() {
            @Override
            public ApiFuture<ListSearchHypernymsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsResponse> callable,
                ListSearchHypernymsRequest request,
                ApiCallContext context,
                ApiFuture<ListSearchHypernymsResponse> futureResponse) {
              PageContext<ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SEARCH_HYPERNYMS_PAGE_STR_DESC, request, context);
              return ListSearchHypernymsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
      SEARCH_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>() {
            @Override
            public ApiFuture<SearchAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAssetsRequest, SearchAssetsResponse> callable,
                SearchAssetsRequest request,
                ApiCallContext context,
                ApiFuture<SearchAssetsResponse> futureResponse) {
              PageContext<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem> pageContext =
                  PageContext.create(callable, SEARCH_ASSETS_PAGE_STR_DESC, request, context);
              return SearchAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchIndexEndpointPagedResponse>
      SEARCH_INDEX_ENDPOINT_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchIndexEndpointRequest,
              SearchIndexEndpointResponse,
              SearchIndexEndpointPagedResponse>() {
            @Override
            public ApiFuture<SearchIndexEndpointPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointResponse> callable,
                SearchIndexEndpointRequest request,
                ApiCallContext context,
                ApiFuture<SearchIndexEndpointResponse> futureResponse) {
              PageContext<SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_INDEX_ENDPOINT_PAGE_STR_DESC, request, context);
              return SearchIndexEndpointPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      LIST_INDEX_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIndexEndpointsRequest,
              ListIndexEndpointsResponse,
              ListIndexEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListIndexEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse> callable,
                ListIndexEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListIndexEndpointsResponse> futureResponse) {
              PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INDEX_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListIndexEndpointsPagedResponse.createAsync(pageContext, futureResponse);
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
          ViewCollectionItemsRequest, ViewCollectionItemsResponse, ViewCollectionItemsPagedResponse>
      VIEW_COLLECTION_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ViewCollectionItemsRequest,
              ViewCollectionItemsResponse,
              ViewCollectionItemsPagedResponse>() {
            @Override
            public ApiFuture<ViewCollectionItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsResponse> callable,
                ViewCollectionItemsRequest request,
                ApiCallContext context,
                ApiFuture<ViewCollectionItemsResponse> futureResponse) {
              PageContext<ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
                  pageContext =
                      PageContext.create(
                          callable, VIEW_COLLECTION_ITEMS_PAGE_STR_DESC, request, context);
              return ViewCollectionItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAsset. */
  public UnaryCallSettings<CreateAssetRequest, Asset> createAssetSettings() {
    return createAssetSettings;
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings() {
    return updateAssetSettings;
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return getAssetSettings;
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return listAssetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings() {
    return deleteAssetSettings;
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public OperationCallSettings<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationSettings() {
    return deleteAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to uploadAsset. */
  public UnaryCallSettings<UploadAssetRequest, Operation> uploadAssetSettings() {
    return uploadAssetSettings;
  }

  /** Returns the object with the settings used for calls to uploadAsset. */
  public OperationCallSettings<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationSettings() {
    return uploadAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateRetrievalUrl. */
  public UnaryCallSettings<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlSettings() {
    return generateRetrievalUrlSettings;
  }

  /** Returns the object with the settings used for calls to analyzeAsset. */
  public UnaryCallSettings<AnalyzeAssetRequest, Operation> analyzeAssetSettings() {
    return analyzeAssetSettings;
  }

  /** Returns the object with the settings used for calls to analyzeAsset. */
  public OperationCallSettings<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationSettings() {
    return analyzeAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to indexAsset. */
  public UnaryCallSettings<IndexAssetRequest, Operation> indexAssetSettings() {
    return indexAssetSettings;
  }

  /** Returns the object with the settings used for calls to indexAsset. */
  public OperationCallSettings<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationSettings() {
    return indexAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeIndexAsset. */
  public UnaryCallSettings<RemoveIndexAssetRequest, Operation> removeIndexAssetSettings() {
    return removeIndexAssetSettings;
  }

  /** Returns the object with the settings used for calls to removeIndexAsset. */
  public OperationCallSettings<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationSettings() {
    return removeIndexAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to viewIndexedAssets. */
  public PagedCallSettings<
          ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsSettings() {
    return viewIndexedAssetsSettings;
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return createIndexSettings;
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationSettings() {
    return createIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public UnaryCallSettings<UpdateIndexRequest, Operation> updateIndexSettings() {
    return updateIndexSettings;
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public OperationCallSettings<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationSettings() {
    return updateIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return getIndexSettings;
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return listIndexesSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return deleteIndexSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationSettings() {
    return deleteIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to createCorpus. */
  public UnaryCallSettings<CreateCorpusRequest, Operation> createCorpusSettings() {
    return createCorpusSettings;
  }

  /** Returns the object with the settings used for calls to createCorpus. */
  public OperationCallSettings<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationSettings() {
    return createCorpusOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCorpus. */
  public UnaryCallSettings<GetCorpusRequest, Corpus> getCorpusSettings() {
    return getCorpusSettings;
  }

  /** Returns the object with the settings used for calls to updateCorpus. */
  public UnaryCallSettings<UpdateCorpusRequest, Corpus> updateCorpusSettings() {
    return updateCorpusSettings;
  }

  /** Returns the object with the settings used for calls to listCorpora. */
  public PagedCallSettings<ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
      listCorporaSettings() {
    return listCorporaSettings;
  }

  /** Returns the object with the settings used for calls to deleteCorpus. */
  public UnaryCallSettings<DeleteCorpusRequest, Empty> deleteCorpusSettings() {
    return deleteCorpusSettings;
  }

  /** Returns the object with the settings used for calls to analyzeCorpus. */
  public UnaryCallSettings<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings() {
    return analyzeCorpusSettings;
  }

  /** Returns the object with the settings used for calls to analyzeCorpus. */
  public OperationCallSettings<AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationSettings() {
    return analyzeCorpusOperationSettings;
  }

  /** Returns the object with the settings used for calls to createDataSchema. */
  public UnaryCallSettings<CreateDataSchemaRequest, DataSchema> createDataSchemaSettings() {
    return createDataSchemaSettings;
  }

  /** Returns the object with the settings used for calls to updateDataSchema. */
  public UnaryCallSettings<UpdateDataSchemaRequest, DataSchema> updateDataSchemaSettings() {
    return updateDataSchemaSettings;
  }

  /** Returns the object with the settings used for calls to getDataSchema. */
  public UnaryCallSettings<GetDataSchemaRequest, DataSchema> getDataSchemaSettings() {
    return getDataSchemaSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataSchema. */
  public UnaryCallSettings<DeleteDataSchemaRequest, Empty> deleteDataSchemaSettings() {
    return deleteDataSchemaSettings;
  }

  /** Returns the object with the settings used for calls to listDataSchemas. */
  public PagedCallSettings<
          ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
      listDataSchemasSettings() {
    return listDataSchemasSettings;
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public UnaryCallSettings<CreateAnnotationRequest, Annotation> createAnnotationSettings() {
    return createAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to getAnnotation. */
  public UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings() {
    return getAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to listAnnotations. */
  public PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings() {
    return listAnnotationsSettings;
  }

  /** Returns the object with the settings used for calls to updateAnnotation. */
  public UnaryCallSettings<UpdateAnnotationRequest, Annotation> updateAnnotationSettings() {
    return updateAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnnotation. */
  public UnaryCallSettings<DeleteAnnotationRequest, Empty> deleteAnnotationSettings() {
    return deleteAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to ingestAsset. */
  public StreamingCallSettings<IngestAssetRequest, IngestAssetResponse> ingestAssetSettings() {
    return ingestAssetSettings;
  }

  /** Returns the object with the settings used for calls to clipAsset. */
  public UnaryCallSettings<ClipAssetRequest, ClipAssetResponse> clipAssetSettings() {
    return clipAssetSettings;
  }

  /** Returns the object with the settings used for calls to generateHlsUri. */
  public UnaryCallSettings<GenerateHlsUriRequest, GenerateHlsUriResponse> generateHlsUriSettings() {
    return generateHlsUriSettings;
  }

  /** Returns the object with the settings used for calls to importAssets. */
  public UnaryCallSettings<ImportAssetsRequest, Operation> importAssetsSettings() {
    return importAssetsSettings;
  }

  /** Returns the object with the settings used for calls to importAssets. */
  public OperationCallSettings<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationSettings() {
    return importAssetsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createSearchConfig. */
  public UnaryCallSettings<CreateSearchConfigRequest, SearchConfig> createSearchConfigSettings() {
    return createSearchConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateSearchConfig. */
  public UnaryCallSettings<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigSettings() {
    return updateSearchConfigSettings;
  }

  /** Returns the object with the settings used for calls to getSearchConfig. */
  public UnaryCallSettings<GetSearchConfigRequest, SearchConfig> getSearchConfigSettings() {
    return getSearchConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteSearchConfig. */
  public UnaryCallSettings<DeleteSearchConfigRequest, Empty> deleteSearchConfigSettings() {
    return deleteSearchConfigSettings;
  }

  /** Returns the object with the settings used for calls to listSearchConfigs. */
  public PagedCallSettings<
          ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
      listSearchConfigsSettings() {
    return listSearchConfigsSettings;
  }

  /** Returns the object with the settings used for calls to createSearchHypernym. */
  public UnaryCallSettings<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymSettings() {
    return createSearchHypernymSettings;
  }

  /** Returns the object with the settings used for calls to updateSearchHypernym. */
  public UnaryCallSettings<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymSettings() {
    return updateSearchHypernymSettings;
  }

  /** Returns the object with the settings used for calls to getSearchHypernym. */
  public UnaryCallSettings<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymSettings() {
    return getSearchHypernymSettings;
  }

  /** Returns the object with the settings used for calls to deleteSearchHypernym. */
  public UnaryCallSettings<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymSettings() {
    return deleteSearchHypernymSettings;
  }

  /** Returns the object with the settings used for calls to listSearchHypernyms. */
  public PagedCallSettings<
          ListSearchHypernymsRequest, ListSearchHypernymsResponse, ListSearchHypernymsPagedResponse>
      listSearchHypernymsSettings() {
    return listSearchHypernymsSettings;
  }

  /** Returns the object with the settings used for calls to searchAssets. */
  public PagedCallSettings<SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
      searchAssetsSettings() {
    return searchAssetsSettings;
  }

  /** Returns the object with the settings used for calls to searchIndexEndpoint. */
  public PagedCallSettings<
          SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchIndexEndpointPagedResponse>
      searchIndexEndpointSettings() {
    return searchIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public UnaryCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointSettings() {
    return createIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationSettings() {
    return createIndexEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIndexEndpoint. */
  public UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings() {
    return getIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to listIndexEndpoints. */
  public PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings() {
    return listIndexEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public UnaryCallSettings<UpdateIndexEndpointRequest, Operation> updateIndexEndpointSettings() {
    return updateIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public OperationCallSettings<
          UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationSettings() {
    return updateIndexEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public UnaryCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointSettings() {
    return deleteIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public OperationCallSettings<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationSettings() {
    return deleteIndexEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings() {
    return deployIndexSettings;
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public OperationCallSettings<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationSettings() {
    return deployIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings() {
    return undeployIndexSettings;
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public OperationCallSettings<UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationSettings() {
    return undeployIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings() {
    return createCollectionSettings;
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public OperationCallSettings<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationSettings() {
    return createCollectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings() {
    return deleteCollectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public OperationCallSettings<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationSettings() {
    return deleteCollectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCollection. */
  public UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings() {
    return getCollectionSettings;
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public UnaryCallSettings<UpdateCollectionRequest, Collection> updateCollectionSettings() {
    return updateCollectionSettings;
  }

  /** Returns the object with the settings used for calls to listCollections. */
  public PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings() {
    return listCollectionsSettings;
  }

  /** Returns the object with the settings used for calls to addCollectionItem. */
  public UnaryCallSettings<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemSettings() {
    return addCollectionItemSettings;
  }

  /** Returns the object with the settings used for calls to removeCollectionItem. */
  public UnaryCallSettings<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemSettings() {
    return removeCollectionItemSettings;
  }

  /** Returns the object with the settings used for calls to viewCollectionItems. */
  public PagedCallSettings<
          ViewCollectionItemsRequest, ViewCollectionItemsResponse, ViewCollectionItemsPagedResponse>
      viewCollectionItemsSettings() {
    return viewCollectionItemsSettings;
  }

  public WarehouseStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWarehouseStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonWarehouseStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "visionai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "visionai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "visionai.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(WarehouseStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(WarehouseStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WarehouseStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected WarehouseStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAssetSettings = settingsBuilder.createAssetSettings().build();
    updateAssetSettings = settingsBuilder.updateAssetSettings().build();
    getAssetSettings = settingsBuilder.getAssetSettings().build();
    listAssetsSettings = settingsBuilder.listAssetsSettings().build();
    deleteAssetSettings = settingsBuilder.deleteAssetSettings().build();
    deleteAssetOperationSettings = settingsBuilder.deleteAssetOperationSettings().build();
    uploadAssetSettings = settingsBuilder.uploadAssetSettings().build();
    uploadAssetOperationSettings = settingsBuilder.uploadAssetOperationSettings().build();
    generateRetrievalUrlSettings = settingsBuilder.generateRetrievalUrlSettings().build();
    analyzeAssetSettings = settingsBuilder.analyzeAssetSettings().build();
    analyzeAssetOperationSettings = settingsBuilder.analyzeAssetOperationSettings().build();
    indexAssetSettings = settingsBuilder.indexAssetSettings().build();
    indexAssetOperationSettings = settingsBuilder.indexAssetOperationSettings().build();
    removeIndexAssetSettings = settingsBuilder.removeIndexAssetSettings().build();
    removeIndexAssetOperationSettings = settingsBuilder.removeIndexAssetOperationSettings().build();
    viewIndexedAssetsSettings = settingsBuilder.viewIndexedAssetsSettings().build();
    createIndexSettings = settingsBuilder.createIndexSettings().build();
    createIndexOperationSettings = settingsBuilder.createIndexOperationSettings().build();
    updateIndexSettings = settingsBuilder.updateIndexSettings().build();
    updateIndexOperationSettings = settingsBuilder.updateIndexOperationSettings().build();
    getIndexSettings = settingsBuilder.getIndexSettings().build();
    listIndexesSettings = settingsBuilder.listIndexesSettings().build();
    deleteIndexSettings = settingsBuilder.deleteIndexSettings().build();
    deleteIndexOperationSettings = settingsBuilder.deleteIndexOperationSettings().build();
    createCorpusSettings = settingsBuilder.createCorpusSettings().build();
    createCorpusOperationSettings = settingsBuilder.createCorpusOperationSettings().build();
    getCorpusSettings = settingsBuilder.getCorpusSettings().build();
    updateCorpusSettings = settingsBuilder.updateCorpusSettings().build();
    listCorporaSettings = settingsBuilder.listCorporaSettings().build();
    deleteCorpusSettings = settingsBuilder.deleteCorpusSettings().build();
    analyzeCorpusSettings = settingsBuilder.analyzeCorpusSettings().build();
    analyzeCorpusOperationSettings = settingsBuilder.analyzeCorpusOperationSettings().build();
    createDataSchemaSettings = settingsBuilder.createDataSchemaSettings().build();
    updateDataSchemaSettings = settingsBuilder.updateDataSchemaSettings().build();
    getDataSchemaSettings = settingsBuilder.getDataSchemaSettings().build();
    deleteDataSchemaSettings = settingsBuilder.deleteDataSchemaSettings().build();
    listDataSchemasSettings = settingsBuilder.listDataSchemasSettings().build();
    createAnnotationSettings = settingsBuilder.createAnnotationSettings().build();
    getAnnotationSettings = settingsBuilder.getAnnotationSettings().build();
    listAnnotationsSettings = settingsBuilder.listAnnotationsSettings().build();
    updateAnnotationSettings = settingsBuilder.updateAnnotationSettings().build();
    deleteAnnotationSettings = settingsBuilder.deleteAnnotationSettings().build();
    ingestAssetSettings = settingsBuilder.ingestAssetSettings().build();
    clipAssetSettings = settingsBuilder.clipAssetSettings().build();
    generateHlsUriSettings = settingsBuilder.generateHlsUriSettings().build();
    importAssetsSettings = settingsBuilder.importAssetsSettings().build();
    importAssetsOperationSettings = settingsBuilder.importAssetsOperationSettings().build();
    createSearchConfigSettings = settingsBuilder.createSearchConfigSettings().build();
    updateSearchConfigSettings = settingsBuilder.updateSearchConfigSettings().build();
    getSearchConfigSettings = settingsBuilder.getSearchConfigSettings().build();
    deleteSearchConfigSettings = settingsBuilder.deleteSearchConfigSettings().build();
    listSearchConfigsSettings = settingsBuilder.listSearchConfigsSettings().build();
    createSearchHypernymSettings = settingsBuilder.createSearchHypernymSettings().build();
    updateSearchHypernymSettings = settingsBuilder.updateSearchHypernymSettings().build();
    getSearchHypernymSettings = settingsBuilder.getSearchHypernymSettings().build();
    deleteSearchHypernymSettings = settingsBuilder.deleteSearchHypernymSettings().build();
    listSearchHypernymsSettings = settingsBuilder.listSearchHypernymsSettings().build();
    searchAssetsSettings = settingsBuilder.searchAssetsSettings().build();
    searchIndexEndpointSettings = settingsBuilder.searchIndexEndpointSettings().build();
    createIndexEndpointSettings = settingsBuilder.createIndexEndpointSettings().build();
    createIndexEndpointOperationSettings =
        settingsBuilder.createIndexEndpointOperationSettings().build();
    getIndexEndpointSettings = settingsBuilder.getIndexEndpointSettings().build();
    listIndexEndpointsSettings = settingsBuilder.listIndexEndpointsSettings().build();
    updateIndexEndpointSettings = settingsBuilder.updateIndexEndpointSettings().build();
    updateIndexEndpointOperationSettings =
        settingsBuilder.updateIndexEndpointOperationSettings().build();
    deleteIndexEndpointSettings = settingsBuilder.deleteIndexEndpointSettings().build();
    deleteIndexEndpointOperationSettings =
        settingsBuilder.deleteIndexEndpointOperationSettings().build();
    deployIndexSettings = settingsBuilder.deployIndexSettings().build();
    deployIndexOperationSettings = settingsBuilder.deployIndexOperationSettings().build();
    undeployIndexSettings = settingsBuilder.undeployIndexSettings().build();
    undeployIndexOperationSettings = settingsBuilder.undeployIndexOperationSettings().build();
    createCollectionSettings = settingsBuilder.createCollectionSettings().build();
    createCollectionOperationSettings = settingsBuilder.createCollectionOperationSettings().build();
    deleteCollectionSettings = settingsBuilder.deleteCollectionSettings().build();
    deleteCollectionOperationSettings = settingsBuilder.deleteCollectionOperationSettings().build();
    getCollectionSettings = settingsBuilder.getCollectionSettings().build();
    updateCollectionSettings = settingsBuilder.updateCollectionSettings().build();
    listCollectionsSettings = settingsBuilder.listCollectionsSettings().build();
    addCollectionItemSettings = settingsBuilder.addCollectionItemSettings().build();
    removeCollectionItemSettings = settingsBuilder.removeCollectionItemSettings().build();
    viewCollectionItemsSettings = settingsBuilder.viewCollectionItemsSettings().build();
  }

  /** Builder for WarehouseStubSettings. */
  public static class Builder extends StubSettings.Builder<WarehouseStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAssetRequest, Asset> createAssetSettings;
    private final UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings;
    private final UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings;
    private final PagedCallSettings.Builder<
            ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings;
    private final UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings;
    private final OperationCallSettings.Builder<DeleteAssetRequest, Empty, DeleteAssetMetadata>
        deleteAssetOperationSettings;
    private final UnaryCallSettings.Builder<UploadAssetRequest, Operation> uploadAssetSettings;
    private final OperationCallSettings.Builder<
            UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
        uploadAssetOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
        generateRetrievalUrlSettings;
    private final UnaryCallSettings.Builder<AnalyzeAssetRequest, Operation> analyzeAssetSettings;
    private final OperationCallSettings.Builder<
            AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
        analyzeAssetOperationSettings;
    private final UnaryCallSettings.Builder<IndexAssetRequest, Operation> indexAssetSettings;
    private final OperationCallSettings.Builder<
            IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
        indexAssetOperationSettings;
    private final UnaryCallSettings.Builder<RemoveIndexAssetRequest, Operation>
        removeIndexAssetSettings;
    private final OperationCallSettings.Builder<
            RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
        removeIndexAssetOperationSettings;
    private final PagedCallSettings.Builder<
            ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
        viewIndexedAssetsSettings;
    private final UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings;
    private final OperationCallSettings.Builder<CreateIndexRequest, Index, CreateIndexMetadata>
        createIndexOperationSettings;
    private final UnaryCallSettings.Builder<UpdateIndexRequest, Operation> updateIndexSettings;
    private final OperationCallSettings.Builder<UpdateIndexRequest, Index, UpdateIndexMetadata>
        updateIndexOperationSettings;
    private final UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings;
    private final PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings;
    private final UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings;
    private final OperationCallSettings.Builder<DeleteIndexRequest, Empty, DeleteIndexMetadata>
        deleteIndexOperationSettings;
    private final UnaryCallSettings.Builder<CreateCorpusRequest, Operation> createCorpusSettings;
    private final OperationCallSettings.Builder<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
        createCorpusOperationSettings;
    private final UnaryCallSettings.Builder<GetCorpusRequest, Corpus> getCorpusSettings;
    private final UnaryCallSettings.Builder<UpdateCorpusRequest, Corpus> updateCorpusSettings;
    private final PagedCallSettings.Builder<
            ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
        listCorporaSettings;
    private final UnaryCallSettings.Builder<DeleteCorpusRequest, Empty> deleteCorpusSettings;
    private final UnaryCallSettings.Builder<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings;
    private final OperationCallSettings.Builder<
            AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
        analyzeCorpusOperationSettings;
    private final UnaryCallSettings.Builder<CreateDataSchemaRequest, DataSchema>
        createDataSchemaSettings;
    private final UnaryCallSettings.Builder<UpdateDataSchemaRequest, DataSchema>
        updateDataSchemaSettings;
    private final UnaryCallSettings.Builder<GetDataSchemaRequest, DataSchema> getDataSchemaSettings;
    private final UnaryCallSettings.Builder<DeleteDataSchemaRequest, Empty>
        deleteDataSchemaSettings;
    private final PagedCallSettings.Builder<
            ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
        listDataSchemasSettings;
    private final UnaryCallSettings.Builder<CreateAnnotationRequest, Annotation>
        createAnnotationSettings;
    private final UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings;
    private final PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings;
    private final UnaryCallSettings.Builder<UpdateAnnotationRequest, Annotation>
        updateAnnotationSettings;
    private final UnaryCallSettings.Builder<DeleteAnnotationRequest, Empty>
        deleteAnnotationSettings;
    private final StreamingCallSettings.Builder<IngestAssetRequest, IngestAssetResponse>
        ingestAssetSettings;
    private final UnaryCallSettings.Builder<ClipAssetRequest, ClipAssetResponse> clipAssetSettings;
    private final UnaryCallSettings.Builder<GenerateHlsUriRequest, GenerateHlsUriResponse>
        generateHlsUriSettings;
    private final UnaryCallSettings.Builder<ImportAssetsRequest, Operation> importAssetsSettings;
    private final OperationCallSettings.Builder<
            ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
        importAssetsOperationSettings;
    private final UnaryCallSettings.Builder<CreateSearchConfigRequest, SearchConfig>
        createSearchConfigSettings;
    private final UnaryCallSettings.Builder<UpdateSearchConfigRequest, SearchConfig>
        updateSearchConfigSettings;
    private final UnaryCallSettings.Builder<GetSearchConfigRequest, SearchConfig>
        getSearchConfigSettings;
    private final UnaryCallSettings.Builder<DeleteSearchConfigRequest, Empty>
        deleteSearchConfigSettings;
    private final PagedCallSettings.Builder<
            ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
        listSearchConfigsSettings;
    private final UnaryCallSettings.Builder<CreateSearchHypernymRequest, SearchHypernym>
        createSearchHypernymSettings;
    private final UnaryCallSettings.Builder<UpdateSearchHypernymRequest, SearchHypernym>
        updateSearchHypernymSettings;
    private final UnaryCallSettings.Builder<GetSearchHypernymRequest, SearchHypernym>
        getSearchHypernymSettings;
    private final UnaryCallSettings.Builder<DeleteSearchHypernymRequest, Empty>
        deleteSearchHypernymSettings;
    private final PagedCallSettings.Builder<
            ListSearchHypernymsRequest,
            ListSearchHypernymsResponse,
            ListSearchHypernymsPagedResponse>
        listSearchHypernymsSettings;
    private final PagedCallSettings.Builder<
            SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
        searchAssetsSettings;
    private final PagedCallSettings.Builder<
            SearchIndexEndpointRequest,
            SearchIndexEndpointResponse,
            SearchIndexEndpointPagedResponse>
        searchIndexEndpointSettings;
    private final UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings;
    private final OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
        createIndexEndpointOperationSettings;
    private final UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings;
    private final PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings;
    private final UnaryCallSettings.Builder<UpdateIndexEndpointRequest, Operation>
        updateIndexEndpointSettings;
    private final OperationCallSettings.Builder<
            UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
        updateIndexEndpointOperationSettings;
    private final UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings;
    private final OperationCallSettings.Builder<
            DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
        deleteIndexEndpointOperationSettings;
    private final UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings;
    private final OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
        deployIndexOperationSettings;
    private final UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings;
    private final OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
        undeployIndexOperationSettings;
    private final UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings;
    private final OperationCallSettings.Builder<
            CreateCollectionRequest, Collection, CreateCollectionMetadata>
        createCollectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings;
    private final OperationCallSettings.Builder<
            DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
        deleteCollectionOperationSettings;
    private final UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings;
    private final UnaryCallSettings.Builder<UpdateCollectionRequest, Collection>
        updateCollectionSettings;
    private final PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings;
    private final UnaryCallSettings.Builder<AddCollectionItemRequest, AddCollectionItemResponse>
        addCollectionItemSettings;
    private final UnaryCallSettings.Builder<
            RemoveCollectionItemRequest, RemoveCollectionItemResponse>
        removeCollectionItemSettings;
    private final PagedCallSettings.Builder<
            ViewCollectionItemsRequest,
            ViewCollectionItemsResponse,
            ViewCollectionItemsPagedResponse>
        viewCollectionItemsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_9_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.5)
              .setMaxRetryDelay(Duration.ofMillis(120000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_9_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
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

      createAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAssetsSettings = PagedCallSettings.newBuilder(LIST_ASSETS_PAGE_STR_FACT);
      deleteAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAssetOperationSettings = OperationCallSettings.newBuilder();
      uploadAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadAssetOperationSettings = OperationCallSettings.newBuilder();
      generateRetrievalUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeAssetOperationSettings = OperationCallSettings.newBuilder();
      indexAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      indexAssetOperationSettings = OperationCallSettings.newBuilder();
      removeIndexAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeIndexAssetOperationSettings = OperationCallSettings.newBuilder();
      viewIndexedAssetsSettings = PagedCallSettings.newBuilder(VIEW_INDEXED_ASSETS_PAGE_STR_FACT);
      createIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexOperationSettings = OperationCallSettings.newBuilder();
      updateIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIndexOperationSettings = OperationCallSettings.newBuilder();
      getIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIndexesSettings = PagedCallSettings.newBuilder(LIST_INDEXES_PAGE_STR_FACT);
      deleteIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexOperationSettings = OperationCallSettings.newBuilder();
      createCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCorpusOperationSettings = OperationCallSettings.newBuilder();
      getCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCorporaSettings = PagedCallSettings.newBuilder(LIST_CORPORA_PAGE_STR_FACT);
      deleteCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeCorpusOperationSettings = OperationCallSettings.newBuilder();
      createDataSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataSchemasSettings = PagedCallSettings.newBuilder(LIST_DATA_SCHEMAS_PAGE_STR_FACT);
      createAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnnotationsSettings = PagedCallSettings.newBuilder(LIST_ANNOTATIONS_PAGE_STR_FACT);
      updateAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      ingestAssetSettings = StreamingCallSettings.newBuilder();
      clipAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateHlsUriSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAssetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAssetsOperationSettings = OperationCallSettings.newBuilder();
      createSearchConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSearchConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSearchConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSearchConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSearchConfigsSettings = PagedCallSettings.newBuilder(LIST_SEARCH_CONFIGS_PAGE_STR_FACT);
      createSearchHypernymSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSearchHypernymSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSearchHypernymSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSearchHypernymSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSearchHypernymsSettings =
          PagedCallSettings.newBuilder(LIST_SEARCH_HYPERNYMS_PAGE_STR_FACT);
      searchAssetsSettings = PagedCallSettings.newBuilder(SEARCH_ASSETS_PAGE_STR_FACT);
      searchIndexEndpointSettings =
          PagedCallSettings.newBuilder(SEARCH_INDEX_ENDPOINT_PAGE_STR_FACT);
      createIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexEndpointOperationSettings = OperationCallSettings.newBuilder();
      getIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIndexEndpointsSettings = PagedCallSettings.newBuilder(LIST_INDEX_ENDPOINTS_PAGE_STR_FACT);
      updateIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIndexEndpointOperationSettings = OperationCallSettings.newBuilder();
      deleteIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexEndpointOperationSettings = OperationCallSettings.newBuilder();
      deployIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployIndexOperationSettings = OperationCallSettings.newBuilder();
      undeployIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployIndexOperationSettings = OperationCallSettings.newBuilder();
      createCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCollectionOperationSettings = OperationCallSettings.newBuilder();
      deleteCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCollectionOperationSettings = OperationCallSettings.newBuilder();
      getCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCollectionsSettings = PagedCallSettings.newBuilder(LIST_COLLECTIONS_PAGE_STR_FACT);
      addCollectionItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeCollectionItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      viewCollectionItemsSettings =
          PagedCallSettings.newBuilder(VIEW_COLLECTION_ITEMS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssetSettings,
              updateAssetSettings,
              getAssetSettings,
              listAssetsSettings,
              deleteAssetSettings,
              uploadAssetSettings,
              generateRetrievalUrlSettings,
              analyzeAssetSettings,
              indexAssetSettings,
              removeIndexAssetSettings,
              viewIndexedAssetsSettings,
              createIndexSettings,
              updateIndexSettings,
              getIndexSettings,
              listIndexesSettings,
              deleteIndexSettings,
              createCorpusSettings,
              getCorpusSettings,
              updateCorpusSettings,
              listCorporaSettings,
              deleteCorpusSettings,
              analyzeCorpusSettings,
              createDataSchemaSettings,
              updateDataSchemaSettings,
              getDataSchemaSettings,
              deleteDataSchemaSettings,
              listDataSchemasSettings,
              createAnnotationSettings,
              getAnnotationSettings,
              listAnnotationsSettings,
              updateAnnotationSettings,
              deleteAnnotationSettings,
              clipAssetSettings,
              generateHlsUriSettings,
              importAssetsSettings,
              createSearchConfigSettings,
              updateSearchConfigSettings,
              getSearchConfigSettings,
              deleteSearchConfigSettings,
              listSearchConfigsSettings,
              createSearchHypernymSettings,
              updateSearchHypernymSettings,
              getSearchHypernymSettings,
              deleteSearchHypernymSettings,
              listSearchHypernymsSettings,
              searchAssetsSettings,
              searchIndexEndpointSettings,
              createIndexEndpointSettings,
              getIndexEndpointSettings,
              listIndexEndpointsSettings,
              updateIndexEndpointSettings,
              deleteIndexEndpointSettings,
              deployIndexSettings,
              undeployIndexSettings,
              createCollectionSettings,
              deleteCollectionSettings,
              getCollectionSettings,
              updateCollectionSettings,
              listCollectionsSettings,
              addCollectionItemSettings,
              removeCollectionItemSettings,
              viewCollectionItemsSettings);
      initDefaults(this);
    }

    protected Builder(WarehouseStubSettings settings) {
      super(settings);

      createAssetSettings = settings.createAssetSettings.toBuilder();
      updateAssetSettings = settings.updateAssetSettings.toBuilder();
      getAssetSettings = settings.getAssetSettings.toBuilder();
      listAssetsSettings = settings.listAssetsSettings.toBuilder();
      deleteAssetSettings = settings.deleteAssetSettings.toBuilder();
      deleteAssetOperationSettings = settings.deleteAssetOperationSettings.toBuilder();
      uploadAssetSettings = settings.uploadAssetSettings.toBuilder();
      uploadAssetOperationSettings = settings.uploadAssetOperationSettings.toBuilder();
      generateRetrievalUrlSettings = settings.generateRetrievalUrlSettings.toBuilder();
      analyzeAssetSettings = settings.analyzeAssetSettings.toBuilder();
      analyzeAssetOperationSettings = settings.analyzeAssetOperationSettings.toBuilder();
      indexAssetSettings = settings.indexAssetSettings.toBuilder();
      indexAssetOperationSettings = settings.indexAssetOperationSettings.toBuilder();
      removeIndexAssetSettings = settings.removeIndexAssetSettings.toBuilder();
      removeIndexAssetOperationSettings = settings.removeIndexAssetOperationSettings.toBuilder();
      viewIndexedAssetsSettings = settings.viewIndexedAssetsSettings.toBuilder();
      createIndexSettings = settings.createIndexSettings.toBuilder();
      createIndexOperationSettings = settings.createIndexOperationSettings.toBuilder();
      updateIndexSettings = settings.updateIndexSettings.toBuilder();
      updateIndexOperationSettings = settings.updateIndexOperationSettings.toBuilder();
      getIndexSettings = settings.getIndexSettings.toBuilder();
      listIndexesSettings = settings.listIndexesSettings.toBuilder();
      deleteIndexSettings = settings.deleteIndexSettings.toBuilder();
      deleteIndexOperationSettings = settings.deleteIndexOperationSettings.toBuilder();
      createCorpusSettings = settings.createCorpusSettings.toBuilder();
      createCorpusOperationSettings = settings.createCorpusOperationSettings.toBuilder();
      getCorpusSettings = settings.getCorpusSettings.toBuilder();
      updateCorpusSettings = settings.updateCorpusSettings.toBuilder();
      listCorporaSettings = settings.listCorporaSettings.toBuilder();
      deleteCorpusSettings = settings.deleteCorpusSettings.toBuilder();
      analyzeCorpusSettings = settings.analyzeCorpusSettings.toBuilder();
      analyzeCorpusOperationSettings = settings.analyzeCorpusOperationSettings.toBuilder();
      createDataSchemaSettings = settings.createDataSchemaSettings.toBuilder();
      updateDataSchemaSettings = settings.updateDataSchemaSettings.toBuilder();
      getDataSchemaSettings = settings.getDataSchemaSettings.toBuilder();
      deleteDataSchemaSettings = settings.deleteDataSchemaSettings.toBuilder();
      listDataSchemasSettings = settings.listDataSchemasSettings.toBuilder();
      createAnnotationSettings = settings.createAnnotationSettings.toBuilder();
      getAnnotationSettings = settings.getAnnotationSettings.toBuilder();
      listAnnotationsSettings = settings.listAnnotationsSettings.toBuilder();
      updateAnnotationSettings = settings.updateAnnotationSettings.toBuilder();
      deleteAnnotationSettings = settings.deleteAnnotationSettings.toBuilder();
      ingestAssetSettings = settings.ingestAssetSettings.toBuilder();
      clipAssetSettings = settings.clipAssetSettings.toBuilder();
      generateHlsUriSettings = settings.generateHlsUriSettings.toBuilder();
      importAssetsSettings = settings.importAssetsSettings.toBuilder();
      importAssetsOperationSettings = settings.importAssetsOperationSettings.toBuilder();
      createSearchConfigSettings = settings.createSearchConfigSettings.toBuilder();
      updateSearchConfigSettings = settings.updateSearchConfigSettings.toBuilder();
      getSearchConfigSettings = settings.getSearchConfigSettings.toBuilder();
      deleteSearchConfigSettings = settings.deleteSearchConfigSettings.toBuilder();
      listSearchConfigsSettings = settings.listSearchConfigsSettings.toBuilder();
      createSearchHypernymSettings = settings.createSearchHypernymSettings.toBuilder();
      updateSearchHypernymSettings = settings.updateSearchHypernymSettings.toBuilder();
      getSearchHypernymSettings = settings.getSearchHypernymSettings.toBuilder();
      deleteSearchHypernymSettings = settings.deleteSearchHypernymSettings.toBuilder();
      listSearchHypernymsSettings = settings.listSearchHypernymsSettings.toBuilder();
      searchAssetsSettings = settings.searchAssetsSettings.toBuilder();
      searchIndexEndpointSettings = settings.searchIndexEndpointSettings.toBuilder();
      createIndexEndpointSettings = settings.createIndexEndpointSettings.toBuilder();
      createIndexEndpointOperationSettings =
          settings.createIndexEndpointOperationSettings.toBuilder();
      getIndexEndpointSettings = settings.getIndexEndpointSettings.toBuilder();
      listIndexEndpointsSettings = settings.listIndexEndpointsSettings.toBuilder();
      updateIndexEndpointSettings = settings.updateIndexEndpointSettings.toBuilder();
      updateIndexEndpointOperationSettings =
          settings.updateIndexEndpointOperationSettings.toBuilder();
      deleteIndexEndpointSettings = settings.deleteIndexEndpointSettings.toBuilder();
      deleteIndexEndpointOperationSettings =
          settings.deleteIndexEndpointOperationSettings.toBuilder();
      deployIndexSettings = settings.deployIndexSettings.toBuilder();
      deployIndexOperationSettings = settings.deployIndexOperationSettings.toBuilder();
      undeployIndexSettings = settings.undeployIndexSettings.toBuilder();
      undeployIndexOperationSettings = settings.undeployIndexOperationSettings.toBuilder();
      createCollectionSettings = settings.createCollectionSettings.toBuilder();
      createCollectionOperationSettings = settings.createCollectionOperationSettings.toBuilder();
      deleteCollectionSettings = settings.deleteCollectionSettings.toBuilder();
      deleteCollectionOperationSettings = settings.deleteCollectionOperationSettings.toBuilder();
      getCollectionSettings = settings.getCollectionSettings.toBuilder();
      updateCollectionSettings = settings.updateCollectionSettings.toBuilder();
      listCollectionsSettings = settings.listCollectionsSettings.toBuilder();
      addCollectionItemSettings = settings.addCollectionItemSettings.toBuilder();
      removeCollectionItemSettings = settings.removeCollectionItemSettings.toBuilder();
      viewCollectionItemsSettings = settings.viewCollectionItemsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAssetSettings,
              updateAssetSettings,
              getAssetSettings,
              listAssetsSettings,
              deleteAssetSettings,
              uploadAssetSettings,
              generateRetrievalUrlSettings,
              analyzeAssetSettings,
              indexAssetSettings,
              removeIndexAssetSettings,
              viewIndexedAssetsSettings,
              createIndexSettings,
              updateIndexSettings,
              getIndexSettings,
              listIndexesSettings,
              deleteIndexSettings,
              createCorpusSettings,
              getCorpusSettings,
              updateCorpusSettings,
              listCorporaSettings,
              deleteCorpusSettings,
              analyzeCorpusSettings,
              createDataSchemaSettings,
              updateDataSchemaSettings,
              getDataSchemaSettings,
              deleteDataSchemaSettings,
              listDataSchemasSettings,
              createAnnotationSettings,
              getAnnotationSettings,
              listAnnotationsSettings,
              updateAnnotationSettings,
              deleteAnnotationSettings,
              clipAssetSettings,
              generateHlsUriSettings,
              importAssetsSettings,
              createSearchConfigSettings,
              updateSearchConfigSettings,
              getSearchConfigSettings,
              deleteSearchConfigSettings,
              listSearchConfigsSettings,
              createSearchHypernymSettings,
              updateSearchHypernymSettings,
              getSearchHypernymSettings,
              deleteSearchHypernymSettings,
              listSearchHypernymsSettings,
              searchAssetsSettings,
              searchIndexEndpointSettings,
              createIndexEndpointSettings,
              getIndexEndpointSettings,
              listIndexEndpointsSettings,
              updateIndexEndpointSettings,
              deleteIndexEndpointSettings,
              deployIndexSettings,
              undeployIndexSettings,
              createCollectionSettings,
              deleteCollectionSettings,
              getCollectionSettings,
              updateCollectionSettings,
              listCollectionsSettings,
              addCollectionItemSettings,
              removeCollectionItemSettings,
              viewCollectionItemsSettings);
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
          .createAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .updateAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .uploadAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateRetrievalUrlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .indexAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .removeIndexAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .viewIndexedAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listIndexesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .getCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCorporaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .updateDataSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataSchemasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .getAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnnotationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .clipAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateHlsUriSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSearchConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSearchConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSearchConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSearchConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSearchConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSearchHypernymSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSearchHypernymSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSearchHypernymSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSearchHypernymSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSearchHypernymsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listIndexEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deployIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeployIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCollectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .addCollectionItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .removeCollectionItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .viewCollectionItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteAssetMetadata.class))
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
          .uploadAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UploadAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UploadAssetResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UploadAssetMetadata.class))
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
          .analyzeAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AnalyzeAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnalyzeAssetResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(AnalyzeAssetMetadata.class))
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
          .indexAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<IndexAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IndexAssetResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(IndexAssetMetadata.class))
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
          .removeIndexAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveIndexAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RemoveIndexAssetResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RemoveIndexAssetMetadata.class))
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
          .createIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Index.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateIndexMetadata.class))
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
          .updateIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Index.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateIndexMetadata.class))
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
          .deleteIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteIndexMetadata.class))
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
          .createCorpusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCorpusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Corpus.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateCorpusMetadata.class))
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
          .analyzeCorpusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AnalyzeCorpusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnalyzeCorpusResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(AnalyzeCorpusMetadata.class))
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
          .importAssetsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportAssetsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportAssetsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportAssetsMetadata.class))
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
          .createIndexEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateIndexEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IndexEndpoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateIndexEndpointMetadata.class))
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
          .updateIndexEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateIndexEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IndexEndpoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateIndexEndpointMetadata.class))
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
          .deleteIndexEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIndexEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteIndexEndpointMetadata.class))
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
          .deployIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeployIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeployIndexResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeployIndexMetadata.class))
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
          .undeployIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UndeployIndexResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UndeployIndexMetadata.class))
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
          .createCollectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCollectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateCollectionMetadata.class))
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
          .deleteCollectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCollectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteCollectionMetadata.class))
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

    /** Returns the builder for the settings used for calls to createAsset. */
    public UnaryCallSettings.Builder<CreateAssetRequest, Asset> createAssetSettings() {
      return createAssetSettings;
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings() {
      return updateAssetSettings;
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getAssetSettings;
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return listAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings() {
      return deleteAssetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public OperationCallSettings.Builder<DeleteAssetRequest, Empty, DeleteAssetMetadata>
        deleteAssetOperationSettings() {
      return deleteAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to uploadAsset. */
    public UnaryCallSettings.Builder<UploadAssetRequest, Operation> uploadAssetSettings() {
      return uploadAssetSettings;
    }

    /** Returns the builder for the settings used for calls to uploadAsset. */
    public OperationCallSettings.Builder<
            UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
        uploadAssetOperationSettings() {
      return uploadAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateRetrievalUrl. */
    public UnaryCallSettings.Builder<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
        generateRetrievalUrlSettings() {
      return generateRetrievalUrlSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeAsset. */
    public UnaryCallSettings.Builder<AnalyzeAssetRequest, Operation> analyzeAssetSettings() {
      return analyzeAssetSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeAsset. */
    public OperationCallSettings.Builder<
            AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
        analyzeAssetOperationSettings() {
      return analyzeAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to indexAsset. */
    public UnaryCallSettings.Builder<IndexAssetRequest, Operation> indexAssetSettings() {
      return indexAssetSettings;
    }

    /** Returns the builder for the settings used for calls to indexAsset. */
    public OperationCallSettings.Builder<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
        indexAssetOperationSettings() {
      return indexAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeIndexAsset. */
    public UnaryCallSettings.Builder<RemoveIndexAssetRequest, Operation>
        removeIndexAssetSettings() {
      return removeIndexAssetSettings;
    }

    /** Returns the builder for the settings used for calls to removeIndexAsset. */
    public OperationCallSettings.Builder<
            RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
        removeIndexAssetOperationSettings() {
      return removeIndexAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to viewIndexedAssets. */
    public PagedCallSettings.Builder<
            ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
        viewIndexedAssetsSettings() {
      return viewIndexedAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return createIndexSettings;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, CreateIndexMetadata>
        createIndexOperationSettings() {
      return createIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public UnaryCallSettings.Builder<UpdateIndexRequest, Operation> updateIndexSettings() {
      return updateIndexSettings;
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public OperationCallSettings.Builder<UpdateIndexRequest, Index, UpdateIndexMetadata>
        updateIndexOperationSettings() {
      return updateIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getIndexSettings;
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return listIndexesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return deleteIndexSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Empty, DeleteIndexMetadata>
        deleteIndexOperationSettings() {
      return deleteIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createCorpus. */
    public UnaryCallSettings.Builder<CreateCorpusRequest, Operation> createCorpusSettings() {
      return createCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to createCorpus. */
    public OperationCallSettings.Builder<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
        createCorpusOperationSettings() {
      return createCorpusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCorpus. */
    public UnaryCallSettings.Builder<GetCorpusRequest, Corpus> getCorpusSettings() {
      return getCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to updateCorpus. */
    public UnaryCallSettings.Builder<UpdateCorpusRequest, Corpus> updateCorpusSettings() {
      return updateCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to listCorpora. */
    public PagedCallSettings.Builder<
            ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
        listCorporaSettings() {
      return listCorporaSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCorpus. */
    public UnaryCallSettings.Builder<DeleteCorpusRequest, Empty> deleteCorpusSettings() {
      return deleteCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeCorpus. */
    public UnaryCallSettings.Builder<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings() {
      return analyzeCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeCorpus. */
    public OperationCallSettings.Builder<
            AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
        analyzeCorpusOperationSettings() {
      return analyzeCorpusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createDataSchema. */
    public UnaryCallSettings.Builder<CreateDataSchemaRequest, DataSchema>
        createDataSchemaSettings() {
      return createDataSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataSchema. */
    public UnaryCallSettings.Builder<UpdateDataSchemaRequest, DataSchema>
        updateDataSchemaSettings() {
      return updateDataSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to getDataSchema. */
    public UnaryCallSettings.Builder<GetDataSchemaRequest, DataSchema> getDataSchemaSettings() {
      return getDataSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataSchema. */
    public UnaryCallSettings.Builder<DeleteDataSchemaRequest, Empty> deleteDataSchemaSettings() {
      return deleteDataSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to listDataSchemas. */
    public PagedCallSettings.Builder<
            ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
        listDataSchemasSettings() {
      return listDataSchemasSettings;
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public UnaryCallSettings.Builder<CreateAnnotationRequest, Annotation>
        createAnnotationSettings() {
      return createAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to getAnnotation. */
    public UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings() {
      return getAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to listAnnotations. */
    public PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings() {
      return listAnnotationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnnotation. */
    public UnaryCallSettings.Builder<UpdateAnnotationRequest, Annotation>
        updateAnnotationSettings() {
      return updateAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnnotation. */
    public UnaryCallSettings.Builder<DeleteAnnotationRequest, Empty> deleteAnnotationSettings() {
      return deleteAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to ingestAsset. */
    public StreamingCallSettings.Builder<IngestAssetRequest, IngestAssetResponse>
        ingestAssetSettings() {
      return ingestAssetSettings;
    }

    /** Returns the builder for the settings used for calls to clipAsset. */
    public UnaryCallSettings.Builder<ClipAssetRequest, ClipAssetResponse> clipAssetSettings() {
      return clipAssetSettings;
    }

    /** Returns the builder for the settings used for calls to generateHlsUri. */
    public UnaryCallSettings.Builder<GenerateHlsUriRequest, GenerateHlsUriResponse>
        generateHlsUriSettings() {
      return generateHlsUriSettings;
    }

    /** Returns the builder for the settings used for calls to importAssets. */
    public UnaryCallSettings.Builder<ImportAssetsRequest, Operation> importAssetsSettings() {
      return importAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to importAssets. */
    public OperationCallSettings.Builder<
            ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
        importAssetsOperationSettings() {
      return importAssetsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createSearchConfig. */
    public UnaryCallSettings.Builder<CreateSearchConfigRequest, SearchConfig>
        createSearchConfigSettings() {
      return createSearchConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateSearchConfig. */
    public UnaryCallSettings.Builder<UpdateSearchConfigRequest, SearchConfig>
        updateSearchConfigSettings() {
      return updateSearchConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getSearchConfig. */
    public UnaryCallSettings.Builder<GetSearchConfigRequest, SearchConfig>
        getSearchConfigSettings() {
      return getSearchConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSearchConfig. */
    public UnaryCallSettings.Builder<DeleteSearchConfigRequest, Empty>
        deleteSearchConfigSettings() {
      return deleteSearchConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listSearchConfigs. */
    public PagedCallSettings.Builder<
            ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
        listSearchConfigsSettings() {
      return listSearchConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to createSearchHypernym. */
    public UnaryCallSettings.Builder<CreateSearchHypernymRequest, SearchHypernym>
        createSearchHypernymSettings() {
      return createSearchHypernymSettings;
    }

    /** Returns the builder for the settings used for calls to updateSearchHypernym. */
    public UnaryCallSettings.Builder<UpdateSearchHypernymRequest, SearchHypernym>
        updateSearchHypernymSettings() {
      return updateSearchHypernymSettings;
    }

    /** Returns the builder for the settings used for calls to getSearchHypernym. */
    public UnaryCallSettings.Builder<GetSearchHypernymRequest, SearchHypernym>
        getSearchHypernymSettings() {
      return getSearchHypernymSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSearchHypernym. */
    public UnaryCallSettings.Builder<DeleteSearchHypernymRequest, Empty>
        deleteSearchHypernymSettings() {
      return deleteSearchHypernymSettings;
    }

    /** Returns the builder for the settings used for calls to listSearchHypernyms. */
    public PagedCallSettings.Builder<
            ListSearchHypernymsRequest,
            ListSearchHypernymsResponse,
            ListSearchHypernymsPagedResponse>
        listSearchHypernymsSettings() {
      return listSearchHypernymsSettings;
    }

    /** Returns the builder for the settings used for calls to searchAssets. */
    public PagedCallSettings.Builder<
            SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
        searchAssetsSettings() {
      return searchAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to searchIndexEndpoint. */
    public PagedCallSettings.Builder<
            SearchIndexEndpointRequest,
            SearchIndexEndpointResponse,
            SearchIndexEndpointPagedResponse>
        searchIndexEndpointSettings() {
      return searchIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings() {
      return createIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
        createIndexEndpointOperationSettings() {
      return createIndexEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIndexEndpoint. */
    public UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings() {
      return getIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to listIndexEndpoints. */
    public PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings() {
      return listIndexEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public UnaryCallSettings.Builder<UpdateIndexEndpointRequest, Operation>
        updateIndexEndpointSettings() {
      return updateIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public OperationCallSettings.Builder<
            UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
        updateIndexEndpointOperationSettings() {
      return updateIndexEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings() {
      return deleteIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public OperationCallSettings.Builder<
            DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
        deleteIndexEndpointOperationSettings() {
      return deleteIndexEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings() {
      return deployIndexSettings;
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
        deployIndexOperationSettings() {
      return deployIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings() {
      return undeployIndexSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
        undeployIndexOperationSettings() {
      return undeployIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings() {
      return createCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public OperationCallSettings.Builder<
            CreateCollectionRequest, Collection, CreateCollectionMetadata>
        createCollectionOperationSettings() {
      return createCollectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings() {
      return deleteCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public OperationCallSettings.Builder<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
        deleteCollectionOperationSettings() {
      return deleteCollectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCollection. */
    public UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings() {
      return getCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public UnaryCallSettings.Builder<UpdateCollectionRequest, Collection>
        updateCollectionSettings() {
      return updateCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to listCollections. */
    public PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings() {
      return listCollectionsSettings;
    }

    /** Returns the builder for the settings used for calls to addCollectionItem. */
    public UnaryCallSettings.Builder<AddCollectionItemRequest, AddCollectionItemResponse>
        addCollectionItemSettings() {
      return addCollectionItemSettings;
    }

    /** Returns the builder for the settings used for calls to removeCollectionItem. */
    public UnaryCallSettings.Builder<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
        removeCollectionItemSettings() {
      return removeCollectionItemSettings;
    }

    /** Returns the builder for the settings used for calls to viewCollectionItems. */
    public PagedCallSettings.Builder<
            ViewCollectionItemsRequest,
            ViewCollectionItemsResponse,
            ViewCollectionItemsPagedResponse>
        viewCollectionItemsSettings() {
      return viewCollectionItemsSettings;
    }

    @Override
    public WarehouseStubSettings build() throws IOException {
      return new WarehouseStubSettings(this);
    }
  }
}
