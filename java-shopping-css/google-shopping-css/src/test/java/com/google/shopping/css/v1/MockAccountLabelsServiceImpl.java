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

package com.google.shopping.css.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.AccountLabelsServiceGrpc.AccountLabelsServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockAccountLabelsServiceImpl extends AccountLabelsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAccountLabelsServiceImpl() {
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
  public void listAccountLabels(
      ListAccountLabelsRequest request,
      StreamObserver<ListAccountLabelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccountLabelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccountLabelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccountLabels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccountLabelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAccountLabel(
      CreateAccountLabelRequest request, StreamObserver<AccountLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccountLabel) {
      requests.add(request);
      responseObserver.onNext(((AccountLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAccountLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccountLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccountLabel(
      UpdateAccountLabelRequest request, StreamObserver<AccountLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccountLabel) {
      requests.add(request);
      responseObserver.onNext(((AccountLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAccountLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccountLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccountLabel(
      DeleteAccountLabelRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAccountLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
