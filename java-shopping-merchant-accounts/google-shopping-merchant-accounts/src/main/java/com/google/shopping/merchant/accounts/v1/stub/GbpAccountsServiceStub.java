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

import static com.google.shopping.merchant.accounts.v1.GbpAccountsServiceClient.ListGbpAccountsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1.LinkGbpAccountRequest;
import com.google.shopping.merchant.accounts.v1.LinkGbpAccountResponse;
import com.google.shopping.merchant.accounts.v1.ListGbpAccountsRequest;
import com.google.shopping.merchant.accounts.v1.ListGbpAccountsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GbpAccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GbpAccountsServiceStub implements BackgroundResource {

  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGbpAccountsPagedCallable()");
  }

  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse> listGbpAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGbpAccountsCallable()");
  }

  public UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse> linkGbpAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: linkGbpAccountCallable()");
  }

  @Override
  public abstract void close();
}
