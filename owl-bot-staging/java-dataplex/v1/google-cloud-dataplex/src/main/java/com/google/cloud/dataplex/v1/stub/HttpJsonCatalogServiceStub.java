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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.AspectType;
import com.google.cloud.dataplex.v1.CreateAspectTypeRequest;
import com.google.cloud.dataplex.v1.CreateEntryGroupRequest;
import com.google.cloud.dataplex.v1.CreateEntryRequest;
import com.google.cloud.dataplex.v1.CreateEntryTypeRequest;
import com.google.cloud.dataplex.v1.DeleteAspectTypeRequest;
import com.google.cloud.dataplex.v1.DeleteEntryGroupRequest;
import com.google.cloud.dataplex.v1.DeleteEntryRequest;
import com.google.cloud.dataplex.v1.DeleteEntryTypeRequest;
import com.google.cloud.dataplex.v1.Entry;
import com.google.cloud.dataplex.v1.EntryGroup;
import com.google.cloud.dataplex.v1.EntryType;
import com.google.cloud.dataplex.v1.GetAspectTypeRequest;
import com.google.cloud.dataplex.v1.GetEntryGroupRequest;
import com.google.cloud.dataplex.v1.GetEntryRequest;
import com.google.cloud.dataplex.v1.GetEntryTypeRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesResponse;
import com.google.cloud.dataplex.v1.ListEntriesRequest;
import com.google.cloud.dataplex.v1.ListEntriesResponse;
import com.google.cloud.dataplex.v1.ListEntryGroupsRequest;
import com.google.cloud.dataplex.v1.ListEntryGroupsResponse;
import com.google.cloud.dataplex.v1.ListEntryTypesRequest;
import com.google.cloud.dataplex.v1.ListEntryTypesResponse;
import com.google.cloud.dataplex.v1.LookupEntryRequest;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.SearchEntriesRequest;
import com.google.cloud.dataplex.v1.SearchEntriesResponse;
import com.google.cloud.dataplex.v1.UpdateAspectTypeRequest;
import com.google.cloud.dataplex.v1.UpdateEntryGroupRequest;
import com.google.cloud.dataplex.v1.UpdateEntryRequest;
import com.google.cloud.dataplex.v1.UpdateEntryTypeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCatalogServiceStub extends CatalogServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(AspectType.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(EntryGroup.getDescriptor())
          .add(EntryType.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateEntryTypeRequest, Operation>
      createEntryTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateEntryTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntryType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntryTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "entryTypeId", request.getEntryTypeId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryType", request.getEntryType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEntryTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEntryTypeRequest, Operation>
      updateEntryTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntryTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntryType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntryTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{entryType.name=projects/*/locations/*/entryTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entryType.name", request.getEntryType().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryType", request.getEntryType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEntryTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEntryTypeRequest, Operation>
      deleteEntryTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntryTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntryType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntryTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteEntryTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListEntryTypesRequest, ListEntryTypesResponse>
      listEntryTypesMethodDescriptor =
          ApiMethodDescriptor.<ListEntryTypesRequest, ListEntryTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntryTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntryTypesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryTypesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntryTypesResponse>newBuilder()
                      .setDefaultInstance(ListEntryTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntryTypeRequest, EntryType>
      getEntryTypeMethodDescriptor =
          ApiMethodDescriptor.<GetEntryTypeRequest, EntryType>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntryType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntryTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryType>newBuilder()
                      .setDefaultInstance(EntryType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAspectTypeRequest, Operation>
      createAspectTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateAspectTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateAspectType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAspectTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/aspectTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "aspectTypeId", request.getAspectTypeId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("aspectType", request.getAspectType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAspectTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAspectTypeRequest, Operation>
      updateAspectTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateAspectTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateAspectType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAspectTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{aspectType.name=projects/*/locations/*/aspectTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "aspectType.name", request.getAspectType().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("aspectType", request.getAspectType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAspectTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAspectTypeRequest, Operation>
      deleteAspectTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteAspectTypeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteAspectType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAspectTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aspectTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteAspectTypeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAspectTypesRequest, ListAspectTypesResponse>
      listAspectTypesMethodDescriptor =
          ApiMethodDescriptor.<ListAspectTypesRequest, ListAspectTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListAspectTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAspectTypesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/aspectTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAspectTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAspectTypesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAspectTypesResponse>newBuilder()
                      .setDefaultInstance(ListAspectTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAspectTypeRequest, AspectType>
      getAspectTypeMethodDescriptor =
          ApiMethodDescriptor.<GetAspectTypeRequest, AspectType>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetAspectType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAspectTypeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/aspectTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAspectTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AspectType>newBuilder()
                      .setDefaultInstance(AspectType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntryGroupRequest, Operation>
      createEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateEntryGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntryGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "entryGroupId", request.getEntryGroupId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryGroup", request.getEntryGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEntryGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEntryGroupRequest, Operation>
      updateEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntryGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntryGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{entryGroup.name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entryGroup.name", request.getEntryGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryGroup", request.getEntryGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEntryGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEntryGroupRequest, Operation>
      deleteEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntryGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntryGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteEntryGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntryGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntryGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntryGroupsResponse>newBuilder()
                      .setDefaultInstance(ListEntryGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntryGroupRequest, EntryGroup>
      getEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<GetEntryGroupRequest, EntryGroup>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntryGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryGroup>newBuilder()
                      .setDefaultInstance(EntryGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntryRequest, Entry> createEntryMethodDescriptor =
      ApiMethodDescriptor.<CreateEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntry")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/entryGroups/*}/entries",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "entryId", request.getEntryId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("entry", request.getEntry(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateEntryRequest, Entry> updateEntryMethodDescriptor =
      ApiMethodDescriptor.<UpdateEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntry")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{entry.name=projects/*/locations/*/entryGroups/*/entries/**}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "entry.name", request.getEntry().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
                        serializer.putQueryParam(fields, "aspectKeys", request.getAspectKeysList());
                        serializer.putQueryParam(
                            fields, "deleteMissingAspects", request.getDeleteMissingAspects());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("entry", request.getEntry(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteEntryRequest, Entry> deleteEntryMethodDescriptor =
      ApiMethodDescriptor.<DeleteEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntry")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entryGroups/*/entries/**}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEntriesRequest, ListEntriesResponse>
      listEntriesMethodDescriptor =
          ApiMethodDescriptor.<ListEntriesRequest, ListEntriesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/entryGroups/*}/entries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntriesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntriesResponse>newBuilder()
                      .setDefaultInstance(ListEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntryRequest, Entry> getEntryMethodDescriptor =
      ApiMethodDescriptor.<GetEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntry")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entryGroups/*/entries/**}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(
                            fields, "aspectTypes", request.getAspectTypesList());
                        serializer.putQueryParam(fields, "paths", request.getPathsList());
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<LookupEntryRequest, Entry> lookupEntryMethodDescriptor =
      ApiMethodDescriptor.<LookupEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/LookupEntry")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<LookupEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*}:lookupEntry",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<LookupEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<LookupEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(
                            fields, "aspectTypes", request.getAspectTypesList());
                        serializer.putQueryParam(fields, "entry", request.getEntry());
                        serializer.putQueryParam(fields, "paths", request.getPathsList());
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SearchEntriesRequest, SearchEntriesResponse>
      searchEntriesMethodDescriptor =
          ApiMethodDescriptor.<SearchEntriesRequest, SearchEntriesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/SearchEntries")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchEntriesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}:searchEntries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "scope", request.getScope());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchEntriesResponse>newBuilder()
                      .setDefaultInstance(SearchEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable;
  private final OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable;
  private final UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable;
  private final OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable;
  private final UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable;
  private final OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable;
  private final UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> listEntryTypesCallable;
  private final UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable;
  private final UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable;
  private final UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable;
  private final OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable;
  private final UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable;
  private final OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable;
  private final UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable;
  private final OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable;
  private final UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse>
      listAspectTypesCallable;
  private final UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable;
  private final UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable;
  private final UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable;
  private final OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable;
  private final UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable;
  private final OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable;
  private final UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable;
  private final OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable;
  private final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable;
  private final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable;
  private final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable;
  private final UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable;
  private final UnaryCallable<GetEntryRequest, Entry> getEntryCallable;
  private final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable;
  private final UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable;
  private final UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCatalogServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings,
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
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateEntryTypeRequest, Operation> createEntryTypeTransportSettings =
        HttpJsonCallSettings.<CreateEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntryTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEntryTypeRequest, Operation> updateEntryTypeTransportSettings =
        HttpJsonCallSettings.<UpdateEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntryTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("entry_type.name", String.valueOf(request.getEntryType().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntryTypeRequest, Operation> deleteEntryTypeTransportSettings =
        HttpJsonCallSettings.<DeleteEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntryTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEntryTypesRequest, ListEntryTypesResponse>
        listEntryTypesTransportSettings =
            HttpJsonCallSettings.<ListEntryTypesRequest, ListEntryTypesResponse>newBuilder()
                .setMethodDescriptor(listEntryTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEntryTypeRequest, EntryType> getEntryTypeTransportSettings =
        HttpJsonCallSettings.<GetEntryTypeRequest, EntryType>newBuilder()
            .setMethodDescriptor(getEntryTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAspectTypeRequest, Operation> createAspectTypeTransportSettings =
        HttpJsonCallSettings.<CreateAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(createAspectTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAspectTypeRequest, Operation> updateAspectTypeTransportSettings =
        HttpJsonCallSettings.<UpdateAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAspectTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "aspect_type.name", String.valueOf(request.getAspectType().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAspectTypeRequest, Operation> deleteAspectTypeTransportSettings =
        HttpJsonCallSettings.<DeleteAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAspectTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAspectTypesRequest, ListAspectTypesResponse>
        listAspectTypesTransportSettings =
            HttpJsonCallSettings.<ListAspectTypesRequest, ListAspectTypesResponse>newBuilder()
                .setMethodDescriptor(listAspectTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAspectTypeRequest, AspectType> getAspectTypeTransportSettings =
        HttpJsonCallSettings.<GetAspectTypeRequest, AspectType>newBuilder()
            .setMethodDescriptor(getAspectTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEntryGroupRequest, Operation> createEntryGroupTransportSettings =
        HttpJsonCallSettings.<CreateEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEntryGroupRequest, Operation> updateEntryGroupTransportSettings =
        HttpJsonCallSettings.<UpdateEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "entry_group.name", String.valueOf(request.getEntryGroup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntryGroupRequest, Operation> deleteEntryGroupTransportSettings =
        HttpJsonCallSettings.<DeleteEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEntryGroupsRequest, ListEntryGroupsResponse>
        listEntryGroupsTransportSettings =
            HttpJsonCallSettings.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
                .setMethodDescriptor(listEntryGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupTransportSettings =
        HttpJsonCallSettings.<GetEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(getEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEntryRequest, Entry> createEntryTransportSettings =
        HttpJsonCallSettings.<CreateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(createEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEntryRequest, Entry> updateEntryTransportSettings =
        HttpJsonCallSettings.<UpdateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(updateEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("entry.name", String.valueOf(request.getEntry().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntryRequest, Entry> deleteEntryTransportSettings =
        HttpJsonCallSettings.<DeleteEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(deleteEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEntriesRequest, ListEntriesResponse> listEntriesTransportSettings =
        HttpJsonCallSettings.<ListEntriesRequest, ListEntriesResponse>newBuilder()
            .setMethodDescriptor(listEntriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEntryRequest, Entry> getEntryTransportSettings =
        HttpJsonCallSettings.<GetEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(getEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<LookupEntryRequest, Entry> lookupEntryTransportSettings =
        HttpJsonCallSettings.<LookupEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(lookupEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchEntriesRequest, SearchEntriesResponse>
        searchEntriesTransportSettings =
            HttpJsonCallSettings.<SearchEntriesRequest, SearchEntriesResponse>newBuilder()
                .setMethodDescriptor(searchEntriesMethodDescriptor)
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

    this.createEntryTypeCallable =
        callableFactory.createUnaryCallable(
            createEntryTypeTransportSettings, settings.createEntryTypeSettings(), clientContext);
    this.createEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            createEntryTypeTransportSettings,
            settings.createEntryTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEntryTypeCallable =
        callableFactory.createUnaryCallable(
            updateEntryTypeTransportSettings, settings.updateEntryTypeSettings(), clientContext);
    this.updateEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            updateEntryTypeTransportSettings,
            settings.updateEntryTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEntryTypeCallable =
        callableFactory.createUnaryCallable(
            deleteEntryTypeTransportSettings, settings.deleteEntryTypeSettings(), clientContext);
    this.deleteEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            deleteEntryTypeTransportSettings,
            settings.deleteEntryTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEntryTypesCallable =
        callableFactory.createUnaryCallable(
            listEntryTypesTransportSettings, settings.listEntryTypesSettings(), clientContext);
    this.listEntryTypesPagedCallable =
        callableFactory.createPagedCallable(
            listEntryTypesTransportSettings, settings.listEntryTypesSettings(), clientContext);
    this.getEntryTypeCallable =
        callableFactory.createUnaryCallable(
            getEntryTypeTransportSettings, settings.getEntryTypeSettings(), clientContext);
    this.createAspectTypeCallable =
        callableFactory.createUnaryCallable(
            createAspectTypeTransportSettings, settings.createAspectTypeSettings(), clientContext);
    this.createAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            createAspectTypeTransportSettings,
            settings.createAspectTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAspectTypeCallable =
        callableFactory.createUnaryCallable(
            updateAspectTypeTransportSettings, settings.updateAspectTypeSettings(), clientContext);
    this.updateAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            updateAspectTypeTransportSettings,
            settings.updateAspectTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAspectTypeCallable =
        callableFactory.createUnaryCallable(
            deleteAspectTypeTransportSettings, settings.deleteAspectTypeSettings(), clientContext);
    this.deleteAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            deleteAspectTypeTransportSettings,
            settings.deleteAspectTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAspectTypesCallable =
        callableFactory.createUnaryCallable(
            listAspectTypesTransportSettings, settings.listAspectTypesSettings(), clientContext);
    this.listAspectTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAspectTypesTransportSettings, settings.listAspectTypesSettings(), clientContext);
    this.getAspectTypeCallable =
        callableFactory.createUnaryCallable(
            getAspectTypeTransportSettings, settings.getAspectTypeSettings(), clientContext);
    this.createEntryGroupCallable =
        callableFactory.createUnaryCallable(
            createEntryGroupTransportSettings, settings.createEntryGroupSettings(), clientContext);
    this.createEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            createEntryGroupTransportSettings,
            settings.createEntryGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEntryGroupCallable =
        callableFactory.createUnaryCallable(
            updateEntryGroupTransportSettings, settings.updateEntryGroupSettings(), clientContext);
    this.updateEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateEntryGroupTransportSettings,
            settings.updateEntryGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEntryGroupCallable =
        callableFactory.createUnaryCallable(
            deleteEntryGroupTransportSettings, settings.deleteEntryGroupSettings(), clientContext);
    this.deleteEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteEntryGroupTransportSettings,
            settings.deleteEntryGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEntryGroupsCallable =
        callableFactory.createUnaryCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.listEntryGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.getEntryGroupCallable =
        callableFactory.createUnaryCallable(
            getEntryGroupTransportSettings, settings.getEntryGroupSettings(), clientContext);
    this.createEntryCallable =
        callableFactory.createUnaryCallable(
            createEntryTransportSettings, settings.createEntrySettings(), clientContext);
    this.updateEntryCallable =
        callableFactory.createUnaryCallable(
            updateEntryTransportSettings, settings.updateEntrySettings(), clientContext);
    this.deleteEntryCallable =
        callableFactory.createUnaryCallable(
            deleteEntryTransportSettings, settings.deleteEntrySettings(), clientContext);
    this.listEntriesCallable =
        callableFactory.createUnaryCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.listEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.getEntryCallable =
        callableFactory.createUnaryCallable(
            getEntryTransportSettings, settings.getEntrySettings(), clientContext);
    this.lookupEntryCallable =
        callableFactory.createUnaryCallable(
            lookupEntryTransportSettings, settings.lookupEntrySettings(), clientContext);
    this.searchEntriesCallable =
        callableFactory.createUnaryCallable(
            searchEntriesTransportSettings, settings.searchEntriesSettings(), clientContext);
    this.searchEntriesPagedCallable =
        callableFactory.createPagedCallable(
            searchEntriesTransportSettings, settings.searchEntriesSettings(), clientContext);
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
    methodDescriptors.add(createEntryTypeMethodDescriptor);
    methodDescriptors.add(updateEntryTypeMethodDescriptor);
    methodDescriptors.add(deleteEntryTypeMethodDescriptor);
    methodDescriptors.add(listEntryTypesMethodDescriptor);
    methodDescriptors.add(getEntryTypeMethodDescriptor);
    methodDescriptors.add(createAspectTypeMethodDescriptor);
    methodDescriptors.add(updateAspectTypeMethodDescriptor);
    methodDescriptors.add(deleteAspectTypeMethodDescriptor);
    methodDescriptors.add(listAspectTypesMethodDescriptor);
    methodDescriptors.add(getAspectTypeMethodDescriptor);
    methodDescriptors.add(createEntryGroupMethodDescriptor);
    methodDescriptors.add(updateEntryGroupMethodDescriptor);
    methodDescriptors.add(deleteEntryGroupMethodDescriptor);
    methodDescriptors.add(listEntryGroupsMethodDescriptor);
    methodDescriptors.add(getEntryGroupMethodDescriptor);
    methodDescriptors.add(createEntryMethodDescriptor);
    methodDescriptors.add(updateEntryMethodDescriptor);
    methodDescriptors.add(deleteEntryMethodDescriptor);
    methodDescriptors.add(listEntriesMethodDescriptor);
    methodDescriptors.add(getEntryMethodDescriptor);
    methodDescriptors.add(lookupEntryMethodDescriptor);
    methodDescriptors.add(searchEntriesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable() {
    return createEntryTypeCallable;
  }

  @Override
  public OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable() {
    return createEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable() {
    return updateEntryTypeCallable;
  }

  @Override
  public OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable() {
    return updateEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable() {
    return deleteEntryTypeCallable;
  }

  @Override
  public OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable() {
    return deleteEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> listEntryTypesCallable() {
    return listEntryTypesCallable;
  }

  @Override
  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable() {
    return listEntryTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable() {
    return getEntryTypeCallable;
  }

  @Override
  public UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable() {
    return createAspectTypeCallable;
  }

  @Override
  public OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable() {
    return createAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable() {
    return updateAspectTypeCallable;
  }

  @Override
  public OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable() {
    return updateAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable() {
    return deleteAspectTypeCallable;
  }

  @Override
  public OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable() {
    return deleteAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse> listAspectTypesCallable() {
    return listAspectTypesCallable;
  }

  @Override
  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable() {
    return listAspectTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable() {
    return getAspectTypeCallable;
  }

  @Override
  public UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable() {
    return createEntryGroupCallable;
  }

  @Override
  public OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable() {
    return createEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable() {
    return updateEntryGroupCallable;
  }

  @Override
  public OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable() {
    return updateEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable() {
    return deleteEntryGroupCallable;
  }

  @Override
  public OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable() {
    return deleteEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    return listEntryGroupsCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return listEntryGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return getEntryGroupCallable;
  }

  @Override
  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return createEntryCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return updateEntryCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable() {
    return deleteEntryCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return listEntriesCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    return listEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return getEntryCallable;
  }

  @Override
  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return lookupEntryCallable;
  }

  @Override
  public UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable() {
    return searchEntriesCallable;
  }

  @Override
  public UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable() {
    return searchEntriesPagedCallable;
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
