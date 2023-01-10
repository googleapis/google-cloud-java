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

package com.google.cloud.dataproc.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateNodeGroupRequest;
import com.google.cloud.dataproc.v1.GetNodeGroupRequest;
import com.google.cloud.dataproc.v1.NodeGroup;
import com.google.cloud.dataproc.v1.NodeGroupOperationMetadata;
import com.google.cloud.dataproc.v1.ResizeNodeGroupRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NodeGroupController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NodeGroupControllerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodeGroupOperationCallable()");
  }

  public UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodeGroupCallable()");
  }

  public OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeNodeGroupOperationCallable()");
  }

  public UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeNodeGroupCallable()");
  }

  public UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeGroupCallable()");
  }

  @Override
  public abstract void close();
}
