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

package com.google.cloud.tpu.v2.stub;

import static com.google.cloud.tpu.v2.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v2.AcceleratorType;
import com.google.cloud.tpu.v2.CreateNodeRequest;
import com.google.cloud.tpu.v2.DeleteNodeRequest;
import com.google.cloud.tpu.v2.GenerateServiceIdentityRequest;
import com.google.cloud.tpu.v2.GenerateServiceIdentityResponse;
import com.google.cloud.tpu.v2.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v2.GetGuestAttributesRequest;
import com.google.cloud.tpu.v2.GetGuestAttributesResponse;
import com.google.cloud.tpu.v2.GetNodeRequest;
import com.google.cloud.tpu.v2.GetRuntimeVersionRequest;
import com.google.cloud.tpu.v2.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v2.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v2.ListNodesRequest;
import com.google.cloud.tpu.v2.ListNodesResponse;
import com.google.cloud.tpu.v2.ListRuntimeVersionsRequest;
import com.google.cloud.tpu.v2.ListRuntimeVersionsResponse;
import com.google.cloud.tpu.v2.Node;
import com.google.cloud.tpu.v2.OperationMetadata;
import com.google.cloud.tpu.v2.RuntimeVersion;
import com.google.cloud.tpu.v2.StartNodeRequest;
import com.google.cloud.tpu.v2.StopNodeRequest;
import com.google.cloud.tpu.v2.UpdateNodeRequest;
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
 * REST stub implementation for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTpuStub extends TpuStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Node.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          ApiMethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListNodes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/nodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNodesResponse>newBuilder()
                      .setDefaultInstance(ListNodesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      ApiMethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setFullMethodName("google.cloud.tpu.v2.Tpu/GetNode")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNodeRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/nodes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Node>newBuilder()
                  .setDefaultInstance(Node.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateNodeRequest, Operation>
      createNodeMethodDescriptor =
          ApiMethodDescriptor.<CreateNodeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/CreateNode")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNodeRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/nodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "nodeId", request.getNodeId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("node", request.getNode(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNodeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteNodeRequest, Operation>
      deleteNodeMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/DeleteNode")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/nodes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNodeRequest> serializer =
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
                  (DeleteNodeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopNodeRequest, Operation> stopNodeMethodDescriptor =
      ApiMethodDescriptor.<StopNodeRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.tpu.v2.Tpu/StopNode")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StopNodeRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/nodes/*}:stop",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<StopNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<StopNodeRequest> serializer =
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
              (StopNodeRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<StartNodeRequest, Operation> startNodeMethodDescriptor =
      ApiMethodDescriptor.<StartNodeRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.tpu.v2.Tpu/StartNode")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StartNodeRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/nodes/*}:start",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<StartNodeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<StartNodeRequest> serializer =
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
              (StartNodeRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<UpdateNodeRequest, Operation>
      updateNodeMethodDescriptor =
          ApiMethodDescriptor.<UpdateNodeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/UpdateNode")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNodeRequest>newBuilder()
                      .setPath(
                          "/v2/{node.name=projects/*/locations/*/nodes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "node.name", request.getNode().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("node", request.getNode(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNodeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GenerateServiceIdentity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateServiceIdentityRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}:generateServiceIdentity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateServiceIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateServiceIdentityRequest> serializer =
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
                  ProtoMessageResponseParser.<GenerateServiceIdentityResponse>newBuilder()
                      .setDefaultInstance(GenerateServiceIdentityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListAcceleratorTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAcceleratorTypesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/acceleratorTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAcceleratorTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAcceleratorTypesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAcceleratorTypesResponse>newBuilder()
                      .setDefaultInstance(ListAcceleratorTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeMethodDescriptor =
          ApiMethodDescriptor.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetAcceleratorType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAcceleratorTypeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/acceleratorTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAcceleratorTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAcceleratorTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AcceleratorType>newBuilder()
                      .setDefaultInstance(AcceleratorType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListRuntimeVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuntimeVersionsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/runtimeVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimeVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimeVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRuntimeVersionsResponse>newBuilder()
                      .setDefaultInstance(ListRuntimeVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuntimeVersionRequest, RuntimeVersion>
      getRuntimeVersionMethodDescriptor =
          ApiMethodDescriptor.<GetRuntimeVersionRequest, RuntimeVersion>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetRuntimeVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuntimeVersionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/runtimeVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuntimeVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuntimeVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuntimeVersion>newBuilder()
                      .setDefaultInstance(RuntimeVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesMethodDescriptor =
          ApiMethodDescriptor.<GetGuestAttributesRequest, GetGuestAttributesResponse>newBuilder()
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetGuestAttributes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGuestAttributesRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/nodes/*}:getGuestAttributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuestAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuestAttributesRequest> serializer =
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
                  ProtoMessageResponseParser.<GetGuestAttributesResponse>newBuilder()
                      .setDefaultInstance(GetGuestAttributesResponse.getDefaultInstance())
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
                          "/v1alpha1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*}/locations",
                          "/v2alpha1/{name=projects/*}/locations",
                          "/v2/{name=projects/*}/locations")
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
                          "/v1alpha1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*}",
                          "/v2alpha1/{name=projects/*/locations/*}",
                          "/v2/{name=projects/*/locations/*}")
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

  private final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable;
  private final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable;
  private final UnaryCallable<GetNodeRequest, Node> getNodeCallable;
  private final UnaryCallable<CreateNodeRequest, Operation> createNodeCallable;
  private final OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable;
  private final UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable;
  private final OperationCallable<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationCallable;
  private final UnaryCallable<StopNodeRequest, Operation> stopNodeCallable;
  private final OperationCallable<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationCallable;
  private final UnaryCallable<StartNodeRequest, Operation> startNodeCallable;
  private final OperationCallable<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationCallable;
  private final UnaryCallable<UpdateNodeRequest, Operation> updateNodeCallable;
  private final OperationCallable<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationCallable;
  private final UnaryCallable<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable;
  private final UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeCallable;
  private final UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsCallable;
  private final UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsPagedCallable;
  private final UnaryCallable<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionCallable;
  private final UnaryCallable<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTpuStub create(TpuStubSettings settings) throws IOException {
    return new HttpJsonTpuStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTpuStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTpuStub(TpuStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTpuStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTpuStub(
        TpuStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTpuStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonTpuStub(TpuStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTpuCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTpuStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonTpuStub(
      TpuStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListNodesRequest, ListNodesResponse> listNodesTransportSettings =
        HttpJsonCallSettings.<ListNodesRequest, ListNodesResponse>newBuilder()
            .setMethodDescriptor(listNodesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNodeRequest, Node> getNodeTransportSettings =
        HttpJsonCallSettings.<GetNodeRequest, Node>newBuilder()
            .setMethodDescriptor(getNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateNodeRequest, Operation> createNodeTransportSettings =
        HttpJsonCallSettings.<CreateNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteNodeRequest, Operation> deleteNodeTransportSettings =
        HttpJsonCallSettings.<DeleteNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopNodeRequest, Operation> stopNodeTransportSettings =
        HttpJsonCallSettings.<StopNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(stopNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartNodeRequest, Operation> startNodeTransportSettings =
        HttpJsonCallSettings.<StartNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(startNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateNodeRequest, Operation> updateNodeTransportSettings =
        HttpJsonCallSettings.<UpdateNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
        generateServiceIdentityTransportSettings =
            HttpJsonCallSettings
                .<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>newBuilder()
                .setMethodDescriptor(generateServiceIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
        listAcceleratorTypesTransportSettings =
            HttpJsonCallSettings
                .<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
                .setMethodDescriptor(listAcceleratorTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeTransportSettings =
            HttpJsonCallSettings.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
                .setMethodDescriptor(getAcceleratorTypeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
        listRuntimeVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>newBuilder()
                .setMethodDescriptor(listRuntimeVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRuntimeVersionRequest, RuntimeVersion>
        getRuntimeVersionTransportSettings =
            HttpJsonCallSettings.<GetRuntimeVersionRequest, RuntimeVersion>newBuilder()
                .setMethodDescriptor(getRuntimeVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGuestAttributesRequest, GetGuestAttributesResponse>
        getGuestAttributesTransportSettings =
            HttpJsonCallSettings.<GetGuestAttributesRequest, GetGuestAttributesResponse>newBuilder()
                .setMethodDescriptor(getGuestAttributesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.getNodeCallable =
        callableFactory.createUnaryCallable(
            getNodeTransportSettings, settings.getNodeSettings(), clientContext);
    this.createNodeCallable =
        callableFactory.createUnaryCallable(
            createNodeTransportSettings, settings.createNodeSettings(), clientContext);
    this.createNodeOperationCallable =
        callableFactory.createOperationCallable(
            createNodeTransportSettings,
            settings.createNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNodeCallable =
        callableFactory.createUnaryCallable(
            deleteNodeTransportSettings, settings.deleteNodeSettings(), clientContext);
    this.deleteNodeOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodeTransportSettings,
            settings.deleteNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopNodeCallable =
        callableFactory.createUnaryCallable(
            stopNodeTransportSettings, settings.stopNodeSettings(), clientContext);
    this.stopNodeOperationCallable =
        callableFactory.createOperationCallable(
            stopNodeTransportSettings,
            settings.stopNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startNodeCallable =
        callableFactory.createUnaryCallable(
            startNodeTransportSettings, settings.startNodeSettings(), clientContext);
    this.startNodeOperationCallable =
        callableFactory.createOperationCallable(
            startNodeTransportSettings,
            settings.startNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateNodeCallable =
        callableFactory.createUnaryCallable(
            updateNodeTransportSettings, settings.updateNodeSettings(), clientContext);
    this.updateNodeOperationCallable =
        callableFactory.createOperationCallable(
            updateNodeTransportSettings,
            settings.updateNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateServiceIdentityCallable =
        callableFactory.createUnaryCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentitySettings(),
            clientContext);
    this.listAcceleratorTypesCallable =
        callableFactory.createUnaryCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.listAcceleratorTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.getAcceleratorTypeCallable =
        callableFactory.createUnaryCallable(
            getAcceleratorTypeTransportSettings,
            settings.getAcceleratorTypeSettings(),
            clientContext);
    this.listRuntimeVersionsCallable =
        callableFactory.createUnaryCallable(
            listRuntimeVersionsTransportSettings,
            settings.listRuntimeVersionsSettings(),
            clientContext);
    this.listRuntimeVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listRuntimeVersionsTransportSettings,
            settings.listRuntimeVersionsSettings(),
            clientContext);
    this.getRuntimeVersionCallable =
        callableFactory.createUnaryCallable(
            getRuntimeVersionTransportSettings,
            settings.getRuntimeVersionSettings(),
            clientContext);
    this.getGuestAttributesCallable =
        callableFactory.createUnaryCallable(
            getGuestAttributesTransportSettings,
            settings.getGuestAttributesSettings(),
            clientContext);
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
    methodDescriptors.add(listNodesMethodDescriptor);
    methodDescriptors.add(getNodeMethodDescriptor);
    methodDescriptors.add(createNodeMethodDescriptor);
    methodDescriptors.add(deleteNodeMethodDescriptor);
    methodDescriptors.add(stopNodeMethodDescriptor);
    methodDescriptors.add(startNodeMethodDescriptor);
    methodDescriptors.add(updateNodeMethodDescriptor);
    methodDescriptors.add(generateServiceIdentityMethodDescriptor);
    methodDescriptors.add(listAcceleratorTypesMethodDescriptor);
    methodDescriptors.add(getAcceleratorTypeMethodDescriptor);
    methodDescriptors.add(listRuntimeVersionsMethodDescriptor);
    methodDescriptors.add(getRuntimeVersionMethodDescriptor);
    methodDescriptors.add(getGuestAttributesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return listNodesCallable;
  }

  @Override
  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return getNodeCallable;
  }

  @Override
  public UnaryCallable<CreateNodeRequest, Operation> createNodeCallable() {
    return createNodeCallable;
  }

  @Override
  public OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable() {
    return createNodeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    return deleteNodeCallable;
  }

  @Override
  public OperationCallable<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationCallable() {
    return deleteNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StopNodeRequest, Operation> stopNodeCallable() {
    return stopNodeCallable;
  }

  @Override
  public OperationCallable<StopNodeRequest, Node, OperationMetadata> stopNodeOperationCallable() {
    return stopNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StartNodeRequest, Operation> startNodeCallable() {
    return startNodeCallable;
  }

  @Override
  public OperationCallable<StartNodeRequest, Node, OperationMetadata> startNodeOperationCallable() {
    return startNodeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNodeRequest, Operation> updateNodeCallable() {
    return updateNodeCallable;
  }

  @Override
  public OperationCallable<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationCallable() {
    return updateNodeOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityCallable() {
    return generateServiceIdentityCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable() {
    return listAcceleratorTypesCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return listAcceleratorTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType> getAcceleratorTypeCallable() {
    return getAcceleratorTypeCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsCallable() {
    return listRuntimeVersionsCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsPagedCallable() {
    return listRuntimeVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionCallable() {
    return getRuntimeVersionCallable;
  }

  @Override
  public UnaryCallable<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesCallable() {
    return getGuestAttributesCallable;
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
