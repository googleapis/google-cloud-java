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

package com.google.cloud.confidentialcomputing.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.confidentialcomputing.v1.ConfidentialComputingGrpc.ConfidentialComputingImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockConfidentialComputingImpl extends ConfidentialComputingImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConfidentialComputingImpl() {
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
  public void createChallenge(
      CreateChallengeRequest request, StreamObserver<Challenge> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Challenge) {
      requests.add(request);
      responseObserver.onNext(((Challenge) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateChallenge, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Challenge.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void verifyAttestation(
      VerifyAttestationRequest request,
      StreamObserver<VerifyAttestationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VerifyAttestationResponse) {
      requests.add(request);
      responseObserver.onNext(((VerifyAttestationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method VerifyAttestation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VerifyAttestationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void verifyConfidentialSpace(
      VerifyConfidentialSpaceRequest request,
      StreamObserver<VerifyConfidentialSpaceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VerifyConfidentialSpaceResponse) {
      requests.add(request);
      responseObserver.onNext(((VerifyConfidentialSpaceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method VerifyConfidentialSpace, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  VerifyConfidentialSpaceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void verifyConfidentialGke(
      VerifyConfidentialGkeRequest request,
      StreamObserver<VerifyConfidentialGkeResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VerifyConfidentialGkeResponse) {
      requests.add(request);
      responseObserver.onNext(((VerifyConfidentialGkeResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method VerifyConfidentialGke, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  VerifyConfidentialGkeResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
