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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConfigServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class ConfigServiceV2Stub implements BackgroundResource {

  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsPagedCallable()");
  }

  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsCallable()");
  }

  public UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: getBucketCallable()");
  }

  public UnaryCallable<CreateBucketRequest, LogBucket> createBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: createBucketCallable()");
  }

  public UnaryCallable<UpdateBucketRequest, LogBucket> updateBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBucketCallable()");
  }

  public UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBucketCallable()");
  }

  public UnaryCallable<UndeleteBucketRequest, Empty> undeleteBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteBucketCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsPagedCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsCallable()");
  }

  public UnaryCallable<GetViewRequest, LogView> getViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getViewCallable()");
  }

  public UnaryCallable<CreateViewRequest, LogView> createViewCallable() {
    throw new UnsupportedOperationException("Not implemented: createViewCallable()");
  }

  public UnaryCallable<UpdateViewRequest, LogView> updateViewCallable() {
    throw new UnsupportedOperationException("Not implemented: updateViewCallable()");
  }

  public UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteViewCallable()");
  }

  public UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSinksPagedCallable()");
  }

  public UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listSinksCallable()");
  }

  public UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getSinkCallable()");
  }

  public UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createSinkCallable()");
  }

  public UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSinkCallable()");
  }

  public UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSinkCallable()");
  }

  public UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExclusionsPagedCallable()");
  }

  public UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExclusionsCallable()");
  }

  public UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExclusionCallable()");
  }

  public UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: createExclusionCallable()");
  }

  public UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExclusionCallable()");
  }

  public UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExclusionCallable()");
  }

  public UnaryCallable<GetCmekSettingsRequest, CmekSettings> getCmekSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getCmekSettingsCallable()");
  }

  public UnaryCallable<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCmekSettingsCallable()");
  }

  @Override
  public abstract void close();
}
