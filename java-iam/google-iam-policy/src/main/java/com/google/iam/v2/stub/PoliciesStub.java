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

package com.google.iam.v2.stub;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.DeletePolicyRequest;
import com.google.iam.v2.GetPolicyRequest;
import com.google.iam.v2.ListPoliciesRequest;
import com.google.iam.v2.ListPoliciesResponse;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyOperationMetadata;
import com.google.iam.v2.UpdatePolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Policies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PoliciesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyOperationCallable()");
  }

  public UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyCallable()");
  }

  public OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyOperationCallable()");
  }

  public UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyCallable()");
  }

  public OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyOperationCallable()");
  }

  public UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyCallable()");
  }

  @Override
  public abstract void close();
}
