/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.ForwardingRuleClient.AggregatedListForwardingRulesPagedResponse;
import static com.google.cloud.compute.v1.ForwardingRuleClient.ListForwardingRulesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.DeleteForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleAggregatedList;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.InsertForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ListForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetTargetForwardingRuleHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ForwardingRuleStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListForwardingRulesHttpRequest, AggregatedListForwardingRulesPagedResponse>
      aggregatedListForwardingRulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListForwardingRulesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListForwardingRulesHttpRequest, ForwardingRuleAggregatedList>
      aggregatedListForwardingRulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListForwardingRulesCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteForwardingRuleHttpRequest, Operation> deleteForwardingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<GetForwardingRuleHttpRequest, ForwardingRule> getForwardingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertForwardingRuleHttpRequest, Operation> insertForwardingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: insertForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<ListForwardingRulesHttpRequest, ListForwardingRulesPagedResponse>
      listForwardingRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listForwardingRulesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListForwardingRulesHttpRequest, ForwardingRuleList>
      listForwardingRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listForwardingRulesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetTargetForwardingRuleHttpRequest, Operation>
      setTargetForwardingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetForwardingRuleCallable()");
  }

  @Override
  public abstract void close();
}
