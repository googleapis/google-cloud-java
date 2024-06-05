/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.shopping.merchant.accounts.v1beta.HomepageServiceGrpc.HomepageServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockHomepageServiceImpl extends HomepageServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockHomepageServiceImpl() {
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
  public void getHomepage(GetHomepageRequest request, StreamObserver<Homepage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Homepage) {
      requests.add(request);
      responseObserver.onNext(((Homepage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHomepage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Homepage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHomepage(
      UpdateHomepageRequest request, StreamObserver<Homepage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Homepage) {
      requests.add(request);
      responseObserver.onNext(((Homepage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHomepage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Homepage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void claimHomepage(
      ClaimHomepageRequest request, StreamObserver<Homepage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Homepage) {
      requests.add(request);
      responseObserver.onNext(((Homepage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ClaimHomepage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Homepage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void unclaimHomepage(
      UnclaimHomepageRequest request, StreamObserver<Homepage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Homepage) {
      requests.add(request);
      responseObserver.onNext(((Homepage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UnclaimHomepage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Homepage.class.getName(),
                  Exception.class.getName())));
    }
  }
}
