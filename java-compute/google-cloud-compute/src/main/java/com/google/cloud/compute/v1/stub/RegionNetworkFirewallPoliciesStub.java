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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionNetworkFirewallPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.CloneRulesRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListRegionNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.RemoveAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionNetworkFirewallPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionNetworkFirewallPoliciesStub implements BackgroundResource {

  public OperationCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationOperationCallable()");
  }

  public UnaryCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationCallable()");
  }

  public OperationCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleOperationCallable()");
  }

  public UnaryCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation> addRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleCallable()");
  }

  public OperationCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneRulesOperationCallable()");
  }

  public UnaryCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneRulesCallable()");
  }

  public OperationCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssociationCallable()");
  }

  public UnaryCallable<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    throw new UnsupportedOperationException("Not implemented: getEffectiveFirewallsCallable()");
  }

  public UnaryCallable<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public OperationCallable<InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionNetworkFirewallPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchRegionNetworkFirewallPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleOperationCallable()");
  }

  public UnaryCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation> patchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleCallable()");
  }

  public OperationCallable<
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeAssociationOperationCallable()");
  }

  public UnaryCallable<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAssociationCallable()");
  }

  public OperationCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleOperationCallable()");
  }

  public UnaryCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
      removeRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleCallable()");
  }

  public UnaryCallable<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
