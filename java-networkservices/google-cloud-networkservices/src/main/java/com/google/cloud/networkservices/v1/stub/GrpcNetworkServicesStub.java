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
              .build();

  private static final MethodDescriptor<ListGatewaysRequest, ListGatewaysResponse>
      listGatewaysMethodDescriptor =
          MethodDescriptor.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListGateways")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewaysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGatewayRequest, Gateway> getGatewayMethodDescriptor =
      MethodDescriptor.<GetGatewayRequest, Gateway>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGateway")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGatewayRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Gateway.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateGatewayRequest, Operation>
      createGatewayMethodDescriptor =
          MethodDescriptor.<CreateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGatewayRequest, Operation>
      updateGatewayMethodDescriptor =
          MethodDescriptor.<UpdateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGatewayRequest, Operation>
      deleteGatewayMethodDescriptor =
          MethodDescriptor.<DeleteGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetGrpcRouteRequest, GrpcRoute>
      getGrpcRouteMethodDescriptor =
          MethodDescriptor.<GetGrpcRouteRequest, GrpcRoute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetGrpcRoute")
              .setRequestMarshaller(ProtoUtils.marshaller(GetGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GrpcRoute.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGrpcRouteRequest, Operation>
      createGrpcRouteMethodDescriptor =
          MethodDescriptor.<CreateGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGrpcRouteRequest, Operation>
      updateGrpcRouteMethodDescriptor =
          MethodDescriptor.<UpdateGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGrpcRouteRequest, Operation>
      deleteGrpcRouteMethodDescriptor =
          MethodDescriptor.<DeleteGrpcRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteGrpcRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGrpcRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetHttpRouteRequest, HttpRoute>
      getHttpRouteMethodDescriptor =
          MethodDescriptor.<GetHttpRouteRequest, HttpRoute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetHttpRoute")
              .setRequestMarshaller(ProtoUtils.marshaller(GetHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpRoute.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateHttpRouteRequest, Operation>
      createHttpRouteMethodDescriptor =
          MethodDescriptor.<CreateHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateHttpRouteRequest, Operation>
      updateHttpRouteMethodDescriptor =
          MethodDescriptor.<UpdateHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteHttpRouteRequest, Operation>
      deleteHttpRouteMethodDescriptor =
          MethodDescriptor.<DeleteHttpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteHttpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHttpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetTcpRouteRequest, TcpRoute> getTcpRouteMethodDescriptor =
      MethodDescriptor.<GetTcpRouteRequest, TcpRoute>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTcpRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTcpRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TcpRoute.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTcpRouteRequest, Operation>
      createTcpRouteMethodDescriptor =
          MethodDescriptor.<CreateTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTcpRouteRequest, Operation>
      updateTcpRouteMethodDescriptor =
          MethodDescriptor.<UpdateTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTcpRouteRequest, Operation>
      deleteTcpRouteMethodDescriptor =
          MethodDescriptor.<DeleteTcpRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTcpRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTcpRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetTlsRouteRequest, TlsRoute> getTlsRouteMethodDescriptor =
      MethodDescriptor.<GetTlsRouteRequest, TlsRoute>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetTlsRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTlsRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TlsRoute.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTlsRouteRequest, Operation>
      createTlsRouteMethodDescriptor =
          MethodDescriptor.<CreateTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTlsRouteRequest, Operation>
      updateTlsRouteMethodDescriptor =
          MethodDescriptor.<UpdateTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTlsRouteRequest, Operation>
      deleteTlsRouteMethodDescriptor =
          MethodDescriptor.<DeleteTlsRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteTlsRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTlsRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<ListMeshesRequest, ListMeshesResponse>
      listMeshesMethodDescriptor =
          MethodDescriptor.<ListMeshesRequest, ListMeshesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/ListMeshes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMeshesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListMeshesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMeshRequest, Mesh> getMeshMethodDescriptor =
      MethodDescriptor.<GetMeshRequest, Mesh>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/GetMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Mesh.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateMeshRequest, Operation> createMeshMethodDescriptor =
      MethodDescriptor.<CreateMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/CreateMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateMeshRequest, Operation> updateMeshMethodDescriptor =
      MethodDescriptor.<UpdateMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/UpdateMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteMeshRequest, Operation> deleteMeshMethodDescriptor =
      MethodDescriptor.<DeleteMeshRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkservices.v1.NetworkServices/DeleteMesh")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteMeshRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
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
