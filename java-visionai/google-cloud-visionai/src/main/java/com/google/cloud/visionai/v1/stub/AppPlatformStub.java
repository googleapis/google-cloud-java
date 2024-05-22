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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AddApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.AddApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.Application;
import com.google.cloud.visionai.v1.CreateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.CreateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.CreateApplicationRequest;
import com.google.cloud.visionai.v1.CreateDraftRequest;
import com.google.cloud.visionai.v1.CreateProcessorRequest;
import com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest;
import com.google.cloud.visionai.v1.DeleteApplicationRequest;
import com.google.cloud.visionai.v1.DeleteDraftRequest;
import com.google.cloud.visionai.v1.DeleteProcessorRequest;
import com.google.cloud.visionai.v1.DeployApplicationRequest;
import com.google.cloud.visionai.v1.DeployApplicationResponse;
import com.google.cloud.visionai.v1.Draft;
import com.google.cloud.visionai.v1.GetApplicationRequest;
import com.google.cloud.visionai.v1.GetDraftRequest;
import com.google.cloud.visionai.v1.GetInstanceRequest;
import com.google.cloud.visionai.v1.GetProcessorRequest;
import com.google.cloud.visionai.v1.Instance;
import com.google.cloud.visionai.v1.ListApplicationsRequest;
import com.google.cloud.visionai.v1.ListApplicationsResponse;
import com.google.cloud.visionai.v1.ListDraftsRequest;
import com.google.cloud.visionai.v1.ListDraftsResponse;
import com.google.cloud.visionai.v1.ListInstancesRequest;
import com.google.cloud.visionai.v1.ListInstancesResponse;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse;
import com.google.cloud.visionai.v1.ListProcessorsRequest;
import com.google.cloud.visionai.v1.ListProcessorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Processor;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UndeployApplicationRequest;
import com.google.cloud.visionai.v1.UndeployApplicationResponse;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.UpdateApplicationRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UpdateDraftRequest;
import com.google.cloud.visionai.v1.UpdateProcessorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AppPlatform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AppPlatformStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsPagedCallable()");
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsCallable()");
  }

  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: getApplicationCallable()");
  }

  public OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApplicationOperationCallable()");
  }

  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApplicationCallable()");
  }

  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationOperationCallable()");
  }

  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApplicationCallable()");
  }

  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationOperationCallable()");
  }

  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApplicationCallable()");
  }

  public OperationCallable<DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deployApplicationOperationCallable()");
  }

  public UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployApplicationCallable()");
  }

  public OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeployApplicationOperationCallable()");
  }

  public UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployApplicationCallable()");
  }

  public OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addApplicationStreamInputOperationCallable()");
  }

  public UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable() {
    throw new UnsupportedOperationException("Not implemented: addApplicationStreamInputCallable()");
  }

  public OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeApplicationStreamInputOperationCallable()");
  }

  public UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeApplicationStreamInputCallable()");
  }

  public OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationStreamInputOperationCallable()");
  }

  public UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationStreamInputCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApplicationInstancesOperationCallable()");
  }

  public UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createApplicationInstancesCallable()");
  }

  public OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationInstancesOperationCallable()");
  }

  public UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationInstancesCallable()");
  }

  public OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationInstancesOperationCallable()");
  }

  public UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateApplicationInstancesCallable()");
  }

  public UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDraftsPagedCallable()");
  }

  public UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDraftsCallable()");
  }

  public UnaryCallable<GetDraftRequest, Draft> getDraftCallable() {
    throw new UnsupportedOperationException("Not implemented: getDraftCallable()");
  }

  public OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDraftOperationCallable()");
  }

  public UnaryCallable<CreateDraftRequest, Operation> createDraftCallable() {
    throw new UnsupportedOperationException("Not implemented: createDraftCallable()");
  }

  public OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDraftOperationCallable()");
  }

  public UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDraftCallable()");
  }

  public OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDraftOperationCallable()");
  }

  public UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDraftCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsPagedCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsCallable()");
  }

  public UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrebuiltProcessorsCallable()");
  }

  public UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: getProcessorCallable()");
  }

  public OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessorOperationCallable()");
  }

  public UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessorCallable()");
  }

  public OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProcessorOperationCallable()");
  }

  public UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProcessorCallable()");
  }

  public OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessorOperationCallable()");
  }

  public UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessorCallable()");
  }

  @Override
  public abstract void close();
}
