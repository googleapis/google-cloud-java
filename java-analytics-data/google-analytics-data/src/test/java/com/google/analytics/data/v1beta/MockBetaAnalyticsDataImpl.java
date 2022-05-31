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

package com.google.analytics.data.v1beta;

import com.google.analytics.data.v1beta.BetaAnalyticsDataGrpc.BetaAnalyticsDataImplBase;
import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockBetaAnalyticsDataImpl extends BetaAnalyticsDataImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBetaAnalyticsDataImpl() {
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
  public void runReport(
      RunReportRequest request, StreamObserver<RunReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runPivotReport(
      RunPivotReportRequest request, StreamObserver<RunPivotReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunPivotReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunPivotReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunPivotReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunPivotReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchRunReports(
      BatchRunReportsRequest request, StreamObserver<BatchRunReportsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchRunReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchRunReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchRunReports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchRunReportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchRunPivotReports(
      BatchRunPivotReportsRequest request,
      StreamObserver<BatchRunPivotReportsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchRunPivotReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchRunPivotReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchRunPivotReports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchRunPivotReportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMetadata(GetMetadataRequest request, StreamObserver<Metadata> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Metadata) {
      requests.add(request);
      responseObserver.onNext(((Metadata) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMetadata, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Metadata.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runRealtimeReport(
      RunRealtimeReportRequest request,
      StreamObserver<RunRealtimeReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunRealtimeReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunRealtimeReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunRealtimeReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunRealtimeReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkCompatibility(
      CheckCompatibilityRequest request,
      StreamObserver<CheckCompatibilityResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CheckCompatibilityResponse) {
      requests.add(request);
      responseObserver.onNext(((CheckCompatibilityResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckCompatibility, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CheckCompatibilityResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
