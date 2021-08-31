/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.aiplatform.v1.IndexEndpointServiceClient.ListIndexEndpointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateIndexEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateIndexEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteIndexEndpointRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployIndexRequest;
import com.google.cloud.aiplatform.v1.DeployIndexResponse;
import com.google.cloud.aiplatform.v1.GetIndexEndpointRequest;
import com.google.cloud.aiplatform.v1.IndexEndpoint;
import com.google.cloud.aiplatform.v1.ListIndexEndpointsRequest;
import com.google.cloud.aiplatform.v1.ListIndexEndpointsResponse;
import com.google.cloud.aiplatform.v1.UndeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1.UndeployIndexRequest;
import com.google.cloud.aiplatform.v1.UndeployIndexResponse;
import com.google.cloud.aiplatform.v1.UpdateIndexEndpointRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IndexEndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IndexEndpointServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIndexEndpointOperationCallable()");
  }

  public UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexEndpointCallable()");
  }

  public UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexEndpointCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsPagedCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsCallable()");
  }

  public UnaryCallable<UpdateIndexEndpointRequest, IndexEndpoint> updateIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexEndpointCallable()");
  }

  public OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIndexEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexEndpointCallable()");
  }

  public OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexOperationCallable()");
  }

  public UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexCallable()");
  }

  public OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexOperationCallable()");
  }

  public UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexCallable()");
  }

  @Override
  public abstract void close();
}
