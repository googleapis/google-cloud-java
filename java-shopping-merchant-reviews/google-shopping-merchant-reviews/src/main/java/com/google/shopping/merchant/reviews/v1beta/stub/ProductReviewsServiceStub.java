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

import static com.google.shopping.merchant.reviews.v1beta.ProductReviewsServiceClient.ListProductReviewsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.ProductReview;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProductReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ProductReviewsServiceStub implements BackgroundResource {

  public UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductReviewCallable()");
  }

  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductReviewsPagedCallable()");
  }

  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductReviewsCallable()");
  }

  public UnaryCallable<InsertProductReviewRequest, ProductReview> insertProductReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: insertProductReviewCallable()");
  }

  public UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProductReviewCallable()");
  }

  @Override
  public abstract void close();
}
