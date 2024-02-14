/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.orchestration.airflow.service.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.orchestration.airflow.service.v1.EnvironmentsGrpc.EnvironmentsImplBase;
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
public class MockEnvironmentsImpl extends EnvironmentsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEnvironmentsImpl() {
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
  public void executeAirflowCommand(
      ExecuteAirflowCommandRequest request,
      StreamObserver<ExecuteAirflowCommandResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExecuteAirflowCommandResponse) {
      requests.add(request);
      responseObserver.onNext(((ExecuteAirflowCommandResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExecuteAirflowCommand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExecuteAirflowCommandResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopAirflowCommand(
      StopAirflowCommandRequest request,
      StreamObserver<StopAirflowCommandResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StopAirflowCommandResponse) {
      requests.add(request);
      responseObserver.onNext(((StopAirflowCommandResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StopAirflowCommand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StopAirflowCommandResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pollAirflowCommand(
      PollAirflowCommandRequest request,
      StreamObserver<PollAirflowCommandResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PollAirflowCommandResponse) {
      requests.add(request);
      responseObserver.onNext(((PollAirflowCommandResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PollAirflowCommand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PollAirflowCommandResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkloads(
      ListWorkloadsRequest request, StreamObserver<ListWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUserWorkloadsSecret(
      CreateUserWorkloadsSecretRequest request,
      StreamObserver<UserWorkloadsSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsSecret) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserWorkloadsSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUserWorkloadsSecret(
      GetUserWorkloadsSecretRequest request, StreamObserver<UserWorkloadsSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsSecret) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserWorkloadsSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserWorkloadsSecrets(
      ListUserWorkloadsSecretsRequest request,
      StreamObserver<ListUserWorkloadsSecretsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserWorkloadsSecretsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserWorkloadsSecretsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserWorkloadsSecrets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserWorkloadsSecretsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserWorkloadsSecret(
      UpdateUserWorkloadsSecretRequest request,
      StreamObserver<UserWorkloadsSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsSecret) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserWorkloadsSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUserWorkloadsSecret(
      DeleteUserWorkloadsSecretRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUserWorkloadsSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUserWorkloadsConfigMap(
      CreateUserWorkloadsConfigMapRequest request,
      StreamObserver<UserWorkloadsConfigMap> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsConfigMap) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsConfigMap) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserWorkloadsConfigMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsConfigMap.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUserWorkloadsConfigMap(
      GetUserWorkloadsConfigMapRequest request,
      StreamObserver<UserWorkloadsConfigMap> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsConfigMap) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsConfigMap) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserWorkloadsConfigMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsConfigMap.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserWorkloadsConfigMaps(
      ListUserWorkloadsConfigMapsRequest request,
      StreamObserver<ListUserWorkloadsConfigMapsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserWorkloadsConfigMapsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserWorkloadsConfigMapsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserWorkloadsConfigMaps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserWorkloadsConfigMapsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserWorkloadsConfigMap(
      UpdateUserWorkloadsConfigMapRequest request,
      StreamObserver<UserWorkloadsConfigMap> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserWorkloadsConfigMap) {
      requests.add(request);
      responseObserver.onNext(((UserWorkloadsConfigMap) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserWorkloadsConfigMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserWorkloadsConfigMap.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUserWorkloadsConfigMap(
      DeleteUserWorkloadsConfigMapRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUserWorkloadsConfigMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void saveSnapshot(
      SaveSnapshotRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SaveSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void loadSnapshot(
      LoadSnapshotRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method LoadSnapshot, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void databaseFailover(
      DatabaseFailoverRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DatabaseFailover, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchDatabaseProperties(
      FetchDatabasePropertiesRequest request,
      StreamObserver<FetchDatabasePropertiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchDatabasePropertiesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchDatabasePropertiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchDatabaseProperties, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchDatabasePropertiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
