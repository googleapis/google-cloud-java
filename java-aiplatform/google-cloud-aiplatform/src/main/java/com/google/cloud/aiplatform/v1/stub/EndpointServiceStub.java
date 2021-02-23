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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.EndpointServiceClient.ListEndpointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployModelRequest;
import com.google.cloud.aiplatform.v1.DeployModelResponse;
import com.google.cloud.aiplatform.v1.Endpoint;
import com.google.cloud.aiplatform.v1.GetEndpointRequest;
import com.google.cloud.aiplatform.v1.ListEndpointsRequest;
import com.google.cloud.aiplatform.v1.ListEndpointsResponse;
import com.google.cloud.aiplatform.v1.UndeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.UndeployModelRequest;
import com.google.cloud.aiplatform.v1.UndeployModelResponse;
import com.google.cloud.aiplatform.v1.UpdateEndpointRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EndpointServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointOperationCallable()");
  }

  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointCallable()");
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsPagedCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsCallable()");
  }

  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEndpointCallable()");
  }

  public OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointCallable()");
  }

  public OperationCallable<DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelOperationCallable()");
  }

  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelCallable()");
  }

  public OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelOperationCallable()");
  }

  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelCallable()");
  }

  @Override
  public abstract void close();
}
