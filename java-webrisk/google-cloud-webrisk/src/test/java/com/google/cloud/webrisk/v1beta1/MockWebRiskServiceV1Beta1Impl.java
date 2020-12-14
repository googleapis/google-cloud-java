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

package com.google.cloud.webrisk.v1beta1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import com.google.webrisk.v1beta1.WebRiskServiceV1Beta1Grpc.WebRiskServiceV1Beta1ImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockWebRiskServiceV1Beta1Impl extends WebRiskServiceV1Beta1ImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWebRiskServiceV1Beta1Impl() {
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
  public void computeThreatListDiff(
      ComputeThreatListDiffRequest request,
      StreamObserver<ComputeThreatListDiffResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ComputeThreatListDiffResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeThreatListDiffResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void searchUris(
      SearchUrisRequest request, StreamObserver<SearchUrisResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchUrisResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchUrisResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void searchHashes(
      SearchHashesRequest request, StreamObserver<SearchHashesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchHashesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchHashesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
