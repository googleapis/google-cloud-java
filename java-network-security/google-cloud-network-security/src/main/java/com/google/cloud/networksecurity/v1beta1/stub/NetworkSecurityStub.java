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

package com.google.cloud.networksecurity.v1beta1.stub;

import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.AuthorizationPolicy;
import com.google.cloud.networksecurity.v1beta1.ClientTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.CreateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.OperationMetadata;
import com.google.cloud.networksecurity.v1beta1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.UpdateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateServerTlsPolicyRequest;
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
 * Base stub class for the NetworkSecurity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class NetworkSecurityStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAuthorizationPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthorizationPoliciesCallable()");
  }

  public UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthorizationPolicyCallable()");
  }

  public OperationCallable<CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAuthorizationPolicyCallable()");
  }

  public OperationCallable<UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAuthorizationPolicyCallable()");
  }

  public OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAuthorizationPolicyCallable()");
  }

  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServerTlsPoliciesPagedCallable()");
  }

  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServerTlsPoliciesCallable()");
  }

  public UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy> getServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getServerTlsPolicyCallable()");
  }

  public OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<CreateServerTlsPolicyRequest, Operation> createServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createServerTlsPolicyCallable()");
  }

  public OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateServerTlsPolicyRequest, Operation> updateServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServerTlsPolicyCallable()");
  }

  public OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteServerTlsPolicyRequest, Operation> deleteServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServerTlsPolicyCallable()");
  }

  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listClientTlsPoliciesPagedCallable()");
  }

  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listClientTlsPoliciesCallable()");
  }

  public UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy> getClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getClientTlsPolicyCallable()");
  }

  public OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<CreateClientTlsPolicyRequest, Operation> createClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createClientTlsPolicyCallable()");
  }

  public OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateClientTlsPolicyRequest, Operation> updateClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClientTlsPolicyCallable()");
  }

  public OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteClientTlsPolicyRequest, Operation> deleteClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClientTlsPolicyCallable()");
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
