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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdReviewCenterAdServiceClient.SearchAdReviewCenterAdsPagedResponse;

import com.google.ads.admanager.v1.BatchAdReviewCenterAdsOperationMetadata;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdReviewCenterAdService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AdReviewCenterAdServiceStub implements BackgroundResource {

  public OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
  }

  public UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchAdReviewCenterAdsPagedCallable()");
  }

  public UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
      searchAdReviewCenterAdsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAdReviewCenterAdsCallable()");
  }

  public OperationCallable<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchAllowAdReviewCenterAdsOperationCallable()");
  }

  public UnaryCallable<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchAllowAdReviewCenterAdsCallable()");
  }

  public OperationCallable<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchBlockAdReviewCenterAdsOperationCallable()");
  }

  public UnaryCallable<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchBlockAdReviewCenterAdsCallable()");
  }

  @Override
  public abstract void close();
}
