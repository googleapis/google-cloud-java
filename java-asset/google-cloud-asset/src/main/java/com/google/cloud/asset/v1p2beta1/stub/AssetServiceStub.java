/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1p2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p2beta1.CreateFeedRequest;
import com.google.cloud.asset.v1p2beta1.DeleteFeedRequest;
import com.google.cloud.asset.v1p2beta1.Feed;
import com.google.cloud.asset.v1p2beta1.GetFeedRequest;
import com.google.cloud.asset.v1p2beta1.ListFeedsRequest;
import com.google.cloud.asset.v1p2beta1.ListFeedsResponse;
import com.google.cloud.asset.v1p2beta1.UpdateFeedRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AssetServiceStub implements BackgroundResource {

  public UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeedCallable()");
  }

  public UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeedCallable()");
  }

  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedsCallable()");
  }

  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeedCallable()");
  }

  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeedCallable()");
  }

  @Override
  public abstract void close();
}
