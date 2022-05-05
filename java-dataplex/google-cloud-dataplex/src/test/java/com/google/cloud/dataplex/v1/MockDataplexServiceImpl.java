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

package com.google.cloud.dataplex.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataplex.v1.DataplexServiceGrpc.DataplexServiceImplBase;
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
public class MockDataplexServiceImpl extends DataplexServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataplexServiceImpl() {
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
  public void createLake(CreateLakeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateLake, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLake(UpdateLakeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateLake, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLake(DeleteLakeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLake, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLakes(
      ListLakesRequest request, StreamObserver<ListLakesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLakesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLakesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLakes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLakesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLake(GetLakeRequest request, StreamObserver<Lake> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lake) {
      requests.add(request);
      responseObserver.onNext(((Lake) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLake, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lake.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLakeActions(
      ListLakeActionsRequest request, StreamObserver<ListActionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListActionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListActionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLakeActions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListActionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createZone(CreateZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateZone(UpdateZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteZone(DeleteZoneRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listZones(
      ListZonesRequest request, StreamObserver<ListZonesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListZonesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListZonesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListZones, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListZonesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getZone(GetZoneRequest request, StreamObserver<Zone> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Zone) {
      requests.add(request);
      responseObserver.onNext(((Zone) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetZone, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Zone.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listZoneActions(
      ListZoneActionsRequest request, StreamObserver<ListActionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListActionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListActionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListZoneActions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListActionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAsset(CreateAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAsset(UpdateAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAsset(DeleteAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAsset(GetAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssetActions(
      ListAssetActionsRequest request, StreamObserver<ListActionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListActionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListActionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssetActions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListActionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTask(CreateTaskRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTask(UpdateTaskRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTask(DeleteTaskRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTasks(
      ListTasksRequest request, StreamObserver<ListTasksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTasksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTasksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTasks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTasksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTask(GetTaskRequest request, StreamObserver<Task> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Task) {
      requests.add(request);
      responseObserver.onNext(((Task) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Task.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listJobs(ListJobsRequest request, StreamObserver<ListJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJob(GetJobRequest request, StreamObserver<Job> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Job) {
      requests.add(request);
      responseObserver.onNext(((Job) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Job.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelJob(CancelJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEnvironment(
      CreateEnvironmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEnvironment(
      UpdateEnvironmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEnvironment(
      DeleteEnvironmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEnvironments(
      ListEnvironmentsRequest request, StreamObserver<ListEnvironmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEnvironmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEnvironmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEnvironments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEnvironmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnvironment(
      GetEnvironmentRequest request, StreamObserver<Environment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Environment) {
      requests.add(request);
      responseObserver.onNext(((Environment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEnvironment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Environment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSessions(
      ListSessionsRequest request, StreamObserver<ListSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSessions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
