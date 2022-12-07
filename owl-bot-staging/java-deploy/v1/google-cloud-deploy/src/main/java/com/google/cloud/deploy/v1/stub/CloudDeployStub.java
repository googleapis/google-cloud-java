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

package com.google.cloud.deploy.v1.stub;

import static com.google.cloud.deploy.v1.CloudDeployClient.ListDeliveryPipelinesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListJobRunsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListLocationsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListReleasesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListRolloutsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListTargetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.deploy.v1.AbandonReleaseRequest;
import com.google.cloud.deploy.v1.AbandonReleaseResponse;
import com.google.cloud.deploy.v1.ApproveRolloutRequest;
import com.google.cloud.deploy.v1.ApproveRolloutResponse;
import com.google.cloud.deploy.v1.Config;
import com.google.cloud.deploy.v1.CreateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.CreateReleaseRequest;
import com.google.cloud.deploy.v1.CreateRolloutRequest;
import com.google.cloud.deploy.v1.CreateTargetRequest;
import com.google.cloud.deploy.v1.DeleteDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.DeleteTargetRequest;
import com.google.cloud.deploy.v1.DeliveryPipeline;
import com.google.cloud.deploy.v1.GetConfigRequest;
import com.google.cloud.deploy.v1.GetDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.GetJobRunRequest;
import com.google.cloud.deploy.v1.GetReleaseRequest;
import com.google.cloud.deploy.v1.GetRolloutRequest;
import com.google.cloud.deploy.v1.GetTargetRequest;
import com.google.cloud.deploy.v1.JobRun;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesRequest;
import com.google.cloud.deploy.v1.ListDeliveryPipelinesResponse;
import com.google.cloud.deploy.v1.ListJobRunsRequest;
import com.google.cloud.deploy.v1.ListJobRunsResponse;
import com.google.cloud.deploy.v1.ListReleasesRequest;
import com.google.cloud.deploy.v1.ListReleasesResponse;
import com.google.cloud.deploy.v1.ListRolloutsRequest;
import com.google.cloud.deploy.v1.ListRolloutsResponse;
import com.google.cloud.deploy.v1.ListTargetsRequest;
import com.google.cloud.deploy.v1.ListTargetsResponse;
import com.google.cloud.deploy.v1.OperationMetadata;
import com.google.cloud.deploy.v1.Release;
import com.google.cloud.deploy.v1.RetryJobRequest;
import com.google.cloud.deploy.v1.RetryJobResponse;
import com.google.cloud.deploy.v1.Rollout;
import com.google.cloud.deploy.v1.Target;
import com.google.cloud.deploy.v1.UpdateDeliveryPipelineRequest;
import com.google.cloud.deploy.v1.UpdateTargetRequest;
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
 * Base stub class for the CloudDeploy service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudDeployStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDeliveryPipelinesPagedCallable()");
  }

  public UnaryCallable<ListDeliveryPipelinesRequest, ListDeliveryPipelinesResponse>
      listDeliveryPipelinesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeliveryPipelinesCallable()");
  }

  public UnaryCallable<GetDeliveryPipelineRequest, DeliveryPipeline> getDeliveryPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeliveryPipelineCallable()");
  }

  public OperationCallable<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDeliveryPipelineOperationCallable()");
  }

  public UnaryCallable<CreateDeliveryPipelineRequest, Operation> createDeliveryPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeliveryPipelineCallable()");
  }

  public OperationCallable<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDeliveryPipelineOperationCallable()");
  }

  public UnaryCallable<UpdateDeliveryPipelineRequest, Operation> updateDeliveryPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeliveryPipelineCallable()");
  }

  public OperationCallable<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDeliveryPipelineOperationCallable()");
  }

  public UnaryCallable<DeleteDeliveryPipelineRequest, Operation> deleteDeliveryPipelineCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeliveryPipelineCallable()");
  }

  public UnaryCallable<ListTargetsRequest, ListTargetsPagedResponse> listTargetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetsPagedCallable()");
  }

  public UnaryCallable<ListTargetsRequest, ListTargetsResponse> listTargetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetsCallable()");
  }

  public UnaryCallable<GetTargetRequest, Target> getTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetCallable()");
  }

  public OperationCallable<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetOperationCallable()");
  }

  public UnaryCallable<CreateTargetRequest, Operation> createTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetCallable()");
  }

  public OperationCallable<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetOperationCallable()");
  }

  public UnaryCallable<UpdateTargetRequest, Operation> updateTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetCallable()");
  }

  public OperationCallable<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetOperationCallable()");
  }

  public UnaryCallable<DeleteTargetRequest, Operation> deleteTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesPagedCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesCallable()");
  }

  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getReleaseCallable()");
  }

  public OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseOperationCallable()");
  }

  public UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseCallable()");
  }

  public UnaryCallable<AbandonReleaseRequest, AbandonReleaseResponse> abandonReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: abandonReleaseCallable()");
  }

  public UnaryCallable<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: approveRolloutCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsPagedCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsCallable()");
  }

  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: getRolloutCallable()");
  }

  public OperationCallable<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRolloutOperationCallable()");
  }

  public UnaryCallable<CreateRolloutRequest, Operation> createRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: createRolloutCallable()");
  }

  public UnaryCallable<RetryJobRequest, RetryJobResponse> retryJobCallable() {
    throw new UnsupportedOperationException("Not implemented: retryJobCallable()");
  }

  public UnaryCallable<ListJobRunsRequest, ListJobRunsPagedResponse> listJobRunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobRunsPagedCallable()");
  }

  public UnaryCallable<ListJobRunsRequest, ListJobRunsResponse> listJobRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobRunsCallable()");
  }

  public UnaryCallable<GetJobRunRequest, JobRun> getJobRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobRunCallable()");
  }

  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getConfigCallable()");
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
