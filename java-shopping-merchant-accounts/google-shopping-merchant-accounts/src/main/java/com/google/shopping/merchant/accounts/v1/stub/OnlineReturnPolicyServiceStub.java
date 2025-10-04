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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.OnlineReturnPolicyServiceClient.ListOnlineReturnPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.CreateOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.DeleteOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.GetOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1.ListOnlineReturnPoliciesRequest;
import com.google.shopping.merchant.accounts.v1.ListOnlineReturnPoliciesResponse;
import com.google.shopping.merchant.accounts.v1.OnlineReturnPolicy;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OnlineReturnPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OnlineReturnPolicyServiceStub implements BackgroundResource {

  public UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getOnlineReturnPolicyCallable()");
  }

  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOnlineReturnPoliciesPagedCallable()");
  }

  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listOnlineReturnPoliciesCallable()");
  }

  public UnaryCallable<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createOnlineReturnPolicyCallable()");
  }

  public UnaryCallable<DeleteOnlineReturnPolicyRequest, Empty> deleteOnlineReturnPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOnlineReturnPolicyCallable()");
  }

  @Override
  public abstract void close();
}
