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

package google.maps.fleetengine.delivery.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import google.maps.fleetengine.delivery.v1.DeliveryServiceGrpc.DeliveryServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDeliveryServiceImpl extends DeliveryServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDeliveryServiceImpl() {
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
  public void createDeliveryVehicle(
      CreateDeliveryVehicleRequest request, StreamObserver<DeliveryVehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeliveryVehicle) {
      requests.add(request);
      responseObserver.onNext(((DeliveryVehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeliveryVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeliveryVehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeliveryVehicle(
      GetDeliveryVehicleRequest request, StreamObserver<DeliveryVehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeliveryVehicle) {
      requests.add(request);
      responseObserver.onNext(((DeliveryVehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeliveryVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeliveryVehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeliveryVehicle(
      UpdateDeliveryVehicleRequest request, StreamObserver<DeliveryVehicle> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeliveryVehicle) {
      requests.add(request);
      responseObserver.onNext(((DeliveryVehicle) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeliveryVehicle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeliveryVehicle.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateTasks(
      BatchCreateTasksRequest request, StreamObserver<BatchCreateTasksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateTasksResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateTasksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateTasks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateTasksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTask(CreateTaskRequest request, StreamObserver<Task> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Task.class.getName(),
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
  public void searchTasks(
      SearchTasksRequest request, StreamObserver<SearchTasksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchTasksResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchTasksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchTasks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchTasksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTask(UpdateTaskRequest request, StreamObserver<Task> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Task.class.getName(),
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
  public void getTaskTrackingInfo(
      GetTaskTrackingInfoRequest request, StreamObserver<TaskTrackingInfo> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TaskTrackingInfo) {
      requests.add(request);
      responseObserver.onNext(((TaskTrackingInfo) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTaskTrackingInfo, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TaskTrackingInfo.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeliveryVehicles(
      ListDeliveryVehiclesRequest request,
      StreamObserver<ListDeliveryVehiclesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeliveryVehiclesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeliveryVehiclesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeliveryVehicles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeliveryVehiclesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
