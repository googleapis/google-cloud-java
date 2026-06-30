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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequestsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.CancelRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.DeleteRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.GetRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupManagerResizeRequestsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequestsListResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionInstanceGroupManagerResizeRequests service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionInstanceGroupManagerResizeRequestsStub implements BackgroundResource {

  public OperationCallable<
          CancelRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelOperationCallable()");
  }

  public UnaryCallable<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
      cancelCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCallable()");
  }

  public OperationCallable<
          DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
      deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<
          GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<
          InsertRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
