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

package com.google.shopping.merchant.promotions.v1beta.stub;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse;
import com.google.shopping.merchant.promotions.v1beta.Promotion;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PromotionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PromotionsServiceStub implements BackgroundResource {

  public UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable() {
    throw new UnsupportedOperationException("Not implemented: insertPromotionCallable()");
  }

  public UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPromotionCallable()");
  }

  public UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPromotionsPagedCallable()");
  }

  public UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> listPromotionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPromotionsCallable()");
  }

  @Override
  public abstract void close();
}
