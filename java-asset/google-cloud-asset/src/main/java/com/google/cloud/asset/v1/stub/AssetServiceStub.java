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

package com.google.cloud.asset.v1.stub;

import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningResponse;
import com.google.cloud.asset.v1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1.CreateFeedRequest;
import com.google.cloud.asset.v1.DeleteFeedRequest;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.GetFeedRequest;
import com.google.cloud.asset.v1.ListFeedsRequest;
import com.google.cloud.asset.v1.ListFeedsResponse;
import com.google.cloud.asset.v1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1.UpdateFeedRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AssetServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAssetsOperationCallable()");
  }

  public UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAssetsCallable()");
  }

  public UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetAssetsHistoryCallable()");
  }

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

  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllResourcesPagedCallable()");
  }

  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllResourcesCallable()");
  }

  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllIamPoliciesPagedCallable()");
  }

  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllIamPoliciesCallable()");
  }

  public UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeIamPolicyCallable()");
  }

  public OperationCallable<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: analyzeIamPolicyLongrunningOperationCallable()");
  }

  public UnaryCallable<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: analyzeIamPolicyLongrunningCallable()");
  }

  @Override
  public abstract void close();
}
