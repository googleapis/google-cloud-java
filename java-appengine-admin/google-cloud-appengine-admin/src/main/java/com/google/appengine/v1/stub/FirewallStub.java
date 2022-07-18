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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.BatchUpdateIngressRulesRequest;
import com.google.appengine.v1.BatchUpdateIngressRulesResponse;
import com.google.appengine.v1.CreateIngressRuleRequest;
import com.google.appengine.v1.DeleteIngressRuleRequest;
import com.google.appengine.v1.GetIngressRuleRequest;
import com.google.appengine.v1.ListIngressRulesRequest;
import com.google.appengine.v1.ListIngressRulesResponse;
import com.google.appengine.v1.UpdateIngressRuleRequest;
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Firewall service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FirewallStub implements BackgroundResource {

  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIngressRulesPagedCallable()");
  }

  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIngressRulesCallable()");
  }

  public UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateIngressRulesCallable()");
  }

  public UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createIngressRuleCallable()");
  }

  public UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getIngressRuleCallable()");
  }

  public UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIngressRuleCallable()");
  }

  public UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIngressRuleCallable()");
  }

  @Override
  public abstract void close();
}
