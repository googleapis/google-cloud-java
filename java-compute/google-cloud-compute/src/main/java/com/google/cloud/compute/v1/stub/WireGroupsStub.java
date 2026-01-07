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

import static com.google.cloud.compute.v1.WireGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteWireGroupRequest;
import com.google.cloud.compute.v1.GetWireGroupRequest;
import com.google.cloud.compute.v1.InsertWireGroupRequest;
import com.google.cloud.compute.v1.ListWireGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchWireGroupRequest;
import com.google.cloud.compute.v1.WireGroup;
import com.google.cloud.compute.v1.WireGroupList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WireGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WireGroupsStub implements BackgroundResource {

  public OperationCallable<DeleteWireGroupRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteWireGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetWireGroupRequest, WireGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertWireGroupRequest, Operation, Operation> insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertWireGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListWireGroupsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListWireGroupsRequest, WireGroupList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchWireGroupRequest, Operation, Operation> patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchWireGroupRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  @Override
  public abstract void close();
}
