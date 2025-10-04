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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockUserServiceImpl extends UserServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUserServiceImpl() {
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
  public void getUser(GetUserRequest request, StreamObserver<User> responseObserver) {
    Object response = responses.poll();
    if (response instanceof User) {
      requests.add(request);
      responseObserver.onNext(((User) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUser, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  User.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUser(CreateUserRequest request, StreamObserver<User> responseObserver) {
    Object response = responses.poll();
    if (response instanceof User) {
      requests.add(request);
      responseObserver.onNext(((User) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUser, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  User.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUser(DeleteUserRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUser, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUser(UpdateUserRequest request, StreamObserver<User> responseObserver) {
    Object response = responses.poll();
    if (response instanceof User) {
      requests.add(request);
      responseObserver.onNext(((User) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUser, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  User.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUsers(
      ListUsersRequest request, StreamObserver<ListUsersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUsersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUsersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUsers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUsersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
