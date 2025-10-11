/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.compute.v1.OrganizationSecurityPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.AddRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.CopyRulesOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListAssociationsOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListOrganizationSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest;
import com.google.cloud.compute.v1.MoveOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OrganizationSecurityPoliciesListAssociationsResponse;
import com.google.cloud.compute.v1.PatchOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyAssociation;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OrganizationSecurityPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OrganizationSecurityPoliciesStub implements BackgroundResource {

  public OperationCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationOperationCallable()");
  }

  public UnaryCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssociationCallable()");
  }

  public OperationCallable<AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleOperationCallable()");
  }

  public UnaryCallable<AddRuleOrganizationSecurityPolicyRequest, Operation> addRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleCallable()");
  }

  public OperationCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
      copyRulesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: copyRulesOperationCallable()");
  }

  public UnaryCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation> copyRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: copyRulesCallable()");
  }

  public OperationCallable<DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteOrganizationSecurityPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetOrganizationSecurityPolicyRequest, SecurityPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssociationCallable()");
  }

  public UnaryCallable<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public OperationCallable<InsertOrganizationSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertOrganizationSecurityPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListOrganizationSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssociationsCallable()");
  }

  public UnaryCallable<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPreconfiguredExpressionSetsCallable()");
  }

  public OperationCallable<MoveOrganizationSecurityPolicyRequest, Operation, Operation>
      moveOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveOperationCallable()");
  }

  public UnaryCallable<MoveOrganizationSecurityPolicyRequest, Operation> moveCallable() {
    throw new UnsupportedOperationException("Not implemented: moveCallable()");
  }

  public OperationCallable<PatchOrganizationSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchOrganizationSecurityPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleOperationCallable()");
  }

  public UnaryCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation> patchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleCallable()");
  }

  public OperationCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeAssociationOperationCallable()");
  }

  public UnaryCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAssociationCallable()");
  }

  public OperationCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleOperationCallable()");
  }

  public UnaryCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
      removeRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleCallable()");
  }

  @Override
  public abstract void close();
}
