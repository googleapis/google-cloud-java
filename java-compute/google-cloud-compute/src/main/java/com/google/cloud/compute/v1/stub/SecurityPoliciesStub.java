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

import static com.google.cloud.compute.v1.SecurityPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.AggregatedListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.DeleteSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesAggregatedList;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
import com.google.cloud.compute.v1.SetLabelsSecurityPolicyRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecurityPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SecurityPoliciesStub implements BackgroundResource {

  public OperationCallable<AddRuleSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleOperationCallable()");
  }

  public UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: addRuleCallable()");
  }

  public UnaryCallable<AggregatedListSecurityPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuleCallable()");
  }

  public OperationCallable<InsertSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPreconfiguredExpressionSetsCallable()");
  }

  public OperationCallable<PatchSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchRuleSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleOperationCallable()");
  }

  public UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRuleCallable()");
  }

  public OperationCallable<RemoveRuleSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleOperationCallable()");
  }

  public UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: removeRuleCallable()");
  }

  public OperationCallable<SetLabelsSecurityPolicyRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsSecurityPolicyRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  @Override
  public abstract void close();
}
