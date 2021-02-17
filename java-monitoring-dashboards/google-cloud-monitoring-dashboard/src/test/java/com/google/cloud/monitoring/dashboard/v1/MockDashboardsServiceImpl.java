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

package com.google.cloud.monitoring.dashboard.v1;

import com.google.api.core.BetaApi;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DashboardsServiceGrpc.DashboardsServiceImplBase;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
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
public class MockDashboardsServiceImpl extends DashboardsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDashboardsServiceImpl() {
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
  public void createDashboard(
      CreateDashboardRequest request, StreamObserver<Dashboard> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dashboard) {
      requests.add(request);
      responseObserver.onNext(((Dashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDashboard, expected %s or %s",
                  response.getClass().getName(),
                  Dashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDashboards(
      ListDashboardsRequest request, StreamObserver<ListDashboardsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDashboardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDashboardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDashboards, expected %s or %s",
                  response.getClass().getName(),
                  ListDashboardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDashboard(
      GetDashboardRequest request, StreamObserver<Dashboard> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dashboard) {
      requests.add(request);
      responseObserver.onNext(((Dashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDashboard, expected %s or %s",
                  response.getClass().getName(),
                  Dashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDashboard(
      DeleteDashboardRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDashboard, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDashboard(
      UpdateDashboardRequest request, StreamObserver<Dashboard> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dashboard) {
      requests.add(request);
      responseObserver.onNext(((Dashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDashboard, expected %s or %s",
                  response.getClass().getName(),
                  Dashboard.class.getName(),
                  Exception.class.getName())));
    }
  }
}
