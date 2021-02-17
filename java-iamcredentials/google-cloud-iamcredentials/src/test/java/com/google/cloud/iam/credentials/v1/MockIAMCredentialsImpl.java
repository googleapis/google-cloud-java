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

package com.google.cloud.iam.credentials.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.iam.credentials.v1.IAMCredentialsGrpc.IAMCredentialsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockIAMCredentialsImpl extends IAMCredentialsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIAMCredentialsImpl() {
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
  public void generateAccessToken(
      GenerateAccessTokenRequest request,
      StreamObserver<GenerateAccessTokenResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof GenerateAccessTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateAccessTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAccessToken, expected %s or %s",
                  response.getClass().getName(),
                  GenerateAccessTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateIdToken(
      GenerateIdTokenRequest request, StreamObserver<GenerateIdTokenResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof GenerateIdTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateIdTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateIdToken, expected %s or %s",
                  response.getClass().getName(),
                  GenerateIdTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void signBlob(SignBlobRequest request, StreamObserver<SignBlobResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SignBlobResponse) {
      requests.add(request);
      responseObserver.onNext(((SignBlobResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SignBlob, expected %s or %s",
                  response.getClass().getName(),
                  SignBlobResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void signJwt(SignJwtRequest request, StreamObserver<SignJwtResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SignJwtResponse) {
      requests.add(request);
      responseObserver.onNext(((SignJwtResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SignJwt, expected %s or %s",
                  response.getClass().getName(),
                  SignJwtResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
