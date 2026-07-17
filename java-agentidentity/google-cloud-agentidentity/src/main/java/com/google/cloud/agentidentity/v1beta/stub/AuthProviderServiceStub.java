/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.agentidentity.v1beta.stub;

import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentidentity.v1beta.AccessSummary;
import com.google.cloud.agentidentity.v1beta.AuthProvider;
import com.google.cloud.agentidentity.v1beta.Authorization;
import com.google.cloud.agentidentity.v1beta.CreateAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.DeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.DeleteAuthorizationRequest;
import com.google.cloud.agentidentity.v1beta.DisableAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.EnableAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.GetAccessSummaryRequest;
import com.google.cloud.agentidentity.v1beta.GetAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.GetAuthorizationRequest;
import com.google.cloud.agentidentity.v1beta.ListAccessSummariesRequest;
import com.google.cloud.agentidentity.v1beta.ListAccessSummariesResponse;
import com.google.cloud.agentidentity.v1beta.ListAuthProvidersRequest;
import com.google.cloud.agentidentity.v1beta.ListAuthProvidersResponse;
import com.google.cloud.agentidentity.v1beta.ListAuthorizationsRequest;
import com.google.cloud.agentidentity.v1beta.ListAuthorizationsResponse;
import com.google.cloud.agentidentity.v1beta.QueryAuthProvidersRequest;
import com.google.cloud.agentidentity.v1beta.QueryAuthProvidersResponse;
import com.google.cloud.agentidentity.v1beta.QueryWorkloadsRequest;
import com.google.cloud.agentidentity.v1beta.QueryWorkloadsResponse;
import com.google.cloud.agentidentity.v1beta.RevokeAuthorizationRequest;
import com.google.cloud.agentidentity.v1beta.RevokeAuthorizationResponse;
import com.google.cloud.agentidentity.v1beta.UndeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1beta.UpdateAuthProviderRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AuthProviderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AuthProviderServiceStub implements BackgroundResource {

  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthProvidersPagedCallable()");
  }

  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthProvidersCallable()");
  }

  public UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthProviderCallable()");
  }

  public UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: createAuthProviderCallable()");
  }

  public UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAuthProviderCallable()");
  }

  public UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAuthProviderCallable()");
  }

  public UnaryCallable<UndeleteAuthProviderRequest, AuthProvider> undeleteAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteAuthProviderCallable()");
  }

  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryAuthProvidersPagedCallable()");
  }

  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable() {
    throw new UnsupportedOperationException("Not implemented: queryAuthProvidersCallable()");
  }

  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryWorkloadsPagedCallable()");
  }

  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> queryWorkloadsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryWorkloadsCallable()");
  }

  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthorizationsPagedCallable()");
  }

  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthorizationsCallable()");
  }

  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthorizationCallable()");
  }

  public UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAuthorizationCallable()");
  }

  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessSummariesPagedCallable()");
  }

  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessSummariesCallable()");
  }

  public UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessSummaryCallable()");
  }

  public UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeAuthorizationCallable()");
  }

  public UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: enableAuthProviderCallable()");
  }

  public UnaryCallable<DisableAuthProviderRequest, AuthProvider> disableAuthProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: disableAuthProviderCallable()");
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
