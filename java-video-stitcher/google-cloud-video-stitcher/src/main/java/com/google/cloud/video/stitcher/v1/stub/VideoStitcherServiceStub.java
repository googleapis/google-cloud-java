/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.video.stitcher.v1.stub;

import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListCdnKeysPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.stitcher.v1.CdnKey;
import com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.CreateSlateRequest;
import com.google.cloud.video.stitcher.v1.CreateVodSessionRequest;
import com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.DeleteSlateRequest;
import com.google.cloud.video.stitcher.v1.GetCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.GetSlateRequest;
import com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetVodSessionRequest;
import com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysResponse;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListSlatesRequest;
import com.google.cloud.video.stitcher.v1.ListSlatesResponse;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse;
import com.google.cloud.video.stitcher.v1.LiveAdTagDetail;
import com.google.cloud.video.stitcher.v1.LiveSession;
import com.google.cloud.video.stitcher.v1.Slate;
import com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.UpdateSlateRequest;
import com.google.cloud.video.stitcher.v1.VodAdTagDetail;
import com.google.cloud.video.stitcher.v1.VodSession;
import com.google.cloud.video.stitcher.v1.VodStitchDetail;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VideoStitcherService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VideoStitcherServiceStub implements BackgroundResource {

  public UnaryCallable<CreateCdnKeyRequest, CdnKey> createCdnKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createCdnKeyCallable()");
  }

  public UnaryCallable<ListCdnKeysRequest, ListCdnKeysPagedResponse> listCdnKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCdnKeysPagedCallable()");
  }

  public UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listCdnKeysCallable()");
  }

  public UnaryCallable<GetCdnKeyRequest, CdnKey> getCdnKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getCdnKeyCallable()");
  }

  public UnaryCallable<DeleteCdnKeyRequest, Empty> deleteCdnKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCdnKeyCallable()");
  }

  public UnaryCallable<UpdateCdnKeyRequest, CdnKey> updateCdnKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCdnKeyCallable()");
  }

  public UnaryCallable<CreateVodSessionRequest, VodSession> createVodSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createVodSessionCallable()");
  }

  public UnaryCallable<GetVodSessionRequest, VodSession> getVodSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getVodSessionCallable()");
  }

  public UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVodStitchDetailsPagedCallable()");
  }

  public UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVodStitchDetailsCallable()");
  }

  public UnaryCallable<GetVodStitchDetailRequest, VodStitchDetail> getVodStitchDetailCallable() {
    throw new UnsupportedOperationException("Not implemented: getVodStitchDetailCallable()");
  }

  public UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVodAdTagDetailsPagedCallable()");
  }

  public UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVodAdTagDetailsCallable()");
  }

  public UnaryCallable<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailCallable() {
    throw new UnsupportedOperationException("Not implemented: getVodAdTagDetailCallable()");
  }

  public UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLiveAdTagDetailsPagedCallable()");
  }

  public UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLiveAdTagDetailsCallable()");
  }

  public UnaryCallable<GetLiveAdTagDetailRequest, LiveAdTagDetail> getLiveAdTagDetailCallable() {
    throw new UnsupportedOperationException("Not implemented: getLiveAdTagDetailCallable()");
  }

  public UnaryCallable<CreateSlateRequest, Slate> createSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: createSlateCallable()");
  }

  public UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSlatesPagedCallable()");
  }

  public UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSlatesCallable()");
  }

  public UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: getSlateCallable()");
  }

  public UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSlateCallable()");
  }

  public UnaryCallable<DeleteSlateRequest, Empty> deleteSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSlateCallable()");
  }

  public UnaryCallable<CreateLiveSessionRequest, LiveSession> createLiveSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createLiveSessionCallable()");
  }

  public UnaryCallable<GetLiveSessionRequest, LiveSession> getLiveSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getLiveSessionCallable()");
  }

  @Override
  public abstract void close();
}
