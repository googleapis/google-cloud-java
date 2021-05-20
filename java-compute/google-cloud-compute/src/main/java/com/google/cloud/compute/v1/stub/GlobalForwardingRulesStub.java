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

import static com.google.cloud.compute.v1.GlobalForwardingRulesClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.InsertGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ListGlobalForwardingRulesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetLabelsGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetTargetGlobalForwardingRuleRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class GlobalForwardingRulesStub implements BackgroundResource {

  public UnaryCallable<DeleteGlobalForwardingRuleRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetGlobalForwardingRuleRequest, ForwardingRule> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<InsertGlobalForwardingRuleRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListGlobalForwardingRulesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<PatchGlobalForwardingRuleRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<SetTargetGlobalForwardingRuleRequest, Operation> setTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetCallable()");
  }

  @Override
  public abstract void close();
}
