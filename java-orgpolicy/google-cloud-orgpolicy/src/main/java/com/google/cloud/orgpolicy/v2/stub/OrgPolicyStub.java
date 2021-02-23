/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.orgpolicy.v2.stub;

import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orgpolicy.v2.CreatePolicyRequest;
import com.google.cloud.orgpolicy.v2.DeletePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetPolicyRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsResponse;
import com.google.cloud.orgpolicy.v2.ListPoliciesRequest;
import com.google.cloud.orgpolicy.v2.ListPoliciesResponse;
import com.google.cloud.orgpolicy.v2.Policy;
import com.google.cloud.orgpolicy.v2.UpdatePolicyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OrgPolicy service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OrgPolicyStub implements BackgroundResource {

  public UnaryCallable<ListConstraintsRequest, ListConstraintsPagedResponse>
      listConstraintsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConstraintsPagedCallable()");
  }

  public UnaryCallable<ListConstraintsRequest, ListConstraintsResponse> listConstraintsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConstraintsCallable()");
  }

  public UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse> listPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPoliciesPagedCallable()");
  }

  public UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPoliciesCallable()");
  }

  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyCallable()");
  }

  public UnaryCallable<GetEffectivePolicyRequest, Policy> getEffectivePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getEffectivePolicyCallable()");
  }

  public UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyCallable()");
  }

  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyCallable()");
  }

  public UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyCallable()");
  }

  @Override
  public abstract void close();
}
