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
}
