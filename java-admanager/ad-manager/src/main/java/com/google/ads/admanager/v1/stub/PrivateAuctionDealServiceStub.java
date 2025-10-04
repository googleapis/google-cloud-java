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

import static com.google.ads.admanager.v1.PrivateAuctionDealServiceClient.ListPrivateAuctionDealsPagedResponse;

import com.google.ads.admanager.v1.CreatePrivateAuctionDealRequest;
import com.google.ads.admanager.v1.GetPrivateAuctionDealRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionDealsRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionDealsResponse;
import com.google.ads.admanager.v1.PrivateAuctionDeal;
import com.google.ads.admanager.v1.UpdatePrivateAuctionDealRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PrivateAuctionDealService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PrivateAuctionDealServiceStub implements BackgroundResource {

  public UnaryCallable<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateAuctionDealCallable()");
  }

  public UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsPagedResponse>
      listPrivateAuctionDealsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateAuctionDealsPagedCallable()");
  }

  public UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
      listPrivateAuctionDealsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateAuctionDealsCallable()");
  }

  public UnaryCallable<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateAuctionDealCallable()");
  }

  public UnaryCallable<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePrivateAuctionDealCallable()");
  }

  @Override
  public abstract void close();
}
