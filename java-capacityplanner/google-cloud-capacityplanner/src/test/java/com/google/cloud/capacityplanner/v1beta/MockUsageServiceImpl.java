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

package com.google.cloud.capacityplanner.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.capacityplanner.v1beta.UsageServiceGrpc.UsageServiceImplBase;
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
public class MockUsageServiceImpl extends UsageServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUsageServiceImpl() {
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
  public void queryUsageHistories(
      QueryUsageHistoriesRequest request,
      StreamObserver<QueryUsageHistoriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryUsageHistoriesResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryUsageHistoriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryUsageHistories, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryUsageHistoriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryForecasts(
      QueryForecastsRequest request, StreamObserver<QueryForecastsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryForecastsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryForecastsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryForecasts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryForecastsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryReservations(
      QueryReservationsRequest request,
      StreamObserver<QueryReservationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryReservationsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryReservationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryReservations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryReservationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportUsageHistories(
      ExportUsageHistoriesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportUsageHistories, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportForecasts(
      ExportForecastsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportForecasts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportReservationsUsage(
      ExportReservationsUsageRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportReservationsUsage, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
