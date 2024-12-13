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

package com.google.shopping.merchant.reviews.v1beta.stub;

import static com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceClient.ListMerchantReviewsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.MerchantReview;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MerchantReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MerchantReviewsServiceStub implements BackgroundResource {

  public UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: getMerchantReviewCallable()");
  }

  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMerchantReviewsPagedCallable()");
  }

  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMerchantReviewsCallable()");
  }

  public UnaryCallable<InsertMerchantReviewRequest, MerchantReview> insertMerchantReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: insertMerchantReviewCallable()");
  }

  public UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMerchantReviewCallable()");
  }

  @Override
  public abstract void close();
}
