/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.FirewallPoliciesClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.CloneRulesFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPoliciesListAssociationsResponse;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListAssociationsFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListFirewallPoliciesRequest;
import com.google.cloud.compute.v1.MoveFirewallPolicyRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class FirewallPoliciesStub implements BackgroundResource {

  public UnaryCallable<AddAssociationFirewallPolicyRequest, Operation> addAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationCallable()");
  }

  public UnaryCallable<AddRuleFirewallPolicyRequest, Operation> addRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleCallable()");
  }

  public UnaryCallable<CloneRulesFirewallPolicyRequest, Operation> cloneRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneRulesCallable()");
  }

  public UnaryCallable<DeleteFirewallPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssociationCallable()");
  }

  public UnaryCallable<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetRuleFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public UnaryCallable<InsertFirewallPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListFirewallPoliciesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListFirewallPoliciesRequest, FirewallPolicyList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssociationsCallable()");
  }

  public UnaryCallable<MoveFirewallPolicyRequest, Operation> moveCallable() {
    throw new UnsupportedOperationException("Not implemented: moveCallable()");
  }

  public UnaryCallable<PatchFirewallPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<PatchRuleFirewallPolicyRequest, Operation> patchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleCallable()");
  }

  public UnaryCallable<RemoveAssociationFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAssociationCallable()");
  }

  public UnaryCallable<RemoveRuleFirewallPolicyRequest, Operation> removeRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleCallable()");
  }

  public UnaryCallable<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
