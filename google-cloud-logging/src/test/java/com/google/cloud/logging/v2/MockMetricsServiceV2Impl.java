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

package com.google.cloud.logging.v2;

import com.google.api.core.BetaApi;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.MetricsServiceV2Grpc.MetricsServiceV2ImplBase;
import com.google.logging.v2.UpdateLogMetricRequest;
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
public class MockMetricsServiceV2Impl extends MetricsServiceV2ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetricsServiceV2Impl() {
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
  public void listLogMetrics(
      ListLogMetricsRequest request, StreamObserver<ListLogMetricsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLogMetricsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLogMetricsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLogMetrics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLogMetricsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLogMetric(
      GetLogMetricRequest request, StreamObserver<LogMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LogMetric) {
      requests.add(request);
      responseObserver.onNext(((LogMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLogMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LogMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLogMetric(
      CreateLogMetricRequest request, StreamObserver<LogMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LogMetric) {
      requests.add(request);
      responseObserver.onNext(((LogMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateLogMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LogMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLogMetric(
      UpdateLogMetricRequest request, StreamObserver<LogMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LogMetric) {
      requests.add(request);
      responseObserver.onNext(((LogMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateLogMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LogMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLogMetric(
      DeleteLogMetricRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLogMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
