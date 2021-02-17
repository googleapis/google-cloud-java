/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.talent.v4beta1.JobServiceGrpc.JobServiceImplBase;
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
public class MockJobServiceImpl extends JobServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockJobServiceImpl() {
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
    Object response = responses.remove();
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
                  response.getClass().getName(), Job.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateJobs(
      BatchCreateJobsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchCreateJobs, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJob(GetJobRequest request, StreamObserver<Job> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(), Job.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void updateJob(UpdateJobRequest request, StreamObserver<Job> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(), Job.class.getName(), Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateJobs(
      BatchUpdateJobsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchUpdateJobs, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteJob(DeleteJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteJob, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteJobs(
      BatchDeleteJobsRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchDeleteJobs, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listJobs(ListJobsRequest request, StreamObserver<ListJobsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchJobs(
      SearchJobsRequest request, StreamObserver<SearchJobsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchJobs, expected %s or %s",
                  response.getClass().getName(),
                  SearchJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchJobsForAlert(
      SearchJobsRequest request, StreamObserver<SearchJobsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchJobsForAlert, expected %s or %s",
                  response.getClass().getName(),
                  SearchJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
