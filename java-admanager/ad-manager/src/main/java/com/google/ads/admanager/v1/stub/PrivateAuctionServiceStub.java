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

import static com.google.ads.admanager.v1.PrivateAuctionServiceClient.ListPrivateAuctionsPagedResponse;

import com.google.ads.admanager.v1.CreatePrivateAuctionRequest;
import com.google.ads.admanager.v1.GetPrivateAuctionRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsResponse;
import com.google.ads.admanager.v1.PrivateAuction;
import com.google.ads.admanager.v1.UpdatePrivateAuctionRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PrivateAuctionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PrivateAuctionServiceStub implements BackgroundResource {

  public UnaryCallable<GetPrivateAuctionRequest, PrivateAuction> getPrivateAuctionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateAuctionCallable()");
  }

  public UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateAuctionsPagedCallable()");
  }

  public UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
      listPrivateAuctionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateAuctionsCallable()");
  }

  public UnaryCallable<CreatePrivateAuctionRequest, PrivateAuction> createPrivateAuctionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateAuctionCallable()");
  }

  public UnaryCallable<UpdatePrivateAuctionRequest, PrivateAuction> updatePrivateAuctionCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePrivateAuctionCallable()");
  }

  @Override
  public abstract void close();
}
