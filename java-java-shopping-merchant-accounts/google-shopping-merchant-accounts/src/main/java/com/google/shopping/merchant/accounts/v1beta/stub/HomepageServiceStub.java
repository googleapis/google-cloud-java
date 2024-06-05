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

package com.google.shopping.merchant.accounts.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.Homepage;
import com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HomepageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class HomepageServiceStub implements BackgroundResource {

  public UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable() {
    throw new UnsupportedOperationException("Not implemented: getHomepageCallable()");
  }

  public UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHomepageCallable()");
  }

  public UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable() {
    throw new UnsupportedOperationException("Not implemented: claimHomepageCallable()");
  }

  public UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable() {
    throw new UnsupportedOperationException("Not implemented: unclaimHomepageCallable()");
  }

  @Override
  public abstract void close();
}
