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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.AccountsServiceGrpc.AccountsServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockAccountsServiceImpl extends AccountsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAccountsServiceImpl() {
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
  public void getAccount(GetAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Account) {
      requests.add(request);
      responseObserver.onNext(((Account) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAndConfigureAccount(
      CreateAndConfigureAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Account) {
      requests.add(request);
      responseObserver.onNext(((Account) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAndConfigureAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccount(DeleteAccountRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccount(
      UpdateAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Account) {
      requests.add(request);
      responseObserver.onNext(((Account) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccounts(
      ListAccountsRequest request, StreamObserver<ListAccountsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccountsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccountsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccounts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccountsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSubAccounts(
      ListSubAccountsRequest request, StreamObserver<ListSubAccountsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSubAccountsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSubAccountsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSubAccounts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSubAccountsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
