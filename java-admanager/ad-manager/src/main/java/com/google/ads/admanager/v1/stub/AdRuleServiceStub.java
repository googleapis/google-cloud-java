/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdRuleServiceClient.ListAdRulesPagedResponse;

import com.google.ads.admanager.v1.AdRule;
import com.google.ads.admanager.v1.BatchActivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchActivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchCreateAdRulesRequest;
import com.google.ads.admanager.v1.BatchCreateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeleteAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesResponse;
import com.google.ads.admanager.v1.CreateAdRuleRequest;
import com.google.ads.admanager.v1.GetAdRuleRequest;
import com.google.ads.admanager.v1.ListAdRulesRequest;
import com.google.ads.admanager.v1.ListAdRulesResponse;
import com.google.ads.admanager.v1.UpdateAdRuleRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdRuleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class AdRuleServiceStub implements BackgroundResource {

  public UnaryCallable<GetAdRuleRequest, AdRule> getAdRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdRuleCallable()");
  }

  public UnaryCallable<ListAdRulesRequest, ListAdRulesPagedResponse> listAdRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdRulesPagedCallable()");
  }

  public UnaryCallable<ListAdRulesRequest, ListAdRulesResponse> listAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdRulesCallable()");
  }

  public UnaryCallable<CreateAdRuleRequest, AdRule> createAdRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdRuleCallable()");
  }

  public UnaryCallable<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateAdRulesCallable()");
  }

  public UnaryCallable<UpdateAdRuleRequest, AdRule> updateAdRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAdRuleCallable()");
  }

  public UnaryCallable<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateAdRulesCallable()");
  }

  public UnaryCallable<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateAdRulesCallable()");
  }

  public UnaryCallable<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateAdRulesCallable()");
  }

  public UnaryCallable<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteAdRulesCallable()");
  }

  @Override
  public abstract void close();
}
