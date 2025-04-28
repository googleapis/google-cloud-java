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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PrincipalAccessBoundaryPolicy;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse;
import com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PrincipalAccessBoundaryPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PrincipalAccessBoundaryPoliciesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrincipalAccessBoundaryPolicyOperationCallable()");
  }

  public UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrincipalAccessBoundaryPolicyCallable()");
  }

  public UnaryCallable<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getPrincipalAccessBoundaryPolicyCallable()");
  }

  public OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePrincipalAccessBoundaryPolicyOperationCallable()");
  }

  public UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePrincipalAccessBoundaryPolicyCallable()");
  }

  public OperationCallable<DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrincipalAccessBoundaryPolicyOperationCallable()");
  }

  public UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrincipalAccessBoundaryPolicyCallable()");
  }

  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrincipalAccessBoundaryPoliciesPagedCallable()");
  }

  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrincipalAccessBoundaryPoliciesCallable()");
  }

  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchPrincipalAccessBoundaryPolicyBindingsPagedCallable()");
  }

  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchPrincipalAccessBoundaryPolicyBindingsCallable()");
  }

  @Override
  public abstract void close();
}
