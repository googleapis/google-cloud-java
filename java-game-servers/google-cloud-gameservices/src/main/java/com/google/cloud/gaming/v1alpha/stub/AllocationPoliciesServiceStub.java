/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.AllocationPoliciesServiceClient.ListAllocationPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.AllocationPolicy;
import com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse;
import com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class AllocationPoliciesServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAllocationPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
      listAllocationPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAllocationPoliciesCallable()");
  }

  public UnaryCallable<GetAllocationPolicyRequest, AllocationPolicy> getAllocationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAllocationPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAllocationPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAllocationPolicyRequest, Operation> createAllocationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAllocationPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAllocationPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAllocationPolicyRequest, Operation> deleteAllocationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAllocationPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAllocationPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAllocationPolicyRequest, Operation> updateAllocationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAllocationPolicyCallable()");
  }

  @Override
  public abstract void close();
}
