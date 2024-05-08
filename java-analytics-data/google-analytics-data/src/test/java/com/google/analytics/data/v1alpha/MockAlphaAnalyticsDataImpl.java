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

package com.google.analytics.data.v1alpha;

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataGrpc.AlphaAnalyticsDataImplBase;
import com.google.api.core.BetaApi;
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
public class MockAlphaAnalyticsDataImpl extends AlphaAnalyticsDataImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAlphaAnalyticsDataImpl() {
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
  public void runFunnelReport(
      RunFunnelReportRequest request, StreamObserver<RunFunnelReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunFunnelReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunFunnelReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunFunnelReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunFunnelReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAudienceList(
      CreateAudienceListRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryAudienceList(
      QueryAudienceListRequest request,
      StreamObserver<QueryAudienceListResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryAudienceListResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryAudienceListResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryAudienceListResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void sheetExportAudienceList(
      SheetExportAudienceListRequest request,
      StreamObserver<SheetExportAudienceListResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SheetExportAudienceListResponse) {
      requests.add(request);
      responseObserver.onNext(((SheetExportAudienceListResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SheetExportAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SheetExportAudienceListResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAudienceList(
      GetAudienceListRequest request, StreamObserver<AudienceList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AudienceList) {
      requests.add(request);
      responseObserver.onNext(((AudienceList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AudienceList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAudienceLists(
      ListAudienceListsRequest request,
      StreamObserver<ListAudienceListsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAudienceListsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAudienceListsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAudienceLists, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAudienceListsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRecurringAudienceList(
      CreateRecurringAudienceListRequest request,
      StreamObserver<RecurringAudienceList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RecurringAudienceList) {
      requests.add(request);
      responseObserver.onNext(((RecurringAudienceList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRecurringAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RecurringAudienceList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRecurringAudienceList(
      GetRecurringAudienceListRequest request,
      StreamObserver<RecurringAudienceList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RecurringAudienceList) {
      requests.add(request);
      responseObserver.onNext(((RecurringAudienceList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRecurringAudienceList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RecurringAudienceList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRecurringAudienceLists(
      ListRecurringAudienceListsRequest request,
      StreamObserver<ListRecurringAudienceListsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRecurringAudienceListsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRecurringAudienceListsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRecurringAudienceLists, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRecurringAudienceListsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReportTask(
      CreateReportTaskRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateReportTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryReportTask(
      QueryReportTaskRequest request, StreamObserver<QueryReportTaskResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryReportTaskResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryReportTaskResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryReportTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryReportTaskResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReportTask(
      GetReportTaskRequest request, StreamObserver<ReportTask> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportTask) {
      requests.add(request);
      responseObserver.onNext(((ReportTask) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReportTask, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportTask.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReportTasks(
      ListReportTasksRequest request, StreamObserver<ListReportTasksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReportTasksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReportTasksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReportTasks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReportTasksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
