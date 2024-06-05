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
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkServicesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointPoliciesPagedCallable()");
  }

  public UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointPoliciesCallable()");
  }

  public UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointPolicyCallable()");
  }

  public OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEndpointPolicyOperationCallable()");
  }

  public UnaryCallable<CreateEndpointPolicyRequest, Operation> createEndpointPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointPolicyCallable()");
  }

  public OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEndpointPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEndpointPolicyCallable()");
  }

  public OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEndpointPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointPolicyCallable()");
  }

  public UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse> listGatewaysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGatewaysPagedCallable()");
  }

  public UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: listGatewaysCallable()");
  }

  public UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getGatewayCallable()");
  }

  public OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGatewayOperationCallable()");
  }

  public UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: createGatewayCallable()");
  }

  public OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGatewayOperationCallable()");
  }

  public UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGatewayCallable()");
  }

  public OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGatewayOperationCallable()");
  }

  public UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGatewayCallable()");
  }

  public UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesPagedResponse>
      listGrpcRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGrpcRoutesPagedCallable()");
  }

  public UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesResponse> listGrpcRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGrpcRoutesCallable()");
  }

  public UnaryCallable<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getGrpcRouteCallable()");
  }

  public OperationCallable<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGrpcRouteOperationCallable()");
  }

  public UnaryCallable<CreateGrpcRouteRequest, Operation> createGrpcRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: createGrpcRouteCallable()");
  }

  public OperationCallable<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGrpcRouteOperationCallable()");
  }

  public UnaryCallable<UpdateGrpcRouteRequest, Operation> updateGrpcRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGrpcRouteCallable()");
  }

  public OperationCallable<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGrpcRouteOperationCallable()");
  }

  public UnaryCallable<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGrpcRouteCallable()");
  }

  public UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesPagedResponse>
      listHttpRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHttpRoutesPagedCallable()");
  }

  public UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesResponse> listHttpRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listHttpRoutesCallable()");
  }

  public UnaryCallable<GetHttpRouteRequest, HttpRoute> getHttpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getHttpRouteCallable()");
  }

  public OperationCallable<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createHttpRouteOperationCallable()");
  }

  public UnaryCallable<CreateHttpRouteRequest, Operation> createHttpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: createHttpRouteCallable()");
  }

  public OperationCallable<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHttpRouteOperationCallable()");
  }

  public UnaryCallable<UpdateHttpRouteRequest, Operation> updateHttpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHttpRouteCallable()");
  }

  public OperationCallable<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHttpRouteOperationCallable()");
  }

  public UnaryCallable<DeleteHttpRouteRequest, Operation> deleteHttpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHttpRouteCallable()");
  }

  public UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesPagedResponse>
      listTcpRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTcpRoutesPagedCallable()");
  }

  public UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesResponse> listTcpRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTcpRoutesCallable()");
  }

  public UnaryCallable<GetTcpRouteRequest, TcpRoute> getTcpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getTcpRouteCallable()");
  }

  public OperationCallable<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTcpRouteOperationCallable()");
  }

  public UnaryCallable<CreateTcpRouteRequest, Operation> createTcpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: createTcpRouteCallable()");
  }

  public OperationCallable<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTcpRouteOperationCallable()");
  }

  public UnaryCallable<UpdateTcpRouteRequest, Operation> updateTcpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTcpRouteCallable()");
  }

  public OperationCallable<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTcpRouteOperationCallable()");
  }

  public UnaryCallable<DeleteTcpRouteRequest, Operation> deleteTcpRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTcpRouteCallable()");
  }

  public UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesPagedResponse>
      listTlsRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTlsRoutesPagedCallable()");
  }

  public UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesResponse> listTlsRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTlsRoutesCallable()");
  }

  public UnaryCallable<GetTlsRouteRequest, TlsRoute> getTlsRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getTlsRouteCallable()");
  }

  public OperationCallable<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTlsRouteOperationCallable()");
  }

  public UnaryCallable<CreateTlsRouteRequest, Operation> createTlsRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: createTlsRouteCallable()");
  }

  public OperationCallable<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTlsRouteOperationCallable()");
  }

  public UnaryCallable<UpdateTlsRouteRequest, Operation> updateTlsRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTlsRouteCallable()");
  }

  public OperationCallable<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTlsRouteOperationCallable()");
  }

  public UnaryCallable<DeleteTlsRouteRequest, Operation> deleteTlsRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTlsRouteCallable()");
  }

  public UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsPagedResponse>
      listServiceBindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceBindingsPagedCallable()");
  }

  public UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceBindingsCallable()");
  }

  public UnaryCallable<GetServiceBindingRequest, ServiceBinding> getServiceBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceBindingCallable()");
  }

  public OperationCallable<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceBindingOperationCallable()");
  }

  public UnaryCallable<CreateServiceBindingRequest, Operation> createServiceBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceBindingCallable()");
  }

  public OperationCallable<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceBindingOperationCallable()");
  }

  public UnaryCallable<DeleteServiceBindingRequest, Operation> deleteServiceBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceBindingCallable()");
  }

  public UnaryCallable<ListMeshesRequest, ListMeshesPagedResponse> listMeshesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMeshesPagedCallable()");
  }

  public UnaryCallable<ListMeshesRequest, ListMeshesResponse> listMeshesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMeshesCallable()");
  }

  public UnaryCallable<GetMeshRequest, Mesh> getMeshCallable() {
    throw new UnsupportedOperationException("Not implemented: getMeshCallable()");
  }

  public OperationCallable<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMeshOperationCallable()");
  }

  public UnaryCallable<CreateMeshRequest, Operation> createMeshCallable() {
    throw new UnsupportedOperationException("Not implemented: createMeshCallable()");
  }

  public OperationCallable<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMeshOperationCallable()");
  }

  public UnaryCallable<UpdateMeshRequest, Operation> updateMeshCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMeshCallable()");
  }

  public OperationCallable<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMeshOperationCallable()");
  }

  public UnaryCallable<DeleteMeshRequest, Operation> deleteMeshCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMeshCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
