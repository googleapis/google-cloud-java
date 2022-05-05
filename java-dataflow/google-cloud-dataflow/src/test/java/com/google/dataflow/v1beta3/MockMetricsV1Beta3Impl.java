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

package com.google.dataflow.v1beta3;

import com.google.api.core.BetaApi;
import com.google.dataflow.v1beta3.MetricsV1Beta3Grpc.MetricsV1Beta3ImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockMetricsV1Beta3Impl extends MetricsV1Beta3ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetricsV1Beta3Impl() {
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
  public void getJobMetrics(
      GetJobMetricsRequest request, StreamObserver<JobMetrics> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobMetrics) {
      requests.add(request);
      responseObserver.onNext(((JobMetrics) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetJobMetrics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobMetrics.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJobExecutionDetails(
      GetJobExecutionDetailsRequest request, StreamObserver<JobExecutionDetails> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobExecutionDetails) {
      requests.add(request);
      responseObserver.onNext(((JobExecutionDetails) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetJobExecutionDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobExecutionDetails.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStageExecutionDetails(
      GetStageExecutionDetailsRequest request,
      StreamObserver<StageExecutionDetails> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StageExecutionDetails) {
      requests.add(request);
      responseObserver.onNext(((StageExecutionDetails) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStageExecutionDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StageExecutionDetails.class.getName(),
                  Exception.class.getName())));
    }
  }
}
