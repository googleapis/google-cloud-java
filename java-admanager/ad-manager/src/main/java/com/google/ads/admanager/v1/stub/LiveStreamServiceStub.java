/*
 * Copyright 2026 Google LLC
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

import static com.google.ads.admanager.v1.LiveStreamServiceClient.ListLiveStreamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchActivateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsRequest;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsResponse;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsResponse;
import com.google.ads.admanager.v1.CreateLiveStreamRequest;
import com.google.ads.admanager.v1.GetLiveStreamRequest;
import com.google.ads.admanager.v1.ListLiveStreamsRequest;
import com.google.ads.admanager.v1.ListLiveStreamsResponse;
import com.google.ads.admanager.v1.LiveStream;
import com.google.ads.admanager.v1.UpdateLiveStreamRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LiveStreamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class LiveStreamServiceStub implements BackgroundResource {

  public UnaryCallable<GetLiveStreamRequest, LiveStream> getLiveStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getLiveStreamCallable()");
  }

  public UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsPagedResponse>
      listLiveStreamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLiveStreamsPagedCallable()");
  }

  public UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsResponse> listLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLiveStreamsCallable()");
  }

  public UnaryCallable<CreateLiveStreamRequest, LiveStream> createLiveStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createLiveStreamCallable()");
  }

  public UnaryCallable<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateLiveStreamsCallable()");
  }

  public UnaryCallable<UpdateLiveStreamRequest, LiveStream> updateLiveStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLiveStreamCallable()");
  }

  public UnaryCallable<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateLiveStreamsCallable()");
  }

  public UnaryCallable<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateLiveStreamsCallable()");
  }

  public UnaryCallable<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPauseLiveStreamsCallable()");
  }

  public UnaryCallable<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveLiveStreamsCallable()");
  }

  public UnaryCallable<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPauseAdsLiveStreamsCallable()");
  }

  public UnaryCallable<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRefreshMasterPlaylistsCallable()");
  }

  @Override
  public abstract void close();
}
