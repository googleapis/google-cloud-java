/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.CreateDataAttributeRequest;
import com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.DataAttribute;
import com.google.cloud.dataplex.v1.DataAttributeBinding;
import com.google.cloud.dataplex.v1.DataTaxonomy;
import com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.DeleteDataAttributeRequest;
import com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeRequest;
import com.google.cloud.dataplex.v1.GetDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse;
import com.google.cloud.dataplex.v1.ListDataAttributesRequest;
import com.google.cloud.dataplex.v1.ListDataAttributesResponse;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.UpdateDataAttributeRequest;
import com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest;
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
 * REST stub implementation for the DataTaxonomyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDataTaxonomyServiceStub extends DataTaxonomyServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DataAttribute.getDescriptor())
          .add(DataAttributeBinding.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(DataTaxonomy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDataTaxonomyRequest, Operation>
      createDataTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<CreateDataTaxonomyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/CreateDataTaxonomy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataTaxonomies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataTaxonomyId", request.getDataTaxonomyId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataTaxonomy", request.getDataTaxonomy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataTaxonomyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataTaxonomyRequest, Operation>
      updateDataTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataTaxonomyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataTaxonomy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{dataTaxonomy.name=projects/*/locations/*/dataTaxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataTaxonomy.name", request.getDataTaxonomy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataTaxonomyRequest> serializer =
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
                                  .toBody("dataTaxonomy", request.getDataTaxonomy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataTaxonomyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataTaxonomyRequest, Operation>
      deleteDataTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataTaxonomyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataTaxonomy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataTaxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataTaxonomyRequest> serializer =
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
                  (DeleteDataTaxonomyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesMethodDescriptor =
          ApiMethodDescriptor.<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/ListDataTaxonomies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataTaxonomiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataTaxonomies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataTaxonomiesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataTaxonomiesResponse>newBuilder()
                      .setDefaultInstance(ListDataTaxonomiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataTaxonomyRequest, DataTaxonomy>
      getDataTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<GetDataTaxonomyRequest, DataTaxonomy>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/GetDataTaxonomy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataTaxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataTaxonomy>newBuilder()
                      .setDefaultInstance(DataTaxonomy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateDataAttributeBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/CreateDataAttributeBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataAttributeBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataAttributeBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "dataAttributeBindingId",
                                request.getDataAttributeBindingId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "dataAttributeBinding",
                                      request.getDataAttributeBinding(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataAttributeBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataAttributeBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataAttributeBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataAttributeBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{dataAttributeBinding.name=projects/*/locations/*/dataAttributeBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "dataAttributeBinding.name",
                                request.getDataAttributeBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAttributeBindingRequest> serializer =
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
                                  .toBody(
                                      "dataAttributeBinding",
                                      request.getDataAttributeBinding(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataAttributeBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataAttributeBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataAttributeBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataAttributeBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataAttributeBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAttributeBindingRequest> serializer =
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
                  (DeleteDataAttributeBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/ListDataAttributeBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataAttributeBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataAttributeBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAttributeBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAttributeBindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataAttributeBindingsResponse>newBuilder()
                      .setDefaultInstance(ListDataAttributeBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingMethodDescriptor =
          ApiMethodDescriptor.<GetDataAttributeBindingRequest, DataAttributeBinding>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/GetDataAttributeBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataAttributeBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataAttributeBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAttributeBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAttributeBinding>newBuilder()
                      .setDefaultInstance(DataAttributeBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataAttributeRequest, Operation>
      createDataAttributeMethodDescriptor =
          ApiMethodDescriptor.<CreateDataAttributeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/CreateDataAttribute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataTaxonomies/*}/attributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataAttributeId", request.getDataAttributeId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAttribute", request.getDataAttribute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataAttributeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataAttributeRequest, Operation>
      updateDataAttributeMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataAttributeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataAttribute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{dataAttribute.name=projects/*/locations/*/dataTaxonomies/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataAttribute.name", request.getDataAttribute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAttributeRequest> serializer =
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
                                  .toBody("dataAttribute", request.getDataAttribute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataAttributeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataAttributeRequest, Operation>
      deleteDataAttributeMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataAttributeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataAttribute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataTaxonomies/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAttributeRequest> serializer =
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
                  (DeleteDataAttributeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesMethodDescriptor =
          ApiMethodDescriptor.<ListDataAttributesRequest, ListDataAttributesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/ListDataAttributes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataAttributesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataTaxonomies/*}/attributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAttributesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataAttributesResponse>newBuilder()
                      .setDefaultInstance(ListDataAttributesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataAttributeRequest, DataAttribute>
      getDataAttributeMethodDescriptor =
          ApiMethodDescriptor.<GetDataAttributeRequest, DataAttribute>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/GetDataAttribute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataTaxonomies/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAttribute>newBuilder()
                      .setDefaultInstance(DataAttribute.getDefaultInstance())
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

  private final UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable;
  private final OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable;
  private final UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable;
  private final OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable;
  private final UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable;
  private final OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable;
  private final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable;
  private final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable;
  private final UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable;
  private final UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable;
  private final OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable;
  private final UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable;
  private final OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable;
  private final UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable;
  private final OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable;
  private final UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable;
  private final UnaryCallable<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable;
  private final UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable;
  private final UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable;
  private final OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable;
  private final UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable;
  private final OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable;
  private final UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable;
  private final OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable;
  private final UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable;
  private final UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable;
  private final UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataTaxonomyServiceStub create(
      DataTaxonomyServiceStubSettings settings) throws IOException {
    return new HttpJsonDataTaxonomyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataTaxonomyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataTaxonomyServiceStub(
        DataTaxonomyServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataTaxonomyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataTaxonomyServiceStub(
        DataTaxonomyServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataTaxonomyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTaxonomyServiceStub(
      DataTaxonomyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataTaxonomyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataTaxonomyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTaxonomyServiceStub(
      DataTaxonomyServiceStubSettings settings,
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

    HttpJsonCallSettings<CreateDataTaxonomyRequest, Operation> createDataTaxonomyTransportSettings =
        HttpJsonCallSettings.<CreateDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyTransportSettings =
        HttpJsonCallSettings.<UpdateDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_taxonomy.name", String.valueOf(request.getDataTaxonomy().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyTransportSettings =
        HttpJsonCallSettings.<DeleteDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
        listDataTaxonomiesTransportSettings =
            HttpJsonCallSettings.<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(listDataTaxonomiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyTransportSettings =
        HttpJsonCallSettings.<GetDataTaxonomyRequest, DataTaxonomy>newBuilder()
            .setMethodDescriptor(getDataTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDataAttributeBindingRequest, Operation>
        createDataAttributeBindingTransportSettings =
            HttpJsonCallSettings.<CreateDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createDataAttributeBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataAttributeBindingRequest, Operation>
        updateDataAttributeBindingTransportSettings =
            HttpJsonCallSettings.<UpdateDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDataAttributeBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_attribute_binding.name",
                          String.valueOf(request.getDataAttributeBinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataAttributeBindingRequest, Operation>
        deleteDataAttributeBindingTransportSettings =
            HttpJsonCallSettings.<DeleteDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDataAttributeBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
        listDataAttributeBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>newBuilder()
                .setMethodDescriptor(listDataAttributeBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataAttributeBindingRequest, DataAttributeBinding>
        getDataAttributeBindingTransportSettings =
            HttpJsonCallSettings.<GetDataAttributeBindingRequest, DataAttributeBinding>newBuilder()
                .setMethodDescriptor(getDataAttributeBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDataAttributeRequest, Operation>
        createDataAttributeTransportSettings =
            HttpJsonCallSettings.<CreateDataAttributeRequest, Operation>newBuilder()
                .setMethodDescriptor(createDataAttributeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataAttributeRequest, Operation>
        updateDataAttributeTransportSettings =
            HttpJsonCallSettings.<UpdateDataAttributeRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDataAttributeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_attribute.name",
                          String.valueOf(request.getDataAttribute().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataAttributeRequest, Operation>
        deleteDataAttributeTransportSettings =
            HttpJsonCallSettings.<DeleteDataAttributeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDataAttributeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDataAttributesRequest, ListDataAttributesResponse>
        listDataAttributesTransportSettings =
            HttpJsonCallSettings.<ListDataAttributesRequest, ListDataAttributesResponse>newBuilder()
                .setMethodDescriptor(listDataAttributesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataAttributeRequest, DataAttribute> getDataAttributeTransportSettings =
        HttpJsonCallSettings.<GetDataAttributeRequest, DataAttribute>newBuilder()
            .setMethodDescriptor(getDataAttributeMethodDescriptor)
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

    this.createDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            createDataTaxonomyTransportSettings,
            settings.createDataTaxonomySettings(),
            clientContext);
    this.createDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            createDataTaxonomyTransportSettings,
            settings.createDataTaxonomyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            updateDataTaxonomyTransportSettings,
            settings.updateDataTaxonomySettings(),
            clientContext);
    this.updateDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            updateDataTaxonomyTransportSettings,
            settings.updateDataTaxonomyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            deleteDataTaxonomyTransportSettings,
            settings.deleteDataTaxonomySettings(),
            clientContext);
    this.deleteDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataTaxonomyTransportSettings,
            settings.deleteDataTaxonomyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDataTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            listDataTaxonomiesTransportSettings,
            settings.listDataTaxonomiesSettings(),
            clientContext);
    this.listDataTaxonomiesPagedCallable =
        callableFactory.createPagedCallable(
            listDataTaxonomiesTransportSettings,
            settings.listDataTaxonomiesSettings(),
            clientContext);
    this.getDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            getDataTaxonomyTransportSettings, settings.getDataTaxonomySettings(), clientContext);
    this.createDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            createDataAttributeBindingTransportSettings,
            settings.createDataAttributeBindingSettings(),
            clientContext);
    this.createDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            createDataAttributeBindingTransportSettings,
            settings.createDataAttributeBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            updateDataAttributeBindingTransportSettings,
            settings.updateDataAttributeBindingSettings(),
            clientContext);
    this.updateDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAttributeBindingTransportSettings,
            settings.updateDataAttributeBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            deleteDataAttributeBindingTransportSettings,
            settings.deleteDataAttributeBindingSettings(),
            clientContext);
    this.deleteDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAttributeBindingTransportSettings,
            settings.deleteDataAttributeBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDataAttributeBindingsCallable =
        callableFactory.createUnaryCallable(
            listDataAttributeBindingsTransportSettings,
            settings.listDataAttributeBindingsSettings(),
            clientContext);
    this.listDataAttributeBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAttributeBindingsTransportSettings,
            settings.listDataAttributeBindingsSettings(),
            clientContext);
    this.getDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            getDataAttributeBindingTransportSettings,
            settings.getDataAttributeBindingSettings(),
            clientContext);
    this.createDataAttributeCallable =
        callableFactory.createUnaryCallable(
            createDataAttributeTransportSettings,
            settings.createDataAttributeSettings(),
            clientContext);
    this.createDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            createDataAttributeTransportSettings,
            settings.createDataAttributeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataAttributeCallable =
        callableFactory.createUnaryCallable(
            updateDataAttributeTransportSettings,
            settings.updateDataAttributeSettings(),
            clientContext);
    this.updateDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAttributeTransportSettings,
            settings.updateDataAttributeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataAttributeCallable =
        callableFactory.createUnaryCallable(
            deleteDataAttributeTransportSettings,
            settings.deleteDataAttributeSettings(),
            clientContext);
    this.deleteDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAttributeTransportSettings,
            settings.deleteDataAttributeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDataAttributesCallable =
        callableFactory.createUnaryCallable(
            listDataAttributesTransportSettings,
            settings.listDataAttributesSettings(),
            clientContext);
    this.listDataAttributesPagedCallable =
        callableFactory.createPagedCallable(
            listDataAttributesTransportSettings,
            settings.listDataAttributesSettings(),
            clientContext);
    this.getDataAttributeCallable =
        callableFactory.createUnaryCallable(
            getDataAttributeTransportSettings, settings.getDataAttributeSettings(), clientContext);
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
    methodDescriptors.add(createDataTaxonomyMethodDescriptor);
    methodDescriptors.add(updateDataTaxonomyMethodDescriptor);
    methodDescriptors.add(deleteDataTaxonomyMethodDescriptor);
    methodDescriptors.add(listDataTaxonomiesMethodDescriptor);
    methodDescriptors.add(getDataTaxonomyMethodDescriptor);
    methodDescriptors.add(createDataAttributeBindingMethodDescriptor);
    methodDescriptors.add(updateDataAttributeBindingMethodDescriptor);
    methodDescriptors.add(deleteDataAttributeBindingMethodDescriptor);
    methodDescriptors.add(listDataAttributeBindingsMethodDescriptor);
    methodDescriptors.add(getDataAttributeBindingMethodDescriptor);
    methodDescriptors.add(createDataAttributeMethodDescriptor);
    methodDescriptors.add(updateDataAttributeMethodDescriptor);
    methodDescriptors.add(deleteDataAttributeMethodDescriptor);
    methodDescriptors.add(listDataAttributesMethodDescriptor);
    methodDescriptors.add(getDataAttributeMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable() {
    return createDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable() {
    return createDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable() {
    return updateDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable() {
    return updateDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable() {
    return deleteDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable() {
    return deleteDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable() {
    return listDataTaxonomiesCallable;
  }

  @Override
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable() {
    return listDataTaxonomiesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable() {
    return getDataTaxonomyCallable;
  }

  @Override
  public UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable() {
    return createDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable() {
    return createDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable() {
    return updateDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable() {
    return updateDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable() {
    return deleteDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable() {
    return deleteDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable() {
    return listDataAttributeBindingsCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable() {
    return listDataAttributeBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable() {
    return getDataAttributeBindingCallable;
  }

  @Override
  public UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable() {
    return createDataAttributeCallable;
  }

  @Override
  public OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable() {
    return createDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable() {
    return updateDataAttributeCallable;
  }

  @Override
  public OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable() {
    return updateDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable() {
    return deleteDataAttributeCallable;
  }

  @Override
  public OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable() {
    return deleteDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable() {
    return listDataAttributesCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable() {
    return listDataAttributesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable() {
    return getDataAttributeCallable;
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
