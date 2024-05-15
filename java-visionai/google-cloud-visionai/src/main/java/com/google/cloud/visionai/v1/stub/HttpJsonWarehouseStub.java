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

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Warehouse service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonWarehouseStub extends WarehouseStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DeployIndexResponse.getDescriptor())
          .add(IndexEndpoint.getDescriptor())
          .add(CreateCollectionMetadata.getDescriptor())
          .add(UpdateIndexEndpointMetadata.getDescriptor())
          .add(DeployIndexMetadata.getDescriptor())
          .add(CreateIndexEndpointMetadata.getDescriptor())
          .add(DeleteAssetMetadata.getDescriptor())
          .add(UndeployIndexMetadata.getDescriptor())
          .add(UndeployIndexResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(ImportAssetsMetadata.getDescriptor())
          .add(Index.getDescriptor())
          .add(CreateCorpusMetadata.getDescriptor())
          .add(AnalyzeCorpusMetadata.getDescriptor())
          .add(DeleteIndexEndpointMetadata.getDescriptor())
          .add(RemoveIndexAssetResponse.getDescriptor())
          .add(DeleteIndexMetadata.getDescriptor())
          .add(CreateIndexMetadata.getDescriptor())
          .add(Collection.getDescriptor())
          .add(UploadAssetResponse.getDescriptor())
          .add(IndexAssetMetadata.getDescriptor())
          .add(DeleteCollectionMetadata.getDescriptor())
          .add(AnalyzeAssetMetadata.getDescriptor())
          .add(AnalyzeAssetResponse.getDescriptor())
          .add(ImportAssetsResponse.getDescriptor())
          .add(UploadAssetMetadata.getDescriptor())
          .add(IndexAssetResponse.getDescriptor())
          .add(RemoveIndexAssetMetadata.getDescriptor())
          .add(Corpus.getDescriptor())
          .add(AnalyzeCorpusResponse.getDescriptor())
          .add(UpdateIndexMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateAssetRequest, Asset> createAssetMethodDescriptor =
      ApiMethodDescriptor.<CreateAssetRequest, Asset>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateAsset")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/corpora/*}/assets",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasAssetId()) {
                          serializer.putQueryParam(fields, "assetId", request.getAssetId());
                        }
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("asset", request.getAsset(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Asset>newBuilder()
                  .setDefaultInstance(Asset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateAssetRequest, Asset> updateAssetMethodDescriptor =
      ApiMethodDescriptor.<UpdateAssetRequest, Asset>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateAsset")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{asset.name=projects/*/locations/*/corpora/*/assets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "asset.name", request.getAsset().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("asset", request.getAsset(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Asset>newBuilder()
                  .setDefaultInstance(Asset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetAssetRequest, Asset> getAssetMethodDescriptor =
      ApiMethodDescriptor.<GetAssetRequest, Asset>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetAsset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/corpora/*/assets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Asset>newBuilder()
                  .setDefaultInstance(Asset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          ApiMethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/assets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssetsResponse>newBuilder()
                      .setDefaultInstance(ListAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAssetRequest, Operation>
      deleteAssetMethodDescriptor =
          ApiMethodDescriptor.<DeleteAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteAsset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UploadAssetRequest, Operation>
      uploadAssetMethodDescriptor =
          ApiMethodDescriptor.<UploadAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UploadAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UploadAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:upload",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UploadAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UploadAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UploadAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GenerateRetrievalUrl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateRetrievalUrlRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:generateRetrievalUrl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateRetrievalUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateRetrievalUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateRetrievalUrlResponse>newBuilder()
                      .setDefaultInstance(GenerateRetrievalUrlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeAssetRequest, Operation>
      analyzeAssetMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AnalyzeAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:analyze",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AnalyzeAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<IndexAssetRequest, Operation>
      indexAssetMethodDescriptor =
          ApiMethodDescriptor.<IndexAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/IndexAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IndexAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:index",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IndexAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IndexAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (IndexAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveIndexAssetRequest, Operation>
      removeIndexAssetMethodDescriptor =
          ApiMethodDescriptor.<RemoveIndexAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/RemoveIndexAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveIndexAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:removeIndex",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIndexAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIndexAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveIndexAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsMethodDescriptor =
          ApiMethodDescriptor.<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ViewIndexedAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ViewIndexedAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{index=projects/*/locations/*/corpora/*/indexes/*}:viewAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ViewIndexedAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "index", request.getIndex());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ViewIndexedAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ViewIndexedAssetsResponse>newBuilder()
                      .setDefaultInstance(ViewIndexedAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIndexRequest, Operation>
      createIndexMethodDescriptor =
          ApiMethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateIndex")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/indexes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "indexId", request.getIndexId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("index", request.getIndex(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateIndexRequest, Operation>
      updateIndexMethodDescriptor =
          ApiMethodDescriptor.<UpdateIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateIndex")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{index.name=projects/*/locations/*/corpora/*/indexes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "index.name", request.getIndex().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("index", request.getIndex(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      ApiMethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetIndex")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetIndexRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/corpora/*/indexes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetIndexRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetIndexRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Index>newBuilder()
                  .setDefaultInstance(Index.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          ApiMethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListIndexes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIndexesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/indexes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIndexesResponse>newBuilder()
                      .setDefaultInstance(ListIndexesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteIndexRequest, Operation>
      deleteIndexMethodDescriptor =
          ApiMethodDescriptor.<DeleteIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteIndex")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/indexes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCorpusRequest, Operation>
      createCorpusMethodDescriptor =
          ApiMethodDescriptor.<CreateCorpusRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateCorpus")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCorpusRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/corpora",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("corpus", request.getCorpus(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCorpusRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetCorpusRequest, Corpus> getCorpusMethodDescriptor =
      ApiMethodDescriptor.<GetCorpusRequest, Corpus>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetCorpus")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCorpusRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/corpora/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCorpusRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCorpusRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Corpus>newBuilder()
                  .setDefaultInstance(Corpus.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateCorpusRequest, Corpus>
      updateCorpusMethodDescriptor =
          ApiMethodDescriptor.<UpdateCorpusRequest, Corpus>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateCorpus")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCorpusRequest>newBuilder()
                      .setPath(
                          "/v1/{corpus.name=projects/*/locations/*/corpora/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "corpus.name", request.getCorpus().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("corpus", request.getCorpus(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Corpus>newBuilder()
                      .setDefaultInstance(Corpus.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCorporaRequest, ListCorporaResponse>
      listCorporaMethodDescriptor =
          ApiMethodDescriptor.<ListCorporaRequest, ListCorporaResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListCorpora")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCorporaRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/corpora",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCorporaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCorporaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCorporaResponse>newBuilder()
                      .setDefaultInstance(ListCorporaResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCorpusRequest, Empty>
      deleteCorpusMethodDescriptor =
          ApiMethodDescriptor.<DeleteCorpusRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteCorpus")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCorpusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeCorpusRequest, Operation>
      analyzeCorpusMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeCorpusRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AnalyzeCorpus")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeCorpusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*}:analyze",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeCorpusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AnalyzeCorpusRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateDataSchemaRequest, DataSchema>
      createDataSchemaMethodDescriptor =
          ApiMethodDescriptor.<CreateDataSchemaRequest, DataSchema>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateDataSchema")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/dataSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataSchema", request.getDataSchema(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSchema>newBuilder()
                      .setDefaultInstance(DataSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataSchemaRequest, DataSchema>
      updateDataSchemaMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataSchemaRequest, DataSchema>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateDataSchema")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{dataSchema.name=projects/*/locations/*/corpora/*/dataSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataSchema.name", request.getDataSchema().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataSchema", request.getDataSchema(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSchema>newBuilder()
                      .setDefaultInstance(DataSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataSchemaRequest, DataSchema>
      getDataSchemaMethodDescriptor =
          ApiMethodDescriptor.<GetDataSchemaRequest, DataSchema>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetDataSchema")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/dataSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSchema>newBuilder()
                      .setDefaultInstance(DataSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataSchemaRequest, Empty>
      deleteDataSchemaMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataSchemaRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteDataSchema")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/dataSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataSchemasRequest, ListDataSchemasResponse>
      listDataSchemasMethodDescriptor =
          ApiMethodDescriptor.<ListDataSchemasRequest, ListDataSchemasResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListDataSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataSchemasRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/dataSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataSchemasResponse>newBuilder()
                      .setDefaultInstance(ListDataSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnnotationRequest, Annotation>
      createAnnotationMethodDescriptor =
          ApiMethodDescriptor.<CreateAnnotationRequest, Annotation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateAnnotation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*/assets/*}/annotations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasAnnotationId()) {
                              serializer.putQueryParam(
                                  fields, "annotationId", request.getAnnotationId());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("annotation", request.getAnnotation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Annotation>newBuilder()
                      .setDefaultInstance(Annotation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAnnotationRequest, Annotation>
      getAnnotationMethodDescriptor =
          ApiMethodDescriptor.<GetAnnotationRequest, Annotation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetAnnotation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*/annotations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Annotation>newBuilder()
                      .setDefaultInstance(Annotation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsMethodDescriptor =
          ApiMethodDescriptor.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListAnnotations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnnotationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*/assets/*}/annotations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnnotationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnnotationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnnotationsResponse>newBuilder()
                      .setDefaultInstance(ListAnnotationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAnnotationRequest, Annotation>
      updateAnnotationMethodDescriptor =
          ApiMethodDescriptor.<UpdateAnnotationRequest, Annotation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateAnnotation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{annotation.name=projects/*/locations/*/corpora/*/assets/*/annotations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "annotation.name", request.getAnnotation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("annotation", request.getAnnotation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Annotation>newBuilder()
                      .setDefaultInstance(Annotation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAnnotationRequest, Empty>
      deleteAnnotationMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnnotationRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteAnnotation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*/annotations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ClipAssetRequest, ClipAssetResponse>
      clipAssetMethodDescriptor =
          ApiMethodDescriptor.<ClipAssetRequest, ClipAssetResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ClipAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ClipAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:clip",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ClipAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ClipAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ClipAssetResponse>newBuilder()
                      .setDefaultInstance(ClipAssetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateHlsUriRequest, GenerateHlsUriResponse>
      generateHlsUriMethodDescriptor =
          ApiMethodDescriptor.<GenerateHlsUriRequest, GenerateHlsUriResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GenerateHlsUri")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateHlsUriRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/assets/*}:generateHlsUri",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateHlsUriRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateHlsUriRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateHlsUriResponse>newBuilder()
                      .setDefaultInstance(GenerateHlsUriResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportAssetsRequest, Operation>
      importAssetsMethodDescriptor =
          ApiMethodDescriptor.<ImportAssetsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ImportAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/assets:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportAssetsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateSearchConfigRequest, SearchConfig>
      createSearchConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateSearchConfigRequest, SearchConfig>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateSearchConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSearchConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/searchConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "searchConfigId", request.getSearchConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchConfig", request.getSearchConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchConfig>newBuilder()
                      .setDefaultInstance(SearchConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSearchConfigRequest, SearchConfig>
      updateSearchConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateSearchConfigRequest, SearchConfig>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateSearchConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSearchConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{searchConfig.name=projects/*/locations/*/corpora/*/searchConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "searchConfig.name", request.getSearchConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchConfig", request.getSearchConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchConfig>newBuilder()
                      .setDefaultInstance(SearchConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSearchConfigRequest, SearchConfig>
      getSearchConfigMethodDescriptor =
          ApiMethodDescriptor.<GetSearchConfigRequest, SearchConfig>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetSearchConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSearchConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/searchConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchConfig>newBuilder()
                      .setDefaultInstance(SearchConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSearchConfigRequest, Empty>
      deleteSearchConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteSearchConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteSearchConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSearchConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/searchConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListSearchConfigsRequest, ListSearchConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListSearchConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSearchConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/searchConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSearchConfigsResponse>newBuilder()
                      .setDefaultInstance(ListSearchConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymMethodDescriptor =
          ApiMethodDescriptor.<CreateSearchHypernymRequest, SearchHypernym>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateSearchHypernym")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSearchHypernymRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/searchHypernyms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasSearchHypernymId()) {
                              serializer.putQueryParam(
                                  fields, "searchHypernymId", request.getSearchHypernymId());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchHypernym", request.getSearchHypernym(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchHypernym>newBuilder()
                      .setDefaultInstance(SearchHypernym.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymMethodDescriptor =
          ApiMethodDescriptor.<UpdateSearchHypernymRequest, SearchHypernym>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateSearchHypernym")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSearchHypernymRequest>newBuilder()
                      .setPath(
                          "/v1/{searchHypernym.name=projects/*/locations/*/corpora/*/searchHypernyms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "searchHypernym.name",
                                request.getSearchHypernym().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchHypernym", request.getSearchHypernym(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchHypernym>newBuilder()
                      .setDefaultInstance(SearchHypernym.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSearchHypernymRequest, SearchHypernym>
      getSearchHypernymMethodDescriptor =
          ApiMethodDescriptor.<GetSearchHypernymRequest, SearchHypernym>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetSearchHypernym")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSearchHypernymRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/searchHypernyms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchHypernym>newBuilder()
                      .setDefaultInstance(SearchHypernym.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSearchHypernymRequest, Empty>
      deleteSearchHypernymMethodDescriptor =
          ApiMethodDescriptor.<DeleteSearchHypernymRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteSearchHypernym")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSearchHypernymRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/searchHypernyms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchHypernymRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsMethodDescriptor =
          ApiMethodDescriptor.<ListSearchHypernymsRequest, ListSearchHypernymsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListSearchHypernyms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSearchHypernymsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/searchHypernyms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchHypernymsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchHypernymsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSearchHypernymsResponse>newBuilder()
                      .setDefaultInstance(ListSearchHypernymsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchAssetsRequest, SearchAssetsResponse>
      searchAssetsMethodDescriptor =
          ApiMethodDescriptor.<SearchAssetsRequest, SearchAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/SearchAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{corpus=projects/*/locations/*/corpora/*}:searchAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "corpus", request.getCorpus());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearCorpus().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAssetsResponse>newBuilder()
                      .setDefaultInstance(SearchAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointMethodDescriptor =
          ApiMethodDescriptor.<SearchIndexEndpointRequest, SearchIndexEndpointResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/SearchIndexEndpoint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchIndexEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{indexEndpoint=projects/*/locations/*/indexEndpoints/*}:searchIndexEndpoint",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "indexEndpoint", request.getIndexEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearIndexEndpoint().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchIndexEndpointResponse>newBuilder()
                      .setDefaultInstance(SearchIndexEndpointResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIndexEndpointRequest, Operation>
      createIndexEndpointMethodDescriptor =
          ApiMethodDescriptor.<CreateIndexEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateIndexEndpoint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIndexEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/indexEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "indexEndpointId", request.getIndexEndpointId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("indexEndpoint", request.getIndexEndpoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIndexEndpointRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIndexEndpointRequest, IndexEndpoint>
      getIndexEndpointMethodDescriptor =
          ApiMethodDescriptor.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetIndexEndpoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIndexEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/indexEndpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IndexEndpoint>newBuilder()
                      .setDefaultInstance(IndexEndpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsMethodDescriptor =
          ApiMethodDescriptor.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListIndexEndpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIndexEndpointsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/indexEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIndexEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIndexEndpointsResponse>newBuilder()
                      .setDefaultInstance(ListIndexEndpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIndexEndpointRequest, Operation>
      updateIndexEndpointMethodDescriptor =
          ApiMethodDescriptor.<UpdateIndexEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateIndexEndpoint")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIndexEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{indexEndpoint.name=projects/*/locations/*/indexEndpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "indexEndpoint.name", request.getIndexEndpoint().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("indexEndpoint", request.getIndexEndpoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateIndexEndpointRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteIndexEndpointRequest, Operation>
      deleteIndexEndpointMethodDescriptor =
          ApiMethodDescriptor.<DeleteIndexEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteIndexEndpoint")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIndexEndpointRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/indexEndpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIndexEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIndexEndpointRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployIndexRequest, Operation>
      deployIndexMethodDescriptor =
          ApiMethodDescriptor.<DeployIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeployIndex")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{indexEndpoint=projects/*/locations/*/indexEndpoints/*}:deployIndex",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "indexEndpoint", request.getIndexEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearIndexEndpoint().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeployIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeployIndexRequest, Operation>
      undeployIndexMethodDescriptor =
          ApiMethodDescriptor.<UndeployIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UndeployIndex")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployIndexRequest>newBuilder()
                      .setPath(
                          "/v1/{indexEndpoint=projects/*/locations/*/indexEndpoints/*}:undeployIndex",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "indexEndpoint", request.getIndexEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployIndexRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearIndexEndpoint().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeployIndexRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCollectionRequest, Operation>
      createCollectionMethodDescriptor =
          ApiMethodDescriptor.<CreateCollectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/CreateCollection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCollectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/collections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasCollectionId()) {
                              serializer.putQueryParam(
                                  fields, "collectionId", request.getCollectionId());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("collection", request.getCollection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCollectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCollectionRequest, Operation>
      deleteCollectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteCollectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/DeleteCollection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCollectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/collections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCollectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetCollectionRequest, Collection>
      getCollectionMethodDescriptor =
          ApiMethodDescriptor.<GetCollectionRequest, Collection>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/GetCollection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCollectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/corpora/*/collections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Collection>newBuilder()
                      .setDefaultInstance(Collection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCollectionRequest, Collection>
      updateCollectionMethodDescriptor =
          ApiMethodDescriptor.<UpdateCollectionRequest, Collection>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/UpdateCollection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCollectionRequest>newBuilder()
                      .setPath(
                          "/v1/{collection.name=projects/*/locations/*/corpora/*/collections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "collection.name", request.getCollection().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("collection", request.getCollection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Collection>newBuilder()
                      .setDefaultInstance(Collection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsMethodDescriptor =
          ApiMethodDescriptor.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ListCollections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCollectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/corpora/*}/collections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCollectionsResponse>newBuilder()
                      .setDefaultInstance(ListCollectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemMethodDescriptor =
          ApiMethodDescriptor.<AddCollectionItemRequest, AddCollectionItemResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/AddCollectionItem")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddCollectionItemRequest>newBuilder()
                      .setPath(
                          "/v1/{item.collection=projects/*/locations/*/corpora/*/collections/*}:addCollectionItem",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddCollectionItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "item.collection", request.getItem().getCollection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddCollectionItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AddCollectionItemResponse>newBuilder()
                      .setDefaultInstance(AddCollectionItemResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemMethodDescriptor =
          ApiMethodDescriptor
              .<RemoveCollectionItemRequest, RemoveCollectionItemResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/RemoveCollectionItem")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveCollectionItemRequest>newBuilder()
                      .setPath(
                          "/v1/{item.collection=projects/*/locations/*/corpora/*/collections/*}:removeCollectionItem",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveCollectionItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "item.collection", request.getItem().getCollection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveCollectionItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveCollectionItemResponse>newBuilder()
                      .setDefaultInstance(RemoveCollectionItemResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsMethodDescriptor =
          ApiMethodDescriptor.<ViewCollectionItemsRequest, ViewCollectionItemsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.Warehouse/ViewCollectionItems")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ViewCollectionItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{collection=projects/*/locations/*/corpora/*/collections/*}:viewCollectionItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ViewCollectionItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "collection", request.getCollection());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ViewCollectionItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ViewCollectionItemsResponse>newBuilder()
                      .setDefaultInstance(ViewCollectionItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWarehouseStub create(WarehouseStubSettings settings)
      throws IOException {
    return new HttpJsonWarehouseStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWarehouseStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonWarehouseStub(
        WarehouseStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWarehouseStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWarehouseStub(
        WarehouseStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWarehouseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWarehouseStub(WarehouseStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWarehouseCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWarehouseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWarehouseStub(
      WarehouseStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/warehouseOperations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/assets/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/imageIndexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/indexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/corpora/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/indexEndpoints/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateAssetRequest, Asset> createAssetTransportSettings =
        HttpJsonCallSettings.<CreateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(createAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAssetRequest, Asset> updateAssetTransportSettings =
        HttpJsonCallSettings.<UpdateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(updateAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("asset.name", String.valueOf(request.getAsset().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAssetRequest, Asset> getAssetTransportSettings =
        HttpJsonCallSettings.<GetAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(getAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        HttpJsonCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAssetRequest, Operation> deleteAssetTransportSettings =
        HttpJsonCallSettings.<DeleteAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UploadAssetRequest, Operation> uploadAssetTransportSettings =
        HttpJsonCallSettings.<UploadAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
        generateRetrievalUrlTransportSettings =
            HttpJsonCallSettings
                .<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>newBuilder()
                .setMethodDescriptor(generateRetrievalUrlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AnalyzeAssetRequest, Operation> analyzeAssetTransportSettings =
        HttpJsonCallSettings.<AnalyzeAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(analyzeAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<IndexAssetRequest, Operation> indexAssetTransportSettings =
        HttpJsonCallSettings.<IndexAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(indexAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveIndexAssetRequest, Operation> removeIndexAssetTransportSettings =
        HttpJsonCallSettings.<RemoveIndexAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(removeIndexAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
        viewIndexedAssetsTransportSettings =
            HttpJsonCallSettings.<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>newBuilder()
                .setMethodDescriptor(viewIndexedAssetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("index", String.valueOf(request.getIndex()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        HttpJsonCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateIndexRequest, Operation> updateIndexTransportSettings =
        HttpJsonCallSettings.<UpdateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index.name", String.valueOf(request.getIndex().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        HttpJsonCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        HttpJsonCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteIndexRequest, Operation> deleteIndexTransportSettings =
        HttpJsonCallSettings.<DeleteIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCorpusRequest, Operation> createCorpusTransportSettings =
        HttpJsonCallSettings.<CreateCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(createCorpusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCorpusRequest, Corpus> getCorpusTransportSettings =
        HttpJsonCallSettings.<GetCorpusRequest, Corpus>newBuilder()
            .setMethodDescriptor(getCorpusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateCorpusRequest, Corpus> updateCorpusTransportSettings =
        HttpJsonCallSettings.<UpdateCorpusRequest, Corpus>newBuilder()
            .setMethodDescriptor(updateCorpusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("corpus.name", String.valueOf(request.getCorpus().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCorporaRequest, ListCorporaResponse> listCorporaTransportSettings =
        HttpJsonCallSettings.<ListCorporaRequest, ListCorporaResponse>newBuilder()
            .setMethodDescriptor(listCorporaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCorpusRequest, Empty> deleteCorpusTransportSettings =
        HttpJsonCallSettings.<DeleteCorpusRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCorpusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AnalyzeCorpusRequest, Operation> analyzeCorpusTransportSettings =
        HttpJsonCallSettings.<AnalyzeCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(analyzeCorpusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDataSchemaRequest, DataSchema> createDataSchemaTransportSettings =
        HttpJsonCallSettings.<CreateDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(createDataSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataSchemaRequest, DataSchema> updateDataSchemaTransportSettings =
        HttpJsonCallSettings.<UpdateDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(updateDataSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_schema.name", String.valueOf(request.getDataSchema().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDataSchemaRequest, DataSchema> getDataSchemaTransportSettings =
        HttpJsonCallSettings.<GetDataSchemaRequest, DataSchema>newBuilder()
            .setMethodDescriptor(getDataSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataSchemaRequest, Empty> deleteDataSchemaTransportSettings =
        HttpJsonCallSettings.<DeleteDataSchemaRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataSchemasRequest, ListDataSchemasResponse>
        listDataSchemasTransportSettings =
            HttpJsonCallSettings.<ListDataSchemasRequest, ListDataSchemasResponse>newBuilder()
                .setMethodDescriptor(listDataSchemasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAnnotationRequest, Annotation> createAnnotationTransportSettings =
        HttpJsonCallSettings.<CreateAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(createAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAnnotationRequest, Annotation> getAnnotationTransportSettings =
        HttpJsonCallSettings.<GetAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(getAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAnnotationsRequest, ListAnnotationsResponse>
        listAnnotationsTransportSettings =
            HttpJsonCallSettings.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
                .setMethodDescriptor(listAnnotationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAnnotationRequest, Annotation> updateAnnotationTransportSettings =
        HttpJsonCallSettings.<UpdateAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(updateAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("annotation.name", String.valueOf(request.getAnnotation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAnnotationRequest, Empty> deleteAnnotationTransportSettings =
        HttpJsonCallSettings.<DeleteAnnotationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ClipAssetRequest, ClipAssetResponse> clipAssetTransportSettings =
        HttpJsonCallSettings.<ClipAssetRequest, ClipAssetResponse>newBuilder()
            .setMethodDescriptor(clipAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateHlsUriRequest, GenerateHlsUriResponse>
        generateHlsUriTransportSettings =
            HttpJsonCallSettings.<GenerateHlsUriRequest, GenerateHlsUriResponse>newBuilder()
                .setMethodDescriptor(generateHlsUriMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ImportAssetsRequest, Operation> importAssetsTransportSettings =
        HttpJsonCallSettings.<ImportAssetsRequest, Operation>newBuilder()
            .setMethodDescriptor(importAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSearchConfigRequest, SearchConfig>
        createSearchConfigTransportSettings =
            HttpJsonCallSettings.<CreateSearchConfigRequest, SearchConfig>newBuilder()
                .setMethodDescriptor(createSearchConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSearchConfigRequest, SearchConfig>
        updateSearchConfigTransportSettings =
            HttpJsonCallSettings.<UpdateSearchConfigRequest, SearchConfig>newBuilder()
                .setMethodDescriptor(updateSearchConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "search_config.name",
                          String.valueOf(request.getSearchConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSearchConfigRequest, SearchConfig> getSearchConfigTransportSettings =
        HttpJsonCallSettings.<GetSearchConfigRequest, SearchConfig>newBuilder()
            .setMethodDescriptor(getSearchConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSearchConfigRequest, Empty> deleteSearchConfigTransportSettings =
        HttpJsonCallSettings.<DeleteSearchConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSearchConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSearchConfigsRequest, ListSearchConfigsResponse>
        listSearchConfigsTransportSettings =
            HttpJsonCallSettings.<ListSearchConfigsRequest, ListSearchConfigsResponse>newBuilder()
                .setMethodDescriptor(listSearchConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSearchHypernymRequest, SearchHypernym>
        createSearchHypernymTransportSettings =
            HttpJsonCallSettings.<CreateSearchHypernymRequest, SearchHypernym>newBuilder()
                .setMethodDescriptor(createSearchHypernymMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSearchHypernymRequest, SearchHypernym>
        updateSearchHypernymTransportSettings =
            HttpJsonCallSettings.<UpdateSearchHypernymRequest, SearchHypernym>newBuilder()
                .setMethodDescriptor(updateSearchHypernymMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "search_hypernym.name",
                          String.valueOf(request.getSearchHypernym().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSearchHypernymRequest, SearchHypernym>
        getSearchHypernymTransportSettings =
            HttpJsonCallSettings.<GetSearchHypernymRequest, SearchHypernym>newBuilder()
                .setMethodDescriptor(getSearchHypernymMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymTransportSettings =
        HttpJsonCallSettings.<DeleteSearchHypernymRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSearchHypernymMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
        listSearchHypernymsTransportSettings =
            HttpJsonCallSettings
                .<ListSearchHypernymsRequest, ListSearchHypernymsResponse>newBuilder()
                .setMethodDescriptor(listSearchHypernymsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchAssetsRequest, SearchAssetsResponse> searchAssetsTransportSettings =
        HttpJsonCallSettings.<SearchAssetsRequest, SearchAssetsResponse>newBuilder()
            .setMethodDescriptor(searchAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("corpus", String.valueOf(request.getCorpus()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
        searchIndexEndpointTransportSettings =
            HttpJsonCallSettings
                .<SearchIndexEndpointRequest, SearchIndexEndpointResponse>newBuilder()
                .setMethodDescriptor(searchIndexEndpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateIndexEndpointRequest, Operation>
        createIndexEndpointTransportSettings =
            HttpJsonCallSettings.<CreateIndexEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(createIndexEndpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointTransportSettings =
        HttpJsonCallSettings.<GetIndexEndpointRequest, IndexEndpoint>newBuilder()
            .setMethodDescriptor(getIndexEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
        listIndexEndpointsTransportSettings =
            HttpJsonCallSettings.<ListIndexEndpointsRequest, ListIndexEndpointsResponse>newBuilder()
                .setMethodDescriptor(listIndexEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateIndexEndpointRequest, Operation>
        updateIndexEndpointTransportSettings =
            HttpJsonCallSettings.<UpdateIndexEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(updateIndexEndpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "index_endpoint.name",
                          String.valueOf(request.getIndexEndpoint().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointTransportSettings =
            HttpJsonCallSettings.<DeleteIndexEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteIndexEndpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeployIndexRequest, Operation> deployIndexTransportSettings =
        HttpJsonCallSettings.<DeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UndeployIndexRequest, Operation> undeployIndexTransportSettings =
        HttpJsonCallSettings.<UndeployIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIndexMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("index_endpoint", String.valueOf(request.getIndexEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCollectionRequest, Operation> createCollectionTransportSettings =
        HttpJsonCallSettings.<CreateCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createCollectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCollectionRequest, Operation> deleteCollectionTransportSettings =
        HttpJsonCallSettings.<DeleteCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCollectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCollectionRequest, Collection> getCollectionTransportSettings =
        HttpJsonCallSettings.<GetCollectionRequest, Collection>newBuilder()
            .setMethodDescriptor(getCollectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateCollectionRequest, Collection> updateCollectionTransportSettings =
        HttpJsonCallSettings.<UpdateCollectionRequest, Collection>newBuilder()
            .setMethodDescriptor(updateCollectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection.name", String.valueOf(request.getCollection().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCollectionsRequest, ListCollectionsResponse>
        listCollectionsTransportSettings =
            HttpJsonCallSettings.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
                .setMethodDescriptor(listCollectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AddCollectionItemRequest, AddCollectionItemResponse>
        addCollectionItemTransportSettings =
            HttpJsonCallSettings.<AddCollectionItemRequest, AddCollectionItemResponse>newBuilder()
                .setMethodDescriptor(addCollectionItemMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "item.collection", String.valueOf(request.getItem().getCollection()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
        removeCollectionItemTransportSettings =
            HttpJsonCallSettings
                .<RemoveCollectionItemRequest, RemoveCollectionItemResponse>newBuilder()
                .setMethodDescriptor(removeCollectionItemMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "item.collection", String.valueOf(request.getItem().getCollection()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
        viewCollectionItemsTransportSettings =
            HttpJsonCallSettings
                .<ViewCollectionItemsRequest, ViewCollectionItemsResponse>newBuilder()
                .setMethodDescriptor(viewCollectionItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.uploadAssetCallable =
        callableFactory.createUnaryCallable(
            uploadAssetTransportSettings, settings.uploadAssetSettings(), clientContext);
    this.uploadAssetOperationCallable =
        callableFactory.createOperationCallable(
            uploadAssetTransportSettings,
            settings.uploadAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.indexAssetCallable =
        callableFactory.createUnaryCallable(
            indexAssetTransportSettings, settings.indexAssetSettings(), clientContext);
    this.indexAssetOperationCallable =
        callableFactory.createOperationCallable(
            indexAssetTransportSettings,
            settings.indexAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeIndexAssetCallable =
        callableFactory.createUnaryCallable(
            removeIndexAssetTransportSettings, settings.removeIndexAssetSettings(), clientContext);
    this.removeIndexAssetOperationCallable =
        callableFactory.createOperationCallable(
            removeIndexAssetTransportSettings,
            settings.removeIndexAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateIndexCallable =
        callableFactory.createUnaryCallable(
            updateIndexTransportSettings, settings.updateIndexSettings(), clientContext);
    this.updateIndexOperationCallable =
        callableFactory.createOperationCallable(
            updateIndexTransportSettings,
            settings.updateIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.createCorpusCallable =
        callableFactory.createUnaryCallable(
            createCorpusTransportSettings, settings.createCorpusSettings(), clientContext);
    this.createCorpusOperationCallable =
        callableFactory.createOperationCallable(
            createCorpusTransportSettings,
            settings.createCorpusOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deployIndexCallable =
        callableFactory.createUnaryCallable(
            deployIndexTransportSettings, settings.deployIndexSettings(), clientContext);
    this.deployIndexOperationCallable =
        callableFactory.createOperationCallable(
            deployIndexTransportSettings,
            settings.deployIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeployIndexCallable =
        callableFactory.createUnaryCallable(
            undeployIndexTransportSettings, settings.undeployIndexSettings(), clientContext);
    this.undeployIndexOperationCallable =
        callableFactory.createOperationCallable(
            undeployIndexTransportSettings,
            settings.undeployIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createCollectionCallable =
        callableFactory.createUnaryCallable(
            createCollectionTransportSettings, settings.createCollectionSettings(), clientContext);
    this.createCollectionOperationCallable =
        callableFactory.createOperationCallable(
            createCollectionTransportSettings,
            settings.createCollectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCollectionCallable =
        callableFactory.createUnaryCallable(
            deleteCollectionTransportSettings, settings.deleteCollectionSettings(), clientContext);
    this.deleteCollectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteCollectionTransportSettings,
            settings.deleteCollectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAssetMethodDescriptor);
    methodDescriptors.add(updateAssetMethodDescriptor);
    methodDescriptors.add(getAssetMethodDescriptor);
    methodDescriptors.add(listAssetsMethodDescriptor);
    methodDescriptors.add(deleteAssetMethodDescriptor);
    methodDescriptors.add(uploadAssetMethodDescriptor);
    methodDescriptors.add(generateRetrievalUrlMethodDescriptor);
    methodDescriptors.add(analyzeAssetMethodDescriptor);
    methodDescriptors.add(indexAssetMethodDescriptor);
    methodDescriptors.add(removeIndexAssetMethodDescriptor);
    methodDescriptors.add(viewIndexedAssetsMethodDescriptor);
    methodDescriptors.add(createIndexMethodDescriptor);
    methodDescriptors.add(updateIndexMethodDescriptor);
    methodDescriptors.add(getIndexMethodDescriptor);
    methodDescriptors.add(listIndexesMethodDescriptor);
    methodDescriptors.add(deleteIndexMethodDescriptor);
    methodDescriptors.add(createCorpusMethodDescriptor);
    methodDescriptors.add(getCorpusMethodDescriptor);
    methodDescriptors.add(updateCorpusMethodDescriptor);
    methodDescriptors.add(listCorporaMethodDescriptor);
    methodDescriptors.add(deleteCorpusMethodDescriptor);
    methodDescriptors.add(analyzeCorpusMethodDescriptor);
    methodDescriptors.add(createDataSchemaMethodDescriptor);
    methodDescriptors.add(updateDataSchemaMethodDescriptor);
    methodDescriptors.add(getDataSchemaMethodDescriptor);
    methodDescriptors.add(deleteDataSchemaMethodDescriptor);
    methodDescriptors.add(listDataSchemasMethodDescriptor);
    methodDescriptors.add(createAnnotationMethodDescriptor);
    methodDescriptors.add(getAnnotationMethodDescriptor);
    methodDescriptors.add(listAnnotationsMethodDescriptor);
    methodDescriptors.add(updateAnnotationMethodDescriptor);
    methodDescriptors.add(deleteAnnotationMethodDescriptor);
    methodDescriptors.add(clipAssetMethodDescriptor);
    methodDescriptors.add(generateHlsUriMethodDescriptor);
    methodDescriptors.add(importAssetsMethodDescriptor);
    methodDescriptors.add(createSearchConfigMethodDescriptor);
    methodDescriptors.add(updateSearchConfigMethodDescriptor);
    methodDescriptors.add(getSearchConfigMethodDescriptor);
    methodDescriptors.add(deleteSearchConfigMethodDescriptor);
    methodDescriptors.add(listSearchConfigsMethodDescriptor);
    methodDescriptors.add(createSearchHypernymMethodDescriptor);
    methodDescriptors.add(updateSearchHypernymMethodDescriptor);
    methodDescriptors.add(getSearchHypernymMethodDescriptor);
    methodDescriptors.add(deleteSearchHypernymMethodDescriptor);
    methodDescriptors.add(listSearchHypernymsMethodDescriptor);
    methodDescriptors.add(searchAssetsMethodDescriptor);
    methodDescriptors.add(searchIndexEndpointMethodDescriptor);
    methodDescriptors.add(createIndexEndpointMethodDescriptor);
    methodDescriptors.add(getIndexEndpointMethodDescriptor);
    methodDescriptors.add(listIndexEndpointsMethodDescriptor);
    methodDescriptors.add(updateIndexEndpointMethodDescriptor);
    methodDescriptors.add(deleteIndexEndpointMethodDescriptor);
    methodDescriptors.add(deployIndexMethodDescriptor);
    methodDescriptors.add(undeployIndexMethodDescriptor);
    methodDescriptors.add(createCollectionMethodDescriptor);
    methodDescriptors.add(deleteCollectionMethodDescriptor);
    methodDescriptors.add(getCollectionMethodDescriptor);
    methodDescriptors.add(updateCollectionMethodDescriptor);
    methodDescriptors.add(listCollectionsMethodDescriptor);
    methodDescriptors.add(addCollectionItemMethodDescriptor);
    methodDescriptors.add(removeCollectionItemMethodDescriptor);
    methodDescriptors.add(viewCollectionItemsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> ingestAssetCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: ingestAssetCallable(). REST transport is not implemented for this method yet.");
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
