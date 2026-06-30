/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4;

import com.google.api.core.BetaApi;
import com.google.devicesandservices.health.v4.DataPointsServiceGrpc.DataPointsServiceImplBase;
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
public class MockDataPointsServiceImpl extends DataPointsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataPointsServiceImpl() {
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
  public void getDataPoint(
      GetDataPointRequest request, StreamObserver<DataPoint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataPoint) {
      requests.add(request);
      responseObserver.onNext(((DataPoint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataPoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataPoint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataPoints(
      ListDataPointsRequest request, StreamObserver<ListDataPointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataPointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataPointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataPoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataPointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataPoint(
      CreateDataPointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDataPoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataPoint(
      UpdateDataPointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDataPoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteDataPoints(
      BatchDeleteDataPointsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteDataPoints, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reconcileDataPoints(
      ReconcileDataPointsRequest request,
      StreamObserver<ReconcileDataPointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReconcileDataPointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ReconcileDataPointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReconcileDataPoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReconcileDataPointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollUpDataPoints(
      RollUpDataPointsRequest request, StreamObserver<RollUpDataPointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RollUpDataPointsResponse) {
      requests.add(request);
      responseObserver.onNext(((RollUpDataPointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RollUpDataPoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RollUpDataPointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void dailyRollUpDataPoints(
      DailyRollUpDataPointsRequest request,
      StreamObserver<DailyRollUpDataPointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DailyRollUpDataPointsResponse) {
      requests.add(request);
      responseObserver.onNext(((DailyRollUpDataPointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DailyRollUpDataPoints, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DailyRollUpDataPointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportExerciseTcx(
      ExportExerciseTcxRequest request,
      StreamObserver<ExportExerciseTcxResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExportExerciseTcxResponse) {
      requests.add(request);
      responseObserver.onNext(((ExportExerciseTcxResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportExerciseTcx, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExportExerciseTcxResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
