/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.quota.v1beta.stub;

import static com.google.shopping.merchant.quota.v1beta.QuotaServiceClient.ListQuotaGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest;
import com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the QuotaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class QuotaServiceStub implements BackgroundResource {

  public UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsPagedResponse>
      listQuotaGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaGroupsPagedCallable()");
  }

  public UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsResponse> listQuotaGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaGroupsCallable()");
  }

  @Override
  public abstract void close();
}
