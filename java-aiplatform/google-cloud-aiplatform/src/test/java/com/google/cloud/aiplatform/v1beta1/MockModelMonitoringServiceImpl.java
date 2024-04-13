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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceGrpc.ModelMonitoringServiceImplBase;
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
public class MockModelMonitoringServiceImpl extends ModelMonitoringServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockModelMonitoringServiceImpl() {
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
  public void createModelMonitor(
      CreateModelMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateModelMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateModelMonitor(
      UpdateModelMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateModelMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelMonitor(
      GetModelMonitorRequest request, StreamObserver<ModelMonitor> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelMonitor) {
      requests.add(request);
      responseObserver.onNext(((ModelMonitor) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModelMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelMonitor.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelMonitors(
      ListModelMonitorsRequest request,
      StreamObserver<ListModelMonitorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelMonitorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelMonitorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelMonitors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelMonitorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModelMonitor(
      DeleteModelMonitorRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteModelMonitor, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createModelMonitoringJob(
      CreateModelMonitoringJobRequest request,
      StreamObserver<ModelMonitoringJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelMonitoringJob) {
      requests.add(request);
      responseObserver.onNext(((ModelMonitoringJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateModelMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelMonitoringJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelMonitoringJob(
      GetModelMonitoringJobRequest request, StreamObserver<ModelMonitoringJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelMonitoringJob) {
      requests.add(request);
      responseObserver.onNext(((ModelMonitoringJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModelMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelMonitoringJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelMonitoringJobs(
      ListModelMonitoringJobsRequest request,
      StreamObserver<ListModelMonitoringJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelMonitoringJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelMonitoringJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelMonitoringJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelMonitoringJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModelMonitoringJob(
      DeleteModelMonitoringJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteModelMonitoringJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchModelMonitoringStats(
      SearchModelMonitoringStatsRequest request,
      StreamObserver<SearchModelMonitoringStatsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchModelMonitoringStatsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchModelMonitoringStatsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchModelMonitoringStats, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchModelMonitoringStatsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchModelMonitoringAlerts(
      SearchModelMonitoringAlertsRequest request,
      StreamObserver<SearchModelMonitoringAlertsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchModelMonitoringAlertsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchModelMonitoringAlertsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchModelMonitoringAlerts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchModelMonitoringAlertsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
