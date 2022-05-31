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

package com.google.cloud.bigquery.migration.v2alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.migration.v2alpha.MigrationServiceGrpc.MigrationServiceImplBase;
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
public class MockMigrationServiceImpl extends MigrationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMigrationServiceImpl() {
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
  public void createMigrationWorkflow(
      CreateMigrationWorkflowRequest request, StreamObserver<MigrationWorkflow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationWorkflow) {
      requests.add(request);
      responseObserver.onNext(((MigrationWorkflow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMigrationWorkflow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationWorkflow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMigrationWorkflow(
      GetMigrationWorkflowRequest request, StreamObserver<MigrationWorkflow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationWorkflow) {
      requests.add(request);
      responseObserver.onNext(((MigrationWorkflow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMigrationWorkflow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationWorkflow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMigrationWorkflows(
      ListMigrationWorkflowsRequest request,
      StreamObserver<ListMigrationWorkflowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMigrationWorkflowsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMigrationWorkflowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMigrationWorkflows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMigrationWorkflowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMigrationWorkflow(
      DeleteMigrationWorkflowRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMigrationWorkflow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startMigrationWorkflow(
      StartMigrationWorkflowRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method StartMigrationWorkflow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMigrationSubtask(
      GetMigrationSubtaskRequest request, StreamObserver<MigrationSubtask> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationSubtask) {
      requests.add(request);
      responseObserver.onNext(((MigrationSubtask) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMigrationSubtask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationSubtask.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMigrationSubtasks(
      ListMigrationSubtasksRequest request,
      StreamObserver<ListMigrationSubtasksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMigrationSubtasksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMigrationSubtasksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMigrationSubtasks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMigrationSubtasksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
