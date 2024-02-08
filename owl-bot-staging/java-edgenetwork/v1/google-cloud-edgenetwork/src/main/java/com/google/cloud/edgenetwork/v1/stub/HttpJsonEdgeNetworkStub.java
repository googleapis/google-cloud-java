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

package com.google.cloud.edgenetwork.v1.stub;

import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListInterconnectsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListLocationsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListNetworksPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListRoutersPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListSubnetsPagedResponse;
import static com.google.cloud.edgenetwork.v1.EdgeNetworkClient.ListZonesPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.CreateNetworkRequest;
import com.google.cloud.edgenetwork.v1.CreateRouterRequest;
import com.google.cloud.edgenetwork.v1.CreateSubnetRequest;
import com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.DeleteNetworkRequest;
import com.google.cloud.edgenetwork.v1.DeleteRouterRequest;
import com.google.cloud.edgenetwork.v1.DeleteSubnetRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse;
import com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest;
import com.google.cloud.edgenetwork.v1.GetInterconnectRequest;
import com.google.cloud.edgenetwork.v1.GetNetworkRequest;
import com.google.cloud.edgenetwork.v1.GetRouterRequest;
import com.google.cloud.edgenetwork.v1.GetSubnetRequest;
import com.google.cloud.edgenetwork.v1.GetZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneRequest;
import com.google.cloud.edgenetwork.v1.InitializeZoneResponse;
import com.google.cloud.edgenetwork.v1.Interconnect;
import com.google.cloud.edgenetwork.v1.InterconnectAttachment;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse;
import com.google.cloud.edgenetwork.v1.ListInterconnectsRequest;
import com.google.cloud.edgenetwork.v1.ListInterconnectsResponse;
import com.google.cloud.edgenetwork.v1.ListNetworksRequest;
import com.google.cloud.edgenetwork.v1.ListNetworksResponse;
import com.google.cloud.edgenetwork.v1.ListRoutersRequest;
import com.google.cloud.edgenetwork.v1.ListRoutersResponse;
import com.google.cloud.edgenetwork.v1.ListSubnetsRequest;
import com.google.cloud.edgenetwork.v1.ListSubnetsResponse;
import com.google.cloud.edgenetwork.v1.ListZonesRequest;
import com.google.cloud.edgenetwork.v1.ListZonesResponse;
import com.google.cloud.edgenetwork.v1.Network;
import com.google.cloud.edgenetwork.v1.OperationMetadata;
import com.google.cloud.edgenetwork.v1.Router;
import com.google.cloud.edgenetwork.v1.Subnet;
import com.google.cloud.edgenetwork.v1.UpdateRouterRequest;
import com.google.cloud.edgenetwork.v1.UpdateSubnetRequest;
import com.google.cloud.edgenetwork.v1.Zone;
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
 * REST stub implementation for the EdgeNetwork service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEdgeNetworkStub extends EdgeNetworkStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Subnet.getDescriptor())
          .add(InterconnectAttachment.getDescriptor())
          .add(Network.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Router.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<InitializeZoneRequest, InitializeZoneResponse>
      initializeZoneMethodDescriptor =
          ApiMethodDescriptor.<InitializeZoneRequest, InitializeZoneResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/InitializeZone")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InitializeZoneRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*}:initialize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InitializeZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InitializeZoneRequest> serializer =
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
                  ProtoMessageResponseParser.<InitializeZoneResponse>newBuilder()
                      .setDefaultInstance(InitializeZoneResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListZonesRequest, ListZonesResponse>
      listZonesMethodDescriptor =
          ApiMethodDescriptor.<ListZonesRequest, ListZonesResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListZones")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListZonesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/zones",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListZonesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListZonesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListZonesResponse>newBuilder()
                      .setDefaultInstance(ListZonesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetZoneRequest, Zone> getZoneMethodDescriptor =
      ApiMethodDescriptor.<GetZoneRequest, Zone>newBuilder()
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetZone")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetZoneRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/zones/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Zone>newBuilder()
                  .setDefaultInstance(Zone.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListNetworksRequest, ListNetworksResponse>
      listNetworksMethodDescriptor =
          ApiMethodDescriptor.<ListNetworksRequest, ListNetworksResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListNetworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/networks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListNetworksResponse>newBuilder()
                      .setDefaultInstance(ListNetworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNetworkRequest, Network> getNetworkMethodDescriptor =
      ApiMethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetNetwork")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNetworkRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/zones/*/networks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Network>newBuilder()
                  .setDefaultInstance(Network.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkMethodDescriptor =
          ApiMethodDescriptor.<DiagnoseNetworkRequest, DiagnoseNetworkResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseNetwork")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiagnoseNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/networks/*}:diagnose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiagnoseNetworkResponse>newBuilder()
                      .setDefaultInstance(DiagnoseNetworkResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateNetworkRequest, Operation>
      createNetworkMethodDescriptor =
          ApiMethodDescriptor.<CreateNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateNetwork")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/networks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "networkId", request.getNetworkId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("network", request.getNetwork(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteNetworkRequest, Operation>
      deleteNetworkMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteNetwork")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/networks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkRequest> serializer =
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
                  (DeleteNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSubnetsRequest, ListSubnetsResponse>
      listSubnetsMethodDescriptor =
          ApiMethodDescriptor.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListSubnets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubnetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/subnets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSubnetsResponse>newBuilder()
                      .setDefaultInstance(ListSubnetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSubnetRequest, Subnet> getSubnetMethodDescriptor =
      ApiMethodDescriptor.<GetSubnetRequest, Subnet>newBuilder()
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetSubnet")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSubnetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/zones/*/subnets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Subnet>newBuilder()
                  .setDefaultInstance(Subnet.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSubnetRequest, Operation>
      createSubnetMethodDescriptor =
          ApiMethodDescriptor.<CreateSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateSubnet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/subnets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "subnetId", request.getSubnetId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subnet", request.getSubnet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSubnetRequest, Operation>
      updateSubnetMethodDescriptor =
          ApiMethodDescriptor.<UpdateSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/UpdateSubnet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{subnet.name=projects/*/locations/*/zones/*/subnets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "subnet.name", request.getSubnet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subnet", request.getSubnet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSubnetRequest, Operation>
      deleteSubnetMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubnetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteSubnet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubnetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/subnets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubnetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubnetRequest> serializer =
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
                  (DeleteSubnetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsMethodDescriptor =
          ApiMethodDescriptor.<ListInterconnectsRequest, ListInterconnectsResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListInterconnects")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInterconnectsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/interconnects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInterconnectsResponse>newBuilder()
                      .setDefaultInstance(ListInterconnectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInterconnectRequest, Interconnect>
      getInterconnectMethodDescriptor =
          ApiMethodDescriptor.<GetInterconnectRequest, Interconnect>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetInterconnect")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInterconnectRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/interconnects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Interconnect>newBuilder()
                      .setDefaultInstance(Interconnect.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectMethodDescriptor =
          ApiMethodDescriptor
              .<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseInterconnect")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiagnoseInterconnectRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/interconnects/*}:diagnose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseInterconnectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseInterconnectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiagnoseInterconnectResponse>newBuilder()
                      .setDefaultInstance(DiagnoseInterconnectResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/ListInterconnectAttachments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInterconnectAttachmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/interconnectAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectAttachmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInterconnectAttachmentsResponse>newBuilder()
                      .setDefaultInstance(ListInterconnectAttachmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<GetInterconnectAttachmentRequest, InterconnectAttachment>newBuilder()
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/GetInterconnectAttachment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInterconnectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/interconnectAttachments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InterconnectAttachment>newBuilder()
                      .setDefaultInstance(InterconnectAttachment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<CreateInterconnectAttachmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/CreateInterconnectAttachment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInterconnectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/interconnectAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInterconnectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInterconnectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "interconnectAttachmentId",
                                request.getInterconnectAttachmentId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "interconnectAttachment",
                                      request.getInterconnectAttachment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInterconnectAttachmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteInterconnectAttachmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.edgenetwork.v1.EdgeNetwork/DeleteInterconnectAttachment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInterconnectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/interconnectAttachments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectAttachmentRequest> serializer =
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
                  (DeleteInterconnectAttachmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRoutersRequest, ListRoutersResponse>
      listRoutersMethodDescriptor =
          ApiMethodDescriptor.<ListRoutersRequest, ListRoutersResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/ListRouters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRoutersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/routers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRoutersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRoutersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRoutersResponse>newBuilder()
                      .setDefaultInstance(ListRoutersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRouterRequest, Router> getRouterMethodDescriptor =
      ApiMethodDescriptor.<GetRouterRequest, Router>newBuilder()
          .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/GetRouter")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRouterRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/zones/*/routers/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Router>newBuilder()
                  .setDefaultInstance(Router.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DiagnoseRouterRequest, DiagnoseRouterResponse>
      diagnoseRouterMethodDescriptor =
          ApiMethodDescriptor.<DiagnoseRouterRequest, DiagnoseRouterResponse>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DiagnoseRouter")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiagnoseRouterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/routers/*}:diagnose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiagnoseRouterResponse>newBuilder()
                      .setDefaultInstance(DiagnoseRouterResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRouterRequest, Operation>
      createRouterMethodDescriptor =
          ApiMethodDescriptor.<CreateRouterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/CreateRouter")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRouterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/zones/*}/routers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "routerId", request.getRouterId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("router", request.getRouter(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRouterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateRouterRequest, Operation>
      updateRouterMethodDescriptor =
          ApiMethodDescriptor.<UpdateRouterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/UpdateRouter")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRouterRequest>newBuilder()
                      .setPath(
                          "/v1/{router.name=projects/*/locations/*/zones/*/routers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "router.name", request.getRouter().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("router", request.getRouter(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRouterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRouterRequest, Operation>
      deleteRouterMethodDescriptor =
          ApiMethodDescriptor.<DeleteRouterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.edgenetwork.v1.EdgeNetwork/DeleteRouter")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRouterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/zones/*/routers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRouterRequest> serializer =
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
                  (DeleteRouterRequest request, Operation response) ->
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

  private final UnaryCallable<InitializeZoneRequest, InitializeZoneResponse> initializeZoneCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable;
  private final UnaryCallable<GetZoneRequest, Zone> getZoneCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable;
  private final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable;
  private final UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkCallable;
  private final UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable;
  private final OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable;
  private final UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable;
  private final OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
  private final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable;
  private final UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable;
  private final OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable;
  private final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable;
  private final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable;
  private final UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable;
  private final OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable;
  private final UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable;
  private final UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable;
  private final UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable;
  private final UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable;
  private final UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable;
  private final UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable;
  private final OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable;
  private final UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable;
  private final OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable;
  private final UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable;
  private final UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable;
  private final UnaryCallable<GetRouterRequest, Router> getRouterCallable;
  private final UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterCallable;
  private final UnaryCallable<CreateRouterRequest, Operation> createRouterCallable;
  private final OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable;
  private final UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable;
  private final OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable;
  private final UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable;
  private final OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEdgeNetworkStub create(EdgeNetworkStubSettings settings)
      throws IOException {
    return new HttpJsonEdgeNetworkStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEdgeNetworkStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEdgeNetworkStub(
        EdgeNetworkStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEdgeNetworkStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEdgeNetworkStub(
        EdgeNetworkStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEdgeNetworkStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEdgeNetworkStub(EdgeNetworkStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEdgeNetworkCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEdgeNetworkStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEdgeNetworkStub(
      EdgeNetworkStubSettings settings,
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

    HttpJsonCallSettings<InitializeZoneRequest, InitializeZoneResponse>
        initializeZoneTransportSettings =
            HttpJsonCallSettings.<InitializeZoneRequest, InitializeZoneResponse>newBuilder()
                .setMethodDescriptor(initializeZoneMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListZonesRequest, ListZonesResponse> listZonesTransportSettings =
        HttpJsonCallSettings.<ListZonesRequest, ListZonesResponse>newBuilder()
            .setMethodDescriptor(listZonesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetZoneRequest, Zone> getZoneTransportSettings =
        HttpJsonCallSettings.<GetZoneRequest, Zone>newBuilder()
            .setMethodDescriptor(getZoneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        HttpJsonCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        HttpJsonCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
        diagnoseNetworkTransportSettings =
            HttpJsonCallSettings.<DiagnoseNetworkRequest, DiagnoseNetworkResponse>newBuilder()
                .setMethodDescriptor(diagnoseNetworkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateNetworkRequest, Operation> createNetworkTransportSettings =
        HttpJsonCallSettings.<CreateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(createNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteNetworkRequest, Operation> deleteNetworkTransportSettings =
        HttpJsonCallSettings.<DeleteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        HttpJsonCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSubnetRequest, Subnet> getSubnetTransportSettings =
        HttpJsonCallSettings.<GetSubnetRequest, Subnet>newBuilder()
            .setMethodDescriptor(getSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSubnetRequest, Operation> createSubnetTransportSettings =
        HttpJsonCallSettings.<CreateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSubnetRequest, Operation> updateSubnetTransportSettings =
        HttpJsonCallSettings.<UpdateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subnet.name", String.valueOf(request.getSubnet().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSubnetRequest, Operation> deleteSubnetTransportSettings =
        HttpJsonCallSettings.<DeleteSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubnetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListInterconnectsRequest, ListInterconnectsResponse>
        listInterconnectsTransportSettings =
            HttpJsonCallSettings.<ListInterconnectsRequest, ListInterconnectsResponse>newBuilder()
                .setMethodDescriptor(listInterconnectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInterconnectRequest, Interconnect> getInterconnectTransportSettings =
        HttpJsonCallSettings.<GetInterconnectRequest, Interconnect>newBuilder()
            .setMethodDescriptor(getInterconnectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
        diagnoseInterconnectTransportSettings =
            HttpJsonCallSettings
                .<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>newBuilder()
                .setMethodDescriptor(diagnoseInterconnectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
        listInterconnectAttachmentsTransportSettings =
            HttpJsonCallSettings
                .<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listInterconnectAttachmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInterconnectAttachmentRequest, InterconnectAttachment>
        getInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings
                .<GetInterconnectAttachmentRequest, InterconnectAttachment>newBuilder()
                .setMethodDescriptor(getInterconnectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateInterconnectAttachmentRequest, Operation>
        createInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings.<CreateInterconnectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterconnectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteInterconnectAttachmentRequest, Operation>
        deleteInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings.<DeleteInterconnectAttachmentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterconnectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRoutersRequest, ListRoutersResponse> listRoutersTransportSettings =
        HttpJsonCallSettings.<ListRoutersRequest, ListRoutersResponse>newBuilder()
            .setMethodDescriptor(listRoutersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRouterRequest, Router> getRouterTransportSettings =
        HttpJsonCallSettings.<GetRouterRequest, Router>newBuilder()
            .setMethodDescriptor(getRouterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DiagnoseRouterRequest, DiagnoseRouterResponse>
        diagnoseRouterTransportSettings =
            HttpJsonCallSettings.<DiagnoseRouterRequest, DiagnoseRouterResponse>newBuilder()
                .setMethodDescriptor(diagnoseRouterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateRouterRequest, Operation> createRouterTransportSettings =
        HttpJsonCallSettings.<CreateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(createRouterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRouterRequest, Operation> updateRouterTransportSettings =
        HttpJsonCallSettings.<UpdateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRouterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("router.name", String.valueOf(request.getRouter().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRouterRequest, Operation> deleteRouterTransportSettings =
        HttpJsonCallSettings.<DeleteRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouterMethodDescriptor)
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

    this.initializeZoneCallable =
        callableFactory.createUnaryCallable(
            initializeZoneTransportSettings, settings.initializeZoneSettings(), clientContext);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.listNetworksCallable =
        callableFactory.createUnaryCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.listNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.getNetworkCallable =
        callableFactory.createUnaryCallable(
            getNetworkTransportSettings, settings.getNetworkSettings(), clientContext);
    this.diagnoseNetworkCallable =
        callableFactory.createUnaryCallable(
            diagnoseNetworkTransportSettings, settings.diagnoseNetworkSettings(), clientContext);
    this.createNetworkCallable =
        callableFactory.createUnaryCallable(
            createNetworkTransportSettings, settings.createNetworkSettings(), clientContext);
    this.createNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkTransportSettings,
            settings.createNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkTransportSettings, settings.deleteNetworkSettings(), clientContext);
    this.deleteNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkTransportSettings,
            settings.deleteNetworkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.getSubnetCallable =
        callableFactory.createUnaryCallable(
            getSubnetTransportSettings, settings.getSubnetSettings(), clientContext);
    this.createSubnetCallable =
        callableFactory.createUnaryCallable(
            createSubnetTransportSettings, settings.createSubnetSettings(), clientContext);
    this.createSubnetOperationCallable =
        callableFactory.createOperationCallable(
            createSubnetTransportSettings,
            settings.createSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSubnetCallable =
        callableFactory.createUnaryCallable(
            updateSubnetTransportSettings, settings.updateSubnetSettings(), clientContext);
    this.updateSubnetOperationCallable =
        callableFactory.createOperationCallable(
            updateSubnetTransportSettings,
            settings.updateSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSubnetCallable =
        callableFactory.createUnaryCallable(
            deleteSubnetTransportSettings, settings.deleteSubnetSettings(), clientContext);
    this.deleteSubnetOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubnetTransportSettings,
            settings.deleteSubnetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listInterconnectsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.listInterconnectsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.getInterconnectCallable =
        callableFactory.createUnaryCallable(
            getInterconnectTransportSettings, settings.getInterconnectSettings(), clientContext);
    this.diagnoseInterconnectCallable =
        callableFactory.createUnaryCallable(
            diagnoseInterconnectTransportSettings,
            settings.diagnoseInterconnectSettings(),
            clientContext);
    this.listInterconnectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);
    this.listInterconnectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);
    this.getInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getInterconnectAttachmentTransportSettings,
            settings.getInterconnectAttachmentSettings(),
            clientContext);
    this.createInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            createInterconnectAttachmentTransportSettings,
            settings.createInterconnectAttachmentSettings(),
            clientContext);
    this.createInterconnectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            createInterconnectAttachmentTransportSettings,
            settings.createInterconnectAttachmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteInterconnectAttachmentTransportSettings,
            settings.deleteInterconnectAttachmentSettings(),
            clientContext);
    this.deleteInterconnectAttachmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterconnectAttachmentTransportSettings,
            settings.deleteInterconnectAttachmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRoutersCallable =
        callableFactory.createUnaryCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.listRoutersPagedCallable =
        callableFactory.createPagedCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.getRouterCallable =
        callableFactory.createUnaryCallable(
            getRouterTransportSettings, settings.getRouterSettings(), clientContext);
    this.diagnoseRouterCallable =
        callableFactory.createUnaryCallable(
            diagnoseRouterTransportSettings, settings.diagnoseRouterSettings(), clientContext);
    this.createRouterCallable =
        callableFactory.createUnaryCallable(
            createRouterTransportSettings, settings.createRouterSettings(), clientContext);
    this.createRouterOperationCallable =
        callableFactory.createOperationCallable(
            createRouterTransportSettings,
            settings.createRouterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateRouterCallable =
        callableFactory.createUnaryCallable(
            updateRouterTransportSettings, settings.updateRouterSettings(), clientContext);
    this.updateRouterOperationCallable =
        callableFactory.createOperationCallable(
            updateRouterTransportSettings,
            settings.updateRouterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRouterCallable =
        callableFactory.createUnaryCallable(
            deleteRouterTransportSettings, settings.deleteRouterSettings(), clientContext);
    this.deleteRouterOperationCallable =
        callableFactory.createOperationCallable(
            deleteRouterTransportSettings,
            settings.deleteRouterOperationSettings(),
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
    methodDescriptors.add(initializeZoneMethodDescriptor);
    methodDescriptors.add(listZonesMethodDescriptor);
    methodDescriptors.add(getZoneMethodDescriptor);
    methodDescriptors.add(listNetworksMethodDescriptor);
    methodDescriptors.add(getNetworkMethodDescriptor);
    methodDescriptors.add(diagnoseNetworkMethodDescriptor);
    methodDescriptors.add(createNetworkMethodDescriptor);
    methodDescriptors.add(deleteNetworkMethodDescriptor);
    methodDescriptors.add(listSubnetsMethodDescriptor);
    methodDescriptors.add(getSubnetMethodDescriptor);
    methodDescriptors.add(createSubnetMethodDescriptor);
    methodDescriptors.add(updateSubnetMethodDescriptor);
    methodDescriptors.add(deleteSubnetMethodDescriptor);
    methodDescriptors.add(listInterconnectsMethodDescriptor);
    methodDescriptors.add(getInterconnectMethodDescriptor);
    methodDescriptors.add(diagnoseInterconnectMethodDescriptor);
    methodDescriptors.add(listInterconnectAttachmentsMethodDescriptor);
    methodDescriptors.add(getInterconnectAttachmentMethodDescriptor);
    methodDescriptors.add(createInterconnectAttachmentMethodDescriptor);
    methodDescriptors.add(deleteInterconnectAttachmentMethodDescriptor);
    methodDescriptors.add(listRoutersMethodDescriptor);
    methodDescriptors.add(getRouterMethodDescriptor);
    methodDescriptors.add(diagnoseRouterMethodDescriptor);
    methodDescriptors.add(createRouterMethodDescriptor);
    methodDescriptors.add(updateRouterMethodDescriptor);
    methodDescriptors.add(deleteRouterMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<InitializeZoneRequest, InitializeZoneResponse> initializeZoneCallable() {
    return initializeZoneCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return listZonesCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return listZonesPagedCallable;
  }

  @Override
  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return getZoneCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return listNetworksCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    return listNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return getNetworkCallable;
  }

  @Override
  public UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse> diagnoseNetworkCallable() {
    return diagnoseNetworkCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable() {
    return createNetworkCallable;
  }

  @Override
  public OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable() {
    return createNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable() {
    return deleteNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable() {
    return deleteNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return listSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    return listSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return getSubnetCallable;
  }

  @Override
  public UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable() {
    return createSubnetCallable;
  }

  @Override
  public OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable() {
    return createSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return updateSubnetCallable;
  }

  @Override
  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return updateSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable() {
    return deleteSubnetCallable;
  }

  @Override
  public OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable() {
    return deleteSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable() {
    return listInterconnectsCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    return listInterconnectsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable() {
    return getInterconnectCallable;
  }

  @Override
  public UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable() {
    return diagnoseInterconnectCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable() {
    return listInterconnectAttachmentsCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    return listInterconnectAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    return getInterconnectAttachmentCallable;
  }

  @Override
  public UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable() {
    return createInterconnectAttachmentCallable;
  }

  @Override
  public OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable() {
    return createInterconnectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    return deleteInterconnectAttachmentCallable;
  }

  @Override
  public OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable() {
    return deleteInterconnectAttachmentOperationCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable() {
    return listRoutersCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse> listRoutersPagedCallable() {
    return listRoutersPagedCallable;
  }

  @Override
  public UnaryCallable<GetRouterRequest, Router> getRouterCallable() {
    return getRouterCallable;
  }

  @Override
  public UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse> diagnoseRouterCallable() {
    return diagnoseRouterCallable;
  }

  @Override
  public UnaryCallable<CreateRouterRequest, Operation> createRouterCallable() {
    return createRouterCallable;
  }

  @Override
  public OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable() {
    return createRouterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable() {
    return updateRouterCallable;
  }

  @Override
  public OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable() {
    return updateRouterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable() {
    return deleteRouterCallable;
  }

  @Override
  public OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable() {
    return deleteRouterOperationCallable;
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
