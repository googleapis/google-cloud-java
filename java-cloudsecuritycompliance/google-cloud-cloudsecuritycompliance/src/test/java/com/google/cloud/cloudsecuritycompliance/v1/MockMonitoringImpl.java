/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.cloudsecuritycompliance.v1.MonitoringGrpc.MonitoringImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockMonitoringImpl extends MonitoringImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMonitoringImpl() {
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
  public void listFrameworkComplianceSummaries(
      ListFrameworkComplianceSummariesRequest request,
      StreamObserver<ListFrameworkComplianceSummariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFrameworkComplianceSummariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFrameworkComplianceSummariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFrameworkComplianceSummaries,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFrameworkComplianceSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFindingSummaries(
      ListFindingSummariesRequest request,
      StreamObserver<ListFindingSummariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFindingSummariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFindingSummariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFindingSummaries, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFindingSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchFrameworkComplianceReport(
      FetchFrameworkComplianceReportRequest request,
      StreamObserver<FrameworkComplianceReport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FrameworkComplianceReport) {
      requests.add(request);
      responseObserver.onNext(((FrameworkComplianceReport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchFrameworkComplianceReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FrameworkComplianceReport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listControlComplianceSummaries(
      ListControlComplianceSummariesRequest request,
      StreamObserver<ListControlComplianceSummariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListControlComplianceSummariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListControlComplianceSummariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListControlComplianceSummaries,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListControlComplianceSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void aggregateFrameworkComplianceReport(
      AggregateFrameworkComplianceReportRequest request,
      StreamObserver<AggregateFrameworkComplianceReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AggregateFrameworkComplianceReportResponse) {
      requests.add(request);
      responseObserver.onNext(((AggregateFrameworkComplianceReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AggregateFrameworkComplianceReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AggregateFrameworkComplianceReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
