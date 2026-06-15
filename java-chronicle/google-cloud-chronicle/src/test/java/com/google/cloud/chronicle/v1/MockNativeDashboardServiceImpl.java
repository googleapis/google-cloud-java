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

package com.google.cloud.chronicle.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.NativeDashboardServiceGrpc.NativeDashboardServiceImplBase;
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
public class MockNativeDashboardServiceImpl extends NativeDashboardServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockNativeDashboardServiceImpl() {
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
  public void createNativeDashboard(
      CreateNativeDashboardRequest request, StreamObserver<NativeDashboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NativeDashboard) {
      requests.add(request);
      responseObserver.onNext(((NativeDashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateNativeDashboard, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  NativeDashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNativeDashboard(
      GetNativeDashboardRequest request, StreamObserver<NativeDashboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NativeDashboard) {
      requests.add(request);
      responseObserver.onNext(((NativeDashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNativeDashboard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NativeDashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNativeDashboards(
      ListNativeDashboardsRequest request,
      StreamObserver<ListNativeDashboardsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNativeDashboardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNativeDashboardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNativeDashboards, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNativeDashboardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNativeDashboard(
      UpdateNativeDashboardRequest request, StreamObserver<NativeDashboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NativeDashboard) {
      requests.add(request);
      responseObserver.onNext(((NativeDashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateNativeDashboard, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  NativeDashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void duplicateNativeDashboard(
      DuplicateNativeDashboardRequest request, StreamObserver<NativeDashboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NativeDashboard) {
      requests.add(request);
      responseObserver.onNext(((NativeDashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DuplicateNativeDashboard, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NativeDashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNativeDashboard(
      DeleteNativeDashboardRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNativeDashboard, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addChart(AddChartRequest request, StreamObserver<AddChartResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddChartResponse) {
      requests.add(request);
      responseObserver.onNext(((AddChartResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddChart, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddChartResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeChart(
      RemoveChartRequest request, StreamObserver<NativeDashboard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NativeDashboard) {
      requests.add(request);
      responseObserver.onNext(((NativeDashboard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveChart, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NativeDashboard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void editChart(
      EditChartRequest request, StreamObserver<EditChartResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EditChartResponse) {
      requests.add(request);
      responseObserver.onNext(((EditChartResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EditChart, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EditChartResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void duplicateChart(
      DuplicateChartRequest request, StreamObserver<DuplicateChartResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DuplicateChartResponse) {
      requests.add(request);
      responseObserver.onNext(((DuplicateChartResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DuplicateChart, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DuplicateChartResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportNativeDashboards(
      ExportNativeDashboardsRequest request,
      StreamObserver<ExportNativeDashboardsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExportNativeDashboardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ExportNativeDashboardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportNativeDashboards, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExportNativeDashboardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importNativeDashboards(
      ImportNativeDashboardsRequest request,
      StreamObserver<ImportNativeDashboardsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportNativeDashboardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ImportNativeDashboardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportNativeDashboards, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportNativeDashboardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
