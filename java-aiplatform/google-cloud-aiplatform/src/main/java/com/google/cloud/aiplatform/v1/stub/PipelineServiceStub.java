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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListPipelineJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListTrainingPipelinesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CancelPipelineJobRequest;
import com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.CreatePipelineJobRequest;
import com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeletePipelineJobRequest;
import com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.GetPipelineJobRequest;
import com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.ListPipelineJobsRequest;
import com.google.cloud.aiplatform.v1.ListPipelineJobsResponse;
import com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest;
import com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse;
import com.google.cloud.aiplatform.v1.PipelineJob;
import com.google.cloud.aiplatform.v1.TrainingPipeline;
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
 * Base stub class for the PipelineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PipelineServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: createTrainingPipelineCallable()");
  }

  public UnaryCallable<GetTrainingPipelineRequest, TrainingPipeline> getTrainingPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: getTrainingPipelineCallable()");
  }

  public UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTrainingPipelinesPagedCallable()");
  }

  public UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTrainingPipelinesCallable()");
  }

  public OperationCallable<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteTrainingPipelineOperationCallable()");
  }

  public UnaryCallable<DeleteTrainingPipelineRequest, Operation> deleteTrainingPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTrainingPipelineCallable()");
  }

  public UnaryCallable<CancelTrainingPipelineRequest, Empty> cancelTrainingPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelTrainingPipelineCallable()");
  }

  public UnaryCallable<CreatePipelineJobRequest, PipelineJob> createPipelineJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createPipelineJobCallable()");
  }

  public UnaryCallable<GetPipelineJobRequest, PipelineJob> getPipelineJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getPipelineJobCallable()");
  }

  public UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsPagedResponse>
      listPipelineJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPipelineJobsPagedCallable()");
  }

  public UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsResponse>
      listPipelineJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPipelineJobsCallable()");
  }

  public OperationCallable<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
      deletePipelineJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePipelineJobOperationCallable()");
  }

  public UnaryCallable<DeletePipelineJobRequest, Operation> deletePipelineJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePipelineJobCallable()");
  }

  public UnaryCallable<CancelPipelineJobRequest, Empty> cancelPipelineJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelPipelineJobCallable()");
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
