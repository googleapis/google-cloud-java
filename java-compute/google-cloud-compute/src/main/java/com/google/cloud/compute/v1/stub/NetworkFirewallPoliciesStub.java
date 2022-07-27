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

import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.CloneRulesNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkFirewallPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkFirewallPoliciesStub implements BackgroundResource {

  public OperationCallable<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationOperationCallable()");
  }

  public UnaryCallable<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationCallable()");
  }

  public OperationCallable<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleOperationCallable()");
  }

  public UnaryCallable<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleCallable()");
  }

  public OperationCallable<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneRulesOperationCallable()");
  }

  public UnaryCallable<CloneRulesNetworkFirewallPolicyRequest, Operation> cloneRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneRulesCallable()");
  }

  public OperationCallable<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkFirewallPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssociationCallable()");
  }

  public UnaryCallable<GetIamPolicyNetworkFirewallPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public OperationCallable<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertNetworkFirewallPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListNetworkFirewallPoliciesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListNetworkFirewallPoliciesRequest, FirewallPolicyList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchNetworkFirewallPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleOperationCallable()");
  }

  public UnaryCallable<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleCallable()");
  }

  public OperationCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeAssociationOperationCallable()");
  }

  public UnaryCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAssociationCallable()");
  }

  public OperationCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleOperationCallable()");
  }

  public UnaryCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation> removeRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleCallable()");
  }

  public UnaryCallable<SetIamPolicyNetworkFirewallPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
