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

import static com.google.shopping.merchant.accounts.v1.LfpProvidersServiceClient.FindLfpProvidersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse;
import com.google.shopping.merchant.accounts.v1.LinkLfpProviderRequest;
import com.google.shopping.merchant.accounts.v1.LinkLfpProviderResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LfpProvidersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LfpProvidersServiceStub implements BackgroundResource {

  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: findLfpProvidersPagedCallable()");
  }

  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable() {
    throw new UnsupportedOperationException("Not implemented: findLfpProvidersCallable()");
  }

  public UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse> linkLfpProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: linkLfpProviderCallable()");
  }

  @Override
  public abstract void close();
}
