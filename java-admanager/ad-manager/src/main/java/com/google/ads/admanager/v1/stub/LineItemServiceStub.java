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

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemsResponse;
import com.google.ads.admanager.v1.BatchArchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchArchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReleaseLineItemsRequest;
import com.google.ads.admanager.v1.BatchReleaseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeLineItemsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchUpdateLineItemsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemsResponse;
import com.google.ads.admanager.v1.CreateLineItemRequest;
import com.google.ads.admanager.v1.GetLineItemRequest;
import com.google.ads.admanager.v1.LineItem;
import com.google.ads.admanager.v1.ListLineItemsRequest;
import com.google.ads.admanager.v1.ListLineItemsResponse;
import com.google.ads.admanager.v1.UpdateLineItemRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LineItemService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class LineItemServiceStub implements BackgroundResource {

  public UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable() {
    throw new UnsupportedOperationException("Not implemented: getLineItemCallable()");
  }

  public UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLineItemsPagedCallable()");
  }

  public UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLineItemsCallable()");
  }

  public UnaryCallable<CreateLineItemRequest, LineItem> createLineItemCallable() {
    throw new UnsupportedOperationException("Not implemented: createLineItemCallable()");
  }

  public UnaryCallable<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateLineItemsCallable()");
  }

  public UnaryCallable<UpdateLineItemRequest, LineItem> updateLineItemCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLineItemCallable()");
  }

  public UnaryCallable<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateLineItemsCallable()");
  }

  public UnaryCallable<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateLineItemsCallable()");
  }

  public UnaryCallable<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPauseLineItemsCallable()");
  }

  public UnaryCallable<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchResumeLineItemsCallable()");
  }

  public UnaryCallable<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchResumeAndOverbookLineItemsCallable()");
  }

  public UnaryCallable<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteLineItemsCallable()");
  }

  public UnaryCallable<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchReserveLineItemsCallable()");
  }

  public UnaryCallable<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchReserveAndOverbookLineItemsCallable()");
  }

  public UnaryCallable<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchReleaseLineItemsCallable()");
  }

  public UnaryCallable<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveLineItemsCallable()");
  }

  public UnaryCallable<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUnarchiveLineItemsCallable()");
  }

  @Override
  public abstract void close();
}
