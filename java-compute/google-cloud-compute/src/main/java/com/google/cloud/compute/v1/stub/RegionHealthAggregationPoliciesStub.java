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

import static com.google.cloud.compute.v1.RegionHealthAggregationPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionHealthAggregationPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRegionHealthAggregationPoliciesRequest;
import com.google.cloud.compute.v1.DeleteRegionHealthAggregationPolicyRequest;
import com.google.cloud.compute.v1.GetRegionHealthAggregationPolicyRequest;
import com.google.cloud.compute.v1.HealthAggregationPolicy;
import com.google.cloud.compute.v1.HealthAggregationPolicyAggregatedList;
import com.google.cloud.compute.v1.HealthAggregationPolicyList;
import com.google.cloud.compute.v1.InsertRegionHealthAggregationPolicyRequest;
import com.google.cloud.compute.v1.ListRegionHealthAggregationPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthAggregationPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionHealthAggregationPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionHealthAggregationPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionHealthAggregationPoliciesStub implements BackgroundResource {

  public UnaryCallable<
          AggregatedListRegionHealthAggregationPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteRegionHealthAggregationPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionHealthAggregationPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionHealthAggregationPolicyRequest, HealthAggregationPolicy>
      getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionHealthAggregationPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionHealthAggregationPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionHealthAggregationPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionHealthAggregationPoliciesRequest, HealthAggregationPolicyList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchRegionHealthAggregationPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchRegionHealthAggregationPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<
          TestIamPermissionsRegionHealthAggregationPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
