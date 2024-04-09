/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimeTemplatesPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.AssignNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1.AssignNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1.CreateNotebookRuntimeTemplateOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1.DeleteNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1.DeleteNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.GetNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1.GetNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1.ListNotebookRuntimeTemplatesRequest;
import com.google.cloud.aiplatform.v1.ListNotebookRuntimeTemplatesResponse;
import com.google.cloud.aiplatform.v1.ListNotebookRuntimesRequest;
import com.google.cloud.aiplatform.v1.ListNotebookRuntimesResponse;
import com.google.cloud.aiplatform.v1.NotebookRuntime;
import com.google.cloud.aiplatform.v1.NotebookRuntimeTemplate;
import com.google.cloud.aiplatform.v1.StartNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1.StartNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1.StartNotebookRuntimeResponse;
import com.google.cloud.aiplatform.v1.UpgradeNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1.UpgradeNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1.UpgradeNotebookRuntimeResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NotebookServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createNotebookRuntimeTemplateOperationCallable()");
  }

  public UnaryCallable<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createNotebookRuntimeTemplateCallable()");
  }

  public UnaryCallable<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNotebookRuntimeTemplateCallable()");
  }

  public UnaryCallable<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotebookRuntimeTemplatesPagedCallable()");
  }

  public UnaryCallable<ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
      listNotebookRuntimeTemplatesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotebookRuntimeTemplatesCallable()");
  }

  public OperationCallable<DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNotebookRuntimeTemplateOperationCallable()");
  }

  public UnaryCallable<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNotebookRuntimeTemplateCallable()");
  }

  public OperationCallable<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: assignNotebookRuntimeOperationCallable()");
  }

  public UnaryCallable<AssignNotebookRuntimeRequest, Operation> assignNotebookRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: assignNotebookRuntimeCallable()");
  }

  public UnaryCallable<GetNotebookRuntimeRequest, NotebookRuntime> getNotebookRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: getNotebookRuntimeCallable()");
  }

  public UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotebookRuntimesPagedCallable()");
  }

  public UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
      listNotebookRuntimesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotebookRuntimesCallable()");
  }

  public OperationCallable<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNotebookRuntimeOperationCallable()");
  }

  public UnaryCallable<DeleteNotebookRuntimeRequest, Operation> deleteNotebookRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNotebookRuntimeCallable()");
  }

  public OperationCallable<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: upgradeNotebookRuntimeOperationCallable()");
  }

  public UnaryCallable<UpgradeNotebookRuntimeRequest, Operation> upgradeNotebookRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeNotebookRuntimeCallable()");
  }

  public OperationCallable<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: startNotebookRuntimeOperationCallable()");
  }

  public UnaryCallable<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: startNotebookRuntimeCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
