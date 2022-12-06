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

package com.google.cloud.storageinsights.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.storageinsights.v1.StorageInsightsGrpc.StorageInsightsImplBase;
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
public class MockStorageInsightsImpl extends StorageInsightsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockStorageInsightsImpl() {
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
  public void listReportConfigs(
      ListReportConfigsRequest request,
      StreamObserver<ListReportConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReportConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReportConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReportConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReportConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReportConfig(
      GetReportConfigRequest request, StreamObserver<ReportConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportConfig) {
      requests.add(request);
      responseObserver.onNext(((ReportConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReportConfig(
      CreateReportConfigRequest request, StreamObserver<ReportConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportConfig) {
      requests.add(request);
      responseObserver.onNext(((ReportConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateReportConfig(
      UpdateReportConfigRequest request, StreamObserver<ReportConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportConfig) {
      requests.add(request);
      responseObserver.onNext(((ReportConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReportConfig(
      DeleteReportConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReportDetails(
      ListReportDetailsRequest request,
      StreamObserver<ListReportDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReportDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReportDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReportDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReportDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReportDetail(
      GetReportDetailRequest request, StreamObserver<ReportDetail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportDetail) {
      requests.add(request);
      responseObserver.onNext(((ReportDetail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReportDetail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportDetail.class.getName(),
                  Exception.class.getName())));
    }
  }
}
