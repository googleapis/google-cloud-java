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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Warehouse service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WarehouseStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateAssetRequest, Asset> createAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssetCallable()");
  }

  public UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssetCallable()");
  }

  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssetCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsPagedCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsCallable()");
  }

  public OperationCallable<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetOperationCallable()");
  }

  public UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetCallable()");
  }

  public OperationCallable<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadAssetOperationCallable()");
  }

  public UnaryCallable<UploadAssetRequest, Operation> uploadAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadAssetCallable()");
  }

  public UnaryCallable<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlCallable() {
    throw new UnsupportedOperationException("Not implemented: generateRetrievalUrlCallable()");
  }

  public OperationCallable<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeAssetOperationCallable()");
  }

  public UnaryCallable<AnalyzeAssetRequest, Operation> analyzeAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeAssetCallable()");
  }

  public OperationCallable<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: indexAssetOperationCallable()");
  }

  public UnaryCallable<IndexAssetRequest, Operation> indexAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: indexAssetCallable()");
  }

  public OperationCallable<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeIndexAssetOperationCallable()");
  }

  public UnaryCallable<RemoveIndexAssetRequest, Operation> removeIndexAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: removeIndexAssetCallable()");
  }

  public UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: viewIndexedAssetsPagedCallable()");
  }

  public UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: viewIndexedAssetsCallable()");
  }

  public OperationCallable<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public OperationCallable<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexOperationCallable()");
  }

  public UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  public OperationCallable<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexOperationCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public OperationCallable<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCorpusOperationCallable()");
  }

  public UnaryCallable<CreateCorpusRequest, Operation> createCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: createCorpusCallable()");
  }

  public UnaryCallable<GetCorpusRequest, Corpus> getCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: getCorpusCallable()");
  }

  public UnaryCallable<UpdateCorpusRequest, Corpus> updateCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCorpusCallable()");
  }

  public UnaryCallable<ListCorporaRequest, ListCorporaPagedResponse> listCorporaPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCorporaPagedCallable()");
  }

  public UnaryCallable<ListCorporaRequest, ListCorporaResponse> listCorporaCallable() {
    throw new UnsupportedOperationException("Not implemented: listCorporaCallable()");
  }

  public UnaryCallable<DeleteCorpusRequest, Empty> deleteCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCorpusCallable()");
  }

  public OperationCallable<AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeCorpusOperationCallable()");
  }

  public UnaryCallable<AnalyzeCorpusRequest, Operation> analyzeCorpusCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeCorpusCallable()");
  }

  public UnaryCallable<CreateDataSchemaRequest, DataSchema> createDataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataSchemaCallable()");
  }

  public UnaryCallable<UpdateDataSchemaRequest, DataSchema> updateDataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSchemaCallable()");
  }

  public UnaryCallable<GetDataSchemaRequest, DataSchema> getDataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSchemaCallable()");
  }

  public UnaryCallable<DeleteDataSchemaRequest, Empty> deleteDataSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataSchemaCallable()");
  }

  public UnaryCallable<ListDataSchemasRequest, ListDataSchemasPagedResponse>
      listDataSchemasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSchemasPagedCallable()");
  }

  public UnaryCallable<ListDataSchemasRequest, ListDataSchemasResponse> listDataSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSchemasCallable()");
  }

  public UnaryCallable<CreateAnnotationRequest, Annotation> createAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnnotationCallable()");
  }

  public UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnnotationCallable()");
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnnotationsPagedCallable()");
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> listAnnotationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnnotationsCallable()");
  }

  public UnaryCallable<UpdateAnnotationRequest, Annotation> updateAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAnnotationCallable()");
  }

  public UnaryCallable<DeleteAnnotationRequest, Empty> deleteAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAnnotationCallable()");
  }

  public BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> ingestAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: ingestAssetCallable()");
  }

  public UnaryCallable<ClipAssetRequest, ClipAssetResponse> clipAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: clipAssetCallable()");
  }

  public UnaryCallable<GenerateHlsUriRequest, GenerateHlsUriResponse> generateHlsUriCallable() {
    throw new UnsupportedOperationException("Not implemented: generateHlsUriCallable()");
  }

  public OperationCallable<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importAssetsOperationCallable()");
  }

  public UnaryCallable<ImportAssetsRequest, Operation> importAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: importAssetsCallable()");
  }

  public UnaryCallable<CreateSearchConfigRequest, SearchConfig> createSearchConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createSearchConfigCallable()");
  }

  public UnaryCallable<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSearchConfigCallable()");
  }

  public UnaryCallable<GetSearchConfigRequest, SearchConfig> getSearchConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getSearchConfigCallable()");
  }

  public UnaryCallable<DeleteSearchConfigRequest, Empty> deleteSearchConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSearchConfigCallable()");
  }

  public UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsPagedResponse>
      listSearchConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchConfigsPagedCallable()");
  }

  public UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchConfigsCallable()");
  }

  public UnaryCallable<CreateSearchHypernymRequest, SearchHypernym> createSearchHypernymCallable() {
    throw new UnsupportedOperationException("Not implemented: createSearchHypernymCallable()");
  }

  public UnaryCallable<UpdateSearchHypernymRequest, SearchHypernym> updateSearchHypernymCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSearchHypernymCallable()");
  }

  public UnaryCallable<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymCallable() {
    throw new UnsupportedOperationException("Not implemented: getSearchHypernymCallable()");
  }

  public UnaryCallable<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSearchHypernymCallable()");
  }

  public UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsPagedResponse>
      listSearchHypernymsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchHypernymsPagedCallable()");
  }

  public UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchHypernymsCallable()");
  }

  public UnaryCallable<SearchAssetsRequest, SearchAssetsPagedResponse> searchAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAssetsPagedCallable()");
  }

  public UnaryCallable<SearchAssetsRequest, SearchAssetsResponse> searchAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAssetsCallable()");
  }

  public UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointPagedResponse>
      searchIndexEndpointPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIndexEndpointPagedCallable()");
  }

  public UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIndexEndpointCallable()");
  }

  public OperationCallable<CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIndexEndpointOperationCallable()");
  }

  public UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexEndpointCallable()");
  }

  public UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexEndpointCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsPagedCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsCallable()");
  }

  public OperationCallable<UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateIndexEndpointOperationCallable()");
  }

  public UnaryCallable<UpdateIndexEndpointRequest, Operation> updateIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexEndpointCallable()");
  }

  public OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIndexEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexEndpointCallable()");
  }

  public OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexOperationCallable()");
  }

  public UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexCallable()");
  }

  public OperationCallable<UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexOperationCallable()");
  }

  public UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexCallable()");
  }

  public OperationCallable<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectionOperationCallable()");
  }

  public UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectionCallable()");
  }

  public OperationCallable<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectionOperationCallable()");
  }

  public UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectionCallable()");
  }

  public UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getCollectionCallable()");
  }

  public UnaryCallable<UpdateCollectionRequest, Collection> updateCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCollectionCallable()");
  }

  public UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionsPagedCallable()");
  }

  public UnaryCallable<ListCollectionsRequest, ListCollectionsResponse> listCollectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionsCallable()");
  }

  public UnaryCallable<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemCallable() {
    throw new UnsupportedOperationException("Not implemented: addCollectionItemCallable()");
  }

  public UnaryCallable<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemCallable() {
    throw new UnsupportedOperationException("Not implemented: removeCollectionItemCallable()");
  }

  public UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsPagedResponse>
      viewCollectionItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: viewCollectionItemsPagedCallable()");
  }

  public UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: viewCollectionItemsCallable()");
  }

  @Override
  public abstract void close();
}
