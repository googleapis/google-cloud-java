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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListLinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.BucketMetadata;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CopyLogEntriesMetadata;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLinkRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLinkRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.Link;
import com.google.logging.v2.LinkMetadata;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLinksRequest;
import com.google.logging.v2.ListLinksResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.Settings;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConfigServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConfigServiceV2Stub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsPagedCallable()");
  }

  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsCallable()");
  }

  public UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: getBucketCallable()");
  }

  public OperationCallable<CreateBucketRequest, LogBucket, BucketMetadata>
      createBucketAsyncOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBucketAsyncOperationCallable()");
  }

  public UnaryCallable<CreateBucketRequest, Operation> createBucketAsyncCallable() {
    throw new UnsupportedOperationException("Not implemented: createBucketAsyncCallable()");
  }

  public OperationCallable<UpdateBucketRequest, LogBucket, BucketMetadata>
      updateBucketAsyncOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBucketAsyncOperationCallable()");
  }

  public UnaryCallable<UpdateBucketRequest, Operation> updateBucketAsyncCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBucketAsyncCallable()");
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

  public OperationCallable<CreateLinkRequest, Link, LinkMetadata> createLinkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createLinkOperationCallable()");
  }

  public UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createLinkCallable()");
  }

  public OperationCallable<DeleteLinkRequest, Empty, LinkMetadata> deleteLinkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLinkOperationCallable()");
  }

  public UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLinkCallable()");
  }

  public UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinksPagedCallable()");
  }

  public UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinksCallable()");
  }

  public UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getLinkCallable()");
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

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  public OperationCallable<CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: copyLogEntriesOperationCallable()");
  }

  public UnaryCallable<CopyLogEntriesRequest, Operation> copyLogEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: copyLogEntriesCallable()");
  }

  @Override
  public abstract void close();
}
