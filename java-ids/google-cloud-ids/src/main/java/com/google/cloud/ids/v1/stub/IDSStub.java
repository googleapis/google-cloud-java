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

package com.google.cloud.ids.v1.stub;

import static com.google.cloud.ids.v1.IDSClient.ListEndpointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ids.v1.CreateEndpointRequest;
import com.google.cloud.ids.v1.DeleteEndpointRequest;
import com.google.cloud.ids.v1.Endpoint;
import com.google.cloud.ids.v1.GetEndpointRequest;
import com.google.cloud.ids.v1.ListEndpointsRequest;
import com.google.cloud.ids.v1.ListEndpointsResponse;
import com.google.cloud.ids.v1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IDS service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IDSStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsPagedCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsCallable()");
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointCallable()");
  }

  public OperationCallable<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointOperationCallable()");
  }

  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointCallable()");
  }

  public OperationCallable<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointCallable()");
  }

  @Override
  public abstract void close();
}
