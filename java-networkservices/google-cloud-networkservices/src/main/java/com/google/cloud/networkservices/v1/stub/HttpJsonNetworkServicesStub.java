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

package com.google.cloud.networkservices.v1.stub;

import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewaysPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGrpcRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListHttpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListLocationsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceBindingsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTcpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTlsRoutesPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.CreateGatewayRequest;
import com.google.cloud.networkservices.v1.CreateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.CreateHttpRouteRequest;
import com.google.cloud.networkservices.v1.CreateMeshRequest;
import com.google.cloud.networkservices.v1.CreateServiceBindingRequest;
import com.google.cloud.networkservices.v1.CreateTcpRouteRequest;
import com.google.cloud.networkservices.v1.CreateTlsRouteRequest;
import com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.DeleteGatewayRequest;
import com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest;
import com.google.cloud.networkservices.v1.DeleteHttpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteMeshRequest;
import com.google.cloud.networkservices.v1.DeleteServiceBindingRequest;
import com.google.cloud.networkservices.v1.DeleteTcpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteTlsRouteRequest;
import com.google.cloud.networkservices.v1.EndpointPolicy;
import com.google.cloud.networkservices.v1.Gateway;
import com.google.cloud.networkservices.v1.GetEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.GetGatewayRequest;
import com.google.cloud.networkservices.v1.GetGrpcRouteRequest;
import com.google.cloud.networkservices.v1.GetHttpRouteRequest;
import com.google.cloud.networkservices.v1.GetMeshRequest;
import com.google.cloud.networkservices.v1.GetServiceBindingRequest;
import com.google.cloud.networkservices.v1.GetTcpRouteRequest;
import com.google.cloud.networkservices.v1.GetTlsRouteRequest;
import com.google.cloud.networkservices.v1.GrpcRoute;
import com.google.cloud.networkservices.v1.HttpRoute;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse;
import com.google.cloud.networkservices.v1.ListGatewaysRequest;
import com.google.cloud.networkservices.v1.ListGatewaysResponse;
import com.google.cloud.networkservices.v1.ListGrpcRoutesRequest;
import com.google.cloud.networkservices.v1.ListGrpcRoutesResponse;
import com.google.cloud.networkservices.v1.ListHttpRoutesRequest;
import com.google.cloud.networkservices.v1.ListHttpRoutesResponse;
import com.google.cloud.networkservices.v1.ListMeshesRequest;
import com.google.cloud.networkservices.v1.ListMeshesResponse;
import com.google.cloud.networkservices.v1.ListServiceBindingsRequest;
import com.google.cloud.networkservices.v1.ListServiceBindingsResponse;
import com.google.cloud.networkservices.v1.ListTcpRoutesRequest;
import com.google.cloud.networkservices.v1.ListTcpRoutesResponse;
import com.google.cloud.networkservices.v1.ListTlsRoutesRequest;
import com.google.cloud.networkservices.v1.ListTlsRoutesResponse;
import com.google.cloud.networkservices.v1.Mesh;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.ServiceBinding;
import com.google.cloud.networkservices.v1.TcpRoute;
import com.google.cloud.networkservices.v1.TlsRoute;
import com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.UpdateGatewayRequest;
import com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.UpdateHttpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateMeshRequest;
import com.google.cloud.networkservices.v1.UpdateTcpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateTlsRouteRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the NetworkServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonNetworkServicesStub extends NetworkServicesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(EndpointPolicy.getDescriptor())
          .add(Gateway.getDescriptor())
          .add(TcpRoute.getDescriptor())
          .add(HttpRoute.getDescriptor())
          .add(TlsRoute.getDescriptor())
          .add(Mesh.getDescriptor())
          .add(GrpcRoute.getDescriptor())
          .add(ServiceBinding.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListEndpointPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEndpointPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/endpointPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEndpointPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListEndpointPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEndpointPolicyRequest, EndpointPolicy>
      getEndpointPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetEndpointPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEndpointPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/endpointPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EndpointPolicy>newBuilder()
                      .setDefaultInstance(EndpointPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateEndpointPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateEndpointPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEndpointPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/endpointPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "endpointPolicyId", request.getEndpointPolicyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("endpointPolicy", request.getEndpointPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEndpointPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateEndpointPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/UpdateEndpointPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEndpointPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{endpointPolicy.name=projects/*/locations/*/endpointPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "endpointPolicy.name",
                                request.getEndpointPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("endpointPolicy", request.getEndpointPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEndpointPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteEndpointPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteEndpointPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEndpointPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/endpointPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEndpointPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEndpointPolicyRequest> serializer =
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
                  (DeleteEndpointPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListGatewaysRequest, ListGatewaysResponse>
      listGatewaysMethodDescriptor =
          ApiMethodDescriptor.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListGateways")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGatewaysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gateways",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGatewaysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGatewaysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGatewaysResponse>newBuilder()
                      .setDefaultInstance(ListGatewaysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGatewayRequest, Gateway> getGatewayMethodDescriptor =
      ApiMethodDescriptor.<GetGatewayRequest, Gateway>newBuilder()
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGateway")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGatewayRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/gateways/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetGatewayRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetGatewayRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Gateway>newBuilder()
                  .setDefaultInstance(Gateway.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateGatewayRequest, Operation>
      createGatewayMethodDescriptor =
          ApiMethodDescriptor.<CreateGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGateway")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gateways",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "gatewayId", request.getGatewayId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("gateway", request.getGateway(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGatewayRequest, Operation>
      updateGatewayMethodDescriptor =
          ApiMethodDescriptor.<UpdateGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGateway")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{gateway.name=projects/*/locations/*/gateways/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "gateway.name", request.getGateway().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("gateway", request.getGateway(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGatewayRequest, Operation>
      deleteGatewayMethodDescriptor =
          ApiMethodDescriptor.<DeleteGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGateway")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gateways/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGatewayRequest> serializer =
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
                  (DeleteGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListGrpcRoutesRequest, ListGrpcRoutesResponse>
      listGrpcRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListGrpcRoutesRequest, ListGrpcRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListGrpcRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGrpcRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/grpcRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGrpcRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGrpcRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGrpcRoutesResponse>newBuilder()
                      .setDefaultInstance(ListGrpcRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGrpcRouteRequest, GrpcRoute>
      getGrpcRouteMethodDescriptor =
          ApiMethodDescriptor.<GetGrpcRouteRequest, GrpcRoute>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGrpcRoute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGrpcRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/grpcRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GrpcRoute>newBuilder()
                      .setDefaultInstance(GrpcRoute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGrpcRouteRequest, Operation>
      createGrpcRouteMethodDescriptor =
          ApiMethodDescriptor.<CreateGrpcRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGrpcRoute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGrpcRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/grpcRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "grpcRouteId", request.getGrpcRouteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("grpcRoute", request.getGrpcRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGrpcRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGrpcRouteRequest, Operation>
      updateGrpcRouteMethodDescriptor =
          ApiMethodDescriptor.<UpdateGrpcRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGrpcRoute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGrpcRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{grpcRoute.name=projects/*/locations/*/grpcRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "grpcRoute.name", request.getGrpcRoute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("grpcRoute", request.getGrpcRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGrpcRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGrpcRouteRequest, Operation>
      deleteGrpcRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGrpcRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGrpcRoute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGrpcRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/grpcRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGrpcRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGrpcRouteRequest> serializer =
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
                  (DeleteGrpcRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListHttpRoutesRequest, ListHttpRoutesResponse>
      listHttpRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListHttpRoutesRequest, ListHttpRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListHttpRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHttpRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/httpRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHttpRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHttpRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHttpRoutesResponse>newBuilder()
                      .setDefaultInstance(ListHttpRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHttpRouteRequest, HttpRoute>
      getHttpRouteMethodDescriptor =
          ApiMethodDescriptor.<GetHttpRouteRequest, HttpRoute>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetHttpRoute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHttpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/httpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpRoute>newBuilder()
                      .setDefaultInstance(HttpRoute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateHttpRouteRequest, Operation>
      createHttpRouteMethodDescriptor =
          ApiMethodDescriptor.<CreateHttpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateHttpRoute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHttpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/httpRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "httpRouteId", request.getHttpRouteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("httpRoute", request.getHttpRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateHttpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateHttpRouteRequest, Operation>
      updateHttpRouteMethodDescriptor =
          ApiMethodDescriptor.<UpdateHttpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateHttpRoute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHttpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{httpRoute.name=projects/*/locations/*/httpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "httpRoute.name", request.getHttpRoute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("httpRoute", request.getHttpRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateHttpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteHttpRouteRequest, Operation>
      deleteHttpRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteHttpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteHttpRoute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHttpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/httpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHttpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHttpRouteRequest> serializer =
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
                  (DeleteHttpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTcpRoutesRequest, ListTcpRoutesResponse>
      listTcpRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListTcpRoutesRequest, ListTcpRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListTcpRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTcpRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/tcpRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTcpRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTcpRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTcpRoutesResponse>newBuilder()
                      .setDefaultInstance(ListTcpRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTcpRouteRequest, TcpRoute>
      getTcpRouteMethodDescriptor =
          ApiMethodDescriptor.<GetTcpRouteRequest, TcpRoute>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTcpRoute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTcpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tcpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TcpRoute>newBuilder()
                      .setDefaultInstance(TcpRoute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTcpRouteRequest, Operation>
      createTcpRouteMethodDescriptor =
          ApiMethodDescriptor.<CreateTcpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTcpRoute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTcpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/tcpRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "tcpRouteId", request.getTcpRouteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tcpRoute", request.getTcpRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTcpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTcpRouteRequest, Operation>
      updateTcpRouteMethodDescriptor =
          ApiMethodDescriptor.<UpdateTcpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTcpRoute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTcpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{tcpRoute.name=projects/*/locations/*/tcpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tcpRoute.name", request.getTcpRoute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tcpRoute", request.getTcpRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTcpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTcpRouteRequest, Operation>
      deleteTcpRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTcpRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTcpRoute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTcpRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tcpRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTcpRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTcpRouteRequest> serializer =
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
                  (DeleteTcpRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTlsRoutesRequest, ListTlsRoutesResponse>
      listTlsRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListTlsRoutesRequest, ListTlsRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListTlsRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTlsRoutesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/tlsRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTlsRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTlsRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTlsRoutesResponse>newBuilder()
                      .setDefaultInstance(ListTlsRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTlsRouteRequest, TlsRoute>
      getTlsRouteMethodDescriptor =
          ApiMethodDescriptor.<GetTlsRouteRequest, TlsRoute>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTlsRoute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTlsRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tlsRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TlsRoute>newBuilder()
                      .setDefaultInstance(TlsRoute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTlsRouteRequest, Operation>
      createTlsRouteMethodDescriptor =
          ApiMethodDescriptor.<CreateTlsRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTlsRoute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTlsRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/tlsRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "tlsRouteId", request.getTlsRouteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tlsRoute", request.getTlsRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTlsRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTlsRouteRequest, Operation>
      updateTlsRouteMethodDescriptor =
          ApiMethodDescriptor.<UpdateTlsRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTlsRoute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTlsRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{tlsRoute.name=projects/*/locations/*/tlsRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tlsRoute.name", request.getTlsRoute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tlsRoute", request.getTlsRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTlsRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTlsRouteRequest, Operation>
      deleteTlsRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTlsRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTlsRoute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTlsRouteRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tlsRoutes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTlsRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTlsRouteRequest> serializer =
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
                  (DeleteTlsRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsMethodDescriptor =
          ApiMethodDescriptor.<ListServiceBindingsRequest, ListServiceBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListServiceBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServiceBindingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/serviceBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServiceBindingsResponse>newBuilder()
                      .setDefaultInstance(ListServiceBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceBindingRequest, ServiceBinding>
      getServiceBindingMethodDescriptor =
          ApiMethodDescriptor.<GetServiceBindingRequest, ServiceBinding>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetServiceBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServiceBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/serviceBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServiceBinding>newBuilder()
                      .setDefaultInstance(ServiceBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServiceBindingRequest, Operation>
      createServiceBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateServiceBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/serviceBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "serviceBindingId", request.getServiceBindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("serviceBinding", request.getServiceBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServiceBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServiceBindingRequest, Operation>
      deleteServiceBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceBindingRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteServiceBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceBindingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/serviceBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceBindingRequest> serializer =
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
                  (DeleteServiceBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListMeshesRequest, ListMeshesResponse>
      listMeshesMethodDescriptor =
          ApiMethodDescriptor.<ListMeshesRequest, ListMeshesResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListMeshes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMeshesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/meshes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMeshesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMeshesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMeshesResponse>newBuilder()
                      .setDefaultInstance(ListMeshesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMeshRequest, Mesh> getMeshMethodDescriptor =
      ApiMethodDescriptor.<GetMeshRequest, Mesh>newBuilder()
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetMesh")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetMeshRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/meshes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetMeshRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetMeshRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Mesh>newBuilder()
                  .setDefaultInstance(Mesh.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateMeshRequest, Operation>
      createMeshMethodDescriptor =
          ApiMethodDescriptor.<CreateMeshRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateMesh")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMeshRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/meshes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMeshRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMeshRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "meshId", request.getMeshId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("mesh", request.getMesh(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMeshRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMeshRequest, Operation>
      updateMeshMethodDescriptor =
          ApiMethodDescriptor.<UpdateMeshRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateMesh")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMeshRequest>newBuilder()
                      .setPath(
                          "/v1/{mesh.name=projects/*/locations/*/meshes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMeshRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "mesh.name", request.getMesh().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMeshRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("mesh", request.getMesh(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMeshRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMeshRequest, Operation>
      deleteMeshMethodDescriptor =
          ApiMethodDescriptor.<DeleteMeshRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteMesh")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMeshRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/meshes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMeshRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMeshRequest> serializer =
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
                  (DeleteMeshRequest request, Operation response) ->
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable;
  private final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable;
  private final UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable;
  private final UnaryCallable<CreateEndpointPolicyRequest, Operation> createEndpointPolicyCallable;
  private final OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable;
  private final UnaryCallable<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyCallable;
  private final OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable;
  private final UnaryCallable<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyCallable;
  private final OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable;
  private final UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable;
  private final UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse>
      listGatewaysPagedCallable;
  private final UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable;
  private final UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable;
  private final OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable;
  private final UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable;
  private final OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable;
  private final UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable;
  private final OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable;
  private final UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesResponse> listGrpcRoutesCallable;
  private final UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesPagedResponse>
      listGrpcRoutesPagedCallable;
  private final UnaryCallable<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteCallable;
  private final UnaryCallable<CreateGrpcRouteRequest, Operation> createGrpcRouteCallable;
  private final OperationCallable<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationCallable;
  private final UnaryCallable<UpdateGrpcRouteRequest, Operation> updateGrpcRouteCallable;
  private final OperationCallable<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationCallable;
  private final UnaryCallable<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteCallable;
  private final OperationCallable<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationCallable;
  private final UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesResponse> listHttpRoutesCallable;
  private final UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesPagedResponse>
      listHttpRoutesPagedCallable;
  private final UnaryCallable<GetHttpRouteRequest, HttpRoute> getHttpRouteCallable;
  private final UnaryCallable<CreateHttpRouteRequest, Operation> createHttpRouteCallable;
  private final OperationCallable<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationCallable;
  private final UnaryCallable<UpdateHttpRouteRequest, Operation> updateHttpRouteCallable;
  private final OperationCallable<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationCallable;
  private final UnaryCallable<DeleteHttpRouteRequest, Operation> deleteHttpRouteCallable;
  private final OperationCallable<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationCallable;
  private final UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesResponse> listTcpRoutesCallable;
  private final UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesPagedResponse>
      listTcpRoutesPagedCallable;
  private final UnaryCallable<GetTcpRouteRequest, TcpRoute> getTcpRouteCallable;
  private final UnaryCallable<CreateTcpRouteRequest, Operation> createTcpRouteCallable;
  private final OperationCallable<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationCallable;
  private final UnaryCallable<UpdateTcpRouteRequest, Operation> updateTcpRouteCallable;
  private final OperationCallable<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationCallable;
  private final UnaryCallable<DeleteTcpRouteRequest, Operation> deleteTcpRouteCallable;
  private final OperationCallable<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationCallable;
  private final UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesResponse> listTlsRoutesCallable;
  private final UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesPagedResponse>
      listTlsRoutesPagedCallable;
  private final UnaryCallable<GetTlsRouteRequest, TlsRoute> getTlsRouteCallable;
  private final UnaryCallable<CreateTlsRouteRequest, Operation> createTlsRouteCallable;
  private final OperationCallable<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationCallable;
  private final UnaryCallable<UpdateTlsRouteRequest, Operation> updateTlsRouteCallable;
  private final OperationCallable<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationCallable;
  private final UnaryCallable<DeleteTlsRouteRequest, Operation> deleteTlsRouteCallable;
  private final OperationCallable<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationCallable;
  private final UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsCallable;
  private final UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsPagedResponse>
      listServiceBindingsPagedCallable;
  private final UnaryCallable<GetServiceBindingRequest, ServiceBinding> getServiceBindingCallable;
  private final UnaryCallable<CreateServiceBindingRequest, Operation> createServiceBindingCallable;
  private final OperationCallable<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationCallable;
  private final UnaryCallable<DeleteServiceBindingRequest, Operation> deleteServiceBindingCallable;
  private final OperationCallable<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationCallable;
  private final UnaryCallable<ListMeshesRequest, ListMeshesResponse> listMeshesCallable;
  private final UnaryCallable<ListMeshesRequest, ListMeshesPagedResponse> listMeshesPagedCallable;
  private final UnaryCallable<GetMeshRequest, Mesh> getMeshCallable;
  private final UnaryCallable<CreateMeshRequest, Operation> createMeshCallable;
  private final OperationCallable<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationCallable;
  private final UnaryCallable<UpdateMeshRequest, Operation> updateMeshCallable;
  private final OperationCallable<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationCallable;
  private final UnaryCallable<DeleteMeshRequest, Operation> deleteMeshCallable;
  private final OperationCallable<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworkServicesStub create(NetworkServicesStubSettings settings)
      throws IOException {
    return new HttpJsonNetworkServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkServicesStub(
        NetworkServicesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkServicesStub(
        NetworkServicesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkServicesStub(
      NetworkServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNetworkServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkServicesStub(
      NetworkServicesStubSettings settings,
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

    HttpJsonCallSettings<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
        listEndpointPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
                .setMethodDescriptor(listEndpointPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicyTransportSettings =
            HttpJsonCallSettings.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
                .setMethodDescriptor(getEndpointPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicyTransportSettings =
            HttpJsonCallSettings.<CreateEndpointPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createEndpointPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateEndpointPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateEndpointPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "endpoint_policy.name",
                          String.valueOf(request.getEndpointPolicy().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteEndpointPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteEndpointPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListGatewaysRequest, ListGatewaysResponse> listGatewaysTransportSettings =
        HttpJsonCallSettings.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
            .setMethodDescriptor(listGatewaysMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGatewayRequest, Gateway> getGatewayTransportSettings =
        HttpJsonCallSettings.<GetGatewayRequest, Gateway>newBuilder()
            .setMethodDescriptor(getGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGatewayRequest, Operation> createGatewayTransportSettings =
        HttpJsonCallSettings.<CreateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateGatewayRequest, Operation> updateGatewayTransportSettings =
        HttpJsonCallSettings.<UpdateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("gateway.name", String.valueOf(request.getGateway().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteGatewayRequest, Operation> deleteGatewayTransportSettings =
        HttpJsonCallSettings.<DeleteGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGrpcRoutesRequest, ListGrpcRoutesResponse>
        listGrpcRoutesTransportSettings =
            HttpJsonCallSettings.<ListGrpcRoutesRequest, ListGrpcRoutesResponse>newBuilder()
                .setMethodDescriptor(listGrpcRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteTransportSettings =
        HttpJsonCallSettings.<GetGrpcRouteRequest, GrpcRoute>newBuilder()
            .setMethodDescriptor(getGrpcRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGrpcRouteRequest, Operation> createGrpcRouteTransportSettings =
        HttpJsonCallSettings.<CreateGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createGrpcRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateGrpcRouteRequest, Operation> updateGrpcRouteTransportSettings =
        HttpJsonCallSettings.<UpdateGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGrpcRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("grpc_route.name", String.valueOf(request.getGrpcRoute().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteTransportSettings =
        HttpJsonCallSettings.<DeleteGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGrpcRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHttpRoutesRequest, ListHttpRoutesResponse>
        listHttpRoutesTransportSettings =
            HttpJsonCallSettings.<ListHttpRoutesRequest, ListHttpRoutesResponse>newBuilder()
                .setMethodDescriptor(listHttpRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHttpRouteRequest, HttpRoute> getHttpRouteTransportSettings =
        HttpJsonCallSettings.<GetHttpRouteRequest, HttpRoute>newBuilder()
            .setMethodDescriptor(getHttpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHttpRouteRequest, Operation> createHttpRouteTransportSettings =
        HttpJsonCallSettings.<CreateHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createHttpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateHttpRouteRequest, Operation> updateHttpRouteTransportSettings =
        HttpJsonCallSettings.<UpdateHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHttpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("http_route.name", String.valueOf(request.getHttpRoute().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteHttpRouteRequest, Operation> deleteHttpRouteTransportSettings =
        HttpJsonCallSettings.<DeleteHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHttpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTcpRoutesRequest, ListTcpRoutesResponse>
        listTcpRoutesTransportSettings =
            HttpJsonCallSettings.<ListTcpRoutesRequest, ListTcpRoutesResponse>newBuilder()
                .setMethodDescriptor(listTcpRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTcpRouteRequest, TcpRoute> getTcpRouteTransportSettings =
        HttpJsonCallSettings.<GetTcpRouteRequest, TcpRoute>newBuilder()
            .setMethodDescriptor(getTcpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTcpRouteRequest, Operation> createTcpRouteTransportSettings =
        HttpJsonCallSettings.<CreateTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTcpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTcpRouteRequest, Operation> updateTcpRouteTransportSettings =
        HttpJsonCallSettings.<UpdateTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTcpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tcp_route.name", String.valueOf(request.getTcpRoute().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTcpRouteRequest, Operation> deleteTcpRouteTransportSettings =
        HttpJsonCallSettings.<DeleteTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTcpRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTlsRoutesRequest, ListTlsRoutesResponse>
        listTlsRoutesTransportSettings =
            HttpJsonCallSettings.<ListTlsRoutesRequest, ListTlsRoutesResponse>newBuilder()
                .setMethodDescriptor(listTlsRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTlsRouteRequest, TlsRoute> getTlsRouteTransportSettings =
        HttpJsonCallSettings.<GetTlsRouteRequest, TlsRoute>newBuilder()
            .setMethodDescriptor(getTlsRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTlsRouteRequest, Operation> createTlsRouteTransportSettings =
        HttpJsonCallSettings.<CreateTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTlsRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTlsRouteRequest, Operation> updateTlsRouteTransportSettings =
        HttpJsonCallSettings.<UpdateTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTlsRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tls_route.name", String.valueOf(request.getTlsRoute().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTlsRouteRequest, Operation> deleteTlsRouteTransportSettings =
        HttpJsonCallSettings.<DeleteTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTlsRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListServiceBindingsRequest, ListServiceBindingsResponse>
        listServiceBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListServiceBindingsRequest, ListServiceBindingsResponse>newBuilder()
                .setMethodDescriptor(listServiceBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetServiceBindingRequest, ServiceBinding>
        getServiceBindingTransportSettings =
            HttpJsonCallSettings.<GetServiceBindingRequest, ServiceBinding>newBuilder()
                .setMethodDescriptor(getServiceBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateServiceBindingRequest, Operation>
        createServiceBindingTransportSettings =
            HttpJsonCallSettings.<CreateServiceBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteServiceBindingRequest, Operation>
        deleteServiceBindingTransportSettings =
            HttpJsonCallSettings.<DeleteServiceBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMeshesRequest, ListMeshesResponse> listMeshesTransportSettings =
        HttpJsonCallSettings.<ListMeshesRequest, ListMeshesResponse>newBuilder()
            .setMethodDescriptor(listMeshesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetMeshRequest, Mesh> getMeshTransportSettings =
        HttpJsonCallSettings.<GetMeshRequest, Mesh>newBuilder()
            .setMethodDescriptor(getMeshMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateMeshRequest, Operation> createMeshTransportSettings =
        HttpJsonCallSettings.<CreateMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(createMeshMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMeshRequest, Operation> updateMeshTransportSettings =
        HttpJsonCallSettings.<UpdateMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMeshMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("mesh.name", String.valueOf(request.getMesh().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMeshRequest, Operation> deleteMeshTransportSettings =
        HttpJsonCallSettings.<DeleteMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMeshMethodDescriptor)
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listEndpointPoliciesCallable =
        callableFactory.createUnaryCallable(
            listEndpointPoliciesTransportSettings,
            settings.listEndpointPoliciesSettings(),
            clientContext);
    this.listEndpointPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointPoliciesTransportSettings,
            settings.listEndpointPoliciesSettings(),
            clientContext);
    this.getEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            getEndpointPolicyTransportSettings,
            settings.getEndpointPolicySettings(),
            clientContext);
    this.createEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            createEndpointPolicyTransportSettings,
            settings.createEndpointPolicySettings(),
            clientContext);
    this.createEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createEndpointPolicyTransportSettings,
            settings.createEndpointPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            updateEndpointPolicyTransportSettings,
            settings.updateEndpointPolicySettings(),
            clientContext);
    this.updateEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateEndpointPolicyTransportSettings,
            settings.updateEndpointPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEndpointPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointPolicyTransportSettings,
            settings.deleteEndpointPolicySettings(),
            clientContext);
    this.deleteEndpointPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteEndpointPolicyTransportSettings,
            settings.deleteEndpointPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listGatewaysCallable =
        callableFactory.createUnaryCallable(
            listGatewaysTransportSettings, settings.listGatewaysSettings(), clientContext);
    this.listGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listGatewaysTransportSettings, settings.listGatewaysSettings(), clientContext);
    this.getGatewayCallable =
        callableFactory.createUnaryCallable(
            getGatewayTransportSettings, settings.getGatewaySettings(), clientContext);
    this.createGatewayCallable =
        callableFactory.createUnaryCallable(
            createGatewayTransportSettings, settings.createGatewaySettings(), clientContext);
    this.createGatewayOperationCallable =
        callableFactory.createOperationCallable(
            createGatewayTransportSettings,
            settings.createGatewayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGatewayCallable =
        callableFactory.createUnaryCallable(
            updateGatewayTransportSettings, settings.updateGatewaySettings(), clientContext);
    this.updateGatewayOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewayTransportSettings,
            settings.updateGatewayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteGatewayTransportSettings, settings.deleteGatewaySettings(), clientContext);
    this.deleteGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewayTransportSettings,
            settings.deleteGatewayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listGrpcRoutesCallable =
        callableFactory.createUnaryCallable(
            listGrpcRoutesTransportSettings, settings.listGrpcRoutesSettings(), clientContext);
    this.listGrpcRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listGrpcRoutesTransportSettings, settings.listGrpcRoutesSettings(), clientContext);
    this.getGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            getGrpcRouteTransportSettings, settings.getGrpcRouteSettings(), clientContext);
    this.createGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            createGrpcRouteTransportSettings, settings.createGrpcRouteSettings(), clientContext);
    this.createGrpcRouteOperationCallable =
        callableFactory.createOperationCallable(
            createGrpcRouteTransportSettings,
            settings.createGrpcRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            updateGrpcRouteTransportSettings, settings.updateGrpcRouteSettings(), clientContext);
    this.updateGrpcRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateGrpcRouteTransportSettings,
            settings.updateGrpcRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            deleteGrpcRouteTransportSettings, settings.deleteGrpcRouteSettings(), clientContext);
    this.deleteGrpcRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteGrpcRouteTransportSettings,
            settings.deleteGrpcRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listHttpRoutesCallable =
        callableFactory.createUnaryCallable(
            listHttpRoutesTransportSettings, settings.listHttpRoutesSettings(), clientContext);
    this.listHttpRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listHttpRoutesTransportSettings, settings.listHttpRoutesSettings(), clientContext);
    this.getHttpRouteCallable =
        callableFactory.createUnaryCallable(
            getHttpRouteTransportSettings, settings.getHttpRouteSettings(), clientContext);
    this.createHttpRouteCallable =
        callableFactory.createUnaryCallable(
            createHttpRouteTransportSettings, settings.createHttpRouteSettings(), clientContext);
    this.createHttpRouteOperationCallable =
        callableFactory.createOperationCallable(
            createHttpRouteTransportSettings,
            settings.createHttpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateHttpRouteCallable =
        callableFactory.createUnaryCallable(
            updateHttpRouteTransportSettings, settings.updateHttpRouteSettings(), clientContext);
    this.updateHttpRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateHttpRouteTransportSettings,
            settings.updateHttpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteHttpRouteCallable =
        callableFactory.createUnaryCallable(
            deleteHttpRouteTransportSettings, settings.deleteHttpRouteSettings(), clientContext);
    this.deleteHttpRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteHttpRouteTransportSettings,
            settings.deleteHttpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTcpRoutesCallable =
        callableFactory.createUnaryCallable(
            listTcpRoutesTransportSettings, settings.listTcpRoutesSettings(), clientContext);
    this.listTcpRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listTcpRoutesTransportSettings, settings.listTcpRoutesSettings(), clientContext);
    this.getTcpRouteCallable =
        callableFactory.createUnaryCallable(
            getTcpRouteTransportSettings, settings.getTcpRouteSettings(), clientContext);
    this.createTcpRouteCallable =
        callableFactory.createUnaryCallable(
            createTcpRouteTransportSettings, settings.createTcpRouteSettings(), clientContext);
    this.createTcpRouteOperationCallable =
        callableFactory.createOperationCallable(
            createTcpRouteTransportSettings,
            settings.createTcpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTcpRouteCallable =
        callableFactory.createUnaryCallable(
            updateTcpRouteTransportSettings, settings.updateTcpRouteSettings(), clientContext);
    this.updateTcpRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateTcpRouteTransportSettings,
            settings.updateTcpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTcpRouteCallable =
        callableFactory.createUnaryCallable(
            deleteTcpRouteTransportSettings, settings.deleteTcpRouteSettings(), clientContext);
    this.deleteTcpRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTcpRouteTransportSettings,
            settings.deleteTcpRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTlsRoutesCallable =
        callableFactory.createUnaryCallable(
            listTlsRoutesTransportSettings, settings.listTlsRoutesSettings(), clientContext);
    this.listTlsRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listTlsRoutesTransportSettings, settings.listTlsRoutesSettings(), clientContext);
    this.getTlsRouteCallable =
        callableFactory.createUnaryCallable(
            getTlsRouteTransportSettings, settings.getTlsRouteSettings(), clientContext);
    this.createTlsRouteCallable =
        callableFactory.createUnaryCallable(
            createTlsRouteTransportSettings, settings.createTlsRouteSettings(), clientContext);
    this.createTlsRouteOperationCallable =
        callableFactory.createOperationCallable(
            createTlsRouteTransportSettings,
            settings.createTlsRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTlsRouteCallable =
        callableFactory.createUnaryCallable(
            updateTlsRouteTransportSettings, settings.updateTlsRouteSettings(), clientContext);
    this.updateTlsRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateTlsRouteTransportSettings,
            settings.updateTlsRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTlsRouteCallable =
        callableFactory.createUnaryCallable(
            deleteTlsRouteTransportSettings, settings.deleteTlsRouteSettings(), clientContext);
    this.deleteTlsRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTlsRouteTransportSettings,
            settings.deleteTlsRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listServiceBindingsCallable =
        callableFactory.createUnaryCallable(
            listServiceBindingsTransportSettings,
            settings.listServiceBindingsSettings(),
            clientContext);
    this.listServiceBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceBindingsTransportSettings,
            settings.listServiceBindingsSettings(),
            clientContext);
    this.getServiceBindingCallable =
        callableFactory.createUnaryCallable(
            getServiceBindingTransportSettings,
            settings.getServiceBindingSettings(),
            clientContext);
    this.createServiceBindingCallable =
        callableFactory.createUnaryCallable(
            createServiceBindingTransportSettings,
            settings.createServiceBindingSettings(),
            clientContext);
    this.createServiceBindingOperationCallable =
        callableFactory.createOperationCallable(
            createServiceBindingTransportSettings,
            settings.createServiceBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServiceBindingCallable =
        callableFactory.createUnaryCallable(
            deleteServiceBindingTransportSettings,
            settings.deleteServiceBindingSettings(),
            clientContext);
    this.deleteServiceBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceBindingTransportSettings,
            settings.deleteServiceBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listMeshesCallable =
        callableFactory.createUnaryCallable(
            listMeshesTransportSettings, settings.listMeshesSettings(), clientContext);
    this.listMeshesPagedCallable =
        callableFactory.createPagedCallable(
            listMeshesTransportSettings, settings.listMeshesSettings(), clientContext);
    this.getMeshCallable =
        callableFactory.createUnaryCallable(
            getMeshTransportSettings, settings.getMeshSettings(), clientContext);
    this.createMeshCallable =
        callableFactory.createUnaryCallable(
            createMeshTransportSettings, settings.createMeshSettings(), clientContext);
    this.createMeshOperationCallable =
        callableFactory.createOperationCallable(
            createMeshTransportSettings,
            settings.createMeshOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMeshCallable =
        callableFactory.createUnaryCallable(
            updateMeshTransportSettings, settings.updateMeshSettings(), clientContext);
    this.updateMeshOperationCallable =
        callableFactory.createOperationCallable(
            updateMeshTransportSettings,
            settings.updateMeshOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMeshCallable =
        callableFactory.createUnaryCallable(
            deleteMeshTransportSettings, settings.deleteMeshSettings(), clientContext);
    this.deleteMeshOperationCallable =
        callableFactory.createOperationCallable(
            deleteMeshTransportSettings,
            settings.deleteMeshOperationSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listEndpointPoliciesMethodDescriptor);
    methodDescriptors.add(getEndpointPolicyMethodDescriptor);
    methodDescriptors.add(createEndpointPolicyMethodDescriptor);
    methodDescriptors.add(updateEndpointPolicyMethodDescriptor);
    methodDescriptors.add(deleteEndpointPolicyMethodDescriptor);
    methodDescriptors.add(listGatewaysMethodDescriptor);
    methodDescriptors.add(getGatewayMethodDescriptor);
    methodDescriptors.add(createGatewayMethodDescriptor);
    methodDescriptors.add(updateGatewayMethodDescriptor);
    methodDescriptors.add(deleteGatewayMethodDescriptor);
    methodDescriptors.add(listGrpcRoutesMethodDescriptor);
    methodDescriptors.add(getGrpcRouteMethodDescriptor);
    methodDescriptors.add(createGrpcRouteMethodDescriptor);
    methodDescriptors.add(updateGrpcRouteMethodDescriptor);
    methodDescriptors.add(deleteGrpcRouteMethodDescriptor);
    methodDescriptors.add(listHttpRoutesMethodDescriptor);
    methodDescriptors.add(getHttpRouteMethodDescriptor);
    methodDescriptors.add(createHttpRouteMethodDescriptor);
    methodDescriptors.add(updateHttpRouteMethodDescriptor);
    methodDescriptors.add(deleteHttpRouteMethodDescriptor);
    methodDescriptors.add(listTcpRoutesMethodDescriptor);
    methodDescriptors.add(getTcpRouteMethodDescriptor);
    methodDescriptors.add(createTcpRouteMethodDescriptor);
    methodDescriptors.add(updateTcpRouteMethodDescriptor);
    methodDescriptors.add(deleteTcpRouteMethodDescriptor);
    methodDescriptors.add(listTlsRoutesMethodDescriptor);
    methodDescriptors.add(getTlsRouteMethodDescriptor);
    methodDescriptors.add(createTlsRouteMethodDescriptor);
    methodDescriptors.add(updateTlsRouteMethodDescriptor);
    methodDescriptors.add(deleteTlsRouteMethodDescriptor);
    methodDescriptors.add(listServiceBindingsMethodDescriptor);
    methodDescriptors.add(getServiceBindingMethodDescriptor);
    methodDescriptors.add(createServiceBindingMethodDescriptor);
    methodDescriptors.add(deleteServiceBindingMethodDescriptor);
    methodDescriptors.add(listMeshesMethodDescriptor);
    methodDescriptors.add(getMeshMethodDescriptor);
    methodDescriptors.add(createMeshMethodDescriptor);
    methodDescriptors.add(updateMeshMethodDescriptor);
    methodDescriptors.add(deleteMeshMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable() {
    return listEndpointPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable() {
    return listEndpointPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable() {
    return getEndpointPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateEndpointPolicyRequest, Operation> createEndpointPolicyCallable() {
    return createEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable() {
    return createEndpointPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyCallable() {
    return updateEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable() {
    return updateEndpointPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyCallable() {
    return deleteEndpointPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable() {
    return deleteEndpointPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    return listGatewaysCallable;
  }

  @Override
  public UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse> listGatewaysPagedCallable() {
    return listGatewaysPagedCallable;
  }

  @Override
  public UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    return getGatewayCallable;
  }

  @Override
  public UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    return createGatewayCallable;
  }

  @Override
  public OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    return createGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    return updateGatewayCallable;
  }

  @Override
  public OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    return updateGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    return deleteGatewayCallable;
  }

  @Override
  public OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    return deleteGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesResponse> listGrpcRoutesCallable() {
    return listGrpcRoutesCallable;
  }

  @Override
  public UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesPagedResponse>
      listGrpcRoutesPagedCallable() {
    return listGrpcRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteCallable() {
    return getGrpcRouteCallable;
  }

  @Override
  public UnaryCallable<CreateGrpcRouteRequest, Operation> createGrpcRouteCallable() {
    return createGrpcRouteCallable;
  }

  @Override
  public OperationCallable<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationCallable() {
    return createGrpcRouteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGrpcRouteRequest, Operation> updateGrpcRouteCallable() {
    return updateGrpcRouteCallable;
  }

  @Override
  public OperationCallable<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationCallable() {
    return updateGrpcRouteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteCallable() {
    return deleteGrpcRouteCallable;
  }

  @Override
  public OperationCallable<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationCallable() {
    return deleteGrpcRouteOperationCallable;
  }

  @Override
  public UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesResponse> listHttpRoutesCallable() {
    return listHttpRoutesCallable;
  }

  @Override
  public UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesPagedResponse>
      listHttpRoutesPagedCallable() {
    return listHttpRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GetHttpRouteRequest, HttpRoute> getHttpRouteCallable() {
    return getHttpRouteCallable;
  }

  @Override
  public UnaryCallable<CreateHttpRouteRequest, Operation> createHttpRouteCallable() {
    return createHttpRouteCallable;
  }

  @Override
  public OperationCallable<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationCallable() {
    return createHttpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHttpRouteRequest, Operation> updateHttpRouteCallable() {
    return updateHttpRouteCallable;
  }

  @Override
  public OperationCallable<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationCallable() {
    return updateHttpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHttpRouteRequest, Operation> deleteHttpRouteCallable() {
    return deleteHttpRouteCallable;
  }

  @Override
  public OperationCallable<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationCallable() {
    return deleteHttpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesResponse> listTcpRoutesCallable() {
    return listTcpRoutesCallable;
  }

  @Override
  public UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesPagedResponse>
      listTcpRoutesPagedCallable() {
    return listTcpRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTcpRouteRequest, TcpRoute> getTcpRouteCallable() {
    return getTcpRouteCallable;
  }

  @Override
  public UnaryCallable<CreateTcpRouteRequest, Operation> createTcpRouteCallable() {
    return createTcpRouteCallable;
  }

  @Override
  public OperationCallable<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationCallable() {
    return createTcpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTcpRouteRequest, Operation> updateTcpRouteCallable() {
    return updateTcpRouteCallable;
  }

  @Override
  public OperationCallable<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationCallable() {
    return updateTcpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTcpRouteRequest, Operation> deleteTcpRouteCallable() {
    return deleteTcpRouteCallable;
  }

  @Override
  public OperationCallable<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationCallable() {
    return deleteTcpRouteOperationCallable;
  }

  @Override
  public UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesResponse> listTlsRoutesCallable() {
    return listTlsRoutesCallable;
  }

  @Override
  public UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesPagedResponse>
      listTlsRoutesPagedCallable() {
    return listTlsRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTlsRouteRequest, TlsRoute> getTlsRouteCallable() {
    return getTlsRouteCallable;
  }

  @Override
  public UnaryCallable<CreateTlsRouteRequest, Operation> createTlsRouteCallable() {
    return createTlsRouteCallable;
  }

  @Override
  public OperationCallable<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationCallable() {
    return createTlsRouteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTlsRouteRequest, Operation> updateTlsRouteCallable() {
    return updateTlsRouteCallable;
  }

  @Override
  public OperationCallable<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationCallable() {
    return updateTlsRouteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTlsRouteRequest, Operation> deleteTlsRouteCallable() {
    return deleteTlsRouteCallable;
  }

  @Override
  public OperationCallable<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationCallable() {
    return deleteTlsRouteOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsCallable() {
    return listServiceBindingsCallable;
  }

  @Override
  public UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsPagedResponse>
      listServiceBindingsPagedCallable() {
    return listServiceBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceBindingRequest, ServiceBinding> getServiceBindingCallable() {
    return getServiceBindingCallable;
  }

  @Override
  public UnaryCallable<CreateServiceBindingRequest, Operation> createServiceBindingCallable() {
    return createServiceBindingCallable;
  }

  @Override
  public OperationCallable<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationCallable() {
    return createServiceBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceBindingRequest, Operation> deleteServiceBindingCallable() {
    return deleteServiceBindingCallable;
  }

  @Override
  public OperationCallable<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationCallable() {
    return deleteServiceBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListMeshesRequest, ListMeshesResponse> listMeshesCallable() {
    return listMeshesCallable;
  }

  @Override
  public UnaryCallable<ListMeshesRequest, ListMeshesPagedResponse> listMeshesPagedCallable() {
    return listMeshesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMeshRequest, Mesh> getMeshCallable() {
    return getMeshCallable;
  }

  @Override
  public UnaryCallable<CreateMeshRequest, Operation> createMeshCallable() {
    return createMeshCallable;
  }

  @Override
  public OperationCallable<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationCallable() {
    return createMeshOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMeshRequest, Operation> updateMeshCallable() {
    return updateMeshCallable;
  }

  @Override
  public OperationCallable<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationCallable() {
    return updateMeshOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMeshRequest, Operation> deleteMeshCallable() {
    return deleteMeshCallable;
  }

  @Override
  public OperationCallable<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationCallable() {
    return deleteMeshOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
