/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.asset.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.asset.v1.AssetServiceGrpc.AssetServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockAssetServiceImpl extends AssetServiceImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<Object> responses;

  public MockAssetServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void addResponse(GeneratedMessageV3 response) {
    responses.add(response);
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
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
  public void exportAssets(
      ExportAssetsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext((Operation) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchGetAssetsHistory(
      BatchGetAssetsHistoryRequest request,
      StreamObserver<BatchGetAssetsHistoryResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchGetAssetsHistoryResponse) {
      requests.add(request);
      responseObserver.onNext((BatchGetAssetsHistoryResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
