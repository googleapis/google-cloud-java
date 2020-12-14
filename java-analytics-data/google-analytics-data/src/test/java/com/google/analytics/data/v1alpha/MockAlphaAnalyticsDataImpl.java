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

package com.google.analytics.data.v1alpha;

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataGrpc.AlphaAnalyticsDataImplBase;
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
  public void runReport(
      RunReportRequest request, StreamObserver<RunReportResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RunReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void runPivotReport(
      RunPivotReportRequest request, StreamObserver<RunPivotReportResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RunPivotReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunPivotReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchRunReports(
      BatchRunReportsRequest request, StreamObserver<BatchRunReportsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchRunReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchRunReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchRunPivotReports(
      BatchRunPivotReportsRequest request,
      StreamObserver<BatchRunPivotReportsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchRunPivotReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchRunPivotReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getMetadata(GetMetadataRequest request, StreamObserver<Metadata> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Metadata) {
      requests.add(request);
      responseObserver.onNext(((Metadata) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void runRealtimeReport(
      RunRealtimeReportRequest request,
      StreamObserver<RunRealtimeReportResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RunRealtimeReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunRealtimeReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
