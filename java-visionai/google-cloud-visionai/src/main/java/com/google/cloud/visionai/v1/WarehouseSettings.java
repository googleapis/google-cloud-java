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

package com.google.cloud.visionai.v1;

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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.visionai.v1.stub.WarehouseStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WarehouseClient}.
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
 * WarehouseSettings.Builder warehouseSettingsBuilder = WarehouseSettings.newBuilder();
 * warehouseSettingsBuilder
 *     .createAssetSettings()
 *     .setRetrySettings(
 *         warehouseSettingsBuilder
 *             .createAssetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WarehouseSettings warehouseSettings = warehouseSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WarehouseSettings extends ClientSettings<WarehouseSettings> {

  /** Returns the object with the settings used for calls to createAsset. */
  public UnaryCallSettings<CreateAssetRequest, Asset> createAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createAssetSettings();
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Asset> updateAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateAssetSettings();
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getAssetSettings();
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listAssetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteAssetSettings();
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public OperationCallSettings<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to uploadAsset. */
  public UnaryCallSettings<UploadAssetRequest, Operation> uploadAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).uploadAssetSettings();
  }

  /** Returns the object with the settings used for calls to uploadAsset. */
  public OperationCallSettings<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).uploadAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateRetrievalUrl. */
  public UnaryCallSettings<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlSettings() {
    return ((WarehouseStubSettings) getStubSettings()).generateRetrievalUrlSettings();
  }

  /** Returns the object with the settings used for calls to analyzeAsset. */
  public UnaryCallSettings<AnalyzeAssetRequest, Operation> analyzeAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).analyzeAssetSettings();
  }

  /** Returns the object with the settings used for calls to analyzeAsset. */
  public OperationCallSettings<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).analyzeAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to indexAsset. */
  public UnaryCallSettings<IndexAssetRequest, Operation> indexAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).indexAssetSettings();
  }

  /** Returns the object with the settings used for calls to indexAsset. */
  public OperationCallSettings<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).indexAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeIndexAsset. */
  public UnaryCallSettings<RemoveIndexAssetRequest, Operation> removeIndexAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).removeIndexAssetSettings();
  }

  /** Returns the object with the settings used for calls to removeIndexAsset. */
  public OperationCallSettings<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).removeIndexAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to viewIndexedAssets. */
  public PagedCallSettings<
          ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).viewIndexedAssetsSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public UnaryCallSettings<UpdateIndexRequest, Operation> updateIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateIndexSettings();
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public OperationCallSettings<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listIndexesSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCorpus. */
  public UnaryCallSettings<CreateCorpusRequest, Operation> createCorpusSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createCorpusSettings();
  }

  /** Returns the object with the settings used for calls to createCorpus. */
  public OperationCallSettings<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCorpus. */
  public UnaryCallSettings<GetCorpusRequest, Corpus> getCorpusSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getCorpusSettings();
  }

  /** Returns the object with the settings used for calls to updateCorpus. */
  public UnaryCallSettings<UpdateCorpusRequest, Corpus> updateCorpusSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateCorpusSettings();
  }

  /** Returns the object with the settings used for calls to listCorpora. */
  public PagedCallSettings<ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
      listCorporaSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listCorporaSettings();
  }

  /** Returns the object with the settings used for calls to deleteCorpus. */
  public UnaryCallSettings<DeleteCorpusRequest, Empty> deleteCorpusSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteCorpusSettings();
  }

  /** Returns the object with the settings used for calls to analyzeCorpus. */
  public UnaryCallSettings<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings() {
    return ((WarehouseStubSettings) getStubSettings()).analyzeCorpusSettings();
  }

  /** Returns the object with the settings used for calls to analyzeCorpus. */
  public OperationCallSettings<AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).analyzeCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to createDataSchema. */
  public UnaryCallSettings<CreateDataSchemaRequest, DataSchema> createDataSchemaSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to updateDataSchema. */
  public UnaryCallSettings<UpdateDataSchemaRequest, DataSchema> updateDataSchemaSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to getDataSchema. */
  public UnaryCallSettings<GetDataSchemaRequest, DataSchema> getDataSchemaSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataSchema. */
  public UnaryCallSettings<DeleteDataSchemaRequest, Empty> deleteDataSchemaSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteDataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to listDataSchemas. */
  public PagedCallSettings<
          ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
      listDataSchemasSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listDataSchemasSettings();
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public UnaryCallSettings<CreateAnnotationRequest, Annotation> createAnnotationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to getAnnotation. */
  public UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to listAnnotations. */
  public PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listAnnotationsSettings();
  }

  /** Returns the object with the settings used for calls to updateAnnotation. */
  public UnaryCallSettings<UpdateAnnotationRequest, Annotation> updateAnnotationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnnotation. */
  public UnaryCallSettings<DeleteAnnotationRequest, Empty> deleteAnnotationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to ingestAsset. */
  public StreamingCallSettings<IngestAssetRequest, IngestAssetResponse> ingestAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).ingestAssetSettings();
  }

  /** Returns the object with the settings used for calls to clipAsset. */
  public UnaryCallSettings<ClipAssetRequest, ClipAssetResponse> clipAssetSettings() {
    return ((WarehouseStubSettings) getStubSettings()).clipAssetSettings();
  }

  /** Returns the object with the settings used for calls to generateHlsUri. */
  public UnaryCallSettings<GenerateHlsUriRequest, GenerateHlsUriResponse> generateHlsUriSettings() {
    return ((WarehouseStubSettings) getStubSettings()).generateHlsUriSettings();
  }

  /** Returns the object with the settings used for calls to importAssets. */
  public UnaryCallSettings<ImportAssetsRequest, Operation> importAssetsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).importAssetsSettings();
  }

  /** Returns the object with the settings used for calls to importAssets. */
  public OperationCallSettings<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).importAssetsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createSearchConfig. */
  public UnaryCallSettings<CreateSearchConfigRequest, SearchConfig> createSearchConfigSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createSearchConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateSearchConfig. */
  public UnaryCallSettings<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateSearchConfigSettings();
  }

  /** Returns the object with the settings used for calls to getSearchConfig. */
  public UnaryCallSettings<GetSearchConfigRequest, SearchConfig> getSearchConfigSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getSearchConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteSearchConfig. */
  public UnaryCallSettings<DeleteSearchConfigRequest, Empty> deleteSearchConfigSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteSearchConfigSettings();
  }

  /** Returns the object with the settings used for calls to listSearchConfigs. */
  public PagedCallSettings<
          ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
      listSearchConfigsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listSearchConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createSearchHypernym. */
  public UnaryCallSettings<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createSearchHypernymSettings();
  }

  /** Returns the object with the settings used for calls to updateSearchHypernym. */
  public UnaryCallSettings<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateSearchHypernymSettings();
  }

  /** Returns the object with the settings used for calls to getSearchHypernym. */
  public UnaryCallSettings<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getSearchHypernymSettings();
  }

  /** Returns the object with the settings used for calls to deleteSearchHypernym. */
  public UnaryCallSettings<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteSearchHypernymSettings();
  }

  /** Returns the object with the settings used for calls to listSearchHypernyms. */
  public PagedCallSettings<
          ListSearchHypernymsRequest, ListSearchHypernymsResponse, ListSearchHypernymsPagedResponse>
      listSearchHypernymsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listSearchHypernymsSettings();
  }

  /** Returns the object with the settings used for calls to searchAssets. */
  public PagedCallSettings<SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
      searchAssetsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).searchAssetsSettings();
  }

  /** Returns the object with the settings used for calls to searchIndexEndpoint. */
  public PagedCallSettings<
          SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchIndexEndpointPagedResponse>
      searchIndexEndpointSettings() {
    return ((WarehouseStubSettings) getStubSettings()).searchIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public UnaryCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createIndexEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIndexEndpoint. */
  public UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to listIndexEndpoints. */
  public PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listIndexEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public UnaryCallSettings<UpdateIndexEndpointRequest, Operation> updateIndexEndpointSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public OperationCallSettings<
          UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateIndexEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public UnaryCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteIndexEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public OperationCallSettings<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteIndexEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deployIndexSettings();
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public OperationCallSettings<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deployIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings() {
    return ((WarehouseStubSettings) getStubSettings()).undeployIndexSettings();
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public OperationCallSettings<UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).undeployIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createCollectionSettings();
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public OperationCallSettings<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).createCollectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteCollectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public OperationCallSettings<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationSettings() {
    return ((WarehouseStubSettings) getStubSettings()).deleteCollectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCollection. */
  public UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings() {
    return ((WarehouseStubSettings) getStubSettings()).getCollectionSettings();
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public UnaryCallSettings<UpdateCollectionRequest, Collection> updateCollectionSettings() {
    return ((WarehouseStubSettings) getStubSettings()).updateCollectionSettings();
  }

  /** Returns the object with the settings used for calls to listCollections. */
  public PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).listCollectionsSettings();
  }

  /** Returns the object with the settings used for calls to addCollectionItem. */
  public UnaryCallSettings<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemSettings() {
    return ((WarehouseStubSettings) getStubSettings()).addCollectionItemSettings();
  }

  /** Returns the object with the settings used for calls to removeCollectionItem. */
  public UnaryCallSettings<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemSettings() {
    return ((WarehouseStubSettings) getStubSettings()).removeCollectionItemSettings();
  }

  /** Returns the object with the settings used for calls to viewCollectionItems. */
  public PagedCallSettings<
          ViewCollectionItemsRequest, ViewCollectionItemsResponse, ViewCollectionItemsPagedResponse>
      viewCollectionItemsSettings() {
    return ((WarehouseStubSettings) getStubSettings()).viewCollectionItemsSettings();
  }

  public static final WarehouseSettings create(WarehouseStubSettings stub) throws IOException {
    return new WarehouseSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WarehouseStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WarehouseStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WarehouseStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WarehouseStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WarehouseStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return WarehouseStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WarehouseStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WarehouseStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WarehouseSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WarehouseSettings. */
  public static class Builder extends ClientSettings.Builder<WarehouseSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WarehouseStubSettings.newBuilder(clientContext));
    }

    protected Builder(WarehouseSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WarehouseStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WarehouseStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(WarehouseStubSettings.newHttpJsonBuilder());
    }

    public WarehouseStubSettings.Builder getStubSettingsBuilder() {
      return ((WarehouseStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public UnaryCallSettings.Builder<CreateAssetRequest, Asset> createAssetSettings() {
      return getStubSettingsBuilder().createAssetSettings();
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Asset> updateAssetSettings() {
      return getStubSettingsBuilder().updateAssetSettings();
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getStubSettingsBuilder().getAssetSettings();
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return getStubSettingsBuilder().listAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings() {
      return getStubSettingsBuilder().deleteAssetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public OperationCallSettings.Builder<DeleteAssetRequest, Empty, DeleteAssetMetadata>
        deleteAssetOperationSettings() {
      return getStubSettingsBuilder().deleteAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to uploadAsset. */
    public UnaryCallSettings.Builder<UploadAssetRequest, Operation> uploadAssetSettings() {
      return getStubSettingsBuilder().uploadAssetSettings();
    }

    /** Returns the builder for the settings used for calls to uploadAsset. */
    public OperationCallSettings.Builder<
            UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
        uploadAssetOperationSettings() {
      return getStubSettingsBuilder().uploadAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateRetrievalUrl. */
    public UnaryCallSettings.Builder<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
        generateRetrievalUrlSettings() {
      return getStubSettingsBuilder().generateRetrievalUrlSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeAsset. */
    public UnaryCallSettings.Builder<AnalyzeAssetRequest, Operation> analyzeAssetSettings() {
      return getStubSettingsBuilder().analyzeAssetSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeAsset. */
    public OperationCallSettings.Builder<
            AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
        analyzeAssetOperationSettings() {
      return getStubSettingsBuilder().analyzeAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to indexAsset. */
    public UnaryCallSettings.Builder<IndexAssetRequest, Operation> indexAssetSettings() {
      return getStubSettingsBuilder().indexAssetSettings();
    }

    /** Returns the builder for the settings used for calls to indexAsset. */
    public OperationCallSettings.Builder<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
        indexAssetOperationSettings() {
      return getStubSettingsBuilder().indexAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeIndexAsset. */
    public UnaryCallSettings.Builder<RemoveIndexAssetRequest, Operation>
        removeIndexAssetSettings() {
      return getStubSettingsBuilder().removeIndexAssetSettings();
    }

    /** Returns the builder for the settings used for calls to removeIndexAsset. */
    public OperationCallSettings.Builder<
            RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
        removeIndexAssetOperationSettings() {
      return getStubSettingsBuilder().removeIndexAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to viewIndexedAssets. */
    public PagedCallSettings.Builder<
            ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, ViewIndexedAssetsPagedResponse>
        viewIndexedAssetsSettings() {
      return getStubSettingsBuilder().viewIndexedAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, CreateIndexMetadata>
        createIndexOperationSettings() {
      return getStubSettingsBuilder().createIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public UnaryCallSettings.Builder<UpdateIndexRequest, Operation> updateIndexSettings() {
      return getStubSettingsBuilder().updateIndexSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public OperationCallSettings.Builder<UpdateIndexRequest, Index, UpdateIndexMetadata>
        updateIndexOperationSettings() {
      return getStubSettingsBuilder().updateIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Empty, DeleteIndexMetadata>
        deleteIndexOperationSettings() {
      return getStubSettingsBuilder().deleteIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCorpus. */
    public UnaryCallSettings.Builder<CreateCorpusRequest, Operation> createCorpusSettings() {
      return getStubSettingsBuilder().createCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to createCorpus. */
    public OperationCallSettings.Builder<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
        createCorpusOperationSettings() {
      return getStubSettingsBuilder().createCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCorpus. */
    public UnaryCallSettings.Builder<GetCorpusRequest, Corpus> getCorpusSettings() {
      return getStubSettingsBuilder().getCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to updateCorpus. */
    public UnaryCallSettings.Builder<UpdateCorpusRequest, Corpus> updateCorpusSettings() {
      return getStubSettingsBuilder().updateCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to listCorpora. */
    public PagedCallSettings.Builder<
            ListCorporaRequest, ListCorporaResponse, ListCorporaPagedResponse>
        listCorporaSettings() {
      return getStubSettingsBuilder().listCorporaSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCorpus. */
    public UnaryCallSettings.Builder<DeleteCorpusRequest, Empty> deleteCorpusSettings() {
      return getStubSettingsBuilder().deleteCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeCorpus. */
    public UnaryCallSettings.Builder<AnalyzeCorpusRequest, Operation> analyzeCorpusSettings() {
      return getStubSettingsBuilder().analyzeCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeCorpus. */
    public OperationCallSettings.Builder<
            AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
        analyzeCorpusOperationSettings() {
      return getStubSettingsBuilder().analyzeCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createDataSchema. */
    public UnaryCallSettings.Builder<CreateDataSchemaRequest, DataSchema>
        createDataSchemaSettings() {
      return getStubSettingsBuilder().createDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataSchema. */
    public UnaryCallSettings.Builder<UpdateDataSchemaRequest, DataSchema>
        updateDataSchemaSettings() {
      return getStubSettingsBuilder().updateDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to getDataSchema. */
    public UnaryCallSettings.Builder<GetDataSchemaRequest, DataSchema> getDataSchemaSettings() {
      return getStubSettingsBuilder().getDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataSchema. */
    public UnaryCallSettings.Builder<DeleteDataSchemaRequest, Empty> deleteDataSchemaSettings() {
      return getStubSettingsBuilder().deleteDataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to listDataSchemas. */
    public PagedCallSettings.Builder<
            ListDataSchemasRequest, ListDataSchemasResponse, ListDataSchemasPagedResponse>
        listDataSchemasSettings() {
      return getStubSettingsBuilder().listDataSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public UnaryCallSettings.Builder<CreateAnnotationRequest, Annotation>
        createAnnotationSettings() {
      return getStubSettingsBuilder().createAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to getAnnotation. */
    public UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings() {
      return getStubSettingsBuilder().getAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to listAnnotations. */
    public PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings() {
      return getStubSettingsBuilder().listAnnotationsSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnnotation. */
    public UnaryCallSettings.Builder<UpdateAnnotationRequest, Annotation>
        updateAnnotationSettings() {
      return getStubSettingsBuilder().updateAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnnotation. */
    public UnaryCallSettings.Builder<DeleteAnnotationRequest, Empty> deleteAnnotationSettings() {
      return getStubSettingsBuilder().deleteAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to ingestAsset. */
    public StreamingCallSettings.Builder<IngestAssetRequest, IngestAssetResponse>
        ingestAssetSettings() {
      return getStubSettingsBuilder().ingestAssetSettings();
    }

    /** Returns the builder for the settings used for calls to clipAsset. */
    public UnaryCallSettings.Builder<ClipAssetRequest, ClipAssetResponse> clipAssetSettings() {
      return getStubSettingsBuilder().clipAssetSettings();
    }

    /** Returns the builder for the settings used for calls to generateHlsUri. */
    public UnaryCallSettings.Builder<GenerateHlsUriRequest, GenerateHlsUriResponse>
        generateHlsUriSettings() {
      return getStubSettingsBuilder().generateHlsUriSettings();
    }

    /** Returns the builder for the settings used for calls to importAssets. */
    public UnaryCallSettings.Builder<ImportAssetsRequest, Operation> importAssetsSettings() {
      return getStubSettingsBuilder().importAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to importAssets. */
    public OperationCallSettings.Builder<
            ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
        importAssetsOperationSettings() {
      return getStubSettingsBuilder().importAssetsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createSearchConfig. */
    public UnaryCallSettings.Builder<CreateSearchConfigRequest, SearchConfig>
        createSearchConfigSettings() {
      return getStubSettingsBuilder().createSearchConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateSearchConfig. */
    public UnaryCallSettings.Builder<UpdateSearchConfigRequest, SearchConfig>
        updateSearchConfigSettings() {
      return getStubSettingsBuilder().updateSearchConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getSearchConfig. */
    public UnaryCallSettings.Builder<GetSearchConfigRequest, SearchConfig>
        getSearchConfigSettings() {
      return getStubSettingsBuilder().getSearchConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSearchConfig. */
    public UnaryCallSettings.Builder<DeleteSearchConfigRequest, Empty>
        deleteSearchConfigSettings() {
      return getStubSettingsBuilder().deleteSearchConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listSearchConfigs. */
    public PagedCallSettings.Builder<
            ListSearchConfigsRequest, ListSearchConfigsResponse, ListSearchConfigsPagedResponse>
        listSearchConfigsSettings() {
      return getStubSettingsBuilder().listSearchConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to createSearchHypernym. */
    public UnaryCallSettings.Builder<CreateSearchHypernymRequest, SearchHypernym>
        createSearchHypernymSettings() {
      return getStubSettingsBuilder().createSearchHypernymSettings();
    }

    /** Returns the builder for the settings used for calls to updateSearchHypernym. */
    public UnaryCallSettings.Builder<UpdateSearchHypernymRequest, SearchHypernym>
        updateSearchHypernymSettings() {
      return getStubSettingsBuilder().updateSearchHypernymSettings();
    }

    /** Returns the builder for the settings used for calls to getSearchHypernym. */
    public UnaryCallSettings.Builder<GetSearchHypernymRequest, SearchHypernym>
        getSearchHypernymSettings() {
      return getStubSettingsBuilder().getSearchHypernymSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSearchHypernym. */
    public UnaryCallSettings.Builder<DeleteSearchHypernymRequest, Empty>
        deleteSearchHypernymSettings() {
      return getStubSettingsBuilder().deleteSearchHypernymSettings();
    }

    /** Returns the builder for the settings used for calls to listSearchHypernyms. */
    public PagedCallSettings.Builder<
            ListSearchHypernymsRequest,
            ListSearchHypernymsResponse,
            ListSearchHypernymsPagedResponse>
        listSearchHypernymsSettings() {
      return getStubSettingsBuilder().listSearchHypernymsSettings();
    }

    /** Returns the builder for the settings used for calls to searchAssets. */
    public PagedCallSettings.Builder<
            SearchAssetsRequest, SearchAssetsResponse, SearchAssetsPagedResponse>
        searchAssetsSettings() {
      return getStubSettingsBuilder().searchAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to searchIndexEndpoint. */
    public PagedCallSettings.Builder<
            SearchIndexEndpointRequest,
            SearchIndexEndpointResponse,
            SearchIndexEndpointPagedResponse>
        searchIndexEndpointSettings() {
      return getStubSettingsBuilder().searchIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings() {
      return getStubSettingsBuilder().createIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
        createIndexEndpointOperationSettings() {
      return getStubSettingsBuilder().createIndexEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIndexEndpoint. */
    public UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings() {
      return getStubSettingsBuilder().getIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexEndpoints. */
    public PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings() {
      return getStubSettingsBuilder().listIndexEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public UnaryCallSettings.Builder<UpdateIndexEndpointRequest, Operation>
        updateIndexEndpointSettings() {
      return getStubSettingsBuilder().updateIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public OperationCallSettings.Builder<
            UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
        updateIndexEndpointOperationSettings() {
      return getStubSettingsBuilder().updateIndexEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings() {
      return getStubSettingsBuilder().deleteIndexEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public OperationCallSettings.Builder<
            DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
        deleteIndexEndpointOperationSettings() {
      return getStubSettingsBuilder().deleteIndexEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings() {
      return getStubSettingsBuilder().deployIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
        deployIndexOperationSettings() {
      return getStubSettingsBuilder().deployIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings() {
      return getStubSettingsBuilder().undeployIndexSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
        undeployIndexOperationSettings() {
      return getStubSettingsBuilder().undeployIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings() {
      return getStubSettingsBuilder().createCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public OperationCallSettings.Builder<
            CreateCollectionRequest, Collection, CreateCollectionMetadata>
        createCollectionOperationSettings() {
      return getStubSettingsBuilder().createCollectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings() {
      return getStubSettingsBuilder().deleteCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public OperationCallSettings.Builder<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
        deleteCollectionOperationSettings() {
      return getStubSettingsBuilder().deleteCollectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCollection. */
    public UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings() {
      return getStubSettingsBuilder().getCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public UnaryCallSettings.Builder<UpdateCollectionRequest, Collection>
        updateCollectionSettings() {
      return getStubSettingsBuilder().updateCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to listCollections. */
    public PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings() {
      return getStubSettingsBuilder().listCollectionsSettings();
    }

    /** Returns the builder for the settings used for calls to addCollectionItem. */
    public UnaryCallSettings.Builder<AddCollectionItemRequest, AddCollectionItemResponse>
        addCollectionItemSettings() {
      return getStubSettingsBuilder().addCollectionItemSettings();
    }

    /** Returns the builder for the settings used for calls to removeCollectionItem. */
    public UnaryCallSettings.Builder<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
        removeCollectionItemSettings() {
      return getStubSettingsBuilder().removeCollectionItemSettings();
    }

    /** Returns the builder for the settings used for calls to viewCollectionItems. */
    public PagedCallSettings.Builder<
            ViewCollectionItemsRequest,
            ViewCollectionItemsResponse,
            ViewCollectionItemsPagedResponse>
        viewCollectionItemsSettings() {
      return getStubSettingsBuilder().viewCollectionItemsSettings();
    }

    @Override
    public WarehouseSettings build() throws IOException {
      return new WarehouseSettings(this);
    }
  }
}
