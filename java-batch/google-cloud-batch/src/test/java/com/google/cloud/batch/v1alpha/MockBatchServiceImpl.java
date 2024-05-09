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

package com.google.cloud.batch.v1alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.batch.v1alpha.BatchServiceGrpc.BatchServiceImplBase;
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
public class MockBatchServiceImpl extends BatchServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBatchServiceImpl() {
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
  public void createJob(CreateJobRequest request, StreamObserver<Job> responseObserver) {
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
                  "Unrecognized response type %s for method CreateJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Job.class.getName(),
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
  public void deleteJob(DeleteJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateJob(UpdateJobRequest request, StreamObserver<Job> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Job.class.getName(),
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
  public void createResourceAllowance(
      CreateResourceAllowanceRequest request, StreamObserver<ResourceAllowance> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResourceAllowance) {
      requests.add(request);
      responseObserver.onNext(((ResourceAllowance) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateResourceAllowance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResourceAllowance.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getResourceAllowance(
      GetResourceAllowanceRequest request, StreamObserver<ResourceAllowance> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResourceAllowance) {
      requests.add(request);
      responseObserver.onNext(((ResourceAllowance) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetResourceAllowance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResourceAllowance.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteResourceAllowance(
      DeleteResourceAllowanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteResourceAllowance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listResourceAllowances(
      ListResourceAllowancesRequest request,
      StreamObserver<ListResourceAllowancesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListResourceAllowancesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListResourceAllowancesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListResourceAllowances, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListResourceAllowancesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateResourceAllowance(
      UpdateResourceAllowanceRequest request, StreamObserver<ResourceAllowance> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResourceAllowance) {
      requests.add(request);
      responseObserver.onNext(((ResourceAllowance) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateResourceAllowance, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResourceAllowance.class.getName(),
                  Exception.class.getName())));
    }
  }
}
