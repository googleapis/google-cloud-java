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

import static com.google.cloud.compute.v1.GlobalForwardingRuleClient.ListGlobalForwardingRulesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ListGlobalForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetTargetGlobalForwardingRuleHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class GlobalForwardingRuleStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteGlobalForwardingRuleHttpRequest, Operation>
      deleteGlobalForwardingRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGlobalForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
      getGlobalForwardingRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlobalForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertGlobalForwardingRuleHttpRequest, Operation>
      insertGlobalForwardingRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertGlobalForwardingRuleCallable()");
  }

  @BetaApi
  public UnaryCallable<ListGlobalForwardingRulesHttpRequest, ListGlobalForwardingRulesPagedResponse>
      listGlobalForwardingRulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGlobalForwardingRulesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
      listGlobalForwardingRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlobalForwardingRulesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetTargetGlobalForwardingRuleHttpRequest, Operation>
      setTargetGlobalForwardingRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setTargetGlobalForwardingRuleCallable()");
  }

  @Override
  public abstract void close();
}
