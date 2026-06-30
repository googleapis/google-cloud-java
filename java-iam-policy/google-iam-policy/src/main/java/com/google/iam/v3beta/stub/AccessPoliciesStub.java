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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3beta.AccessPolicy;
import com.google.iam.v3beta.CreateAccessPolicyRequest;
import com.google.iam.v3beta.DeleteAccessPolicyRequest;
import com.google.iam.v3beta.GetAccessPolicyRequest;
import com.google.iam.v3beta.ListAccessPoliciesRequest;
import com.google.iam.v3beta.ListAccessPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.SearchAccessPolicyBindingsRequest;
import com.google.iam.v3beta.SearchAccessPolicyBindingsResponse;
import com.google.iam.v3beta.UpdateAccessPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccessPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AccessPoliciesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAccessPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccessPolicyCallable()");
  }

  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessPolicyCallable()");
  }

  public OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAccessPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccessPolicyCallable()");
  }

  public OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAccessPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccessPolicyCallable()");
  }

  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessPoliciesCallable()");
  }

  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchAccessPolicyBindingsPagedCallable()");
  }

  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchAccessPolicyBindingsCallable()");
  }

  @Override
  public abstract void close();
}
