/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.kms.inventory.v1.stub;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest;
import com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the KeyTrackingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class KeyTrackingServiceStub implements BackgroundResource {

  public UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getProtectedResourcesSummaryCallable()");
  }

  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchProtectedResourcesPagedCallable()");
  }

  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProtectedResourcesCallable()");
  }

  @Override
  public abstract void close();
}
