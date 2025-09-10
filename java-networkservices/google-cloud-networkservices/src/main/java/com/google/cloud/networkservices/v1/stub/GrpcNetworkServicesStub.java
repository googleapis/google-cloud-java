/*
 * Copyright 2025 Google LLC
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
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewayRouteViewsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewaysPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGrpcRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListHttpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListLocationsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshRouteViewsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceBindingsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceLbPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTcpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTlsRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListWasmPluginVersionsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListWasmPluginsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.cloud.networkservices.v1.CreateServiceLbPolicyRequest;
import com.google.cloud.networkservices.v1.CreateTcpRouteRequest;
import com.google.cloud.networkservices.v1.CreateTlsRouteRequest;
import com.google.cloud.networkservices.v1.CreateWasmPluginRequest;
import com.google.cloud.networkservices.v1.CreateWasmPluginVersionRequest;
import com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.DeleteGatewayRequest;
import com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest;
import com.google.cloud.networkservices.v1.DeleteHttpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteMeshRequest;
import com.google.cloud.networkservices.v1.DeleteServiceBindingRequest;
import com.google.cloud.networkservices.v1.DeleteServiceLbPolicyRequest;
import com.google.cloud.networkservices.v1.DeleteTcpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteTlsRouteRequest;
import com.google.cloud.networkservices.v1.DeleteWasmPluginRequest;
import com.google.cloud.networkservices.v1.DeleteWasmPluginVersionRequest;
import com.google.cloud.networkservices.v1.EndpointPolicy;
import com.google.cloud.networkservices.v1.Gateway;
import com.google.cloud.networkservices.v1.GatewayRouteView;
import com.google.cloud.networkservices.v1.GetEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.GetGatewayRequest;
import com.google.cloud.networkservices.v1.GetGatewayRouteViewRequest;
import com.google.cloud.networkservices.v1.GetGrpcRouteRequest;
import com.google.cloud.networkservices.v1.GetHttpRouteRequest;
import com.google.cloud.networkservices.v1.GetMeshRequest;
import com.google.cloud.networkservices.v1.GetMeshRouteViewRequest;
import com.google.cloud.networkservices.v1.GetServiceBindingRequest;
import com.google.cloud.networkservices.v1.GetServiceLbPolicyRequest;
import com.google.cloud.networkservices.v1.GetTcpRouteRequest;
import com.google.cloud.networkservices.v1.GetTlsRouteRequest;
import com.google.cloud.networkservices.v1.GetWasmPluginRequest;
import com.google.cloud.networkservices.v1.GetWasmPluginVersionRequest;
import com.google.cloud.networkservices.v1.GrpcRoute;
import com.google.cloud.networkservices.v1.HttpRoute;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse;
import com.google.cloud.networkservices.v1.ListGatewayRouteViewsRequest;
import com.google.cloud.networkservices.v1.ListGatewayRouteViewsResponse;
import com.google.cloud.networkservices.v1.ListGatewaysRequest;
import com.google.cloud.networkservices.v1.ListGatewaysResponse;
import com.google.cloud.networkservices.v1.ListGrpcRoutesRequest;
import com.google.cloud.networkservices.v1.ListGrpcRoutesResponse;
import com.google.cloud.networkservices.v1.ListHttpRoutesRequest;
import com.google.cloud.networkservices.v1.ListHttpRoutesResponse;
import com.google.cloud.networkservices.v1.ListMeshRouteViewsRequest;
import com.google.cloud.networkservices.v1.ListMeshRouteViewsResponse;
import com.google.cloud.networkservices.v1.ListMeshesRequest;
import com.google.cloud.networkservices.v1.ListMeshesResponse;
import com.google.cloud.networkservices.v1.ListServiceBindingsRequest;
import com.google.cloud.networkservices.v1.ListServiceBindingsResponse;
import com.google.cloud.networkservices.v1.ListServiceLbPoliciesRequest;
import com.google.cloud.networkservices.v1.ListServiceLbPoliciesResponse;
import com.google.cloud.networkservices.v1.ListTcpRoutesRequest;
import com.google.cloud.networkservices.v1.ListTcpRoutesResponse;
import com.google.cloud.networkservices.v1.ListTlsRoutesRequest;
import com.google.cloud.networkservices.v1.ListTlsRoutesResponse;
import com.google.cloud.networkservices.v1.ListWasmPluginVersionsRequest;
import com.google.cloud.networkservices.v1.ListWasmPluginVersionsResponse;
import com.google.cloud.networkservices.v1.ListWasmPluginsRequest;
import com.google.cloud.networkservices.v1.ListWasmPluginsResponse;
import com.google.cloud.networkservices.v1.Mesh;
import com.google.cloud.networkservices.v1.MeshRouteView;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.ServiceBinding;
import com.google.cloud.networkservices.v1.ServiceLbPolicy;
import com.google.cloud.networkservices.v1.TcpRoute;
import com.google.cloud.networkservices.v1.TlsRoute;
import com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.UpdateGatewayRequest;
import com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.UpdateHttpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateMeshRequest;
import com.google.cloud.networkservices.v1.UpdateServiceBindingRequest;
import com.google.cloud.networkservices.v1.UpdateServiceLbPolicyRequest;
import com.google.cloud.networkservices.v1.UpdateTcpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateTlsRouteRequest;
import com.google.cloud.networkservices.v1.UpdateWasmPluginRequest;
import com.google.cloud.networkservices.v1.WasmPlugin;
import com.google.cloud.networkservices.v1.WasmPluginVersion;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the NetworkServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNetworkServicesStub extends NetworkServicesStub {
  private static final MethodDescriptor<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesMethodDescriptor =
          MethodDescriptor.<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListEndpointPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEndpointPolicyRequest, EndpointPolicy>
      getEndpointPolicyMethodDescriptor =
          MethodDescriptor.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EndpointPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicyMethodDescriptor =
          MethodDescriptor.<CreateEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicyMethodDescriptor =
          MethodDescriptor.<UpdateEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/UpdateEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicyMethodDescriptor =
          MethodDescriptor.<DeleteEndpointPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteEndpointPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>
      listWasmPluginVersionsMethodDescriptor =
          MethodDescriptor
              .<ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListWasmPluginVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWasmPluginVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWasmPluginVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetWasmPluginVersionRequest, WasmPluginVersion>
      getWasmPluginVersionMethodDescriptor =
          MethodDescriptor.<GetWasmPluginVersionRequest, WasmPluginVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetWasmPluginVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWasmPluginVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WasmPluginVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateWasmPluginVersionRequest, Operation>
      createWasmPluginVersionMethodDescriptor =
          MethodDescriptor.<CreateWasmPluginVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateWasmPluginVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWasmPluginVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteWasmPluginVersionRequest, Operation>
      deleteWasmPluginVersionMethodDescriptor =
          MethodDescriptor.<DeleteWasmPluginVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteWasmPluginVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWasmPluginVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListWasmPluginsRequest, ListWasmPluginsResponse>
      listWasmPluginsMethodDescriptor =
          MethodDescriptor.<ListWasmPluginsRequest, ListWasmPluginsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListWasmPlugins")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWasmPluginsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWasmPluginsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetWasmPluginRequest, WasmPlugin>
      getWasmPluginMethodDescriptor =
          MethodDescriptor.<GetWasmPluginRequest, WasmPlugin>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetWasmPlugin")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWasmPluginRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WasmPlugin.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateWasmPluginRequest, Operation>
      createWasmPluginMethodDescriptor =
          MethodDescriptor.<CreateWasmPluginRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateWasmPlugin")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWasmPluginRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateWasmPluginRequest, Operation>
      updateWasmPluginMethodDescriptor =
          MethodDescriptor.<UpdateWasmPluginRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateWasmPlugin")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWasmPluginRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteWasmPluginRequest, Operation>
      deleteWasmPluginMethodDescriptor =
          MethodDescriptor.<DeleteWasmPluginRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteWasmPlugin")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWasmPluginRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListGatewaysRequest, ListGatewaysResponse>
      listGatewaysMethodDescriptor =
          MethodDescriptor.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListGateways")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewaysResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGatewayRequest, Gateway> getGatewayMethodDescriptor =
      MethodDescriptor.<GetGatewayRequest, Gateway>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGateway")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGatewayRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Gateway.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateGatewayRequest, Operation>
      createGatewayMethodDescriptor =
          MethodDescriptor.<CreateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGatewayRequest, Operation>
      updateGatewayMethodDescriptor =
          MethodDescriptor.<UpdateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGatewayRequest, Operation>
      deleteGatewayMethodDescriptor =
          MethodDescriptor.<DeleteGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListGrpcRoutesRequest, ListGrpcRoutesResponse>
      listGrpcRoutesMethodDescriptor =
          MethodDescriptor.<ListGrpcRoutesRequest, ListGrpcRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListGrpcRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGrpcRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGrpcRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGrpcRouteRequest, GrpcRoute>
      getGrpcRouteMethodDescriptor =
          MethodDescriptor.<GetGrpcRouteRequest, GrpcRoute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGrpcRoute")
              .setRequestMarshaller(ProtoUtils.marshaller(GetGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GrpcRoute.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGrpcRouteRequest, Operation>
      createGrpcRouteMethodDescriptor =
          MethodDescriptor.<CreateGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGrpcRouteRequest, Operation>
      updateGrpcRouteMethodDescriptor =
          MethodDescriptor.<UpdateGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGrpcRouteRequest, Operation>
      deleteGrpcRouteMethodDescriptor =
          MethodDescriptor.<DeleteGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHttpRoutesRequest, ListHttpRoutesResponse>
      listHttpRoutesMethodDescriptor =
          MethodDescriptor.<ListHttpRoutesRequest, ListHttpRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListHttpRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHttpRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHttpRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHttpRouteRequest, HttpRoute>
      getHttpRouteMethodDescriptor =
          MethodDescriptor.<GetHttpRouteRequest, HttpRoute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetHttpRoute")
              .setRequestMarshaller(ProtoUtils.marshaller(GetHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpRoute.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateHttpRouteRequest, Operation>
      createHttpRouteMethodDescriptor =
          MethodDescriptor.<CreateHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHttpRouteRequest, Operation>
      updateHttpRouteMethodDescriptor =
          MethodDescriptor.<UpdateHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHttpRouteRequest, Operation>
      deleteHttpRouteMethodDescriptor =
          MethodDescriptor.<DeleteHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTcpRoutesRequest, ListTcpRoutesResponse>
      listTcpRoutesMethodDescriptor =
          MethodDescriptor.<ListTcpRoutesRequest, ListTcpRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListTcpRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTcpRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTcpRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTcpRouteRequest, TcpRoute> getTcpRouteMethodDescriptor =
      MethodDescriptor.<GetTcpRouteRequest, TcpRoute>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTcpRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTcpRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TcpRoute.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateTcpRouteRequest, Operation>
      createTcpRouteMethodDescriptor =
          MethodDescriptor.<CreateTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTcpRouteRequest, Operation>
      updateTcpRouteMethodDescriptor =
          MethodDescriptor.<UpdateTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTcpRouteRequest, Operation>
      deleteTcpRouteMethodDescriptor =
          MethodDescriptor.<DeleteTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTlsRoutesRequest, ListTlsRoutesResponse>
      listTlsRoutesMethodDescriptor =
          MethodDescriptor.<ListTlsRoutesRequest, ListTlsRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListTlsRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTlsRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTlsRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTlsRouteRequest, TlsRoute> getTlsRouteMethodDescriptor =
      MethodDescriptor.<GetTlsRouteRequest, TlsRoute>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTlsRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTlsRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TlsRoute.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateTlsRouteRequest, Operation>
      createTlsRouteMethodDescriptor =
          MethodDescriptor.<CreateTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTlsRouteRequest, Operation>
      updateTlsRouteMethodDescriptor =
          MethodDescriptor.<UpdateTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTlsRouteRequest, Operation>
      deleteTlsRouteMethodDescriptor =
          MethodDescriptor.<DeleteTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsMethodDescriptor =
          MethodDescriptor.<ListServiceBindingsRequest, ListServiceBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListServiceBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceBindingRequest, ServiceBinding>
      getServiceBindingMethodDescriptor =
          MethodDescriptor.<GetServiceBindingRequest, ServiceBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetServiceBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateServiceBindingRequest, Operation>
      createServiceBindingMethodDescriptor =
          MethodDescriptor.<CreateServiceBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateServiceBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceBindingRequest, Operation>
      updateServiceBindingMethodDescriptor =
          MethodDescriptor.<UpdateServiceBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/UpdateServiceBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceBindingRequest, Operation>
      deleteServiceBindingMethodDescriptor =
          MethodDescriptor.<DeleteServiceBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteServiceBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMeshesRequest, ListMeshesResponse>
      listMeshesMethodDescriptor =
          MethodDescriptor.<ListMeshesRequest, ListMeshesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListMeshes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMeshesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListMeshesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMeshRequest, Mesh> getMeshMethodDescriptor =
      MethodDescriptor.<GetMeshRequest, Mesh>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Mesh.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateMeshRequest, Operation> createMeshMethodDescriptor =
      MethodDescriptor.<CreateMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateMeshRequest, Operation> updateMeshMethodDescriptor =
      MethodDescriptor.<UpdateMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteMeshRequest, Operation> deleteMeshMethodDescriptor =
      MethodDescriptor.<DeleteMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>
      listServiceLbPoliciesMethodDescriptor =
          MethodDescriptor.<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListServiceLbPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceLbPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceLbPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceLbPolicyRequest, ServiceLbPolicy>
      getServiceLbPolicyMethodDescriptor =
          MethodDescriptor.<GetServiceLbPolicyRequest, ServiceLbPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetServiceLbPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceLbPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceLbPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateServiceLbPolicyRequest, Operation>
      createServiceLbPolicyMethodDescriptor =
          MethodDescriptor.<CreateServiceLbPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/CreateServiceLbPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceLbPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceLbPolicyRequest, Operation>
      updateServiceLbPolicyMethodDescriptor =
          MethodDescriptor.<UpdateServiceLbPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/UpdateServiceLbPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceLbPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceLbPolicyRequest, Operation>
      deleteServiceLbPolicyMethodDescriptor =
          MethodDescriptor.<DeleteServiceLbPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/DeleteServiceLbPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceLbPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGatewayRouteViewRequest, GatewayRouteView>
      getGatewayRouteViewMethodDescriptor =
          MethodDescriptor.<GetGatewayRouteViewRequest, GatewayRouteView>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/GetGatewayRouteView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGatewayRouteViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GatewayRouteView.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMeshRouteViewRequest, MeshRouteView>
      getMeshRouteViewMethodDescriptor =
          MethodDescriptor.<GetMeshRouteViewRequest, MeshRouteView>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetMeshRouteView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMeshRouteViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MeshRouteView.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>
      listGatewayRouteViewsMethodDescriptor =
          MethodDescriptor.<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListGatewayRouteViews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGatewayRouteViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewayRouteViewsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>
      listMeshRouteViewsMethodDescriptor =
          MethodDescriptor.<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.NetworkServices/ListMeshRouteViews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMeshRouteViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMeshRouteViewsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
  private final UnaryCallable<ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>
      listWasmPluginVersionsCallable;
  private final UnaryCallable<ListWasmPluginVersionsRequest, ListWasmPluginVersionsPagedResponse>
      listWasmPluginVersionsPagedCallable;
  private final UnaryCallable<GetWasmPluginVersionRequest, WasmPluginVersion>
      getWasmPluginVersionCallable;
  private final UnaryCallable<CreateWasmPluginVersionRequest, Operation>
      createWasmPluginVersionCallable;
  private final OperationCallable<
          CreateWasmPluginVersionRequest, WasmPluginVersion, OperationMetadata>
      createWasmPluginVersionOperationCallable;
  private final UnaryCallable<DeleteWasmPluginVersionRequest, Operation>
      deleteWasmPluginVersionCallable;
  private final OperationCallable<DeleteWasmPluginVersionRequest, Empty, OperationMetadata>
      deleteWasmPluginVersionOperationCallable;
  private final UnaryCallable<ListWasmPluginsRequest, ListWasmPluginsResponse>
      listWasmPluginsCallable;
  private final UnaryCallable<ListWasmPluginsRequest, ListWasmPluginsPagedResponse>
      listWasmPluginsPagedCallable;
  private final UnaryCallable<GetWasmPluginRequest, WasmPlugin> getWasmPluginCallable;
  private final UnaryCallable<CreateWasmPluginRequest, Operation> createWasmPluginCallable;
  private final OperationCallable<CreateWasmPluginRequest, WasmPlugin, OperationMetadata>
      createWasmPluginOperationCallable;
  private final UnaryCallable<UpdateWasmPluginRequest, Operation> updateWasmPluginCallable;
  private final OperationCallable<UpdateWasmPluginRequest, WasmPlugin, OperationMetadata>
      updateWasmPluginOperationCallable;
  private final UnaryCallable<DeleteWasmPluginRequest, Operation> deleteWasmPluginCallable;
  private final OperationCallable<DeleteWasmPluginRequest, Empty, OperationMetadata>
      deleteWasmPluginOperationCallable;
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
  private final UnaryCallable<UpdateServiceBindingRequest, Operation> updateServiceBindingCallable;
  private final OperationCallable<UpdateServiceBindingRequest, ServiceBinding, OperationMetadata>
      updateServiceBindingOperationCallable;
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
  private final UnaryCallable<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>
      listServiceLbPoliciesCallable;
  private final UnaryCallable<ListServiceLbPoliciesRequest, ListServiceLbPoliciesPagedResponse>
      listServiceLbPoliciesPagedCallable;
  private final UnaryCallable<GetServiceLbPolicyRequest, ServiceLbPolicy>
      getServiceLbPolicyCallable;
  private final UnaryCallable<CreateServiceLbPolicyRequest, Operation>
      createServiceLbPolicyCallable;
  private final OperationCallable<CreateServiceLbPolicyRequest, ServiceLbPolicy, OperationMetadata>
      createServiceLbPolicyOperationCallable;
  private final UnaryCallable<UpdateServiceLbPolicyRequest, Operation>
      updateServiceLbPolicyCallable;
  private final OperationCallable<UpdateServiceLbPolicyRequest, ServiceLbPolicy, OperationMetadata>
      updateServiceLbPolicyOperationCallable;
  private final UnaryCallable<DeleteServiceLbPolicyRequest, Operation>
      deleteServiceLbPolicyCallable;
  private final OperationCallable<DeleteServiceLbPolicyRequest, Empty, OperationMetadata>
      deleteServiceLbPolicyOperationCallable;
  private final UnaryCallable<GetGatewayRouteViewRequest, GatewayRouteView>
      getGatewayRouteViewCallable;
  private final UnaryCallable<GetMeshRouteViewRequest, MeshRouteView> getMeshRouteViewCallable;
  private final UnaryCallable<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>
      listGatewayRouteViewsCallable;
  private final UnaryCallable<ListGatewayRouteViewsRequest, ListGatewayRouteViewsPagedResponse>
      listGatewayRouteViewsPagedCallable;
  private final UnaryCallable<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>
      listMeshRouteViewsCallable;
  private final UnaryCallable<ListMeshRouteViewsRequest, ListMeshRouteViewsPagedResponse>
      listMeshRouteViewsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNetworkServicesStub create(NetworkServicesStubSettings settings)
      throws IOException {
    return new GrpcNetworkServicesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNetworkServicesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNetworkServicesStub(
        NetworkServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNetworkServicesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNetworkServicesStub(
        NetworkServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNetworkServicesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkServicesStub(
      NetworkServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNetworkServicesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNetworkServicesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkServicesStub(
      NetworkServicesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
        listEndpointPoliciesTransportSettings =
            GrpcCallSettings.<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>newBuilder()
                .setMethodDescriptor(listEndpointPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyTransportSettings =
        GrpcCallSettings.<GetEndpointPolicyRequest, EndpointPolicy>newBuilder()
            .setMethodDescriptor(getEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEndpointPolicyRequest, Operation> createEndpointPolicyTransportSettings =
        GrpcCallSettings.<CreateEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyTransportSettings =
        GrpcCallSettings.<UpdateEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "endpoint_policy.name",
                      String.valueOf(request.getEndpointPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyTransportSettings =
        GrpcCallSettings.<DeleteEndpointPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEndpointPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>
        listWasmPluginVersionsTransportSettings =
            GrpcCallSettings
                .<ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>newBuilder()
                .setMethodDescriptor(listWasmPluginVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWasmPluginVersionRequest, WasmPluginVersion>
        getWasmPluginVersionTransportSettings =
            GrpcCallSettings.<GetWasmPluginVersionRequest, WasmPluginVersion>newBuilder()
                .setMethodDescriptor(getWasmPluginVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWasmPluginVersionRequest, Operation>
        createWasmPluginVersionTransportSettings =
            GrpcCallSettings.<CreateWasmPluginVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(createWasmPluginVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWasmPluginVersionRequest, Operation>
        deleteWasmPluginVersionTransportSettings =
            GrpcCallSettings.<DeleteWasmPluginVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWasmPluginVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWasmPluginsRequest, ListWasmPluginsResponse>
        listWasmPluginsTransportSettings =
            GrpcCallSettings.<ListWasmPluginsRequest, ListWasmPluginsResponse>newBuilder()
                .setMethodDescriptor(listWasmPluginsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWasmPluginRequest, WasmPlugin> getWasmPluginTransportSettings =
        GrpcCallSettings.<GetWasmPluginRequest, WasmPlugin>newBuilder()
            .setMethodDescriptor(getWasmPluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateWasmPluginRequest, Operation> createWasmPluginTransportSettings =
        GrpcCallSettings.<CreateWasmPluginRequest, Operation>newBuilder()
            .setMethodDescriptor(createWasmPluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateWasmPluginRequest, Operation> updateWasmPluginTransportSettings =
        GrpcCallSettings.<UpdateWasmPluginRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWasmPluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "wasm_plugin.name", String.valueOf(request.getWasmPlugin().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWasmPluginRequest, Operation> deleteWasmPluginTransportSettings =
        GrpcCallSettings.<DeleteWasmPluginRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWasmPluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGatewaysRequest, ListGatewaysResponse> listGatewaysTransportSettings =
        GrpcCallSettings.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
            .setMethodDescriptor(listGatewaysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGatewayRequest, Gateway> getGatewayTransportSettings =
        GrpcCallSettings.<GetGatewayRequest, Gateway>newBuilder()
            .setMethodDescriptor(getGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGatewayRequest, Operation> createGatewayTransportSettings =
        GrpcCallSettings.<CreateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGatewayRequest, Operation> updateGatewayTransportSettings =
        GrpcCallSettings.<UpdateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("gateway.name", String.valueOf(request.getGateway().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGatewayRequest, Operation> deleteGatewayTransportSettings =
        GrpcCallSettings.<DeleteGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGrpcRoutesRequest, ListGrpcRoutesResponse>
        listGrpcRoutesTransportSettings =
            GrpcCallSettings.<ListGrpcRoutesRequest, ListGrpcRoutesResponse>newBuilder()
                .setMethodDescriptor(listGrpcRoutesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteTransportSettings =
        GrpcCallSettings.<GetGrpcRouteRequest, GrpcRoute>newBuilder()
            .setMethodDescriptor(getGrpcRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGrpcRouteRequest, Operation> createGrpcRouteTransportSettings =
        GrpcCallSettings.<CreateGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createGrpcRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGrpcRouteRequest, Operation> updateGrpcRouteTransportSettings =
        GrpcCallSettings.<UpdateGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGrpcRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("grpc_route.name", String.valueOf(request.getGrpcRoute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteTransportSettings =
        GrpcCallSettings.<DeleteGrpcRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGrpcRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHttpRoutesRequest, ListHttpRoutesResponse>
        listHttpRoutesTransportSettings =
            GrpcCallSettings.<ListHttpRoutesRequest, ListHttpRoutesResponse>newBuilder()
                .setMethodDescriptor(listHttpRoutesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetHttpRouteRequest, HttpRoute> getHttpRouteTransportSettings =
        GrpcCallSettings.<GetHttpRouteRequest, HttpRoute>newBuilder()
            .setMethodDescriptor(getHttpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHttpRouteRequest, Operation> createHttpRouteTransportSettings =
        GrpcCallSettings.<CreateHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createHttpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHttpRouteRequest, Operation> updateHttpRouteTransportSettings =
        GrpcCallSettings.<UpdateHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHttpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("http_route.name", String.valueOf(request.getHttpRoute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHttpRouteRequest, Operation> deleteHttpRouteTransportSettings =
        GrpcCallSettings.<DeleteHttpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHttpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTcpRoutesRequest, ListTcpRoutesResponse> listTcpRoutesTransportSettings =
        GrpcCallSettings.<ListTcpRoutesRequest, ListTcpRoutesResponse>newBuilder()
            .setMethodDescriptor(listTcpRoutesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTcpRouteRequest, TcpRoute> getTcpRouteTransportSettings =
        GrpcCallSettings.<GetTcpRouteRequest, TcpRoute>newBuilder()
            .setMethodDescriptor(getTcpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTcpRouteRequest, Operation> createTcpRouteTransportSettings =
        GrpcCallSettings.<CreateTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTcpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTcpRouteRequest, Operation> updateTcpRouteTransportSettings =
        GrpcCallSettings.<UpdateTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTcpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tcp_route.name", String.valueOf(request.getTcpRoute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTcpRouteRequest, Operation> deleteTcpRouteTransportSettings =
        GrpcCallSettings.<DeleteTcpRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTcpRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTlsRoutesRequest, ListTlsRoutesResponse> listTlsRoutesTransportSettings =
        GrpcCallSettings.<ListTlsRoutesRequest, ListTlsRoutesResponse>newBuilder()
            .setMethodDescriptor(listTlsRoutesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTlsRouteRequest, TlsRoute> getTlsRouteTransportSettings =
        GrpcCallSettings.<GetTlsRouteRequest, TlsRoute>newBuilder()
            .setMethodDescriptor(getTlsRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTlsRouteRequest, Operation> createTlsRouteTransportSettings =
        GrpcCallSettings.<CreateTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTlsRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTlsRouteRequest, Operation> updateTlsRouteTransportSettings =
        GrpcCallSettings.<UpdateTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTlsRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tls_route.name", String.valueOf(request.getTlsRoute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTlsRouteRequest, Operation> deleteTlsRouteTransportSettings =
        GrpcCallSettings.<DeleteTlsRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTlsRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListServiceBindingsRequest, ListServiceBindingsResponse>
        listServiceBindingsTransportSettings =
            GrpcCallSettings.<ListServiceBindingsRequest, ListServiceBindingsResponse>newBuilder()
                .setMethodDescriptor(listServiceBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceBindingRequest, ServiceBinding> getServiceBindingTransportSettings =
        GrpcCallSettings.<GetServiceBindingRequest, ServiceBinding>newBuilder()
            .setMethodDescriptor(getServiceBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateServiceBindingRequest, Operation> createServiceBindingTransportSettings =
        GrpcCallSettings.<CreateServiceBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateServiceBindingRequest, Operation> updateServiceBindingTransportSettings =
        GrpcCallSettings.<UpdateServiceBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "service_binding.name",
                      String.valueOf(request.getServiceBinding().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteServiceBindingRequest, Operation> deleteServiceBindingTransportSettings =
        GrpcCallSettings.<DeleteServiceBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMeshesRequest, ListMeshesResponse> listMeshesTransportSettings =
        GrpcCallSettings.<ListMeshesRequest, ListMeshesResponse>newBuilder()
            .setMethodDescriptor(listMeshesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMeshRequest, Mesh> getMeshTransportSettings =
        GrpcCallSettings.<GetMeshRequest, Mesh>newBuilder()
            .setMethodDescriptor(getMeshMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMeshRequest, Operation> createMeshTransportSettings =
        GrpcCallSettings.<CreateMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(createMeshMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMeshRequest, Operation> updateMeshTransportSettings =
        GrpcCallSettings.<UpdateMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMeshMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("mesh.name", String.valueOf(request.getMesh().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMeshRequest, Operation> deleteMeshTransportSettings =
        GrpcCallSettings.<DeleteMeshRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMeshMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>
        listServiceLbPoliciesTransportSettings =
            GrpcCallSettings
                .<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>newBuilder()
                .setMethodDescriptor(listServiceLbPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceLbPolicyRequest, ServiceLbPolicy>
        getServiceLbPolicyTransportSettings =
            GrpcCallSettings.<GetServiceLbPolicyRequest, ServiceLbPolicy>newBuilder()
                .setMethodDescriptor(getServiceLbPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceLbPolicyRequest, Operation>
        createServiceLbPolicyTransportSettings =
            GrpcCallSettings.<CreateServiceLbPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceLbPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateServiceLbPolicyRequest, Operation>
        updateServiceLbPolicyTransportSettings =
            GrpcCallSettings.<UpdateServiceLbPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServiceLbPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "service_lb_policy.name",
                          String.valueOf(request.getServiceLbPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceLbPolicyRequest, Operation>
        deleteServiceLbPolicyTransportSettings =
            GrpcCallSettings.<DeleteServiceLbPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceLbPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGatewayRouteViewRequest, GatewayRouteView>
        getGatewayRouteViewTransportSettings =
            GrpcCallSettings.<GetGatewayRouteViewRequest, GatewayRouteView>newBuilder()
                .setMethodDescriptor(getGatewayRouteViewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMeshRouteViewRequest, MeshRouteView> getMeshRouteViewTransportSettings =
        GrpcCallSettings.<GetMeshRouteViewRequest, MeshRouteView>newBuilder()
            .setMethodDescriptor(getMeshRouteViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>
        listGatewayRouteViewsTransportSettings =
            GrpcCallSettings
                .<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>newBuilder()
                .setMethodDescriptor(listGatewayRouteViewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>
        listMeshRouteViewsTransportSettings =
            GrpcCallSettings.<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>newBuilder()
                .setMethodDescriptor(listMeshRouteViewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.listWasmPluginVersionsCallable =
        callableFactory.createUnaryCallable(
            listWasmPluginVersionsTransportSettings,
            settings.listWasmPluginVersionsSettings(),
            clientContext);
    this.listWasmPluginVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listWasmPluginVersionsTransportSettings,
            settings.listWasmPluginVersionsSettings(),
            clientContext);
    this.getWasmPluginVersionCallable =
        callableFactory.createUnaryCallable(
            getWasmPluginVersionTransportSettings,
            settings.getWasmPluginVersionSettings(),
            clientContext);
    this.createWasmPluginVersionCallable =
        callableFactory.createUnaryCallable(
            createWasmPluginVersionTransportSettings,
            settings.createWasmPluginVersionSettings(),
            clientContext);
    this.createWasmPluginVersionOperationCallable =
        callableFactory.createOperationCallable(
            createWasmPluginVersionTransportSettings,
            settings.createWasmPluginVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWasmPluginVersionCallable =
        callableFactory.createUnaryCallable(
            deleteWasmPluginVersionTransportSettings,
            settings.deleteWasmPluginVersionSettings(),
            clientContext);
    this.deleteWasmPluginVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteWasmPluginVersionTransportSettings,
            settings.deleteWasmPluginVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.listWasmPluginsCallable =
        callableFactory.createUnaryCallable(
            listWasmPluginsTransportSettings, settings.listWasmPluginsSettings(), clientContext);
    this.listWasmPluginsPagedCallable =
        callableFactory.createPagedCallable(
            listWasmPluginsTransportSettings, settings.listWasmPluginsSettings(), clientContext);
    this.getWasmPluginCallable =
        callableFactory.createUnaryCallable(
            getWasmPluginTransportSettings, settings.getWasmPluginSettings(), clientContext);
    this.createWasmPluginCallable =
        callableFactory.createUnaryCallable(
            createWasmPluginTransportSettings, settings.createWasmPluginSettings(), clientContext);
    this.createWasmPluginOperationCallable =
        callableFactory.createOperationCallable(
            createWasmPluginTransportSettings,
            settings.createWasmPluginOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWasmPluginCallable =
        callableFactory.createUnaryCallable(
            updateWasmPluginTransportSettings, settings.updateWasmPluginSettings(), clientContext);
    this.updateWasmPluginOperationCallable =
        callableFactory.createOperationCallable(
            updateWasmPluginTransportSettings,
            settings.updateWasmPluginOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWasmPluginCallable =
        callableFactory.createUnaryCallable(
            deleteWasmPluginTransportSettings, settings.deleteWasmPluginSettings(), clientContext);
    this.deleteWasmPluginOperationCallable =
        callableFactory.createOperationCallable(
            deleteWasmPluginTransportSettings,
            settings.deleteWasmPluginOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateGatewayCallable =
        callableFactory.createUnaryCallable(
            updateGatewayTransportSettings, settings.updateGatewaySettings(), clientContext);
    this.updateGatewayOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewayTransportSettings,
            settings.updateGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteGatewayTransportSettings, settings.deleteGatewaySettings(), clientContext);
    this.deleteGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewayTransportSettings,
            settings.deleteGatewayOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            updateGrpcRouteTransportSettings, settings.updateGrpcRouteSettings(), clientContext);
    this.updateGrpcRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateGrpcRouteTransportSettings,
            settings.updateGrpcRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGrpcRouteCallable =
        callableFactory.createUnaryCallable(
            deleteGrpcRouteTransportSettings, settings.deleteGrpcRouteSettings(), clientContext);
    this.deleteGrpcRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteGrpcRouteTransportSettings,
            settings.deleteGrpcRouteOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateHttpRouteCallable =
        callableFactory.createUnaryCallable(
            updateHttpRouteTransportSettings, settings.updateHttpRouteSettings(), clientContext);
    this.updateHttpRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateHttpRouteTransportSettings,
            settings.updateHttpRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHttpRouteCallable =
        callableFactory.createUnaryCallable(
            deleteHttpRouteTransportSettings, settings.deleteHttpRouteSettings(), clientContext);
    this.deleteHttpRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteHttpRouteTransportSettings,
            settings.deleteHttpRouteOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateTcpRouteCallable =
        callableFactory.createUnaryCallable(
            updateTcpRouteTransportSettings, settings.updateTcpRouteSettings(), clientContext);
    this.updateTcpRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateTcpRouteTransportSettings,
            settings.updateTcpRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTcpRouteCallable =
        callableFactory.createUnaryCallable(
            deleteTcpRouteTransportSettings, settings.deleteTcpRouteSettings(), clientContext);
    this.deleteTcpRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTcpRouteTransportSettings,
            settings.deleteTcpRouteOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateTlsRouteCallable =
        callableFactory.createUnaryCallable(
            updateTlsRouteTransportSettings, settings.updateTlsRouteSettings(), clientContext);
    this.updateTlsRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateTlsRouteTransportSettings,
            settings.updateTlsRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTlsRouteCallable =
        callableFactory.createUnaryCallable(
            deleteTlsRouteTransportSettings, settings.deleteTlsRouteSettings(), clientContext);
    this.deleteTlsRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTlsRouteTransportSettings,
            settings.deleteTlsRouteOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateServiceBindingCallable =
        callableFactory.createUnaryCallable(
            updateServiceBindingTransportSettings,
            settings.updateServiceBindingSettings(),
            clientContext);
    this.updateServiceBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceBindingTransportSettings,
            settings.updateServiceBindingOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.updateMeshCallable =
        callableFactory.createUnaryCallable(
            updateMeshTransportSettings, settings.updateMeshSettings(), clientContext);
    this.updateMeshOperationCallable =
        callableFactory.createOperationCallable(
            updateMeshTransportSettings,
            settings.updateMeshOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMeshCallable =
        callableFactory.createUnaryCallable(
            deleteMeshTransportSettings, settings.deleteMeshSettings(), clientContext);
    this.deleteMeshOperationCallable =
        callableFactory.createOperationCallable(
            deleteMeshTransportSettings,
            settings.deleteMeshOperationSettings(),
            clientContext,
            operationsStub);
    this.listServiceLbPoliciesCallable =
        callableFactory.createUnaryCallable(
            listServiceLbPoliciesTransportSettings,
            settings.listServiceLbPoliciesSettings(),
            clientContext);
    this.listServiceLbPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listServiceLbPoliciesTransportSettings,
            settings.listServiceLbPoliciesSettings(),
            clientContext);
    this.getServiceLbPolicyCallable =
        callableFactory.createUnaryCallable(
            getServiceLbPolicyTransportSettings,
            settings.getServiceLbPolicySettings(),
            clientContext);
    this.createServiceLbPolicyCallable =
        callableFactory.createUnaryCallable(
            createServiceLbPolicyTransportSettings,
            settings.createServiceLbPolicySettings(),
            clientContext);
    this.createServiceLbPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createServiceLbPolicyTransportSettings,
            settings.createServiceLbPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServiceLbPolicyCallable =
        callableFactory.createUnaryCallable(
            updateServiceLbPolicyTransportSettings,
            settings.updateServiceLbPolicySettings(),
            clientContext);
    this.updateServiceLbPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceLbPolicyTransportSettings,
            settings.updateServiceLbPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceLbPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteServiceLbPolicyTransportSettings,
            settings.deleteServiceLbPolicySettings(),
            clientContext);
    this.deleteServiceLbPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceLbPolicyTransportSettings,
            settings.deleteServiceLbPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.getGatewayRouteViewCallable =
        callableFactory.createUnaryCallable(
            getGatewayRouteViewTransportSettings,
            settings.getGatewayRouteViewSettings(),
            clientContext);
    this.getMeshRouteViewCallable =
        callableFactory.createUnaryCallable(
            getMeshRouteViewTransportSettings, settings.getMeshRouteViewSettings(), clientContext);
    this.listGatewayRouteViewsCallable =
        callableFactory.createUnaryCallable(
            listGatewayRouteViewsTransportSettings,
            settings.listGatewayRouteViewsSettings(),
            clientContext);
    this.listGatewayRouteViewsPagedCallable =
        callableFactory.createPagedCallable(
            listGatewayRouteViewsTransportSettings,
            settings.listGatewayRouteViewsSettings(),
            clientContext);
    this.listMeshRouteViewsCallable =
        callableFactory.createUnaryCallable(
            listMeshRouteViewsTransportSettings,
            settings.listMeshRouteViewsSettings(),
            clientContext);
    this.listMeshRouteViewsPagedCallable =
        callableFactory.createPagedCallable(
            listMeshRouteViewsTransportSettings,
            settings.listMeshRouteViewsSettings(),
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<ListWasmPluginVersionsRequest, ListWasmPluginVersionsResponse>
      listWasmPluginVersionsCallable() {
    return listWasmPluginVersionsCallable;
  }

  @Override
  public UnaryCallable<ListWasmPluginVersionsRequest, ListWasmPluginVersionsPagedResponse>
      listWasmPluginVersionsPagedCallable() {
    return listWasmPluginVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWasmPluginVersionRequest, WasmPluginVersion>
      getWasmPluginVersionCallable() {
    return getWasmPluginVersionCallable;
  }

  @Override
  public UnaryCallable<CreateWasmPluginVersionRequest, Operation>
      createWasmPluginVersionCallable() {
    return createWasmPluginVersionCallable;
  }

  @Override
  public OperationCallable<CreateWasmPluginVersionRequest, WasmPluginVersion, OperationMetadata>
      createWasmPluginVersionOperationCallable() {
    return createWasmPluginVersionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWasmPluginVersionRequest, Operation>
      deleteWasmPluginVersionCallable() {
    return deleteWasmPluginVersionCallable;
  }

  @Override
  public OperationCallable<DeleteWasmPluginVersionRequest, Empty, OperationMetadata>
      deleteWasmPluginVersionOperationCallable() {
    return deleteWasmPluginVersionOperationCallable;
  }

  @Override
  public UnaryCallable<ListWasmPluginsRequest, ListWasmPluginsResponse> listWasmPluginsCallable() {
    return listWasmPluginsCallable;
  }

  @Override
  public UnaryCallable<ListWasmPluginsRequest, ListWasmPluginsPagedResponse>
      listWasmPluginsPagedCallable() {
    return listWasmPluginsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWasmPluginRequest, WasmPlugin> getWasmPluginCallable() {
    return getWasmPluginCallable;
  }

  @Override
  public UnaryCallable<CreateWasmPluginRequest, Operation> createWasmPluginCallable() {
    return createWasmPluginCallable;
  }

  @Override
  public OperationCallable<CreateWasmPluginRequest, WasmPlugin, OperationMetadata>
      createWasmPluginOperationCallable() {
    return createWasmPluginOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWasmPluginRequest, Operation> updateWasmPluginCallable() {
    return updateWasmPluginCallable;
  }

  @Override
  public OperationCallable<UpdateWasmPluginRequest, WasmPlugin, OperationMetadata>
      updateWasmPluginOperationCallable() {
    return updateWasmPluginOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWasmPluginRequest, Operation> deleteWasmPluginCallable() {
    return deleteWasmPluginCallable;
  }

  @Override
  public OperationCallable<DeleteWasmPluginRequest, Empty, OperationMetadata>
      deleteWasmPluginOperationCallable() {
    return deleteWasmPluginOperationCallable;
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
  public UnaryCallable<UpdateServiceBindingRequest, Operation> updateServiceBindingCallable() {
    return updateServiceBindingCallable;
  }

  @Override
  public OperationCallable<UpdateServiceBindingRequest, ServiceBinding, OperationMetadata>
      updateServiceBindingOperationCallable() {
    return updateServiceBindingOperationCallable;
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
  public UnaryCallable<ListServiceLbPoliciesRequest, ListServiceLbPoliciesResponse>
      listServiceLbPoliciesCallable() {
    return listServiceLbPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListServiceLbPoliciesRequest, ListServiceLbPoliciesPagedResponse>
      listServiceLbPoliciesPagedCallable() {
    return listServiceLbPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceLbPolicyRequest, ServiceLbPolicy> getServiceLbPolicyCallable() {
    return getServiceLbPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateServiceLbPolicyRequest, Operation> createServiceLbPolicyCallable() {
    return createServiceLbPolicyCallable;
  }

  @Override
  public OperationCallable<CreateServiceLbPolicyRequest, ServiceLbPolicy, OperationMetadata>
      createServiceLbPolicyOperationCallable() {
    return createServiceLbPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceLbPolicyRequest, Operation> updateServiceLbPolicyCallable() {
    return updateServiceLbPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateServiceLbPolicyRequest, ServiceLbPolicy, OperationMetadata>
      updateServiceLbPolicyOperationCallable() {
    return updateServiceLbPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceLbPolicyRequest, Operation> deleteServiceLbPolicyCallable() {
    return deleteServiceLbPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteServiceLbPolicyRequest, Empty, OperationMetadata>
      deleteServiceLbPolicyOperationCallable() {
    return deleteServiceLbPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetGatewayRouteViewRequest, GatewayRouteView> getGatewayRouteViewCallable() {
    return getGatewayRouteViewCallable;
  }

  @Override
  public UnaryCallable<GetMeshRouteViewRequest, MeshRouteView> getMeshRouteViewCallable() {
    return getMeshRouteViewCallable;
  }

  @Override
  public UnaryCallable<ListGatewayRouteViewsRequest, ListGatewayRouteViewsResponse>
      listGatewayRouteViewsCallable() {
    return listGatewayRouteViewsCallable;
  }

  @Override
  public UnaryCallable<ListGatewayRouteViewsRequest, ListGatewayRouteViewsPagedResponse>
      listGatewayRouteViewsPagedCallable() {
    return listGatewayRouteViewsPagedCallable;
  }

  @Override
  public UnaryCallable<ListMeshRouteViewsRequest, ListMeshRouteViewsResponse>
      listMeshRouteViewsCallable() {
    return listMeshRouteViewsCallable;
  }

  @Override
  public UnaryCallable<ListMeshRouteViewsRequest, ListMeshRouteViewsPagedResponse>
      listMeshRouteViewsPagedCallable() {
    return listMeshRouteViewsPagedCallable;
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
