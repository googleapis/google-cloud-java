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

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
 * REST stub implementation for the VectorSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonVectorSearchServiceStub extends VectorSearchServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Collection.getDescriptor())
          .add(Empty.getDescriptor())
          .add(ExportDataObjectsMetadata.getDescriptor())
          .add(ImportDataObjectsMetadata.getDescriptor())
          .add(Index.getDescriptor())
          .add(ExportDataObjectsResponse.getDescriptor())
          .add(ImportDataObjectsResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsMethodDescriptor =
          ApiMethodDescriptor.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/ListCollections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCollectionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/collections",
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
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetCollectionRequest, Collection>
      getCollectionMethodDescriptor =
          ApiMethodDescriptor.<GetCollectionRequest, Collection>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/GetCollection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCollectionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*}",
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

  private static final ApiMethodDescriptor<CreateCollectionRequest, Operation>
      createCollectionMethodDescriptor =
          ApiMethodDescriptor.<CreateCollectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/CreateCollection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCollectionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/collections",
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
                            serializer.putQueryParam(
                                fields, "collectionId", request.getCollectionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<UpdateCollectionRequest, Operation>
      updateCollectionMethodDescriptor =
          ApiMethodDescriptor.<UpdateCollectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/UpdateCollection")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCollectionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{collection.name=projects/*/locations/*/collections/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCollectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCollectionRequest, Operation>
      deleteCollectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteCollectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/DeleteCollection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCollectionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          ApiMethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/ListIndexes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIndexesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/indexes",
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
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      ApiMethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/GetIndex")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetIndexRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/collections/*/indexes/*}",
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

  private static final ApiMethodDescriptor<CreateIndexRequest, Operation>
      createIndexMethodDescriptor =
          ApiMethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/CreateIndex")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIndexRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/indexes",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<DeleteIndexRequest, Operation>
      deleteIndexMethodDescriptor =
          ApiMethodDescriptor.<DeleteIndexRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/DeleteIndex")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIndexRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*/indexes/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<ImportDataObjectsRequest, Operation>
      importDataObjectsMethodDescriptor =
          ApiMethodDescriptor.<ImportDataObjectsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/ImportDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*}:importDataObjects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataObjectsRequest> serializer =
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
                  (ImportDataObjectsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportDataObjectsRequest, Operation>
      exportDataObjectsMethodDescriptor =
          ApiMethodDescriptor.<ExportDataObjectsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/ExportDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/collections/*}:exportDataObjects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataObjectsRequest> serializer =
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
                  (ExportDataObjectsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsCallable;
  private final UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable;
  private final UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable;
  private final UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable;
  private final OperationCallable<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationCallable;
  private final UnaryCallable<UpdateCollectionRequest, Operation> updateCollectionCallable;
  private final OperationCallable<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationCallable;
  private final UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable;
  private final OperationCallable<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final OperationCallable<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationCallable;
  private final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable;
  private final OperationCallable<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationCallable;
  private final UnaryCallable<ImportDataObjectsRequest, Operation> importDataObjectsCallable;
  private final OperationCallable<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationCallable;
  private final UnaryCallable<ExportDataObjectsRequest, Operation> exportDataObjectsCallable;
  private final OperationCallable<
          ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
      exportDataObjectsOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVectorSearchServiceStub create(
      VectorSearchServiceStubSettings settings) throws IOException {
    return new HttpJsonVectorSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVectorSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVectorSearchServiceStub(
        VectorSearchServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVectorSearchServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVectorSearchServiceStub(
        VectorSearchServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVectorSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVectorSearchServiceStub(
      VectorSearchServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonVectorSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVectorSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVectorSearchServiceStub(
      VectorSearchServiceStubSettings settings,
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
                        .setPost("/v1beta/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

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
    HttpJsonCallSettings<UpdateCollectionRequest, Operation> updateCollectionTransportSettings =
        HttpJsonCallSettings.<UpdateCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCollectionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection.name", String.valueOf(request.getCollection().getName()));
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
    HttpJsonCallSettings<ImportDataObjectsRequest, Operation> importDataObjectsTransportSettings =
        HttpJsonCallSettings.<ImportDataObjectsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataObjectsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportDataObjectsRequest, Operation> exportDataObjectsTransportSettings =
        HttpJsonCallSettings.<ExportDataObjectsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataObjectsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listCollectionsCallable =
        callableFactory.createUnaryCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.listCollectionsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.getCollectionCallable =
        callableFactory.createUnaryCallable(
            getCollectionTransportSettings, settings.getCollectionSettings(), clientContext);
    this.createCollectionCallable =
        callableFactory.createUnaryCallable(
            createCollectionTransportSettings, settings.createCollectionSettings(), clientContext);
    this.createCollectionOperationCallable =
        callableFactory.createOperationCallable(
            createCollectionTransportSettings,
            settings.createCollectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateCollectionCallable =
        callableFactory.createUnaryCallable(
            updateCollectionTransportSettings, settings.updateCollectionSettings(), clientContext);
    this.updateCollectionOperationCallable =
        callableFactory.createOperationCallable(
            updateCollectionTransportSettings,
            settings.updateCollectionOperationSettings(),
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
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.createIndexOperationCallable =
        callableFactory.createOperationCallable(
            createIndexTransportSettings,
            settings.createIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.deleteIndexOperationCallable =
        callableFactory.createOperationCallable(
            deleteIndexTransportSettings,
            settings.deleteIndexOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importDataObjectsCallable =
        callableFactory.createUnaryCallable(
            importDataObjectsTransportSettings,
            settings.importDataObjectsSettings(),
            clientContext);
    this.importDataObjectsOperationCallable =
        callableFactory.createOperationCallable(
            importDataObjectsTransportSettings,
            settings.importDataObjectsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportDataObjectsCallable =
        callableFactory.createUnaryCallable(
            exportDataObjectsTransportSettings,
            settings.exportDataObjectsSettings(),
            clientContext);
    this.exportDataObjectsOperationCallable =
        callableFactory.createOperationCallable(
            exportDataObjectsTransportSettings,
            settings.exportDataObjectsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCollectionsMethodDescriptor);
    methodDescriptors.add(getCollectionMethodDescriptor);
    methodDescriptors.add(createCollectionMethodDescriptor);
    methodDescriptors.add(updateCollectionMethodDescriptor);
    methodDescriptors.add(deleteCollectionMethodDescriptor);
    methodDescriptors.add(listIndexesMethodDescriptor);
    methodDescriptors.add(getIndexMethodDescriptor);
    methodDescriptors.add(createIndexMethodDescriptor);
    methodDescriptors.add(deleteIndexMethodDescriptor);
    methodDescriptors.add(importDataObjectsMethodDescriptor);
    methodDescriptors.add(exportDataObjectsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    return getCollectionCallable;
  }

  @Override
  public UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    return createCollectionCallable;
  }

  @Override
  public OperationCallable<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationCallable() {
    return createCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCollectionRequest, Operation> updateCollectionCallable() {
    return updateCollectionCallable;
  }

  @Override
  public OperationCallable<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationCallable() {
    return updateCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    return deleteCollectionCallable;
  }

  @Override
  public OperationCallable<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationCallable() {
    return deleteCollectionOperationCallable;
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
  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  @Override
  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  @Override
  public OperationCallable<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationCallable() {
    return createIndexOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  @Override
  public OperationCallable<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationCallable() {
    return deleteIndexOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataObjectsRequest, Operation> importDataObjectsCallable() {
    return importDataObjectsCallable;
  }

  @Override
  public OperationCallable<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationCallable() {
    return importDataObjectsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataObjectsRequest, Operation> exportDataObjectsCallable() {
    return exportDataObjectsCallable;
  }

  @Override
  public OperationCallable<
          ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
      exportDataObjectsOperationCallable() {
    return exportDataObjectsOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
