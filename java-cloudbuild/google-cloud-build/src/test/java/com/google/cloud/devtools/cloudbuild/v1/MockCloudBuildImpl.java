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

package com.google.cloud.devtools.cloudbuild.v1;

import com.google.api.core.BetaApi;
import com.google.cloudbuild.v1.ApproveBuildRequest;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CloudBuildGrpc.CloudBuildImplBase;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudBuildImpl extends CloudBuildImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudBuildImpl() {
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
  public void createBuild(CreateBuildRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateBuild, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBuild(GetBuildRequest request, StreamObserver<Build> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Build) {
      requests.add(request);
      responseObserver.onNext(((Build) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBuild, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Build.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBuilds(
      ListBuildsRequest request, StreamObserver<ListBuildsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBuildsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBuildsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBuilds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBuildsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelBuild(CancelBuildRequest request, StreamObserver<Build> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Build) {
      requests.add(request);
      responseObserver.onNext(((Build) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelBuild, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Build.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retryBuild(RetryBuildRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RetryBuild, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveBuild(
      ApproveBuildRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ApproveBuild, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBuildTrigger(
      CreateBuildTriggerRequest request, StreamObserver<BuildTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BuildTrigger) {
      requests.add(request);
      responseObserver.onNext(((BuildTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBuildTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BuildTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBuildTrigger(
      GetBuildTriggerRequest request, StreamObserver<BuildTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BuildTrigger) {
      requests.add(request);
      responseObserver.onNext(((BuildTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBuildTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BuildTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBuildTriggers(
      ListBuildTriggersRequest request,
      StreamObserver<ListBuildTriggersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBuildTriggersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBuildTriggersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBuildTriggers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBuildTriggersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBuildTrigger(
      DeleteBuildTriggerRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBuildTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBuildTrigger(
      UpdateBuildTriggerRequest request, StreamObserver<BuildTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BuildTrigger) {
      requests.add(request);
      responseObserver.onNext(((BuildTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBuildTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BuildTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runBuildTrigger(
      RunBuildTriggerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RunBuildTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void receiveTriggerWebhook(
      ReceiveTriggerWebhookRequest request,
      StreamObserver<ReceiveTriggerWebhookResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReceiveTriggerWebhookResponse) {
      requests.add(request);
      responseObserver.onNext(((ReceiveTriggerWebhookResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReceiveTriggerWebhook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReceiveTriggerWebhookResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkerPool(
      CreateWorkerPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkerPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkerPool(
      GetWorkerPoolRequest request, StreamObserver<WorkerPool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkerPool) {
      requests.add(request);
      responseObserver.onNext(((WorkerPool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkerPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkerPool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkerPool(
      DeleteWorkerPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkerPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkerPool(
      UpdateWorkerPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkerPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkerPools(
      ListWorkerPoolsRequest request, StreamObserver<ListWorkerPoolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkerPoolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkerPoolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkerPools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkerPoolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
