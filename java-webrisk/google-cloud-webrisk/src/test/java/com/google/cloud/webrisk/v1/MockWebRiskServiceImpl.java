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

package com.google.cloud.webrisk.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.WebRiskServiceGrpc.WebRiskServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockWebRiskServiceImpl extends WebRiskServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWebRiskServiceImpl() {
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeThreatListDiff, expected %s or %s",
                  response.getClass().getName(),
                  ComputeThreatListDiffResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchUris, expected %s or %s",
                  response.getClass().getName(),
                  SearchUrisResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchHashes, expected %s or %s",
                  response.getClass().getName(),
                  SearchHashesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSubmission(
      CreateSubmissionRequest request, StreamObserver<Submission> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Submission) {
      requests.add(request);
      responseObserver.onNext(((Submission) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSubmission, expected %s or %s",
                  response.getClass().getName(),
                  Submission.class.getName(),
                  Exception.class.getName())));
    }
  }
}
