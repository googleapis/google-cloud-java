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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateFeedRequest;
import com.google.cloud.chronicle.v1.DeleteFeedRequest;
import com.google.cloud.chronicle.v1.DisableFeedRequest;
import com.google.cloud.chronicle.v1.EnableFeedRequest;
import com.google.cloud.chronicle.v1.Feed;
import com.google.cloud.chronicle.v1.FeedPack;
import com.google.cloud.chronicle.v1.FeedServiceAccount;
import com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest;
import com.google.cloud.chronicle.v1.GenerateSecretRequest;
import com.google.cloud.chronicle.v1.GenerateSecretResponse;
import com.google.cloud.chronicle.v1.GetFeedPackRequest;
import com.google.cloud.chronicle.v1.GetFeedRequest;
import com.google.cloud.chronicle.v1.ImportPushLogsRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksResponse;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse;
import com.google.cloud.chronicle.v1.ListFeedsRequest;
import com.google.cloud.chronicle.v1.ListFeedsResponse;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse;
import com.google.cloud.chronicle.v1.UpdateFeedRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FeedsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class FeedsServiceStub implements BackgroundResource {

  public UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchServiceAccountForCustomerCallable()");
  }

  public UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeedCallable()");
  }

  public UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeedCallable()");
  }

  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeedCallable()");
  }

  public UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: enableFeedCallable()");
  }

  public UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: disableFeedCallable()");
  }

  public UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedsPagedCallable()");
  }

  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedsCallable()");
  }

  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedPacksPagedCallable()");
  }

  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedPacksCallable()");
  }

  public UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeedPackCallable()");
  }

  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeedCallable()");
  }

  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFeedSourceTypeSchemasPagedCallable()");
  }

  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedSourceTypeSchemasCallable()");
  }

  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogTypeSchemasPagedCallable()");
  }

  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogTypeSchemasCallable()");
  }

  public UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable() {
    throw new UnsupportedOperationException("Not implemented: importPushLogsCallable()");
  }

  public UnaryCallable<GenerateSecretRequest, GenerateSecretResponse> generateSecretCallable() {
    throw new UnsupportedOperationException("Not implemented: generateSecretCallable()");
  }

  @Override
  public abstract void close();
}
