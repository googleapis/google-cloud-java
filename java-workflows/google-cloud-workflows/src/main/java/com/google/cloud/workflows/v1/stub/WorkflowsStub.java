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

package com.google.cloud.workflows.v1.stub;

import static com.google.cloud.workflows.v1.WorkflowsClient.ListWorkflowsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.v1.CreateWorkflowRequest;
import com.google.cloud.workflows.v1.DeleteWorkflowRequest;
import com.google.cloud.workflows.v1.GetWorkflowRequest;
import com.google.cloud.workflows.v1.ListWorkflowsRequest;
import com.google.cloud.workflows.v1.ListWorkflowsResponse;
import com.google.cloud.workflows.v1.OperationMetadata;
import com.google.cloud.workflows.v1.UpdateWorkflowRequest;
import com.google.cloud.workflows.v1.Workflow;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Workflows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WorkflowsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowsPagedCallable()");
  }

  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowsCallable()");
  }

  public UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkflowCallable()");
  }

  public OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkflowOperationCallable()");
  }

  public UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkflowCallable()");
  }

  public OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkflowOperationCallable()");
  }

  public UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkflowCallable()");
  }

  public OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkflowOperationCallable()");
  }

  public UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkflowCallable()");
  }

  @Override
  public abstract void close();
}
