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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ResourcePolicyClient.AggregatedListResourcePoliciesPagedResponse;
import static com.google.cloud.compute.v1.ResourcePolicyClient.ListResourcePoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.DeleteResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.InsertResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.ListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ResourcePolicy;
import com.google.cloud.compute.v1.ResourcePolicyAggregatedList;
import com.google.cloud.compute.v1.ResourcePolicyList;
import com.google.cloud.compute.v1.SetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ResourcePolicyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListResourcePoliciesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
      aggregatedListResourcePoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListResourcePoliciesCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteResourcePolicyHttpRequest, Operation> deleteResourcePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteResourcePolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetResourcePolicyHttpRequest, ResourcePolicy> getResourcePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourcePolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getIamPolicyResourcePolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertResourcePolicyHttpRequest, Operation> insertResourcePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: insertResourcePolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<ListResourcePoliciesHttpRequest, ListResourcePoliciesPagedResponse>
      listResourcePoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourcePoliciesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListResourcePoliciesHttpRequest, ResourcePolicyList>
      listResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourcePoliciesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setIamPolicyResourcePolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsResourcePolicyCallable()");
  }

  @Override
  public abstract void close();
}
