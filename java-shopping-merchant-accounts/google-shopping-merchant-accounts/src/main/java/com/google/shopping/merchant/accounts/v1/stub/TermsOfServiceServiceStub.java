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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1.AcceptTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.AcceptTermsOfServiceResponse;
import com.google.shopping.merchant.accounts.v1.GetTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.RetrieveLatestTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.TermsOfService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TermsOfServiceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TermsOfServiceServiceStub implements BackgroundResource {

  public UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getTermsOfServiceCallable()");
  }

  public UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveLatestTermsOfServiceCallable()");
  }

  public UnaryCallable<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>
      acceptTermsOfServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: acceptTermsOfServiceCallable()");
  }

  @Override
  public abstract void close();
}
