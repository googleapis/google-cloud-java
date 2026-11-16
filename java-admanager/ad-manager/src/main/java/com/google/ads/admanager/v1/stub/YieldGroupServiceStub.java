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

import static com.google.ads.admanager.v1.YieldGroupServiceClient.ListYieldGroupsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchActivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsResponse;
import com.google.ads.admanager.v1.CreateYieldGroupRequest;
import com.google.ads.admanager.v1.GetYieldGroupRequest;
import com.google.ads.admanager.v1.ListYieldGroupsRequest;
import com.google.ads.admanager.v1.ListYieldGroupsResponse;
import com.google.ads.admanager.v1.UpdateYieldGroupRequest;
import com.google.ads.admanager.v1.YieldGroup;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the YieldGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class YieldGroupServiceStub implements BackgroundResource {

  public UnaryCallable<GetYieldGroupRequest, YieldGroup> getYieldGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getYieldGroupCallable()");
  }

  public UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsPagedResponse>
      listYieldGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listYieldGroupsPagedCallable()");
  }

  public UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsResponse> listYieldGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listYieldGroupsCallable()");
  }

  public UnaryCallable<CreateYieldGroupRequest, YieldGroup> createYieldGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createYieldGroupCallable()");
  }

  public UnaryCallable<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateYieldGroupsCallable()");
  }

  public UnaryCallable<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateYieldGroupCallable()");
  }

  public UnaryCallable<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateYieldGroupsCallable()");
  }

  public UnaryCallable<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateYieldGroupsCallable()");
  }

  public UnaryCallable<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateYieldGroupsCallable()");
  }

  public UnaryCallable<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveYieldGroupsCallable()");
  }

  @Override
  public abstract void close();
}
