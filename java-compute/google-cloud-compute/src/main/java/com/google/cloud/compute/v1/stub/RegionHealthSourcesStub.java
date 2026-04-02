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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionHealthSourcesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionHealthSourcesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRegionHealthSourcesRequest;
import com.google.cloud.compute.v1.DeleteRegionHealthSourceRequest;
import com.google.cloud.compute.v1.GetRegionHealthSourceRequest;
import com.google.cloud.compute.v1.HealthSource;
import com.google.cloud.compute.v1.HealthSourceAggregatedList;
import com.google.cloud.compute.v1.HealthSourceList;
import com.google.cloud.compute.v1.InsertRegionHealthSourceRequest;
import com.google.cloud.compute.v1.ListRegionHealthSourcesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthSourceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionHealthSourceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionHealthSources service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionHealthSourcesStub implements BackgroundResource {

  public UnaryCallable<AggregatedListRegionHealthSourcesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListRegionHealthSourcesRequest, HealthSourceAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteRegionHealthSourceRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionHealthSourceRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionHealthSourceRequest, HealthSource> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionHealthSourceRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionHealthSourceRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionHealthSourcesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionHealthSourcesRequest, HealthSourceList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchRegionHealthSourceRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchRegionHealthSourceRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<TestIamPermissionsRegionHealthSourceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
