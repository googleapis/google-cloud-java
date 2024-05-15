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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Warehouse service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWarehouseStub extends WarehouseStub {
  private static final MethodDescriptor<CreateAssetRequest, Asset> createAssetMethodDescriptor =
      MethodDescriptor.<CreateAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAssetRequest, Asset> updateAssetMethodDescriptor =
      MethodDescriptor.<UpdateAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetAssetRequest, Asset> getAssetMethodDescriptor =
      MethodDescriptor.<GetAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          MethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAssetRequest, Operation> deleteAssetMethodDescriptor =
      MethodDescriptor.<DeleteAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UploadAssetRequest, Operation> uploadAssetMethodDescriptor =
      MethodDescriptor.<UploadAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/UploadAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(UploadAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlMethodDescriptor =
          MethodDescriptor.<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GenerateRetrievalUrl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateRetrievalUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateRetrievalUrlResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnalyzeAssetRequest, Operation>
      analyzeAssetMethodDescriptor =
          MethodDescriptor.<AnalyzeAssetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AnalyzeAsset")
              .setRequestMarshaller(ProtoUtils.marshaller(AnalyzeAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<IndexAssetRequest, Operation> indexAssetMethodDescriptor =
      MethodDescriptor.<IndexAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/IndexAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(IndexAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RemoveIndexAssetRequest, Operation>
      removeIndexAssetMethodDescriptor =
          MethodDescriptor.<RemoveIndexAssetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/RemoveIndexAsset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveIndexAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsMethodDescriptor =
          MethodDescriptor.<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ViewIndexedAssets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ViewIndexedAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ViewIndexedAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateIndexRequest, Operation> createIndexMethodDescriptor =
      MethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateIndexRequest, Operation> updateIndexMethodDescriptor =
      MethodDescriptor.<UpdateIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      MethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Index.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          MethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListIndexes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIndexesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteIndexRequest, Operation> deleteIndexMethodDescriptor =
      MethodDescriptor.<DeleteIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateCorpusRequest, Operation>
      createCorpusMethodDescriptor =
          MethodDescriptor.<CreateCorpusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateCorpus")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateCorpusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCorpusRequest, Corpus> getCorpusMethodDescriptor =
      MethodDescriptor.<GetCorpusRequest, Corpus>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetCorpus")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCorpusRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Corpus.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateCorpusRequest, Corpus> updateCorpusMethodDescriptor =
      MethodDescriptor.<UpdateCorpusRequest, Corpus>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateCorpus")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateCorpusRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Corpus.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCorporaRequest, ListCorporaResponse>
      listCorporaMethodDescriptor =
          MethodDescriptor.<ListCorporaRequest, ListCorporaResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListCorpora")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCorporaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCorporaResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCorpusRequest, Empty> deleteCorpusMethodDescriptor =
      MethodDescriptor.<DeleteCorpusRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteCorpus")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteCorpusRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AnalyzeCorpusRequest, Operation>
      analyzeCorpusMethodDescriptor =
          MethodDescriptor.<AnalyzeCorpusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AnalyzeCorpus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeCorpusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataSchemaRequest, DataSchema>
      createDataSchemaMethodDescriptor =
          MethodDescriptor.<CreateDataSchemaRequest, DataSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateDataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataSchemaRequest, DataSchema>
      updateDataSchemaMethodDescriptor =
          MethodDescriptor.<UpdateDataSchemaRequest, DataSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateDataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataSchemaRequest, DataSchema>
      getDataSchemaMethodDescriptor =
          MethodDescriptor.<GetDataSchemaRequest, DataSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetDataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataSchemaRequest, Empty>
      deleteDataSchemaMethodDescriptor =
          MethodDescriptor.<DeleteDataSchemaRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteDataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataSchemasRequest, ListDataSchemasResponse>
      listDataSchemasMethodDescriptor =
          MethodDescriptor.<ListDataSchemasRequest, ListDataSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListDataSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSchemasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAnnotationRequest, Annotation>
      createAnnotationMethodDescriptor =
          MethodDescriptor.<CreateAnnotationRequest, Annotation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Annotation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnnotationRequest, Annotation>
      getAnnotationMethodDescriptor =
          MethodDescriptor.<GetAnnotationRequest, Annotation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Annotation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsMethodDescriptor =
          MethodDescriptor.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListAnnotations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAnnotationRequest, Annotation>
      updateAnnotationMethodDescriptor =
          MethodDescriptor.<UpdateAnnotationRequest, Annotation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Annotation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAnnotationRequest, Empty>
      deleteAnnotationMethodDescriptor =
          MethodDescriptor.<DeleteAnnotationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<IngestAssetRequest, IngestAssetResponse>
      ingestAssetMethodDescriptor =
          MethodDescriptor.<IngestAssetRequest, IngestAssetResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/IngestAsset")
              .setRequestMarshaller(ProtoUtils.marshaller(IngestAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IngestAssetResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ClipAssetRequest, ClipAssetResponse>
      clipAssetMethodDescriptor =
          MethodDescriptor.<ClipAssetRequest, ClipAssetResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ClipAsset")
              .setRequestMarshaller(ProtoUtils.marshaller(ClipAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ClipAssetResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateHlsUriRequest, GenerateHlsUriResponse>
      generateHlsUriMethodDescriptor =
          MethodDescriptor.<GenerateHlsUriRequest, GenerateHlsUriResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GenerateHlsUri")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateHlsUriRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateHlsUriResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportAssetsRequest, Operation>
      importAssetsMethodDescriptor =
          MethodDescriptor.<ImportAssetsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ImportAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ImportAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSearchConfigRequest, SearchConfig>
      createSearchConfigMethodDescriptor =
          MethodDescriptor.<CreateSearchConfigRequest, SearchConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateSearchConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSearchConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSearchConfigRequest, SearchConfig>
      updateSearchConfigMethodDescriptor =
          MethodDescriptor.<UpdateSearchConfigRequest, SearchConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateSearchConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSearchConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSearchConfigRequest, SearchConfig>
      getSearchConfigMethodDescriptor =
          MethodDescriptor.<GetSearchConfigRequest, SearchConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetSearchConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSearchConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSearchConfigRequest, Empty>
      deleteSearchConfigMethodDescriptor =
          MethodDescriptor.<DeleteSearchConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteSearchConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSearchConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsMethodDescriptor =
          MethodDescriptor.<ListSearchConfigsRequest, ListSearchConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListSearchConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSearchConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSearchConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymMethodDescriptor =
          MethodDescriptor.<CreateSearchHypernymRequest, SearchHypernym>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateSearchHypernym")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSearchHypernymRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchHypernym.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymMethodDescriptor =
          MethodDescriptor.<UpdateSearchHypernymRequest, SearchHypernym>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateSearchHypernym")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSearchHypernymRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchHypernym.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSearchHypernymRequest, SearchHypernym>
      getSearchHypernymMethodDescriptor =
          MethodDescriptor.<GetSearchHypernymRequest, SearchHypernym>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetSearchHypernym")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSearchHypernymRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchHypernym.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSearchHypernymRequest, Empty>
      deleteSearchHypernymMethodDescriptor =
          MethodDescriptor.<DeleteSearchHypernymRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteSearchHypernym")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSearchHypernymRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsMethodDescriptor =
          MethodDescriptor.<ListSearchHypernymsRequest, ListSearchHypernymsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListSearchHypernyms")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSearchHypernymsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSearchHypernymsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchAssetsRequest, SearchAssetsResponse>
      searchAssetsMethodDescriptor =
          MethodDescriptor.<SearchAssetsRequest, SearchAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/SearchAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointMethodDescriptor =
          MethodDescriptor.<SearchIndexEndpointRequest, SearchIndexEndpointResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/SearchIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchIndexEndpointResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateIndexEndpointRequest, Operation>
      createIndexEndpointMethodDescriptor =
          MethodDescriptor.<CreateIndexEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIndexEndpointRequest, IndexEndpoint>
      getIndexEndpointMethodDescriptor =
          MethodDescriptor.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IndexEndpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsMethodDescriptor =
          MethodDescriptor.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListIndexEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIndexEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateIndexEndpointRequest, Operation>
      updateIndexEndpointMethodDescriptor =
          MethodDescriptor.<UpdateIndexEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteIndexEndpointRequest, Operation>
      deleteIndexEndpointMethodDescriptor =
          MethodDescriptor.<DeleteIndexEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteIndexEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIndexEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployIndexRequest, Operation> deployIndexMethodDescriptor =
      MethodDescriptor.<DeployIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeployIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeployIndexRequest, Operation>
      undeployIndexMethodDescriptor =
          MethodDescriptor.<UndeployIndexRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UndeployIndex")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCollectionRequest, Operation>
      createCollectionMethodDescriptor =
          MethodDescriptor.<CreateCollectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCollectionRequest, Operation>
      deleteCollectionMethodDescriptor =
          MethodDescriptor.<DeleteCollectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCollectionRequest, Collection>
      getCollectionMethodDescriptor =
          MethodDescriptor.<GetCollectionRequest, Collection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Collection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCollectionRequest, Collection>
      updateCollectionMethodDescriptor =
          MethodDescriptor.<UpdateCollectionRequest, Collection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Collection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsMethodDescriptor =
          MethodDescriptor.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListCollections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCollectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCollectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemMethodDescriptor =
          MethodDescriptor.<AddCollectionItemRequest, AddCollectionItemResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AddCollectionItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddCollectionItemRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddCollectionItemResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemMethodDescriptor =
          MethodDescriptor.<RemoveCollectionItemRequest, RemoveCollectionItemResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/RemoveCollectionItem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveCollectionItemRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveCollectionItemResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsMethodDescriptor =
          MethodDescriptor.<ViewCollectionItemsRequest, ViewCollectionItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ViewCollectionItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ViewCollectionItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ViewCollectionItemsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateAssetRequest, Asset> createAssetCallable;
  private final UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable;
  private final UnaryCallable<GetAssetRequest, Asset> getAssetCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
  private final UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable;
  private final OperationCallable<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationCallable;
  private final UnaryCallable<UploadAssetRequest, Operation> uploadAssetCallable;
  private final OperationCallable<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationCallable;
  private final UnaryCallable<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlCallable;
  private final UnaryCallable<AnalyzeAssetRequest, Operation> analyzeAssetCallable;
  private final OperationCallable<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationCallable;
  private final UnaryCallable<IndexAssetRequest, Operation> indexAssetCallable;
  private final OperationCallable<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationCallable;
  private final UnaryCallable<RemoveIndexAssetRequest, Operation> removeIndexAssetCallable;
  private final OperationCallable<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationCallable;
  private final UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsCallable;
  private final UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsPagedCallable;
  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final OperationCallable<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationCallable;
  private final UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable;
  private final OperationCallable<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable;
  private final OperationCallable<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationCallable;
  private final UnaryCallable<CreateCorpusRequest, Operation> createCorpusCallable;
  private final OperationCallable<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationCallable;
  private final UnaryCallable<GetCorpusRequest, Corpus> getCorpusCallable;
  private final UnaryCallable<UpdateCorpusRequest, Corpus> updateCorpusCallable;
  private final UnaryCallable<ListCorporaRequest, ListCorporaResponse> listCorporaCallable;
  private final UnaryCallable<ListCorporaRequest, ListCorporaPagedResponse>
      listCorporaPagedCallable;
  private final UnaryCallable<DeleteCorpusRequest, Empty> deleteCorpusCallable;
  private final UnaryCallable<AnalyzeCorpusRequest, Operation> analyzeCorpusCallable;
  private final OperationCallable<
          AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationCallable;
  private final UnaryCallable<CreateDataSchemaRequest, DataSchema> createDataSchemaCallable;
  private final UnaryCallable<UpdateDataSchemaRequest, DataSchema> updateDataSchemaCallable;
  private final UnaryCallable<GetDataSchemaRequest, DataSchema> getDataSchemaCallable;
  private final UnaryCallable<DeleteDataSchemaRequest, Empty> deleteDataSchemaCallable;
  private final UnaryCallable<ListDataSchemasRequest, ListDataSchemasResponse>
      listDataSchemasCallable;
  private final UnaryCallable<ListDataSchemasRequest, ListDataSchemasPagedResponse>
      listDataSchemasPagedCallable;
  private final UnaryCallable<CreateAnnotationRequest, Annotation> createAnnotationCallable;
  private final UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable;
  private final UnaryCallable<UpdateAnnotationRequest, Annotation> updateAnnotationCallable;
  private final UnaryCallable<DeleteAnnotationRequest, Empty> deleteAnnotationCallable;
  private final BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> ingestAssetCallable;
  private final UnaryCallable<ClipAssetRequest, ClipAssetResponse> clipAssetCallable;
  private final UnaryCallable<GenerateHlsUriRequest, GenerateHlsUriResponse> generateHlsUriCallable;
  private final UnaryCallable<ImportAssetsRequest, Operation> importAssetsCallable;
  private final OperationCallable<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationCallable;
  private final UnaryCallable<CreateSearchConfigRequest, SearchConfig> createSearchConfigCallable;
  private final UnaryCallable<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigCallable;
  private final UnaryCallable<GetSearchConfigRequest, SearchConfig> getSearchConfigCallable;
  private final UnaryCallable<DeleteSearchConfigRequest, Empty> deleteSearchConfigCallable;
  private final UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsCallable;
  private final UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsPagedResponse>
      listSearchConfigsPagedCallable;
  private final UnaryCallable<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymCallable;
  private final UnaryCallable<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymCallable;
  private final UnaryCallable<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymCallable;
  private final UnaryCallable<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymCallable;
  private final UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsCallable;
  private final UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsPagedResponse>
      listSearchHypernymsPagedCallable;
  private final UnaryCallable<SearchAssetsRequest, SearchAssetsResponse> searchAssetsCallable;
  private final UnaryCallable<SearchAssetsRequest, SearchAssetsPagedResponse>
      searchAssetsPagedCallable;
  private final UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointCallable;
  private final UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointPagedResponse>
      searchIndexEndpointPagedCallable;
  private final UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable;
  private final OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationCallable;
  private final UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable;
  private final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable;
  private final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable;
  private final UnaryCallable<UpdateIndexEndpointRequest, Operation> updateIndexEndpointCallable;
  private final OperationCallable<
          UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationCallable;
  private final UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable;
  private final OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationCallable;
  private final UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable;
  private final OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationCallable;
  private final UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable;
  private final OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationCallable;
  private final UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable;
  private final OperationCallable<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationCallable;
  private final UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable;
  private final OperationCallable<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationCallable;
  private final UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable;
  private final UnaryCallable<UpdateCollectionRequest, Collection> updateCollectionCallable;
  private final UnaryCallable<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsCallable;
  private final UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable;
  private final UnaryCallable<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemCallable;
  private final UnaryCallable<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemCallable;
  private final UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsCallable;
  private final UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsPagedResponse>
      viewCollectionItemsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWarehouseStub create(WarehouseStubSettings settings) throws IOException {
    return new GrpcWarehouseStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWarehouseStub create(ClientContext clientContext) throws IOException {
    return new GrpcWarehouseStub(WarehouseStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWarehouseStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWarehouseStub(
        WarehouseStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWarehouseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWarehouseStub(WarehouseStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcWarehouseCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWarehouseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWarehouseStub(
      WarehouseStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAssetRequest, Asset> createAssetTransportSettings =
        GrpcCallSettings.<CreateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(createAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAssetRequest, Asset> updateAssetTransportSettings =
        GrpcCallSettings.<UpdateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(updateAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("asset.name", String.valueOf(request.getAsset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAssetRequest, Asset> getAssetTransportSettings =
        GrpcCallSettings.<GetAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(getAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        GrpcCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAssetRequest, Operation> deleteAssetTransportSettings =
        GrpcCallSettings.<DeleteAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UploadAssetRequest, Operation> uploadAssetTransportSettings =
        GrpcCallSettings.<UploadAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
        generateRetrievalUrlTransportSettings =
            GrpcCallSettings.<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>newBuilder()
                .setMethodDescriptor(generateRetrievalUrlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AnalyzeAssetRequest, Operation> analyzeAssetTransportSettings =
        GrpcCallSettings.<AnalyzeAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(analyzeAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<IndexAssetRequest, Operation> indexAssetTransportSettings =
        GrpcCallSettings.<IndexAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(indexAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveIndexAssetRequest, Operation> removeIndexAssetTransportSettings =
        GrpcCallSettings.<RemoveIndexAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(removeIndexAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
        viewIndexedAssetsTransportSettings =
            GrpcCallSettings.<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>newBuilder()
                .setMethodDescriptor(viewIndexedAssetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("index", String.valueOf(request.getIndex()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        GrpcCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIndexRequest, Operation> updateIndexTransportSettings =
        GrpcCallSettings.<UpdateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index.name", String.valueOf(request.getIndex().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        GrpcCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        GrpcCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIndexRequest, Operation> deleteIndexTransportSettings =
        GrpcCallSettings.<DeleteIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCorpusRequest, Operation> createCorpusTransportSettings =
        GrpcCallSettings.<CreateCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(createCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCorpusRequest, Corpus> getCorpusTransportSettings =
        GrpcCallSettings.<GetCorpusRequest, Corpus>newBuilder()
            .setMethodDescriptor(getCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCorpusRequest, Corpus> updateCorpusTransportSettings =
        GrpcCallSettings.<UpdateCorpusRequest, Corpus>newBuilder()
            .setMethodDescriptor(updateCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("corpus.name", String.valueOf(request.getCorpus().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCorporaRequest, ListCorporaResponse> listCorporaTransportSettings =
        GrpcCallSettings.<ListCorporaRequest, ListCorporaResponse>newBuilder()
            .setMethodDescriptor(listCorporaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCorpusRequest, Empty> deleteCorpusTransportSettings =
        GrpcCallSettings.<DeleteCorpusRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AnalyzeCorpusRequest, Operation> analyzeCorpusTransportSettings =
        GrpcCallSettings.<AnalyzeCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(analyzeCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataSchemaRequest, DataSchema> createDataSchemaTransportSettings =
        GrpcCallSettings.<CreateDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(createDataSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataSchemaRequest, DataSchema> updateDataSchemaTransportSettings =
        GrpcCallSettings.<UpdateDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(updateDataSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_schema.name", String.valueOf(request.getDataSchema().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDataSchemaRequest, DataSchema> getDataSchemaTransportSettings =
        GrpcCallSettings.<GetDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(getDataSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataSchemaRequest, Empty> deleteDataSchemaTransportSettings =
        GrpcCallSettings.<DeleteDataSchemaRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataSchemasRequest, ListDataSchemasResponse>
        listDataSchemasTransportSettings =
            GrpcCallSettings.<ListDataSchemasRequest, ListDataSchemasResponse>newBuilder()
                .setMethodDescriptor(listDataSchemasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAnnotationRequest, Annotation> createAnnotationTransportSettings =
        GrpcCallSettings.<CreateAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(createAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnnotationRequest, Annotation> getAnnotationTransportSettings =
        GrpcCallSettings.<GetAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(getAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnnotationsRequest, ListAnnotationsResponse>
        listAnnotationsTransportSettings =
            GrpcCallSettings.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
                .setMethodDescriptor(listAnnotationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAnnotationRequest, Annotation> updateAnnotationTransportSettings =
        GrpcCallSettings.<UpdateAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(updateAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("annotation.name", String.valueOf(request.getAnnotation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAnnotationRequest, Empty> deleteAnnotationTransportSettings =
        GrpcCallSettings.<DeleteAnnotationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<IngestAssetRequest, IngestAssetResponse> ingestAssetTransportSettings =
        GrpcCallSettings.<IngestAssetRequest, IngestAssetResponse>newBuilder()
            .setMethodDescriptor(ingestAssetMethodDescriptor)
            .build();
    GrpcCallSettings<ClipAssetRequest, ClipAssetResponse> clipAssetTransportSettings =
        GrpcCallSettings.<ClipAssetRequest, ClipAssetResponse>newBuilder()
            .setMethodDescriptor(clipAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateHlsUriRequest, GenerateHlsUriResponse>
        generateHlsUriTransportSettings =
            GrpcCallSettings.<GenerateHlsUriRequest, GenerateHlsUriResponse>newBuilder()
                .setMethodDescriptor(generateHlsUriMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportAssetsRequest, Operation> importAssetsTransportSettings =
        GrpcCallSettings.<ImportAssetsRequest, Operation>newBuilder()
            .setMethodDescriptor(importAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSearchConfigRequest, SearchConfig> createSearchConfigTransportSettings =
        GrpcCallSettings.<CreateSearchConfigRequest, SearchConfig>newBuilder()
            .setMethodDescriptor(createSearchConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigTransportSettings =
        GrpcCallSettings.<UpdateSearchConfigRequest, SearchConfig>newBuilder()
            .setMethodDescriptor(updateSearchConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "search_config.name", String.valueOf(request.getSearchConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSearchConfigRequest, SearchConfig> getSearchConfigTransportSettings =
        GrpcCallSettings.<GetSearchConfigRequest, SearchConfig>newBuilder()
            .setMethodDescriptor(getSearchConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSearchConfigRequest, Empty> deleteSearchConfigTransportSettings =
        GrpcCallSettings.<DeleteSearchConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSearchConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSearchConfigsRequest, ListSearchConfigsResponse>
        listSearchConfigsTransportSettings =
            GrpcCallSettings.<ListSearchConfigsRequest, ListSearchConfigsResponse>newBuilder()
                .setMethodDescriptor(listSearchConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSearchHypernymRequest, SearchHypernym>
        createSearchHypernymTransportSettings =
            GrpcCallSettings.<CreateSearchHypernymRequest, SearchHypernym>newBuilder()
                .setMethodDescriptor(createSearchHypernymMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSearchHypernymRequest, SearchHypernym>
        updateSearchHypernymTransportSettings =
            GrpcCallSettings.<UpdateSearchHypernymRequest, SearchHypernym>newBuilder()
                .setMethodDescriptor(updateSearchHypernymMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "search_hypernym.name",
                          String.valueOf(request.getSearchHypernym().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymTransportSettings =
        GrpcCallSettings.<GetSearchHypernymRequest, SearchHypernym>newBuilder()
            .setMethodDescriptor(getSearchHypernymMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymTransportSettings =
        GrpcCallSettings.<DeleteSearchHypernymRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSearchHypernymMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
        listSearchHypernymsTransportSettings =
            GrpcCallSettings.<ListSearchHypernymsRequest, ListSearchHypernymsResponse>newBuilder()
                .setMethodDescriptor(listSearchHypernymsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchAssetsRequest, SearchAssetsResponse> searchAssetsTransportSettings =
        GrpcCallSettings.<SearchAssetsRequest, SearchAssetsResponse>newBuilder()
            .setMethodDescriptor(searchAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("corpus", String.valueOf(request.getCorpus()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
        searchIndexEndpointTransportSettings =
            GrpcCallSettings.<SearchIndexEndpointRequest, SearchIndexEndpointResponse>newBuilder()
                .setMethodDescriptor(searchIndexEndpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointTransportSettings =
        GrpcCallSettings.<CreateIndexEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointTransportSettings =
        GrpcCallSettings.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
            .setMethodDescriptor(getIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
        listIndexEndpointsTransportSettings =
            GrpcCallSettings.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
                .setMethodDescriptor(listIndexEndpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateIndexEndpointRequest, Operation> updateIndexEndpointTransportSettings =
        GrpcCallSettings.<UpdateIndexEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "index_endpoint.name", String.valueOf(request.getIndexEndpoint().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointTransportSettings =
        GrpcCallSettings.<DeleteIndexEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIndexEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeployIndexRequest, Operation> deployIndexTransportSettings =
        GrpcCallSettings.<DeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeployIndexRequest, Operation> undeployIndexTransportSettings =
        GrpcCallSettings.<UndeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCollectionRequest, Operation> createCollectionTransportSettings =
        GrpcCallSettings.<CreateCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCollectionRequest, Operation> deleteCollectionTransportSettings =
        GrpcCallSettings.<DeleteCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCollectionRequest, Collection> getCollectionTransportSettings =
        GrpcCallSettings.<GetCollectionRequest, Collection>newBuilder()
            .setMethodDescriptor(getCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCollectionRequest, Collection> updateCollectionTransportSettings =
        GrpcCallSettings.<UpdateCollectionRequest, Collection>newBuilder()
            .setMethodDescriptor(updateCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection.name", String.valueOf(request.getCollection().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCollectionsRequest, ListCollectionsResponse>
        listCollectionsTransportSettings =
            GrpcCallSettings.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
                .setMethodDescriptor(listCollectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AddCollectionItemRequest, AddCollectionItemResponse>
        addCollectionItemTransportSettings =
            GrpcCallSettings.<AddCollectionItemRequest, AddCollectionItemResponse>newBuilder()
                .setMethodDescriptor(addCollectionItemMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "item.collection", String.valueOf(request.getItem().getCollection()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
        removeCollectionItemTransportSettings =
            GrpcCallSettings.<RemoveCollectionItemRequest, RemoveCollectionItemResponse>newBuilder()
                .setMethodDescriptor(removeCollectionItemMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "item.collection", String.valueOf(request.getItem().getCollection()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
        viewCollectionItemsTransportSettings =
            GrpcCallSettings.<ViewCollectionItemsRequest, ViewCollectionItemsResponse>newBuilder()
                .setMethodDescriptor(viewCollectionItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("collection", String.valueOf(request.getCollection()));
                      return builder.build();
                    })
                .build();

    this.createAssetCallable =
        callableFactory.createUnaryCallable(
            createAssetTransportSettings, settings.createAssetSettings(), clientContext);
    this.updateAssetCallable =
        callableFactory.createUnaryCallable(
            updateAssetTransportSettings, settings.updateAssetSettings(), clientContext);
    this.getAssetCallable =
        callableFactory.createUnaryCallable(
            getAssetTransportSettings, settings.getAssetSettings(), clientContext);
    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.deleteAssetCallable =
        callableFactory.createUnaryCallable(
            deleteAssetTransportSettings, settings.deleteAssetSettings(), clientContext);
    this.deleteAssetOperationCallable =
        callableFactory.createOperationCallable(
            deleteAssetTransportSettings,
            settings.deleteAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.uploadAssetCallable =
        callableFactory.createUnaryCallable(
            uploadAssetTransportSettings, settings.uploadAssetSettings(), clientContext);
    this.uploadAssetOperationCallable =
        callableFactory.createOperationCallable(
            uploadAssetTransportSettings,
            settings.uploadAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.generateRetrievalUrlCallable =
        callableFactory.createUnaryCallable(
            generateRetrievalUrlTransportSettings,
            settings.generateRetrievalUrlSettings(),
            clientContext);
    this.analyzeAssetCallable =
        callableFactory.createUnaryCallable(
            analyzeAssetTransportSettings, settings.analyzeAssetSettings(), clientContext);
    this.analyzeAssetOperationCallable =
        callableFactory.createOperationCallable(
            analyzeAssetTransportSettings,
            settings.analyzeAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.indexAssetCallable =
        callableFactory.createUnaryCallable(
            indexAssetTransportSettings, settings.indexAssetSettings(), clientContext);
    this.indexAssetOperationCallable =
        callableFactory.createOperationCallable(
            indexAssetTransportSettings,
            settings.indexAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.removeIndexAssetCallable =
        callableFactory.createUnaryCallable(
            removeIndexAssetTransportSettings, settings.removeIndexAssetSettings(), clientContext);
    this.removeIndexAssetOperationCallable =
        callableFactory.createOperationCallable(
            removeIndexAssetTransportSettings,
            settings.removeIndexAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.viewIndexedAssetsCallable =
        callableFactory.createUnaryCallable(
            viewIndexedAssetsTransportSettings,
            settings.viewIndexedAssetsSettings(),
            clientContext);
    this.viewIndexedAssetsPagedCallable =
        callableFactory.createPagedCallable(
            viewIndexedAssetsTransportSettings,
            settings.viewIndexedAssetsSettings(),
            clientContext);
    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.createIndexOperationCallable =
        callableFactory.createOperationCallable(
            createIndexTransportSettings,
            settings.createIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.updateIndexCallable =
        callableFactory.createUnaryCallable(
            updateIndexTransportSettings, settings.updateIndexSettings(), clientContext);
    this.updateIndexOperationCallable =
        callableFactory.createOperationCallable(
            updateIndexTransportSettings,
            settings.updateIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.deleteIndexOperationCallable =
        callableFactory.createOperationCallable(
            deleteIndexTransportSettings,
            settings.deleteIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.createCorpusCallable =
        callableFactory.createUnaryCallable(
            createCorpusTransportSettings, settings.createCorpusSettings(), clientContext);
    this.createCorpusOperationCallable =
        callableFactory.createOperationCallable(
            createCorpusTransportSettings,
            settings.createCorpusOperationSettings(),
            clientContext,
            operationsStub);
    this.getCorpusCallable =
        callableFactory.createUnaryCallable(
            getCorpusTransportSettings, settings.getCorpusSettings(), clientContext);
    this.updateCorpusCallable =
        callableFactory.createUnaryCallable(
            updateCorpusTransportSettings, settings.updateCorpusSettings(), clientContext);
    this.listCorporaCallable =
        callableFactory.createUnaryCallable(
            listCorporaTransportSettings, settings.listCorporaSettings(), clientContext);
    this.listCorporaPagedCallable =
        callableFactory.createPagedCallable(
            listCorporaTransportSettings, settings.listCorporaSettings(), clientContext);
    this.deleteCorpusCallable =
        callableFactory.createUnaryCallable(
            deleteCorpusTransportSettings, settings.deleteCorpusSettings(), clientContext);
    this.analyzeCorpusCallable =
        callableFactory.createUnaryCallable(
            analyzeCorpusTransportSettings, settings.analyzeCorpusSettings(), clientContext);
    this.analyzeCorpusOperationCallable =
        callableFactory.createOperationCallable(
            analyzeCorpusTransportSettings,
            settings.analyzeCorpusOperationSettings(),
            clientContext,
            operationsStub);
    this.createDataSchemaCallable =
        callableFactory.createUnaryCallable(
            createDataSchemaTransportSettings, settings.createDataSchemaSettings(), clientContext);
    this.updateDataSchemaCallable =
        callableFactory.createUnaryCallable(
            updateDataSchemaTransportSettings, settings.updateDataSchemaSettings(), clientContext);
    this.getDataSchemaCallable =
        callableFactory.createUnaryCallable(
            getDataSchemaTransportSettings, settings.getDataSchemaSettings(), clientContext);
    this.deleteDataSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteDataSchemaTransportSettings, settings.deleteDataSchemaSettings(), clientContext);
    this.listDataSchemasCallable =
        callableFactory.createUnaryCallable(
            listDataSchemasTransportSettings, settings.listDataSchemasSettings(), clientContext);
    this.listDataSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listDataSchemasTransportSettings, settings.listDataSchemasSettings(), clientContext);
    this.createAnnotationCallable =
        callableFactory.createUnaryCallable(
            createAnnotationTransportSettings, settings.createAnnotationSettings(), clientContext);
    this.getAnnotationCallable =
        callableFactory.createUnaryCallable(
            getAnnotationTransportSettings, settings.getAnnotationSettings(), clientContext);
    this.listAnnotationsCallable =
        callableFactory.createUnaryCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);
    this.listAnnotationsPagedCallable =
        callableFactory.createPagedCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);
    this.updateAnnotationCallable =
        callableFactory.createUnaryCallable(
            updateAnnotationTransportSettings, settings.updateAnnotationSettings(), clientContext);
    this.deleteAnnotationCallable =
        callableFactory.createUnaryCallable(
            deleteAnnotationTransportSettings, settings.deleteAnnotationSettings(), clientContext);
    this.ingestAssetCallable =
        callableFactory.createBidiStreamingCallable(
            ingestAssetTransportSettings, settings.ingestAssetSettings(), clientContext);
    this.clipAssetCallable =
        callableFactory.createUnaryCallable(
            clipAssetTransportSettings, settings.clipAssetSettings(), clientContext);
    this.generateHlsUriCallable =
        callableFactory.createUnaryCallable(
            generateHlsUriTransportSettings, settings.generateHlsUriSettings(), clientContext);
    this.importAssetsCallable =
        callableFactory.createUnaryCallable(
            importAssetsTransportSettings, settings.importAssetsSettings(), clientContext);
    this.importAssetsOperationCallable =
        callableFactory.createOperationCallable(
            importAssetsTransportSettings,
            settings.importAssetsOperationSettings(),
            clientContext,
            operationsStub);
    this.createSearchConfigCallable =
        callableFactory.createUnaryCallable(
            createSearchConfigTransportSettings,
            settings.createSearchConfigSettings(),
            clientContext);
    this.updateSearchConfigCallable =
        callableFactory.createUnaryCallable(
            updateSearchConfigTransportSettings,
            settings.updateSearchConfigSettings(),
            clientContext);
    this.getSearchConfigCallable =
        callableFactory.createUnaryCallable(
            getSearchConfigTransportSettings, settings.getSearchConfigSettings(), clientContext);
    this.deleteSearchConfigCallable =
        callableFactory.createUnaryCallable(
            deleteSearchConfigTransportSettings,
            settings.deleteSearchConfigSettings(),
            clientContext);
    this.listSearchConfigsCallable =
        callableFactory.createUnaryCallable(
            listSearchConfigsTransportSettings,
            settings.listSearchConfigsSettings(),
            clientContext);
    this.listSearchConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listSearchConfigsTransportSettings,
            settings.listSearchConfigsSettings(),
            clientContext);
    this.createSearchHypernymCallable =
        callableFactory.createUnaryCallable(
            createSearchHypernymTransportSettings,
            settings.createSearchHypernymSettings(),
            clientContext);
    this.updateSearchHypernymCallable =
        callableFactory.createUnaryCallable(
            updateSearchHypernymTransportSettings,
            settings.updateSearchHypernymSettings(),
            clientContext);
    this.getSearchHypernymCallable =
        callableFactory.createUnaryCallable(
            getSearchHypernymTransportSettings,
            settings.getSearchHypernymSettings(),
            clientContext);
    this.deleteSearchHypernymCallable =
        callableFactory.createUnaryCallable(
            deleteSearchHypernymTransportSettings,
            settings.deleteSearchHypernymSettings(),
            clientContext);
    this.listSearchHypernymsCallable =
        callableFactory.createUnaryCallable(
            listSearchHypernymsTransportSettings,
            settings.listSearchHypernymsSettings(),
            clientContext);
    this.listSearchHypernymsPagedCallable =
        callableFactory.createPagedCallable(
            listSearchHypernymsTransportSettings,
            settings.listSearchHypernymsSettings(),
            clientContext);
    this.searchAssetsCallable =
        callableFactory.createUnaryCallable(
            searchAssetsTransportSettings, settings.searchAssetsSettings(), clientContext);
    this.searchAssetsPagedCallable =
        callableFactory.createPagedCallable(
            searchAssetsTransportSettings, settings.searchAssetsSettings(), clientContext);
    this.searchIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            searchIndexEndpointTransportSettings,
            settings.searchIndexEndpointSettings(),
            clientContext);
    this.searchIndexEndpointPagedCallable =
        callableFactory.createPagedCallable(
            searchIndexEndpointTransportSettings,
            settings.searchIndexEndpointSettings(),
            clientContext);
    this.createIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            createIndexEndpointTransportSettings,
            settings.createIndexEndpointSettings(),
            clientContext);
    this.createIndexEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createIndexEndpointTransportSettings,
            settings.createIndexEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.getIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            getIndexEndpointTransportSettings, settings.getIndexEndpointSettings(), clientContext);
    this.listIndexEndpointsCallable =
        callableFactory.createUnaryCallable(
            listIndexEndpointsTransportSettings,
            settings.listIndexEndpointsSettings(),
            clientContext);
    this.listIndexEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listIndexEndpointsTransportSettings,
            settings.listIndexEndpointsSettings(),
            clientContext);
    this.updateIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            updateIndexEndpointTransportSettings,
            settings.updateIndexEndpointSettings(),
            clientContext);
    this.updateIndexEndpointOperationCallable =
        callableFactory.createOperationCallable(
            updateIndexEndpointTransportSettings,
            settings.updateIndexEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteIndexEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteIndexEndpointTransportSettings,
            settings.deleteIndexEndpointSettings(),
            clientContext);
    this.deleteIndexEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteIndexEndpointTransportSettings,
            settings.deleteIndexEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deployIndexCallable =
        callableFactory.createUnaryCallable(
            deployIndexTransportSettings, settings.deployIndexSettings(), clientContext);
    this.deployIndexOperationCallable =
        callableFactory.createOperationCallable(
            deployIndexTransportSettings,
            settings.deployIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployIndexCallable =
        callableFactory.createUnaryCallable(
            undeployIndexTransportSettings, settings.undeployIndexSettings(), clientContext);
    this.undeployIndexOperationCallable =
        callableFactory.createOperationCallable(
            undeployIndexTransportSettings,
            settings.undeployIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.createCollectionCallable =
        callableFactory.createUnaryCallable(
            createCollectionTransportSettings, settings.createCollectionSettings(), clientContext);
    this.createCollectionOperationCallable =
        callableFactory.createOperationCallable(
            createCollectionTransportSettings,
            settings.createCollectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCollectionCallable =
        callableFactory.createUnaryCallable(
            deleteCollectionTransportSettings, settings.deleteCollectionSettings(), clientContext);
    this.deleteCollectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteCollectionTransportSettings,
            settings.deleteCollectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getCollectionCallable =
        callableFactory.createUnaryCallable(
            getCollectionTransportSettings, settings.getCollectionSettings(), clientContext);
    this.updateCollectionCallable =
        callableFactory.createUnaryCallable(
            updateCollectionTransportSettings, settings.updateCollectionSettings(), clientContext);
    this.listCollectionsCallable =
        callableFactory.createUnaryCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.listCollectionsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.addCollectionItemCallable =
        callableFactory.createUnaryCallable(
            addCollectionItemTransportSettings,
            settings.addCollectionItemSettings(),
            clientContext);
    this.removeCollectionItemCallable =
        callableFactory.createUnaryCallable(
            removeCollectionItemTransportSettings,
            settings.removeCollectionItemSettings(),
            clientContext);
    this.viewCollectionItemsCallable =
        callableFactory.createUnaryCallable(
            viewCollectionItemsTransportSettings,
            settings.viewCollectionItemsSettings(),
            clientContext);
    this.viewCollectionItemsPagedCallable =
        callableFactory.createPagedCallable(
            viewCollectionItemsTransportSettings,
            settings.viewCollectionItemsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAssetRequest, Asset> createAssetCallable() {
    return createAssetCallable;
  }

  @Override
  public UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    return updateAssetCallable;
  }

  @Override
  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return getAssetCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    return deleteAssetCallable;
  }

  @Override
  public OperationCallable<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationCallable() {
    return deleteAssetOperationCallable;
  }

  @Override
  public UnaryCallable<UploadAssetRequest, Operation> uploadAssetCallable() {
    return uploadAssetCallable;
  }

  @Override
  public OperationCallable<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationCallable() {
    return uploadAssetOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlCallable() {
    return generateRetrievalUrlCallable;
  }

  @Override
  public UnaryCallable<AnalyzeAssetRequest, Operation> analyzeAssetCallable() {
    return analyzeAssetCallable;
  }

  @Override
  public OperationCallable<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationCallable() {
    return analyzeAssetOperationCallable;
  }

  @Override
  public UnaryCallable<IndexAssetRequest, Operation> indexAssetCallable() {
    return indexAssetCallable;
  }

  @Override
  public OperationCallable<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationCallable() {
    return indexAssetOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveIndexAssetRequest, Operation> removeIndexAssetCallable() {
    return removeIndexAssetCallable;
  }

  @Override
  public OperationCallable<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationCallable() {
    return removeIndexAssetOperationCallable;
  }

  @Override
  public UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsCallable() {
    return viewIndexedAssetsCallable;
  }

  @Override
  public UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsPagedCallable() {
    return viewIndexedAssetsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  @Override
  public OperationCallable<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationCallable() {
    return createIndexOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    return updateIndexCallable;
  }

  @Override
  public OperationCallable<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationCallable() {
    return updateIndexOperationCallable;
  }

  @Override
  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return listIndexesCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    return listIndexesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  @Override
  public OperationCallable<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationCallable() {
    return deleteIndexOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCorpusRequest, Operation> createCorpusCallable() {
    return createCorpusCallable;
  }

  @Override
  public OperationCallable<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationCallable() {
    return createCorpusOperationCallable;
  }

  @Override
  public UnaryCallable<GetCorpusRequest, Corpus> getCorpusCallable() {
    return getCorpusCallable;
  }

  @Override
  public UnaryCallable<UpdateCorpusRequest, Corpus> updateCorpusCallable() {
    return updateCorpusCallable;
  }

  @Override
  public UnaryCallable<ListCorporaRequest, ListCorporaResponse> listCorporaCallable() {
    return listCorporaCallable;
  }

  @Override
  public UnaryCallable<ListCorporaRequest, ListCorporaPagedResponse> listCorporaPagedCallable() {
    return listCorporaPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCorpusRequest, Empty> deleteCorpusCallable() {
    return deleteCorpusCallable;
  }

  @Override
  public UnaryCallable<AnalyzeCorpusRequest, Operation> analyzeCorpusCallable() {
    return analyzeCorpusCallable;
  }

  @Override
  public OperationCallable<AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationCallable() {
    return analyzeCorpusOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDataSchemaRequest, DataSchema> createDataSchemaCallable() {
    return createDataSchemaCallable;
  }

  @Override
  public UnaryCallable<UpdateDataSchemaRequest, DataSchema> updateDataSchemaCallable() {
    return updateDataSchemaCallable;
  }

  @Override
  public UnaryCallable<GetDataSchemaRequest, DataSchema> getDataSchemaCallable() {
    return getDataSchemaCallable;
  }

  @Override
  public UnaryCallable<DeleteDataSchemaRequest, Empty> deleteDataSchemaCallable() {
    return deleteDataSchemaCallable;
  }

  @Override
  public UnaryCallable<ListDataSchemasRequest, ListDataSchemasResponse> listDataSchemasCallable() {
    return listDataSchemasCallable;
  }

  @Override
  public UnaryCallable<ListDataSchemasRequest, ListDataSchemasPagedResponse>
      listDataSchemasPagedCallable() {
    return listDataSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAnnotationRequest, Annotation> createAnnotationCallable() {
    return createAnnotationCallable;
  }

  @Override
  public UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    return getAnnotationCallable;
  }

  @Override
  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> listAnnotationsCallable() {
    return listAnnotationsCallable;
  }

  @Override
  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return listAnnotationsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateAnnotationRequest, Annotation> updateAnnotationCallable() {
    return updateAnnotationCallable;
  }

  @Override
  public UnaryCallable<DeleteAnnotationRequest, Empty> deleteAnnotationCallable() {
    return deleteAnnotationCallable;
  }

  @Override
  public BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> ingestAssetCallable() {
    return ingestAssetCallable;
  }

  @Override
  public UnaryCallable<ClipAssetRequest, ClipAssetResponse> clipAssetCallable() {
    return clipAssetCallable;
  }

  @Override
  public UnaryCallable<GenerateHlsUriRequest, GenerateHlsUriResponse> generateHlsUriCallable() {
    return generateHlsUriCallable;
  }

  @Override
  public UnaryCallable<ImportAssetsRequest, Operation> importAssetsCallable() {
    return importAssetsCallable;
  }

  @Override
  public OperationCallable<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationCallable() {
    return importAssetsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSearchConfigRequest, SearchConfig> createSearchConfigCallable() {
    return createSearchConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigCallable() {
    return updateSearchConfigCallable;
  }

  @Override
  public UnaryCallable<GetSearchConfigRequest, SearchConfig> getSearchConfigCallable() {
    return getSearchConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteSearchConfigRequest, Empty> deleteSearchConfigCallable() {
    return deleteSearchConfigCallable;
  }

  @Override
  public UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsCallable() {
    return listSearchConfigsCallable;
  }

  @Override
  public UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsPagedResponse>
      listSearchConfigsPagedCallable() {
    return listSearchConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSearchHypernymRequest, SearchHypernym> createSearchHypernymCallable() {
    return createSearchHypernymCallable;
  }

  @Override
  public UnaryCallable<UpdateSearchHypernymRequest, SearchHypernym> updateSearchHypernymCallable() {
    return updateSearchHypernymCallable;
  }

  @Override
  public UnaryCallable<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymCallable() {
    return getSearchHypernymCallable;
  }

  @Override
  public UnaryCallable<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymCallable() {
    return deleteSearchHypernymCallable;
  }

  @Override
  public UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsCallable() {
    return listSearchHypernymsCallable;
  }

  @Override
  public UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsPagedResponse>
      listSearchHypernymsPagedCallable() {
    return listSearchHypernymsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAssetsRequest, SearchAssetsResponse> searchAssetsCallable() {
    return searchAssetsCallable;
  }

  @Override
  public UnaryCallable<SearchAssetsRequest, SearchAssetsPagedResponse> searchAssetsPagedCallable() {
    return searchAssetsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointCallable() {
    return searchIndexEndpointCallable;
  }

  @Override
  public UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointPagedResponse>
      searchIndexEndpointPagedCallable() {
    return searchIndexEndpointPagedCallable;
  }

  @Override
  public UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    return createIndexEndpointCallable;
  }

  @Override
  public OperationCallable<CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationCallable() {
    return createIndexEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    return getIndexEndpointCallable;
  }

  @Override
  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    return listIndexEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    return listIndexEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIndexEndpointRequest, Operation> updateIndexEndpointCallable() {
    return updateIndexEndpointCallable;
  }

  @Override
  public OperationCallable<UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationCallable() {
    return updateIndexEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    return deleteIndexEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationCallable() {
    return deleteIndexEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    return deployIndexCallable;
  }

  @Override
  public OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationCallable() {
    return deployIndexOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    return undeployIndexCallable;
  }

  @Override
  public OperationCallable<UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationCallable() {
    return undeployIndexOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    return createCollectionCallable;
  }

  @Override
  public OperationCallable<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationCallable() {
    return createCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    return deleteCollectionCallable;
  }

  @Override
  public OperationCallable<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationCallable() {
    return deleteCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    return getCollectionCallable;
  }

  @Override
  public UnaryCallable<UpdateCollectionRequest, Collection> updateCollectionCallable() {
    return updateCollectionCallable;
  }

  @Override
  public UnaryCallable<ListCollectionsRequest, ListCollectionsResponse> listCollectionsCallable() {
    return listCollectionsCallable;
  }

  @Override
  public UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable() {
    return listCollectionsPagedCallable;
  }

  @Override
  public UnaryCallable<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemCallable() {
    return addCollectionItemCallable;
  }

  @Override
  public UnaryCallable<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemCallable() {
    return removeCollectionItemCallable;
  }

  @Override
  public UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsCallable() {
    return viewCollectionItemsCallable;
  }

  @Override
  public UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsPagedResponse>
      viewCollectionItemsPagedCallable() {
    return viewCollectionItemsPagedCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
