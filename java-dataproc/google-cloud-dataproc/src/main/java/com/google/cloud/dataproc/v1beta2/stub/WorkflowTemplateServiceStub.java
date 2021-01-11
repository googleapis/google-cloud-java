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

package com.google.cloud.dataproc.v1beta2.stub;

import static com.google.cloud.dataproc.v1beta2.WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest;
import com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse;
import com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1beta2.WorkflowMetadata;
import com.google.cloud.dataproc.v1beta2.WorkflowTemplate;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WorkflowTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class WorkflowTemplateServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkflowTemplateCallable()");
  }

  public UnaryCallable<GetWorkflowTemplateRequest, WorkflowTemplate> getWorkflowTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkflowTemplateCallable()");
  }

  public OperationCallable<InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateWorkflowTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: instantiateWorkflowTemplateOperationCallable()");
  }

  public UnaryCallable<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: instantiateWorkflowTemplateCallable()");
  }

  public OperationCallable<InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateInlineWorkflowTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: instantiateInlineWorkflowTemplateOperationCallable()");
  }

  public UnaryCallable<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: instantiateInlineWorkflowTemplateCallable()");
  }

  public UnaryCallable<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkflowTemplateCallable()");
  }

  public UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesPagedResponse>
      listWorkflowTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkflowTemplatesPagedCallable()");
  }

  public UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
      listWorkflowTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkflowTemplatesCallable()");
  }

  public UnaryCallable<DeleteWorkflowTemplateRequest, Empty> deleteWorkflowTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkflowTemplateCallable()");
  }

  @Override
  public abstract void close();
}
