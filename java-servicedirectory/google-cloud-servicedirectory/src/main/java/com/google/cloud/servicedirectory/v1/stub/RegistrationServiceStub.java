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

package com.google.cloud.servicedirectory.v1.stub;

import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.servicedirectory.v1.CreateEndpointRequest;
import com.google.cloud.servicedirectory.v1.CreateNamespaceRequest;
import com.google.cloud.servicedirectory.v1.CreateServiceRequest;
import com.google.cloud.servicedirectory.v1.DeleteEndpointRequest;
import com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest;
import com.google.cloud.servicedirectory.v1.DeleteServiceRequest;
import com.google.cloud.servicedirectory.v1.Endpoint;
import com.google.cloud.servicedirectory.v1.GetEndpointRequest;
import com.google.cloud.servicedirectory.v1.GetNamespaceRequest;
import com.google.cloud.servicedirectory.v1.GetServiceRequest;
import com.google.cloud.servicedirectory.v1.ListEndpointsRequest;
import com.google.cloud.servicedirectory.v1.ListEndpointsResponse;
import com.google.cloud.servicedirectory.v1.ListNamespacesRequest;
import com.google.cloud.servicedirectory.v1.ListNamespacesResponse;
import com.google.cloud.servicedirectory.v1.ListServicesRequest;
import com.google.cloud.servicedirectory.v1.ListServicesResponse;
import com.google.cloud.servicedirectory.v1.Namespace;
import com.google.cloud.servicedirectory.v1.Service;
import com.google.cloud.servicedirectory.v1.UpdateEndpointRequest;
import com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest;
import com.google.cloud.servicedirectory.v1.UpdateServiceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegistrationServiceStub implements BackgroundResource {

  public UnaryCallable<CreateNamespaceRequest, Namespace> createNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createNamespaceCallable()");
  }

  public UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNamespacesPagedCallable()");
  }

  public UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNamespacesCallable()");
  }

  public UnaryCallable<GetNamespaceRequest, Namespace> getNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getNamespaceCallable()");
  }

  public UnaryCallable<UpdateNamespaceRequest, Namespace> updateNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNamespaceCallable()");
  }

  public UnaryCallable<DeleteNamespaceRequest, Empty> deleteNamespaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNamespaceCallable()");
  }

  public UnaryCallable<CreateServiceRequest, Service> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public UnaryCallable<CreateEndpointRequest, Endpoint> createEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsPagedCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsCallable()");
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointCallable()");
  }

  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEndpointCallable()");
  }

  public UnaryCallable<DeleteEndpointRequest, Empty> deleteEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
