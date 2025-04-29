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

package com.google.shopping.merchant.issueresolution.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderAccountIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1beta.RenderProductIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1beta.TriggerActionRequest;
import com.google.shopping.merchant.issueresolution.v1beta.TriggerActionResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IssueResolutionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class IssueResolutionServiceStub implements BackgroundResource {

  public UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: renderAccountIssuesCallable()");
  }

  public UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: renderProductIssuesCallable()");
  }

  public UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerActionCallable()");
  }

  @Override
  public abstract void close();
}
