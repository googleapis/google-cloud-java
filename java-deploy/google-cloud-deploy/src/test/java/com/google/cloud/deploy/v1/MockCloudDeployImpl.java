/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.deploy.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.deploy.v1.CloudDeployGrpc.CloudDeployImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudDeployImpl extends CloudDeployImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudDeployImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listDeliveryPipelines(
      ListDeliveryPipelinesRequest request,
      StreamObserver<ListDeliveryPipelinesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeliveryPipelinesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeliveryPipelinesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeliveryPipelines, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeliveryPipelinesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeliveryPipeline(
      GetDeliveryPipelineRequest request, StreamObserver<DeliveryPipeline> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeliveryPipeline) {
      requests.add(request);
      responseObserver.onNext(((DeliveryPipeline) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeliveryPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeliveryPipeline.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeliveryPipeline(
      CreateDeliveryPipelineRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeliveryPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeliveryPipeline(
      UpdateDeliveryPipelineRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeliveryPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeliveryPipeline(
      DeleteDeliveryPipelineRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDeliveryPipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTargets(
      ListTargetsRequest request, StreamObserver<ListTargetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTargetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTargetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTargets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTargetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollbackTarget(
      RollbackTargetRequest request, StreamObserver<RollbackTargetResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RollbackTargetResponse) {
      requests.add(request);
      responseObserver.onNext(((RollbackTargetResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RollbackTarget, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RollbackTargetResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTarget(GetTargetRequest request, StreamObserver<Target> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Target) {
      requests.add(request);
      responseObserver.onNext(((Target) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTarget, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Target.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTarget(
      CreateTargetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTarget, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTarget(
      UpdateTargetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTarget, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTarget(
      DeleteTargetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTarget, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomTargetTypes(
      ListCustomTargetTypesRequest request,
      StreamObserver<ListCustomTargetTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomTargetTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomTargetTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomTargetTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomTargetTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomTargetType(
      GetCustomTargetTypeRequest request, StreamObserver<CustomTargetType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomTargetType) {
      requests.add(request);
      responseObserver.onNext(((CustomTargetType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomTargetType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomTargetType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomTargetType(
      CreateCustomTargetTypeRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomTargetType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomTargetType(
      UpdateCustomTargetTypeRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomTargetType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomTargetType(
      DeleteCustomTargetTypeRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteCustomTargetType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReleases(
      ListReleasesRequest request, StreamObserver<ListReleasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReleasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReleasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReleases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReleasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRelease(GetReleaseRequest request, StreamObserver<Release> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Release) {
      requests.add(request);
      responseObserver.onNext(((Release) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Release.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRelease(
      CreateReleaseRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void abandonRelease(
      AbandonReleaseRequest request, StreamObserver<AbandonReleaseResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AbandonReleaseResponse) {
      requests.add(request);
      responseObserver.onNext(((AbandonReleaseResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AbandonRelease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AbandonReleaseResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployPolicy(
      CreateDeployPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeployPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeployPolicy(
      UpdateDeployPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeployPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployPolicy(
      DeleteDeployPolicyRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDeployPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeployPolicies(
      ListDeployPoliciesRequest request,
      StreamObserver<ListDeployPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeployPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeployPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeployPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeployPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeployPolicy(
      GetDeployPolicyRequest request, StreamObserver<DeployPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeployPolicy) {
      requests.add(request);
      responseObserver.onNext(((DeployPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeployPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeployPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveRollout(
      ApproveRolloutRequest request, StreamObserver<ApproveRolloutResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApproveRolloutResponse) {
      requests.add(request);
      responseObserver.onNext(((ApproveRolloutResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApproveRolloutResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void advanceRollout(
      AdvanceRolloutRequest request, StreamObserver<AdvanceRolloutResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdvanceRolloutResponse) {
      requests.add(request);
      responseObserver.onNext(((AdvanceRolloutResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AdvanceRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdvanceRolloutResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelRollout(
      CancelRolloutRequest request, StreamObserver<CancelRolloutResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CancelRolloutResponse) {
      requests.add(request);
      responseObserver.onNext(((CancelRolloutResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CancelRolloutResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRollouts(
      ListRolloutsRequest request, StreamObserver<ListRolloutsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRolloutsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRolloutsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRollouts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRolloutsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRollout(GetRolloutRequest request, StreamObserver<Rollout> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rollout) {
      requests.add(request);
      responseObserver.onNext(((Rollout) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rollout.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRollout(
      CreateRolloutRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRollout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void ignoreJob(
      IgnoreJobRequest request, StreamObserver<IgnoreJobResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IgnoreJobResponse) {
      requests.add(request);
      responseObserver.onNext(((IgnoreJobResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method IgnoreJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IgnoreJobResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retryJob(RetryJobRequest request, StreamObserver<RetryJobResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetryJobResponse) {
      requests.add(request);
      responseObserver.onNext(((RetryJobResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetryJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetryJobResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listJobRuns(
      ListJobRunsRequest request, StreamObserver<ListJobRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListJobRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListJobRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListJobRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListJobRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJobRun(GetJobRunRequest request, StreamObserver<JobRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobRun) {
      requests.add(request);
      responseObserver.onNext(((JobRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetJobRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void terminateJobRun(
      TerminateJobRunRequest request, StreamObserver<TerminateJobRunResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TerminateJobRunResponse) {
      requests.add(request);
      responseObserver.onNext(((TerminateJobRunResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TerminateJobRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TerminateJobRunResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConfig(GetConfigRequest request, StreamObserver<Config> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Config) {
      requests.add(request);
      responseObserver.onNext(((Config) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Config.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAutomation(
      CreateAutomationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAutomation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAutomation(
      UpdateAutomationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAutomation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAutomation(
      DeleteAutomationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteAutomation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAutomation(
      GetAutomationRequest request, StreamObserver<Automation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Automation) {
      requests.add(request);
      responseObserver.onNext(((Automation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAutomation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Automation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutomations(
      ListAutomationsRequest request, StreamObserver<ListAutomationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutomationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutomationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutomations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutomationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAutomationRun(
      GetAutomationRunRequest request, StreamObserver<AutomationRun> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AutomationRun) {
      requests.add(request);
      responseObserver.onNext(((AutomationRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAutomationRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AutomationRun.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutomationRuns(
      ListAutomationRunsRequest request,
      StreamObserver<ListAutomationRunsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutomationRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutomationRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutomationRuns, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutomationRunsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelAutomationRun(
      CancelAutomationRunRequest request,
      StreamObserver<CancelAutomationRunResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CancelAutomationRunResponse) {
      requests.add(request);
      responseObserver.onNext(((CancelAutomationRunResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelAutomationRun, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CancelAutomationRunResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
