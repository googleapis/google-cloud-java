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

package com.google.cloud.websecurityscanner.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.websecurityscanner.v1.WebSecurityScannerGrpc.WebSecurityScannerImplBase;
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
public class MockWebSecurityScannerImpl extends WebSecurityScannerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWebSecurityScannerImpl() {
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
  public void createScanConfig(
      CreateScanConfigRequest request, StreamObserver<ScanConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanConfig) {
      requests.add(request);
      responseObserver.onNext(((ScanConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteScanConfig(
      DeleteScanConfigRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getScanConfig(
      GetScanConfigRequest request, StreamObserver<ScanConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanConfig) {
      requests.add(request);
      responseObserver.onNext(((ScanConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listScanConfigs(
      ListScanConfigsRequest request, StreamObserver<ListScanConfigsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListScanConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScanConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateScanConfig(
      UpdateScanConfigRequest request, StreamObserver<ScanConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanConfig) {
      requests.add(request);
      responseObserver.onNext(((ScanConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void startScanRun(StartScanRunRequest request, StreamObserver<ScanRun> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanRun) {
      requests.add(request);
      responseObserver.onNext(((ScanRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getScanRun(GetScanRunRequest request, StreamObserver<ScanRun> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanRun) {
      requests.add(request);
      responseObserver.onNext(((ScanRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listScanRuns(
      ListScanRunsRequest request, StreamObserver<ListScanRunsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListScanRunsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListScanRunsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void stopScanRun(StopScanRunRequest request, StreamObserver<ScanRun> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ScanRun) {
      requests.add(request);
      responseObserver.onNext(((ScanRun) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listCrawledUrls(
      ListCrawledUrlsRequest request, StreamObserver<ListCrawledUrlsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCrawledUrlsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCrawledUrlsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getFinding(GetFindingRequest request, StreamObserver<Finding> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Finding) {
      requests.add(request);
      responseObserver.onNext(((Finding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listFindings(
      ListFindingsRequest request, StreamObserver<ListFindingsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListFindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listFindingTypeStats(
      ListFindingTypeStatsRequest request,
      StreamObserver<ListFindingTypeStatsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListFindingTypeStatsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFindingTypeStatsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
