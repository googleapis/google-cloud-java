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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalVmExtensionPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.GlobalVmExtensionPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListGlobalVmExtensionPoliciesRequest;
import com.google.cloud.compute.v1.DeleteGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.GetGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.GlobalVmExtensionPolicy;
import com.google.cloud.compute.v1.GlobalVmExtensionPolicyList;
import com.google.cloud.compute.v1.InsertGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.ListGlobalVmExtensionPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.UpdateGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.VmExtensionPolicyAggregatedListResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GlobalVmExtensionPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GlobalVmExtensionPoliciesStub implements BackgroundResource {

  public UnaryCallable<AggregatedListGlobalVmExtensionPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteGlobalVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteGlobalVmExtensionPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertGlobalVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertGlobalVmExtensionPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListGlobalVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<UpdateGlobalVmExtensionPolicyRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateGlobalVmExtensionPolicyRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
